package m80;

import com.bytedance.android.live.core.utils.rxutils.autodispose.OutsideScopeException;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes45.dex */
public interface a<E> extends Function<E, E> {
    @Override // io.reactivex.functions.Function
    E apply(E r100) throws OutsideScopeException;
}
