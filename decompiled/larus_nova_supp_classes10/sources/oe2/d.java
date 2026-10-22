package oe2;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.sei.w;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements com.bytedance.android.livesdk.ktvimpl.base.sei.c {
    public boolean a;
    public final KtvContext b;
    public final com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.h c;
    public final MutableLiveData<e> d;
    public final MutableLiveData e;

    public static final class a<T> implements Observer {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            e r5 = (e) r4;
            if (r5 != null) goto L6;
            return;
        L6:
            if (this.a.b.isCurrentUserIsSinger() == false) goto L8;
            return;
        L8:
            if (Intrinsics.areEqual(r5.a(), "Singing") == false) goto L27;
            o r0 = o3.f();
            Object r1 = null;
            if (r0 == null) goto L12;
            DataCenter r2 = r0.getDataCenter();
        L13:
            if (r2 == null) goto L16;
            r1 = r2.get("audio_ktv_sei_model");
        L16:
            if (vm2.d.q0().isFeedInfoTransport() == false) goto L24;
            d r3 = this.a;
            if (r3.a == true) goto L23;
            if (r1 == null) goto L23;
            if ((r1 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == false) goto L23;
            r3.a = false;
            return;
        L23:
            r3.c.e.setValue(Long.valueOf(r5.b()));
            return;
        L24:
            this.a.c.e.setValue(Long.valueOf(r5.b()));
            return;
        L12:
            r2 = null;
            goto L13
        }
    }

    public static final class b {
    }

    static {
    }

    public d() {
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        this.b = r0;
        this.c = r0.getLyricResourceManager();
        MutableLiveData<e> r1 = new MutableLiveData();
        r1.setValue(new e(KtvRoomLyricsStateMachineConfig.d.a.b.a, com.bytedance.android.livesdk.utils.ntp.e.a()));
        Unit r2 = Unit.INSTANCE;
        this.d = r1;
        this.e = r1;
        r1.observeForever(new a(this));
    }

    public final void a(KtvRoomLyricsStateMachineConfig.d r10) {
        Intrinsics.checkNotNullParameter(r10, "newState");
        if ((r10 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L6;
        KtvRoomLyricsStateMachineConfig.d.f r0 = (KtvRoomLyricsStateMachineConfig.d.f) r10;
        String r3 = r10.a;
        KtvContext.Companion.getClass();
        e r8 = new e(r3, KtvContext.a.f(null), r0.d.a);
    L9:
        this.d.setValue(r8);
        return;
    L6:
        if ((r10 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L8;
        KtvRoomLyricsStateMachineConfig.d.C0041d r1 = (KtvRoomLyricsStateMachineConfig.d.C0041d) r10;
        String r4 = r10.a;
        KtvContext.Companion.getClass();
        r8 = new e(r4, KtvContext.a.f(null), r1.c.a);
        goto L9
    L8:
        String r11 = r10.a;
        KtvContext.Companion.getClass();
        r8 = new e(r11, KtvContext.a.f(null));
        goto L9
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final boolean accept(w r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        return r2.b instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final void onSeiResult(w r3) {
        Intrinsics.checkNotNullParameter(r3, "result");
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r4 = r3.b;
        e r1 = null;
        if ((r4 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == true) goto L5;
        r4 = null;
    L5:
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r5 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r4;
        if (r5 == null) goto L15;
        e r6 = r5.k();
        if (r6 != null) goto L10;
        return;
    L10:
        if ((!r6.equals(this.d.getValue())) == false) goto L12;
        r1 = r6;
    L12:
        if (r1 == null) goto L17;
        this.d.setValue(r1);
        return;
    L17:
        return;
    }
}
