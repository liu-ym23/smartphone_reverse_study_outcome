package rs7;

import android.text.TextUtils;
import com.dtf.face.api.IDTResponseCode;
import com.dtf.face.log.RecordService;
import faceverify.q;
import qs7.c;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a extends c.b {
    @Override // qs7.c.b
    public final void d() {
    }

    public abstract void e(String r100, String r101);

    @Override // ms7.a
    public final void onSuccess() {
        e(IDTResponseCode.ZIM_NET_VERIFY_SUCCESS, null);
    }

    public a() {
    }

    @Override // ms7.a
    public final void a(String r100) {
        e("3003", r100);
    }

    @Override // ms7.a
    public final void onError(String r100, String r101) {
        if ("Z1028".equals(r100) == false) goto L6;
        e("Z1028", r101);
        return;
    L6:
        if ("Z6003".equals(r100) == false) goto L8;
        e("Z6003", r101);
        return;
    L8:
        e("Z1027", r101);
    }

    @Override // ms7.a
    public final void onServerError(String r100, String r101) {
        e(r100, r101);
    }

    @Override // ms7.a
    public final void b(String r100, String r101, String r102) {
        String r103 = hs7.a.h().M;
        RecordService r104 = RecordService.getInstance();
        String[] r105 = new String[2];
        r105[0] = "msg";
        if (TextUtils.isEmpty(r103) == false) goto L5;
        r103 = "NULL";
    L5:
        r105[1] = r103;
        r104.recordEvent(2, q.KEY_PREVIEW_TRACE, r105);
        e("VerifyError|" + r100, r102);
    }
}
