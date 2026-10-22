package y48;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes24.dex */
public interface c0 extends n {
    void b(View r100);

    View c(Context r100, FrameLayout r101);

    boolean d(CoroutineScope r100, View r101, byte[] r102);

    void f(LifecycleCoroutineScope r100, View r101);

    void g(View r100, FrameLayout r101);
}
