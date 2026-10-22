package oic;

import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import com.ss.android.videoshop.context.VideoContext;
import nic.n;

/* JADX INFO: loaded from: classes40.dex */
public final class c implements n {
    public c() {
    }

    @Override // nic.n
    public final void a(VideoContext r100, vic.a r101, int r102, int r103, boolean r104) {
        if (r101.f555368g == false) goto L5;
        return;
    L5:
        if (r104 == false) goto L8;
        r101.f555363b.removeMessages(1);
        WeakHandler r105 = r101.f555363b;
        r105.sendMessageDelayed(Message.obtain(r105, 1, r102, 0), 300);
        return;
    }
}
