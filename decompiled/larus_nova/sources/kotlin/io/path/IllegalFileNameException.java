package kotlin.io.path;

import java.nio.file.FileSystemException;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/io/path/IllegalFileNameException;", "Ljava/nio/file/FileSystemException;", "file", "Ljava/nio/file/Path;", "(Ljava/nio/file/Path;)V", "other", "message", "", "(Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/lang/String;)V", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class IllegalFileNameException extends FileSystemException {
    public IllegalFileNameException(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        this(r100, null, null);
    }

    public IllegalFileNameException(Path r100, Path r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "file");
        String r103 = r100.toString();
        if (r101 == null) goto L5;
        String r104 = r101.toString();
    L6:
        super(r103, r104, r102);
        return;
    L5:
        r104 = null;
        goto L6
    }
}
