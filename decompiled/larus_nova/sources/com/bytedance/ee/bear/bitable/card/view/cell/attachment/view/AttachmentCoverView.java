package com.bytedance.ee.bear.bitable.card.view.cell.attachment.view;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.upload.PendingUploadAttachmentEntity;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.upload.UploadAttachmentEntity;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.middleground.drive.export.DriveFile;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.util.io.FileUtils;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.utils.statistics.PerfLog;
import ip4.s;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 X2\u00020\u0001:\u0001XB)\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010:\u001a\u0002082\u0006\u0010;\u001a\u00020(J\b\u0010<\u001a\u00020\u0007H\u0016J\u0010\u0010=\u001a\u00020(2\u0006\u0010>\u001a\u00020\u000bH\u0002J\u0016\u0010?\u001a\u0002082\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007J\b\u0010B\u001a\u0004\u0018\u00010*J\u000e\u0010C\u001a\u0002082\u0006\u0010D\u001a\u00020EJ\u0016\u0010F\u001a\u0002082\u0006\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u00020\u0007J\u0010\u0010I\u001a\u0002082\u0006\u0010H\u001a\u00020\u0007H\u0002J\b\u0010J\u001a\u000208H\u0014J\u001a\u0010K\u001a\u0002082\u0006\u0010L\u001a\u00020\u000b2\b\u0010M\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010N\u001a\u0002082\b\b\u0001\u0010O\u001a\u00020\u0007J\u0006\u0010P\u001a\u000208J\b\u0010Q\u001a\u000208H\u0002J\b\u0010R\u001a\u000208H\u0002J\u000e\u0010S\u001a\u0002082\u0006\u0010T\u001a\u00020\u0007J\u0010\u0010U\u001a\u0002082\b\u0010V\u001a\u0004\u0018\u00010WR\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u000e\u0010\u001e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0018\u00101\u001a\n 2*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\b3R\u000e\u00104\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/view/AttachmentCoverView;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "PROGRESS_FORMAT", "", "mCoverImageView", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "mCoverBorder", "Landroid/view/View;", "mPlaceholderContainer", "getMPlaceholderContainer", "()Landroid/view/View;", "setMPlaceholderContainer", "(Landroid/view/View;)V", "mPlaceholderIcon", "Landroid/widget/ImageView;", "getMPlaceholderIcon", "()Landroid/widget/ImageView;", "setMPlaceholderIcon", "(Landroid/widget/ImageView;)V", "mPlayVideoIcon", "getMPlayVideoIcon", "setMPlayVideoIcon", "mUploadBarContainer", "mUploadBar", "Landroid/widget/ProgressBar;", "imageLoadStatus", "Lcom/bytedance/ee/bear/middleground/drive/export/DriveFile$Status;", "uploadPercentView", "Landroid/widget/TextView;", "mCancelUploadView", "mSrcObjToken", "mCoverBorderVisible", "", "mAttachmentEntity", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/AttachmentEntity;", "attachmentViewDelegate", "Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/view/IAttachmentViewDelegate;", "getAttachmentViewDelegate", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/view/IAttachmentViewDelegate;", "setAttachmentViewDelegate", "(Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/view/IAttachmentViewDelegate;)V", "TAG", "kotlin.jvm.PlatformType", "TAG$1", "mOverrideWidth", "mOverrideHeight", "loadingDriveKey", "setSrcObjToken", "", "srcObjToken", "setBorderVisible", "visible", "getLayoutId", "isAllowFilePreview", "token", "setOverrideWidthAndHeight", "width", "height", "getCurrentEntity", "setCoverFitType", "scaleType", "Landroid/widget/ImageView$ScaleType;", ChameleonOpenTracker.Stage.RENDER, "attachmentEntity", "priority", "driveLoadImage", "onDetachedFromWindow", "renderCoverImage", "localPath", "fileName", "setCoverTint", "color", "clearCoverTint", "renderPlaceholderView", "renderUploadingView", "notifyUploadProgress", "uploadProgress", "setCancelUploadClickListener", "l", "Landroid/view/View$OnClickListener;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class AttachmentCoverView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f207398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LKUIRoundedImageView2 f207399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f207400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f207401d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f207402e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f207403f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f207404g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ProgressBar f207405h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DriveFile.Status f207406i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f207407j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f207408k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f207409l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f207410m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AttachmentEntity f207411n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public p f207412o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f207413p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f207414q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f207415r;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachmentCoverView f207416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f207417b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f207418c;

        public b(AttachmentCoverView r100, String r101, String r102) {
            this.f207416a = r100;
            this.f207417b = r101;
            this.f207418c = r102;
        }

        public final void a() {
            int r100 = this.f207416a.f207414q;
            if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.attachment_origin_size") == false) goto L5;
            r100 = Integer.MIN_VALUE;
            int r101 = Integer.MIN_VALUE;
        L6:
            ImageLoader.with(this.f207416a.getContext()).asBitmap().load(this.f207417b).diskCacheStrategy(DiskCacheStrategy.ALL).override(r100, r101).into(this.f207416a.f207399b);
            int r102 = 8;
            this.f207416a.getMPlaceholderContainer().setVisibility(8);
            this.f207416a.f207399b.setVisibility(0);
            AttachmentCoverView r103 = this.f207416a;
            View r104 = r103.f207400c;
            if (r103.f207410m == false) goto L9;
            int r105 = 0;
        L10:
            r104.setVisibility(r105);
            String r106 = this.f207418c;
            if (r106 == null) goto L17;
            ImageView r107 = this.f207416a.getMPlayVideoIcon();
            if (s.d(r106) == false) goto L15;
            r102 = 0;
        L15:
            r107.setVisibility(r102);
            return;
        L17:
            return;
        L9:
            r105 = 8;
            goto L10
        L5:
            r101 = r100;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
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

    public AttachmentCoverView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AttachmentCoverView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public int getLayoutId() {
        return R.layout.bitable_card_attachment_cover_view;
    }

    public final void d() {
        AttachmentEntity r100 = this.f207411n;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAttachmentEntity");
        r100 = null;
    L5:
        s.a r101 = s.b(r100.getName());
        this.f207401d.setVisibility(0);
        this.f207401d.setBackgroundColor(getResources().getColor(r101.f495304c));
        this.f207402e.setImageResource(kac.a.b(r101.f495303b));
        this.f207399b.setVisibility(8);
        this.f207400c.setVisibility(8);
        this.f207403f.setVisibility(8);
    }

    public final AttachmentEntity getCurrentEntity() {
        AttachmentEntity r100 = this.f207411n;
        if (r100 == null) goto L7;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mAttachmentEntity");
        goto L7
    L8:
        return r100;
    L7:
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int r100 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.itemview.fix.attachmentcover.rendererror") == true) goto L5;
        return;
    L5:
        if (this.f207415r == null) goto L9;
        ((w85.c) org.koin.java.a.c(w85.c.class, null, null, 6)).b(this.f207415r);
        return;
    }

    public final p getAttachmentViewDelegate() {
        return this.f207412o;
    }

    public final View getMPlaceholderContainer() {
        return this.f207401d;
    }

    public final ImageView getMPlaceholderIcon() {
        return this.f207402e;
    }

    public final ImageView getMPlayVideoIcon() {
        return this.f207403f;
    }

    public final void a(int r100) {
        if (r100 >= 1) goto L5;
        return;
    L5:
        this.f207405h.setProgress(r100);
        TextView r101 = this.f207407j;
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        r101.setText(String.format(this.f207398a, Arrays.copyOf(new Object[]{Integer.valueOf(r100)}, 1)));
    }

    public final void setAttachmentViewDelegate(p r100) {
        this.f207412o = r100;
    }

    public final void setBorderVisible(boolean r100) {
        this.f207410m = r100;
    }

    public final void setCancelUploadClickListener(View.OnClickListener r100) {
        View r101 = this.f207408k;
        if (r101 == null) goto L6;
        r101.setOnClickListener(r100);
        return;
    }

    public final void setCoverFitType(ImageView.ScaleType r100) {
        Intrinsics.checkNotNullParameter(r100, "scaleType");
        this.f207399b.setScaleType(r100);
    }

    public final void setCoverTint(int r100) {
        this.f207399b.setColorFilter(r100, PorterDuff.Mode.SRC_IN);
    }

    public final void setMPlaceholderContainer(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f207401d = r100;
    }

    public final void setMPlaceholderIcon(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f207402e = r100;
    }

    public final void setMPlayVideoIcon(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f207403f = r100;
    }

    public final void setSrcObjToken(String r100) {
        this.f207409l = r100;
    }

    public final void b(AttachmentEntity r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "attachmentEntity");
        tt5.a.h(this.f207413p, "render " + r110 + ", " + r111);
        this.f207411n = r110;
        AttachmentEntity r100 = null;
        if ((r110 instanceof UploadAttachmentEntity) == true) goto L5;
        this.f207404g.setVisibility(8);
        AttachmentEntity r101 = this.f207411n;
        if (r101 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mAttachmentEntity");
        r101 = null;
    L18:
        String r102 = r101.getName();
        if (s.a(r102) == true) goto L27;
        String r103 = FileUtils.s(r102);
        s.a[] r104 = s.f495301e;
        ArrayList r105 = new ArrayList(r104.length);
        int r106 = r104.length;
        int r107 = 0;
    L22:
        if (r107 >= r106) goto L27;
        String[] r108 = r104[r107].f495302a;
        Intrinsics.checkNotNull(r103);
        if (ArraysKt.contains(r108, r103.toLowerCase()) == true) goto L25;
        r105.add(Unit.INSTANCE);
        r107 = r107 + 1;
        goto L22
    L25:
        boolean r109 = true;
    L28:
        if (r109 == false) goto L85;
        String r112 = this.f207409l;
        if (r112 != null) goto L32;
        r112 = "";
    L32:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.f499003a.g() == false) goto L38;
        int r113 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.fix_attach_preview_over_permission") == false) goto L37;
        boolean r114 = f.a(r112);
    L39:
        if (r114 == true) goto L41;
        d();
        tt5.a.h(this.f207413p, "render cover, no preview permission");
        return;
    L41:
        p r115 = this.f207412o;
        if (r115 == null) goto L44;
        PendingUploadAttachmentEntity r116 = r115.findPendingUploadAttachmentByFileToken(r110.getAttachmentToken());
    L45:
        w85.c r117 = (w85.c) org.koin.java.a.c(w85.c.class, null, null, 6);
        AttachmentEntity r118 = this.f207411n;
        if (r118 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("mAttachmentEntity");
        r118 = null;
    L48:
        String r119 = r118.getAttachmentToken();
        DownloadRequestInfo.DownloadType r120 = DownloadRequestInfo.DownloadType.COVER;
        w85.b r121 = r117.c(r119, r120);
        int r122 = com.bytedance.ee.bear.bitable.c.f207079a;
        com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.itemview.fix.attachmentcover.rendererror");
        String r123 = this.f207413p;
        StringBuilder r124 = new StringBuilder("render cover, pendingUploadAttachmentEntity: ");
        if (r116 != null) goto L51;
        boolean r125 = true;
    L52:
        r124.append(r125);
        tt5.a.h(r123, r124.toString());
        if (r121 != null) goto L55;
        if (r116 == null) goto L59;
        c(r116.getLocalPath(), r116.getName());
        return;
    L59:
        AttachmentEntity r126 = this.f207411n;
        if (r126 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("mAttachmentEntity");
        r126 = null;
    L63:
        if (r126.userLocalPathRender == false) goto L75;
        AttachmentEntity r127 = this.f207411n;
        if (r127 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("mAttachmentEntity");
        r127 = null;
    L67:
        String r128 = r127.getAvailableLocalPath();
        if (r128 == null) goto L74;
        AttachmentEntity r129 = this.f207411n;
        if (r129 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("mAttachmentEntity");
    L73:
        c(r128, r100.getName());
        return;
    L72:
        r100 = r129;
        goto L73
    L74:
        d();
        return;
    L75:
        this.f207399b.setImageDrawable(null);
        d();
        this.f207406i = DriveFile.Status.READY;
        AttachmentEntity r130 = this.f207411n;
        if (r130 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("mAttachmentEntity");
        r130 = null;
    L78:
        e r131 = new e(this, r130.getAttachmentToken());
        w85.a.C8081a r132 = new w85.a.C8081a();
        r132.f558639a = true;
        AttachmentEntity r133 = this.f207411n;
        if (r133 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("mAttachmentEntity");
        r133 = null;
    L81:
        r132.f558643e = r133.getAttachmentToken();
        r132.f558640b = r120;
        r132.f558649k = new DownloadRequestInfo.b(1280, 1280, "near", false);
        r132.f558650l = r111;
        r132.f558648j = r131;
        AttachmentEntity r134 = this.f207411n;
        if (r134 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("mAttachmentEntity");
        r134 = null;
    L84:
        r132.f558651m = r134.getExtra();
        r132.f558645g = "bitable_image";
        this.f207415r = ((w85.c) org.koin.java.a.c(w85.c.class, null, null, 6)).d(new w85.a(r132)).f558657f;
        return;
    L55:
        if (this.f207406i != DriveFile.Status.SUCCESS) goto L92;
        c(r121.f558653b.getAbsolutePath(), r110.getName());
        return;
    L92:
        return;
    L51:
        r125 = false;
        goto L52
    L44:
        r116 = null;
        goto L45
    L37:
        r114 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(new BaseEntity(r112, sbb.e.f541301l, BizDomain.FileBizDomainCCM, ""), "CCM_FILE_PREVIEW"), null).getAllow();
        goto L39
    L38:
        r114 = ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g("CCM_FILE_PREVIEW", FileBizDomain.FileBizDomainCCM, 12, r112).f481503a;
        goto L39
    L85:
        d();
        tt5.a.h(this.f207413p, "render attachemnt : isSupportCover = false");
        return;
    L27:
        r109 = false;
        goto L28
    L5:
        if ((r110 instanceof PendingUploadAttachmentEntity) == false) goto L13;
        PendingUploadAttachmentEntity r135 = (PendingUploadAttachmentEntity) r110;
        if (s.d(r135.getName()) == false) goto L9;
    L12:
        c(r135.getLocalPath(), r135.getName());
        return;
    L9:
        if (s.c(r135.getName()) == true) goto L12;
        d();
        return;
    L13:
        d();
        this.f207404g.setVisibility(0);
        this.f207403f.setVisibility(8);
        this.f207399b.setImageDrawable(null);
        a(1);
    }

    public final void c(String r100, String r101) {
        com.bytedance.ee.util.ui.j.f(new b(this, r100, r101));
    }

    public AttachmentCoverView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f207398a = "%d%%";
        this.f207406i = DriveFile.Status.SUCCESS;
        this.f207409l = "";
        this.f207410m = true;
        this.f207413p = "AttachmentCoverView";
        this.f207414q = -1;
        LayoutInflater.from(r100).inflate(getLayoutId(), this);
        this.f207399b = (LKUIRoundedImageView2) findViewById(R.id.cover_view);
        this.f207400c = findViewById(R.id.cover_border);
        this.f207401d = findViewById(R.id.placeholder_container);
        this.f207402e = (ImageView) findViewById(R.id.placeholder_icon);
        this.f207403f = (ImageView) findViewById(R.id.play_video_icon);
        this.f207404g = findViewById(R.id.upload_widget_container);
        this.f207405h = (ProgressBar) findViewById(R.id.upload_progress_bar);
        this.f207407j = (TextView) findViewById(R.id.upload_percent);
        this.f207408k = findViewById(R.id.cancel_upload);
    }

    public /* synthetic */ AttachmentCoverView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
