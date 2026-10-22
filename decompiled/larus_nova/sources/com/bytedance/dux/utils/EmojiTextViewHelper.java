package com.bytedance.dux.utils;

import android.text.InputFilter;
import android.widget.TextView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class EmojiTextViewHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f205849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f205850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f205851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f205852d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f205853e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f205854f;

    public final EmojiTextViewHelper$emojiInputFilter$2.a a() {
        return (EmojiTextViewHelper$emojiInputFilter$2.a) this.f205854f.getValue();
    }

    public EmojiTextViewHelper(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        this.f205849a = r100;
        this.f205850b = true;
        this.f205851c = LazyKt.lazy(EmojiTextViewHelper$emojiService$2.INSTANCE);
        this.f205852d = LazyKt.lazy(new EmojiTextViewHelper$enableParseEmojiSwitch$2(this));
        this.f205854f = LazyKt.lazy(new EmojiTextViewHelper$emojiInputFilter$2(this));
    }

    public final InputFilter[] b(InputFilter[] r100) {
        if (r100 != null) goto L4;
        return r100;
    L4:
        if (((Boolean) this.f205852d.getValue()).booleanValue() == false) goto L41;
        int r101 = 0;
        if (this.f205850b == false) goto L15;
        int r102 = r100.length;
        if (ArraysKt.contains(r100, a()) == true) goto L42;
        int r103 = r102 + 1;
        InputFilter[] r104 = new InputFilter[r103];
        int r105 = 0;
    L12:
        if (r105 >= r103) goto L14;
        r104[r105] = a();
        r105 = r105 + 1;
        goto L12
    L14:
        System.arraycopy(r100, 0, r104, 0, r102);
        return r104;
    L42:
        return r100;
    L15:
        int r106 = r100.length;
        if (r100.length != 0) goto L18;
        boolean r107 = true;
    L19:
        if (r107 == false) goto L21;
        return r100;
    L21:
        if (ArraysKt.contains(r100, a()) == false) goto L43;
        int r108 = r106 - 1;
        InputFilter[] r109 = new InputFilter[r108];
        int r110 = 0;
    L24:
        if (r110 >= r108) goto L26;
        r109[r110] = a();
        r110 = r110 + 1;
    L26:
        if (r101 >= r108) goto L32;
        if (Intrinsics.areEqual(r100[r101], a()) == true) goto L30;
        r109[r101] = r100[r101];
    L30:
        r101 = r101 + 1;
        goto L26
    L32:
        return r109;
    L43:
        return r100;
    L18:
        r107 = false;
        goto L19
    L41:
        return r100;
    }

    public final void c(boolean r100) {
        this.f205850b = r100;
        TextView r101 = this.f205849a;
        r101.setFilters(b(r101.getFilters()));
    }
}
