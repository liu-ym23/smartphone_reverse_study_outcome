package ak2;

import android.view.View;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class e implements wd.d, IExternalButton {
    public e() {
    }

    public final String getTargetButtonName() {
        return "COMMERCE";
    }

    public final void onHide() {
    }

    public final void onLoad() {
    }

    public final void onShow() {
    }

    public final boolean onTriggerAnimation(long r1) {
        return false;
    }

    public final void onUnload() {
    }

    public final void onViewAttached(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
    }

    public final void onViewAttached(wd.c r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
    }

    public final void onViewDetached() {
    }

    public final void onViewWillAttach(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
    }

    public final void onViewWillAttach(wd.c r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
    }

    public final void onViewWillDetach() {
    }

    public final View getView() {
        throw new IllegalStateException("should not call getView");
    }

    public final void onBehaviorUpdate(String r2) {
        Intrinsics.checkNotNullParameter(r2, "extraData");
        IExternalButton.DefaultImpls.onBehaviorUpdate(this, r2);
    }

    public final void onShow(ToolbarMatchInterface r1) {
        IExternalButton.DefaultImpls.onShow(this, r1);
    }
}
