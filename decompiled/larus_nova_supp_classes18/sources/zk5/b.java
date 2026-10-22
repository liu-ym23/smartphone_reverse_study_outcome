package zk5;

import android.content.Context;
import com.bytedance.ee.bear.more.pageview2.PageViewFragment;
import com.bytedance.ee.bear.operation.api.event.OperationEvent;
import io.reactivex.Flowable;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface b {
    Flowable<al5.a> a(String r1, int r2);

    void b(Context r1, PageViewFragment r2, HashMap r3);

    void c(OperationEvent r1);

    void checkAndInit();
}
