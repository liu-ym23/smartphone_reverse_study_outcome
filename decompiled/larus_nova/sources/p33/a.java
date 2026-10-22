package p33;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import bi3.e;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import n43.c;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f527564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, LinearLayout> f527565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f527566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f527567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n43.b f527568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n43.a f527569f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, c> f527570g;

    public a(RecyclerView r100, Map r101, FrameLayout r102, e r103, bi3.c r104, Map r105) {
        Intrinsics.checkNotNullParameter(r100, "yataBodyContainer");
        Intrinsics.checkNotNullParameter(r101, "yataCustomContainers");
        Intrinsics.checkNotNullParameter(r103, "loadingWidget");
        Intrinsics.checkNotNullParameter(r104, "errorWidget");
        Intrinsics.checkNotNullParameter(r105, "widgets");
        this.f527564a = r100;
        this.f527565b = r101;
        this.f527566c = r102;
        this.f527567d = true;
        this.f527568e = r103;
        this.f527569f = r104;
        this.f527570g = r105;
    }
}
