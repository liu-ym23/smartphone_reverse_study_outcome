package com.larus.business.markdown.fresco;

import android.graphics.Rect;
import android.text.Spanned;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import lsc.h;
import lsc.l;
import org.commonmark.node.Image;
import wsc.i;

/* JADX INFO: loaded from: classes4.dex */
public final class e extends lsc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f320499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f320500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f320501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f320502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f320503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.business.markdown.api.extplugin.image.a f320504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f320505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f320506h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CharSequence f320507i;

    public static final class a {
    }

    static {
    }

    @Override // lsc.a, lsc.j
    public final void G4(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L5;
        ViewGroup r102 = (ViewGroup) r101;
    L6:
        if (r102 == null) goto L8;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        r102.setTag(R.id.markwon_cached_widget_list, null);
    L8:
        CharSequence r103 = r100.getText();
        if ((r103 instanceof Spanned) == false) goto L13;
        int r104 = 0;
        com.larus.business.markdown.api.extplugin.image.c[] r105 = (com.larus.business.markdown.api.extplugin.image.c[]) ((Spanned) r103).getSpans(0, r103.length(), com.larus.business.markdown.api.extplugin.image.c.class);
        int r106 = r105.length;
    L11:
        if (r104 >= r106) goto L13;
        r105[r104].a(r100);
        r104 = r104 + 1;
    L13:
        this.f320506h = null;
        this.f320507i = null;
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // lsc.a, lsc.j
    public final void g(h.a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        Rect r101 = this.f320503e;
        Integer r102 = this.f320501c;
        if (r102 == null) goto L5;
        int r103 = r102.intValue();
    L6:
        r100.f510601f = new i(r101, r103, this.f320502d);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    @Override // lsc.a, lsc.j
    public final void h(l.a r110) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        r110.a(Image.class, new f(this, this.f320499a, this.f320500b, this.f320501c, this.f320502d, this.f320503e, this.f320504f, this.f320505g));
    }

    @Override // lsc.a, lsc.j
    public final void f(TextView r100, Spanned r101) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        Intrinsics.checkNotNullParameter(r101, "markdown");
        CharSequence r102 = r100.getText();
        com.larus.business.markdown.api.extplugin.image.c[] r103 = null;
        if ((r102 instanceof Spanned) == false) goto L5;
        Spanned r104 = (Spanned) r102;
    L6:
        int r105 = 0;
        if (r104 == null) goto L9;
        r103 = (com.larus.business.markdown.api.extplugin.image.c[]) r104.getSpans(0, r102.length(), com.larus.business.markdown.api.extplugin.image.c.class);
    L9:
        if (r103 != null) goto L11;
        r103 = new com.larus.business.markdown.api.extplugin.image.c[0];
    L11:
        List r106 = ArraysKt.toMutableList(r101.getSpans(0, r101.length(), com.larus.business.markdown.api.extplugin.image.c.class));
        int r107 = r103.length;
    L12:
        if (r105 >= r107) goto L18;
        com.larus.business.markdown.api.extplugin.image.c r108 = r103[r105];
        if (r106.remove(r108) == true) goto L16;
        r108.c(r100);
    L17:
        r105 = r105 + 1;
        goto L12
    L16:
        r108.b(r101, r108);
        r108.hashCode();
        goto L17
    L18:
        Iterator r109 = r106.iterator();
    L20:
        if (r109.hasNext() == false) goto L22;
        com.larus.business.markdown.api.extplugin.image.c r110 = (com.larus.business.markdown.api.extplugin.image.c) r109.next();
        r110.hashCode();
        r110.d(r100, r101);
        goto L20
    L22:
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // lsc.a, lsc.j
    public final void i(CharSequence r100, uvc.b r101) {
        Intrinsics.checkNotNullParameter(r101, "node");
        this.f320507i = r100;
    }

    @Override // lsc.a, lsc.j
    public final void l(TextView r100, uvc.b r101) {
        Intrinsics.checkNotNullParameter(r101, "node");
        this.f320506h = r100;
    }

    public e(Integer r100, int r101, Integer r102, int r103, Rect r104, com.larus.business.markdown.api.extplugin.image.a r105, Map<String, ? extends Object> r106) {
        this.f320499a = r100;
        this.f320500b = r101;
        this.f320501c = r102;
        this.f320502d = r103;
        this.f320503e = r104;
        this.f320504f = r105;
        this.f320505g = r106;
    }
}
