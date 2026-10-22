package com.obric.assistant.cocreationreview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f387226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CardTemplateTagTone f387227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f387228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f387229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<Context, Drawable> f387230e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f387226a, r101.f387226a) == true) goto L12;
        return false;
    L12:
        if (this.f387227b == r101.f387227b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f387228c, r101.f387228c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f387229d, r101.f387229d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f387230e, r101.f387230e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f387226a.hashCode() * 31) + this.f387227b.hashCode()) * 31;
        Integer r101 = this.f387228c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.f387229d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Function1<Context, Drawable> r108 = this.f387230e;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CardTemplateTag(text=" + this.f387226a + ", tone=" + this.f387227b + ", accentColor=" + this.f387228c + ", iconRes=" + this.f387229d + ", iconDrawableProvider=" + this.f387230e + ')';
    }

    public /* synthetic */ d(String r100, CardTemplateTagTone r101, Integer r102, Integer r110, int r111) {
        if ((r111 & 2) == 0) goto L5;
        r101 = CardTemplateTagTone.NEUTRAL;
    L5:
        CardTemplateTagTone r103 = r101;
        if ((r111 & 4) == 0) goto L8;
        Integer r104 = null;
    L10:
        if ((r111 & 8) == 0) goto L12;
        Integer r105 = null;
    L13:
        this(r100, r103, r104, r105, null);
        return;
    L12:
        r105 = r110;
        goto L13
    L8:
        r104 = r102;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(String r100, CardTemplateTagTone r101, Integer r102, Integer r103, Function1<? super Context, ? extends Drawable> r104) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "tone");
        this.f387226a = r100;
        this.f387227b = r101;
        this.f387228c = r102;
        this.f387229d = r103;
        this.f387230e = r104;
    }
}
