package x;

import bytedance.io.exception.IllegalPathException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes28.dex */
public final class i extends RandomAccessFile {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w.a f561992a = null;

    static {
        f561992a = w.a.C8054a.f557764a;
    }

    public i(File r100, String r101) throws FileNotFoundException, IllegalPathException {
        f561992a.getClass();
        super(w.a.a(r100), r101);
    }
}
