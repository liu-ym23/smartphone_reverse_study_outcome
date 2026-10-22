package mwb;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class h {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f516079i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f516080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f516081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f516082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f516083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f516084e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f516085f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f516086g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f516087h;

    public static final class a {
    }

    static {
    }

    public h(View r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        this.f516080a = r100;
        View r101 = r100.findViewById(R.id.ivClose);
        if (r101 == null) goto L31;
        this.f516081b = (ImageView) r101;
        View r102 = r100.findViewById(R.id.tvTitleInBar);
        if (r102 == null) goto L29;
        this.f516082c = (TextView) r102;
        View r103 = r100.findViewById(R.id.ivLanguage);
        if (r103 == null) goto L27;
        this.f516083d = (ImageView) r103;
        View r104 = r100.findViewById(R.id.ivAIInterpretation);
        if (r104 == null) goto L25;
        this.f516084e = (ImageView) r104;
        View r105 = r100.findViewById(R.id.ivSettings);
        if (r105 == null) goto L23;
        this.f516085f = (ImageView) r105;
        View r106 = r100.findViewById(R.id.ivMore);
        if (r106 == null) goto L21;
        this.f516086g = (ImageView) r106;
        View r107 = r100.findViewById(R.id.ivShare);
        if (r107 == null) goto L19;
        this.f516087h = (ImageView) r107;
        return;
    L19:
        throw new IllegalStateException("Required view not found, id=2131375944, type=".concat(ImageView.class.getSimpleName()));
    L21:
        throw new IllegalStateException("Required view not found, id=2131375920, type=".concat(ImageView.class.getSimpleName()));
    L23:
        throw new IllegalStateException("Required view not found, id=2131375943, type=".concat(ImageView.class.getSimpleName()));
    L25:
        throw new IllegalStateException("Required view not found, id=2131375895, type=".concat(ImageView.class.getSimpleName()));
    L27:
        throw new IllegalStateException("Required view not found, id=2131375918, type=".concat(ImageView.class.getSimpleName()));
    L29:
        throw new IllegalStateException("Required view not found, id=2131390086, type=".concat(TextView.class.getSimpleName()));
    L31:
        throw new IllegalStateException("Required view not found, id=2131375905, type=".concat(ImageView.class.getSimpleName()));
    }
}
