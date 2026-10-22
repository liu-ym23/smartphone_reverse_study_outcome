package com.bytedance.livesdk.ktvcommon.midi.view.midiplayerview;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class KtvMidiDataProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f256175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f256176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f256177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zk6.c f256178d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/livesdk/ktvcommon/midi/view/midiplayerview/KtvMidiDataProcessor$HitStatus;", "", "PERFECT", "GOOD", EffectConstants.NORMAL, "MISS", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum HitStatus extends Enum<HitStatus> {
        public static final HitStatus GOOD = null;
        public static final HitStatus MISS = null;
        public static final HitStatus NORMAL = null;
        public static final HitStatus PERFECT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ HitStatus[] f256179a = null;

        static {
            HitStatus r100 = new HitStatus("PERFECT", 0);
            PERFECT = r100;
            HitStatus r101 = new HitStatus("GOOD", 1);
            GOOD = r101;
            HitStatus r102 = new HitStatus(EffectConstants.NORMAL, 2);
            NORMAL = r102;
            HitStatus r103 = new HitStatus("MISS", 3);
            MISS = r103;
            f256179a = new HitStatus[]{r100, r101, r102, r103};
        }

        public static HitStatus valueOf(String r100) {
            return (HitStatus) r27.a.a(HitStatus.class, r100);
        }

        public static HitStatus[] values() {
            return (HitStatus[]) f256179a.clone();
        }

        public HitStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public KtvMidiDataProcessor(d r100, zk6.b r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "dataHolder");
        this.f256177c = r100;
        this.f256178d = r101;
        this.f256175a = new CompositeDisposable();
    }
}
