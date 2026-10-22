package ms.bd.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import com.ss.ttm.player.MediaPlayer;
import java.security.KeyPairGenerator;
import java.security.spec.ECGenParameterSpec;
import java.util.Date;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes5.dex */
public abstract class p {
    public static boolean a(String r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return false;
    L5:
        if (b(r100, true) == false) goto L7;
        return true;
    L7:
        return b(r100, false);
    }

    public static boolean b(String r110, boolean r111) {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 23) goto L21;
        Date r101 = new Date();
        KeyGenParameterSpec.Builder r102 = new KeyGenParameterSpec.Builder(r110, 12).setAlgorithmParameterSpec(new ECGenParameterSpec((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "cef7c2", new byte[]{97, 98, 22, 83, 14, 112, 54, 86, 102}))).setDigests(new String[]{(String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "cc42f5", new byte[]{65, 73, 102, 11, 11, 119, 54}), (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "13d653", new byte[]{19, 25, 54, 15, 89, 124, 102}), (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "152e3c", new byte[]{19, 31, 96, 92, 89, 37, 96})}).setKeyValidityStart(r101);
        if (r100 < 24) goto L7;
        r102.setAttestationChallenge(r101.toString().getBytes());
    L7:
        Context r103 = d2.f515131b.f515132a;
        if (r103 != null) goto L10;
        PackageManager r104 = null;
    L11:
        if (r111 == false) goto L23;
        if (r100 < 31) goto L23;
        if (r104 == null) goto L23;
        if (r104.hasSystemFeature((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "b1face", new byte[]{114, Base64.padSymbol, 17, 7, 83, 123, 101, 94, 36, 62, 117, 39, 2, 20, 78, 119, 47, 20, 50, 39, 122, 48, 16, 42, 85, 118, 94, 17, 35, 37, 118, 32, 1, 20, 72, 123, 110, 30})) == false) goto L23;
        r102.setDevicePropertiesAttestationIncluded(true);
    L23:
        KeyPairGenerator r105 = KeyPairGenerator.getInstance((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "51affe", new byte[]{1, 16}), (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "837edd", new byte[]{8, 63, 64, 3, 84, 122, 63, 57, 99, 44, 26, 37, 75, 3, 94}));     // Catch: Exception -> L22
        r105.initialize(r102.build());     // Catch: Exception -> L22
        r105.generateKeyPair();     // Catch: Exception -> L22
        return true;
    L10:
        r104 = r103.getPackageManager();
    L21:
        return false;
    }
}
