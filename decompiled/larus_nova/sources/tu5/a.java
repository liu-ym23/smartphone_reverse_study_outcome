package tu5;

import com.ss.android.lark.vfs.VFSFile;
import java.util.Comparator;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements Comparator<VFSFile> {
    public a() {
    }

    @Override // java.util.Comparator
    public final int compare(VFSFile r100, VFSFile r101) {
        return b.a(r101.getName(), r100.getName());
    }
}
