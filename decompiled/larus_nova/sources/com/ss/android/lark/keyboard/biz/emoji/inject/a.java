package com.ss.android.lark.keyboard.biz.emoji.inject;

import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.keyboard.widget.RoundedIconTextView;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EmojiTopPlugin f428329a;

    public a(EmojiTopPlugin r100) {
        this.f428329a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Chat r101 = (Chat) r100;
        EmojiTopPlugin r102 = this.f428329a;
        Intrinsics.checkNotNull(r101);
        RoundedIconTextView r103 = r102.f428324d;
        if (r103 == null) goto L22;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
    L9:
        if (r105 != null) goto L12;
        return;
    L12:
        if (r101.isGroup() == false) goto L14;
    L16:
        int r106 = 0;
    L18:
        if (r105.leftMargin == r106) goto L24;
        r105.leftMargin = r106;
        r103.setLayoutParams(r105);
        return;
    L24:
        return;
    L14:
        if (com.ss.android.lark.keyboard.utils.b.a(r101) == true) goto L16;
        r106 = UIHelper.dp2px(12.0f);
        goto L18
    L8:
        r105 = null;
        goto L9
    }
}
