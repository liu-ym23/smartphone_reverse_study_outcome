package com.bytedance.ee.bear.middleground.comment.card;

import android.widget.ImageView;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.widget.CommentEditText;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n0<T, R> implements Function {
    public final /* synthetic */ HalfScreenCardComment a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;

    public n0(HalfScreenCardComment r1, String r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object apply(Object r23) {
        String r3 = (String) r23;
        Intrinsics.checkNotNullParameter(r3, "it");
        ImageView r1 = this.a.P;
        d r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("sendView");
        r1 = null;
    L5:
        r1.setEnabled(true);
        this.a.getClass();
        if (HalfScreenCardComment.n() == false) goto L15;
        List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r4 = this.a.N;
        if (r4 == null) goto L15;
        if ((!r4.isEmpty()) == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L15;
        ArrayList r7 = new ArrayList(r4);
    L16:
        CommentEditText r5 = this.a.M;
        if (r5 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        r5 = null;
    L19:
        r5.setText("");
        HalfScreenCardComment r6 = this.a;
        gf5.d r8 = r6.a.N;
        d r9 = r6.E;
        if (r9 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
    L23:
        r8.a(new ef5.h(r2.f(Integer.valueOf(this.a.n.getCurrentItem()))));
        if (this.a.a.o != 0) goto L26;
        boolean r10 = true;
    L28:
        return this.a.c.B(new com.bytedance.ee.bear.rn.e(null, r3, this.b, false, r10, r7, null, null, null, null, this.c, null, null, null, null, null, 0, null, 261065));
    L26:
        r10 = false;
        goto L28
    L22:
        r2 = r9;
    L15:
        r7 = null;
        goto L16
    }
}
