package lg7;

import androidx.room.Update;
import com.bytedance.sync.v2.protocal.Bucket;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public interface s {
    int a(List<? extends mg7.f> r100);

    void c(long r100, long r101);

    void e();

    List i(String r100);

    long insert(mg7.f r100);

    void insert(List<? extends mg7.f> r100);

    List k(Bucket r100, String r101);

    List m(Bucket r100, String r101, String r102);

    @Update(onConflict = 1)
    int update(List<? extends mg7.f> r100);
}
