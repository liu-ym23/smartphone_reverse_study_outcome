package k2;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes43.dex */
public interface k extends u4.a, h, o {
    void createContainer(ViewGroup r100, b r101, Activity r102, Fragment r103);

    m getContainerViewService();

    KClass<?> getRenderClass();
}
