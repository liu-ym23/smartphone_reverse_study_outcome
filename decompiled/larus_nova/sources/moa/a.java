package moa;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f514619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f514620b;

    public a(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f514620b = r100;
    }

    public a(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f514619a = r100;
    }
}
