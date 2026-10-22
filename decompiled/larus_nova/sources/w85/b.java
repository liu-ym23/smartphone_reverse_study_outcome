package w85;

import com.ss.android.lark.vfs.VFSFile;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InputStream f558652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public File f558653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f558654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f558655d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f558656e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f558657f;

    public b() {
        this.f558654c = "0";
        this.f558655d = -1;
        this.f558656e = -1;
        this.f558657f = null;
    }

    public b(InputStream r100, VFSFile r101, long r102) {
        this.f558657f = null;
        this.f558652a = r100;
        this.f558653b = r101;
        this.f558654c = "1";
        this.f558655d = r102;
        this.f558656e = 0;
    }
}
