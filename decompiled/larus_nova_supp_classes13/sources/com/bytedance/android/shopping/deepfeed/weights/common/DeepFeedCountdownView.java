package com.bytedance.android.shopping.deepfeed.weights.common;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/common/DeepFeedCountdownView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "endTimeMs", "", "setEndTimestamp", "Lkotlin/Function0;", "listener", "setOnCountdownEndListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedCountdownView extends AppCompatTextView {
    public static final /* synthetic */ int h = 0;
    public long a;
    public boolean b;
    public Function0<Unit> c;
    public Job d;
    public String e;
    public String f;
    public String g;

    public DeepFeedCountdownView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DeepFeedCountdownView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void x() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.TextView*/.onAttachedToWindow();
        if (this.b == false) goto L5;
        return;
    L5:
        if (this.a <= System.currentTimeMillis()) goto L9;
        x();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.TextView*/.onDetachedFromWindow();
        this.b = false;
        Job r1 = this.d;
        if (r1 == null) goto L5;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L5:
        this.d = null;
        this.b = false;
    }

    public final void setEndTimestamp(long r4) {
        this.a = r4;
        long r5 = System.currentTimeMillis();
        long r0 = this.a;
        if (r0 <= r5) goto L5;
        long r1 = r0 - r5;
    L6:
        y(r1);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public final void setOnCountdownEndListener(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.c = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y(long r7) {
        if (r7 > 0) goto L6;
        setText(this.e + this.g);
        return;
    L6:
        long r8 = r7 / ((long) 1000);
        long r0 = 3600;
        int r3 = (int) (r8 / r0);
        long r4 = 60;
        int r1 = (int) ((r8 % r0) / r4);
        int r9 = (int) (r8 % r4);
        StringCompanionObject r10 = StringCompanionObject.INSTANCE;     // Catch: Exception -> L9
        setText(String.format("%s%02d:%02d:%02d", Arrays.copyOf(new Object[]{this.e + this.f, Integer.valueOf(r3), Integer.valueOf(r1), Integer.valueOf(r9)}, 4)));     // Catch: Exception -> L9
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeepFeedCountdownView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.e = "";
        this.f = "";
        this.g = "已失效";
        setGravity(17);
    }

    public /* synthetic */ DeepFeedCountdownView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
