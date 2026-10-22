package y62;

import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.interactivity.comment.mylive.MyLiveEntranceManager;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IBaseUser f566330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MyLiveEntranceManager f566331b;

    public c(IBaseUser r100, MyLiveEntranceManager r101) {
        this.f566330a = r100;
        this.f566331b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        UserProfileEvent r101 = new UserProfileEvent(this.f566330a);
        r101.setClickUserPosition(UserProfileEvent.POSITION_MY_LIVE);
        xs2.b.a().post(r101);
        MyLiveEntranceManager.a(this.f566331b);
    }
}
