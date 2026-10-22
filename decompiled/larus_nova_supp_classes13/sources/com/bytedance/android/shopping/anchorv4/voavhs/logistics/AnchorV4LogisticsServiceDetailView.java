package com.bytedance.android.shopping.anchorv4.voavhs.logistics;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.shopping.anchorv4.dto.base.ShowEvent;
import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.LongContentLabelComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.d;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.processflow.AnchorV4PathEffectFlowLayout;
import com.bytedance.android.shopping.buynow.data.model.ErrorPageButtonAction;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010$\u001a\u00020\u0010¢\u0006\u0004\b%\u0010&J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005R$\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006'"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/AnchorV4LogisticsServiceDetailView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/d;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/ServiceComponent;", "data", "Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/AnchorV4LogisticsAndCouponBusinessMeta;", "businessMeta", "", "update", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/TextWithOneIconElementView;", "<set-?>", "b", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/TextWithOneIconElementView;", "getTivDetailButton", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/TextWithOneIconElementView;", "tivDetailButton", "", "i", "Ljava/lang/Integer;", "getServiceType", "()Ljava/lang/Integer;", "setServiceType", "(Ljava/lang/Integer;)V", "serviceType", "Lkotlin/Function0;", "j", "Lkotlin/jvm/functions/Function0;", "getRefresh", "()Lkotlin/jvm/functions/Function0;", "setRefresh", "(Lkotlin/jvm/functions/Function0;)V", ErrorPageButtonAction.REFRESH, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4LogisticsServiceDetailView extends ConstraintLayout implements d {
    public final TextView a;
    public final TextWithOneIconElementView b;
    public final TextWithOneIconElementView c;
    public final int d;
    public final int e;
    public final List<LongContentLabelComponentView> f;
    public AnchorV4PathEffectFlowLayout g;
    public ServiceComponent h;
    public Integer i;
    public Function0<Unit> j;

    public AnchorV4LogisticsServiceDetailView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AnchorV4LogisticsServiceDetailView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void R5() {
        Iterator<T> r0 = this.f.iterator();
    L3:
        boolean r2 = true;
        List r4 = null;
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((LongContentLabelComponentView) r1).getVisibility() != 0) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L3;
    L12:
        LongContentLabelComponentView r3 = (LongContentLabelComponentView) r1;
        ArrayList r6 = (ArrayList) this.f;
        ListIterator r7 = r6.listIterator(r6.size());
    L14:
        if (r7.hasPrevious() == false) goto L21;
        Object r8 = r7.previous();
        if (((LongContentLabelComponentView) r8).getVisibility() != 0) goto L18;
        boolean r9 = true;
    L19:
        if (r9 == false) goto L14;
    L22:
        LongContentLabelComponentView r10 = (LongContentLabelComponentView) r8;
        if (r3 == null) goto L36;
        ViewGroup.LayoutParams r11 = r3.getLayoutParams();
        if ((r11 instanceof ConstraintLayout.LayoutParams) == true) goto L27;
        r11 = null;
    L27:
        ConstraintLayout.LayoutParams r12 = (ConstraintLayout.LayoutParams) r11;
        if (r12 == null) goto L30;
        ((ViewGroup.MarginLayoutParams) r12).topMargin = 0;
        r12.topToTop = 0;
    L30:
        ViewGroup.LayoutParams r13 = this.a.getLayoutParams();
        if ((r13 instanceof ConstraintLayout.LayoutParams) == true) goto L33;
        r13 = null;
    L33:
        ConstraintLayout.LayoutParams r14 = (ConstraintLayout.LayoutParams) r13;
        if (r14 == null) goto L36;
        r14.topToTop = r3.getId();
        r14.bottomToBottom = r3.getId();
    L36:
        if (r10 == null) goto L38;
        ViewGroup.LayoutParams r15 = r10.getLayoutParams();
    L40:
        if ((r15 instanceof ConstraintLayout.LayoutParams) == true) goto L42;
        r15 = null;
    L42:
        ConstraintLayout.LayoutParams r16 = (ConstraintLayout.LayoutParams) r15;
        if (r16 == null) goto L59;
        ServiceComponent r17 = this.h;
        if (r17 == null) goto L53;
        TagsScrollBoxComponent r18 = r17.getProcessItems();
        if (r18 == null) goto L53;
        List r19 = r18.getButtonList();
        if (r19 == null) goto L53;
        if ((!r19.isEmpty()) == false) goto L53;
        r4 = r19;
    L53:
        if (r4 != null) goto L56;
        r2 = false;
    L56:
        if (r2 == false) goto L58;
        r16.bottomToTop = this.e;
        goto L59
    L58:
        r16.bottomToBottom = 0;
    L59:
        requestLayout();
        return;
    L38:
        r15 = null;
        goto L40
    L18:
        r9 = false;
        goto L19
    L21:
        r8 = null;
        goto L22
    L8:
        r5 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.d
    public final List<ShowEvent> showEvent() {
        ServiceComponent r0 = this.h;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getShowEvent();
    }

    public final Function0<Unit> getRefresh() {
        return this.j;
    }

    public final Integer getServiceType() {
        return this.i;
    }

    public final TextWithOneIconElementView getTivDetailButton() {
        return this.b;
    }

    public final void setRefresh(Function0<Unit> r1) {
        this.j = r1;
    }

    public final void setServiceType(Integer r1) {
        this.i = r1;
    }

    public final void update(ServiceComponent r7, AnchorV4LogisticsAndCouponBusinessMeta r8) {
        Intrinsics.checkNotNullParameter(r7, "data");
        this.h = r7;
        this.i = Integer.valueOf(r7.getServiceType());
        TextWithOneIconElementView r9 = this.b;
        TextWithOneIconElement r0 = r7.getHeader();
        int r1 = TextWithOneIconElementView.j;
        List<TextWithOneIconElement> r2 = null;
        r9.update(r0, null, false);
        this.c.update(r7.getSuffix(), null, false);
        Iterator r10 = ((ArrayList) this.f).iterator();
        int r3 = 0;
    L4:
        if (r10.hasNext() == false) goto L19;
        Object r4 = r10.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        LongContentLabelComponentView r6 = (LongContentLabelComponentView) r4;
        List<LongContentLabelComponent> r11 = r7.getDetailContent();
        if (r11 == null) goto L11;
        int r12 = r11.size();
    L12:
        if (r3 >= r12) goto L18;
        List<LongContentLabelComponent> r13 = r7.getDetailContent();
        if (r13 == null) goto L16;
        LongContentLabelComponent r14 = (LongContentLabelComponent) ListProtector.get(r13, r3);
    L17:
        r6.update(r14);
        goto L18
    L16:
        r14 = null;
    L18:
        r3 = r5;
        goto L4
    L11:
        r12 = 0;
        goto L12
    L19:
        TagsScrollBoxComponent r15 = r7.getProcessItems();
        if (r15 == null) goto L34;
        List<TextWithOneIconElement> r16 = r15.getButtonList();
        if (r16 != null) goto L24;
        return;
    L24:
        if ((!r16.isEmpty()) == false) goto L26;
        r2 = r16;
    L26:
        if (r2 == null) goto L36;
        AnchorV4PathEffectFlowLayout r17 = this.g;
        if (r17 == null) goto L37;
        r17.update(r2);
        return;
    L37:
        return;
    L36:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4LogisticsServiceDetailView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.d = ViewCompat.generateViewId();
        this.e = ViewCompat.generateViewId();
        this.f = new ArrayList();
        setBackgroundColor(-1);
        TextWithOneIconElementView r13 = new TextWithOneIconElementView(r10, null, 0, null, 30);
        r13.setId(ViewCompat.generateViewId());
        Unit r0 = Unit.INSTANCE;
        this.b = r13;
        TextWithOneIconElementView r14 = new TextWithOneIconElementView(r10, null, 0, null, 30);
        r14.setId(ViewCompat.generateViewId());
        this.c = r14;
        TextView r15 = new TextView(r10);
        r15.setId(ViewCompat.generateViewId());
        r15.setText("");
        r15.setMinHeight(com.bytedance.android.shopping.extensions.b.b(20));
        r15.setTextSize(2, 14.0f);
        r15.setVisibility(4);
        this.a = r15;
        setClipChildren(false);
        setClipToPadding(false);
    }

    public /* synthetic */ AnchorV4LogisticsServiceDetailView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
