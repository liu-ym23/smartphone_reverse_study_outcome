package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.k0;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface s extends d83.b, k0 {

    public static final class a {
        public static /* synthetic */ boolean a(s r1, Integer r2, int r3) {
            if ((r3 & 1) == 0) goto L6;
            r2 = null;
        L6:
            return r1.iW(r2, null);
        }

        public static /* synthetic */ boolean b(s r1, Integer r2, int r3) {
            if ((r3 & 1) == 0) goto L6;
            r2 = null;
        L6:
            return r1.qV(r2, null);
        }
    }

    boolean BY();

    Boolean Cb();

    void D6(RecyclerView r1);

    void Em(Integer r1);

    int FB();

    int G7();

    boolean Gv();

    void Gw();

    float HG();

    AnchorV4HeadV2VO K10();

    void Kb(int r1, Bitmap r2);

    Integer Lz();

    boolean Mm();

    void Nw();

    AnchorV4HeadV2VO P70();

    HeadLynxAbilityManager Pg();

    Map<Integer, Boolean> Rm();

    y Sf();

    void TB(int r1, boolean r2);

    int W4();

    void W8(int r1, Bitmap r2);

    int XU();

    boolean Y10();

    boolean aN(int r1);

    int bz();

    boolean eI();

    com.bytedance.android.shopping.anchorv4.voavhs.blur.f eL();

    e.b eh();

    Context getContext();

    int getCurrentPosition();

    RecyclerView getRecyclerView();

    boolean h00();

    com.bytedance.android.shopping.anchorv4.voavhs.headv2.t hq();

    boolean iW(Integer r1, Boolean r2);

    boolean isExpanded();

    boolean k80();

    void m90();

    boolean n0();

    boolean oa();

    boolean p3();

    void pK(Integer r1);

    boolean qV(Integer r1, Boolean r2);

    boolean r9();

    u rR();

    float s00();

    void tB(Boolean r1);

    void u1();

    boolean vn();

    com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.a w7();

    boolean wZ();

    boolean wq();

    d0 yd();

    boolean z20();
}
