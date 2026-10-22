package x64;

import com.bytedance.badger.monitor.CollectStage;
import com.bytedance.badger.monitor.TriggerStage;
import com.bytedance.badger.utils.C10462c;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements z64.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z64.f f562606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f562607b;

    public a(z64.f r100, long r101) {
        this.f562606a = r100;
        this.f562607b = r101;
    }

    @Override // z64.g
    public final void a(z64.i r210) {
        if ((r210 instanceof z64.i.b) == false) goto L6;
        com.bytedance.badger.monitor.c.a(com.bytedance.badger.monitor.c.f199044c, TriggerStage.login, CollectStage.collect_finished, this.f562606a, null, 0, System.currentTimeMillis() - this.f562607b, 0, null, null, false, 0, null, 0, z64.h.c.f570473a, 6544);
        return;
    L6:
        if ((r210 instanceof z64.i.a) == false) goto L10;
        com.bytedance.badger.monitor.c.b(com.bytedance.badger.monitor.c.f199044c, TriggerStage.login, new C10462c("update errorMsg:" + ((z64.i.a) r210).f570475a, -1203, null, null, 12), 0, null, 0, 0, 0, this.f562606a, null, false, 0, null, z64.h.c.f570473a, 3964);
        return;
    }
}
