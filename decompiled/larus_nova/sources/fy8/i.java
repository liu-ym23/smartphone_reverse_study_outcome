package fy8;

import com.larus.canvas.feature.component.instruction.model.UIInstructionTab;
import com.larus.canvas.service.bean.InstructionTab;
import java.util.List;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: classes26.dex */
public interface i extends t1a.a {

    public static final class a {
        public static /* synthetic */ void a(i r100, String r101, int r102) {
            if ((r102 & 2) == 0) goto L5;
            boolean r103 = true;
        L6:
            r100.t4(r101, r103, false, null, null);
            return;
        L5:
            r103 = false;
            goto L6
        }
    }

    e BZ();

    void J3();

    String K5();

    List<InstructionTab> Qp(List<UIInstructionTab> r100);

    void XX(j r100);

    void fC(boolean r100);

    a1 jY();

    void p2(String r100);

    void t4(String r100, boolean r101, boolean r102, Integer r103, Integer r104);

    String xs();
}
