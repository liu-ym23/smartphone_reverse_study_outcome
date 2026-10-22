package v68;

import com.larus.audio.call.aec.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import r58.d;

/* JADX INFO: loaded from: classes24.dex */
public interface a {
    void a(String r100);

    void b(int r100);

    void c(long r100, Long r101);

    void d(v58.a r100, Function2<? super d, ? super byte[], Unit> r101);

    void e(Function0<Unit> r100);

    void f(Function2<? super String, ? super Long, Unit> r100);

    void g(Function2<? super Boolean, ? super String, Unit> r100);

    w h();

    void release();

    void setBluetoothForceToMedia(boolean r100);

    boolean start(Function1<? super Exception, Unit> r100);

    void stopRecord();
}
