package wm4;

import com.ss.android.lark.utils.FileType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class c {
    public static final int a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "fileName");
        FileType r101 = FileType.getFileTypeBySuffix("." + StringsKt.substringAfterLast(r100, '.', ""));
        if (r101 != null) goto L6;
        r101 = FileType.TYPE_UNKNOWN;
    L6:
        return r101.getResId(3);
    }
}
