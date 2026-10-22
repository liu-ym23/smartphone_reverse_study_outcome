package v43;

import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class f implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, RecyclerView> f553064a;

    @Override // v43.m
    public final Map<String, RecyclerView> getPopup() {
        return this.f553064a;
    }

    public f(int r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r101, "popup");
        this.f553064a = r101;
    }
}
