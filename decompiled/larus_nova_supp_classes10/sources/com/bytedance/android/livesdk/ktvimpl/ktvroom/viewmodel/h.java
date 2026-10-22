package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import android.util.LongSparseArray;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h {
    public static final a r = null;
    public final WeakReference<KtvContext> a;
    public boolean b;
    public final boolean c;
    public boolean d;
    public final NextLiveData<Long> e;
    public final NextLiveData<ub0.a> f;
    public long g;
    public final CompositeDisposable h;
    public final String i;
    public final LongSparseArray<ub0.d> j;
    public final ArrayList<Long> k;
    public final com.bytedance.android.live.ktv.common.music.download.i l;
    public final long m;
    public final LongSparseArray<ArrayList<com.bytedance.android.live.ktv.common.music.download.i.a>> n;
    public final c o;
    public final ArrayList<Function1<ub0.a, Unit>> p;
    public Function1<? super ub0.d, Unit> q;

    public static final class a {
        public a() {
        }

        public static final void a(a r1, String r2) {
            r1.getClass();
            ALogger.i(bb0.b.b().concat("-lyric-KtvLyricsResourceManager"), r2 + ", invoke class :" + a.class.getSimpleName());
        }
    }

    public static final class b implements com.bytedance.android.live.ktv.common.music.download.i.a {
        public final h a;
        public final WeakReference<Function1<ub0.a, Unit>> b;

        public final void b(ub0.c r6) {
            Intrinsics.checkNotNullParameter(r6, "lyricsDownloadInfo");
            a r0 = h.r;
            a.a(r0, "歌词下载成功，LyricDownLoaderListener，" + r6.a);
            this.a.k.remove(Long.valueOf(r6.b));
            String r1 = r6.a;
            if (r1 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == false) goto L14;
            Function1<ub0.a, Unit> r3 = this.b.get();
            if (r3 == null) goto L25;
            Unit r7 = (Unit) r3.invoke(new ub0.a.a(r6.b));
            return;
        L25:
            return;
        L14:
            h r4 = this.a;
            r4.k.remove(Long.valueOf(r6.b));
            a.a(r0, "歌词下载完成，id：" + r6.b);
            ub0.d r5 = r4.e(r6);
            r4.j.put(r5.a, r5);
            Function1<ub0.a, Unit> r8 = this.b.get();
            if (r8 != null) goto L17;
        L21:
            Function1<ub0.a, Unit> r9 = this.b.get();
            if (r9 == null) goto L26;
            this.a.p.remove(r9);
            return;
        L26:
            return;
        L17:
            if (r5.c.isEmpty() == false) goto L19;
            ub0.a.a r10 = new ub0.a.a(r6.b);
        L20:
            Unit r11 = (Unit) r8.invoke(r10);
            goto L21
        L19:
            r10 = new ub0.a.b(r6.b, r5.c, r5.getType());
            goto L20
        L5:
            if (r1.length() == 0) goto L8;
            r2 = false;
            goto L9
        }

        public b(h r2, WeakReference<Function1<ub0.a, Unit>> r3) {
            Intrinsics.checkNotNullParameter(r2, "rsManager");
            Intrinsics.checkNotNullParameter(r3, "wefCb");
            this.a = r2;
            this.b = r3;
        }

        public final void a(long r4, int r6, String r7) {
            Intrinsics.checkNotNullParameter(r7, "errorMsg");
            a.a(h.r, "歌词下载失败，status_code: " + r6 + ", errorMsg: " + r7);
            this.a.k.remove(Long.valueOf(r4));
            Function1<ub0.a, Unit> r8 = this.b.get();
            if (r8 == null) goto L5;
            Unit r5 = (Unit) r8.invoke(new ub0.a.a(r4));
        L5:
            Function1<ub0.a, Unit> r9 = this.b.get();
            if (r9 == null) goto L9;
            this.a.p.remove(r9);
            return;
        }
    }

    public static final class c implements com.bytedance.android.live.ktv.common.music.download.i.a {
        public final /* synthetic */ h a;

        public c(h r1) {
            this.a = r1;
        }

        public final void b(ub0.c r7) {
            Intrinsics.checkNotNullParameter(r7, "lyricsDownloadInfo");
            long r0 = r7.b;
            this.a.k.remove(Long.valueOf(r0));
            if (this.a.j.get(r0) == null) goto L14;
            ub0.d r2 = this.a.j.get(r7.b);
            if (r2 == null) goto L14;
            List r3 = r2.c;
            if (r3 == null) goto L14;
            if (r3.isEmpty() == true) goto L14;
            h r4 = this.a;
            Function1<? super ub0.d, Unit> r5 = r4.q;
            if (r5 == null) goto L18;
            Unit r6 = (Unit) r5.invoke(r4.j.get(r0));
        L18:
            ArrayList<com.bytedance.android.live.ktv.common.music.download.i.a> r8 = this.a.n.get(r0);
            if (r8 == null) goto L24;
            Iterator<T> r9 = r8.iterator();
        L22:
            if (r9.hasNext() == false) goto L24;
            ((com.bytedance.android.live.ktv.common.music.download.i.a) r9.next()).b(r7);
        L24:
            this.a.n.remove(r0);
            a.a(h.r, "歌词下载完成，id：" + r7.b);
            return;
        L14:
            ub0.d r10 = this.a.e(r7);
            Function1<? super ub0.d, Unit> r11 = this.a.q;
            if (r11 == null) goto L17;
            Unit r12 = (Unit) r11.invoke(r10);
        L17:
            this.a.j.put(r10.a, r10);
            goto L18
        }

        public final void a(long r4, int r6, String r7) {
            Intrinsics.checkNotNullParameter(r7, "errorMsg");
            a.a(h.r, "歌词下载失败，status_code: " + r6 + ", errorMsg: " + r7);
            this.a.k.remove(Long.valueOf(r4));
            ArrayList<com.bytedance.android.live.ktv.common.music.download.i.a> r0 = this.a.n.get(r4);
            if (r0 == null) goto L8;
            Iterator<T> r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L8;
            ((com.bytedance.android.live.ktv.common.music.download.i.a) r1.next()).a(r4, r6, r7);
        L8:
            this.a.n.remove(r4);
        }
    }

    static {
        r = new a();
    }

    public h(KtvContext r5) {
        ReadOnlyProperty r0 = vm2.h.c4;
        KProperty[] r1 = vm2.h.a;
        this.c = ((Boolean) r0.getValue(null, r1[261(0x105, float:3.66E-43)])).booleanValue();
        this.a = new WeakReference(r5);
        this.d = true;
        this.e = new NextLiveData();
        this.f = new NextLiveData();
        this.h = new CompositeDisposable();
        KtvRoomLyricsStateMachineConfig.d.a r6 = KtvRoomLyricsStateMachineConfig.d.a.b;
        IMiddlewareUserService r7 = jc1.k.f(IMiddlewareUserService.class);
        if (r7 == null) goto L9;
        com.bytedance.android.livesdk.user.e r8 = r7.user();
        if (r8 == null) goto L9;
        String r9 = r8.n();
        if (r9 == null) goto L9;
    L10:
        this.i = r9;
        this.j = new LongSparseArray();
        this.k = new ArrayList();
        this.l = new com.bytedance.android.live.ktv.common.music.download.i();
        this.m = ((Number) vm2.h.b4.getValue(null, r1[260(0x104, float:3.64E-43)])).longValue();
        this.n = new LongSparseArray();
        this.o = new c(this);
        this.p = new ArrayList();
        return;
    L9:
        r9 = null;
        goto L10
    }

    public static void a(h r1) {
        r1.j.clear();
        r1.k.clear();
    }

    public final void d(com.bytedance.android.livesdk.ktvimpl.base.sei.k r13) {
        Intrinsics.checkNotNullParameter(r13, "sei");
        if (Intrinsics.areEqual(r13.A(), this.i) == false) goto L5;
        return;
    L5:
        int r0 = r13.d();
        boolean r1 = true;
        if (r0 == 0) goto L16;
        if (r0 == 1) goto L16;
        if (r0 == 3) goto L16;
        if (r0 == 4) goto L16;
        if (r0 == 5) goto L16;
        return;
    L16:
        if (r13.j() > 0) goto L18;
        return;
    L18:
        if (this.d == false) goto L47;
        String r2 = r13.p();
        if (r2 != null) goto L22;
    L25:
        boolean r3 = true;
    L26:
        if (r3 == false) goto L28;
    L32:
        double r6 = r13.y();
        if (r6 <= 1.0E-6d) goto L35;
    L38:
        if (r1 == false) goto L48;
        long r4 = (long) ((r13.y() + r13.m()) * 1000.0f);
        Long r5 = (Long) this.e.getValue();
        if (r5 != null) goto L43;
        r5 = 0L;
    L43:
        if (Math.abs(r5.longValue() - r4) <= this.m) goto L49;
        this.e.setValue(Long.valueOf((long) ((r13.y() + r13.m()) * 1000.0f)));
        return;
    L49:
        return;
    L48:
        return;
    L35:
        if (r6 < (-1.0E-6d)) goto L38;
        r1 = false;
        goto L38
    L28:
        if (r13.n() <= 0) goto L32;
        if (r13.j() == this.g) goto L32;
        String r7 = r13.p();
        Intrinsics.checkNotNull(r7);
        b(r7, r13.j(), r13.n(), this.o);
        this.g = r13.j();
        goto L32
    L22:
        if (r2.length() == 0) goto L25;
        r3 = false;
        goto L26
    }

    public final ub0.d e(ub0.c r8) {
        a r0 = r;
        a.a(r0, "开始解析歌词，id: " + r8.b);
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.b r1 = com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.b.a;
        long r2 = r8.b;
        String r4 = r8.d;
        String r5 = r8.a;
        int r6 = r8.c;
        r1.getClass();
        ub0.d r3 = com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.b.a(r2, r4, r5, r6);
        NextLiveData<ub0.a> r7 = this.f;
        if (r3.c.isEmpty() == false) goto L5;
        a.a(r0, "歌词解析失败");
        ub0.a.a r9 = new ub0.a.a(r8.b);
    L6:
        r7.setValue(r9);
        if (this.b == true) goto L9;
    L18:
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r10 = KtvRoomContext.a.a();
        if (r10 == null) goto L29;
        com.bytedance.live.datacontext.m<Integer> r11 = r10.getMidiTotalLyricsLineCount();
        if (r11 == null) goto L29;
        ub0.a r12 = (ub0.a) this.f.getValue();
        if (r12 == null) goto L27;
        List r13 = r12.a();
        if (r13 == null) goto L27;
        int r14 = r13.size();
    L28:
        r11.setValue(Integer.valueOf(r14));
    L27:
        r14 = 0;
    L29:
        return r3;
    L9:
        if (this.c == false) goto L18;
        WeakReference<KtvContext> r15 = this.a;
        if (r15 == null) goto L13;
        KtvContext r16 = r15.get();
    L14:
        if (r16 == null) goto L18;
        NextLiveData<ub0.a> r17 = r16.getLyricsChangeLiveData();
        if (r17 == null) goto L18;
        r17.setValue(this.f.getValue());
        goto L18
    L13:
        r16 = null;
        goto L14
    L5:
        a.a(r0, "歌词解析成功, parseLyrics");
        r9 = new ub0.a.b(r8.b, r3.c, r3.getType());
        goto L6
    }

    public final void f(List<MusicPanel> r14) {
        List<MusicPanel> r0 = r14;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        this.j.clear();
        this.k.clear();
        return;
    L11:
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = this.k.iterator();
    L12:
        Object r5 = null;
        if (r3.hasNext() == false) goto L25;
        long r6 = ((Number) r3.next()).longValue();
        Iterator<T> r4 = r14.iterator();
    L16:
        if (r4.hasNext() == false) goto L23;
        Object r8 = r4.next();
        if (((MusicPanel) r8).a.getId() != r6) goto L20;
        boolean r9 = true;
    L21:
        if (r9 == false) goto L16;
        r5 = r8;
        goto L23
    L20:
        r9 = false;
    L23:
        if (r5 != null) goto L12;
        r2.add(Long.valueOf(r6));
        goto L12
    L25:
        this.k.removeAll(r2);
        int r7 = this.j.size();
        int r10 = 0;
    L26:
        if (r10 >= r7) goto L40;
        long r11 = this.j.keyAt(r10);
        Iterator<T> r12 = r14.iterator();
    L29:
        if (r12.hasNext() == false) goto L36;
        Object r13 = r12.next();
        if (((MusicPanel) r13).a.getId() != r11) goto L33;
        boolean r15 = true;
    L34:
        if (r15 == false) goto L29;
    L37:
        if (r13 != null) goto L39;
        r2.add(Long.valueOf(r11));
    L39:
        r10 = r10 + 1;
        goto L26
    L33:
        r15 = false;
        goto L34
    L36:
        r13 = null;
        goto L37
    L40:
        Iterator<T> r16 = this.k.iterator();
    L42:
        if (r16.hasNext() == false) goto L64;
        this.j.remove(((Number) r16.next()).longValue());
        goto L42
    L64:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void c(KtvMusic r13, Function1<? super ub0.a, Unit> r14) {
        Intrinsics.checkNotNullParameter(r13, "music");
        Intrinsics.checkNotNullParameter(r14, "cb");
        String r3 = "getLyricResultEvent:" + r13.getMId();
        ALogger.i(bb0.b.b().concat("-lyric-KtvLyricsResourceManager"), r3 + ", invoke class :" + h.class.getSimpleName());
        com.bytedance.android.livesdk.ktvimpl.base.util.j.l.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.d(r13) == true) goto L6;
        r14.invoke(new ub0.a.a(r13.getMId()));
        return;
    L6:
        List r5 = r13.getMLyricUrlList();
        boolean r7 = true;
        String r9 = null;
        Object r10 = null;
        if (r5 == null) goto L20;
        Iterator r6 = r5.iterator();
    L10:
        if (r6.hasNext() == false) goto L19;
        Object r11 = r6.next();
        if (r2.a((String) r11) == false) goto L16;
        com.bytedance.android.livesdk.ktvimpl.base.util.j.l.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.d(r13) == false) goto L16;
        boolean r12 = true;
    L17:
        if (r12 == false) goto L10;
        r10 = r11;
    L16:
        r12 = false;
    L19:
        r9 = (String) r10;
    L20:
        if (r9 != null) goto L22;
    L25:
        if (r7 == false) goto L27;
        r14.invoke(new ub0.a.a(r13.getMId()));
        return;
    L27:
        long r8 = r13.getMId();
        int r15 = r13.getMLyricType();
        Intrinsics.checkNotNullParameter(r9, "url");
        Intrinsics.checkNotNullParameter(r14, "cb");
        String r2 = bb0.b.b().concat("-lyric-KtvLyricsResourceManager");
        ALogger.i(r2, ("getLyricResultEvent:" + r8) + ", invoke class :" + h.class.getSimpleName());
        ub0.d r1 = this.j.get(r8);
        if (r1 == null) goto L30;
        r14.invoke(new ub0.a.b(r8, r1.c, r1.getType()));
        return;
    L30:
        this.p.add(r14);
        b(r9, r8, r15, new b(this, new WeakReference(r14)));
        return;
    L22:
        if (r9.length() == 0) goto L25;
        r7 = false;
        goto L25
    }

    public final void b(String r8, long r9, int r11, com.bytedance.android.live.ktv.common.music.download.i.a r12) {
        Intrinsics.checkNotNullParameter(r8, "url");
        Intrinsics.checkNotNullParameter(r12, "callback");
        com.bytedance.android.live.ktv.common.music.download.h r1 = com.bytedance.android.live.ktv.common.music.download.h.a;
        ub0.c r0 = new ub0.c(r8, r9, r11, com.bytedance.android.live.ktv.common.music.download.h.d(r8, r9));
        String r2 = bb0.b.b().concat("-lyric-KtvLyricsResourceManager");
        ALogger.i(r2, ("downAndParse：" + r9 + ", type:" + r11) + ", invoke class :" + h.class.getSimpleName());
        boolean r3 = true;
        if (this.k.contains(Long.valueOf(r9)) == false) goto L5;
    L36:
        String r4 = bb0.b.b().concat("-lyric-downAndParse");
        ALogger.i(r4, (r9 + " is download or already parse") + ", invoke class :" + h.class.getSimpleName());
        if ((!Intrinsics.areEqual(r12, this.o)) == false) goto L44;
        ArrayList<com.bytedance.android.live.ktv.common.music.download.i.a> r10 = this.n.get(r9);
        if (r10 != null) goto L41;
        r10 = new ArrayList();
    L41:
        r10.add(r12);
        this.n.put(r9, r10);
        return;
    L44:
        return;
    L5:
        if (r8.length() != 0) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L36;
        com.bytedance.android.livesdk.ktvimpl.base.util.p.g.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.p.f == false) goto L26;
        WeakReference<KtvContext> r13 = this.a;
        if (r13 == null) goto L15;
        KtvContext r14 = r13.get();
    L16:
        if (r14 == null) goto L26;
        com.bytedance.android.livesdk.ktvimpl.base.util.p r15 = r14.getLyricStateRecord(r9);
        if (r15 == null) goto L26;
        if (r8.length() <= 0) goto L22;
        boolean r16 = true;
    L23:
        if (r16 == false) goto L26;
        r15.e = Boolean.TRUE;
        goto L26
    L22:
        r16 = false;
        goto L23
    L15:
        r14 = null;
    L26:
        if (this.j.indexOfKey(r9) > 0) goto L34;
        String r17 = r0.d;
        if (new PolarisFileWrapper(r17).exists() == false) goto L30;
        a.a(r, "文件已经存在, path: " + r17);
    L31:
        if (r3 == true) goto L34;
        this.k.add(Long.valueOf(r9));
        this.l.b(r0, r12);
        return;
    L30:
        r3 = false;
    L34:
        r12.b(r0);
        return;
    L7:
        r5 = false;
        goto L8
    }
}
