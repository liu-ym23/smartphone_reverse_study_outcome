package com.bytedance.ee.bear.list.homepage.title;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewGroupKt;
import bd5.o;
import bd5.p;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.diskmanage.Biz;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.UIHelper;
import h18.e;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import wc5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0002BCB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0016\u0010%\u001a\u00020$2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!J\u0010\u0010'\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010)J\b\u0010*\u001a\u00020$H\u0002J\b\u0010+\u001a\u00020$H\u0002J\b\u0010,\u001a\u00020$H\u0002J\u0010\u0010-\u001a\u00020$2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010.\u001a\u00020$2\b\u0010/\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010\u0014\u001a\u00020$2\u0006\u00100\u001a\u00020\u000fH\u0016J\b\u00101\u001a\u00020$H\u0016J\b\u00102\u001a\u00020$H\u0016J\u0006\u00103\u001a\u00020$J\u0006\u00104\u001a\u00020$J\u0006\u00105\u001a\u00020$J\u0018\u00106\u001a\u00020$2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u000fH\u0003J\u0010\u0010:\u001a\u00020$2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010;\u001a\u00020$2\u0006\u00109\u001a\u00020\u000fJ\u0012\u0010<\u001a\u00020$2\b\u0010/\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010=\u001a\u00020$2\b\u0010>\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010?\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u000e\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020\u001fR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001aR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/bytedance/ee/bear/list/homepage/title/SubMenuViewPad;", "Landroid/widget/RelativeLayout;", "Lcom/bytedance/ee/bear/list/homepage/IHomeSubMenuView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "delegate", "Lcom/bytedance/ee/bear/list/homepage/IHomeSubMenuView$ViewDelegate;", "dp2", OperationName.OPERATION_OFFLINE_AVAILABLE, "", "filterState", "Lcom/bytedance/ee/bear/list/homepage/title/SubMenuView$FilterState;", "textViewGroup", "Landroid/widget/LinearLayout;", "showGrid", "ivGrid", "Landroidx/appcompat/widget/AppCompatImageView;", "ivFilter", "ivFilterIcon", "getIvFilterIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "ivSort", "ivSortIcon", "getIvSortIcon", "onItemClickListener", "Lcom/bytedance/ee/bear/list/homepage/title/SubMenuViewPad$OnItemClickListener;", "textList", "", "Lcom/bytedance/ee/bear/list/homepage/title/DocPageEnum;", "initViews", "", "setDataList", "list", "setCustomLeftTextArea", "title", "", "addGridView", "addFilterView", "addSortView", "setOffline", "showFilterDesc", "desc", "grid", "hideGrid", "hideFilter", "hideSort", "showAllButton", "showSort", "setIconState", "imageView", "Landroid/widget/ImageView;", "selected", "setFilterState", "setSelectedSortState", "showSortDesc", "setViewDelegate", "viewDelegate", "setTitle", "setOnItemClickListener", "listener", "Companion", "OnItemClickListener", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubMenuViewPad extends RelativeLayout implements f {
    public f.a a;
    public boolean b;
    public SubMenuView.FilterState c;
    public LinearLayout d;
    public boolean e;
    public AppCompatImageView f;
    public AppCompatImageView g;
    public AppCompatImageView h;
    public b i;
    public List<? extends DocPageEnum> j;

    public static final class a {
    }

    public interface b {
        void a(int r1, int r2, String r3);
    }

    public static final class c implements Runnable {
        public final /* synthetic */ SubMenuViewPad a;

        public c(SubMenuViewPad r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ImageView r0 = this.a.h;     // Catch: Throwable -> L7
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("ivSort");     // Catch: Throwable -> L7
            r0 = null;
        L5:
            r0.requestLayout();     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ SubMenuViewPad a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;

        public d(SubMenuViewPad r1, TextView r2, int r3, int r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            LinearLayout r6 = this.a.d;
            if (r6 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("textViewGroup");
            r6 = null;
        L5:
            Sequence r7 = ViewGroupKt.getChildren(r6);
            TextView r0 = this.b;
            Iterator r8 = r7.iterator();
        L7:
            if (r8.hasNext() == false) goto L9;
            View r1 = (View) r8.next();
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) r1).setTextColor(r0.getContext().getResources().getColor(2131106607));
            goto L7
        L9:
            TextView r9 = this.b;
            r9.setTextColor(r9.getContext().getResources().getColor(2131105548));
            tt5.a.h("SubMenuViewPad", "onClick: index = " + this.c + " id = " + this.d);
            b r10 = this.a.i;
            if (r10 == null) goto L14;
            r10.a(this.c, this.d, this.e);
            return;
        }
    }

    static {
    }

    public SubMenuViewPad(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SubMenuViewPad(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // wc5.f
    public final void a(String r1) {
    }

    @Override // wc5.f
    public void setTitle(String r1) {
    }

    public final void c() {
        ImageView r0 = this.g;
        ImageView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ivFilter");
        r0 = null;
    L5:
        r0.setVisibility(8);
        ImageView r2 = this.h;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("ivSort");
    L9:
        if (r1 == null) goto L12;
        r1.post(new c(this));
        return;
    L12:
        return;
    L8:
        r1 = r2;
        goto L9
    }

    public final void e() {
        ImageView r0 = this.h;
        ImageView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ivSort");
        r0 = null;
    L5:
        r0.setVisibility(0);
        ImageView r2 = this.g;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("ivFilter");
        r2 = null;
    L8:
        r2.setVisibility(0);
        ImageView r3 = this.f;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("ivGrid");
    L12:
        r1.setVisibility(0);
        return;
    L11:
        r1 = r3;
        goto L12
    }

    public final AppCompatImageView getIvFilterIcon() {
        AppCompatImageView r0 = this.g;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ivFilter");
        return null;
    L6:
        return r0;
    }

    public final AppCompatImageView getIvSortIcon() {
        AppCompatImageView r0 = this.h;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ivSort");
        return null;
    L6:
        return r0;
    }

    @Override // wc5.f
    public final void b(boolean r5) {
        this.e = r5;
        ImageView r0 = this.f;
        AppCompatImageView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ivGrid");
        r0 = null;
    L5:
        l.c(r0, 2131102419);
        AppCompatImageView r2 = this.f;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("ivGrid");
    L9:
        Resources r3 = getResources();
        if (r5 == false) goto L12;
        int r6 = 2131254229;
    L13:
        r1.setImageDrawable(r3.getDrawable(r6));
        return;
    L12:
        r6 = 2131253870;
        goto L13
    L8:
        r1 = r2;
        goto L9
    }

    public final void setCustomLeftTextArea(String r7) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
        Unit r1 = null;
        if (r7 == null) goto L13;
        LinearLayout r2 = this.d;     // Catch: Throwable -> L15
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("textViewGroup");     // Catch: Throwable -> L15
        r2 = null;
    L8:
        r2.removeAllViews();     // Catch: Throwable -> L15
        TextView r3 = new TextView(getContext());     // Catch: Throwable -> L15
        r3.setText(r7);     // Catch: Throwable -> L15
        int r8 = e.a;     // Catch: Throwable -> L15
        r3.setTypeface(e.b(r3.getContext(), 1));     // Catch: Throwable -> L15
        r3.setTextSize(2, 16.0f);     // Catch: Throwable -> L15
        r3.setTextColor(r3.getContext().getResources().getColor(2131106607));     // Catch: Throwable -> L15
        r3.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));     // Catch: Throwable -> L15
        r3.setPadding(UIHelper.dp2px(16.0f), UIHelper.dp2px(11.0f), UIHelper.dp2px(0.0f), UIHelper.dp2px(11.0f));     // Catch: Throwable -> L15
        Unit r9 = this.d;     // Catch: Throwable -> L15
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("textViewGroup");     // Catch: Throwable -> L15
    L12:
        r1.addView(r3);     // Catch: Throwable -> L15
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L15
        goto L13
    L11:
        r1 = r9;
    L13:
        Object r10 = Result.constructor-impl(r1);     // Catch: Throwable -> L15
    L17:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L23;
        tt5.a.f("setCustomLeftTextArea failed", r11, false);
        return;
    L23:
        return;
    L15:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }

    public final void setDataList(List<? extends DocPageEnum> r14) {
        if (r14 != null) goto L5;
        setVisibility(8);
        tt5.a.h("SubMenuViewPad", "hide view because list is null");
        return;
    L5:
        this.j = r14;
        LinearLayout r0 = this.d;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("textViewGroup");
        r0 = null;
    L8:
        r0.removeAllViews();
        Iterator<T> r1 = r14.iterator();
        int r7 = 0;
    L10:
        if (r1.hasNext() == false) goto L25;
        Object r3 = r1.next();
        int r10 = r7 + 1;
        if (r7 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        DocPageEnum r4 = (DocPageEnum) r3;
        TextView r11 = new TextView(getContext());
        String r9 = r11.getContext().getString(r4.getTextResId());
        int r8 = r4.getId();
        r11.setText(r9);
        int r5 = e.a;
        r11.setTypeface(e.b(r11.getContext(), 1));
        r11.setTextSize(2, 16.0f);
        r11.setTextColor(r11.getContext().getResources().getColor(2131106607));
        r11.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        if (r14.size() <= 1) goto L18;
        if (r7 != 0) goto L18;
        r11.setTextColor(r11.getContext().getResources().getColor(2131105548));
    L18:
        r11.setPadding(UIHelper.dp2px(16.0f), UIHelper.dp2px(11.0f), UIHelper.dp2px(0.0f), UIHelper.dp2px(11.0f));
        if (r14.size() <= 1) goto L21;
        r11.setOnClickListener(new d(this, r11, r7, r8, r9));
    L21:
        LinearLayout r6 = this.d;
        if (r6 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("textViewGroup");
        r6 = null;
    L24:
        r6.addView(r11);
        r7 = r10;
        goto L10
    }

    @Override // wc5.f
    public void setFilterState(SubMenuView.FilterState r3) {
        Intrinsics.checkNotNullParameter(r3, "filterState");
        this.c = r3;
        AppCompatImageView r0 = this.g;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ivFilter");
        r0 = null;
    L6:
        if (r3 != SubMenuView.FilterState.CHECKED) goto L8;
        boolean r4 = true;
    L9:
        d(r0, r4);
        return;
    L8:
        r4 = false;
        goto L9
    }

    @Override // wc5.f
    public void setOffline(boolean r1) {
        this.b = r1;
        setFilterState(this.c);
    }

    public final void setOnItemClickListener(b r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        tt5.a.h("SubMenuViewPad", "setOnItemClickListener() called with: listener = " + r3);
        this.i = r3;
    }

    public final void setSelectedSortState(boolean r2) {
        AppCompatImageView r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ivSort");
        r0 = null;
    L5:
        d(r0, r2);
    }

    @Override // wc5.f
    public void setViewDelegate(f.a r3) {
        tt5.a.h("SubMenuViewPad", "setViewDelegate() called with: viewDelegate = " + r3 + " this:" + hashCode());
        this.a = r3;
    }

    public final void d(AppCompatImageView r3, boolean r4) {
        int r0 = 2131102416;
        if (r4 == true) goto L5;
        r3.setBackgroundDrawable(null);
        if (this.b == true) goto L17;
        r0 = 2131102419;
    L17:
        l.c(r3, r0);
        return;
    L5:
        if (this.b == true) goto L8;
        r0 = 2131106273;
    L8:
        r3.setBackgroundDrawable(getResources().getDrawable(2131243705));
        if (this.b == false) goto L11;
        int r5 = 2131106270;
    L12:
        l.b(r3, r5);
        goto L17
    L11:
        r5 = 2131106271;
        goto L12
    }

    public SubMenuViewPad(Context r11, AttributeSet r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13);
        tt5.a.h("SubMenuViewPad", "initViews: this:" + hashCode());
        setBackgroundColor(UIUtils.getColor(r11, 2131100548));
        LinearLayout r14 = new LinearLayout(r11);
        r14.setOrientation(0);
        RelativeLayout.LayoutParams r0 = new RelativeLayout.LayoutParams(-2, -2);
        r0.addRule(5);
        r0.addRule(15);
        r14.setLayoutParams(r0);
        this.d = r14;
        HorizontalScrollView r15 = new HorizontalScrollView(r11);
        RelativeLayout.LayoutParams r16 = new RelativeLayout.LayoutParams(-1, -2);
        r16.addRule(9);
        r16.addRule(16, 2131376623);
        r16.addRule(15);
        r16.setMarginEnd(UIHelper.dp2px(6.0f));
        r15.setPadding(UIHelper.dp2px(8.0f), 0, 0, 0);
        r15.setLayoutParams(r16);
        r15.setScrollbarFadingEnabled(false);
        r15.setHorizontalScrollBarEnabled(false);
        r15.setHorizontalFadingEdgeEnabled(true);
        r15.setFadingEdgeLength(UIHelper.dp2px(10.0f));
        LinearLayout r3 = this.d;
        ImageView r4 = null;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textViewGroup");
        r3 = null;
    L5:
        r15.addView(r3);
        AppCompatImageView r5 = new AppCompatImageView(getContext());
        r5.setId(2131376276);
        r5.setImageResource(2131253870);
        RelativeLayout.LayoutParams r6 = new RelativeLayout.LayoutParams(n.d(24), n.d(24));
        int r8 = n.d(4);
        r5.setPadding(r8, r8, r8, r8);
        r6.addRule(11);
        r6.addRule(15);
        r6.rightMargin = r5.getContext().getResources().getDimensionPixelSize(2131168310);
        r5.setLayoutParams(r6);
        this.f = r5;
        addView(r5);
        ImageView r7 = this.f;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("ivGrid");
        r7 = null;
    L8:
        l.c(r7, 2131102419);
        boolean r17 = LarkKVStorage.h(new com.ss.android.lark.storage.a(Biz.DOCS.getValue()), true).getBoolean("is_grid", false);
        this.e = r17;
        b(r17);
        ImageView r18 = this.f;
        if (r18 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("ivGrid");
        r18 = null;
    L11:
        r18.setOnClickListener(new o(this));
        AppCompatImageView r19 = new AppCompatImageView(getContext());
        r19.setId(2131376241);
        r19.setImageResource(2131254759);
        RelativeLayout.LayoutParams r110 = new RelativeLayout.LayoutParams(n.d(24), n.d(24));
        int r9 = n.d(4);
        r19.setPadding(r9, r9, r9, r9);
        ImageView r10 = this.f;
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("ivGrid");
        r10 = null;
    L14:
        r110.addRule(16, r10.getId());
        r110.addRule(15);
        r110.rightMargin = r19.getContext().getResources().getDimensionPixelSize(2131168298);
        r19.setLayoutParams(r110);
        this.g = r19;
        addView(r19);
        ImageView r111 = this.g;
        if (r111 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("ivFilter");
        r111 = null;
    L17:
        l.c(r111, 2131102419);
        ImageView r112 = this.g;
        if (r112 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("ivFilter");
        r112 = null;
    L20:
        r112.setOnClickListener(new bd5.n(this));
        AppCompatImageView r113 = new AppCompatImageView(getContext());
        r113.setId(2131376623);
        r113.setImageResource(2131255775);
        RelativeLayout.LayoutParams r1 = new RelativeLayout.LayoutParams(n.d(24), n.d(24));
        int r20 = n.d(4);
        r113.setPadding(r20, r20, r20, r20);
        ImageView r21 = this.g;
        if (r21 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("ivFilter");
        r21 = null;
    L23:
        r1.addRule(16, r21.getId());
        r1.addRule(15);
        r1.rightMargin = r113.getContext().getResources().getDimensionPixelSize(2131168298);
        r113.setLayoutParams(r1);
        this.h = r113;
        addView(r113);
        ImageView r114 = this.h;
        if (r114 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("ivSort");
        r114 = null;
    L26:
        l.c(r114, 2131102419);
        ImageView r115 = this.h;
        if (r115 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("ivSort");
    L30:
        r4.setOnClickListener(new p(this));
        addView(r15);
        n.d(2);
        this.c = SubMenuView.FilterState.DEFAULT;
        return;
    L29:
        r4 = r115;
        goto L30
    }

    public /* synthetic */ SubMenuViewPad(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
