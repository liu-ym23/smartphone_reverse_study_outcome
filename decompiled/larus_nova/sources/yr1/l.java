package yr1;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.android.live.base.model.user.IBaseUser;

/* JADX INFO: loaded from: classes8.dex */
public interface l {
    com.bytedance.android.livesdk.chatroom.vs_host.business.q a(Activity r100, String r101, String r102, IBaseUser r103, long r104, boolean r105);

    void c(IBaseUser r100, boolean r101);

    com.bytedance.android.livesdk.chatroom.vs_host.business.r d();

    boolean f(Integer r100, String r101);

    void showManagePoiDialog(Context r100, boolean r101, long r102, DialogInterface.OnDismissListener r103);

    void showPoiInfoDialogForAudience(Context r100, String r101, String r102, String r103);
}
