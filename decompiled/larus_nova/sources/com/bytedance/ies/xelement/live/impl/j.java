package com.bytedance.ies.xelement.live.impl;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.android.livesdkapi.xlive.IXLivePlayer;
import com.bytedance.android.livesdkapi.xlive.IXLivePlayerView;
import com.bytedance.android.livesdkapi.xlive.XLivePlayerViewConfig;
import com.bytedance.ies.xelement.live.LynxLiveLight;
import com.lynx.tasm.behavior.LynxContext;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class j implements com.bytedance.ies.xelement.live.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f250157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LynxLiveLight f250158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f250159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IXLivePlayerView f250160d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LynxContext f250161e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.ies.xelement.live.a f250162f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public i f250163g;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.ies.xelement.live.impl.i, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.ies.xelement.live.c
    public final View createPlayerView() {
        IXLivePlayerView r100 = this.f250160d;
        if (r100 == null) goto L5;
        View r101 = r100.createPlayerView();
    L6:
        final IXLivePlayerView r102 = this.f250160d;
        if (r102 != null) goto L9;
    L21:
        return r101;
    L9:
        if (this.f250157a.f250149f == true) goto L11;
        i r103 = this.f250163g;
        if (r103 == null) goto L21;
        com.bytedance.ies.xelement.live.a r104 = this.f250162f;
        if (r104 == null) goto L20;
        r104.e(r102, r103);
    L20:
        this.f250163g = null;
        goto L21
    L11:
        if (this.f250163g != null) goto L21;
        ?? r105 = new i(r102, this);
        this.f250163g = r105;
        com.bytedance.ies.xelement.live.a r106 = this.f250162f;
        if (r106 == 0) goto L21;
        Intrinsics.checkNotNull(r105);
        r106.c(r102, r105);
        goto L21
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.ies.xelement.live.c
    public final boolean d() {
        if (this.f250159c == true) goto L8;
        com.bytedance.ies.xelement.live.a r100 = this.f250162f;
        if (r100 == null) goto L7;
        r100.isShared();
    L7:
        return false;
    L8:
        return true;
    }

    @Override // com.bytedance.ies.xelement.live.c
    public final void destroy() {
        IXLivePlayerView r100 = this.f250160d;
        if (r100 == null) goto L5;
        r100.destroy();
    L5:
        i r101 = this.f250163g;
        if (r101 == null) goto L13;
        IXLivePlayerView r102 = this.f250160d;
        if (r102 == null) goto L14;
        com.bytedance.ies.xelement.live.a r103 = this.f250162f;
        if (r103 == null) goto L15;
        r103.e(r102, r101);
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.ies.xelement.live.c
    public final void onAttach() {
        IXLivePlayerView r100 = this.f250160d;
        if (r100 == null) goto L6;
        r100.onAttach();
        return;
    }

    @Override // com.bytedance.ies.xelement.live.c
    public final void onDetach() {
        IXLivePlayerView r100 = this.f250160d;
        if (r100 == null) goto L6;
        r100.onDetach();
        return;
    }

    @Override // com.bytedance.ies.xelement.live.c
    public final void onPropsUpdated() {
        IXLivePlayerView r100 = this.f250160d;
        if (r100 == null) goto L6;
        r100.onPropsUpdated();
        return;
    }

    @Override // com.bytedance.ies.xelement.live.c
    public final void pause() {
        IXLivePlayerView r100 = this.f250160d;
        if (r100 == null) goto L6;
        r100.stop();
        return;
    }

    @Override // com.bytedance.ies.xelement.live.c
    public final void play() {
        IXLivePlayerView r100 = this.f250160d;
        if (r100 == null) goto L6;
        r100.play();
        return;
    }

    @Override // com.bytedance.ies.xelement.live.c
    public final View playerView() {
        IXLivePlayerView r100 = this.f250160d;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.playerView();
    }

    @Override // com.bytedance.ies.xelement.live.c
    public final void stop() {
        IXLivePlayerView r100 = this.f250160d;
        if (r100 == null) goto L6;
        r100.stop();
        return;
    }

    public j() {
        this.f250157a = new h();
    }

    @Override // com.bytedance.ies.xelement.live.c
    public final void c() {
        if (d() == false) goto L17;
        this.f250159c = false;
        IXLivePlayerView r100 = this.f250160d;
        if (r100 == null) goto L18;
        com.bytedance.ies.xelement.live.a r101 = this.f250162f;
        if (r101 == null) goto L9;
        r101.a(r100);
    L9:
        ILivePlayerClient r102 = r100.client();
        if (r102 == null) goto L12;
        IRenderView r103 = r102.getRenderView();
    L13:
        if (r103 == null) goto L19;
        r103.setVisibility(0);
        return;
    L19:
        return;
    L12:
        r103 = null;
        goto L13
    L18:
        return;
    }

    @Override // com.bytedance.ies.xelement.live.c
    public final IXLivePlayerView b() {
        return this.f250160d;
    }

    @Override // com.bytedance.ies.xelement.live.c
    public final h config() {
        return this.f250157a;
    }

    @Override // com.bytedance.ies.xelement.live.c
    public final boolean a(HashMap r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Object r101 = r100.get("room_id");
        IXLivePlayerView r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.toString();
    L6:
        Object r104 = r100.get("exit_room_shareable");
        boolean r105 = false;
        if (r104 != null) goto L9;
    L11:
        boolean r106 = false;
    L13:
        if (TextUtils.isEmpty(r103) == false) goto L15;
    L27:
        boolean r107 = false;
    L28:
        this.f250159c = r107;
        if (r107 == false) goto L31;
        r100.put("exit_biz_tag", this.f250157a.f250148e);
    L31:
        com.bytedance.ies.xelement.live.a r108 = this.f250162f;
        if (r108 == null) goto L34;
        r108.b(r100);
        boolean r109 = true;
    L35:
        IXLivePlayerView r110 = this.f250160d;
        if (r110 == null) goto L42;
        XLivePlayerViewConfig r111 = r110.config();
        if (r111 == null) goto L42;
        if (r111.getShareToOther() != true) goto L42;
        r105 = true;
    L42:
        if (r105 == true) goto L44;
    L73:
        return r109;
    L44:
        if (this.f250159c == true) goto L73;
        IXLivePlayerView r112 = this.f250160d;
        Intrinsics.checkNotNull(r112);
        i r113 = this.f250163g;
        if (r113 == null) goto L52;
        com.bytedance.ies.xelement.live.a r114 = this.f250162f;
        if (r114 == null) goto L50;
        r114.e(r112, r113);
    L50:
        this.f250163g = null;
    L52:
        if (this.f250161e == null) goto L54;
        IXLivePlayer r115 = is0.c.c().xlive();
        LynxContext r116 = this.f250161e;
        Intrinsics.checkNotNull(r116);
        r102 = r115.createLivePlayerView(r116);
    L54:
        this.f250160d = r102;
        if (r102 == null) goto L73;
        XLivePlayerViewConfig r117 = r102.config();
        r117.setRoomId(this.f250157a.f250146c);
        r117.setScene(this.f250157a.f250148e);
        r117.setBizDomain(this.f250157a.f250147d);
        r117.setStreamData(this.f250157a.f250150g);
        r117.setResolution(this.f250157a.f250153j);
        r117.setShareToOther(this.f250157a.f250149f);
        r117.setMute(this.f250157a.f250152i);
        r117.setScaleType(this.f250157a.f250151h);
        if (this.f250157a.f250152i == false) goto L61;
        ILivePlayerClient r118 = r102.client();
        if (r118 == null) goto L64;
        r118.mute();
    L64:
        h r119 = this.f250157a;
        if ((r119 instanceof h) == false) goto L67;
        r119.f250144a = r102.config();
        this.f250157a.f250145b = r102;
    L67:
        ILivePlayerClient r120 = r102.client();
        if (r120 == null) goto L70;
        r120.switchResolution(this.f250157a.f250153j);
    L70:
        LynxLiveLight r121 = this.f250158b;
        if (r121 == null) goto L73;
        r121.P(this);
        goto L73
    L61:
        ILivePlayerClient r122 = r102.client();
        if (r122 == null) goto L64;
        r122.unmute();
        goto L64
    L34:
        r109 = false;
        goto L35
    L15:
        if (TextUtils.isEmpty(this.f250157a.f250148e) == true) goto L27;
        if (r106 == false) goto L27;
        IXLivePlayerView r123 = this.f250160d;
        if (r123 == null) goto L24;
        XLivePlayerViewConfig r124 = r123.config();
        if (r124 == null) goto L24;
        if (r124.getShareToOther() != true) goto L24;
        boolean r125 = true;
    L25:
        if (r125 == false) goto L27;
        r107 = true;
    L24:
        r125 = false;
        goto L25
    L9:
        if (r104.equals(Boolean.TRUE) != true) goto L11;
        r106 = true;
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.ies.xelement.live.c
    public final void onListCellAppear(String r100) {
        Intrinsics.checkNotNullParameter(r100, "itemKey");
        IXLivePlayerView r101 = this.f250160d;
        if (r101 == null) goto L6;
        r101.onListCellAppear(r100);
        return;
    }

    @Override // com.bytedance.ies.xelement.live.c
    public final void onListCellDisAppear(String r100) {
        Intrinsics.checkNotNullParameter(r100, "itemKey");
        IXLivePlayerView r101 = this.f250160d;
        if (r101 == null) goto L6;
        r101.onListCellDisAppear(r100);
        return;
    }

    @Override // com.bytedance.ies.xelement.live.c
    public final void onListCellPrepareForReuse(String r100) {
        Intrinsics.checkNotNullParameter(r100, "itemKey");
        IXLivePlayerView r101 = this.f250160d;
        if (r101 == null) goto L6;
        r101.onListCellPrepareForReuse(r100);
        return;
    }

    @Override // com.bytedance.ies.xelement.live.c
    public final void sendCustomEvents(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "params");
        IXLivePlayerView r102 = this.f250160d;
        if (r102 == null) goto L6;
        r102.sendCustomEvents(r100, r101);
        return;
    }
}
