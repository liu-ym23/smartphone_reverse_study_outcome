package com.larus.bmhome.share.api;

import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import by7.e;
import com.larus.bmhome.chat.detail.AbstractCommonDetailFragment;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.panel.a;
import com.larus.bmhome.share.panel.b;
import com.larus.bmhome.share.panel.d;
import com.larus.bmhome.share.panel.h;
import com.larus.camera.impl.ui.viewmodel.b0;
import com.larus.im.bean.bot.BotModel;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import jr9.c;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0001JF\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0096\u0001¢\u0006\u0002\u0010\u0016J\u001b\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u000eH\u0096\u0001J\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001e\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u001f\u001a\u00020\u0005H\u0096\u0001J\u001f\u0010 \u001a\u0004\u0018\u00010\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0001J\u001d\u0010 \u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010!\u001a\u0004\u0018\u00010\u000eH\u0096\u0001J\u0013\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%H\u0096\u0001Ju\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010$\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.2\u000e\u0010/\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001002\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u000e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100H\u0096\u0001J\u001d\u00103\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0001J\t\u00104\u001a\u00020\u000bH\u0096\u0001J\u0013\u00105\u001a\u00020\u00052\b\u00106\u001a\u0004\u0018\u00010\u000eH\u0096\u0001J/\u00107\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%2\b\u00106\u001a\u0004\u0018\u00010\u000e2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0001J/\u00108\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%2\b\u00106\u001a\u0004\u0018\u00010\u000e2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0001J%\u00109\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0001J1\u0010:\u001a\u00020\u000b2\b\u00106\u001a\u0004\u0018\u00010\u000e2\b\u0010;\u001a\u0004\u0018\u00010\u000e2\b\u0010<\u001a\u0004\u0018\u00010\u000e2\b\u0010=\u001a\u0004\u0018\u00010\u000eH\u0096\u0001J%\u0010>\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010?\u001a\u0004\u0018\u00010\u000e2\u0006\u0010@\u001a\u00020\u0005H\u0096\u0001J9\u0010A\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010B\u001a\u0004\u0018\u00010\u000e2\u001a\u0010-\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b\u0018\u00010CH\u0096\u0001J#\u0010D\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010E\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0097\u0001JM\u0010F\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010$\u001a\u00020%2\b\u0010G\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010H\u001a\u0004\u0018\u00010.H\u0097\u0001J1\u0010I\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010?\u001a\u0004\u0018\u00010\u000e2\b\u0010J\u001a\u0004\u0018\u00010,2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0097\u0001Ja\u0010K\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010L\u001a\u0004\u0018\u00010\u000e2\b\u0010M\u001a\u0004\u0018\u00010\u000e2\b\u0010N\u001a\u0004\u0018\u00010\u000e2\u0006\u0010$\u001a\u00020%2\b\u0010O\u001a\u0004\u0018\u00010\u000e2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010H\u001a\u0004\u0018\u00010.H\u0097\u0001J\u001b\u0010P\u001a\u00020\u000b2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010\u0011\u001a\u00020\u000eH\u0096\u0001J\u0013\u0010S\u001a\u00020\u000b2\b\u0010T\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J\\\u0010U\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u00106\u001a\u0004\u0018\u00010\u000e2\b\u0010;\u001a\u0004\u0018\u00010\u000e2\u0006\u0010(\u001a\u00020)2\u0006\u0010V\u001a\u00020\u00052#\u0010W\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\bY\u0012\b\bZ\u0012\u0004\b\b([\u0012\u0004\u0012\u00020\u000b\u0018\u00010XH\u0096\u0001J~\u0010\\\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010]\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010^\u001a\u00020\u000e2\u0006\u0010_\u001a\u00020\u000e2\b\u0010`\u001a\u0004\u0018\u00010\u00102\b\u0010a\u001a\u0004\u0018\u00010\u000e2\b\u0010b\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010c\u001a\u00020\u00052\b\u0010d\u001a\u0004\u0018\u00010\u0015H\u0096\u0001¢\u0006\u0002\u0010eJC\u0010f\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\b\u0010^\u001a\u0004\u0018\u00010\u000e2\b\u0010]\u001a\u0004\u0018\u00010\u000e2\u0006\u0010g\u001a\u00020\u00052\b\u0010h\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0001J%\u0010i\u001a\u0004\u0018\u00010j2\b\u0010k\u001a\u0004\u0018\u00010l2\u0006\u0010m\u001a\u00020n2\u0006\u0010(\u001a\u00020)H\u0096\u0001JS\u0010o\u001a\u0004\u0018\u00010j2\b\u0010p\u001a\u0004\u0018\u00010l2\u0006\u0010$\u001a\u00020%2\u0006\u0010(\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010q\u001a\u00020\u00052\u0006\u0010r\u001a\u00020\u0005H\u0096\u0001¨\u0006s"}, d2 = {"Lcom/larus/bmhome/share/api/ShareServiceDelegate;", "Lcom/larus/bmhome/share/api/IShareService;", "<init>", "()V", "canShowConversationShareAction", "", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "clickShareChatButton", "", "isImmersiveBackground", "chatType", "", "messageCnt", "", "botId", "node", "Lcom/ixigua/lib/track/ITrackNode;", "traceInfo", "Lorg/json/JSONObject;", "(ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/ixigua/lib/track/ITrackNode;Lorg/json/JSONObject;)V", "copyContentToClipboard", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "content", "createShareItemUIConfig", "Lcom/larus/platform/model/share/ShareItemUIConfig;", "channelType", "isImmersive", "enableLongPressMessageShare", "getBotShareTitle", "botName", "getSharePanelConfig", "Lcom/larus/platform/model/share/SharePanelConfig;", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "getSharePanelView", "Lcom/larus/bmhome/share/panel/AbsSharePanelView;", "shareContent", "Lcom/larus/bmhome/share/panel/FlowShareContent;", "isMainBot", "eventParam", "Lcom/larus/bmhome/share/panel/SharePanelEventParam;", "callback", "Lcom/larus/bmhome/share/panel/ISharePanelClickListener;", "shareItemConfigs", "", "Lcom/larus/platform/model/share/ShareItemConfig;", "prependItemConfigs", "getShareSubTitle", "init", "isInstalledChannel", "shareChannel", "mobSharePanelClick", "mobSharePanelElementShow", "mobSharePanelShow", "mobShareResult", "shareType", "shareId", "success", "notifySystemAlbumUpdate", "path", "isImage", "notifySystemImageUpdate", "imagePath", "Lkotlin/Function2;", "performShareApp", "enterFrom", "performShareBot", "currentPage", "sharePanelClickListener", "performShareImage", "sharePanelEventParam", "performShareLink", "shareLink", "shareTitle", "shareSubTitle", "linkImageUrl", "sendShareEvokeAppEvent", "uri", "Landroid/net/Uri;", "sendShareImageEvent", "params", "share", DyPayConstant.KEY_SHOW_LOADING, "listener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "resultCode", "shareMessageEvent", "clickFrom", "messageId", "showName", "isButtonAddText", "userType", "deepResearchId", "isAiDoc", "extra", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/ixigua/lib/track/ITrackNode;ZLorg/json/JSONObject;)V", "sharePanelToastShow", "isSuccess", "errorMsg", "showLongImageSharePanel", "Landroidx/fragment/app/DialogFragment;", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "longImageShareParams", "Lcom/larus/bmhome/share/panel/LongImageShareParams;", "showSharePanel", "activity", "landscapeFixedPanelWidth", "monitorShare", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareServiceDelegate implements IShareService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ShareServiceDelegate f313831b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IShareService f313832a;

    static {
        f313831b = new ShareServiceDelegate();
    }

    @Override // com.larus.bmhome.share.api.IShareService
    public final boolean a(String r100) {
        return this.f313832a.a(r100);
    }

    @Override // com.larus.bmhome.share.api.IShareService
    public final void b(Context r100, String r110, String r111, b r112, boolean r113, Function1<? super Integer, Unit> r114) {
        Intrinsics.checkNotNullParameter(r112, "shareContent");
        this.f313832a.b(r100, r110, r111, r112, r113, r114);
    }

    @Override // com.larus.bmhome.share.api.IShareService
    public final DialogFragment c(FragmentActivity r110, ShareScene r111, b r112, h r113, d r114, e r115, boolean r116, boolean r117) {
        Intrinsics.checkNotNullParameter(r111, "shareScene");
        Intrinsics.checkNotNullParameter(r112, "shareContent");
        return this.f313832a.c(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    @Override // com.larus.bmhome.share.api.IShareService
    public final void d(String r100, String r101, String r102, String r103) {
        this.f313832a.d(r100, r101, r102, r103);
    }

    @Override // com.larus.bmhome.share.api.IShareService
    public final void e(boolean r110, String r111, String r112, String r113, String r114, String r210, Integer r211, String r212, String r213, e r214, boolean r215, JSONObject r216) {
        Intrinsics.checkNotNullParameter(r114, "messageId");
        Intrinsics.checkNotNullParameter(r210, "showName");
        this.f313832a.e(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    @Override // com.larus.bmhome.share.api.IShareService
    @Deprecated(message = "use showSharePanel or share")
    public final void f(Context r110, wc9.e r111, BotModel r112, ShareScene r113, String r114, e r115, d r116) {
        Intrinsics.checkNotNullParameter(r113, "shareScene");
        this.f313832a.f(r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // com.larus.bmhome.share.api.IShareService
    public final jr9.b g(String r100) {
        return this.f313832a.g(r100);
    }

    @Override // com.larus.bmhome.share.api.IShareService
    public final boolean h(wc9.e r100, BotModel r101) {
        return this.f313832a.h(r100, r101);
    }

    @Override // com.larus.bmhome.share.api.IShareService
    public final void i(ShareScene r100, String r101, h r102, e r103) {
        Intrinsics.checkNotNullParameter(r100, "shareScene");
        this.f313832a.i(r100, r101, r102, r103);
    }

    @Override // com.larus.bmhome.share.api.IShareService
    public final void init() {
        this.f313832a.init();
    }

    @Override // com.larus.bmhome.share.api.IShareService
    public final DialogFragment j(FragmentActivity r100, com.larus.bmhome.share.panel.e r101, b r102) {
        Intrinsics.checkNotNullParameter(r101, "longImageShareParams");
        Intrinsics.checkNotNullParameter(r102, "shareContent");
        return this.f313832a.j(r100, r101, r102);
    }

    @Override // com.larus.bmhome.share.api.IShareService
    public final void k(boolean r100, String r110, Integer r111, String r112, e r113, JSONObject r114) {
        Intrinsics.checkNotNullParameter(r114, "traceInfo");
        this.f313832a.k(r100, r110, r111, r112, r113, r114);
    }

    @Override // com.larus.bmhome.share.api.IShareService
    public final void l(String r100, String r101, String r110, boolean r111, String r112, AbstractCommonDetailFragment r113) {
        this.f313832a.l(r100, r101, r110, r111, r112, r113);
    }

    @Override // com.larus.bmhome.share.api.IShareService
    public final boolean m() {
        return this.f313832a.m();
    }

    @Override // com.larus.bmhome.share.api.IShareService
    public final String n(Context r100, BotModel r101) {
        return this.f313832a.n(r100, r101);
    }

    @Override // com.larus.bmhome.share.api.IShareService
    public final void o(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "content");
        this.f313832a.o(r100, r101);
    }

    @Override // com.larus.bmhome.share.api.IShareService
    public final String p(Context r100, BotModel r101) {
        return this.f313832a.p(r100, r101);
    }

    @Override // com.larus.bmhome.share.api.IShareService
    public final a q(Context r110, ShareScene r111, b r112, boolean r113, boolean r114, h r115, d r116, List<jr9.a> r210, e r211, List<jr9.a> r212) {
        Intrinsics.checkNotNullParameter(r111, "shareScene");
        return this.f313832a.q(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    @Override // com.larus.bmhome.share.api.IShareService
    @Deprecated(message = "use showSharePanel or share")
    public final void r(Context r110, String r111, String r112, String r113, ShareScene r114, String r115, h r116, e r117, d r210) {
        Intrinsics.checkNotNullParameter(r114, "shareScene");
        this.f313832a.r(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    @Override // com.larus.bmhome.share.api.IShareService
    public final void s(ShareScene r100, String r101, h r102, e r103) {
        Intrinsics.checkNotNullParameter(r100, "shareScene");
        this.f313832a.s(r100, r101, r102, r103);
    }

    @Override // com.larus.bmhome.share.api.IShareService
    public final c t(ShareScene r100) {
        Intrinsics.checkNotNullParameter(r100, "shareScene");
        return this.f313832a.t(r100);
    }

    @Override // com.larus.bmhome.share.api.IShareService
    @Deprecated(message = "use showSharePanel or share")
    public final void u(Context r100, String r101, h r102, e r103) {
        this.f313832a.u(r100, r101, r102, r103);
    }

    @Override // com.larus.bmhome.share.api.IShareService
    public final void v(Uri r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "botId");
        this.f313832a.v(r100, r101);
    }

    @Override // com.larus.bmhome.share.api.IShareService
    public final void w(JSONObject r100) {
        this.f313832a.w(r100);
    }

    @Override // com.larus.bmhome.share.api.IShareService
    public final void x(ShareScene r100, h r101, e r102) {
        Intrinsics.checkNotNullParameter(r100, "shareScene");
        this.f313832a.x(r100, r101, r102);
    }

    @Override // com.larus.bmhome.share.api.IShareService
    public final void y(Context r100, String r101, b0 r102) {
        this.f313832a.y(r100, r101, r102);
    }

    private ShareServiceDelegate() {
        IShareService r100 = (IShareService) ServiceManager.get().getService(IShareService.class);
        if (r100 != null) goto L5;
        r100 = new ShareServiceNoop();
    L5:
        this.f313832a = r100;
    }
}
