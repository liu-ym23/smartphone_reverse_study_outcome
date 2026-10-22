package ms.bd.c;

import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.ttm.player.MediaPlayer;
import java.io.BufferedReader;
import java.util.HashMap;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes5.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f515385a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f515386b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f515387c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f515388d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f515389e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f515390f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f515391g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f515392h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f515393i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final u f515394j = null;

    static {
        f515385a = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "a7ce96", new byte[]{64, 39, 31, 18, 3, 50, 113, 25, 32});
        f515386b = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "12cfb9", new byte[]{8, 49, 2, 22, 74, 47, 32, 22});
        f515387c = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "f0b44b", new byte[]{81, 55, 16, 84, 30, 103, 96, 2});
        f515388d = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "9cad6a", new byte[]{56, 98});
        f515389e = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "fe9478", new byte[]{ByteCompanionObject.MAX_VALUE, 112});
        f515390f = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "7109ca", new byte[]{32, 39});
        f515391g = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "e1092e", new byte[]{121, 50, 91});
        f515392h = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "28da52", new byte[]{46, 51, 25});
        f515393i = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "024b3c", new byte[]{34, 63, 85, 19});
        f515394j = new u();
    }

    public static HashMap c() {
        HashMap r100 = new HashMap();
        BufferedReader r101 = null;
        PolarisFileReaderWrapper r102 = new PolarisFileReaderWrapper((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "0e4185", new byte[]{110, 119, 85, 74, 4, 109, 48, 84, 112, 104, 47, 97, 72}));     // Catch: Throwable -> L21
        BufferedReader r103 = new BufferedReader(r102);     // Catch: Throwable -> L20
    L33:
        String r104 = r103.readLine();     // Catch: Throwable -> L19
        if (r104 != null) goto L11;
        r103.close();     // Catch: Throwable -> L29
    L35:
        r102.close();     // Catch: Throwable -> L30
    L28:
        return r100;
    L11:
        String[] r105 = r104.split((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "27c013", new byte[]{121}), 2);     // Catch: Throwable -> L19
        if (r105.length < 2) goto L33;
        String r106 = r105[0].trim();     // Catch: Throwable -> L19
        String r107 = r105[1].trim();     // Catch: Throwable -> L19
        if (r100.get(r106) != null) goto L33;
        r100.put(r106, r107);     // Catch: Throwable -> L19
    L19:
        r101 = r103;
    L22:
        if (r101 != null) goto L31;
    L26:
        if (r102 == null) goto L28;
    L31:
        r101.close();     // Catch: Throwable -> L25
    L21:
        r102 = null;
        goto L22
    }

    public static String a(String r110) {
        String r100 = null;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r110);     // Catch: Throwable -> L14
        if (r101.exists() == false) goto L6;
        PolarisFileReaderWrapper r111 = new PolarisFileReaderWrapper(r101);     // Catch: Throwable -> L14
        BufferedReader r102 = new BufferedReader(r111);     // Catch: Throwable -> L13
        r100 = r102.readLine();     // Catch: Throwable -> L12
        r102.close();     // Catch: Throwable -> L27
    L36:
        r111.close();     // Catch: Throwable -> L22
    L23:
        if (r100 != null) goto L26;
        return (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "d34651", new byte[]{37});
    L26:
        return r100.trim();
    L15:
        if (r102 != null) goto L28;
    L19:
        if (r111 == null) goto L23;
    L28:
        r102.close();     // Catch: Throwable -> L18
    L13:
        r102 = null;
        goto L15
    L6:
        return (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "0ad581", new byte[]{113});
    L14:
        r111 = null;
        r102 = null;
        goto L15
    }

    public static String b(HashMap r100, String r101) {
        String r102 = (String) r100.get(r101);     // Catch: Throwable -> L4
    L5:
        if (r102 != null) goto L8;
        return "";
    L8:
        return r102.trim();
    L4:
        r102 = null;
        goto L5
    }
}
