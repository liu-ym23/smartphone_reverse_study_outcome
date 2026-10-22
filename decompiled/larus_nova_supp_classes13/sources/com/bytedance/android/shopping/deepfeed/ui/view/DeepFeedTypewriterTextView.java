package com.bytedance.android.shopping.deepfeed.ui.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/view/DeepFeedTypewriterTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedTypewriterTextView extends AppCompatTextView {
    public Job a;
    public String b;

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.TextView*/.onDetachedFromWindow();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
        if (this.b.length() != 0) goto L6;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L9;
        setText(this.b);     // Catch: Throwable -> L14
    L9:
        Job r2 = this.a;     // Catch: Throwable -> L14
        Unit r3 = null;
        if (r2 == null) goto L12;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);     // Catch: Throwable -> L14
        r3 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L12:
        Result.constructor-impl(r3);     // Catch: Throwable -> L14
        return;
    L6:
        r1 = false;
    L14:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public DeepFeedTypewriterTextView(Context r2) {
        this(r2, null);
    }

    public DeepFeedTypewriterTextView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void y(DeepFeedTypewriterTextView r17, String r18, String r19, String r20, Function0 r21) {
        r17.getClass();
        Intrinsics.checkNotNullParameter(r18, "prefix");
        Intrinsics.checkNotNullParameter(r19, "boldContent");
        Intrinsics.checkNotNullParameter(r20, "suffix");
        Intrinsics.checkNotNullParameter("|", "cursor");
        Job r3 = r17.a;
        if (r3 == null) goto L5;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L5:
        r17.setText("");
        String r2 = r18 + r19 + r20;
        r17.b = r2;
        r17.a = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new DeepFeedTypewriterTextView$startTypewriter$1(r17, r2, r18.length(), r18.length() + r19.length(), "|", 60, r21, null), 3, null);
    }

    public static final SpannableStringBuilder x(DeepFeedTypewriterTextView r2, String r3, int r4, int r5, String r6, boolean r7) {
        r2.getClass();
        SpannableStringBuilder r8 = new SpannableStringBuilder(r3);
        int r9 = RangesKt.coerceAtMost(r4, r3.length());
        int r10 = RangesKt.coerceAtMost(r5, r3.length());
        if (r10 <= r9) goto L5;
        r8.setSpan(new z6a.j(-1), r9, r10, 33);
    L5:
        if (r7 == false) goto L7;
        int r11 = r8.length();
        r8.append(r6);
        r8.setSpan(new z6a.j(-1), r11, r8.length(), 33);
    L7:
        return r8;
    }
}
