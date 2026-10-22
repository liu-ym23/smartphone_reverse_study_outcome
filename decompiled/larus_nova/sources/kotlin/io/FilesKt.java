package kotlin.io;

import java.io.File;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"kotlin/io/FilesKt__FilePathComponentsKt", "kotlin/io/FilesKt__FileReadWriteKt", "kotlin/io/FilesKt__FileTreeWalkKt", "kotlin/io/FilesKt__UtilsKt"}, k = 4, mv = {1, 9, 0}, xi = 49)
public final class FilesKt extends FilesKt__UtilsKt {
    public static /* bridge */ /* synthetic */ void appendBytes(File r100, byte[] r101) {
        FilesKt__FileReadWriteKt.appendBytes(r100, r101);
    }

    public static /* bridge */ /* synthetic */ void appendText$default(File r100, String r101, Charset r102, int r103, Object r104) {
        FilesKt__FileReadWriteKt.appendText$default(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ ByteBuffer byteBufferForEncoding(int r100, CharsetEncoder r101) {
        return FilesKt__FileReadWriteKt.byteBufferForEncoding(r100, r101);
    }

    public static /* bridge */ /* synthetic */ boolean copyRecursively$default(File r100, File r101, boolean r102, Function2 r103, int r104, Object r105) {
        return FilesKt__UtilsKt.copyRecursively$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ File copyTo$default(File r100, File r101, boolean r102, int r103, int r104, Object r105) {
        return FilesKt__UtilsKt.copyTo$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ boolean deleteRecursively(File r100) {
        return FilesKt__UtilsKt.deleteRecursively(r100);
    }

    public static /* bridge */ /* synthetic */ void forEachLine$default(File r100, Charset r101, Function1 r102, int r103, Object r104) {
        FilesKt__FileReadWriteKt.forEachLine$default(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ String getExtension(File r100) {
        return FilesKt__UtilsKt.getExtension(r100);
    }

    public static /* bridge */ /* synthetic */ String getInvariantSeparatorsPath(File r100) {
        return FilesKt__UtilsKt.getInvariantSeparatorsPath(r100);
    }

    public static /* bridge */ /* synthetic */ String getNameWithoutExtension(File r100) {
        return FilesKt__UtilsKt.getNameWithoutExtension(r100);
    }

    public static /* bridge */ /* synthetic */ CharsetEncoder newReplaceEncoder(Charset r100) {
        return FilesKt__FileReadWriteKt.newReplaceEncoder(r100);
    }

    public static /* bridge */ /* synthetic */ byte[] readBytes(File r100) {
        return FilesKt__FileReadWriteKt.readBytes(r100);
    }

    public static /* bridge */ /* synthetic */ List readLines$default(File r100, Charset r101, int r102, Object r103) {
        return FilesKt__FileReadWriteKt.readLines$default(r100, r101, r102, r103);
    }

    public static /* bridge */ /* synthetic */ String readText(File r100, Charset r101) {
        return FilesKt__FileReadWriteKt.readText(r100, r101);
    }

    public static /* bridge */ /* synthetic */ String readText$default(File r100, Charset r101, int r102, Object r103) {
        return FilesKt__FileReadWriteKt.readText$default(r100, r101, r102, r103);
    }

    public static /* bridge */ /* synthetic */ File relativeTo(File r100, File r101) {
        return FilesKt__UtilsKt.relativeTo(r100, r101);
    }

    public static /* bridge */ /* synthetic */ File resolve(File r100, String r101) {
        return FilesKt__UtilsKt.resolve(r100, r101);
    }

    public static /* bridge */ /* synthetic */ File resolveSibling(File r100, String r101) {
        return FilesKt__UtilsKt.resolveSibling(r100, r101);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith(File r100, File r101) {
        return FilesKt__UtilsKt.startsWith(r100, r101);
    }

    public static /* bridge */ /* synthetic */ String toRelativeString(File r100, File r101) {
        return FilesKt__UtilsKt.toRelativeString(r100, r101);
    }

    public static /* bridge */ /* synthetic */ FileTreeWalk walk$default(File r100, FileWalkDirection r101, int r102, Object r103) {
        return FilesKt__FileTreeWalkKt.walk$default(r100, r101, r102, r103);
    }

    public static /* bridge */ /* synthetic */ FileTreeWalk walkBottomUp(File r100) {
        return FilesKt__FileTreeWalkKt.walkBottomUp(r100);
    }

    public static /* bridge */ /* synthetic */ FileTreeWalk walkTopDown(File r100) {
        return FilesKt__FileTreeWalkKt.walkTopDown(r100);
    }

    public static /* bridge */ /* synthetic */ void writeBytes(File r100, byte[] r101) {
        FilesKt__FileReadWriteKt.writeBytes(r100, r101);
    }

    public static /* bridge */ /* synthetic */ void writeText(File r100, String r101, Charset r102) {
        FilesKt__FileReadWriteKt.writeText(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ void writeText$default(File r100, String r101, Charset r102, int r103, Object r104) {
        FilesKt__FileReadWriteKt.writeText$default(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ void writeTextImpl(OutputStream r100, String r101, Charset r102) {
        FilesKt__FileReadWriteKt.writeTextImpl(r100, r101, r102);
    }

    private FilesKt() {
    }
}
