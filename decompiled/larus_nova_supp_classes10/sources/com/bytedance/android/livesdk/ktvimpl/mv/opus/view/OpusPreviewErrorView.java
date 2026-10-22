package com.bytedance.android.livesdk.ktvimpl.mv.opus.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.ktv.common.view.CommomKtvButton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010R*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/mv/opus/view/OpusPreviewErrorView;", "Landroid/widget/FrameLayout;", "Lkotlin/Function0;", "", "a", "Lkotlin/jvm/functions/Function0;", "getRetryCallback", "()Lkotlin/jvm/functions/Function0;", "setRetryCallback", "(Lkotlin/jvm/functions/Function0;)V", "retryCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class OpusPreviewErrorView extends FrameLayout {
    public Function0<Unit> a;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ OpusPreviewErrorView a;

        public a(OpusPreviewErrorView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.getRetryCallback();
            if (r2 == null) goto L6;
            Unit r3 = (Unit) r2.invoke();
            return;
        }
    }

    public final Function0<Unit> getRetryCallback() {
        return this.a;
    }

    public final void setRetryCallback(Function0<Unit> r1) {
        this.a = r1;
    }

    public OpusPreviewErrorView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        LayoutInflater.from(r2).inflate(2131563349, this);
        setBackgroundColor(-1);
        CommomKtvButton r4 = findViewById(2131384465);
        if (r4 == null) goto L6;
        r4.setTextColor(-16777216);
        r4.setBackgroundResource(2131249193);
        r4.setOnClickListener(new a(this));
        return;
    }
}
