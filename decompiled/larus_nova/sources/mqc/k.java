package mqc;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/* JADX INFO: loaded from: classes41.dex */
public final class k extends SimpleFileVisitor<Path> {
    public k() {
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public final FileVisitResult postVisitDirectory(Object r100, IOException r101) throws IOException {
        Path r102 = (Path) r100;
        if (r102 == null) goto L6;
        Files.deleteIfExists(r102);     // Catch: IOException -> L7
    L6:
        return FileVisitResult.CONTINUE;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public final FileVisitResult preVisitDirectory(Object r100, BasicFileAttributes r101) throws IOException {
        Path r102 = (Path) r100;
        return FileVisitResult.CONTINUE;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public final FileVisitResult visitFile(Object r100, BasicFileAttributes r101) throws IOException {
        Path r102 = (Path) r100;
        if (r102 == null) goto L6;
        Files.deleteIfExists(r102);     // Catch: IOException -> L7
    L6:
        return FileVisitResult.CONTINUE;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public final FileVisitResult visitFileFailed(Object r100, IOException r101) throws IOException {
        Path r102 = (Path) r100;
        return FileVisitResult.CONTINUE;
    }
}
