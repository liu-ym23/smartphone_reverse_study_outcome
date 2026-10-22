package com.ss.android.lark.flow.mergeforward.page.plugin;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chat.chatwindow.biz.plugin.core.d;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.c;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends com.ss.android.lark.flow.chat.page.flow.plugin.b {
    public a() {
    }

    @Override // com.ss.android.lark.flow.chat.page.flow.plugin.b, com.ss.android.lark.chat.chatwindow.biz.plugin.core.e
    public final List<d> a(FragmentActivity r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "chatApp");
        return super.a(r100, r101);
    }
}
