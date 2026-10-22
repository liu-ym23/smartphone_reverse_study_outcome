package hy;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public interface f {

    public static class a implements b {
        public a() {
        }

        @Override // hy.f.b
        public void a(int r100, List r101) {
        }

        @Override // hy.f.b
        public void b(int r100, List<AnchorLinkUser> r101) {
        }

        @Override // hy.f.b
        public void c(int r100, List<User> r101) {
        }

        @Override // hy.f.b
        public void d(int r100, List<AnchorLinkUser> r101) {
        }
    }

    public interface b {
        void a(int r100, List r101);

        void b(int r100, List<AnchorLinkUser> r101);

        void c(int r100, List<User> r101);

        void d(int r100, List<AnchorLinkUser> r101);
    }

    List<AnchorLinkUser> a();

    void attach();

    void b(int r100, String r101);

    AnchorLinkUser getGuestInfo(String r100, String r101);

    List<AnchorLinkUser> getOnlineUserList();

    void h(a r100);

    void i(a r100);

    void r0();

    void v();
}
