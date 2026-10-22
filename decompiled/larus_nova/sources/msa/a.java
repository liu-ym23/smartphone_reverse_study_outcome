package msa;

import android.media.MediaMetadataRetriever;
import android.media.SoundPool;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import f06.b;
import f06.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SoundPool f515529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Integer> f515530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f515531c;

    /* JADX INFO: renamed from: msa.a$a, reason: collision with other inner class name */
    public class C6848a implements SoundPool.OnLoadCompleteListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f515532a;

        public C6848a(a r100) {
            this.f515532a = r100;
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public final void onLoadComplete(SoundPool r100, int r101, int r110) {
            a r102 = this.f515532a;
            r102.f515531c = r102.f515529a.play(r101, 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }

    public a(SoundPool r100) {
        this.f515530b = new HashMap();
        this.f515529a = r100;
        r100.setOnLoadCompleteListener(new C6848a(this));
    }

    public static String a(MediaMetadataRetriever r110) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {9};
        b r111 = new b();
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
        d r108 = r107.preInvoke(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE, "android/media/MediaMetadataRetriever", "extractMetadata", r110, r101, "java.lang.String", r111);     // Catch: Exception -> L22
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
        r108 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
