package zsc;

import androidx.core.net.MailTo;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.commonmark.node.Link;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes5.dex */
public final class a extends i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f573510e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f573511f = null;

    @Override // zsc.i
    public final char d() {
        return Typography.less;
    }

    static {
        f573510e = PatternProtector.compile("^<([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)>");
        f573511f = PatternProtector.compile("^<[a-zA-Z][a-zA-Z0-9.+-]{1,31}:[^<>\u0000- ]*>");
    }

    @Override // zsc.i
    public final uvc.b b() {
        String r100 = a(f573510e);
        if (r100 == null) goto L6;
        String r101 = r100.substring(1, r100.length() - 1);
        Link r102 = new Link(MailTo.MAILTO_SCHEME + r101, null);
        r102.b(new Text(r101));
        return r102;
    L6:
        String r103 = a(f573511f);
        if (r103 == null) goto L10;
        String r104 = r103.substring(1, r103.length() - 1);
        Link r105 = new Link(r104, null);
        r105.b(new Text(r104));
        return r105;
    L10:
        return null;
    }

    public a() {
    }
}
