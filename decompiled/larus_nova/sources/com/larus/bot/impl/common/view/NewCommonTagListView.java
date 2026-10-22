package com.larus.bot.impl.common.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.h;
import v19.i5;
import zp9.w;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/bot/impl/common/view/NewCommonTagListView;", "Lcom/larus/bot/impl/common/view/AbsCommonTagListView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "scrollAnimator", "Landroid/animation/ObjectAnimator;", "select", "", "index", "", "scrollable", "", "bindData", "list", "", "Lcom/larus/platform/api/creation/TabTag;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewCommonTagListView extends AbsCommonTagListView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObjectAnimator f317710f;

    public static final class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f317711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ NewCommonTagListView f317712b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f317713c;

        public a(View r100, NewCommonTagListView r101, boolean r102) {
            this.f317711a = r100;
            this.f317712b = r101;
            this.f317713c = r102;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            r100.removeOnLayoutChangeListener(this);
            if (this.f317711a.getWidth() > 0) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(this.f317711a.getParent(), this.f317712b.getContainer()) == false) goto L15;
            int r109 = ((this.f317711a.getLeft() + (this.f317711a.getWidth() / 2)) - (this.f317712b.getWidth() / 2)) + i5.g();
            if (this.f317713c == true) goto L9;
            this.f317712b.scrollTo(r109, 0);
            return;
        L9:
            ObjectAnimator r110 = this.f317712b.f317710f;
            if (r110 == null) goto L12;
            r110.cancel();
        L12:
            NewCommonTagListView r111 = this.f317712b;
            ObjectAnimator r112 = ObjectAnimator.ofInt(r111, "scrollX", new int[]{r111.getScrollX(), r109});
            r112.setDuration(200);
            r112.start();
            r111.f317710f = r112;
            return;
        }
    }

    public NewCommonTagListView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // zp9.u
    public final void d(List<w> r110) {
        Intrinsics.checkNotNullParameter(r110, "list");
        getContainer().removeAllViews();
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = r110.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if ((true ^ ((w) r102).a()) == false) goto L4;
        r100.add(r102);
        goto L4
    L8:
        Iterator r103 = r100.iterator();
        int r104 = 0;
        int r105 = 0;
    L10:
        if (r103.hasNext() == false) goto L39;
        Object r106 = r103.next();
        int r107 = r105 + 1;
        if (r105 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        w r108 = (w) r106;
        NewBotTagItemView r109 = new NewBotTagItemView(getContext(), null);
        String r111 = r108.f573273b;
        if (r111 != null) goto L17;
        r111 = "";
    L17:
        r109.setText(r111);
        boolean r112 = h.f552477a;
        if (h.a(null) == false) goto L20;
        String r113 = r108.f573275d;
    L22:
        if (h.a(null) == false) goto L24;
        String r114 = r108.f573277f;
    L25:
        if (r113 == null) goto L27;
        r109.setIcon(r113);
    L27:
        if (r114 == null) goto L29;
        r109.setTagColor(r114);
    L29:
        r109.setTag(Integer.valueOf(r105));
        r109.setOnClickListener(getClickListener());
        r109.setClickable(!r108.a());
        LinearLayout.LayoutParams r115 = new LinearLayout.LayoutParams(-2, -2);
        if (r105 != 0) goto L32;
        int r116 = i5.q();
    L33:
        r115.setMarginStart(r116);
        if (r105 != (r100.size() - 1)) goto L36;
        int r117 = i5.q();
    L37:
        r115.setMarginEnd(r117);
        getContainer().addView(r109, r115);
        r105 = r107;
        goto L10
    L36:
        r117 = i5.h();
        goto L37
    L32:
        r116 = i5.h();
        goto L33
    L24:
        r114 = r108.f573276e;
        goto L25
    L20:
        r113 = r108.f573274c;
        goto L22
    L39:
        if ((!r110.isEmpty()) == true) goto L42;
        r104 = 8;
    L42:
        setVisibility(r104);
        b(getCurrent(), true);
    }

    public NewCommonTagListView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-1, -2);
        r102.bottomMargin = i5.z();
        r102.topMargin = i5.c();
        getContainer().setOrientation(0);
        addView(getContainer(), r102);
        setHorizontalScrollBarEnabled(false);
    }

    @Override // zp9.u
    public final void b(int r100, boolean r101) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 >= getContainer().getChildCount()) goto L40;
        setInnerCurrent(r100);
        View r102 = ViewGroupKt.get(getContainer(), r100);
        LinearLayout r103 = getContainer();
        int r104 = r103.getChildCount();
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L16;
        View r106 = r103.getChildAt(r105);
        r106.setSelected(Intrinsics.areEqual(r106, r102));
        if ((r106 instanceof TextView) == false) goto L11;
        TextView r107 = (TextView) r106;
    L12:
        if (r107 == null) goto L14;
        r107.setTypeface(Typeface.DEFAULT, Intrinsics.areEqual(r106, r102) ? 1 : 0);
    L14:
        r105 = r105 + 1;
        goto L7
    L11:
        r107 = null;
        goto L12
    L16:
        if (isLaidOut() == true) goto L18;
    L30:
        addOnLayoutChangeListener(new a(r102, this, r101));
        return;
    L18:
        if (isLayoutRequested() == true) goto L30;
        if (r102.getWidth() > 0) goto L22;
        return;
    L22:
        if (Intrinsics.areEqual(r102.getParent(), getContainer()) == false) goto L37;
        int r108 = ((r102.getLeft() + (r102.getWidth() / 2)) - (getWidth() / 2)) + i5.g();
        if (r101 == true) goto L26;
        scrollTo(r108, 0);
        return;
    L26:
        ObjectAnimator r109 = this.f317710f;
        if (r109 == null) goto L29;
        r109.cancel();
    L29:
        ObjectAnimator r110 = ObjectAnimator.ofInt(this, "scrollX", new int[]{getScrollX(), r108});
        r110.setDuration(200);
        r110.start();
        this.f317710f = r110;
        return;
    L37:
        return;
    }
}
