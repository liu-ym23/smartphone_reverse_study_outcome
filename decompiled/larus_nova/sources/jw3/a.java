package jw3;

import com.bytedance.applet.event.j;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.im.bean.message.Message;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public interface a {
    void a(Object r100, String r101, String r102, String r103, Long r104, j r105);

    b b(Message r100, boolean r101);

    void c(Object r100, String r101, String r102, String r103, String r104, String r105, Map r106, String r107, String r108, Long r110, Integer r111, j r112);

    b d(Message r100, String r101);

    b e(PlayStateEnum r100);

    void f(String r100, b r101);

    void g(Object r100, String r101, String r102, Long r103, boolean r104);

    void h(Object r100, String r101, String r102, String r103, String r104, String r105, Map r106, String r107, String r108, Long r110, Integer r111, j r112);

    void i(Long r100);

    void j(String r100, String r101, String r102, String r103);

    boolean k();
}
