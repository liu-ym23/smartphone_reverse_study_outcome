package com.bytedance.awemeopen.apps.framework.comment.api.constants;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/api/constants/CommentColorViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "Companion", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CommentColorViewModel extends ViewModel {
    public static final a Companion = null;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static boolean a(CommentColorMode r1) {
            Intrinsics.checkNotNullParameter(r1, "mode");
            if (r1 != CommentColorMode.MODE_DARK) goto L5;
            return true;
        L5:
            return false;
        }

        @JvmStatic
        public static boolean b(CommentColorMode r1) {
            Intrinsics.checkNotNullParameter(r1, "mode");
            if (r1 != CommentColorMode.MODE_LIGHT_OR_DARK) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final boolean isDarkMode(CommentColorMode r1) {
        Companion.getClass();
        return a.a(r1);
    }

    @JvmStatic
    public static final boolean isLightOrDarkMode(CommentColorMode r1) {
        Companion.getClass();
        return a.b(r1);
    }

    public CommentColorViewModel() {
    }

    @JvmStatic
    public static final boolean isLightMode(CommentColorMode r1) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r1, "mode");
        if (r1 != CommentColorMode.MODE_LIGHT) goto L5;
        return true;
    L5:
        return false;
    }
}
