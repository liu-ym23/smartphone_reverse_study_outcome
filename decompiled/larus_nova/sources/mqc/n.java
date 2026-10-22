package mqc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.volcengine.zeus.log.ZeusLogger;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f514959a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f514960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f514961b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f514960a, r101.f514960a) == true) goto L8;
            return false;
        L8:
            if (this.f514961b == r101.f514961b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f514960a;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L7:
            return (r101 * 31) + this.f514961b;
        L5:
            r101 = 0;
            goto L7
        }

        public final String toString() {
            return "AssetsPluginFileNameInfo(pkgName=" + this.f514960a + ", versionCode=" + this.f514961b + ")";
        }

        public a(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "pkgName");
            this.f514960a = r100;
            this.f514961b = r101;
        }
    }

    public n() {
    }

    static {
        f514959a = new n();
    }

    public static a a(String r110) {
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        Object r101 = null;
        if (r100 == false) goto L12;
        return null;
    L12:
        List r102 = StringsKt.split$default(r110, new String[]{"_"}, false, 0, 6, null);
        if (r102.size() >= 2) goto L29;
        ZeusLogger.w("PluginFileNameHelper", "extractAssetsPluginFileNameInfo: pluginFileName " + r110 + " is invalid");
        return null;
    L29:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L18
        Object r112 = Result.m9449constructorimpl(new a((String) ListProtector.get(r102, 0), CastIntegerProtector.parseInt((String) ListProtector.get(r102, 1))));     // Catch: Throwable -> L18
    L20:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r112);
        if (r103 == null) goto L24;
        ZeusLogger.w("PluginFileNameHelper", "extractAssetsPluginFileNameInfo failed: " + r103.getMessage(), r103);
    L24:
        if (Result.m9455isFailureimpl(r112) == true) goto L28;
        r101 = r112;
    L28:
        return (a) r101;
    L18:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    L5:
        if (r110.length() == 0) goto L8;
        r100 = false;
        goto L9
    }
}
