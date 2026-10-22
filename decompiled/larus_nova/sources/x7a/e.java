package x7a;

import com.lynx.tasm.LynxView;
import com.lynx.tasm.q1;

/* JADX INFO: loaded from: classes32.dex */
public final class e extends q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxView f562862a;

    @Override // com.lynx.tasm.q1
    public final void onLoadSuccess() {
        w6a.h.a.f558471a.b(this.f562862a);
        this.f562862a.onEnterForeground();
    }

    public e(LynxView r100) {
        this.f562862a = r100;
    }
}
