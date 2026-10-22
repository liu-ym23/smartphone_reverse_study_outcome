package r58;

import com.larus.audio.audiov3.audio.record.AudioRecordState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes24.dex */
public interface c {
    void a(String r100);

    void b(long r100, long r101);

    int c();

    long d(long r100);

    void e(Function0<Unit> r100);

    void f(Function2<? super String, ? super Long, Unit> r100);

    void g(Function2<? super Boolean, ? super String, Unit> r100);

    void h(v58.a r100);

    int i(byte[] r100, int r101);

    void j();

    void k(Function2<? super d, ? super byte[], Unit> r100);

    AudioRecordState l();

    void prepare();

    void release();

    void start();

    void stop();
}
