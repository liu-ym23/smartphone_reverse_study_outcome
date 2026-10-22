package com.bytedance.ee.bear.bitable.card.view.cell.attachment.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.bear.bitable.common.widgets.flex.InnerRecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 J2\u00020\u0001:\u0001JB\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010#\u001a\u00020$H\u0016J\u000e\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'J\u0010\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020$2\b\u0010,\u001a\u0004\u0018\u00010\"J\u0010\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020\u0019H\u0016J\b\u0010/\u001a\u00020*H\u0016J\b\u00100\u001a\u00020*H\u0016J\u001a\u00101\u001a\u00020$2\u0010\u00102\u001a\f\u0012\u0006\u0012\u0004\u0018\u000104\u0018\u000103H\u0016J\u001a\u00105\u001a\u00020\u00192\u0010\u00106\u001a\f\u0012\u0006\u0012\u0004\u0018\u000104\u0018\u000103H\u0004J\u0012\u00107\u001a\u00020$2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0012\u0010:\u001a\u00020$2\b\u0010;\u001a\u0004\u0018\u00010<H\u0014J\u000e\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020\u0019J\u000e\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020\nJ\u001d\u0010A\u001a\u00020$2\u0010\u0010B\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010D\u0018\u00010C¢\u0006\u0002\u0010EJ\u0010\u0010F\u001a\u00020$2\b\u0010G\u001a\u0004\u0018\u00010HJ\u0006\u0010I\u001a\u00020$R\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\nX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/view/AttachmentGridView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mAttachmentAdapter", "Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/view/AttachmentAdapter;", "getMAttachmentAdapter", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/view/AttachmentAdapter;", "setMAttachmentAdapter", "(Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/view/AttachmentAdapter;)V", "mIsLandscape", "", "getMIsLandscape", "()Z", "setMIsLandscape", "(Z)V", "layoutRes", "getLayoutRes", "()I", "mSrcObjToken", "", "init", "", "setGridViewClickListener", "clickListener", "Landroid/view/View$OnClickListener;", "limitMaxVisibleLine", GXTemplateKey.STYLE_FONT_LINES, "", "updateSrcObjToken", "srcObjToken", "updateWidth", "needFullWidth", "getItemWidth", "getItemWidthMargin", "setData", "data", "", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/AttachmentEntity;", "isAttachmentsEqual", "newItems", "setAttachmentViewDelegate", "attachmentViewDelegate", "Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/view/IAttachmentViewDelegate;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onOrientationChanged", "isLandscape", "notifyItemChanged", "position", "setCustomMenus", "menus", "", "Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/view/AttachmentMenuEnum;", "([Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/view/AttachmentMenuEnum;)V", "setAttachmentCoverViewEventListener", "attachmentCoverViewEventListener", "Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/view/AttachmentAdapter$OnAttachmentCoverViewEventListener;", "destroyCustomMenu", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class AttachmentGridView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f207419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AttachmentAdapter f207420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f207421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f207422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f207423e;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachmentGridView f207424a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<AttachmentEntity> f207425b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(AttachmentGridView r100, List<? extends AttachmentEntity> r101) {
            this.f207424a = r100;
            this.f207425b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f207424a.getMAttachmentAdapter().y2(this.f207425b);     // Catch: Throwable -> L4
            this.f207424a.getMAttachmentAdapter().notifyDataSetChanged();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public void c(boolean r100) {
    }

    public float getItemWidth() {
        return 0.0f;
    }

    public float getItemWidthMargin() {
        return 0.0f;
    }

    public final AttachmentAdapter getMAttachmentAdapter() {
        AttachmentAdapter r100 = this.f207420b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mAttachmentAdapter");
        return null;
    }

    public final RecyclerView getMRecyclerView() {
        RecyclerView r100 = this.f207419a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        return null;
    }

    public void a() {
        if (getResources().getConfiguration().orientation != 2) goto L5;
        boolean r100 = true;
    L6:
        this.f207421c = r100;
        View.inflate(getContext(), getLayoutRes(), this);
        setMRecyclerView((RecyclerView) findViewById(R.id.attachment_grid_view_root_rv));
        final Context r101 = getContext();
        GridLayoutManager r102 = new AttachmentGridView$init$mGridLayoutManager$1(this, r101);
        getMRecyclerView().setLayoutManager(r102);
        getMRecyclerView().setHasFixedSize(true);
        setMAttachmentAdapter(new AttachmentAdapter());
        int r103 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.attachment_stable_id_crash_fix_enable") == false) goto L9;
        getMAttachmentAdapter().setHasStableIds(false);
    L10:
        getMRecyclerView().setAdapter(getMAttachmentAdapter());
        return;
    L9:
        getMAttachmentAdapter().setHasStableIds(true);
        goto L10
    L5:
        r100 = false;
        goto L6
    }

    public int getLayoutRes() {
        return this.f207422d;
    }

    public final boolean getMIsLandscape() {
        return this.f207421c;
    }

    public AttachmentGridView(Context r100) {
        super(r100);
        this.f207422d = R.layout.bitable_card_attachment_grid_layout;
        this.f207423e = "";
        a();
    }

    public void b(float r100) {
        RecyclerView r101 = getMRecyclerView();
        if ((r101 instanceof InnerRecyclerView) == false) goto L5;
        InnerRecyclerView r102 = (InnerRecyclerView) r101;
    L6:
        if (r102 == null) goto L9;
        r102.t(r100 * 86);
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L9:
        if (this.f207421c == r101) goto L12;
        this.f207421c = r101;
        return;
    L12:
        return;
    L5:
        if (2 != r100.orientation) goto L7;
        r101 = true;
        goto L9
    }

    public final void setAttachmentCoverViewEventListener(AttachmentAdapter.a r100) {
        getMAttachmentAdapter().f207385e = r100;
    }

    public void setAttachmentViewDelegate(p r100) {
        getMAttachmentAdapter().f207382b = r100;
    }

    public final void setCustomMenus(AttachmentMenuEnum[] r100) {
        getMAttachmentAdapter().f207383c = r100;
    }

    public void setData(List<? extends AttachmentEntity> r100) {
        if (getMRecyclerView().isComputingLayout() == false) goto L5;
        getMRecyclerView().post(new b(this, r100));
        return;
    L5:
        getMAttachmentAdapter().y2(r100);
        getMAttachmentAdapter().notifyDataSetChanged();
    }

    public final void setGridViewClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "clickListener");
        getMRecyclerView().setOnClickListener(r100);
    }

    public final void setMAttachmentAdapter(AttachmentAdapter r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f207420b = r100;
    }

    public final void setMIsLandscape(boolean r100) {
        this.f207421c = r100;
    }

    public final void setMRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f207419a = r100;
    }

    public AttachmentGridView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f207422d = R.layout.bitable_card_attachment_grid_layout;
        this.f207423e = "";
        a();
    }

    public AttachmentGridView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f207422d = R.layout.bitable_card_attachment_grid_layout;
        this.f207423e = "";
        a();
    }
}
