package com.bytedance.ee.bear.bitable.itemview.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.bitable.card.view.page.u;
import com.bytedance.ee.bear.bitable.databinding.BitableItemViewRecordTitleBarBinding;
import com.larksuite.component.ui.imageview.LKUILottieAnimationView;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001)B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u00032\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020$2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0016\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordTitleBarContainer;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordTitleBarData;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableItemViewRecordTitleBarBinding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableItemViewRecordTitleBarBinding;", "state", "Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordTitleBarContainer$ItemViewRecordTitleBarState;", "getState", "()Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordTitleBarContainer$ItemViewRecordTitleBarState;", NotificationCompat.CATEGORY_NAVIGATION, "Lcom/bytedance/ee/bear/bitable/itemview/record/menu/Navigation;", "getNavigation", "()Lcom/bytedance/ee/bear/bitable/itemview/record/menu/Navigation;", "setNavigation", "(Lcom/bytedance/ee/bear/bitable/itemview/record/menu/Navigation;)V", "subscribe", "Lcom/bytedance/ee/bear/bitable/card/view/page/RecordSubscribeWrapper;", "getSubscribe", "()Lcom/bytedance/ee/bear/bitable/card/view/page/RecordSubscribeWrapper;", "setSubscribe", "(Lcom/bytedance/ee/bear/bitable/card/view/page/RecordSubscribeWrapper;)V", "setData", "", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "openMenu", "Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewMoreMenuData;", "onOffsetChanged", "offset", "", "totalScrollRange", "ItemViewRecordTitleBarState", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewRecordTitleBarContainer extends FrameLayout implements gv4.b<ItemViewRecordTitleBarData> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f214036e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitableItemViewRecordTitleBarBinding f214037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f214038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.itemview.record.menu.b f214039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public u f214040d;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f214041a = null;

        static {
            f214041a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ItemViewRecordTitleBarData f214042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Boolean f214043b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f214044c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f214045d;

        public b() {
            this.f214044c = -1.0f;
            this.f214045d = UIHelper.dp2px(48.0f);
        }
    }

    public final BitableItemViewRecordTitleBarBinding getBinding() {
        return this.f214037a;
    }

    public final com.bytedance.ee.bear.bitable.itemview.record.menu.b getNavigation() {
        return this.f214039c;
    }

    public final b getState() {
        return this.f214038b;
    }

    public final u getSubscribe() {
        return this.f214040d;
    }

    public ItemViewRecordTitleBarContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setNavigation(com.bytedance.ee.bear.bitable.itemview.record.menu.b r100) {
        this.f214039c = r100;
    }

    public final void setSubscribe(u r100) {
        this.f214040d = r100;
    }

    public ItemViewRecordTitleBarContainer(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        LayoutInflater.from(r110).inflate(R.layout.bitable_item_view_record_title_bar, this);
        int r112 = R.id.record_card_menu_subscribe;
        FrameLayout r100 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.record_card_menu_subscribe);
        if (r100 == null) goto L23;
        r112 = R.id.record_card_menu_subscribe_icon;
        LKUILottieAnimationView r101 = (LKUILottieAnimationView) ViewBindings.findChildViewById(this, R.id.record_card_menu_subscribe_icon);
        if (r101 == null) goto L23;
        r112 = R.id.recordcard_close;
        FrameLayout r102 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.recordcard_close);
        if (r102 == null) goto L23;
        r112 = R.id.recordcard_menu_more;
        FrameLayout r103 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.recordcard_menu_more);
        if (r103 == null) goto L23;
        r112 = R.id.recordcard_menu_share;
        FrameLayout r104 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.recordcard_menu_share);
        if (r104 == null) goto L23;
        r112 = R.id.recordcard_menu_share_icon;
        AppCompatImageView r105 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.recordcard_menu_share_icon);
        if (r105 == null) goto L23;
        r112 = R.id.recordcard_table_title_tv;
        TextView r106 = (TextView) ViewBindings.findChildViewById(this, R.id.recordcard_table_title_tv);
        if (r106 == null) goto L23;
        r112 = R.id.recordcard_title_ll_opt;
        ConstraintLayout r107 = (ConstraintLayout) ViewBindings.findChildViewById(this, R.id.recordcard_title_ll_opt);
        if (r107 == null) goto L23;
        r112 = R.id.recordcard_to_navigation;
        AppCompatImageView r113 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.recordcard_to_navigation);
        if (r113 == null) goto L23;
        this.f214037a = new BitableItemViewRecordTitleBarBinding(this, r100, r101, r102, r103, r104, r105, r106, r107, r113);
        this.f214038b = new b();
        setOnClickListener(a.f214041a);
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r112)));
    }

    public final void a(int r100, int r101) {
        int r102 = RangesKt.coerceAtMost(this.f214038b.f214045d, r101);
        if (Math.abs(r100) <= r102) goto L5;
        float r103 = 1.0f;
    L7:
        if (r100 != 0) goto L16;
        ItemViewRecordTitleBarData r104 = this.f214038b.f214042a;
        if (r104 != null) goto L11;
    L13:
        boolean r105 = false;
    L14:
        if (r105 == false) goto L16;
        boolean r106 = true;
    L17:
        b r107 = this.f214038b;
        if (r107.f214044c != r103) goto L20;
        boolean r108 = true;
    L21:
        if (r108 == true) goto L23;
    L25:
        this.f214038b.f214044c = r103;
        setBackgroundColor(j08.b.c(getContext(), R.color.bg_body, r103));
        ItemViewRecordTitleBarData r109 = this.f214038b.f214042a;
        if (r109 != null) goto L28;
    L30:
        boolean r110 = false;
    L32:
        if (r110 == false) goto L34;
        this.f214037a.f210935h.setTextColor(ContextCompat.getColor(getContext(), R.color.text_title));
    L35:
        this.f214038b.f214043b = Boolean.valueOf(r106);
        BitableItemViewRecordTitleBarBinding r111 = this.f214037a;
        Iterator r112 = CollectionsKt.listOf(new FrameLayout[]{r111.f210931d, r111.f210932e, r111.f210933f, r111.f210929b}).iterator();
    L37:
        if (r112.hasNext() == false) goto L42;
        FrameLayout r113 = (FrameLayout) r112.next();
        if (r106 == true) goto L40;
        r113.setBackground(null);
        goto L37
    L40:
        r113.setBackgroundResource(R.drawable.bitable_page_view_title_bar_button_bg);
        goto L37
    L42:
        return;
    L34:
        this.f214037a.f210935h.setTextColor(j08.b.c(getContext(), R.color.text_title, r103));
        goto L35
    L28:
        if (r109.getFixedTitleColor() != true) goto L30;
        r110 = true;
        goto L32
    L23:
        if (Intrinsics.areEqual(r107.f214043b, Boolean.valueOf(r106)) == false) goto L25;
        return;
    L20:
        r108 = false;
        goto L21
    L11:
        if (r104.getShowCover() != true) goto L13;
        r105 = true;
    L16:
        r106 = false;
        goto L17
    L5:
        r103 = Math.abs(r100) / r102;
        goto L7
    }
}
