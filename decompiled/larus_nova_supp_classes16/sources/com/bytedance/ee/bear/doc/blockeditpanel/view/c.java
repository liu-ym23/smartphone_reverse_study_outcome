package com.bytedance.ee.bear.doc.blockeditpanel.view;

import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import ey4.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements Runnable {
    public final /* synthetic */ BlockEditPanelFragment a;
    public final /* synthetic */ BaseBlockEditPanel b;

    public c(BlockEditPanelFragment r1, BaseBlockEditPanel r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        BlockEditPanelFragment r0 = this.a;
        String r1 = this.b.getPanelId();
        int r2 = this.b.getMeasuredHeight();
        int r3 = BlockEditPanelFragment.n;
        FragmentActivity r4 = r0.getActivity();
        if (r4 == null) goto L9;
        Resources r5 = r4.getResources();
        if (r5 == null) goto L9;
        Configuration r6 = r5.getConfiguration();
        if (r6 == null) goto L9;
        int r7 = r6.orientation;
    L10:
        Iterator<g> r8 = r0.Z90().getPanelHeightInfoList().iterator();
    L12:
        if (r8.hasNext() == false) goto L20;
        g r9 = r8.next();
        if (Intrinsics.areEqual(r9.a, r1) == false) goto L12;
        if (r9.c != r7) goto L12;
        if (r9.d != r0.Z90().getEditStatus()) goto L12;
        tt5.a.h("BlockEditPanelFragment", "replace panel height info : " + r9);
        r9.b = r2;
    L21:
        BlockEditPanelFragment r10 = this.a;
        List<BaseBlockEditPanel> r11 = r10.V90();
        ArrayList r12 = (ArrayList) r11;
        int r13 = r12.size() - 1;
        if (r13 < 1) goto L34;
        int r14 = r10.W90(((BaseBlockEditPanel) ListProtector.get(r11, r13)).getPanelId());
        tt5.a.b("BlockEditPanelFragment", "topPanelHeight: " + r14);
        Iterator r16 = r12.iterator();
        int r17 = 0;
    L26:
        if (r16.hasNext() == false) goto L34;
        Object r18 = r16.next();
        int r19 = r17 + 1;
        if (r17 >= 0) goto L30;
        CollectionsKt.throwIndexOverflow();
    L30:
        BaseBlockEditPanel r20 = (BaseBlockEditPanel) r18;
        if (r17 == r13) goto L33;
        r20.postDelayed(new e(r20, r14, r13, r17, r10), 50);
    L33:
        r17 = r19;
    L34:
        this.a.ca0(false);
        return;
    L20:
        g r21 = new g(r1, r2, r7, r0.Z90().getEditStatus());
        tt5.a.h("BlockEditPanelFragment", "add panel height info : " + r21);
        r0.Z90().getPanelHeightInfoList().add(r21);
    L9:
        r7 = 1;
        goto L10
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
