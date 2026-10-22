package com.bytedance.ee.bear.middleground.permission.secret;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f234102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f234103b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Function0<Unit> r101 = this.f234102a;
        if (r101 == null) goto L6;
        r101.invoke();
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        super.updateDrawState(r100);
        r100.setColor(ContextCompat.getColor(this.f234103b, R.color.ud_B600));
        r100.setUnderlineText(false);
    }

    public h(Function0<Unit> r100, FragmentActivity r101) {
        this.f234102a = r100;
        this.f234103b = r101;
    }
}
