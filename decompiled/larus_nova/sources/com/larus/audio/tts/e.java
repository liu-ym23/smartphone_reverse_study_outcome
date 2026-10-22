package com.larus.audio.tts;

import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.audiov3.task.tts.TtsErrorType;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.audio.t0;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f289835a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f289836b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static PlayStateEnum f289837c;

    public static final class a implements n68.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CopyOnWriteArrayList<n68.a> f289838a;

        public a(CopyOnWriteArrayList<n68.a> r100) {
            this.f289838a = r100;
        }

        @Override // n68.a
        public final void c(PlayStateEnum r100) {
            e r101 = e.f289835a;
            e.b(r100);
        }

        @Override // n68.a
        public final void d(PlayStateEnum r100) {
            e r101 = e.f289835a;
            Iterator r102 = e.a().iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            ((n68.a) r102.next()).d(r100);
            goto L4
        }

        @Override // n68.a
        public final void e(TtsErrorType r100) {
            Iterator<T> r101 = this.f289838a.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((n68.a) r101.next()).e(r100);
            goto L4
        }

        @Override // n68.a
        public final void a(boolean r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, DBDefinition.TASK_ID);
            Iterator<T> r103 = this.f289838a.iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            ((n68.a) r103.next()).a(r100, r101, r102);
            goto L4
        }

        @Override // n68.a
        public final void b(boolean r100, String r110, String r111, long r112) {
            Intrinsics.checkNotNullParameter(r111, DBDefinition.TASK_ID);
            Iterator<T> r101 = this.f289838a.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((n68.a) r101.next()).b(r100, r110, r111, r112);
            goto L4
        }
    }

    public e() {
    }

    static {
        f289835a = new e();
        f289836b = LazyKt.lazy(new d());
    }

    public static CopyOnWriteArrayList a() {
        return (CopyOnWriteArrayList) f289836b.getValue();
    }

    @Override // com.larus.audio.t0
    public final PlayStateEnum l() {
        IFlowTtsClientService.f288300a.getClass();
        return IFlowTtsClientService.a.a().m();
    }

    public static void b(PlayStateEnum r100) {
        if (f289837c != r100) goto L5;
        return;
    L5:
        Iterator r101 = a().iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((n68.a) r101.next()).c(r100);
        goto L7
    L9:
        f289837c = r100;
    }

    @Override // com.larus.audio.t0
    public final void k(n68.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (a().contains(r100) == true) goto L5;
        return;
    L5:
        a().remove(r100);
    }

    @Override // com.larus.audio.t0
    public final void m(n68.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (a().contains(r100) == false) goto L5;
        return;
    L5:
        a().add(r100);
        r100.c(f289837c);
    }

    @Override // com.larus.audio.t0
    public final void n(PlayStateEnum r100) {
        if (r100 == null) goto L5;
        b(r100);
        IFlowTtsClientService.f288300a.getClass();
        IFlowTtsClientService.a.a().v(r100);
        return;
    }
}
