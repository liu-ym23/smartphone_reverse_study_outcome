package kwb;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmSearchInputView;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.titlebar.MmTitleBarView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f506498h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f506499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MmTitleBarView f506500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MmSearchInputView f506501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f506502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f506503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f506504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RecyclerView f506505g;

    public static final class a {
    }

    static {
    }

    public c(View r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        this.f506499a = r100;
        View r101 = r100.findViewById(R.id.titleBar);
        if (r101 == null) goto L27;
        this.f506500b = (MmTitleBarView) r101;
        View r102 = r100.findViewById(R.id.searchInputView);
        if (r102 == null) goto L25;
        this.f506501c = (MmSearchInputView) r102;
        View r103 = r100.findViewById(R.id.loadingView);
        if (r103 == null) goto L23;
        this.f506502d = (ImageView) r103;
        View r104 = r100.findViewById(R.id.emptyView);
        if (r104 == null) goto L21;
        this.f506503e = (TextView) r104;
        View r105 = r100.findViewById(R.id.errorView);
        if (r105 == null) goto L19;
        this.f506504f = (TextView) r105;
        View r106 = r100.findViewById(R.id.candidateList);
        if (r106 == null) goto L17;
        this.f506505g = (RecyclerView) r106;
        return;
    L17:
        throw new IllegalStateException("Required view not found, id=2131365137, type=RecyclerView");
    L19:
        throw new IllegalStateException("Required view not found, id=2131371746, type=".concat(TextView.class.getSimpleName()));
    L21:
        throw new IllegalStateException("Required view not found, id=2131371567, type=".concat(TextView.class.getSimpleName()));
    L23:
        throw new IllegalStateException("Required view not found, id=2131378988, type=".concat(ImageView.class.getSimpleName()));
    L25:
        throw new IllegalStateException("Required view not found, id=2131385295, type=MmSearchInputView");
    L27:
        throw new IllegalStateException("Required view not found, id=2131388775, type=MmTitleBarView");
    }
}
