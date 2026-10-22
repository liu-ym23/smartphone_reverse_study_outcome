package pa7;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import com.bytedance.scene.navigation.d;
import com.bytedance.scene.ui.template.SwipeBackGroupScene;
import com.bytedance.scene.ui.view.NavigationBarView;
import com.bytedance.scene.ui.view.StatusBarView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a extends SwipeBackGroupScene {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Toolbar f528364x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public FrameLayout f528365y;

    /* JADX INFO: renamed from: pa7.a$a, reason: collision with other inner class name */
    public class ViewOnClickListenerC7172a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f528366a;

        public ViewOnClickListenerC7172a(a r100) {
            this.f528366a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            d.b(this.f528366a).q0();
        }
    }

    public abstract View B0(LayoutInflater r100, ViewGroup r101);

    public a() {
    }

    @Override // com.bytedance.scene.Scene
    public final void T(Bundle r100) {
        super.T(r100);
        this.f528364x.setNavigationOnClickListener(new ViewOnClickListenerC7172a(this));
        Window r101 = h0().getWindow();
        r101.setStatusBarColor(0);
        r101.setNavigationBarColor(0);
    }

    @Override // com.bytedance.scene.ui.template.SwipeBackGroupScene
    public final ViewGroup A0(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        ViewGroup r103 = (ViewGroup) r100.inflate(R.layout.scene_appcompat_layout, r101, false);
        this.f528364x = (Toolbar) r103.findViewById(R.id.scene_toolbar);
        this.f528365y = (FrameLayout) r103.findViewById(R.id.scene_content);
        StatusBarView r104 = (StatusBarView) r103.findViewById(R.id.scene_status_bar);
        NavigationBarView r105 = (NavigationBarView) r103.findViewById(R.id.scene_navigation_bar);
        View r106 = B0(r100, this.f528365y);
        if (r106 == null) goto L5;
        this.f528365y.addView(r106, new ViewGroup.LayoutParams(-1, -1));
    L5:
        Resources r107 = getResources();
        float r108 = TypedValue.applyDimension(1, 4.0f, WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()));
        ViewCompat.setElevation(this.f528364x, r108);
        return r103;
    }
}
