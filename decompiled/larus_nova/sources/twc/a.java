package twc;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import org.nanohttpd.protocols.http.NanoHTTPD;

/* JADX INFO: loaded from: classes42.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f547805a;

    @Override // twc.d
    public final void clear() {
        Iterator r100 = ((ArrayList) this.f547805a).iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        ((c) r100.next()).delete();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        NanoHTTPD.LOG.log(Level.WARNING, "could not delete file ", e);
        goto L4
    L10:
        ((ArrayList) this.f547805a).clear();
    }

    public a() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(System.getProperty("java.io.tmpdir"));
        if (r100.exists() == true) goto L5;
        r100.mkdirs();
    L5:
        this.f547805a = new ArrayList();
    }
}
