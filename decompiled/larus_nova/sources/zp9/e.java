package zp9;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.profile.impl.creation.w3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f573217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f573218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f573219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView.RecycledViewPool f573220d;

    public e(n r100, m r101, w3 r102, RecyclerView.RecycledViewPool r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, "repository");
        this.f573217a = r100;
        this.f573218b = r101;
        this.f573219c = r102;
        this.f573220d = r103;
    }
}
