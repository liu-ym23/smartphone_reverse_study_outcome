package iv7;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.InflaterInputStream;

/* JADX INFO: loaded from: classes23.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f495951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f495952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f495953c;

    public f() {
        this.f495951a = true;
        this.f495952b = null;
        this.f495953c = false;
    }

    public final void a(InputStream r100, OutputStream r101) throws IOException {
        i r102 = this.f495952b;
        if (r102 != null) goto L7;
        r102 = new i(this.f495951a);
        if (this.f495953c == false) goto L8;
        this.f495952b = r102;
    L8:
        jv7.c.a(new InflaterInputStream(r100, r102, 32768), r101);
        if (this.f495953c == true) goto L14;
        i r103 = this.f495952b;
        if (r103 == null) goto L15;
        r103.a();
        this.f495952b = null;
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r102.reset();
        goto L8
    }
}
