package com.ss.android.lark.chameleonv2.lkapi.transport;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.officesdk.utils.di.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class WhiteMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f411452a = 0;

    @AppConfig(key = "larkapi_rustcmd_whitelist")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/WhiteMap$CommandWhiteList;", "", "<init>", "()V", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CommandWhiteList {
        public CommandWhiteList() {
        }
    }

    static {
    }

    public static boolean a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "bizName");
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L10;
        j.b("LK_API_TAG_CommandWhiteMap", "command validate permission error bizName empty");
        return false;
    L10:
        String r103 = SettingManager.getInstance().getString(CommandWhiteList.class);
        if (r103 != null) goto L14;
        r103 = "";
    L14:
        if (r103.length() != 0) goto L16;
        boolean r104 = true;
    L17:
        if (r104 == false) goto L32;
        j.b("LK_API_TAG_CommandWhiteMap", "command validate permission error config empty");
        return false;
    L32:
        JSONArray r105 = JSON.parseObject(r103).getJSONArray(r100);
        if (r105.isEmpty() == false) goto L26;
        j.b("LK_API_TAG_CommandWhiteMap", "command validate permission error white list empty ".concat(r100));
        return false;
    L26:
        if (r105.contains(Integer.valueOf(r101)) == false) goto L28;
        return true;
    L28:
        j.b("LK_API_TAG_CommandWhiteMap", "command validate permission error rust command forbidden " + r100 + r101);
        return false;
    L30:
        j.b("LK_API_TAG_CommandWhiteMap", "command validate permission error config parse error");
        return false;
    L16:
        r104 = false;
        goto L17
    L5:
        r102 = false;
        goto L7
    }
}
