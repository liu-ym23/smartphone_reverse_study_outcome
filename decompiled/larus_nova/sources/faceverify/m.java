package faceverify;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dtf.face.config.AndroidClientConfig;
import com.dtf.face.log.RecordService;
import com.dtf.face.ui.toyger.FaceShowElderlyFragment;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SoundPool f476170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<String, Integer> f476171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f476172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f476173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile List<Integer> f476174e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f476175f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final File f476176g = null;

    public static class a implements SoundPool.OnLoadCompleteListener {
        public a() {
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public void onLoadComplete(SoundPool r100, int r101, int r102) {
            if (m.f476174e.contains(Integer.valueOf(r101)) == true) goto L6;
            m.f476174e.add(Integer.valueOf(r101));
        L6:
            if (m.f476172c != null) goto L8;
        L10:
            Integer r103 = 0;
        L11:
            if (r101 != 0) goto L13;
            return;
        L13:
            if (r103.intValue() != r101) goto L17;
            m.a(r101);
            return;
        L17:
            return;
        L8:
            if (m.f476171b.get(m.f476172c) == null) goto L10;
            r103 = m.f476171b.get(m.f476172c);
            goto L11
        }
    }

    static {
        f476176g = new PolarisFileWrapper(hs7.a.h().getContext().getCacheDir(), FaceShowElderlyFragment.DOWNLOAD_AUDIO_PATH);
    }

    public static synchronized void a() {
        monitor-enter(m.class);
        f476171b = new HashMap();     // Catch: Throwable -> L42
        f476174e = new ArrayList();     // Catch: Throwable -> L42
        AudioAttributes r100 = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();     // Catch: Throwable -> L42
        SoundPool r101 = new SoundPool.Builder().setMaxStreams(1).setAudioAttributes(r100).build();     // Catch: Throwable -> L42
        f476170a = r101;     // Catch: Throwable -> L42
        r101.setOnLoadCompleteListener(new a());     // Catch: Throwable -> L42
        if (f476170a == null) goto L40;
        Context r102 = hs7.a.h().getContext();     // Catch: Throwable -> L42
        String[] r103 = r102.getAssets().list(FaceShowElderlyFragment.AUDIO_ASSTES_PATH);     // Catch: Throwable -> L45
        int r104 = 0;
        if (r103 != null) goto L10;
    L17:
        PolarisFileWrapper r105 = new PolarisFileWrapper(r102.getCacheDir(), FaceShowElderlyFragment.DOWNLOAD_AUDIO_PATH);     // Catch: Throwable -> L45
        if (r105.exists() == true) goto L20;
    L32:
        if (r104 != 0) goto L40;
        if (f476175f == true) goto L40;
        HashMap<String, String> r106 = hs7.a.h().c().suitable;     // Catch: Throwable -> L45
        if (r106 == null) goto L40;
        if (r106.size() <= 0) goto L40;
        ts7.c.c(new n(r106));     // Catch: Throwable -> L45
        goto L40
    L20:
        if (r105.isDirectory() == false) goto L32;
        String[] r107 = r105.list();     // Catch: Throwable -> L45
        if (r107.length <= 0) goto L24;
        int r108 = 1;
    L25:
        int r109 = r107.length;     // Catch: Throwable -> L45
    L26:
        if (r104 >= r109) goto L31;
        String r110 = r107[r104];     // Catch: Throwable -> L45
        if (a(r110) == false) goto L30;
        a(r105.getAbsolutePath(), r110, true);     // Catch: Throwable -> L45
    L30:
        r104 = r104 + 1;     // Catch: Throwable -> L45
        goto L26
    L31:
        r104 = r108;
        goto L32
    L24:
        r108 = 0;
        goto L25
    L10:
        if (r103.length <= 0) goto L17;
        int r111 = r103.length;     // Catch: Throwable -> L45
        int r112 = 0;
    L12:
        if (r112 >= r111) goto L40;
        String r113 = r103[r112].replace(FaceShowElderlyFragment.AUDIO_FORM, "");     // Catch: Throwable -> L45
        if (f476171b.containsKey(r113) == true) goto L16;
        a(FaceShowElderlyFragment.AUDIO_ASSTES_PATH, r113, false);     // Catch: Throwable -> L45
    L16:
        r112 = r112 + 1;     // Catch: Throwable -> L45
    L40:
        monitor-exit(m.class);
        return;
    L42:
        th = move-exception;
        throw th;
    }

    public static void b() {
        SoundPool r100 = f476170a;
        if (r100 == null) goto L6;
        r100.autoPause();
        return;
    }

    public static boolean a(String r100) {
        Context r101 = hs7.a.h().getContext();
        AndroidClientConfig r102 = hs7.a.h().c();
        if (r102 == null) goto L14;
        HashMap<String, String> r103 = r102.suitable;
        if (r103 == null) goto L14;
        if (r101 == null) goto L14;
        String r104 = r103.get(FaceShowElderlyFragment.MD5_KEY_PREFIX + r100);
        PolarisFileWrapper r105 = new PolarisFileWrapper(r101.getCacheDir(), FaceShowElderlyFragment.DOWNLOAD_AUDIO_PATH + File.separator + r100 + FaceShowElderlyFragment.AUDIO_FORM);
        if (r105.exists() == false) goto L14;
        if (TextUtils.equals(ws7.i.e(r105.getAbsolutePath()), r104) == false) goto L13;
        return true;
    L13:
        RecordService.getInstance().recordEvent(2, "suitableError", new String[]{"msg", "md5 check fail", "fileName", r100});
        ws7.f.f(r105);
    L14:
        return false;
    }

    public static int a(int r100) {
        if (f476173d == 0) goto L5;
        f476170a.stop(r100);
    L5:
        int r101 = f476170a.play(r100, 1.0f, 1.0f, 1, 0, 1.0f);
        f476173d = r101;
        return r101;
    }

    public static /* synthetic */ boolean a(boolean r100) {
        f476175f = r100;
        return r100;
    }

    public static int a(String r100, String r101, boolean r102) {
        int r103 = 0;
        if (r102 == false) goto L8;
        int r104 = f476170a.load(r100 + File.separator + r101 + FaceShowElderlyFragment.AUDIO_FORM, 1);     // Catch: Throwable -> L6
    L5:
        r103 = r104;
        if (r103 == 0) goto L13;
        f476171b.put(r101, Integer.valueOf(r103));     // Catch: Throwable -> L6
    L13:
        return r103;
    L8:
        r104 = f476170a.load(hs7.a.h().getContext().getAssets().openFd(r100 + r101 + FaceShowElderlyFragment.AUDIO_FORM), 1);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        RecordService.getInstance().recordException(th);
        goto L13
    }
}
