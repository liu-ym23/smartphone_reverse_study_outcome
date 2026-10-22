package j21;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.link.model.p;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public interface d {
    void onInitPageFailed(int r100);

    void onInviteeOrApplicantListChanged(List<? extends IBaseUser> r100, String r101);

    void onPersonalPageUpdate(List<? extends p> r100, List<? extends p> r101, List<? extends IBaseUser> r102, String r103);

    void onRequestChangeMultiTeamFailed();

    void onTeamPageUpdate(List<? extends p> r100, List<? extends p> r101, List<? extends IBaseUser> r102, String r103, Map<String, Long> r104, boolean r105);
}
