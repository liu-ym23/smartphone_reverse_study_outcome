package lg7;

import com.bytedance.sync.v2.protocal.ConsumeType;
import com.bytedance.sync.v2.protocal.PacketStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface l {
    long a(mg7.b r100);

    void b(ArrayList<mg7.e> r100);

    List c(long r100, ConsumeType r101, int r102);

    void d(String r100);

    int delete(List<? extends mg7.e> r100);

    List e(Set r100, PacketStatus r101, int r102);

    void f(String r100);

    void h(mg7.b r100);

    List j(int r100);

    mg7.b n(String r100, long r101);
}
