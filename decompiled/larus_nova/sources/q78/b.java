package q78;

import android.app.Application;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import android.os.Build;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import m58.h;

/* JADX INFO: loaded from: classes24.dex */
public final class b {
    public static final boolean a(AudioRecord r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "tag");
        boolean r102 = false;
        if (Build.VERSION.SDK_INT < 29) goto L46;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L34
        CharSequence r104 = null;
        if (r100 == null) goto L7;
        AudioRecordingConfiguration r105 = r100.getActiveRecordingConfiguration();     // Catch: Throwable -> L34
    L8:
        if (r105 == null) goto L32;
        int r106 = c68.b.f22600a;     // Catch: Throwable -> L34
        StringBuilder r107 = new StringBuilder("[");     // Catch: Throwable -> L34
        r107.append(r101);     // Catch: Throwable -> L34
        r107.append("][checkActiveRecordingConfiguration] AudioRecord(");     // Catch: Throwable -> L34
        r107.append(r100);     // Catch: Throwable -> L34
        r107.append("), isClientSilenced: ");     // Catch: Throwable -> L34
        r107.append(r105.isClientSilenced());     // Catch: Throwable -> L34
        r107.append(", AudioRecord.state: ");     // Catch: Throwable -> L34
        if (r100 == null) goto L12;
        Integer r108 = Integer.valueOf(r100.getState());     // Catch: Throwable -> L34
    L13:
        r107.append(r108);     // Catch: Throwable -> L34
        r107.append(", AudioRecord.getRecordingState: ");     // Catch: Throwable -> L34
        if (r100 == null) goto L16;
        Integer r109 = Integer.valueOf(r100.getRecordingState());     // Catch: Throwable -> L34
    L17:
        r107.append(r109);     // Catch: Throwable -> L34
        c68.b.d("AudioRecordUtils", r107.toString());     // Catch: Throwable -> L34
        if (r105.isClientSilenced() == false) goto L31;
        StringBuilder r110 = new StringBuilder("[");     // Catch: Throwable -> L34
        r110.append(r101);     // Catch: Throwable -> L34
        r110.append("][checkActiveRecordingConfiguration] audioDevice.id: ");     // Catch: Throwable -> L34
        AudioDeviceInfo r111 = r105.getAudioDevice();     // Catch: Throwable -> L34
        if (r111 == null) goto L22;
        Integer r112 = Integer.valueOf(r111.getId());     // Catch: Throwable -> L34
    L23:
        r110.append(r112);     // Catch: Throwable -> L34
        c68.b.d("AudioRecordUtils", r110.toString());     // Catch: Throwable -> L34
        StringBuilder r113 = new StringBuilder("[");     // Catch: Throwable -> L34
        r113.append(r101);     // Catch: Throwable -> L34
        r113.append("][checkActiveRecordingConfiguration] audioDevice.type: ");     // Catch: Throwable -> L34
        AudioDeviceInfo r114 = r105.getAudioDevice();     // Catch: Throwable -> L34
        if (r114 == null) goto L26;
        Integer r115 = Integer.valueOf(r114.getType());     // Catch: Throwable -> L34
    L27:
        r113.append(r115);     // Catch: Throwable -> L34
        c68.b.d("AudioRecordUtils", r113.toString());     // Catch: Throwable -> L34
        StringBuilder r116 = new StringBuilder("[");     // Catch: Throwable -> L34
        r116.append(r101);     // Catch: Throwable -> L34
        r116.append("][checkActiveRecordingConfiguration] audioDevice.productName: ");     // Catch: Throwable -> L34
        AudioDeviceInfo r117 = r105.getAudioDevice();     // Catch: Throwable -> L34
        if (r117 == null) goto L30;
        r104 = r117.getProductName();     // Catch: Throwable -> L34
    L30:
        r116.append(r104);     // Catch: Throwable -> L34
        c68.b.d("AudioRecordUtils", r116.toString());     // Catch: Throwable -> L34
        c68.b.d("AudioRecordUtils", "[" + r101 + "][checkActiveRecordingConfiguration] clientAudioSource: " + r105.getClientAudioSource());     // Catch: Throwable -> L34
        goto L31
    L26:
        r115 = null;
        goto L27
    L22:
        r112 = null;
    L31:
        r102 = r105.isClientSilenced();     // Catch: Throwable -> L34
        goto L32
    L16:
        r109 = null;
        goto L17
    L12:
        r108 = null;
    L32:
        Object r118 = Result.m9449constructorimpl(Boolean.valueOf(r102));     // Catch: Throwable -> L34
    L36:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r118);
        if (r119 == null) goto L39;
        int r120 = c68.b.f22600a;
        c68.b.b("AudioRecordUtils", "[" + r101 + "]checkActiveRecordingConfiguration error :" + r119);
    L39:
        Boolean r121 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r118) == false) goto L43;
        r118 = r121;
    L43:
        return ((Boolean) r118).booleanValue();
    L7:
        r105 = null;
    L34:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L36
    L46:
        return false;
    }

    public static final void b(f r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r101, "caller");
        if (Build.VERSION.SDK_INT < 29) goto L19;
        AudioManager.AudioRecordingCallback r102 = (AudioManager.AudioRecordingCallback) r100.f531987a.getValue();
        if (r102 == null) goto L21;
        m58.b r103 = h.f512140k;
        if (r103 == null) goto L11;
        Application r104 = r103.getApplication();
        if (r104 == null) goto L11;
        Object r105 = r104.getSystemService("audio");
    L13:
        if ((r105 instanceof AudioManager) == false) goto L15;
        AudioManager r106 = (AudioManager) r105;
    L16:
        if (r106 == null) goto L18;
        r106.registerAudioRecordingCallback(r102, null);
    L18:
        int r107 = c68.b.f22600a;
        c68.b.d("AudioRecordUtils", "[" + r101 + "] register callback_" + r102.hashCode() + " success");
        return;
    L15:
        r106 = null;
    L11:
        r105 = null;
        goto L13
    L21:
        return;
    L19:
        int r108 = c68.b.f22600a;
        c68.b.d("AudioRecordUtils", "[" + r101 + "] register callback is not supported before Q");
    }

    public static final void c(f r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r101, "caller");
        if (Build.VERSION.SDK_INT < 29) goto L18;
        AudioManager.AudioRecordingCallback r102 = (AudioManager.AudioRecordingCallback) r100.f531987a.getValue();
        if (r102 == null) goto L20;
        m58.b r103 = h.f512140k;
        AudioManager r104 = null;
        if (r103 == null) goto L11;
        Application r105 = r103.getApplication();
        if (r105 == null) goto L11;
        Object r106 = r105.getSystemService("audio");
    L13:
        if ((r106 instanceof AudioManager) == false) goto L15;
        r104 = (AudioManager) r106;
    L15:
        if (r104 == null) goto L17;
        r104.unregisterAudioRecordingCallback(r102);
    L17:
        int r107 = c68.b.f22600a;
        c68.b.d("AudioRecordUtils", "[" + r101 + "] unregister callback_" + r102.hashCode() + " success");
        return;
    L11:
        r106 = null;
        goto L13
    L20:
        return;
    L18:
        int r108 = c68.b.f22600a;
        c68.b.d("AudioRecordUtils", "[" + r101 + "] unregister callback is not supported before Q");
    }
}
