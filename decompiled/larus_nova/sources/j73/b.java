package j73;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.shopping.anchorv3.compat.UserInteractFrameLayout;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes12.dex */
public interface b extends com.bytedance.android.shopping.anchorv4.containers.e {
    Integer B();

    void Z();

    AnchorV4Param c();

    CompositeDisposable compositeDisposable();

    boolean e();

    void g(Disposable r100);

    Context getContext();

    long getDuration();

    FragmentManager getFragmentManager();

    LifecycleOwner getLifecycleOwner();

    String getSessionId();

    boolean isExpanded();

    UserInteractFrameLayout m0();

    long p();

    int r();

    V4NativeParams w();
}
