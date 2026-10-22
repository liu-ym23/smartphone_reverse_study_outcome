package ak2;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class a implements wd.d, IExternalButton {
    public a() {
    }

    public View getButtonViewInMore() {
        return null;
    }

    public abstract Context getContext();

    public abstract View getRealView();

    @Deprecated(message = "使用 onViewWillDetach 替代", replaceWith = @ReplaceWith(expression = "onViewWillDetach()", imports = {}))
    public void onHide() {
    }

    public void onLoad() {
    }

    @Deprecated(message = "使用 onViewAttached 替代", replaceWith = @ReplaceWith(expression = "onViewAttached()", imports = {}))
    public void onShow() {
    }

    public boolean onTriggerAnimation(long r1) {
        return false;
    }

    public void onUnload() {
    }

    public void onViewDetached() {
    }

    public void onViewWillAttach(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
    }

    public void onViewWillAttach(wd.c r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
    }

    public void onViewWillDetach() {
    }

    public abstract void setRealView(View r1);

    public void onBehaviorUpdate(String r2) {
        Intrinsics.checkNotNullParameter(r2, "extraData");
        Intrinsics.checkNotNullParameter(r2, "extraData");
        IExternalButton.DefaultImpls.onBehaviorUpdate(this, r2);
    }

    public void onShow(ToolbarMatchInterface r1) {
        IExternalButton.DefaultImpls.onShow(this, r1);
    }
}
