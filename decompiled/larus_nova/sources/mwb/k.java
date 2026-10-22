package mwb;

import android.view.View;
import android.widget.TextView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f516106d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f516107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f516108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f516109c;

    public static final class a {
    }

    static {
    }

    public k(View r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        this.f516107a = r100;
        View r101 = r100.findViewById(R.id.itemContent1);
        if (r101 == null) goto L11;
        this.f516108b = (TextView) r101;
        View r102 = r100.findViewById(R.id.itemContent2);
        if (r102 == null) goto L9;
        this.f516109c = (TextView) r102;
        return;
    L9:
        throw new IllegalStateException("Required view not found, id=2131375673, type=".concat(TextView.class.getSimpleName()));
    L11:
        throw new IllegalStateException("Required view not found, id=2131375672, type=".concat(TextView.class.getSimpleName()));
    }
}
