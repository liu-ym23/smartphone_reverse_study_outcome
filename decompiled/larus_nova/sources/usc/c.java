package usc;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;
import org.commonmark.internal.h;
import org.commonmark.node.Block;
import org.commonmark.node.HtmlBlock;
import wvc.g;

/* JADX INFO: loaded from: classes41.dex */
public final class c extends wvc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HtmlBlock f551575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f551576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final usc.a f551577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Pattern f551578d;

    /* JADX INFO: loaded from: classes5.dex */
    public static final class a extends wvc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<String> f551579a;

        public a() {
            this.f551579a = new LinkedHashSet();
        }

        @Override // wvc.e
        public final wvc.f a(g r100, h.a r101) {
            h r102 = (h) r100;
            int r103 = r102.f525694e;
            CharSequence r104 = r102.f525690a;
            if (r102.f525696g < 4) goto L5;
            return null;
        L5:
            if (r104.charAt(r103) != '<') goto L18;
            Iterator<String> r105 = this.f551579a.iterator();
        L8:
            if (r105.hasNext() == false) goto L19;
            String r106 = r105.next();
            Pattern r107 = PatternProtector.compile("^<(?:" + r106 + ")(?:\\s|>|$)", 2);
            Pattern r108 = PatternProtector.compile("</(?:" + r106 + ")>", 2);
            if (r107.matcher(r104.subSequence(r103, r104.length())).find() == false) goto L8;
            org.commonmark.internal.d r109 = new org.commonmark.internal.d(new wvc.d[]{new c(r108)});
            r109.f525669b = r102.f525691b;
            return r109;
        L19:
            return null;
        L18:
            return null;
        }
    }

    @Override // wvc.a, wvc.d
    public final void c() {
        HtmlBlock r100 = this.f551575a;
        r100.f525768h = this.f551577c.f551566a.toString();
    }

    @Override // wvc.d
    public final Block a() {
        return this.f551575a;
    }

    public c(Pattern r100) {
        this.f551578d = r100;
        this.f551575a = new HtmlBlock();
        this.f551577c = new usc.a();
    }

    @Override // wvc.a, wvc.d
    public final void d(CharSequence r100) {
        usc.a r101 = this.f551577c;
        if (r101.f551567b == 0) goto L5;
        r101.f551566a.append('\n');
    L5:
        r101.f551566a.append(r100);
        r101.f551567b++;
        Pattern r102 = this.f551578d;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.matcher(r100).find() == false) goto L12;
        this.f551576b = true;
        return;
    }

    @Override // wvc.d
    public final wvc.c f(g r100) {
        if (this.f551576b == false) goto L5;
        return null;
    L5:
        h r101 = (h) r100;
        if (r101.f525697h == false) goto L11;
        if (this.f551578d != null) goto L11;
        return null;
    L11:
        return wvc.c.a(r101.f525691b);
    }
}
