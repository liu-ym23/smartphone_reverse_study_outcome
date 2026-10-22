package zi3;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.base.api.ai.framework.model.PanelItem;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes14.dex */
public interface c {
    void a(Context r100, List<PanelItem> r101);

    View b(Context r100, Function1<? super View, Unit> r101, Function1<? super View, Unit> r102);

    boolean c();

    View d(Context r100, Function1<? super View, Unit> r101);

    boolean e();
}
