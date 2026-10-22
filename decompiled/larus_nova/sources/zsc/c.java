package zsc;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;
import org.commonmark.node.Code;

/* JADX INFO: loaded from: classes5.dex */
public final class c extends i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f573513e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f573514f = null;

    @Override // zsc.i
    public final char d() {
        return '`';
    }

    static {
        f573513e = PatternProtector.compile("`+");
        f573514f = PatternProtector.compile("^`+");
    }

    @Override // zsc.i
    public final uvc.b b() {
        String r100 = a(f573514f);
        if (r100 != null) goto L6;
        return null;
    L6:
        int r101 = this.f573521d;
    L7:
        String r102 = a(f573513e);
        if (r102 == null) goto L24;
        if (r102.equals(r100) == false) goto L7;
        Code r103 = new Code();
        String r104 = this.f573520c.substring(r101, this.f573521d - r100.length()).replace('\n', ' ');
        if (r104.length() < 3) goto L22;
        boolean r105 = false;
        if (r104.charAt(0) != ' ') goto L22;
        if (r104.charAt(r104.length() - 1) != ' ') goto L22;
        int r106 = r104.length();
        if (tvc.d.b(' ', r104, 0, r106) == r106) goto L20;
        r105 = true;
    L20:
        if (r105 == false) goto L22;
        r104 = r104.substring(1, r104.length() - 1);
    L22:
        r103.f525760h = r104;
        return r103;
    L24:
        this.f573521d = r101;
        return f(r100);
    }

    public c() {
    }
}
