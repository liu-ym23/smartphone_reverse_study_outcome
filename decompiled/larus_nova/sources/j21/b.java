package j21;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.p;
import java.util.List;

/* JADX INFO: loaded from: classes47.dex */
public interface b {
    void onInviteeOrApplicantListChanged(List<? extends IBaseUser> r100);

    void onPageRecsFetch(List<? extends p> r100, List<? extends p> r101, List<? extends IBaseUser> r102, IRivalRankRecommendResponse r103, boolean r104);

    void onPageUpdate(List<? extends p> r100, List<? extends p> r101, List<? extends IBaseUser> r102, IRivalRankRecommendResponse r103, boolean r104);
}
