package ak2;

import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class b implements q {
    public b() {
    }

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

    public void onViewAttached(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
    }

    public void onViewAttached(wd.c r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
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
}
