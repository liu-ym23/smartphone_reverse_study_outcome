package j33;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.abscontainer.arch.core.data.RefreshProtocolSource;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes12.dex */
public interface f {
    void a();

    RecyclerView b(String r100);

    AndroidYaTaInstance c();

    View d(String r100);

    Object e(String r100);

    Map<String, Object> f();

    String g(com.bytedance.kmp.ec.yata.event.common.e r100);

    void h(n33.a r100, RefreshProtocolSource r101, n33.d r102);

    int i(z33.a r100);

    void j(View r100, String r101, String r102, Map<String, ? extends Object> r103, String r104);

    void k(ga6.c r100, int r101);

    Map<String, Object> l(com.bytedance.kmp.ec.yata.event.common.e r100);

    String m(com.bytedance.kmp.ec.yata.event.common.e r100);

    boolean n(z33.a r100);

    List<z33.a> o(Function1<? super z33.a, Boolean> r100);

    boolean p();
}
