package k0c;

import com.ss.android.lark.passportc.api.ExecuteStrategy;
import com.ss.android.lark.passportc.task.f;
import io.reactivex.Observable;
import java.util.List;

/* JADX INFO: loaded from: classes37.dex */
public interface d {
    Observable<j0c.c> a(j0c.e r100, ExecuteStrategy r101);

    void b(d r100);

    j0c.b c();

    List<d> children();

    void d(d r100);

    int getOrder();

    f getTask();

    List<d> parents();
}
