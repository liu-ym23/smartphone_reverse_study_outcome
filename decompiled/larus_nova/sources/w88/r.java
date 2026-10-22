package w88;

import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.im.bean.bot.BotModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public interface r {

    /* JADX INFO: loaded from: classes23.dex */
    public static final class a {
        public static /* synthetic */ void a(IDoraAVLinkService r100, int r110, String r111, String r112) {
            r100.w(r110, r111, 0, r112, null, com.larus.im.internal.delegate.c.f348197a.currentTimeMillis(), null);
        }
    }

    t A();

    boolean B();

    void C(String r100, String r101, Integer r102);

    void D();

    void E(int r100);

    void F(String r100);

    boolean G();

    void H();

    void I();

    void J(int r100, int r101, int r102, int r103, int r104, String r105, String r106);

    void K(com.larus.dora.impl.onboarding.b r100);

    boolean L();

    Integer c();

    void h(String r100);

    boolean j();

    void k(String r100, String r101);

    boolean l();

    void m(Function1<? super z98.f, Unit> r100);

    void n(Integer r100);

    void o(boolean r100);

    void p();

    String q();

    void r(BotModel r100);

    boolean s();

    void t(boolean r100, Integer r101, Integer r102);

    void u();

    void v(String r100, String r101);

    void w(int r100, String r101, int r102, String r103, Integer r104, long r105, String r106);

    void x(String r100);

    boolean y();

    void z(String r100);
}
