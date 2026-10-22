package com.larus.canvas.feature.component.logic;

import android.net.Uri;
import com.larus.canvas.feature.component.logic.bean.ImageSaveStatus;
import com.larus.canvas.feature.component.logic.loading.CanvasProgressState;
import com.larus.canvas.service.bean.InstructionTab;
import com.larus.canvas.service.bean.OptionItem;
import kotlin.Pair;

/* JADX INFO: loaded from: classes26.dex */
public interface n2 extends t1a.a {

    public static final class a {
        public static /* synthetic */ void a(n2 r100, InstructionTab r101, OptionItem r102, boolean r103) {
            r100.h70(r101, r102, null, r103, "router_auto_send");
        }
    }

    void Fp(ky8.j r100);

    void IQ(String r100, boolean r101);

    int Jx();

    boolean M20();

    ky8.f O30(String r100);

    int PT();

    void SS(ky8.j r100);

    int Sr();

    Long XF();

    void Xu(int r100);

    void bs(String r100);

    kotlinx.coroutines.flow.i1<ky8.g> bt();

    void cc(String r100, @ImageSaveStatus int r101);

    int dx();

    void gu();

    void h70(InstructionTab r100, OptionItem r101, String r102, boolean r103, String r104);

    Pair<String, String> j50();

    void lH(String r100);

    int re();

    void tM(Uri r100, boolean r101);

    kotlinx.coroutines.flow.b1 tx();

    CanvasProgressState zm();
}
