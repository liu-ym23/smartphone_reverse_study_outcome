package s9;

import android.content.Context;
import android.os.MessageQueue;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements MessageQueue.IdleHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f541033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f541034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f541035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f541036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ e f541037e;

    public b(Context r100, String r101, String r102, int r103, e r104) {
        this.f541033a = r100;
        this.f541034b = r101;
        this.f541035c = r102;
        this.f541036d = r103;
        this.f541037e = r104;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        ConcurrentHashMap<Integer, f> r100 = a.f541022a;
        a.c(this.f541033a, this.f541034b, this.f541035c, this.f541036d, this.f541037e);
        return false;
    }
}
