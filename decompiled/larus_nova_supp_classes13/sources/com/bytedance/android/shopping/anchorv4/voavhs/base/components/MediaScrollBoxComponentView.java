package com.bytedance.android.shopping.anchorv4.voavhs.base.components;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.ShowEvent;
import com.bytedance.android.shopping.anchorv4.dto.components.MediaScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.MediaBoxElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.d;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.MediaBoxElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.extensions.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R(\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/MediaScrollBoxComponentView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/d;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "", "setActionHub", "Landroid/widget/HorizontalScrollView;", "<set-?>", "b", "Landroid/widget/HorizontalScrollView;", "getHorizontalScrollView", "()Landroid/widget/HorizontalScrollView;", "horizontalScrollView", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaScrollBoxComponentView extends FrameLayout implements ActionHubAccessor, d {
    public static final /* synthetic */ int e = 0;
    public boolean a;
    public HorizontalScrollView b;
    public MediaScrollBoxComponent c;
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a d;

    public MediaScrollBoxComponentView(Context r4) {
        this(r4, null, 0, 14);
    }

    public MediaScrollBoxComponentView(Context r3, AttributeSet r4) {
        this(r3, r4, 0, 12);
    }

    public MediaScrollBoxComponentView(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 8);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.d
    public final List<ShowEvent> showEvent() {
        MediaScrollBoxComponent r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getShowEvent();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.d;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return this.c;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    public final HorizontalScrollView getHorizontalScrollView() {
        return this.b;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final String getOnLimitClickBindKey(Action r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        return ActionHubAccessor.DefaultImpls.c(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r2) {
        Intrinsics.checkNotNullParameter(r2, "hub");
        this.d = r2;
    }

    public final void a(MediaScrollBoxComponent r6, boolean r7) {
        this.c = r6;
        this.a = r7;
        if (r6 == null) goto L18;
        List<MediaBoxElement> r8 = r6.getMedias();
        if (r8 == null) goto L18;
        if ((!r8.isEmpty()) == true) goto L10;
        r8 = null;
    L10:
        if (r8 == null) goto L18;
        float r0 = (n1.f - (b.b(Integer.valueOf(r6.getSpace())) * (((int) (1 / r6.getEdgePercent())) - 1))) * r6.getEdgePercent();
        removeAllViews();
        if (r6.getScrollable() == false) goto L15;
        int r1 = r6.getSpace();
        int r2 = r6.getAlignStrategy();
        HorizontalScrollView r3 = new HorizontalScrollView(getContext());
        r3.setHorizontalScrollBarEnabled(false);
        r3.setHorizontalFadingEdgeEnabled(false);
        r3.addView(b(r8, r1, (int) r0, r2));
        Unit r9 = Unit.INSTANCE;
        this.b = r3;
        addView(r3);
    L16:
        Action r10 = r6.getAction();
        Intrinsics.checkNotNullParameter(this, "theView");
        ActionHubAccessor.DefaultImpls.a(this, this, r10);
        return;
    L15:
        addView(b(r8, r6.getSpace(), (int) r0, r6.getAlignStrategy()));
    L18:
        setVisibility(8);
    }

    public MediaScrollBoxComponentView(Context r3, AttributeSet r4, int r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.d = null;
    }

    public final LinearLayout b(List<MediaBoxElement> r10, int r11, int r12, int r13) {
        LinearLayout r0 = new LinearLayout(getContext());
        r0.setOrientation(0);
        ExtensionsKt.a(r0, r13);
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r10.iterator();
        int r2 = 0;
    L4:
        if (r15.hasNext() == false) goto L15;
        Object r3 = r15.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        MediaBoxElementView r5 = new MediaBoxElementView(r0.getContext(), null, 0, 14);
        MediaBoxElementView.c(r5, (MediaBoxElement) r3, null, this.a, 2);
        r14.add(r5);
        if (r12 > 0) goto L11;
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(-2, -2);
    L12:
        if (r2 <= 0) goto L14;
        r6.leftMargin = b.b(Integer.valueOf(r11));
    L14:
        r0.addView(r5, r6);
        r2 = r4;
        goto L4
    L11:
        r6 = new LinearLayout.LayoutParams(r12, r12);
        goto L12
    L15:
        return r0;
    }
}
