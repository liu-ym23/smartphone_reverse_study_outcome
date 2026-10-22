package com.ss.android.lark.integrator.ccm.dependency.di;

import android.app.assist.AssistContent;
import com.ss.android.lark.intent.export.entity.donate.ScreenDonateEntity;
import com.ss.android.lark.utils.LarkContext;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class x implements com.bytedance.ee.bear.lark.dependency.p {
    public x() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.p
    public final void a(AssistContent r100, List<? extends ScreenDonateEntity> r101) {
        Intrinsics.checkNotNullParameter(r100, "assistContent");
        Intrinsics.checkNotNullParameter(r101, "list");
        ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).V0();
    }
}
