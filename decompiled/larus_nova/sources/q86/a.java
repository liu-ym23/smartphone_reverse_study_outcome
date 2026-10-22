package q86;

import com.lynx.tasm.base.LLog;
import com.ss.android.videoshop.mediaview.SimpleMediaView;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements nic.a {
    public a() {
    }

    @Override // nic.a
    public final void b(SimpleMediaView r100) {
        LLog.i("LynxVideoAttachListener", r100 + " is attach");
    }

    @Override // nic.a
    public final void c(SimpleMediaView r100) {
        LLog.i("LynxVideoAttachListener", r100 + " is detach");
    }

    @Override // nic.a
    public final void a(SimpleMediaView r100, boolean r101) {
        if (r101 == false) goto L5;
        LLog.i("LynxVideoAttachListener", r100 + " is visible");
        return;
    L5:
        LLog.i("LynxVideoAttachListener", r100 + " is invisible");
    }
}
