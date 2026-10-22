package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0007"}, d2 = {"walk", "Lkotlin/io/FileTreeWalk;", "Ljava/io/File;", "direction", "Lkotlin/io/FileWalkDirection;", "walkBottomUp", "walkTopDown", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/FilesKt")
class FilesKt__FileTreeWalkKt extends FilesKt__FileReadWriteKt {
    public FilesKt__FileTreeWalkKt() {
    }

    public static FileTreeWalk walkBottomUp(File r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return walk(r100, FileWalkDirection.BOTTOM_UP);
    }

    public static FileTreeWalk walkTopDown(File r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return walk(r100, FileWalkDirection.TOP_DOWN);
    }

    public static final FileTreeWalk walk(File r100, FileWalkDirection r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "direction");
        return new FileTreeWalk(r100, r101);
    }

    public static /* synthetic */ FileTreeWalk walk$default(File r100, FileWalkDirection r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = FileWalkDirection.TOP_DOWN;
    L6:
        return walk(r100, r101);
    }
}
