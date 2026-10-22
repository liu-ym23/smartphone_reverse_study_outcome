package com.larus.bmhome.chat.markdown.richtext;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import android.widget.TextView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import com.larus.bmhome.chat.referenceicon.MessageReferenceIconStore;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes25.dex */
public final class d extends ReplacementSpan implements tsc.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f307182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f307183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f307184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f307185d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f307186e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RoundedBitmapDrawable f307187f;

    @Override // tsc.o
    public final void f(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        Object r101 = r100.getTag(R.id.larus_mention_avatar_binding);
        if ((r101 instanceof AvatarBinding) == false) goto L5;
        AvatarBinding r102 = (AvatarBinding) r101;
    L6:
        if (r102 == null) goto L8;
        r102.a();
        r100.removeOnAttachStateChangeListener(r102);
    L8:
        r100.setTag(R.id.larus_mention_avatar_binding, null);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public d(Resources r100, p r101) {
        Intrinsics.checkNotNullParameter(r100, "resources");
        Intrinsics.checkNotNullParameter(r101, "avatar");
        this.f307182a = r100;
        this.f307183b = r101;
        this.f307184c = c7.b(18);
        this.f307185d = c7.b(4);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Intrinsics.checkNotNullParameter(r101, "text");
        if (r104 == null) goto L5;
        r100.getFontMetricsInt(r104);
    L5:
        int r105 = this.f307184c + this.f307185d;
        if (r102 >= r103) goto L11;
        if (r101.charAt(r102) != '@') goto L11;
        r102 = r102 + 1;
    L11:
        return r105 + ((int) r100.measureText(r101, r102, r103));
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r110, CharSequence r111, int r112, int r113, float r114, int r115, int r210, int r211, Paint r212) {
        int r100 = r112;
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r111, "text");
        Intrinsics.checkNotNullParameter(r212, "paint");
        RoundedBitmapDrawable r101 = this.f307187f;
        String r102 = this.f307186e;
        if (r102 == null) goto L7;
        p r116 = this.f307183b;
        r116.getClass();
        MessageReferenceIconStore r117 = MessageReferenceIconStore.f308518a;
        if (Intrinsics.areEqual(r102, MessageReferenceIconStore.a(r116.f307229a, r116.f307230b, r116.f307231c)) == false) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L13;
        r110.save();
        r110.translate(r114, r210 + (((r212.getFontMetrics().ascent + r212.getFontMetrics().descent) - this.f307184c) / 2.0f));
        int r104 = this.f307184c;
        r101.setBounds(0, 0, r104, r104);
        r101.draw(r110);
        r110.restore();
    L15:
        if (r100 < r113) goto L17;
    L19:
        r110.drawText(r111, r100, r113, this.f307185d + (this.f307184c + r114), r210, r212);
        return;
    L17:
        if (r111.charAt(r112) != '@') goto L19;
        r100 = r100 + 1;
        goto L19
    L13:
        r110.drawText("@", r114, r210, r212);
    L7:
        r103 = false;
        goto L8
    }
}
