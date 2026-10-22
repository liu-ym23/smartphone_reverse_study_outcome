package com.ss.android.lark.widget.light.span;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class n extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f446277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<Context> f446278b;

    public final int hashCode() {
        return this.f446277a.hashCode();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f446277a, ((n) r100).f446277a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        if ((r100 instanceof mcc.m) == true) goto L6;
        return;
    L6:
        if (r100.getTag(R.id.tag_long_press) == null) goto L8;
        r100.setTag(R.id.tag_long_press, null);
        ((mcc.l) r100).b(r100, this.f446277a);
        return;
    L8:
        ((mcc.l) r100).a(r100, this.f446277a);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        super.updateDrawState(r100);
        Context r101 = this.f446278b.get();
        if (r101 == null) goto L5;
        int r102 = UIUtils.getColor(r101, R.color.text_link_normal);
    L6:
        r100.setColor(r102);
        r100.setUnderlineText(false);
        return;
    L5:
        r102 = UIHelper.getColor(R.color.text_link_normal);
        goto L6
    }

    public n(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "mPhoneNum");
        this.f446277a = r101;
        this.f446278b = new WeakReference(r100);
    }
}
