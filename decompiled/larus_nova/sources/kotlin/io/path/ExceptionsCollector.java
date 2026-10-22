package kotlin.io.path;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.android.ec.core.event.a;
import com.larus.bmhome.share.panel.ShareChannel;
import java.nio.file.FileSystemException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0007j\u0002`\bJ\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\fJ\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\fR\u001b\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lkotlin/io/path/ExceptionsCollector;", "", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "", "(I)V", "collectedExceptions", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getCollectedExceptions", "()Ljava/util/List;", "path", "Ljava/nio/file/Path;", "getPath", "()Ljava/nio/file/Path;", "setPath", "(Ljava/nio/file/Path;)V", "<set-?>", "totalExceptions", "getTotalExceptions", "()I", ShareChannel.COLLECT, "", a.KEY_EXCEPTION, "enterEntry", "name", "exitEntry", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class ExceptionsCollector {
    private final List<Exception> collectedExceptions;
    private final int limit;
    private Path path;
    private int totalExceptions;

    public ExceptionsCollector() {
        int r100 = 0;
        this(r100, 1, null);
    }

    public final List<Exception> getCollectedExceptions() {
        return this.collectedExceptions;
    }

    public final Path getPath() {
        return this.path;
    }

    public final int getTotalExceptions() {
        return this.totalExceptions;
    }

    public ExceptionsCollector(int r100) {
        this.limit = r100;
        this.collectedExceptions = new ArrayList();
    }

    public final void collect(Exception r100) {
        Intrinsics.checkNotNullParameter(r100, a.KEY_EXCEPTION);
        boolean r101 = true;
        this.totalExceptions++;
        if (this.collectedExceptions.size() < this.limit) goto L6;
        r101 = false;
    L6:
        if (r101 == true) goto L8;
        return;
    L8:
        if (this.path == null) goto L10;
        Throwable r102 = new FileSystemException(String.valueOf(this.path)).initCause(r100);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type java.nio.file.FileSystemException");
        r100 = (FileSystemException) r102;
    L10:
        this.collectedExceptions.add(r100);
    }

    public final void enterEntry(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Path r101 = this.path;
        if (r101 == null) goto L5;
        Path r102 = r101.resolve(r100);
    L6:
        this.path = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void exitEntry(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Path r101 = this.path;
        Path r102 = null;
        if (r101 == null) goto L5;
        Path r103 = r101.getFileName();
    L7:
        if (Intrinsics.areEqual(r100, r103) == false) goto L14;
        Path r104 = this.path;
        if (r104 == null) goto L11;
        r102 = r104.getParent();
    L11:
        this.path = r102;
        return;
    L14:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r103 = null;
        goto L7
    }

    public final void setPath(Path r100) {
        this.path = r100;
    }

    public /* synthetic */ ExceptionsCollector(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 64;
    L5:
        this(r100);
    }
}
