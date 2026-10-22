package com.larus.bmhome.share.api;

import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.bot.share.ShareBotController$performShareBot$1;
import com.larus.bmhome.chat.detail.AbstractCommonDetailFragment;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.panel.b;
import com.larus.bmhome.share.panel.d;
import com.larus.bmhome.share.panel.h;
import com.larus.camera.impl.ui.viewmodel.b0;
import com.larus.im.bean.bot.BotModel;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import jr9.c;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;
import wc9.e;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H\u0016J$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH'JR\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H'Jh\u0010\u0017\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H'J4\u0010\u001e\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH'J\u0012\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010#H&J\u001a\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\nH&JG\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\n2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010'\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010-\u001a\u00020#H&¢\u0006\u0002\u0010.J\u0081\u0001\u0010/\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\n2\b\u00100\u001a\u0004\u0018\u00010\n2\b\u0010'\u001a\u0004\u0018\u00010\n2\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\n2\b\u00103\u001a\u0004\u0018\u00010,2\b\u00104\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u00106\u001a\u00020\u00052\n\b\u0002\u00107\u001a\u0004\u0018\u00010#H&¢\u0006\u0002\u00108J\u001c\u00109\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\\\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010>\u001a\u00020?2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010A\u001a\u00020\u00052\b\b\u0002\u0010B\u001a\u00020\u0005H&J_\u0010C\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010D\u001a\u0004\u0018\u00010\n2\b\u0010E\u001a\u0004\u0018\u00010\n2\u0006\u0010>\u001a\u00020?2\b\b\u0002\u0010F\u001a\u00020\u00052%\b\u0002\u0010G\u001a\u001f\u0012\u0013\u0012\u00110,¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u0003\u0018\u00010HH&J(\u0010L\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH&J2\u0010M\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010D\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH&J2\u0010N\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010D\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH&J0\u0010O\u001a\u00020\u00032\b\u0010D\u001a\u0004\u0018\u00010\n2\b\u0010E\u001a\u0004\u0018\u00010\n2\b\u0010P\u001a\u0004\u0018\u00010\n2\b\u0010Q\u001a\u0004\u0018\u00010\nH&J\u001e\u0010R\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u001c\u0010R\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010S\u001a\u0004\u0018\u00010\nH&J|\u0010T\u001a\u0004\u0018\u00010U2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010>\u001a\u0004\u0018\u00010?2\b\b\u0002\u0010V\u001a\u00020\u00052\b\b\u0002\u0010W\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010@\u001a\u0004\u0018\u00010\u00162\u0010\b\u0002\u0010X\u001a\n\u0012\u0004\u0012\u00020Z\u0018\u00010Y2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010[\u001a\n\u0012\u0004\u0012\u00020Z\u0018\u00010YH&J\u001c\u0010\\\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J$\u0010]\u001a\u0004\u0018\u00010;2\b\u0010^\u001a\u0004\u0018\u00010=2\u0006\u0010_\u001a\u00020`2\u0006\u0010>\u001a\u00020?H&J\u001a\u0010a\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010b\u001a\u00020\nH&JD\u0010c\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010\n2\b\u00101\u001a\u0004\u0018\u00010\n2\b\u00100\u001a\u0004\u0018\u00010\n2\u0006\u0010d\u001a\u00020\u00052\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J$\u0010f\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\n2\u0006\u0010g\u001a\u00020\u0005H&J:\u0010h\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010i\u001a\u0004\u0018\u00010\n2\u001c\b\u0002\u0010@\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010jH&J\u0012\u0010k\u001a\u00020\u00052\b\u0010D\u001a\u0004\u0018\u00010\nH&J\u001e\u0010l\u001a\u0004\u0018\u00010m2\b\u0010n\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010V\u001a\u00020\u0005H&J\u0012\u0010o\u001a\u0004\u0018\u00010p2\u0006\u0010\u0012\u001a\u00020\u0013H&¨\u0006q"}, d2 = {"Lcom/larus/bmhome/share/api/IShareService;", "", "init", "", "enableLongPressMessageShare", "", "performShareApp", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "enterFrom", "", "node", "Lcom/ixigua/lib/track/ITrackNode;", "performShareBot", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "currentPage", "sharePanelClickListener", "Lcom/larus/bmhome/share/panel/ISharePanelClickListener;", "performShareLink", "shareLink", "shareTitle", "shareSubTitle", "linkImageUrl", "eventParam", "Lcom/larus/bmhome/share/panel/SharePanelEventParam;", "performShareImage", "path", "sharePanelEventParam", "sendShareImageEvent", "params", "Lorg/json/JSONObject;", "sendShareEvokeAppEvent", "uri", "Landroid/net/Uri;", "botId", "clickShareChatButton", "isImmersiveBackground", "chatType", "messageCnt", "", "traceInfo", "(ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/ixigua/lib/track/ITrackNode;Lorg/json/JSONObject;)V", "shareMessageEvent", "clickFrom", "messageId", "showName", "isButtonAddText", "userType", "deepResearchId", "isAiDoc", "extra", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/ixigua/lib/track/ITrackNode;ZLorg/json/JSONObject;)V", "canShowConversationShareAction", "showSharePanel", "Landroidx/fragment/app/DialogFragment;", "activity", "Landroidx/fragment/app/FragmentActivity;", "shareContent", "Lcom/larus/bmhome/share/panel/FlowShareContent;", "callback", "landscapeFixedPanelWidth", "monitorShare", "share", "shareChannel", "shareType", DyPayConstant.KEY_SHOW_LOADING, "listener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "resultCode", "mobSharePanelShow", "mobSharePanelElementShow", "mobSharePanelClick", "mobShareResult", "shareId", "success", "getBotShareTitle", "botName", "getSharePanelView", "Lcom/larus/bmhome/share/panel/AbsSharePanelView;", "isImmersive", "isMainBot", "shareItemConfigs", "", "Lcom/larus/platform/model/share/ShareItemConfig;", "prependItemConfigs", "getShareSubTitle", "showLongImageSharePanel", "fragmentActivity", "longImageShareParams", "Lcom/larus/bmhome/share/panel/LongImageShareParams;", "copyContentToClipboard", "content", "sharePanelToastShow", "isSuccess", "errorMsg", "notifySystemAlbumUpdate", "isImage", "notifySystemImageUpdate", "imagePath", "Lkotlin/Function2;", "isInstalledChannel", "createShareItemUIConfig", "Lcom/larus/platform/model/share/ShareItemUIConfig;", "channelType", "getSharePanelConfig", "Lcom/larus/platform/model/share/SharePanelConfig;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IShareService {

    /* JADX INFO: loaded from: classes26.dex */
    public static final class a {
        public static /* synthetic */ void f(ShareServiceDelegate r100, String r101, String r102, String r110, boolean r111, AbstractCommonDetailFragment r112) {
            r100.l(r101, r102, r110, r111, null, r112);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void d(IShareService r100, Context r101, String r110, String r111, b r112, Function1 r113, int r114) {
            if ((r114 & 16) == 0) goto L5;
            boolean r102 = true;
        L7:
            if ((r114 & 32) == 0) goto L9;
            r113 = null;
        L9:
            r100.b(r101, r110, r111, r112, r102, r113);
            return;
        L5:
            r102 = false;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ com.larus.bmhome.share.panel.a a(ShareServiceDelegate r110, Context r111, ShareScene r112, b r113, boolean r114, h r115, d r116, List r117, int r118) {
            if ((r118 & 16) == 0) goto L5;
            boolean r100 = false;
        L7:
            if ((r118 & 128) == 0) goto L9;
            List r101 = null;
        L11:
            return r110.q(r111, r112, r113, false, r100, r115, r116, r101, null, null);
        L9:
            r101 = r117;
            goto L11
        L5:
            r100 = r114;
            goto L7
        }

        public static /* synthetic */ void b(ShareServiceDelegate r110, Context r111, e r112, BotModel r113, ShareScene r114, String r115, by7.e r116, ShareBotController$performShareBot$1 r117, int r118) {
            if ((r118 & 16) == 0) goto L5;
            String r100 = null;
        L7:
            if ((r118 & 32) == 0) goto L9;
            by7.e r101 = null;
        L11:
            if ((r118 & 64) == 0) goto L13;
            ShareBotController$performShareBot$1 r102 = null;
        L14:
            r110.f(r111, r112, r113, r114, r100, r101, r102);
            return;
        L13:
            r102 = r117;
            goto L14
        L9:
            r101 = r116;
            goto L11
        L5:
            r100 = r115;
            goto L7
        }

        public static /* synthetic */ DialogFragment g(IShareService r110, FragmentActivity r111, ShareScene r112, b r113, h r114, d r115, by7.e r116, boolean r117, int r210) {
            if ((r210 & 8) == 0) goto L5;
            h r100 = null;
        L7:
            if ((r210 & 16) == 0) goto L9;
            d r101 = null;
        L11:
            if ((r210 & 32) == 0) goto L13;
            by7.e r102 = null;
        L15:
            if ((r210 & 64) == 0) goto L17;
            boolean r118 = false;
        L19:
            if ((r210 & 128) == 0) goto L21;
            boolean r119 = true;
        L23:
            return r110.c(r111, r112, r113, r100, r101, r102, r118, r119);
        L21:
            r119 = false;
            goto L23
        L17:
            r118 = r117;
            goto L19
        L13:
            r102 = r116;
            goto L15
        L9:
            r101 = r115;
            goto L11
        L5:
            r100 = r114;
            goto L7
        }

        public static /* synthetic */ void c(IShareService r110, Context r111, String r112, String r113, String r114, ShareScene r115, h r116, by7.e r117, d r118, int r119) {
            if ((r119 & 64) == 0) goto L5;
            h r100 = null;
        L7:
            if ((r119 & 128) == 0) goto L9;
            by7.e r101 = null;
        L11:
            if ((r119 & 256) == 0) goto L13;
            d r102 = null;
        L14:
            r110.r(r111, r112, r113, r114, r115, null, r100, r101, r102);
            return;
        L13:
            r102 = r118;
            goto L14
        L9:
            r101 = r117;
            goto L11
        L5:
            r100 = r116;
            goto L7
        }

        public static /* synthetic */ void e(ShareServiceDelegate r110, boolean r111, String r112, String r113, String r114, String r115, String r116, Integer r210, String r211, by7.e r212, JSONObject r213, int r214) {
            if ((r214 & 256) == 0) goto L5;
            String r100 = null;
        L7:
            if ((r214 & 2048) == 0) goto L9;
            JSONObject r117 = null;
        L10:
            r110.e(r111, r112, r113, r114, r115, r116, r210, "bot", r100, r212, false, r117);
            return;
        L9:
            r117 = r213;
            goto L10
        L5:
            r100 = r211;
            goto L7
        }
    }

    boolean a(String r100);

    void b(Context r100, String r101, String r102, b r103, boolean r104, Function1<? super Integer, Unit> r105);

    DialogFragment c(FragmentActivity r100, ShareScene r101, b r102, h r103, d r104, by7.e r105, boolean r106, boolean r107);

    void d(String r100, String r101, String r102, String r103);

    void e(boolean r100, String r101, String r102, String r103, String r104, String r105, Integer r106, String r107, String r108, by7.e r110, boolean r111, JSONObject r112);

    @Deprecated(message = "use showSharePanel or share")
    void f(Context r100, e r101, BotModel r102, ShareScene r103, String r104, by7.e r105, d r106);

    jr9.b g(String r100);

    boolean h(e r100, BotModel r101);

    void i(ShareScene r100, String r101, h r102, by7.e r103);

    void init();

    DialogFragment j(FragmentActivity r100, com.larus.bmhome.share.panel.e r101, b r102);

    void k(boolean r100, String r101, Integer r102, String r103, by7.e r104, JSONObject r105);

    void l(String r100, String r101, String r102, boolean r103, String r104, AbstractCommonDetailFragment r105);

    boolean m();

    String n(Context r100, BotModel r101);

    void o(Context r100, String r101);

    String p(Context r100, BotModel r101);

    com.larus.bmhome.share.panel.a q(Context r100, ShareScene r101, b r102, boolean r103, boolean r104, h r105, d r106, List<jr9.a> r107, by7.e r108, List<jr9.a> r110);

    @Deprecated(message = "use showSharePanel or share")
    void r(Context r100, String r101, String r102, String r103, ShareScene r104, String r105, h r106, by7.e r107, d r108);

    void s(ShareScene r100, String r101, h r102, by7.e r103);

    c t(ShareScene r100);

    @Deprecated(message = "use showSharePanel or share")
    void u(Context r100, String r101, h r102, by7.e r103);

    void v(Uri r100, String r101);

    void w(JSONObject r100);

    void x(ShareScene r100, h r101, by7.e r102);

    void y(Context r100, String r101, b0 r102);
}
