package com.bytedance.ug.sdk.luckycat.impl.popup;

import android.text.TextUtils;
import com.amap.api.col.s.ce;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.forest.model.n;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR,\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR,\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001f¨\u0006&"}, d2 = {"Lcom/bytedance/ug/sdk/luckycat/impl/popup/a;", "", "", "enablePreloadByRouter", "Z", "f", "()Z", "setEnablePreloadByRouter", "(Z)V", "enablePreloadByTask", ce.f26391f, "setEnablePreloadByTask", "enablePrefetchByRouter", "d", "setEnablePrefetchByRouter", "enablePrefetchByTask", "e", "setEnablePrefetchByTask", "enableForestPreloadFeedReady", "getEnableForestPreloadFeedReady", "setEnableForestPreloadFeedReady", "enableForestPreloadSettingsReady", "c", "setEnableForestPreloadSettingsReady", "", "Lcom/bytedance/ug/sdk/luckycat/impl/popup/f;", "luckyPreloadConfigList", "Ljava/util/List;", "h", "()Ljava/util/List;", "setLuckyPreloadConfigList", "(Ljava/util/List;)V", "", "luckyPrefetchConfig", "getLuckyPrefetchConfig", "setLuckyPrefetchConfig", "<init>", "()V", "luckycat_container_release"}, k = 1, mv = {1, 4, 0})
public final class a {

    @SerializedName("enable_forest_preload_feed_ready")
    private boolean enableForestPreloadFeedReady;

    @SerializedName("enable_forest_preload_app_settings_update")
    private boolean enableForestPreloadSettingsReady;

    @SerializedName("enable_prefetch_by_router")
    private boolean enablePrefetchByRouter;

    @SerializedName("enable_prefetch_by_taskpage")
    private boolean enablePrefetchByTask;

    @SerializedName("enable_forest_preload_by_router")
    private boolean enablePreloadByRouter;

    @SerializedName("enable_forest_preload_by_taskpage")
    private boolean enablePreloadByTask;

    @SerializedName("prefetch_config")
    private List<String> luckyPrefetchConfig;

    @SerializedName("preload_config")
    private List<f> luckyPreloadConfigList;

    public a() {
    }

    public final boolean c() {
        return this.enableForestPreloadSettingsReady;
    }

    public final boolean d() {
        return this.enablePrefetchByRouter;
    }

    public final boolean e() {
        return this.enablePrefetchByTask;
    }

    public final boolean f() {
        return this.enablePreloadByRouter;
    }

    public final boolean g() {
        return this.enablePreloadByTask;
    }

    public final List<f> h() {
        return this.luckyPreloadConfigList;
    }

    public final boolean a(String r100) {
        if (CollectionUtils.isEmpty(this.luckyPrefetchConfig) == false) goto L5;
        return false;
    L5:
        List<String> r101 = this.luckyPrefetchConfig;
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.contains(r100) != true) goto L12;
        return true;
    L12:
        return false;
    }

    public final boolean b(String r100) {
        List<f> r101 = this.luckyPreloadConfigList;
        if (r101 == null) goto L41;
        Iterator<T> r102 = r101.iterator();
        boolean r103 = false;
    L6:
        if (r102.hasNext() == false) goto L32;
        f r104 = (f) r102.next();
        if (r104 == null) goto L6;
        g r105 = r104.d();
        String r106 = null;
        if (r105 == null) goto L12;
        String r107 = r105.b();
    L14:
        if (TextUtils.isEmpty(r107) == true) goto L19;
        g r108 = r104.d();
        if (r108 == null) goto L18;
        r106 = r108.b();
    L18:
        String r109 = UriProtector.parse(r106).getPath();
    L21:
        if (TextUtils.equals(r109, r100) == false) goto L6;
        if (Intrinsics.areEqual(r104.f(), "common") == false) goto L25;
    L28:
        r103 = true;
    L29:
        if (r103 == false) goto L6;
        return true;
    L25:
        if (Intrinsics.areEqual(r104.f(), "all") == true) goto L28;
        r103 = false;
        goto L29
    L19:
        r109 = "";
        goto L21
    L12:
        r107 = null;
        goto L14
    L32:
        return r103;
    L41:
        return false;
    }

    public final n i(String r100) {
        List<f> r101 = this.luckyPreloadConfigList;
        if (r101 == null) goto L25;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L25;
        f r103 = (f) r102.next();
        if (r103 == null) goto L6;
        g r104 = r103.d();
        if (r104 == null) goto L12;
        String r105 = r104.b();
    L14:
        if (TextUtils.isEmpty(r105) == true) goto L20;
        g r106 = r103.d();
        if (r106 == null) goto L18;
        String r107 = r106.b();
    L19:
        String r108 = UriProtector.parse(r107).getPath();
    L22:
        if (TextUtils.equals(r108, r100) == false) goto L6;
        r103.a();
        return r103.f271421a;
    L18:
        r107 = null;
        goto L19
    L20:
        r108 = "";
        goto L22
    L12:
        r105 = null;
    L25:
        return null;
    }
}
