package com.bytedance.ee.bear.bitable.card.view.cell.attachment;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import bb5.j;
import com.bytedance.ee.bear.bitable.card.model.enums.ETableType;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.CardOperationModel;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.upload.BitableAttachmentUploadManagerV2;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.upload.PendingUploadAttachmentEntity;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.upload.UploadAttachmentEntity;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentAdapter;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentGridView;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentMediaPickerPanel;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentMenuEnum;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.PageAttachmentView;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.h;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.i;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.l;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.m;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.p;
import com.bytedance.ee.bear.bitable.card.view.membrane.AsyncPrefetchAndRecyclePool;
import com.bytedance.ee.bear.bitable.card.view.membrane.AsyncPrefetchAndRecyclePool$recycledViewPool$1;
import com.bytedance.ee.bear.bitable.card.viewmodel.BitableCardViewModel;
import com.bytedance.ee.bear.bitable.card.viewmodel.y1;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.n;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.LocalOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceThirdPartyOpenEntity;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.documentinfo.BlockInfo;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.drive.sdk.service.f;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.SaveToLocalMenuV2;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.fileselector.api.FileType;
import com.bytedance.ee.bear.fileselector.bean.FileBean;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UiType;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import hp4.u;
import io.reactivex.disposables.CompositeDisposable;
import ip4.e;
import ip4.g;
import ip4.o;
import ip4.q;
import ip4.r;
import ip4.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import jq4.k;
import kotlin.jvm.internal.Intrinsics;
import sa5.w;

/* JADX INFO: loaded from: classes15.dex */
public class AttachmentCellViewHolder extends BaseCellViewHolder<List<AttachmentEntity>, List<AttachmentEntity>> implements p, jp4.a, u {

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final /* synthetic */ int f207275k0 = 0;
    public final View F;
    public final AttachmentGridView G;
    public final View H;
    public final AppCompatImageView I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f207276J;
    public AttachmentMediaPickerPanel K;
    public final k L;
    public final CompositeDisposable M;
    public final b N;
    public w O;
    public final com.bytedance.ee.bear.bitable.card.view.cell.attachment.upload.a P;
    public final BitableCardViewModel Q;
    public final DocViewModel R;
    public final jp4.b S;
    public boolean T;
    public boolean U;
    public dp4.a<List<AttachmentEntity>> V;
    public ArrayList<UploadAttachmentEntity> W;
    public final List<AttachmentEntity> X;
    public final PermissionResponse Y;
    public final Runnable Z;

    public class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachmentCellViewHolder f207277a;

        public a(AttachmentCellViewHolder r100) {
            this.f207277a = r100;
        }

        @Override // bb5.c
        public final void a(FileType r100) {
            AttachmentCellViewHolder r101 = this.f207277a;
            int r102 = AttachmentCellViewHolder.f207275k0;
            if (r101.f207229a.getActivity() == null) goto L6;
            HashMap r103 = new HashMap();
            r103.put("num", String.valueOf(2));
            String r104 = xo5.a.d(this.f207277a.f207229a.getActivity(), R.string.Bitable_Download_UploadAttachmentExceedMax_Toast, r103);
            Toast.showText(this.f207277a.f207229a.getActivity(), r104);
            return;
        }
    }

    public class b implements AttachmentAdapter.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachmentCellViewHolder f207278a;

        public b(AttachmentCellViewHolder r100) {
            this.f207278a = r100;
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentAdapter.a
        public final void b(UploadAttachmentEntity r100) {
            AttachmentCellViewHolder r101 = this.f207278a;
            int r102 = AttachmentCellViewHolder.f207275k0;
            r101.f207229a.q0().K();
            this.f207278a.P.removeUploadTasks(r100);
            this.f207278a.T4(r100);
            ((f) org.koin.java.a.a(f.class)).d0().d(new String[]{r100.getUploadTaskKey()});
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentAdapter.a
        public final void a(AttachmentMenuEnum r100, AttachmentEntity r101) {
            if (r100 != AttachmentMenuEnum.DELETE) goto L13;
            AttachmentCellViewHolder r102 = this.f207278a;
            int r103 = AttachmentCellViewHolder.f207275k0;
            if (r102.f207235g.f486413e == false) goto L14;
            r102.f207229a.q0().k(BitableAnalytic.AttachmentOperationAction.DELETE, 1);
            this.f207278a.f207229a.q0().r();
            if ((r101 instanceof PendingUploadAttachmentEntity) == false) goto L10;
            PendingUploadAttachmentEntity r104 = (PendingUploadAttachmentEntity) r101;
            this.f207278a.P.removeUploadTasks(r104);
            this.f207278a.T4(r104);
            ArrayList r105 = new ArrayList();
            r105.add(r101);
            this.f207278a.X3(r105, CardOperationModel.PayloadBean.EditType.DELETE_LOCAL, r105);
            return;
        L10:
            if (r101.getClass().equals(AttachmentEntity.class) == false) goto L16;
            ArrayList r106 = new ArrayList();
            r106.add(r101);
            this.f207278a.X3(r106, "delete", r106);
            return;
        L16:
            return;
        L14:
            return;
        }
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachmentCellViewHolder f207279a;

        public c(AttachmentCellViewHolder r100) {
            this.f207279a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            AttachmentCellViewHolder r101 = this.f207279a;
            int r102 = AttachmentCellViewHolder.f207275k0;
            r101.a4();
        }
    }

    public class d extends za5.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachmentCellViewHolder f207280a;

        @Override // za5.b, za5.a
        public final void b() {
            this.f207280a.c4();
        }

        public d(AttachmentCellViewHolder r100) {
            this.f207280a = r100;
        }

        @Override // za5.b, za5.a
        public final void c(List<? extends FileBean> r110) {
            tt5.a.h("AttachmentCellViewHolder", "select media... size = " + r110.size());
            final ArrayList r100 = new ArrayList();
            Iterator<? extends FileBean> r101 = r110.iterator();
        L4:
            if (r101.hasNext() == false) goto L17;
            FileBean r102 = r101.next();
            String r103 = r102.getMimeType();
            if (com.bytedance.ee.bear.bitable.c.m() == false) goto L15;
            if (this.f207280a.U == false) goto L15;
            if (TextUtils.isEmpty(r103) == true) goto L4;
            if (r103.startsWith("image") == true) goto L15;
            if (r103.startsWith("video") == false) goto L4;
        L15:
            r100.add(r102);
            goto L4
        L17:
            if (r110.size() == r100.size()) goto L19;
            com.bytedance.ee.util.ui.j.c(new q(this, r100));
        L19:
            this.f207280a.c4();
            Iterator r104 = r100.iterator();
        L21:
            if (r104.hasNext() == false) goto L23;
            FileBean r105 = (FileBean) r104.next();
            AttachmentCellViewHolder r106 = this.f207280a;
            com.bytedance.ee.bear.bitable.card.view.cell.attachment.upload.a r107 = r106.P;
            String r108 = r106.f207229a.getUrl();
            String r109 = this.f207280a.f207229a.getObjToken();
            int r111 = this.f207280a.f207229a.getType();
            AttachmentCellViewHolder r112 = this.f207280a;
            r107.uploadSelectedAttachment(r105, r108, r109, r111, r112.V, r112.U4(), this.f207280a.T);
            BitableAnalytic r113 = this.f207280a.f207229a.q0();
            String r114 = FileUtils.s(r105.getPath());
            r113.getClass();
            HashMap r115 = new HashMap();
            r115.put("attach_file_type", r114);
            r113.s("bitable_upload_type", r115);
            goto L21
        L23:
            this.f207280a.f207229a.q0().k(BitableAnalytic.AttachmentOperationAction.UPLOAD, r110.size());
        }
    }

    @Override // jp4.a
    public final void q3(UploadAttachmentEntity r100, String r101, String r102, String r103) {
    }

    @Override // hp4.u
    public final boolean r2() {
        return false;
    }

    public final boolean U4() {
        cp4.b r100 = this.f207233e.f478254a;
        if (r100.g() == false) goto L5;
        return true;
    L5:
        if (this.Q.isNeedShowForm(r100) == true) goto L7;
    L12:
        return false;
    L7:
        if (r100.E == null) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == true) goto L12;
        return true;
    L9:
        r101 = false;
        goto L10
    }

    public final void V4() {
        if (this.f207235g.f486413e == false) goto L11;
        this.G.setCustomMenus(new AttachmentMenuEnum[]{AttachmentMenuEnum.DELETE});
        int r100 = com.bytedance.ee.bear.bitable.c.f207079a;
        int r101 = n.f214744a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.fix_attach_cell_view_holder_leak") == true) goto L7;
        this.O = new e(this);
    L10:
        this.f207229a.c(this.O);
        return;
    L7:
        if (this.O != null) goto L10;
        this.O = new ip4.d(this);
        goto L10
    L11:
        this.G.setCustomMenus(null);
    }

    public final void W4() {
        ((ArrayList) this.X).clear();
        ArrayList<UploadAttachmentEntity> r100 = this.W;
        if (r100 != null) goto L5;
    L7:
        tt5.a.h("AttachmentCellViewHolder", "uploadingAttachmentList isEmpty");
    L8:
        List<AttachmentEntity> r101 = this.V.f469598l;
        if (r101 != null) goto L11;
    L14:
        List<AttachmentEntity> r102 = r101;
        if (hu5.a.f(r102) == false) goto L21;
        tt5.a.h("AttachmentCellViewHolder", "curAttachmentData size=" + r102.size());
        Iterator<AttachmentEntity> r103 = r102.iterator();
    L18:
        if (r103.hasNext() == false) goto L20;
        AttachmentEntity r104 = r103.next();
        r104.setAvailableLocalPath(this.P.findLocalPathIfAttachmentUploadedManually(r104.getAttachmentToken()));
        goto L18
    L20:
        ((ArrayList) this.X).addAll(r102);
    L22:
        boolean r105 = true;
        if (this.f207239k == false) goto L107;
        int r106 = com.bytedance.ee.bear.bitable.c.f207079a;
        int r107 = 0;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.itemview.attachment.large.style") == true) goto L27;
    L29:
        int r108 = l4();
        if (hu5.a.d(this.X) == false) goto L32;
    L34:
        int r109 = j4();
        if (r108 >= r109) goto L53;
        AttachmentGridView r110 = this.G;
        if (r110 == null) goto L40;
        r109 = r109 + ((int) r110.getItemWidthMargin());
    L40:
        List<AttachmentEntity> r111 = this.X;
        if (r111 == null) goto L52;
        Iterator r112 = ((ArrayList) r111).iterator();
    L44:
        if (r112.hasNext() == false) goto L52;
        AttachmentEntity r113 = (AttachmentEntity) r112.next();
        AttachmentGridView r114 = this.G;
        if (r114 == null) goto L48;
        int r115 = (int) r114.getItemWidth();
    L49:
        r108 = r108 + r115;
        if (r108 < r109) goto L44;
    L48:
        r115 = 0;
    L52:
        r105 = false;
    L53:
        View r116 = this.f207244p;
        if (r116 == null) goto L66;
        if (r105 == false) goto L57;
        int r117 = -1;
    L58:
        r116.getLayoutParams().width = r117;
        if (r105 == false) goto L62;
        P4(com.bytedance.ee.util.ui.n.c(16.0f), com.bytedance.ee.util.ui.n.c(16.0f));
        goto L66
    L62:
        if (hu5.a.d(this.X) == true) goto L64;
        com.bytedance.ee.util.ui.n.c(1.8f);
    L65:
        P4(com.bytedance.ee.util.ui.n.d(12), com.bytedance.ee.util.ui.n.d(12));
        goto L66
    L64:
        com.bytedance.ee.util.ui.n.d(12);
        goto L65
    L57:
        r117 = -2;
    L66:
        BitableCardViewModel r118 = this.Q;
        if (r118 != null) goto L69;
    L105:
        this.G.c(r105);
        this.G.setData(this.X);
    L113:
        com.bytedance.ee.util.ui.j.f(new ip4.a(this));
        V4();
        return;
    L69:
        if (r118.getMembraneManager() == null) goto L105;
        if ((this.G instanceof PageAttachmentView) == false) goto L113;
        int r119 = j4();
        if (r105 == true) goto L75;
        this.G.c(false);
    L104:
        this.G.setData(this.X);
        goto L113
    L75:
        if (this.f207235g.f486413e == false) goto L77;
        Integer r120 = Integer.valueOf(r119 - com.bytedance.ee.util.ui.n.d(52));
    L78:
        PageAttachmentView r121 = (PageAttachmentView) this.G;
        Integer r122 = Integer.valueOf(((ArrayList) this.X).size());
        r121.getClass();
        if (r122 == null) goto L81;
        int r123 = r122.intValue();
    L82:
        if (r120 == null) goto L85;
        r107 = r120.intValue();
    L85:
        if (r123 <= 0) goto L102;
        if (r107 <= 0) goto L102;
        int r124 = r107 / r121.f207456g;
        int r125 = (int) Math.ceil(((double) r123) / ((double) r124));
        p r126 = r121.getMAttachmentAdapter().f207382b;
        if (r126 == null) goto L97;
        y1 r127 = r126.getMembraneManager();
        if (r127 == null) goto L97;
        AsyncPrefetchAndRecyclePool r128 = r127.f209194a;
        if (r128 == null) goto L97;
        AsyncPrefetchAndRecyclePool$recycledViewPool$1 r129 = r128.f208449d;
        if (r129 == null) goto L97;
        r129.setMaxRecycledViews(R.id.attachment_cell_item_type, r125);
    L97:
        tt5.a.b("PageAttachmentView", "setFixedSize rowsNum=" + r125 + " columnsNum=" + r124);
        if (r125 < 10) goto L100;
        int r130 = r121.f207457h * 10;
    L101:
        ViewGroup.LayoutParams r131 = r121.getMRecyclerView().getLayoutParams();
        r131.width = r107;
        r131.height = r130;
        goto L104
    L100:
        r130 = r125 * r121.f207457h;
    L102:
        tt5.a.h("PageAttachmentView", "setFixedSize entityCount=" + r123 + " attachmentViewWidth=" + r107);
        r121.getMRecyclerView().getLayoutParams().height = -2;
        goto L104
    L81:
        r123 = 0;
        goto L82
    L77:
        r120 = Integer.valueOf(r119);
        goto L78
    L32:
        if (this.f207235g.f486413e == false) goto L34;
        r108 = r108 + com.bytedance.ee.util.ui.n.d(52);
        goto L34
    L27:
        if (hu5.a.d(this.X) == true) goto L29;
    L107:
        if (this.f207233e.f478254a.E == null) goto L112;
        Iterator r132 = ((ArrayList) this.X).iterator();
    L110:
        if (r132.hasNext() == false) goto L112;
        ((AttachmentEntity) r132.next()).userLocalPathRender = true;
    L112:
        this.G.setData(this.X);
        goto L113
    L21:
        tt5.a.h("AttachmentCellViewHolder", "curAttachmentData isEmpty");
        goto L22
    L11:
        if ((r101 instanceof List) == true) goto L14;
        tt5.a.h("AttachmentCellViewHolder", "curAttachmentData value illegal");
        return;
    L5:
        if (r100.isEmpty() == true) goto L7;
        tt5.a.h("AttachmentCellViewHolder", "uploadingAttachmentList size=" + this.W.size());
        ((ArrayList) this.X).addAll(this.W);
        goto L8
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder, com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void b0() {
        AttachmentGridView r100 = this.G;
        if (this.f207239k == false) goto L5;
        float r101 = 10.0f;
    L6:
        r100.b(r101);
        return;
    L5:
        r101 = 3.3f;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.p
    public final y1 getMembraneManager() {
        return this.Q.getMembraneManager();
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final void A() {
        super.A();
        if (this.f207239k == false) goto L5;
        return;
    L5:
        View r100 = this.F;
        boolean r101 = ((ArrayList) this.X).isEmpty();
        if (r100 != null) goto L8;
        return;
    L8:
        if (y4() == false) goto L13;
        if (r101 == false) goto L14;
        r100.setBackgroundResource(R.drawable.bitable_card_field_attachment_bg);
        return;
    L14:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [ip4.f, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final void Z3() {
        super.Z3();
        if (this.K != null) goto L5;
        this.K = new AttachmentMediaPickerPanel(this.F.getContext(), this.f207229a.q0(), this.f207229a.getFragment().getLifecycle());
    L5:
        final d r100 = new d(this);
        AttachmentMediaPickerPanel r101 = this.K;
        a r102 = new a(this);
        ?? r103 = new ip4.f(this);
        boolean r104 = this.T;
        boolean r105 = this.U;
        String r106 = null;
        if (Boolean.TRUE.equals(AppInfoUtils.f()) == true) goto L8;
        g r107 = 0;
    L9:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "fileSelectListener");
        Intrinsics.checkNotNullParameter(r102, "sizeCheckListener");
        Intrinsics.checkNotNullParameter(r103, "dismissListener");
        if (r104 == false) goto L12;
        r101.b(r100, r107);
    L23:
        this.P.shouldDisableLandscape(!ku5.c.k(this.F.getContext()));
        k r108 = this.L;
        if (r108 == null) goto L26;
        r108.d(this.F, this);
    L26:
        this.f207229a.q0().f();
        this.f207229a.q0().A(i4(), u4());
        return;
    L12:
        com.bytedance.ee.bear.widgets.a r109 = new com.bytedance.ee.bear.widgets.a(r101.f207427a);
        if (r105 == true) goto L15;
    L19:
        Context r110 = r101.f207427a;
        if (r110 == null) goto L22;
        r106 = r110.getString(R.string.Bitable_Attachment_UploadMethod);
    L22:
        r109.k(r106);
        r109.e(R.string.Bitable_Attachment_Camera, new h(r101, r100, r107));
        r109.e(R.string.Bitable_Attachment_Photo, new i(r101, r100, r102));
        r109.e(R.string.Bitable_Attachment_LocalFile, new com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.j(r101, r100, r102));
        r109.b(new com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.k(r101));
        r109.f240136b.f284132c.onCancelListener(new l(r101));
        r109.p(new m(r103));
        r109.q();
        BitableAnalytic r111 = r101.f207428b;
        r111.getClass();
        r111.t("ccm_bitable_card_attachment_choose_view", new HashMap());
        goto L23
    L15:
        if (com.bytedance.ee.bear.bitable.c.m() == false) goto L19;
        Context r112 = r101.f207427a;
        if (r112 == null) goto L22;
        r106 = r112.getString(R.string.Bitabe_DB_AttachmentField_OnlyPhotosAndVideosAllowed_Desc_Mob);
        goto L22
    L8:
        r107 = new g(this, r100);
        goto L9
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final void c4() {
        super.c4();
        k r100 = this.L;
        if (r100 == null) goto L6;
        r100.f(this.F, this);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final void s4() {
        super.s4();
        this.G.setGridViewClickListener(new c(this));
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder, com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void u() {
        super.u();
        this.M.dispose();
        int r100 = com.bytedance.ee.bear.bitable.c.f207079a;
        int r101 = n.f214744a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.fix_attach_cell_view_holder_leak") == false) goto L7;
        AttachmentMediaPickerPanel r102 = this.K;
        if (r102 == null) goto L7;
        ((CompositeDisposable) r102.f207430d.getValue()).clear();
        r102.a();
    L7:
        this.P.unregisterFileUploadStatusListener(this.S);
        w r103 = this.O;
        if (r103 == null) goto L11;
        this.f207229a.b(r103);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final View getContentView() {
        return this.F;
    }

    public static boolean R4(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (s.d(r100) == false) goto L8;
    L9:
        return true;
    L8:
        if (s.c(r100) == true) goto L9;
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder, com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void M2(boolean r100) {
        super.M2(r100);
        com.bytedance.ee.util.ui.j.f(new ip4.a(this));
        V4();
        AttachmentGridView r101 = this.G;
        if (r101.f207421c == r100) goto L6;
        r101.f207421c = r100;
        return;
    }

    public final void T4(UploadAttachmentEntity r100) {
        tt5.a.h("AttachmentCellViewHolder", "removeAttachment: primaryId=" + r100.getPrimaryId());
        ArrayList<UploadAttachmentEntity> r101 = this.W;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.contains(r100) == false) goto L9;
        this.W.remove(r100);
        W4();
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.p
    public final void b1(int r210) {
        if (this.Q.getEnableFollow().getValue() != Boolean.TRUE) goto L5;
        boolean r100 = true;
    L6:
        ArrayList r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        if (((ArrayList) this.X).isEmpty() == false) goto L9;
        r r103 = new r(0, null, r101, r102);
    L88:
        BaseOpenEntity r104 = r103.f495294b;
        tt5.a.h("AttachmentCellViewHolder", "finalIndex:" + r103.f495293a + " originIndex:" + r210);
        if (r104 != null) goto L92;
        tt5.a.h("AttachmentCellViewHolder", "originClickEntity is null");
        return;
    L92:
        BaseOpenEntity r105 = r103.f495294b;
        if (r105 == null) goto L125;
        if (R4(r105.getFileName()) == false) goto L120;
        if (r100 == false) goto L109;
        ArrayList r106 = new ArrayList();
        Iterator<SpaceThirdPartyOpenEntity> r107 = r103.f495296d.iterator();
    L100:
        if (r107.hasNext() == false) goto L105;
        SpaceThirdPartyOpenEntity r108 = r107.next();
        if (R4(r108.getFileName()) == false) goto L100;
        r106.add(r108);
        goto L100
    L105:
        if ((r105 instanceof SpaceThirdPartyOpenEntity) == false) goto L107;
        int r109 = r106.indexOf(r105);
    L108:
        r103.f495293a = r109;
        r103.f495296d.clear();
        r103.f495296d.addAll(r106);
        goto L125
    L107:
        r109 = 0;
        goto L108
    L109:
        ArrayList r110 = new ArrayList();
        Iterator<BaseOpenEntity> r111 = r103.f495295c.iterator();
    L111:
        if (r111.hasNext() == false) goto L115;
        BaseOpenEntity r112 = r111.next();
        if (R4(r112.getFileName()) == false) goto L111;
        r110.add(r112);
        goto L111
    L115:
        int r113 = r110.indexOf(r105);
        if (r113 != (-1)) goto L118;
        int r114 = 0;
    L119:
        r103.f495293a = r114;
        r103.f495295c.clear();
        r103.f495295c.addAll(r110);
        goto L125
    L118:
        r114 = r113;
        goto L119
    L120:
        r103.f495293a = 0;
        r103.f495296d.clear();
        r103.f495295c.clear();
        if ((r105 instanceof SpaceThirdPartyOpenEntity) == false) goto L123;
        r103.f495296d.add((SpaceThirdPartyOpenEntity) r105);
    L123:
        r103.f495295c.add(r105);
    L125:
        if (r100 == true) goto L127;
    L131:
        if (r100 == false) goto L133;
    L135:
        tt5.a.d("AttachmentCellViewHolder", "onAttachmentClick, openEntity is null");
        return;
    L133:
        if (r103.f495295c.isEmpty() == true) goto L135;
        this.f207229a.q0().k("preview", 1);
        ((com.bytedance.ee.bear.i) org.koin.java.a.a(com.bytedance.ee.bear.i.class)).h(this.f207229a.getActivity(), r103.f495295c, r103.f495293a);
        return;
    L127:
        if (r103.f495296d.isEmpty() == true) goto L131;
        this.f207229a.q0().k("preview", 1);
        dp4.a<List<AttachmentEntity>> r115 = this.V;
        if (r115 == null) goto L153;
        this.Q.updateAttachment(new AttachmentFollowData(r115.f469587a.f478255b, r115.f469588b.f464635b, (SpaceThirdPartyOpenEntity) ListProtector.get(r103.f495296d, r103.f495293a), this.V.f469588b.f464634a.f464660d, r103.f495293a, r103.f495296d));
        return;
    L153:
        return;
    L9:
        ArrayList<BaseMoreMenuAction> r116 = new ArrayList();
        r116.add(new SaveToLocalMenuV2());
        String r117 = String.valueOf(System.currentTimeMillis());
        this.Q.setCurOriginToken(r117);
        BaseOpenEntity r118 = null;
        int r119 = 0;
    L11:
        if (r119 >= ((ArrayList) this.X).size()) goto L70;
        AttachmentEntity r120 = (AttachmentEntity) ListProtector.get(this.X, r119);
        if (r120 != null) goto L16;
        BaseOpenEntity r121 = r118;
        int r122 = r119;
        String r123 = r117;
    L68:
        r118 = r121;
    L69:
        r119 = r122 + 1;
        r117 = r123;
        goto L11
    L16:
        if ((r120 instanceof PendingUploadAttachmentEntity) == false) goto L18;
        PendingUploadAttachmentEntity r124 = (PendingUploadAttachmentEntity) r120;
        r121 = r118;
        r122 = r119;
        r123 = r117;
        LocalOpenEntity r125 = new LocalOpenEntity("26_local", null, null, r124.getName(), null, r116, r124.getLocalPath());
    L34:
        r118 = r125;
    L60:
        if (r118 == null) goto L62;
        r118.setOriginToken(r123);
        r101.add(r118);
    L62:
        if (r100 == true) goto L64;
    L66:
        if (r122 != r210) goto L68;
    L64:
        if ((r118 instanceof SpaceThirdPartyOpenEntity) == false) goto L66;
        r102.add((SpaceThirdPartyOpenEntity) r118);
        goto L66
    L18:
        r121 = r118;
        r122 = r119;
        r123 = r117;
        if (TextUtils.isEmpty(r120.getAttachmentToken()) == true) goto L59;
        PendingUploadAttachmentEntity r126 = findPendingUploadAttachmentByFileToken(r120.getAttachmentToken());
        if (r126 == null) goto L23;
        r125 = new LocalOpenEntity("26_local", null, null, r126.getName(), null, r116, r126.getLocalPath());
        goto L34
    L23:
        BitableCardViewModel r127 = this.Q;
        dp4.a r128 = this.f207232d;
        if (r128 == null) goto L30;
        cp4.a r129 = r128.f469588b;
        if (r129 == null) goto L30;
        cp4.b r130 = r129.f464634a;
        if (r130 == null) goto L30;
        ETableType r131 = r130.f464675s;
    L32:
        if (r127.isTableAddType(r131) == false) goto L35;
        r125 = new LocalOpenEntity("26_local", null, null, r120.getName(), null, r116, r120.getAvailableLocalPath());
        goto L34
    L35:
        SpaceThirdPartyOpenEntity r132 = new SpaceThirdPartyOpenEntity("26", r120.getAttachmentToken(), r120.getName());
        r132.setApiExtra(r120.getExtra());
        r132.setMountPoint(r120.getMountPointType());
        r132.setMountNodeToken(r120.getMountNodeToken());
        r132.setPreviewFrom("bitable_attach");
        r132.setBusinessId("bitable_attach");
        r132.setDocToken(r120.getMountNodeToken());
        r132.setUniqueId(r120.getAttachmentToken());
        r132.setMoreMenuActions(r116);
        String r133 = this.R.getDocEncryptId();
        if (com.bytedance.ee.bear.bitable.utils.g.b() == false) goto L54;
        DocumentInfo r134 = this.R.getDocumentInfoProvider().g().getValue();
        if (r134 == null) goto L54;
        mr4.a r135 = this.f207229a.o();
        if (r135 != null) goto L42;
    L52:
        boolean r136 = false;
    L53:
        r132.setHostDocumentInfo(r134.convertToHostDocumentInfo());
    L55:
        r132.setEncryptId(r133);
        r132.setInBlock(r136);
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("admin.watermark.filewatermark.remaining") == false) goto L58;
        r132.setBizScene(DriveBizScene.DriveBizScene_BASE);
        r132.setWatermarkScene(DriveWatermarkScene.DriveWatermarkScene_BASE_ATTACHMENT_DOWNLOAD);
    L58:
        r118 = r132;
        goto L60
    L42:
        if (TextUtils.isEmpty(r135.f514980a) == false) goto L44;
    L46:
        boolean r137 = false;
    L47:
        if (r137 == false) goto L52;
        r132.setDocToken(r135.f514980a);
        BlockInfo r138 = r134.getBlockInfo(r135.f514980a);
        if (r138 == null) goto L51;
        r133 = r138.getEncryptId();
    L51:
        r136 = true;
        goto L53
    L44:
        if (r135.f514981b == null) goto L46;
        r137 = true;
    L54:
        r136 = false;
    L30:
        r131 = null;
        goto L32
    L59:
        r118 = null;
        goto L60
    L70:
        BaseOpenEntity r139 = r118;
        if (r100 == false) goto L73;
        ArrayList r140 = r102;
    L74:
        int r141 = 0;
    L76:
        if (r141 >= r140.size()) goto L81;
        if (r139 == ((BaseOpenEntity) ListProtector.get(r140, r141))) goto L82;
        r141 = r141 + 1;
    L82:
        if (r100 == false) goto L87;
        Iterator r142 = r102.iterator();
        int r143 = 0;
    L85:
        if (r142.hasNext() == false) goto L87;
        ((SpaceThirdPartyOpenEntity) r142.next()).setIndex(r143);
        r143 = r143 + 1;
    L87:
        r103 = new r(r141, r139, r101, r102);
        goto L88
    L81:
        r141 = 0;
        goto L82
    L73:
        r140 = r101;
        goto L74
    L5:
        r100 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.p
    public final PendingUploadAttachmentEntity findPendingUploadAttachmentByFileToken(String r100) {
        return this.P.findPendingUploadAttachmentByFileToken(r100);
    }

    @Override // hp4.u
    public final int getPanelHeight(Context r100) {
        AttachmentMediaPickerPanel r101 = this.K;
        if (r101 == null) goto L5;
        r101.getClass();
    L5:
        return 0;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder, com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void l2(dp4.a<List<AttachmentEntity>> r100) {
        super.l2(r100);
        this.V = r100;
        fp4.g r101 = this.f207233e;
        if ((r101 instanceof fp4.a) == false) goto L19;
        List<String> r102 = ((fp4.a) r101).f478233n;
        boolean r103 = true;
        if (r102 != null) goto L7;
    L9:
        boolean r104 = false;
    L10:
        this.T = r104;
        fp4.a r105 = (fp4.a) this.f207233e;
        List<String> r106 = r105.f478234o;
        if (r106 != null) goto L13;
    L17:
        r103 = false;
    L18:
        this.U = r103;
        goto L19
    L13:
        if (r106.contains("image") == true) goto L18;
        if (r105.f478234o.contains("video") == false) goto L17;
    L7:
        if (r102.isEmpty() == true) goto L9;
        r104 = true;
    L19:
        AttachmentGridView r107 = this.G;
        if (r107 == null) goto L23;
        r107.setAttachmentCoverViewEventListener(this.N);
    L23:
        if (this.f207276J == false) goto L25;
        this.f207276J = false;
        W4();
    L25:
        this.M.add(this.P.loadUploadingAttachmentList(r100, U4()).observeOn(fo5.d.d()).subscribe(new ip4.b(this), new ip4.c(this)));
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final void I4(Object r100, String r101) {
        dp4.a r102 = this.f207232d;
        if (r102 != null) goto L11;
        tt5.a.h("AttachmentCellViewHolder", "saveSubmitValue break cell isNull");
        return;
    L11:
        super.I4(S4(r101, (List) r102.f469599m, (List) r100), r101);     // Catch: ClassCastException -> L8
        return;
    L8:
        e = move-exception;
        tt5.a.e("AttachmentCellViewHolder", "saveSubmitValue failed", e, false);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final void N4(List<AttachmentEntity> r100, String r101) {
        List<AttachmentEntity> r102 = r100;
        dp4.a r103 = this.f207232d;
        if (r103 != null) goto L10;
        tt5.a.h("AttachmentCellViewHolder", "saveSubmitValue break cell isNull");
        return;
    L10:
        super.N4(S4(r101, (List) r103.f469598l, r102), r101);     // Catch: ClassCastException -> L7
        return;
    L7:
        e = move-exception;
        tt5.a.e("AttachmentCellViewHolder", "updateField failed", e, false);
    }

    public final boolean Q4(String r100, String r101) {
        dp4.a<List<AttachmentEntity>> r102 = this.V;
        if (r102 != null) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.equals(r102.f469587a.f478255b, r100) == false) goto L9;
        if (TextUtils.equals(this.V.f469588b.f464635b, r101) == false) goto L9;
        return true;
    }

    public static List S4(String r100, List r101, List r102) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        tt5.a.k("AttachmentCellViewHolder", "mergeAttachments invalid editType isEmpty");
    L5:
        HashSet r103 = new HashSet();
        ArrayList r104 = new ArrayList();
        if (hu5.a.f(r102) == false) goto L15;
        Iterator r105 = r102.iterator();
    L9:
        if (r105.hasNext() == false) goto L15;
        AttachmentEntity r106 = (AttachmentEntity) r105.next();
        if (TextUtils.equals(r100, CardOperationModel.PayloadBean.EditType.PRE_ADD) == false) goto L13;
        r104.add(r106);
    L13:
        r103.add(r106.getId());
    L15:
        if (hu5.a.f(r101) == false) goto L32;
        Iterator r107 = r101.iterator();
    L18:
        if (r107.hasNext() == false) goto L32;
        AttachmentEntity r108 = (AttachmentEntity) r107.next();
        if (TextUtils.equals(r100, CardOperationModel.PayloadBean.EditType.PRE_ADD) == true) goto L22;
        if (TextUtils.equals(r100, "delete") == false) goto L31;
        if (r103.contains(r108.getId()) == true) goto L18;
        r104.add(r108);
    L31:
        r103.add(r108.getId());
        goto L18
    L22:
        if (r103.contains(r108.getId()) == true) goto L18;
        r104.add(r108);
    L32:
        return r104;
    }

    @Override // jp4.a
    public final void D0(UploadAttachmentEntity r100, String r101, String r102) {
        if (Q4(r101, r102) == true) goto L5;
        return;
    L5:
        if (this.W != null) goto L8;
        this.W = new ArrayList();
    L8:
        if (this.W.contains(r100) == true) goto L10;
        ListProtector.add(this.W, 0, r100);
    L10:
        W4();
        boolean r103 = true;
        if ((r100 instanceof PendingUploadAttachmentEntity) == false) goto L13;
        r103 = true ^ ((PendingUploadAttachmentEntity) r100).isPendingUpload();
    L13:
        if (r103 == false) goto L17;
        this.f207229a.q0().J(r100.isCameraOnly());
        return;
    }

    @Override // jp4.a
    public final void s1(UploadAttachmentEntity r100, String r101, String r102, float r103) {
        if (Q4(r101, r102) == false) goto L22;
        int r104 = ((ArrayList) this.X).size();
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L14;
        AttachmentEntity r106 = (AttachmentEntity) ListProtector.get(this.X, r105);
        if ((r106 instanceof UploadAttachmentEntity) == false) goto L13;
        if (((UploadAttachmentEntity) r106).getPrimaryId() != r100.getPrimaryId()) goto L13;
    L15:
        if (r105 == (-1)) goto L23;
        AttachmentGridView r107 = this.G;
        r107.getClass();
        com.bytedance.ee.util.ui.j.f(new com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.g(r107, r105));
        return;
    L23:
        return;
    L13:
        r105 = r105 + 1;
        goto L6
    L14:
        r105 = -1;
        goto L15
    }

    @Override // jp4.a
    public final void z2(UploadAttachmentEntity r100, String r101, String r102, int r103) {
        if (Q4(r101, r102) == true) goto L5;
        return;
    L5:
        if (r100.getClass() != UploadAttachmentEntity.class) goto L9;
        T4(r100);
        return;
    }

    public AttachmentCellViewHolder(View r100, aq4.a r110, gp4.h r111, jq4.j r112, boolean r113) {
        super(r100, r110, r111, r113);
        this.f207276J = true;
        this.M = new CompositeDisposable();
        this.N = new b(this);
        this.U = false;
        this.X = new ArrayList();
        this.Y = null;
        this.Z = null;
        this.L = r112;
        com.bytedance.ee.bear.bitable.card.view.cell.attachment.upload.a r114 = (com.bytedance.ee.bear.bitable.card.view.cell.attachment.upload.a) com.bytedance.ee.bear.browser.plugin.q.a(r111.getFragment(), BitableAttachmentUploadManagerV2.class);
        this.P = r114;
        this.Q = (BitableCardViewModel) com.bytedance.ee.bear.browser.plugin.q.a(r111.getFragment(), BitableCardViewModel.class);
        if (this.D == false) goto L5;
        r114.addOnUploadedListener(new ip4.h(this));
    L5:
        this.R = (DocViewModel) com.bytedance.ee.bear.browser.plugin.q.a(r111.getFragment(), DocViewModel.class);
        mr4.a r101 = r111.o();
        if (r101 != null) goto L8;
    L10:
        String r102 = "";
    L11:
        gj5.c r103 = ((gj5.b) org.koin.java.a.a(gj5.b.class)).g("CCM_ATTACHMENT_UPLOAD", FileBizDomain.FileBizDomainCCM, 12, r102);
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        boolean r104 = jg5.e.a.f499003a.g();
        if (r104 == false) goto L14;
        BaseEntity r105 = new BaseEntity(r102, sbb.e.f541301l, BizDomain.FileBizDomainCCM, "");
        this.Y = ((ph5.b) org.koin.java.a.a(ph5.b.class)).f(new PermissionRequest(r105, "ATTACHMENT_UPLOAD"), null);
    L14:
        jp4.b r106 = new jp4.b(this);
        this.S = r106;
        r114.registerFileUploadStatusListener(r106);
        r114.setBitableCardDelegate(r111);
        if (r113 == false) goto L17;
        this.F = this.f207244p;
        this.f207248t.setImageResource(R.drawable.ud_icon_upload_outlined);
        this.f207248t.setOnClickListener(new ip4.i(this));
    L18:
        this.F.setPadding(0, com.bytedance.ee.util.ui.n.d(6), 0, com.bytedance.ee.util.ui.n.d(6));
        AttachmentGridView r115 = (AttachmentGridView) r100.findViewById(R.id.attachment_content);
        this.G = r115;
        if (r111.o() == null) goto L21;
        r115.f207423e = r111.o().f514980a;
        AttachmentAdapter r116 = r115.getMAttachmentAdapter();
        r116.f207384d = r115.f207423e;
    L21:
        r115.setAttachmentViewDelegate(this);
        View r117 = r100.findViewById(R.id.add_attachment_button_fl);
        this.H = r117;
        r117.setAlpha(1.0f);
        this.Z = new ip4.k(this);
        if (r103 != null) goto L24;
    L33:
        if (r104 == false) goto L42;
        PermissionResponse r118 = this.Y;
        if (r118 == null) goto L42;
        if (r118.getAllow() == true) goto L42;
        if (this.Y.getDenySource().getUiType() != UiType.DISABLED) goto L41;
        r117.setAlpha(0.5f);
    L41:
        this.Z = new o(this, r111);
    L42:
        r117.setOnClickListener(new ip4.p(this));
        this.I = (AppCompatImageView) r100.findViewById(R.id.add_attachment_button_image);
        return;
    L24:
        if (r103.f481503a == true) goto L33;
        if (r104 == true) goto L33;
        r117.setAlpha(0.5f);
        FileAuthResultFrom r119 = r103.f481504b;
        if (r119 != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L30;
        this.Z = new ip4.l(this);
        goto L33
    L30:
        if (r119 != FileAuthResultFrom.COME_FROM_AUTHZ) goto L32;
        this.Z = new ip4.m(r111);
        goto L33
    L32:
        this.Z = new ip4.n();
        goto L33
    L17:
        this.F = r100.findViewById(R.id.attachment_container);
        goto L18
    L8:
        if (TextUtils.isEmpty(r101.f514980a) == true) goto L10;
        r102 = r101.f514980a;
        goto L11
    }
}
