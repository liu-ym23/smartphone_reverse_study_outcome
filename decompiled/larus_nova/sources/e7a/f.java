package e7a;

import android.view.View;
import androidx.camera.video.AudioStats;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.list.container.ListContainerView;
import com.lynx.tasm.behavior.ui.list.container.UIListContainer;

/* JADX INFO: loaded from: classes32.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f471241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f471242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f471243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f471244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f471245e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f471246f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final double f471247g;

    public interface a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f471248a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f471249b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f471250c;

        public b(int r100, int r101, int r102) {
            this.f471248a = r100;
            this.f471249b = r101;
            this.f471250c = r102;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int b() {
        if (this.f471242b == false) goto L5;
        int r100 = ((ListContainerView) ((UIListContainer.d) this.f471241a).f382805a.getView()).getLinearLayout().getHeight();
        int r101 = ((ListContainerView) ((UIListContainer.d) this.f471241a).f382805a.getView()).getHeight();
    L7:
        return Math.max(0, r100 - r101);
    L5:
        r100 = ((ListContainerView) ((UIListContainer.d) this.f471241a).f382805a.getView()).getLinearLayout().getWidth();
        r101 = ((ListContainerView) ((UIListContainer.d) this.f471241a).f382805a.getView()).getWidth();
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int a(View r100) {
        if ((r100 instanceof com.lynx.tasm.behavior.ui.view.a) == false) goto L13;
        com.lynx.tasm.behavior.ui.view.a r101 = (com.lynx.tasm.behavior.ui.view.a) r100;
        if ((r101.getDrawChildHook() instanceof LynxBaseUI) == false) goto L13;
        LynxBaseUI r102 = (LynxBaseUI) r101.getDrawChildHook();
        if (this.f471242b == false) goto L9;
        double r103 = ((double) r102.getTop()) - (((double) (((ListContainerView) ((UIListContainer.d) this.f471241a).f382805a.getView()).getHeight() - r102.getHeight())) * this.f471244d);
        int r104 = this.f471245e;
    L11:
        return (int) (r103 + ((double) r104));
    L9:
        r103 = ((double) r102.getLeft()) - (((double) (((ListContainerView) ((UIListContainer.d) this.f471241a).f382805a.getView()).getWidth() - r102.getWidth())) * this.f471244d);
        r104 = this.f471245e;
    L13:
        throw new RuntimeException("A list-item is not an AndroidView, some thing went wrong");
    }

    public f(double r100, int r101, double r102, int r110, UIListContainer.d r111) {
        this.f471241a = null;
        this.f471242b = true;
        this.f471243c = false;
        this.f471244d = -1.0d;
        this.f471245e = 0;
        this.f471246f = 1;
        this.f471247g = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f471244d = r100;
        this.f471245e = r101;
        this.f471247g = r102;
        this.f471246f = Math.max(1, r110);
        this.f471241a = r111;
    }
}
