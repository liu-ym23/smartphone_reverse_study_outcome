package com.ss.android.vesdk.filterparam;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.ttve.nativePort.TEBundle;

/* JADX INFO: loaded from: classes40.dex */
public class VEAudioAECFilterParam extends VEBaseAudioFilterParam {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f455775a;

    public VEAudioAECFilterParam() {
        this.filterName = VEBaseAudioFilterParam.AUDIO_ACOUSTIC_ECHO_CANCELLATION_NAME;
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseAudioFilterParam, com.ss.android.vesdk.filterparam.VEBaseFilterParam
    public final TEBundle getBundle() {
        TEBundle r100 = super.getBundle();
        r100.setString(ExifInterface.TAG_MODEL, this.f455775a);
        return r100;
    }

    public VEAudioAECFilterParam(String r100) {
        this();
        this.f455775a = r100;
    }
}
