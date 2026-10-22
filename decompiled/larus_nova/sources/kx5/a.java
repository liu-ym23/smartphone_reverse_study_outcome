package kx5;

import com.bytedance.frameworks.baselib.network.dispatcher.IRequest;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements IRequest, Runnable, Comparable<IRequest> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f506555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f506556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f506557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f506558d;

    public a() {
        this.f506555a = new AtomicBoolean(false);
        this.f506556b = new AtomicBoolean(false);
        this.f506557c = 0;
    }

    public void b(int r100) {
        this.f506558d = r100;
    }
}
