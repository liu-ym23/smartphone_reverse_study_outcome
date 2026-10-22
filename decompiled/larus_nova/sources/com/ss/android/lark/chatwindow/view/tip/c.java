package com.ss.android.lark.chatwindow.view.tip;

import android.content.Context;
import com.larus.nova.R;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import wgb.f;

/* JADX INFO: loaded from: classes35.dex */
public class c<T> extends a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f417112f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f417113g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f417114h;

    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final boolean f() {
        return true;
    }

    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final boolean g() {
        return false;
    }

    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final boolean i() {
        f r100 = (f) this;
        if ((r100.f417113g - r100.f417114h) > 0) goto L5;
    L7:
        return false;
    L5:
        if (this.f417103b.f() != Chat.MessagePosition.NEWEST_UNREAD) goto L7;
        return true;
    }

    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final int b() {
        if (this.f417112f <= this.f417103b.b()) goto L7;
        return this.f417112f;
    L7:
        return this.f417103b.G7();
    }

    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final boolean h() {
        if (this.f417103b.f() == Chat.MessagePosition.NEWEST_UNREAD) goto L5;
    L9:
        return false;
    L5:
        if ((!this.f417105d) == false) goto L9;
        f r100 = (f) this;
        if ((r100.f417113g - r100.f417114h) <= 0) goto L9;
        ChatCoreModule.a().getAppConfigDependency().isOn();
        return true;
    }

    static {
        UIHelper.getDimens(R.dimen.title_height);
    }

    public c(Context r100, r7b.c r101) {
        super(r100, r101);
        UIHelper.dp2px(8.0f);
        this.f417113g = -1;
        UIHelper.dp2px(8.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final void j(List<T> r100, a.b<T> r101) {
        Iterator r102 = ((ArrayList) r100).iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        int r103 = r101.b(r102.next());
        if (r103 == (-1)) goto L4;
        if (this.f417113g <= r103) goto L4;
        this.f417113g = r103;
        goto L4
    L11:
        super.j(r100, r101);
    }
}
