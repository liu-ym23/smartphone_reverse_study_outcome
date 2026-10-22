package dtb;

import com.larksuite.framework.utils.a0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.Notice;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class c {
    public static final int a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "tag");
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        Log.w(r101, "sid is invalid");
        int r103 = a0.a(0);
    L12:
        Log.i(r101, "sid is -> " + r100 + "  notificationId is -> " + r103);
        return r103;
    L11:
        r103 = r100.hashCode();
        goto L12
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Integer] */
    public static final int b(Notice r100, String r101) {
        if (r101 != 0) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        r101 = Integer.valueOf(a0.a(0));
    L11:
        if (r100 != null) goto L13;
    L15:
        boolean r103 = false;
    L16:
        if (r103 == false) goto L22;
        ?? r104 = new Object[2];
        String r105 = r100.extra.f433072p;
        if (r105 != null) goto L20;
        r105 = "";
    L20:
        r104[0] = r105;
        r104[1] = r101;
        return Objects.hash(r104);
    L22:
        return Objects.hash(new Object[]{r101});
    L13:
        if (r100.isFromBackgroundUser != true) goto L15;
        r103 = true;
        goto L16
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r102 = false;
        goto L9
    }
}
