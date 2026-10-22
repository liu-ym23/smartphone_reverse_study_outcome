package com.bytedance.ee.bear.list.homepage.title;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewGroupKt;
import bd5.o;
import bd5.p;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.diskmanage.Biz;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
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

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0002BCB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0016\u0010%\u001a\u00020$2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!J\u0010\u0010'\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010)J\b\u0010*\u001a\u00020$H\u0002J\b\u0010+\u001a\u00020$H\u0002J\b\u0010,\u001a\u00020$H\u0002J\u0010\u0010-\u001a\u00020$2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010.\u001a\u00020$2\b\u0010/\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010\u0014\u001a\u00020$2\u0006\u00100\u001a\u00020\u000fH\u0016J\b\u00101\u001a\u00020$H\u0016J\b\u00102\u001a\u00020$H\u0016J\u0006\u00103\u001a\u00020$J\u0006\u00104\u001a\u00020$J\u0006\u00105\u001a\u00020$J\u0018\u00106\u001a\u00020$2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u000fH\u0003J\u0010\u0010:\u001a\u00020$2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010;\u001a\u00020$2\u0006\u00109\u001a\u00020\u000fJ\u0012\u0010<\u001a\u00020$2\b\u0010/\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010=\u001a\u00020$2\b\u0010>\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010?\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u000e\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020\u001fR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001aR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/bytedance/ee/bear/list/homepage/title/SubMenuViewPad;", "Landroid/widget/RelativeLayout;", "Lcom/bytedance/ee/bear/list/homepage/IHomeSubMenuView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "delegate", "Lcom/bytedance/ee/bear/list/homepage/IHomeSubMenuView$ViewDelegate;", "dp2", OperationName.OPERATION_OFFLINE_AVAILABLE, "", "filterState", "Lcom/bytedance/ee/bear/list/homepage/title/SubMenuView$FilterState;", "textViewGroup", "Landroid/widget/LinearLayout;", "showGrid", "ivGrid", "Landroidx/appcompat/widget/AppCompatImageView;", "ivFilter", "ivFilterIcon", "getIvFilterIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "ivSort", "ivSortIcon", "getIvSortIcon", "onItemClickListener", "Lcom/bytedance/ee/bear/list/homepage/title/SubMenuViewPad$OnItemClickListener;", "textList", "", "Lcom/bytedance/ee/bear/list/homepage/title/DocPageEnum;", "initViews", "", "setDataList", "list", "setCustomLeftTextArea", "title", "", "addGridView", "addFilterView", "addSortView", "setOffline", "showFilterDesc", SocialConstants.PARAM_APP_DESC, GXViewKey.VIEW_TYPE_CONTAINER_GRID, "hideGrid", "hideFilter", "hideSort", "showAllButton", "showSort", "setIconState", "imageView", "Landroid/widget/ImageView;", "selected", "setFilterState", "setSelectedSortState", "showSortDesc", "setViewDelegate", "viewDelegate", com.alipay.sdk.m.x.d.f25925o, "setOnItemClickListener", "listener", "Companion", "OnItemClickListener", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubMenuViewPad extends RelativeLayout implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f.a f228391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f228392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SubMenuView.FilterState f228393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearLayout f228394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f228395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AppCompatImageView f228396f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AppCompatImageView f228397g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AppCompatImageView f228398h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f228399i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<? extends DocPageEnum> f228400j;

    public static final class a {
    }

    public interface b {
        void a(int r100, int r101, String r102);
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SubMenuViewPad f228401a;

        public c(SubMenuViewPad r100) {
            this.f228401a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AppCompatImageView r100 = this.f228401a.f228398h;     // Catch: Throwable -> L7
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("ivSort");     // Catch: Throwable -> L7
            r100 = null;
        L5:
            r100.requestLayout();     // Catch: Throwable -> L7
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SubMenuViewPad f228402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f228403b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f228404c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f228405d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f228406e;

        public d(SubMenuViewPad r100, TextView r101, int r102, int r103, String r104) {
            this.f228402a = r100;
            this.f228403b = r101;
            this.f228404c = r102;
            this.f228405d = r103;
            this.f228406e = r104;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LinearLayout r101 = this.f228402a.f228394d;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("textViewGroup");
            r101 = null;
        L5:
            Sequence<View> r102 = ViewGroupKt.getChildren(r101);
            TextView r103 = this.f228403b;
            Iterator<View> r104 = r102.iterator();
        L7:
            if (r104.hasNext() == false) goto L9;
            View r105 = r104.next();
            Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) r105).setTextColor(r103.getContext().getResources().getColor(R.color.text_caption));
            goto L7
        L9:
            TextView r106 = this.f228403b;
            r106.setTextColor(r106.getContext().getResources().getColor(R.color.primary_fill_default));
            tt5.a.h("SubMenuViewPad", "onClick: index = " + this.f228404c + " id = " + this.f228405d);
            b r107 = this.f228402a.f228399i;
            if (r107 == null) goto L14;
            r107.a(this.f228404c, this.f228405d, this.f228406e);
            return;
        }
    }

    static {
    }

    public SubMenuViewPad(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SubMenuViewPad(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // wc5.f
    public final void a(String r100) {
    }

    @Override // wc5.f
    public void setTitle(String r100) {
    }

    public final void c() {
        AppCompatImageView r100 = this.f228397g;
        AppCompatImageView r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ivFilter");
        r100 = null;
    L5:
        r100.setVisibility(8);
        AppCompatImageView r102 = this.f228398h;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("ivSort");
    L9:
        if (r101 == null) goto L12;
        r101.post(new c(this));
        return;
    L12:
        return;
    L8:
        r101 = r102;
        goto L9
    }

    public final void e() {
        AppCompatImageView r100 = this.f228398h;
        AppCompatImageView r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ivSort");
        r100 = null;
    L5:
        r100.setVisibility(0);
        AppCompatImageView r102 = this.f228397g;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("ivFilter");
        r102 = null;
    L8:
        r102.setVisibility(0);
        AppCompatImageView r103 = this.f228396f;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("ivGrid");
    L12:
        r101.setVisibility(0);
        return;
    L11:
        r101 = r103;
        goto L12
    }

    public final AppCompatImageView getIvFilterIcon() {
        AppCompatImageView r100 = this.f228397g;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ivFilter");
        return null;
    L6:
        return r100;
    }

    public final AppCompatImageView getIvSortIcon() {
        AppCompatImageView r100 = this.f228398h;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ivSort");
        return null;
    L6:
        return r100;
    }

    @Override // wc5.f
    public final void b(boolean r100) {
        this.f228395e = r100;
        AppCompatImageView r101 = this.f228396f;
        AppCompatImageView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ivGrid");
        r101 = null;
    L5:
        l.c(r101, R.color.icon_n2);
        AppCompatImageView r103 = this.f228396f;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("ivGrid");
    L9:
        Resources r104 = getResources();
        if (r100 == false) goto L12;
        int r105 = R.drawable.ud_icon_disorder_list_outlined;
    L13:
        r102.setImageDrawable(r104.getDrawable(r105));
        return;
    L12:
        r105 = R.drawable.ud_icon_borders_outlined;
        goto L13
    L8:
        r102 = r103;
        goto L9
    }

    public final void setCustomLeftTextArea(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L15
        Unit r102 = null;
        LinearLayout r103 = null;
        if (r100 == null) goto L13;
        LinearLayout r104 = this.f228394d;     // Catch: Throwable -> L15
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("textViewGroup");     // Catch: Throwable -> L15
        r104 = null;
    L8:
        r104.removeAllViews();     // Catch: Throwable -> L15
        TextView r105 = new TextView(getContext());     // Catch: Throwable -> L15
        r105.setText(r100);     // Catch: Throwable -> L15
        int r106 = e.f483540a;     // Catch: Throwable -> L15
        r105.setTypeface(e.b(r105.getContext(), 1));     // Catch: Throwable -> L15
        r105.setTextSize(2, 16.0f);     // Catch: Throwable -> L15
        r105.setTextColor(r105.getContext().getResources().getColor(R.color.text_caption));     // Catch: Throwable -> L15
        r105.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));     // Catch: Throwable -> L15
        r105.setPadding(UIHelper.dp2px(16.0f), UIHelper.dp2px(11.0f), UIHelper.dp2px(0.0f), UIHelper.dp2px(11.0f));     // Catch: Throwable -> L15
        LinearLayout r107 = this.f228394d;     // Catch: Throwable -> L15
        if (r107 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("textViewGroup");     // Catch: Throwable -> L15
    L12:
        r103.addView(r105);     // Catch: Throwable -> L15
        r102 = Unit.INSTANCE;     // Catch: Throwable -> L15
        goto L13
    L11:
        r103 = r107;
    L13:
        Object r108 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L15
    L17:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L23;
        tt5.a.f("setCustomLeftTextArea failed", r109, false);
        return;
    L23:
        return;
    L15:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    public final void setDataList(List<? extends DocPageEnum> r110) {
        if (r110 != null) goto L5;
        setVisibility(8);
        tt5.a.h("SubMenuViewPad", "hide view because list is null");
        return;
    L5:
        this.f228400j = r110;
        LinearLayout r100 = this.f228394d;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("textViewGroup");
        r100 = null;
    L8:
        r100.removeAllViews();
        Iterator<T> r101 = r110.iterator();
        int r102 = 0;
    L10:
        if (r101.hasNext() == false) goto L25;
        Object r103 = r101.next();
        int r111 = r102 + 1;
        if (r102 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        DocPageEnum r104 = (DocPageEnum) r103;
        TextView r112 = new TextView(getContext());
        String r105 = r112.getContext().getString(r104.getTextResId());
        int r106 = r104.getId();
        r112.setText(r105);
        int r107 = e.f483540a;
        r112.setTypeface(e.b(r112.getContext(), 1));
        r112.setTextSize(2, 16.0f);
        r112.setTextColor(r112.getContext().getResources().getColor(R.color.text_caption));
        r112.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        if (r110.size() <= 1) goto L18;
        if (r102 != 0) goto L18;
        r112.setTextColor(r112.getContext().getResources().getColor(R.color.primary_fill_default));
    L18:
        r112.setPadding(UIHelper.dp2px(16.0f), UIHelper.dp2px(11.0f), UIHelper.dp2px(0.0f), UIHelper.dp2px(11.0f));
        if (r110.size() <= 1) goto L21;
        r112.setOnClickListener(new d(this, r112, r102, r106, r105));
    L21:
        LinearLayout r108 = this.f228394d;
        if (r108 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("textViewGroup");
        r108 = null;
    L24:
        r108.addView(r112);
        r102 = r111;
        goto L10
    }

    @Override // wc5.f
    public void setFilterState(SubMenuView.FilterState r100) {
        Intrinsics.checkNotNullParameter(r100, "filterState");
        this.f228393c = r100;
        AppCompatImageView r101 = this.f228397g;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ivFilter");
        r101 = null;
    L6:
        if (r100 != SubMenuView.FilterState.CHECKED) goto L8;
        boolean r102 = true;
    L9:
        d(r101, r102);
        return;
    L8:
        r102 = false;
        goto L9
    }

    @Override // wc5.f
    public void setOffline(boolean r100) {
        this.f228392b = r100;
        setFilterState(this.f228393c);
    }

    public final void setOnItemClickListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        tt5.a.h("SubMenuViewPad", "setOnItemClickListener() called with: listener = " + r100);
        this.f228399i = r100;
    }

    public final void setSelectedSortState(boolean r100) {
        AppCompatImageView r101 = this.f228398h;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ivSort");
        r101 = null;
    L5:
        d(r101, r100);
    }

    @Override // wc5.f
    public void setViewDelegate(f.a r100) {
        tt5.a.h("SubMenuViewPad", "setViewDelegate() called with: viewDelegate = " + r100 + " this:" + hashCode());
        this.f228391a = r100;
    }

    public final void d(AppCompatImageView r100, boolean r101) {
        int r102 = R.color.icon_disable;
        if (r101 == true) goto L5;
        r100.setBackgroundDrawable(null);
        if (this.f228392b == true) goto L17;
        r102 = R.color.icon_n2;
    L17:
        l.c(r100, r102);
        return;
    L5:
        if (this.f228392b == true) goto L8;
        r102 = R.color.space_list_icon_filter_blue;
    L8:
        r100.setBackgroundDrawable(getResources().getDrawable(R.drawable.list_filter_icon_selected_bg));
        if (this.f228392b == false) goto L11;
        int r103 = R.color.space_list_bg_filter_icon_offline;
    L12:
        l.b(r100, r103);
        goto L17
    L11:
        r103 = R.color.space_list_bg_filter_icon_selected;
        goto L12
    }

    public SubMenuViewPad(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        tt5.a.h("SubMenuViewPad", "initViews: this:" + hashCode());
        setBackgroundColor(UIUtils.getColor(r110, R.color.bg_body));
        LinearLayout r113 = new LinearLayout(r110);
        r113.setOrientation(0);
        RelativeLayout.LayoutParams r100 = new RelativeLayout.LayoutParams(-2, -2);
        r100.addRule(5);
        r100.addRule(15);
        r113.setLayoutParams(r100);
        this.f228394d = r113;
        HorizontalScrollView r114 = new HorizontalScrollView(r110);
        RelativeLayout.LayoutParams r115 = new RelativeLayout.LayoutParams(-1, -2);
        r115.addRule(9);
        r115.addRule(16, R.id.iv_sort);
        r115.addRule(15);
        r115.setMarginEnd(UIHelper.dp2px(6.0f));
        r114.setPadding(UIHelper.dp2px(8.0f), 0, 0, 0);
        r114.setLayoutParams(r115);
        r114.setScrollbarFadingEnabled(false);
        r114.setHorizontalScrollBarEnabled(false);
        r114.setHorizontalFadingEdgeEnabled(true);
        r114.setFadingEdgeLength(UIHelper.dp2px(10.0f));
        LinearLayout r101 = this.f228394d;
        AppCompatImageView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textViewGroup");
        r101 = null;
    L5:
        r114.addView(r101);
        AppCompatImageView r103 = new AppCompatImageView(getContext());
        r103.setId(R.id.iv_grid);
        r103.setImageResource(R.drawable.ud_icon_borders_outlined);
        RelativeLayout.LayoutParams r104 = new RelativeLayout.LayoutParams(n.d(24), n.d(24));
        int r105 = n.d(4);
        r103.setPadding(r105, r105, r105, r105);
        r104.addRule(11);
        r104.addRule(15);
        r104.rightMargin = r103.getContext().getResources().getDimensionPixelSize(R.dimen.space_kit_len_14);
        r103.setLayoutParams(r104);
        this.f228396f = r103;
        addView(r103);
        AppCompatImageView r106 = this.f228396f;
        if (r106 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("ivGrid");
        r106 = null;
    L8:
        l.c(r106, R.color.icon_n2);
        boolean r116 = LarkKVStorage.h(new com.ss.android.lark.storage.a(Biz.DOCS.getValue()), true).getBoolean("is_grid", false);
        this.f228395e = r116;
        b(r116);
        AppCompatImageView r117 = this.f228396f;
        if (r117 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("ivGrid");
        r117 = null;
    L11:
        r117.setOnClickListener(new o(this));
        AppCompatImageView r118 = new AppCompatImageView(getContext());
        r118.setId(R.id.iv_filter);
        r118.setImageResource(R.drawable.ud_icon_filter_outlined);
        RelativeLayout.LayoutParams r119 = new RelativeLayout.LayoutParams(n.d(24), n.d(24));
        int r107 = n.d(4);
        r118.setPadding(r107, r107, r107, r107);
        AppCompatImageView r108 = this.f228396f;
        if (r108 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("ivGrid");
        r108 = null;
    L14:
        r119.addRule(16, r108.getId());
        r119.addRule(15);
        r119.rightMargin = r118.getContext().getResources().getDimensionPixelSize(R.dimen.space_kit_len_10);
        r118.setLayoutParams(r119);
        this.f228397g = r118;
        addView(r118);
        AppCompatImageView r120 = this.f228397g;
        if (r120 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("ivFilter");
        r120 = null;
    L17:
        l.c(r120, R.color.icon_n2);
        AppCompatImageView r121 = this.f228397g;
        if (r121 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("ivFilter");
        r121 = null;
    L20:
        r121.setOnClickListener(new bd5.n(this));
        AppCompatImageView r122 = new AppCompatImageView(getContext());
        r122.setId(R.id.iv_sort);
        r122.setImageResource(R.drawable.ud_icon_sort_outlined);
        RelativeLayout.LayoutParams r109 = new RelativeLayout.LayoutParams(n.d(24), n.d(24));
        int r123 = n.d(4);
        r122.setPadding(r123, r123, r123, r123);
        AppCompatImageView r124 = this.f228397g;
        if (r124 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("ivFilter");
        r124 = null;
    L23:
        r109.addRule(16, r124.getId());
        r109.addRule(15);
        r109.rightMargin = r122.getContext().getResources().getDimensionPixelSize(R.dimen.space_kit_len_10);
        r122.setLayoutParams(r109);
        this.f228398h = r122;
        addView(r122);
        AppCompatImageView r125 = this.f228398h;
        if (r125 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("ivSort");
        r125 = null;
    L26:
        l.c(r125, R.color.icon_n2);
        AppCompatImageView r126 = this.f228398h;
        if (r126 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("ivSort");
    L30:
        r102.setOnClickListener(new p(this));
        addView(r114);
        n.d(2);
        this.f228393c = SubMenuView.FilterState.DEFAULT;
        return;
    L29:
        r102 = r126;
        goto L30
    }

    public /* synthetic */ SubMenuViewPad(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
