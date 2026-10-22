package com.bytedance.ee.bear.drive.biz.comment;

import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.document.offline.file.upload.FileUploadModel;
import com.bytedance.ee.bear.drive.biz.extra_info.DriveSpaceFileExtraInfoViewPlugin;
import com.bytedance.ee.bear.drive.biz.extra_info.FileExtraInfoView;
import com.bytedance.ee.bear.drive.biz.extra_info.meta.DriveMetaInfoVM;
import com.bytedance.ee.bear.drive.biz.feed.DriveFeedVM;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.biz.preview.DrivePreviewContentPlugin;
import com.bytedance.ee.bear.drive.biz.preview.screen.DriveFullScreenVM;
import com.bytedance.ee.bear.drive.biz.preview.vc.DriveVCFollowPlugin;
import com.bytedance.ee.bear.drive.biz.preview.vc.comment.DriveDocCommentFollowConnector;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.view.preview.imageviewer.DrivePreviewViewPager;
import com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.comment.Comment;
import com.bytedance.ee.bear.middleground.comment.export.CommentBuilder;
import com.bytedance.ee.bear.middleground.comment.export.CommentStyle;
import com.bytedance.ee.bear.middleground.comment.export.CommentVoiceHostPolicy;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentArea;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.framework.utils.DeviceUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.translate.TranslateLanguageSetting;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 X2\u00020\u0001:\u0001XB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0006\u0010\u0013\u001a\u00020\u0010J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\u0017\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\u0017\u0010 \u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cJ\b\u0010!\u001a\u00020\"H\u0002J\u0006\u0010#\u001a\u00020\u0019J\u0006\u0010$\u001a\u00020\u0019J\u0006\u0010%\u001a\u00020\u0019J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010'\u001a\u00020(H\u0002J\b\u0010*\u001a\u00020\u0010H\u0016J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010,\u001a\u00020\u00102\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u00020\u0010H\u0002J\b\u00103\u001a\u00020\u0010H\u0002J\n\u0010:\u001a\u0004\u0018\u00010;H\u0002J\u0010\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020\u001bH\u0002J\b\u0010>\u001a\u00020\u0010H\u0002J\b\u0010C\u001a\u00020\u0010H\u0002J\b\u0010H\u001a\u00020\u0010H\u0002J\b\u0010I\u001a\u00020\u0010H\u0002J\b\u0010J\u001a\u00020\u0010H\u0002J\u000f\u0010K\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u0010LJ\b\u0010M\u001a\u00020\u0019H\u0002J\b\u0010N\u001a\u00020\u0019H\u0002J\b\u0010O\u001a\u00020\u0019H\u0002J\b\u0010P\u001a\u00020\u0019H\u0002J\b\u0010Q\u001a\u00020\u0019H\u0002J\b\u0010V\u001a\u00020\u0010H\u0002J\b\u0010W\u001a\u00020\u0010H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R!\u00104\u001a\b\u0012\u0004\u0012\u00020\u001b058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b6\u00107R#\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010@058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u00109\u001a\u0004\bA\u00107R!\u0010D\u001a\b\u0012\u0004\u0012\u00020E058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u00109\u001a\u0004\bF\u00107R\u0010\u0010R\u001a\u0004\u0018\u00010SX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010UX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/comment/DriveCommentPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "mLoadListener", "Lcom/bytedance/ee/bear/drive/core/load/IFileLoader$LoadListener;", "mCommentWrapper", "Lcom/bytedance/ee/bear/drive/biz/comment/DriveCommentWrapper;", "mPreviewContainer", "Landroid/view/ViewGroup;", "mAiContainerAbility", "Lcom/bytedance/ee/bear/drive/core/ai/IDrivePreviewAiContainerHostAbility;", "commentPanelAiBottomSuppressionOwner", "", "commentVoiceBarAiBottomSuppressionOwner", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "setupCommentIfNeed", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onAttachPreview", "canShowCommentEntry", "", "commentCount", "", "(Ljava/lang/Integer;)Z", "canCreateComment", "shouldOfferCreateWholeCommentFromPanel", "createWholeCommentFromPanel", "openCommentEntry", "resolveHeaderCommentEntryAction", "Lcom/bytedance/ee/bear/drive/biz/comment/DriveHeaderCommentEntryAction;", "canShowHeaderCommentEntry", "isHeaderCommentEntryEnabled", "openHeaderCommentEntry", "updateFileExtraView", "permissionVM", "Lcom/bytedance/ee/bear/drive/biz/permission/DriveMGPermissionVM;", "updateCommentByPermission", "onDetachPreview", "onDetachFromHost", "onConfigurationChanged", "newConfiguration", "Landroid/content/res/Configuration;", "showCommentPanelAfterPreviewLayout", JSEventListener.ACTION, "Ljava/lang/Runnable;", "releaseCommentPanelAiBottomSuppression", "releaseCommentVoiceBarAiBottomSuppression", "currentPageObserver", "Landroidx/lifecycle/Observer;", "getCurrentPageObserver", "()Landroidx/lifecycle/Observer;", "currentPageObserver$delegate", "Lkotlin/Lazy;", "createPdfCommentInputHint", "", "createPdfInputHint", "currentPageIndex", "observePdfCurrentPage", "translateSettingObserver", "Lcom/ss/android/lark/chat/entity/translate/TranslateLanguageSetting;", "getTranslateSettingObserver", "translateSettingObserver$delegate", "observeTranslateSetting", "commentMarkTypeObserver", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentArea$Type;", "getCommentMarkTypeObserver", "commentMarkTypeObserver$delegate", "observeCommentMarkType", "initPdfAreaMarker", "initSharedComment", "resolveIsPdfFile", "()Ljava/lang/Boolean;", "isPreviewReady", "isPdfMarkCommentEnabled", "shouldCreatePdfCurrentPageCommentFromHeader", "resolveCommentUsingNewUI", "isPdfFloatCommentEnable", "commentProtocol", "Lcom/bytedance/ee/bear/rn/RnCommentProtocol;", "commonPushProtocol", "Lcom/bytedance/ee/bear/rn/RnCommonPushProtocol;", "prepareRnInOfficeSdk", "releaseRnInOfficeSDK", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveCommentPlugin extends AbsDrivePlugin {
    public static final a Companion = null;
    private static final String FG_PDF_COMMENT_HALF_STYLE_NO_TTOFFICE = "ccm.mobile.drive_pdf_comment_half_style_no_ttoffice";
    public static final String TAG = "DriveComponent_DriveCommentPlugin";
    private final Lazy commentMarkTypeObserver$delegate;
    private final Object commentPanelAiBottomSuppressionOwner;
    private com.bytedance.ee.bear.rn.g commentProtocol;
    private final Object commentVoiceBarAiBottomSuppressionOwner;
    private com.bytedance.ee.bear.rn.h commonPushProtocol;
    private final Lazy currentPageObserver$delegate;
    private t75.i mAiContainerAbility;
    private a1 mCommentWrapper;
    private u75.b.a mLoadListener;
    private ViewGroup mPreviewContainer;
    private final Lazy translateSettingObserver$delegate;

    public static final class a {
        public a() {
        }
    }

    public static final class a0 implements Runnable {
        public final /* synthetic */ a1 a;

        public a0(a1 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a1 r0 = this.a;     // Catch: Throwable -> L4
            r0.A(null, false, r0.e());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements a1.h {
        public final /* synthetic */ DriveFeedVM a;

        public b(DriveFeedVM r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.drive.biz.comment.a1.h
        public final void g(List<String> r2) {
            if (this.a.getDriveFeedManager() == null) goto L7;
            com.bytedance.ee.bear.drive.biz.feed.c r0 = this.a.getDriveFeedManager();
            if (r0 == null) goto L9;
            r0.g(r2);
            return;
        L9:
            return;
        L7:
            tt5.a.d(DriveCommentPlugin.TAG, "readMessage failed! mDriveFeedManager is null!");
        }
    }

    public static final class b0 implements com.bytedance.ee.bear.rn.h.a {
        public static final b0 a = null;

        static {
            a = new b0();
        }

        public b0() {
        }

        public final void didReceivePush(String r1) {
        }
    }

    public static final class c implements FileExtraInfoView.a {
        public final /* synthetic */ DriveCommentPlugin a;

        @Override // com.bytedance.ee.bear.drive.biz.extra_info.FileExtraInfoView.a
        public final void a() {
            a1 r0 = DriveCommentPlugin.access$getMCommentWrapper$p(this.a);
            if (r0 == null) goto L6;
            r0.f.get().onAreaClick();
            return;
        }

        @Override // com.bytedance.ee.bear.drive.biz.extra_info.FileExtraInfoView.a
        public final void c() {
            a1 r0 = DriveCommentPlugin.access$getMCommentWrapper$p(this.a);
            if (r0 == null) goto L5;
            r0.g(false, null, null);
        L5:
            k75.a.c(this.a.getHost()).m(this.a.getHost().c.getFileModel(), "input", "ccm_comment_view");
        }

        public c(DriveCommentPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.drive.biz.extra_info.FileExtraInfoView.a
        public final void b(int r2) {
            this.a.openCommentEntry(Integer.valueOf(r2));
        }
    }

    public static final class d implements m1 {
        public final /* synthetic */ DriveCommentPlugin a;

        @Override // com.bytedance.ee.bear.drive.biz.comment.m1
        public final DrivePluginHost S() {
            return this.a.getHost();
        }

        @Override // com.bytedance.ee.bear.drive.biz.comment.m1
        public FragmentActivity getActivity() {
            return DriveCommentPlugin.access$getActivity(this.a);
        }

        public final View b() {
            return this.a.findViewById(2131379453);
        }

        public d(DriveCommentPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.drive.biz.comment.m1
        public final <T extends ViewModel> T a(Class<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "clazz");
            return (T) DriveCommentPlugin.access$viewModel(this.a, r2);
        }
    }

    public static final class e implements q1 {
        public final /* synthetic */ DriveCommentPlugin a;

        public e(DriveCommentPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.drive.biz.comment.q1
        public final AbsPreviewView get() {
            DrivePreviewContentPlugin r0 = (DrivePreviewContentPlugin) DriveCommentPlugin.access$findPlugin(this.a, DrivePreviewContentPlugin.class);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.currentPreviewView();
        }
    }

    public static final class f implements a1.e {
        public final /* synthetic */ DriveCommentPlugin a;

        @Override // com.bytedance.ee.bear.drive.biz.comment.a1.e
        public final void cancel() {
            DriveCommentPlugin.access$releaseCommentPanelAiBottomSuppression(this.a);
        }

        public f(DriveCommentPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.drive.biz.comment.a1.e
        public final void a(Runnable r2) {
            Intrinsics.checkNotNullParameter(r2, JSEventListener.ACTION);
            DriveCommentPlugin.access$showCommentPanelAfterPreviewLayout(this.a, r2);
        }
    }

    public static final class g extends u75.b.C0306b {
        public final /* synthetic */ DriveCommentPlugin a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ErrCode.values().length];
                r0[ErrCode.OWNER_DELETED_FILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[ErrCode.FILE_NOT_FOUND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public g(DriveCommentPlugin r1) {
            this.a = r1;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void b(com.bytedance.ee.bear.drive.view.preview.wrapper.z r3) {
            Intrinsics.checkNotNullParameter(r3, "previewFileModel");
            Intrinsics.checkNotNullParameter(r3, "previewFileModel");
            if (r3.q != 2) goto L13;
            a1 r4 = DriveCommentPlugin.access$getMCommentWrapper$p(this.a);
            if (r4 == null) goto L13;
            com.bytedance.ee.bear.drive.biz.comment.data.m r5 = r4.r;
            if (true == r5.n) goto L9;
            boolean r0 = true;
        L10:
            r5.n = true;
            if (r0 == false) goto L13;
            r5.i();
            goto L13
        L9:
            r0 = false;
        L13:
            a1 r6 = DriveCommentPlugin.access$getMCommentWrapper$p(this.a);
            if (r6 == null) goto L17;
            r6.s();
            return;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void c(ErrCode r2) {
            Intrinsics.checkNotNullParameter(r2, "code");
            int r3 = a.a[r2.ordinal()];
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // u75.b.C0306b, u75.b.a
        public final <T> void a(InfoCode r4, T r5) {
            Intrinsics.checkNotNullParameter(r4, "code");
            if (r4 == InfoCode.FileInfoSuccess) goto L5;
        L7:
            boolean r1 = false;
            boolean r2 = true;
            if (r4 != InfoCode.FileNotChange) goto L26;
            a1 r6 = DriveCommentPlugin.access$getMCommentWrapper$p(this.a);
            if (r6 != null) goto L12;
            return;
        L12:
            if (Intrinsics.areEqual(k75.a.i(this.a.getHost()).liveInnerAreaCommentEnableState().getValue(), Boolean.TRUE) == false) goto L21;
            f85.a r7 = (f85.a) this.a.getHost().c.getFileModel();
            if (r7 != null) goto L16;
        L18:
            boolean r8 = false;
        L19:
            if (r8 == false) goto L21;
        L22:
            r6.k = r2;
            com.bytedance.ee.bear.middleground.comment.export.h r9 = r6.c;
            if (r9 == null) goto L45;
            r9.l0(r2, false);
            return;
        L45:
            return;
        L16:
            if (r7.j() != true) goto L18;
            r8 = true;
        L21:
            r2 = false;
            goto L22
        L26:
            if (r4 == InfoCode.HitCache) goto L28;
            return;
        L28:
            if ((r5 instanceof w75.a) == true) goto L30;
        L39:
            a1 r10 = DriveCommentPlugin.access$getMCommentWrapper$p(this.a);
            if (r10 == null) goto L48;
            r10.s();
            return;
        L48:
            return;
        L30:
            if (((w75.a) r5).q != 2) goto L39;
            a1 r11 = DriveCommentPlugin.access$getMCommentWrapper$p(this.a);
            if (r11 == null) goto L39;
            com.bytedance.ee.bear.drive.biz.comment.data.m r12 = r11.r;
            if (true == r12.n) goto L36;
            r1 = true;
        L36:
            r12.n = true;
            if (r1 == false) goto L39;
            r12.i();
            goto L39
        L5:
            if ((r5 instanceof f85.a) == false) goto L7;
            this.a.setupCommentIfNeed();
            k75.a.i(this.a.getHost()).liveOuterSupportAreaComment().postValue(Boolean.valueOf(((f85.a) r5).j()));
        }
    }

    public static final class h implements a1.i {
        public final /* synthetic */ DriveFeedVM a;

        public h(DriveFeedVM r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.drive.biz.comment.a1.i
        public final void a(boolean r2, boolean r3) {
            if (this.a.getDriveFeedManager() == null) goto L8;
            com.bytedance.ee.bear.drive.biz.feed.c r0 = this.a.getDriveFeedManager();
            if (r0 == null) goto L9;
            r0.a(r2, r3);
            return;
        L9:
            return;
        }
    }

    public static final class i implements q1 {
        public final /* synthetic */ DriveCommentPlugin a;

        public i(DriveCommentPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.drive.biz.comment.q1
        public final AbsPreviewView get() {
            DrivePreviewContentPlugin r0 = (DrivePreviewContentPlugin) DriveCommentPlugin.access$findPlugin(this.a, DrivePreviewContentPlugin.class);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.currentPreviewView();
        }
    }

    public static final class j<T> implements Observer {
        public final /* synthetic */ DriveCommentPlugin a;

        public j(DriveCommentPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            int r0 = com.bytedance.ee.bear.drive.biz.preview.orientation.a.a;
            if (com.bytedance.ee.bear.drive.biz.preview.orientation.a.C0152a.b(DriveCommentPlugin.access$getActivity(this.a)) == false) goto L5;
        L8:
            a1 r1 = DriveCommentPlugin.access$getMCommentWrapper$p(this.a);
            if (r1 == null) goto L13;
            r1.g(Intrinsics.areEqual(r4, Boolean.TRUE), null, null);
            return;
        L13:
            return;
        L5:
            if (ku5.c.k(DriveCommentPlugin.access$getActivity(this.a)) == true) goto L8;
            if (DriveCommentPlugin.access$isPdfMarkCommentEnabled(this.a) == true) goto L8;
        }
    }

    public static final class k<T> implements com.bytedance.ee.bear.drive.view.preview.wrapper.y {
        public final /* synthetic */ DriveCommentPlugin a;

        public k(DriveCommentPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.y
        public final Object run() {
            a1 r0 = DriveCommentPlugin.access$getMCommentWrapper$p(this.a);
            if (r0 == null) goto L7;
            boolean r1 = true;
            if (r0.isShowing() != true) goto L7;
        L9:
            return Boolean.valueOf(r1);
        L7:
            r1 = false;
            goto L9
        }
    }

    public static final class l<T> implements Observer {
        public final /* synthetic */ DriveCommentPlugin a;
        public final /* synthetic */ DrivePluginHost b;

        public l(DriveCommentPlugin r1, DrivePluginHost r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r4) {
            Boolean r5 = (Boolean) r4;
            a1 r0 = DriveCommentPlugin.access$getMCommentWrapper$p(this.a);
            if (r0 != null) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L14;
            f85.a r6 = (f85.a) this.b.c.getFileModel();
            boolean r2 = true;
            if (r6 != null) goto L9;
        L11:
            boolean r7 = false;
        L12:
            if (r7 == false) goto L14;
        L15:
            r0.k = r2;
            com.bytedance.ee.bear.middleground.comment.export.h r8 = r0.c;
            if (r8 == null) goto L20;
            r8.l0(r2, false);
            return;
        L20:
            return;
        L9:
            if (r6.j() != true) goto L11;
            r7 = true;
        L14:
            r2 = false;
            goto L15
        }
    }

    public static final class m<T> implements Observer {
        public final /* synthetic */ DrivePluginHost a;

        public m(DrivePluginHost r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            k75.a.i(this.a).liveOuterDisableShowComment().postValue(Boolean.valueOf(((com.bytedance.ee.bear.drive.biz.preview.screen.a) r2).a));
        }
    }

    public static final class n<T> implements Observer {
        public final /* synthetic */ DrivePluginHost a;
        public final /* synthetic */ DriveCommentPlugin b;

        public n(DrivePluginHost r1, DriveCommentPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r2) {
            if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L8;
            MutableLiveData<Boolean> r3 = k75.a.i(this.a).liveOuterCommentable();
            Boolean r0 = Boolean.FALSE;
            r3.postValue(r0);
            k75.a.i(this.a).liveOuterSupportAreaComment().postValue(r0);
            DriveCommentPlugin.access$releaseCommentPanelAiBottomSuppression(this.b);
            a1 r4 = DriveCommentPlugin.access$getMCommentWrapper$p(this.b);
            if (r4 == null) goto L9;
            r4.J1();
            return;
        L9:
            return;
        }
    }

    public static final class o<T> implements Observer {
        public final /* synthetic */ DriveCommentPlugin a;
        public final /* synthetic */ DriveMGPermissionVM b;
        public final /* synthetic */ Ref.BooleanRef c;

        public o(DriveCommentPlugin r1, DriveMGPermissionVM r2, Ref.BooleanRef r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onChanged(Object r5) {
            List r6 = (List) r5;
            if (r6 == null) goto L5;
            int r7 = r6.size();
        L6:
            DriveSpaceFileExtraInfoViewPlugin r0 = (DriveSpaceFileExtraInfoViewPlugin) DriveCommentPlugin.access$findPlugin(this.a, DriveSpaceFileExtraInfoViewPlugin.class);
            l65.i r1 = null;
            if (r0 == null) goto L9;
            FileExtraInfoView r2 = r0.getFileExtraView();
        L10:
            if (r2 == null) goto L12;
            r2.e = r7;
            r2.d.setTvCommentCardText(r7);
        L12:
            DriveCommentPlugin r3 = this.a;
            DriveMGPermissionVM r4 = this.b;
            Intrinsics.checkNotNull(r4);
            DriveCommentPlugin.access$updateFileExtraView(r3, r4);
            if (this.c.element == false) goto L15;
            return;
        L15:
            if (DriveCommentPlugin.access$getMCommentWrapper$p(this.a) == null) goto L35;
            if (r7 <= 0) goto L36;
            this.c.element = true;
            DriveVCFollowPlugin r8 = (DriveVCFollowPlugin) DriveCommentPlugin.access$findPlugin(this.a, DriveVCFollowPlugin.class);
            if (r8 == null) goto L20;
            r1 = r8.getVcManager();
        L20:
            tt5.a.h(DriveCommentPlugin.TAG, "setFollowDocumentInfo vcFollowManager=" + r1);
            if (r1 == null) goto L24;
            r1.a(com.bytedance.ee.bear.drive.biz.preview.vc.comment.a.class, DriveCommentPlugin.access$getMCommentWrapper$p(this.a));
        L24:
            if (DriveCommentPlugin.access$isPdfMarkCommentEnabled(this.a) == false) goto L27;
            if (r1 == null) goto L27;
            r1.a(DriveDocCommentFollowConnector.class, DriveCommentPlugin.access$getMCommentWrapper$p(this.a));
        L27:
            if (r1 == null) goto L37;
            l65.f r9 = r1.g;
            r9.getClass();
            StringBuilder r10 = new StringBuilder("delayRegisterCommentFollowableContent -> isAttachmentBizType=");
            int r11 = com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.a;
            r10.append(com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.C0037a.a(r9.b));
            tt5.a.h("CCMFollow_DriveFollowableContentManager", r10.toString());
            py4.i r12 = r9.a.f;
            if (r12 != null) goto L31;
            return;
        L31:
            if (r9.f != null) goto L39;
            l65.e r13 = new l65.e(FileUploadModel.FROM_COMMENT, r9.c);
            r9.f = r13;
            List<l65.e> r14 = r9.d;
            Intrinsics.checkNotNull(r13);
            ((CopyOnWriteArrayList) r14).add(r13);
            r12.b(r9.f);
            return;
        L39:
            return;
        L37:
            return;
        L36:
            return;
        L35:
            return;
        L9:
            r2 = null;
            goto L10
        L5:
            r7 = 0;
            goto L6
        }
    }

    public static final class p<T> implements Observer {
        public final /* synthetic */ DriveCommentPlugin a;

        public p(DriveCommentPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            CommentRectF r4 = (CommentRectF) r3;
            if (r4 == null) goto L6;
            DriveCommentPlugin r0 = this.a;
            DriveCommentPlugin.access$showCommentPanelAfterPreviewLayout(r0, new com.bytedance.ee.bear.drive.biz.comment.k(r0, r4));
            return;
        }
    }

    public static final class q<T> implements com.bytedance.ee.bear.drive.view.preview.wrapper.y {
        public final /* synthetic */ DriveCommentPlugin a;
        public final /* synthetic */ DriveCommentVM b;

        public q(DriveCommentPlugin r1, DriveCommentVM r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.y
        public final Object run() {
            ViewGroup r0 = DriveCommentPlugin.access$getMPreviewContainer$p(this.a);
            if (r0 == null) goto L5;
            int r1 = r0.getMeasuredHeight();
        L6:
            int r2 = this.b.getCommentPanelDefaultHeight();
            if (r1 <= 0) goto L10;
            r2 = r1 - r2;
        L10:
            return Integer.valueOf(r2);
        L5:
            r1 = 0;
            goto L6
        }
    }

    public static final class r<T> implements Observer {
        public final /* synthetic */ DriveCommentPlugin a;

        public r(DriveCommentPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Boolean r5 = (Boolean) r4;
            t75.i r0 = DriveCommentPlugin.access$getMAiContainerAbility$p(this.a);
            if (r0 == null) goto L6;
            r0.J3(this.a, Intrinsics.areEqual(r5, Boolean.TRUE));
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.comment.DriveCommentPlugin$resolveIsPdfFile$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class C03461 extends FunctionReferenceImpl implements Function1<String, Boolean> {
        public static final C03461 INSTANCE = null;

        static {
            INSTANCE = new C03461();
        }

        public C03461() {
            super(1, i75.h.class, "isPdfExt", "isPdfExt(Ljava/lang/String;)Z", 0);
        }

        public final Boolean invoke(String r1) {
            return Boolean.valueOf(i75.h.k(r1));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((String) r1);
        }
    }

    public static final class s<T> implements Observer {
        public final /* synthetic */ DriveCommentPlugin a;
        public final /* synthetic */ DriveMGPermissionVM b;

        public s(DriveCommentPlugin r1, DriveMGPermissionVM r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r4) {
            u55.b r5 = (u55.b) r4;
            StringBuilder r0 = new StringBuilder("permission updated, comment is showing: ");
            a1 r1 = DriveCommentPlugin.access$getMCommentWrapper$p(this.a);
            Boolean r2 = null;
            if (r1 == null) goto L5;
            Boolean r3 = Boolean.valueOf(r1.isShowing());
        L6:
            r0.append(r3);
            r0.append(", canRead: ");
            if (r5 == null) goto L9;
            r2 = Boolean.valueOf(r5.e());
        L9:
            r0.append(r2);
            tt5.a.h(DriveCommentPlugin.TAG, r0.toString());
            DriveCommentPlugin r6 = this.a;
            DriveMGPermissionVM r7 = this.b;
            Intrinsics.checkNotNull(r7);
            DriveCommentPlugin.access$updateFileExtraView(r6, r7);
            DriveCommentPlugin r8 = this.a;
            DriveMGPermissionVM r9 = this.b;
            Intrinsics.checkNotNull(r9);
            DriveCommentPlugin.access$updateCommentByPermission(r8, r9);
            return;
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class t<T> implements Observer {
        public final /* synthetic */ DriveCommentPlugin a;

        public t(DriveCommentPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Integer r3 = (Integer) r2;
            a1 r4 = DriveCommentPlugin.access$getMCommentWrapper$p(this.a);
            if (r4 == null) goto L7;
            boolean r0 = true;
            if (r4.isShowing() != true) goto L7;
        L8:
            if (r0 == false) goto L13;
            a1 r5 = DriveCommentPlugin.access$getMCommentWrapper$p(this.a);
            if (r5 == null) goto L14;
            r5.v();
            return;
        L14:
            return;
        L13:
            return;
        L7:
            r0 = false;
            goto L8
        }
    }

    public static final class u<T> implements Observer {
        public final /* synthetic */ DriveCommentPlugin a;

        public u(DriveCommentPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            u55.a r5 = (u55.a) r4;
            StringBuilder r0 = new StringBuilder("meta info updated, comment is showing: ");
            a1 r1 = DriveCommentPlugin.access$getMCommentWrapper$p(this.a);
            if (r1 == null) goto L5;
            Boolean r2 = Boolean.valueOf(r1.isShowing());
        L6:
            r0.append(r2);
            tt5.a.h(DriveCommentPlugin.TAG, r0.toString());
            a1 r3 = DriveCommentPlugin.access$getMCommentWrapper$p(this.a);
            if (r3 == null) goto L11;
            boolean r6 = true;
            if (r3.isShowing() != true) goto L11;
        L12:
            if (r6 == false) goto L16;
            a1 r7 = DriveCommentPlugin.access$getMCommentWrapper$p(this.a);
            if (r7 == null) goto L18;
            r7.z((u55.b) ((DriveMGPermissionVM) DriveCommentPlugin.access$viewModel(this.a, DriveMGPermissionVM.class)).livePerm().getValue(), r5);
            return;
        L18:
            return;
        L16:
            this.a.setupCommentIfNeed();
            return;
        L11:
            r6 = false;
            goto L12
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class v<T> implements Observer {
        public final /* synthetic */ DriveCommentPlugin a;
        public final /* synthetic */ DriveMGPermissionVM b;
        public final /* synthetic */ DrivePluginHost c;

        public v(DriveCommentPlugin r1, DriveMGPermissionVM r2, DrivePluginHost r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onChanged(Object r5) {
            ConnectionService.NetworkState r6 = (ConnectionService.NetworkState) r5;
            DriveCommentPlugin r0 = this.a;
            DriveMGPermissionVM r1 = this.b;
            Intrinsics.checkNotNull(r1);
            DriveCommentPlugin.access$updateFileExtraView(r0, r1);
            a1 r2 = DriveCommentPlugin.access$getMCommentWrapper$p(this.a);
            if (r2 == null) goto L5;
            r2.l();
        L5:
            com.bytedance.ee.bear.drive.biz.preview.screen.a r3 = (com.bytedance.ee.bear.drive.biz.preview.screen.a) ((DriveFullScreenVM) DriveCommentPlugin.access$viewModel(this.a, DriveFullScreenVM.class)).getLiveFullScreen().getValue();
            boolean r4 = false;
            if (r3 != null) goto L8;
        L10:
            boolean r7 = false;
        L11:
            MutableLiveData<Boolean> r8 = k75.a.i(this.c).liveOuterDisableShowComment();
            if (r6 != null) goto L14;
        L16:
            boolean r9 = false;
        L17:
            if (r9 == false) goto L19;
            if (r7 == true) goto L19;
        L20:
            r8.postValue(Boolean.valueOf(r4));
            return;
        L19:
            r4 = true;
            goto L20
        L14:
            if (r6.a() != true) goto L16;
            r9 = true;
            goto L17
        L8:
            if (r3.a != true) goto L10;
            r7 = true;
            goto L11
        }
    }

    public static final class w<T> implements Observer {
        public final /* synthetic */ DriveCommentPlugin a;

        public w(DriveCommentPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            a1 r0 = DriveCommentPlugin.access$getMCommentWrapper$p(this.a);
            if (r0 == null) goto L8;
            Intrinsics.checkNotNull(r4);
            final boolean r5 = r4.booleanValue();
            com.bytedance.ee.bear.middleground.comment.export.h r1 = r0.c;
            if (r1 == null) goto L9;
            r1.e1(new com.bytedance.ee.bear.drive.biz.comment.n(r5));
            return;
        L9:
            return;
        }
    }

    public static final class x<T> implements Observer {
        public final /* synthetic */ DriveCommentPlugin a;

        public x(DriveCommentPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            DrivePreviewViewPager r0 = (DrivePreviewViewPager) this.a.findViewById(2131370322);
            if (r0 == null) goto L6;
            r0.setEnableSwipe(Intrinsics.areEqual(r4, Boolean.TRUE));
            return;
        }
    }

    public static final class y<T> implements Observer {
        public final /* synthetic */ DriveCommentPlugin a;

        public y(DriveCommentPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            CommentRectF r4 = (CommentRectF) r3;
            if (r4 != null) goto L7;
            DriveCommentPlugin.access$releaseCommentPanelAiBottomSuppression(this.a);
            a1 r5 = DriveCommentPlugin.access$getMCommentWrapper$p(this.a);
            if (r5 == null) goto L9;
            r5.o();
            return;
        L9:
            return;
        L7:
            DriveCommentPlugin r0 = this.a;
            DriveCommentPlugin.access$showCommentPanelAfterPreviewLayout(r0, new com.bytedance.ee.bear.drive.biz.comment.l(r0, r4));
        }
    }

    public static final class z<T> implements Observer {
        public final /* synthetic */ DriveCommentPlugin a;

        public z(DriveCommentPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Void r3 = (Void) r2;
            DriveCommentPlugin.access$releaseCommentPanelAiBottomSuppression(this.a);
            a1 r4 = DriveCommentPlugin.access$getMCommentWrapper$p(this.a);
            if (r4 == null) goto L7;
            boolean r0 = true;
            if (r4.isShowing() != true) goto L7;
        L8:
            if (r0 == false) goto L13;
            a1 r5 = DriveCommentPlugin.access$getMCommentWrapper$p(this.a);
            if (r5 == null) goto L14;
            r5.o();
            return;
        L14:
            return;
        L13:
            return;
        L7:
            r0 = false;
            goto L8
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final String createPdfCommentInputHint() {
        PreviewViewModel r0 = (PreviewViewModel) viewModel(PreviewViewModel.class);
        if (r0 == null) goto L15;
        MutableLiveData<Integer> r1 = r0.currentPageLiveData;
        if (r1 == null) goto L16;
        Integer r2 = (Integer) r1.getValue();
        if (r2 == null) goto L17;
        int r3 = r2.intValue();
        String r4 = createPdfInputHint(r3);
        if (r3 < 0) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == true) goto L14;
        return null;
    L14:
        return r4;
    L11:
        r5 = false;
        goto L12
    L17:
        return null;
    L16:
        return null;
    L15:
        return null;
    }

    private final Observer<CommentArea.Type> getCommentMarkTypeObserver() {
        return (Observer) this.commentMarkTypeObserver$delegate.getValue();
    }

    private final Observer<Integer> getCurrentPageObserver() {
        return (Observer) this.currentPageObserver$delegate.getValue();
    }

    private final Observer<TranslateLanguageSetting> getTranslateSettingObserver() {
        return (Observer) this.translateSettingObserver$delegate.getValue();
    }

    private final void initPdfAreaMarker() {
        DriveSpaceFileExtraInfoViewPlugin r0 = (DriveSpaceFileExtraInfoViewPlugin) findPlugin(DriveSpaceFileExtraInfoViewPlugin.class);
        if (r0 == null) goto L8;
        FileExtraInfoView r1 = r0.getFileExtraView();
        if (r1 == null) goto L8;
        r1.setAreaMarkerEnable(true);
        return;
    L8:
        tt5.a.d(TAG, "initPdfAreaMarker, fileExtraView is null.");
    }

    private final void observeCommentMarkType() {
        DriveCommentVM r0 = (DriveCommentVM) viewModel(DriveCommentVM.class);
        if (r0 != null) goto L6;
        tt5.a.d(TAG, "observeMarkType, commentVM is null.");
        return;
    L6:
        tt5.a.h(TAG, "observeMarkType");
        r0.getLiveInnerCommentMarkType().removeObserver(getCommentMarkTypeObserver());
        r0.getLiveInnerCommentMarkType().observe(getLifecycleOwner(), getCommentMarkTypeObserver());
    }

    private final void observePdfCurrentPage() {
        PreviewViewModel r0 = (PreviewViewModel) viewModel(PreviewViewModel.class);
        if (r0 != null) goto L6;
        tt5.a.d(TAG, "observePdfCurrentPage, previewVM is null.");
        return;
    L6:
        tt5.a.h(TAG, "observePdfCurrentPage");
        r0.currentPageLiveData.removeObserver(getCurrentPageObserver());
        r0.currentPageLiveData.observe(getLifecycleOwner(), getCurrentPageObserver());
    }

    private final void observeTranslateSetting() {
        DriveCommentVM r0 = (DriveCommentVM) viewModel(DriveCommentVM.class);
        if (r0 != null) goto L6;
        tt5.a.d(TAG, "observeTranslateSetting, commentVM is null.");
        return;
    L6:
        tt5.a.h(TAG, "observeTranslateSetting");
        r0.getLiveTranslateSetting().removeObserver(getTranslateSettingObserver());
        r0.getLiveTranslateSetting().observe(getLifecycleOwner(), getTranslateSettingObserver());
    }

    private final void releaseCommentPanelAiBottomSuppression() {
        t75.i r0 = this.mAiContainerAbility;
        if (r0 == null) goto L6;
        r0.G5(this.commentPanelAiBottomSuppressionOwner);
        return;
    }

    private final void releaseCommentVoiceBarAiBottomSuppression() {
        t75.i r0 = this.mAiContainerAbility;
        Object r1 = this.commentVoiceBarAiBottomSuppressionOwner;
        Intrinsics.checkNotNullParameter(r1, "owner");
        if (r0 == null) goto L6;
        r0.J3(r1, false);
        return;
    }

    private final DriveHeaderCommentEntryAction resolveHeaderCommentEntryAction() {
        int r0 = l1.a;
        boolean r1 = shouldCreatePdfCurrentPageCommentFromHeader();
        boolean r2 = canCreateComment();
        boolean r3 = canShowCommentEntry$default(this, null, 1, null);
        if (r1 == false) goto L6;
        if (r2 == false) goto L6;
        return DriveHeaderCommentEntryAction.CREATE_CURRENT_PAGE_COMMENT;
    L6:
        if (r1 == true) goto L13;
        if (r3 == false) goto L11;
        return DriveHeaderCommentEntryAction.OPEN_DEFAULT_ENTRY;
    L11:
        return DriveHeaderCommentEntryAction.HIDE;
    L13:
        return DriveHeaderCommentEntryAction.HIDE;
    }

    private final boolean shouldOfferCreateWholeCommentFromPanel() {
        int r0 = l1.a;
        boolean r1 = l1.a(AppInfoUtils.f().booleanValue(), DriveCommentPlugin$shouldOfferCreateWholeCommentFromPanel$isCreateCommentFeatureEnabled$1.INSTANCE, new DriveCommentPlugin$shouldOfferCreateWholeCommentFromPanel$isCreateCommentFeatureEnabled$2(this));
        Boolean r2 = resolveIsPdfFile();
        boolean r3 = isPreviewReady();
        boolean r4 = getHost().c.isHistoryMode();
        boolean r5 = canCreateComment();
        if (r1 == false) goto L18;
        if (r4 == true) goto L19;
        if (r5 == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == true) goto L20;
        if (Intrinsics.areEqual(r2, Boolean.FALSE) == false) goto L13;
        r3 = true;
        goto L20
    L13:
        if (r2 != null) goto L17;
        r3 = false;
        goto L20
    L17:
        throw new NoWhenBranchMatchedException();
    L20:
        return r3;
    L19:
        return false;
    L18:
        return false;
    }

    /* JADX WARN: Type inference failed for: r5v13, types: [com.bytedance.ee.bear.drive.biz.comment.data.i, com.bytedance.ee.bear.rn.h$a] */
    public final void setupCommentIfNeed() {
        boolean r0 = resolveCommentUsingNewUI();
        boolean r2 = isPdfMarkCommentEnabled();
        boolean r3 = isPdfFloatCommentEnable();
        StringBuilder r4 = new StringBuilder("setup comment, usePdfFloatingComment=");
        r4.append(r0);
        r4.append(", isPdfMarkCommentEnabled=");
        r4.append(r2);
        r4.append(", isPdfFloatCommentEnable=");
        r4.append(r3);
        r4.append(", commentWrapperExists=");
        if (this.mCommentWrapper == null) goto L5;
        boolean r5 = true;
    L6:
        r4.append(r5);
        tt5.a.h(TAG, r4.toString());
        final a1 r6 = this.mCommentWrapper;
        if (r6 == null) goto L11;
        g55.n r7 = r6.s;
        if (r7 == null) goto L11;
        r7.h = r0;
    L11:
        if (r6 == null) goto L174;
        DriveMGPermissionVM r1 = (DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class);
        if (r1 == null) goto L17;
        LiveData<u55.b> r8 = r1.livePerm();
        if (r8 == null) goto L17;
        u55.b r9 = (u55.b) r8.getValue();
    L18:
        DriveMetaInfoVM r10 = (DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class);
        tt5.a.h("DriveCommentWrapper", "setup, isUsingNewUI: " + r6.s.h);
        r6.i();
        r6.q = (f85.a) r6.F.getFileModel();
        final com.bytedance.ee.bear.drive.biz.comment.data.m r11 = r6.r;
        DriveViewModel r12 = r6.F;
        r11.c();
        r11.e = r12;
        r11.f = (f85.a) r12.getFileModel();
        tt5.a.h("DriveCommentDataManager", "attach, mSourceCommentRectFList merging binding map, current size: " + r11.g.size());
        Iterator r13 = ((HashMap) r11.h).entrySet().iterator();
        boolean r14 = false;
    L20:
        if (r13.hasNext() == false) goto L41;
        Map.Entry r16 = (Map.Entry) r13.next();
        if (r16 == null) goto L20;
        CommentRectF r17 = (CommentRectF) r16.getValue();
        if (r17 == null) goto L20;
        String r18 = r17.b;
        if (r18 == null) goto L20;
        Iterator<CommentRectF> r19 = r11.g.iterator();
    L31:
        if (r19.hasNext() == false) goto L38;
        CommentRectF r20 = r19.next();
        if (r20 == null) goto L31;
        if (TextUtils.equals(r18, r20.b) == false) goto L31;
    L39:
        if (r20 != null) goto L20;
        r11.g.add(r17);
        r14 = true;
        goto L20
    L38:
        r20 = null;
        goto L39
    L41:
        if (r14 == false) goto L44;
        tt5.a.h("DriveCommentDataManager", "attach, mSourceCommentRectFList merged binding map, new size: " + r11.g.size());
        r11.g();
    L44:
        if (TextUtils.isEmpty(r11.e.getFileId()) == false) goto L46;
        final String r21 = "";
    L47:
        tt5.a.h("DRIVE_COMMENT_FLOW", "setup drive comment success=" + TextUtils.isEmpty(r11.e.getFileId()));
        com.bytedance.ee.bear.rn.h r22 = (com.bytedance.ee.bear.rn.h) org.koin.java.a.b(com.bytedance.ee.bear.rn.h.class, null, new com.bytedance.ee.bear.drive.biz.comment.data.h(r21));
        r11.l = r22;
        if (r11.f != null) goto L51;
        tt5.a.d("DriveCommentDataManager", "registerPushListener file model is null");
    L57:
        r11.i();
        if (r9 != null) goto L60;
    L116:
        if (r10 == null) goto L118;
        u55.a r23 = (u55.a) r10.getLiveMetaInfo().getValue();
    L119:
        r6.z(r9, r23);
        if (r6.s.h == false) goto L174;
        if (r6.c != null) goto L125;
        tt5.a.d("DriveCommentWrapper", "setupCopyLinkTemplate, mComment is null.");
    L129:
        Boolean r24 = null;
    L158:
        com.bytedance.ee.bear.middleground.comment.export.h r26 = r6.c;
        if (r26 != null) goto L161;
        tt5.a.d("DriveCommentWrapper", "setupSendToIM, mComment is null.");
    L163:
        if (r6.c != null) goto L165;
        tt5.a.d("DriveCommentWrapper", "setupPermissionShare, mComment is null.");
    L167:
        if (r6.c != null) goto L169;
        tt5.a.d("DriveCommentWrapper", "setupMentionClickedListener, mComment is null.");
    L171:
        if (r6.c != null) goto L173;
        tt5.a.h("DriveCommentWrapper", "setupAuthorizeListener, mComment is null");
    L175:
        a1 r27 = this.mCommentWrapper;
        if (r27 == null) goto L178;
        r27.l();
    L178:
        Boolean r28 = Boolean.valueOf(r2);
        tt5.a.h(TAG, "setupCommentIfNeed, isPdfMarkCommentEnabled: " + r28.booleanValue());
        if (r28.booleanValue() == false) goto L181;
        Boolean r29 = r28;
    L182:
        if (r29 == null) goto L206;
        r29.booleanValue();
        initPdfAreaMarker();
        observePdfCurrentPage();
        observeTranslateSetting();
        observeCommentMarkType();
        initSharedComment();
        return;
    L206:
        return;
    L181:
        r29 = r24;
        goto L182
    L173:
        tt5.a.h("DriveCommentWrapper", "setupAuthorizeListener, registerAuthorizeObserver.");
        r6.c.b().q(new f1(r6));
        goto L175
    L169:
        tt5.a.h("DriveCommentWrapper", "setupPermissionShare, listening OnMentionClicked.");
        r6.c.r1(new com.bytedance.ee.bear.drive.biz.comment.v(r6));
        goto L171
    L165:
        tt5.a.h("DriveCommentWrapper", "setupPermissionShare: true.");
        r6.c.p0().j();
        goto L167
    L161:
        r26.L(new com.bytedance.ee.bear.drive.biz.comment.w());
        goto L163
    L125:
        if (r6.F.isTypeWiki() == false) goto L131;
        BaseOpenEntity r30 = r6.F.getOpenEntity();
        if ((r30 instanceof SpaceFileOpenEntity) == true) goto L130;
        r6.c.m1(null);
        tt5.a.d("DriveCommentWrapper", "setupCopyLinkTemplate, is wiki but openEntity invalid: " + r30);
        goto L129
    L130:
        String r31 = ((SpaceFileOpenEntity) r30).getOriginUrl();
        tt5.a.h("DriveCommentWrapper", "setupCopyLinkTemplate, is wiki, using originUrl: " + du5.b.l(r31));
    L142:
        if (TextUtils.isEmpty(r31) == false) goto L187;
        tt5.a.d("DriveCommentWrapper", "setupCopyLinkTemplate, copyLinkTemplate is null or empty.");
        r6.c.m1(null);
        goto L129
    L187:
        Uri r32 = UriProtector.parse(r31);     // Catch: Exception -> L146
    L148:
        if (r32 != null) goto L150;
        tt5.a.d("DriveCommentWrapper", "setupCopyLinkTemplate, copyLinkTemplateUri is null.");
        r6.c.m1(null);
        goto L129
    L150:
        qi5.a r33 = qi5.a.a;
        String r34 = r32.toString();
        r33.getClass();
        Uri r36 = UriProtector.parse(qi5.a.a(r34, 12)).buildUpon().clearQuery().encodedQuery("comment_id={commentId}").appendQueryParameter("comment_anchor", "true").build();     // Catch: Exception -> L153
    L155:
        if (r36 != null) goto L157;
        tt5.a.d("DriveCommentWrapper", "setupCopyLinkTemplate, templateUri is null.");
        r24 = null;
        r6.c.m1(null);
        goto L158
    L157:
        r24 = null;
        String r37 = r36.toString();
        tt5.a.h("DriveCommentWrapper", "setupCopyLinkTemplate, resultTemplateUrl: " + du5.b.l(r37));
        r6.c.m1(r37);
    L153:
        e = move-exception;
        tt5.a.e("DriveCommentWrapper", "setupCopyLinkTemplate, failed to build templateUri: ", e, false);
        r36 = null;
    L146:
        e = move-exception;
        tt5.a.e("DriveCommentWrapper", "setupCopyLinkTemplate, failed to parse copyLinkTemplateUri: ", e, false);
        r32 = null;
        goto L148
    L131:
        f85.a r38 = r6.q;
        if (r38 != null) goto L134;
        tt5.a.d("DriveCommentWrapper", "setupCopyLinkTemplate, not wiki, mFileModel is null.");
        r6.c.m1(null);
        goto L129
    L134:
        f85.a.C0229a r39 = (f85.a.C0229a) r38.a;
        if (r39 != null) goto L137;
        tt5.a.d("DriveCommentWrapper", "setupCopyLinkTemplate, not wiki, fileMeta is null.");
        r6.c.m1(null);
        goto L129
    L137:
        String r40 = r39.a;
        if (TextUtils.isEmpty(r40) == false) goto L140;
        tt5.a.d("DriveCommentWrapper", "setupCopyLinkTemplate, not wiki, fileId is null or empty.");
        r6.c.m1(null);
        goto L129
    L140:
        r31 = s45.p.a().ua(sbb.e.l.getType(), r40, null);
        tt5.a.h("DriveCommentWrapper", "setupCopyLinkTemplate, not wiki, assemble space url: " + du5.b.l(r31));
        goto L142
    L118:
        r23 = null;
        goto L119
    L60:
        if (r6.q == null) goto L116;
        if (r6.b == null) goto L116;
        com.bytedance.ee.bear.appsetting.c r41 = com.bytedance.ee.bear.appsetting.c.a.a;
        boolean r42 = r41.g("ccm.comment_voice_input_upgrade");
        boolean r43 = r41.g("ccm.comment_voice_input_doubao");
        boolean r110 = LarkAppContext.inst().buildConfig().isOfficeSDK();
        int r111 = CommentVoiceHostPolicy.a;
        if (r110 == false) goto L67;
        if (r43 == false) goto L67;
        CommentVoiceHostPolicy.Route r44 = CommentVoiceHostPolicy.Route.UNIFIED_COMPONENT;
    L72:
        if (r44 == CommentVoiceHostPolicy.Route.DISABLED) goto L74;
        boolean r46 = true;
    L75:
        StringBuilder r47 = new StringBuilder("setup: voiceNeedsHostFragment=");
        r47.append(r46);
        r47.append(", audioAvailable=");
        r47.append(!r6.F.isVCFollowMode());
        tt5.a.h("DriveCommentWrapper", r47.toString());
        FragmentActivity r112 = r6.b;
        CommentBuilder r48 = new CommentBuilder(r112, r6.A, r112.getSupportFragmentManager());
        DrivePluginHost r113 = r6.C.S();
        int r114 = com.bytedance.ee.bear.drive.biz.comment.i.a;
        Intrinsics.checkNotNullParameter(r113, "host");
        com.bytedance.ee.bear.drive.biz.comment.h r115 = new com.bytedance.ee.bear.drive.biz.comment.h(ew4.b.a(r113));
        if (r46 == false) goto L82;
        m1 r49 = r6.C;
        if (r49 == null) goto L82;
        Fragment r50 = r49.S().getHostFragment();
        if (r50 == null) goto L82;
        r48.D = r50;
    L82:
        com.bytedance.ee.bear.middleground.comment.export.n r51 = (com.bytedance.ee.bear.middleground.comment.export.n) org.koin.java.a.a(com.bytedance.ee.bear.middleground.comment.export.n.class);
        String r116 = ((f85.a.C0229a) r6.q.a).a;
        Intrinsics.checkNotNullParameter(r116, "token");
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        r48.d = r116;
        DriveViewModel r117 = r6.F;
        int r118 = h55.a.a;
        String r119 = h55.a.C0236a.a(r117);
        Intrinsics.checkNotNullParameter(r119, "url");
        Intrinsics.checkNotNullParameter(r119, "<set-?>");
        r48.e = r119;
        sbb.e r120 = sbb.e.l;
        Intrinsics.checkNotNullParameter(r120, "pageType");
        Intrinsics.checkNotNullParameter(r120, "<set-?>");
        r48.f = r120;
        String r121 = ((f85.a.C0229a) r6.q.a).k;
        Intrinsics.checkNotNullParameter(r121, "subFileType");
        r48.h = r121;
        r48.i = 1;
        if (r6.s.h == false) goto L85;
        CommentStyle r122 = CommentStyle.FLOAT;
    L86:
        Intrinsics.checkNotNullParameter(r122, "commentStyle");
        r48.o = r122;
        boolean r123 = r6.s.h;
        r48.n = r123;
        r48.m = r123;
        r48.j = 0;
        boolean r124 = true;
        r48.p = !r6.F.isVCFollowMode();
        Intrinsics.checkNotNullParameter(r115, "commentHostDelegate");
        r48.F = r115;
        c1 r125 = new c1(r6, r9);
        Intrinsics.checkNotNullParameter(r125, "isOwner");
        r48.r = r125;
        r48.v = new a1.d(r6.b, r6.q, r9, r10);
        com.bytedance.ee.bear.drive.biz.comment.b r126 = new com.bytedance.ee.bear.drive.biz.comment.b(new b1(r6));
        Intrinsics.checkNotNullParameter(r126, "per");
        Intrinsics.checkNotNullParameter(r126, "<set-?>");
        r48.k = r126;
        if (r6.t == null) goto L89;
        boolean r127 = true;
    L90:
        r48.l = r127;
        r48.s = false;
        Function1 r128 = new x0(r6);
        Intrinsics.checkNotNullParameter(r128, JSEventListener.ACTION_READMESSAGE);
        r48.u = r128;
        com.bytedance.ee.bear.middleground.comment.uitls.r r129 = ((com.bytedance.ee.bear.middleground.comment.export.n) org.koin.java.a.a(com.bytedance.ee.bear.middleground.comment.export.n.class)).e();
        Intrinsics.checkNotNullParameter(r129, "adminPermission");
        r48.y = r129;
        r48.A = r41.g("ccm.mobile.comment_markdown_enable");
        if (Boolean.TRUE.equals(r6.U.invoke()) == false) goto L93;
        Function0<Boolean> r52 = r6.V;
    L94:
        r48.G = r52;
        Comment r53 = r51.g(r48);
        r6.c = r53;
        if (r53 != null) goto L97;
    L109:
        tt5.a.h("DRIVE_COMMENT_FLOW", "setup drive comment finish");
        r6.r.b(r6);
        r6.r.j.add(r6);
        r6.c.p0().h(r6.F.isVCFollowMode());
        com.bytedance.ee.bear.middleground.comment.export.j r54 = r6.c.p0();
        if (r6.s.h == true) goto L112;
    L114:
        r124 = false;
    L115:
        r54.d(r124);
        r6.c.b1(r6.y);
        r6.c.R(new y0(r6));
        r6.c.A0(r6.z);
        r6.c.h1(new com.bytedance.ee.bear.drive.biz.comment.o(r6));
        r6.c.z(new d1(r6));
        r6.c.W0(new com.bytedance.ee.bear.drive.biz.comment.p(r6));
        goto L116
    L112:
        if (DeviceUtils.isPad() == true) goto L114;
    L97:
        if (r6.q == null) goto L109;
        if (r53 == null) goto L102;
        r53.q0(new com.bytedance.ee.bear.drive.biz.comment.y(r6));
    L102:
        com.bytedance.ee.bear.middleground.comment.export.h r56 = r6.c;
        if (r56 == null) goto L105;
        r56.b().x(null);
    L105:
        r6.c.e1(new c0(r6));
        r6.c.U(new e0(r6));
        r6.c.y0(new h1(r6));
        r6.c.X(new f0(r6));
        r6.c.c1(new g0(r6));
        r6.c.t1(new h0(r6));
        r6.c.r0(r6.W);
        if (r6.c.f().contains(r6.X) == true) goto L108;
        r6.c.f().add(r6.X);
    L108:
        r6.c.Y(new i0(r6));
        r6.c.j1(new k0(r6));
        r6.c.L0(new l0(r6));
        r6.c.y(new m0(r6));
        a1.f r57 = r6.y;
        ((HashSet) r57.a).add(new n0(r6));
        r6.c.M(new d0(r6));
        tt5.a.h("DRIVE_COMMENT_FLOW", "setup MG comment finish");
        goto L109
    L93:
        r52 = null;
        goto L94
    L89:
        r127 = false;
        goto L90
    L85:
        r122 = CommentStyle.HALF_SCREEN;
        goto L86
    L74:
        r46 = false;
    L67:
        if (r110 == true) goto L70;
        if (r42 == false) goto L70;
        r44 = CommentVoiceHostPolicy.Route.LARK_IM;
    L70:
        r44 = CommentVoiceHostPolicy.Route.DISABLED;
        goto L72
    L51:
        if (r11.m == null) goto L54;
        if (r22 == null) goto L54;
        r22.a();
        r11.m = null;
    L54:
        ?? r58 = new com.bytedance.ee.bear.drive.biz.comment.data.i(r11);
        r11.m = r58;
        com.bytedance.ee.bear.rn.h r59 = r11.l;
        if (r59 == null) goto L57;
        r59.b(r58);
        tt5.a.h("DriveCommentDataManager", "registerPushListener success, protocol=" + r11.l.hashCode() + ", observer=" + r11.m.hashCode());
        goto L57
    L46:
        r21 = r11.e.getFileId();
    L17:
        r9 = null;
    L174:
        r24 = null;
        goto L175
    L5:
        r5 = false;
        goto L6
    }

    public DriveCommentPlugin() {
        this.commentPanelAiBottomSuppressionOwner = new Object();
        this.commentVoiceBarAiBottomSuppressionOwner = new Object();
        this.currentPageObserver$delegate = LazyKt.lazy(new DriveCommentPlugin$currentPageObserver$2(this));
        this.translateSettingObserver$delegate = LazyKt.lazy(new DriveCommentPlugin$translateSettingObserver$2(this));
        this.commentMarkTypeObserver$delegate = LazyKt.lazy(new DriveCommentPlugin$commentMarkTypeObserver$2(this));
    }

    private final boolean canCreateComment() {
        if (k75.a.g(this) == false) goto L15;
        u55.b r0 = (u55.b) ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).livePerm().getValue();
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L12;
        return false;
    L12:
        if (getHost().c.isHistoryMode() == true) goto L17;
        return true;
    L17:
        return false;
    L7:
        if (r0.a() != true) goto L9;
        r1 = true;
        goto L10
    L15:
        return false;
    }

    private final boolean createWholeCommentFromPanel() {
        boolean r0 = canCreateComment();
        boolean r1 = shouldOfferCreateWholeCommentFromPanel();
        Boolean r2 = resolveIsPdfFile();
        boolean r3 = isPreviewReady();
        boolean r4 = true;
        boolean r5 = false;
        if (r0 == false) goto L6;
        if (r1 == false) goto L6;
        boolean r6 = true;
    L7:
        StringBuilder r7 = new StringBuilder("create whole comment from panel, canCreateComment=");
        r7.append(r0);
        r7.append(", shouldOfferEntry=");
        r7.append(r1);
        r7.append(", resolvedIsPdf=");
        r7.append(r2);
        r7.append(", isPreviewReady=");
        r7.append(r3);
        r7.append(", isHistoryMode=");
        r7.append(getHost().c.isHistoryMode());
        r7.append(", commentWrapperExists=");
        if (this.mCommentWrapper != null) goto L11;
        r4 = false;
    L11:
        r7.append(r4);
        tt5.a.h(TAG, r7.toString());
        int r8 = l1.a;
        Function0<Boolean> r9 = new DriveCommentPlugin$createWholeCommentFromPanel$executed$1(this);
        Intrinsics.checkNotNullParameter(r9, JSEventListener.ACTION);
        if (r6 == false) goto L15;
        r5 = ((Boolean) r9.invoke()).booleanValue();
    L15:
        tt5.a.h(TAG, "create whole comment from panel result, executed=" + r5);
        return r5;
    L6:
        r6 = false;
        goto L7
    }

    private final void initSharedComment() {
        BaseOpenEntity r0 = getHost().c.getOpenEntity();
        if (r0 == null) goto L32;
        Uri r3 = null;
        if ((r0 instanceof SpaceFileOpenEntity) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L32;
        if ((r0 instanceof SpaceFileOpenEntity) == false) goto L12;
        SpaceFileOpenEntity r1 = (SpaceFileOpenEntity) r0;
    L13:
        if (r1 == null) goto L32;
        if (Intrinsics.areEqual(r1.getPreviewFrom(), "docs_feed") == false) goto L18;
        tt5.a.k(TAG, "initSharedComment, previewFrom is feed, ignore shared comment.");
        return;
    L18:
        String r2 = r1.getOriginUrl();
        if (r2 != null) goto L34;
    L30:
        tt5.a.d(TAG, "initSharedComment, originUri is null");
        return;
    L34:
        r3 = UriProtector.parse(r2);     // Catch: Exception -> L22
    L24:
        if (r3 == null) goto L30;
        String r6 = UriProtector.getQueryParameter(r3, "comment_id");
        String r7 = UriProtector.getQueryParameter(r3, "reply_id");
        tt5.a.h(TAG, "initSharedComment, commentId: " + r6 + ", replyId: " + r7);
        a1 r4 = this.mCommentWrapper;
        if (r4 == null) goto L36;
        r4.y("Share", r6, r7, -1, null);
        return;
    L36:
        return;
    L22:
        e = move-exception;
        tt5.a.e(TAG, "initSharedComment, failed to parse originUrl: ", e, false);
        goto L24
    L12:
        r1 = null;
    L32:
        tt5.a.d(TAG, "initSharedComment, no valid openEntity.");
    }

    private final boolean isPdfFloatCommentEnable() {
        boolean r0 = Intrinsics.areEqual(resolveIsPdfFile(), Boolean.TRUE);
        q75.a r1 = o75.b.a().getDriveConfig();
        boolean r3 = true;
        if (w55.n.g().f() == false) goto L9;
        x55.a r2 = w55.l.a;
        if (w55.n.j(r1) == false) goto L9;
        if (w55.n.d == false) goto L9;
        boolean r4 = true;
    L10:
        if (r0 == false) goto L13;
        if (r4 == false) goto L13;
    L14:
        tt5.a.h(TAG, "isPdfFloatCommentEnable: " + r3 + ", isPdf: " + r0 + ", isPdfQuoteCommentEnable: " + r4);
        return r3;
    L13:
        r3 = false;
    L9:
        r4 = false;
        goto L10
    }

    private final boolean isPdfMarkCommentEnabled() {
        boolean r0 = Intrinsics.areEqual(resolveIsPdfFile(), Boolean.TRUE);
        boolean r1 = w55.n.d;
        if (r0 == false) goto L6;
        if (r1 == false) goto L6;
        boolean r2 = true;
    L7:
        tt5.a.h(TAG, "isPdfMarkCommentEnabled: " + r2 + ", isPdf: " + r0 + ", fg: " + r1);
        return r2;
    L6:
        r2 = false;
        goto L7
    }

    private final boolean isPreviewReady() {
        Integer r0 = (Integer) k75.a.i(getHost()).liveInnerPreviewShowStatus().getValue();
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 2) goto L8;
        return true;
    }

    private final void prepareRnInOfficeSdk() {
        if (AppInfoUtils.f().booleanValue() == true) goto L6;
        tt5.a.h(TAG, "prepareRnInOfficeSdk, not OfficeSDK.");
        return;
    L6:
        final String r0 = getHost().c.getFileId();
        if (r0 != null) goto L9;
        r0 = "";
    L9:
        tt5.a.h(TAG, "prepareRnInOfficeSdk, fileId: ".concat(r0));
        ((com.bytedance.ee.bear.rn.j) org.koin.java.a.c(com.bytedance.ee.bear.rn.j.class, null, null, 6)).m();
        if (this.commentProtocol != null) goto L13;
        com.bytedance.ee.bear.rn.g r1 = (com.bytedance.ee.bear.rn.g) org.koin.java.a.b(com.bytedance.ee.bear.rn.g.class, null, new DriveCommentPlugin$prepareRnInOfficeSdk$1$1(r0));
        r1.x(null);
        this.commentProtocol = r1;
        Unit r2 = Unit.INSTANCE;
    L13:
        if (this.commonPushProtocol != null) goto L16;
        com.bytedance.ee.bear.rn.h r3 = (com.bytedance.ee.bear.rn.h) org.koin.java.a.b(com.bytedance.ee.bear.rn.h.class, null, new DriveCommentPlugin$prepareRnInOfficeSdk$2$1(r0));
        r3.b(b0.a);
        this.commonPushProtocol = r3;
        Unit r4 = Unit.INSTANCE;
        return;
    }

    private final void releaseRnInOfficeSDK() {
        if (AppInfoUtils.f().booleanValue() == true) goto L6;
        tt5.a.h(TAG, "releaseRnInOfficeSDK, not OfficeSDK.");
        return;
    L6:
        String r0 = getHost().c.getFileId();
        if (r0 != null) goto L9;
        r0 = "";
    L9:
        tt5.a.h(TAG, "releaseRnInOfficeSDK, fileId: ".concat(r0));
        com.bytedance.ee.bear.rn.g r1 = this.commentProtocol;
        if (r1 == null) goto L12;
        r1.s(null);
    L12:
        this.commentProtocol = null;
        com.bytedance.ee.bear.rn.h r2 = this.commonPushProtocol;
        if (r2 == null) goto L15;
        r2.a();
    L15:
        this.commonPushProtocol = null;
    }

    private final boolean resolveCommentUsingNewUI() {
        boolean r0 = idb.f.a().isCurrentEnable(FG_PDF_COMMENT_HALF_STYLE_NO_TTOFFICE);
        boolean r1 = isPdfMarkCommentEnabled();
        if (r0 == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        int r3 = l1.a;
        if (r0 == false) goto L11;
        boolean r4 = r2;
    L12:
        tt5.a.h(TAG, "resolveCommentUsingNewUI: " + r4 + ", isHalfStyleNoTTOfficeEnabled: " + r0 + ", isPdfMarkCommentEnabled: " + r1 + ", isPdfFloatCommentEnable: " + r2);
        return r4;
    L11:
        r4 = r1;
        goto L12
    L5:
        if (isPdfFloatCommentEnable() == false) goto L7;
        r2 = true;
        goto L8
    }

    private final Boolean resolveIsPdfFile() {
        w75.a r0 = getHost().c.getFileModel();
        if (r0 == null) goto L7;
        w75.b r1 = r0.c();
        if (r1 == null) goto L7;
        String r2 = r1.k;
    L8:
        BaseOpenEntity r3 = getHost().c.getOpenEntity();
        if (r3 == null) goto L11;
        String r4 = r3.getFileExt();
    L12:
        int r5 = l1.a;
        C03461 r6 = C03461.INSTANCE;
        Intrinsics.checkNotNullParameter(r6, "isPdfExt");
        if (r2 != null) goto L15;
    L19:
        if (r4 != null) goto L21;
        r2 = null;
    L26:
        if (r2 != null) goto L29;
        return null;
    L29:
        return (Boolean) r6.invoke(r2);
    L21:
        if ((!StringsKt.isBlank(r4)) == true) goto L24;
        r4 = null;
    L24:
        r2 = r4;
        goto L26
    L15:
        if ((!StringsKt.isBlank(r2)) == true) goto L18;
        r2 = null;
    L18:
        if (r2 != null) goto L29;
    L11:
        r4 = null;
    L7:
        r2 = null;
        goto L8
    }

    private final boolean shouldCreatePdfCurrentPageCommentFromHeader() {
        boolean r0 = Intrinsics.areEqual(resolveIsPdfFile(), Boolean.TRUE);
        boolean r1 = isPdfFloatCommentEnable();
        int r2 = l1.a;
        boolean r3 = l1.a(AppInfoUtils.f().booleanValue(), DriveCommentPlugin$shouldCreatePdfCurrentPageCommentFromHeader$isHostCommentFeatureEnabled$1.INSTANCE, new DriveCommentPlugin$shouldCreatePdfCurrentPageCommentFromHeader$isHostCommentFeatureEnabled$2(this));
        if (r1 == true) goto L5;
    L9:
        boolean r4 = false;
    L10:
        tt5.a.h(TAG, "shouldCreatePdfCurrentPageCommentFromHeader: " + r4 + ", isPdf: " + r0 + ", isPdfFloatCommentEnable: " + r1 + ", isHostCommentFeatureEnabled: " + r3);
        return r4;
    L5:
        if (isPdfMarkCommentEnabled() == true) goto L8;
        if (r3 == false) goto L9;
        if (r0 == false) goto L9;
    L8:
        r4 = true;
        goto L10
    }

    public final boolean canShowHeaderCommentEntry() {
        if (resolveHeaderCommentEntryAction() == DriveHeaderCommentEntryAction.HIDE) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isHeaderCommentEntryEnabled() {
        boolean r0 = canShowHeaderCommentEntry();
        int r1 = l1.a;
        Boolean r2 = resolveIsPdfFile();
        boolean r3 = isPreviewReady();
        if (r0 == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == true) goto L13;
        if (Intrinsics.areEqual(r2, Boolean.FALSE) == false) goto L11;
        r3 = true;
        goto L13
    L11:
        if (r2 == null) goto L13;
        throw new NoWhenBranchMatchedException();
    L13:
        return r3;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        View r0 = findViewById(2131370319);
        g55.n r4 = new g55.n(getHost().c, (DriveFullScreenVM) viewModel(DriveFullScreenVM.class), new i(this), r0);
        a1 r1 = new a1(new d(this), new e(this), r4, getHost().c, new AnonymousClass3(this), new AnonymousClass4(this), new f(this));
        r1.d = new DriveCommentPlugin$onAttachPreview$6$1(this);
        com.bytedance.ee.bear.middleground.comment.export.h r2 = r1.c;
        if (r2 == null) goto L6;
        r2.q0(new com.bytedance.ee.bear.drive.biz.comment.y(r1));
    L6:
        this.mCommentWrapper = r1;
        u75.b r3 = getHost().c();
        g r5 = new g(this);
        this.mLoadListener = r5;
        r3.c(r5);
        DriveFeedVM r6 = (DriveFeedVM) viewModel(DriveFeedVM.class);
        a1 r7 = this.mCommentWrapper;
        if (r7 == null) goto L9;
        r7.w = new h(r6);
    L9:
        if (r7 == null) goto L11;
        r7.D = new b(r6);
    L11:
        DriveSpaceFileExtraInfoViewPlugin r8 = (DriveSpaceFileExtraInfoViewPlugin) findPlugin(DriveSpaceFileExtraInfoViewPlugin.class);
        if (r8 == null) goto L14;
        FileExtraInfoView r9 = r8.getFileExtraView();
    L15:
        if (r9 == null) goto L18;
        r9.setOnCommentListener(new c(this));
        return;
    L18:
        return;
    L14:
        r9 = null;
        goto L15
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        releaseCommentPanelAiBottomSuppression();
        releaseCommentVoiceBarAiBottomSuppression();
        t75.i r0 = this.mAiContainerAbility;
        if (r0 == null) goto L5;
        r0.J3(this, false);
    L5:
        super.onDetachPreview();
        u75.b.a r1 = this.mLoadListener;
        if (r1 == null) goto L8;
        getHost().c().g(r1);
    L8:
        a1 r2 = this.mCommentWrapper;
        if (r2 == null) goto L11;
        r2.J1();
    L11:
        a1 r3 = this.mCommentWrapper;
        if (r3 == null) goto L34;
        StringBuilder r4 = new StringBuilder("destroy, self: ");
        r4.append(r3.hashCode());
        r4.append(", mComment: ");
        com.bytedance.ee.bear.middleground.comment.export.h r5 = r3.c;
        if (r5 != null) goto L16;
        Object r6 = "null";
    L17:
        r4.append(r6);
        tt5.a.h("DriveCommentWrapper", r4.toString());
        r3.p();
        Toast.cancelLoading();
        r3.e.cancel();
        r3.C = null;
        r3.b = null;
        r3.A = null;
        r3.i();
        com.bytedance.ee.bear.middleground.comment.export.h r7 = r3.c;
        if (r7 != null) goto L32;
    L25:
        com.bytedance.ee.bear.drive.biz.comment.data.m r8 = r3.r;
        r8.getClass();
        tt5.a.h("DriveCommentDataManager", "destroy");
        r8.c();
        Disposable r9 = r8.c;
        if (r9 != null) goto L28;
    L30:
        r8.c = null;
        ((HashMap) r8.h).clear();
        return;
    L28:
        if (r9.isDisposed() == true) goto L30;
        r8.c.dispose();
        goto L30
    L32:
        r7.Q0(false, true);     // Catch: Exception -> L22
        r3.c.destroy(true);     // Catch: Exception -> L22
    L24:
        r3.c = null;
    L22:
        e = move-exception;
        tt5.a.f("DRIVE_PREVIEW_FLOW", e, false);
        goto L24
    L16:
        r6 = Integer.valueOf(r5.hashCode());
        goto L17
    }

    public final boolean openHeaderCommentEntry() {
        boolean r0 = isHeaderCommentEntryEnabled();
        DriveHeaderCommentEntryAction r1 = resolveHeaderCommentEntryAction();
        PreviewViewModel r2 = (PreviewViewModel) viewModel(PreviewViewModel.class);
        Integer r3 = null;
        if (r2 == null) goto L7;
        MutableLiveData<Integer> r4 = r2.currentPageLiveData;
        if (r4 == null) goto L7;
        Integer r5 = (Integer) r4.getValue();
    L8:
        boolean r6 = isPdfFloatCommentEnable();
        StringBuilder r7 = new StringBuilder("open header comment entry, enabled=");
        r7.append(r0);
        r7.append(", action=");
        r7.append(r1);
        r7.append(", resolvedIsPdf=");
        r7.append(resolveIsPdfFile());
        r7.append(", isPreviewReady=");
        r7.append(isPreviewReady());
        r7.append(", isPdfFloatCommentEnable=");
        r7.append(r6);
        r7.append(", canCreateComment=");
        r7.append(canCreateComment());
        r7.append(", cachedCommentCount=");
        List r8 = (List) ((DriveCommentVM) viewModel(DriveCommentVM.class)).getLiveCommentData().getValue();
        if (r8 == null) goto L11;
        r3 = Integer.valueOf(r8.size());
    L11:
        r7.append(r3);
        r7.append(", currentPageIndex=");
        r7.append(r5);
        tt5.a.h(TAG, r7.toString());
        if (r0 == true) goto L14;
        tt5.a.h(TAG, "openHeaderCommentEntry blocked, canShow=" + canShowHeaderCommentEntry() + ", resolvedIsPdf=" + resolveIsPdfFile() + ", previewStatus=" + k75.a.i(getHost()).liveInnerPreviewShowStatus().getValue());
    L14:
        int r9 = l1.a;
        Function1<Boolean, Boolean> r10 = new AnonymousClass1(this);
        Function0<Boolean> r11 = new AnonymousClass2(this);
        Intrinsics.checkNotNullParameter(r1, JSEventListener.ACTION);
        Intrinsics.checkNotNullParameter(r10, "createComment");
        Intrinsics.checkNotNullParameter(r11, "openDefaultEntry");
        if (r0 == false) goto L30;
        Intrinsics.checkNotNullParameter(r1, JSEventListener.ACTION);
        Intrinsics.checkNotNullParameter(r10, "createComment");
        Intrinsics.checkNotNullParameter(r11, "openDefaultEntry");
        int r12 = l1.a.a[r1.ordinal()];
        if (r12 == 1) goto L28;
        if (r12 == 2) goto L29;
        if (r12 != 3) goto L25;
        return false;
    L25:
        throw new NoWhenBranchMatchedException();
    L29:
        return ((Boolean) r11.invoke()).booleanValue();
    L28:
        return ((Boolean) r10.invoke(Boolean.FALSE)).booleanValue();
    L30:
        return false;
    L7:
        r5 = null;
        goto L8
    }

    public static final /* synthetic */ String access$createPdfCommentInputHint(DriveCommentPlugin r0) {
        return r0.createPdfCommentInputHint();
    }

    public static final /* synthetic */ boolean access$createWholeCommentFromPanel(DriveCommentPlugin r0) {
        return r0.createWholeCommentFromPanel();
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveCommentPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ Object access$getCommentVoiceBarAiBottomSuppressionOwner$p(DriveCommentPlugin r0) {
        return r0.commentVoiceBarAiBottomSuppressionOwner;
    }

    public static final /* synthetic */ Context access$getContext(DriveCommentPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ t75.i access$getMAiContainerAbility$p(DriveCommentPlugin r0) {
        return r0.mAiContainerAbility;
    }

    public static final /* synthetic */ a1 access$getMCommentWrapper$p(DriveCommentPlugin r0) {
        return r0.mCommentWrapper;
    }

    public static final /* synthetic */ ViewGroup access$getMPreviewContainer$p(DriveCommentPlugin r0) {
        return r0.mPreviewContainer;
    }

    public static final /* synthetic */ boolean access$isPdfFloatCommentEnable(DriveCommentPlugin r0) {
        return r0.isPdfFloatCommentEnable();
    }

    public static final /* synthetic */ boolean access$isPdfMarkCommentEnabled(DriveCommentPlugin r0) {
        return r0.isPdfMarkCommentEnabled();
    }

    public static final /* synthetic */ void access$releaseCommentPanelAiBottomSuppression(DriveCommentPlugin r0) {
        r0.releaseCommentPanelAiBottomSuppression();
    }

    public static final /* synthetic */ boolean access$shouldOfferCreateWholeCommentFromPanel(DriveCommentPlugin r0) {
        return r0.shouldOfferCreateWholeCommentFromPanel();
    }

    private final String createPdfInputHint(int r9) {
        int r0 = l1.a;
        String r2 = getContext().getString(2131889759);
        String r1 = getContext().getString(2131888385);
        Intrinsics.checkNotNullParameter(r2, "pageHintTemplate");
        Intrinsics.checkNotNullParameter(r1, "defaultHint");
        if (r9 >= 0) goto L5;
        return r1;
    L5:
        return StringsKt.replace$default(r2, "{num}", String.valueOf(r9 + 1), false, 4, null);
    }

    private final void showCommentPanelAfterPreviewLayout(Runnable r3) {
        t75.i r0 = this.mAiContainerAbility;
        if (r0 != null) goto L6;
        r3.run();
        return;
    L6:
        r0.E6(this.commentPanelAiBottomSuppressionOwner, r3);
    }

    private final void updateCommentByPermission(DriveMGPermissionVM r7) {
        u55.b r8 = (u55.b) r7.livePerm().getValue();
        boolean r0 = k75.a.g(this);
        boolean r1 = true;
        if (r8 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        StringBuilder r4 = new StringBuilder("updateCommentByPermission, isShowing: ");
        a1 r5 = this.mCommentWrapper;
        if (r5 == null) goto L11;
        Boolean r6 = Boolean.valueOf(r5.isShowing());
    L12:
        r4.append(r6);
        r4.append(", isConnected: ");
        r4.append(r0);
        r4.append(", canComment: ");
        r4.append(r3);
        tt5.a.h(TAG, r4.toString());
        a1 r2 = this.mCommentWrapper;
        if (r2 != null) goto L15;
    L17:
        boolean r9 = false;
    L18:
        if (r9 == false) goto L34;
        if (r8 != null) goto L21;
    L23:
        boolean r10 = false;
    L24:
        if (r10 == false) goto L34;
        a1 r11 = this.mCommentWrapper;
        if (r11 == null) goto L28;
        r11.v();
    L28:
        a1 r12 = this.mCommentWrapper;
        if (r12 == null) goto L31;
        r12.l();
    L31:
        a1 r13 = this.mCommentWrapper;
        if (r13 == null) goto L35;
        r13.z(r8, (u55.a) ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).getLiveMetaInfo().getValue());
    L35:
        if (r8 != null) goto L37;
    L39:
        r1 = false;
    L40:
        if (r1 == true) goto L45;
        releaseCommentPanelAiBottomSuppression();
        a1 r14 = this.mCommentWrapper;
        if (r14 == null) goto L46;
        r14.J1();
        return;
    L46:
        return;
    L45:
        return;
    L37:
        if (r8.e() != true) goto L39;
    L21:
        if (r8.e() != true) goto L23;
        r10 = true;
    L34:
        setupCommentIfNeed();
        goto L35
    L15:
        if (r2.isShowing() != true) goto L17;
        r9 = true;
        goto L18
    L11:
        r6 = null;
        goto L12
    L5:
        if (r8.a() != true) goto L7;
        r3 = true;
        goto L8
    }

    private final void updateFileExtraView(DriveMGPermissionVM r6) {
        boolean r0 = k75.a.g(this);
        u55.b r7 = (u55.b) r6.livePerm().getValue();
        boolean r1 = true;
        if (r7 != null) goto L5;
    L7:
        boolean r8 = false;
    L8:
        if (r8 == true) goto L10;
    L12:
        boolean r9 = false;
    L13:
        MutableLiveData<Boolean> r3 = k75.a.i(getHost()).liveOuterCommentable();
        if (r0 == false) goto L17;
        if (r9 == false) goto L17;
        boolean r4 = true;
    L18:
        r3.postValue(Boolean.valueOf(r4));
        DriveSpaceFileExtraInfoViewPlugin r5 = (DriveSpaceFileExtraInfoViewPlugin) findPlugin(DriveSpaceFileExtraInfoViewPlugin.class);
        if (r5 == null) goto L21;
        FileExtraInfoView r10 = r5.getFileExtraView();
    L22:
        if (r10 == null) goto L28;
        if (r0 == false) goto L26;
        if (r9 == false) goto L26;
    L27:
        r10.setCommentEnterState(r1);
    L26:
        r1 = false;
    L28:
        if (r10 == null) goto L31;
        r10.c(r0, r9);
        return;
    L31:
        return;
    L21:
        r10 = null;
    L17:
        r4 = false;
        goto L18
    L10:
        if (getHost().c.isHistoryMode() == true) goto L12;
        r9 = true;
        goto L13
    L5:
        if (r7.a() != true) goto L7;
        r8 = true;
        goto L8
    }

    public final boolean canShowCommentEntry(Integer r3) {
        if (r3 == null) goto L5;
    L4:
        int r4 = r3.intValue();
    L13:
        if (k75.a.g(this) == false) goto L19;
        if (r4 <= 0) goto L16;
    L17:
        return true;
    L16:
        if (canCreateComment() == true) goto L17;
        return false;
    L19:
        return false;
    L5:
        List r5 = (List) ((DriveCommentVM) viewModel(DriveCommentVM.class)).getLiveCommentData().getValue();
        if (r5 == null) goto L8;
        r3 = Integer.valueOf(r5.size());
    L9:
        if (r3 != null) goto L4;
        r4 = 0;
        goto L13
    L8:
        r3 = null;
        goto L9
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r7) {
        Intrinsics.checkNotNullParameter(r7, "host");
        super.onAttachToHost(r7);
        this.mAiContainerAbility = (t75.i) r7.getHostAbilityOrNull(t75.i.class);
        k75.a.i(r7).liveInnerAreaCommentActive().observe(getLifecycleOwner(), new r(this));
        prepareRnInOfficeSdk();
        DriveMGPermissionVM r0 = (DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class);
        r0.livePerm().observe(getLifecycleOwner(), new s(this, r0));
        k75.a.i(r7).liveInnerPreviewShowStatus().observe(getLifecycleOwner(), new t(this));
        ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).getLiveMetaInfo().observe(getLifecycleOwner(), new u(this));
        k75.a.h(this, new v(this, r0, r7));
        k75.a.i(r7).liveInnerInterceptMaskClick().observe(getLifecycleOwner(), new w(this));
        k75.a.i(r7).liveInnerSetSwipeEnable().observe(getLifecycleOwner(), new x(this));
        k75.a.i(r7).liveInnerCommentSelected().observe(getLifecycleOwner(), new y(this));
        k75.a.i(r7).liveInnerSingleTap().observe(getLifecycleOwner(), new z(this));
        k75.a.i(r7).liveInnerCreateNewComment().observe(getLifecycleOwner(), new j(this));
        k75.a.i(r7).liveOuterCommentCardVisible().postValue(new k(this));
        k75.a.i(r7).liveInnerAreaCommentEnableState().observe(getLifecycleOwner(), new l(this, r7));
        ((DriveFullScreenVM) viewModel(DriveFullScreenVM.class)).getLiveFullScreen().observe(getLifecycleOwner(), new m(r7));
        r7.c.liveHistoryMode().observe(getLifecycleOwner(), new n(r7, this));
        DriveCommentVM r1 = (DriveCommentVM) viewModel(DriveCommentVM.class);
        Ref.BooleanRef r2 = new Ref.BooleanRef();
        r1.getLiveCommentData().observe(getLifecycleOwner(), new o(this, r0, r2));
        r1.getLiveFeedSelectedComment().observe(getLifecycleOwner(), new p(this));
        k75.a.i(r7).liveOuterNotPreviewContentHeight().postValue(new q(this, r1));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r2) {
        super.onConfigurationChanged(r2);
        a1 r3 = this.mCommentWrapper;
        if (r3 == null) goto L10;
        com.bytedance.ee.bear.middleground.comment.export.h r0 = r3.c;
        if (r0 == null) goto L11;
        r0.f0();
        if (r3.s.h == false) goto L12;
        r3.c.J();
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        releaseCommentPanelAiBottomSuppression();
        releaseCommentVoiceBarAiBottomSuppression();
        t75.i r0 = this.mAiContainerAbility;
        if (r0 == null) goto L5;
        r0.J3(this, false);
    L5:
        this.mAiContainerAbility = null;
        super.onDetachFromHost(r3);
        releaseRnInOfficeSDK();
    }

    public final boolean openCommentEntry(Integer r8) {
        List r0 = (List) ((DriveCommentVM) viewModel(DriveCommentVM.class)).getLiveCommentData().getValue();
        if (r0 == null) goto L5;
        Integer r2 = Integer.valueOf(r0.size());
    L7:
        if (r8 == null) goto L9;
        int r4 = r8.intValue();
    L12:
        StringBuilder r5 = new StringBuilder("openCommentEntry, entryCommentCount: ");
        r5.append(r8);
        r5.append(", cachedCommentDataReady: ");
        if (r0 == null) goto L15;
        boolean r1 = true;
    L16:
        r5.append(r1);
        r5.append(", cachedCommentCount: ");
        r5.append(r2);
        r5.append(", resolvedCommentCount: ");
        r5.append(r4);
        r5.append(", action: ");
        if (r4 > 0) goto L19;
        String r3 = "create";
    L20:
        r5.append(r3);
        tt5.a.h(TAG, r5.toString());
        if (canShowCommentEntry(Integer.valueOf(r4)) == true) goto L24;
        tt5.a.h(TAG, "openCommentEntry blocked, canShowCommentEntry=false");
        return false;
    L24:
        a1 r6 = this.mCommentWrapper;
        if (r6 != null) goto L28;
        tt5.a.h(TAG, "openCommentEntry blocked, commentWrapper is null");
        return false;
    L28:
        if (r4 > 0) goto L30;
        r6.g(false, null, null);
    L31:
        k75.a.c(getHost()).m(getHost().c.getFileModel(), FileUploadModel.FROM_COMMENT, "ccm_comment_view");
        return true;
    L30:
        showCommentPanelAfterPreviewLayout(new a0(r6));
        goto L31
    L19:
        r3 = "show";
        goto L20
    L15:
        r1 = false;
        goto L16
    L9:
        if (r2 == null) goto L11;
        r4 = r2.intValue();
        goto L12
    L11:
        r4 = 0;
        goto L12
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$findPlugin(DriveCommentPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static final /* synthetic */ void access$showCommentPanelAfterPreviewLayout(DriveCommentPlugin r0, Runnable r1) {
        r0.showCommentPanelAfterPreviewLayout(r1);
    }

    public static final /* synthetic */ void access$updateCommentByPermission(DriveCommentPlugin r0, DriveMGPermissionVM r1) {
        r0.updateCommentByPermission(r1);
    }

    public static final /* synthetic */ void access$updateFileExtraView(DriveCommentPlugin r0, DriveMGPermissionVM r1) {
        r0.updateFileExtraView(r1);
    }

    public static final /* synthetic */ ViewModel access$viewModel(DriveCommentPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }

    public void onAttachToUIContainer(DrivePluginHost r2, com.bytedance.ee.bear.browser.plugin.t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super.onAttachToUIContainer(r2, r3);
        View r4 = r3.findView(2131370305);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.view.ViewGroup");
        this.mPreviewContainer = (ViewGroup) r4;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onAttachToUIContainer((DrivePluginHost) r1, r2);
    }

    public static /* synthetic */ boolean canShowCommentEntry$default(DriveCommentPlugin r0, Integer r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.canShowCommentEntry(r1);
    }

    public static /* synthetic */ boolean openCommentEntry$default(DriveCommentPlugin r0, Integer r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.openCommentEntry(r1);
    }
}
