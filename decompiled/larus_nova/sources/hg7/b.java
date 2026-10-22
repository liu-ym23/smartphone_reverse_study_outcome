package hg7;

import com.bytedance.sync.v2.protocal.Bucket;
import com.bytedance.sync.v2.protocal.PacketStatus;
import com.bytedance.sync.v2.protocal.TopicType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface b extends rgc.a {
    mg7.c A(long r100);

    void B0(List<mg7.c> r100, List<String> r101, List<? extends mg7.a> r102);

    void G(ArrayList<mg7.d> r100);

    List<mg7.d> I(TopicType r100, long r101, String r102, int r103);

    List J(long r100, int r101);

    long Q(mg7.f r100);

    List R(Set r100, PacketStatus r101, int r102);

    void c(long r100, long r101);

    List<mg7.c> d0(dg7.a.d r100);

    void e();

    void h(mg7.b r100);

    void h0(List r100);

    List i(String r100);

    List j(int r100);

    List k(Bucket r100, String r101);

    List m(Bucket r100, String r101, String r102);

    mg7.b n(String r100, long r101);

    void q(ArrayList<mg7.e> r100, mg7.c r101);

    boolean s(mg7.b r100, List<? extends mg7.e> r101);

    boolean u(List<? extends mg7.e> r100);

    boolean u0(List<? extends mg7.f> r100, mg7.c r101, List<? extends mg7.f> r102);

    void v0(List<? extends mg7.d> r100);

    boolean x(String r100);
}
