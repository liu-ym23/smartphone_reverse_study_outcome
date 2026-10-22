package mqc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.volcengine.zeus.log.ZeusLogger;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class n {
    public static final n a = null;

    public static final class a {
        public final String a;
        public final int b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L7:
            return (r1 * 31) + this.b;
        L5:
            r1 = 0;
            goto L7
        }

        public final String toString() {
            return "AssetsPluginFileNameInfo(pkgName=" + this.a + ", versionCode=" + this.b + ")";
        }

        public a(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "pkgName");
            this.a = r2;
            this.b = r3;
        }
    }

    public n() {
    }

    static {
        a = new n();
    }

    public static a a(String r10) {
        if (r10 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        Object r3 = null;
        if (r2 == false) goto L12;
        return null;
    L12:
        List r4 = StringsKt.split$default(r10, new String[]{"_"}, false, 0, 6, null);
        if (r4.size() >= 2) goto L29;
        ZeusLogger.w("PluginFileNameHelper", "extractAssetsPluginFileNameInfo: pluginFileName " + r10 + " is invalid");
        return null;
    L29:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L18
        Object r12 = Result.m49constructorimpl(new a((String) ListProtector.get(r4, 0), CastIntegerProtector.parseInt((String) ListProtector.get(r4, 1))));     // Catch: Throwable -> L18
    L20:
        Throwable r0 = Result.m52exceptionOrNullimpl(r12);
        if (r0 == null) goto L24;
        ZeusLogger.w("PluginFileNameHelper", "extractAssetsPluginFileNameInfo failed: " + r0.getMessage(), r0);
    L24:
        if (Result.m55isFailureimpl(r12) == true) goto L28;
        r3 = r12;
    L28:
        return (a) r3;
    L18:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r12 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L20
    L5:
        if (r10.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
