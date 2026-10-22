package com.larus.larkfeed;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.lark.biz.im.api.r;
import com.ss.android.lark.biz.officesdk.im.message.menu.IDoubaoTextSelectService;
import com.ss.android.lark.biz.officesdk.im.share.IOfficeSDKSharePanelType;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kza.m;
import kza.n;
import mpc.e;
import qza.c;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 62\u00020\u0001:\u00016J\b\u0010\u0002\u001a\u00020\u0001H&J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&J!\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&J(\u0010\u0016\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\fH&J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u001f\u001a\u00020 H&J\f\u0010!\u001a\u00060\"j\u0002`#H&J\b\u0010$\u001a\u00020%H&J\u001a\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'2\b\u0010)\u001a\u0004\u0018\u00010\u0001H&J\b\u0010*\u001a\u00020+H&J\b\u0010,\u001a\u00020-H&J\b\u0010.\u001a\u00020/H&J\b\u00100\u001a\u000201H&J\u0018\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0017H&¨\u00067"}, d2 = {"Lcom/larus/larkfeed/IOfficeSocialBridge;", "", "createOpenMessageOperator", "createTextSelectService", "Lcom/ss/android/lark/biz/officesdk/im/message/menu/IDoubaoTextSelectService;", "createMessageMenuConfigService", "Lcom/ss/android/lark/biz/officesdk/im/message/menu/IMessageMenuConfigService;", "shareChannelTransform", "Lcom/ss/android/lark/biz/officesdk/im/share/IOfficeSDKSharePanelType;", "channel", "", "saveBitmapToSD", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroid/graphics/Bitmap;)Ljava/lang/Boolean;", "pushInnerNotification", "", "data", "Lcom/ss/android/lark/biz/officesdk/im/notification/OnlinePushNotificationData;", "openGalleryPreview", "Landroidx/fragment/app/FragmentActivity;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "request", "Lcom/ss/android/lark/biz/officesdk/im/mediapreview/OpenFeishuGalleryPreviewRequest;", "isShowTracker", "createPickAvatarIntent", "Landroid/content/Intent;", "createDoubaoMessageFeedbackService", "Lcom/ss/android/lark/biz/officesdk/im/message/reaction/IDoubaoMessageFeedbackService;", "createDoubaoMergeForwardService", "Lcom/ss/android/lark/biz/im/api/IDoubaoMergeForwardService;", "Lcom/ss/android/lark/biz/officesdk/im/mergeforward/IDoubaoMergeForwardService;", "createDoubaoForwardProtocol", "Lcom/suite/lark/platform/feature/forward/doubao/api/IDoubaoForwardProtocal;", "getGalleryItems", "", "Lcom/ss/android/lark/biz/officesdk/im/mediapreview/OpenFeishuGalleryPreviewItem;", "content", "createOfficeSDKFeedApi", "Lcom/ss/android/lark/officesdk/feed/api/IOfficeSDKFeedApi;", "createOfficeSDKNotificationApi", "Lcom/ss/android/lark/biz/officesdk/im/notification/IOfficeSDKNotificationApi;", "createOfficeSDKUserApi", "Lcom/ss/android/lark/officesdk/flow/user/api/IOfficeSDKUserApi;", "createSideBarChatPageService", "Lcom/ss/android/lark/biz/officesdk/im/feed/host/IHostMainContainerService;", "showProfileAvatarViewDialog", "image", "Lcom/ss/android/lark/biz/officesdk/im/mediapreview/OpenFeishuAvatarPreviewRequest;", "from", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IOfficeSocialBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f355120a = null;

    @Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\r\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0096\u0001J\t\u0010\t\u001a\u00020\nH\u0096\u0001J\t\u0010\u000b\u001a\u00020\fH\u0096\u0001J\t\u0010\r\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u0096\u0001J\t\u0010\u001b\u001a\u00020\u001cH\u0096\u0001J\u001b\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u0014H\u0096\u0001J)\u0010!\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0096\u0001J\u0011\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020,H\u0096\u0001J\"\u0010-\u001a\u0004\u0018\u00010)2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010.\u001a\u0004\u0018\u00010/H\u0096\u0001¢\u0006\u0002\u00100J\u0015\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u000104H\u0096\u0001J\u0019\u00105\u001a\u00020\"2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020#H\u0096\u0001¨\u00069"}, d2 = {"Lcom/larus/larkfeed/IOfficeSocialBridge$Companion;", "Lcom/larus/larkfeed/IOfficeSocialBridge;", "<init>", "()V", "createDoubaoForwardProtocol", "Lcom/suite/lark/platform/feature/forward/doubao/api/IDoubaoForwardProtocal;", "createDoubaoMergeForwardService", "Lcom/ss/android/lark/biz/im/api/IDoubaoMergeForwardService;", "Lcom/ss/android/lark/biz/officesdk/im/mergeforward/IDoubaoMergeForwardService;", "createDoubaoMessageFeedbackService", "Lcom/ss/android/lark/biz/officesdk/im/message/reaction/IDoubaoMessageFeedbackService;", "createMessageMenuConfigService", "Lcom/ss/android/lark/biz/officesdk/im/message/menu/IMessageMenuConfigService;", "createOfficeSDKFeedApi", "Lcom/ss/android/lark/officesdk/feed/api/IOfficeSDKFeedApi;", "createOfficeSDKNotificationApi", "Lcom/ss/android/lark/biz/officesdk/im/notification/IOfficeSDKNotificationApi;", "createOfficeSDKUserApi", "Lcom/ss/android/lark/officesdk/flow/user/api/IOfficeSDKUserApi;", "createOpenMessageOperator", "", "createPickAvatarIntent", "Landroid/content/Intent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "createSideBarChatPageService", "Lcom/ss/android/lark/biz/officesdk/im/feed/host/IHostMainContainerService;", "createTextSelectService", "Lcom/ss/android/lark/biz/officesdk/im/message/menu/IDoubaoTextSelectService;", "getGalleryItems", "", "Lcom/ss/android/lark/biz/officesdk/im/mediapreview/OpenFeishuGalleryPreviewItem;", "content", "openGalleryPreview", "", "Landroidx/fragment/app/FragmentActivity;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "request", "Lcom/ss/android/lark/biz/officesdk/im/mediapreview/OpenFeishuGalleryPreviewRequest;", "isShowTracker", "", "pushInnerNotification", "data", "Lcom/ss/android/lark/biz/officesdk/im/notification/OnlinePushNotificationData;", "saveBitmapToSD", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroid/graphics/Bitmap;)Ljava/lang/Boolean;", "shareChannelTransform", "Lcom/ss/android/lark/biz/officesdk/im/share/IOfficeSDKSharePanelType;", "channel", "", "showProfileAvatarViewDialog", "image", "Lcom/ss/android/lark/biz/officesdk/im/mediapreview/OpenFeishuAvatarPreviewRequest;", "from", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IOfficeSocialBridge {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f355121c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IOfficeSocialBridge f355122b;

        static {
            f355121c = new Companion();
        }

        @Override // com.larus.larkfeed.IOfficeSocialBridge
        public final qtb.b a() {
            return this.f355122b.a();
        }

        @Override // com.larus.larkfeed.IOfficeSocialBridge
        public final Boolean b(Context r100, Bitmap r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return this.f355122b.b(r100, r101);
        }

        @Override // com.larus.larkfeed.IOfficeSocialBridge
        public final oza.a c() {
            return this.f355122b.c();
        }

        @Override // com.larus.larkfeed.IOfficeSocialBridge
        public final IDoubaoTextSelectService d() {
            return this.f355122b.d();
        }

        @Override // com.larus.larkfeed.IOfficeSocialBridge
        public final e e() {
            return this.f355122b.e();
        }

        @Override // com.larus.larkfeed.IOfficeSocialBridge
        public final gza.b f() {
            return this.f355122b.f();
        }

        @Override // com.larus.larkfeed.IOfficeSocialBridge
        public final List<m> g(Object r100) {
            return this.f355122b.g(r100);
        }

        @Override // com.larus.larkfeed.IOfficeSocialBridge
        public final IOfficeSDKSharePanelType h(String r100) {
            return this.f355122b.h(r100);
        }

        @Override // com.larus.larkfeed.IOfficeSocialBridge
        public final nza.a i() {
            return this.f355122b.i();
        }

        @Override // com.larus.larkfeed.IOfficeSocialBridge
        public final stb.a j() {
            return this.f355122b.j();
        }

        @Override // com.larus.larkfeed.IOfficeSocialBridge
        public final void k(FragmentActivity r100, FragmentManager r101, n r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "fragmentManager");
            Intrinsics.checkNotNullParameter(r102, "request");
            this.f355122b.k(r100, r101, r102, r103);
        }

        @Override // com.larus.larkfeed.IOfficeSocialBridge
        public final Intent l(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return this.f355122b.l(r100);
        }

        @Override // com.larus.larkfeed.IOfficeSocialBridge
        public final r m() {
            return this.f355122b.m();
        }

        @Override // com.larus.larkfeed.IOfficeSocialBridge
        public final qza.a n() {
            return this.f355122b.n();
        }

        @Override // com.larus.larkfeed.IOfficeSocialBridge
        public final void o(c r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f355122b.o(r100);
        }

        @Override // com.larus.larkfeed.IOfficeSocialBridge
        public final Object p() {
            return this.f355122b.p();
        }

        private Companion() {
            this.f355122b = (IOfficeSocialBridge) ServiceManager.get().getService(IOfficeSocialBridge.class);
        }
    }

    static {
        f355120a = Companion.f355121c;
    }

    qtb.b a();

    Boolean b(Context r100, Bitmap r101);

    oza.a c();

    IDoubaoTextSelectService d();

    e e();

    gza.b f();

    List<m> g(Object r100);

    IOfficeSDKSharePanelType h(String r100);

    nza.a i();

    stb.a j();

    void k(FragmentActivity r100, FragmentManager r101, n r102, boolean r103);

    Intent l(Context r100);

    r m();

    qza.a n();

    void o(c r100);

    Object p();
}
