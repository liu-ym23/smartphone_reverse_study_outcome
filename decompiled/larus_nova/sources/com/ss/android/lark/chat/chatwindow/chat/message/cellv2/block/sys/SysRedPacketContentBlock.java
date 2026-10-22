package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.sys;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.nova.R;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.lark.audit.AuditManager;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.content.SystemContent;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.chat.export.entity.message.content.SystemMessageType;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.f1;
import com.ss.android.lark.chat.utils.p;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.authorization.ThridPartySDKAuthEffectType;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.dialog.CommonLoadingDialog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import w4b.x;

/* JADX INFO: loaded from: classes35.dex */
public final class SysRedPacketContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<com.ss.android.lark.chat.base.view.vo.message.d>, Object> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f413240g;

    public static final class a implements k<View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f413241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f413242b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f413243c;

        @Override // com.ss.android.lark.blueprint.k
        public final View getView() {
            return this.f413241a;
        }

        public a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f413241a = r100;
            this.f413242b = r100.findViewById(R.id.system_message_check_label);
            this.f413243c = (TextView) r100.findViewById(R.id.system_label);
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f413244a = null;

        static {
            int[] r100 = new int[SystemMessageType.values().length];
            r100[SystemMessageType.GRAB_OTHER_HONGBAO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[SystemMessageType.OTHER_GRAB_MY_HONGBAO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[SystemMessageType.LAST_HONGBAO_IS_GRABBED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[SystemMessageType.SIMPLIFY_OTHER_GRAB_MY_HONGBAO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[SystemMessageType.SIMPLIFY_OTHER_GRAB_MY_HONGBAO_NOT_OVER_OUT_NUM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[SystemMessageType.SEND_HONGBAO_MESSAGE_FAILED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f413244a = r100;
        }
    }

    public static final class d implements f1.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SysRedPacketContentBlock f413245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map<String, String> f413246b;

        public d(SysRedPacketContentBlock r100, Map<String, String> r101) {
            this.f413245a = r100;
            this.f413246b = r101;
        }

        @Override // com.ss.android.lark.chat.utils.f1.b.a
        public final void a(SystemMessageType r100) {
            Intrinsics.checkNotNullParameter(r100, "systemMessageType");
            if (SysRedPacketContentBlock.h(this.f413245a) == true) goto L6;
            LKUIToast.show(this.f413245a.f412673c.getContext(), R.string.Lark_Core_OpenRedPacketDisabledByAdmin_Toast);
            return;
        L6:
            String r101 = this.f413246b.get(MusicAppletPage.KEY_MESSAGE_ID);
            String r102 = this.f413246b.get("hongbao_id");
            if (this.f413245a.f412673c.a() == false) goto L11;
            ChatCoreModule.a().getChatDependency().m(this.f413245a.f412673c.getContext());
            Log.i("SysRedPacketContentBlock", "showDialogWhenInterceptClickForVcVisitor");
            return;
        L11:
            if (TextUtils.isEmpty(r102) == true) goto L21;
            ChatCoreModule.a().getMiraDependency().isPluginInstalled(ChatCoreModule.a().getMoneyDependency().getMoneyPluginPackageName());
            ChatCoreModule.a().getMiraDependency().isPluginLoaded(ChatCoreModule.a().getMoneyDependency().getMoneyPluginPackageName());
            y5c.a r103 = y5c.a.f566285a;
            Statistics.sendEvent("money_plugin", new JSONObject().put("scene", "open_red_packet").put(MonitorConstants.APP_INSTALL_STATUS, 0).put(FrescoMonitorConst.LOAD_STATUS, 0));
            this.f413245a.getClass();
            if (r100 != SystemMessageType.OTHER_GRAB_MY_HONGBAO) goto L15;
        L19:
            x r104 = ChatCoreModule.a().getMoneyDependency();
            new CommonLoadingDialog();
            r104.a();
            return;
        L15:
            if (r100 == SystemMessageType.LAST_HONGBAO_IS_GRABBED) goto L19;
            if (r100 == SystemMessageType.SIMPLIFY_OTHER_GRAB_MY_HONGBAO) goto L19;
            SystemMessageType r105 = SystemMessageType.SIMPLIFY_OTHER_GRAB_MY_HONGBAO_NOT_OVER_OUT_NUM;
            goto L19
        }
    }

    public static final class e implements f1.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SysRedPacketContentBlock f413247a;

        public e(SysRedPacketContentBlock r100) {
            this.f413247a = r100;
        }

        @Override // com.ss.android.lark.chat.utils.f1.b.a
        public final void a(SystemMessageType r100) {
            if (SysRedPacketContentBlock.h(this.f413247a) == true) goto L6;
            LKUIToast.show(this.f413247a.f412673c.getContext(), R.string.Lark_Core_OpenRedPacketDisabledByAdmin_Toast);
            return;
        L6:
            ChatCoreModule.a().getMiraDependency().isPluginInstalled(ChatCoreModule.a().getMoneyDependency().getMoneyPluginPackageName());
            ChatCoreModule.a().getMiraDependency().isPluginLoaded(ChatCoreModule.a().getMoneyDependency().getMoneyPluginPackageName());
            y5c.a r101 = y5c.a.f566285a;
            Statistics.sendEvent("money_plugin", new JSONObject().put("scene", "open_wallet").put(MonitorConstants.APP_INSTALL_STATUS, 0).put(FrescoMonitorConst.LOAD_STATUS, 0));
            x r102 = ChatCoreModule.a().getMoneyDependency();
            new CommonLoadingDialog();
            r102.a();
        }
    }

    static {
    }

    @Override // com.ss.android.lark.blueprint.i
    public final j getKey() {
        return this.f413240g;
    }

    public SysRedPacketContentBlock(g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f413240g = IMMessageKeys$Blocks.SYS_RED_PACKET;
    }

    public static final boolean h(SysRedPacketContentBlock r100) {
        r100.getClass();
        Pair<Integer, Integer> r101 = AuditManager.getInstance().checkAuthorityWithErrorType(28, "SDK", String.valueOf(ThridPartySDKAuthEffectType.PaySDK.getValue()));
        Log.i("SysRedPacketContentBlock", "checkAuthority" + r101.first + " , error: " + r101.second);
        Integer r102 = (Integer) r101.first;
        if (r102 != null) goto L6;
        return true;
    L6:
        if (r102.intValue() != 1) goto L11;
        return false;
    L11:
        return true;
    }

    public void update(m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.d>> r100, q<y6b.a<com.ss.android.lark.chat.base.view.vo.message.d>> r101, y6b.a<com.ss.android.lark.chat.base.view.vo.message.d> r102) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        Intrinsics.checkNotNullParameter(r102, "data");
        SystemContent r103 = (SystemContent) r102.b().f553338a;
        String r104 = r103.getFormattedContent();
        a r105 = (a) r101.c(this.f413240g, IMMessageKeys$Slots.CONTENT, SysRedPacketContentBlock$update$blockView$1.INSTANCE);
        if (TextUtils.isEmpty(r104) == false) goto L5;
        r105.f413241a.setVisibility(8);
    L6:
        Map<String, String> r106 = r103.getContents();
        if (CollectionUtils.isEmpty(r106) == false) goto L9;
        return;
    L9:
        SystemMessageType r107 = r103.getType();
        switch(c.f413244a[r107.ordinal()]) {
            case 1: goto L16;
            case 2: goto L16;
            case 3: goto L16;
            case 4: goto L16;
            case 5: goto L16;
            case 6: goto L12;
            default: goto L20;
        };
    L12:
        String r108 = r106.get("wallet");
        if (TextUtils.isEmpty(r108) == true) goto L20;
        SpannableStringBuilder r109 = f1.c(this.f412673c.getContext(), r103.getType(), r104, r108, new e(this));
    L21:
        if (r109 == null) goto L30;
        r105.f413243c.setText(r109);
        r105.f413243c.setMovementMethod(LinkMovementMethod.getInstance());
        r105.f413243c.setHighlightColor(0);
        ChatThemeInfo r110 = this.f412673c.r8();
        if (r110 == null) goto L30;
        if (r110.getComponentScene() == ChatThemeInfo.Scene.DEFAULT_SCENE) goto L28;
        r105.f413243c.setBackground(UIUtils.getDrawable(this.f412673c.getContext(), R.drawable.bg_system_msg));
        r105.f413243c.setTextColor(p.c(this.f412673c.getContext()));
        goto L30
    L28:
        TextView r111 = r105.f413243c;
        FragmentActivity r112 = this.f412673c.getContext();
        int r113 = p.f416714a;
        Intrinsics.checkNotNullParameter(r112, PerfLog.PARAM_KEY_CONTEXT_ID);
        r111.setBackgroundColor(UIUtils.getColor(r112, R.color.transparent));
        r105.f413243c.setTextColor(p.e(this.f412673c.getContext()));
    L30:
        if (this.f412673c.s8() == true) goto L33;
        r105.f413242b.setVisibility(8);
        return;
    L33:
        return;
    L16:
        String r114 = r106.get("hongbao");
        if (TextUtils.isEmpty(r114) == true) goto L20;
        r109 = f1.c(this.f412673c.getContext(), r103.getType(), r104, r114, new d(this, r106));
    L20:
        r109 = null;
        goto L21
    L5:
        r105.f413243c.setText(r104);
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(m r100, q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }
}
