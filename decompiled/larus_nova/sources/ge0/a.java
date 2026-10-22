package ge0;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AndroidLifecycleScopeProvider;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.contract.InteractDialogFragmentBaseContract$View;

/* JADX INFO: loaded from: classes46.dex */
public abstract class a<V extends InteractDialogFragmentBaseContract$View> extends com.bytedance.android.livesdk.common.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V f481007b;

    public final <R> AutoDisposeConverter<R> c() {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(this.f481007b.f72094d.getLifecycleOwner(), Lifecycle.Event.ON_DESTROY), RxUtil.rxSchedulerHelper());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(V r100) {
        this.f481007b = r100;
        this.f119692a = r100;
    }
}
