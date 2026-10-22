package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006 "}, d2 = {"Lcom/bytedance/android/window/shop/widget/WindowHeadBubbleBaseCard;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "getSubTitle", "()Landroid/widget/TextView;", "setSubTitle", "(Landroid/widget/TextView;)V", "subTitle", "Lcom/facebook/drawee/view/SimpleDraweeView;", "b", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getCover", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "setCover", "(Lcom/facebook/drawee/view/SimpleDraweeView;)V", "cover", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "c", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "getIcon", "()Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "setIcon", "(Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;)V", "icon", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHeadBubbleBaseCard extends ConstraintLayout {
    public TextView a;
    public SimpleDraweeView b;
    public ECDraweeView c;
    public View d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ uq3.e b;
        public final /* synthetic */ Function2 c;

        public a(Function1 r1, uq3.e r2, Function2 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            Function1 r4 = this.a;
            if (r4 == null) goto L5;
            Unit r5 = (Unit) r4.invoke(this.b.e);
        L5:
            Function2 r6 = this.c;
            if (r6 == null) goto L13;
            Integer r0 = this.b.f;
            if (r0 == null) goto L10;
            String r1 = String.valueOf(r0.intValue());
        L11:
            Unit r7 = (Unit) r6.invoke("bubble_click", r1);
            return;
        L10:
            r1 = null;
            goto L11
        }
    }

    public final SimpleDraweeView getCover() {
        SimpleDraweeView r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cover");
    L5:
        return r0;
    }

    public final ECDraweeView getIcon() {
        ECDraweeView r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("icon");
    L5:
        return r0;
    }

    public final TextView getSubTitle() {
        TextView r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("subTitle");
    L5:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onFinishInflate() {
        super/*android.view.ViewGroup*/.onFinishInflate();
        this.c = (ECDraweeView) findViewById(2131371277);
        this.a = (TextView) findViewById(2131371285);
        this.b = findViewById(2131371275);
        this.d = findViewById(2131371278);
    }

    public final void setCover(SimpleDraweeView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void setIcon(ECDraweeView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void setSubTitle(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public WindowHeadBubbleBaseCard(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(uq3.e r23, Function1<? super String, Unit> r24, Function2<? super String, ? super String, Unit> r25, Function4<? super View, ? super uq3.e, ? super Integer, ? super Function0<Unit>, Unit> r26, int r27) {
        Intrinsics.checkNotNullParameter(r23, "bubbleVO");
        TextView r4 = this.a;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("subTitle");
    L5:
        r4.setText(r23.d);
        ECDraweeView r6 = this.c;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("icon");
    L8:
        h0.d(r6, r23.b, null, null, null, null, null, 120);
        SimpleDraweeView r14 = this.b;
        if (r14 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("cover");
    L11:
        List<? extends ECUrlModel> r5 = r23.c;
        if (r5 == null) goto L14;
        ECUrlModel r15 = (ECUrlModel) CollectionsKt.getOrNull(r5, 0);
    L15:
        h0.d(r14, r15, null, null, null, null, null, 120);
        if (r25 == null) goto L22;
        Integer r7 = r23.f;
        if (r7 == null) goto L20;
        String r8 = String.valueOf(r7.intValue());
    L21:
        Unit r9 = (Unit) r25.invoke("bubble_show", r8);
        goto L22
    L20:
        r8 = null;
    L22:
        setOnClickListener(new a(r24, r23, r25));
        if (r26 == null) goto L26;
        Unit r1 = (Unit) r26.invoke(this, r23, Integer.valueOf(r27), null);
        return;
    L26:
        return;
    L14:
        r15 = null;
        goto L15
    }
}
