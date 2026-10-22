package j2a;

import bu9.j;
import bu9.m;
import bu9.o;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.platform.model.camera.ve.Ratio;
import com.ss.android.vesdk.VEAudioEncodeSettings;
import com.ss.android.vesdk.VEVideoEncodeSettings;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import pq9.k;

/* JADX INFO: loaded from: classes31.dex */
public final class b extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Ratio f497044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f497045e;

    @Override // j2a.c
    public final int c() {
        if (this.f497044d != Ratio.RATIO_FULL_SCREEN) goto L6;
        k.f530291a.getClass();
        return k.f530294d.getFirst().intValue();
    L6:
        return this.f497047b;
    }

    public final VEAudioEncodeSettings d() {
        j r100 = ((m) this.f497045e.getValue()).a();
        if (r100 == null) goto L14;
        VEAudioEncodeSettings.Builder r101 = new VEAudioEncodeSettings.Builder();
        int r102 = r100.a();
        if (r102 != 0) goto L7;
        VEAudioEncodeSettings.ENCODE_STANDARD r103 = VEAudioEncodeSettings.ENCODE_STANDARD.ENCODE_STANDARD_WAV;
    L11:
        VEAudioEncodeSettings r104 = r101.setCodec(r103).Build();
        if (r104 == null) goto L14;
        return r104;
    L7:
        if (r102 == 1) goto L9;
        r103 = VEAudioEncodeSettings.ENCODE_STANDARD.ENCODE_STANDARD_AAC;
        goto L11
    L9:
        r103 = VEAudioEncodeSettings.ENCODE_STANDARD.ENCODE_STANDARD_PCM;
    L14:
        return new VEAudioEncodeSettings.Builder().setCodec(VEAudioEncodeSettings.ENCODE_STANDARD.ENCODE_STANDARD_AAC).Build();
    }

    public final VEVideoEncodeSettings e() {
        Pair<Integer, Integer> r100 = b();
        o r101 = ((m) this.f497045e.getValue()).b();
        if (r101 == null) goto L13;
        VEVideoEncodeSettings.Builder r102 = new VEVideoEncodeSettings.Builder(1).setSupportHwEnc(r101.d()).setVideoRes(r100.getFirst().intValue(), r100.getSecond().intValue()).enableRecordingMp4(r101.a());
        int r103 = r101.b();
        if (r103 != 0) goto L7;
        VEVideoEncodeSettings.ENCODE_STANDARD r104 = VEVideoEncodeSettings.ENCODE_STANDARD.ENCODE_STANDARD_H264;
    L11:
        VEVideoEncodeSettings r105 = r102.setEncodeStandard(r104).setEncodeProfile(VEVideoEncodeSettings.ENCODE_PROFILE.ENCODE_PROFILE_MAIN).setFps(r101.c()).build();
        if (r105 == null) goto L13;
        return r105;
    L7:
        if (r103 == 2) goto L9;
        r104 = VEVideoEncodeSettings.ENCODE_STANDARD.ENCODE_STANDARD_ByteVC1;
        goto L11
    L9:
        r104 = VEVideoEncodeSettings.ENCODE_STANDARD.ENCODE_STANDARD_MPEG4;
    L13:
        Pair<Integer, Integer> r106 = b();
        return new VEVideoEncodeSettings.Builder(1).setSupportHwEnc(true).setVideoRes(r106.getFirst().intValue(), r106.getSecond().intValue()).enableRecordingMp4(true).setEncodeStandard(VEVideoEncodeSettings.ENCODE_STANDARD.ENCODE_STANDARD_ByteVC1).setEncodeProfile(VEVideoEncodeSettings.ENCODE_PROFILE.ENCODE_PROFILE_MAIN).build();
    }

    public b(Ratio r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_RATION);
        super(r100);
        this.f497044d = r100;
        this.f497045e = LazyKt.lazy(new a());
    }
}
