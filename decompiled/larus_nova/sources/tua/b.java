package tua;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModel;
import com.ss.android.lark.api.api.ForsetiBaseChainFragment;
import com.ss.android.lark.api.bean.ForsetiMode;
import com.ss.android.lark.api.bean.ForsetiPageViewType;
import com.ss.android.lark.api.bean.ForsetiScreenMode;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import com.ss.android.lark.api.bean.ForsetiWidth;
import com.ss.android.lark.api.ui.j;
import com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.ForsetiPlugin;
import com.ss.android.lark.forseti.chain.ForsetiChainFragment;
import com.ss.android.lark.forseti.widget.ForsetiNormalChainDraggingView;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes34.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ tua.a a(b r100, Function1 r101) {
            return r100.K(r101, false);
        }
    }

    Fragment A(ForsetiBaseChainFragment r100);

    void B(FragmentManager.FragmentLifecycleCallbacks r100);

    void C();

    void D(Function1 r100);

    Fragment E();

    ForsetiWidth F(Fragment r100);

    ForsetiBaseChainFragment G(Fragment r100, String r101, Fragment r102, uua.a r103);

    ForsetiViewMode H();

    ForsetiBaseChainFragment I(Fragment r100);

    ForsetiChainFragment J(String r100, Fragment r101, String r102, com.ss.android.lark.api.bean.config.a r103);

    com.ss.android.lark.forseti.global.a K(Function1 r100, boolean r101);

    boolean L(String r100, Fragment r101, String r102, boolean r103, uua.a r104);

    void M(ForsetiBaseChainFragment r100);

    String N();

    void O(ForsetiViewModel.b r100);

    void P(j r100);

    void Q(Function0<Boolean> r100);

    void R(Fragment r100, com.ss.android.lark.api.ui.a r101);

    void S(FragmentManager.FragmentLifecycleCallbacks r100);

    ForsetiMode T();

    String U();

    void V(Fragment r100, String r101, Fragment r102, boolean r103, uua.a r104);

    boolean a(Fragment r100);

    void b(int r100);

    void c(boolean r100);

    void clear();

    void d(int r100);

    void e(j r100);

    ForsetiChainFragment f(String r100, Fragment r101, String r102, com.ss.android.lark.api.bean.config.a r103);

    c g(Fragment r100);

    Fragment h(Fragment r100, String r101);

    void i(Fragment r100, ForsetiPlugin.b r101);

    void j(Function1<? super ForsetiScreenMode, Unit> r100);

    ForsetiScreenMode k();

    void l(ForsetiViewModel.b r100);

    ForsetiNormalChainDraggingView m();

    ForsetiBaseChainFragment n(Fragment r100, String r101, Fragment r102, uua.a r103);

    ForsetiChainFragment o(String r100);

    void p();

    yua.d q();

    void r(ForsetiBaseChainFragment r100, FragmentManager r101);

    ArrayDeque<String> s();

    boolean t(Fragment r100);

    void u(Fragment r100, com.ss.android.lark.api.ui.a r101);

    ForsetiChainFragment v();

    ForsetiPageViewType w(Fragment r100);

    void x(Function1<? super ForsetiMode, Unit> r100);

    void y(Fragment r100);

    void z(Fragment r100, ForsetiPlugin.b r101);
}
