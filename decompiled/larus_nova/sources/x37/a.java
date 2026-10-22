package x37;

import android.media.MediaMetadataRetriever;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    public static String a(MediaMetadataRetriever r110) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {9};
        f06.b r111 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE));
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r104 = r103;
        int r105 = r104.length;
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L15;
        f06.a r107 = r104[r106];
        int r112 = r106;
        int r113 = r105;
        f06.a[] r114 = r104;
        f06.d r108 = r107.preInvoke(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE, "android/media/MediaMetadataRetriever", "extractMetadata", r110, r101, "java.lang.String", r111);     // Catch: Exception -> L22
        if (r108.f474982a == true) goto L17;
        r100.add(r107);     // Catch: Exception -> L22
    L17:
        if (r108.f474982a == false) goto L21;
        return (String) r108.f474983b;
    L21:
        return r110.extractMetadata(9);
    L14:
        r106 = r112 + 1;
        r105 = r113;
        r104 = r114;
        goto L8
    L15:
        r108 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
