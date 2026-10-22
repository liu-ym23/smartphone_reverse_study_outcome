package com.bytedance.awemeopen.apps.framework.comment.util;

import android.content.res.Resources;
import android.util.TypedValue;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentColorMode;
import com.bytedance.awemeopen.apps.framework.comment.widget.view.MentionEditText;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f194184a = 0;

    static {
        Resources r100 = Resources.getSystem();
        MathKt.roundToInt(TypedValue.applyDimension(1, 16, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics())));
    }

    @JvmStatic
    public static final void a(MentionEditText r100, CommentColorMode r101) {
        Intrinsics.checkNotNullParameter(r101, "colorMode");
        if (v04.b.f552303b == true) goto L7;
        v04.b.f552303b = true;
        v04.b.a(r100);
        v04.b.f552303b = false;
        return;
    }
}
