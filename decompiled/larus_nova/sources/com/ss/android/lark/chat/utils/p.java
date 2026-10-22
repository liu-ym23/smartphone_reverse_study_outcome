package com.ss.android.lark.chat.utils;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f416714a = 0;

    static {
    }

    @JvmStatic
    public static final View a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        if (FeatureGatingModule.getFeatureGatingService().isEnable("im.message.message_background_and_padding") == true) goto L10;
        FrameLayout r101 = (FrameLayout) r100.findViewById(R.id.msg_swipe_view_background);
        if (r101 != null) goto L8;
        return r100;
    L8:
        return r101;
    L10:
        return r100;
    }

    @JvmStatic
    public static final int b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return UIUtils.getColor(r100, R.color.static_white);
    }

    @JvmStatic
    public static final int c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return UIUtils.getColor(r100, R.color.text_caption);
    }

    @JvmStatic
    public static final int d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return UIUtils.getColor(r100, R.color.text_link_normal);
    }

    @JvmStatic
    public static final int e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return UIUtils.getColor(r100, R.color.text_placeholder);
    }

    @JvmStatic
    public static final boolean f(ChatThemeInfo.Scene r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100 != ChatThemeInfo.Scene.DARK) goto L10;
        return true;
    L10:
        return false;
    }

    @JvmStatic
    public static final boolean g(ChatThemeInfo.Scene r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100 == ChatThemeInfo.Scene.DEFAULT_SCENE) goto L10;
        return true;
    L10:
        return false;
    }
}
