package com.bytedance.awemeopen.apps.framework.comment.write.emojichoose;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.GridLayoutManager;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.comment.util.CommentKeyboardUtils;
import com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.choose.EmojiChooseParams;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public final ViewGroup a;
    public View b;
    public EmojiGridPage c;

    public final void a() {
        int r0 = CommentKeyboardUtils.b(false, false);
        if (r0 <= 0) goto L15;
        View r1 = this.b;
        if (r1 == null) goto L7;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
    L8:
        if (r2 == null) goto L11;
        r2.height = r0;
    L11:
        View r3 = this.b;
        if (r3 == null) goto L16;
        r3.requestLayout();
        return;
    L16:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void b(boolean r2) {
        EmojiGridPage r0 = this.c;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    public a(vy3.a r5, ViewGroup r6, com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.c r7, EmojiChooseParams r8) {
        Intrinsics.checkNotNullParameter(r5, "inputApi");
        Intrinsics.checkNotNullParameter(r6, "parentContainer");
        Intrinsics.checkNotNullParameter(r7, "iInputViewBridge");
        Intrinsics.checkNotNullParameter(r8, "mEmojiChooseParams");
        this.a = r6;
        boolean r2 = false;
        View r0 = LayoutInflater.from(r6.getContext()).inflate(2131558628, r6, false);
        this.b = r0;
        d r1 = new d(r6.getContext());
        r1.b = r0;
        r1.c = r7;
        r1.d = r8;
        final EmojiGridPage r9 = new EmojiGridPage(r5, r1);
        this.c = r9;
        final GridLayoutManager r10 = new GridLayoutManager(r9.c, 7, 1, false);
        r10.setSpanSizeLookup(new EmojiGridPage$initView$1(r9, r10));
        r9.g.setLayoutManager(r10);
        SmallEmojiPanelAdapter r11 = (SmallEmojiPanelAdapter) r9.h.getValue();
        if (r11 == null) goto L42;
        r11.d = r9.e;
        r9.k = r9.f.findViewById(2131385912);
        r9.j = (DmtTextView) r9.f.findViewById(2131385904);
        r9.i = (DmtTextView) r9.f.findViewById(2131368785);
        if (r9.d.enableSmallEmojiSendBtn == false) goto L11;
        AppCompatTextView r12 = r9.j;
        if (r12 == null) goto L11;
        r12.setVisibility(0);
        AppCompatTextView r13 = r9.j;
        if (r13 == null) goto L11;
        r13.setOnClickListener(new c(r9));
    L11:
        AppCompatTextView r14 = r9.i;
        if (r14 == null) goto L16;
        r14.setVisibility(0);
        AppCompatTextView r15 = r9.i;
        if (r15 == null) goto L16;
        r15.setOnClickListener(new b(r9));
    L16:
        View r16 = r9.k;
        if (r16 == null) goto L21;
        r16.setVisibility(0);
    L21:
        if (n0.c(r9.f.getContext()) == false) goto L28;
        View r17 = r9.k;
        if (r17 == null) goto L25;
        r17.setBackgroundResource(2131231437);
    L25:
        DmtTextView r18 = r9.i;
        if (r18 == null) goto L34;
        r18.setBackgroundResource(2131231435);
    L34:
        e r19 = r9.e;
        if (r19 == null) goto L41;
        String r20 = r19.c();
        if (r20 == null) goto L41;
        if (r20.length() <= 0) goto L41;
        r2 = true;
    L41:
        r9.a(r2);
        goto L42
    L28:
        View r21 = r9.k;
        if (r21 == null) goto L31;
        r21.setBackgroundResource(2131231436);
    L31:
        DmtTextView r22 = r9.i;
        if (r22 == null) goto L34;
        r22.setBackgroundResource(2131231434);
    L42:
        r9.g.setAdapter((SmallEmojiPanelAdapter) r9.h.getValue());
        if (n0.c(r0.getContext()) == false) goto L45;
        r0.setBackgroundColor(r6.getContext().getResources().getColor(2131100264));
    L46:
        a();
        return;
    L45:
        r0.setBackgroundColor(r6.getContext().getResources().getColor(2131100263));
        goto L46
    }
}
