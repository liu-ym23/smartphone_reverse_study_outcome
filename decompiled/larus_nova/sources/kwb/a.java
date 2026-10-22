package kwb;

import android.view.View;
import android.widget.TextView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f506489d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f506490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f506491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f506492c;

    /* JADX INFO: renamed from: kwb.a$a, reason: collision with other inner class name */
    public static final class C6623a {
    }

    static {
    }

    public a(View r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        this.f506490a = r100;
        View r101 = r100.findViewById(R.id.avatarBg);
        if (r101 == null) goto L11;
        this.f506491b = r101;
        View r102 = r100.findViewById(R.id.addSpeakerText);
        if (r102 == null) goto L9;
        this.f506492c = (TextView) r102;
        return;
    L9:
        throw new IllegalStateException("Required view not found, id=2131362224, type=".concat(TextView.class.getSimpleName()));
    L11:
        throw new IllegalStateException("Required view not found, id=2131363629, type=".concat(View.class.getSimpleName()));
    }
}
