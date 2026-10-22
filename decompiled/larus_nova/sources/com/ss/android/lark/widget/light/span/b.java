package com.ss.android.lark.widget.light.span;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f446232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f446233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f446234c;

    public final int hashCode() {
        return (((this.f446232a.hashCode() * 31) + this.f446233b.hashCode()) * 31) + this.f446234c;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f446232a, r101.f446232a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f446233b, r101.f446233b) == true) goto L15;
        return false;
    L15:
        if (this.f446234c == r101.f446234c) goto L17;
        return false;
    L17:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        if ((r100 instanceof mcc.m) == true) goto L6;
        return;
    L6:
        if (r100.getTag(R.id.tag_long_press) == null) goto L10;
        r100.setTag(R.id.tag_long_press, null);
        if (((mcc.b) r100).c(r100, this.f446232a, this.f446233b) == false) goto L12;
        r100.performHapticFeedback(0);
        return;
    L12:
        return;
    L10:
        ((mcc.b) r100).d(r100, this.f446232a, this.f446233b);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        super.updateDrawState(r100);
        r100.setColor(this.f446234c);
        r100.setUnderlineText(false);
    }

    public b(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "mUserName");
        Intrinsics.checkNotNullParameter(r101, "mUserId");
        this.f446232a = r100;
        this.f446233b = r101;
        this.f446234c = r102;
    }
}
