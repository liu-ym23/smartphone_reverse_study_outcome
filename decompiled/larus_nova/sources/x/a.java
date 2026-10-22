package x;

import bytedance.io.BdFile;
import bytedance.io.exception.IllegalPathException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes28.dex */
public final class a extends FileInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w.a f561983a = null;

    static {
        f561983a = w.a.C8054a.f557764a;
    }

    public a(String r100) throws FileNotFoundException, IllegalPathException {
        if (r100 == null) goto L4;
        BdFile r101 = new BdFile(r100);
    L5:
        f561983a.getClass();
        super(w.a.a(r101));
        return;
    L4:
        r101 = null;
        goto L5
    }
}
