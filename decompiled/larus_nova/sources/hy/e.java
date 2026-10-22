package hy;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public interface e extends f {
    boolean N(String r100);

    int c();

    void clear(boolean r100);

    List<AnchorLinkUser> d();

    void e(User r100);

    AnchorLinkUser f(String r100, boolean r101);

    AnchorLinkUser g(String r100);

    List<User> getInviteeList();

    void j();

    void k(User r100);
}
