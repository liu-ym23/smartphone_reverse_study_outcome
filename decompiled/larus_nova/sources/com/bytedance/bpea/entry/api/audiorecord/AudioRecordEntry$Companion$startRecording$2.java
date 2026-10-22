package com.bytedance.bpea.entry.api.audiorecord;

import android.media.AudioRecord;
import android.media.MediaSyncEvent;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import f06.b;
import f06.c;
import fna.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class AudioRecordEntry$Companion$startRecording$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MediaSyncEvent $syncEvent;
    final /* synthetic */ AudioRecord $this_startRecording;

    public AudioRecordEntry$Companion$startRecording$2(AudioRecord r100, MediaSyncEvent r101) {
        this.$this_startRecording = r100;
        this.$syncEvent = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        INVOKEVIRTUAL_com_bytedance_bpea_entry_api_audiorecord_AudioRecordEntry$Companion$startRecording$2_com_obric_performance_power_monitor_audioin_AudioInLancet_startRecording(this.$this_startRecording, this.$syncEvent);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    public static void INVOKEVIRTUAL_com_bytedance_bpea_entry_api_audiorecord_AudioRecordEntry$Companion$startRecording$2_com_obric_performance_power_monitor_audioin_AudioInLancet_startRecording(AudioRecord r100, MediaSyncEvent r101) {
        if (g.d() == true) goto L6;
        a(r100, r101);
        return;
    L6:
        a(r100, r101);
        if ((r100 instanceof AudioRecord) == false) goto L10;
        hna.a.b(r100.hashCode());
        return;
    }

    public static void a(AudioRecord r110, MediaSyncEvent r111) {
        c r100 = new c();
        Object[] r101 = {r111};
        b r112 = new b();
        if (r100.b(100400, "android/media/AudioRecord", "startRecording", r110, r101, "void", r112).f474982a == false) goto L6;
        r100.a(100400, "android/media/AudioRecord", "startRecording", r110, r101, null, r112, false);
        return;
    L6:
        r110.startRecording(r111);
        r100.a(100400, "android/media/AudioRecord", "startRecording", r110, r101, null, r112, true);
    }
}
