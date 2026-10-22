package com.ss.android.lark.widget.light.span;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class i extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f446243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f446244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f446245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f446246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f446247e;

    public final int hashCode() {
        int r100 = ((this.f446244b.hashCode() * 31) + this.f446245c.hashCode()) * 31;
        if (this.f446246d == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        String r103 = this.f446247e;
        if (r103 == null) goto L9;
        int r104 = r103.hashCode();
    L11:
        return r102 + r104;
    L9:
        r104 = 0;
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f446244b, r101.f446244b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f446245c, r101.f446245c) == true) goto L15;
        return false;
    L15:
        if (this.f446246d == r101.f446246d) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f446247e, r101.f446247e) == true) goto L20;
        return false;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.style.ClickableSpan
    public final void onClick(View r110) {
        Intrinsics.checkNotNullParameter(r110, "widget");
        if ((r110 instanceof mcc.m) == true) goto L6;
        return;
    L6:
        if (r110.getTag(R.id.tag_long_press) == null) goto L8;
        r110.setTag(R.id.tag_long_press, null);
        ((mcc.i) r110).o(r110, this.f446244b, this.f446245c, this.f446246d);
        return;
    L8:
        ((mcc.i) r110).p(r110, this.f446244b, this.f446245c, this.f446246d, this.f446247e);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        super.updateDrawState(r100);
        if (this.f446246d == false) goto L5;
        r100.setColor(UIUtils.getColor(this.f446243a, R.color.text_link_hover));
    L6:
        r100.setUnderlineText(false);
        return;
    L5:
        r100.setColor(UIUtils.getColor(this.f446243a, R.color.ud_N650));
        goto L6
    }

    public i(Context r100, String r101, String r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r102, "name");
        this.f446243a = r100;
        this.f446244b = r101;
        this.f446245c = r102;
        this.f446246d = r103;
        this.f446247e = r104;
    }
}
