package io.noties.markwon.maybe;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.collections.SetsKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.commonmark.node.HtmlInline;
import zsc.i;
import zsc.j;

/* JADX INFO: loaded from: classes41.dex */
public final class c extends i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set<String> f492638e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f492639f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f492640g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Pattern f492641h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Pattern f492642i = null;

    public static final class a {
    }

    @Override // zsc.i
    public final char d() {
        return Typography.less;
    }

    static {
        f492638e = SetsKt.setOf(new String[]{"img", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "blockquote", "sub", "sup", "b", "strong", "s", "del", "u", "ins", "ol", "ul", RXScreenCaptureService.KEY_INDEX, "em", "cite", "dfn", "h1", "h2", "h3", "h4", "h5", "h6", "p", "div", "span"});
        PatternProtector.compile("(^<![-\\w][^>]*$)|(^<[A-Za-z][-_/\\w\\d]*(\\s+[^>]*)?(?!>)$)");
        f492639f = PatternProtector.compile("^<$", 0);
        f492640g = PatternProtector.compile("^<[A-Za-z0-9]*$");
        f492641h = PatternProtector.compile("^<[A-Za-z0-9]+ [^>\\n]*$");
        f492642i = PatternProtector.compile("^</[A-Za-z0-9]*$", 0);
    }

    @Override // zsc.i
    public final uvc.b b() {
        if (a(f492639f) == null) goto L6;
        String r100 = ((j) this.f573518a).f573533g;
        return g();
    L6:
        String r101 = a(f492640g);
        if (r101 == null) goto L20;
        String r102 = r101.substring(1);
        Iterator<T> r103 = f492638e.iterator();
    L10:
        if (r103.hasNext() == false) goto L14;
        Object r104 = r103.next();
        if (StringsKt.startsWith$default((String) r104, r102, false, 2, null) == false) goto L10;
    L16:
        if (((String) r104) == null) goto L46;
        String r105 = ((j) this.f573518a).f573533g;
        return g();
    L46:
        return null;
    L14:
        r104 = null;
        goto L16
    L20:
        String r106 = a(f492641h);
        if (r106 != null) goto L23;
        String r107 = a(f492642i);
        if (r107 == null) goto L48;
        String r108 = r107.substring(2);
        Iterator<T> r109 = f492638e.iterator();
    L30:
        if (r109.hasNext() == false) goto L34;
        Object r110 = r109.next();
        if (StringsKt.startsWith$default((String) r110, r108, false, 2, null) == false) goto L30;
    L36:
        if (((String) r110) == null) goto L49;
        String r111 = ((j) this.f573518a).f573533g;
        return g();
    L49:
        return null;
    L34:
        r110 = null;
        goto L36
    L48:
        return null;
    L23:
        if (f492638e.contains(r106.substring(1, StringsKt.indexOf$default(r106, " ", 0, false, 6, null))) == false) goto L47;
        String r112 = ((j) this.f573518a).f573533g;
        return g();
    L47:
        return null;
    }

    public final MaybeNode g() {
        HtmlInline r100 = new HtmlInline();
        r100.f525769h = "";
        MaybeNode r101 = new MaybeNode(r100);
        r101.b(f(""));
        return r101;
    }

    public c() {
    }
}
