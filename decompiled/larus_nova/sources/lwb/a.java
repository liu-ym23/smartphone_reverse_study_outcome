package lwb;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmEndWindowLoadingLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f511097f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f511098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f511099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f511100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MmEndWindowLoadingLayout f511101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f511102e;

    /* JADX INFO: renamed from: lwb.a$a, reason: collision with other inner class name */
    public static final class C6745a {
    }

    static {
    }

    public a(View r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        this.f511098a = r100;
        View r101 = r100.findViewById(R.id.mmRootView);
        if (r101 == null) goto L19;
        this.f511099b = (ConstraintLayout) r101;
        View r102 = r100.findViewById(R.id.webviewContainer);
        if (r102 == null) goto L17;
        this.f511100c = (FrameLayout) r102;
        View r103 = r100.findViewById(R.id.loadingLayout);
        if (r103 == null) goto L15;
        this.f511101d = (MmEndWindowLoadingLayout) r103;
        View r104 = r100.findViewById(R.id.topCloseBtn);
        if (r104 == null) goto L13;
        this.f511102e = (AppCompatImageView) r104;
        return;
    L13:
        throw new IllegalStateException("Required view not found, id=2131389095, type=AppCompatImageView");
    L15:
        throw new IllegalStateException("Required view not found, id=2131378982, type=MmEndWindowLoadingLayout");
    L17:
        throw new IllegalStateException("Required view not found, id=2131393138, type=".concat(FrameLayout.class.getSimpleName()));
    L19:
        throw new IllegalStateException("Required view not found, id=2131380188, type=ConstraintLayout");
    }
}
