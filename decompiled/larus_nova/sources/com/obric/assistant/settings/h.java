package com.obric.assistant.settings;

import com.bytedance.keva.Keva;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.t1;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f392071a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f392072b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f392073c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f392074d = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f392075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f392076b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f392077c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f392075a == r101.f392075a) goto L12;
            return false;
        L12:
            if (this.f392076b == r101.f392076b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f392077c, r101.f392077c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f392075a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f392076b == true) goto L11;
            r100 = 1237;
        L11:
            return ((r102 + r100) * 31) + this.f392077c.hashCode();
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "EntryEnabledState(enabled=" + this.f392075a + ", resolved=" + this.f392076b + ", source=" + this.f392077c + ')';
        }

        public a(boolean r100, boolean r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, "source");
            this.f392075a = r100;
            this.f392076b = r101;
            this.f392077c = r102;
        }
    }

    public static final class b implements com.obric.assistant.m {
        public b() {
        }

        @Override // com.obric.assistant.m
        public final void a(String r100) {
            if (r100 != null) goto L4;
        L7:
            h.f392071a.getClass();
            com.larus.utils.t0.a(new g());
            return;
        L4:
            if (Intrinsics.areEqual(r100, "obric_feature_cocreation_review_support") == true) goto L7;
            if (StringsKt.contains$default(r100, "obric_feature_cocreation_review_support", false, 2, null) == true) goto L7;
        }
    }

    public h() {
    }

    static {
        f392071a = new h();
        f392072b = new AtomicBoolean(false);
        f392073c = LazyKt.lazy(new f());
        f392074d = new b();
    }

    public static a a() {
        if (f392072b.compareAndSet(false, true) == false) goto L6;
        t1.f393353a.B0(f392074d);
    L6:
        JsonObject r100 = t1.f393353a.getObricCloudConfig("obric_feature_cocreation_review_support");
        Object r101 = null;
        if (r100 == null) goto L19;
        JsonElement r102 = r100.get("obric_feature_cocreation_review_support");
        if (r102 == null) goto L19;
        if (r102.isJsonObject() == true) goto L14;
        r102 = null;
    L14:
        if (r102 == null) goto L16;
        JsonObject r103 = r102.getAsJsonObject();
    L17:
        if (r103 == null) goto L19;
        r100 = r103;
        goto L19
    L16:
        r103 = null;
    L19:
        if (r100 == null) goto L35;
        JsonElement r104 = r100.get("enable");
        if (r104 == null) goto L35;
        if (r104.isJsonPrimitive() == true) goto L26;
        r104 = null;
    L26:
        if (r104 == null) goto L35;
        JsonPrimitive r105 = r104.getAsJsonPrimitive();
        if (r105 == null) goto L35;
        if (r105.isBoolean() == true) goto L33;
        r105 = null;
    L33:
        if (r105 == null) goto L35;
        Boolean r106 = Boolean.valueOf(r105.getAsBoolean());
    L37:
        if (r106 == null) goto L83;
        boolean r107 = r106.booleanValue();
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L41
        ((Keva) f392073c.getValue()).storeBoolean("cached_enabled", r107);     // Catch: Throwable -> L41
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L41
    L43:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L46;
        FLogger.f375446a.w("CocreationReviewEntryGate", "updateCachedEnabled failed: " + r110.getMessage(), r110);
    L46:
        FLogger.f375446a.d("CocreationReviewEntryGate", "isEnabled: enabled=" + r106 + ", resolved=true, source=config, config=" + r100);
        return new a(r106.booleanValue(), true, "config");
    L41:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L43
    L83:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L54
        Lazy r113 = f392073c;     // Catch: Throwable -> L54
        if (((Keva) r113.getValue()).contains("cached_enabled") == true) goto L51;
        Boolean r114 = null;
    L52:
        Object r115 = Result.m9449constructorimpl(r114);     // Catch: Throwable -> L54
    L56:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);
        if (r116 == null) goto L60;
        FLogger.f375446a.w("CocreationReviewEntryGate", "readCachedEnabled failed: " + r116.getMessage(), r116);
    L60:
        if (Result.m9455isFailureimpl(r115) == true) goto L63;
        r101 = r115;
    L63:
        Boolean r117 = (Boolean) r101;
        String r118 = "null";
        if (r117 == null) goto L73;
        FLogger r119 = FLogger.f375446a;
        StringBuilder r120 = new StringBuilder("isEnabled: enabled=");
        r120.append(r117);
        r120.append(", resolved=true, source=keva, config=");
        if (r100 == null) goto L71;
        String r121 = r100.toString();
        if (r121 == null) goto L71;
        r118 = r121;
    L71:
        r120.append(r118);
        r119.i("CocreationReviewEntryGate", r120.toString());
        return new a(r117.booleanValue(), true, "keva");
    L73:
        FLogger r122 = FLogger.f375446a;
        if (r100 == null) goto L79;
        String r123 = r100.toString();
        if (r123 == null) goto L79;
        r118 = r123;
    L79:
        r122.i("CocreationReviewEntryGate", "isEnabled: enabled=false, resolved=false, source=unknown, config=".concat(r118));
        return new a(false, false, "unknown");
    L51:
        r114 = Boolean.valueOf(((Keva) r113.getValue()).getBoolean("cached_enabled", false));     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L35:
        r106 = null;
        goto L37
    }
}
