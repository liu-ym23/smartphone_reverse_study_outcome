package vt2;

import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.livesdk.event.FollowStatusDataErrorEvent;

/* JADX INFO: loaded from: classes11.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b r100, String r101, FollowStatusDataErrorEvent.FollowDataSource r110, String r111, String r112, String r113, FollowInfo r114) {
            r100.a(r101, r110, r111, r112, r113, r114, "");
        }
    }

    void a(String r100, FollowStatusDataErrorEvent.FollowDataSource r101, String r102, String r103, String r104, FollowInfo r105, String r106);

    String b(FollowInfo r100);
}
