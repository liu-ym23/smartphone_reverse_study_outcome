package com.obric.assistant;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f389188a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f389189b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f389190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f389191b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f389190a, r101.f389190a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f389191b, r101.f389191b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f389190a.hashCode() * 31) + this.f389191b.hashCode();
        }

        public final String toString() {
            return "Model(displayModel=" + this.f389190a + ", model=" + this.f389191b + ')';
        }

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "displayModel");
            Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
            this.f389190a = r100;
            this.f389191b = r101;
        }
    }

    public e() {
    }

    static {
        f389188a = new e();
        f389189b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new d());
    }

    public static a a(String r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        Object r103 = null;
        if (r102 == false) goto L50;
        return null;
    L50:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L42
        JsonObject r105 = (JsonObject) ((Gson) f389189b.getValue()).fromJson(r100, JsonObject.class);     // Catch: Throwable -> L42
        JsonElement r106 = r105.get("display_model");     // Catch: Throwable -> L42
        if (r106 == null) goto L16;
        String r107 = r106.getAsString();     // Catch: Throwable -> L42
    L17:
        String r108 = "";
        if (r107 != null) goto L20;
        r107 = "";
    L20:
        JsonElement r109 = r105.get(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);     // Catch: Throwable -> L42
        if (r109 == null) goto L23;
        String r110 = r109.getAsString();     // Catch: Throwable -> L42
    L24:
        if (r110 == null) goto L28;
        r108 = r110;
    L28:
        if (r107.length() != 0) goto L30;
        boolean r111 = true;
    L31:
        if (r111 == false) goto L33;
    L39:
        a r112 = null;
    L40:
        Object r113 = Result.m9449constructorimpl(r112);     // Catch: Throwable -> L42
    L45:
        if (Result.m9455isFailureimpl(r113) == true) goto L49;
        r103 = r113;
    L49:
        return (a) r103;
    L33:
        if (r108.length() == 0) goto L36;
        r101 = false;
    L36:
        if (r101 == true) goto L39;
        r112 = new a(r107, r108);     // Catch: Throwable -> L42
        goto L40
    L30:
        r111 = false;
        goto L31
    L23:
        r110 = null;
        goto L24
    L16:
        r107 = null;
    L42:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L45
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static String b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "displayModel");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        return GsonProtectorUtils.toJson((Gson) f389189b.getValue(), MapsKt.mapOf(new Pair[]{TuplesKt.to("display_model", r100), TuplesKt.to(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, r101)}));
    }
}
