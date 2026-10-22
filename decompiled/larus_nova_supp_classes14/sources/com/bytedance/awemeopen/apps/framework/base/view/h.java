package com.bytedance.awemeopen.apps.framework.base.view;

import android.text.Layout;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.awemeopen.bizmodels.feed.video.TextExtraStruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ ProfileSignatureView a;
    public final /* synthetic */ int b;

    /* JADX WARN: Type inference failed for: r1v15, types: [android.widget.TextView, com.bytedance.awemeopen.apps.framework.base.view.ProfileSignatureView] */
    /* JADX WARN: Type inference failed for: r4v9, types: [android.widget.TextView, com.bytedance.awemeopen.apps.framework.base.view.ProfileSignatureView] */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.widget.TextView, com.bytedance.awemeopen.apps.framework.base.view.ProfileSignatureView] */
    /* JADX WARN: Type inference failed for: r6v8, types: [android.widget.TextView, com.bytedance.awemeopen.apps.framework.base.view.ProfileSignatureView] */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.widget.TextView, com.bytedance.awemeopen.apps.framework.base.view.ProfileSignatureView] */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.widget.TextView, com.bytedance.awemeopen.apps.framework.base.view.ProfileSignatureView] */
    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.a.getLayout() != null) goto L5;
        return;
    L5:
        ViewTreeObserver r0 = this.a.getViewTreeObserver();
        if (r0 == null) goto L8;
        r0.removeOnGlobalLayoutListener(this);
    L8:
        int r1 = this.a.getLineCount();
        ProfileSignatureView r2 = this.a;
        if (r2.e >= 0.0f) goto L11;
        r2.e = Layout.getDesiredWidth(ProfileSignatureView.x(r2), this.a.getPaint());
    L11:
        int r3 = this.b;
        if (r3 >= 0) goto L15;
        ProfileSignatureView r4 = this.a;
        r4.getClass();
        r4.B();
    L63:
        this.a.c = true;
        return;
    L15:
        if (r3 != 0) goto L27;
        if (r1 <= 0) goto L27;
        int r5 = this.a.getLayout().getLineEnd(0);
        CharSequence r6 = this.a.getText().subSequence(0, r5);
        if (StringsKt.endsWith$default(r6, "\n", false, 2, null) == false) goto L21;
        r5 = r5 - 1;
    L21:
        if (r5 > 4) goto L23;
        ProfileSignatureView r7 = this.a;
        r7.getClass();
        r7.B();
        goto L63
    L23:
        String r8 = r6.subSequence(0, 4).toString();
        this.a.setMovementMethod(i.b);
        ?? r9 = this.a;
        r9.setText(r9.A(r8, true));
        ProfileSignatureView r10 = this.a;
        List<TextExtraStruct> r11 = r10.i;
        if (r11 == null) goto L26;
        ProfileSignatureView.z(r10, r11);
    L26:
        ProfileSignatureView r12 = this.a;
        r12.getClass();
        r12.B();
    L27:
        if (r1 <= r3) goto L62;
        int r13 = this.a.getLayout().getLineEnd(this.b - 1);
        CharSequence r14 = this.a.getText().subSequence(0, r13);
        ?? r15 = this.a;
        if (r15.e < r15.getLayout().getWidth()) goto L34;
        ViewTreeObserver r16 = this.a.getViewTreeObserver();
        if (r16 == null) goto L33;
        r16.addOnGlobalLayoutListener(this);
    L33:
        ViewGroup.LayoutParams r17 = this.a.getLayoutParams();
        float r18 = this.a.getLayout().getWidth();
        ?? r19 = this.a;
        r17.width = (int) (r18 + r19.e);
        r19.invalidate();
    L46:
        int r20 = 0;
    L47:
        int r21 = r13 - r20;
        String r22 = r14.subSequence(0, Math.max(0, r21)).toString();
        this.a.setMovementMethod(i.b);
        ?? r23 = this.a;
        r23.setText(r23.A(r22, true));
        int r24 = Math.max(0, r21) + 1;
        ArrayList r25 = new ArrayList();
        List<TextExtraStruct> r26 = this.a.i;
        if (r26 == null) goto L61;
        Iterator<T> r27 = r26.iterator();
    L51:
        if (r27.hasNext() == false) goto L61;
        TextExtraStruct r28 = (TextExtraStruct) r27.next();
        if (r28.getStart() >= r24) goto L51;
        if (r28.getStart() >= r24) goto L60;
        if (r28.getEnd() < r24) goto L60;
        TextExtraStruct r29 = new TextExtraStruct();
        r29.setStart(r28.getStart());
        r29.setEnd(r24);
        r29.setHashTagName(r28.getHashTagName());
        r29.setType(r28.getType());
        r25.add(r29);
    L60:
        r25.add(r28);
    L61:
        ProfileSignatureView.z(this.a, r25);
        ProfileSignatureView r30 = this.a;
        r30.getClass();
        r30.B();
        goto L63
    L34:
        float r31 = this.a.getLayout().getLineRight(this.b - 1);
        ?? r32 = this.a;
        if ((r31 + r32.e) <= r32.getLayout().getWidth()) goto L44;
        float r33 = this.a.getLayout().getLineRight(this.b - 1);
        ?? r34 = this.a;
        float r35 = (r33 + r34.e) - r34.getLayout().getWidth();
        r20 = 1;
    L37:
        int r36 = r13 - r20;
        if (r36 < 0) goto L47;
        if (Layout.getDesiredWidth(this.a.getText().subSequence(r36, r13), this.a.getPaint()) >= r35) goto L47;
        r20 = r20 + 1;
        goto L37
    L44:
        if (StringsKt.endsWith$default(r14, "\n", false, 2, null) == false) goto L46;
        r20 = 1;
        goto L47
    L62:
        this.a.B();
        goto L63
    }

    public h(ProfileSignatureView r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
