package com.bytedance.ee.bear.office.list.selectpanel;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.bear.office.list.OfficeListPageMenuCapabilityRegistry;
import com.bytedance.ee.bear.office.list.i;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class OfficeSelectPanelHostDelegate$getRuleOrNull$2 extends FunctionReferenceImpl implements Function1<Document, Boolean> {
    public OfficeSelectPanelHostDelegate$getRuleOrNull$2(Object r8) {
        super(1, r8, OfficeSelectPanelHostDelegate.class, "canShowRecentRealDelete", "canShowRecentRealDelete(Lcom/bytedance/ee/bear/list/dto/Document;)Z", 0);
    }

    public final Boolean invoke(Document r5) {
        Intrinsics.checkNotNullParameter(r5, "p0");
        OfficeSelectPanelHostDelegate r0 = (OfficeSelectPanelHostDelegate) ((CallableReference) this).receiver;
        Object r1 = r0.b.invoke();
        OfficeSpaceTab r2 = OfficeSpaceTab.RECENT;
        if (r1 != r2) goto L15;
        OfficeListPageMenuCapabilityRegistry r3 = OfficeListPageMenuCapabilityRegistry.a;
        String r4 = (String) r0.c.invoke();
        Fragment r6 = r0.m;
        r3.getClass();
        i r7 = OfficeListPageMenuCapabilityRegistry.b(r4, r2, r6);
        if (r7 == null) goto L15;
        ce5.a r8 = r7.c;
        Intrinsics.checkNotNullParameter(r8, "userComponentAbility");
        Intrinsics.checkNotNullParameter(r5, "item");
        if (t0.u(r5, r8) == true) goto L15;
        if (r8.d.isCurrentEnable("ccm.workspace.recent_delete_enable") == false) goto L15;
        if (TextUtils.equals(r8.b.b, r5.e) == false) goto L15;
        boolean r9 = true;
    L17:
        return Boolean.valueOf(r9);
    L15:
        r9 = false;
        goto L17
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Document) r1);
    }
}
