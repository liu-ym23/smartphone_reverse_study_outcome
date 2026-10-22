package zsc;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.commonmark.node.HtmlInline;

/* JADX INFO: loaded from: classes5.dex */
public final class g extends i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f573517e = null;

    @Override // zsc.i
    public final char d() {
        return Typography.less;
    }

    static {
        f573517e = PatternProtector.compile("^(?:<[A-Za-z][A-Za-z0-9-_]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-_]*\\s*[>]|<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->|[<][?].*?[?][>]|<![A-Z]+\\s+[^>]*>|<!\\[CDATA\\[[\\s\\S]*?\\]\\]>)", 2);
    }

    @Override // zsc.i
    public final uvc.b b() {
        String r100 = a(f573517e);
        if (r100 == null) goto L6;
        HtmlInline r101 = new HtmlInline();
        r101.f525769h = r100;
        return r101;
    L6:
        return null;
    }

    public g() {
    }
}
