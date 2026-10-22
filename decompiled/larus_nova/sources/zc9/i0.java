package zc9;

import com.larus.im.bean.message.block.MusicCreationContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class i0 {
    public static final String a(MusicCreationContent r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.isBlock() == false) goto L8;
        String r101 = r100.getUniqueTaskId();
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L8:
        return r100.getPlayList().getItemId();
    }
}
