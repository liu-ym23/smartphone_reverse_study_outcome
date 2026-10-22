package ex5;

import com.bytedance.flow_audio.api.business.asr.error.FlowAsrErrorType;
import com.bytedance.flow_audio.api.business.asr.session.FlowAsrCancelReason;
import com.bytedance.flow_audio.api.foundation.record.AudioEngineAECType;
import com.bytedance.flow_audio.api.foundation.record.AudioEngineSceneType;
import com.bytedance.flow_audio.api.foundation.record.FlowAsrAudioEncoding;
import com.bytedance.flow_audio.api.foundation.record.RecordAmplitudeType;
import com.bytedance.flow_audio.api.scene.FlowAudioAssistantScene;
import com.bytedance.flow_audio.api.service.common.IKMPLoggerService;
import com.bytedance.flow_audio.impl.business.asr.o;
import com.bytedance.flow_audio.impl.business.asr.viewModel.VoiceInputViewModel;
import com.bytedance.flow_audio.impl.core.task.FlowAudioAssistantTask;
import com.bytedance.flow_audio.impl.core.task.FlowAudioAssistantTaskPool;
import com.bytedance.manager.FlowTtsKmpManager;
import com.larus.asr.n2;
import com.larus.asr.w2;
import gw5.g;
import gw5.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lw5.h;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements ww5.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f474718b;

    @Override // ww5.a
    public final void O1() {
        ax5.b r100 = (ax5.b) this.f474718b.getValue();
        Object r101 = r100.f16634b;
        monitor-enter(r101);
        List r102 = CollectionsKt.toList(((LinkedHashMap) r100.f16635c).values());     // Catch: Throwable -> L44
        ((LinkedHashMap) r100.f16635c).clear();     // Catch: Throwable -> L44
        monitor-exit(r101);
        Iterator r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        jw5.a r104 = (jw5.a) r103.next();
        r104.Q1(FlowAsrCancelReason.USER);
        r104.release();
        goto L8
    L10:
        FlowAudioAssistantTaskPool r105 = FlowAudioAssistantTaskPool.f244106e;
        ReentrantLock r106 = r105.f244108b;
        r106.lock();
        Collection r107 = ((LinkedHashMap) r105.f244109c).values();     // Catch: Throwable -> L41
        int r108 = 0;
        if ((r107 instanceof Collection) == true) goto L14;
    L16:
        Iterator r109 = r107.iterator();     // Catch: Throwable -> L41
    L18:
        if (r109.hasNext() == false) goto L24;
        if (((FlowAudioAssistantTaskPool.b) r109.next()).f244114b == false) goto L18;
        r108 = r108 + 1;     // Catch: Throwable -> L41
        if (r108 >= 0) goto L18;
        CollectionsKt.throwCountOverflow();     // Catch: Throwable -> L41
    L24:
        Collection r110 = ((LinkedHashMap) r105.f244109c).values();     // Catch: Throwable -> L41
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L41
        Iterator r112 = r110.iterator();     // Catch: Throwable -> L41
    L26:
        if (r112.hasNext() == false) goto L30;
        Object r113 = r112.next();     // Catch: Throwable -> L41
        if (((FlowAudioAssistantTaskPool.b) r113).f244114b == true) goto L26;
        r111.add(r113);     // Catch: Throwable -> L41
        goto L26
    L30:
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));     // Catch: Throwable -> L41
        Iterator r115 = r111.iterator();     // Catch: Throwable -> L41
    L32:
        if (r115.hasNext() == false) goto L34;
        r114.add(((FlowAudioAssistantTaskPool.b) r115.next()).f244113a);     // Catch: Throwable -> L41
        goto L32
    L34:
        Set r116 = CollectionsKt.toSet(r114);     // Catch: Throwable -> L41
        ((LinkedHashMap) r105.f244109c).clear();     // Catch: Throwable -> L41
        r106.unlock();
        Iterator r117 = r116.iterator();
    L37:
        if (r117.hasNext() == false) goto L39;
        r105.h((FlowAudioAssistantTask) r117.next());
        goto L37
    L39:
        FlowAudioAssistantTaskPool.c("FlowAudioAssistantTaskPool: clear task pool idleReleaseScheduled=" + r116.size() + " inUseDetached=" + r108);
        return;
    L14:
        if (r107.isEmpty() == false) goto L16;
    L41:
        th = move-exception;
        r106.unlock();
        throw th;
    L44:
        th = move-exception;
        throw th;
    }

    public c() {
        this.f474718b = LazyKt.lazy(new a(this));
    }

    @Override // ww5.a
    public final FlowTtsKmpManager S0() {
        return FlowTtsKmpManager.f265443a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ww5.a
    public final void F2(qw5.a r110) {
        Intrinsics.checkNotNullParameter(r110, "config");
        FlowAudioAssistantTaskPool r100 = FlowAudioAssistantTaskPool.f244106e;
        FlowAudioAssistantScene r101 = r110.f534997e;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r110, "config");
        pw5.a r102 = r110.f535000h;
        FlowAudioAssistantTask r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.f530841e;
    L6:
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        if (r100.i(r101) == true) goto L12;
        FlowAudioAssistantTaskPool.c("FlowAudioAssistantTaskPool: pre-connect skipped, task pool disabled scene=" + r101.getRawValue());
        return;
    L12:
        if (FlowAudioAssistantTaskPool.g(r110) == false) goto L14;
        FlowAudioAssistantTaskPool.c("FlowAudioAssistantTaskPool: pre-connect skipped, task pool bypassed scene=" + r101.getRawValue());
        return;
    L14:
        boolean r105 = true;
        if (r104.length() != 0) goto L17;
        boolean r106 = true;
    L18:
        if (r106 == false) goto L20;
        FlowAudioAssistantTaskPool.b("FlowAudioAssistantTaskPool: pre-connect skipped, appKey is empty scene=" + r101.getRawValue());
        return;
    L20:
        pw5.a r107 = r110.f535000h;
        if (r107 != null) goto L23;
    L25:
        r105 = false;
    L26:
        if (r105 == true) goto L56;
        FlowAudioAssistantTaskPool.c("FlowAudioAssistantTaskPool: pre-connect skipped, connect pool disabled scene=" + r101.getRawValue());
        return;
    L56:
        ReentrantLock r108 = r100.f244108b;     // Catch: Throwable -> L46
        r108.lock();     // Catch: Throwable -> L46
    L35:
        th = th;
    L44:
        r108.unlock();     // Catch: Throwable -> L46
        throw th;     // Catch: Throwable -> L46
    L31:
        if (((LinkedHashMap) r100.f244109c).get(r104) == null) goto L37;
        FlowAudioAssistantTaskPool.c("FlowAudioAssistantTaskPool: pre-connect skipped, already initialized appKey=" + r104 + " scene=" + r101.getRawValue());     // Catch: Throwable -> L35
        r108.unlock();     // Catch: Throwable -> L46
        r100 = r100;
    L51:
        return;
    L37:
        FlowAudioAssistantTask r109 = new FlowAudioAssistantTask(r110);     // Catch: Throwable -> L35
        r109.f();     // Catch: Throwable -> L42
        r100.f244109c.put(r104, new FlowAudioAssistantTaskPool.b(r109, false));     // Catch: Throwable -> L42
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L35
        r108.unlock();     // Catch: Throwable -> L46
        StringBuilder r112 = new StringBuilder("FlowAudioAssistantTaskPool: pre-connect completed appKey=");
        r112.append(r104);
        r112.append(" scene=");
        r104 = r101.getRawValue();
        r112.append(r104);
        FlowAudioAssistantTaskPool.c(r112.toString());
        r100 = "FlowAudioAssistantTaskPool: pre-connect completed appKey=";
    L42:
        th = th;
        r103 = r109;
    L46:
        th = move-exception;
        if (r103 == null) goto L49;
        r100.h(r103);
    L49:
        FlowAudioAssistantTaskPool.b("FlowAudioAssistantTaskPool: pre-connect failed appKey=" + r104 + " scene=" + r101.getRawValue() + " error=" + th.getMessage());
        return;
    L23:
        if (r107.f530851o != true) goto L25;
    L17:
        r106 = false;
        goto L18
    L5:
        r104 = null;
        goto L6
    }

    @Override // ww5.a
    public final o M1(qw5.a r110, sw5.a r111) {
        Intrinsics.checkNotNullParameter(r110, "config");
        if (r111 != null) goto L49;
        xw5.b r112 = xw5.c.f565228a;
        AudioEngineAECType r100 = null;
        if (r112 == null) goto L47;
        String r101 = r110.f534993a;
        i r102 = r110.f535002j;
        if (r102 == null) goto L10;
        com.bytedance.flow_audio.api.foundation.record.a r103 = r102.f483061b;
        if (r103 == null) goto L10;
    L11:
        int r104 = r103.f243714a;
        int r105 = r103.f243715b;
        int r106 = r103.f243716c;
        FlowAsrAudioEncoding.a r107 = FlowAsrAudioEncoding.Companion;
        String r108 = r103.f243717d.getFormat();
        r107.getClass();
        if (r108 == null) goto L14;
        String r109 = r108.toLowerCase(Locale.ROOT);
    L15:
        FlowAsrAudioEncoding r113 = FlowAsrAudioEncoding.OPUS;
        if (Intrinsics.areEqual(r109, r113.getFormat()) == true) goto L19;
        r113 = FlowAsrAudioEncoding.PCM;
    L19:
        com.bytedance.flow_audio.api.foundation.record.a r114 = new com.bytedance.flow_audio.api.foundation.record.a(r104, r105, r106, r113, r103.f243718e, r103.f243719f);
        i r115 = r110.f535002j;
        if (r115 == null) goto L24;
        g r116 = r115.f483065f;
        if (r116 == null) goto L24;
        String r117 = r116.f483054a;
    L25:
        String r118 = "";
        if (r117 != null) goto L29;
        r117 = "";
    L29:
        if ((124 & 1) == 0) goto L32;
        r114 = new com.bytedance.flow_audio.api.foundation.record.a(0);
    L32:
        if ((124 & 2) != 0) goto L36;
        r118 = r117;
    L36:
        if ((124 & 8) == 0) goto L38;
        AudioEngineSceneType r119 = AudioEngineSceneType.ASR;
    L40:
        if ((124 & 16) == 0) goto L42;
        RecordAmplitudeType r120 = RecordAmplitudeType.AMPLITUDE_METER;
    L44:
        if ((124 & 32) == 0) goto L46;
        r100 = AudioEngineAECType.NONE;
    L46:
        Intrinsics.checkNotNullParameter(r114, "captureFormat");
        Intrinsics.checkNotNullParameter(r118, "filePath");
        Intrinsics.checkNotNullParameter(r119, "scene");
        Intrinsics.checkNotNullParameter(r120, "amplitudeType");
        Intrinsics.checkNotNullParameter(r100, "aecType");
        r111 = r112.p1();
        goto L49
    L42:
        r120 = null;
        goto L44
    L38:
        r119 = null;
    L24:
        r117 = null;
        goto L25
    L14:
        r109 = null;
    L10:
        r103 = new com.bytedance.flow_audio.api.foundation.record.a(0);
        goto L11
    L47:
        r111 = null;
    L49:
        return new o(r110, r111);
    }

    @Override // ww5.a
    public final VoiceInputViewModel h0(w2 r100, n2 r101) {
        Intrinsics.checkNotNullParameter("asr", "audioScene");
        VoiceInputViewModel r102 = new VoiceInputViewModel("asr", true, r101);
        r102.f244035k = r100;
        return r102;
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [ax5.a] */
    @Override // ww5.a
    public final void U2(String r110, qw5.a r111, h r112) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, "config");
        Intrinsics.checkNotNullParameter(r112, "completion");
        final ax5.b r100 = (ax5.b) this.f474718b.getValue();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, "config");
        Intrinsics.checkNotNullParameter(r112, "completion");
        i r101 = r111.f535002j;
        String r102 = null;
        boolean r103 = false;
        if (r101 != null) goto L5;
        qw5.a r104 = null;
    L7:
        if (r104 != null) goto L12;
        FlowAsrErrorType r105 = FlowAsrErrorType.UNSUPPORTED;
        StringBuilder r106 = new StringBuilder("id=");
        r106.append(r110);
        r106.append(",asrConfigPresent=");
        if (r111.f535002j == null) goto L11;
        r103 = true;
    L11:
        r106.append(r103);
        r112.c1(new hw5.a(r105, "ASR config missing for voice input retry", 500, r106.toString()));
        return;
    L12:
        i r113 = r104.f535002j;
        if (r113 == null) goto L17;
        g r114 = r113.f483065f;
        if (r114 == null) goto L17;
        r102 = r114.f483054a;
    L17:
        if (r102 != null) goto L20;
        r102 = "";
    L20:
        if (r102.length() != 0) goto L22;
        boolean r115 = true;
    L23:
        if (r115 == false) goto L25;
        r112.c1(new hw5.a(FlowAsrErrorType.SOURCE_PREPARE_FAILED, "ASR retry audio file path is empty", -1001, "id=" + r110 + ",filePathEmpty=true"));
        return;
    L25:
        Object r116 = r100.f16634b;
        monitor-enter(r116);
        jw5.a r107 = r100.f16635c.remove(r110);     // Catch: Throwable -> L36
        monitor-exit(r116);
        if (r107 == null) goto L31;
        r107.release();
    L31:
        jw5.a r117 = r100.f16633a.invoke(r104);
        r100.a(r110, r117);
        r117.v2(new ax5.c(r110, r117, r102, r112, new ax5.a(r100)));
        IKMPLoggerService r118 = lp7.a.f510233a;
        StringBuilder r108 = new StringBuilder("voice input retry start id=");
        r108.append(r110);
        r108.append(" hasFilePath=");
        if (r102.length() <= 0) goto L34;
        r103 = true;
    L34:
        r108.append(r103);
        lp7.a.c("FlowAudioVoiceInputRetry", r108.toString());
        r117.start();
        return;
    L36:
        th = move-exception;
        throw th;
    L22:
        r115 = false;
        goto L23
    L5:
        gw5.b r109 = gw5.b.a(r101.getContext());
        g r119 = r101.f483065f;
        r104 = qw5.a.a(r111, r110, null, i.a(r101, r109, g.a(r119, r119.f483054a, false, 6), null, 475), 7678);
        goto L7
    }
}
