package jw3;

import com.bytedance.applet.event.j;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.im.bean.message.Message;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface a {
    void a(Object r1, String r2, String r3, String r4, Long r5, j r6);

    b b(Message r1, boolean r2);

    void c(Object r1, String r2, String r3, String r4, String r5, String r6, Map r7, String r8, String r9, Long r10, Integer r11, j r12);

    b d(Message r1, String r2);

    b e(PlayStateEnum r1);

    void f(String r1, b r2);

    void g(Object r1, String r2, String r3, Long r4, boolean r5);

    void h(Object r1, String r2, String r3, String r4, String r5, String r6, Map r7, String r8, String r9, Long r10, Integer r11, j r12);

    void i(Long r1);

    void j(String r1, String r2, String r3, String r4);

    boolean k();
}
