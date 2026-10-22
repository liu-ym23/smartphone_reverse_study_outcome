package ho4;

import com.bytedance.ee.bear.bitable.anniex.util.h;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.q1;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f486215a;

    @Override // com.lynx.tasm.q1
    public final void onFirstScreen() {
        h.d(this.f486215a, "lynx_first_screen");
    }

    @Override // com.lynx.tasm.q1
    public final void onLoadSuccess() {
        h.d(this.f486215a, "lynx_load_success");
    }

    @Override // com.lynx.tasm.q1
    public final void onPageStart(String r100) {
        h r101 = this.f486215a;
        int r102 = h.f206758d;
        r101.getClass();
        r101.f206761c = System.currentTimeMillis();
    }

    @Override // com.lynx.tasm.q1, com.lynx.tasm.p
    public final void onReceivedError(LynxError r100) {
        h r101 = this.f486215a;
        if (r100 == null) goto L6;
        String r102 = r100.getMsg();
        if (r102 == null) goto L6;
    L7:
        if (r100 == null) goto L9;
        Integer r103 = Integer.valueOf(r100.getErrorCode());
    L10:
        h.c(r101, "lynx_error", r102, r103, 8);
        return;
    L9:
        r103 = null;
    L6:
        r102 = "";
        goto L7
    }

    public a(int r100, String r101) {
        this.f486215a = new h(r100, r101);
    }
}
