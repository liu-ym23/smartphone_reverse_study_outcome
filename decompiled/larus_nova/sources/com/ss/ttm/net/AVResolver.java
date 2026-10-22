package com.ss.ttm.net;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ttm.player.AVThreadPool;
import java.net.InetAddress;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class AVResolver {
    public static int HOST_MAX_CACHE_TIME = 600000;
    private static final int MAX_CACHED = 128;
    private static final String TAG = "AVResolver";
    private static final Hashtable<String, HostInfo> mCacheHosts = null;
    private String mError;
    private HostInfo mHostInfo;
    private String mHostName;
    private String[] mIPStr;
    private boolean mRet;
    private Thread mThread;

    public static class HostInfo {

        /* JADX INFO: renamed from: ip, reason: collision with root package name */
        public String f457030ip;
        public long time;

        public HostInfo() {
        }
    }

    public static class ParserHost implements Runnable {
        String mHostName;
        AVResolver mResolver;

        public void com_ss_ttm_net_AVResolver$ParserHost__run$___twin___() {
            String r100 = null;
            InetAddress r101 = InetAddress.getByName(this.mHostName);     // Catch: Throwable -> L8
            r100 = r101.getHostAddress();     // Catch: Throwable -> L6
        L11:
            AVResolver.access$102(this.mResolver, true);
            if (r101 == null) goto L21;
            if (r100 == null) goto L22;
            AVResolver.access$202(this.mResolver, new String[1]);
            AVResolver.access$200(this.mResolver)[0] = r100;
            HostInfo r102 = new HostInfo();
            r102.time = System.currentTimeMillis();
            r102.f457030ip = r100;
            AVResolver.putHostInfo(this.mHostName, r102);
            r102.time = System.currentTimeMillis();
            return;
        L22:
            return;
        L21:
            return;
        L6:
            th = th;
        L10:
            th.printStackTrace();
            AVResolver.access$002(this.mResolver, th.getMessage());
        L8:
            th = th;
            r101 = null;
            goto L10
        }

        @Override // java.lang.Runnable
        public void run() {
            com_ss_ttm_net_AVResolver$ParserHost_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_ttm_net_AVResolver$ParserHost_com_larus_apm_impl_protector_RunnableLancet_run(ParserHost r100) {
            r100.com_ss_ttm_net_AVResolver$ParserHost__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public ParserHost(AVResolver r100, String r101) {
            this.mResolver = r100;
            this.mHostName = r101;
        }
    }

    static {
        mCacheHosts = new Hashtable();
    }

    public void freeAddress() {
        Thread r100 = this.mThread;
        if (r100 == null) goto L11;
        r100.interrupt();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public String getAddress() {
        if (this.mRet == false) goto L11;
        String[] r100 = this.mIPStr;
        if (r100 == null) goto L11;
        String r101 = r100[0];
        if (r101 == null) goto L11;
        return r101;
    L11:
        return "parser host name: " + this.mHostName + " error.err msg:" + this.mError;
    }

    public int isSuccess() {
        if (this.mRet == false) goto L12;
        String[] r100 = this.mIPStr;
        if (r100 != null) goto L7;
        return -1;
    L7:
        if (r100[0] == null) goto L13;
        return 1;
    L13:
        return -1;
    L12:
        return 0;
    }

    public AVResolver() {
        this.mRet = false;
        this.mThread = null;
        this.mError = null;
    }

    public static /* synthetic */ String[] access$200(AVResolver r100) {
        return r100.mIPStr;
    }

    public static final boolean isIP(String r100) {
        if (r100.length() < 7) goto L13;
        if (r100.length() > 15) goto L13;
        return PatternProtector.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(r100).find();
    L9:
        e = move-exception;
        e.printStackTrace();
        return false;
    L13:
        if (r100.charAt(0) == '[') goto L15;
    L17:
        return false;
    L15:
        if (r100.charAt(r100.length() - 1) != ']') goto L17;
        return true;
    }

    public void getAddressInfo(String r110) {
        this.mHostName = r110;
        if (TextUtils.isEmpty(r110) == false) goto L7;
        this.mRet = true;
        return;
    L7:
        if (isIP(this.mHostName) == false) goto L10;
        this.mIPStr = new String[]{this.mHostName};
        this.mRet = true;
        return;
    L10:
        Hashtable<String, HostInfo> r100 = mCacheHosts;
        HostInfo r101 = r100.get(r110);
        this.mHostInfo = r101;
        if (r101 != null) goto L13;
    L24:
        AVThreadPool.addTask(new ParserHost(this, this.mHostName));     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        this.mRet = true;
        this.mError = e.getMessage();
        return;
    L13:
        if (r101.f457030ip == null) goto L18;
        long r102 = System.currentTimeMillis();
        HostInfo r103 = this.mHostInfo;
        if ((r102 - r103.time) >= HOST_MAX_CACHE_TIME) goto L18;
        this.mIPStr = new String[]{r103.f457030ip};
        this.mRet = true;
        return;
    L18:
        r100.remove(r110);
        this.mHostInfo = null;
        goto L24
    }

    public static /* synthetic */ String access$002(AVResolver r100, String r101) {
        r100.mError = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$102(AVResolver r100, boolean r101) {
        r100.mRet = r101;
        return r101;
    }

    public static /* synthetic */ String[] access$202(AVResolver r100, String[] r101) {
        r100.mIPStr = r101;
        return r101;
    }

    public static synchronized void putHostInfo(String r110, HostInfo r111) {
        monitor-enter(AVResolver.class);
        long r100 = System.currentTimeMillis();     // Catch: Throwable -> L26
        Hashtable<String, HostInfo> r101 = mCacheHosts;     // Catch: Exception -> L21 Throwable -> L26
        Object r102 = null;
        if (r101.size() <= 128) goto L16;
        Iterator<Map.Entry<String, HostInfo>> r103 = r101.entrySet().iterator();     // Catch: Exception -> L21 Throwable -> L26
        Object r104 = null;
    L9:
        if (r103.hasNext() == false) goto L15;
        HostInfo r105 = r103.next().getValue();     // Catch: Exception -> L21 Throwable -> L26
        r102 = (String) r103.next().getKey();     // Catch: Exception -> L21 Throwable -> L26
        if (r105 == null) goto L9;
        long r106 = r105.time;     // Catch: Exception -> L21 Throwable -> L26
        if (r106 >= r100) goto L9;
        r104 = r105;
        r100 = r106;
        goto L9
    L15:
        Object r107 = r102;
        r102 = r104;
    L17:
        if (r102 == null) goto L23;
        if (r107 == null) goto L23;
        mCacheHosts.remove(r107);     // Catch: Exception -> L21 Throwable -> L26
    L23:
        mCacheHosts.put(r110, r111);     // Catch: Throwable -> L26
        monitor-exit(AVResolver.class);
        return;
    L16:
        r107 = null;
    L21:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }
}
