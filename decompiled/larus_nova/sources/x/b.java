package x;

import bytedance.io.BdFile;
import bytedance.io.exception.IllegalPathException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes28.dex */
public final class b extends FileOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w.a f561984a = null;

    static {
        f561984a = w.a.C8054a.f557764a;
    }

    public b(String r100) throws FileNotFoundException, IllegalPathException {
        if (r100 == null) goto L4;
        BdFile r101 = new BdFile(r100);
    L5:
        this(r101, false);
        return;
    L4:
        r101 = null;
        goto L5
    }

    public b(BdFile r100, boolean r101) throws FileNotFoundException, IllegalPathException {
        f561984a.getClass();
        super(w.a.a(r100), r101);
    }
}
