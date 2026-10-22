package s24;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes44.dex */
public interface a extends k24.a {
    void V2(Activity r100, String r101, Function0<Unit> r102, Function2<? super Float, ? super Float, Unit> r103, Function1<? super Boolean, Unit> r104, Map<String, String> r105, boolean r106);

    void c1(Activity r100, String r101, Function0<Unit> r102, Function2<? super Float, ? super Float, Unit> r103, Function1<? super Boolean, Unit> r104, Map<String, String> r105, boolean r106);

    boolean e();

    String g();

    boolean isAvailable();

    void j(FragmentActivity r100, String r101);
}
