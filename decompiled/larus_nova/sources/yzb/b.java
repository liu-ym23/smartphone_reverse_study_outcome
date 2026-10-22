package yzb;

import com.ss.android.lark.passport.signinsdk_api.account.TenantInfo;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import java.util.List;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes37.dex */
public interface b {
    User a(String r100);

    @Deprecated(message = "")
    TenantInfo b(User r100);

    String c();

    String d();

    List<User> getAllValidUserList();

    User getForegroundUser();

    boolean isLogin();
}
