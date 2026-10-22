package hca;

import android.view.ViewGroup;
import com.obric.assistant.ability.PageStateChangedReason;
import com.obric.assistant.data.ObricFloatChatPageState;

/* JADX INFO: loaded from: classes32.dex */
public interface d extends m1a.a {

    public static final class a {
        public static /* synthetic */ void a(d r100, boolean r101, int r102) {
            if ((r102 & 2) == 0) goto L5;
            boolean r103 = true;
        L7:
            if ((r102 & 4) == 0) goto L9;
            r101 = false;
        L9:
            r100.Ns(0, r103, r101);
            return;
        L5:
            r103 = false;
            goto L7
        }
    }

    void C1(boolean r100, boolean r101, String r102);

    int G1();

    boolean Hu();

    void Ns(int r100, boolean r101, boolean r102);

    void P5(int r100);

    void T7(Float r100, boolean r101, String r102);

    void T8(float r100, boolean r101);

    boolean UR(String r100);

    ObricFloatChatPageState getPageState();

    ViewGroup getTitleContainer();

    void i2(boolean r100, int r101, Float r102, boolean r103, boolean r104, PageStateChangedReason r105);

    void o2(int r100);
}
