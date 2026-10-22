package com.bytedance.ee.bear.list.folderselect.command;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.list.dto.SpaceMakeCopyToSpaceResult;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import com.larksuite.component.universe_design.toast.UDToast;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q implements UDToast.b {
    public final /* synthetic */ com.bytedance.ee.bear.route.h a;
    public final /* synthetic */ SpaceMakeCopyToSpaceResult b;
    public final /* synthetic */ n c;
    public final /* synthetic */ int d;

    public final void a(com.ss.android.lark.compose.foundation.toast.b r4) {
        Intrinsics.checkNotNullParameter(r4, Notice.CLICK_TYPE_TOAST);
        this.a.u5(((SpaceMakeCopyToSpaceResult.Data) ((Result) this.b).data).getUrl());
        n r5 = this.c;
        int r0 = this.d;
        String r1 = ((SpaceMakeCopyToSpaceResult.Data) ((Result) this.b).data).getObjToken();
        r5.getClass();
        HashMap r6 = new HashMap();
        r6.put("file_type", sbb.e.c(r0));
        r6.put("file_id", du5.b.g(r1));
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n("click_copy_doc", r6);
    }

    public q(com.bytedance.ee.bear.route.h r1, SpaceMakeCopyToSpaceResult r2, n r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
