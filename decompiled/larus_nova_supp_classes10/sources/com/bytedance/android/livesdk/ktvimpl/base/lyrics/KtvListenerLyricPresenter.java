package com.bytedance.android.livesdk.ktvimpl.base.lyrics;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.sei.k;
import com.bytedance.android.livesdk.ktvimpl.base.sei.v;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.h;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/KtvListenerLyricPresenter;", "Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/KtvBaseLyricPresenter;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvListenerLyricPresenter extends KtvBaseLyricPresenter implements Observer<Long> {
    public boolean b;
    public boolean c;
    public long d;
    public Disposable e;
    public final long f;
    public final wd2.a g;
    public final h h;
    public boolean i;
    public long j;
    public final HashSet<Integer> k;
    public boolean l;
    public Function1<? super Long, Unit> m;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ KtvListenerLyricPresenter a;

        public a(KtvListenerLyricPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            this.a.d += (long) 33;
            ALogger.i("updateLyricProgress", "--" + this.a.d);
            KtvListenerLyricPresenter r7 = this.a;
            r7.f(r7.d);
        }
    }

    public final void d() {
        this.k.clear();
        this.c = false;
        this.a.release();
        Disposable r0 = this.e;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.e = null;
        this.d = 0;
        this.j = 0;
        this.l = true;
        wd2.a r1 = this.g;
        if (r1 == null) goto L9;
        r1.e();
        return;
    }

    public final void e() {
        Disposable r0 = this.e;
        if (r0 != null) goto L5;
    L7:
        ALogger.e("updateLyricProgress", "--start");
        this.e = du2.a.b(0, 33, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.KtvBaseLyricPresenter
    public final void a(ub0.a r3) {
        Intrinsics.checkNotNullParameter(r3, "lyricsChangeEvent");
        if ((r3 instanceof ub0.a.b) == false) goto L5;
        this.l = false;
        b(3);
    L5:
        this.k.clear();
        super.a(r3);
        this.c = !this.a.getCurrentLyrics().isEmpty();
        String r4 = "listener-onLyricsChange,Lyrics added:" + this.c;
        ALogger.i(bb0.b.b().concat("-lyric"), r4 + ", invoke class :KtvListenerLyricPresenter");
    }

    public final void b(int r7) {
        String r1 = bb0.b.b();
        ALogger.i(r1, ("sendCommand:" + r7) + ", invoke class :KtvListenerLyricPresenter");
        wd2.a r0 = this.g;
        if (r0 == null) goto L16;
        if (r7 == 4) goto L14;
        if (r7 == 5) goto L11;
        if (r7 != 6) goto L38;
        d();
        wd2.a r8 = this.g;
        if (r8 == null) goto L34;
        r8.e();
        return;
    L34:
        return;
    L38:
        return;
    L11:
        this.b = false;
        if (r0 == null) goto L36;
        wd2.a.c(r0);
        return;
    L36:
        return;
    L14:
        this.b = true;
        wd2.a.b(r0);
        return;
    L16:
        if (r7 == 0) goto L31;
        if (r7 == 3) goto L29;
        if (r7 == 4) goto L25;
        if (r7 == 5) goto L24;
        if (r7 != 6) goto L44;
        d();
        return;
    L44:
        return;
    L24:
        this.b = false;
        e();
        return;
    L25:
        this.b = true;
        Disposable r9 = this.e;
        if (r9 == null) goto L28;
        r9.dispose();
    L28:
        this.e = null;
        return;
    L29:
        this.b = false;
        e();
        return;
    L31:
        if (this.b == true) goto L43;
        e();
        return;
    }

    public final void c(k r11) {
        Intrinsics.checkNotNullParameter(r11, "seiModelCompat");
        b(r11.d());
        List<v> r0 = r11.l();
        if (r0 == null) goto L55;
        int r12 = r11.n();
        this.a.getDisplayConfig().n = r12;
        Iterator<v> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L73;
        v r2 = r1.next();
        String r3 = "";
        if (r12 != 2) goto L18;
        new lg4.b();
        TreeMap r7 = new TreeMap();
        String r8 = r2.a();
        if (r8 == null) goto L13;
        r3 = r8;
    L13:
        lg4.b.c(r7, r3);
        Iterator r4 = r7.keySet().iterator();
        if (r4 != null) goto L16;
    L24:
        com.bytedance.component.lyric.model.b r5 = null;
    L25:
        if (r5 == null) goto L6;
        int r6 = r2.b();
        Intrinsics.checkNotNullParameter(r5, "lyricsLineInfo");
        if (this.c == true) goto L6;
        if (this.k.contains(Integer.valueOf(r6)) == true) goto L6;
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.a r9 = this.a;
        if (r9 == null) goto L54;
        ((KtvSingAndListenerLyricView) r9).adjustAddLyricsLine(r5, true);
        this.k.add(Integer.valueOf(r6));
        if (this.l == false) goto L6;
        if (r6 > 1) goto L6;
        if (this.i == false) goto L6;
        int r10 = ((com.bytedance.component.lyric.model.b) ListProtector.get(this.a.getCurrentLyrics(), 0)).b;
        if (this.a.getCurrentLyrics().size() > 0) goto L41;
    L52:
        this.l = false;
        goto L6
    L41:
        if (r10 <= 3000) goto L52;
        com.bytedance.component.lyric.model.b r13 = new com.bytedance.component.lyric.model.b();
        r13.h = true;
        r13.b = r10 - 3000;
        r13.d = "...";
        r13.f = new String[]{".", ".", "."};
        r13.g = new int[]{1000, 1000, 1000};
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.a r14 = this.a;
        if (r14 == null) goto L51;
        KtvSingAndListenerLyricView r15 = (KtvSingAndListenerLyricView) r14;
        Intrinsics.checkNotNullParameter(r13, "firstLineInfo");
        com.bytedance.component.lyric.model.b r16 = (com.bytedance.component.lyric.model.b) ListProtector.get(r15.getLyricsLineInfos(), 0);
        if (Intrinsics.areEqual(r16.d, "...") == true) goto L47;
    L49:
        ListProtector.add(r15.getLyricsLineInfos(), 0, r13);
        r15.setCurToAddLineIndex(r15.getCurToAddLineIndex() + 1);
        goto L52
    L47:
        if (StringsKt.equals$default(r16.d, r13.d, false, 2, null) == false) goto L49;
    L51:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.base.lyrics.KtvSingAndListenerLyricView");
    L54:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.base.lyrics.KtvSingAndListenerLyricView");
    L16:
        if (r4.hasNext() != true) goto L24;
        r5 = (com.bytedance.component.lyric.model.b) r7.get(r4.next());
        goto L25
    L18:
        if (r12 != 3) goto L24;
        lg4.a r17 = new lg4.a();
        String r18 = r2.a();
        if (r18 == null) goto L23;
        r3 = r18;
    L23:
        r5 = r17.b(r3);
        goto L25
    L73:
        return;
    }

    public final void f(long r6) {
        if (this.g == null) goto L5;
        return;
    L5:
        long r0 = this.j - r6;
        if (r0 < this.f) goto L9;
        pd2.d r2 = pd2.d.n;
        long r3 = Math.abs(r0);
        r2.getClass();
        pd2.d.D(r3);
    L9:
        if (r6 < this.j) goto L11;
    L13:
        this.d = r6;
        this.a.renderLyricsByPlayTime(r6);
        this.j = r6;
        return;
    L11:
        if (r0 >= this.f) goto L13;
    }

    public final void onChanged(Object r3) {
        long r0 = ((Number) r3).longValue();
        wd2.a r4 = this.g;
        if (r4 == null) goto L6;
        r4.a(r0);
        return;
    }

    public KtvListenerLyricPresenter(final KtvSingAndListenerLyricViewV2 r4, Function1 r5) {
        Intrinsics.checkNotNullParameter(r4, "lyricView");
        super(r4);
        this.m = r5;
        this.f = vm2.h.u();
        boolean r6 = ((Boolean) vm2.h.m3.getValue(null, vm2.h.a[219(0xdb, float:3.07E-43)])).booleanValue();
        KtvContext.Companion.getClass();
        h r0 = KtvContext.a.g().getLyricResourceManager();
        this.h = r0;
        this.i = true;
        if (r6 == false) goto L5;
        wd2.a r7 = new wd2.a();
        r7.b = new KtvListenerLyricPresenter$$special$$inlined$apply$lambda$1(this, r4);
        Unit r8 = Unit.INSTANCE;
        this.g = r7;
    L5:
        r0.e.observeForever(this);
        this.k = new HashSet();
        this.l = true;
    }
}
