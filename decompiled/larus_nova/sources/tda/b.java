package tda;

import com.bytedance.keva.Keva;
import com.ss.ttvideoengine.model.BarrageMaskInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f545532a = null;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f545533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f545534b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f545535c;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f545533a, r101.f545533a) == true) goto L12;
            return false;
        L12:
            if (this.f545534b == r101.f545534b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f545535c, r101.f545535c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f545533a.hashCode() * 31;
            long r101 = this.f545534b;
            return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f545535c.hashCode();
        }

        public final String toString() {
            return "Snapshot(token=" + this.f545533a + ", updatedAtMs=" + this.f545534b + ", userId=" + this.f545535c + ')';
        }

        public /* synthetic */ a(int r100) {
            this("", 0, "");
        }

        public a(String r100, long r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "token");
            Intrinsics.checkNotNullParameter(r102, "userId");
            this.f545533a = r100;
            this.f545534b = r101;
            this.f545535c = r102;
        }
    }

    static {
        f545532a = LazyKt.lazy(new tda.a());
    }

    @JvmStatic
    public static final a a() {
        String r100 = ((Keva) f545532a.getValue()).getString("x_tt_token", "");
        Intrinsics.checkNotNull(r100);
        int r101 = 0;
        if ((!StringsKt.isBlank(r100)) == false) goto L17;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L6
        JSONObject r103 = new JSONObject(r100);     // Catch: Throwable -> L6
        Object r104 = Result.m9449constructorimpl(new a(r103.optString("token", ""), r103.optLong(BarrageMaskInfo.KEY_MASK_UPDATED_AT, 0), r103.optString("user_id", "")));     // Catch: Throwable -> L6
    L8:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L11;
        r105.getMessage();
    L11:
        a r106 = new a(r101);
        if (Result.m9455isFailureimpl(r104) == false) goto L15;
        r104 = r106;
    L15:
        return (a) r104;
    L6:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    L17:
        return new a(r101);
    }

    @JvmStatic
    public static final void b(String r100, String r101) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        boolean r102 = false;
        if (r100.length() != 0) goto L10;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
    L20:
        ((Keva) f545532a.getValue()).storeString("x_tt_token", "");
        return;
    L14:
        if (r101.length() != 0) goto L16;
        r102 = true;
    L16:
        if (r102 == true) goto L20;
        long r104 = System.currentTimeMillis();
        JSONObject r105 = new JSONObject();
        r105.put("token", r100);
        r105.put(BarrageMaskInfo.KEY_MASK_UPDATED_AT, r104);
        r105.put("user_id", r101);
        String r106 = r105.toString();
        ((Keva) f545532a.getValue()).storeString("x_tt_token", r106);
        return;
    L10:
        r103 = false;
        goto L12
    }
}
