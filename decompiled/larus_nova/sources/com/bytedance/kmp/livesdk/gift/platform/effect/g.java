package com.bytedance.kmp.livesdk.gift.platform.effect;

import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.j3;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.j;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonAssertResManager;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.android.ugc.effectmanager.MobConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.n;
import py.k;

/* JADX INFO: loaded from: classes19.dex */
public final class g implements e, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zy0.b f252376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f252377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f252378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.kmp.livesdk.gift.platform.effect.a f252379d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f252380e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f252381f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final vy0.d f252382g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j f252383h;

    public static final class a {
    }

    public static final class b extends hd6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f252384a;

        @Override // hd6.a
        public final void a() {
            g r100 = this.f252384a;
            r100.f252378c = true;
            zy0.b r101 = r100.f252376a;
            if (r101 == null) goto L5;
            r101.dispose();
        L5:
            g r102 = this.f252384a;
            r102.f252376a = null;
            com.bytedance.kmp.livesdk.gift.platform.effect.a r103 = r102.f252379d;
            if (r103 == null) goto L9;
            r103.onStop();
            return;
        }

        @Override // hd6.a
        public final void b() {
            g r100 = this.f252384a;
            r100.f252378c = false;
            com.bytedance.kmp.livesdk.gift.platform.effect.a r101 = r100.f252379d;
            if (r101 == null) goto L6;
            r101.onStart();
            return;
        }

        public b(g r100) {
            this.f252384a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.effect.c
    public final void K() {
        this.f252378c = true;
        zy0.b r100 = this.f252376a;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        zy0.b r100 = this.f252376a;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f252376a = null;
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.effect.c
    public final boolean isIdle() {
        return this.f252378c;
    }

    public g(vy0.d r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxCardService");
        Intrinsics.checkNotNullParameter(r101, "assetService");
        this.f252382g = r100;
        this.f252383h = r101;
        this.f252377b = new LinkedHashMap();
        this.f252378c = true;
        this.f252380e = MSkiaImageRegionDecoder.FILE_PREFIX;
        this.f252381f = new b(this);
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.effect.c
    public final void E(com.bytedance.android.livesdk.gift.platform.core.model.f r110, com.bytedance.kmp.livesdk.gift.platform.effect.a r111) {
        Intrinsics.checkNotNullParameter(r111, "playCallback");
        this.f252379d = r111;
        com.bytedance.android.live.core.resources.e r100 = this.f252383h.G1(r110.f130881h);
        if (r100 != null) goto L6;
        this.f252378c = true;
        r111.onEnd();
        return;
    L6:
        this.f252379d = r111;
        Intrinsics.checkNotNullParameter(r110, "msg");
        Intrinsics.checkNotNullParameter(r100, ChameleonAssertResManager.ASSET_FOLDER);
        jy0.b.a("whd-effect-lynx", "play");
        this.f252378c = false;
        ((LinkedHashMap) this.f252377b).clear();
        String r101 = String.valueOf(r110.f130876c);
        com.bytedance.android.live.revenue.core.util.j.a r102 = com.bytedance.android.live.revenue.core.util.j.C0;
        yz0.g r103 = (yz0.g) com.bytedance.android.live.revenue.core.util.f.d(r102.a(), yz0.g.class);
        String r104 = "";
        if (r103 == null) goto L12;
        IRoomBase r105 = r103.getRoom();
        if (r105 == null) goto L12;
        String r106 = r105.getIdStr();
        if (r106 == null) goto L12;
    L13:
        LinkedHashMap r107 = new LinkedHashMap();
        r107.put(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, r101);
        String r112 = "0";
        r107.put("is_own_room", "0");
        r107.put("show_room_id", r106);
        r107.put("room_link_status", "single");
        r110.getClass();
        r107.put("asset_predownload", String.valueOf(0));
        r107.put(MusicAppletPage.KEY_MESSAGE_ID, String.valueOf(r110.f130875b));
        r107.put("is_series_send", "0");
        IBaseUser r108 = r110.f130878e;
        if (r108 == null) goto L16;
        String r109 = r108.getIdString();
    L17:
        cy0.e.f465759a.getClass();
        cy0.j r113 = cy0.e.a.f465760a;
        m.f163449e.getClass();
        Object r114 = m.b(r113).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r114);
        IBaseUser r115 = ((com.bytedance.android.livesdk.revenue.service.user.a) ((com.bytedance.live.kmp.core.c) r114)).b();
        if (r115 == null) goto L20;
        String r116 = r115.getIdString();
    L21:
        String r117 = "1";
        if (Intrinsics.areEqual(r116, r109) == false) goto L24;
        char r118 = 'n';
        Object r119 = "1";
    L25:
        r107.put("is_gift_sender", r119);
        com.bytedance.android.livesdk.revenue.service.room.c r120 = (com.bytedance.android.livesdk.revenue.service.room.c) com.bytedance.android.live.revenue.core.util.e.c(r102.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r120 == null) goto L30;
        com.bytedance.android.livesdk.revenue.room.a r121 = r120.getRoomContext();
        if (r121 == null) goto L30;
        boolean r122 = r121.getCommonIsAnchor();
    L32:
        if ((true ^ r110.f130885l.isEmpty()) == false) goto L40;
        List<String> r123 = r110.f130885l;
        if (r115 == null) goto L36;
        String r124 = com.bytedance.android.live.base.model.user.m.a(r115);
    L38:
        if (r123.contains(r124) == true) goto L41;
    L42:
        r117 = "0";
    L43:
        r107.put("is_gift_receiver", r117);
        r107.put(MobConstants.EFFECT_ID, String.valueOf(r110.f130881h));
        r107.put("gift_type", String.valueOf(r110.f130877d));
        r110.getClass();
        r107.put("gift_effect_type", String.valueOf(0));
        h1 r125 = r110.f130880g;
        if (r125 == null) goto L46;
        int r126 = r125.getType();
    L47:
        r107.put("gift_type", String.valueOf(r126));
        r107.put(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, String.valueOf(r110.f130876c));
        r107.put("asset_id", String.valueOf(r110.f130881h));
        String r127 = r110.f130894u;
        if (r127 != null) goto L50;
        r127 = "0";
    L50:
        r107.put(BindCardPayConfirmConstants.Key.TRACE_ID, r127);
        r110.getClass();
        r107.put("asset_type", String.valueOf(0));
        r110.getClass();
        r107.put("asset_predownload", String.valueOf(0));
        if (m12.b.a() == false) goto L58;
        if (r118 != 'd') goto L54;
        String r128 = "livesdk_gift_effect_show_anchor";
    L59:
        n r129 = new n();
        Map<String, String> r130 = r129.f516447a;
        Intrinsics.checkNotNullParameter(r130, "map");
        Intrinsics.checkNotNullParameter(r107, "map");
        r130.putAll(r107);
        Object r131 = m.b(r113).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r131);
        ((i) ((f80.a) r131)).w3(r128, r129.f516447a, r129.f516448b);
        this.f252377b.put("modelPath", this.f252380e + r110.f130882i);
        this.f252377b.put("primaryEffectId", String.valueOf(r100.getId()));
        this.f252377b.put("giftId", String.valueOf(r110.f130876c));
        this.f252377b.put("send_time", String.valueOf(r110.f130886m));
        Map<String, String> r132 = this.f252377b;
        IBaseUser r133 = r110.f130878e;
        if (r133 == null) goto L62;
        String r134 = com.bytedance.android.live.base.model.user.m.a(r133);
    L63:
        if (r134 != null) goto L65;
        r134 = "";
    L65:
        r132.put("sender_user_id", r134);
        Map<String, String> r135 = this.f252377b;
        h1 r136 = r110.f130880g;
        if (r136 == null) goto L68;
        Integer r137 = Integer.valueOf(r136.getDiamondCount());
    L69:
        r135.put("money", String.valueOf(r137));
        Map<String, String> r138 = this.f252377b;
        String r139 = String.valueOf(r110.f130884k);
        if (r139 == null) goto L73;
        r112 = r139;
    L73:
        r138.put("privilege_level", r112);
        j3 r140 = r110.f130883j;
        if (r140 != null) goto L76;
    L129:
        this.f252377b.put("anchorImage", "");
        r110.getClass();
        this.f252377b.put("assetList", GsonProtectorUtils.toJson(l97.a.f508113a, new LinkedHashMap()));
        String r141 = r100.getLynxSchema();
        if (r141 == null) goto L133;
        r104 = r141;
    L133:
        hd6.b r142 = new hd6.b(r104, this.f252377b, this.f252381f);
        if (r142.f484604e == false) goto L136;
        String r143 = r142.f484600a + "&enable_canvas=1";
    L137:
        x0 r144 = new x0(r143);
        x0 r145 = r144.d("url");
        Map<String, String> r146 = r142.f484601b;
        if (r146 == null) goto L143;
        Iterator<Map.Entry<String, String>> r147 = r146.entrySet().iterator();
    L141:
        if (r147.hasNext() == false) goto L143;
        Map.Entry<String, String> r148 = r147.next();
        r145.b(r148.getKey(), r148.getValue());
    L143:
        Intrinsics.checkNotNullParameter("url", "key");
        Intrinsics.checkNotNullParameter(r145, "value");
        r144.f91014a.put("url", r145);
        this.f252376a = this.f252382g.Xi(com.bytedance.live.kmp.util.c.f255167a.getContext(), new vy0.a.C8050a(), r144.c(), new LynxEffectPlayerService$createLynxComponentDelegate$1(this, r142));
        r145.toString();
        zy0.b r149 = this.f252376a;
        if (r149 == null) goto L150;
        xy0.a<?> r150 = r149.g();
        if (r150 == null) goto L151;
        r150.load();
        return;
    L151:
        return;
    L150:
        return;
    L136:
        r143 = r142.f484600a;
        goto L137
    L76:
        if (r140.getId() == null) goto L82;
        Map<String, String> r151 = this.f252377b;
        j3 r152 = r110.f130883j;
        if (r152 == null) goto L80;
        String r153 = r152.getId();
    L81:
        r151.put("sendTogether", String.valueOf(r153));
        goto L82
    L80:
        r153 = null;
    L82:
        Map<String, String> r154 = this.f252377b;
        h1 r155 = r110.f130880g;
        if (r155 == null) goto L98;
        k r156 = r155.getImage();
        if (r156 == null) goto L98;
        List<String> r157 = r156.getUrls();
        if (r157 == null) goto L98;
        if (r157.size() <= 0) goto L91;
        boolean r158 = true;
    L92:
        if (r158 == true) goto L95;
        r157 = null;
    L95:
        if (r157 == null) goto L98;
        String r159 = (String) ListProtector.get(r157, 0);
        if (r159 == null) goto L98;
    L99:
        r154.put("gift_icon", r159);
        Map<String, String> r160 = this.f252377b;
        h1 r161 = r110.f130880g;
        if (r161 == null) goto L104;
        String r162 = r161.getName();
        if (r162 == null) goto L104;
    L105:
        r160.put("gift_name", r162);
        Map<String, String> r163 = this.f252377b;
        IBaseUser r164 = r110.f130878e;
        if (r164 == null) goto L121;
        k r165 = r164.getAvatarThumbKt();
        if (r165 == null) goto L121;
        List<String> r166 = r165.getUrls();
        if (r166 == null) goto L121;
        if (r166.size() <= 0) goto L114;
        boolean r167 = true;
    L115:
        if (r167 == true) goto L118;
        r166 = null;
    L118:
        if (r166 == null) goto L121;
        String r168 = (String) ListProtector.get(r166, 0);
        if (r168 == null) goto L121;
    L122:
        r163.put("sender_avatar", r168);
        Map<String, String> r169 = this.f252377b;
        IBaseUser r170 = r110.f130878e;
        if (r170 == null) goto L127;
        String r171 = r170.getNickName();
        if (r171 == null) goto L127;
    L128:
        r169.put("sender_name", r171);
    L127:
        r171 = "";
        goto L128
    L114:
        r167 = false;
    L121:
        r168 = "";
    L104:
        r162 = "";
        goto L105
    L91:
        r158 = false;
    L98:
        r159 = "";
        goto L99
    L68:
        r137 = null;
        goto L69
    L62:
        r134 = null;
        goto L63
    L54:
        if (r118 != 'n') goto L58;
        r128 = "livesdk_gift_effect_show_sender";
    L58:
        r128 = "livesdk_gift_effect_show";
        goto L59
    L46:
        r126 = 0;
    L41:
        r118 = Directory.UNIX_ID;
        goto L43
    L36:
        r124 = "";
        goto L38
    L40:
        if (r122 == false) goto L42;
    L30:
        r122 = false;
        goto L32
    L24:
        r118 = Permission.EXECUTE;
        r119 = "0";
        goto L25
    L20:
        r116 = null;
        goto L21
    L16:
        r109 = null;
    L12:
        r106 = "";
        goto L13
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.effect.e
    public final void sendJsEvent(String r100, Object r101) {
        Intrinsics.checkNotNullParameter("H5_webcastNotification", "eventName");
        Intrinsics.checkNotNullParameter(r101, "data");
        jy0.b.a("whd-effect-lynx", "sendJsEvent");
        zy0.b r102 = this.f252376a;
        if (r102 == null) goto L8;
        xy0.a<?> r103 = r102.g();
        if (r103 == null) goto L9;
        r103.sendJsEvent("H5_webcastNotification", r101);
        return;
    L9:
        return;
    }
}
