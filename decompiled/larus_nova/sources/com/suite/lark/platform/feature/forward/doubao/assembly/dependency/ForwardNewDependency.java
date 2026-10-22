package com.suite.lark.platform.feature.forward.doubao.assembly.dependency;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.auditsdk.v2.utils.AuditUtilsV2;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.biz.im.api.StickerContent;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.forwardv3.configuration.dto.StickImage;
import com.ss.android.lark.forwardv3.configuration.listener.OnCustomForwardConfirmDialogContentView;
import com.ss.android.lark.forwardv3.dependency.ExternalForwardDirection;
import com.ss.android.lark.forwardv3.dependency.IExternalForwardExecutor;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.picker.base.view.avatar.ExternalTargetAvatarProvider;
import com.ss.android.lark.picker.doubao.ExternalTargetConstants;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.richtext.RichText;
import com.suite.lark.platform.feature.forward.doubao.DoubaoForwardPicker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import mpc.e;
import tib.g;

/* JADX INFO: loaded from: classes36.dex */
@ClaymoreImpl(g.class)
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 K2\u00020\u0001:\u0003KLMB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J2\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!H\u0016J\b\u0010#\u001a\u00020\u0016H\u0016J\u0012\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u0016H\u0016J\"\u0010&\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010\u001fH\u0016J*\u0010&\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*2\b\u0010(\u001a\u0004\u0018\u00010\u001fH\u0016J\u0018\u0010+\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0016H\u0016J\b\u0010-\u001a\u00020\u0016H\u0016J*\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u0002000/2\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u000202\u0018\u00010/H\u0016J\b\u00103\u001a\u00020\u0016H\u0016J\u001a\u00104\u001a\u0004\u0018\u0001052\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u000107H\u0016J\b\u00108\u001a\u00020\u001cH\u0016J\u0018\u00109\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0016H\u0016J\"\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140/2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001607H\u0002J\b\u0010<\u001a\u00020\u0012H\u0016J\b\u0010=\u001a\u00020\u0012H\u0016J\n\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010@\u001a\u00020\u0016H\u0016J@\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u00162\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0016072\u0006\u0010F\u001a\u00020\u00162\u0006\u0010G\u001a\u00020\u00122\u0006\u0010H\u001a\u00020\u0016H\u0016J\n\u0010I\u001a\u0004\u0018\u00010JH\u0002¨\u0006N"}, d2 = {"Lcom/suite/lark/platform/feature/forward/doubao/assembly/dependency/ForwardNewDependency;", "Lcom/ss/android/lark/forwardv3/dependency/IForwardNewDependency;", "<init>", "()V", "createForwardChatPicker", "Lcom/ss/android/lark/forwardv3/dependency/ForwardChatPickerHolder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "showSquareMessageStickerThumb", "", "imageView", "Landroid/widget/ImageView;", "image", "Lcom/ss/android/lark/forwardv3/configuration/dto/StickImage;", "attachGlobalWatermark", "dialog", "Landroid/app/Dialog;", "hasFilePreviewPermissionFromMessage", "", "message", "Lcom/ss/android/lark/chat/entity/message/Message;", "getLoginUserId", "", "startCreateGroup", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "isEnableChatPreview", "requestCode", "", "startCreateGroupWithFilter", "param", "Landroid/os/Bundle;", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "getCreateGroupChatResultKey", "showNoIMPermissionDialog", "msg", "go2Chat", "chatId", "bundle", "chatMode", "Lcom/ss/android/lark/chat/entity/chat/Chat$ChatMode;", "go2Thread", "threadId", "getAppLinkDomain", "getChatterMap", "", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "recommendAtList", "Lcom/bytedance/lark/pb/basic/v1/Chatter;", "getCreateGroupSelectedDataKey", "getEventParams", "Lcom/ss/android/lark/forwardv3/statistics/EventParamsV3;", "messageIds", "", "getLoginUserAuthorityDeniedReason", "startProfile", "userid", "getMessageByIds", "isEnterSendEnabled", "isDoubaoWorkTabEnabled", "getExternalTargetItem", "Lcom/ss/android/lark/forwardv3/dependency/ExternalTargetItem;", "getExternalTargetId", "getExternalForwardExecutor", "Lcom/ss/android/lark/forwardv3/dependency/IExternalForwardExecutor;", "direction", "Lcom/ss/android/lark/forwardv3/dependency/ExternalForwardDirection;", "quasiTitle", "sourceChatId", "isThreadRootMsg", "originMergeForwardId", "getDoubaoForwardProtocol", "Lcom/suite/lark/platform/feature/forward/doubao/api/IDoubaoForwardProtocal;", "Companion", "LarkToDoubaoExternalForwardExecutor", "MockExternalForwardExecutor", "forward-doubao-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForwardNewDependency implements g {
    private static final a Companion = null;
    private static final long MOCK_EXECUTE_DELAY_MS = 1000;
    private static final String TAG = "ForwardNewDependency";

    public static final class LarkToDoubaoExternalForwardExecutor implements IExternalForwardExecutor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f461300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f461301b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<String> f461302c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f461303d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f461304e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f461305f;

        public LarkToDoubaoExternalForwardExecutor(e r100, String r101, List<String> r102, String r103, boolean r104, String r105) {
            Intrinsics.checkNotNullParameter(r101, "quasiTitle");
            Intrinsics.checkNotNullParameter(r102, "messageIds");
            Intrinsics.checkNotNullParameter(r103, "sourceChatId");
            Intrinsics.checkNotNullParameter(r105, "originMergeForwardId");
            this.f461300a = r100;
            this.f461301b = r101;
            this.f461302c = r102;
            this.f461303d = r103;
            this.f461304e = r104;
            this.f461305f = r105;
        }

        @Override // com.ss.android.lark.forwardv3.dependency.IExternalForwardExecutor
        public final void a(CoroutineScope r100, Context r101, List<? extends SearchBaseInfo> r110, String r111, RichText r112, IExternalForwardExecutor.a r113) {
            Intrinsics.checkNotNullParameter(r100, "scope");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r110, "items");
            Intrinsics.checkNotNullParameter(r111, "note");
            Intrinsics.checkNotNullParameter(r112, "richText");
            Intrinsics.checkNotNullParameter(r113, "callback");
            e r102 = this.f461300a;
            if (r102 != null) goto L6;
            r113.onFailure("doubao forward protocol is null");
            return;
        L6:
            List<String> r103 = this.f461302c;
            ArrayList r104 = new ArrayList();
            Iterator<T> r105 = r103.iterator();
        L8:
            if (r105.hasNext() == false) goto L13;
            Object r114 = r105.next();
            if ((!StringsKt.isBlank((String) r114)) == false) goto L8;
            r104.add(r114);
            goto L8
        L13:
            if (r104.isEmpty() == false) goto L16;
            r113.onFailure("lark message is empty");
            return;
        L16:
            BuildersKt.launch$default(r100, null, null, new ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$execute$1(r102, r104, r111, this, r113, null), 3, null);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b implements IExternalForwardExecutor {
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f461307a = null;

        static {
            int[] r100 = new int[ExternalForwardDirection.values().length];
            r100[ExternalForwardDirection.DOUBAO_TO_LARK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ExternalForwardDirection.LARK_TO_DOUBAO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f461307a = r100;
        }
    }

    public static final class d implements ExternalTargetAvatarProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f461308a;

        public d(e r100) {
            this.f461308a = r100;
        }

        @Override // com.ss.android.lark.picker.base.view.avatar.ExternalTargetAvatarProvider
        public final Drawable createDrawable() {
            return this.f461308a.K0().f514767c;
        }
    }

    static {
        Companion = new a();
    }

    public ForwardNewDependency() {
    }

    public OnCustomForwardConfirmDialogContentView getDoubaoForwardConfirmDialogContentView() {
        return null;
    }

    @Override // tib.g
    public String getExternalTargetId() {
        return ExternalTargetConstants.DOUBAO_EXTERNAL_TARGET_ID;
    }

    @Override // tib.g
    public boolean isDoubaoWorkTabEnabled() {
        return true;
    }

    @Override // tib.g
    public void startProfile(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "userid");
    }

    private final e getDoubaoForwardProtocol() {
        return (e) OfficeSDKManager.getHostGlobalService(e.class);
    }

    @Override // tib.g
    public String getCreateGroupChatResultKey() {
        IIMApi r100 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getCreateGroupChatResultKey();
    }

    @Override // tib.g
    public String getCreateGroupSelectedDataKey() {
        IIMApi r100 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getCreateGroupSelectedDataKey();
    }

    @Override // tib.g
    public tib.a getExternalTargetItem() {
        e r100 = getDoubaoForwardProtocol();
        if (r100 != null) goto L30;
        return null;
    L30:
        mpc.a r101 = r100.K0();     // Catch: Throwable -> L7
    L9:
        StringBuilder r102 = new StringBuilder("getExternalTargetItem: getDoubaoForwardItem iconDrawable==null? ");
        if (r101 == null) goto L12;
        Drawable r103 = r101.f514767c;
    L13:
        if (r103 != null) goto L15;
        boolean r104 = true;
    L16:
        r102.append(r104);
        Log.i(TAG, r102.toString());
        if (r101 != null) goto L20;
        return null;
    L20:
        if (StringsKt.isBlank(r101.f514765a) == false) goto L22;
    L28:
        Log.w(TAG, "getExternalTargetItem skip: invalid doubao forward item");
        return null;
    L22:
        if (StringsKt.isBlank(r101.f514766b) == true) goto L28;
        if (r101.f514767c == null) goto L28;
        return new tib.a(new d(r100), r101.f514766b);
    L15:
        r104 = false;
        goto L16
    L12:
        r103 = null;
    L7:
        th = move-exception;
        Log.e(TAG, "get doubao forward item failed", th);
        r101 = null;
        goto L9
    }

    @Override // tib.g
    public String getLoginUserId() {
        return ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d();
    }

    @Override // tib.g
    public boolean isEnterSendEnabled() {
        return ((IIMApi) ApiUtils.getApi(IIMApi.class)).isEnterSendEnabled();
    }

    @Override // tib.g
    public String getAppLinkDomain() {
        String r100 = jcb.b.c().a("applink");
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // tib.g
    public int getLoginUserAuthorityDeniedReason() {
        owa.a.b().getClass();
        return 10;
    }

    private final Map<String, Message> getMessageByIds(List<String> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<String> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        String r103 = r102.next();
        if (r103 == null) goto L4;
        r101.add(r103);
        goto L4
    L9:
        return ImSdkService.f().ta(r101);
    }

    @Override // tib.g
    public void attachGlobalWatermark(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        ljb.a.a().attachGlobalWatermark(r100);
    }

    @Override // tib.g
    public tib.c createForwardChatPicker(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        DoubaoForwardPicker r101 = new DoubaoForwardPicker(r100);
        return new tib.c(r101, r101);
    }

    @Override // tib.g
    public Map<String, Chatter> getChatterMap(Map<String, com.bytedance.lark.pb.basic.v1.Chatter> r100) {
        return ((IIMApi) ApiUtils.getApi(IIMApi.class)).getChatterMap(r100);
    }

    @Override // tib.g
    public zib.a getEventParams(List<String> r100) {
        String r101 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d();
        List<String> r102 = r100;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
        return null;
    L12:
        Map<String, Message> r104 = getMessageByIds(r100);
        if (CollectionUtils.isEmpty(r104) == false) goto L15;
        String r105 = null;
    L17:
        if (CollectionUtils.isEmpty(r104) == false) goto L19;
        String r106 = null;
    L20:
        Chat r107 = ((IIMApi) ApiUtils.getApi(IIMApi.class)).getChatById(r105);
        if (r107 == null) goto L25;
        Chat.Type r108 = r107.getType();
        if (r108 == null) goto L25;
        int r109 = r108.getNumber();
    L27:
        return new zib.a(r101, r105, r106, r109, r104);
    L25:
        r109 = -1;
        goto L27
    L19:
        r106 = ((Message) CollectionsKt.first(r104.values())).getThreadId();
        goto L20
    L15:
        r105 = ((Message) CollectionsKt.first(r104.values())).getChatId();
        goto L17
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L10
    }

    @Override // tib.g
    public boolean hasFilePreviewPermissionFromMessage(Message r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        boolean r101 = !owa.a.c().i(true);
        String r102 = getLoginUserId();
        if (TextUtils.isEmpty(r100.getOriginalSenderId()) == true) goto L8;
        String r103 = r100.getOriginalSenderId();
    L10:
        if (TextUtils.equals(r102, r103) == false) goto L13;
        Lazy r104 = AuditUtilsV2.f409687a;
        if (AuditUtilsV2.b() == true) goto L13;
        return true;
    L13:
        if (r101 == true) goto L15;
        return true;
    L15:
        if (r100.getType() != Message.Type.MEDIA) goto L17;
    L25:
        return false;
    L17:
        if (r100.getType() == Message.Type.IMAGE) goto L25;
        if (r100.getType() == Message.Type.FILE) goto L25;
        if (r100.getType() == Message.Type.FOLDER) goto L25;
        if (r100.getType() == Message.Type.STICKER) goto L25;
        return true;
    L8:
        r103 = r100.getFromId();
        goto L10
    }

    public String resolveDoubaoQuasiTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "quasiTitle");
        return r100;
    }

    @Override // tib.g
    public void showNoIMPermissionDialog(String r100) {
        IIMApi r101 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r101 != null) goto L5;
        return;
    L5:
        r101.showNoIMPermissionDialog(r100);
    }

    @Override // tib.g
    public void go2Thread(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "threadId");
        IIMApi r102 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r102 != null) goto L5;
        return;
    L5:
        l1.a r103 = new l1.a();
        r103.f410298e = r101;
        r103.f410316w = Boolean.TRUE;
        r102.openReplyInThread(r100, new l1(r103));
    }

    @Override // tib.g
    public void go2Chat(Context r100, String r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "chatId");
        if (Intrinsics.areEqual(r101, ExternalTargetConstants.DOUBAO_EXTERNAL_TARGET_ID) == false) goto L7;
        e r103 = (e) OfficeSDKManager.getHostGlobalService(e.class);
        if (r103 == null) goto L12;
        r103.D0();
        return;
    L12:
        return;
    L7:
        IIMApi r104 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r104 != null) goto L10;
        return;
    L10:
        ChatBundle.a r105 = new ChatBundle.a();
        r105.f409934a = r101;
        r105.f409957x = r102;
        r105.b(Boolean.TRUE);
        r104.openChat(r100, new ChatBundle(r105));
    }

    @Override // tib.g
    public void showSquareMessageStickerThumb(Context r100, ImageView r101, StickImage r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "imageView");
        IIMApi r103 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r102 == null) goto L6;
        String r104 = r102.f425217a;
        if (r104 == null) goto L6;
    L7:
        int r105 = 0;
        if (r102 == null) goto L10;
        int r106 = r102.f425218b;
    L11:
        if (r102 == null) goto L13;
        r105 = r102.f425219c;
    L13:
        r103.showSquareMessageStickerThumb(r100, r101, new StickerContent(r104, r106, r105));
        return;
    L10:
        r106 = 0;
    L6:
        r104 = "";
        goto L7
    }

    @Override // tib.g
    public void startCreateGroup(Fragment r100, boolean r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        IIMApi r103 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r103 != null) goto L5;
        return;
    L5:
        r103.openCreateGroupChatModuleForForward(r100, r101, r102);
    }

    @Override // tib.g
    public void go2Chat(Context r100, String r101, Chat.ChatMode r102, Bundle r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "chatId");
        Intrinsics.checkNotNullParameter(r102, "chatMode");
        if (Intrinsics.areEqual(r101, ExternalTargetConstants.DOUBAO_EXTERNAL_TARGET_ID) == false) goto L7;
        e r104 = (e) OfficeSDKManager.getHostGlobalService(e.class);
        if (r104 == null) goto L12;
        r104.D0();
        return;
    L12:
        return;
    L7:
        IIMApi r105 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r105 != null) goto L10;
        return;
    L10:
        ChatBundle.a r106 = new ChatBundle.a();
        r106.f409934a = r101;
        r106.f409957x = r103;
        r106.a(r102);
        r106.b(Boolean.TRUE);
        r105.openChat(r100, new ChatBundle(r106));
    }

    @Override // tib.g
    public void startCreateGroupWithFilter(Context r100, Fragment r101, Bundle r102, IGetDataCallback<Chat> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "param");
        IIMApi r104 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r104 != null) goto L5;
        return;
    L5:
        r104.createGroupChatFromForward(r100, r101, r102, r103);
    }

    @Override // tib.g
    public IExternalForwardExecutor getExternalForwardExecutor(ExternalForwardDirection r100, String r110, List<String> r111, String r112, boolean r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "direction");
        Intrinsics.checkNotNullParameter(r110, "quasiTitle");
        Intrinsics.checkNotNullParameter(r111, "messageIds");
        Intrinsics.checkNotNullParameter(r112, "sourceChatId");
        Intrinsics.checkNotNullParameter(r114, "originMergeForwardId");
        int r101 = c.f461307a[r100.ordinal()];
        if (r101 == 1) goto L10;
        if (r101 != 2) goto L8;
        return new LarkToDoubaoExternalForwardExecutor(getDoubaoForwardProtocol(), r110, r111, r112, r113, r114);
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return new DoubaoToLarkExternalForwardExecutor(com.suite.lark.platform.feature.forward.doubao.assembly.d.a());
    }
}
