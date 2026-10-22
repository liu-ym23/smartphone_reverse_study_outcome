package nl5;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import eu5.b;
import f06.d;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static Pair<Integer, Integer> b(String r4) {
        int r0 = 0;
    L16:
        int r5 = 0;
    L17:
        tt5.a.d("MediaMimeType", "get video width or height error");
    L19:
        return new Pair(Integer.valueOf(r0), Integer.valueOf(r5));
    L4:
        if (TextUtils.isEmpty(r4) == true) goto L6;
        MediaMetadataRetriever r1 = new MediaMetadataRetriever();     // Catch: Exception -> L16
        r1.setDataSource(b.a, UriProtector.parse(r4));     // Catch: Exception -> L16
        String r6 = a(r1, 18);     // Catch: Exception -> L16
        String r2 = a(r1, 19);     // Catch: Exception -> L16
        if (TextUtils.isEmpty(r6) == false) goto L10;
    L14:
        int r7 = 0;
    L15:
        int r3 = r0;
        r0 = r7;
        r5 = r3;
        goto L19
    L10:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        r5 = CastIntegerProtector.parseInt(r6);     // Catch: Exception -> L16
        r0 = r5;
        r7 = CastIntegerProtector.parseInt(r2);     // Catch: Exception -> L20
        goto L15
    L6:
        return new Pair(0, 0);
    }

    public static String a(MediaMetadataRetriever r18, int r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {Integer.valueOf(r19)};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(100023);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(100023, "android/media/MediaMetadataRetriever", "extractMetadata", r18, r1, "java.lang.String", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (String) r4.b;
    L21:
        return r18.extractMetadata(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }
}
