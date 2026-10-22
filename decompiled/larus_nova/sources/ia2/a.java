package ia2;

import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes9.dex */
public interface a {
    String getAnchorId();

    CompositeDisposable getCompositeDisposable();

    WeakReference<DataCenter> getDataCenter();

    long getRoomId();

    boolean isMessageListEmpty();
}
