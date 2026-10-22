package mv2;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes11.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.LayoutManager f515876a;

    public abstract int a(View r100);

    public abstract int b(View r100);

    public abstract int c(View r100);

    public abstract int d();

    public abstract int e();

    public abstract int f();

    public c(RecyclerView.LayoutManager r100) {
        new Rect();
        this.f515876a = r100;
    }
}
