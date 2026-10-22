package io.noties.markwon.maybe;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.StringsKt;
import org.commonmark.node.Link;
import zsc.j;
import zsc.n;

/* JADX INFO: loaded from: classes41.dex */
public final class e extends n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f492646f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f492647g = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicReference<String> f492648e;

    public static final class a {
    }

    static {
        f492646f = PatternProtector.compile("^\\[[^\\(\\)]+\\]\\([^\\[\\)]*$");
        f492647g = PatternProtector.compile("(?!\\[)([^\\]])*");
    }

    @Override // zsc.n, zsc.i
    public final uvc.b b() {
        if (StringsKt.endsWith$default(this.f492648e.get(), ((j) this.f573518a).f573533g, false, 2, null) == false) goto L13;
        String r100 = a(f492646f);
        if (r100 == null) goto L13;
        Matcher r101 = f492647g.matcher(r100);
        if (r101.find() == false) goto L9;
        String r102 = r101.group();
    L10:
        MaybeNode r103 = new MaybeNode(new Link("", r102));
        r103.b(f(r100));
        return r103;
    L9:
        r102 = "";
    L13:
        return super.b();
    }

    public e(AtomicReference<String> r100) {
        this.f492648e = r100;
    }
}
