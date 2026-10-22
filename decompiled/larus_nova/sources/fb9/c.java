package fb9;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.home.api.feed.FlowFeedActionScene;
import eb9.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes29.dex */
public interface c extends fb9.a {

    public static final class a {
        public static /* synthetic */ boolean a(c r100, ConstraintLayout r101, o r102, FlowFeedActionScene r103, List r110) {
            return r100.g(r101, r102, r103, r110, new b());
        }
    }

    boolean g(View r100, o<?> r101, FlowFeedActionScene r102, List<? extends eb9.d> r103, Function2<? super eb9.d, ? super eb9.c, Unit> r104);
}
