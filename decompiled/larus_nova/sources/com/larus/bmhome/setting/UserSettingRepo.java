package com.larus.bmhome.setting;

import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.bmhome.setting.migrate.UserSettingMigrateRepo;
import com.larus.platform.model.UserConfigItem;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o2;
import hq9.y4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class UserSettingRepo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final UserSettingRepo f313819a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Keva f313820b;

    public static final class a implements com.larus.platform.api.b {
        public a() {
        }

        @Override // com.larus.platform.api.b
        public final void a(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            UserSettingRepo r101 = UserSettingRepo.f313819a;
            UserSettingRepo.f313820b = null;
        }

        @Override // com.larus.platform.api.b
        public final void b(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            UserSettingRepo r101 = UserSettingRepo.f313819a;
            UserSettingRepo.f313820b = null;
        }
    }

    public UserSettingRepo() {
    }

    static {
        f313819a = new UserSettingRepo();
        a r100 = new a();
        AccountService.f365697a.E(r100);
    }

    public static Keva c() {
        if (f313820b != null) goto L6;
        f313820b = Keva.getRepo(AccountService.f365697a.getSecUserId() + '_' + o2.f365782a.e(), 0);
    L6:
        return f313820b;
    }

    public static String a() {
        Keva r100 = c();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getString("key_pre_bot_conversation_id", "");
    }

    public static Boolean b() {
        Keva r100 = c();
        if (r100 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r100.getBoolean("key_is_in_cvs_list", false));
    }

    public final Object d(List<Integer> r100, int r101, String r110, Continuation<? super y4> r111) {
        if ((r111 instanceof UserSettingRepo$requireAllUserConfig$1) == false) goto L7;
        UserSettingRepo$requireAllUserConfig$1 r102 = (UserSettingRepo$requireAllUserConfig$1) r111;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r112 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        boolean r106 = r102.Z$0;
        String r107 = (String) r102.L$0;
        ResultKt.throwOnFailure(r112);
    L22:
        y4 r113 = (y4) r112;
        if (r106 == false) goto L44;
        if (r113 == null) goto L44;
        ArrayList<UserConfigItem> r108 = r113.a();
        if (r108 == null) goto L44;
        ArrayList r114 = new ArrayList();
        Iterator<T> r109 = r108.iterator();
    L28:
        boolean r115 = false;
        if (r109.hasNext() == false) goto L43;
        Object r116 = r109.next();
        UserConfigItem r117 = (UserConfigItem) r116;
        Integer r118 = r117.b();
        int r119 = UserConfigKey.IN_APP_BANNER_SHOW_DETAIL_ADMIN_SWITCH.getValue();
        if (r118 != null) goto L34;
    L35:
        Integer r120 = r117.b();
        int r121 = UserConfigKey.IN_APP_BANNER_SHOW_DETAIL.getValue();
        if (r120 != null) goto L39;
    L41:
        if (r115 == false) goto L28;
        r114.add(r116);
        goto L28
    L39:
        if (r120.intValue() != r121) goto L41;
    L40:
        r115 = true;
        goto L41
    L34:
        if (r118.intValue() == r119) goto L40;
    L43:
        UserSettingCacheManager.o(UserSettingCacheManager.f313814a, r114, false, r107, 2);
    L44:
        return r112;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        boolean r122 = r100.contains(Boxing.boxInt(UserConfigKey.IN_APP_BANNER_SHOW_DETAIL_ADMIN_SWITCH.getValue()));
        if (r122 == false) goto L17;
        String r123 = AccountService.f365697a.getSecUserId();
    L18:
        int r124 = UserSettingMigrateRepo.f313824a;
        r102.L$0 = r123;
        r102.Z$0 = r122;
        r102.label = 1;
        Object r125 = UserSettingMigrateRepo.a(r100, r101, r110, r102);
        if (r125 != r104) goto L21;
        return r104;
    L21:
        r107 = r123;
        r112 = r125;
        r106 = r122;
        goto L22
    L17:
        r123 = null;
    L7:
        r102 = new UserSettingRepo$requireAllUserConfig$1(this, r111);
        goto L8
    }
}
