package com.bytedance.awemeopen.apps.framework.comment.util;

import android.content.res.Resources;
import android.util.TypedValue;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentColorMode;
import com.bytedance.awemeopen.apps.framework.comment.widget.view.MentionEditText;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
        Resources r1 = Resources.getSystem();
        MathKt.roundToInt(TypedValue.applyDimension(1, 16, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics())));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void a(MentionEditText r1, CommentColorMode r2) {
        Intrinsics.checkNotNullParameter(r2, "colorMode");
        if (v04.b.b == true) goto L7;
        v04.b.b = true;
        v04.b.a(r1);
        v04.b.b = false;
        return;
    }
}
