package com.bytedance.android.livesdk.ktvimpl.base;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.widget.HolderRoomScopeWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/MidiScoreDebugWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/base/widget/HolderRoomScopeWidget;", "<init>", "()V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MidiScoreDebugWidget extends HolderRoomScopeWidget {
    public float d;
    public float e;
    public int f;
    public int g;
    public float h;
    public RecyclerView i;
    public final ScoreListAdapter j;
    public final CompositeDisposable k;
    public final Map<Integer, Float> l;
    public LinearLayout m;

    public static final class a implements View.OnTouchListener {
        public final /* synthetic */ MidiScoreDebugWidget a;

        public a(MidiScoreDebugWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r6, MotionEvent r7) {
            int r8 = r7.getAction();
            ViewGroup.LayoutParams r2 = null;
            if (r8 != 0) goto L5;
            MidiScoreDebugWidget r9 = this.a;
            r9.d = r7.getRawX();
            MidiScoreDebugWidget r10 = this.a;
            r10.e = r7.getRawY();
            LinearLayout r11 = this.a.m;
            if (r11 == null) goto L21;
            r2 = r11.getLayoutParams();
        L21:
            if (r2 == null) goto L25;
            FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r2;
            MidiScoreDebugWidget r12 = this.a;
            r12.f = r3.leftMargin;
            r12.g = r3.topMargin;
            return true;
        L25:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        L5:
            if (r8 == 2) goto L8;
            return false;
        L8:
            int r13 = (int) (r7.getRawX() - this.a.d);
            float r14 = r7.getRawY();
            MidiScoreDebugWidget r4 = this.a;
            int r15 = (int) (r14 - r4.e);
            LinearLayout r5 = r4.m;
            if (r5 == null) goto L11;
            r2 = r5.getLayoutParams();
        L11:
            if (r2 == null) goto L17;
            FrameLayout.LayoutParams r16 = (FrameLayout.LayoutParams) r2;
            MidiScoreDebugWidget r0 = this.a;
            r16.leftMargin = r0.f + r13;
            r16.topMargin = r0.g + r15;
            LinearLayout r17 = r0.m;
            if (r17 == null) goto L15;
            r17.setLayoutParams(r16);
        L15:
            return true;
        L17:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MidiScoreDebugWidget a;

        public b(MidiScoreDebugWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r11) {
            p r12 = (p) r11;
            if (r12 == null) goto L49;
            MidiScoreDebugWidget r0 = this.a;
            float r1 = r12.a;
            float r2 = r12.n;
            float r3 = r12.p;
            r0.getClass();
            Double r4 = (Double) ArraysKt.getOrNull(vm2.h.Z(), 0);
            if (r4 == null) goto L8;
            float r5 = (float) r4.doubleValue();
        L9:
            Double r6 = (Double) ArraysKt.getOrNull(vm2.h.Z(), 1);
            float r7 = 0.1f;
            if (r6 == null) goto L12;
            float r8 = (float) r6.doubleValue();
        L13:
            Double r9 = (Double) ArraysKt.getOrNull(vm2.h.Z(), 2);
            if (r9 == null) goto L16;
            r7 = (float) r9.doubleValue();
        L16:
            float r10 = (((r1 * r5) + (r2 * r8)) + (r3 * r7)) * ((Number) KtvSettingHelper.x0.getValue()).floatValue();
            float r13 = 100.0f;
            if (r10 <= 100.0f) goto L19;
            r10 = 100.0f;
        L19:
            MidiScoreDebugWidget r14 = this.a;
            r14.getClass();
            Double r15 = (Double) ArraysKt.getOrNull(vm2.h.Z(), 0);
            if (r15 == null) goto L22;
            r15.doubleValue();
        L22:
            Double r16 = (Double) ArraysKt.getOrNull(vm2.h.Z(), 1);
            if (r16 == null) goto L25;
            r16.doubleValue();
        L25:
            Double r17 = (Double) ArraysKt.getOrNull(vm2.h.Z(), 2);
            if (r17 == null) goto L28;
            r17.doubleValue();
        L28:
            int r18 = r12.l;
            if (jc0.a.c() == true) goto L46;
            if (r18 < 0) goto L46;
            r14.l.put(Integer.valueOf(r18), Float.valueOf(r10));
            Iterator<T> r19 = ((LinkedHashMap) r14.l).values().iterator();
            float r20 = 0.0f;
        L35:
            if (r19.hasNext() == false) goto L38;
            r20 = r20 + ((Number) r19.next()).floatValue();
            goto L35
        L38:
            if (r14.l.isEmpty() == false) goto L40;
            int r21 = 1;
        L41:
            float r22 = r20 / r21;
            if (r22 > 100.0f) goto L45;
            r13 = r22;
        L45:
            r14.h = r13;
            r10 = r13;
            goto L46
        L40:
            r21 = r14.l.size();
        L46:
            r14.h = r10;
            List<q> r110 = CollectionsKt.listOf(new q[]{new q("演唱句索引:", r12.l, true), new q("总积分:", this.a.h, true), new q("音准打分(句):", r12.a, false), new q("情感打分(句):", r12.n, false), new q("节奏打分(句):", r12.p, false), new q("音准打分(整):", r12.b, false), new q("情感打分(整):", r12.o, false), new q("节奏打分(整):", r12.q, false)});
            MidiScoreDebugWidget r23 = this.a;
            r23.getClass();
            Intrinsics.checkNotNullParameter(r110, "items");
            ScoreListAdapter r24 = r23.j;
            r24.getClass();
            Intrinsics.checkNotNullParameter(r110, "newItems");
            r24.a = r110;
            r24.notifyDataSetChanged();
            return;
        L12:
            r8 = 0.1f;
            goto L13
        L8:
            r5 = 0.8f;
            goto L9
        }
    }

    public final int getLayoutId() {
        return 2131566500;
    }

    public MidiScoreDebugWidget() {
        this.j = new ScoreListAdapter(CollectionsKt.emptyList());
        this.k = new CompositeDisposable();
        this.l = new LinkedHashMap();
    }

    public final void onCreate() {
        super/*com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget*/.onCreate();
        LinearLayout r0 = (LinearLayout) findViewById(2131385172);
        this.m = r0;
        if (r0 == null) goto L5;
        r0.setOnTouchListener(new a(this));
    L5:
        RecyclerView r1 = findViewById(2131384071);
        this.i = r1;
        if (r1 == null) goto L8;
        r1.setLayoutManager(new LinearLayoutManager(((Widget) this).context));
    L8:
        RecyclerView r2 = this.i;
        if (r2 == null) goto L11;
        r2.addItemDecoration(new DividerItemDecoration(((Widget) this).context, 1));
    L11:
        RecyclerView r3 = this.i;
        if (r3 == null) goto L14;
        r3.setAdapter(this.j);
    L14:
        KtvContext.Companion.getClass();
        Disposable r4 = KtvContext.a.g().getRealTimeInfoModel().a().subscribe(new b(this));
        if (r4 == null) goto L18;
        RxUtilKt.c(r4, this.k);
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        this.k.clear();
    }
}
