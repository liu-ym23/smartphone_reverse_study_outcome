package com.bytedance.ee.bear.lark.biz.bitable;

import android.view.View;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bitable.homepage.BitableDefaultTabViewModel;
import com.bytedance.ee.bear.bitable.homepage.BitableTabType;
import com.bytedance.ee.bear.bitable.homepage.tabchoose.BitableDefaultTabData;
import com.bytedance.ee.bear.bitable.homepage.tabchoose.BitableTabChooseResponse;
import com.bytedance.ee.bear.bitable.homepage.tabchoose.BitableTabData;
import com.larksuite.framework.thread.ThreadUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ BitableTabFragmentV2 a;
    public final /* synthetic */ View b;

    public i(BitableTabFragmentV2 r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r8) {
        BitableTabChooseResponse r9 = (BitableTabChooseResponse) r8;
        boolean r1 = false;
        String r3 = null;
        if (r9.isSuccess() == false) goto L23;
        tt5.a.h("BitableTabFragmentV2", "observe bitableTabChooseResponse update and success");
        BitableTabData r10 = r9.data;
        BitableTabFragmentV2 r0 = this.a;
        if (r10 == null) goto L16;
        BitableDefaultTabData r6 = r10.getTab();
        if (r6 == null) goto L16;
        String r7 = r6.getDefault();
        if (r7 == null) goto L16;
        if (r7.length() <= 0) goto L13;
        boolean r11 = true;
    L14:
        if (r11 != true) goto L16;
        r1 = true;
        goto L16
    L13:
        r11 = false;
    L16:
        if (r1 == false) goto L21;
        BitableTabFragmentV2 r2 = this.a;
        int r4 = BitableTabFragmentV2.t;
        BitableDefaultTabViewModel r5 = (BitableDefaultTabViewModel) r2.s.getValue();
        BitableDefaultTabData r12 = r10.getTab();
        if (r12 == null) goto L20;
        r3 = r12.getDefault();
    L20:
        int r13 = r5.getCurrentTab(r3);
    L22:
        r0.h = r13;
        BitableTabFragmentV2 r14 = this.a;
        View r16 = this.b;
        r14.getClass();
        ThreadUtils.runOnUIThread(new g(r14, r16));
        return;
    L21:
        tt5.a.k("BitableTabFragmentV2", "tab data is empty, to recommend data");
        r13 = BitableTabType.RECOMMEND.getValue();
        goto L22
    L23:
        tt5.a.d("BitableTabFragmentV2", "observe bitableTabChooseResponse update and error");
        BitableTabData r17 = r9.data;
        BitableTabFragmentV2 r18 = this.a;
        if (r17 == null) goto L35;
        BitableDefaultTabData r19 = r17.getTab();
        if (r19 == null) goto L35;
        String r20 = r19.getDefault();
        if (r20 == null) goto L35;
        if (r20.length() <= 0) goto L32;
        boolean r21 = true;
    L33:
        if (r21 != true) goto L35;
        r1 = true;
        goto L35
    L32:
        r21 = false;
    L35:
        if (r1 == false) goto L40;
        BitableTabFragmentV2 r22 = this.a;
        int r23 = BitableTabFragmentV2.t;
        BitableDefaultTabViewModel r24 = (BitableDefaultTabViewModel) r22.s.getValue();
        BitableDefaultTabData r26 = r17.getTab();
        if (r26 == null) goto L39;
        r3 = r26.getDefault();
    L39:
        int r27 = r24.getCurrentTab(r3);
    L41:
        r18.h = r27;
        BitableTabFragmentV2 r28 = this.a;
        View r29 = this.b;
        r28.getClass();
        ThreadUtils.runOnUIThread(new g(r28, r29));
        return;
    L40:
        tt5.a.k("BitableTabFragmentV2", "tab data is empty, to recommend data");
        r27 = BitableTabType.RECOMMEND.getValue();
        goto L41
    }
}
