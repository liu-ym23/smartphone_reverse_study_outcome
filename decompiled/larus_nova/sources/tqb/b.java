package tqb;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.m;
import com.lynx.tasm.q1;
import com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeProtocol;
import com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeRuntimeFactory;
import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.lynxkit.container.LarkLynxContainerBuilder;
import com.ss.android.lark.lynxkit.host.LarkLynxHostOptions;
import com.ss.android.lark.lynxkit.host.LarkLynxHostParams;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f547241a = 0;

    public static final class a extends q1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q1 f547242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e f547243b;

        @Override // com.lynx.tasm.q1
        public final void onLoadSuccess() {
            e r100 = this.f547243b;
            if (r100 == null) goto L5;
            r100.a();
        L5:
            q1 r101 = this.f547242a;
            if (r101 == null) goto L8;
            r101.onLoadSuccess();
            return;
        L8:
            super.onLoadSuccess();
        }

        @Override // com.lynx.tasm.q1
        public final void onPageStart(String r100) {
            e r101 = this.f547243b;
            if (r101 == null) goto L5;
            r101.onLoadStart();
        L5:
            q1 r102 = this.f547242a;
            if (r102 == null) goto L8;
            r102.onPageStart(r100);
            return;
        L8:
            super.onPageStart(r100);
        }

        @Override // com.lynx.tasm.q1, com.lynx.tasm.p
        public final void onReceivedError(LynxError r100) {
            e r101 = this.f547243b;
            if (r101 == null) goto L5;
            r101.a();
        L5:
            q1 r102 = this.f547242a;
            if (r102 == null) goto L8;
            r102.onReceivedError(r100);
            return;
        L8:
            super.onReceivedError(r100);
        }

        public a(q1 r100, e r101) {
            this.f547242a = r100;
            this.f547243b = r101;
        }
    }

    static {
    }

    public static boolean b(LarkLynxHostParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        if (TextUtils.isEmpty(r100.getTemplateUrl()) == true) goto L5;
    L8:
        return true;
    L5:
        if (TextUtils.isEmpty(r100.getTemplatePath()) == false) goto L8;
        return false;
    }

    public static void c(ILarkLynxContainer r100, LarkLynxHostParams r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "params");
        String r102 = "";
        if (TextUtils.isEmpty(r101.getTemplateUrl()) == true) goto L13;
        String r103 = r101.getTemplateUrl();
        if (r103 == null) goto L8;
        r102 = r103;
    L8:
        Map<String, Object> r104 = r101.getInitDataMap();
        if (r104 == null) goto L11;
        r100.render(r102, r104, r101.getLynxViewShareData());
        return;
    L11:
        r100.render(r102, r101.getInitDataJson(), r101.getLynxViewShareData());
        return;
    L13:
        if (TextUtils.isEmpty(r101.getTemplatePath()) == true) goto L22;
        String r105 = r101.getTemplatePath();
        if (r105 == null) goto L18;
        r102 = r105;
    L18:
        Map<String, Object> r106 = r101.getInitDataMap();
        if (r106 == null) goto L21;
        r100.renderByTemplateLoader(r102, r106, r101.getLynxViewShareData());
        return;
    L21:
        r100.renderByTemplateLoader(r102, r101.getInitDataJson(), r101.getLynxViewShareData());
        return;
    L22:
        r100.render();
    }

    public static ILarkLynxContainer a(Context r100, LarkLynxHostParams r101, LarkLynxHostOptions r102, e r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "options");
        LarkLynxContainerBuilder r104 = new LarkLynxContainerBuilder(r100).enableAsyncRender(r101.getEnableAsyncRender()).enableAsyncRenderForList(r101.getEnableAsyncRenderForList()).enableDevToolsDebug(r101.getEnableDevToolsDebug()).setEnableUserCodeCache(r101.getEnableUserCodeCache());
        ILynxContainerContext r105 = r101.getContainerContext();
        if (r105 == null) goto L5;
        r104.containerContext(r105);
    L5:
        String r106 = r101.getTagForJsContext();
        boolean r107 = false;
        LynxView r108 = null;
        if (r106 != null) goto L8;
    L16:
        String r109 = r101.getTagForCustomComponent();
        if (r109 != null) goto L19;
    L27:
        String r110 = r101.getTagForGlobalData();
        if (r110 != null) goto L30;
    L38:
        String r111 = r101.getTagForBridgeMethodDispatcher();
        if (r111 != null) goto L41;
    L49:
        String r112 = r101.getTagForBridgeMethodGroup();
        if (r112 != null) goto L52;
    L60:
        String r113 = r101.getTagForBridgeProtocol();
        if (r113 != null) goto L63;
    L71:
        ILarkLynxBridgeRuntimeFactory r114 = r101.getBridgeRuntimeFactory();
        if (r114 == null) goto L74;
        r104.bridgeRuntimeFactory(r114);
    L74:
        ILarkLynxBridgeProtocol r115 = r101.getBridgeProtocol();
        if (r115 == null) goto L77;
        r104.bridgeProtocol(r115);
    L77:
        String r116 = r101.getBridgeProtocolContainerId();
        if (r116 != null) goto L80;
    L88:
        String r117 = r101.getTagForJSModule();
        if (r117 != null) goto L91;
    L99:
        String r118 = r101.getTagForTemplateLoader();
        if (r118 != null) goto L102;
    L110:
        String r119 = r101.getDevToolSocketUrl();
        if (r119 != null) goto L113;
    L121:
        String r120 = r101.getCodeCacheSourceUrl();
        if (r120 != null) goto L124;
    L132:
        String r121 = r101.getTemplateUrl();
        if (r121 != null) goto L135;
    L143:
        String r122 = r101.getTemplatePath();
        if (r122 != null) goto L146;
    L153:
        Map<String, ? extends Object> r123 = r101.getInitDataMap();
        if (r123 != null) goto L156;
    L157:
        String r124 = r101.getInitDataJson();
        if (r124 == null) goto L160;
        r104.initData(r124);
    L160:
        Integer r125 = r101.getWidthMeasureSpec();
        if (r125 == null) goto L163;
        r104.widthMeasureSpec(r125.intValue());
    L163:
        Integer r126 = r101.getHeightMeasureSpec();
        if (r126 == null) goto L166;
        r104.heightMeasureSpec(r126.intValue());
    L166:
        Float r127 = r101.getFontScale();
        if (r127 == null) goto L169;
        r104.fontScale(r127.floatValue());
    L169:
        Map<String, Object> r128 = r101.getLynxViewShareData();
        if (r128 == null) goto L175;
        Iterator<Map.Entry<String, Object>> r129 = r128.entrySet().iterator();
    L173:
        if (r129.hasNext() == false) goto L175;
        Map.Entry<String, Object> r130 = r129.next();
        r104.lynxContextShareData(r130.getKey(), r130.getValue());
    L175:
        m r131 = r102.getImageInterceptor();
        if (r131 == null) goto L178;
        r104.imageLoader(r131);
    L178:
        sqb.a r132 = r102.getTemplateLoadListener();
        if (r132 == null) goto L181;
        r104.templateLoadListener(r132);
    L181:
        ILarkLynxContainer r133 = r104.build();
        if (r102.getLynxViewClient() != null) goto L184;
        if (r103 != null) goto L184;
    L189:
        return r133;
    L184:
        View r134 = r133.getLynxView();
        if ((r134 instanceof LynxView) == false) goto L187;
        r108 = (LynxView) r134;
    L187:
        if (r108 == null) goto L189;
        r108.addLynxViewClient(new a(r102.getLynxViewClient(), r103));
        goto L189
    L156:
        if (r104.initData(r123) != null) goto L160;
    L146:
        if (r122.length() <= 0) goto L148;
        r107 = true;
    L148:
        if (r107 == true) goto L151;
        r122 = null;
    L151:
        if (r122 == null) goto L153;
        r104.templatePathForTemplateLoader(r122);
        goto L153
    L135:
        if (r121.length() <= 0) goto L137;
        boolean r135 = true;
    L138:
        if (r135 == true) goto L141;
        r121 = null;
    L141:
        if (r121 == null) goto L143;
        r104.templateUrl(r121);
        goto L143
    L137:
        r135 = false;
        goto L138
    L124:
        if (r120.length() <= 0) goto L126;
        boolean r136 = true;
    L127:
        if (r136 == true) goto L130;
        r120 = null;
    L130:
        if (r120 == null) goto L132;
        r104.setCodeCacheSourceUrl(r120);
        goto L132
    L126:
        r136 = false;
        goto L127
    L113:
        if (r119.length() <= 0) goto L115;
        boolean r137 = true;
    L116:
        if (r137 == true) goto L119;
        r119 = null;
    L119:
        if (r119 == null) goto L121;
        r104.devToolSocketUrl(r119);
        goto L121
    L115:
        r137 = false;
        goto L116
    L102:
        if (r118.length() <= 0) goto L104;
        boolean r138 = true;
    L105:
        if (r138 == true) goto L108;
        r118 = null;
    L108:
        if (r118 == null) goto L110;
        r104.tagForTemplateLoader(r118);
        goto L110
    L104:
        r138 = false;
        goto L105
    L91:
        if (r117.length() <= 0) goto L93;
        boolean r139 = true;
    L94:
        if (r139 == true) goto L97;
        r117 = null;
    L97:
        if (r117 == null) goto L99;
        r104.tagForJSModule(r117);
        goto L99
    L93:
        r139 = false;
        goto L94
    L80:
        if (r116.length() <= 0) goto L82;
        boolean r140 = true;
    L83:
        if (r140 == true) goto L86;
        r116 = null;
    L86:
        if (r116 == null) goto L88;
        r104.bridgeProtocolContainerId(r116);
        goto L88
    L82:
        r140 = false;
        goto L83
    L63:
        if (r113.length() <= 0) goto L65;
        boolean r141 = true;
    L66:
        if (r141 == true) goto L69;
        r113 = null;
    L69:
        if (r113 == null) goto L71;
        r104.tagForBridgeProtocol(r113);
        goto L71
    L65:
        r141 = false;
        goto L66
    L52:
        if (r112.length() <= 0) goto L54;
        boolean r142 = true;
    L55:
        if (r142 == true) goto L58;
        r112 = null;
    L58:
        if (r112 == null) goto L60;
        r104.tagForBridgeMethodGroup(r112);
        goto L60
    L54:
        r142 = false;
        goto L55
    L41:
        if (r111.length() <= 0) goto L43;
        boolean r143 = true;
    L44:
        if (r143 == true) goto L47;
        r111 = null;
    L47:
        if (r111 == null) goto L49;
        r104.tagForBridgeMethodDispatcher(r111);
        goto L49
    L43:
        r143 = false;
        goto L44
    L30:
        if (r110.length() <= 0) goto L32;
        boolean r144 = true;
    L33:
        if (r144 == true) goto L36;
        r110 = null;
    L36:
        if (r110 == null) goto L38;
        r104.tagForGlobalData(r110);
        goto L38
    L32:
        r144 = false;
        goto L33
    L19:
        if (r109.length() <= 0) goto L21;
        boolean r145 = true;
    L22:
        if (r145 == true) goto L25;
        r109 = null;
    L25:
        if (r109 == null) goto L27;
        r104.tagForCustomComponent(r109);
        goto L27
    L21:
        r145 = false;
        goto L22
    L8:
        if (r106.length() <= 0) goto L10;
        boolean r146 = true;
    L11:
        if (r146 == true) goto L14;
        r106 = null;
    L14:
        if (r106 == null) goto L16;
        r104.tagForJsContext(r106);
        goto L16
    L10:
        r146 = false;
        goto L11
    }
}
