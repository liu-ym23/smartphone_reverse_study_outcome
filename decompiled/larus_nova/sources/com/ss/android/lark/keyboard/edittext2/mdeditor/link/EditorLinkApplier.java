package com.ss.android.lark.keyboard.edittext2.mdeditor.link;

import android.text.InputFilter;
import android.text.NoCopySpan;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.TextView;
import com.ss.android.lark.keyboard.edittext2.widget.f;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import v7b.n;

/* JADX INFO: loaded from: classes36.dex */
public final class EditorLinkApplier implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<n, CharSequence> f429188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f429189b;

    public static final class a {
    }

    static {
    }

    public final void a(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        List r101 = ArraysKt.toMutableList(r100.getFilters());
        r101.add(this);
        CollectionsKt.removeAll(r101, EditorLinkApplier$attach$1.INSTANCE);
        r100.setFilters((InputFilter[]) r101.toArray(new InputFilter[0]));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EditorLinkApplier(Function1<? super n, ? extends CharSequence> r100, List<? extends b> r101) {
        Intrinsics.checkNotNullParameter(r100, "linkParser");
        Intrinsics.checkNotNullParameter(r101, "regexResolvers");
        this.f429188a = r100;
        this.f429189b = r101;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r110, int r111, int r112, Spanned r210, int r211, int r212) {
        Intrinsics.checkNotNullParameter(r110, "source");
        if (r110.length() >= 10) goto L5;
        return r110;
    L5:
        long r100 = System.currentTimeMillis();
        ArrayList r101 = new ArrayList();
        boolean r102 = r110 instanceof Spanned;
        if (r102 == true) goto L8;
        r101.add(new IntRange(r111, r112));
    L18:
        if (r101.isEmpty() == false) goto L20;
        return r110;
    L20:
        ArrayList r113 = new ArrayList();
        Iterator r103 = r101.iterator();
    L22:
        if (r103.hasNext() == false) goto L30;
        IntRange r104 = (IntRange) r103.next();
        int r114 = r104.getFirst();
        int r105 = r104.getLast();
        Iterator<T> r115 = this.f429189b.iterator();
    L25:
        if (r115.hasNext() == false) goto L22;
        List<b.a> r116 = ((b) r115.next()).a(r114, r105, r110);
        if (r116.isEmpty() == true) goto L25;
        r113.addAll(r116);
        goto L22
    L30:
        if (r113.isEmpty() == false) goto L32;
        return r110;
    L32:
        SpannableStringBuilder r117 = new SpannableStringBuilder(r110, r111, r112);
        if (r102 == false) goto L35;
        TextUtils.copySpansFrom(r117, r111, r112, NoCopySpan.class, r117, 0);
    L35:
        Iterator r106 = r113.iterator();
        int r107 = 0;
    L37:
        if (r106.hasNext() == false) goto L47;
        b.a r108 = (b.a) r106.next();
        int r109 = r108.f429192b + r107;
        int r118 = r108.f429193c + r107;
        CharSequence r119 = this.f429188a.invoke(r108.f429191a);
        if (r109 < 0) goto L42;
        if (r109 >= r118) goto L42;
        boolean r120 = true;
    L43:
        if (r120 == false) goto L37;
        if (r118 > r117.length()) goto L37;
        r117.replace(r109, r118, r119);
        r107 = r107 + (r119.length() - (r118 - r109));
    L42:
        r120 = false;
        goto L43
    L47:
        Log.i("EditorLinkApplier", "regex find url count " + r113.size() + ", cost: " + (System.currentTimeMillis() - r100));
        return r117;
    L8:
        int r121 = r111;
    L9:
        if (r121 >= r112) goto L18;
        Spanned r122 = (Spanned) r110;
        int r123 = r122.nextSpanTransition(r121, r112, f.class);
        if (((f[]) r122.getSpans(r121, r123, f.class)).length != 0) goto L13;
        boolean r124 = true;
    L14:
        if (r124 == false) goto L16;
        r101.add(new IntRange(r121, r123));
    L16:
        r121 = r123;
        goto L9
    L13:
        r124 = false;
        goto L14
    }
}
