package x;

import bytedance.io.exception.IllegalPathException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes28.dex */
public final class h extends PrintWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w.a f561991a = null;

    static {
        f561991a = w.a.C8054a.f557764a;
    }

    public h(String r100) throws FileNotFoundException, IllegalPathException {
        super(f561991a.b(r100));
    }

    public h(String r100, String r101) throws FileNotFoundException, UnsupportedEncodingException, IllegalPathException {
        super(f561991a.b(r100), r101);
    }
}
