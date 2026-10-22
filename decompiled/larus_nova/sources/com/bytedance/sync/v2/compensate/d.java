package com.bytedance.sync.v2.compensate;

import android.os.Handler;
import com.bytedance.sync.v2.protocal.BsyncProtocol;
import com.bytedance.sync.v2.protocal.BsyncTopic;
import hg7.k;
import java.util.List;
import xf7.n;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends Rotation {
    @Override // com.bytedance.sync.v2.compensate.Rotation
    public final int c() {
        return 1;
    }

    @Override // com.bytedance.sync.v2.compensate.Rotation
    public final void a() {
        this.f270396b.b(new Object[0]).removeCallbacks(this.f270400f);
        zf7.b.a(this.f270398d + "cancelSync");
    }

    @Override // com.bytedance.sync.v2.compensate.Rotation
    public final void b() {
        zf7.b.a(this.f270398d + "start send Sync");
        this.f270397c.e0();
    }

    @Override // com.bytedance.sync.v2.compensate.Rotation
    public final boolean d(BsyncProtocol r100) {
        if (r100 == null) goto L8;
        List<BsyncTopic> r101 = r100.topics;
        if (r101 == null) goto L8;
        if (r101.isEmpty() == true) goto L8;
        return true;
    L8:
        return false;
    }

    public d(String r100, fg7.e r101, k r102, n<Handler> r103, Rotation.b r104) {
        super(r100, r101, r102, r103, r104);
    }
}
