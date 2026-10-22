package com.larus.drive.biz.impl.search.kmp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.flow.search.kmp.api.model.FlowSearchData;
import com.bytedance.flow.search.kmp.api.model.payload.RecentDrivePayload;
import com.bytedance.flow.search.kmp.api.spi.SearchDriveItem;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.biz.impl.sdk.DriveSdkService;
import com.larus.drive.sdk.api.IDriveSdkService;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.extension.aggregate_search_ui.api.BaseSearchListCell;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.utils.e1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import n79.f;
import n79.g;
import v19.b7;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/drive/biz/impl/search/kmp/KmpRecentDriveCell;", "Lcom/larus/extension/aggregate_search_ui/api/BaseSearchListCell;", "Lcom/larus/drive/biz/impl/search/kmp/KmpRecentDriveCellState;", "<init>", "()V", "layoutId", "", "getLayoutId", "()I", "iconView", "Landroid/widget/ImageView;", "thumbnailView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "titleView", "Landroid/widget/TextView;", "subtitleView", "currentSourceData", "Lcom/bytedance/flow/search/kmp/api/model/FlowSearchData;", "currentPayload", "Lcom/bytedance/flow/search/kmp/api/model/payload/RecentDrivePayload;", "onViewCreated", "", "view", "Landroid/view/View;", "onBindView", "state", "position", "bindDriveFileIcon", "fileItem", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpRecentDriveCell extends BaseSearchListCell<b> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f341237h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f341238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f341239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SimpleDraweeView f341240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f341241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f341242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FlowSearchData f341243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecentDrivePayload f341244g;

    public static final class a {
    }

    static {
    }

    public KmpRecentDriveCell() {
        this.f341238a = R.layout.larus_item_search_recent_drive;
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell
    public final int getLayoutId() {
        return this.f341238a;
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell, com.larus.list.arch.IFlowListCell
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        IOfficeSdkServiceV2 r101 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r101 == null) goto L5;
        IOfficeSdkServiceV2.a.b(r101, false, "kmp_recent_drive_cell", 5);
    L5:
        this.f341239b = (ImageView) r100.findViewById(R.id.image_recent_drive_icon);
        this.f341240c = (SimpleDraweeView) r100.findViewById(R.id.image_recent_drive_thumbnail);
        this.f341241d = (TextView) r100.findViewById(R.id.text_recent_drive_title);
        this.f341242e = (TextView) r100.findViewById(R.id.text_recent_drive_subtitle);
        r100.setOnClickListener(new f(this));
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell, com.larus.list.arch.IFlowListCell
    public final void onBindView(View r210, ei9.f r211, int r212) {
        b r100 = (b) r211;
        Intrinsics.checkNotNullParameter(r210, "view");
        Intrinsics.checkNotNullParameter(r100, "state");
        RecentDrivePayload r101 = r100.f341247a;
        this.f341243f = r101.f243291h;
        this.f341244g = r101;
        TextView r102 = this.f341241d;
        ImageView r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r102 = null;
    L5:
        r102.setText(r101.f243463i);
        long r104 = RangesKt.coerceAtLeast(r101.f243466l, r101.f243467m);
        TextView r105 = this.f341242e;
        if (r105 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("subtitleView");
        r105 = null;
    L9:
        if (r104 <= 0) goto L11;
        String r106 = b7.a(r104);
    L12:
        r105.setText(r106);
        String r110 = r101.f243463i;
        String r111 = r101.f243465k;
        SearchDriveItem r107 = r101.f243469o;
        if (r107 == null) goto L15;
        String r108 = r107.f243534c;
    L16:
        if (r108 != null) goto L18;
        String r112 = "";
    L19:
        if (r107 == null) goto L21;
        int r113 = r107.f243535d;
    L22:
        if (r107 == null) goto L24;
        String r109 = r107.f243536e;
    L25:
        if (r109 != null) goto L27;
        String r114 = "";
    L28:
        long r115 = r101.f243466l;
        long r116 = r101.f243467m;
        int r117 = r101.f243468n;
        if (r107 == null) goto L31;
        String r118 = r107.f243539h;
    L32:
        if (r118 != null) goto L34;
        String r213 = "";
    L35:
        DriveFileType.a r119 = DriveFileType.Companion;
        String r120 = r101.f243464j;
        r119.getClass();
        DriveFileType r121 = DriveFileType.a.a(r120);
        if (r121 != null) goto L38;
        r121 = DriveFileType.UNKNOWN;
    L38:
        DriveFileType r214 = r121;
        SearchDriveItem r122 = r101.f243469o;
        if (r122 == null) goto L41;
        int r215 = r122.f243541j;
    L42:
        if (r122 == null) goto L44;
        String r216 = r122.f243542k;
    L45:
        DriveFileItem r123 = new DriveFileItem(r110, r111, r112, r113, r114, r115, r116, r117, r213, r214, r215, r216);
        DriveSdkService r124 = DriveSdkService.f341224a;
        ImageView r125 = this.f341239b;
        if (r125 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r125 = null;
    L48:
        r124.F(r123, r125);
        if (r123.f341573j == DriveFileType.IMAGE) goto L51;
    L72:
        SimpleDraweeView r126 = this.f341240c;
        if (r126 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("thumbnailView");
        r126 = null;
    L75:
        e1.q(r126);
        ImageView r127 = this.f341239b;
        if (r127 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L79:
        e1.x(r103);
        return;
    L78:
        r103 = r127;
        goto L79
    L51:
        if (r123.h() == false) goto L72;
        String r128 = IDriveSdkService.a.b(r124, r123.f341565b, 120, 120);
        if (r128 != null) goto L62;
        SimpleDraweeView r129 = this.f341240c;
        if (r129 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("thumbnailView");
        r129 = null;
    L57:
        e1.q(r129);
        ImageView r130 = this.f341239b;
        if (r130 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L61:
        e1.x(r103);
        return;
    L60:
        r103 = r130;
        goto L61
    L62:
        SimpleDraweeView r131 = this.f341240c;
        if (r131 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("thumbnailView");
        r131 = null;
    L65:
        e1.x(r131);
        ImageView r132 = this.f341239b;
        if (r132 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r132 = null;
    L68:
        e1.q(r132);
        SimpleDraweeView r133 = this.f341240c;
        if (r133 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("thumbnailView");
        r133 = null;
    L71:
        ImageLoaderKt.v(r133, r128, "aggregate_search_driver", null, new g(this));
        return;
    L44:
        r216 = null;
        goto L45
    L41:
        r215 = 1;
        goto L42
    L34:
        r213 = r118;
        goto L35
    L31:
        r118 = null;
        goto L32
    L27:
        r114 = r109;
        goto L28
    L24:
        r109 = null;
        goto L25
    L21:
        r113 = 0;
        goto L22
    L18:
        r112 = r108;
        goto L19
    L15:
        r108 = null;
        goto L16
    L11:
        r106 = "";
        goto L12
    }
}
