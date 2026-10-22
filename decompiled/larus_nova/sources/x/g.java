package x;

import bytedance.io.exception.IllegalPathException;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes28.dex */
public final class g extends PrintStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w.a f561990a = null;

    static {
        f561990a = w.a.C8054a.f557764a;
    }

    public g(String r100) throws FileNotFoundException, IllegalPathException {
        super(f561990a.b(r100));
    }

    public g(String r100, String r101) throws FileNotFoundException, UnsupportedEncodingException, IllegalPathException {
        super(f561990a.b(r100), r101);
    }
}
