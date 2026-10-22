package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import android.view.MotionEvent;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground.comment.uitls.CommentUtils;
import com.larksuite.component.universe_design.toast.UDToast;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void c(FragmentActivity r2, Function0 r3) {
        UDToast.a r0 = UDToast.build(r2);
        r0.g(r2.getString(2131889355));
        r0.b(2131889356, new i(r3));
        r0.h();
    }

    public static boolean a(FragmentActivity r1, MotionEvent r2, Function0 r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "onSwitchToPortrait");
        return b(r1, r2, com.bytedance.ee.bear.middleground.comment.export.e.b(), r3);
    }

    public static boolean b(FragmentActivity r2, MotionEvent r3, boolean r4, Function0 r5) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r5, "onSwitchToPortrait");
        if (r4 == true) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r6 == true) goto L11;
        return false;
    L11:
        if ((r3.getAction() & 255) != 0) goto L15;
        if (r2 != null) goto L14;
        return true;
    L14:
        c(r2, r5);
    L15:
        return true;
    L5:
        if (CommentUtils.b(r2) == false) goto L7;
        r6 = true;
        goto L8
    }
}
