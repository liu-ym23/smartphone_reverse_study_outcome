package qe7;

import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import java.util.concurrent.Callable;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class b<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f532696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UpdatePackage f532697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f532698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Throwable f532699d;

    public b(a r100, UpdatePackage r101, boolean r102, Throwable r103) {
        this.f532696a = r100;
        this.f532697b = r101;
        this.f532698c = r102;
        this.f532699d = r103;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        JSONObject r100 = new JSONObject();
        UpdatePackage r101 = this.f532697b;
        a r102 = this.f532696a;
        boolean r103 = this.f532698c;
        Throwable r104 = this.f532699d;
        if (r101 == null) goto L6;
        String r105 = r101.getChannel();
        if (r105 == null) goto L6;
    L7:
        r100.put("channel", r105);
        r100.put("failed", r103);
        if (r104 == null) goto L11;
        String r106 = r104.getMessage();
        if (r106 == null) goto L11;
    L12:
        r100.put("failedMsg", r106);
        EventCenter.enqueueEvent(new Event(this.f532696a.f532686b + "_getGeckoUpdateResult", System.currentTimeMillis(), new f66.d(r100)));
        return;
    L11:
        r106 = "";
    L6:
        r105 = r102.f532686b;
        goto L7
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
