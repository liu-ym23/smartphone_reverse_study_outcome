package q78;

import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecordingConfiguration;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class e extends AudioManager.AudioRecordingCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f531986a;

    public e(f r100) {
        this.f531986a = r100;
    }

    @Override // android.media.AudioManager.AudioRecordingCallback
    public final void onRecordingConfigChanged(List<AudioRecordingConfiguration> r110) {
        Intrinsics.checkNotNullParameter(r110, FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY);
        super.onRecordingConfigChanged(r110);
        List<AudioRecordingConfiguration> r111 = r110;
        ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator<T> r112 = r111.iterator();
    L4:
        if (r112.hasNext() == false) goto L10;
        AudioRecordingConfiguration r101 = (AudioRecordingConfiguration) r112.next();
        AudioDeviceInfo r102 = r101.getAudioDevice();
        if (r102 == null) goto L8;
        a r103 = new a(r102.getId(), r102.getProductName().toString(), r102.getType(), r102.isSource());
    L9:
        int r104 = r101.getClientAudioSource();
        int r105 = r101.getClientAudioSessionId();
        AudioFormat r106 = r101.getClientFormat();
        boolean r107 = r101.isClientSilenced();
        r100.add(new c(r104, r105, r106, r107, r103, r101.getAudioSource(), r101.getFormat()));
        goto L4
    L8:
        r103 = null;
        goto L9
    L10:
        this.f531986a.a(r100);
    }
}
