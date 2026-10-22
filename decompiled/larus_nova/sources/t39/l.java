package t39;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.dora.impl.guide.service.GuideSession$setStateListener$1;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes27.dex */
public interface l {
    Unit a();

    void b(GuideSession$setStateListener$1 r100);

    Object c(Continuation<? super Boolean> r100);

    Object d(Fragment r100, View r101, Continuation<? super Unit> r102);

    Object e(Fragment r100, View r101, Continuation<? super Unit> r102);

    int f();
}
