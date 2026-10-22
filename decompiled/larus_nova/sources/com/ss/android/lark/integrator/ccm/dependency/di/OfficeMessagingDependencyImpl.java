package com.ss.android.lark.integrator.ccm.dependency.di;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.dto.DocImagesForwardData;
import com.bytedance.ee.bear.dto.DocShareTextData;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.forwardv2.dto.ForwardTemplate;
import com.ss.android.lark.forwardv2.dto.StickImage;
import com.ss.android.lark.forwardv2.dto.template.BasicDialogContent;
import com.ss.android.lark.forwardv2.dto.template.BusinessRecentVisitIncludeConfig;
import com.ss.android.lark.forwardv2.dto.template.ForwardFeature;
import com.ss.android.lark.forwardv2.dto.template.ForwardViewDependency;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$GroupChatTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$PublicTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$ShieldTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$ThreadTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$UserTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.GroupChatConfig;
import com.ss.android.lark.forwardv2.dto.template.config.ThreadConfig;
import com.ss.android.lark.forwardv2.dto.template.config.UserConfig;
import com.ss.android.lark.forwardv3.configuration.BasicDialogContentConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardAdditionNoteConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardCommonConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardConfirmDialogConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardSelectConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTargetConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.forwardv3.configuration.listener.OnCustomForwardConfirmDialogContentView;
import com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener;
import com.ss.android.lark.forwardv3.configuration.targetconfig.AIConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.BotConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$GroupType;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$Shield;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$Status;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$Tenant;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$ThreadType;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$UserType;
import com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem;
import com.ss.android.lark.forwardv3.configuration.targetconfig.GroupConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.IncludeConfig;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.forwardv3.forward.imageforward.ImageForwardContent;
import com.ss.android.lark.forwardv3.forward.textforward.TextForwardContent;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.integrator.ccm.dependency.forward.CCMForward;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKBizConfigProvider;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.ApiUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@UserScope
public final class OfficeMessagingDependencyImpl extends i0 {

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J*\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J \u0010\u0016\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016¨\u0006 "}, d2 = {"Lcom/ss/android/lark/integrator/ccm/dependency/di/OfficeMessagingDependencyImpl$OfficeCcmImageConfirmView;", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnCustomForwardConfirmDialogContentView;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "setUpForwardMessage", "", "message", "Lcom/ss/android/lark/chat/entity/message/Message;", "interceptCustomForwardContent", "", "setupCustomForwardContentView", "activity", "Landroid/app/Activity;", "contentParent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "content", "Lcom/ss/android/lark/forwardv3/configuration/BasicDialogContentConfig;", "imageLoader", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnCustomForwardConfirmDialogContentView$ImageLoader;", "onViewClick", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "view", "Landroid/view/View;", "writeToParcel", "flags", "", "describeContents", "CREATOR", "assemble-office_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OfficeCcmImageConfirmView implements OnCustomForwardConfirmDialogContentView {
        public static final a CREATOR = null;

        public static final class a implements Parcelable.Creator<OfficeCcmImageConfirmView> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final OfficeCcmImageConfirmView createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "parcel");
                Intrinsics.checkNotNullParameter(r100, "parcel");
                return new OfficeCcmImageConfirmView();
            }

            @Override // android.os.Parcelable.Creator
            public final OfficeCcmImageConfirmView[] newArray(int r100) {
                return new OfficeCcmImageConfirmView[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        public OfficeCcmImageConfirmView() {
        }

        @Override // com.ss.android.lark.forwardv3.configuration.listener.OnCustomForwardConfirmDialogContentView
        public final void U0() {
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.ss.android.lark.forwardv3.configuration.listener.OnCustomForwardConfirmDialogContentView
        public final boolean n1() {
            return true;
        }

        @Override // com.ss.android.lark.forwardv3.configuration.listener.OnCustomForwardConfirmDialogContentView
        public final void p(Activity r100, Fragment r101, View r102) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
            Intrinsics.checkNotNullParameter(r102, "view");
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
        }

        @Override // com.ss.android.lark.forwardv3.configuration.listener.OnCustomForwardConfirmDialogContentView
        public final void E1(Activity r100, ConstraintLayout r101, BasicDialogContentConfig r102, OnCustomForwardConfirmDialogContentView.a r103) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "contentParent");
            Intrinsics.checkNotNullParameter(r102, "content");
            IIMApi r104 = (IIMApi) ApiUtils.getApi(IIMApi.class);
            if (r104 == null) goto L8;
            com.ss.android.lark.biz.im.api.d r105 = r104.chatApi();
            if (r105 == null) goto L9;
            r105.e();
            return;
        L9:
            return;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J.\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/integrator/ccm/dependency/di/OfficeMessagingDependencyImpl$OfficeCcmOnForwardContentListener;", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardContentListener;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "onSuccess", "", "activity", "Landroid/app/Activity;", "result", "", "", "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "allowToast", "onFailed", "", "errorTitle", "errorMessage", "writeToParcel", "flags", "", "describeContents", "CREATOR", "assemble-office_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OfficeCcmOnForwardContentListener implements OnForwardContentListener {
        public static final a CREATOR = null;

        public static final class a implements Parcelable.Creator<OfficeCcmOnForwardContentListener> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final OfficeCcmOnForwardContentListener createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "parcel");
                Intrinsics.checkNotNullParameter(r100, "parcel");
                return new OfficeCcmOnForwardContentListener();
            }

            @Override // android.os.Parcelable.Creator
            public final OfficeCcmOnForwardContentListener[] newArray(int r100) {
                return new OfficeCcmOnForwardContentListener[r100];
            }
        }

        public static final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Activity f427828a;

            public b(Activity r100) {
                this.f427828a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                UDToast.show(this.f427828a, R.string.CreationMobile_mention_sharing_success, R.drawable.ud_icon_yes_outlined);     // Catch: Throwable -> L4
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
            CREATOR = new a();
        }

        public OfficeCcmOnForwardContentListener() {
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
        }

        @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
        public final void onFailed(String r100) {
            tt5.a.d("OfficeMessagingDependencyImpl", "forward failed, errorTitle=null, errorMessage=" + r100);
        }

        @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
        public final boolean m(Activity r100, Map<String, ? extends ForwardTargetBaseInfoNew> r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r101, "result");
            if (r100 != null) goto L5;
            return true;
        L5:
            if (r102 == false) goto L7;
            UICallbackExecutor.execute(new b(r100));
        L7:
            return true;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.integrator.ccm.dependency.di.i0, com.bytedance.ee.bear.lark.dependency.t
    public final boolean Qc() {
        IOfficeSDKBizConfigProvider r100 = OfficeSDKManager.getBizConfigProvider();
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        boolean r103 = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.docx.mobile.share_words_preview_forward_container_enable");
        if (r102 == false) goto L12;
        if (r103 == false) goto L12;
        r101 = true;
    L12:
        tt5.a.h("OfficeMessagingDependencyImpl", "isForwardToImEnabled=" + r101 + ", imEnabled=" + r102 + ", fgEnabled=" + r103);
        return r101;
    L5:
        if (r100.isEnabled(IOfficeSDKBizConfigProvider.Biz.IM) != true) goto L7;
        r102 = true;
        goto L8
    }

    @Inject
    public OfficeMessagingDependencyImpl() {
    }

    public static void a(ForwardTemplateNew r100) {
        if (r100.getForwardTargetConfig().f425197d != null) goto L5;
        ForwardTargetConfig r101 = r100.getForwardTargetConfig();
        IncludeConfig.CREATOR.getClass();
        r101.f425197d = IncludeConfig.b.a();
    L5:
        IncludeConfig r102 = r100.getForwardTargetConfig().f425197d;
        if (r102 == null) goto L9;
        EntityItem.a r103 = new EntityItem.a();
        r103.a(new AIConfig());
        r102.a(r103.c());
        return;
    }

    @Override // com.ss.android.lark.integrator.ccm.dependency.di.i0, com.bytedance.ee.bear.lark.dependency.t
    public final void V0(Context r100, DocShareTextData r101) {
        bd(r100, r101, -1);
    }

    @Override // com.ss.android.lark.integrator.ccm.dependency.di.i0, com.bytedance.ee.bear.lark.dependency.t
    public final void aa(Context r100, DocImagesForwardData r110) {
        if (Qc() == true) goto L6;
        tt5.a.h("OfficeMessagingDependencyImpl", "forwardImage fallback to online behavior, im experiment disabled");
        CCMForward.a(r100, r110);
        return;
    L6:
        if (r100 == null) goto L32;
        if (r110 == null) goto L32;
        List<String> r101 = r110.getImages();
        if (r101 != null) goto L12;
        r101 = CollectionsKt.emptyList();
    L12:
        ArrayList<String> r102 = new ArrayList(r101);
        if (r102.isEmpty() == false) goto L16;
        tt5.a.k("OfficeMessagingDependencyImpl", "forwardImage ignored, image list is empty");
        return;
    L16:
        IIMApi r103 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r103 == null) goto L22;
        ImageContent r104 = new ImageContent();
        ImageSet r105 = new ImageSet();
        r104.setImageSet(r105);
        Image r106 = new Image();
        r105.setOrigin(r106);
        List<String> r107 = r110.getImages();
        if (r107 != null) goto L21;
        r107 = CollectionsKt.emptyList();
    L21:
        r106.setUrls(new ArrayList(r107));
        Message r108 = new Message();
        r108.setType(Message.Type.IMAGE);
        r108.setMessageContent(r104);
        r108.setOnTimeDel(false);
        BasicDialogContentConfig r109 = r103.chatApi().b();
        r109.f425138k = false;
    L30:
        ForwardTemplateNew.a r111 = new ForwardTemplateNew.a();
        r111.f425212g = 5;
        ImageForwardContent.a r112 = new ImageForwardContent.a();
        Intrinsics.checkNotNullParameter(r102, "imageList");
        r112.f425359a = r102;
        r111.f425211f = r112.a();
        ForwardAdditionNoteConfig.a r113 = new ForwardAdditionNoteConfig.a();
        r113.f425157a = r110.isCanAddExtraInfo();
        ForwardAdditionNoteConfig r114 = r113.a();
        Intrinsics.checkNotNullParameter(r114, "forwardAdditionNoteConfig");
        r111.f425209d = r114;
        ForwardConfirmDialogConfig.a r115 = new ForwardConfirmDialogConfig.a();
        r115.f425184d = r109;
        OfficeCcmImageConfirmView r116 = new OfficeCcmImageConfirmView();
        Intrinsics.checkNotNullParameter(r116, "listener");
        r115.f425185e = r116;
        ForwardConfirmDialogConfig r117 = r115.a();
        Intrinsics.checkNotNullParameter(r117, "forwardConfirmDialogConfig");
        r111.f425210e = r117;
        ForwardCommonConfig.a r118 = new ForwardCommonConfig.a();
        r118.f425173f = new OfficeCcmOnForwardContentListener();
        ForwardCommonConfig r119 = r118.a();
        Intrinsics.checkNotNullParameter(r119, "forwardCommonConfig");
        r111.f425208c = r119;
        ForwardTemplateNew r120 = r111.a();
        a(r120);
        tt5.a.h("OfficeMessagingDependencyImpl", "forwardImage by DoubaoForwardLauncher, imageSize=" + r102.size());
        com.suite.lark.platform.feature.forward.doubao.u.a(r100, r120, 0, null, 12);
        return;
    L22:
        BasicDialogContentConfig.a r121 = new BasicDialogContentConfig.a();
        String r122 = r110.getTitle();
        String r123 = "";
        if (r122 != null) goto L25;
        r122 = "";
    L25:
        Intrinsics.checkNotNullParameter(r122, "title");
        r121.f425140b = r122;
        String r124 = r110.getContent();
        if (r124 == null) goto L29;
        r123 = r124;
    L29:
        Intrinsics.checkNotNullParameter(r123, "content");
        r121.f425141c = r123;
        r109 = r121.a();
    L32:
        tt5.a.k("OfficeMessagingDependencyImpl", "forwardImage ignored, context or data is null");
    }

    @Override // com.ss.android.lark.integrator.ccm.dependency.di.i0, com.bytedance.ee.bear.lark.dependency.t
    public final void n3(FragmentActivity r210, ForwardTemplate r211) {
        if (Qc() == true) goto L6;
        tt5.a.h("OfficeMessagingDependencyImpl", "forwardWithTemplate fallback to online behavior, im experiment disabled");
        super.n3(r210, r211);
        return;
    L6:
        int r100 = OfficeForwardTemplateAdapter.f427813a;
        Intrinsics.checkNotNullParameter(r211, ThumbGlideUrl.SOURCE_TEMPLATE);
        ForwardFeature r101 = r211.f424787c;
        ForwardTemplateNew.a r102 = new ForwardTemplateNew.a();
        r102.f425212g = 3;
        TextForwardContent.a r103 = new TextForwardContent.a();
        Bundle r104 = r211.f424791g;
        if (r104 == null) goto L9;
        String r105 = r104.getString("share_url");
    L10:
        String r106 = "";
        if (r105 != null) goto L13;
        r105 = "";
    L13:
        Intrinsics.checkNotNullParameter(r105, "content");
        r103.f425380a = r105;
        r102.f425211f = r103.a();
        ForwardSelectConfig.a r107 = new ForwardSelectConfig.a();
        boolean r108 = r101.f424828d;
        r107.f425192b = !r108;
        r107.f425191a = r108;
        r107.f425193c = r101.f424829e;
        ForwardSelectConfig r109 = r107.a();
        Intrinsics.checkNotNullParameter(r109, "forwardSelectConfig");
        r102.f425207b = r109;
        ForwardTargetConfig.a r110 = new ForwardTargetConfig.a();
        r110.f425201a = r211.f424787c.f424835k;
        IncludeConfig r111 = new IncludeConfig();
        BusinessRecentVisitIncludeConfig r112 = r211.f424785a;
        if (r112 == null) goto L16;
        List r113 = r112.f424822a;
    L17:
        if (r113 != null) goto L20;
        r113 = CollectionsKt.emptyList();
    L20:
        if (r113.isEmpty() == false) goto L22;
        IncludeConfig.CREATOR.getClass();
        r111 = IncludeConfig.b.a();
        String r114 = "";
    L116:
        Intrinsics.checkNotNullParameter(r111, "includeConfig");
        r110.f425204d = r111;
        ForwardTargetConfig r115 = r110.a();
        Intrinsics.checkNotNullParameter(r115, "forwardTargetConfig");
        r102.f425206a = r115;
        ForwardAdditionNoteConfig.a r116 = new ForwardAdditionNoteConfig.a();
        r116.f425157a = r101.f424830f;
        r116.f425158b = false;
        ForwardAdditionNoteConfig r117 = r116.a();
        Intrinsics.checkNotNullParameter(r117, "forwardAdditionNoteConfig");
        r102.f425209d = r117;
        ForwardViewDependency r118 = r211.f424789e;
        ForwardConfirmDialogConfig.a r119 = new ForwardConfirmDialogConfig.a();
        String r120 = r118.f424865d;
        if (r120 != null) goto L119;
        r120 = r114;
    L119:
        Intrinsics.checkNotNullParameter(r120, "titleBarText");
        r119.f425181a = r120;
        String r121 = r118.f424868g;
        if (r121 != null) goto L122;
        r121 = r114;
    L122:
        Intrinsics.checkNotNullParameter(r121, "confirmButtonText");
        r119.f425182b = r121;
        String r122 = r118.f424869h;
        if (r122 != null) goto L125;
        r122 = r114;
    L125:
        Intrinsics.checkNotNullParameter(r122, "cancelButtonText");
        r119.f425183c = r122;
        BasicDialogContent r123 = r118.f424866e;
        BasicDialogContentConfig.a r124 = new BasicDialogContentConfig.a();
        if (r123 == null) goto L128;
        String r125 = r123.f424807a;
    L129:
        if (r125 != null) goto L131;
        r125 = r114;
    L131:
        Intrinsics.checkNotNullParameter(r125, "label");
        r124.f425139a = r125;
        if (r123 == null) goto L134;
        String r126 = r123.f424808b;
    L135:
        if (r126 != null) goto L137;
        r126 = r114;
    L137:
        Intrinsics.checkNotNullParameter(r126, "title");
        r124.f425140b = r126;
        if (r123 == null) goto L140;
        String r127 = r123.f424809c;
    L141:
        if (r127 != null) goto L143;
        r127 = r114;
    L143:
        Intrinsics.checkNotNullParameter(r127, "content");
        r124.f425141c = r127;
        if (r123 == null) goto L146;
        String r128 = r123.f424810d;
    L147:
        if (r128 != null) goto L149;
        r128 = r114;
    L149:
        Intrinsics.checkNotNullParameter(r128, "description");
        r124.f425142d = r128;
        if (r123 == null) goto L152;
        int r129 = r123.f424815i;
    L153:
        r124.f425143e = r129;
        if (r123 == null) goto L156;
        boolean r130 = r123.f424816j;
    L157:
        r124.f425148j = r130;
        if (r123 == null) goto L160;
        boolean r131 = r123.f424817k;
    L161:
        r124.f425149k = r131;
        if (r123 == null) goto L164;
        Image r132 = r123.f424812f;
    L165:
        if (r132 == null) goto L168;
        Image r133 = r123.f424812f;
        r124.f425144f = 0;
        r124.f425145g = r133;
        r124.f425146h = null;
        r124.f425147i = null;
    L193:
        r119.f425184d = r124.a();
        OfficeForwardTemplateAdapter.OfficeV2CustomConfirmView r134 = new OfficeForwardTemplateAdapter.OfficeV2CustomConfirmView(r211, r118.f424866e);
        Intrinsics.checkNotNullParameter(r134, "listener");
        r119.f425185e = r134;
        ForwardConfirmDialogConfig r135 = r119.a();
        Intrinsics.checkNotNullParameter(r135, "forwardConfirmDialogConfig");
        r102.f425210e = r135;
        ForwardCommonConfig.a r136 = new ForwardCommonConfig.a();
        String r137 = r211.f424789e.f424863b;
        if (r137 != null) goto L196;
        String r138 = r114;
    L197:
        Intrinsics.checkNotNullParameter(r138, "titleBarText");
        r136.f425171d = r138;
        r101.a();
        r136.f425170c = false;
        r136.f425169b = r101.f424827c;
        r136.f425173f = new OfficeForwardTemplateAdapter.OfficeV2ForwardContentAdapter();
        ForwardCommonConfig r139 = r136.a();
        Intrinsics.checkNotNullParameter(r139, "forwardCommonConfig");
        r102.f425208c = r139;
        ForwardTemplateNew r140 = r102.a();
        tt5.a.h("OfficeMessagingDependencyImpl", "forwardWithTemplate by DoubaoForwardLauncher");
        com.suite.lark.platform.feature.forward.doubao.u.a(r210, r140, 0, null, 12);
        return;
    L196:
        r138 = r137;
        goto L197
    L168:
        if (r123 == null) goto L170;
        Image r141 = r123.f424813g;
    L171:
        if (r141 == null) goto L173;
        Image r142 = r123.f424813g;
        r124.f425144f = 0;
        r124.f425145g = null;
        r124.f425146h = r142;
        r124.f425147i = null;
        goto L193
    L173:
        if (r123 == null) goto L175;
        StickImage r143 = r123.f424814h;
    L176:
        if (r143 == null) goto L185;
        StickImage r144 = r123.f424814h;
        if (r144 == null) goto L183;
        com.ss.android.lark.forwardv3.configuration.dto.StickImage r145 = new com.ss.android.lark.forwardv3.configuration.dto.StickImage();
        String r146 = r144.getKey();
        if (r146 != null) goto L182;
        r146 = r114;
    L182:
        Intrinsics.checkNotNullParameter(r146, "<set-?>");
        r145.f425217a = r146;
        r145.f425218b = r144.getWidth();
        r145.f425219c = r144.getHeight();
    L184:
        r124.f425144f = 0;
        r124.f425145g = null;
        r124.f425146h = null;
        r124.f425147i = r145;
        goto L193
    L183:
        r145 = null;
        goto L184
    L185:
        if (r123 == null) goto L187;
        int r147 = r123.f424811e;
    L188:
        if (r147 == 0) goto L193;
        if (r123 == null) goto L191;
        int r148 = r123.f424811e;
    L192:
        r124.f425144f = r148;
        r124.f425145g = null;
        r124.f425146h = null;
        r124.f425147i = null;
        goto L193
    L191:
        r148 = 0;
        goto L192
    L187:
        r147 = 0;
        goto L188
    L175:
        r143 = null;
        goto L176
    L170:
        r141 = null;
        goto L171
    L164:
        r132 = null;
        goto L165
    L160:
        r131 = false;
        goto L161
    L156:
        r130 = false;
        goto L157
    L152:
        r129 = 0;
        goto L153
    L146:
        r128 = null;
        goto L147
    L140:
        r127 = null;
        goto L141
    L134:
        r126 = null;
        goto L135
    L128:
        r125 = null;
        goto L129
    L22:
        Iterator r149 = r113.iterator();
    L24:
        if (r149.hasNext() == false) goto L113;
        com.ss.android.lark.forwardv2.dto.template.config.EntityItem r150 = (com.ss.android.lark.forwardv2.dto.template.config.EntityItem) r149.next();
        UserConfig r151 = r150.f424880a;
        int r152 = OfficeForwardTemplateAdapter.f427813a;
        if (r151 == null) goto L49;
        EntityItem.a r153 = new EntityItem.a();
        com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig.a r154 = new com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig.a();
        r154.b(OfficeForwardTemplateAdapter.a(r151.getTenantCondition()));
        Condition$UserTypeCondition r155 = r151.getUserTypeCondition();
        if (r155 != null) goto L30;
        int r156 = -1;
    L31:
        if (r156 != 1) goto L33;
        Condition$UserType r157 = Condition$UserType.SELF;
    L37:
        Intrinsics.checkNotNullParameter(r157, "userType");
        r154.f425256b = r157;
        Condition$ShieldTypeCondition r158 = r151.getShieldTypeCondition();
        if (r158 != null) goto L40;
        int r159 = -1;
    L42:
        if (r159 != 1) goto L44;
        Condition$Shield r160 = Condition$Shield.NORMAL;
    L48:
        Intrinsics.checkNotNullParameter(r160, "shield");
        r154.f425257c = r160;
        r153.f(r154.a());
        r111.a(r153.c());
        goto L49
    L44:
        if (r159 == 2) goto L46;
        r160 = Condition$Shield.ALL;
        goto L48
    L46:
        r160 = Condition$Shield.SHIELD;
        goto L48
    L40:
        r159 = OfficeForwardTemplateAdapter.a.f427823e[r158.ordinal()];
        goto L42
    L33:
        if (r156 == 2) goto L35;
        r157 = Condition$UserType.ALL;
        goto L37
    L35:
        r157 = Condition$UserType.OTHERS;
        goto L37
    L30:
        r156 = OfficeForwardTemplateAdapter.a.f427820b[r155.ordinal()];
    L49:
        GroupChatConfig r161 = r150.f424881b;
        if (r161 == null) goto L84;
        EntityItem.a r162 = new EntityItem.a();
        GroupConfig.a r163 = new GroupConfig.a();
        r163.b(OfficeForwardTemplateAdapter.a(r161.getTenantCondition()));
        Condition$GroupChatTypeCondition r164 = r161.getGroupChatTypeCondition();
        if (r164 != null) goto L54;
        int r165 = 1;
        int r166 = -1;
    L55:
        if (r166 != r165) goto L57;
        Condition$GroupType r167 = Condition$GroupType.NORMAL;
    L61:
        Intrinsics.checkNotNullParameter(r167, "groupType");
        r163.f425247b = r167;
        Condition$PublicTypeCondition r168 = r161.getPublicTypeCondition();
        if (r168 != null) goto L64;
        int r169 = -1;
    L66:
        if (r169 != 1) goto L68;
        Condition$Status r170 = Condition$Status.PUBLIC;
    L72:
        Intrinsics.checkNotNullParameter(r170, "status");
        r163.f425248c = r170;
        Condition$ShieldTypeCondition r171 = r161.getShieldTypeCondition();
        if (r171 != null) goto L75;
        int r172 = -1;
    L77:
        if (r172 != 1) goto L79;
        Condition$Shield r173 = Condition$Shield.NORMAL;
    L83:
        Intrinsics.checkNotNullParameter(r173, "shield");
        r163.f425249d = r173;
        r162.d(r163.a());
        r111.a(r162.c());
    L85:
        ThreadConfig r174 = r150.f424883d;
        if (r174 == null) goto L110;
        EntityItem.a r175 = new EntityItem.a();
        com.ss.android.lark.forwardv3.configuration.targetconfig.ThreadConfig.a r176 = new com.ss.android.lark.forwardv3.configuration.targetconfig.ThreadConfig.a();
        Condition$Tenant r177 = OfficeForwardTemplateAdapter.a(r174.getTenantCondition());
        Intrinsics.checkNotNullParameter(r177, "tenant");
        r176.f425252a = r177;
        Condition$ThreadTypeCondition r178 = r174.getThreadTypeCondition();
        if (r178 != null) goto L90;
        int r179 = -1;
    L92:
        if (r179 != 1) goto L94;
        Condition$ThreadType r180 = Condition$ThreadType.NORMAL_THREAD;
    L98:
        r176.b(r180);
        Condition$PublicTypeCondition r181 = r174.getPublicTypeCondition();
        if (r181 != null) goto L101;
        int r182 = 1;
        int r183 = -1;
    L102:
        if (r183 != r182) goto L104;
        Condition$Status r184 = Condition$Status.PUBLIC;
    L108:
        Intrinsics.checkNotNullParameter(r184, "status");
        r176.f425254c = r184;
        r175.e(r176.a());
        r111.a(r175.c());
        goto L110
    L104:
        if (r183 == 2) goto L106;
        r184 = Condition$Status.ALL;
        goto L108
    L106:
        r184 = Condition$Status.PRIVATE;
        goto L108
    L101:
        r183 = OfficeForwardTemplateAdapter.a.f427822d[r181.ordinal()];
        r182 = 1;
        goto L102
    L94:
        if (r179 == 2) goto L96;
        r180 = Condition$ThreadType.ALL;
        goto L98
    L96:
        r180 = Condition$ThreadType.MSG_THREAD;
        goto L98
    L90:
        r179 = OfficeForwardTemplateAdapter.a.f427824f[r178.ordinal()];
    L110:
        if (r150.f424882c == null) goto L112;
        EntityItem.a r185 = new EntityItem.a();
        r185.b(new BotConfig());
        r111.a(r185.c());
    L112:
        r106 = r106;
        goto L24
    L79:
        if (r172 == 2) goto L81;
        r173 = Condition$Shield.ALL;
        goto L83
    L81:
        r173 = Condition$Shield.SHIELD;
        goto L83
    L75:
        r172 = OfficeForwardTemplateAdapter.a.f427823e[r171.ordinal()];
        goto L77
    L68:
        if (r169 == 2) goto L70;
        r170 = Condition$Status.ALL;
        goto L72
    L70:
        r170 = Condition$Status.PRIVATE;
        goto L72
    L64:
        r169 = OfficeForwardTemplateAdapter.a.f427822d[r168.ordinal()];
        goto L66
    L57:
        if (r166 == 2) goto L59;
        r167 = Condition$GroupType.ALL;
        goto L61
    L59:
        r167 = Condition$GroupType.THREAD;
        goto L61
    L54:
        r166 = OfficeForwardTemplateAdapter.a.f427821c[r164.ordinal()];
        r165 = 1;
        goto L55
    L84:
        r106 = r106;
        goto L85
    L113:
        r114 = r106;
        if (((ArrayList) r111.f425250a).isEmpty() == false) goto L116;
        IncludeConfig.CREATOR.getClass();
        r111 = IncludeConfig.b.a();
        goto L116
    L16:
        r113 = null;
        goto L17
    L9:
        r105 = null;
        goto L10
    }

    @Override // com.ss.android.lark.integrator.ccm.dependency.di.i0, com.bytedance.ee.bear.lark.dependency.t
    public final void bd(Context r100, DocShareTextData r101, int r110) {
        if (Qc() == true) goto L6;
        tt5.a.h("OfficeMessagingDependencyImpl", "forwardText fallback to online behavior, im experiment disabled");
        CCMForward.b(r100, r101, r110);
        return;
    L6:
        if (r100 == null) goto L27;
        if (r101 == null) goto L27;
        ForwardTemplateNew.a r102 = new ForwardTemplateNew.a();
        r102.f425212g = 3;
        TextForwardContent.a r103 = new TextForwardContent.a();
        String r104 = r101.getContent();
        String r105 = "";
        if (r104 != null) goto L12;
        r104 = "";
    L12:
        Intrinsics.checkNotNullParameter(r104, "content");
        r103.f425380a = r104;
        r103.f425381b = r101.isLocalShare();
        String r106 = r101.getSourceName();
        if (r106 != null) goto L15;
        r106 = "";
    L15:
        Intrinsics.checkNotNullParameter(r106, "sourceName");
        r103.f425382c = r106;
        r102.f425211f = r103.a();
        ForwardConfirmDialogConfig.a r107 = new ForwardConfirmDialogConfig.a();
        BasicDialogContentConfig.a r108 = new BasicDialogContentConfig.a();
        String r109 = r101.getContent();
        if (r109 != null) goto L18;
        r109 = "";
    L18:
        Intrinsics.checkNotNullParameter(r109, "content");
        r108.f425141c = r109;
        String r111 = r101.getTitle();
        if (r111 == null) goto L22;
        r105 = r111;
    L22:
        Intrinsics.checkNotNullParameter(r105, "title");
        r108.f425140b = r105;
        r107.f425184d = r108.a();
        ForwardConfirmDialogConfig r112 = r107.a();
        Intrinsics.checkNotNullParameter(r112, "forwardConfirmDialogConfig");
        r102.f425210e = r112;
        ForwardAdditionNoteConfig.a r113 = new ForwardAdditionNoteConfig.a();
        r113.f425157a = r101.isCanAddExtraInfo();
        ForwardAdditionNoteConfig r114 = r113.a();
        Intrinsics.checkNotNullParameter(r114, "forwardAdditionNoteConfig");
        r102.f425209d = r114;
        ForwardCommonConfig.a r115 = new ForwardCommonConfig.a();
        r115.f425173f = new OfficeCcmOnForwardContentListener();
        ForwardCommonConfig r116 = r115.a();
        Intrinsics.checkNotNullParameter(r116, "forwardCommonConfig");
        r102.f425208c = r116;
        ForwardTemplateNew r117 = r102.a();
        a(r117);
        StringBuilder r118 = new StringBuilder("forwardText by DoubaoForwardLauncher, contentLen=");
        String r119 = r101.getContent();
        if (r119 == null) goto L25;
        int r120 = r119.length();
    L26:
        r118.append(r120);
        tt5.a.h("OfficeMessagingDependencyImpl", r118.toString());
        com.suite.lark.platform.feature.forward.doubao.u.a(r100, r117, r110, null, 8);
        return;
    L25:
        r120 = 0;
    L27:
        tt5.a.k("OfficeMessagingDependencyImpl", "forwardText ignored, context or data is null");
    }
}
