package ep1;

import android.view.ViewGroup;
import android.widget.GridLayout;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes8.dex */
public abstract class c {
    public c() {
    }

    public abstract int a(DataCenter r100);

    public abstract String b();

    public abstract boolean c(List<ToolbarButton> r100, ViewGroup r101, Function2<? super ToolbarButton, ? super GridLayout, Unit> r102);
}
