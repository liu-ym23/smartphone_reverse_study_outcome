package io.noties.markwon.maybe;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.StringsKt;
import org.commonmark.node.Image;
import zsc.j;

/* JADX INFO: loaded from: classes41.dex */
public final class d extends zsc.d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f492643f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f492644g = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicReference<String> f492645e;

    public static final class a {
    }

    static {
        f492643f = PatternProtector.compile("^!\\[[^\\)\\[]*$");
        f492644g = PatternProtector.compile("(?![!\\[])([^\\]])*");
    }

    @Override // zsc.d, zsc.i
    public final uvc.b b() {
        if (StringsKt.endsWith$default(this.f492645e.get(), ((j) this.f573518a).f573533g, false, 2, null) == false) goto L13;
        String r100 = a(f492643f);
        if (r100 == null) goto L13;
        Matcher r101 = f492644g.matcher(r100);
        if (r101.find() == false) goto L9;
        String r102 = r101.group();
    L10:
        MaybeNode r103 = new MaybeNode(new Image("", r102));
        r103.b(f(r100));
        return r103;
    L9:
        r102 = "";
    L13:
        return super.b();
    }

    public d(AtomicReference<String> r100) {
        this.f492645e = r100;
    }
}
