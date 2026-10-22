package com.larus.music.applet.qqmusic.impl;

import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.account.base.api.IDouyinHeartBeatService;
import com.larus.music.MusicAuthManager;
import com.larus.music.applet.qqmusic.api.AbsOpenMusicAuthModalMethodIDL;
import com.larus.music.c0;
import com.larus.music.i;
import com.larus.platform.api.i5;
import com.larus.platform.api.j5;
import com.larus.platform.api.p4;
import com.larus.settings.value.e10;
import com.larus.settings.value.ul;
import com.larus.utils.l0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import d3.a0;
import e3.d;
import f3.h;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ol9.l;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/music/applet/qqmusic/impl/OpenMusicAuthModalMethod;", "Lcom/larus/music/applet/qqmusic/api/AbsOpenMusicAuthModalMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/larus/music/applet/qqmusic/api/AbsOpenMusicAuthModalMethodIDL$OpenMusicAuthModalParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/larus/music/applet/qqmusic/api/AbsOpenMusicAuthModalMethodIDL$OpenMusicAuthModalResultModel;", "Companion", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenMusicAuthModalMethod extends AbsOpenMusicAuthModalMethodIDL {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f359464a = 0;

    public static final class a {
    }

    static {
    }

    public OpenMusicAuthModalMethod() {
    }

    /* JADX WARN: Type inference failed for: r2v32, types: [ol9.l] */
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r310, ParamModel r311, final h r312) {
        final AbsOpenMusicAuthModalMethodIDL.a r100 = (AbsOpenMusicAuthModalMethodIDL.a) r311;
        Intrinsics.checkNotNullParameter(r310, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r312, "callback");
        AppletAppManagerService r101 = AppletAppManagerService.INSTANCE;
        a0 r102 = r310.getContainerContext();
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.getAppletId();
    L7:
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        r101.getClass();
        if (AppletAppManagerService.a(r104) == null) goto L12;
        boolean r110 = true;
    L13:
        String r105 = r100.getId();
        if (r105 != null) goto L16;
        String r106 = "";
    L17:
        String r107 = r100.getSubTitle();
        if (r107 != null) goto L20;
        String r108 = "";
    L21:
        String r109 = r100.getTitle();
        if (r109 != null) goto L24;
        String r111 = "";
    L25:
        ArrayList<String> r112 = r100.getAuthTarget();
        String r113 = r100.getBottomAuthText();
        String r210 = r100.getMsgId();
        AbsOpenMusicAuthModalMethodIDL.TraceInfo r114 = r100.getTraceInfo();
        if (r114 == null) goto L28;
        String r211 = r114.getBotId();
    L29:
        AbsOpenMusicAuthModalMethodIDL.TraceInfo r115 = r100.getTraceInfo();
        if (r115 == null) goto L32;
        String r116 = r115.getScene();
    L33:
        AbsOpenMusicAuthModalMethodIDL.TraceInfo r117 = r100.getTraceInfo();
        if (r117 == null) goto L36;
        String r118 = r117.getSecEnterMethod();
    L37:
        AbsOpenMusicAuthModalMethodIDL.TraceInfo r119 = r100.getTraceInfo();
        if (r119 == null) goto L40;
        String r212 = r119.getEnterMethod();
    L41:
        AbsOpenMusicAuthModalMethodIDL.TraceInfo r120 = r100.getTraceInfo();
        if (r120 == null) goto L44;
        String r213 = r120.getAction();
    L45:
        AbsOpenMusicAuthModalMethodIDL.TraceInfo r121 = r100.getTraceInfo();
        if (r121 == null) goto L48;
        String r214 = r121.getAppName();
    L49:
        AbsOpenMusicAuthModalMethodIDL.TraceInfo r122 = r100.getTraceInfo();
        if (r122 == null) goto L52;
        String r215 = r122.getAppType();
    L53:
        AbsOpenMusicAuthModalMethodIDL.TraceInfo r123 = r100.getTraceInfo();
        if (r123 == null) goto L56;
        String r216 = r123.getUniqueKey();
    L57:
        AbsOpenMusicAuthModalMethodIDL.TraceInfo r124 = r100.getTraceInfo();
        if (r124 == null) goto L60;
        String r217 = r124.getWidgetId();
    L61:
        AbsOpenMusicAuthModalMethodIDL.TraceInfo r125 = r100.getTraceInfo();
        if (r125 == null) goto L64;
        String r218 = r125.getAppKey();
    L65:
        AbsOpenMusicAuthModalMethodIDL.TraceInfo r126 = r100.getTraceInfo();
        if (r126 == null) goto L68;
        String r313 = r126.getCurrentPage();
    L69:
        AbsOpenMusicAuthModalMethodIDL.TraceInfo r127 = r100.getTraceInfo();
        if (r127 == null) goto L72;
        String r314 = r127.getBindScene();
    L73:
        AbsOpenMusicAuthModalMethodIDL.TraceInfo r128 = r100.getTraceInfo();
        if (r128 == null) goto L76;
        String r315 = r128.getBindSource();
    L77:
        AbsOpenMusicAuthModalMethodIDL.TraceInfo r129 = r100.getTraceInfo();
        if (r129 == null) goto L80;
        String r316 = r129.getBindType();
    L81:
        p4 r130 = new p4(r116, r118, r212, r213, r211, r210, null, r214, r215, r216, r217, r218, r313, r314, r315, r316, 144);
        nl9.a r131 = r100.getAuthParams();
        if (r131 == null) goto L84;
        String r132 = r131.a();
    L85:
        if (r132 != null) goto L87;
        String r133 = "";
    L88:
        nl9.a r134 = r100.getAuthParams();
        if (r134 == null) goto L91;
        String r135 = r134.c();
    L92:
        if (r135 != null) goto L94;
        String r136 = "";
    L95:
        nl9.a r137 = r100.getAuthParams();
        if (r137 == null) goto L98;
        String r138 = r137.d();
    L99:
        if (r138 != null) goto L101;
        String r139 = "";
    L102:
        i5 r219 = new i5(r106, r108, r111, r113, r130, r112, r133, r136, r139, r110, new l(r312, r100));
        AbsOpenMusicAuthModalMethodIDL.TraceInfo r140 = r100.getTraceInfo();
        if (r140 == null) goto L105;
        String r141 = r140.getBotId();
    L106:
        if (r141 != null) goto L108;
        String r142 = "";
    L109:
        boolean r220 = Intrinsics.areEqual(r100.getSource(), "query");
        String r221 = r100.getMsgId();
        nl9.a r143 = r100.getAuthParams();
        if (r143 == null) goto L112;
        r103 = r143.b();
    L112:
        if (r103 != null) goto L114;
        String r222 = "";
    L115:
        j5 r144 = new j5(r142, true, r220, r221, r222, null, null, r219, null, 352);
        i r145 = i.f359475a;
        Intrinsics.checkNotNullParameter(r144, "startMusicAuthParams");
        e10 r146 = e10.f368561a;
        int r147 = l0.f375430a;
        if (((Boolean) l0.a(Boolean.FALSE, new ul())).booleanValue() == false) goto L120;
        MusicAuthManager r148 = MusicAuthManager.f359456a;
        Intrinsics.checkNotNullParameter(r144, "startMusicAuthParams");
        IDouyinHeartBeatService r149 = (IDouyinHeartBeatService) ServiceManager.get().getService(IDouyinHeartBeatService.class);
        if (r149 == null) goto L122;
        IDouyinHeartBeatService.a.a(r149, 0, true, null, new c0(r144), 5);
        return;
    L122:
        return;
    L120:
        MusicAuthManager.f359456a.d(r144);
        return;
    L114:
        r222 = r103;
        goto L115
    L108:
        r142 = r141;
        goto L109
    L105:
        r141 = null;
        goto L106
    L101:
        r139 = r138;
        goto L102
    L98:
        r138 = null;
        goto L99
    L94:
        r136 = r135;
        goto L95
    L91:
        r135 = null;
        goto L92
    L87:
        r133 = r132;
        goto L88
    L84:
        r132 = null;
        goto L85
    L80:
        r316 = null;
        goto L81
    L76:
        r315 = null;
        goto L77
    L72:
        r314 = null;
        goto L73
    L68:
        r313 = null;
        goto L69
    L64:
        r218 = null;
        goto L65
    L60:
        r217 = null;
        goto L61
    L56:
        r216 = null;
        goto L57
    L52:
        r215 = null;
        goto L53
    L48:
        r214 = null;
        goto L49
    L44:
        r213 = null;
        goto L45
    L40:
        r212 = null;
        goto L41
    L36:
        r118 = null;
        goto L37
    L32:
        r116 = null;
        goto L33
    L28:
        r211 = null;
        goto L29
    L24:
        r111 = r109;
        goto L25
    L20:
        r108 = r107;
        goto L21
    L16:
        r106 = r105;
        goto L17
    L12:
        r110 = false;
        goto L13
    L5:
        r104 = null;
        goto L7
    }
}
