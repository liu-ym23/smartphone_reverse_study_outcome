package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.content.Context;
import android.text.TextPaint;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0014\u0010\u0006\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0006\u0010\b\u001a\u00020\u0007R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0019\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/info/widget/ECNewCountDownView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lq83/a;", "Lkotlin/Function0;", "", "finishAction", "setOnCountFinishCallback", "", "getViewWidth", "Lcom/bytedance/android/ec/model/response/k;", "a", "Lcom/bytedance/android/ec/model/response/k;", "getCountDown", "()Lcom/bytedance/android/ec/model/response/k;", "setCountDown", "(Lcom/bytedance/android/ec/model/response/k;)V", "countDown", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "b", "Ljava/lang/StringBuilder;", "getStringBuilder", "()Ljava/lang/StringBuilder;", "setStringBuilder", "(Ljava/lang/StringBuilder;)V", "stringBuilder", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECNewCountDownView extends AppCompatTextView implements q83.a {
    public com.bytedance.android.ec.model.response.k a;
    public StringBuilder b;
    public Function0<Unit> c;
    public final long d;

    /* JADX WARN: Multi-variable type inference failed */
    public final float getViewWidth() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        TextPaint r1 = getPaint();     // Catch: Throwable -> L9
        CharSequence r2 = getText();     // Catch: Throwable -> L9
        if (r2 == null) goto L6;
        String r3 = r2.toString();     // Catch: Throwable -> L9
        if (r3 == null) goto L6;
    L7:
        Object r4 = Result.constructor-impl(Float.valueOf(r1.measureText(r3)));     // Catch: Throwable -> L9
    L11:
        Float r5 = Float.valueOf(0.0f);
        if (Result.isFailure-impl(r4) == false) goto L15;
        r4 = r5;
    L15:
        return ((Number) r4).floatValue();
    L6:
        r3 = "";
    L9:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final com.bytedance.android.ec.model.response.k getCountDown() {
        return this.a;
    }

    public final StringBuilder getStringBuilder() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTick(long r13) {
        com.bytedance.android.ec.model.response.k r0 = this.a;
        if (r0 == null) goto L25;
        long r2 = this.d;
        if (r13 >= r2) goto L22;
        long r3 = r2 - r13;
        String r14 = r0.b();
        String r15 = "";
        if (r14 != null) goto L9;
        r14 = "";
    L9:
        String r1 = r0.d();
        if (r1 == null) goto L13;
        r15 = r1;
    L13:
        StringBuilder r4 = this.b;
        Intrinsics.checkNotNullParameter(r14, "prefix");
        Intrinsics.checkNotNullParameter(r15, "suffix");
        double r5 = r3;
        if (r5 <= 0) goto L16;
        int r6 = (int) (r5 / ((double) 3600000));
        double r7 = r5 - ((double) (3600000 * r6));
        int r8 = (int) (r7 / ((double) 60000));
        int r9 = (int) ((r7 - ((double) (60000 * r8))) / ((double) 1000));
    L17:
        String r10 = getContext().getString(2131896692, new Object[]{Integer.valueOf(r6)});
        String r11 = getContext().getString(2131896692, new Object[]{Integer.valueOf(r8)});
        String r12 = getContext().getString(2131896692, new Object[]{Integer.valueOf(r9)});
        if (r4 == null) goto L20;
        r4.append(r6 + " 小时，" + r8 + " 分钟，" + r9 + " 秒");
    L20:
        setText(r14 + r10 + ':' + r11 + ':' + r12 + r15);
        return true;
    L16:
        r9 = 0;
        r6 = 0;
        r8 = 0;
        goto L17
    L22:
        Function0<Unit> r16 = this.c;
        if (r16 == null) goto L25;
        Unit r17 = (Unit) r16.invoke();
    L25:
        return false;
    }

    public final void setCountDown(com.bytedance.android.ec.model.response.k r1) {
        this.a = r1;
    }

    public final void setOnCountFinishCallback(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "finishAction");
        this.c = r2;
    }

    public final void setStringBuilder(StringBuilder r1) {
        this.b = r1;
    }

    public ECNewCountDownView(Context r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, null, 0);
        this.d = r4;
    }
}
