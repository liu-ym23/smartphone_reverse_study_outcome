package com.bytedance.android.livesdk.ktvimpl.feed;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.ktvimpl.base.sei.h;
import com.bytedance.android.livesdk.ktvimpl.base.sei.i;
import com.bytedance.android.livesdk.ktvimpl.base.sei.k;
import com.bytedance.android.livesdk.ktvimpl.base.sei.l;
import com.bytedance.android.livesdk.ktvimpl.base.sei.m;
import com.bytedance.android.livesdk.ktvimpl.base.sei.w;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvComponentFeedViewModel implements com.bytedance.android.livesdk.ktvimpl.base.sei.b, com.bytedance.android.livesdk.ktvimpl.base.sei.c {
    public com.bytedance.android.livesdk.ktvimpl.base.sei.a a;
    public final StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> b;
    public final b c;
    public final NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> d;
    public final NextLiveData<ld0.a> e;
    public final m f;
    public Integer g;
    public Integer h;
    public Integer i;
    public IRoom j;
    public final a k;

    public interface a {
        void i3(com.bytedance.android.livesdk.ktvimpl.base.sei.g r1);

        void k3(k r1);

        void s1();
    }

    public KtvComponentFeedViewModel(a r3) {
        this.k = r3;
        KtvRoomLyricsStateMachineConfig r4 = KtvRoomLyricsStateMachineConfig.a;
        Function1<StateMachine.c<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b>, Unit> r0 = new KtvComponentFeedViewModel$stateMachine$1(this);
        r4.getClass();
        StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r1 = KtvRoomLyricsStateMachineConfig.a(r0, null);
        this.b = r1;
        this.c = new b(r1);
        this.d = new NextLiveData();
        this.e = new NextLiveData();
        r1.d(KtvRoomLyricsStateMachineConfig.a.g.c, null);
        l r5 = new l();
        r5.a("ktv_sei", k.class);
        r5.a("ktv_score_sei", com.bytedance.android.livesdk.ktvimpl.base.sei.g.class);
        r5.a("ktv_midi_sei", i.class);
        r5.a("ktv_midi_feedback_sei", h.class);
        Unit r2 = Unit.INSTANCE;
        m r6 = new m(r5);
        this.f = r6;
        r6.c(this, 5.0f);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final boolean accept(w r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r2, "result");
        return true;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final void onSeiResult(w r7) {
        Intrinsics.checkNotNullParameter(r7, "result");
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r0 = r7.b;
        if ((r0 instanceof k) == false) goto L61;
        IRoom r1 = this.j;
        if (r1 == null) goto L7;
        r1.getOwnerUserIdString();
    L7:
        ((k) r7.b).getClass();
        Integer r2 = Integer.valueOf(((k) r7.b).z());
        Integer r3 = Integer.valueOf(((k) r7.b).u());
        int r4 = 0;
        if (r2 != null) goto L11;
        int r5 = 0;
    L19:
        int r6 = ((k) r7.b).z();
        Integer r8 = this.g;
        if (r8 != null) goto L23;
    L24:
        this.g = Integer.valueOf(((k) r7.b).z());
    L26:
        if (((k) r7.b).z() == 3) goto L29;
        r4 = ((k) r7.b).u();
    L29:
        Integer r9 = this.h;
        if (r9 != null) goto L33;
    L34:
        this.h = Integer.valueOf(r4);
    L35:
        Integer r10 = this.i;
        if (r10 != null) goto L39;
    L40:
        a r11 = this.k;
        if (r11 == null) goto L43;
        r11.s1();
    L43:
        this.i = Integer.valueOf(r5);
    L44:
        a r12 = this.k;
        if (r12 == null) goto L48;
        r12.k3((k) r7.b);
    L48:
        if (((k) r7.b).F() == false) goto L53;
        if (((k) r7.b).d() == 1) goto L53;
        this.c.g((k) r7.b, new JSONObject(r7.a));
    L53:
        if (((k) r7.b).d() != 1) goto L58;
        this.c.f((k) r7.b);
        if (((k) r7.b).C() != 0) goto L58;
        this.e.setValue(new ld0.a());
    L58:
        if (Lists.isEmpty(((k) r7.b).l()) == true) goto L69;
        this.a = r7.b;
        return;
    L69:
        return;
    L39:
        if (r10.intValue() == r5) goto L44;
    L33:
        if (r4 == r9.intValue()) goto L35;
    L23:
        if (r6 == r8.intValue()) goto L26;
    L11:
        if (r2.intValue() != 3) goto L13;
        r5 = 3;
        goto L19
    L13:
        if (r3 != null) goto L16;
    L18:
        r5 = 1;
        goto L19
    L16:
        if (r3.intValue() != 1) goto L18;
        r5 = 2;
        goto L19
    L61:
        if ((r0 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.g) == false) goto L71;
        IRoom r13 = this.j;
        if (r13 == null) goto L65;
        r13.getOwnerUserIdString();
    L65:
        ((com.bytedance.android.livesdk.ktvimpl.base.sei.g) r7.b).getClass();
        a r14 = this.k;
        if (r14 == null) goto L72;
        r14.i3((com.bytedance.android.livesdk.ktvimpl.base.sei.g) r7.b);
        return;
    L72:
        return;
    }
}
