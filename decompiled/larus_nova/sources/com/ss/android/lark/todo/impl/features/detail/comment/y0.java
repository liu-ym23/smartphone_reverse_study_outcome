package com.ss.android.lark.todo.impl.features.detail.comment;

import com.larus.nova.R;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class y0 extends com.ss.android.lark.keyboard.keyboard2.m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f443011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final KeyboardMenuItemKey f443012d;

    public interface a {
        void onClick();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final int a() {
        return R.drawable.ud_icon_attachment_outlined;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void s() {
        this.f443011c.onClick();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final KeyboardMenuItemKey g() {
        return this.f443012d;
    }

    public y0(CommentKeyboardSection$2$1$1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "dependency");
        this.f443011c = r100;
        this.f443012d = KeyboardMenuItemKey.TodoAttachment;
    }
}
