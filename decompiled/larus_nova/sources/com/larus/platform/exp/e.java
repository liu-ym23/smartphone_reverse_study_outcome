package com.larus.platform.exp;

import com.bytedance.keva.Keva;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f365377a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f365378b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Boolean> f365379c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f365380d = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f365381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f365382b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f365381a == r101.f365381a) goto L12;
            return false;
        L12:
            if (this.f365382b == r101.f365382b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f365381a == false) goto L5;
            int r100 = 1231;
        L6:
            long r101 = this.f365382b;
            return (r100 * 31) + ((int) (r101 ^ (r101 >>> 32)));
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "Record(opened=" + this.f365381a + ", updateTimestampMs=" + this.f365382b + ')';
        }

        public a(boolean r100, long r101) {
            this.f365381a = r100;
            this.f365382b = r101;
        }
    }

    public e() {
    }

    static {
        f365377a = new e();
        f365378b = new Object();
        f365379c = new LinkedHashMap();
        f365380d = LazyKt.lazy(new d());
    }

    public static boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "doubaoUid");
        String r101 = StringsKt.trim(r100).toString();
        boolean r102 = false;
        if (r101.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        FLogger.f375446a.e("DoubaoIMFeatureStore", "freezeSnapshot normalizedUid is empty");
        return false;
    L9:
        Object r104 = f365378b;
        monitor-enter(r104);
        LinkedHashMap r105 = (LinkedHashMap) f365379c;     // Catch: Throwable -> L20
        Object r106 = r105.get(r101);     // Catch: Throwable -> L20
        if (r106 != null) goto L17;
        f365377a.getClass();     // Catch: Throwable -> L20
        a r107 = b(r101);     // Catch: Throwable -> L20
        if (r107 == null) goto L16;
        r102 = r107.f365381a;     // Catch: Throwable -> L20
    L16:
        r106 = Boolean.valueOf(r102);     // Catch: Throwable -> L20
        r105.put(r101, r106);     // Catch: Throwable -> L20
    L17:
        boolean r108 = ((Boolean) r106).booleanValue();     // Catch: Throwable -> L20
        monitor-exit(r104);
        return r108;
    L20:
        th = move-exception;
        throw th;
    L5:
        r103 = false;
        goto L6
    }

    public static a b(String r100) {
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L17
        String r103 = ((Keva) f365380d.getValue()).getString("doubao_im_feature_opened::" + r100, null);     // Catch: Throwable -> L17
        if (r103 == null) goto L14;
        JSONObject r104 = new JSONObject(r103);     // Catch: Throwable -> L17
        if (Intrinsics.areEqual(r104.optString("doubao_uid"), r100) == false) goto L14;
        if ((r104.opt("im_feature_opened") instanceof Boolean) == false) goto L14;
        if ((r104.opt("update_timestamp_ms") instanceof Number) == false) goto L14;
        a r105 = new a(r104.optBoolean("im_feature_opened"), r104.optLong("update_timestamp_ms"));     // Catch: Throwable -> L17
    L15:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L17
    L19:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L23;
        FLogger.f375446a.e("DoubaoIMFeatureStore", "read persisted IM feature value failed", r107);
    L23:
        if (Result.m9455isFailureimpl(r106) == true) goto L27;
        r101 = r106;
    L27:
        return (a) r101;
    L14:
        r105 = null;
    L17:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    }
}
