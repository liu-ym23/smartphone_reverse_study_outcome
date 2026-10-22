package sdb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiHandler;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import zz7.b;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f541492a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f541493b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f541494c = 0;

    static {
        f541492a = b.g(UIHelper.getContext(), 16);
        f541493b = (int) b.h(UIHelper.getContext(), 14);
        f541494c = 2;
    }

    @JvmStatic
    public static final void a(Context r100, SpannableStringBuilder r101, String r110, String r111, IGetDataCallback<Boolean> r112, int r113) {
        Intrinsics.checkNotNullParameter(r110, "emojiKey");
        if (r100 == null) goto L18;
        Drawable r102 = EmojiHandler.c(r110, r112, r112);
        String r114 = qsb.b.a().df(r110);
        if (r114.length() <= 0) goto L7;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        StringBuilder r115 = new StringBuilder("[");
        r115.append(r114);
    L13:
        r115.append(']');
        r111 = r115.toString();
    L14:
        int r116 = r101.length();
        r101.append(r111);
        if (r102 == null) goto L19;
        r101.setSpan(new com.ss.android.lark.widget.linked_emojicon.base.a(r100, r102, r110, r113, f541494c, f541493b), r116, r101.length(), 17);
        return;
    L19:
        return;
    L11:
        if (r111 != null) goto L14;
        r115 = new StringBuilder("[");
        r115.append(r110);
        goto L13
    L7:
        r103 = false;
        goto L9
    }
}
