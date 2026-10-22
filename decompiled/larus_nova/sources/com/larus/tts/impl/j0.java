package com.larus.tts.impl;

import com.bytedance.keva.Keva;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o2;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Keva f370242a;

    public static final class a implements com.larus.platform.api.b {
        public a() {
        }

        @Override // com.larus.platform.api.b
        public final void a(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Keva r101 = j0.f370242a;
            j0.f370242a = null;
        }

        @Override // com.larus.platform.api.b
        public final void b(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Keva r101 = j0.f370242a;
            j0.f370242a = null;
        }
    }

    static {
        a r100 = new a();
        AccountService.f365697a.E(r100);
    }

    public static boolean b() {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("getMainBotUserChangedTtsSwitch, ");
        Keva r102 = d();
        if (r102 == null) goto L5;
        Boolean r103 = Boolean.valueOf(r102.getBoolean("user_has_changed_tts_switch", false));
    L6:
        r101.append(r103);
        r100.e("SettingRepo", r101.toString());
        Keva r104 = d();
        if (r104 != null) goto L9;
        return false;
    L9:
        return r104.getBoolean("user_has_changed_tts_switch", false);
    L5:
        r103 = null;
        goto L6
    }

    public static Keva d() {
        if (f370242a != null) goto L6;
        f370242a = Keva.getRepo(AccountService.f365697a.getSecUserId() + '_' + o2.f365782a.e(), 0);
    L6:
        return f370242a;
    }

    public static int a() {
        Keva r100 = d();
        if (r100 != null) goto L5;
        return -1;
    L5:
        return r100.getInt("bot_global_tts_switch", -1);
    }

    public static int c(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        FLogger.f375446a.e("SettingRepo", "cvs id is null please check code !!!");
        return -1;
    L12:
        Keva r102 = d();
        if (r102 != null) goto L15;
        return -1;
    L15:
        return r102.getInt("bot_tts_switch_" + r100, -1);
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L9
    }
}
