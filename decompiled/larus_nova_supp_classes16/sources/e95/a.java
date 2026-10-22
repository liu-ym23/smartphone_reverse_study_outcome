package e95;

import com.bytedance.ee.bear.libarchive.ArchiveEntry;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final List<ArchiveEntry> a;

    /* JADX INFO: renamed from: e95.a$a, reason: collision with other inner class name */
    public static final class C0218a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends ArchiveEntry> r2) {
        Intrinsics.checkNotNullParameter(r2, "archiveEntryList");
        this.a = r2;
    }
}
