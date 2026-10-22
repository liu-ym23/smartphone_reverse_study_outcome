package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.model.ECUrlModel;
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
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/window/shop/widget/WindowHeadBubbleDoubleCard;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "title", "b", "getSubTitle", "setSubTitle", "subTitle", "Lcom/facebook/drawee/view/SimpleDraweeView;", "c", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getEntrance", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "setEntrance", "(Lcom/facebook/drawee/view/SimpleDraweeView;)V", "entrance", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHeadBubbleDoubleCard extends ConstraintLayout {
    public TextView a;
    public TextView b;
    public SimpleDraweeView c;
    public SimpleDraweeView d;
    public SimpleDraweeView e;
    public View f;

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

    public final SimpleDraweeView getEntrance() {
        SimpleDraweeView r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("entrance");
    L5:
        return r0;
    }

    public final TextView getSubTitle() {
        TextView r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("subTitle");
    L5:
        return r0;
    }

    public final TextView getTitle() {
        TextView r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("title");
    L5:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onFinishInflate() {
        super/*android.view.ViewGroup*/.onFinishInflate();
        this.a = (TextView) findViewById(2131371287);
        this.b = (TextView) findViewById(2131371285);
        this.c = findViewById(2131371276);
        this.d = findViewById(2131371282);
        this.e = findViewById(2131371284);
        this.f = findViewById(2131371278);
    }

    public final void setEntrance(SimpleDraweeView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void setSubTitle(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void setTitle(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public WindowHeadBubbleDoubleCard(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(uq3.e r22, Function1<? super String, Unit> r23, Function2<? super String, ? super String, Unit> r24, Function4<? super View, ? super uq3.e, ? super Integer, ? super Function0<Unit>, Unit> r25, int r26) {
        Intrinsics.checkNotNullParameter(r22, "bubbleVO");
        TextView r3 = this.a;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("title");
    L5:
        r3.setText(r22.a);
        TextView r4 = this.b;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("subTitle");
    L8:
        r4.setText(r22.d);
        Integer r5 = r22.f;
        if (r5 == null) goto L11;
        String r6 = String.valueOf(r5.intValue());
    L12:
        Unit r7 = (Unit) r24.invoke("bubble_show", r6);
        setOnClickListener(new a(r23, r22, r24));
        SimpleDraweeView r8 = this.d;
        if (r8 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("productOne");
    L15:
        List<? extends ECUrlModel> r2 = r22.c;
        if (r2 == null) goto L18;
        ECUrlModel r9 = (ECUrlModel) CollectionsKt.getOrNull(r2, 0);
    L19:
        h0.d(r8, r9, null, null, null, null, null, 120);
        SimpleDraweeView r13 = this.e;
        if (r13 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("productTwo");
    L22:
        List<? extends ECUrlModel> r10 = r22.c;
        if (r10 == null) goto L25;
        ECUrlModel r14 = (ECUrlModel) CollectionsKt.getOrNull(r10, 1);
    L26:
        h0.d(r13, r14, null, null, null, null, null, 120);
        Unit r1 = (Unit) r25.invoke(this, r22, Integer.valueOf(r26), null);
        return;
    L25:
        r14 = null;
        goto L26
    L18:
        r9 = null;
        goto L19
    L11:
        r6 = null;
        goto L12
    }
}
