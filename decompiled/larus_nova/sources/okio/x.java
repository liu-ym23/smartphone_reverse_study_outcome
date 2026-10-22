package okio;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class x extends w {
    @Override // okio.w
    public final String toString() {
        return "NioSystemFileSystem";
    }

    public x() {
    }

    public static Long g(FileTime r100) {
        Long r101 = Long.valueOf(r100.toMillis());
        if (r101.longValue() == 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L10;
        return null;
    L10:
        return r101;
    L5:
        r102 = false;
        goto L6
    }

    @Override // okio.w, okio.l
    public final k d(b0 r110) {
        Intrinsics.checkNotNullParameter(r110, "path");
        Path r111 = Paths.get(r110.toString(), new String[0]);
        Intrinsics.checkNotNullParameter(r111, "nioPath");
        Long r100 = null;
        BasicFileAttributes r101 = Files.readAttributes(r111, BasicFileAttributes.class, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});     // Catch: Throwable -> L25
        if (r101.isSymbolicLink() == false) goto L7;
        Path r112 = Files.readSymbolicLink(r111);
    L8:
        boolean r102 = r101.isRegularFile();
        boolean r103 = r101.isDirectory();
        if (r112 == null) goto L11;
        String r104 = b0.f523973b;
        Intrinsics.checkNotNullParameter(r112, "<this>");
        b0 r105 = b0.a.a(r112.toString(), false);
    L12:
        Long r106 = Long.valueOf(r101.size());
        FileTime r113 = r101.creationTime();
        if (r113 == null) goto L15;
        Long r107 = g(r113);
    L16:
        FileTime r114 = r101.lastModifiedTime();
        if (r114 == null) goto L19;
        Long r108 = g(r114);
    L20:
        FileTime r115 = r101.lastAccessTime();
        if (r115 == null) goto L24;
        r100 = g(r115);
    L24:
        return new k(r102, r103, r105, r106, r107, r108, r100);
    L19:
        r108 = null;
        goto L20
    L15:
        r107 = null;
        goto L16
    L11:
        r105 = null;
        goto L12
    L7:
        r112 = null;
    L28:
        return null;
    }
}
