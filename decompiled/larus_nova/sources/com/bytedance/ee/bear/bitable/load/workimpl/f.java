package com.bytedance.ee.bear.bitable.load.workimpl;

import com.bytedance.ee.bear.bitable.BitableDocumentPluginHost;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.bear.bitable.infoarch.BitableInfoArchPlugin;
import com.bytedance.ee.bear.bitable.load.AbsLoadWork;
import com.bytedance.ee.bear.bitable.load.dataloader.NetResourceLoader;
import com.bytedance.ee.bear.bitable.preload.BitablePreloadConfig;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class f extends AbsLoadWork implements cu4.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<String, String> f214574f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f214575g;

    public static final class a {
    }

    static {
    }

    @Override // cu4.b
    public final boolean a() {
        zt4.f r100 = (zt4.f) this.f214440a.e(zt4.f.class);
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L21;
        BitableResourceData r102 = r100.f573591f;
        if (r102 == null) goto L12;
        String r103 = r102.getResValue();
    L13:
        if (r103 != null) goto L15;
    L18:
        boolean r104 = true;
    L19:
        if (r104 == true) goto L21;
        return true;
    L15:
        if (r103.length() == 0) goto L18;
        r104 = false;
        goto L19
    L12:
        r103 = null;
    L21:
        return false;
    L5:
        if (r100.f573590e != true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.bitable.load.AbsLoadWork
    public final void d() {
        this.f214440a.A("BITABLE_NATIVE_GET_CACHE_START", System.currentTimeMillis());
        this.f214440a.h("not_render_nativeview_cache_reason", "default");
        zt4.h r100 = (zt4.h) this.f214440a.e(zt4.h.class);
        zt4.f r101 = (zt4.f) this.f214440a.e(zt4.f.class);
        if (r100 == null) goto L14;
        if (r101 == null) goto L14;
        zr4.a r102 = r100.f573597g;
        if (r102 == null) goto L10;
        String r103 = r102.f573421i;
        if (r103 == null) goto L10;
    L11:
        o(r103);
        if (a() == true) goto L16;
        o("mainPageCacheNotExist");
    L16:
        if (a() == false) goto L20;
        tt5.a.h("RenderNativeViewWork", "registerCacheNativeView");
        BitableInfoArchPlugin r104 = (BitableInfoArchPlugin) this.f214440a.getPluginHost().findPlugin(BitableInfoArchPlugin.class);
        if (r104 == null) goto L23;
        r104.registerLifeCyclerListener(new h(this));
    L23:
        this.f214441b.m();
        m();
        return;
    L20:
        tt5.a.h("RenderNativeViewWork", "registerNetNativeView");
        NetResourceLoader r105 = (NetResourceLoader) this.f214440a.e(NetResourceLoader.class);
        if (r105 == null) goto L23;
        r105.l(NetResourceLoader.ResourceType.MainPage, new i(this));
    L10:
        r103 = "";
    L14:
        o("loaderNotExist");
        goto L16
    }

    public final void o(String r100) {
        if (Intrinsics.areEqual(this.f214575g, "default") == false) goto L10;
        if (r100.length() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
    L11:
        this.f214575g = r100;
        this.f214440a.h("not_render_nativeview_cache_reason", r100);
        return;
    L7:
        r101 = false;
    L10:
        if (Intrinsics.areEqual(r100, "success") == true) goto L11;
    }

    public f(com.bytedance.ee.bear.bitable.load.e r100, com.bytedance.ee.bear.bitable.load.f r101) {
        Intrinsics.checkNotNullParameter(r100, "loadContext");
        Intrinsics.checkNotNullParameter(r101, "loadControl");
        super(r100, r101);
        BitablePreloadConfig.Companion.getClass();
        this.f214574f = BitablePreloadConfig.a.a().getBaseRenderKeyToBridgeName();
        this.f214575g = "default";
    }

    public static final void n(f r110, BitableResourceData r111) {
        r110.getClass();
        tt5.a.h("RenderNativeViewWork", "renderNativeView");
        if (r111 != null) goto L37;
        String r112 = null;
    L10:
        if (r112 != null) goto L12;
    L15:
        boolean r100 = true;
    L16:
        if (r100 == true) goto L30;
        r110.f214440a.A("BITABLE_NATIVE_CALL_NATIVE_RENDER", System.currentTimeMillis());     // Catch: Throwable -> L5 Exception -> L7
        tt5.a.h("RenderNativeViewWork", "dispatch main page cache.");     // Catch: Throwable -> L5 Exception -> L7
        JSONObject r101 = new JSONObject(r112);     // Catch: Throwable -> L5 Exception -> L7
        Iterator<String> r113 = r101.keys();     // Catch: Throwable -> L5 Exception -> L7
    L19:
        if (r113.hasNext() == false) goto L26;
        String r102 = r113.next();     // Catch: Throwable -> L5 Exception -> L7
        String r103 = r110.f214574f.get(r102);     // Catch: Throwable -> L5 Exception -> L7
        if (r103 != null) goto L23;
        r103 = r102;
    L23:
        String r104 = r101.optString(r102);     // Catch: Throwable -> L5 Exception -> L7
        com.bytedance.ee.bear.bitable.load.e r105 = r110.f214440a;     // Catch: Throwable -> L5 Exception -> L7
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L5 Exception -> L7
        Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L5 Exception -> L7
        DocumentPluginHost r106 = r105.getPluginHost();     // Catch: Throwable -> L5 Exception -> L7
        if ((r106 instanceof BitableDocumentPluginHost) == false) goto L19;
        ((BitableDocumentPluginHost) r106).d(r103, r104, new g());     // Catch: Throwable -> L5 Exception -> L7
        goto L19
    L26:
        NativeAddRecordCacheRenderPlugin r114 = (NativeAddRecordCacheRenderPlugin) r110.f214440a.getPluginHost().findPlugin(NativeAddRecordCacheRenderPlugin.class);     // Catch: Throwable -> L5 Exception -> L7
        if (r114 == null) goto L29;
        r114.onRenderMainViewCache();     // Catch: Throwable -> L5 Exception -> L7
    L29:
        r110.o("success");     // Catch: Throwable -> L5 Exception -> L7
    L33:
        r110.f214440a.h("is_native_cache_render", Boolean.valueOf(Intrinsics.areEqual(r110.f214575g, "success")));
        r110.f214440a.t("hit cacheNativeView", Boolean.valueOf(Intrinsics.areEqual(r110.f214575g, "success")));
        return;
    L30:
        r110.o("mainPageCacheNotExist");     // Catch: Throwable -> L5 Exception -> L7
        goto L33
    L12:
        if (r112.length() == 0) goto L15;
        r100 = false;
        goto L16
    L37:
        r112 = r111.getResValue();     // Catch: Throwable -> L5 Exception -> L7
    L7:
        e = move-exception;
        r110.o("nativeCardException");     // Catch: Throwable -> L5
        tt5.a.e("RenderNativeViewWork", "native render error : ", e, false);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        r110.f214440a.h("is_native_cache_render", Boolean.valueOf(Intrinsics.areEqual(r110.f214575g, "success")));
        r110.f214440a.t("hit cacheNativeView", Boolean.valueOf(Intrinsics.areEqual(r110.f214575g, "success")));
        throw th;
    }
}
