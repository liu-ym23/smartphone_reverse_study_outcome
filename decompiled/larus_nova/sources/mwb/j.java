package mwb;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmSubtitleSpeakerAvatarView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class j {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f516094l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f516095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f516096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f516097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f516098d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MmSubtitleSpeakerAvatarView f516099e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f516100f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f516101g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f516102h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f516103i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f516104j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f516105k;

    public static final class a {
    }

    static {
    }

    public j(View r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        this.f516095a = r100;
        View r101 = r100.findViewById(R.id.container);
        if (r101 == null) goto L43;
        this.f516096b = (ConstraintLayout) r101;
        View r102 = r100.findViewById(R.id.subtitleHighlightBackground);
        if (r102 == null) goto L41;
        this.f516097c = r102;
        View r103 = r100.findViewById(R.id.editSpeakerContainer);
        if (r103 == null) goto L39;
        this.f516098d = (ConstraintLayout) r103;
        View r104 = r100.findViewById(R.id.speakerAvatar);
        if (r104 == null) goto L37;
        this.f516099e = (MmSubtitleSpeakerAvatarView) r104;
        View r105 = r100.findViewById(R.id.userName);
        if (r105 == null) goto L35;
        this.f516100f = (TextView) r105;
        View r106 = r100.findViewById(R.id.editSpeakerIcon);
        if (r106 == null) goto L33;
        this.f516101g = (ImageView) r106;
        View r107 = r100.findViewById(R.id.itemSeparator);
        if (r107 == null) goto L31;
        this.f516102h = r107;
        View r108 = r100.findViewById(R.id.time);
        if (r108 == null) goto L29;
        this.f516103i = (TextView) r108;
        View r109 = r100.findViewById(R.id.itemContent1);
        if (r109 == null) goto L27;
        this.f516104j = (TextView) r109;
        View r110 = r100.findViewById(R.id.itemContent2);
        if (r110 == null) goto L25;
        this.f516105k = (TextView) r110;
        return;
    L25:
        throw new IllegalStateException("Required view not found, id=2131375673, type=".concat(TextView.class.getSimpleName()));
    L27:
        throw new IllegalStateException("Required view not found, id=2131375672, type=".concat(TextView.class.getSimpleName()));
    L29:
        throw new IllegalStateException("Required view not found, id=2131388654, type=".concat(TextView.class.getSimpleName()));
    L31:
        throw new IllegalStateException("Required view not found, id=2131375688, type=".concat(View.class.getSimpleName()));
    L33:
        throw new IllegalStateException("Required view not found, id=2131371386, type=".concat(ImageView.class.getSimpleName()));
    L35:
        throw new IllegalStateException("Required view not found, id=2131391985, type=".concat(TextView.class.getSimpleName()));
    L37:
        throw new IllegalStateException("Required view not found, id=2131387058, type=MmSubtitleSpeakerAvatarView");
    L39:
        throw new IllegalStateException("Required view not found, id=2131371385, type=ConstraintLayout");
    L41:
        throw new IllegalStateException("Required view not found, id=2131387642, type=".concat(View.class.getSimpleName()));
    L43:
        throw new IllegalStateException("Required view not found, id=2131367728, type=ConstraintLayout");
    }
}
