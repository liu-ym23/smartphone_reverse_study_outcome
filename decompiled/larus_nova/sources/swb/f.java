package swb;

import com.ss.android.lark.vfs.VFSFile;
import java.util.Comparator;

/* JADX INFO: loaded from: classes37.dex */
public final class f implements Comparator<VFSFile> {
    public f() {
    }

    @Override // java.util.Comparator
    public final int compare(VFSFile r100, VFSFile r101) {
        return g.b(r101.getName(), r100.getName());
    }
}
