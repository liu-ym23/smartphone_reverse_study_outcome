package mwb;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewpager2.widget.ViewPager2;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.HideKeyboardLinearLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f516042h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HideKeyboardLinearLayout f516043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f516044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UDTabLayout f516045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f516046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f516047e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f516048f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewPager2 f516049g;

    public static final class a {
    }

    static {
    }

    public d(HideKeyboardLinearLayout r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        this.f516043a = r100;
        View r101 = r100.findViewById(R.id.mmTabLayoutContainerFl);
        if (r101 == null) goto L27;
        this.f516044b = (FrameLayout) r101;
        View r102 = r100.findViewById(R.id.mmTabLayout);
        if (r102 == null) goto L25;
        this.f516045c = (UDTabLayout) r102;
        View r103 = r100.findViewById(R.id.icon_new_summary_indicator);
        if (r103 == null) goto L23;
        this.f516046d = (ImageView) r103;
        View r104 = r100.findViewById(R.id.dividerLine);
        if (r104 == null) goto L21;
        this.f516047e = r104;
        View r105 = r100.findViewById(R.id.notificationContainer);
        if (r105 == null) goto L19;
        this.f516048f = (FrameLayout) r105;
        View r106 = r100.findViewById(R.id.mmViewPager);
        if (r106 == null) goto L17;
        this.f516049g = (ViewPager2) r106;
        return;
    L17:
        throw new IllegalStateException("Required view not found, id=2131380199, type=ViewPager2");
    L19:
        throw new IllegalStateException("Required view not found, id=2131381036, type=".concat(FrameLayout.class.getSimpleName()));
    L21:
        throw new IllegalStateException("Required view not found, id=2131369203, type=".concat(View.class.getSimpleName()));
    L23:
        throw new IllegalStateException("Required view not found, id=2131374778, type=".concat(ImageView.class.getSimpleName()));
    L25:
        throw new IllegalStateException("Required view not found, id=2131380193, type=UDTabLayout");
    L27:
        throw new IllegalStateException("Required view not found, id=2131380194, type=".concat(FrameLayout.class.getSimpleName()));
    }
}
