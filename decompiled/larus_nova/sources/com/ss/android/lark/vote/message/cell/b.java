package com.ss.android.lark.vote.message.cell;

import com.ss.android.lark.vote.message.entity.VoteContentVO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements r5b.e<VoteContentVO, obc.a, VoteMessageCell> {
    public b() {
    }

    @Override // r5b.e
    public final v5b.b b() {
        return new obc.a();
    }

    @Override // r5b.e
    public final r5b.d a(r5b.a r100, p2b.b r101) {
        Intrinsics.checkNotNullParameter(r100, "chatContext");
        Intrinsics.checkNotNullParameter(r101, "openCellCallback");
        return new VoteMessageCell(r100);
    }
}
