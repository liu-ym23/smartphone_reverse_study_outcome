package laa;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.obric.assistant.ability.PageStateChangedReason;
import com.obric.assistant.data.ObricFloatChatPageState;

/* JADX INFO: loaded from: classes32.dex */
public interface d extends m1a.a {

    public static final class a {
        public static /* synthetic */ void a(d r100, float r101, boolean r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r101 = 0.0f;
        L6:
            if ((r103 & 2) == 0) goto L8;
            r102 = false;
        L8:
            r100.T8(r101, r102);
        }

        public static /* synthetic */ void b(d r100, Boolean r101, boolean r102, boolean r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r101 = null;
        L6:
            if ((r104 & 4) == 0) goto L9;
            r102 = false;
        L9:
            if ((r104 & 8) == 0) goto L11;
            r103 = false;
        L11:
            r100.qT(r101, r102, r103);
        }

        public static /* synthetic */ void c(d r100, Float r101, boolean r102, String r103, int r104) {
            if ((r104 & 1) == 0) goto L6;
            r101 = null;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = true;
        L9:
            if ((r104 & 4) == 0) goto L11;
            r103 = "";
        L11:
            r100.T7(r101, r102, r103);
        }

        public static /* synthetic */ void d(d r100, boolean r101, int r102, Float r110, boolean r111, boolean r112, PageStateChangedReason r113, int r114) {
            if ((r114 & 1) == 0) goto L5;
            boolean r103 = true;
        L7:
            if ((r114 & 4) == 0) goto L9;
            r110 = null;
        L9:
            Float r104 = r110;
            if ((r114 & 8) == 0) goto L12;
            boolean r105 = false;
        L14:
            if ((r114 & 16) == 0) goto L16;
            boolean r106 = false;
        L18:
            if ((r114 & 32) == 0) goto L20;
            r113 = PageStateChangedReason.OTHER;
        L20:
            r100.i2(r103, r102, r104, r105, r106, r113);
            return;
        L16:
            r106 = r112;
            goto L18
        L12:
            r105 = r111;
            goto L14
        L5:
            r103 = r101;
            goto L7
        }
    }

    void AN(hca.b r100);

    void Bn(AVKitDuplexState r100);

    void C0(boolean r100, boolean r101);

    void C00(boolean r100);

    void C1(boolean r100, boolean r101, String r102);

    void D50(String r100, String r101);

    boolean Da();

    void F0(boolean r100);

    void Gm(boolean r100);

    void H30(laa.a r100);

    void HU(hca.b r100);

    void Hd(boolean r100);

    boolean JY();

    void Ks(boolean r100);

    void MO(boolean r100);

    void Mx(laa.a r100);

    void Nq();

    void P5(int r100);

    void T7(Float r100, boolean r101, String r102);

    void T8(float r100, boolean r101);

    void U3(boolean r100);

    boolean Xh();

    RecyclerView Xw();

    void Yx(MotionEvent r100);

    void a7(boolean r100);

    boolean aF();

    String bl();

    void g8(int r100);

    ObricFloatChatPageState getPageState();

    void h1(boolean r100);

    void i2(boolean r100, int r101, Float r102, boolean r103, boolean r104, PageStateChangedReason r105);

    boolean isFullScreen();

    boolean isVisible();

    void j1(boolean r100);

    void le();

    int mb();

    void o2(int r100);

    void onScreenOff();

    void qT(Boolean r100, boolean r101, boolean r102);

    void refresh();

    void sN(int r100);

    void tV();

    void uv();

    void xK();

    void xw(String r100, boolean r101);

    void zf(boolean r100);
}
