package zsc;

import java.util.regex.Pattern;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes5.dex */
public final class b extends i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f573512e = null;

    @Override // zsc.i
    public final char d() {
        return '\\';
    }

    static {
        f573512e = j.f573525n;
    }

    @Override // zsc.i
    public final uvc.b b() {
        this.f573521d++;
        if (c() != '\n') goto L6;
        HardLineBreak r100 = new HardLineBreak();
        this.f573521d++;
        return r100;
    L6:
        if (this.f573521d >= this.f573520c.length()) goto L11;
        Pattern r101 = f573512e;
        String r102 = this.f573520c;
        int r103 = this.f573521d;
        if (r101.matcher(r102.substring(r103, r103 + 1)).matches() == false) goto L11;
        String r104 = this.f573520c;
        int r105 = this.f573521d;
        ((j) this.f573518a).getClass();
        Text r106 = new Text(r104.substring(r105, r105 + 1));
        this.f573521d++;
        return r106;
    L11:
        return f("\\");
    }

    public b() {
    }
}
