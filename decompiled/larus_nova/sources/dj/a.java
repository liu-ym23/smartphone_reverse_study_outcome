package dj;

import android.content.Context;
import android.os.Bundle;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes44.dex */
public interface a {
    Function0<Unit> a(Context r100, List<String> r101, String r102, Function2<? super String, ? super String, Unit> r103);

    void b(Context r100, Bundle r101, int r102, Function2<? super Integer, Object, Unit> r103);

    void c(Context r100, Bundle r101, Function1<Object, Unit> r102);

    void d(Context r100, Bundle r101, Object r102, Function2<? super Boolean, ? super String, Unit> r103);
}
