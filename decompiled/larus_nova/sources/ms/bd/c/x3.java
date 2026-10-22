package ms.bd.c;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.ss.ttm.player.MediaPlayer;

/* JADX INFO: loaded from: classes42.dex */
public abstract class x3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f515432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f515433b = null;

    static {
        f515433b = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "c4c507", new byte[]{51, 51, 29, 81, 27, 57, 33});
    }

    public static String a() {
        String r100 = f515432a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        SensorManager r101 = (SensorManager) d2.f515131b.f515132a.getSystemService((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "d60c34", new byte[]{102, 49, 77, 4, 3, 49}));
        if (r101 == null) goto L18;
        StringBuilder r102 = new StringBuilder();
        Sensor r103 = r101.getDefaultSensor(1);
        if (r103 == null) goto L10;
        r102.append(1);
        r102.append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "5ead01", new byte[]{27}));
        r102.append(r103.getName());
        r102.append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "2378ec", new byte[]{28}));
        r102.append(r103.getVendor());
        r102.append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "5b0fba", new byte[]{56}));
    L10:
        Sensor r104 = r101.getDefaultSensor(5);
        if (r104 == null) goto L13;
        r102.append(5);
        r102.append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "b283c1", new byte[]{76}));
        r102.append(r104.getName());
        r102.append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "3f3efe", new byte[]{29}));
        r102.append(r104.getVendor());
        r102.append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "2cf2a4", new byte[]{63}));
    L13:
        Sensor r105 = r101.getDefaultSensor(9);
        if (r105 == null) goto L16;
        r102.append(9);
        r102.append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "0567bc", new byte[]{30}));
        r102.append(r105.getName());
        r102.append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "b38f69", new byte[]{76}));
        r102.append(r105.getVendor());
    L16:
        f515432a = r102.toString();
    L18:
        if (f515432a != null) goto L21;
        f515432a = f515433b;
    L21:
        return f515432a;
    }
}
