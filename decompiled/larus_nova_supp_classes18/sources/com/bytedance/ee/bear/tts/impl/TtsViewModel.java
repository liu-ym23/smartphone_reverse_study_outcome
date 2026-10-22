package com.bytedance.ee.bear.tts.impl;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import com.bytedance.ee.bear.permission.model.DocUserPermissions;
import com.bytedance.ee.bear.tts.TtsDataSource;
import com.bytedance.ee.bear.tts.TtsLoadScene;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.bear.tts.impl.model.TtsM3U8Model;
import com.bytedance.ee.bear.tts.impl.model.TtsMetaModel;
import com.bytedance.ee.bear.tts.impl.model.TtsPermissionModel;
import com.bytedance.ee.bear.tts.impl.model.TtsPlaybackModel;
import com.bytedance.ee.bear.tts.impl.model.TtsToneModel;
import com.bytedance.ee.bear.tts.m3u8.TtsM3U8Bean;
import com.bytedance.ee.bear.tts.meta.TtsMetaBean;
import com.bytedance.ee.bear.tts.operation.TtsOperationQueue;
import com.bytedance.ee.bear.tts.tone.TtsToneBean;
import com.bytedance.ee.bear.tts.tone.TtsToneListBean;
import com.bytedance.ee.bear.widgets.lottie.CCMLottieRes;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class TtsViewModel implements mo5.g {
    public static int E;
    public Deferred<TtsResult> A;
    public Deferred<TtsResult> B;
    public final String C;
    public final to5.a D;
    public final String a;
    public final int b;
    public final Lazy c;
    public final String d;
    public final CCMLottieRes e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final MutableLiveData<mo5.j> j;
    public final MutableLiveData<IPlayer.State> k;
    public final MutableLiveData<Long> l;
    public final MutableLiveData<qo5.b> m;
    public final MutableLiveData<Float> n;
    public final MutableLiveData<Long> o;
    public final MutableLiveData<Pair<Long, Long>> p;
    public final MutableLiveData<List<TtsToneBean>> q;
    public final MutableLiveData<TtsToneBean> r;
    public final MutableLiveData<TtsLoadScene> s;
    public final to5.a t;
    public final TtsM3U8Model u;
    public final TtsMetaModel v;
    public final TtsPermissionModel w;
    public final TtsPlaybackModel x;
    public final TtsToneModel y;
    public IPlayer z;

    public static final class a implements Runnable {
        public final /* synthetic */ TtsViewModel a;

        public a(TtsViewModel r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TtsViewModel r0 = this.a;     // Catch: Throwable -> L4
            r0.j.setValue(TtsViewModel.x(r0));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b {
    }

    public final class c implements sf5.b {
        public final /* synthetic */ TtsViewModel a;

        @Override // sf5.b
        public final void a() {
        }

        public c(TtsViewModel r1) {
            this.a = r1;
        }

        @Override // sf5.b
        public final void b(String r18) {
            TtsViewModel r2 = this.a;
            TtsM3U8Model r3 = r2.u;
            TtsM3U8Bean r0 = r3.c;
            if (r0 == null) goto L5;
            r0.rawContent = r18;
        L5:
            StringBuilder r1 = new StringBuilder("decodeM3U8, rawM3U8: ");
            TtsM3U8Bean r4 = r3.c;
            TtsM3U8Bean r5 = null;
            if (r4 == null) goto L8;
            String r6 = r4.rawContent;
        L9:
            r1.append(r6);
            tt5.a.b("TtsM3U8Model", r1.toString());
            ((ArrayList) r3.f).clear();
            TtsM3U8Bean r7 = r3.c;
            boolean r8 = false;
            if (r7 == null) goto L115;
            String r9 = r7.rawContent;
            if (r9 == null) goto L115;
            int r10 = 1;
            if (r9.length() <= 0) goto L16;
            boolean r11 = true;
        L17:
            if (r11 == false) goto L19;
            String r12 = r9;
        L20:
            if (r12 == null) goto L115;
            List r13 = StringsKt.split$default(r12, new String[]{"\n"}, false, 0, 6, null);
            if ((!r13.isEmpty()) == true) goto L26;
            r13 = null;
        L26:
            if (r13 != null) goto L28;
            tt5.a.k("TtsM3U8Model", "decodeM3U8, rawM3U8 split result is empty.");
            r3.d(false);
        L116:
            long r14 = r3.c();
            so5.a r15 = r2.x.d;
            if (r15 == null) goto L119;
            r15.i = r14;
        L119:
            r2.o.setValue(Long.valueOf(r14));
            MutableLiveData<Pair<Long, Long>> r16 = r2.p;
            TtsM3U8Bean r17 = r3.c;
            if (r17 == null) goto L122;
            Pair r19 = new Pair(Long.valueOf(r17.segmentFirstOffsetMs), Long.valueOf(r17.segmentSumDurationMs));
        L123:
            r16.setValue(r19);
            to5.a r20 = r2.t;
            TtsM3U8Bean r21 = r3.c;
            if (r21 == null) goto L126;
            r5 = r21.clone();
        L126:
            r20.d = r5;
            return;
        L122:
            r19 = new Pair(0L, 0L);
            goto L123
        L28:
            qo5.b r22 = new qo5.b();
            Iterator r110 = r13.iterator();
        L30:
            if (r110.hasNext() == false) goto L114;
            String r111 = (String) r110.next();
            tt5.a.b("TtsM3U8Model", "decodeM3U8, eachLine: " + r111);
            if (StringsKt.trim(r111).toString().length() != 0) goto L34;
            boolean r23 = true;
        L35:
            if (r23 == false) goto L38;
        L36:
            r110 = r110;
        L112:
            r110 = r110;
            r10 = 1;
            goto L30
        L38:
            if (StringsKt.startsWith$default(r111, "#EXT-X-LARK-INF", false, 2, null) == false) goto L88;
            Intrinsics.checkNotNullParameter(r111, "blockInfoStr");
            Matcher r24 = qo5.b.f.matcher(r111);     // Catch: Exception -> L44
            if (r24.find() == false) goto L128;
            r22.a = r24.group(r10);     // Catch: Exception -> L44
        L128:
            Matcher r25 = qo5.b.g.matcher(r111);     // Catch: Exception -> L56
            if (r25.find() == false) goto L136;
            String r26 = r25.group(r10);     // Catch: Exception -> L56
            if (r26 == null) goto L53;
            Integer r27 = StringsKt.toIntOrNull(r26);     // Catch: Exception -> L56
            if (r27 == null) goto L53;
            int r28 = r27.intValue();     // Catch: Exception -> L56
        L54:
            r22.b = r28;     // Catch: Exception -> L56
        L53:
            r28 = 0;
        L136:
            Matcher r29 = qo5.b.h.matcher(r111);     // Catch: Exception -> L66
            if (r29.find() == false) goto L68;
            String r30 = r29.group(r10);     // Catch: Exception -> L66
            if (r30 == null) goto L68;
            Integer r31 = StringsKt.toIntOrNull(r30);     // Catch: Exception -> L66
            if (r31 == null) goto L68;
            int r112 = r31.intValue();     // Catch: Exception -> L66
        L130:
            Matcher r32 = qo5.b.i.matcher(r111);     // Catch: Exception -> L77
            if (r32.find() == false) goto L79;
            String r33 = r32.group(r10);     // Catch: Exception -> L77
            if (r33 == null) goto L79;
            Integer r34 = StringsKt.toIntOrNull(r33);     // Catch: Exception -> L77
            if (r34 == null) goto L79;
            int r35 = r34.intValue();     // Catch: Exception -> L77
        L80:
            r22.c = new Pair(Integer.valueOf(r112), Integer.valueOf(r35));
            Matcher r36 = qo5.b.j.matcher(r111);     // Catch: Exception -> L85
            if (r36.find() == false) goto L36;
            r22.d = r36.group(r10);     // Catch: Exception -> L85
        L85:
            e = move-exception;
            tt5.a.e("TtsM3U8Segment", "decodeBlockInfo, error when decoding blockParentId:", e, false);
            r22.d = null;
        L79:
            r35 = 0;
        L77:
            e = move-exception;
            tt5.a.e("TtsM3U8Segment", "decodeBlockInfo, error when decoding blockRangeEnd:", e, false);
        L68:
            r112 = 0;
        L66:
            e = move-exception;
            tt5.a.e("TtsM3U8Segment", "decodeBlockInfo, error when decoding blockRangeStart:", e, false);
        L56:
            e = move-exception;
            tt5.a.e("TtsM3U8Segment", "decodeBlockInfo, error when decoding blockVer:", e, false);
            r22.b = 0;
        L44:
            e = move-exception;
            tt5.a.e("TtsM3U8Segment", "decodeBlockInfo, error when decoding blockId:", e, false);
            r22.a = null;
            goto L128
        L88:
            if (StringsKt.startsWith$default(r111, "#EXTINF", false, 2, null) == false) goto L106;
            Intrinsics.checkNotNullParameter(r111, "extInfoStr");
            Matcher r37 = qo5.b.k.matcher(r111);     // Catch: Exception -> L103
            if (r37.find() == false) goto L36;
            String r38 = r37.group(r10);     // Catch: Exception -> L103
            if (r38 == null) goto L98;
            Double r39 = StringsKt.toDoubleOrNull(r38);     // Catch: Exception -> L103
            if (r39 == null) goto L98;
            long r113 = (long) (r39.doubleValue() * ((double) CCMLynxCardView.ViewType.BANNER));
        L138:
            r22.e = r113;     // Catch: Exception -> L101
        L101:
            e = e;
        L105:
            tt5.a.e("TtsM3U8Segment", "decodeExtInfo, error when decoding ExtInf:", e, false);
            r22.e = 0;
        L98:
            r113 = 0;
        L103:
            e = e;
            r110 = r110;
            goto L105
        L106:
            r110 = r110;
            if (Intrinsics.areEqual(StringsKt.trim(r111).toString(), "#EXT-X-ENDLIST") == true) goto L108;
            if (StringsKt.startsWith$default(r111, "#", false, 2, null) == false) goto L113;
            tt5.a.b("TtsM3U8Model", "decodeM3U8, unknown tag found: " + r111);
            goto L112
        L113:
            Intrinsics.checkNotNullParameter(r111, ResourceData.KEY_URL);
            StringsKt.trim(r111).toString();
            ((ArrayList) r3.f).add(r22);
            r22 = new qo5.b();
            goto L112
        L108:
            ((ArrayList) r3.f).add(r22);
            r8 = true;
            goto L114
        L34:
            r23 = false;
        L114:
            tt5.a.h("TtsM3U8Model", "decodeM3U8, segment count: " + ((ArrayList) r3.f).size());
            r3.d(r8);
            goto L116
        L19:
            r12 = null;
            goto L20
        L16:
            r11 = false;
        L115:
            tt5.a.k("TtsM3U8Model", "decodeM3U8, rawM3U8 is null or empty.");
            r3.d(false);
            goto L116
        L8:
            r6 = null;
            goto L9
        }
    }

    public final class d implements Observer<IPlayer.State> {
        public final /* synthetic */ TtsViewModel a;

        public d(TtsViewModel r1) {
            this.a = r1;
        }

        public final void onChanged(Object r13) {
            IPlayer.State r14 = (IPlayer.State) r13;
            Intrinsics.checkNotNullParameter(r14, "state");
            tt5.a.h("TtsViewModel", this.a.d + " PlayerStateObserver-onChanged, state: " + r14);
            TtsViewModel r0 = this.a;
            IPlayer.State r2 = (IPlayer.State) r0.k.getValue();
            if (r2 != null) goto L5;
            r2 = IPlayer.State.IDLE;
        L5:
            int[] r3 = f.a;
            int r4 = r3[r2.ordinal()];
            boolean r5 = true;
            if (r4 == 1) goto L20;
            if (r4 == 2) goto L13;
            if (r4 == 3) goto L13;
            if (r14 != r2) goto L23;
        L22:
            r5 = false;
        L23:
            int r6 = r3[r14.ordinal()];
            if (r6 != 2) goto L26;
            e r7 = (e) r0.h.getValue();
            r7.getClass();
            tt5.a.h("TtsViewModel", r7.d.d + " ProgressTimer-startTimer.");
            com.bytedance.ee.util.ui.j.c(r7.b);
        L40:
            if (r5 == false) goto L43;
            tt5.a.h("TtsViewModel", r0.d + " onPlayerStateChanged, TTS state valid, lastState: " + r2 + ", newState: " + r14);
            r0.k.setValue(r14);
            r0.t.e(r14);
            return;
        L43:
            return;
        L26:
            if (r6 == 4) goto L28;
            ((e) r0.h.getValue()).a();
            goto L40
        L28:
            ((e) r0.h.getValue()).a();
            Long r8 = (Long) r0.l.getValue();
            if (r8 == null) goto L31;
            long r9 = r8.longValue();
        L32:
            Long r10 = (Long) r0.o.getValue();
            if (r10 == null) goto L35;
            long r11 = r10.longValue();
        L36:
            tt5.a.h("TtsViewModel", r0.d + " onPlayerStateChanged, ENDED, progressMs: " + r9 + ", totalDurationMs: " + r11 + ", align progress to fill total duration, reset playback progress to 0");
            r0.l.setValue(Long.valueOf(r11));
            r0.m.setValue(r0.u.a(r11));
            so5.a r12 = r0.x.d;
            if (r12 == null) goto L40;
            r12.j = 0;
            goto L40
        L35:
            r11 = 0;
            goto L36
        L31:
            r9 = 0;
        L13:
            if (r14 == IPlayer.State.IDLE) goto L22;
            if (r14 == IPlayer.State.PREPARING) goto L22;
            if (r14 == IPlayer.State.PREPARED) goto L22;
        L20:
            if (r14 == IPlayer.State.IDLE) goto L22;
            goto L22
        }
    }

    public final class e {
        public final boolean a;
        public final com.bytedance.ee.bear.tts.impl.i b;
        public long c;
        public final /* synthetic */ TtsViewModel d;

        public e() {
            throw null;
        }

        public final void a() {
            tt5.a.h("TtsViewModel", this.d.d + " ProgressTimer-stopTimer.");
            com.bytedance.ee.util.ui.j.e(this.b);
        }

        public e(TtsViewModel r1) {
            this.d = r1;
            this.a = false;
            this.b = new com.bytedance.ee.bear.tts.impl.i(this);
        }
    }

    public /* synthetic */ class f {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[IPlayer.State.values().length];
            r0[IPlayer.State.PREPARING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[IPlayer.State.PLAYING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[IPlayer.State.BUFFERING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[IPlayer.State.ENDED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ TtsViewModel a;
        public final /* synthetic */ TtsLoadScene b;

        public g(TtsViewModel r1, TtsLoadScene r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            this.a.s.setValue(this.b);
            to5.a r0 = this.a.t;
            TtsLoadScene r1 = this.b;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "scene");
            int r2 = to5.a.b.b[r1.ordinal()];
            if (r2 != 1) goto L5;
            String r3 = "timbre";
        L9:
            r0.g = r3;
            return;
        L5:
            if (r2 == 2) goto L7;
            r3 = "play";
            goto L9
        L7:
            r3 = "seek";
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ mo5.b a;
        public final /* synthetic */ TtsResult b;

        public h(mo5.b r1, TtsResult r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            mo5.b r0 = this.a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.a(this.b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ TtsViewModel a;

        public i(TtsViewModel r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MutableLiveData<IPlayer.State> r0 = this.a.k;     // Catch: Throwable -> L4
            IPlayer.State r1 = IPlayer.State.PREPARING;     // Catch: Throwable -> L4
            r0.setValue(r1);     // Catch: Throwable -> L4
            this.a.t.e(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class j implements mo5.b {
        public final /* synthetic */ TtsViewModel a;
        public final /* synthetic */ mo5.b b;

        public j(TtsViewModel r1, mo5.b r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // mo5.b
        public final void a(TtsResult r10) {
            Intrinsics.checkNotNullParameter(r10, "result");
            if (r10.a() == false) goto L24;
            TtsViewModel r11 = this.a;
            mo5.b r0 = this.b;
            TtsResult r1 = r11.l("TtsViewModel-resume");
            if (r1.a() == false) goto L9;
            r1 = null;
        L9:
            if (r1 == null) goto L11;
            tt5.a.h("TtsViewModel", r11.d + " resume, checkAccess failed: " + r1);
            com.bytedance.ee.util.ui.j.c(new com.bytedance.ee.bear.tts.impl.k(r0, r1));
            return;
        L11:
            ((com.bytedance.ee.bear.lark.dependency.g) r11.c.getValue()).getNtpTime();
            TtsM3U8Bean r2 = r11.u.c;
            long r3 = 0;
            if (r2 == null) goto L14;
            long r5 = r2.expireTimeMS;
        L16:
            if (0 <= (r5 - 300000)) goto L21;
            tt5.a.k("TtsViewModel", r11.d + " resume, M3U8 will be expired, current time: 0, expire time: " + r5);
            so5.a r4 = r11.x.d;
            if (r4 == null) goto L20;
            r3 = r4.j;
        L20:
            r11.A(TtsLoadScene.M3U8_EXPIRED, r3, r0);
            return;
        L21:
            tt5.a.h("TtsViewModel", r11.d + " resume");
            com.bytedance.ee.bear.tts.operation.f r6 = new com.bytedance.ee.bear.tts.operation.f(r11.z);
            r6.b = r0;
            r11.z().b(r6);
            so5.a r12 = r11.x.d;
            if (r12 == null) goto L30;
            r12.h = 0;
            return;
        L30:
            return;
        L14:
            r5 = 0;
            goto L16
        L24:
            mo5.b r7 = this.b;
            if (r7 == null) goto L32;
            r7.a(r10);
            return;
        }
    }

    public static final class k implements Runnable {
        public final /* synthetic */ mo5.b a;
        public final /* synthetic */ TtsResult b;

        public k(mo5.b r1, TtsResult r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            mo5.b r0 = this.a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.a(this.b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class l implements Runnable {
        public final /* synthetic */ mo5.b a;

        public l(mo5.b r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TtsResult r0 = new TtsResult(TtsResult.OperationCode.SEEK_FAILED_NOT_PLAYABLE);     // Catch: Throwable -> L6
            mo5.b r1 = this.a;     // Catch: Throwable -> L6
            if (r1 == null) goto L9;
            r1.a(r0);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    @Override // mo5.g
    public final void onDestroy() {
        tt5.a.h("TtsViewModel", this.d + " onDestroy");
        q();
        tt5.a.h("TtsViewModel", this.d + " destroyModel");
        z().j();
    }

    @Override // mo5.g
    public final void pause() {
        tt5.a.h("TtsViewModel", this.d + " pause");
        com.bytedance.ee.bear.tts.operation.d r0 = new com.bytedance.ee.bear.tts.operation.d(this.z);
        r0.b = null;
        z().b(r0);
    }

    @Override // mo5.g
    public final void q() {
        tt5.a.h("TtsViewModel", this.d + " prune");
        Job r4 = this.A;     // Catch: Exception -> L12
        if (r4 != null) goto L6;
    L14:
        this.A = null;
        Job r5 = this.B;     // Catch: Exception -> L24
        if (r5 != null) goto L18;
    L26:
        this.B = null;
        ((e) this.h.getValue()).a();
        this.u.d = false;
        this.v.d = false;
        this.w.d = false;
        this.y.d = false;
        IPlayer r0 = this.z;
        if (r0 == null) goto L34;
        r0.h().removeObserver((Observer) this.i.getValue());
        r0.e();
        r0.a((sf5.b) this.g.getValue());
        r0.stop();
        r0.release();     // Catch: Throwable -> L31
    L33:
        this.z = null;
    L31:
        th = move-exception;
        tt5.a.e("TtsViewModel", this.d + " destroyPlayer, release error:", th, false);
    L34:
        MutableLiveData<IPlayer.State> r1 = this.k;
        IPlayer.State r2 = IPlayer.State.IDLE;
        r1.setValue(r2);
        this.t.e(r2);
        z().c();
        return;
    L18:
        if (r5.isActive() == true) goto L21;
        r5 = null;
    L21:
        if (r5 == null) goto L26;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);     // Catch: Exception -> L24
    L24:
        e = move-exception;
        tt5.a.e("TtsViewModel", this.d + " prune, cancel prepareJob error:", e, false);
        goto L26
    L6:
        if (r4.isActive() == true) goto L9;
        r4 = null;
    L9:
        if (r4 == null) goto L14;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        tt5.a.e("TtsViewModel", this.d + " prune, cancel preloadJob error:", e, false);
        goto L14
    }

    public final String toString() {
        return "TtsViewModel@" + hashCode() + "{token: " + du5.b.i(this.a) + ", type: " + this.b + '}';
    }

    public final TtsOperationQueue z() {
        return (TtsOperationQueue) this.f.getValue();
    }

    @Override // mo5.g
    public final void e() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new TtsViewModel$deleteFromCache$1(this, "TtsAlbumViewModel-removeItem", null, null), 3, null);
    }

    @Override // mo5.g
    public final String a() {
        return this.C;
    }

    @Override // mo5.g
    public final MutableLiveData b() {
        return this.m;
    }

    @Override // mo5.g
    public final MutableLiveData c() {
        return this.q;
    }

    @Override // mo5.g
    public final MutableLiveData g() {
        return this.o;
    }

    @Override // mo5.g
    public final MutableLiveData i() {
        return this.j;
    }

    @Override // mo5.g
    public final MutableLiveData j() {
        return this.p;
    }

    @Override // mo5.g
    public final to5.a m() {
        return this.D;
    }

    @Override // mo5.g
    public final MutableLiveData n() {
        return this.s;
    }

    @Override // mo5.g
    public final MutableLiveData o() {
        return this.l;
    }

    @Override // mo5.g
    public final MutableLiveData r() {
        return this.n;
    }

    @Override // mo5.g
    public final MutableLiveData u() {
        return this.k;
    }

    @Override // mo5.g
    public final MutableLiveData v() {
        return this.r;
    }

    public static final mo5.j x(TtsViewModel r13) {
        r13.getClass();
        String r5 = LarkContext.getApplication().getString(2131891661);
        TtsMetaBean r0 = r13.v.c;
        boolean r1 = false;
        String r2 = null;
        if (r0 == null) goto L21;
        String r7 = r13.a;
        int r8 = r13.b;
        String r6 = r0.getTitle();
        if (r6.length() <= 0) goto L7;
        r1 = true;
    L7:
        if (r1 == false) goto L9;
        r2 = r6;
    L9:
        if (r2 != null) goto L11;
        String r9 = r5;
    L12:
        String r3 = r0.getOwnerName();
        if (r3 != null) goto L15;
        String r10 = "";
    L16:
        String r4 = r0.getIconInfo();
        if (r4 != null) goto L19;
        String r11 = "";
    L20:
        mo5.j r12 = new mo5.j(r7, r8, r9, r10, r11, r13.e);
    L44:
        tt5.a.h("TtsViewModel", r13.d + " generateItemInfo: " + r12);
        return r12;
    L19:
        r11 = r4;
        goto L20
    L15:
        r10 = r3;
        goto L16
    L11:
        r9 = r2;
        goto L12
    L21:
        so5.a r14 = r13.x.d;
        if (r14 == null) goto L43;
        String r15 = r13.a;
        int r16 = r13.b;
        String r17 = r14.c;
        if (r17 != null) goto L26;
    L33:
        String r18 = r5;
    L34:
        String r19 = r14.d;
        if (r19 != null) goto L37;
        String r110 = "";
    L38:
        String r20 = r14.e;
        if (r20 != null) goto L41;
        String r111 = "";
    L42:
        r12 = new mo5.j(r15, r16, r18, r110, r111, r13.e);
        goto L44
    L41:
        r111 = r20;
        goto L42
    L37:
        r110 = r19;
        goto L38
    L26:
        if (r17.length() <= 0) goto L28;
        r1 = true;
    L28:
        if (r1 == false) goto L30;
        r2 = r17;
    L30:
        if (r2 == null) goto L33;
        r18 = r2;
        goto L34
    L43:
        r12 = new mo5.j(r13.a, r13.b, r5, "", "", r13.e);
        goto L44
    }

    public static final void y(TtsViewModel r2) {
        so5.a r0 = r2.x.d;
        if (r0 == null) goto L9;
        TtsMetaBean r1 = r2.v.c;
        if (r1 == null) goto L7;
        r0.c = r1.getTitle();
        r0.d = r1.getOwnerName();
        r0.e = r1.getIconInfo();
        return;
    L7:
        tt5.a.k("TtsViewModel", r2.d + " updatePlaybackFromMeta, metaBean is null.");
        return;
    }

    public final TtsResult B(Deferred<TtsResult> r4) {
        if (r4.isCancelled() == false) goto L6;
        return new TtsResult(TtsResult.ModelCode.CANCELLED);
    L6:
        if (r4.isCompleted() == true) goto L13;
        tt5.a.k("TtsViewModel", this.d + " safeGetDeferResult, deferred(" + r4 + ") is still active after invokeOnCompletion.");
        return new TtsResult(TtsResult.ModelCode.UNKNOWN);
    L13:
        return (TtsResult) r4.getCompleted();
    L9:
        e = move-exception;
        tt5.a.e("TtsViewModel", this.d + " safeGetDeferResult, error:", e, false);
        return new TtsResult(TtsResult.ModelCode.CANCELLED);
    }

    @Override // mo5.g
    public final TtsResult l(String r6) {
        Intrinsics.checkNotNullParameter(r6, "reason");
        TtsMetaModel r0 = this.v;
        NetService.ServerErrorException r1 = r0.e;
        if (r1 == null) goto L14;
        if ((r1 instanceof NetService.ServerErrorException) == false) goto L14;
        int r2 = r1.getCode();
        if (r2 != 4) goto L9;
        tt5.a.k("TtsMetaModel", "getAccessResult, server error code: 4, no permission.");
        TtsResult r3 = new TtsResult(TtsResult.AccessCode.NO_PERMISSION_DEFAULT);
    L21:
        if (r3.a() == false) goto L59;
        ro5.a r4 = this.w.c;
        if (r4 == null) goto L55;
        DocUserPermissions r5 = r4.a;
        boolean r7 = false;
        if (r5 == null) goto L31;
        DocUserPermissions.EState r8 = r5.a;
        if (r8 == null) goto L31;
        if (r8.allow() != true) goto L31;
        boolean r9 = true;
    L32:
        if (r9 == true) goto L34;
        tt5.a.k("TtsPermissionModel", "getAccessResult, no view permission.");
        r3 = new TtsResult(TtsResult.AccessCode.NO_VIEW_PERMISSION);
        goto L59
    L34:
        DocUserPermissions r10 = r4.a;
        if (r10 == null) goto L41;
        DocUserPermissions.EState r11 = r10.b;
        if (r11 == null) goto L41;
        if (r11.allow() != true) goto L41;
        boolean r12 = true;
    L42:
        if (r12 == true) goto L44;
        tt5.a.k("TtsPermissionModel", "getAccessResult, no preview permission.");
        r3 = new TtsResult(TtsResult.AccessCode.NO_PREVIEW_PERMISSION);
        goto L59
    L44:
        DocUserPermissions r13 = r4.a;
        if (r13 == null) goto L51;
        DocUserPermissions.EState r14 = r13.c;
        if (r14 == null) goto L51;
        if (r14.allow() != true) goto L51;
        r7 = true;
    L51:
        if (r7 == true) goto L53;
        tt5.a.k("TtsPermissionModel", "getAccessResult, no perceive permission.");
        r3 = new TtsResult(TtsResult.AccessCode.NO_PERCEIVE_PERMISSION);
        goto L59
    L53:
        tt5.a.h("TtsPermissionModel", "getAccessResult, permission allowed.");
        r3 = TtsResult.d;
    L41:
        r12 = false;
    L31:
        r9 = false;
        goto L32
    L55:
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == false) goto L57;
        tt5.a.k("TtsPermissionModel", "getAccessResult, network connected but permissionBean is null");
        r3 = new TtsResult(TtsResult.AccessCode.NO_PERMISSION_DEFAULT);
        goto L59
    L57:
        tt5.a.k("TtsPermissionModel", "getAccessResult, network not connected.");
        r3 = new TtsResult(TtsResult.AccessCode.NETWORK_ERROR);
    L59:
        if (r3.a() == false) goto L61;
        r3 = this.u.b();
    L61:
        tt5.a.h("TtsViewModel", this.d + " checkAccess, reason: " + r6 + ", result: " + r3);
        return r3;
    L9:
        if (r2 != 1002) goto L14;
        tt5.a.k("TtsMetaModel", "getAccessResult, server error code: 1002, deleted.");
        r3 = new TtsResult(TtsResult.AccessCode.FILE_NOT_EXISTS);
    L14:
        if (r0.c == null) goto L16;
        tt5.a.h("TtsMetaModel", "getAccessResult, success");
        r3 = TtsResult.d;
        goto L21
    L16:
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == false) goto L18;
        tt5.a.k("TtsMetaModel", "getAccessResult, network connected but metaBean is null.");
        r3 = new TtsResult(TtsResult.AccessCode.NO_PERMISSION_DEFAULT);
        goto L21
    L18:
        tt5.a.k("TtsMetaModel", "getAccessResult, network not connected.");
        r3 = new TtsResult(TtsResult.AccessCode.NETWORK_ERROR);
        goto L21
    }

    @Override // mo5.g
    public final void d(String r8, o r9) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new TtsViewModel$saveToCache$1(this, r8, r9, null), 3, null);
    }

    @Override // mo5.g
    public final void f(TtsToneBean r8, po5.b.a r9) {
        Intrinsics.checkNotNullParameter(r8, "toneBean");
        TtsResult r0 = l("TtsViewModel-selectTone");
        Object r2 = null;
        if (r0.a() == false) goto L7;
        r0 = null;
    L7:
        if (r0 == null) goto L10;
        tt5.a.h("TtsViewModel", this.d + " selectTone, checkAccess failed: " + r0);
        com.bytedance.ee.util.ui.j.c(new com.bytedance.ee.bear.tts.impl.l(r9, r0));
        return;
    L10:
        String r1 = r8.getToneId();
        TtsToneBean r3 = (TtsToneBean) this.r.getValue();
        if (r3 == null) goto L13;
        String r4 = r3.getToneId();
    L15:
        if (Intrinsics.areEqual(r1, r4) == false) goto L18;
        tt5.a.k("TtsViewModel", this.d + " selectTone, toneId is same as playing: " + r8);
        com.bytedance.ee.util.ui.j.c(new m(r9));
        return;
    L18:
        Ref.ObjectRef r5 = new Ref.ObjectRef();
        r5.element = r8;
        TtsToneListBean r6 = this.y.c;
        if (r6 == null) goto L33;
        ArrayList<TtsToneBean> r7 = r6.getToneList();
        if (r7 == null) goto L33;
        Iterator<T> r10 = r7.iterator();
    L24:
        if (r10.hasNext() == false) goto L28;
        Object r11 = r10.next();
        if (Intrinsics.areEqual(((TtsToneBean) r11).getToneId(), r8.getToneId()) == false) goto L24;
        r2 = r11;
    L28:
        TtsToneBean r12 = (TtsToneBean) r2;
        if (r12 != null) goto L32;
        tt5.a.k("TtsViewModel", this.d + " selectTone, toneModel loaded and target tone not supported: " + r8);
        com.bytedance.ee.util.ui.j.c(new n(r9));
        return;
    L32:
        r5.element = r12;
    L33:
        tt5.a.h("TtsViewModel", this.d + " selectTone, targetTone: " + r5.element);
        so5.a r13 = this.x.d;
        if (r13 == null) goto L36;
        r13.l = ((TtsToneBean) r5.element).getToneId();
    L36:
        so5.a r14 = this.x.d;
        if (r14 == null) goto L39;
        r14.m = ((TtsToneBean) r5.element).getToneName();
    L39:
        this.r.setValue(r5.element);
        d("selectTone", new o(this, r9));
        return;
    L13:
        r4 = null;
        goto L15
    }

    @Override // mo5.g
    public final void h(TtsLoadScene r12, final mo5.b r13) {
        Intrinsics.checkNotNullParameter(r12, "scene");
        tt5.a.h("TtsViewModel", this.d + " prepare, scene: " + r12);
        com.bytedance.ee.util.ui.j.f(new g(this, r12));
        if (r12 == TtsLoadScene.SWITCH_TONE) goto L44;
        final Deferred<TtsResult> r0 = this.B;
        if (r0 != null) goto L18;
    L42:
        Job r1 = this.A;     // Catch: Exception -> L38
        if (r1 != null) goto L32;
    L40:
        final Deferred<TtsResult> r14 = BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new TtsViewModel$prepare$5(this, r12, null), 3, null);
        tt5.a.h("TtsViewModel", this.d + " prepare, prepareJob: " + r14);
        com.bytedance.ee.util.ui.j.f(new i(this));
        r14.invokeOnCompletion(new TtsViewModel$prepare$6$2(this, r14, r13));
        this.B = r14;
        return;
    L32:
        if (r1.isActive() == true) goto L35;
        r1 = null;
    L35:
        if (r1 == null) goto L40;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);     // Catch: Exception -> L38
    L38:
        e = move-exception;
        tt5.a.e("TtsViewModel", this.d + " prepare, cancel preloadJob error:", e, false);
        goto L40
    L18:
        if (r0.isActive() == false) goto L22;
        r0.invokeOnCompletion(new TtsViewModel$prepare$3$1(this, r0, r13));
        return;
    L22:
        if (r0.isCompleted() == false) goto L42;
        if (r0.isCancelled() == true) goto L42;
        TtsResult r2 = B(r0);
        tt5.a.h("TtsViewModel", this.d + " prepare, complete, result: " + r2);
        if (r2.a() == false) goto L42;
        com.bytedance.ee.util.ui.j.c(new h(r13, r2));
        return;
    L44:
        Job r3 = this.B;     // Catch: Exception -> L13
        if (r3 == null) goto L42;
        if (r3.isActive() == true) goto L10;
        r3 = null;
    L10:
        if (r3 == null) goto L42;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);     // Catch: Exception -> L13
        Unit r4 = Unit.INSTANCE;     // Catch: Exception -> L13
    L13:
        e = move-exception;
        tt5.a.e("TtsViewModel", this.d + " prepare, cancel prepareJob error:", e, false);
        Unit r5 = Unit.INSTANCE;
        goto L42
    }

    @Override // mo5.g
    public final void k(float r4, po5.d.a r5) {
        TtsResult r0 = l("TtsViewModel-setSpeed");
        if (r0.a() == false) goto L7;
        r0 = null;
    L7:
        if (r0 == null) goto L10;
        tt5.a.h("TtsViewModel", this.d + " setSpeed, checkAccess failed: " + r0);
        com.bytedance.ee.util.ui.j.c(new p(r5, r0));
        return;
    L10:
        tt5.a.h("TtsViewModel", this.d + " setSpeed, targetSpeed: " + r4);
        com.bytedance.ee.bear.tts.operation.h r1 = new com.bytedance.ee.bear.tts.operation.h(this.z);
        r1.b = r5;
        r1.e = r4;
        z().b(r1);
        so5.a r6 = this.x.d;
        if (r6 == null) goto L13;
        r6.k = r4;
    L13:
        this.n.setValue(Float.valueOf(r4));
    }

    @Override // mo5.g
    public final void p(TtsLoadScene r2, mo5.b r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        h(r2, new j(this, r3));
    }

    @Override // mo5.g
    public final void s(TtsLoadScene r8, final TtsAlbumViewModel$reloadAlbum$2.a r9) {
        Intrinsics.checkNotNullParameter(r8, "loadScene");
        tt5.a.h("TtsViewModel", this.d + " preload, loadScene: " + r8);
        final Deferred<TtsResult> r0 = this.A;
        if (r0 == null) goto L6;
        r0.invokeOnCompletion(new TtsViewModel$preload$1$1(this, r0, r9));
        return;
    L6:
        final Deferred<TtsResult> r10 = BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new TtsViewModel$preload$2(this, r8, null), 3, null);
        r10.invokeOnCompletion(new TtsViewModel$preload$3$1(this, r10, r9));
        this.A = r10;
    }

    @Override // mo5.g
    public final void t(long r21, mo5.b r23) {
        Long r3 = (Long) this.l.getValue();
        if (r3 == null) goto L5;
        long r8 = r3.longValue();
    L6:
        TtsResult r4 = l("TtsViewModel-seekTo");
        if (r4.a() == false) goto L11;
        r4 = null;
    L11:
        if (r4 == null) goto L14;
        tt5.a.h("TtsViewModel", this.d + " seekTo, checkAccess failed: " + r4);
        this.l.setValue(Long.valueOf(r8));
        this.m.setValue(this.u.a(r8));
        com.bytedance.ee.util.ui.j.c(new k(r23, r4));
        return;
    L14:
        TtsM3U8Bean r5 = this.u.c;
        if (r5 == null) goto L17;
        long r10 = RangesKt.coerceAtLeast(r5.segmentFirstOffsetMs, 0);
    L18:
        TtsM3U8Bean r6 = this.u.c;
        if (r6 == null) goto L21;
        long r12 = RangesKt.coerceAtLeast(r6.segmentSumDurationMs, 0);
    L22:
        tt5.a.h("TtsViewModel", this.d + " seekTo, targetTimeMs: " + r21 + ", segmentFirstOffsetMs: " + r10 + ", segmentSumDurationMs: " + r12);
        long r14 = r10 + r12;
        if (r21 <= r14) goto L30;
        tt5.a.h("TtsViewModel", this.d + " seekTo, targetTimeMs out of range.");
        this.l.setValue(Long.valueOf(r8));
        this.m.setValue(this.u.a(r8));
        IPlayer.State r1 = (IPlayer.State) this.k.getValue();
        if (r1 == null) goto L27;
        this.k.setValue(r1);
    L27:
        com.bytedance.ee.util.ui.j.c(new l(r23));
        return;
    L30:
        if ((r21 - r10) >= 0) goto L33;
        A(TtsLoadScene.SEEK_BACKWARD, r21, r23);
        return;
    L33:
        long r2 = RangesKt.coerceIn(r21, 0, r14);
        long r7 = RangesKt.coerceIn(r2 - r10, 0, r12);
        so5.a r9 = this.x.d;
        if (r9 == null) goto L36;
        r9.j = r2;
    L36:
        this.l.setValue(Long.valueOf(r2));
        this.m.setValue(this.u.a(r2));
        IPlayer.State r11 = (IPlayer.State) this.k.getValue();
        if (r11 == null) goto L39;
        this.k.setValue(r11);
    L39:
        com.bytedance.ee.bear.tts.operation.g r13 = new com.bytedance.ee.bear.tts.operation.g(this.z);
        r13.b = r23;
        r13.e = r7;
        z().b(r13);
        return;
    L21:
        r12 = 0;
        goto L22
    L17:
        r10 = 0;
        goto L18
    L5:
        r8 = 0;
        goto L6
    }

    @Override // mo5.g
    public final void w(TtsLoadScene r6, po5.b.a.C0292a r7) {
        Intrinsics.checkNotNullParameter(r6, "scene");
        TtsResult r0 = l("TtsViewModel-reload");
        if (r0.a() == false) goto L7;
        r0 = null;
    L7:
        if (r0 == null) goto L10;
        tt5.a.h("TtsViewModel", this.d + " reload, checkAccess failed: " + r0);
        com.bytedance.ee.util.ui.j.c(new com.bytedance.ee.bear.tts.impl.j(r7, r0));
        return;
    L10:
        so5.a r1 = this.x.d;
        if (r1 == null) goto L13;
        long r2 = r1.j;
    L14:
        tt5.a.h("TtsViewModel", this.d + " reload, from progressMs: " + r2);
        A(r6, r2, r7);
        return;
    L13:
        r2 = 0;
        goto L14
    }

    public final void A(TtsLoadScene r4, long r5, mo5.b r7) {
        IPlayer r0 = this.z;
        if (r0 == null) goto L8;
        MutableLiveData r1 = r0.h();
        if (r1 == null) goto L8;
        if (((IPlayer.State) r1.getValue()) == null) goto L8;
    L9:
        q();
        MutableLiveData<IPlayer.State> r2 = this.k;
        IPlayer.State r3 = IPlayer.State.BUFFERING;
        r2.setValue(r3);
        so5.a r6 = this.x.d;
        if (r6 == null) goto L12;
        r6.j = r5;
    L12:
        this.l.setValue(Long.valueOf(r5));
        this.m.setValue(this.u.a(r5));
        this.t.e(r3);
        p(r4, r7);
        return;
    L8:
        IPlayer.State r8 = IPlayer.State.IDLE;
        goto L9
    }

    public TtsViewModel(String r4, int r5, TtsMetaBean r6, so5.a r7) {
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);
        this.a = r4;
        this.b = r5;
        this.c = LazyKt.lazy(LazyThreadSafetyMode.NONE, TtsViewModel$coreDependency$2.INSTANCE);
        this.d = "[TtsViewModel@" + hashCode() + ']';
        int r0 = E;
        E = r0 + 1;
        int r1 = r0 % 3;
        tt5.a.h("TtsViewModel", "coverLottieRes, index: " + r1);
        CCMLottieRes r2 = (CCMLottieRes) ArraysKt.getOrNull(CCMLottieRes.values(), r1);
        if (r2 != null) goto L5;
        r2 = CCMLottieRes.SEA_WAVE;
    L5:
        this.e = r2;
        this.f = LazyKt.lazy(TtsViewModel$operationQueue$2.INSTANCE);
        this.g = LazyKt.lazy(new TtsViewModel$playerHlsListener$2(this));
        this.h = LazyKt.lazy(new TtsViewModel$progressTimer$2(this));
        this.i = LazyKt.lazy(new TtsViewModel$playerStateObserver$2(this));
        this.j = new MutableLiveData();
        this.k = new MutableLiveData();
        this.l = new MutableLiveData();
        this.m = new MutableLiveData();
        this.n = new MutableLiveData(Float.valueOf(1.0f));
        this.o = new MutableLiveData();
        this.p = new MutableLiveData();
        this.q = new MutableLiveData();
        this.r = new MutableLiveData();
        this.s = new MutableLiveData();
        to5.a r3 = new to5.a(r4, r5);
        this.t = r3;
        this.u = new TtsM3U8Model(r4, r5);
        this.w = new TtsPermissionModel(r4, r5);
        this.y = new TtsToneModel(r4, r5);
        if (r6 != null) goto L8;
        TtsMetaModel r8 = new TtsMetaModel(r4, r5);
    L9:
        this.v = r8;
        if (r7 != null) goto L14;
        if (r6 != null) goto L13;
        TtsPlaybackModel r9 = new TtsPlaybackModel(r4, r5);
    L15:
        this.x = r9;
        com.bytedance.ee.util.ui.j.f(new a(this));
        this.C = r4 + '-' + r5;
        this.D = r3;
        return;
    L13:
        so5.a r10 = new so5.a();
        TtsDataSource r11 = TtsDataSource.UNKNOWN;
        r10.a = r6.getObjToken();
        r10.b = r6.getObjType();
        r10.c = r6.getTitle();
        r10.d = r6.getOwnerName();
        r10.e = r6.getIconInfo();
        r9 = new TtsPlaybackModel(r10);
        goto L15
    L14:
        r9 = new TtsPlaybackModel(r7);
        goto L15
    L8:
        r8 = new TtsMetaModel(r6);
        goto L9
    }
}
