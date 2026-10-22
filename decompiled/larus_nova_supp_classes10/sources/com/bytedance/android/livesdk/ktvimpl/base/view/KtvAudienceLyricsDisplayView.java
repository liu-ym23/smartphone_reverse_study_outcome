package com.bytedance.android.livesdk.ktvimpl.base.view;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.BackpressureStrategy;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/view/KtvAudienceLyricsDisplayView;", "Lcom/bytedance/android/livesdk/ktvimpl/base/view/KtvAnchorLyricsDisplayView;", "", "getAddedLyricsLineByLine", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvAudienceLyricsDisplayView extends KtvAnchorLyricsDisplayView {
    public long K;
    public final HashSet<Integer> L;
    public Disposable M;
    public boolean N;
    public boolean O;
    public final List<a> P;
    public final Subject<Long> Q;
    public Disposable R;

    public interface a {
        void a();
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ KtvAudienceLyricsDisplayView a;

        public b(KtvAudienceLyricsDisplayView r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            KtvAudienceLyricsDisplayView r0 = this.a;
            r0.getClass();
            r0.e(r5.longValue());
            KtvAudienceLyricsDisplayView r1 = this.a;
            r5.longValue();
            Iterator r6 = ((ArrayList) r1.P).iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            ((a) r6.next()).a();
            goto L4
        }
    }

    public static final class c<T> implements Consumer {
        public c(KtvAudienceLyricsDisplayView r1) {
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            String r5 = "lyrics latestOnly consumer error: " + r4.getClass().getSimpleName() + ':' + r4.getMessage();
            ALogger.i(bb0.b.b(), r5 + ", invoke class :KtvAudienceLyricsDisplayView");
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ KtvAudienceLyricsDisplayView a;
        public final /* synthetic */ long b;

        public d(KtvAudienceLyricsDisplayView r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            this.a.K += this.b;
            if (h.N() == false) goto L5;
            this.a.g("timer_tick");
            KtvAudienceLyricsDisplayView r7 = this.a;
            r7.Q.onNext(Long.valueOf(r7.K));
            return;
        L5:
            this.a.k("switch_off");
            KtvAudienceLyricsDisplayView r8 = this.a;
            r8.e(r8.K);
            KtvAudienceLyricsDisplayView r9 = this.a;
            long r0 = r9.K;
            Iterator r10 = ((ArrayList) r9.P).iterator();
        L7:
            if (r10.hasNext() == false) goto L11;
            ((a) r10.next()).a();
            goto L7
        }
    }

    public KtvAudienceLyricsDisplayView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvAudienceLyricsDisplayView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void h() {
        this.d = false;
        this.c = 0;
        this.b = 0;
        this.n = 0;
        Iterator r0 = ((LinkedHashMap) this.a).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Function1) ((Map.Entry) r0.next()).getValue()).invoke(0L);
        goto L4
    L6:
        this.e.clear();
        Disposable r1 = this.M;
        if (r1 == null) goto L9;
        r1.dispose();
    L9:
        this.M = null;
        k("release");
        getLyricsLineInfos().clear();
        this.L.clear();
        this.K = 0;
        this.N = true;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.view.KtvAnchorLyricsDisplayView
    public int getAddedLyricsLineByLine() {
        if (this.L.isEmpty() == false) goto L6;
        return 0;
    L6:
        return getLyricsLineInfos().size();
    }

    public final void j() {
        Disposable r0 = this.M;
        if (r0 == null) goto L9;
        if (r0.isDisposed() == true) goto L9;
        return;
    L9:
        if (h.N() == false) goto L11;
        long r1 = h.K();
    L12:
        this.M = du2.a.b(0, r1, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r1));
        return;
    L11:
        r1 = 33;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.view.KtvAnchorLyricsDisplayView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable r0 = this.M;
        if (r0 != null) goto L5;
    L11:
        k("detach");
        this.M = null;
        this.R = null;
        return;
    L5:
        if (r0.isDisposed() == true) goto L11;
        if (((Boolean) h.N3.getValue(null, h.a[246(0xf6, float:3.45E-43)])).booleanValue() != true) goto L11;
        Disposable r1 = this.M;
        if (r1 == null) goto L11;
        r1.dispose();
        goto L11
    }

    public final void g(String r8) {
        if (h.N() == true) goto L6;
        k("switch_off");
        return;
    L6:
        Disposable r0 = this.R;
        if (r0 != null) goto L9;
    L11:
        this.R = this.Q.toFlowable(BackpressureStrategy.LATEST).onBackpressureLatest().throttleLatest(h.K(), TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread(), true).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), new c(this));
        String r9 = "lyrics latestOnly consumer start:".concat(r8);
        ALogger.i(bb0.b.b(), r9 + ", invoke class :KtvAudienceLyricsDisplayView");
        return;
    L9:
        if (r0.isDisposed() == true) goto L11;
    }

    public final void i(int r4) {
        String r1 = bb0.b.b();
        ALogger.i(r1, ("sendCommand:" + r4) + ", invoke class :KtvAudienceLyricsDisplayView");
        if (r4 == 0) goto L21;
        if (r4 != 3) goto L7;
        this.O = false;
        h();
        j();
        return;
    L7:
        if (r4 != 4) goto L9;
        this.O = true;
        Disposable r5 = this.M;
        if (r5 == null) goto L18;
        r5.dispose();
    L18:
        this.M = null;
        k("song_pause");
        return;
    L9:
        if (r4 != 5) goto L11;
        this.O = false;
        j();
        return;
    L11:
        if (r4 != 6) goto L29;
        h();
        invalidate();
        return;
    L29:
        return;
    L21:
        if (this.O == true) goto L28;
        j();
        return;
    }

    public final void k(String r3) {
        Disposable r0 = this.R;
        if (r0 != null) goto L5;
    L10:
        this.R = null;
        return;
    L5:
        if (r0.isDisposed() == true) goto L10;
        Disposable r1 = this.R;
        if (r1 == null) goto L9;
        r1.dispose();
    L9:
        String r4 = "lyrics latestOnly consumer stop:".concat(r3);
        ALogger.i(bb0.b.b(), r4 + ", invoke class :KtvAudienceLyricsDisplayView");
        goto L10
    }

    public KtvAudienceLyricsDisplayView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.L = new HashSet();
        this.N = true;
        this.P = new ArrayList();
        this.Q = PublishSubject.create().toSerialized();
        ((Boolean) h.L3.getValue(null, h.a[244(0xf4, float:3.42E-43)])).booleanValue();
    }

    public final void f(int r21, com.bytedance.component.lyric.model.b r22, long r23) {
        Intrinsics.checkNotNullParameter(r22, "lyricsLineInfo");
        if (getHasAddedFullLyrics() == false) goto L5;
        return;
    L5:
        if (this.L.contains(Integer.valueOf(r21)) == true) goto L127;
        Intrinsics.checkNotNullParameter(r22, "lyricsLineInfo");
        String r2 = r22.d;
        Paint r3 = new Paint();
        if (this.u != 0.0f) goto L13;
        if (getMeasuredWidth() <= 0) goto L13;
        setOneLineMaxWidth(getMeasuredWidth());
    L15:
        r3.setTextSize(this.f.getTextSize() * 1.1f);
        float r4 = this.u - r3.measureText("   ");
        int r5 = getAddedLyricsLineByLine();
        if (r3.measureText(r2) > r4) goto L18;
    L90:
        int r6 = this.c + 1;
        this.c = r6;
        if (r5 >= r6) goto L93;
        this.e.add(r22);
    L93:
        this.L.add(Integer.valueOf(r21));
        this.K = r23;
        System.currentTimeMillis();
        if (getConfig().o == 4) goto L96;
        boolean r1 = true;
    L97:
        if (r1 == true) goto L99;
        return;
    L99:
        if (this.N == true) goto L101;
        return;
    L101:
        if (getLyricsLineInfos().size() > 0) goto L103;
    L105:
        boolean r7 = false;
    L106:
        this.N = r7;
        return;
    L103:
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), 0)).b <= 3000) goto L105;
        com.bytedance.component.lyric.model.b r8 = new com.bytedance.component.lyric.model.b();
        r8.h = true;
        r8.b = ((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), 0)).b - 3000;
        r8.d = "...";
        r8.f = new String[]{".", ".", "."};
        r8.g = new int[]{1000, 1000, 1000};
        r7 = false;
        ListProtector.add(getLyricsLineInfos(), 0, r8);
        setCurToAddLineIndex(getCurToAddLineIndex() + 1);
        goto L106
    L96:
        r1 = false;
        goto L97
    L18:
        if (r22.h == true) goto L90;
        int r9 = this.m;
        if (r9 != 2) goto L38;
        com.bytedance.component.lyric.model.b r10 = new com.bytedance.component.lyric.model.b();
        com.bytedance.component.lyric.model.b r11 = new com.bytedance.component.lyric.model.b();
        StringBuilder r12 = new StringBuilder();
        StringBuilder r13 = new StringBuilder();
        StringBuilder r14 = new StringBuilder();
        String r15 = r22.d;
        if (r15 == null) goto L93;
        int r16 = r15.length();
        int r17 = 0;
    L25:
        if (r17 >= r16) goto L31;
        char r18 = r15.charAt(r17);
        r12.append(r18);
        if (r3.measureText(r12.toString()) <= r4) goto L29;
        r14.append(r18);
    L30:
        r17 = r17 + 1;
        goto L25
    L29:
        r13.append(r18);
        goto L30
    L31:
        r10.b = r22.b;
        r10.d = r13.toString();
        int r19 = this.c + 1;
        this.c = r19;
        if (r5 >= r19) goto L34;
        this.e.add(r10);
    L34:
        r11.b = r22.b + 4000;
        r11.d = r14.toString();
        int r20 = this.c + 1;
        this.c = r20;
        if (r5 >= r20) goto L93;
        this.e.add(r11);
        goto L93
    L38:
        if (r9 != 3) goto L93;
        com.bytedance.component.lyric.model.b r24 = new com.bytedance.component.lyric.model.b();
        com.bytedance.component.lyric.model.b r25 = new com.bytedance.component.lyric.model.b();
        StringBuilder r26 = new StringBuilder();
        String[] r27 = r22.f;
        if (r27 == null) goto L93;
        ArrayList r110 = new ArrayList();
        ArrayList r111 = new ArrayList();
        ArrayList r112 = new ArrayList();
        StringBuilder r113 = new StringBuilder();
        StringBuilder r114 = new StringBuilder();
        ArrayList r115 = new ArrayList();
        int r28 = r22.b;
        int r29 = r27.length;
        int r30 = r28;
        int r31 = 0;
    L42:
        if (r31 >= r29) goto L56;
        int r116 = r29;
        String r32 = r27[r31];
        r26.append(r32);
        String[] r117 = r27;
        if (r3.measureText(r26.toString()) <= r4) goto L50;
        r112.add(r32);
        r114.append(r32);
        int[] r33 = r22.g;
        if (r33 == null) goto L55;
        if (r31 >= r33.length) goto L55;
        r115.add(Integer.valueOf(r33[r31]));
    L55:
        r31 = r31 + 1;
        r29 = r116;
        r27 = r117;
        goto L42
    L50:
        r110.add(r32);
        r113.append(r32);
        int[] r34 = r22.g;
        if (r34 == null) goto L55;
        if (r31 >= r34.length) goto L55;
        r111.add(Integer.valueOf(r34[r31]));
        r30 = r30 + r34[r31];
        goto L55
    L56:
        r24.b = r22.b;
        Object[] r35 = r110.toArray(new String[0]);
        if (r35 == null) goto L89;
        r24.f = (String[]) r35;
        r24.g = new int[r111.size()];
        int r36 = r111.size();
        int r37 = 0;
    L59:
        if (r37 >= r36) goto L65;
        int[] r38 = r24.g;
        if (r38 == null) goto L63;
        r38[r37] = ((Number) ListProtector.get(r111, r37)).intValue();
    L63:
        r37 = r37 + 1;
        goto L59
    L65:
        if (this.H == false) goto L71;
        String r39 = r113.toString();
        if (r39 == null) goto L70;
        r24.d = StringsKt.trim(r39).toString();
    L72:
        int r40 = this.c + 1;
        this.c = r40;
        if (r5 >= r40) goto L75;
        this.e.add(r24);
    L75:
        r25.b = r30;
        Object[] r41 = r112.toArray(new String[0]);
        if (r41 == null) goto L87;
        r25.f = (String[]) r41;
        r25.g = new int[r115.size()];
        int r42 = r115.size();
        int r43 = 0;
    L78:
        if (r43 >= r42) goto L83;
        int[] r44 = r25.g;
        if (r44 == null) goto L82;
        r44[r43] = ((Number) ListProtector.get(r115, r43)).intValue();
    L82:
        r43 = r43 + 1;
        goto L78
    L83:
        r25.d = r114.toString();
        int r45 = this.c + 1;
        this.c = r45;
        if (r5 >= r45) goto L93;
        this.e.add(r25);
        goto L93
    L87:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L70:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L71:
        r24.d = r113.toString();
        goto L72
    L89:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L13:
        if (this.u != 0.0f) goto L15;
        setOneLineMaxWidth(t6.a(getContext(), 240.0f));
        goto L15
    }

    public /* synthetic */ KtvAudienceLyricsDisplayView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
