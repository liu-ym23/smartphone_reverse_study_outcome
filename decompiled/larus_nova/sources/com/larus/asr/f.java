package com.larus.asr;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.widget.EditText;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f287265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r19.b f287266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f287267c;

    public static final class a {
    }

    static {
    }

    public f() {
    }

    public final void a(EditText r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        FLogger.f375446a.i("AsrLoadingHelper", "[dismissLoading]");
        this.f287265a = false;
        ValueAnimator r101 = this.f287267c;
        if (r101 == null) goto L7;
        r101.cancel();
    L7:
        this.f287267c = null;
        Editable r102 = r100.getText();
        if ((r102 instanceof Spannable) == true) goto L11;
        r102 = null;
    L11:
        if (r102 == null) goto L15;
        r19.b r103 = this.f287266b;
        if (r103 == null) goto L15;
        r102.removeSpan(r103);
    L15:
        Editable r104 = r100.getText();
        if (r104 != null) goto L18;
    L20:
        this.f287266b = null;
        return;
    L18:
        if (StringsKt.endsWith$default(r104, " ", false, 2, null) == false) goto L20;
        r104.delete(r104.length() - 1, r104.length());
        goto L20
    }

    public final void b(final EditText r100, int r101, String r110) {
        Intrinsics.checkNotNullParameter(r110, "currentText");
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f287265a == false) goto L8;
        return;
    L8:
        Context r102 = r100.getContext();
        if (r102 != null) goto L11;
        return;
    L11:
        this.f287265a = true;
        FLogger.f375446a.i("AsrLoadingHelper", "[showLoading] currentText=" + g2a.d.b(r110));
        String r111 = r110.concat(" ");
        this.f287266b = new r19.b(r101, r102);
        SpannableString r103 = new SpannableString(r111);
        Integer r104 = null;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L18
        r19.b r106 = this.f287266b;     // Catch: Throwable -> L18
        if (r106 == null) goto L15;
        r103.setSpan(r106, RangesKt.coerceAtLeast(r103.length() - 1, 0), r103.length(), 17);     // Catch: Throwable -> L18
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L18
    L16:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L18
    L20:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L23;
        FLogger.f375446a.e("AsrLoadingHelper", "renderTextWithLoading error " + r109.getMessage() + " currentText=" + r111, r109);
    L23:
        r100.setText(r103);
        ValueAnimator r112 = ValueAnimator.ofInt(new int[]{0, 255});
        r112.setDuration(400);
        r112.setRepeatCount(-1);
        r112.setRepeatMode(2);
        r112.addUpdateListener(new e(this, r100));
        FLogger r113 = FLogger.f375446a;
        StringBuilder r114 = new StringBuilder("textLen=");
        Editable r115 = r100.getText();
        if (r115 == null) goto L26;
        r104 = Integer.valueOf(r115.length());
    L26:
        r114.append(r104);
        r113.i("AsrLoadingHelper", r114.toString());
        r112.start();
        this.f287267c = r112;
        return;
    L15:
        r107 = null;
    L18:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    }
}
