package ia1;

import com.bytedance.android.live.schema.convert.HybridType;
import com.bytedance.android.live.schema.convert.HybridUiType;
import com.bytedance.android.live.schema.convert.PopupGraType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HybridType f488840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HybridUiType f488841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PopupGraType f488842c;

    public /* synthetic */ a(HybridType r100, HybridUiType r101) {
        this(r100, r101, PopupGraType.OTHER);
    }

    public a(HybridType r100, HybridUiType r101, PopupGraType r102) {
        Intrinsics.checkNotNullParameter(r100, "hybridType");
        Intrinsics.checkNotNullParameter(r101, "hybridUiType");
        Intrinsics.checkNotNullParameter(r102, "popupGraType");
        this.f488840a = r100;
        this.f488841b = r101;
        this.f488842c = r102;
    }
}
