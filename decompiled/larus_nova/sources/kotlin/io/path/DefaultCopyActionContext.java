package kotlin.io.path;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lkotlin/io/path/DefaultCopyActionContext;", "Lkotlin/io/path/CopyActionContext;", "()V", "copyToIgnoringExistingDirectory", "Lkotlin/io/path/CopyActionResult;", "Ljava/nio/file/Path;", PickerReporterConstants.KEY.TARGET, "followLinks", "", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class DefaultCopyActionContext implements CopyActionContext {
    public static final DefaultCopyActionContext INSTANCE = null;

    static {
        INSTANCE = new DefaultCopyActionContext();
    }

    private DefaultCopyActionContext() {
    }

    @Override // kotlin.io.path.CopyActionContext
    public CopyActionResult copyToIgnoringExistingDirectory(Path r100, Path r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        LinkOption[] r103 = LinkFollowing.INSTANCE.toLinkOptions(r102);
        LinkOption[] r104 = (LinkOption[]) Arrays.copyOf(r103, r103.length);
        if (Files.isDirectory(r100, (LinkOption[]) Arrays.copyOf(r104, r104.length)) == true) goto L5;
    L6:
        CopyOption[] r105 = (CopyOption[]) Arrays.copyOf(r103, r103.length);
        Files.copy(r100, r101, (CopyOption[]) Arrays.copyOf(r105, r105.length));
    L8:
        return CopyActionResult.CONTINUE;
    L5:
        if (Files.isDirectory(r101, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1)) == true) goto L8;
        goto L6
    }
}
