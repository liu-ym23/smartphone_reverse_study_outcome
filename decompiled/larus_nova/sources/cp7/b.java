package cp7;

import android.view.View;
import com.bytedance.ugc.glue.UGCTools;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f464719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<Integer[]> f464720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f464721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f464722d;

    public static final class a extends View {
    }

    public b(int r100, int r101) {
        this.f464721c = r100;
        this.f464722d = r101;
        this.f464719a = UGCTools.getPxByDp(5.0f);
        this.f464720b = new ArrayList();
    }

    public final void a(int r100, int r101, int r102, int r103, int r104) {
        if (r104 == 0) goto L5;
        this.f464720b.add(new Integer[]{Integer.valueOf(r100), Integer.valueOf(r101), Integer.valueOf(r102), Integer.valueOf(r103), Integer.valueOf(r104)});
        return;
    }
}
