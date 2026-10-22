package com.bytedance.android.livesdk.ktvimpl.base.frame;

import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidgetViewModel;
import com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/frame/IKWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/base/frame/AbsKWidgetViewModel;", "T", "Lcom/bytedance/android/livesdk/utils/ViewModelStoreOwnerCompat;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IKWidget<T extends AbsKWidgetViewModel> extends ViewModelStoreOwnerCompat {

    public static final class a {
        public static <T extends AbsKWidgetViewModel> T a(IKWidget<T> r3) {
            Type r0 = r3.getClass().getGenericSuperclass();
            if (r0 == null) goto L5;
        L9:
            if (r0 != null) goto L11;
            return null;
        L11:
            if ((r0 instanceof ParameterizedType) == false) goto L20;
            Type r1 = ((ParameterizedType) r0).getActualTypeArguments()[0];
            ViewModelProvider r2 = new ViewModelProvider(r3, r3.getViewModelFactory());
            if (r1 == null) goto L17;
            return (T) r2.get((Class) r1);
        L17:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<T>");
        L20:
            return null;
        L5:
            if (v.a() == false) goto L9;
            throw new IllegalArgumentException();
        }
    }

    ViewModelProvider.Factory getViewModelFactory();

    void onUnLoad();
}
