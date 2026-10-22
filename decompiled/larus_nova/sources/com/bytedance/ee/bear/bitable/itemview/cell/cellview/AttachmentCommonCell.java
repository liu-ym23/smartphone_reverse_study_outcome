package com.bytedance.ee.bear.bitable.itemview.cell.cellview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.upload.PendingUploadAttachmentEntity;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.upload.UploadAttachmentEntity;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentAdapter;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentGridView;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentMenuEnum;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.p;
import com.bytedance.ee.bear.bitable.card.viewmodel.y1;
import com.bytedance.ee.bear.bitable.celleditor.model.upload.TargetCellInfo;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.itemview.cell.ItemViewCellContainerV2;
import com.bytedance.ee.bear.bitable.itemview.record.list.ContainerDirection;
import com.bytedance.ee.bear.bitable.itemview.recordpages.ItemViewRecordPagesData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000 `2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u00020\u00052\u00020\u00062\u00020\u0007:\u0001`B5\b\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020$H\u0014J\b\u0010%\u001a\u00020$H\u0014J,\u0010C\u001a\u00020$2\u0006\u0010D\u001a\u00020(2\b\u0010E\u001a\u0004\u0018\u00010!2\b\u0010F\u001a\u0004\u0018\u00010!2\u0006\u0010G\u001a\u00020HH\u0016J$\u0010I\u001a\u00020$2\u0006\u0010D\u001a\u00020(2\b\u0010E\u001a\u0004\u0018\u00010!2\b\u0010F\u001a\u0004\u0018\u00010!H\u0016J.\u0010J\u001a\u00020$2\u0006\u0010D\u001a\u00020(2\b\u0010E\u001a\u0004\u0018\u00010!2\b\u0010F\u001a\u0004\u0018\u00010!2\b\u0010K\u001a\u0004\u0018\u00010!H\u0016J,\u0010L\u001a\u00020$2\u0006\u0010D\u001a\u00020(2\b\u0010E\u001a\u0004\u0018\u00010!2\b\u0010F\u001a\u0004\u0018\u00010!2\u0006\u0010M\u001a\u00020NH\u0016J\u001c\u0010O\u001a\u00020\u001f2\b\u0010E\u001a\u0004\u0018\u00010!2\b\u0010F\u001a\u0004\u0018\u00010!H\u0002J\u0010\u0010P\u001a\u00020$2\u0006\u0010D\u001a\u00020(H\u0002J\b\u0010Q\u001a\u00020$H\u0016J\b\u0010R\u001a\u0004\u0018\u00010SJ\u0006\u0010T\u001a\u00020$J\b\u0010U\u001a\u00020$H\u0002J\u0006\u0010V\u001a\u00020$J$\u0010W\u001a\u00020$2\b\u0010X\u001a\u0004\u0018\u00010\u00032\u0006\u0010Y\u001a\u00020\u00042\b\u0010Z\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010[\u001a\u00020$H&J\n\u0010\\\u001a\u0004\u0018\u000108H&J\u0018\u0010]\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020\u001f2\u0006\u0010_\u001a\u00020NH&R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010&\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u000202X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u000108X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020>X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/AttachmentCommonCell;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKitEx;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/AttachmentCellValue;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/CellContextData;", "Lcom/bytedance/ee/bear/bitable/common/TouchDetectListener;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/upload/FileUploadStatusListener;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/LocalValueCell;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "mData", "mExtra", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/AttachmentCellValue;Lcom/bytedance/ee/bear/bitable/itemview/cell/CellContextData;)V", "getMData", "()Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/AttachmentCellValue;", "setMData", "(Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/AttachmentCellValue;)V", "getMExtra", "()Lcom/bytedance/ee/bear/bitable/itemview/cell/CellContextData;", "setMExtra", "(Lcom/bytedance/ee/bear/bitable/itemview/cell/CellContextData;)V", "mHandler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "getMHandler", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "setMHandler", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;)V", "hasLocalValue", "", "recordId", "", "fieldId", "onAttachedToWindow", "", "onDetachedFromWindow", "mUploadingList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/upload/UploadAttachmentEntity;", "Lkotlin/collections/ArrayList;", "mShowList", "", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/AttachmentEntity;", "getMShowList", "()Ljava/util/List;", "setMShowList", "(Ljava/util/List;)V", "mAttachmentGridView", "Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/view/AttachmentGridView;", "getMAttachmentGridView", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/view/AttachmentGridView;", "setMAttachmentGridView", "(Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/view/AttachmentGridView;)V", "addAttachmentButtonFl", "Landroid/view/View;", "getAddAttachmentButtonFl", "()Landroid/view/View;", "setAddAttachmentButtonFl", "(Landroid/view/View;)V", "attachmentCoverViewEventListener", "Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/view/AttachmentAdapter$OnAttachmentCoverViewEventListener;", "getAttachmentCoverViewEventListener", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/view/AttachmentAdapter$OnAttachmentCoverViewEventListener;", "setAttachmentCoverViewEventListener", "(Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/view/AttachmentAdapter$OnAttachmentCoverViewEventListener;)V", "onUpdateProgress", "attachmentEntity", "editFieldId", "editRecordId", "progress", "", "onUploadStart", "onUploadSuccess", "fileToken", "onUploadFail", "errorCode", "", "isCurrentCell", "removeAttachment", "onTouchDown", "getUploadStatusManager", "Lcom/bytedance/ee/bear/bitable/celleditor/model/upload/IAttachmentUploadStatusManager;", "updateDisplayData", "updateLayout", "ensureVisible", "setData", "data", "extra", "handler", "setAdapterParams", "getAddView", "needFullWidth", "editable", "remainWidth", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AttachmentCommonCell extends FrameLayout implements gv4.c<AttachmentCellValue, qt4.a>, com.bytedance.ee.bear.bitable.common.k, jp4.a, qt4.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AttachmentCellValue f213793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public qt4.a f213794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gv4.a f213795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<UploadAttachmentEntity> f213796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<? extends AttachmentEntity> f213797e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AttachmentGridView f213798f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f213799g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AttachmentAdapter.a f213800h;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f213801a = null;

        static {
            int[] r100 = new int[ContainerDirection.values().length];
            r100[ContainerDirection.HORIZONTAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ContainerDirection.VERTICAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f213801a = r100;
        }
    }

    public static final class c implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachmentCommonCell f213802a;

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.p
        public final PendingUploadAttachmentEntity findPendingUploadAttachmentByFileToken(String r100) {
            return null;
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.p
        public final y1 getMembraneManager() {
            return null;
        }

        public c(AttachmentCommonCell r100) {
            this.f213802a = r100;
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.p
        public final void b1(int r100) {
            com.bytedance.ee.bear.bitable.itemview.b r101 = com.bytedance.ee.bear.bitable.itemview.util.i.c(this.f213802a);
            if (r101 == null) goto L7;
            BitableAnalytic r102 = r101.q0();
            if (r102 == null) goto L7;
            r102.k("preview", 1);
        L7:
            Context r103 = this.f213802a.getContext();
            com.bytedance.ee.bear.bitable.itemview.b r104 = com.bytedance.ee.bear.bitable.itemview.util.i.c(this.f213802a);
            qt4.a r105 = this.f213802a.m8316getMExtra();
            String r106 = null;
            if (r105 == null) goto L10;
            String r107 = r105.f534791h;
        L11:
            qt4.a r108 = this.f213802a.m8316getMExtra();
            if (r108 == null) goto L14;
            r106 = r108.f534792i;
        L14:
            com.bytedance.ee.bear.bitable.itemview.util.i.g(r103, r104, r107, r106, this.f213802a.getMShowList(), r100, false);
            return;
        L10:
            r107 = null;
            goto L11
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ qt4.a f213803a;

        public d(qt4.a r100) {
            this.f213803a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f213803a.f534789f.run();
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ qt4.a f213804a;

        public e(qt4.a r100) {
            this.f213804a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f213804a.f534789f.run();
        }
    }

    static {
    }

    public AttachmentCommonCell(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 14);
    }

    public AttachmentCommonCell(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 12);
    }

    public abstract boolean d(boolean r100, int r101);

    public abstract void f();

    public abstract View getAddView();

    @Override // jp4.a
    public final void q3(UploadAttachmentEntity r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "attachmentEntity");
    }

    public final AttachmentGridView getMAttachmentGridView() {
        AttachmentGridView r100 = this.f213798f;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mAttachmentGridView");
        return null;
    }

    public final void h() {
        ArrayList r100 = new ArrayList();
        r100.addAll(this.f213796d);
        AttachmentCellValue r101 = getMData();
        ArrayList r102 = r101;
        if (r101 != null) goto L6;
        r102 = new ArrayList();
    L6:
        r100.addAll(r102);
        Iterator r103 = r100.iterator();
    L7:
        ContainerDirection r104 = null;
        String r105 = null;
        if (r103.hasNext() == false) goto L13;
        AttachmentEntity r106 = (AttachmentEntity) r103.next();
        ir4.i r107 = getUploadStatusManager();
        if (r107 == null) goto L12;
        r105 = r107.findLocalPathIfAttachmentUploadedManually(r106.getAttachmentToken());
    L12:
        r106.setAvailableLocalPath(r105);
        goto L7
    L13:
        int r108 = 0;
        if (r100.size() > 0) goto L16;
    L29:
        this.f213797e = r100;
        qt4.a r109 = m8316getMExtra();
        if (r109 == null) goto L33;
        r104 = r109.f534786c;
    L33:
        if (r104 != null) goto L35;
        int r110 = -1;
    L36:
        if (r110 != (-1)) goto L38;
        qt4.a r111 = m8316getMExtra();
        if (r111 == null) goto L48;
        boolean r112 = r111.f534788e;
    L49:
        qt4.a r113 = m8316getMExtra();
        if (r113 == null) goto L52;
        r108 = r113.f534784a;
    L52:
        boolean r114 = d(r112, r108);
        com.bytedance.ee.bear.bitable.itemview.util.i.i(this, r114);
        getMAttachmentGridView().c(r114);
    L54:
        if (Intrinsics.areEqual(this.f213797e, getMAttachmentGridView().getMAttachmentAdapter().f207381a) == false) goto L57;
        tt5.a.h("AttachmentCell", "same attachment");
        return;
    L57:
        getMAttachmentGridView().setData(this.f213797e);
        return;
    L48:
        r112 = false;
        goto L49
    L38:
        if (r110 != 1) goto L40;
        f();
        getMAttachmentGridView().getLayoutParams().width = -2;
        com.bytedance.ee.bear.bitable.m.B(getMAttachmentGridView().getMRecyclerView(), -2, false);
        goto L54
    L40:
        if (r110 != 2) goto L43;
        f();
        getMAttachmentGridView().getLayoutParams().width = -2;
        com.bytedance.ee.bear.bitable.m.B(getMAttachmentGridView().getMRecyclerView(), -2, false);
        goto L54
    L43:
        throw new NoWhenBranchMatchedException();
    L35:
        r110 = b.f213801a[r104.ordinal()];
        goto L36
    L16:
        if (getVisibility() != 8) goto L29;
        ViewParent r115 = getParent();
        if ((r115 instanceof ItemViewCellContainerV2) == false) goto L20;
        ItemViewCellContainerV2 r116 = (ItemViewCellContainerV2) r115;
    L21:
        if (r116 == null) goto L23;
        com.bytedance.ee.bear.bitable.m.z(r116.getBinding().f210826d, false);
        com.bytedance.ee.bear.bitable.m.z(r116.getBinding().f210824b, true);
    L23:
        ViewParent r117 = getParent();
        if ((r117 instanceof qt4.h) == false) goto L26;
        qt4.h r118 = (qt4.h) r117;
    L27:
        if (r118 == null) goto L29;
        com.bytedance.ee.bear.bitable.m.z(r118.getBinding().f210835f, false);
        com.bytedance.ee.bear.bitable.m.z(r118.getBinding().f210832c, true);
        goto L29
    L26:
        r118 = null;
        goto L27
    L20:
        r116 = null;
        goto L21
    }

    @Override // com.bytedance.ee.bear.bitable.common.k
    public final void b() {
        AttachmentAdapter r100 = getMAttachmentGridView().getMAttachmentAdapter();
        ActionMode r101 = r100.f207386f;
        if (r101 == null) goto L6;
        r101.finish();
        r100.f207386f = null;
        return;
    }

    /* JADX INFO: renamed from: getMData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8315getMData() {
        return getMData();
    }

    public /* bridge */ /* synthetic */ Object getMExtra() {
        return m8316getMExtra();
    }

    public final ir4.i getUploadStatusManager() {
        com.bytedance.ee.bear.bitable.itemview.b r100 = com.bytedance.ee.bear.bitable.itemview.util.i.c(this);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.he();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.ee.bear.bitable.itemview.b r100 = com.bytedance.ee.bear.bitable.itemview.util.i.c(this);
        if (r100 == null) goto L5;
        r100.EB(this);
    L5:
        ir4.i r101 = getUploadStatusManager();
        if (r101 == null) goto L9;
        r101.registerFileUploadStatusListener(this);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.ee.bear.bitable.itemview.b r100 = com.bytedance.ee.bear.bitable.itemview.util.i.c(this);
        if (r100 == null) goto L5;
        r100.ES(this);
    L5:
        ir4.i r101 = getUploadStatusManager();
        if (r101 == null) goto L9;
        r101.unregisterFileUploadStatusListener(this);
        return;
    }

    public final View getAddAttachmentButtonFl() {
        return this.f213799g;
    }

    public final AttachmentAdapter.a getAttachmentCoverViewEventListener() {
        return this.f213800h;
    }

    public final gv4.a getMHandler() {
        return this.f213795c;
    }

    public final List<AttachmentEntity> getMShowList() {
        return this.f213797e;
    }

    public AttachmentCellValue getMData() {
        return this.f213793a;
    }

    /* JADX INFO: renamed from: getMExtra, reason: collision with other method in class */
    public qt4.a m8316getMExtra() {
        return this.f213794b;
    }

    public final void e(UploadAttachmentEntity r100) {
        tt5.a.h("AttachmentCell", "removeAttachment: primaryId=" + r100.getPrimaryId());
        ArrayList<UploadAttachmentEntity> r101 = this.f213796d;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.contains(r100) == false) goto L9;
        this.f213796d.remove(r100);
        h();
        return;
    }

    public final void setAddAttachmentButtonFl(View r100) {
        this.f213799g = r100;
    }

    public final void setAttachmentCoverViewEventListener(AttachmentAdapter.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f213800h = r100;
    }

    public final void setMAttachmentGridView(AttachmentGridView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f213798f = r100;
    }

    @Override // gv4.c
    public /* bridge */ /* synthetic */ void setMData(AttachmentCellValue r100) {
        setMData2(r100);
    }

    @Override // gv4.c
    public /* bridge */ /* synthetic */ void setMExtra(qt4.a r100) {
        setMExtra2(r100);
    }

    public final void setMHandler(gv4.a r100) {
        this.f213795c = r100;
    }

    public final void setMShowList(List<? extends AttachmentEntity> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f213797e = r100;
    }

    /* JADX INFO: renamed from: setMData, reason: avoid collision after fix types in other method */
    public void setMData2(AttachmentCellValue r100) {
        this.f213793a = r100;
    }

    /* JADX INFO: renamed from: setMExtra, reason: avoid collision after fix types in other method */
    public void setMExtra2(qt4.a r100) {
        this.f213794b = r100;
    }

    @Override // qt4.k
    public final boolean a(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "recordId");
        Intrinsics.checkNotNullParameter(r111, "fieldId");
        qt4.a r100 = m8316getMExtra();
        if (r100 != null) goto L5;
    L13:
        com.bytedance.ee.bear.bitable.itemview.b r101 = com.bytedance.ee.bear.bitable.itemview.util.i.c(this);
        if (r101 == null) goto L28;
        ItemViewRecordPagesData r102 = r101.Kg();
        if (r102 == null) goto L28;
        TargetCellInfo r112 = new TargetCellInfo(r102.getBaseId(), r102.getTableId(), r110, r111, r102.getMode(), false);
        ir4.i r113 = getUploadStatusManager();
        if (r113 == null) goto L21;
        List<UploadAttachmentEntity> r114 = r113.findAttachmentListByCellInfo(r112);
    L22:
        if (r114 != null) goto L24;
    L26:
        return false;
    L24:
        if ((!r114.isEmpty()) != true) goto L26;
        return true;
    L21:
        r114 = null;
    L28:
        return false;
    L5:
        if (Intrinsics.areEqual(r100.f534791h, r110) == false) goto L13;
        if (Intrinsics.areEqual(r100.f534792i, r111) == false) goto L13;
        if (this.f213796d.size() > 0) goto L29;
        return false;
    L29:
        return true;
    }

    public final boolean c(String r100, String r101) {
        qt4.a r102 = m8316getMExtra();
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.f534791h;
    L7:
        if (Intrinsics.areEqual(r104, r101) == false) goto L14;
        qt4.a r105 = m8316getMExtra();
        if (r105 == null) goto L12;
        r103 = r105.f534792i;
    L12:
        if (Intrinsics.areEqual(r103, r100) == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        r104 = null;
        goto L7
    }

    public AttachmentCommonCell(Context r100, AttributeSet r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f213793a = null;
        this.f213794b = null;
        this.f213796d = new ArrayList();
        this.f213797e = new ArrayList();
        this.f213800h = new com.bytedance.ee.bear.bitable.itemview.cell.cellview.a(this);
    }

    @Override // jp4.a
    public final void D0(UploadAttachmentEntity r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "attachmentEntity");
        tt5.a.h("AttachmentCell", "onUploadStart " + r101 + ", " + r102 + ' ' + r100.getId());
        if (c(r101, r102) == false) goto L17;
        StringBuilder r103 = new StringBuilder("onUploadStart isCurrentCell ");
        boolean r104 = true;
        r103.append(!this.f213796d.contains(r100));
        tt5.a.h("AttachmentCell", r103.toString());
        if (this.f213796d.contains(r100) == true) goto L7;
        ListProtector.add(this.f213796d, 0, r100);
    L7:
        h();
        if ((r100 instanceof PendingUploadAttachmentEntity) == false) goto L10;
        r104 = true ^ ((PendingUploadAttachmentEntity) r100).isPendingUpload();
    L10:
        if (r104 == false) goto L18;
        com.bytedance.ee.bear.bitable.itemview.b r105 = com.bytedance.ee.bear.bitable.itemview.util.i.c(this);
        if (r105 == null) goto L19;
        BitableAnalytic r106 = r105.q0();
        if (r106 == null) goto L20;
        r106.J(r100.isCameraOnly());
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    public void g(AttachmentCellValue r100, qt4.a r110, gv4.a r111) {
        Intrinsics.checkNotNullParameter(r110, "extra");
        setMData2(r100);
        this.f213795c = r111;
        setMExtra2(r110);
        com.bytedance.ee.bear.bitable.itemview.b r101 = com.bytedance.ee.bear.bitable.itemview.util.i.c(this);
        String r112 = null;
        if (r101 == null) goto L11;
        ItemViewRecordPagesData r102 = r101.Kg();
        if (r102 == null) goto L11;
        TargetCellInfo r103 = new TargetCellInfo(r102.getBaseId(), r102.getTableId(), r110.f534791h, r110.f534792i, r102.getMode(), false);
        ir4.i r104 = getUploadStatusManager();
        if (r104 == null) goto L9;
        List<UploadAttachmentEntity> r105 = r104.findAttachmentListByCellInfo(r103);
    L10:
        this.f213796d = new ArrayList(r105);
        goto L11
    L9:
        r105 = null;
    L11:
        h();
        getMAttachmentGridView().setAttachmentViewDelegate(new c(this));
        View r106 = getAddView();
        if (r106 == null) goto L14;
        r106.setOnClickListener(new d(r110));
    L14:
        getMAttachmentGridView().setGridViewClickListener(new e(r110));
        getMAttachmentGridView().setAttachmentCoverViewEventListener(this.f213800h);
        View r107 = this.f213799g;
        if (r107 == null) goto L18;
        com.bytedance.ee.bear.bitable.m.z(r107, r110.f534788e);
    L18:
        if (r110.f534788e == false) goto L20;
        getMAttachmentGridView().setCustomMenus(new AttachmentMenuEnum[]{AttachmentMenuEnum.DELETE});
    L21:
        AttachmentGridView r108 = getMAttachmentGridView();
        com.bytedance.ee.bear.bitable.itemview.b r113 = com.bytedance.ee.bear.bitable.itemview.util.i.c(this);
        if (r113 == null) goto L26;
        mr4.a r114 = r113.o();
        if (r114 == null) goto L26;
        r112 = r114.f514980a;
    L26:
        r108.f207423e = r112;
        r108.getMAttachmentAdapter().f207384d = r108.f207423e;
        return;
    L20:
        getMAttachmentGridView().setCustomMenus(null);
        goto L21
    }

    @Override // jp4.a
    public final void s1(UploadAttachmentEntity r100, String r101, String r102, float r110) {
        Intrinsics.checkNotNullParameter(r100, "attachmentEntity");
        tt5.a.h("AttachmentCell", "onUpdateProgress " + r101 + ", " + r102 + ' ' + r110 + ' ' + r100.getId());
        if (c(r101, r102) == false) goto L25;
        int r103 = this.f213797e.size();
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L16;
        UploadAttachmentEntity r105 = null;
        Object r106 = com.bytedance.ee.bear.bitable.m.j(this.f213797e, r104, null);
        if ((r106 instanceof UploadAttachmentEntity) == false) goto L10;
        r105 = (UploadAttachmentEntity) r106;
    L10:
        if (r105 == null) goto L15;
        if (r105.getPrimaryId() != r100.getPrimaryId()) goto L15;
    L17:
        tt5.a.h("AttachmentCell", "onUpdateProgress isCurrentCell index:" + r104);
        if (r104 == (-1)) goto L26;
        AttachmentGridView r107 = getMAttachmentGridView();
        r107.getClass();
        com.bytedance.ee.util.ui.j.f(new com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.g(r107, r104));
        return;
    L26:
        return;
    L15:
        r104 = r104 + 1;
        goto L6
    L16:
        r104 = -1;
        goto L17
    }

    @Override // jp4.a
    public final void z2(UploadAttachmentEntity r100, String r101, String r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "attachmentEntity");
        if (c(r101, r102) == false) goto L6;
        e(r100);
        return;
    }
}
