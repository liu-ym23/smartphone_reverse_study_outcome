package zsc;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes5.dex */
public final class m extends i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f573547e = null;

    @Override // zsc.i
    public final char d() {
        return '\n';
    }

    static {
        f573547e = PatternProtector.compile(" *$");
    }

    @Override // zsc.i
    public final uvc.b b() {
        this.f573521d++;
        uvc.b r100 = this.f573519b.f551902c;
        if ((r100 instanceof Text) == false) goto L19;
        Text r101 = (Text) r100;
        if (r101.f525783h.endsWith(" ") == false) goto L19;
        String r102 = r101.f525783h;
        Matcher r103 = f573547e.matcher(r102);
        if (r103.find() == false) goto L9;
        int r104 = r103.end() - r103.start();
    L10:
        if (r104 <= 0) goto L13;
        r101.f525783h = r102.substring(0, r102.length() - r104);
    L13:
        if (r104 < 2) goto L17;
        return new HardLineBreak();
    L17:
        return new SoftLineBreak();
    L9:
        r104 = 0;
    L19:
        return new SoftLineBreak();
    }

    public m() {
    }
}
