package com.ss.android.lark.passport_user.api;

import com.ss.android.lark.passport.assemble.l;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public interface IUserListService {

    public static final enum UserLoginSource extends Enum<UserLoginSource> {
        public static final UserLoginSource ByLogin = null;
        public static final UserLoginSource ByOnPushFetch = null;
        public static final UserLoginSource ByPull = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ UserLoginSource[] f438088a = null;

        static {
            UserLoginSource r100 = new UserLoginSource("ByPull", 0);
            ByPull = r100;
            UserLoginSource r101 = new UserLoginSource("ByOnPushFetch", 1);
            ByOnPushFetch = r101;
            UserLoginSource r102 = new UserLoginSource("ByLogin", 2);
            ByLogin = r102;
            f438088a = new UserLoginSource[]{r100, r101, r102};
        }

        public static UserLoginSource[] values() {
            return (UserLoginSource[]) f438088a.clone();
        }

        public static UserLoginSource valueOf(String r100) {
            return (UserLoginSource) a.a(UserLoginSource.class, r100);
        }

        public UserLoginSource(String r100, int r101) {
            super(r100, r101);
        }
    }

    List<User> getAllValidUserList();

    User getForegroundUser();

    void q();

    List<String> r();

    l s(String r100);

    void t(List<User> r100, String r101, UserLoginSource r102);

    void u(User r100);
}
