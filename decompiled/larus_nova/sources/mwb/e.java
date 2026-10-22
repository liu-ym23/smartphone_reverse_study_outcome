package mwb;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmRecordingNavLayout;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingTopBarView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f516050j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f516051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f516052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f516053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MmRecordingNavLayout f516054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f516055e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f516056f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FrameLayout f516057g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MmRecordingTopBarView f516058h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f516059i;

    public static final class a {
    }

    static {
    }

    public final d c() {
        d r100 = this.f516059i;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("Default middle slot is not attached");
    }

    public final UDTabLayout a() {
        return c().f516045c;
    }

    public final ViewPager2 b() {
        return c().f516049g;
    }

    public e(View r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        this.f516051a = r100;
        View r101 = r100.findViewById(R.id.flMapContainer);
        if (r101 == null) goto L27;
        this.f516052b = (ViewGroup) r101;
        View r102 = r100.findViewById(R.id.topSlotContainer);
        if (r102 == null) goto L25;
        this.f516053c = (FrameLayout) r102;
        View r103 = r100.findViewById(R.id.mmNavLayout);
        if (r103 == null) goto L23;
        this.f516054d = (MmRecordingNavLayout) r103;
        View r104 = r100.findViewById(R.id.titleSlotContainer);
        if (r104 == null) goto L21;
        this.f516055e = (FrameLayout) r104;
        View r105 = r100.findViewById(R.id.middleSlotContainer);
        if (r105 == null) goto L19;
        this.f516056f = (FrameLayout) r105;
        View r106 = r100.findViewById(R.id.toolbarSlotContainer);
        if (r106 == null) goto L17;
        this.f516057g = (FrameLayout) r106;
        return;
    L17:
        throw new IllegalStateException("Required view not found, id=2131389064, type=".concat(FrameLayout.class.getSimpleName()));
    L19:
        throw new IllegalStateException("Required view not found, id=2131380092, type=".concat(FrameLayout.class.getSimpleName()));
    L21:
        throw new IllegalStateException("Required view not found, id=2131388788, type=".concat(FrameLayout.class.getSimpleName()));
    L23:
        throw new IllegalStateException("Required view not found, id=2131380186, type=MmRecordingNavLayout");
    L25:
        throw new IllegalStateException("Required view not found, id=2131389107, type=".concat(FrameLayout.class.getSimpleName()));
    L27:
        throw new IllegalStateException("Required view not found, id=2131372654, type=".concat(ViewGroup.class.getSimpleName()));
    }
}
