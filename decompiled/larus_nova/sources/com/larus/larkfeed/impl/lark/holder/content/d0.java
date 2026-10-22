package com.larus.larkfeed.impl.lark.holder.content;

import com.ss.android.lark.chat.export.entity.message.Content;
import java.util.Collection;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class d0 implements qxa.a<Unit, Collection<? extends gya.a<? extends Content>>> {
    public d0() {
    }

    @Override // qxa.a
    public final Object a(Unit r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        return CollectionsKt.listOf(new c0());
    }
}
