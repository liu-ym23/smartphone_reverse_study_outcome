package com.bytedance.awemeopen.apps.framework.comment.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentColorMode;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentColorViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final Drawable a(boolean r100, CommentColorMode r101, Context r102) {
        Intrinsics.checkNotNullParameter(r101, "colorMode");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r100 == false) goto L12;
        CommentColorViewModel.Companion.getClass();
        if (CommentColorViewModel.a.b(r101) == false) goto L8;
        return c(r102, R.drawable.ic_s_s_heartbroken_filled_16, R.color.TextTertiary);
    L8:
        if (CommentColorViewModel.a.a(r101) == false) goto L11;
        return c(r102, R.drawable.ic_s_s_heartbroken_filled_16, R.color.ConstTextInverse4);
    L11:
        return c(r102, R.drawable.ic_s_s_heartbroken_filled_16, R.color.TextReverse3);
    L12:
        CommentColorViewModel.Companion.getClass();
        if (CommentColorViewModel.a.b(r101) == false) goto L16;
        return c(r102, R.drawable.ic_s_s_heartbroken_outlined_16, R.color.TextTertiary);
    L16:
        if (CommentColorViewModel.a.a(r101) == false) goto L19;
        return c(r102, R.drawable.ic_s_s_heartbroken_outlined_16, R.color.ConstTextInverse4);
    L19:
        return c(r102, R.drawable.ic_s_s_heartbroken_outlined_16, R.color.TextReverse3);
    }

    @JvmStatic
    public static final Drawable b(boolean r100, CommentColorMode r101, Context r102) {
        Intrinsics.checkNotNullParameter(r101, "colorMode");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r100 == true) goto L13;
        CommentColorViewModel.Companion.getClass();
        if (CommentColorViewModel.a.b(r101) == false) goto L9;
        return c(r102, R.drawable.ic_s_s_heart_outlined_20, R.color.TextTertiary);
    L9:
        if (CommentColorViewModel.a.a(r101) == false) goto L12;
        return c(r102, R.drawable.ic_s_s_heart_outlined_20, R.color.ConstTextInverse4);
    L12:
        return c(r102, R.drawable.ic_s_s_heart_outlined_20, R.color.TextReverse3);
    L13:
        return c(r102, R.drawable.ic_s_s_heart_filled_20, R.color.BGBadge);
    }

    public static Drawable c(Context r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Drawable r103 = ContextCompat.getDrawable(r100, r101);
        if (r103 == null) goto L7;
        Drawable r104 = DrawableCompat.wrap(r103).mutate();
        if (r104 == null) goto L7;
        DrawableCompat.setTint(r104, ContextCompat.getColor(r100, r102));
    L7:
        return r103;
    }
}
