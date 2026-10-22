package gd2;

import android.content.res.Configuration;
import com.bytedance.android.live.liveinteract.jsbridge.method.h;
import com.bytedance.android.livesdk.chorusconcert.VSChorusConcertWidget;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes9.dex */
public interface f {
    void a(VSChorusConcertWidget.b r100);

    boolean b();

    void c(VSChorusConcertWidget.b r100);

    boolean d();

    void e(hd2.b r100);

    void f();

    JsonObject g(hd2.a r100);

    d getConcertEarMonitor();

    void h(hd2.c r100, h.b r101);

    void onConfigurationChanged(Configuration r100);

    void onPause();

    void onResume();

    void setMainSingerInteractId(String r100);
}
