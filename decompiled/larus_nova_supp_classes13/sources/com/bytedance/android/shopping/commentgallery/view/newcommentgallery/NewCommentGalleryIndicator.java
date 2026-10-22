package com.bytedance.android.shopping.commentgallery.view.newcommentgallery;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO;
import com.bytedance.android.shopping.commentgallery.view.CommentGalleryExpandableTextView;
import com.bytedance.android.shopping.extensions.f;
import com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPagerAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0006\u001a\u00020\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003J\u0018\u0010\b\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016J/\u0010\u0013\u001a\u00020\u00042%\u0010\u0012\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0006\u0010\u0017\u001a\u00020\u0016¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/shopping/commentgallery/view/newcommentgallery/NewCommentGalleryIndicator;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "Lkotlin/Function0;", "", "listener", "setExpandBtnClickListener", "loadMoreListener", "setLoadMoreListener", "backListener", "setBackListener", "switchModeListener", "setSwitchModeListener", "Lkotlin/Function1;", "Lcom/bytedance/android/shopping/anchorv3/comment/model/CommentNodeVO;", "Lkotlin/ParameterName;", "name", "curComment", "diggCommentListener", "setDiggCommentListener", "Lcc3/c;", "getCurCommentGalleryModel", "", "getPosition", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewCommentGalleryIndicator extends ConstraintLayout implements IIndicatorView {
    public final View a;
    public final TextView b;
    public final LinearLayout c;
    public final CommentGalleryExpandableTextView d;
    public final TextView e;
    public final TextView f;
    public final ImageView g;
    public final TextView h;
    public final List<cc3.c> i;
    public Function0<Unit> j;
    public Function0<Unit> k;
    public Function0<Unit> l;
    public Function1<? super CommentNodeVO, Unit> m;
    public CommentNodeVO n;
    public cc3.c o;
    public int p;
    public float q;
    public float r;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ NewCommentGalleryIndicator a;

        public a(NewCommentGalleryIndicator r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.k;
            if (r2 == null) goto L6;
            Unit r3 = (Unit) r2.invoke();
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ NewCommentGalleryIndicator a;

        public b(NewCommentGalleryIndicator r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.l;
            if (r2 == null) goto L6;
            Unit r3 = (Unit) r2.invoke();
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ NewCommentGalleryIndicator a;

        public c(NewCommentGalleryIndicator r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            NewCommentGalleryIndicator r3 = this.a;
            Function1<? super CommentNodeVO, Unit> r0 = r3.m;
            if (r0 == null) goto L6;
            Unit r4 = (Unit) r0.invoke(r3.n);
            return;
        }
    }

    public NewCommentGalleryIndicator(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public NewCommentGalleryIndicator(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void onDataChanged(TransitionPagerAdapter<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "adapter");
    }

    public final void onTransitionBegin(int r1) {
    }

    public final int getPosition() {
        return this.p + 1;
    }

    public cc3.c getCurCommentGalleryModel() {
        return this.o;
    }

    public final void onPageSelected(int r12) {
        this.p = r12;
        CommentNodeVO r0 = this.n;
        if (r0 == null) goto L5;
        long r3 = r0.getId();
    L6:
        this.o = (cc3.c) ListProtector.get(this.i, r12);
        this.n = ((cc3.c) ListProtector.get(this.i, r12)).c;
        TextView r1 = this.e;
        StringBuilder r5 = new StringBuilder("@");
        CommentNodeVO r6 = this.n;
        Long r7 = null;
        if (r6 == null) goto L9;
        String r8 = r6.getUserName();
    L10:
        r5.append(r8);
        String r9 = r5.toString();
        String r10 = "";
        if (r9 != null) goto L14;
        r9 = "";
    L14:
        r1.setText(r9);
        TextView r2 = this.f;
        CommentNodeVO r11 = this.n;
        if (r11 == null) goto L19;
        String r13 = r11.getSku();
        if (r13 == null) goto L19;
    L20:
        r2.setText(r13);
        CommentGalleryExpandableTextView r4 = this.d;
        CommentNodeVO r14 = this.n;
        if (r14 == null) goto L26;
        String r15 = r14.getContent();
        if (r15 == null) goto L26;
        r10 = r15;
    L26:
        CommentNodeVO r16 = this.n;
        if (r16 == null) goto L29;
        long r17 = r16.getId();
    L31:
        if (r3 == r17) goto L33;
        boolean r18 = true;
    L34:
        r4.getClass();
        Intrinsics.checkNotNullParameter(r10, "text");
        if (r18 == false) goto L37;
        r4.a.setText(r10);
        r4.j = r10;
        r4.c();
    L37:
        ImageView r19 = this.g;
        CommentNodeVO r20 = this.n;
        if (r20 != null) goto L40;
    L42:
        int r21 = 2131233469;
    L43:
        r19.setImageResource(r21);
        TextView r22 = this.h;
        CommentNodeVO r23 = this.n;
        if (r23 == null) goto L46;
        long r24 = r23.getLikes();
    L48:
        if (r24 != 0) goto L50;
        String r25 = "有用";
    L54:
        r22.setText(r25);
        TextView r26 = this.b;
        StringBuilder r27 = new StringBuilder();
        r27.append(r12 + 1);
        r27.append('/');
        r27.append(((ArrayList) this.i).size());
        r26.setText(r27.toString());
        if (r12 != (((ArrayList) this.i).size() - 2)) goto L60;
        Function0<Unit> r110 = this.j;
        if (r110 == null) goto L61;
        Unit r111 = (Unit) r110.invoke();
        return;
    L61:
        return;
    L60:
        return;
    L50:
        CommentNodeVO r28 = this.n;
        if (r28 == null) goto L53;
        r7 = Long.valueOf(r28.getLikes());
    L53:
        r25 = String.valueOf(r7);
        goto L54
    L46:
        r24 = 0;
        goto L48
    L40:
        if (r20.getLiked() != true) goto L42;
        r21 = 2131233463;
        goto L43
    L33:
        r18 = false;
        goto L34
    L29:
        r17 = 0;
    L19:
        r13 = "";
        goto L20
    L9:
        r8 = null;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final void onTransitionEnd(int r2) {
        if (r2 != 3) goto L6;
        this.q = this.r;
        return;
    }

    public void setBackListener(Function0<Unit> r1) {
        this.k = r1;
    }

    public void setDiggCommentListener(Function1<? super CommentNodeVO, Unit> r1) {
        this.m = r1;
    }

    public final void setExpandBtnClickListener(Function0<Unit> r2) {
        this.d.setExpandBtnClickListener(r2);
    }

    public void setLoadMoreListener(Function0<Unit> r1) {
        this.j = r1;
    }

    public void setSwitchModeListener(Function0<Unit> r1) {
        this.l = r1;
    }

    public final void onAttach(int r2, TransitionPagerAdapter<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "adapter");
        Intrinsics.checkNotNullParameter(r3, "adapter");
        IIndicatorView.DefaultImpls.onAttach(this, r2, r3);
    }

    public final void onDetach(int r2, TransitionPagerAdapter<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "adapter");
        Intrinsics.checkNotNullParameter(r3, "adapter");
        IIndicatorView.DefaultImpls.onDetach(this, r2, r3);
    }

    public final void onTransitionChanged(int r5, float r6) {
        if (r5 != 0) goto L5;
    L14:
        this.r = r6;
        if (r6 <= 1.0f) goto L18;
        this.r = 1.0f;
    L18:
        if (this.r >= 0.0f) goto L20;
        this.r = 0.0f;
    L20:
        this.a.getBackground().setAlpha((int) (this.r * 255));
        return;
    L5:
        if (r5 != 1) goto L7;
        float r7 = this.q;
        r6 = r7 + ((1 - r7) * r6);
        goto L14
    L7:
        if (r5 != 2) goto L9;
        r6 = this.q * (1 - r6);
        goto L14
    L9:
        if (r5 == 3) goto L11;
        r6 = 1.0f;
        goto L14
    L11:
        r6 = 1 - RangesKt.coerceAtLeast(r6, 0.0f);
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NewCommentGalleryIndicator(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.i = new ArrayList();
        this.q = 1.0f;
        this.r = 1.0f;
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r4).aU(2131560408, this, true);
        this.a = findViewById(2131370528);
        TextView r7 = (TextView) findViewById(2131370527);
        this.b = r7;
        ImageView r8 = (ImageView) findViewById(2131370526);
        LinearLayout r9 = (LinearLayout) findViewById(2131370535);
        this.c = r9;
        this.d = (CommentGalleryExpandableTextView) findViewById(2131370513);
        TextView r0 = (TextView) findViewById(2131370548);
        this.e = r0;
        this.f = (TextView) findViewById(2131370547);
        ImageView r1 = (ImageView) findViewById(2131370532);
        this.g = r1;
        this.h = (TextView) findViewById(2131370543);
        f.e(r7, 500);
        f.e(r0, 500);
        r8.setOnClickListener(new a(this));
        r9.setOnClickListener(new b(this));
        r1.setOnClickListener(new c(this));
    }

    public /* synthetic */ NewCommentGalleryIndicator(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
