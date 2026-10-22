package com.bytedance.ee.bear.document.restore;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larksuite.component.universe_design.button.UDButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 52\u00020\u0001:\u000245B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010*\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(J\u000e\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u000200J\u000e\u00101\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(J\u000e\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020(R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/document/restore/DocDeletedView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "llLoadingFromXml", "Landroid/widget/LinearLayout;", "getLlLoadingFromXml", "()Landroid/widget/LinearLayout;", "setLlLoadingFromXml", "(Landroid/widget/LinearLayout;)V", "facadeNoDataEmptyStateFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "getFacadeNoDataEmptyStateFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "setFacadeNoDataEmptyStateFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;)V", "btnBackSourceDocFromXml", "Lcom/larksuite/component/universe_design/button/UDButton;", "getBtnBackSourceDocFromXml", "()Lcom/larksuite/component/universe_design/button/UDButton;", "setBtnBackSourceDocFromXml", "(Lcom/larksuite/component/universe_design/button/UDButton;)V", "delegate", "Lcom/bytedance/ee/bear/document/restore/DocDeletedView$ViewDelegate;", "titleBar", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "initView", "", "setDesc", "desc", "", "setImageRes", "resId", "", "setTitleBarVisible", "visible", "", "setDelegate", "setRestoreVisible", "setBackIcon", "drawable", "Landroid/graphics/drawable/Drawable;", "setBackListener", "listener", "Landroid/view/View$OnClickListener;", "setBackIconVisible", "setIsRestoring", "restoring", "ViewDelegate", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocDeletedView extends FrameLayout {
    public LinearLayout a;
    public SpaceEmptyState b;
    public UDButton c;
    public b d;
    public BaseTitleBar e;

    public static final class a {
    }

    public interface b {
        void a();
    }

    static {
    }

    public final UDButton getBtnBackSourceDocFromXml() {
        UDButton r0 = this.c;
        if (r0 != null) goto L6;
        r0 = findViewById(2131364651);
        this.c = r0;
    L6:
        return r0;
    }

    public final SpaceEmptyState getFacadeNoDataEmptyStateFromXml() {
        SpaceEmptyState r0 = this.b;
        if (r0 != null) goto L6;
        r0 = findViewById(2131372043);
        this.b = r0;
    L6:
        return r0;
    }

    public final LinearLayout getLlLoadingFromXml() {
        KeyEvent.Callback r0 = this.a;
        if (r0 != null) goto L6;
        r0 = findViewById(2131378741);
        this.a = (LinearLayout) r0;
    L6:
        return (LinearLayout) r0;
    }

    public final void setBackIcon(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        BaseTitleBar r0 = this.e;
        if (r0 == null) goto L8;
        ImageView r1 = r0.getLeftImage();
        if (r1 == null) goto L9;
        r1.setImageDrawable(r2);
        return;
    L9:
        return;
    }

    public final void setBackIconVisible(boolean r2) {
        BaseTitleBar r0 = this.e;
        if (r0 == null) goto L6;
        r0.setLeftVisible(r2);
        return;
    }

    public final void setBackListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        BaseTitleBar r0 = this.e;
        if (r0 == null) goto L6;
        r0.setLeftClickListener(r2);
        return;
    }

    public final void setBtnBackSourceDocFromXml(UDButton r1) {
        this.c = r1;
    }

    public final void setDelegate(b r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.d = r2;
    }

    public final void setDesc(String r2) {
        Intrinsics.checkNotNullParameter(r2, "desc");
        getFacadeNoDataEmptyStateFromXml().setDesc(r2);
    }

    public final void setFacadeNoDataEmptyStateFromXml(SpaceEmptyState r1) {
        this.b = r1;
    }

    public final void setImageRes(int r2) {
        getFacadeNoDataEmptyStateFromXml().setImageRes(Integer.valueOf(r2));
    }

    public final void setIsRestoring(boolean r2) {
        UDButton r0 = getBtnBackSourceDocFromXml();
        if (r2 == false) goto L5;
        r0.setEnabled(false);
        r0.setAlpha(0.5f);
        com.larksuite.component.universe_design.button.e.h(r0, DocDeletedView$setIsRestoring$1$1.INSTANCE);
        return;
    L5:
        r0.setEnabled(true);
        r0.setAlpha(1.0f);
        com.larksuite.component.universe_design.button.e.c(r0, 2131889871);
    }

    public final void setLlLoadingFromXml(LinearLayout r1) {
        this.a = r1;
    }

    public final void setRestoreVisible(boolean r2) {
        UDButton r0 = getBtnBackSourceDocFromXml();
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setTitleBarVisible(boolean r2) {
        BaseTitleBar r0 = this.e;
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        return;
    L6:
        r3 = 8;
        goto L7
    }

    public DocDeletedView(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        LayoutInflater.from(r4).inflate(2131560079, this);
        BaseTitleBar r6 = new BaseTitleBar(getContext());
        r6.setId(2131388775);
        r6.setDividerVisible(false);
        addView(r6, -1, -2);
        this.e = r6;
        getLlLoadingFromXml().setVisibility(8);
        SpaceEmptyState r7 = getFacadeNoDataEmptyStateFromXml();
        r7.setVisibility(0);
        r7.setImageRes(2131232549);
        Resources r8 = r7.getResources();
        String r1 = null;
        if (r8 == null) goto L5;
        String r9 = r8.getString(2131889867);
    L6:
        r7.setDesc(r9);
        r7.setPrimaryText(null);
        UDButton r10 = getBtnBackSourceDocFromXml();
        r10.setVisibility(8);
        Resources r11 = r10.getResources();
        if (r11 == null) goto L9;
        r1 = r11.getString(2131889871);
    L9:
        r10.setText(r1);
        r10.setOnClickListener(new e(this));
        return;
    L5:
        r9 = null;
        goto L6
    }
}
