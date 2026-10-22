package mwb;

import android.view.View;
import android.widget.TextView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.titlebar.MmTitleBarView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f515997i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f515998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MmTitleBarView f515999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f516000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f516001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f516002e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f516003f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f516004g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f516005h;

    /* JADX INFO: renamed from: mwb.a$a, reason: collision with other inner class name */
    public static final class C6866a {
    }

    static {
    }

    public a(View r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        this.f515998a = r100;
        View r101 = r100.findViewById(R.id.titleBar);
        if (r101 == null) goto L31;
        this.f515999b = (MmTitleBarView) r101;
        View r102 = r100.findViewById(R.id.audioSaveLayout);
        if (r102 == null) goto L29;
        this.f516000c = r102;
        View r103 = r100.findViewById(R.id.audioNotSaveLayout);
        if (r103 == null) goto L27;
        this.f516001d = r103;
        View r104 = r100.findViewById(R.id.audioSaveText);
        if (r104 == null) goto L25;
        this.f516002e = (TextView) r104;
        View r105 = r100.findViewById(R.id.audioNotSaveText);
        if (r105 == null) goto L23;
        this.f516003f = (TextView) r105;
        View r106 = r100.findViewById(R.id.audioSaveCheckView);
        if (r106 == null) goto L21;
        this.f516004g = r106;
        View r107 = r100.findViewById(R.id.audioNotSaveCheckView);
        if (r107 == null) goto L19;
        this.f516005h = r107;
        return;
    L19:
        throw new IllegalStateException("Required view not found, id=2131363389, type=".concat(View.class.getSimpleName()));
    L21:
        throw new IllegalStateException("Required view not found, id=2131363395, type=".concat(View.class.getSimpleName()));
    L23:
        throw new IllegalStateException("Required view not found, id=2131363391, type=".concat(TextView.class.getSimpleName()));
    L25:
        throw new IllegalStateException("Required view not found, id=2131363398, type=".concat(TextView.class.getSimpleName()));
    L27:
        throw new IllegalStateException("Required view not found, id=2131363390, type=".concat(View.class.getSimpleName()));
    L29:
        throw new IllegalStateException("Required view not found, id=2131363396, type=".concat(View.class.getSimpleName()));
    L31:
        throw new IllegalStateException("Required view not found, id=2131388775, type=MmTitleBarView");
    }
}
