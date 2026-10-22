package com.bytedance.android.shopping.commentv3.uitree.p000float;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.bytedance.android.shopping.commentv3.base.BaseCommentUI;
import com.bytedance.android.shopping.commentv3.base.b;
import com.bytedance.android.shopping.commentv3.base.c;
import com.bytedance.android.shopping.commentv3.uitree.list.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/uitree/float/FloatWindowUI;", "Lcom/bytedance/android/shopping/commentv3/base/BaseCommentUI;", "Lcom/bytedance/android/shopping/commentv3/uitree/float/c;", "Lcom/bytedance/android/shopping/commentv3/uitree/float/b;", "Lcom/bytedance/android/shopping/commentv3/uitree/float/g;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FloatWindowUI extends BaseCommentUI<c, b> implements g {
    public static final /* synthetic */ int o = 0;
    public ImageView i;
    public ImageView j;
    public final Lazy k;
    public final Lazy l;
    public int m;
    public final Lazy n;

    public static final class a<T> implements Observer {
        public final /* synthetic */ FloatWindowUI a;

        public a(FloatWindowUI r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            c r4 = (c) r3;
            FloatWindowUI r0 = this.a;
            if (r4 == null) goto L7;
            boolean r1 = true;
            if (r4.a != true) goto L7;
        L8:
            if (r1 == false) goto L12;
            ImageView r5 = r0.j;
            if (r5 == null) goto L16;
            r5.setImageResource(2131234323);
            return;
        L16:
            return;
        L12:
            ImageView r6 = r0.j;
            if (r6 == null) goto L18;
            r6.setImageResource(2131234325);
            return;
        L18:
            return;
        L7:
            r1 = false;
            goto L8
        }
    }

    public final b o() {
        return new c(false, false);
    }

    public FloatWindowUI() {
        this.k = LazyKt.lazy(new FloatWindowUI$commentRootApi$2(this));
        this.l = LazyKt.lazy(new FloatWindowUI$commentListApi$2(this));
        this.n = LazyKt.lazy(new FloatWindowUI$scrollOffsetThreshold$2(this));
    }

    @Override // com.bytedance.android.shopping.commentv3.base.BaseCommentUI, com.bytedance.android.shopping.commentv3.base.BaseUI, com.bytedance.android.shopping.commentv3.base.LifecycleUI
    public final void onCreate() {
        super.onCreate();
        View r0 = this.c;
        ViewGroup.LayoutParams r2 = null;
        if ((r0 instanceof ViewGroup) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L8;
        ImageView r3 = (ImageView) r1.findViewById(2131388937);
    L9:
        this.i = r3;
        View r4 = this.c;
        if ((r4 instanceof ViewGroup) == true) goto L12;
        r4 = null;
    L12:
        ViewGroup r5 = (ViewGroup) r4;
        if (r5 == null) goto L15;
        ImageView r6 = (ImageView) r5.findViewById(2131380243);
    L16:
        this.j = r6;
        c r7 = this.g;
        if (r7 == null) goto L19;
        int r8 = r7.a(64);
    L20:
        c r9 = this.g;
        if (r9 == null) goto L23;
        int r10 = r9.a(60);
    L24:
        c r11 = this.g;
        if (r11 == null) goto L27;
        int r12 = r11.a(10);
    L28:
        View r13 = this.c;
        if (r13 == null) goto L31;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
    L33:
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == true) goto L35;
        r14 = null;
    L35:
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;
        if (r15 == null) goto L40;
        r15.width = r8;
        r15.bottomMargin = r10;
        View r16 = this.c;
        if (r16 == null) goto L40;
        r16.setLayoutParams(r15);
    L40:
        ImageView r17 = this.i;
        if (r17 == null) goto L43;
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
    L45:
        if ((r18 instanceof ViewGroup.MarginLayoutParams) == true) goto L47;
        r18 = null;
    L47:
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
        if (r19 == null) goto L52;
        r19.width = r8;
        r19.height = r8;
        ImageView r20 = this.i;
        if (r20 == null) goto L52;
        r20.setLayoutParams(r19);
    L52:
        ImageView r21 = this.j;
        if (r21 == null) goto L55;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
    L57:
        if ((r22 instanceof ViewGroup.MarginLayoutParams) == false) goto L60;
        r2 = r22;
    L60:
        ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) r2;
        if (r23 == null) goto L65;
        r23.width = r8;
        r23.height = r8;
        r23.topMargin = r12;
        ImageView r24 = this.j;
        if (r24 == null) goto L65;
        r24.setLayoutParams(r23);
    L65:
        ImageView r25 = this.j;
        if (r25 == null) goto L68;
        r25.setOnClickListener(new d(this));
    L68:
        ImageView r26 = this.i;
        if (r26 == null) goto L71;
        r26.setOnClickListener(new e(this));
    L71:
        e r27 = (e) this.l.getValue();
        if (r27 == null) goto L74;
        r27.a(new f(this));
    L74:
        this.b.observe(this, new a(this));
        return;
    L55:
        r22 = null;
        goto L57
    L43:
        r18 = null;
        goto L45
    L31:
        r14 = null;
        goto L33
    L27:
        int r28 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r12 = com.bytedance.android.ec.hybrid.list.util.c.d(10);
        goto L28
    L23:
        int r29 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r10 = com.bytedance.android.ec.hybrid.list.util.c.d(60);
        goto L24
    L19:
        int r30 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r8 = com.bytedance.android.ec.hybrid.list.util.c.d(64);
        goto L20
    L15:
        r6 = null;
        goto L16
    L8:
        r3 = null;
        goto L9
    }

    @Override // com.bytedance.android.shopping.commentv3.uitree.p000float.g
    public final void e(int r4) {
        View r0 = this.c;
        if (r0 == null) goto L12;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 != null) goto L7;
        return;
    L7:
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
        ((ViewGroup.MarginLayoutParams) r1).bottomMargin += r4;
        View r5 = this.c;
        if (r5 == null) goto L15;
        r5.setLayoutParams(r1);
        return;
    L15:
        return;
    L14:
        return;
    }
}
