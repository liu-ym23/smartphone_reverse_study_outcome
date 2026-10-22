package com.bytedance.ee.bear.demo;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.contract.drive.DriveLocalFilePath;
import com.bytedance.ee.bear.drive.loader.download.platform.DriveDownloadUrlProvider;
import com.bytedance.ee.bear.drive.loader.download.platform.api.DriveFileInfoLoader;
import com.bytedance.ee.bear.drive.loader.download.platform.api.DriveImagePreviewLoader;
import com.bytedance.ee.bear.drive.loader.download.platform.api.DriveVideoPreviewLoader;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.drive.FileInfoV1Puller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.drive.PreviewGetV1Puller;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.drive.view.preview.imageviewer.OfficePhotoViewContainer;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.constants.AscOrder;
import com.bytedance.ee.bear.list.constants.RankType;
import com.bytedance.ee.bear.list.constants.ThumbnailPolicy;
import com.bytedance.ee.bear.list.cover.CoverLoader;
import com.bytedance.ee.bear.list.delete.DeleteExecutor;
import com.bytedance.ee.permission.PermissionSdk;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J\b\u0010$\u001a\u00020\u001fH\u0002J\b\u0010%\u001a\u00020\u001fH\u0002J\b\u0010&\u001a\u00020\u001fH\u0002J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010,\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010-\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)H\u0002J.\u0010.\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u001b2\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u000200H\u0002J \u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00102\u001a\u0002002\u0006\u00101\u001a\u000200H\u0002J \u00107\u001a\u0004\u0018\u0001062\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u001b2\u0006\u00101\u001a\u000200H\u0002J\b\u00108\u001a\u00020\u001fH\u0002J\u001d\u00109\u001a\u00020\u001f*\u00020:2\u000e\b\u0004\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001f0<H\u0082\bJ\b\u0010=\u001a\u00020\u001fH\u0002J\b\u0010>\u001a\u00020\u001fH\u0002J\b\u0010?\u001a\u00020\u001fH\u0002J\b\u0010@\u001a\u00020\u001fH\u0002J\u0012\u0010D\u001a\u00020\u001f2\b\b\u0002\u0010E\u001a\u00020CH\u0002J\b\u0010F\u001a\u00020\u001fH\u0002J\b\u0010G\u001a\u00020\u001fH\u0002J\b\u0010H\u001a\u00020\u001fH\u0002J\b\u0010I\u001a\u00020\u001fH\u0002J\b\u0010J\u001a\u00020\u001fH\u0002J\b\u0010K\u001a\u00020\u001fH\u0002J(\u0010L\u001a\u00020\u001f2\u0006\u0010M\u001a\u0002002\u0006\u0010N\u001a\u00020\u001c2\u0006\u0010O\u001a\u0002002\u0006\u0010P\u001a\u00020\u001cH\u0002J\b\u0010Q\u001a\u00020\u001fH\u0002J\b\u0010R\u001a\u00020\u001fH\u0002J\b\u0010S\u001a\u00020\u001fH\u0002J\b\u0010T\u001a\u00020\u001fH\u0002J\b\u0010U\u001a\u00020\u001fH\u0002J\b\u0010V\u001a\u00020\u001fH\u0002J\b\u0010W\u001a\u00020\u001fH\u0002J\b\u0010X\u001a\u00020\u001fH\u0002J\b\u0010Y\u001a\u00020\u001fH\u0002J\b\u0010Z\u001a\u00020\u001fH\u0002J\b\u0010[\u001a\u00020\u001fH\u0002J\u000e\u0010\\\u001a\u00020\u001f2\u0006\u0010]\u001a\u000200J\b\u0010^\u001a\u00020\u001fH\u0002J\b\u0010_\u001a\u00020`H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006a"}, d2 = {"Lcom/bytedance/ee/bear/demo/CCMFolderDemoActivity;", "Lcom/bytedance/ee/bear/facade/common/BaseCommonActivity;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "docsSdk", "Lcom/bytedance/ee/bear/office/export/docs/IDocsSdk;", "getDocsSdk", "()Lcom/bytedance/ee/bear/office/export/docs/IDocsSdk;", "setDocsSdk", "(Lcom/bytedance/ee/bear/office/export/docs/IDocsSdk;)V", "listLoader", "Lcom/bytedance/ee/bear/list/recent/ListLoader;", "moveExecutor", "Lcom/bytedance/ee/bear/list/move/MoveExecutor;", "permissionExecutor", "Lcom/bytedance/ee/bear/list/permission/PermissionExecutor;", "coverLoader", "Lcom/bytedance/ee/bear/list/cover/CoverLoader;", "logView", "Landroid/widget/TextView;", "coverView", "Landroid/widget/ImageView;", "iconView1", "iconView2", "iconView3", "doubaoObjTypeList", "", "", "thumbnailPolicy", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "mockGetDownloadAllUrl", "mockDeleteWiki", "mockDriveFileInfo", "mockDriveImagePreviewUrl", "mockLoadIcon", "showLocalImage", "container", "Landroid/widget/FrameLayout;", "showAssetWithOfficePhoto", "showAssetGifWithOfficePhoto", "showAssetHeifWithOfficePhoto", "showAssetPngWithOfficePhoto", "showOfficeAsset", "assetCandidates", "", "outputFileName", "previewExt", "buildPreviewModel", "Lcom/bytedance/ee/bear/drive/view/preview/wrapper/PreviewFileModel;", "cacheFile", "Ljava/io/File;", "cacheAsset", "clearText", "onClickClear", "Landroid/widget/Button;", "block", "Lkotlin/Function0;", "requestFileInfo", "requestPreviewGet", "requestTranscodeInfo", "cancelTranscodeRequest", "lastLabel", "hasMore", "", "mockRecent", "loadMore", "mockChildren", "mockDeleteOne", "mockDeleteMulti", "mockDeleteRecent", "mockDeleteMixed", "mockMove", "mockMoveUnified", "srcObjToken", "srcObjType", "destParentToken", "destParentObjType", "mockRenameFolder", "mockRenameFile", "mockQueryPermission", "mockQueryFolderPermission", "mockRequestPasswordCheck", "mockFetchDocPermission", "mockUpdateFolderLinkShare", "mockUpdateDocLinkShare", "mockCreateFolder", "mockCreateObject", "mockDownloadCover", "append", "text", "mockFetchImagePreview", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "office-ccm-demo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CCMFolderDemoActivity extends Hilt_CCMFolderDemoActivity implements d0c.c {

    @Inject
    public ik5.a d;
    public com.bytedance.ee.bear.list.recent.f e;
    public com.bytedance.ee.bear.list.move.f f;
    public nd5.d g;
    public final CoverLoader h;
    public TextView i;
    public ImageView j;
    public ImageView k;
    public ImageView l;
    public ImageView m;
    public final List<Integer> n;
    public final int o;
    public String p;
    public boolean q;

    public static final class a implements nc5.a<DocumentListInfo> {
        public final /* synthetic */ CCMFolderDemoActivity a;

        public a(CCMFolderDemoActivity r1) {
            this.a = r1;
        }

        public final void onFailure(Throwable r4) {
            Intrinsics.checkNotNullParameter(r4, "throwable");
            this.a.C1("recent failure: " + r4.getLocalizedMessage() + '\n');
            Log.e("CCMFolderDemo", "recent failure", r4);
        }

        public final void onSuccess(Object r4) {
            DocumentListInfo r5 = (DocumentListInfo) r4;
            Intrinsics.checkNotNullParameter(r5, "documentListInfo");
            this.a.q = r5.isHasMore();
            this.a.p = r5.getLastLabel();
            this.a.C1("recent success: documentListInfo:" + r5 + " size=" + r5.getDocumentList().size() + ", hasMore=" + this.a.q + ", lastLabel=" + this.a.p + '\n');
        }
    }

    public static final class a0 implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public a0(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r5 = this.b;
            r5.getClass();
            r5.C1("mockDriveImagePreviewUrl start, fileToken=Bdg7bvcGoohsExxkD2acvHmLnHg\n");
            new DriveFileInfoLoader().fetchFileInfo("Bdg7bvcGoohsExxkD2acvHmLnHg", FileInfoPuller.CALLER_EXPLORER, new com.bytedance.ee.bear.demo.i(r5));
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public b(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r5 = this.b;
            r5.getClass();
            r5.C1("mockQueryFolderPermission start, token=TLwdfOTu8lPrEmdV6tPcDloHnbd\n");
            nd5.d r0 = r5.g;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("permissionExecutor");
            r0 = null;
        L5:
            r0.a("TLwdfOTu8lPrEmdV6tPcDloHnbd", 0, new com.bytedance.ee.bear.demo.m(r5));
        }
    }

    public static final class b0 implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public b0(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r3 = this.b;
            r3.getClass();
            r3.C1("mockDeleteRecent start, token=OgjidjHLaomPCpxgIQDc2nXlnYg\n");
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public c(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r8 = this.b;
            r8.getClass();
            r8.C1("mockRequestPasswordCheck start, token=E531bP6oBoZA9axO7jNcaffsnjg, type=12, password=123456qazx\n");
            new PermissionSdk().a().e("E531bP6oBoZA9axO7jNcaffsnjg", 12, "123456qazx", false, new com.bytedance.ee.bear.demo.q(r8));
        }
    }

    public static final class c0 implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public c0(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r8 = this.b;
            r8.getClass();
            List r0 = CollectionsKt.listOf(new com.bytedance.ee.bear.list.delete.d[]{new com.bytedance.ee.bear.list.delete.d("FbWLdkqmgot1enxuKmUcCz8Knfv", 22, true), new com.bytedance.ee.bear.list.delete.d("OgjidjHLaomPCpxgIQDc2nXlnYg", 22, false), new com.bytedance.ee.bear.list.delete.d("TSXHdYiMDooktcxkHrxcKpSOnbh", 22, false)});
            r8.C1("mockDeleteMixed start, size=" + r0.size() + '\n');
            new DeleteExecutor().b(r0, new com.bytedance.ee.bear.demo.d(r8));
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public d(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r5 = this.b;
            r5.getClass();
            r5.C1("mockFetchDocPermission start, token=E531bP6oBoZA9axO7jNcaffsnjg, type=12\n");
            new PermissionSdk().a().c("E531bP6oBoZA9axO7jNcaffsnjg", 12, new com.bytedance.ee.bear.demo.j(r5));
        }
    }

    public static final class d0 implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public d0(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            CCMFolderDemoActivity.B1(this.a);
            this.b.F1(true);
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public e(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r6 = this.b;
            r6.getClass();
            r6.C1("mockUpdateFolderLinkShare start, token=TLwdfOTu8lPrEmdV6tPcDloHnbd, type=0, link_share_entity=1\n");
            nd5.d r0 = r6.g;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("permissionExecutor");
            r0 = null;
        L5:
            r0.b("TLwdfOTu8lPrEmdV6tPcDloHnbd", 0, 1, new com.bytedance.ee.bear.demo.s(r6));
        }
    }

    public static final class e0 implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public e0(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r5 = this.b;
            r5.getClass();
            r5.C1("mockDeleteOne start, token=FbWLdkqmgot1enxuKmUcCz8Knfv\n");
            new DeleteExecutor().e("FbWLdkqmgot1enxuKmUcCz8Knfv", 22, new com.bytedance.ee.bear.demo.f(r5));
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public f(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r6 = this.b;
            r6.getClass();
            r6.C1("mockUpdateDocLinkShare start, token=VZ0es0y8nlOItZd5vwFcU4r9nQh, type=30, link_share_entity=1\n");
            nd5.d r0 = r6.g;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("permissionExecutor");
            r0 = null;
        L5:
            r0.b("VZ0es0y8nlOItZd5vwFcU4r9nQh", 30, 1, new com.bytedance.ee.bear.demo.r(r6));
        }
    }

    public static final class f0 implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public f0(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r13) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r14 = this.b;
            r14.getClass();
            List r0 = CollectionsKt.listOf(new String[]{"nodcn2uWd7FdxOfHOcCDGBCCVSf", "nodcnCLv5Mn7OigIFXfPVwAIbjc"});
            r14.C1("mockDeleteMulti start, tokens=" + CollectionsKt.joinToString$default(r0, null, null, null, 0, null, null, 63, null) + '\n');
            new DeleteExecutor().c(r0, new com.bytedance.ee.bear.demo.e(r14));
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public g(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r5 = this.b;
            r5.getClass();
            r5.C1("mockCreateFolder start, name=new, source=0\n");
            new ce5.a(r5);
            new com.bytedance.ee.bear.list.create.i().g("new", "HDB8fk7lulJXGed3U17cqu3En6c", new com.bytedance.ee.bear.demo.b(r5));
        }
    }

    public static final class g0 implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public g0(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r8 = this.b;
            r8.getClass();
            r8.C1("mockMove start, src=D4kWd3kn3oMgvKx4C1RlKl1bg0c dest=\n");
            r8.C1("mockMoveUnified start, srcObjToken=D4kWd3kn3oMgvKx4C1RlKl1bg0c srcObjType=22 destParentToken= destParentObjType=4\n");
            com.bytedance.ee.bear.list.move.f r0 = r8.f;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("moveExecutor");
            r0 = null;
        L5:
            r0.h("D4kWd3kn3oMgvKx4C1RlKl1bg0c", 22, "", 4, new com.bytedance.ee.bear.demo.l(r8));
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public h(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r8 = this.b;
            r8.getClass();
            String r3 = UUID.randomUUID().toString();
            r8.C1("mockCreateObject start, type=22, parentToken=, uuid=" + r3 + '\n');
            new com.bytedance.ee.bear.list.create.i().a(22, "", r3, "121", new com.bytedance.ee.bear.demo.c(r8));
        }
    }

    public static final class h0 implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public h0(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r5 = this.b;
            r5.getClass();
            r5.C1("mockRenameFolder start, file_token=TLwdfOTu8lPrEmdV6tPcDloHnbd, new_name=Demo_New_Name\n");
            new qd5.b().p("TLwdfOTu8lPrEmdV6tPcDloHnbd", "Demo_New_Name", new com.bytedance.ee.bear.demo.p(r5));
        }
    }

    public static final class i implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public i(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Type inference failed for: r10v2, types: [android.app.Activity, com.bytedance.ee.bear.demo.CCMFolderDemoActivity, java.lang.Object] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            CCMFolderDemoActivity.B1(this.a);
            ?? r11 = this.b;
            r11.getClass();
            r11.runOnUiThread(new com.bytedance.ee.bear.demo.g(r11));
            int r6 = y9c.d.a(120);
            CoverLoader r1 = r11.h;
            ImageView r0 = r11.j;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("coverView");
            r0 = null;
        L5:
            Context r2 = r0.getContext();
            ImageView r12 = r11.j;
            if (r12 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("coverView");
            ImageView r3 = null;
        L9:
            r1.b(r2, r3, "QX6KbucnXooQMgxBQdCcwRunnZg", r6, r6, "near", 8);
            return;
        L8:
            r3 = r12;
            goto L9
        }
    }

    public static final class i0 implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public i0(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r5 = this.b;
            r5.getClass();
            r5.C1("mockRenameFile start, file_token=JpAAbZCdko4r5RxUCRhcrwlcnFb, name=Demo_New_Name.jpg\n");
            new qd5.b().o("JpAAbZCdko4r5RxUCRhcrwlcnFb", "Demo_New_Name.jpg", new com.bytedance.ee.bear.demo.o(r5));
        }
    }

    public static final class j implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public j(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r7 = this.b;
            ImageView r0 = r7.k;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("iconView1");
            r0 = null;
        L5:
            boolean r2 = mbb.c.a;
            IconShape r3 = IconShape.SQUARE;
            mbb.c.c(r0, "XpYPbdV3ZoPM9BxEWoMcuTb8nug", 0, r3, null);
            ImageView r1 = r7.l;
            if (r1 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("iconView2");
            r1 = null;
        L8:
            mbb.c.c(r1, "TSXHdYiMDooktcxkHrxcKpSOnbh", 22, r3, null);
            ImageView r8 = r7.m;
            if (r8 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("iconView3");
            r8 = null;
        L11:
            mbb.c.c(r8, "TazOsJXEVlSwoEdZ0U2cy1cunmh", 30, r3, null);
        }
    }

    public static final class j0 implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public j0(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r5 = this.b;
            r5.getClass();
            r5.C1("mockQueryPermission start, token=VZ0es0y8nlOItZd5vwFcU4r9nQh, type=30\n");
            nd5.d r0 = r5.g;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("permissionExecutor");
            r0 = null;
        L5:
            r0.a("VZ0es0y8nlOItZd5vwFcU4r9nQh", 30, new com.bytedance.ee.bear.demo.n(r5));
        }
    }

    public static final class k implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;
        public final /* synthetic */ FrameLayout c;

        public k(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2, FrameLayout r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r10 = this.b;
            FrameLayout r0 = this.c;
            r10.getClass();
            PolarisFileWrapper r1 = r10.D1(CollectionsKt.listOf("Unsplash-1.jpg"), "Unsplash-1.jpg");
            if (r1 != null) goto L5;
            r10.C1("asset image not found\n");
            return;
        L5:
            String r2 = r1.getAbsolutePath();
            DriveLocalFilePath r3 = new DriveLocalFilePath().localFilePath(r2);
            com.bytedance.ee.bear.drive.view.preview.wrapper.z r4 = new com.bytedance.ee.bear.drive.view.preview.wrapper.z();
            r4.d = r3;
            String r5 = FilesKt.getExtension(r1);
            if (r5.length() != 0) goto L8;
            boolean r6 = true;
        L9:
            if (r6 == false) goto L11;
            r5 = "jpg";
        L11:
            r4.c = r5;
            r4.a = r1.getName();
            UserSession r7 = r10.e9();
            AppCompatImageView r8 = r95.b.a(r10, r4, r7);
            r0.removeAllViews();
            Resources r11 = r10.getResources();
            r0.addView(r8, new FrameLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 200.0f, WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics()))));
            r8.setOnPhotoRequestListener(new com.bytedance.ee.bear.demo.u(r10));
            r8.c(r4, r7);
            return;
        L8:
            r6 = false;
            goto L9
        }
    }

    public static final class l implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public l(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            CCMFolderDemoActivity.B1(this.a);
            this.b.F1(false);
        }
    }

    public static final class m implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;
        public final /* synthetic */ FrameLayout c;

        public m(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2, FrameLayout r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r6 = this.b;
            FrameLayout r0 = this.c;
            r6.getClass();
            r6.G1(r0, CollectionsKt.listOf("Unsplash-1.jpg"), "Unsplash-1.jpg", "jpg");
        }
    }

    public static final class n implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;
        public final /* synthetic */ FrameLayout c;

        public n(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2, FrameLayout r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r6 = this.b;
            FrameLayout r0 = this.c;
            r6.getClass();
            r6.G1(r0, CollectionsKt.listOf(new String[]{"gif_test.gif", "gif_test"}), "gif_test.gif", "gif");
        }
    }

    public static final class o implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;
        public final /* synthetic */ FrameLayout c;

        public o(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2, FrameLayout r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r6 = this.b;
            FrameLayout r0 = this.c;
            r6.getClass();
            r6.G1(r0, CollectionsKt.listOf(new String[]{"heif_test.heic", "heif_test.heif", "heif_test"}), "heif_test.heic", "heic");
        }
    }

    public static final class p implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;
        public final /* synthetic */ FrameLayout c;

        public p(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2, FrameLayout r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r6 = this.b;
            FrameLayout r0 = this.c;
            r6.getClass();
            r6.G1(r0, CollectionsKt.listOf(new String[]{"png_test.png", "png_test"}), "png_test.png", "png");
        }
    }

    public static final class q implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;
        public final /* synthetic */ FrameLayout c;

        public q(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2, FrameLayout r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            CCMFolderDemoActivity.B1(this.a);
            this.b.G1(this.c, CollectionsKt.listOf(new String[]{"big_jpg.jpg", "big_jpg"}), "big_jpg.jpg", "jpg");
        }
    }

    public static final class r implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public r(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            CCMFolderDemoActivity.B1(this.a);
            this.b.C1("request file/info start\n");
            new FileInfoV1Puller.Params("boxcnfL3yvdMkmB3xbPs0CAuOBd", null, FileInfoPuller.CALLER_EXPLORER, null, null, null);
        }
    }

    public static final class s implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public s(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            CCMFolderDemoActivity.B1(this.a);
            this.b.C1("request preview/get start\n");
            new PreviewGetV1Puller.Params("CwSpbfeeYo7pR8xTp7pcyfyxn8g", null, FileInfoPuller.CALLER_EXPLORER, 3, false, null, null);
        }
    }

    public static final class t implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public t(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r4 = this.b;
            r4.C1("request transcode info start\n");
            new DriveVideoPreviewLoader().fetchDriveVideoPreview("XCTKbEVVkoGrAPxYr9ocNogknde", new com.bytedance.ee.bear.demo.t(r4));
        }
    }

    public static final class u implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public u(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            CCMFolderDemoActivity.B1(this.a);
            this.b.getClass();
        }
    }

    public static final class v implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public v(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r4 = this.b;
            r4.getClass();
            r4.C1("mockFetchImagePreview start, token=Bdg7bvcGoohsExxkD2acvHmLnHg\n");
            new DriveImagePreviewLoader().fetchDriveImagePreview("Bdg7bvcGoohsExxkD2acvHmLnHg", new com.bytedance.ee.bear.demo.k(r4));
        }
    }

    public static final class w implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public w(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r13) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r14 = this.b;
            r14.getClass();
            int r6 = RankType.EDIT_TIME.getValue();
            int r0 = AscOrder.DESC.getValue();
            r14.C1("mockChildren start, parentToken=\n");
            com.bytedance.ee.bear.list.recent.f r2 = r14.e;
            if (r2 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("listLoader");
            r2 = null;
        L5:
            com.bytedance.ee.bear.list.recent.f r1 = r2;
            r1.i("", "", Integer.valueOf(r0), r14.n, 10, r6, 1024, 1024, r14.o, new com.bytedance.ee.bear.demo.a(r14));
        }
    }

    public static final class x implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public x(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r13) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r14 = this.b;
            r14.getClass();
            List r0 = CollectionsKt.listOf(new String[]{"GI55d7U3ao0NDGx1gYml48pugHe", "CsJUdp9srooyI1xtHaFl492Wgte", "SuJqdudbFohDCmxFFiNl1YdxgsA"});
            CollectionsKt.listOf(new Integer[]{22, 22, 22});
            r14.C1("mockDeleteWiki start, tokens=" + CollectionsKt.joinToString$default(r0, null, null, null, 0, null, null, 63, null));
        }
    }

    public static final class y implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public y(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r5 = this.b;
            r5.getClass();
            r5.C1("mockGetDownloadAllUrl start, token=NUiub0cmMoIn2txFiJ1cgQybnIf\n");
            r5.C1("getDownloadAllUrl result: " + new DriveDownloadUrlProvider().getDownloadAllUrl("NUiub0cmMoIn2txFiJ1cgQybnIf") + '\n');
        }
    }

    public static final class z implements View.OnClickListener {
        public final /* synthetic */ CCMFolderDemoActivity a;
        public final /* synthetic */ CCMFolderDemoActivity b;

        public z(CCMFolderDemoActivity r1, CCMFolderDemoActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CCMFolderDemoActivity.B1(this.a);
            CCMFolderDemoActivity r5 = this.b;
            r5.getClass();
            r5.C1("mockDriveFileInfo start, token=Bdg7bvcGoohsExxkD2acvHmLnHg\n");
            new DriveFileInfoLoader().fetchFileInfo("Bdg7bvcGoohsExxkD2acvHmLnHg", null, new com.bytedance.ee.bear.demo.h(r5));
        }
    }

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.demo.Hilt_CCMFolderDemoActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(CCMFolderDemoActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L48;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.demo.Hilt_CCMFolderDemoActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(CCMFolderDemoActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public CCMFolderDemoActivity() {
        this.h = new CoverLoader();
        this.n = CollectionsKt.listOf(new Integer[]{0, 12, 22, 30});
        this.o = ThumbnailPolicy.NEAR.getValue();
    }

    public final UserSession e9() {
        return PassportcConvention.a(LarkContext.getApplication());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m121provideComponent() {
        return provideComponent();
    }

    public static final void B1(CCMFolderDemoActivity r1) {
        TextView r2 = r1.i;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("logView");
        r2 = null;
    L5:
        r2.setText("");
    }

    public final void C1(String r4) {
        Intrinsics.checkNotNullParameter(r4, "text");
        TextView r0 = this.i;
        LinearLayout r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("logView");
        r0 = null;
    L5:
        r0.append(r4);
        TextView r5 = this.i;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("logView");
        r5 = null;
    L8:
        ViewParent r6 = r5.getParent();
        if ((r6 instanceof LinearLayout) == false) goto L11;
        r2 = (LinearLayout) r6;
    L11:
        if (r2 == null) goto L14;
        r2.setVisibility(0);
        return;
    }

    public final void F1(boolean r11) {
        int r5 = RankType.VISIT_TIME.getValue();
        if (r11 == false) goto L6;
        String r12 = this.p;
        if (r12 == null) goto L6;
    L7:
        String r2 = r12;
        C1("mockRecent start, lastLabel=" + r2 + '\n');
        com.bytedance.ee.bear.list.recent.f r13 = this.e;
        if (r13 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("listLoader");
        r13 = null;
    L10:
        r13.d(r2, this.n, 10, r5, 1024, 1024, this.o, new a(this));
        return;
    L6:
        r12 = "";
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public final void onCreate(Bundle r38) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L7;
        v19.f.a(getTheme());     // Catch: Throwable -> L11
    L7:
        if (v19.f.f(this) == false) goto L9;
        v19.f.c(getTheme());     // Catch: Throwable -> L11
    L9:
        A1(r38);
        super.onCreate(r38);
        setContentView(2131558454);
        htb.a.a();
        new ce5.a(this);
        this.e = new com.bytedance.ee.bear.list.recent.f();
        this.f = new com.bytedance.ee.bear.list.move.f();
        this.g = new nd5.d();
        this.i = (TextView) findViewById(2131365352);
        this.j = (ImageView) findViewById(2131365347);
        this.k = (ImageView) findViewById(2131365348);
        this.l = (ImageView) findViewById(2131365349);
        this.m = (ImageView) findViewById(2131365350);
        Button r1 = (Button) findViewById(2131365334);
        Button r2 = (Button) findViewById(2131365312);
        Button r3 = (Button) findViewById(2131365317);
        Button r4 = (Button) findViewById(2131365316);
        Button r5 = (Button) findViewById(2131365329);
        Button r6 = (Button) findViewById(2131365330);
        Button r7 = (Button) findViewById(2131365336);
        Button r8 = (Button) findViewById(2131365335);
        Button r9 = (Button) findViewById(2131365333);
        Button r10 = (Button) findViewById(2131365332);
        Button r11 = (Button) findViewById(2131365337);
        Button r12 = (Button) findViewById(2131365324);
        Button r13 = (Button) findViewById(2131365346);
        Button r14 = (Button) findViewById(2131365345);
        Button r16 = (Button) findViewById(2131365313);
        Button r17 = (Button) findViewById(2131365314);
        Button r18 = (Button) findViewById(2131365321);
        Button r19 = (Button) findViewById(2131365328);
        Button r110 = (Button) findViewById(2131365343);
        Button r111 = (Button) findViewById(2131365341);
        Button r112 = (Button) findViewById(2131365339);
        Button r113 = (Button) findViewById(2131365340);
        Button r114 = (Button) findViewById(2131365342);
        Button r115 = (Button) findViewById(2131365338);
        Button r116 = (Button) findViewById(2131365325);
        Button r117 = (Button) findViewById(2131365331);
        Button r118 = (Button) findViewById(2131365344);
        Button r119 = (Button) findViewById(2131365311);
        Button r120 = (Button) findViewById(2131365327);
        Button r121 = (Button) findViewById(2131365319);
        Button r122 = (Button) findViewById(2131365320);
        Button r123 = (Button) findViewById(2131365322);
        Button r124 = (Button) findViewById(2131365323);
        Button r125 = (Button) findViewById(2131365318);
        Button r126 = (Button) findViewById(2131365315);
        FrameLayout r127 = (FrameLayout) findViewById(2131365353);
        r1.setOnClickListener(new l(this, this));
        r2.setOnClickListener(new w(this, this));
        r5.setOnClickListener(new d0(this, this));
        r3.setOnClickListener(new e0(this, this));
        r4.setOnClickListener(new f0(this, this));
        r6.setOnClickListener(new g0(this, this));
        r7.setOnClickListener(new h0(this, this));
        r8.setOnClickListener(new i0(this, this));
        r9.setOnClickListener(new j0(this, this));
        r10.setOnClickListener(new b(this, this));
        r11.setOnClickListener(new c(this, this));
        r12.setOnClickListener(new d(this, this));
        r13.setOnClickListener(new e(this, this));
        r14.setOnClickListener(new f(this, this));
        r16.setOnClickListener(new g(this, this));
        r17.setOnClickListener(new h(this, this));
        r18.setOnClickListener(new i(this, this));
        r19.setOnClickListener(new j(this, this));
        r110.setOnClickListener(new k(this, this, r127));
        r111.setOnClickListener(new m(this, this, r127));
        r112.setOnClickListener(new n(this, this, r127));
        r113.setOnClickListener(new o(this, this, r127));
        r114.setOnClickListener(new p(this, this, r127));
        r115.setOnClickListener(new q(this, this, r127));
        r116.setOnClickListener(new r(this, this));
        r117.setOnClickListener(new s(this, this));
        r118.setOnClickListener(new t(this, this));
        r119.setOnClickListener(new u(this, this));
        r120.setOnClickListener(new v(this, this));
        r121.setOnClickListener(new x(this, this));
        r122.setOnClickListener(new y(this, this));
        r123.setOnClickListener(new z(this, this));
        r124.setOnClickListener(new a0(this, this));
        r125.setOnClickListener(new b0(this, this));
        r126.setOnClickListener(new c0(this, this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final PolarisFileWrapper D1(List r7, String r8) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(getCacheDir(), r8);
        if (r0.exists() == false) goto L5;
        return r0;
    L5:
        Iterator r9 = r7.iterator();
    L7:
        if (r9.hasNext() == false) goto L31;
        String r10 = (String) r9.next();
        InputStream r11 = getAssets().open(r10);     // Catch: Exception -> L30
        PolarisFileOutputStreamWrapper r2 = new PolarisFileOutputStreamWrapper(r0);     // Catch: Throwable -> L25
        byte[] r3 = new byte[8192];     // Catch: Throwable -> L20
        int r4 = r11.read(r3);     // Catch: Throwable -> L20
    L14:
        if (r4 == (-1)) goto L16;
        r2.write(r3, 0, r4);     // Catch: Throwable -> L20
        r4 = r11.read(r3);     // Catch: Throwable -> L20
        goto L14
    L16:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L20
        goto L7
    L17:
        CloseableKt.closeFinally(r2, null);     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r11, null);     // Catch: Exception -> L30
        return r0;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);     // Catch: Exception -> L30
        throw th;     // Catch: Exception -> L30
    L31:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void G1(FrameLayout r2, List<String> r3, String r4, String r5) {
        PolarisFileWrapper r6 = D1(r3, r4);
        if (r6 != null) goto L6;
        C1("asset not found\n");
        return;
    L6:
        String r7 = r6.getAbsolutePath();
        DriveLocalFilePath r8 = new DriveLocalFilePath().localFilePath(r7);
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r0 = new com.bytedance.ee.bear.drive.view.preview.wrapper.z();
        r0.d = r8;
        r0.c = r5;
        r0.a = r4;
        OfficePhotoViewContainer r9 = new OfficePhotoViewContainer(this);
        ViewOwner r10 = new ViewOwner(this, this);
        r9.b = (PreviewViewModel) r10.viewModel(PreviewViewModel.class);
        r9.c = (DriveComponentRenderVM) r10.viewModel(DriveComponentRenderVM.class);
        r9.setUserAbility(new a95.a());
        r9.g = r0;
        r2.removeAllViews();
        r2.addView(r9, new FrameLayout.LayoutParams(-1, -1));
        r9.a();
    }
}
