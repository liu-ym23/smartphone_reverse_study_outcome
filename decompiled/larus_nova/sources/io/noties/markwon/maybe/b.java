package io.noties.markwon.maybe;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;
import kotlin.TypeCastException;
import kotlin.text.StringsKt;
import org.commonmark.internal.h;
import org.commonmark.internal.i;
import org.commonmark.node.FencedCodeBlock;

/* JADX INFO: loaded from: classes41.dex */
public final class b extends i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f492636e = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f492637d;

    public static final class a {
    }

    /* JADX INFO: renamed from: io.noties.markwon.maybe.b$b, reason: collision with other inner class name */
    public static final class C6319b extends wvc.b {
        public C6319b() {
        }

        @Override // wvc.e
        public final wvc.f a(wvc.g r110, h.a r111) {
            h r112 = (h) r110;
            int r113 = r112.f525696g;
            org.commonmark.internal.d r100 = null;
            if (r113 < 4) goto L5;
            return null;
        L5:
            int r101 = r112.f525694e;
            CharSequence r114 = r112.f525690a;
            int r102 = r114.length();
            int r103 = r101;
            int r104 = 0;
            int r105 = 0;
        L7:
            if (r103 >= r102) goto L16;
            char r106 = r114.charAt(r103);
            if (r106 == '`') goto L13;
            if (r106 != '~') goto L16;
            r105 = r105 + 1;
        L14:
            r103 = r103 + 1;
            goto L7
        L13:
            r104 = r104 + 1;
        L16:
            if (r104 < 3) goto L29;
            if (r105 != 0) goto L29;
            int r107 = r101 + r104;
            int r108 = r114.length();
        L20:
            if (r107 >= r108) goto L25;
            if (r114.charAt(r107) == '`') goto L26;
            r107 = r107 + 1;
        L26:
            if (r107 != (-1)) goto L32;
            b r115 = new b('`', r104, r113);
        L33:
            if (r115 == null) goto L39;
            r100 = new org.commonmark.internal.d(new wvc.d[]{r115});
            FencedCodeBlock r116 = r115.f525706a;
            if (r116 == null) goto L38;
            r100.f525669b = r101 + r116.f525763i;
            goto L39
        L38:
            throw new TypeCastException("null cannot be cast to non-null type org.commonmark.node.FencedCodeBlock");
        L39:
            return r100;
        L32:
            r115 = null;
            goto L33
        L25:
            r107 = -1;
        L29:
            if (r105 < 3) goto L32;
            if (r104 != 0) goto L32;
            r115 = new b('~', r105, r113);
            goto L33
        }
    }

    static {
        f492636e = PatternProtector.compile("^`{1,2}$");
    }

    @Override // org.commonmark.internal.i, wvc.a, wvc.d
    public final void d(CharSequence r100) {
        CharSequence r101 = this.f492637d;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L12;
        super.d(this.f492637d);
        this.f492637d = null;
    L12:
        if (f492636e.matcher(StringsKt.trim(r100, new char[]{' '})).matches() == false) goto L15;
        this.f492637d = r100;
        return;
    L15:
        super.d(r100);
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // org.commonmark.internal.i, wvc.d
    public final wvc.c f(wvc.g r100) {
        h r101 = (h) r100;
        CharSequence r102 = r101.f525690a;
        int r103 = r101.f525694e;
        boolean r104 = false;
        if (r101.f525696g >= 4) goto L17;
        FencedCodeBlock r105 = this.f525706a;
        if (r105 == null) goto L16;
        char r106 = r105.f525762h;
        int r107 = r105.f525763i;
        int r108 = tvc.d.b(r106, r102, r103, r102.length()) - r103;
        if (r108 >= r107) goto L10;
    L12:
        boolean r109 = false;
    L13:
        if (r109 == false) goto L17;
        boolean r110 = true;
    L18:
        if (r110 == false) goto L29;
        CharSequence r111 = this.f492637d;
        if (r111 == null) goto L27;
        if (r111.length() <= 0) goto L24;
        r104 = true;
    L24:
        if (r104 == false) goto L27;
        d(r111);
        this.f492637d = null;
    L27:
        return wvc.c.b();
    L29:
        return super.f(r100);
    L10:
        if (tvc.d.c(r102, r103 + r108, r102.length()) != r102.length()) goto L12;
        r109 = true;
        goto L13
    L16:
        throw new TypeCastException("null cannot be cast to non-null type org.commonmark.node.FencedCodeBlock");
    L17:
        r110 = false;
        goto L18
    }

    public b(char r100, int r101, int r102) {
        super(r100, r101, r102);
    }
}
