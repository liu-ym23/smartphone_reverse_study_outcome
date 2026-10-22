package com.larus.asr;

import com.larus.audio.audiov3.config.task.sami.asr.ReportType;
import com.larus.audio.audiov3.task.asr.AsrEventEnum;
import com.larus.audio.audiov3.task.asr.AsrLifeState;
import com.larus.audio.audiov3.task.asr.AsrState;
import com.larus.audio.audiov3.task.asr.sami.data.SamiAsrDataBin;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<h68.d> f287231a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f287232b = null;

    public static final class a implements h68.d {
        public a() {
        }

        @Override // h68.d
        public final void a(y58.b r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Iterator<h68.d> r101 = d.f287231a.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            r101.next().a(r100);
            goto L4
        }

        @Override // h68.d
        public final void b(h68.b r100) {
            Intrinsics.checkNotNullParameter(r100, "asrStreamSentenceResp");
            Iterator<h68.d> r101 = d.f287231a.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            r101.next().b(r100);
            goto L4
        }

        @Override // h68.d
        public final void c(SamiAsrDataBin r100) {
            Iterator<h68.d> r101 = d.f287231a.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            r101.next().c(r100);
            goto L4
        }

        @Override // h68.d
        public final void e(AsrState r100) {
            Intrinsics.checkNotNullParameter(r100, "asrState");
            Iterator<T> r101 = d.f287231a.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((h68.d) r101.next()).e(r100);
            goto L4
        }

        @Override // h68.d
        public void onEvent(AsrEventEnum r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Iterator<T> r101 = d.f287231a.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((h68.d) r101.next()).onEvent(r100);
            goto L4
        }

        @Override // h68.d
        public final void f(y58.b r100, ReportType r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r101, "type");
            Iterator<h68.d> r102 = d.f287231a.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            r102.next().f(r100, r101);
            goto L4
        }

        @Override // h68.d
        public final void d(AsrLifeState r100, String r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r100, "lifeState");
            Iterator<T> r103 = d.f287231a.iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            ((h68.d) r103.next()).d(r100, r101, r102);
            goto L4
        }
    }

    static {
        f287231a = new CopyOnWriteArrayList();
        f287232b = new a();
    }
}
