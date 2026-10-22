package hda;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f484737a;

    /* JADX WARN: Multi-variable type inference failed */
    public final String d() {
        JSONObject r100 = this.f484737a.optJSONObject("sourceInfo");
        if (r100 == null) goto L6;
        String r101 = p0.b(r100, "appName");
        if (r101 == null) goto L6;
        return r101;
    L6:
        String r102 = p0.b(this.f484737a, "sourceAppName");
        if (r102 != null) goto L51;
        JSONArray r103 = this.f484737a.optJSONArray("appNames");
        boolean r104 = true;
        Object r105 = null;
        if (r103 == null) goto L23;
        String r106 = r103.optString(0);
        if (r106 == null) goto L23;
        if ((!StringsKt.isBlank(r106)) == true) goto L15;
    L17:
        boolean r107 = false;
    L18:
        if (r107 == true) goto L21;
        r106 = null;
    L21:
        if (r106 == null) goto L23;
        return r106;
    L15:
        if (Intrinsics.areEqual(r106, "null") == true) goto L17;
        r107 = true;
    L23:
        String r108 = p0.b(this.f484737a, "appNames");
        if (r108 == null) goto L47;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L37
        String r110 = new JSONArray(r108).optString(0);     // Catch: Throwable -> L37
        Intrinsics.checkNotNull(r110);     // Catch: Throwable -> L37
        if ((!StringsKt.isBlank(r110)) == true) goto L29;
    L31:
        r104 = false;
    L32:
        if (r104 == true) goto L35;
        r110 = null;
    L35:
        Object r111 = Result.m9449constructorimpl(r110);     // Catch: Throwable -> L37
    L40:
        if (Result.m9455isFailureimpl(r111) == true) goto L43;
        r105 = r111;
    L43:
        r105 = (String) r105;
        if (r105 != null) goto L47;
        return r108;
    L29:
        if (Intrinsics.areEqual(r110, "null") == true) goto L31;
    L37:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L47:
        return r105;
    L51:
        return r102;
    }

    public o0(q0 r100) {
        Intrinsics.checkNotNullParameter(r100, "record");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(new JSONObject(r100.f484744e));     // Catch: Throwable -> L5
    L8:
        if (Result.m9452exceptionOrNullimpl(r102) == null) goto L11;
        r102 = new JSONObject();
    L11:
        this.f484737a = (JSONObject) r102;
        return;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final JSONArray a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f484737a.optJSONArray(r100);
    }

    public final Long b(String... r100) {
        Intrinsics.checkNotNullParameter(r100, "keys");
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L14;
        String r103 = r100[r102];
        if (this.f484737a.has(r103) == false) goto L13;
        if (this.f484737a.isNull(r103) == true) goto L13;
        Long r104 = StringsKt.toLongOrNull(this.f484737a.optString(r103));
        if (r104 == null) goto L13;
        return Long.valueOf(r104.longValue());
    L13:
        r102 = r102 + 1;
        goto L3
    L14:
        return null;
    }

    public final String c(String... r100) {
        Intrinsics.checkNotNullParameter(r100, "keys");
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        String r103 = r100[r102];
        String r104 = p0.b(this.f484737a, r103);
        if (r104 != null) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }
}
