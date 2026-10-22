package com.bytedance.ee.bear.middleground.permission.escape;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeApprovalInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h extends ClickableSpan {
    public final /* synthetic */ FragmentActivity a;
    public final /* synthetic */ EscapeApprovalInfo b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        int r3 = EscapeApprovalListFragment.j;
        EscapeApprovalListFragment.b.a(this.a, this.b);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        Intrinsics.checkNotNullParameter(r3, "ds");
        super.updateDrawState(r3);
        r3.setColor(ContextCompat.getColor(this.a, 2131108626));
        r3.setUnderlineText(false);
    }

    public h(FragmentActivity r1, EscapeApprovalInfo r2) {
        this.a = r1;
        this.b = r2;
    }
}
