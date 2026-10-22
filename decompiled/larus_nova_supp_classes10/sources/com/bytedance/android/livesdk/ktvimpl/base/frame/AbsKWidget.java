package com.bytedance.android.livesdk.ktvimpl.base.frame;

import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.livesdk.ktvapi.AbsKtvControlWidget;
import com.bytedance.android.livesdk.ktvapi.HolderRoomWidget;
import com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidgetViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvStageWidget;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/frame/AbsKWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/base/frame/AbsKWidgetViewModel;", "T", "Lcom/bytedance/android/livesdk/ktvapi/HolderRoomWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/base/frame/IKWidget;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class AbsKWidget<T extends AbsKWidgetViewModel> extends HolderRoomWidget implements IKWidget<T> {
    public T d;
    public final WeakReference<AbsKtvControlWidget.a> e;

    public abstract AbsKtvControlWidget.WidgetType wq();

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.IKWidget
    public ViewModelProvider.Factory getViewModelFactory() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    public final void yq() {
        WeakReference<AbsKtvControlWidget.a> r0 = this.e;
        if (r0 == null) goto L8;
        AbsKtvControlWidget.a r1 = r0.get();
        if (r1 == null) goto L9;
        r1.a(wq(), this);
        return;
    L9:
        return;
    }

    public AbsKWidget() {
        this.e = null;
    }

    public void onCreate() {
        super/*com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget*/.onCreate();
        this.d = (T) xq();
        ((KtvStageWidget) this).Eq();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.IKWidget
    public final void onUnLoad() {
        getViewModelStore().clear();
        WeakReference<AbsKtvControlWidget.a> r0 = this.e;
        if (r0 == null) goto L8;
        AbsKtvControlWidget.a r1 = r0.get();
        if (r1 == null) goto L9;
        r1.k(this);
        return;
    L9:
        return;
    }

    public T xq() {
        return (T) IKWidget.a.a(this);
    }
}
