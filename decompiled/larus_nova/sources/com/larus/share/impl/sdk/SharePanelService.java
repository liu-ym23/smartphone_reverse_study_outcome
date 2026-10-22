package com.larus.share.impl.sdk;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ee.bear.document.share.ShareItem;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.ShareRuntimeServiceDelegate;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.share.panel.d;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.home.impl.sdk.h2;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.o;
import com.larus.platform.service.z2;
import com.larus.share.impl.panel.ISharePanelService;
import com.larus.share.impl.panel.SharePanelDialog;
import com.larus.share.impl.sdk.special.ShareImageSpecialHandler;
import com.larus.share.impl.util.AigcImageMetadataOutputHelper;
import com.larus.share.impl.util.e;
import com.larus.share.impl.util.f;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.r;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.j;
import org.json.JSONObject;
import t19.s;
import v19.h;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016JR\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J[\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00172#\u0010\u001f\u001a\u001f\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0007\u0018\u00010 H\u0016JU\u0010%\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00172#\u0010\u001f\u001a\u001f\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0007\u0018\u00010 H\u0002JU\u0010&\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00172#\u0010\u001f\u001a\u001f\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0007\u0018\u00010 H\u0002JU\u0010'\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00172#\u0010\u001f\u001a\u001f\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0007\u0018\u00010 H\u0002JU\u0010(\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00172#\u0010\u001f\u001a\u001f\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0007\u0018\u00010 H\u0002J\u0018\u0010)\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0002J\u001c\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u0010-\u001a\u00020\u0017H\u0016J\u0012\u0010.\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020!2\u0006\u0010$\u001a\u00020!2\b\u00101\u001a\u0004\u0018\u000102H\u0016J(\u00103\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u00104J \u00105\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00106\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u00107R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/larus/share/impl/sdk/SharePanelService;", "Lcom/larus/share/impl/panel/ISharePanelService;", "<init>", "()V", "TAG", "", "init", "", "showSharePanel", "Landroidx/fragment/app/DialogFragment;", "activity", "Landroidx/fragment/app/FragmentActivity;", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "shareContent", "Lcom/larus/bmhome/share/panel/FlowShareContent;", "eventParam", "Lcom/larus/bmhome/share/panel/SharePanelEventParam;", "callback", "Lcom/larus/bmhome/share/panel/ISharePanelClickListener;", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "landscapeFixedPanelWidth", "", "monitorShare", "share", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "shareChannel", "shareType", DyPayConstant.KEY_SHOW_LOADING, "listener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "resultCode", ShareItem.SHARE_IMAGE, "shareVideo", "shareFile", "dispatchToRuntime", "shouldBlockFileEgress", "createShareItemUIConfig", "Lcom/larus/platform/model/share/ShareItemUIConfig;", "channelType", "isImmersive", "isInstalledChannel", "handleShareResultOnActivityResult", "requestCode", "intent", "Landroid/content/Intent;", "buildFinalImageShareContent", "(Landroid/content/Context;Ljava/lang/String;Lcom/larus/bmhome/share/panel/FlowShareContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveBitmapImageForShare", "isAIGC", "(Lcom/larus/bmhome/share/panel/FlowShareContent;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SharePanelService implements ISharePanelService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f368729b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<String> f368730c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f368731a;

    public static final class a {
    }

    static {
        f368729b = SetsKt.setOf(new String[]{"image", "video", "file"});
        f368730c = SetsKt.setOf(new String[]{"forward", ShareChannel.MERGE_FORWARD, ShareChannel.SINGLE_FORWARD, ShareChannel.ASK_DOUBAO, ShareChannel.COLLECT, "report", "delete", ShareChannel.PERMISSION_SETTING, "copy_link", ShareChannel.COPY_TEXT, ShareChannel.COPY_FEISHU_LINK, "publish", ShareChannel.SET_PRIVATE});
    }

    @Override // com.larus.share.impl.panel.ISharePanelService
    public final void init() {
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 == null) goto L7;
        r100.T();
        boolean r101 = true;
        if (h2.f346184a.isBasicMode() != true) goto L7;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        ShareRuntimeServiceDelegate.f313829b.c();
        return;
    L7:
        r101 = false;
        goto L8
    }

    public SharePanelService() {
        this.f368731a = "SharePanelService";
    }

    @Override // com.larus.share.impl.panel.ISharePanelService
    public final boolean a(String r110) {
        int r100 = com.larus.share.impl.sdk.a.f368732a;
        if (CollectionsKt.contains(SetsKt.setOf(new String[]{ShareChannel.DOUYIN, "wechat", ShareChannel.WX_MOMENTS, "qq", "more", "copy_link", ShareChannel.SAVE_VIDEO, ShareChannel.SHARE_LONG_PIC, ShareChannel.EXPORT_FILE}), r110) == true) goto L7;
        return true;
    L7:
        return ShareRuntimeServiceDelegate.f313829b.a(r110);
    }

    @Override // com.larus.share.impl.panel.ISharePanelService
    public final jr9.b e(String r100, boolean r101) {
        int r102 = com.larus.share.impl.sdk.a.f368732a;
        if (r100 != null) goto L5;
        return null;
    L5:
        switch(r100.hashCode()) {
            case -2095199449: goto L120;
            case -1879227763: goto L116;
            case -1335458389: goto L112;
            case -1321978579: goto L108;
            case -934521548: goto L104;
            case -791770330: goto L100;
            case -677145915: goto L96;
            case -401149172: goto L88;
            case -326564186: goto L84;
            case -235365105: goto L80;
            case -56908407: goto L76;
            case 3616: goto L72;
            case 3357525: goto L68;
            case 93227207: goto L64;
            case 293021118: goto L56;
            case 308055001: goto L52;
            case 949444906: goto L48;
            case 1235271283: goto L44;
            case 1397633267: goto L40;
            case 1403190297: goto L36;
            case 1406022185: goto L32;
            case 1415079737: goto L28;
            case 1505434244: goto L24;
            case 1505669047: goto L20;
            case 1927738830: goto L12;
            case 2126665127: goto L8;
            default: goto L150;
        };
    L150:
        return null;
    L8:
        if (r100.equals(ShareChannel.SHARE_LONG_PIC) == true) goto L125;
        return null;
    L125:
        return new jr9.b(R.drawable.larus_share_channel_icon_long_image, R.drawable.larus_share_channel_icon_long_image_rectangle, R.string.larus_cc_share_screenshot_button, null, 248);
    L12:
        if (r100.equals(ShareChannel.SINGLE_FORWARD) == false) goto L152;
        boolean r103 = h.f552477a;
        if (h.a(null) == false) goto L17;
        int r104 = R.drawable.larus_share_single_forward_dark;
    L126:
        return new jr9.b(r104, r104, R.string.larus_IM_QRCode_cta_forward_oneByOne, null, 248);
    L17:
        r104 = R.drawable.larus_share_single_forward;
        goto L126
    L152:
        return null;
    L20:
        if (r100.equals(ShareChannel.COPY_TEXT) == true) goto L127;
        return null;
    L127:
        return new jr9.b(R.drawable.larus_share_channel_icon_copy_text_rectangle, R.drawable.larus_share_channel_icon_copy_text_rectangle, R.string.larus_sharesheet_copytext, null, 248);
    L24:
        if (r100.equals("copy_link") == true) goto L128;
        return null;
    L128:
        return new jr9.b(R.drawable.larus_share_channel_icon_copy_link, R.drawable.larus_share_channel_icon_copy_link_rectangle, R.string.larus_sharesheet_copylink, null, 248);
    L28:
        if (r100.equals(ShareChannel.SAVE_VIDEO) == true) goto L129;
        return null;
    L129:
        return new jr9.b(R.drawable.larus_share_channel_icon_save, R.drawable.larus_share_channel_icon_save_rectangle, R.string.larus_sharesheet_savevideo, null, 248);
    L32:
        if (r100.equals(ShareChannel.SAVE_LOCAL) == true) goto L130;
        return null;
    L130:
        return new jr9.b(R.drawable.larus_share_channel_icon_save_local, R.drawable.larus_share_channel_icon_save_local, R.string.larus_file_preview_button_save_local, null, 248);
    L36:
        if (r100.equals(ShareChannel.SAVE_IMAGE) == true) goto L131;
        return null;
    L131:
        return new jr9.b(R.drawable.larus_share_channel_icon_save, R.drawable.larus_share_channel_icon_save_rectangle, R.string.larus_sharesheet_saveimage, null, 248);
    L40:
        if (r100.equals(ShareChannel.SAVE_CLOUD) == true) goto L132;
        return null;
    L132:
        return new jr9.b(R.drawable.larus_share_channel_icon_save_drive, R.drawable.larus_share_channel_icon_save_drive, R.string.larus_file_preview_button_save_drive, null, 248);
    L44:
        if (r100.equals(ShareChannel.WX_MOMENTS) == true) goto L133;
        return null;
    L133:
        return new jr9.b(R.drawable.larus_share_channel_icon_moment, 0, R.string.larus_sharesheet_wechatmoments_cn, null, 250);
    L48:
        if (r100.equals(ShareChannel.COLLECT) == true) goto L134;
        return null;
    L134:
        return new jr9.b(R.drawable.larus_share_channel_icon_collect, R.drawable.larus_share_channel_icon_collect_rectangle, R.string.larus_collections_tab, null, 248);
    L52:
        if (r100.equals(ShareChannel.COPY_FEISHU_LINK) == true) goto L135;
        return null;
    L135:
        return new jr9.b(R.drawable.larus_share_channel_icon_copy_feishu_link, 0, R.string.larus_doubaoPC_sharePanel_btn_copyFSLink, null, 250);
    L56:
        if (r100.equals(ShareChannel.MERGE_FORWARD) == false) goto L162;
        boolean r105 = h.f552477a;
        if (h.a(null) == false) goto L61;
        int r106 = R.drawable.larus_share_merge_forward_dark;
    L136:
        return new jr9.b(r106, r106, R.string.larus_IM_QRCode_cta_forward_combine, null, 248);
    L61:
        r106 = R.drawable.larus_share_merge_forward;
        goto L136
    L162:
        return null;
    L64:
        if (r100.equals(ShareChannel.DOUYIN) == false) goto L163;
        HashMap r107 = new HashMap();
        r107.put("url", Integer.valueOf(R.string.larus_sharesheet_douyinfriend_cn));
        r107.put(ShareType.FILE_URL, Integer.valueOf(R.string.larus_sharesheet_douyinfriend_cn));
        Unit r108 = Unit.INSTANCE;
        return new jr9.b(R.drawable.larus_share_channel_icon_douyin, 0, R.string.larus_douyin_anchor_share_icon, r107, 234);
    L163:
        return null;
    L68:
        if (r100.equals("more") == true) goto L138;
        return null;
    L138:
        return new jr9.b(R.drawable.larus_share_channel_icon_more, R.drawable.larus_share_channel_icon_more_rectangle, R.string.larus_sharesheet_more, null, 248);
    L72:
        if (r100.equals("qq") == true) goto L139;
        return null;
    L139:
        return new jr9.b(R.drawable.larus_share_channel_icon_qq, 0, R.string.larus_sharesheet_qqfriend_cn, null, 250);
    L76:
        if (r100.equals(ShareChannel.SCAN_QR_CODE) == true) goto L140;
        return null;
    L140:
        return new jr9.b(R.drawable.larus_share_scan_qr_code, R.drawable.larus_share_scan_qr_code, R.string.larus_accessibility_icon_scan, null, 248);
    L80:
        if (r100.equals("publish") == true) goto L141;
        return null;
    L141:
        return new jr9.b(R.drawable.larus_share_channel_icon_publish, 0, R.string.larus_aiCreation_saveShareSheet_btn_publishDoubao_cn, null, 250);
    L84:
        if (r100.equals(ShareChannel.SET_PRIVATE) == true) goto L142;
        return null;
    L142:
        return new jr9.b(R.drawable.larus_share_channel_icon_set_private, 0, R.string.larus_aiCreation_saveShareSheet_btn_makePrivate, null, 250);
    L88:
        if (r100.equals(ShareChannel.ASK_DOUBAO) == false) goto L169;
        boolean r109 = h.f552477a;
        if (h.a(null) == false) goto L93;
        int r110 = R.drawable.larus_share_ask_doubao_dark;
    L143:
        return new jr9.b(r110, r110, R.string.larus_aiDoc_selectText_askAI_cn, null, 248);
    L93:
        r110 = R.drawable.larus_share_ask_doubao;
        goto L143
    L169:
        return null;
    L96:
        if (r100.equals("forward") == false) goto L170;
        boolean r111 = h.f552477a;
        h.a(null);
        return new jr9.b(R.drawable.larus_share_forward, R.drawable.larus_share_forward, R.string.larus_send_to_feishuChat, null, 248);
    L170:
        return null;
    L100:
        if (r100.equals("wechat") == true) goto L145;
        return null;
    L145:
        return new jr9.b(R.drawable.larus_share_channel_icon_weixin, 0, R.string.larus_sharesheet_wechatfriend_cn, null, 250);
    L104:
        if (r100.equals("report") == true) goto L146;
        return null;
    L146:
        return new jr9.b(R.drawable.larus_share_channel_icon_feedback_complaint, R.drawable.larus_share_channel_icon_feedback_complaint, R.string.larus_feedback_share_entry_report, null, 248);
    L108:
        if (r100.equals(ShareChannel.CCM_SHARE) == true) goto L147;
        return null;
    L147:
        return new jr9.b(R.drawable.larus_share_channel_icon_ccm_share, R.drawable.larus_share_channel_icon_ccm_share, R.string.larus_cici_share_btn, null, 248);
    L112:
        if (r100.equals("delete") == true) goto L148;
        return null;
    L148:
        return new jr9.b(R.drawable.larus_share_channel_icon_delete_rectangle, R.drawable.larus_share_channel_icon_delete_rectangle, R.string.larus_long_press_delete_message, null, 248);
    L116:
        if (r100.equals(ShareChannel.MESSAGE_FORWARD) == true) goto L149;
        return null;
    L149:
        return new jr9.b(R.drawable.larus_share_forward, R.drawable.larus_share_forward, R.string.larus_IM_QRCode_cta_forward, null, 248);
    L120:
        if (r100.equals(ShareChannel.EXPORT_FILE) == true) goto L123;
        return null;
    L123:
        return new jr9.b(R.drawable.larus_share_channel_icon_export_file_rectangle, R.drawable.larus_share_channel_icon_export_file_rectangle, R.string.larus_exportFile_actionName, null, 248);
    }

    @Override // com.larus.share.impl.panel.ISharePanelService
    public final void d(int r100, int r101, Intent r102) {
        ShareRuntimeServiceDelegate.f313829b.b(r100, r101, r102);
    }

    public static final Object f(SharePanelService r210, Context r211, String r212, com.larus.bmhome.share.panel.b r213, Continuation r214) {
        com.larus.bmhome.share.panel.b r100 = r213;
        r210.getClass();
        if ((r214 instanceof SharePanelService$buildFinalImageShareContent$1) == false) goto L7;
        SharePanelService$buildFinalImageShareContent$1 r101 = (SharePanelService$buildFinalImageShareContent$1) r214;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = false;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        String r107 = (String) r101.L$1;
        com.larus.bmhome.share.panel.b r108 = (com.larus.bmhome.share.panel.b) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L82:
        AigcImageMetadataOutputHelper.a r109 = (AigcImageMetadataOutputHelper.a) r103;
        if (r109.f368762b == false) goto L85;
    L87:
        String r110 = r109.f368761a;
        if (r110 != null) goto L95;
        r110 = r107;
    L95:
        return com.larus.bmhome.share.panel.b.a(r108, r110, null, null, null, null, null, false, 50331644);
    L85:
        if (r109.f368763c == true) goto L87;
    L94:
        return null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r111 = r101.I$0;
        com.larus.bmhome.share.panel.b r112 = (com.larus.bmhome.share.panel.b) r101.L$1;
        Context r113 = (Context) r101.L$0;
        ResultKt.throwOnFailure(r103);
        int r114 = r111;
        r211 = r113;
        Object r115 = r103;
    L49:
        String r116 = (String) r115;
        if (r116 == null) goto L94;
        if (r116.length() <= 0) goto L54;
        boolean r117 = true;
    L55:
        if (r117 == false) goto L57;
        String r118 = r116;
    L58:
        if (r118 == null) goto L94;
        if (r114 == 0) goto L61;
    L64:
        boolean r119 = true;
    L65:
        r100 = com.larus.bmhome.share.panel.b.a(r112, r118, null, null, null, null, null, r119, 66912252);
    L67:
        if (r114 == 0) goto L97;
        String r120 = r100.f313858a;
        if (r120 != null) goto L72;
    L73:
        r106 = true;
    L74:
        if (r106 == true) goto L92;
        if (f.a(r120) == true) goto L92;
        int r121 = AigcImageMetadataOutputHelper.f368760a;
        com.larus.bmhome.share.panel.f r122 = r100.f313882y;
        r101.L$0 = r100;
        r101.L$1 = r120;
        r101.label = 2;
        Object r123 = AigcImageMetadataOutputHelper.b(r211, r120, r122, r101);
        if (r123 == r104) goto L93;
        r108 = r100;
        r103 = r123;
        r107 = r120;
    L93:
        return r104;
    L92:
        return r112;
    L72:
        if (r120.length() != 0) goto L74;
    L97:
        return r100;
    L61:
        if (r112.f313874q == true) goto L64;
        r119 = false;
        goto L65
    L57:
        r118 = null;
        goto L58
    L54:
        r117 = false;
        goto L55
    L16:
        ResultKt.throwOnFailure(r103);
        if (r100.f313882y != null) goto L19;
    L21:
        r114 = 0;
    L22:
        Bitmap r124 = r100.f313859b;
        if (r124 != null) goto L25;
    L27:
        boolean r125 = false;
    L28:
        if (r125 == false) goto L33;
        if (r114 == 0) goto L31;
    L32:
        boolean r126 = true;
    L34:
        if (r114 != 0) goto L37;
        if (r126 == true) goto L37;
        return r100;
    L37:
        if (r126 == false) goto L66;
        FLogger.f375446a.i(r210.f368731a, "[buildFinalImageShareContent] materialize bitmap for channel=" + r212);
        if (r100.f313874q == false) goto L42;
        if (r114 != 0) goto L42;
        boolean r127 = true;
    L43:
        r101.L$0 = r211;
        r101.L$1 = r100;
        r101.I$0 = r114;
        r101.label = 1;
        j r128 = new j(IntrinsicsKt.intercepted(r101), 1);
        r128.C();
        ImageSave.z(ImageSave.f295932a, "", r100.f313859b, r100.f313873p, null, r127, false, null, new c(r128), 104);
        Object r129 = r128.B();
        if (r129 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L46;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L46:
        if (r129 == r104) goto L93;
        r115 = r129;
        r112 = r100;
    L42:
        r127 = false;
        goto L43
    L66:
        r211 = r211;
        r112 = r100;
        goto L67
    L31:
        if (Intrinsics.areEqual(r212, ShareChannel.SAVE_IMAGE) == true) goto L32;
    L33:
        r126 = false;
        goto L34
    L25:
        if (r124.isRecycled() == true) goto L27;
        r125 = true;
        goto L28
    L19:
        if (z2.f365865a.aigcMetadataConfig().getEnableConversationImageMetadata() == false) goto L21;
        r114 = 1;
    L7:
        r101 = new SharePanelService$buildFinalImageShareContent$1(r210, r214);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.share.impl.panel.ISharePanelService
    public final void b(Context r110, String r111, String r210, com.larus.bmhome.share.panel.b r211, boolean r212, Function1<? super Integer, Unit> r213) {
        Intrinsics.checkNotNullParameter(r211, "shareContent");
        if (r110 == 0) goto L140;
        if (r111 == null) goto L140;
        if (r210 == null) goto L140;
        boolean r112 = false;
        if (Intrinsics.areEqual(r210, ShareType.FILE_URL) == false) goto L20;
        e.f368769a.getClass();
        if (e.f368770b.contains(r111) == true) goto L29;
        FlowFileProtectionService r100 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r100 != null) goto L14;
    L16:
        boolean r101 = false;
    L17:
        if (r101 == false) goto L29;
    L28:
        boolean r102 = true;
    L30:
        LifecycleOwner r113 = null;
        if (r102 == false) goto L62;
        FLogger.f375446a.d(this.f368731a, "share blocked by enterprise file security channel=" + r111 + " type=" + r210);
        o r103 = o.f365780a;
        JSONObject r104 = new JSONObject();
        r104.put("action", "share");
        r104.put("entry", "share_service");
        r104.put("channel", r111);
        r104.put("content_type", r210);
        Unit r105 = Unit.INSTANCE;
        r103.reportEvent("flow_enterprise_file_egress_block", r104);
        FlowFileProtectionService r106 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        switch(r111.hashCode()) {
            case -2095199449: goto L45;
            case 1403190297: goto L42;
            case 1406022185: goto L39;
            case 1415079737: goto L36;
            default: goto L49;
        };
    L49:
        if (r106 == null) goto L51;
        String r107 = r106.A0();
    L52:
        if (r107 != null) goto L54;
    L59:
        if (r213 == null) goto L142;
        r213.invoke(2);
        return;
    L142:
        return;
    L54:
        if ((!StringsKt.isBlank(r107)) == false) goto L56;
        String r108 = r107;
    L57:
        if (r108 == null) goto L59;
        s.j(s.f544207a, r110, r108, null, false, 28);
        goto L59
    L56:
        r108 = null;
    L51:
        r107 = null;
        goto L52
    L36:
        if (r111.equals(ShareChannel.SAVE_VIDEO) == false) goto L49;
    L47:
        if (r106 == null) goto L51;
        r107 = r106.H0();
        goto L52
    L39:
        if (r111.equals(ShareChannel.SAVE_LOCAL) == true) goto L47;
    L42:
        if (r111.equals(ShareChannel.SAVE_IMAGE) == false) goto L49;
    L45:
        if (r111.equals(ShareChannel.EXPORT_FILE) == true) goto L47;
    L62:
        int r109 = r210.hashCode();
        if (r109 == 3143036) goto L133;
        if (r109 == 100313435) goto L121;
        if (r109 == 112202875) goto L70;
    L134:
        g(r110, r111, r210, r211, r212, r213);
        return;
    L70:
        if (r210.equals("video") == false) goto L134;
        if (new ShareImageSpecialHandler().j(r110, r111, r210, r211, r212, r213) == false) goto L76;
        return;
    L76:
        if (Intrinsics.areEqual(r111, ShareChannel.SAVE_VIDEO) == false) goto L101;
        String r114 = r.h();
        String r115 = "";
        if (r114 != null) goto L80;
        r114 = "";
    L80:
        FLogger.f375446a.i(this.f368731a, "[shareVideo] videoUrl = " + r211.f313862e + ", albumDirPath = " + r114);
        String r116 = r211.f313862e;
        if (r116 == null) goto L85;
        r115 = r116;
    L85:
        if (new PolarisFileWrapper(r115).exists() == false) goto L101;
        if (o0.d(r114) == false) goto L101;
        String r117 = r211.f313862e;
        if (r117 == null) goto L93;
        boolean r118 = StringsKt.contains$default(r117, r114, false, 2, null);
        int r119 = 1;
        if (r118 != true) goto L94;
        boolean r120 = true;
    L95:
        if (r120 == false) goto L101;
        if (r213 == null) goto L98;
        r213.invoke(Integer.valueOf(r119));
    L98:
        s.f544207a.getClass();
        s.o(r110, R.string.larus_save_success, false);
        return;
    L94:
        r120 = false;
        goto L95
    L93:
        r119 = 1;
    L101:
        if (o0.d(r211.f313862e) == false) goto L107;
        int r121 = f.f368775a;
        if (f.a(r211.f313862e) == true) goto L107;
        if (Intrinsics.areEqual(r111, ShareChannel.SAVE_VIDEO) == false) goto L107;
        e.f368769a.f(r110, r211.f313862e, false, r213);
        return;
    L107:
        String r122 = r211.f313862e;
        if (r122 != null) goto L110;
    L111:
        r112 = true;
    L112:
        if (r112 == true) goto L114;
    L119:
        g(r110, r111, r210, r211, r212, r213);
        return;
    L114:
        if (Intrinsics.areEqual(r111, ShareChannel.SAVE_VIDEO) == false) goto L119;
        FLogger.f375446a.e(this.f368731a, "[shareVideo] videoUrl is empty for SAVE_VIDEO, abort");
        if (r213 == null) goto L118;
        r213.invoke(2);
    L118:
        s.f544207a.getClass();
        s.s(r110, R.string.larus_save_failed);
        return;
    L110:
        if (r122.length() != 0) goto L112;
    L121:
        if (r210.equals("image") == false) goto L134;
        if ((r110 instanceof LifecycleOwner) == false) goto L126;
        r113 = (LifecycleOwner) r110;
    L126:
        if (r113 == null) goto L130;
        CoroutineScope r123 = LifecycleOwnerKt.getLifecycleScope(r113);
        if (r123 == null) goto L130;
    L131:
        BuildersKt.launch$default(r123, null, null, new SharePanelService$shareImage$1(r110, r213, r111, r210, r212, this, r211, null), 3, null);
        return;
    L130:
        r123 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate());
        goto L131
    L133:
        if (r210.equals("file") == false) goto L134;
        int r124 = f.f368775a;
        if (f.a(r211.f313869l) == false) goto L138;
        FLogger.f375446a.i(this.f368731a, "[shareFile] network file is not supported");
        return;
    L138:
        g(r110, r111, r210, r211, r212, r213);
        return;
    L14:
        if (r100.I0() != true) goto L16;
        r101 = true;
    L29:
        r102 = false;
        goto L30
    L20:
        if (f368729b.contains(r210) == false) goto L29;
        if (f368730c.contains(r111) == true) goto L29;
        FlowFileProtectionService r125 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r125 == null) goto L29;
        if (r125.I0() != true) goto L29;
    L140:
        FLogger.f375446a.i(this.f368731a, "context == null || shareChannel == null || shareType == null " + r110 + ' ' + r111 + ' ' + r210);
    }

    public final void g(Context r110, String r111, String r112, com.larus.bmhome.share.panel.b r113, boolean r114, Function1<? super Integer, Unit> r115) {
        FLogger.f375446a.i(this.f368731a, "ShareRuntimeServiceDelegate.share channel=" + r111 + " type=" + r112);
        ShareRuntimeServiceDelegate.f313829b.d(r110, r111, r112, r113, r114, new b(r110, r115));
        if (r115 == null) goto L6;
        r115.invoke(3);
        return;
    }

    @Override // com.larus.share.impl.panel.ISharePanelService
    public final DialogFragment c(FragmentActivity r110, ShareScene r111, com.larus.bmhome.share.panel.b r112, com.larus.bmhome.share.panel.h r210, d r211, by7.e r212, boolean r213, boolean r214) {
        Intrinsics.checkNotNullParameter(r111, "shareScene");
        Intrinsics.checkNotNullParameter(r112, "shareContent");
        if (r214 == false) goto L32;
        com.larus.share.impl.e r100 = com.larus.share.impl.a.f368590a;
        com.larus.share.impl.a.m(r111, r112, r212, "custom");
    L32:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L23
        if (r110 != null) goto L9;
    L21:
        com.larus.share.impl.a.k(r111, r112, "activity finishing", r212, "custom");     // Catch: Throwable -> L23
        return null;
    L9:
        if (r110.isFinishing() == true) goto L21;
        if (r110.isDestroyed() == true) goto L21;
        if (r110.getSupportFragmentManager().isStateSaved() == true) goto L21;
        jr9.c r102 = com.larus.share.impl.sdk.a.a(r111);     // Catch: Throwable -> L23
        SharePanelDialog r103 = new SharePanelDialog();     // Catch: Throwable -> L23
        r103.V90(r110, r111, r102, r112, r210, r211, r212, r213, r214);     // Catch: Throwable -> L23
        FragmentManager r104 = r110.getSupportFragmentManager();     // Catch: Throwable -> L23
        LandscapeRestrictionOperation r105 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L23
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r103, "share_dialog", r105);     // Catch: Throwable -> L23
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r104, r103, r105) == false) goto L30;
    L20:
        return r103;
    L30:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L29 Throwable -> L23
    L19:
        r103.show(r104, "share_dialog");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Throwable r107 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r107 == null) goto L28;
        FLogger.f375446a.i(this.f368731a, r107.toString());
        com.larus.share.impl.e r108 = com.larus.share.impl.a.f368590a;
        com.larus.share.impl.a.k(r111, r112, r107.toString(), r212, "custom");
    L28:
        return null;
    }
}
