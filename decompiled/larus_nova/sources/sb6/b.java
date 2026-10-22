package sb6;

import com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.GuestLinkMainPageDialogForLinker;
import com.bytedance.kmp.live.livelink.api.guestlink.api.GuestLinkEnterChannelType;
import lb6.d;

/* JADX INFO: loaded from: classes19.dex */
public interface b extends d {
    void a(int r100, GuestLinkMainPageDialogForLinker.g r101);

    void b(lb6.a r100);

    void c(long r100, long r101, String r102, String r103, boolean r104);

    void d(lb6.a r100, boolean r101);

    boolean e();

    void g(long r100, long r101, String r102, boolean r103);

    a getLinkState();

    void h(long r100, long r101, String r102, String r103);

    void i(long r100, long r101, long r102, @GuestLinkEnterChannelType long r103);

    void j(nb6.a r100);

    void k(String r100);

    void l(long r100, long r101, int r102, int r103, String r104, String r105, long r106, boolean r110);
}
