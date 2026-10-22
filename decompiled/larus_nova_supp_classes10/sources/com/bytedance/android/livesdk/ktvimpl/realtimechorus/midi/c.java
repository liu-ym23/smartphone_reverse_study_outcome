package com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.y;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.b {
    public Disposable a;
    public final List<com.bytedance.android.livesdk.ktvimpl.base.sei.p> b;
    public com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.b c;
    public final d d;
    public final j1 e;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            this.a.c();
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.b
    public final void b() {
        Disposable r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        Disposable r1 = this.a;
        if (r1 != null) goto L10;
    L13:
        this.a = Observable.timer(((Number) KtvSettingHelper.q.getValue()).intValue(), TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this));
        return;
    L10:
        if (r1.isDisposed() == true) goto L12;
        r1.dispose();
    L12:
        this.a = null;
        goto L13
    L5:
        if (r0.isDisposed() == true) goto L7;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.b
    public final void c() {
        if (((ArrayList) this.b).isEmpty() == false) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.b r0 = this.c;
        if (r0 == null) goto L9;
        r0.a(this.b, null, null);
    L9:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L21;
        JSONObject r3 = new JSONObject();
        JSONArray r1 = new JSONArray();
        Iterator<T> r2 = this.b.iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        com.bytedance.android.livesdk.ktvimpl.base.sei.p r4 = (com.bytedance.android.livesdk.ktvimpl.base.sei.p) r2.next();
        JSONObject r5 = new JSONObject();
        r5.put("userId", r4.b());
        r5.put("midi", Float.valueOf(r4.a()));
        r1.put(r5);
        goto L12
    L14:
        r3.put("midiUsers", r1);
        ALogger.d("RTChorusMidiRtsManager", "updateMidiData: " + r3);
        com.bytedance.android.livesdk.chatroom.o r6 = o3.f();
        if (r6 == null) goto L21;
        com.bytedance.live.datacontext.j r7 = r6.getLiveStream();
        if (r7 == null) goto L21;
        com.bytedance.android.live.pushstream.d r8 = (com.bytedance.android.live.pushstream.d) r7.getValue();
        if (r8 == null) goto L21;
        r8.c1("ktv_chorus_midi", r3, 1, false, false);
    L21:
        ((ArrayList) this.b).clear();
    }

    public c(y r2) {
        Intrinsics.checkNotNullParameter(r2, "multiLinkRoomScopeProvider");
        this.e = r2;
        this.b = new ArrayList();
        this.d = new d(this);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.b
    public final void a(String r5, float r6) {
        Intrinsics.checkNotNullParameter(r5, "userId");
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L13
        r2.put("userId", r5);     // Catch: Exception -> L13
        r2.put("midi", Float.valueOf(r6));     // Catch: Exception -> L13
        d(r5, r6);     // Catch: Exception -> L13
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L13
        r7.put("ktv_chorus_midi", r2);     // Catch: Exception -> L13
        ALogger.d("RTChorusMidiRtsManager", "sendMidiMessage: " + r7);     // Catch: Exception -> L13
        cg6.a r8 = this.e.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);     // Catch: Exception -> L13
        if (r8 == null) goto L16;
        hg6.g r9 = r8.getRtcManager();     // Catch: Exception -> L13
        if (r9 == null) goto L17;
        ei6.a r10 = r9.V0();     // Catch: Exception -> L13
        if (r10 == null) goto L18;
        si6.b r0 = r10.b();     // Catch: Exception -> L13
        if (r0 == null) goto L19;
        r0.n(bj6.a.b(r10), r7.toString());     // Catch: Exception -> L13
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public final void d(String r6, float r7) {
        boolean r0 = false;
        if (r6 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return;
    L11:
        Iterator<T> r3 = this.b.iterator();
    L13:
        if (r3.hasNext() == false) goto L17;
        com.bytedance.android.livesdk.ktvimpl.base.sei.p r4 = (com.bytedance.android.livesdk.ktvimpl.base.sei.p) r3.next();
        if (Intrinsics.areEqual(r4.b(), r6) == false) goto L13;
        r4.c(r7);
        r0 = true;
        goto L13
    L17:
        if (r0 == true) goto L25;
        List<com.bytedance.android.livesdk.ktvimpl.base.sei.p> r1 = this.b;
        ArrayList r5 = (ArrayList) r1;
        r5.add(new com.bytedance.android.livesdk.ktvimpl.base.sei.p(r6, r7));
        return;
    L25:
        return;
    L5:
        if (r6.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
