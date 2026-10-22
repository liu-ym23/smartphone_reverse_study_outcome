package yv7;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BridgeAdapterDataObserver.a f569298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f569299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<RecyclerView.Adapter> f569300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<RecyclerView.Adapter> f569301d;

    public a(BridgeAdapterDataObserver.a r100) {
        this.f569298a = r100;
        this.f569299b = new ArrayList();
        this.f569300c = new ArrayList();
        this.f569301d = new ArrayList();
        new ArrayList();
    }

    public final RecyclerView.Adapter a(int r100) {
        return (RecyclerView.Adapter) ListProtector.get(this.f569300c, r100);
    }

    public final int b(b r100) {
        return ((ArrayList) this.f569299b).indexOf(r100);
    }
}
