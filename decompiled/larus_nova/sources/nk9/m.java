package nk9;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f519503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f519504b;

    public final Rect a() {
        Rect r100 = this.f519504b;
        this.f519503a.getGlobalVisibleRect(r100);
        return r100;
    }

    public m(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f519503a = r100;
        this.f519504b = new Rect();
    }
}
