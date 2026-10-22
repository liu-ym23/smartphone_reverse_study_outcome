package xzb;

import kotlin.Deprecated;
import nzb.b;
import ozb.c;

/* JADX INFO: loaded from: classes37.dex */
public interface a {
    @Deprecated(message = "use com.ss.android.lark.passport_user.api.container.ILarkUserListApi instead")
    String getSession();

    @Deprecated(message = "use com.ss.android.lark.passport_user.api.container.ILarkUserListApi instead")
    String getTenantId();

    @Deprecated(message = "use com.ss.android.lark.passport_user.api.container.ILarkUserListApi instead")
    String getUserId();

    @Deprecated(message = "use com.ss.android.lark.passport_user.api.container.ILarkUserListApi instead")
    String getUserName();

    void registerLoginListener(b r100);

    void registerLogoutListener(c r100);

    void registerUserListChangeListener(mzb.a r100);

    void registerUserSwitchListener(qzb.a r100);

    void unregisterUserListChangeListener(mzb.a r100);

    void unregisterUserSwitchListener(qzb.a r100);
}
