package com.ss.android.lark.widget.light.span;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.span.AtUserGroupInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtUserGroupInfo f446235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f446236b;

    public static final class a {
    }

    static {
    }

    public final int hashCode() {
        return (this.f446235a.hashCode() * 31) + this.f446236b;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(c.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.widget.light.span.AtUserGroupClickSpan");
        c r102 = (c) r100;
        if (Intrinsics.areEqual(this.f446235a, r102.f446235a) == true) goto L16;
        return false;
    L16:
        if (this.f446236b == r102.f446236b) goto L18;
        return false;
    L18:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        if ((r100 instanceof mcc.c) == true) goto L5;
        return;
    L5:
        Log.d("AtUserGroupClickSpan", "onClick: " + this.f446235a.getUserGroupId() + ' ' + this.f446235a.getPermissionStatus());
        ((mcc.c) r100).i(r100, this.f446235a);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        super.updateDrawState(r100);
        r100.setColor(this.f446236b);
        r100.setUnderlineText(false);
    }

    public c(AtUserGroupInfo r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "atUserGroupInfo");
        this.f446235a = r100;
        this.f446236b = r101;
    }
}
