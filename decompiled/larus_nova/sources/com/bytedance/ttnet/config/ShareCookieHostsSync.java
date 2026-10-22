package com.bytedance.ttnet.config;

import com.alipay.sdk.m.u.i;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.ttnet.utils.TtnetUtil;
import java.net.CookieHandler;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ShareCookieHostsSync {
    private static final String TAG = "ShareCookieHostsSync";
    private static volatile ShareCookieHostsSync mInstance;

    public ShareCookieHostsSync() {
    }

    public static ShareCookieHostsSync inst() {
        if (mInstance != null) goto L15;
        monitor-enter(ShareCookieHostsSync.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new ShareCookieHostsSync();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ShareCookieHostsSync.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    private List<String> parseCookieHostListFromString(String r100) {
        ArrayList r101 = new ArrayList();
        if (StringUtils.isEmpty(r100) == false) goto L5;
        return r101;
    L5:
        String[] r102 = r100.split(",");
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L11;
        String r105 = r102[r104];
        if (StringUtils.isEmpty(r105) == true) goto L10;
        r101.add(r105.trim());
    L10:
        r104 = r104 + 1;
        goto L6
    L11:
        return r101;
    }

    private List<String> splitWebkitCookieStringToCookieList(List<String> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<String> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        String[] r103 = r102.next().split(i.f25853b);
        int r104 = r103.length;
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L4;
        String r106 = r103[r105];
        if (StringUtils.isEmpty(r106) == true) goto L10;
        r101.add(r106.trim());
    L10:
        r105 = r105 + 1;
        goto L6
    L11:
        return r101;
    }

    private void doSyncShareCookies(String r110, String r111) {
        CookieHandler r100 = CookieHandler.getDefault();
        if (r100 != null) goto L6;
        Logger.e(TAG, "Default CookieHandler is null.");
        return;
    L6:
        List<String> r112 = parseCookieHostListFromString(r110);
        List<String> r113 = parseCookieHostListFromString(r111);
        ArrayList r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        Iterator<String> r114 = r113.iterator();
    L8:
        if (r114.hasNext() == false) goto L20;
        String r103 = r114.next();
        if (TtnetUtil.inCookieHostList(r103, r112) == true) goto L12;
        if (Logger.debug() == false) goto L18;
        Logger.d(TAG, "added hosts add: " + r103);
    L18:
        r102.add(r103);
        goto L8
    L12:
        if (Logger.debug() == false) goto L14;
        Logger.d(TAG, "kept hosts add: " + r103);
    L14:
        r101.add(r103);
        goto L8
    L20:
        if (r102.isEmpty() == false) goto L23;
        return;
    L23:
        if (r101.isEmpty() == false) goto L26;
        r101 = r102;
    L26:
        Map<String, List<String>> r115 = new HashMap();
        Iterator r116 = r101.iterator();
    L28:
        if (r116.hasNext() == false) goto L38;
        String r104 = (String) r116.next();
        r115 = r100.get(new URI("https://" + r104 + HTTP.URL_DEFAULT), null);     // Catch: Throwable -> L36
        if (r115.size() <= 0) goto L28;
        if (Logger.debug() == false) goto L38;
        Logger.d(TAG, "Sync cookie from host: " + r104 + " sync cookies: " + r115.toString());     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        th.printStackTrace();
    L38:
        if (r115 != null) goto L40;
        return;
    L40:
        if (r115.isEmpty() == true) goto L94;
        List<String> r117 = r115.get("Cookie");
        if (r117 != null) goto L45;
    L46:
        r117 = r115.get(BaseHttpRequestInfo.KEY_COOKIE);
        if (r117 != null) goto L49;
        return;
    L49:
        if (r117.isEmpty() == true) goto L95;
    L51:
        LinkedHashMap r118 = new LinkedHashMap();
        List<String> r119 = splitWebkitCookieStringToCookieList(r117);
        Iterator r105 = r102.iterator();
    L53:
        if (r105.hasNext() == false) goto L96;
        String r106 = (String) r105.next();
        ArrayList r107 = new ArrayList();
        URI r108 = new URI("https://" + r106 + HTTP.URL_DEFAULT);     // Catch: Throwable -> L63
        Iterator<String> r109 = r119.iterator();     // Catch: Throwable -> L63
    L57:
        if (r109.hasNext() == false) goto L61;
        String r120 = r109.next();     // Catch: Throwable -> L63
        if (StringUtils.isEmpty(r120) == true) goto L57;
        r107.add(r120 + "; Domain=" + r106);     // Catch: Throwable -> L63
        goto L57
    L61:
        r118.put("Set-Cookie", r107);     // Catch: Throwable -> L63
        r100.put(r108, r118);     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        th.printStackTrace();
        goto L53
    L96:
        return;
    L95:
        return;
    L45:
        if (r117.isEmpty() == false) goto L51;
    }

    public void onShareCookieHostsChanged(final String r100, final String r101) {
        if (r101.equals(r100) == false) goto L5;
        return;
    L5:
        final String r102 = "Sync-Cookie";
        new AnonymousClass1(this, r102, r100, r101).start();
    }

    public static /* synthetic */ void access$000(ShareCookieHostsSync r100, String r101, String r102) {
        r100.doSyncShareCookies(r101, r102);
    }
}
