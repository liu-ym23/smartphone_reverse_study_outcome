package og0;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ch0.e;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.base.LayerBackgroundStatus;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.MultiLinkCommonGuestMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.ui.SelfDisciplineTimerView;
import com.bytedance.android.livesdk.common.AnchorPauseTipsView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import rj0.l;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends jg0.b<MultiLinkGuestViewBinder.a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MultiLinkGuestViewBinder.a f523168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HSImageView f523169e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinkMicQuickInteractView f523170f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SelfDisciplineTimerView f523171g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AnchorPauseTipsView f523172h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewGroup f523173i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final g f523174j;

    /* JADX INFO: renamed from: og0.a$a, reason: collision with other inner class name */
    public static final class C7048a {
    }

    static {
    }

    @Override // jg0.b
    public final int b() {
        return R.layout.ttlive_layer_multilink_self_discipline_stub;
    }

    @Override // jg0.f
    public final void onDetach() {
        this.f523168d = null;
        ViewGroup r100 = this.f523173i;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("selfDisciplineContainer");
    L5:
        UtilityKotlinExtentionsKt.t(r100);
        SelfDisciplineTimerView r101 = this.f523171g;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("timerView");
    L8:
        r101.b();
        HSImageView r102 = this.f523169e;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("likeEffect");
    L11:
        r102.setVisibility(8);
    }

    @Override // jg0.b
    public final String c() {
        return VerticalNitaInflate.Tag.MultiLinkMicSelfDisciplineLayer.name();
    }

    public final boolean g() {
        MultiLinkGuestViewBinder.a r100 = this.f523168d;
        String r101 = null;
        if (r100 == null) goto L11;
        e r102 = r100.f75934k;
        if (r102 == null) goto L11;
        ILinkPlayerInfoBridge r103 = r102.f23724a;
        if (r103 == null) goto L11;
        IBaseUser r104 = r103.getUser();
        if (r104 == null) goto L11;
        String r105 = r104.getIdString();
    L12:
        m<IRoom> r106 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r106 == null) goto L18;
        IRoom r107 = r106.getValue();
        if (r107 == null) goto L18;
        r101 = r107.getOwnerUserIdString();
    L18:
        return Intrinsics.areEqual(r105, r101);
    L11:
        r105 = null;
        goto L12
    }

    public final void h() {
        SelfDisciplineContext.a r100 = SelfDisciplineContext.Companion;
        boolean r101 = true;
        if (r100.e() == false) goto L74;
        LinkMicQuickInteractView r102 = this.f523170f;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("linkInteract");
    L7:
        r102.setVisibility(8);
        if (this.f498949b == 0) goto L10;
        return;
    L10:
        if (g() == true) goto L99;
        AnchorPauseTipsView r103 = this.f523172h;
        if (r103 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("leaveView");
    L15:
        if (r103.getVisibility() == 0) goto L100;
        MultiLinkGuestViewBinder.a r104 = this.f523168d;
        Integer r105 = null;
        if (r104 == null) goto L25;
        e r106 = r104.f75934k;
        if (r106 == null) goto L25;
        ILinkPlayerInfoBridge r107 = r106.f23724a;
        if (r107 == null) goto L25;
        IBaseUser r108 = r107.getUser();
        if (r108 == null) goto L25;
        String r109 = r108.getIdString();
    L27:
        if ((!Intrinsics.areEqual(r109, je0.d.b0())) == false) goto L29;
    L30:
        ViewGroup r110 = this.f523173i;
        if (r110 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("selfDisciplineContainer");
    L33:
        UtilityKotlinExtentionsKt.w(r110);
        SelfDisciplineTimerView r111 = this.f523171g;
        if (r111 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("timerView");
    L36:
        r111.setVisibility(0);
        MultiLinkGuestViewBinder.a r112 = this.f523168d;
        if (r112 == null) goto L102;
        e r113 = r112.f75934k;
        if (r113 == null) goto L103;
        ILinkPlayerInfoBridge r114 = r113.f23724a;
        if (r114 == null) goto L104;
        SelfDisciplineTimerView r115 = this.f523171g;
        if (r115 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("timerView");
    L45:
        r115.getClass();
        Intrinsics.checkNotNullParameter(r114, "playerInfo");
        r115.f79723c = r114;
        IBaseUser r116 = r114.getUser();
        Intrinsics.checkNotNull(r116);
        String r117 = r116.getIdString();
        long r118 = r114.getSelfDisciplineDuration();
        if (r115.f79722b.containsKey(r117) == false) goto L58;
        Long r119 = r115.f79722b.get(r117);
        if (r119 != null) goto L50;
    L59:
        TextView r120 = (TextView) r115.a(R.id.tv_timer);
        if (r120 == null) goto L63;
        r105 = Integer.valueOf(r120.getVisibility());
    L63:
        if (r105.intValue() == 0) goto L70;
        TextView r121 = (TextView) r115.a(R.id.tv_timer);
        if (r121 == null) goto L67;
        r121.setVisibility(0);
    L67:
        TextView r122 = (TextView) r115.a(R.id.tv_timer);
        if (r122 == null) goto L70;
        r122.setText(SelfDisciplineTimerView.d(0));
    L70:
        Disposable r123 = r115.f79724d;
        if (r123 == null) goto L73;
        r123.dispose();
    L73:
        r115.f79724d = Observable.interval(0, 1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.ui.a(r115, r117));
        return;
    L50:
        if (r118 > r119.longValue()) goto L53;
        r101 = false;
    L53:
        if (r101 == true) goto L56;
        r119 = null;
    L56:
        if (r119 == null) goto L59;
        r115.f79722b.put(r117, Long.valueOf(r118));
        goto L59
    L58:
        r115.f79722b.put(r117, Long.valueOf(r118));
        goto L59
    L104:
        return;
    L103:
        return;
    L102:
        return;
    L29:
        if (r100.f() == false) goto L30;
        return;
    L25:
        r109 = null;
        goto L27
    L100:
        return;
    L99:
        return;
    L74:
        ViewGroup r124 = this.f523173i;
        if (r124 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("selfDisciplineContainer");
    L78:
        if (r124.getVisibility() != 0) goto L106;
        ViewGroup r125 = this.f523173i;
        if (r125 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("selfDisciplineContainer");
    L82:
        UtilityKotlinExtentionsKt.t(r125);
        SelfDisciplineTimerView r126 = this.f523171g;
        if (r126 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("timerView");
    L85:
        r126.b();
        MultiLinkGuestViewBinder.a r127 = this.f523168d;
        if (r127 == null) goto L107;
        e r128 = r127.f75934k;
        if (r128 == null) goto L108;
        ILinkPlayerInfoBridge r129 = r128.f23724a;
        if (r129 != null) goto L92;
        return;
    L92:
        if (r129.isOpenSendGift() != true) goto L110;
        LinkMicQuickInteractView r130 = this.f523170f;
        if (r130 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("linkInteract");
    L96:
        r130.setVisibility(0);
        return;
    L110:
        return;
    L108:
        return;
    L107:
        return;
    }

    @Override // jg0.b, jg0.f
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.a(r100);
        View r101 = this.f523174j.m(R.id.ttlive_guest_fans_ticket_count);
        if (r101 == null) goto L26;
        this.f523170f = (LinkMicQuickInteractView) r101;
        View r102 = this.f523174j.m(R.id.ttlive_leave_view);
        if (r102 == null) goto L24;
        this.f523172h = (AnchorPauseTipsView) r102;
        View r103 = this.f523174j.m(R.id.ttlive_self_discipline_like_effect);
        if (r103 == null) goto L22;
        this.f523169e = (HSImageView) r103;
        View r104 = this.f523174j.m(R.id.ttlive_self_discipline_timer_view);
        if (r104 == null) goto L20;
        this.f523171g = (SelfDisciplineTimerView) r104;
        View r105 = this.f523174j.m(R.id.self_discipline_container);
        if (r105 == null) goto L18;
        this.f523173i = (ViewGroup) r105;
        HSImageView r106 = this.f523169e;
        if (r106 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("likeEffect");
    L15:
        r106.setVisibility(8);
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.ui.SelfDisciplineTimerView");
    L22:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.widget.HSImageView");
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.common.AnchorPauseTipsView");
    L26:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView");
    }

    public a(MultiLinkCommonGuestMicSeatBasicLayer r100, xg0.a r101) {
        Intrinsics.checkNotNullParameter(r100, "basicLayer");
        Intrinsics.checkNotNullParameter(r101, "linkSeatAbilityProvider");
        super(r101);
        this.f523174j = r100;
    }

    @Override // jg0.f
    public final void d(Object r100, int r101) {
        MultiLinkGuestViewBinder.a r102 = (MultiLinkGuestViewBinder.a) r100;
        Intrinsics.checkNotNullParameter(r102, "itemData");
        this.f523168d = r102;
        h();
    }

    @Override // jg0.f
    public final void k(Object r100, int r101, Bundle r102) {
        MultiLinkGuestViewBinder.a r103 = (MultiLinkGuestViewBinder.a) r100;
        Intrinsics.checkNotNullParameter(r103, "itemData");
        Intrinsics.checkNotNullParameter(r102, WsConstants.KEY_PAYLOAD);
        this.f523168d = r103;
        if (SelfDisciplineContext.Companion.e() == false) goto L8;
        LinkMicQuickInteractView r104 = this.f523170f;
        if (r104 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("linkInteract");
    L7:
        r104.setVisibility(8);
    L8:
        Iterator<String> r105 = r102.keySet().iterator();
    L10:
        if (r105.hasNext() == false) goto L83;
        String r106 = r105.next();
        if (r106 == null) goto L10;
        int r107 = r106.hashCode();
        if (r107 != (-1417529401)) goto L17;
        if (r106.equals("payload_key_self_discipline_duration_update") == false) goto L10;
        h();
        goto L10
    L17:
        if (r107 != (-1010189482)) goto L10;
        if (r106.equals("payload_key_background_status_update") == false) goto L10;
        MultiLinkGuestViewBinder.a r108 = this.f523168d;
        boolean r109 = false;
        if (r108 == null) goto L30;
        e r110 = r108.f75934k;
        if (r110 == null) goto L30;
        ILinkPlayerInfoBridge r111 = r110.f23724a;
        if (r111 == null) goto L30;
        if (r111.isBackground() != true) goto L30;
        boolean r112 = true;
    L31:
        MultiLinkGuestViewBinder.a r113 = this.f523168d;
        if (r113 == null) goto L10;
        e r114 = r113.f75934k;
        if (r114 == null) goto L10;
        ILinkPlayerInfoBridge r115 = r114.f23724a;
        if (r115 == null) goto L10;
        if (r115.getSilenceStatus() == 0) goto L41;
        r109 = true;
    L41:
        IBaseUser r116 = r115.getUser();
        String r117 = null;
        if (r116 == null) goto L44;
        String r118 = r116.getIdString();
    L45:
        m<IRoom> r119 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r119 == null) goto L50;
        IRoom r120 = r119.getValue();
        if (r120 == null) goto L50;
        r117 = r120.getOwnerUserIdString();
    L50:
        boolean r121 = Intrinsics.areEqual(r118, r117);
        if (je0.d.D() == true) goto L61;
        l.f537955n2.getClass();
        l r122 = l.a.a();
        if (r122 != null) goto L55;
    L57:
        if (r112 == false) goto L59;
        LayerBackgroundStatus r123 = LayerBackgroundStatus.Leave;
    L68:
        int r124 = b.f523175a[r123.ordinal()];
        if (r124 == 1) goto L79;
        if (r124 == 2) goto L79;
        if (r124 != 3) goto L10;
        ViewGroup r125 = this.f523173i;
        if (r125 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("selfDisciplineContainer");
    L78:
        UtilityKotlinExtentionsKt.t(r125);
    L79:
        h();
        goto L10
    L59:
        r123 = LayerBackgroundStatus.Normal;
        goto L68
    L55:
        if (r122.isEngineOn() != true) goto L57;
    L61:
        if (r115.isSelfBackground() == true) goto L63;
        r123 = LayerBackgroundStatus.Normal;
        goto L68
    L63:
        if (r109 == true) goto L67;
        if (r121 == true) goto L67;
        r123 = LayerBackgroundStatus.Audio;
    L67:
        r123 = LayerBackgroundStatus.Leave;
        goto L68
    L44:
        r118 = null;
    L30:
        r112 = false;
        goto L31
    }
}
