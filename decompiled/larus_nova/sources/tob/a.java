package tob;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f546989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f546990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f546991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f546992d;

    static {
        f546991c = "";
        f546992d = "";
    }

    public static void a() {
        String r100 = f546989a;
        if (r100 == null) goto L5;
        Log.d("AppreciablePerformance", "endPlay");
        AppreciableKit.Companion.getInstance().end(r100, null, null, null, null, null);
    L5:
        f546989a = null;
        f546990b = 0;
        f546991c = "";
        f546992d = "";
    }

    public static void b(int r110) {
        if (f546989a == null) goto L5;
        Log.e("AppreciablePerformance", "errorPlay, errorCode:" + r110 + ", audioLength:" + f546990b + ", messageId:" + f546991c + ", resourceKey:" + f546992d);
        AppreciableKit.Companion.getInstance().error(new ErrorParams(Biz.Messenger, Scene.Chat, Event.audio_play, ErrorType.Other, ErrorLevel.Fatal, r110, null, null, null, Boolean.FALSE, null, c(f546990b, f546991c, f546992d), null));
    L5:
        f546989a = null;
        f546990b = 0;
        f546991c = "";
        f546992d = "";
    }

    public static void d(String r100) {
        if (Intrinsics.areEqual(r100, f546991c) == true) goto L5;
        return;
    L5:
        String r101 = f546989a;
        if (r101 == null) goto L9;
        Log.i("AppreciablePerformance", "startDownload, messageId:" + r100);
        AppreciableKit.Companion.getInstance().spanStart(r101, "download_cost");
        return;
    }

    public static void f(String r100) {
        if (Intrinsics.areEqual(r100, f546991c) == true) goto L5;
        return;
    L5:
        String r101 = f546989a;
        if (r101 == null) goto L9;
        Log.i("AppreciablePerformance", "stopDownload, messageId:" + r100);
        AppreciableKit.Companion.getInstance().spanEnd(r101, "download_cost");
        return;
    }

    public static HashMap c(int r100, String r101, String r102) {
        HashMap r103 = new HashMap();
        r103.put("audio_length", Integer.valueOf(r100));
        if (r101 == null) goto L5;
        r103.put(MusicAppletPage.KEY_MESSAGE_ID, r101);
    L5:
        if (r102 == null) goto L7;
        r103.put("resource_key", r102);
    L7:
        return r103;
    }

    public static void e(int r110, String r111, String r112) {
        Log.d("AppreciablePerformance", "startPlay, audioLength:" + r110 + ", messageId:" + r111 + ", resourceKey:" + r112);
        if (f546989a != null) goto L5;
    L8:
        f546990b = r110;
        f546991c = r111;
        f546992d = r112;
        f546989a = AppreciableKit.Companion.getInstance().start(Biz.Messenger, Scene.Chat, Event.audio_play, null, true, null, null, c(r110, r111, r112), null);
        return;
    L5:
        if (Intrinsics.areEqual(f546991c, r111) == false) goto L8;
        Log.d("AppreciablePerformance", "skip repeat start");
    }
}
