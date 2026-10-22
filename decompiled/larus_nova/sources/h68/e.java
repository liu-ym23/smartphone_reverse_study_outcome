package h68;

import com.larus.audio.audiov3.task.asr.AsrState;
import com.larus.audio.report.h;

/* JADX INFO: loaded from: classes24.dex */
public interface e {
    int a(byte[] r100, int r101);

    boolean b();

    void c(String r100, Object r101, Object r102, Object r103);

    void cancel();

    AsrState d();

    long e();

    void f(d r100);

    void g(h r100);

    y58.a getConfig();

    String getTaskId();

    void release();

    void start();

    void stop();
}
