package zsc;

import java.util.regex.Pattern;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes5.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f573518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public uvc.b f573519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f573520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f573521d;

    public i() {
    }

    public abstract uvc.b b();

    public abstract char d();

    public final char c() {
        k r100 = this.f573518a;
        ((j) r100).f573534h = this.f573521d;
        return ((j) r100).d();
    }

    public final void e() {
        k r100 = this.f573518a;
        ((j) r100).f573534h = this.f573521d;
        ((j) r100).c(j.f573523l);
        this.f573521d = ((j) this.f573518a).f573534h;
    }

    public final String a(Pattern r100) {
        k r101 = this.f573518a;
        ((j) r101).f573534h = this.f573521d;
        String r102 = ((j) r101).c(r100);
        this.f573521d = ((j) this.f573518a).f573534h;
        return r102;
    }

    public final Text f(String r100) {
        ((j) this.f573518a).getClass();
        return new Text(r100);
    }
}
