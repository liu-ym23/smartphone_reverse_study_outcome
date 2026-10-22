package kotlin.io.path;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlin/io/path/PathRelativizer;", "", "()V", "emptyPath", "Ljava/nio/file/Path;", "kotlin.jvm.PlatformType", "parentPath", "tryRelativeTo", "path", "base", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class PathRelativizer {
    public static final PathRelativizer INSTANCE = null;
    private static final Path emptyPath = null;
    private static final Path parentPath = null;

    private PathRelativizer() {
    }

    static {
        INSTANCE = new PathRelativizer();
        emptyPath = Paths.get("", new String[0]);
        parentPath = Paths.get(DownloadConstants.VULNERABILITY_PATH, new String[0]);
    }

    public final Path tryRelativeTo(Path r100, Path r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "base");
        Path r102 = r101.normalize();
        Path r103 = r100.normalize();
        Path r104 = r102.relativize(r103);
        int r105 = Math.min(r102.getNameCount(), r103.getNameCount());
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L12;
        Path r107 = r102.getName(r106);
        Path r108 = parentPath;
        if (Intrinsics.areEqual(r107, r108) == false) goto L12;
        if (Intrinsics.areEqual(r103.getName(r106), r108) == false) goto L10;
        r106 = r106 + 1;
        goto L3
    L10:
        throw new IllegalArgumentException("Unable to compute relative path");
    L12:
        if (Intrinsics.areEqual(r103, r102) == false) goto L14;
    L16:
        String r109 = r104.toString();
        if (StringsKt.endsWith$default(r109, r104.getFileSystem().getSeparator(), false, 2, null) == false) goto L19;
        r103 = r104.getFileSystem().getPath(StringsKt.dropLast(r109, r104.getFileSystem().getSeparator().length()), new String[0]);
    L20:
        Intrinsics.checkNotNull(r103);
        return r103;
    L19:
        r103 = r104;
        goto L20
    L14:
        if (Intrinsics.areEqual(r102, emptyPath) == false) goto L16;
        goto L16
    }
}
