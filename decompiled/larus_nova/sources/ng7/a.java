package ng7;

import com.bytedance.sync.v2.process.d;
import com.bytedance.sync.v2.protocal.BsyncHeader;
import com.bytedance.sync.v2.protocal.BsyncTopic;
import com.bytedance.sync.v2.protocal.Ctrl;
import hg7.k;
import java.util.List;
import zf7.b;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements d<Ctrl> {
    public a() {
    }

    @Override // com.bytedance.sync.v2.process.d
    public final boolean a(Ctrl r100) {
        if (r100 != Ctrl.HttpPoll) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.sync.v2.process.d
    public final void b(BsyncHeader r100, List<BsyncTopic> r101) {
        b.d("received http poll cmd, do http poll");
        ((k) rgc.b.a(k.class)).l0(true);
    }
}
