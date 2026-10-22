package com.bytedance.kmp.ec.yata.common.biz.callback;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class YataRequestEventParams {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f251361i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f251362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f251363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f251364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f251365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f251366e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f251367f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f251368g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f251369h;

    public static final class a {
        public static YataRequestEventParams a(com.bytedance.kmp.ec.yata.event.common.e r100) {
            Intrinsics.checkNotNullParameter(r100, "input");
            Map<String, Object> r101 = r100.q();
            Map r102 = null;
            if (r101 == null) goto L5;
            Object r103 = r101.get("api");
        L7:
            if ((r103 instanceof String) == false) goto L9;
            String r104 = (String) r103;
        L10:
            if (r101 == null) goto L12;
            Object r105 = r101.get("header");
        L14:
            if ((r105 instanceof Map) == false) goto L16;
            Map r106 = (Map) r105;
        L17:
            if (r106 != null) goto L19;
        L22:
            boolean r107 = true;
        L23:
            if (r107 == false) goto L31;
            if (r101 == null) goto L26;
            Object r108 = r101.get("headers");
        L28:
            if ((r108 instanceof Map) == false) goto L30;
            r106 = (Map) r108;
            goto L31
        L30:
            Map r109 = null;
        L32:
            if (r101 == null) goto L34;
            Object r110 = r101.get("config");
        L36:
            if ((r110 instanceof Map) == false) goto L38;
            Map r111 = (Map) r110;
        L39:
            if (r101 == null) goto L41;
            Object r112 = r101.get("query");
        L43:
            if ((r112 instanceof Map) == false) goto L45;
            Map r113 = (Map) r112;
        L46:
            if (r101 == null) goto L48;
            Object r114 = r101.get(ContainerPosition.BODY);
        L50:
            if ((r114 instanceof Map) == false) goto L53;
            r102 = (Map) r114;
        L53:
            return new YataRequestEventParams(r104, r109, r111, r113, r102);
        L48:
            r114 = null;
            goto L50
        L45:
            r113 = null;
            goto L46
        L41:
            r112 = null;
            goto L43
        L38:
            r111 = null;
            goto L39
        L34:
            r110 = null;
            goto L36
        L26:
            r108 = null;
        L31:
            r109 = r106;
            goto L32
        L19:
            if (r106.isEmpty() == true) goto L22;
            r107 = false;
            goto L23
        L16:
            r106 = null;
            goto L17
        L12:
            r105 = null;
            goto L14
        L9:
            r104 = null;
            goto L10
        L5:
            r103 = null;
            goto L7
        }
    }

    static {
    }

    public YataRequestEventParams() {
        this(null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof YataRequestEventParams) == true) goto L8;
        return false;
    L8:
        YataRequestEventParams r101 = (YataRequestEventParams) r100;
        if (Intrinsics.areEqual(this.f251362a, r101.f251362a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f251363b, r101.f251363b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f251364c, r101.f251364c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f251365d, r101.f251365d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f251366e, r101.f251366e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f251362a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.f251363b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.f251364c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, Object> r110 = this.f251365d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, Object> r113 = this.f251366e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "YataRequestEventParams(api=" + this.f251362a + ", originHeaders=" + this.f251363b + ", config=" + this.f251364c + ", queryMap=" + this.f251365d + ", bodyMap=" + this.f251366e + ')';
    }

    public YataRequestEventParams(String r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102, Map<String, ? extends Object> r103, Map<String, ? extends Object> r104) {
        this.f251362a = r100;
        this.f251363b = r101;
        this.f251364c = r102;
        this.f251365d = r103;
        this.f251366e = r104;
        this.f251367f = LazyKt.lazy(new YataRequestEventParams$headers$2(this));
        this.f251368g = LazyKt.lazy(new YataRequestEventParams$contentType$2(this));
        this.f251369h = LazyKt.lazy(new YataRequestEventParams$isUsePost$2(this));
    }
}
