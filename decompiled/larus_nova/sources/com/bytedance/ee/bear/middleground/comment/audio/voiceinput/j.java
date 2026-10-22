package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import android.view.MotionEvent;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground.comment.uitls.CommentUtils;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f230430a = 0;

    static {
    }

    public static void c(FragmentActivity r100, Function0 r101) {
        UDToast.a r102 = UDToast.build(r100);
        r102.g(r100.getString(R.string.LarkCCM_Docx_LandscapeMode_Dictate_Toast));
        r102.b(R.string.LarkCCM_Docx_LandscapeMode_Switch_Button, new i(r101));
        r102.h();
    }

    public static boolean a(FragmentActivity r100, MotionEvent r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, "onSwitchToPortrait");
        return b(r100, r101, com.bytedance.ee.bear.middleground.comment.export.e.b(), r102);
    }

    public static boolean b(FragmentActivity r100, MotionEvent r101, boolean r102, Function0 r103) {
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r103, "onSwitchToPortrait");
        if (r102 == true) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == true) goto L11;
        return false;
    L11:
        if ((r101.getAction() & 255) != 0) goto L15;
        if (r100 != null) goto L14;
        return true;
    L14:
        c(r100, r103);
    L15:
        return true;
    L5:
        if (CommentUtils.b(r100) == false) goto L7;
        r104 = true;
        goto L8
    }
}
