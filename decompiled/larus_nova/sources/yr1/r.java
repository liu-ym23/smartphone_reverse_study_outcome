package yr1;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.LandscapeTopMoreAdapter;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.z;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes8.dex */
public interface r {
    void a(LifecycleOwner r100, Function0<Unit> r101);

    LandscapeTopMoreAdapter c(Context r100, DataCenter r101, List r102, int r103, int r104, Function1 r105);

    z<pp1.c> createToolbarBubble(DataCenter r100, Context r101, View r102);

    boolean d(String r100);

    void f(LifecycleOwner r100, Function3<? super Uri, ? super Integer, ? super DialogInterface.OnDismissListener, Unit> r101);

    void g(String r100);

    boolean h(String r100);

    boolean i(boolean r100);

    void j(List<String> r100);

    void k();

    com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e n(ExtendedToolbarButton r100, List r101);
}
