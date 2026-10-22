package n25;

import com.ss.android.lark.vfs.VFSFile;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i {
    public final File a;
    public final String b;

    public final String toString() {
        return "Resource{file=" + this.a + ", version='" + this.b + "'}";
    }

    public i(VFSFile r1, String r2, boolean r3) {
        this.a = r1;
        this.b = r2;
    }
}
