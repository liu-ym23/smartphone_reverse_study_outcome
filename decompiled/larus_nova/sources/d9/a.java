package d9;

import android.os.Bundle;
import android.widget.FrameLayout;
import com.bytedance.android.annie.container.dialog.l;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import ia.f;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements b {

    /* JADX INFO: renamed from: d9.a$a, reason: collision with other inner class name */
    public static final class C5646a implements l {
        public C5646a() {
        }

        @Override // com.bytedance.android.annie.container.dialog.l
        public final void attach(FrameLayout r100, f r101, t36.f r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "floatView");
            Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
            Intrinsics.checkNotNullParameter(r102, "mAnnieXLiveFragmentModel");
        }

        @Override // com.bytedance.android.annie.container.dialog.l
        public final boolean getModStatusBar() {
            return false;
        }

        @Override // com.bytedance.android.annie.container.dialog.l
        public final void handlePullStateChange(int r100) {
        }

        @Override // com.bytedance.android.annie.container.dialog.l
        public final boolean needAdapterStatusBarColor() {
            return false;
        }

        @Override // com.bytedance.android.annie.container.dialog.l
        public final void onActivityCreatedProxy(Bundle r100) {
        }

        @Override // com.bytedance.android.annie.container.dialog.l
        public final void onDestroyProxy() {
        }

        @Override // com.bytedance.android.annie.container.dialog.l
        public final void onDestroyViewProxy() {
        }

        @Override // com.bytedance.android.annie.container.dialog.l
        public final void setModStatusBar(boolean r100) {
        }
    }

    public a() {
    }

    @Override // d9.b
    public final void W() {
    }

    @Override // d9.b
    public final Integer f1(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        return null;
    }

    @Override // d9.b
    public final void p(float r100) {
    }

    @Override // d9.b
    public final l P() {
        return new C5646a();
    }
}
