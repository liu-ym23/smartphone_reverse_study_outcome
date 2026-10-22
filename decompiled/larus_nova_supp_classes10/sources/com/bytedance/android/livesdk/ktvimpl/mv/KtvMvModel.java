package com.bytedance.android.livesdk.ktvimpl.mv;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.ktvimpl.base.api.KtvRoomApi;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.dd;
import com.bytedance.android.livesdk.message.model.fd;
import com.bytedance.android.livesdk.message.model.gd;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.message.KtvStreamSingSyncData;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvMvModel implements vlc.l, com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b {
    public String a;
    public final CompositeDisposable b;
    public final ArrayList<l> c;
    public final ArrayList<s> d;
    public final String e;
    public Function3<? super String, ? super Long, ? super String, Unit> f;
    public Function3<? super String, ? super Long, ? super String, Boolean> g;
    public final ArrayList<y> h;
    public l i;
    public final Lazy j;
    public Long k;
    public DataCenter l;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ KtvMvModel a;
        public final /* synthetic */ y b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Function3 d;

        public b(KtvMvModel r1, y r2, String r3, Function3 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r12) {
            com.bytedance.android.live.network.response.e r13 = (com.bytedance.android.live.network.response.e) r12;
            com.bytedance.android.live.ktv.common.model.api.b r0 = (com.bytedance.android.live.ktv.common.model.api.b) ((ExtraResponse) r13).data;
            fd r1 = r0.a();
            fd r2 = r0.a();
            if (r2 == null) goto L5;
            String r5 = r2.d();
        L6:
            if (r5 == null) goto L30;
            if (r1 == null) goto L30;
            l r14 = new l(this.b, r5, r1.a(), r1.b(), this.b.f, r1.e(), this.c);
            Long r3 = this.b.e;
            if (r3 == null) goto L12;
            long r6 = r3.longValue();
        L14:
            if (r6 <= 0) goto L16;
            r14.m = Long.valueOf(r6);
        L16:
            List r4 = r1.c();
            if (r4 == null) goto L26;
            Iterator<T> r7 = r4.iterator();
        L20:
            if (r7.hasNext() == false) goto L24;
            T r8 = r7.next();
            if ((!TextUtils.isEmpty((String) r8)) == false) goto L20;
        L25:
            String r9 = r8;
        L27:
            r14.c = r9;
            String r10 = this.b.c;
            this.a.g(r14, false);
            Function3 r11 = this.d;
            if (r11 == null) goto L37;
            Unit r15 = (Unit) r11.invoke(r14, 0, null);
            return;
        L37:
            return;
        L24:
            r8 = (T) null;
            goto L25
        L26:
            r9 = null;
            goto L27
        L12:
            r6 = 0;
        L30:
            com.bytedance.android.live.ktv.common.util.g.e("vId/videoInfo is null, " + ((ExtraResponse) r13).logId);
            Function3<? super String, ? super Long, ? super String, Unit> r16 = this.a.f;
            if (r16 == null) goto L39;
            Unit r17 = (Unit) r16.invoke(r5, Long.valueOf(this.b.b), this.b.d);
            return;
        L39:
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ KtvMvModel a;
        public final /* synthetic */ Function3 b;
        public final /* synthetic */ y c;

        public c(KtvMvModel r1, Function3 r2, y r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            int r0 = mb0.b.a;
            int r1 = mb0.b.a.a(r6);
            String r2 = mb0.b.a.b(r6);
            Function3 r3 = this.b;
            if (r3 == null) goto L5;
            Unit r4 = (Unit) r3.invoke(null, Integer.valueOf(r1), r2);
        L5:
            Function3<? super String, ? super Long, ? super String, Unit> r7 = this.a.f;
            if (r7 == null) goto L8;
            Unit r8 = (Unit) r7.invoke(null, Long.valueOf(this.c.b), this.c.d);
        L8:
            com.bytedance.android.live.ktv.common.util.g.e("requestMvInfo error " + r6.getMessage());
            com.bytedance.android.live.ktv.common.util.g.c("requestMvInfo error " + r6.getMessage());
        }
    }

    static {
    }

    public final void e() {
        this.c.clear();
        DataCenter r0 = this.l;
        if (r0 == null) goto L8;
        vlc.d r1 = (vlc.d) r0.get("data_message_manager", null);
        if (r1 == null) goto L9;
        r1.removeMessageListener(this);
        return;
    L9:
        return;
    }

    public final l a(l r9) {
        Iterator<l> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        l r1 = r0.next();
        l r2 = r1;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r9, "other");
        if (r2.f == r9.f) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L4;
    L15:
        return r1;
    L8:
        if (Intrinsics.areEqual(r2.g, r9.g) == false) goto L10;
        r3 = true;
        goto L11
    L13:
        r1 = null;
        goto L15
    }

    public final l b(y r8) {
        Iterator<l> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        l r1 = r0.next();
        if (Intrinsics.areEqual(r8.d, r1.g) == false) goto L4;
        if (r8.b != r1.f) goto L4;
        return r1;
    L10:
        return null;
    }

    public final void d(l r11) {
        HashSet r0 = new HashSet();
        Iterator<s> r1 = this.d.iterator();
    L4:
        if (r1.hasNext() == false) goto L20;
        s r2 = r1.next();
        Function1<l, Boolean> r3 = r2.b;
        y r4 = r2.a;
        if (r4 == null) goto L8;
        if (r11.f == r4.b) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == false) goto L4;
        if (((Boolean) r3.invoke(r11)).booleanValue() == false) goto L4;
        r0.add(r2);
        goto L4
    L13:
        if (Intrinsics.areEqual(r11.g, r4.d) == false) goto L15;
        r5 = true;
        goto L16
    L8:
        if (((Boolean) r3.invoke(r11)).booleanValue() == false) goto L4;
        r0.add(r2);
        goto L4
    L20:
        this.d.removeAll(r0);
    }

    public final void h(DataCenter r4) {
        DataCenter r0 = this.l;
        if (r0 == null) goto L8;
        if (r0 == null) goto L8;
        vlc.d r1 = (vlc.d) r0.get("data_message_manager", null);
        if (r1 == null) goto L8;
        r1.removeMessageListener(this);
    L8:
        this.l = r4;
        if (r4 == null) goto L14;
        vlc.d r5 = (vlc.d) r4.get("data_message_manager", null);
        if (r5 == null) goto L15;
        r5.addMessageListener(MessageType.KTV_MV_VIDEO_MESSAGE.getIntType(), this);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b
    public final void handleStateChange(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "transition");
        Intrinsics.checkNotNullParameter(r2, "transition");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b
    public final void notifyClear(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "clearListener");
        Intrinsics.checkNotNullParameter(r2, "clearListener");
    }

    public final void onMessage(tlc.d r13) {
        String r1 = null;
        Object r2 = null;
        if ((r13 instanceof gd) == true) goto L5;
        r13 = null;
    L5:
        gd r14 = (gd) r13;
        if (r14 == null) goto L30;
        dd r15 = r14.videoContent;
        if (r15 == null) goto L31;
        com.bytedance.android.live.ktv.common.util.g.d(r15.toString());
        Long r0 = r15.c();
        if (r0 == null) goto L32;
        long r5 = r0.longValue();
        String r7 = r15.a();
        fd r16 = r15.d();
        if (r16 == null) goto L33;
        String r3 = r16.d();
        if (r3 != null) goto L16;
        return;
    L16:
        l r4 = new l(r3, r16.a(), r5, r7, r16.b(), null, r16.e(), "message");
        List r17 = r16.c();
        if (r17 == null) goto L25;
        Iterator r18 = r17.iterator();
    L20:
        if (r18.hasNext() == false) goto L24;
        Object r6 = r18.next();
        if ((!TextUtils.isEmpty((String) r6)) == false) goto L20;
        r2 = r6;
    L24:
        r1 = (String) r2;
    L25:
        r4.c = r1;
        Unit r19 = Unit.INSTANCE;
        g(r4, false);
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b
    public final void onMusicListChange(List<MusicPanel> r18) {
        if (r18 == null) goto L5;
        int r3 = r18.size();
    L7:
        if (r3 <= 1) goto L16;
        if (r18 == null) goto L16;
        MusicPanel r4 = (MusicPanel) ListProtector.get(r18, 1);
        if (r4 == null) goto L16;
        KtvMusic r5 = r4.a;
        if (r5 == null) goto L16;
        if (Intrinsics.areEqual(r5.getOrderUserIdString(), jc1.k.n(IMiddlewareUserService.class).user().n()) == false) goto L16;
        c(new y(r5, null), KtvMvModel$onMusicListChange$1$1.INSTANCE);
    L16:
        if (r18 != null) goto L18;
    L65:
        this.c.clear();
        if (((Boolean) this.j.getValue()).booleanValue() == false) goto L79;
        ArrayList<s> r1 = this.d;
        ArrayList r6 = new ArrayList();
        Iterator<s> r2 = r1.iterator();
    L69:
        if (r2.hasNext() == false) goto L77;
        s r7 = r2.next();
        if (r7.a == null) goto L73;
        boolean r8 = true;
    L74:
        if (r8 == false) goto L69;
        r6.add(r7);
        goto L69
    L73:
        r8 = false;
        goto L74
    L77:
        if ((!r6.isEmpty()) == false) goto L107;
        this.d.removeAll(r6);
        return;
    L107:
        return;
    L79:
        this.d.clear();
        return;
    L18:
        if (r18.isEmpty() == true) goto L65;
        ArrayList r9 = new ArrayList();
        Iterator<l> r10 = this.c.iterator();
    L22:
        if (r10.hasNext() == false) goto L37;
        l r11 = r10.next();
        long r12 = r11.f;
        String r13 = r11.g;
        Iterator<T> r14 = r18.iterator();
    L25:
        if (r14.hasNext() == false) goto L34;
        Object r15 = r14.next();
        MusicPanel r16 = (MusicPanel) r15;
        if (r16.a.getMId() == r12) goto L29;
    L31:
        boolean r17 = false;
    L32:
        if (r17 == false) goto L25;
    L35:
        if (r15 != null) goto L22;
        r9.add(r11);
        goto L22
    L29:
        if (Intrinsics.areEqual(r16.a.getOrderUserIdString(), r13) == false) goto L31;
        r17 = true;
        goto L32
    L34:
        r15 = null;
        goto L35
    L37:
        Iterator r19 = r9.iterator();
    L39:
        if (r19.hasNext() == false) goto L41;
        this.c.remove((l) r19.next());
        goto L39
    L41:
        ArrayList<s> r20 = this.d;
        ArrayList r21 = new ArrayList();
        Iterator<s> r22 = r20.iterator();
    L43:
        if (r22.hasNext() == false) goto L63;
        s r23 = r22.next();
        y r24 = r23.a;
        if (r24 == null) goto L60;
        long r25 = r24.b;
        String r26 = r24.d;
        Iterator<T> r110 = r18.iterator();
    L48:
        if (r110.hasNext() == false) goto L57;
        Object r111 = r110.next();
        MusicPanel r112 = (MusicPanel) r111;
        if (r112.a.getMId() == r25) goto L52;
    L54:
        boolean r113 = false;
    L55:
        if (r113 == false) goto L48;
    L58:
        if (r111 != null) goto L60;
        boolean r27 = true;
    L61:
        if (r27 == false) goto L43;
        r21.add(r23);
        goto L43
    L52:
        if (Intrinsics.areEqual(r112.a.getOrderUserIdString(), r26) == false) goto L54;
        r113 = true;
        goto L55
    L57:
        r111 = null;
    L60:
        r27 = false;
        goto L61
    L63:
        this.d.removeAll(r21);
        return;
    L5:
        r3 = 0;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b
    public final void onSeiResult(com.bytedance.android.livesdk.ktvimpl.base.sei.w r14) {
        Intrinsics.checkNotNullParameter(r14, "result");
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r15 = r14.b;
        l r1 = null;
        if ((r15 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == true) goto L5;
        r15 = null;
    L5:
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r16 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r15;
        if (r16 != null) goto L8;
        return;
    L8:
        if ((!Intrinsics.areEqual(this.a, r16.D())) == false) goto L31;
        if (r16.D() != null) goto L31;
        if (r16.v() == 2) goto L14;
    L20:
        boolean r0 = false;
    L21:
        if (r0 == false) goto L31;
        Function3<? super String, ? super Long, ? super String, Boolean> r2 = this.g;
        if (r2 == null) goto L25;
        Boolean r3 = (Boolean) r2.invoke(null, Long.valueOf(r16.j()), r16.A());
    L27:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L29;
        this.a = null;
    L29:
        com.bytedance.android.live.ktv.common.util.g.c("onSeiResult , vid is null：" + r16.j());
        return;
    L25:
        r3 = null;
        goto L27
    L14:
        if (r16.d() == 3) goto L18;
        if (r16.d() != 0) goto L20;
    L18:
        if (r16.j() <= 0) goto L20;
        r0 = true;
    L31:
        if (r16.D() != null) goto L33;
        return;
    L33:
        if ((!Intrinsics.areEqual(this.a, r16.D())) == false) goto L67;
        com.bytedance.android.live.ktv.common.util.g.d(r16.toString());
        long r5 = r16.j();
        String r4 = r16.A();
        if (r2.a(r4) == false) goto L37;
        String r8 = r4;
    L38:
        if (r8 != null) goto L40;
        return;
    L40:
        String r6 = r16.D();
        this.a = r6;
        Iterator<l> r7 = this.c.iterator();
    L42:
        if (r7.hasNext() == false) goto L51;
        l r9 = r7.next();
        l r10 = r9;
        if (r10.f == r5) goto L46;
    L48:
        boolean r11 = false;
    L49:
        if (r11 == false) goto L42;
        r1 = r9;
        goto L51
    L46:
        if (Intrinsics.areEqual(r8, r10.g) == false) goto L48;
        r11 = true;
    L51:
        l r12 = r1;
        long r13 = (long) ((r16.y() + r16.m()) * 1000.0f);
        if (r12 != null) goto L54;
    L57:
        f(new y(r5, null, r8, Long.valueOf(r13), null, 18), r6, "sei_result", KtvMvModel$onSeiResult$1$1.INSTANCE);
        return;
    L54:
        if ((!Intrinsics.areEqual(r12.d, r6)) == true) goto L57;
        Intrinsics.checkNotNullParameter("sei_result", "<set-?>");
        r12.l = "sei_result";
        g(r12, true);
        return;
    L37:
        r8 = null;
        goto L38
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b
    public final void playPreviewMv(KtvStreamSingSyncData r2) {
        Intrinsics.checkNotNullParameter(r2, "syncData");
        Intrinsics.checkNotNullParameter(r2, "syncData");
    }

    public KtvMvModel(Long r2, DataCenter r3) {
        this.k = r2;
        this.l = r3;
        this.b = new CompositeDisposable();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = (String) vm2.h.i4.getValue(null, vm2.h.a[267(0x10b, float:3.74E-43)]);
        h(this.l);
        this.h = new ArrayList();
        this.j = LazyKt.lazy(KtvMvModel$enableGrayFixSwitch$2.INSTANCE);
    }

    public final void c(y r6, Function3 r7) {
        Intrinsics.checkNotNullParameter(r6, "songParam");
        Intrinsics.checkNotNullParameter(r7, "cb");
        com.bytedance.android.live.ktv.common.util.g.d("getMvInfo songParam: " + r6);
        l r0 = b(r6);
        y r1 = null;
        if (r0 == null) goto L6;
        r7.invoke(r0, 0, null);
        return;
    L6:
        com.bytedance.android.live.ktv.common.util.g.d("requestMvInfoBySong" + r6);
        if (this.h.contains(r6) == false) goto L24;
        com.bytedance.android.live.ktv.common.util.g.d("requestMvInfoBySong:in requesting " + r6);
        if (r7 == null) goto L29;
        Iterator<y> r2 = this.h.iterator();
    L12:
        if (r2.hasNext() == false) goto L16;
        y r3 = r2.next();
        if (Intrinsics.areEqual(r3, r6) == false) goto L12;
        r1 = r3;
    L16:
        y r4 = r1;
        if (r4 != null) goto L19;
        return;
    L19:
        if (r4.a != null) goto L21;
        r4.a = new ArrayList();
    L21:
        ArrayList<Function3<l, Integer, String, Unit>> r8 = r4.a;
        if (r8 == null) goto L31;
        r8.add(r7);
        return;
    L31:
        return;
    L29:
        return;
    L24:
        com.bytedance.android.live.ktv.common.util.g.g("requestAndNotifyAllMvInfoBySong:" + r6.b + "--" + r6.c);
        this.h.add(r6);
        RxUtilKt.c(((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).fetchAtmosphereVideoInfo(this.k, Long.valueOf(r6.b), r6.c, r6.f).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this, r6, r7), new e(this, r6)), this.b);
    }

    public final void g(l r10, boolean r11) {
        l r0 = a(r10);
        if (r0 != null) goto L5;
    L10:
        Iterator<l> r12 = this.c.iterator();
    L11:
        boolean r1 = true;
        if (r12.hasNext() == false) goto L21;
        l r2 = r12.next();
        l r3 = r2;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r10, "other");
        if (r3.f == r10.f) goto L16;
    L18:
        boolean r4 = false;
    L19:
        if (r4 == false) goto L11;
    L22:
        if (r2 != null) goto L25;
        r1 = false;
    L25:
        if (r1 == false) goto L27;
        com.bytedance.android.live.ktv.common.util.g.c("相同歌曲和演唱者id:" + r10.d + "。old:" + a(r10) + "=====new:" + r10);
    L27:
        com.bytedance.android.live.ktv.common.util.g.c("saveMvInfo:" + r10);
        this.c.add(r10);
        d(r10);
        return;
    L16:
        if (Intrinsics.areEqual(r3.g, r10.g) == false) goto L18;
        r4 = true;
        goto L19
    L21:
        r2 = null;
        goto L22
    L5:
        if (Intrinsics.areEqual(r0.d, r10.d) == false) goto L9;
        if (r11 == false) goto L34;
        d(r10);
        return;
    L34:
        return;
    L9:
        this.c.remove(r0);
        goto L10
    }

    public final void f(y r8, String r9, String r10, Function3<? super l, ? super Integer, ? super String, Unit> r11) {
        com.bytedance.android.live.ktv.common.util.g.d("requestMvInfo" + r8);
        com.bytedance.android.live.ktv.common.util.g.g("requestMvInfo:" + r8 + "--" + r9 + "----" + r10);
        RxUtilKt.c(((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).getAtmosphereVideoInfoByVid(this.k, r9, Long.valueOf(r8.b), Long.valueOf(d5.c(r8.d)), r8.d).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r8, r10, r11), new c(this, r11, r8)), this.b);
    }
}
