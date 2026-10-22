package kwb;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f506506g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f506507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f506508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f506509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f506510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f506511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f506512f;

    public static final class a {
    }

    static {
    }

    public d(View r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        this.f506507a = r100;
        View r101 = r100.findViewById(R.id.titleContainer);
        if (r101 == null) goto L23;
        this.f506508b = r101;
        View r102 = r100.findViewById(R.id.tvTitle);
        if (r102 == null) goto L21;
        this.f506509c = (TextView) r102;
        View r103 = r100.findViewById(R.id.tvSubTitle);
        if (r103 == null) goto L19;
        this.f506510d = (TextView) r103;
        View r104 = r100.findViewById(R.id.ivClose);
        if (r104 == null) goto L17;
        this.f506511e = (ImageView) r104;
        View r105 = r100.findViewById(R.id.divider);
        if (r105 == null) goto L15;
        this.f506512f = r105;
        return;
    L15:
        throw new IllegalStateException("Required view not found, id=2131369197, type=".concat(View.class.getSimpleName()));
    L17:
        throw new IllegalStateException("Required view not found, id=2131375905, type=".concat(ImageView.class.getSimpleName()));
    L19:
        throw new IllegalStateException("Required view not found, id=2131390079, type=".concat(TextView.class.getSimpleName()));
    L21:
        throw new IllegalStateException("Required view not found, id=2131390084, type=".concat(TextView.class.getSimpleName()));
    L23:
        throw new IllegalStateException("Required view not found, id=2131388777, type=".concat(View.class.getSimpleName()));
    }
}
