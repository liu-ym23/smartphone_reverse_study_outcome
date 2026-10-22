package com.ss.android.lark.audio.voiceinput.processor;

import com.ss.android.lark.log.Log;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class VoiceDataProcessDispatcher implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<ProcessType, d> f409341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ProcessType f409342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f409343c;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f409344a = null;

        static {
            int[] r100 = new int[ProcessType.values().length];
            r100[ProcessType.OnlyAsr.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ProcessType.VoiceWithAsr.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f409344a = r100;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.c
    public final void b() {
        Iterator r100 = ((LinkedHashMap) this.f409341a).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        Map.Entry r101 = (Map.Entry) r100.next();
        ProcessType r102 = (ProcessType) r101.getKey();
        ((d) r101.getValue()).b();
        goto L4
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.c
    public final void e() {
        Map<ProcessType, d> r100 = this.f409341a;
        LinkedHashMap r101 = (LinkedHashMap) r100;
        d r102 = (d) r101.get(this.f409342b);
        if (r102 == null) goto L6;
        r102.d();
        return;
    }

    public final String i() {
        Map<ProcessType, d> r100 = this.f409341a;
        LinkedHashMap r101 = (LinkedHashMap) r100;
        d r102 = (d) r101.get(this.f409342b);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.a();
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.c
    public final void onDestroy() {
        Iterator r100 = ((LinkedHashMap) this.f409341a).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        Map.Entry r101 = (Map.Entry) r100.next();
        ProcessType r102 = (ProcessType) r101.getKey();
        ((d) r101.getValue()).onDestroy();
        goto L4
    L6:
        ((LinkedHashMap) this.f409341a).clear();
    }

    public VoiceDataProcessDispatcher(h r100) {
        Intrinsics.checkNotNullParameter(r100, "voiceInputContext");
        LinkedHashMap r101 = new LinkedHashMap();
        UploadProcessor r102 = new UploadProcessor(r100);
        r101.put(ProcessType.OnlyVoice, r102);
        r101.put(ProcessType.OnlyAsr, new AsrProcessor(r100));
        ProcessType r103 = ProcessType.VoiceWithAsr;
        r101.put(r103, new VoiceWithAsrProcessor(r100));
        r101.put(ProcessType.Extend, new com.ss.android.lark.audio.voiceinput.processor.b());
        this.f409341a = r101;
        this.f409342b = r103;
        g r104 = new g(0);
        r104.f409359d = true;
        this.f409343c = r104;
    }

    public final void a(ProcessType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Map<ProcessType, d> r101 = this.f409341a;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        d r103 = (d) r102.get(this.f409342b);
        if (r103 == null) goto L6;
        r103.f(r100);
        return;
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.c
    public final void d(com.ss.android.lark.audio.voiceinput.d.b r100) {
        int r101 = b.f409344a[this.f409342b.ordinal()];
        AsrProcessor r102 = null;
        VoiceWithAsrProcessor r103 = null;
        if (r101 != 1) goto L5;
        Object r104 = ((LinkedHashMap) this.f409341a).get(ProcessType.OnlyAsr);
        if ((r104 instanceof AsrProcessor) == false) goto L15;
        r102 = (AsrProcessor) r104;
    L15:
        if (r102 == null) goto L21;
        r102.f409326g = r100;
        r102.f409320a.f409362c.H2(r102.f409328i);
        return;
    L21:
        return;
    L5:
        if (r101 == 2) goto L7;
        Log.i("VoiceInputService", "[VoiceDataProcessDispatcher]no need registerAsrCallback,because currentProcessType is:" + this.f409342b);
        return;
    L7:
        Object r105 = ((LinkedHashMap) this.f409341a).get(ProcessType.VoiceWithAsr);
        if ((r105 instanceof VoiceWithAsrProcessor) == false) goto L10;
        r103 = (VoiceWithAsrProcessor) r105;
    L10:
        if (r103 == null) goto L19;
        AsrProcessor r106 = r103.f409345a;
        r106.f409326g = r100;
        r106.f409320a.f409362c.H2(r106.f409328i);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.ss.android.lark.audio.voiceinput.processor.VoiceDataProcessDispatcher$onStartRecord$1] */
    @Override // com.ss.android.lark.audio.voiceinput.processor.c
    public final void c(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "strFileName");
        Intrinsics.checkNotNullParameter(r101, "cid");
        Map<ProcessType, d> r103 = this.f409341a;
        LinkedHashMap r104 = (LinkedHashMap) r103;
        d r105 = (d) r104.get(this.f409342b);
        if (r105 == 0) goto L6;
        r105.h(this.f409343c, new VoiceDataProcessDispatcher$onStartRecord$1(this));
        return;
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.c
    public final void g(String r100, String r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "strFileName");
        Intrinsics.checkNotNullParameter(r101, "cid");
        Log.i("VoiceInputService", "[VoiceDataProcessDispatcher]onAudioRecorded currentProcessType:" + this.f409342b);
        g r104 = this.f409343c;
        r104.f409356a = ByteBuffer.wrap(new byte[0]);
        r104.f409357b = true;
        d r105 = (d) ((LinkedHashMap) this.f409341a).get(this.f409342b);
        if (r105 == null) goto L6;
        r105.g(this.f409343c, new VoiceDataProcessDispatcher$onAudioRecorded$2$1(this));
        r105.e();
        return;
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.c
    public final void h(ByteBuffer r100, int r101, double r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        g r104 = this.f409343c;
        r104.f409356a = r100;
        r104.f409357b = false;
        r104.f409358c = false;
        Map<ProcessType, d> r105 = this.f409341a;
        LinkedHashMap r106 = (LinkedHashMap) r105;
        d r107 = (d) r106.get(this.f409342b);
        if (r107 == null) goto L8;
        r107.g(this.f409343c, new VoiceDataProcessDispatcher$onUpdateAudio$2(this));
        return;
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.c
    public final void f(String r100, String r101, boolean r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "strFileName");
        Intrinsics.checkNotNullParameter(r101, "cid");
        Map<ProcessType, d> r105 = this.f409341a;
        LinkedHashMap r106 = (LinkedHashMap) r105;
        d r107 = (d) r106.get(this.f409342b);
        if (r107 == null) goto L6;
        r107.i(this.f409343c, r100, r104);
        return;
    }
}
