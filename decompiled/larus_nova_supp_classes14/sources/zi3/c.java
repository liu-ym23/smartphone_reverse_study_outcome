package zi3;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.base.api.ai.framework.model.PanelItem;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface c {
    void a(Context r1, List<PanelItem> r2);

    View b(Context r1, Function1<? super View, Unit> r2, Function1<? super View, Unit> r3);

    boolean c();

    View d(Context r1, Function1<? super View, Unit> r2);

    boolean e();
}
