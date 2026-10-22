package n25;

import com.ss.android.lark.vfs.VFSFile;
import java.io.File;

/* JADX INFO: loaded from: classes16.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f516739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f516740b;

    public final String toString() {
        return "Resource{file=" + this.f516739a + ", version='" + this.f516740b + "'}";
    }

    public i(VFSFile r100, String r101, boolean r102) {
        this.f516739a = r100;
        this.f516740b = r101;
    }
}
