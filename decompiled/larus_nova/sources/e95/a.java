package e95;

import com.bytedance.ee.bear.libarchive.ArchiveEntry;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ArchiveEntry> f471489a;

    /* JADX INFO: renamed from: e95.a$a, reason: collision with other inner class name */
    public static final class C5756a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends ArchiveEntry> r100) {
        Intrinsics.checkNotNullParameter(r100, "archiveEntryList");
        this.f471489a = r100;
    }
}
