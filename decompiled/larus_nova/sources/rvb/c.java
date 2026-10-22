package rvb;

import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmSubtitleAsrOptConfig;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.helper.MmSubtitleSmoothType;
import com.ss.android.lark.pb.minutes.v1.RecordingSubtitleData;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecordingSubtitleData f539529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f539530b;

    public c(RecordingSubtitleData r100, a r101) {
        this.f539529a = r100;
        this.f539530b = r101;
    }

    public final void a() {
        Long r100 = this.f539529a.seg_id;
        if (r100 == null) goto L5;
        long r101 = r100.longValue();
    L6:
        boolean r102 = this.f539530b.f539515e.containsKey(Long.valueOf(r101));
        if (r102 == false) goto L9;
        int r103 = -1;
    L10:
        a.d r104 = this.f539530b.f539514d.get(Long.valueOf(r101));
        ConcurrentHashMap<Long, a.d> r105 = this.f539530b.f539514d;
        Long r106 = Long.valueOf(r101);
        if (r104 == null) goto L13;
        RecordingSubtitleData r107 = this.f539529a;
        int r108 = r104.f539526b;
        Intrinsics.checkNotNullParameter(r107, "data");
        a.d r109 = new a.d(r107, r108);
    L14:
        r105.put(r106, r109);
        if (r102 == true) goto L17;
        this.f539530b.f539515e.put(Long.valueOf(r101), Boolean.TRUE);
    L17:
        a r110 = this.f539530b;
        RecordingSubtitleData r111 = this.f539529a;
        MmSubtitleSmoothType r112 = r110.f539511a;
        MmSubtitleSmoothType r113 = MmSubtitleSmoothType.TARGET;
        if (r112 != r113) goto L20;
        RecordingSubtitleData.Subtitle r114 = r111.target;
    L21:
        RecordingSubtitleData.SSDSpeaker r115 = r111.ssd_speaker;
        RecordingSubtitleData.Subtitle r116 = null;
        if (r115 == null) goto L25;
        String r117 = r115.speaker_user_id;
        if (r117 == null) goto L25;
    L31:
        if (r114 == null) goto L62;
        MmSubtitleAsrOptConfig r118 = r110.f539521k;
        if (r118 != null) goto L35;
    L37:
        boolean r119 = false;
    L38:
        if (r119 == false) goto L62;
        Long r120 = r110.f539516f.get(r117);
        if (r120 != null) goto L42;
    L45:
        r110.f539516f.put(r117, Long.valueOf(r101));
    L46:
        if (r120 == null) goto L62;
        a.d r121 = r110.f539514d.get(r120);
        if (r121 == null) goto L50;
        RecordingSubtitleData r122 = r121.f539525a;
    L51:
        if (r122 != null) goto L53;
    L57:
        if (r122 == null) goto L62;
        if (a.b(r122) == false) goto L62;
        if (r116 == null) goto L62;
        r110.f539516f.remove(r117);
        goto L62
    L53:
        if (r110.f539511a != r113) goto L55;
        RecordingSubtitleData.Subtitle r123 = r122.target;
    L56:
        r116 = r123;
        goto L57
    L55:
        r123 = r122.source;
        goto L56
    L50:
        r122 = null;
        goto L51
    L42:
        if (r120.longValue() < r101) goto L45;
        if (a.b(r111) == true) goto L46;
    L35:
        if (r118.getEnabled() != true) goto L37;
        r119 = true;
    L62:
        a r124 = this.f539530b;
        if (r124.f539518h.compareAndSet(false, true) == false) goto L71;
        lvb.a.a(r124.f539513c, "start consume loop");
        if (r124.f539517g != null) goto L67;
        PthreadHandlerThreadV2 r125 = new PthreadHandlerThreadV2("mmSubtitleSmoothThread");
        ThreadMethodProxy.start(r125);
        r124.f539517g = new b(r124, r125.getLooper());
    L67:
        Handler r126 = r124.f539517g;
        if (r126 == null) goto L72;
        r126.sendEmptyMessage(1);
        return;
    L72:
        return;
    L71:
        return;
    L25:
        if (r115 == null) goto L27;
        r117 = r115.user_id;
    L28:
        if (r117 != null) goto L31;
        r117 = "1";
        goto L31
    L27:
        r117 = null;
        goto L28
    L20:
        r114 = r111.source;
        goto L21
    L13:
        r109 = new a.d(this.f539529a, r103);
        goto L14
    L9:
        r103 = 0;
        goto L10
    L5:
        r101 = 0;
        goto L6
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
