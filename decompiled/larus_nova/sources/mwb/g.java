package mwb;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.wavebar.MmAudioWaveBarView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f516071h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f516072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MmAudioWaveBarView f516073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f516074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f516075d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f516076e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f516077f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f516078g;

    public static final class a {
    }

    static {
    }

    public g(View r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        this.f516072a = r100;
        View r101 = r100.findViewById(R.id.recordWaveBarView);
        if (r101 == null) goto L27;
        this.f516073b = (MmAudioWaveBarView) r101;
        View r102 = r100.findViewById(R.id.gradientLeft);
        if (r102 == null) goto L25;
        this.f516074c = r102;
        View r103 = r100.findViewById(R.id.gradientRight);
        if (r103 == null) goto L23;
        this.f516075d = r103;
        View r104 = r100.findViewById(R.id.tvDuration);
        if (r104 == null) goto L21;
        this.f516076e = (TextView) r104;
        View r105 = r100.findViewById(R.id.ivResumePause);
        if (r105 == null) goto L19;
        this.f516077f = (ImageView) r105;
        View r106 = r100.findViewById(R.id.ivStop);
        if (r106 == null) goto L17;
        this.f516078g = r106;
        return;
    L17:
        throw new IllegalStateException("Required view not found, id=2131375945, type=".concat(View.class.getSimpleName()));
    L19:
        throw new IllegalStateException("Required view not found, id=2131375939, type=".concat(ImageView.class.getSimpleName()));
    L21:
        throw new IllegalStateException("Required view not found, id=2131390023, type=".concat(TextView.class.getSimpleName()));
    L23:
        throw new IllegalStateException("Required view not found, id=2131373885, type=".concat(View.class.getSimpleName()));
    L25:
        throw new IllegalStateException("Required view not found, id=2131373884, type=".concat(View.class.getSimpleName()));
    L27:
        throw new IllegalStateException("Required view not found, id=2131383984, type=MmAudioWaveBarView");
    }
}
