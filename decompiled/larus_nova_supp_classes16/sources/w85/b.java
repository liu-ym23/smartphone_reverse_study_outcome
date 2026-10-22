package w85;

import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.ss.android.lark.vfs.VFSFile;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public InputStream a;
    public File b;
    public String c;
    public long d;
    public int e;
    public String f;

    public b() {
        this.c = DiagramData$RESULT.FAIL;
        this.d = -1;
        this.e = -1;
        this.f = null;
    }

    public b(InputStream r2, VFSFile r3, long r4) {
        this.f = null;
        this.a = r2;
        this.b = r3;
        this.c = DiagramData$RESULT.SUCCESS;
        this.d = r4;
        this.e = 0;
    }
}
