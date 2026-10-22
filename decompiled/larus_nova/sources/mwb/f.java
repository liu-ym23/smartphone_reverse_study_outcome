package mwb;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmCoveredEditTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class f {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f516060k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f516061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f516062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MmCoveredEditTextView f516063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f516064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f516065e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f516066f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f516067g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f516068h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f516069i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f516070j;

    public static final class a {
    }

    static {
    }

    public f(View r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        this.f516061a = r100;
        View r101 = r100.findViewById(R.id.title_container);
        if (r101 == null) goto L35;
        this.f516062b = r101;
        View r102 = r100.findViewById(R.id.tvEditTitle);
        if (r102 == null) goto L33;
        this.f516063c = (MmCoveredEditTextView) r102;
        View r103 = r100.findViewById(R.id.tvTopic);
        if (r103 == null) goto L31;
        this.f516064d = (TextView) r103;
        View r104 = r100.findViewById(R.id.ivTime);
        if (r104 == null) goto L29;
        this.f516065e = (ImageView) r104;
        View r105 = r100.findViewById(R.id.tvTime);
        if (r105 == null) goto L27;
        this.f516066f = (TextView) r105;
        View r106 = r100.findViewById(R.id.ivLocation);
        if (r106 == null) goto L25;
        this.f516067g = (ImageView) r106;
        View r107 = r100.findViewById(R.id.tvLocation);
        if (r107 == null) goto L23;
        this.f516068h = (TextView) r107;
        View r108 = r100.findViewById(R.id.ivChooseLocation);
        if (r108 == null) goto L21;
        this.f516069i = (ImageView) r108;
        this.f516070j = r100.findViewById(R.id.dividerLineForOneTab);
        return;
    L21:
        throw new IllegalStateException("Required view not found, id=2131375904, type=".concat(ImageView.class.getSimpleName()));
    L23:
        throw new IllegalStateException("Required view not found, id=2131390047, type=".concat(TextView.class.getSimpleName()));
    L25:
        throw new IllegalStateException("Required view not found, id=2131375919, type=".concat(ImageView.class.getSimpleName()));
    L27:
        throw new IllegalStateException("Required view not found, id=2131390082, type=".concat(TextView.class.getSimpleName()));
    L29:
        throw new IllegalStateException("Required view not found, id=2131375948, type=".concat(ImageView.class.getSimpleName()));
    L31:
        throw new IllegalStateException("Required view not found, id=2131390088, type=".concat(TextView.class.getSimpleName()));
    L33:
        throw new IllegalStateException("Required view not found, id=2131390025, type=MmCoveredEditTextView");
    L35:
        throw new IllegalStateException("Required view not found, id=2131388843, type=".concat(View.class.getSimpleName()));
    }
}
