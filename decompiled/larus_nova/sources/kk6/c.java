package kk6;

import android.graphics.drawable.Drawable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import ek6.d;
import fk6.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class c<T extends fk6.b> implements ik6.a<T> {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // ik6.a
    public final List b(d r100) {
        Intrinsics.checkNotNullParameter((fk6.b) r100, "content");
        return null;
    }

    @Override // ik6.a
    public final String e(d r100) {
        fk6.b r101 = (fk6.b) r100;
        Intrinsics.checkNotNullParameter(r101, "content");
        String r102 = r101.c();
        gk6.a r103 = r101.d();
        if (r103 == null) goto L18;
        Integer r104 = r103.f481550g;
        if (r104 == null) goto L19;
        int r105 = r104.intValue();
        if (r105 > 0) goto L9;
    L11:
        boolean r106 = false;
    L12:
        if (r106 == true) goto L15;
        r104 = null;
    L15:
        if (r104 != null) goto L17;
        return r102;
    L17:
        return r102.subSequence(0, r104.intValue()).toString() + "…";
    L9:
        if (r102.length() <= r105) goto L11;
        r106 = true;
        goto L12
    L19:
        return r102;
    L18:
        return r102;
    }

    @Override // ik6.a
    public final void f(ik6.b r100, d r101) {
        fk6.b r102 = (fk6.b) r101;
        Intrinsics.checkNotNullParameter(r100, "editor");
        Intrinsics.checkNotNullParameter(r102, "content");
        ArrayList r103 = new ArrayList();
        gk6.a r104 = r102.d();
        Integer r105 = null;
        if (r104 == null) goto L5;
        Integer r106 = r104.f481544a;
    L6:
        if (r106 == null) goto L9;
        int r107 = r104.f481544a.intValue();
        int r108 = com.bytedance.live.richcontent.utils.b.f255804a;
        r103.add(new ForegroundColorSpan(r107));
    L9:
        if (r104 != null) goto L11;
    L13:
        if (r104 != null) goto L15;
    L17:
        if (r104 != null) goto L19;
    L21:
        if (r104 == null) goto L23;
        r105 = r104.f481545b;
    L23:
        if (r105 == null) goto L29;
        int r109 = r104.f481545b.intValue();
        Boolean r110 = r104.f481546c;
        if (r110 == null) goto L27;
        boolean r111 = r110.booleanValue();
    L28:
        int r112 = com.bytedance.live.richcontent.utils.b.f255804a;
        r103.add(new AbsoluteSizeSpan(r109, r111));
        goto L29
    L27:
        r111 = false;
    L29:
        Iterator r113 = r103.iterator();
    L31:
        if (r113.hasNext() == false) goto L33;
        r100.a(r102, (CharacterStyle) r113.next());
        goto L31
    L33:
        return;
    L19:
        if (r104.f481549f != true) goto L21;
        int r114 = com.bytedance.live.richcontent.utils.b.f255804a;
        r103.add(new UnderlineSpan());
        goto L21
    L15:
        if (r104.f481548e != true) goto L17;
        int r115 = com.bytedance.live.richcontent.utils.b.f255804a;
        r103.add(new StyleSpan(2));
        goto L17
    L11:
        if (r104.f481547d != true) goto L13;
        int r116 = com.bytedance.live.richcontent.utils.b.f255804a;
        r103.add(new StyleSpan(1));
        goto L13
    L5:
        r106 = null;
        goto L6
    }

    @Override // ik6.a
    public final void g(ik6.b r100, d r101) {
        fk6.b r102 = (fk6.b) r101;
        Intrinsics.checkNotNullParameter(r100, "editor");
        Intrinsics.checkNotNullParameter(r102, "content");
        ek6.c r103 = r102.b();
        if (r103 == null) goto L6;
        int r104 = com.bytedance.live.richcontent.utils.b.f255804a;
        Intrinsics.checkNotNullParameter(r103, "action");
        r100.a(r102, new lk6.d(r103));
        return;
    }

    @Override // ik6.a
    public final void c(ik6.d r100, d r101, ek6.b r102) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        Intrinsics.checkNotNullParameter((fk6.b) r101, "content");
        Intrinsics.checkNotNullParameter(r102, "resourceInfo");
    }

    @Override // ik6.a
    public final void d(ik6.b r100, d r101, ek6.b r102) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        Intrinsics.checkNotNullParameter((fk6.b) r101, "content");
        Intrinsics.checkNotNullParameter(r102, "resourceInfo");
    }

    @Override // ik6.a
    public final void a(ik6.b r100, d r101, ek6.b r102, Drawable r103) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        Intrinsics.checkNotNullParameter((fk6.b) r101, "content");
        Intrinsics.checkNotNullParameter(r102, "resourceInfo");
        Intrinsics.checkNotNullParameter(r103, "drawable");
    }
}
