package kwb;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f506513e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f506514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f506515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f506516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f506517d;

    public static final class a {
    }

    static {
    }

    public e(View r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        this.f506514a = r100;
        View r101 = r100.findViewById(R.id.tvTitle);
        if (r101 == null) goto L15;
        this.f506515b = (TextView) r101;
        View r102 = r100.findViewById(R.id.ivClose);
        if (r102 == null) goto L13;
        this.f506516c = (ImageView) r102;
        View r103 = r100.findViewById(R.id.divider);
        if (r103 == null) goto L11;
        this.f506517d = r103;
        return;
    L11:
        throw new IllegalStateException("Required view not found, id=2131369197, type=".concat(View.class.getSimpleName()));
    L13:
        throw new IllegalStateException("Required view not found, id=2131375905, type=".concat(ImageView.class.getSimpleName()));
    L15:
        throw new IllegalStateException("Required view not found, id=2131390084, type=".concat(TextView.class.getSimpleName()));
    }
}
