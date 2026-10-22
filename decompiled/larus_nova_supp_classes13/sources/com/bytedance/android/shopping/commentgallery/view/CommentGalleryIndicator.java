package com.bytedance.android.shopping.commentgallery.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0006\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016J/\u0010\u0011\u001a\u00020\u00042%\u0010\u0010\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0006\u0010\u0015\u001a\u00020\u0014¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/commentgallery/view/CommentGalleryIndicator;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "Lkotlin/Function0;", "", "loadMoreListener", "setLoadMoreListener", "backListener", "setBackListener", "switchModeListener", "setSwitchModeListener", "Lkotlin/Function1;", "Lcom/bytedance/android/shopping/anchorv3/comment/model/CommentNodeVO;", "Lkotlin/ParameterName;", "name", "curComment", "diggCommentListener", "setDiggCommentListener", "Lcc3/c;", "getCurCommentGalleryModel", "", "getPosition", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentGalleryIndicator extends ConstraintLayout implements IIndicatorView {
    public final TextView a;
    public final CommentGalleryExpandableTextView b;
    public final TextView c;
    public final TextView d;
    public final ImageView e;
    public final TextView f;
    public final List<cc3.c> g;
    public Function0<Unit> h;
    public Function0<Unit> i;
    public Function0<Unit> j;
    public Function1<? super CommentNodeVO, Unit> k;
    public CommentNodeVO l;
    public cc3.c m;
    public int n;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ CommentGalleryIndicator a;

        public a(CommentGalleryIndicator r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.i;
            if (r2 == null) goto L6;
            Unit r3 = (Unit) r2.invoke();
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ CommentGalleryIndicator a;

        public b(CommentGalleryIndicator r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.j;
            if (r2 == null) goto L6;
            Unit r3 = (Unit) r2.invoke();
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ CommentGalleryIndicator a;

        public c(CommentGalleryIndicator r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            CommentGalleryIndicator r3 = this.a;
            Function1<? super CommentNodeVO, Unit> r0 = r3.k;
            if (r0 == null) goto L6;
            Unit r4 = (Unit) r0.invoke(r3.l);
            return;
        }
    }

    public CommentGalleryIndicator(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CommentGalleryIndicator(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void onDataChanged(TransitionPagerAdapter<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "adapter");
    }

    public final void onTransitionBegin(int r1) {
    }

    public final void onTransitionChanged(int r1, float r2) {
    }

    public final void onTransitionEnd(int r1) {
    }

    public final int getPosition() {
        return this.n + 1;
    }

    public cc3.c getCurCommentGalleryModel() {
        return this.m;
    }

    public final void onPageSelected(int r12) {
        this.n = r12;
        CommentNodeVO r0 = this.l;
        if (r0 == null) goto L5;
        long r3 = r0.getId();
    L6:
        this.m = (cc3.c) ListProtector.get(this.g, r12);
        this.l = ((cc3.c) ListProtector.get(this.g, r12)).c;
        TextView r1 = this.c;
        StringBuilder r5 = new StringBuilder("@");
        CommentNodeVO r6 = this.l;
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
        TextView r2 = this.d;
        CommentNodeVO r11 = this.l;
        if (r11 == null) goto L19;
        String r13 = r11.getSku();
        if (r13 == null) goto L19;
    L20:
        r2.setText(r13);
        CommentGalleryExpandableTextView r4 = this.b;
        CommentNodeVO r14 = this.l;
        if (r14 == null) goto L26;
        String r15 = r14.getContent();
        if (r15 == null) goto L26;
        r10 = r15;
    L26:
        CommentNodeVO r16 = this.l;
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
        ImageView r19 = this.e;
        CommentNodeVO r20 = this.l;
        if (r20 != null) goto L40;
    L42:
        int r21 = 2131233468;
    L43:
        r19.setImageResource(r21);
        TextView r22 = this.f;
        CommentNodeVO r23 = this.l;
        if (r23 == null) goto L46;
        long r24 = r23.getLikes();
    L48:
        if (r24 != 0) goto L50;
        String r25 = "有用";
    L54:
        r22.setText(r25);
        TextView r26 = this.a;
        StringBuilder r27 = new StringBuilder();
        r27.append(r12 + 1);
        r27.append('/');
        r27.append(((ArrayList) this.g).size());
        r26.setText(r27.toString());
        if (r12 != (((ArrayList) this.g).size() - 2)) goto L60;
        Function0<Unit> r110 = this.h;
        if (r110 == null) goto L61;
        Unit r111 = (Unit) r110.invoke();
        return;
    L61:
        return;
    L60:
        return;
    L50:
        CommentNodeVO r28 = this.l;
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
        r21 = 2131233462;
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

    public void setBackListener(Function0<Unit> r1) {
        this.i = r1;
    }

    public void setDiggCommentListener(Function1<? super CommentNodeVO, Unit> r1) {
        this.k = r1;
    }

    public void setLoadMoreListener(Function0<Unit> r1) {
        this.h = r1;
    }

    public void setSwitchModeListener(Function0<Unit> r1) {
        this.j = r1;
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

    /* JADX WARN: Multi-variable type inference failed */
    public CommentGalleryIndicator(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.g = new ArrayList();
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560407, this, true);
        this.a = (TextView) findViewById(2131370527);
        ImageView r5 = (ImageView) findViewById(2131370526);
        ImageView r6 = (ImageView) findViewById(2131370534);
        this.b = (CommentGalleryExpandableTextView) findViewById(2131370513);
        this.c = (TextView) findViewById(2131370548);
        this.d = (TextView) findViewById(2131370547);
        ImageView r7 = (ImageView) findViewById(2131370532);
        this.e = r7;
        this.f = (TextView) findViewById(2131370543);
        r5.setOnClickListener(new a(this));
        r6.setOnClickListener(new b(this));
        r7.setOnClickListener(new c(this));
    }

    public /* synthetic */ CommentGalleryIndicator(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
