package mt6;

import android.app.Application;
import android.net.Uri;
import com.bytedance.ies.bullet.lynx.h;
import com.bytedance.locallife.cube.api.config.CubeConfig;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes21.dex */
public interface b {
    List<p46.c> a(m16.b r100);

    void b();

    Map<String, Object> c(m16.b r100, boolean r101);

    List<c> d();

    Uri e(String r100);

    h f(CubeConfig r100, h r101);

    void g(Application r100, Function1<? super Throwable, Unit> r101, Function0<Unit> r102);

    List<com.lynx.tasm.behavior.a> getBehaviorList();
}
