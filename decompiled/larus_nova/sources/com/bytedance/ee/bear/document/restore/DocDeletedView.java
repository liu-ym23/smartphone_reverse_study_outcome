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
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 52\u00020\u0001:\u000245B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010*\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(J\u000e\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u000200J\u000e\u00101\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(J\u000e\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020(R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/document/restore/DocDeletedView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "llLoadingFromXml", "Landroid/widget/LinearLayout;", "getLlLoadingFromXml", "()Landroid/widget/LinearLayout;", "setLlLoadingFromXml", "(Landroid/widget/LinearLayout;)V", "facadeNoDataEmptyStateFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "getFacadeNoDataEmptyStateFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "setFacadeNoDataEmptyStateFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;)V", "btnBackSourceDocFromXml", "Lcom/larksuite/component/universe_design/button/UDButton;", "getBtnBackSourceDocFromXml", "()Lcom/larksuite/component/universe_design/button/UDButton;", "setBtnBackSourceDocFromXml", "(Lcom/larksuite/component/universe_design/button/UDButton;)V", "delegate", "Lcom/bytedance/ee/bear/document/restore/DocDeletedView$ViewDelegate;", "titleBar", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "initView", "", "setDesc", SocialConstants.PARAM_APP_DESC, "", "setImageRes", "resId", "", "setTitleBarVisible", "visible", "", "setDelegate", "setRestoreVisible", "setBackIcon", "drawable", "Landroid/graphics/drawable/Drawable;", "setBackListener", "listener", "Landroid/view/View$OnClickListener;", "setBackIconVisible", "setIsRestoring", "restoring", "ViewDelegate", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocDeletedView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f221435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SpaceEmptyState f221436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public UDButton f221437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f221438d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BaseTitleBar f221439e;

    public static final class a {
    }

    public interface b {
        void a();
    }

    static {
    }

    public final UDButton getBtnBackSourceDocFromXml() {
        KeyEvent.Callback r100 = this.f221437c;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.btn_back_source_doc);
        this.f221437c = (UDButton) r100;
    L6:
        return (UDButton) r100;
    }

    public final SpaceEmptyState getFacadeNoDataEmptyStateFromXml() {
        KeyEvent.Callback r100 = this.f221436b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.facade_no_data_empty_state);
        this.f221436b = (SpaceEmptyState) r100;
    L6:
        return (SpaceEmptyState) r100;
    }

    public final LinearLayout getLlLoadingFromXml() {
        KeyEvent.Callback r100 = this.f221435a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.ll_loading);
        this.f221435a = (LinearLayout) r100;
    L6:
        return (LinearLayout) r100;
    }

    public final void setBackIcon(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        BaseTitleBar r101 = this.f221439e;
        if (r101 == null) goto L8;
        ImageView r102 = r101.getLeftImage();
        if (r102 == null) goto L9;
        r102.setImageDrawable(r100);
        return;
    L9:
        return;
    }

    public final void setBackIconVisible(boolean r100) {
        BaseTitleBar r101 = this.f221439e;
        if (r101 == null) goto L6;
        r101.setLeftVisible(r100);
        return;
    }

    public final void setBackListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        BaseTitleBar r101 = this.f221439e;
        if (r101 == null) goto L6;
        r101.setLeftClickListener(r100);
        return;
    }

    public final void setBtnBackSourceDocFromXml(UDButton r100) {
        this.f221437c = r100;
    }

    public final void setDelegate(b r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f221438d = r100;
    }

    public final void setDesc(String r100) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
        getFacadeNoDataEmptyStateFromXml().setDesc(r100);
    }

    public final void setFacadeNoDataEmptyStateFromXml(SpaceEmptyState r100) {
        this.f221436b = r100;
    }

    public final void setImageRes(int r100) {
        getFacadeNoDataEmptyStateFromXml().setImageRes(Integer.valueOf(r100));
    }

    public final void setIsRestoring(boolean r100) {
        UDButton r101 = getBtnBackSourceDocFromXml();
        if (r100 == false) goto L5;
        r101.setEnabled(false);
        r101.setAlpha(0.5f);
        com.larksuite.component.universe_design.button.e.h(r101, DocDeletedView$setIsRestoring$1$1.INSTANCE);
        return;
    L5:
        r101.setEnabled(true);
        r101.setAlpha(1.0f);
        com.larksuite.component.universe_design.button.e.c(r101, R.string.LarkCCM_Workspace_Deleted_Restore_Button);
    }

    public final void setLlLoadingFromXml(LinearLayout r100) {
        this.f221435a = r100;
    }

    public final void setRestoreVisible(boolean r100) {
        UDButton r101 = getBtnBackSourceDocFromXml();
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setTitleBarVisible(boolean r100) {
        BaseTitleBar r101 = this.f221439e;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        return;
    L6:
        r102 = 8;
        goto L7
    }

    public DocDeletedView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.doc_empty_layout, this);
        BaseTitleBar r102 = new BaseTitleBar(getContext());
        r102.setId(R.id.titleBar);
        r102.setDividerVisible(false);
        addView(r102, -1, -2);
        this.f221439e = r102;
        getLlLoadingFromXml().setVisibility(8);
        SpaceEmptyState r103 = getFacadeNoDataEmptyStateFromXml();
        r103.setVisibility(0);
        r103.setImageRes(Integer.valueOf(R.drawable.ccm_empty_neutral_no_content));
        Resources r104 = r103.getResources();
        String r105 = null;
        if (r104 == null) goto L5;
        String r106 = r104.getString(R.string.LarkCCM_Workspace_Deleted_Common_Empty);
    L6:
        r103.setDesc(r106);
        r103.setPrimaryText(null);
        UDButton r107 = getBtnBackSourceDocFromXml();
        r107.setVisibility(8);
        Resources r108 = r107.getResources();
        if (r108 == null) goto L9;
        r105 = r108.getString(R.string.LarkCCM_Workspace_Deleted_Restore_Button);
    L9:
        r107.setText(r105);
        r107.setOnClickListener(new e(this));
        return;
    L5:
        r106 = null;
        goto L6
    }
}
