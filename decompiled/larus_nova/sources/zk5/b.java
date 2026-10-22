package zk5;

import android.content.Context;
import com.bytedance.ee.bear.more.pageview2.PageViewFragment;
import com.bytedance.ee.bear.operation.api.event.OperationEvent;
import io.reactivex.Flowable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes18.dex */
public interface b {
    Flowable<al5.a> a(String r100, int r101);

    void b(Context r100, PageViewFragment r101, HashMap r102);

    void c(OperationEvent r100);

    void checkAndInit();
}
