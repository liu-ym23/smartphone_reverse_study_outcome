package com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.card;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Arrays;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ DmtTextView b;
    public final /* synthetic */ View c;
    public final /* synthetic */ DmtTextView d;
    public final /* synthetic */ DmtTextView e;
    public final /* synthetic */ DmtTextView f;
    public final /* synthetic */ ECMultiProCardVPAdapter g;
    public final /* synthetic */ View h;

    public final void a() {
        long r2 = this.a - (System.currentTimeMillis() / ((long) ECDraweeView.SQUARE));
        if (r2 <= 0) goto L39;
        long r0 = 86400;
        if (r2 <= r0) goto L18;
        int r1 = (int) (r2 / r0);
        AppCompatTextView r3 = this.b;
        if (r3 == null) goto L10;
        StringBuilder r4 = new StringBuilder();
        r4.append(r1);
        r4.append(22825);
        r3.setText(r4.toString());
    L10:
        AppCompatTextView r5 = this.b;
        if (r5 == null) goto L14;
        r5.setVisibility(0);
    L14:
        View r6 = this.c;
        if (r6 == null) goto L38;
        r6.setVisibility(8);
    L38:
        this.g.d.postDelayed(this, 1000);
        return;
    L18:
        long r7 = 3600;
        int r8 = (int) (r2 / r7);
        long r9 = 60;
        int r10 = (int) ((r2 % r7) / r9);
        int r11 = (int) (r2 % r9);
        AppCompatTextView r12 = this.d;
        if (r12 == null) goto L22;
        StringCompanionObject r13 = StringCompanionObject.INSTANCE;
        r12.setText(String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r8)}, 1)));
    L22:
        AppCompatTextView r14 = this.e;
        if (r14 == null) goto L26;
        StringCompanionObject r15 = StringCompanionObject.INSTANCE;
        r14.setText(String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r10)}, 1)));
    L26:
        AppCompatTextView r16 = this.f;
        if (r16 == null) goto L30;
        StringCompanionObject r17 = StringCompanionObject.INSTANCE;
        r16.setText(String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r11)}, 1)));
    L30:
        AppCompatTextView r18 = this.b;
        if (r18 == null) goto L34;
        r18.setVisibility(8);
    L34:
        View r19 = this.c;
        if (r19 == null) goto L38;
        r19.setVisibility(0);
        goto L38
    L39:
        AppCompatTextView r20 = this.b;
        if (r20 == null) goto L43;
        r20.setText("0天");
    L43:
        AppCompatTextView r21 = this.b;
        if (r21 == null) goto L47;
        r21.setVisibility(0);
    L47:
        View r22 = this.c;
        if (r22 == null) goto L51;
        r22.setVisibility(8);
    L51:
        this.g.e.remove(this.h);
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

    public c(long r1, DmtTextView r3, View r4, DmtTextView r5, DmtTextView r6, DmtTextView r7, ECMultiProCardVPAdapter r8, View r9) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
