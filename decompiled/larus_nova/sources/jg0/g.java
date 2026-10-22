package jg0;

import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.utils.AvatarType;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.MultiLinkMicSeatGiftIconElement;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.theme.MultiLinkThemedCompetitionBusinessLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.preonline.MultiLinkPreOnlineMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.ThemedCompetitionQuickInteractView;
import com.bytedance.android.live.liveinteract.voicechat.view.VoiceChatRoomAnchorView;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import tf0.e;
import tf0.p;

/* JADX INFO: loaded from: classes46.dex */
public class g<T extends tf0.e> implements f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f<T>> f498954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f498955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f498956c;

    public static final class a {
    }

    static {
    }

    public final PointF c() {
        Iterator r100 = ((ArrayList) this.f498954a).iterator();
    L3:
        View r101 = null;
        if (r100.hasNext() == false) goto L41;
        f r102 = (f) r100.next();
        if ((r102 instanceof g) == true) goto L8;
        if ((r102 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g) == false) goto L3;
        MultiLinkMicSeatGiftIconElement r103 = ((com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g) r102).f75731m;
        if (r103 == null) goto L37;
        LinkMicQuickInteractView r104 = r103.f75666c;
        if (r104 != null) goto L16;
        return null;
    L16:
        if (r104.getVisibility() != 0) goto L40;
        LinkMicQuickInteractView r105 = r103.f75666c;
        if (r105 == null) goto L39;
        int[] r106 = new int[2];
        r105.f79525f.getLocationOnScreen(r106);
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a r107 = r105.f79533n;
        View r108 = r107.f79579f.f79606a.getCurrentView();
        if ((r108 instanceof TextView) == false) goto L24;
        r101 = r108;
    L24:
        TextView r109 = (TextView) r101;
        if (r109 != null) goto L27;
        Pair r110 = new Pair(Integer.valueOf(r107.f79579f.f79606a.getCurrentView().getWidth()), Integer.valueOf(r107.f79579f.f79606a.getWidth()));
    L28:
        int r111 = ((Number) r110.getFirst()).intValue();
        if (r111 <= ((Number) r110.getSecond()).intValue()) goto L32;
        r106[0] = r106[0] - (r111 - r105.f79533n.f79579f.f79606a.getWidth());
    L32:
        return new PointF(r106[0], r106[1]);
    L27:
        int r112 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r113 = View.MeasureSpec.makeMeasureSpec(0, 0);
        CharSequence r114 = r109.getText();
        r109.setText(r105.f79543x);
        r109.measure(r112, r113);
        r107.f79579f.f79606a.measure(r112, r113);
        int r115 = r107.f79579f.f79606a.getMeasuredWidth();
        int r116 = r109.getMeasuredWidth();
        r109.setText(r114);
        r110 = new Pair(Integer.valueOf(r116), Integer.valueOf(r115));
        goto L28
    L39:
        return null;
    L40:
        return null;
    L37:
        return null;
    L8:
        return ((g) r102).c();
    L41:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View] */
    public final bd0.c f() {
        Iterator r100 = ((ArrayList) this.f498954a).iterator();
    L3:
        Object r101 = null;
        if (r100.hasNext() == false) goto L59;
        f r102 = (f) r100.next();
        if ((r102 instanceof g) == true) goto L8;
        if ((r102 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b) == true) goto L11;
        if ((r102 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g) == true) goto L18;
        if ((r102 instanceof MultiLinkPreOnlineMicSeatBasicLayer) == true) goto L22;
        if ((r102 instanceof e) == true) goto L26;
        if ((r102 instanceof ng0.b) == false) goto L3;
        ng0.b r103 = (ng0.b) r102;
        r103.getClass();
        VoiceChatRoomAnchorView r104 = r103.f519022e;
        if (r104 == null) goto L33;
        View r105 = r104.a(R.id.ttlive_avatar_view);
    L34:
        MultiLinkGuestViewBinder.a r106 = r103.f519021d;
        if (r106 == null) goto L43;
        ch0.e r107 = r106.f75934k;
        if (r107 == null) goto L43;
        ILinkPlayerInfoBridge r108 = r107.f23724a;
        if (r108 == null) goto L43;
        IBaseUser r109 = r108.getUser();
        if (r109 == null) goto L43;
        String r110 = r109.getIdString();
    L44:
        MultiLinkGuestViewBinder.a r111 = r103.f519021d;
        if (r111 == null) goto L58;
        ch0.e r112 = r111.f75934k;
        if (r112 == null) goto L58;
        ILinkPlayerInfoBridge r113 = r112.f23724a;
        if (r113 == null) goto L58;
        IBaseUser r114 = r113.getUser();
        if (r114 == null) goto L58;
        k r115 = je0.d.n(r114, AvatarType.AVATAR_THUMB.getValue());
        if (r115 == null) goto L58;
        List<String> r116 = r115.getUrls();
        if (r116 == null) goto L58;
        r101 = (String) ListProtector.get(r116, 0);
    L58:
        return new bd0.c(r105, null, r110, false, 0.0f, 0.0f, r101, false, null, null, null, null, 4024);
    L43:
        r110 = null;
        goto L44
    L33:
        r105 = null;
        goto L34
    L26:
        e r117 = (e) r102;
        r117.i();
        return r117.f();
    L22:
        MultiLinkPreOnlineMicSeatBasicLayer r118 = (MultiLinkPreOnlineMicSeatBasicLayer) r102;
        r118.getClass();
        return new bd0.c(r118.f75818d, null, null, false, 0.0f, 0.0f, null, false, null, null, null, null, 4088);
    L18:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g r119 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g) r102;
        r119.i();
        return r119.f();
    L11:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b r120 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b) r102;
        r120.getClass();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r121 = r120.f75704i;
        if (r121 == null) goto L15;
        r101 = r121.f75677j;
    L15:
        return new bd0.c(r101, null, null, false, 0.0f, 0.0f, null, false, null, null, null, null, 4088);
    L8:
        return ((g) r102).f();
    L59:
        return null;
    }

    public final com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b g() {
        Iterator r100 = ((ArrayList) this.f498954a).iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        f r101 = (f) r100.next();
        if ((r101 instanceof g) == true) goto L8;
        if ((r101 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b) == false) goto L4;
        return (com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b) r101;
    L8:
        return ((g) r101).g();
    L13:
        return null;
    }

    public final com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g h() {
        Iterator r100 = ((ArrayList) this.f498954a).iterator();
    L4:
        if (r100.hasNext() == false) goto L14;
        f r101 = (f) r100.next();
        if ((r101 instanceof g) == true) goto L8;
        if ((r101 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g) == false) goto L4;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g r102 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g) r101;
        if (r102.z() == false) goto L4;
        return r102;
    L8:
        return ((g) r101).h();
    L14:
        return null;
    }

    @Override // jg0.f
    public final View l() {
        View r100 = LayoutInflater.from(this.f498956c.getContext()).inflate(R.layout.ttlive_item_mic_seat_layer_container, this.f498956c, false);
        if (r100 == null) goto L13;
        ViewGroup r101 = (ViewGroup) r100;
        this.f498955b = r101;
        Intrinsics.checkNotNull(r101);
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        r102.width = -1;
        r102.height = -1;
        Iterator r103 = ((ArrayList) this.f498954a).iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        View r104 = ((f) r103.next()).l();
        if (r104 == null) goto L6;
        ViewGroup r105 = this.f498955b;
        Intrinsics.checkNotNull(r105);
        r105.addView(r104);
        goto L6
    L10:
        ViewGroup r106 = this.f498955b;
        Intrinsics.checkNotNull(r106);
        r106.setClipChildren(false);
        this.f498956c.setClipChildren(false);
        ViewGroup r107 = this.f498955b;
        Intrinsics.checkNotNull(r107);
        return r107;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final ig0.b n() {
        Iterator r100 = ((ArrayList) this.f498954a).iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        f r101 = (f) r100.next();
        if ((r101 instanceof g) == true) goto L8;
        if ((r101 instanceof ig0.b) == false) goto L4;
        return (ig0.b) r101;
    L8:
        return ((g) r101).n();
    L13:
        return null;
    }

    public final MultiLinkPreOnlineMicSeatBasicLayer o() {
        Iterator r100 = ((ArrayList) this.f498954a).iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        f r101 = (f) r100.next();
        if ((r101 instanceof g) == true) goto L8;
        if ((r101 instanceof MultiLinkPreOnlineMicSeatBasicLayer) == false) goto L4;
        return (MultiLinkPreOnlineMicSeatBasicLayer) r101;
    L8:
        return ((g) r101).o();
    L13:
        return null;
    }

    @Override // jg0.f
    public final void onDetach() {
        Iterator r100 = ((ArrayList) this.f498954a).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((f) r100.next()).onDetach();
        goto L4
    }

    public final View p() {
        Iterator r100 = ((ArrayList) this.f498954a).iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        f r101 = (f) r100.next();
        if ((r101 instanceof g) == true) goto L8;
        if ((r101 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g) == false) goto L4;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g r102 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g) r101;
        r102.i();
        return r102.x();
    L8:
        return ((g) r101).p();
    L13:
        return null;
    }

    public final Integer q() {
        Iterator r100 = ((ArrayList) this.f498954a).iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        f r101 = (f) r100.next();
        if ((r101 instanceof g) == true) goto L8;
        if ((r101 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g) == false) goto L4;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g r102 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g) r101;
        r102.i();
        return r102.y();
    L8:
        return ((g) r101).q();
    L13:
        return null;
    }

    public final og0.a r() {
        Iterator r100 = ((ArrayList) this.f498954a).iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        f r101 = (f) r100.next();
        if ((r101 instanceof g) == true) goto L8;
        if ((r101 instanceof og0.a) == false) goto L4;
        return (og0.a) r101;
    L8:
        return ((g) r101).r();
    L13:
        return null;
    }

    public final pg0.e s() {
        Iterator r100 = ((ArrayList) this.f498954a).iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        f r101 = (f) r100.next();
        if ((r101 instanceof g) == true) goto L8;
        if ((r101 instanceof pg0.e) == false) goto L4;
        return (pg0.e) r101;
    L8:
        return ((g) r101).s();
    L13:
        return null;
    }

    public final PointF t() {
        Iterator r100 = ((ArrayList) this.f498954a).iterator();
    L3:
        View r101 = null;
        if (r100.hasNext() == false) goto L45;
        f r102 = (f) r100.next();
        if ((r102 instanceof g) == true) goto L8;
        if ((r102 instanceof MultiLinkThemedCompetitionBusinessLayer) == false) goto L3;
        MultiLinkThemedCompetitionBusinessLayer r103 = (MultiLinkThemedCompetitionBusinessLayer) r102;
        ThemedCompetitionQuickInteractView r104 = r103.f75756f;
        if (r104 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("themedCompetitionScore");
    L15:
        if (r104.getVisibility() != 0) goto L44;
        ThemedCompetitionQuickInteractView r105 = r103.f75756f;
        if (r105 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("themedCompetitionScore");
    L20:
        int r106 = r103.f75758h;
        int[] r107 = new int[2];
        r105.f79563d.getLocationOnScreen(r107);
        if (r106 == 5) goto L23;
        if (r106 == 12) goto L23;
    L39:
        return new PointF(r107[0], r107[1]);
    L23:
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a r108 = r105.f79568i;
        View r109 = r108.f79579f.f79606a.getCurrentView();
        if ((r109 instanceof TextView) == false) goto L27;
        r101 = r109;
    L27:
        TextView r110 = (TextView) r101;
        if (r110 != null) goto L30;
        int r111 = r108.f79579f.f79606a.getCurrentView().getWidth();
    L32:
        if (r111 <= r105.f79568i.f79579f.f79606a.getWidth()) goto L39;
        if (r106 == 5) goto L37;
        if (r106 != 12) goto L39;
        r107[0] = r107[0] - (r111 - r105.f79568i.f79579f.f79606a.getWidth());
        goto L39
    L37:
        r107[0] = r107[0] - ((r111 - r105.f79568i.f79579f.f79606a.getWidth()) / 2);
        goto L39
    L30:
        int r112 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r113 = View.MeasureSpec.makeMeasureSpec(0, 0);
        CharSequence r114 = r110.getText();
        r110.setText(r105.f79569j);
        r110.measure(r112, r113);
        int r115 = r110.getMeasuredWidth();
        r110.setText(r114);
        r111 = r115;
        goto L32
    L44:
        return null;
    L8:
        return ((g) r102).t();
    L45:
        return null;
    }

    public final MultiLinkThemedCompetitionBusinessLayer u() {
        Iterator r100 = ((ArrayList) this.f498954a).iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        f r101 = (f) r100.next();
        if ((r101 instanceof g) == true) goto L8;
        if ((r101 instanceof MultiLinkThemedCompetitionBusinessLayer) == false) goto L4;
        return (MultiLinkThemedCompetitionBusinessLayer) r101;
    L8:
        return ((g) r101).u();
    L13:
        return null;
    }

    public g(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        this.f498956c = r100;
        this.f498954a = new ArrayList();
    }

    @Override // jg0.f
    public void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Iterator r101 = ((ArrayList) this.f498954a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((f) r101.next()).a(r100);
        goto L4
    }

    public final void b(f r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER);
        ((ArrayList) this.f498954a).add(r100);
    }

    @Override // jg0.f
    public final void j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Iterator r101 = ((ArrayList) this.f498954a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((f) r101.next()).j(r100);
        goto L4
    }

    public final View m(int r100) {
        Iterator r101 = ((ArrayList) this.f498954a).iterator();
    L4:
        if (r101.hasNext() == false) goto L14;
        f r102 = (f) r101.next();
        if ((r102 instanceof g) == true) goto L8;
        if ((r102 instanceof jg0.a) == false) goto L4;
        View r103 = ((jg0.a) r102).m(r100);
        if (r103 == null) goto L4;
        return r103;
    L8:
        return ((g) r102).m(r100);
    L14:
        return null;
    }

    public final void x(int r100) {
        ViewGroup r101 = this.f498955b;
        if (r101 == null) goto L5;
        r101.setVisibility(r100);
    L5:
        List<f<T>> r102 = this.f498954a;
        if (r102 == null) goto L13;
        Iterator<T> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L19;
        View r104 = ((f) r103.next()).l();
        if (r104 == null) goto L9;
        r104.setVisibility(r100);
        goto L9
    L19:
        return;
    }

    @Override // jg0.f
    public /* bridge */ /* synthetic */ void d(Object r100, int r101) {
        v((tf0.e) r100, r101);
    }

    public void v(T r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "itemData");
        Iterator r102 = ((ArrayList) this.f498954a).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((f) r102.next()).d(r100, r101);
        goto L4
    }

    public final void e(int r100, p r101, Object r102) {
        Intrinsics.checkNotNullParameter(r101, "action");
        Iterator r103 = ((ArrayList) this.f498954a).iterator();
    L4:
        if (r103.hasNext() == false) goto L12;
        f r104 = (f) r103.next();
        if ((r104 instanceof g) == true) goto L7;
        if ((r104 instanceof d) == false) goto L4;
        ((d) r104).e(r100, r101, r102);
        goto L4
    L7:
        ((g) r104).e(r100, r101, r102);
        return;
    }

    @Override // jg0.f
    public /* bridge */ /* synthetic */ void k(Object r100, int r101, Bundle r102) {
        w((tf0.e) r100, r101, r102);
    }

    public void w(T r100, int r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "itemData");
        Intrinsics.checkNotNullParameter(r102, WsConstants.KEY_PAYLOAD);
        Iterator r103 = ((ArrayList) this.f498954a).iterator();     // Catch: Exception -> L9
    L5:
        if (r103.hasNext() == false) goto L14;
        ((f) r103.next()).k(r100, r101, r102);     // Catch: Exception -> L9
    L14:
        return;
    }
}
