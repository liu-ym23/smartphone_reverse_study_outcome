package com.ss.android.lark.chat.chatwindow.biz.component.keyboard;

import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f412048a = 0;

    static {
    }

    public static boolean a(OpenApp r100) {
        if (r100 == null) goto L5;
        boolean r101 = Intrinsics.areEqual(r100.getCanEdit(), Boolean.TRUE);
    L6:
        if (r101 == true) goto L8;
        return false;
    L8:
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("open_app.bot.without_callback_owner_show_input") == false) goto L12;
        return true;
    L12:
        return false;
    L5:
        r101 = false;
        goto L6
    }

    public static boolean b(Chat r100, Chatter r101, OpenApp r102) {
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L33;
        if (r100 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == true) goto L34;
        if (r102 != null) goto L18;
    L22:
        boolean r105 = false;
    L23:
        if (r105 == true) goto L35;
        if (r100 != null) goto L26;
    L28:
        boolean r106 = false;
    L29:
        if (r106 == true) goto L36;
        return false;
    L36:
        return true;
    L26:
        if (r100.isFrozen() == false) goto L28;
        r106 = true;
        goto L29
    L35:
        return true;
    L18:
        if (r102.getChatable() != OpenApp.Chatable.UNCHATABLE) goto L22;
        if (a(r102) == true) goto L22;
        r105 = true;
        goto L23
    L34:
        return true;
    L11:
        if (r100.isChatable() == false) goto L14;
        r104 = false;
        goto L15
    L33:
        return true;
    L5:
        if (r101.isDimission() == false) goto L7;
        r103 = true;
        goto L8
    }
}
