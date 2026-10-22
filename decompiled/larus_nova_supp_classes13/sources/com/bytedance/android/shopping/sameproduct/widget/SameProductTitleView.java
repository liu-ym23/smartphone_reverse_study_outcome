package com.bytedance.android.shopping.sameproduct.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.utils.w0;
import com.bytedance.android.shopping.sameproduct.model.ECCommissionDialogInfo;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import jj4.a;
import jj4.b;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import ld3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/sameproduct/widget/SameProductTitleView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SameProductTitleView extends FrameLayout implements View.OnClickListener {
    public final TextView a;
    public final View b;

    public SameProductTitleView(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [android.app.Dialog, com.bytedance.android.shopping.sameproduct.widget.ECCommissionDialog, java.lang.Object] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        if (r5 != null) goto L4;
    L5:
        if (r5 != null) goto L7;
        return;
    L7:
        if (r5.getId() != 2131370643) goto L57;
    L8:
        ?? r6 = new ECCommissionDialog(getContext());
        int r0 = f.a;
        int r1 = f.a.a;
        int r2 = w0.a;
        Object r3 = (ECCommissionDialogInfo) w0.b("{\"title\":\"分佣说明\",\"content\":\"查看同款商品能力旨在促进用户成交，推荐的商品以联盟商品为主，并且靠前排序，成交后会同样给视频作者分佣。\",\"button_text\":\"我知道了\"}", ECCommissionDialogInfo.class);
        if (r3 == null) goto L23;
        int r4 = p.a;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L15
        b r8 = b.b;     // Catch: Throwable -> L15
        Object r9 = a.a("same_product_commission_dialog_content", ECCommissionDialogInfo.class, r3, false);     // Catch: Throwable -> L15
        if (r9 != null) goto L21;
        Intrinsics.throwNpe();     // Catch: Throwable -> L15
    L21:
        ECCommissionDialogInfo r10 = (ECCommissionDialogInfo) r9;
        if (r10 == null) goto L23;
    L33:
        if (r10 == null) goto L58;
        TextView r11 = r6.a;
        if (r11 == null) goto L37;
        r11.setText(r10.getTitle());
    L37:
        TextView r12 = r6.b;
        if (r12 == null) goto L40;
        r12.setText(r10.getContent());
    L40:
        TextView r13 = r6.c;
        if (r13 == null) goto L44;
        r13.setText(r10.getButtonText());
    L44:
        if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L52;
        DialogLancet.handleBlockedDialogShow(r6);
        return;
    L52:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L49
    L47:
        DialogLancet.beforeDialogShow(r6);
        r6.show();
        DialogLancet.afterDialogShow(r6);
        return;
    L58:
        return;
    L15:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Object r15 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r15) == true) goto L20;
        r3 = r15;
    L20:
        r9 = r3;
    L23:
        int r16 = p.a;
        Object r17 = null;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L26
        b r19 = b.b;     // Catch: Throwable -> L26
        Object r20 = a.a(" same_product_commission_dialog_content", ECCommissionDialogInfo.class, null, false);     // Catch: Throwable -> L26
    L32:
        r10 = (ECCommissionDialogInfo) r20;
    L26:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r22) == true) goto L31;
        r17 = r22;
    L31:
        r20 = r17;
        goto L32
    L57:
        return;
    L4:
        if (r5.getId() == 2131370692) goto L8;
        goto L5
    }

    public SameProductTitleView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        LayoutInflater.from(r2).inflate(2131560653, this);
        TextView r4 = (TextView) findViewById(2131370692);
        this.a = r4;
        View r5 = findViewById(2131370643);
        this.b = r5;
        r4.setOnClickListener(this);
        r5.setOnClickListener(this);
    }
}
