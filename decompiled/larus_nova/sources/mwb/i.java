package mwb;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f516088f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f516089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f516090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f516091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final UDShadowLayout f516092d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f516093e;

    public static final class a {
    }

    static {
    }

    public i(View r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        this.f516089a = r100;
        View r101 = r100.findViewById(R.id.subtitleRecyclerView);
        if (r101 == null) goto L15;
        this.f516090b = (RecyclerView) r101;
        this.f516091c = r100.findViewById(R.id.subtitleDegradedEmptyView);
        View r102 = r100.findViewById(R.id.backToBottomLayout);
        if (r102 == null) goto L13;
        this.f516092d = (UDShadowLayout) r102;
        View r103 = r100.findViewById(R.id.backToBottomView);
        if (r103 == null) goto L11;
        this.f516093e = (AppCompatImageView) r103;
        return;
    L11:
        throw new IllegalStateException("Required view not found, id=2131363768, type=AppCompatImageView");
    L13:
        throw new IllegalStateException("Required view not found, id=2131363767, type=UDShadowLayout");
    L15:
        throw new IllegalStateException("Required view not found, id=2131387643, type=RecyclerView");
    }
}
