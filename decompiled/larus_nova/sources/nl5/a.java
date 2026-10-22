package nl5;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import eu5.b;
import f06.d;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public final class a {
    public static Pair<Integer, Integer> b(String r100) {
        int r101 = 0;
    L16:
        int r102 = 0;
    L17:
        tt5.a.d("MediaMimeType", "get video width or height error");
    L19:
        return new Pair(Integer.valueOf(r101), Integer.valueOf(r102));
    L4:
        if (TextUtils.isEmpty(r100) == true) goto L6;
        MediaMetadataRetriever r103 = new MediaMetadataRetriever();     // Catch: Exception -> L16
        r103.setDataSource(b.f474075a, UriProtector.parse(r100));     // Catch: Exception -> L16
        String r104 = a(r103, 18);     // Catch: Exception -> L16
        String r105 = a(r103, 19);     // Catch: Exception -> L16
        if (TextUtils.isEmpty(r104) == false) goto L10;
    L14:
        int r106 = 0;
    L15:
        int r107 = r101;
        r101 = r106;
        r102 = r107;
        goto L19
    L10:
        if (TextUtils.isEmpty(r105) == true) goto L14;
        r102 = CastIntegerProtector.parseInt(r104);     // Catch: Exception -> L16
        r101 = r102;
        r106 = CastIntegerProtector.parseInt(r105);     // Catch: Exception -> L20
        goto L15
    L6:
        return new Pair(0, 0);
    }

    public static String a(MediaMetadataRetriever r110, int r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r111)};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE));
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE, "android/media/MediaMetadataRetriever", "extractMetadata", r110, r101, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (String) r107.f474983b;
    L21:
        return r110.extractMetadata(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
