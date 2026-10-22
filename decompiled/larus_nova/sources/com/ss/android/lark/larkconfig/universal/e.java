package com.ss.android.lark.larkconfig.universal;

import com.bytedance.lark.pb.basic.v1.UniversalUserSetting;
import com.ss.android.lark.log.Log;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f431131a = null;

    public e() {
    }

    static {
        f431131a = new e();
        new CopyOnWriteArrayList();
    }

    public final UniversalUserSetting a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        a.f431126a.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        UniversalUserSetting r101 = (UniversalUserSetting) ((LinkedHashMap) a.f431127b).get(r100);
        if (r101 != null) goto L6;
        Log.e("UniversalUserSettingManager", "no universal user setting for " + r100 + ", default values are used");
        return new UniversalUserSetting.Builder().key(r100).bool_value(Boolean.FALSE).int_value(0L).str_value("").build();
    L6:
        return r101;
    }
}
