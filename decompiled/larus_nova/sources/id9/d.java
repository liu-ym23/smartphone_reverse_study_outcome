package id9;

import com.larus.audio.call.record.AVInnerRecordAdapter$linkAudioRecorder$1;
import com.larus.im.service.audio.AvAecType;
import com.larus.im.service.audio.ModalType;
import com.larus.im.service.audio.cmd.TargetVideoSourceType;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.im.service.audio.l;
import com.larus.im.service.audio.n;
import com.larus.im.service.audio.o;
import com.larus.im.service.audio.q;
import com.larus.im.service.audio.x;
import com.larus.im.service.audio.x0;
import com.larus.im.service.audio.y;
import java.util.Map;

/* JADX INFO: loaded from: classes29.dex */
public interface d extends e {
    void A(o r100);

    void B(xe9.d r100);

    y a();

    n c(int r100, AvAecType r101, AVInnerRecordAdapter$linkAudioRecorder$1 r102);

    void d(x r100);

    void f(String r100);

    x0 getSessionConfig();

    void h(boolean r100);

    boolean k();

    void m(ModalType r100, TargetVideoSourceType r101);

    void o();

    void p(TriggerMode r100, String r101);

    void r(Map<String, ? extends Object> r100);

    void t();

    void u(l r100);

    q v();

    void x(x r100);

    void y(Map<String, String> r100);
}
