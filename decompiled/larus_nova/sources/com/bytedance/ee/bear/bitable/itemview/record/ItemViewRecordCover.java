package com.bytedance.ee.bear.bitable.itemview.record;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ee.bear.bitable.card.view.table.EmptyCoverView;
import com.bytedance.ee.bear.bitable.card.view.table.m;
import com.bytedance.ee.bear.bitable.databinding.BitableCardCoverPageViewPagerBinding;
import com.bytedance.ee.bear.bitable.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#J\b\u0010$\u001a\u00020\u001fH\u0002J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'H\u0002J\u0018\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020'H\u0014J\b\u0010+\u001a\u00020\u001fH\u0016J\n\u0010,\u001a\u0004\u0018\u00010\u0016H\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001a¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordCover;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/card/view/table/IPageCoverDelegate;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableCardCoverPageViewPagerBinding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableCardCoverPageViewPagerBinding;", "setBinding", "(Lcom/bytedance/ee/bear/bitable/databinding/BitableCardCoverPageViewPagerBinding;)V", "coverAdapter", "Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordCoverAdapter;", "getCoverAdapter", "()Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordCoverAdapter;", "setCoverAdapter", "(Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordCoverAdapter;)V", "recordId", "", "getRecordId", "()Ljava/lang/String;", "setRecordId", "(Ljava/lang/String;)V", "fieldId", "getFieldId", "setFieldId", "setData", "", "data", "Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordCoverData;", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "updateCoverIndex", "processEmptyCoverView", "index", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onItemClick", "getToken", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewRecordCover extends FrameLayout implements m {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f214004e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BitableCardCoverPageViewPagerBinding f214005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ItemViewRecordCoverAdapter f214006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f214007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f214008d;

    public static final class a {
    }

    static {
    }

    public final void b() {
        String r100 = String.valueOf(this.f214005a.f210625e.getCurrentItem() + 1) + '/' + this.f214006b.f214010e.size();
        TextView r101 = this.f214005a.f210627g;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.table.m
    public final void a() {
        com.bytedance.ee.bear.bitable.itemview.util.i.g(getContext(), com.bytedance.ee.bear.bitable.itemview.util.i.c(this), this.f214007c, this.f214008d, this.f214006b.f214010e, this.f214005a.f210625e.getCurrentItem(), false);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.table.m
    public String getToken() {
        com.bytedance.ee.bear.bitable.itemview.b r100 = com.bytedance.ee.bear.bitable.itemview.util.i.c(this);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getObjToken();
    }

    public final BitableCardCoverPageViewPagerBinding getBinding() {
        return this.f214005a;
    }

    public final ItemViewRecordCoverAdapter getCoverAdapter() {
        return this.f214006b;
    }

    public final String getFieldId() {
        return this.f214008d;
    }

    public final String getRecordId() {
        return this.f214007c;
    }

    public ItemViewRecordCover(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setBinding(BitableCardCoverPageViewPagerBinding r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f214005a = r100;
    }

    public final void setCoverAdapter(ItemViewRecordCoverAdapter r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f214006b = r100;
    }

    public final void setFieldId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f214008d = r100;
    }

    public final void setRecordId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f214007c = r100;
    }

    public ItemViewRecordCover(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        View r112 = LayoutInflater.from(r110).inflate(R.layout.bitable_card_cover_page_view_pager, this, false);
        addView(r112);
        int r100 = R.id.bitable_card_cover_empty_image;
        EmptyCoverView r101 = (EmptyCoverView) ViewBindings.findChildViewById(r112, R.id.bitable_card_cover_empty_image);
        if (r101 == null) goto L17;
        r100 = R.id.bitable_card_cover_empty_layout;
        RelativeLayout r102 = (RelativeLayout) ViewBindings.findChildViewById(r112, R.id.bitable_card_cover_empty_layout);
        if (r102 == null) goto L17;
        r100 = R.id.bitable_card_cover_empty_text;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r112, R.id.bitable_card_cover_empty_text);
        if (r103 == null) goto L17;
        r100 = R.id.bitable_card_cover_view_pager;
        ViewPager r104 = (ViewPager) ViewBindings.findChildViewById(r112, R.id.bitable_card_cover_view_pager);
        if (r104 == null) goto L17;
        FrameLayout r105 = (FrameLayout) r112;
        r100 = R.id.cover_index;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r112, R.id.cover_index);
        if (r106 == null) goto L17;
        r100 = R.id.cover_index_layout;
        LinearLayout r113 = (LinearLayout) ViewBindings.findChildViewById(r112, R.id.cover_index_layout);
        if (r113 == null) goto L17;
        this.f214005a = new BitableCardCoverPageViewPagerBinding(r105, r101, r102, r103, r104, r105, r106, r113);
        this.f214007c = "";
        this.f214008d = "";
        ItemViewRecordCoverAdapter r114 = new ItemViewRecordCoverAdapter(r110, this);
        this.f214006b = r114;
        this.f214005a.f210625e.setAdapter(r114);
        this.f214005a.f210625e.setOnPageChangeListener(new AnonymousClass1(this));
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r112.getResources().getResourceName(r100)));
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        int r112 = View.MeasureSpec.getSize(r110);
        Context r100 = getContext();
        Boolean r101 = ku5.c.f506210a;
        if (r100 != null) goto L5;
        int r102 = 0;
    L7:
        if (ku5.c.k(getContext()) == false) goto L14;
        if (com.bytedance.ee.bear.bitable.itemview.util.i.e(this) == false) goto L11;
    L12:
        int r113 = View.MeasureSpec.makeMeasureSpec((int) (((double) r102) * 0.48d), 1073741824);
    L22:
        super.onMeasure(r110, r113 + 24);
        return;
    L11:
        if (r112 > (r102 / 2)) goto L12;
    L14:
        if (com.bytedance.ee.bear.bitable.itemview.util.i.e(this) == true) goto L21;
        int r103 = com.bytedance.ee.bear.bitable.c.f207079a;
        int r104 = n.f214744a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.mobile.config_item_view.bugfix") == true) goto L18;
    L20:
        r113 = View.MeasureSpec.makeMeasureSpec(r112, 1073741824);
        goto L22
    L18:
        if (r112 <= (((double) r102) * 0.75d)) goto L20;
    L21:
        r113 = View.MeasureSpec.makeMeasureSpec((int) (((double) r102) * 0.75d), 1073741824);
        goto L22
    L5:
        Display r105 = ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay();
        Point r106 = new Point();
        r105.getRealSize(r106);
        r102 = r106.y;
        goto L7
    }
}
