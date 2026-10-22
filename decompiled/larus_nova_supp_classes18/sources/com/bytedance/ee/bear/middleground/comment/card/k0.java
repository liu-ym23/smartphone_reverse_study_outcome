package com.bytedance.ee.bear.middleground.comment.card;

import android.text.Editable;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.middleground.comment.audio.RecordViewModel;
import com.bytedance.ee.bear.middleground.comment.widget.CommentEditText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k0<T> implements Observer {
    public final /* synthetic */ HalfScreenCardComment a;

    public k0(HalfScreenCardComment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        ConnectionService.NetworkState r8 = (ConnectionService.NetworkState) r7;
        Intrinsics.checkNotNullParameter(r8, "it");
        boolean r0 = true;
        if (r8.a() != true) goto L5;
        boolean r9 = true;
    L6:
        ImageView r2 = this.a.Q;
        CommentEditText r3 = null;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("atButton");
        r2 = null;
    L9:
        r2.setEnabled(r9);
        AppCompatImageView r4 = this.a.J;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("voiceButton");
        r4 = null;
    L12:
        if (r9 == true) goto L14;
    L16:
        boolean r5 = false;
    L17:
        r4.setEnabled(r5);
        ImageView r6 = this.a.L;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("imageButton");
        r6 = null;
    L20:
        if (r9 == true) goto L22;
    L24:
        boolean r10 = false;
    L25:
        r6.setEnabled(r10);
        ImageView r11 = this.a.P;
        if (r11 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("sendView");
        r11 = null;
    L29:
        if (r9 == false) goto L39;
        AppCompatEditText r12 = this.a.M;
        if (r12 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        r12 = null;
    L33:
        Editable r13 = r12.getText();
        Intrinsics.checkNotNull(r13);
        if (r13.length() <= 0) goto L36;
        boolean r14 = true;
    L37:
        if (r14 == false) goto L39;
    L40:
        r11.setEnabled(r0);
        HalfScreenCardComment r1 = this.a;
        r1.G.h = r9;
        r1.t();
        if (r9 == true) goto L56;
        RecordViewModel r15 = this.a.G;
        if (r15.d == false) goto L57;
        r15.i();
        if (com.bytedance.ee.bear.middleground.comment.export.e.a() == true) goto L50;
        CommentEditText r16 = this.a.M;
        if (r16 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        r16 = null;
    L49:
        r16.L();
    L50:
        CommentEditText r17 = this.a.M;
        if (r17 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
    L54:
        r3.P();
        this.a.G.g();
        this.a.p(false);
        return;
    L53:
        r3 = r17;
        goto L54
    L57:
        return;
    L56:
        return;
    L36:
        r14 = false;
    L39:
        r0 = false;
        goto L40
    L22:
        if (this.a.a.E == false) goto L24;
        r10 = true;
        goto L25
    L14:
        if (this.a.H.f() == false) goto L16;
        r5 = true;
        goto L17
    L5:
        r9 = false;
        goto L6
    }
}
