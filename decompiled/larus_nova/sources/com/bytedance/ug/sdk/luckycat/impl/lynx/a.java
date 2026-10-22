package com.bytedance.ug.sdk.luckycat.impl.lynx;

import android.net.Uri;
import android.os.Message;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ug.sdk.luckycat.impl.browser.webview.PageInfo;
import com.bytedance.ug.sdk.luckycat.impl.manager.LuckyCatSettingsManger;
import com.bytedance.ug.sdk.luckycat.impl.model.ContainerType;
import com.bytedance.ug.sdk.luckycat.impl.model.PageLoadReason;
import com.bytedance.ug.sdk.luckycat.impl.model.SchemaUIConfig;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements c, com.bytedance.ug.sdk.luckycat.utils.j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f271213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f271214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f271215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SchemaUIConfig f271216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, Object> f271217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C3801a f271218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f271219g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FragmentActivity f271220h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f271221i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final bk7.c f271222j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final JSONObject f271223k;

    /* JADX INFO: renamed from: com.bytedance.ug.sdk.luckycat.impl.lynx.a$a, reason: collision with other inner class name */
    public final class C3801a extends ij7.i {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ a f271224h;

        public C3801a(a r100, String r101) {
            this.f271224h = r100;
            super(r101);
        }

        @Override // ij7.i
        public final void h(boolean r100, int r101, String r102) {
            super.h(r100, r101, r102);
            b r103 = this.f271224h.f271219g;
            if (r103 == null) goto L5;
            r103.a(r100, r101);
        L5:
            this.f271224h.f271219g = null;
        }
    }

    @Override // com.bytedance.ug.sdk.luckycat.impl.lynx.c
    public final boolean IC() {
        return false;
    }

    @Override // com.bytedance.ug.sdk.luckycat.impl.lynx.c
    public final vi7.c Qw() {
        return null;
    }

    @Override // com.bytedance.ug.sdk.luckycat.utils.j.a
    public final void handleMsg(Message r100) {
    }

    public final FragmentActivity getActivity() {
        return this.f271220h;
    }

    @Override // com.bytedance.ug.sdk.luckycat.impl.lynx.c
    public final String getContainerID() {
        return this.f271214b;
    }

    @Override // com.bytedance.ug.sdk.luckycat.impl.lynx.c
    public final String getCurrentUrl() {
        return this.f271215c;
    }

    @Override // com.bytedance.ug.sdk.luckycat.impl.lynx.c
    public final void Zf(CloseType r100) {
        c r101 = this.f271213a;
        if (r101 == null) goto L5;
        r101.Zf(r100);
    L5:
        bk7.c r102 = this.f271222j;
        if (r102 == null) goto L9;
        r102.onClose(r100.getValue());
        return;
    }

    public final void a(PageLoadReason r100) {
        String r101 = zi7.b.f572264b.x(this.f271215c, false);
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L12:
        this.f271218f.i(this.f271215c, r100);
        bk7.c r102 = this.f271222j;
        if (r102 == null) goto L15;
        r102.b();
    L15:
        xi7.a r103 = (xi7.a) hn7.d.b(xi7.a.class);
        String r104 = null;
        if (r103 == null) goto L18;
        r103.i();
    L18:
        FragmentActivity r105 = this.f271220h;
        LinkedHashMap r106 = new LinkedHashMap();
        ck7.a r107 = (ck7.a) hn7.d.b(ck7.a.class);
        if (r107 == null) goto L21;
        r106.putAll(r107.B());
    L21:
        LinkedHashMap r108 = new LinkedHashMap();
        String r109 = this.f271221i;
        if (r109 == null) goto L24;
        StringsKt.isBlank(r109);
    L24:
        Uri r110 = UriProtector.parse(this.f271221i);
        Set<String> r111 = UriProtector.getQueryParameterNames(r110);
        if (r111 == null) goto L38;
        Iterator<T> r112 = r111.iterator();
    L28:
        if (r112.hasNext() == false) goto L38;
        String r113 = (String) r112.next();
        if (r113 != null) goto L32;
    L35:
        boolean r114 = true;
    L36:
        if (r114 == true) goto L28;
        r108.put(r113, UriProtector.getQueryParameter(r110, r113));
        goto L28
    L32:
        if (StringsKt.isBlank(r113) == true) goto L35;
        r114 = false;
    L38:
        String r115 = this.f271215c;
        if (r115 == null) goto L41;
        StringsKt.isBlank(r115);
    L41:
        Uri r116 = UriProtector.parse(this.f271215c);
        Set<String> r117 = UriProtector.getQueryParameterNames(r116);
        if (r117 == null) goto L55;
        Iterator<T> r118 = r117.iterator();
    L45:
        if (r118.hasNext() == false) goto L55;
        String r119 = (String) r118.next();
        if (r119 != null) goto L49;
    L52:
        boolean r120 = true;
    L53:
        if (r120 == true) goto L45;
        r108.put(r119, UriProtector.getQueryParameter(r116, r119));
        goto L45
    L49:
        if (StringsKt.isBlank(r119) == true) goto L52;
        r120 = false;
    L55:
        r106.put("queryItems", r108);
        r106.putAll(k.f271239b.b(r105));
        xi7.a r121 = (xi7.a) hn7.d.b(xi7.a.class);
        if (r121 == null) goto L58;
        JSONObject r122 = r121.i();
    L59:
        if (r122 == null) goto L65;
        Iterator<String> r123 = r122.keys();
        if (r123 == null) goto L65;
    L63:
        if (r123.hasNext() == false) goto L65;
        String r124 = r123.next();
        r106.put(r124, r122.opt(r124));
    L65:
        r106.put("containerID", this.f271214b);
        this.f271217e = r106;
        String r125 = this.f271215c;
        if (r125 != null) goto L68;
        return;
    L68:
        if ((!StringsKt.isBlank(r125)) == false) goto L70;
        r104 = r125;
    L70:
        if (r104 == null) goto L99;
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L73
        Object r127 = Result.m9449constructorimpl(Boolean.valueOf(UriProtector.parse(this.f271221i).getBooleanQueryParameter("disable_prefetch", false)));     // Catch: Throwable -> L73
    L75:
        Boolean r128 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r127) == false) goto L79;
        r127 = r128;
    L79:
        if (((Boolean) r127).booleanValue() == true) goto L83;
        yi7.a r129 = (yi7.a) hn7.d.b(yi7.a.class);
        if (r129 == null) goto L100;
        r129.Q();
        return;
    L100:
        return;
    L83:
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatLynxFragment", "disable prefetch. schema = " + this.f271221i);
        return;
    L73:
        th = move-exception;
        Result.Companion r130 = Result.Companion;
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L75
    L99:
        return;
    L58:
        r122 = null;
        goto L59
    L5:
        if ((!Intrinsics.areEqual(this.f271215c, r101)) == false) goto L12;
        this.f271215c = r101;
        C3801a r131 = this.f271218f;
        if (r131 == null) goto L12;
        PageInfo r132 = r131.f490107c;
        if (r132 == null) goto L12;
        r132.f271118b = r101;
        goto L12
    }

    public a(FragmentActivity r100, String r110, bk7.c r111, JSONObject r112) {
        this.f271220h = r100;
        this.f271221i = r110;
        this.f271222j = r111;
        this.f271223k = r112;
        Map<String, WeakReference<c>> r113 = LuckyCatContainerIDManager.f271169a;
        this.f271214b = UUID.randomUUID().toString();
        String r114 = "";
        this.f271215c = "";
        this.f271217e = new LinkedHashMap();
        C3801a r101 = new C3801a(this, this.f271214b);
        this.f271218f = r101;
        String r115 = com.bytedance.ug.sdk.luckycat.utils.i.d(r110);
        if (r115 == null) goto L5;
        r114 = r115;
    L5:
        this.f271215c = r114;
        SchemaUIConfig r116 = SchemaUIConfig.createConfig(r110);
        this.f271216d = r116;
        LuckyCatSettingsManger r117 = LuckyCatSettingsManger.b.f271283a;
        r117.getClass();
        Object r118 = r117.c(new String[]{"common", "enable_lynx_popup_prelaod"});
        if ((r118 instanceof Boolean) == false) goto L8;
        boolean r119 = ((Boolean) r118).booleanValue();
    L10:
        if (r119 == true) goto L13;
        if (r116 == null) goto L13;
        r116.setPreloadPopup(false);
    L13:
        ContainerType r120 = ContainerType.LYNX_POPUP;
        r101.f490108d = false;
        r101.f490109e = r120;
        if (com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.s() == false) goto L26;
        vi7.c r102 = k.f271239b.c(r100, this, new l(this), null, r101, r110);
        if (r102 == null) goto L19;
        r102.c();
    L19:
        if (r116 != null) goto L21;
        return;
    L21:
        if (r116.isPreloadPopup() != true) goto L25;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("luckycat_lynx_popup", "pre load popup");
        a(PageLoadReason.NEW_PAGE);
        return;
    L25:
        return;
    L26:
        return;
    L8:
        r119 = true;
        goto L10
    }
}
