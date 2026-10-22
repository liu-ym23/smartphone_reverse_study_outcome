package com.bytedance.ies.xelement.live;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bytedance.android.livesdkapi.xlive.IXLivePlayerView;
import com.bytedance.android.livesdkapi.xlive.XLivePlayerViewConfig;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@LynxBehavior(isCreateAsync = false, tagName = {"x-live-ng"})
@LynxGeneratorName(packageName = "com.bytedance.ies.xelement.live")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0007J\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0007J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0007J\u0019\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0017¢\u0006\u0004\b\u0012\u0010\fJ\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0007J\u001c\u0010\u0019\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0017J\u001c\u0010\u001a\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0017J\u001c\u0010\u001b\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0017J\u001c\u0010\u001c\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0017J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\tH\u0007J\u0012\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u0007J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0015H\u0007J\u001c\u0010\"\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0017J\u0019\u0010#\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b#\u0010\f¨\u0006%"}, d2 = {"Lcom/bytedance/ies/xelement/live/LynxLiveLight;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/view/View;", "", "roomId", "", "setRoomId", "page", "setPage", "", "shareToOther", "setShareToOther", "(Ljava/lang/Boolean;)V", "streamData", "setStreamData", "qualities", "setQualities", ITTVideoEngineEventSource.KEY_MUTE, "setVolume", "objectfit", "setObjectfit", "Lcom/lynx/react/bridge/ReadableMap;", "params", "Lcom/lynx/react/bridge/Callback;", "callback", "play", "enterLiveRoom", "requireOwnership", "stop", "opt", "setInList", "value", "setBizDomain", "setLogExtra", "pause", "setCustomPlayer", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "x-element-live_release"}, k = 1, mv = {1, 6, 0})
public class LynxLiveLight extends LynxUI<View> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f250107h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.ies.xelement.live.a f250108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f250109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f250110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f250111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f250112e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f250113f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f250114g;

    public static final class a {
    }

    static {
    }

    public LynxLiveLight() {
        throw null;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        N(null);
        c r100 = this.f250113f;
        if (r100 == null) goto L6;
        r100.destroy();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onAttach() {
        super.onAttach();
        c r100 = this.f250113f;
        if (r100 == null) goto L6;
        r100.onAttach();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onDetach() {
        super.onDetach();
        N(null);
        c r100 = this.f250113f;
        if (r100 == null) goto L6;
        r100.onDetach();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReady() {
        super.onNodeReady();
        if (this.f250112e == false) goto L6;
        this.f250112e = false;
        O("error", MapsKt.mapOf(TuplesKt.to("msg", "unable to create live player")));
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeRemoved() {
        super.onNodeRemoved();
        c r100 = this.f250113f;
        if (r100 == null) goto L6;
        r100.pause();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onPropsUpdated() {
        super.onPropsUpdated();
        c r100 = this.f250113f;
        if (r100 == null) goto L6;
        r100.onPropsUpdated();
        return;
    }

    public final boolean M(Callback r100) {
        c r101 = this.f250113f;
        if (r101 == null) goto L10;
        Intrinsics.checkNotNull(r101);
        if (r101.d() == false) goto L10;
        if (r100 == null) goto L9;
        r100.invoke(new Object[]{4, "The live player is shared to the live room, do not execute it"});
    L9:
        return true;
    L10:
        return false;
    }

    public final void N(Callback r100) {
        c r101 = this.f250113f;
        if (r101 == null) goto L9;
        r101.stop();
        Unit r102 = Unit.INSTANCE;
        if (r100 == null) goto L7;
        r100.invoke(new Object[]{0});
        Unit r103 = Unit.INSTANCE;
    L8:
        if (r103 == null) goto L9;
        return;
    L7:
        r103 = null;
    L9:
        if (r100 == null) goto L13;
        r100.invoke(new Object[]{3});
        Unit r104 = Unit.INSTANCE;
        return;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.ies.xelement.live.d] */
    public final void P(final c r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        View r101 = r100.playerView();
        if (r101 != null) goto L5;
    L9:
        boolean r102 = this.f250110c;
        if (r102 == true) goto L12;
        if (r102 == true) goto L20;
        return;
    L20:
        if (this.f250114g == null) goto L35;
        c r103 = this.f250113f;
        if (r103 == null) goto L28;
        View r104 = r103.playerView();
        if (r104 == null) goto L28;
        ViewTreeObserver r105 = r104.getViewTreeObserver();
        if (r105 == null) goto L28;
        r105.removeOnGlobalLayoutListener(this.f250114g);
    L28:
        this.f250114g = null;
        return;
    L35:
        return;
    L12:
        if (this.f250114g != null) goto L30;
        this.f250114g = new d(this, r100);
        View r106 = r100.playerView();
        if (r106 == null) goto L31;
        ViewTreeObserver r107 = r106.getViewTreeObserver();
        if (r107 == null) goto L32;
        r107.addOnGlobalLayoutListener(this.f250114g);
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L5:
        if (Intrinsics.areEqual(r101.getParent(), this.f250111d) == true) goto L9;
        ViewGroup r108 = this.f250111d;
        if (r108 == null) goto L9;
        r108.addView(r101, new ViewGroup.LayoutParams(-1, -1));
        goto L9
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        FrameLayout r101 = new FrameLayout(r100);
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return r101;
    }

    @LynxProp(name = "biz-domain")
    public final void setBizDomain(String r100) {
        c r101 = this.f250113f;
        if (r101 == null) goto L5;
        com.bytedance.ies.xelement.live.impl.h r102 = r101.config();
    L6:
        if (r102 == null) goto L12;
        if (r100 != null) goto L10;
        r100 = "x-live-ng";
    L10:
        r102.a(r100);
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @LynxProp(name = "custom-player")
    public final void setCustomPlayer(Boolean r100) {
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L8;
        com.bytedance.ies.xelement.live.a r101 = this.f250108a;
        if (r101 == null) goto L9;
        r101.d();
        return;
    L9:
        return;
    }

    @LynxProp(name = "in-list")
    public final void setInList(boolean r100) {
        this.f250110c = r100;
    }

    @LynxProp(name = "log-extra")
    public final void setLogExtra(ReadableMap r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        c r101 = this.f250113f;
        if (r101 == null) goto L5;
        com.bytedance.ies.xelement.live.impl.h r102 = r101.config();
    L6:
        if (r102 == null) goto L10;
        r100.asHashMap();
        r102.getClass();
        return;
    L10:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @LynxProp(name = "objectfit")
    public final void setObjectfit(String r100) {
        if (r100 == null) goto L19;
        int r101 = r100.hashCode();
        if (r101 == 3143043) goto L16;
        if (r101 == 94852023) goto L12;
        if (r101 != 951526612) goto L19;
        r100.equals(LynxVideoManagerLite.CONTAIN);
        goto L19
    L12:
        if (r100.equals("cover") == false) goto L19;
        int r102 = 2;
    L20:
        c r103 = this.f250113f;
        if (r103 == null) goto L23;
        com.bytedance.ies.xelement.live.impl.h r104 = r103.config();
    L24:
        if (r104 == null) goto L28;
        r104.f(r102);
        return;
    L28:
        return;
    L23:
        r104 = null;
        goto L24
    L16:
        if (r100.equals(LynxVideoManagerLite.FILL) == false) goto L19;
        r102 = 1;
    L19:
        r102 = 0;
        goto L20
    }

    @LynxProp(name = "scene")
    public final void setPage(String r100) {
        c r101 = this.f250113f;
        if (r101 == null) goto L5;
        com.bytedance.ies.xelement.live.impl.h r102 = r101.config();
    L6:
        if (r102 == null) goto L12;
        if (r100 != null) goto L10;
        r100 = "x-live-ng";
    L10:
        r102.g(r100);
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @LynxProp(name = "qualities")
    public final void setQualities(String r100) {
        c r101 = this.f250113f;
        if (r101 == null) goto L5;
        com.bytedance.ies.xelement.live.impl.h r102 = r101.config();
    L6:
        if (r102 == null) goto L12;
        if (r100 != null) goto L10;
        r100 = "";
    L10:
        r102.d(r100);
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @LynxProp(name = "room-id")
    public final void setRoomId(String r100) {
        c r101 = this.f250113f;
        if (r101 == null) goto L5;
        com.bytedance.ies.xelement.live.impl.h r102 = r101.config();
    L6:
        if (r102 == null) goto L12;
        if (r100 != null) goto L10;
        r100 = "233";
    L10:
        r102.e(r100);
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @LynxProp(name = "android-share")
    public final void setShareToOther(Boolean r100) {
        c r101 = this.f250113f;
        if (r101 == null) goto L5;
        com.bytedance.ies.xelement.live.impl.h r102 = r101.config();
    L6:
        if (r102 == null) goto L13;
        if (r100 == null) goto L10;
        boolean r103 = r100.booleanValue();
    L11:
        r102.h(r103);
        return;
    L10:
        r103 = false;
        goto L11
    L13:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @LynxProp(name = "stream-data")
    public final void setStreamData(String r100) {
        c r101 = this.f250113f;
        if (r101 == null) goto L5;
        com.bytedance.ies.xelement.live.impl.h r102 = r101.config();
    L6:
        if (r102 == null) goto L12;
        if (r100 != null) goto L10;
        r100 = "";
    L10:
        r102.i(r100);
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @LynxProp(name = ITTVideoEngineEventSource.KEY_MUTE)
    public void setVolume(Boolean r100) {
        c r101 = this.f250113f;
        if (r101 == null) goto L5;
        com.bytedance.ies.xelement.live.impl.h r102 = r101.config();
    L6:
        if (r102 == null) goto L13;
        if (r100 == null) goto L10;
        boolean r103 = r100.booleanValue();
    L11:
        r102.c(r103);
        return;
    L10:
        r103 = true;
        goto L11
    L13:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public LynxLiveLight(LynxContext r100, Object r101) {
        super(r100, r101);
        this.f250111d = (ViewGroup) getView();
        this.f250113f = new com.bytedance.ies.xelement.live.impl.j();
        XLivePlayerViewConfig r102 = null;
        if (r100 != null) goto L17;
    L7:
        IXLivePlayerView r103 = null;
    L8:
        c r104 = this.f250113f;
        if (r104 == null) goto L16;
        com.bytedance.ies.xelement.live.impl.j r105 = (com.bytedance.ies.xelement.live.impl.j) r104;
        r105.f250161e = r100;
        r105.f250162f = this.f250108a;
        r105.f250160d = r103;
        com.bytedance.ies.xelement.live.impl.h r106 = r105.f250157a;
        if (r103 == null) goto L13;
        r102 = r103.config();
    L13:
        r106.f250144a = r102;
        r106.f250145b = r103;
        r105.f250157a.c(true);
        r105.f250157a.f(0);
        r105.f250157a.e("233");
        r105.f250157a.g("x-live-ng");
        r105.f250157a.a("x-live-ng");
        Intrinsics.checkNotNullParameter(this, "ui");
        r105.f250158b = this;
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.xelement.live.impl.LynxLiveLightPlayerDefaultImpl");
    L17:
        r103 = is0.c.c().xlive().createLivePlayerView(r100.getContext());     // Catch: NoClassDefFoundError -> L6
    L6:
        LLog.e("x-live-ng", "unable to create live player");
        this.f250112e = true;
        goto L7
    }

    public final void O(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        int r102 = getSign();
        if (r101 != null) goto L5;
        Map<String, ? extends Object> r103 = new LinkedHashMap();
    L6:
        m7a.a r104 = new m7a.a(r102, r100, r103);
        LynxContext r105 = getLynxContext();
        if (r105 == null) goto L11;
        EventEmitter r106 = r105.getEventEmitter();
        if (r106 == null) goto L11;
        r106.sendCustomEvent(r104);
    L11:
        c r107 = this.f250113f;
        if (r107 == null) goto L17;
        if (r101 != null) goto L15;
        r101 = new HashMap();
    L15:
        r107.sendCustomEvents(r100, r101);
        return;
    L17:
        return;
    L5:
        r103 = r101;
        goto L6
    }

    @LynxUIMethod
    public void enterLiveRoom(ReadableMap r100, Callback r101) {
        if (M(r101) == false) goto L5;
        return;
    L5:
        c r102 = this.f250113f;
        if (r102 == null) goto L18;
        if (r100 == null) goto L9;
        HashMap<String, Object> r103 = r100.asHashMap();
    L10:
        if (r103 != null) goto L12;
        r103 = new HashMap();
    L12:
        c r104 = this.f250113f;
        if (r104 == null) goto L16;
        r104.playerView();
    L16:
        if (r102.a(r103) != true) goto L18;
        boolean r105 = true;
    L19:
        if (r105 == false) goto L22;
        if (r101 == null) goto L25;
        r101.invoke(new Object[]{0});
        return;
    L25:
        return;
    L22:
        if (r101 == null) goto L27;
        r101.invoke(new Object[]{1, "please implement ILynxLiveLight.xLiveEnterRoom in your App"});
        return;
    L27:
        return;
    L9:
        r103 = null;
    L18:
        r105 = false;
        goto L19
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onListCellAppear(String r100, LynxBaseUI r101) {
        Intrinsics.checkNotNullParameter(r101, "list");
        super.onListCellAppear(r100, r101);
        this.f250109b = false;
        c r102 = this.f250113f;
        if (r102 == null) goto L8;
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        r102.onListCellAppear(r100);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onListCellPrepareForReuse(String r100, LynxBaseUI r101) {
        Intrinsics.checkNotNullParameter(r101, "list");
        super.onListCellPrepareForReuse(r100, r101);
        this.f250109b = false;
        c r102 = this.f250113f;
        if (r102 == null) goto L8;
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        r102.onListCellPrepareForReuse(r100);
        return;
    }

    @LynxUIMethod
    public void pause(ReadableMap r100, Callback r101) {
        if (M(r101) == false) goto L5;
        return;
    L5:
        c r102 = this.f250113f;
        if (r102 == null) goto L12;
        r102.pause();
        Unit r103 = Unit.INSTANCE;
        if (r101 == null) goto L10;
        r101.invoke(new Object[]{0});
        Unit r104 = Unit.INSTANCE;
    L11:
        if (r104 == null) goto L12;
        return;
    L10:
        r104 = null;
    L12:
        if (r101 == null) goto L16;
        r101.invoke(new Object[]{3});
        Unit r105 = Unit.INSTANCE;
        return;
    }

    @LynxUIMethod
    public void play(ReadableMap r100, Callback r101) {
        if (this.f250109b == false) goto L5;
        if (r101 == null) goto L43;
        r101.invoke(new Object[]{3, AnonymousClass2.INSTANCE});
        return;
    L43:
        return;
    L5:
        if (this.f250111d == null) goto L14;
        c r102 = this.f250113f;
        if (r102 == null) goto L14;
        if (r102.playerView() != null) goto L12;
        r102.createPlayerView();
    L12:
        P(r102);
    L14:
        if (M(r101) == false) goto L16;
        return;
    L16:
        c r103 = this.f250113f;
        if (r103 != null) goto L19;
        return;
    L19:
        if (r103.playerView() == null) goto L39;
        c r104 = this.f250113f;
        Unit r105 = null;
        if (r104 == null) goto L23;
        com.bytedance.ies.xelement.live.impl.h r106 = r104.config();
    L24:
        if (r106 == null) goto L27;
        r106.b(new e(this));
    L27:
        c r107 = this.f250113f;
        if (r107 == null) goto L33;
        r107.play();
        Unit r108 = Unit.INSTANCE;
        if (r101 == null) goto L32;
        r101.invoke(new Object[]{0});
        r105 = Unit.INSTANCE;
    L32:
        if (r105 == null) goto L33;
        return;
    L33:
        if (r101 == null) goto L41;
        r101.invoke(new Object[]{3});
        Unit r109 = Unit.INSTANCE;
        return;
    L41:
        return;
    L23:
        r106 = null;
        goto L24
    }

    @LynxUIMethod
    public void requireOwnership(ReadableMap r100, Callback r101) {
        c r102 = this.f250113f;
        if (r102 == null) goto L5;
        r102.c();
    L5:
        if (r101 == null) goto L8;
        r101.invoke(new Object[]{0});
        return;
    }

    @LynxUIMethod
    public void stop(ReadableMap r100, Callback r101) {
        if (M(r101) == false) goto L5;
        return;
    L5:
        N(r101);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onListCellDisAppear(String r100, LynxBaseUI r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "list");
        super.onListCellDisAppear(r100, r101, r102);
        if (this.f250110c == false) goto L5;
        this.f250109b = true;
        N(null);
    L5:
        c r103 = this.f250113f;
        if (r103 == null) goto L11;
        if (r100 != null) goto L9;
        r100 = "";
    L9:
        r103.onListCellDisAppear(r100);
        return;
    }
}
