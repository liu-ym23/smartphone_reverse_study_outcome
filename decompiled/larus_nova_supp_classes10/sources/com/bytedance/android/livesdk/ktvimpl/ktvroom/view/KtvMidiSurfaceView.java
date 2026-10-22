package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.model.api.g0;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001*B\u001b\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016RT\u0010\u001b\u001a4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010#\u001a\u00020\u001c8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/KtvMidiSurfaceView;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/KtvHwDrawBaseSurfaceView;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/b;", "Lcom/bytedance/android/live/ktv/common/model/api/g0;", "config", "", "setConfig", "Lcom/bytedance/android/live/ktv/common/midi/g;", "strategy", "setPerformStrategy", "", "visibility", "setVisibility", "setContainerVisibility", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isTimeOut", "", "timeStamp", "n", "Lkotlin/jvm/functions/Function2;", "getOneDrawCallback", "()Lkotlin/jvm/functions/Function2;", "setOneDrawCallback", "(Lkotlin/jvm/functions/Function2;)V", "oneDrawCallback", "", "o", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "setTypeName", "(Ljava/lang/String;)V", "typeName", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvMidiSurfaceView extends KtvHwDrawBaseSurfaceView implements b {
    public final v i;
    public final s j;
    public com.bytedance.android.live.ktv.common.midi.g k;
    public com.bytedance.android.live.ktv.common.midi.f l;
    public final List<com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a> m;
    public Function2<? super Boolean, ? super Long, Unit> n;
    public String o;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final View asView() {
        return this;
    }

    public final String name() {
        return "KtvMidiSurfaceView";
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public void setConfig(g0 r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final void A1() {
        this.j.c = false;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final void onDetach() {
        this.k.clear();
        Iterator<T> r0 = this.m.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a) r0.next()).e();
        goto L4
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final void reset() {
        s r0 = this.j;
        r0.a = -1;
        r0.d = 0;
        r0.c = false;
        Float r2 = Float.valueOf(0.0f);
        r0.b = new Pair(r2, r2);
        Iterator<T> r1 = this.m.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a) r1.next()).f();
        goto L4
    }

    public Function2<Boolean, Long, Unit> getOneDrawCallback() {
        return this.n;
    }

    public String getTypeName() {
        return this.o;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final void R2(long r3) {
        Iterator<T> r0 = this.m.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a) r0.next()).g(r3);
        goto L4
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.KtvHwDrawBaseSurfaceView
    public final void e(Canvas r5) {
        if (r5 == null) goto L11;
        Iterator<T> r0 = this.m.iterator();
    L5:
        if (r0.hasNext() == false) goto L18;
        ((com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a) r0.next()).a(r5);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        ALogger.e("KtvMidiSurfaceView", "onSurfaceDraw Exception " + Log.getStackTraceString(e));
        goto L5
    L18:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final void qc(com.bytedance.android.live.ktv.common.midi.f r4) {
        Intrinsics.checkNotNullParameter(r4, "strategy");
        this.l = r4;
        if (r4 == null) goto L8;
        Iterator<T> r1 = this.m.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a r2 = (com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a) r1.next();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "strategy");
        r2.c = r4;
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public void setContainerVisibility(int r1) {
        setVisibility(r1);
    }

    public void setOneDrawCallback(Function2<? super Boolean, ? super Long, Unit> r1) {
        this.n = r1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public void setPerformStrategy(com.bytedance.android.live.ktv.common.midi.g r4) {
        Intrinsics.checkNotNullParameter(r4, "strategy");
        this.k = r4;
        Iterator r5 = ((ArrayList) this.m).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a r1 = (com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a) r5.next();
        com.bytedance.android.live.ktv.common.midi.g r2 = this.k;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "strategy");
        r1.d = r2;
        goto L4
    }

    public void setTypeName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.o = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setVisibility(int r2) {
        super/*android.view.SurfaceView*/.setVisibility(r2);
        Iterator<T> r3 = this.m.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a) r3.next()).getClass();
        goto L4
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final void xc(Pair<Integer, Integer> r4) {
        if (r4 == null) goto L5;
        v r0 = this.i;
        int r1 = ((Number) r4.getFirst()).intValue();
        int r5 = ((Number) r4.getSecond()).intValue();
        r0.g = r1;
        r0.h = r5;
        r0.i = r0.d / (r5 - r1);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final void y(MidiSkinDressInfo r4) {
        Iterator<T> r0 = this.m.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a r1 = (com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a) r0.next();
        this.k.y(r4);
        r1.h(r4);
        goto L4
    }

    public KtvMidiSurfaceView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.i = new v();
        this.j = new s();
        this.k = new com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.a();
        ArrayList r4 = new ArrayList();
        r4.add(new KtvMidiLineRender());
        r4.add(new j());
        r4.add(new p());
        r4.add(new i());
        Unit r5 = Unit.INSTANCE;
        this.m = r4;
        c();
        this.o = "midi";
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final void Gk(db0.a r5, com.bytedance.android.live.ktv.common.midi.g r6) {
        Intrinsics.checkNotNullParameter(r5, "model");
        if (this.l != null) goto L5;
        return;
    L5:
        if (this.k.getCurrentMode() != 1) goto L7;
        v r7 = this.i;
        r7.j = 1000;
        r7.k = 2500;
        r7.l = 3500;
        float r0 = r7.a / 3500;
        r7.m = r0;
        r7.n = (int) (r7.b / (r0 * 2.0f));
    L8:
        Iterator r8 = ((ArrayList) this.m).iterator();
    L10:
        if (r8.hasNext() == false) goto L14;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a r1 = (com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a) r8.next();
        v r2 = this.i;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "toneMapHelper");
        r1.f = r2;
        s r3 = this.j;
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        r1.j = r3;
        com.bytedance.android.live.ktv.common.midi.g r4 = this.k;
        Intrinsics.checkNotNullParameter(r4, "strategy");
        r1.d = r4;
        r1.d(r5);
        goto L10
    L14:
        return;
    L7:
        v r9 = this.i;
        r9.j = 1360;
        r9.k = 3470;
        r9.l = 4830;
        float r10 = r9.a / 4830;
        r9.m = r10;
        r9.n = (int) (r9.b / (r10 * 2.0f));
        goto L8
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final void F9(com.bytedance.android.live.ktv.common.midi.k r3, Long r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "scoreInfo");
        Iterator r0 = ((ArrayList) this.m).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a) r0.next()).b(r3, r4, r5);
        goto L4
    }

    public final void surfaceChanged(SurfaceHolder r1, int r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "holder");
        Intrinsics.checkNotNullParameter(r1, "holder");
        Function2<Boolean, Long, Unit> r5 = getOneDrawCallback();
        if (r5 == null) goto L6;
        Unit r6 = (Unit) r5.invoke(Boolean.FALSE, Long.valueOf(System.currentTimeMillis()));
        return;
    }
}
