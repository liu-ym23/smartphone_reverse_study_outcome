package com.ss.android.lark.chat.utils;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f416752a = 0;

    static {
    }

    public static boolean a(Chat r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        Chat.RestrictedWhiteListSetting r101 = r100.getRestrictedModeSetting().getWhiteListSetting();
        if (r101 != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L14;
        return true;
    L14:
        if (r100.getRestrictedModeSetting().getSwitch() == true) goto L16;
        return true;
    L16:
        if (r100.getRestrictedModeSetting().getCopy() == Chat.RestrictedModeSetting.Participant.ALL_MEMBERS) goto L21;
        return false;
    L21:
        return true;
    L8:
        if (r101.isHitWhiteList() != true) goto L10;
        r102 = true;
        goto L11
    }

    public static boolean b(Chat r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        Chat.RestrictedWhiteListSetting r101 = r100.getRestrictedModeSetting().getWhiteListSetting();
        if (r101 != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L14;
        return true;
    L14:
        if (r100.getRestrictedModeSetting().getSwitch() == true) goto L16;
        return true;
    L16:
        if (r100.getRestrictedModeSetting().getDownload() == Chat.RestrictedModeSetting.Participant.ALL_MEMBERS) goto L21;
        return false;
    L21:
        return true;
    L8:
        if (r101.isHitWhiteList() != true) goto L10;
        r102 = true;
        goto L11
    }

    public static boolean c(Chat r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        Chat.RestrictedWhiteListSetting r101 = r100.getRestrictedModeSetting().getWhiteListSetting();
        if (r101 != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L14;
        return true;
    L14:
        if (r100.getRestrictedModeSetting().getSwitch() == true) goto L16;
        return true;
    L16:
        if (r100.getRestrictedModeSetting().getForward() == Chat.RestrictedModeSetting.Participant.ALL_MEMBERS) goto L21;
        return false;
    L21:
        return true;
    L8:
        if (r101.isHitWhiteList() != true) goto L10;
        r102 = true;
        goto L11
    }

    public static boolean d(Chat r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        Chat.RestrictedWhiteListSetting r101 = r100.getRestrictedModeSetting().getWhiteListSetting();
        if (r101 != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L14;
        return true;
    L14:
        if (r100.getRestrictedModeSetting().getSwitch() == true) goto L16;
        return true;
    L16:
        if (r100.getRestrictedModeSetting().getDownload() == Chat.RestrictedModeSetting.Participant.ALL_MEMBERS) goto L21;
        return false;
    L21:
        return true;
    L8:
        if (r101.isHitWhiteList() != true) goto L10;
        r102 = true;
        goto L11
    }

    public static boolean e(Chat r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        Chat.RestrictedWhiteListSetting r101 = r100.getRestrictedModeSetting().getWhiteListSetting();
        if (r101 != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L14;
        return true;
    L14:
        if (r100.getRestrictedModeSetting().getSwitch() == true) goto L16;
        return true;
    L16:
        if (r100.getRestrictedModeSetting().getScreenshot() == Chat.RestrictedModeSetting.Participant.ALL_MEMBERS) goto L21;
        return false;
    L21:
        return true;
    L8:
        if (r101.isHitWhiteList() != true) goto L10;
        r102 = true;
        goto L11
    }

    public static void f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDToast.show(r100, R.string.Lark_IM_RestrictedMode_CopyForwardNotAllow_Toast);
    }

    public static void g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDToast.show(r100, R.string.Lark_IM_RestrictedMode_CopyForwardNotAllow_Toast);
    }
}
