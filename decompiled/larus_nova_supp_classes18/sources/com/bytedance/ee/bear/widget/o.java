package com.bytedance.ee.bear.widget;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import com.larksuite.component.universe_design.edittext.UDEditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o implements Drawable.Callback {
    public final /* synthetic */ SpannableStringBuilder a;
    public final /* synthetic */ bo4.a b;
    public final /* synthetic */ l c;

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r1, Runnable r2, long r3) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r1, Runnable r2) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r4) {
        tt5.a.b("DocEditTextPresenter", "invalidateDrawable");
        UDEditText r5 = this.c.f;
        final SpannableStringBuilder r0 = this.a;
        final bo4.a r1 = this.b;
        r5.post(new n(this, r0, r1));
    }

    public o(l r1, SpannableStringBuilder r2, bo4.a r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
