package com.bytedance.awemeopen.apps.framework.comment.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentColorMode;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentColorViewModel;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final Drawable a(boolean r4, CommentColorMode r5, Context r6) {
        Intrinsics.checkNotNullParameter(r5, "colorMode");
        Intrinsics.checkNotNullParameter(r6, "context");
        if (r4 == false) goto L12;
        CommentColorViewModel.Companion.getClass();
        if (CommentColorViewModel.a.b(r5) == false) goto L8;
        return c(r6, 2131236741, 2131100053);
    L8:
        if (CommentColorViewModel.a.a(r5) == false) goto L11;
        return c(r6, 2131236741, 2131099799);
    L11:
        return c(r6, 2131236741, 2131100048);
    L12:
        CommentColorViewModel.Companion.getClass();
        if (CommentColorViewModel.a.b(r5) == false) goto L16;
        return c(r6, 2131236745, 2131100053);
    L16:
        if (CommentColorViewModel.a.a(r5) == false) goto L19;
        return c(r6, 2131236745, 2131099799);
    L19:
        return c(r6, 2131236745, 2131100048);
    }

    @JvmStatic
    public static final Drawable b(boolean r1, CommentColorMode r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "colorMode");
        Intrinsics.checkNotNullParameter(r3, "context");
        if (r1 == true) goto L13;
        CommentColorViewModel.Companion.getClass();
        if (CommentColorViewModel.a.b(r2) == false) goto L9;
        return c(r3, 2131236736, 2131100053);
    L9:
        if (CommentColorViewModel.a.a(r2) == false) goto L12;
        return c(r3, 2131236736, 2131099799);
    L12:
        return c(r3, 2131236736, 2131100048);
    L13:
        return c(r3, 2131236731, 2131099677);
    }

    public static Drawable c(Context r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Drawable r4 = ContextCompat.getDrawable(r1, r2);
        if (r4 == null) goto L7;
        Drawable r0 = DrawableCompat.wrap(r4).mutate();
        if (r0 == null) goto L7;
        DrawableCompat.setTint(r0, ContextCompat.getColor(r1, r3));
    L7:
        return r4;
    }
}
