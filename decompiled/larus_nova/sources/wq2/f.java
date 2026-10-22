package wq2;

import com.bytedance.android.livesdk.revenue.service.datacenter.UserProfileClickPos;
import com.bytedance.android.livesdk.revenue.service.datacenter.UserProfileReportType;
import com.bytedance.android.scope.o;

/* JADX INFO: loaded from: classes11.dex */
public interface f extends o {

    public static final class a {
        public static /* synthetic */ void a(f r100, String r101, UserProfileClickPos r102, String r103, UserProfileReportType r110, int r111, int r112) {
            if ((r112 & 32) == 0) goto L5;
            int r104 = 0;
        L6:
            r100.An(r101, r102, r103, r110, r104);
            return;
        L5:
            r104 = r111;
            goto L6
        }
    }

    void An(String r100, UserProfileClickPos r101, String r102, UserProfileReportType r103, int r104);

    void B4(String r100);

    void Mj();

    void Mm();

    void P1(boolean r100);

    void S1(gt1.d r100);

    void U1(boolean r100);

    void Ug();

    void Wg();

    void Wk();

    void Xf(qr2.d r100);

    void Zn(boolean r100);

    void bj(boolean r100);

    void ha();

    void k9(boolean r100);

    void kn();

    void n4(boolean r100);

    void nj(int r100);

    void qd();

    void tl(gt1.f r100);

    void y6();

    void z7();
}
