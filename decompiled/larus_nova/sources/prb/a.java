package prb;

import android.content.Context;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.export.ui.message.style.BubbleStyle;
import idb.f;
import kotlin.jvm.internal.Intrinsics;
import v5b.c;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f530390a = 0;

    static {
    }

    public static boolean c(r5b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "chatContext");
        if (r100.Y() == false) goto L5;
    L11:
        return false;
    L5:
        if (r100.q() == true) goto L11;
        if (r100.r() == true) goto L11;
        if (r100.m() == true) goto L11;
        return true;
    }

    public static void a(Context r100, View r101) {
        BubbleStyle.a(12, r101, new int[]{UIUtils.dp2px(r100, 0.0f), UIUtils.dp2px(r100, 12.0f), UIUtils.dp2px(r100, 12.0f), UIUtils.dp2px(r100, 12.0f)});
    }

    public static BubbleStyle b(Context r100, c r101, r5b.a r102) {
        Intrinsics.checkNotNullParameter(r101, "messageVO");
        Intrinsics.checkNotNullParameter(r102, "chatContext");
        int[] r103 = {UIUtils.dp2px(r100, 12.0f), UIUtils.dp2px(r100, 12.0f), UIUtils.dp2px(r100, 12.0f), UIUtils.dp2px(r100, 12.0f)};
        if (r101.h() == true) goto L7;
        BubbleStyle.a(1, null, r103);
        return BubbleStyle.f415420h;
    L7:
        if (r101.d() == true) goto L10;
        BubbleStyle.a(0, null, r103);
        return BubbleStyle.f415420h;
    L10:
        Intrinsics.checkNotNullParameter(r102, "chatContext");
        if (f.a().isEnable("im.message.thread_reply_bubble_optimize") == true) goto L13;
    L15:
        boolean r104 = false;
    L16:
        if (r104 == false) goto L18;
        BubbleStyle.a(0, null, r103);
        BubbleStyle r105 = BubbleStyle.f415420h;
        Intrinsics.checkNotNull(r105);
        return r105;
    L18:
        BubbleStyle.a(1, null, r103);
        BubbleStyle r106 = BubbleStyle.f415420h;
        Intrinsics.checkNotNull(r106);
        return r106;
    L13:
        if (c(r102) == false) goto L15;
        r104 = true;
        goto L16
    }
}
