package mwb;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.wavebar.MmAudioWaveBarView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f516032j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f516033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f516034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MmAudioWaveBarView f516035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f516036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f516037e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f516038f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f516039g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f516040h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f516041i;

    public static final class a {
    }

    static {
    }

    public c(View r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        this.f516033a = r100;
        View r101 = r100.findViewById(R.id.tvDuration);
        if (r101 == null) goto L35;
        this.f516034b = (TextView) r101;
        View r102 = r100.findViewById(R.id.recordWaveBarView);
        if (r102 == null) goto L33;
        this.f516035c = (MmAudioWaveBarView) r102;
        View r103 = r100.findViewById(R.id.gradientLeft);
        if (r103 == null) goto L31;
        this.f516036d = r103;
        View r104 = r100.findViewById(R.id.gradientRight);
        if (r104 == null) goto L29;
        this.f516037e = r104;
        View r105 = r100.findViewById(R.id.toolbarActionContainer);
        if (r105 == null) goto L27;
        this.f516038f = (LinearLayout) r105;
        View r106 = r100.findViewById(R.id.recordKeyPointContainer);
        if (r106 == null) goto L25;
        this.f516039g = r106;
        View r107 = r100.findViewById(R.id.ivResumePause);
        if (r107 == null) goto L23;
        this.f516040h = (ImageView) r107;
        View r108 = r100.findViewById(R.id.ivStop);
        if (r108 == null) goto L21;
        this.f516041i = r108;
        return;
    L21:
        throw new IllegalStateException("Required view not found, id=2131375945, type=".concat(View.class.getSimpleName()));
    L23:
        throw new IllegalStateException("Required view not found, id=2131375939, type=".concat(ImageView.class.getSimpleName()));
    L25:
        throw new IllegalStateException("Required view not found, id=2131383980, type=".concat(View.class.getSimpleName()));
    L27:
        throw new IllegalStateException("Required view not found, id=2131389058, type=".concat(LinearLayout.class.getSimpleName()));
    L29:
        throw new IllegalStateException("Required view not found, id=2131373885, type=".concat(View.class.getSimpleName()));
    L31:
        throw new IllegalStateException("Required view not found, id=2131373884, type=".concat(View.class.getSimpleName()));
    L33:
        throw new IllegalStateException("Required view not found, id=2131383984, type=MmAudioWaveBarView");
    L35:
        throw new IllegalStateException("Required view not found, id=2131390023, type=".concat(TextView.class.getSimpleName()));
    }
}
