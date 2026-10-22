package x65;

import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.drive.biz.upload.multimedia.MediaUploadFragment;
import com.bytedance.ee.bear.f;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.fileselector.bean.FileBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import r65.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends za5.b {
    public final /* synthetic */ MediaUploadFragment a;

    @Override // za5.b, za5.a
    public final void b() {
        this.a.NU(0);
    }

    public b(MediaUploadFragment r1) {
        this.a = r1;
    }

    @Override // za5.b, za5.a
    public final void c(List<? extends FileBean> r8) {
        MediaUploadFragment r0 = this.a;
        ArrayList<FileBean> r1 = new ArrayList(r8);
        int r9 = MediaUploadFragment.z;
        r0.v = r1;
        if (j.a.a.getNetworkState().a() == true) goto L6;
        Toast.showFailureText(this.a.getContext(), this.a.getString(2131888423), 0);
        this.a.NU(0);
        return;
    L6:
        this.a.s = true;
        tt5.a.h("DRIVE_MediaPickerFragment", "onSelectFileBeanList: needResult= " + this.a.p + "isSend=" + this.a.s);
        MediaUploadFragment r10 = this.a;
        if (r10.p == false) goto L12;
        if (r10.q == false) goto L12;
        r10.NU(0);
        return;
    L12:
        if (r10.s == false) goto L21;
        ArrayList<FileBean> r3 = r10.v;
        ArrayList r4 = new ArrayList();
        if (r3 == null) goto L20;
        int r5 = 0;
    L18:
        if (r5 >= r3.size()) goto L20;
        r4.add(((FileBean) ListProtector.get(r3, r5)).getPath());
        r5 = r5 + 1;
    L20:
        tt5.a.h("DRIVE_MediaPickerFragment", "selected files=" + r4);
        ((e) r10.f).j(r4, r10.l, true, false);
        f r11 = (f) org.koin.java.a.a(f.class);
        MediaUploadFragment r2 = this.a;
        r11.f(r2.m, r2.n, r2.o, TipCallBackData.CONFIRM);
        return;
    L21:
        r10.NU(0);
        f r12 = (f) org.koin.java.a.a(f.class);
        MediaUploadFragment r6 = this.a;
        r12.f(r6.m, r6.n, r6.o, "cancel");
    }
}
