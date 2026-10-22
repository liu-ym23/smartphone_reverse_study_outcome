package com.bytedance.ee.bear.bitable.itemview.recordpages;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.LiveData;
import androidx.viewbinding.ViewBindings;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bytedance.ee.bear.bitable.databinding.BitableItemViewRecordFooterChild1Binding;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/recordpages/ItemViewRecordFooterChild1;", "Lcom/bytedance/ee/bear/bitable/itemview/recordpages/FooterChild;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableItemViewRecordFooterChild1Binding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableItemViewRecordFooterChild1Binding;", "hasObserve", "Ljava/util/concurrent/atomic/AtomicBoolean;", "setData", "", "data", "Lcom/bytedance/ee/bear/bitable/itemview/recordpages/ItemViewRecordFooterData;", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "needFollowScroll", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewRecordFooterChild1 extends FooterChild {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitableItemViewRecordFooterChild1Binding f214171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f214172b;

    public final BitableItemViewRecordFooterChild1Binding getBinding() {
        return this.f214171a;
    }

    public ItemViewRecordFooterChild1(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public ItemViewRecordFooterChild1(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        LayoutInflater.from(r110).inflate(R.layout.bitable_item_view_record_footer_child1, this);
        int r112 = R.id.bottomInnerContainer;
        if (((LinearLayout) ViewBindings.findChildViewById(this, R.id.bottomInnerContainer)) == null) goto L25;
        r112 = R.id.commentCount;
        TextView r100 = (TextView) ViewBindings.findChildViewById(this, R.id.commentCount);
        if (r100 == null) goto L25;
        r112 = R.id.commentLayout;
        if (((ConstraintLayout) ViewBindings.findChildViewById(this, R.id.commentLayout)) == null) goto L25;
        r112 = R.id.inputHolderTv;
        TextView r101 = (TextView) ViewBindings.findChildViewById(this, R.id.inputHolderTv);
        if (r101 == null) goto L25;
        r112 = R.id.next_record;
        AppCompatImageView r102 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.next_record);
        if (r102 == null) goto L25;
        r112 = R.id.pageIndicator;
        LinearLayout r103 = (LinearLayout) ViewBindings.findChildViewById(this, R.id.pageIndicator);
        if (r103 == null) goto L25;
        r112 = R.id.pre_record;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.pre_record);
        if (r104 == null) goto L25;
        r112 = R.id.record_index;
        TextView r105 = (TextView) ViewBindings.findChildViewById(this, R.id.record_index);
        if (r105 == null) goto L25;
        r112 = R.id.switch_card_view;
        if (((LinearLayout) ViewBindings.findChildViewById(this, R.id.switch_card_view)) == null) goto L25;
        r112 = R.id.userAvatar;
        UDAvatar r106 = (UDAvatar) ViewBindings.findChildViewById(this, R.id.userAvatar);
        if (r106 == null) goto L25;
        this.f214171a = new BitableItemViewRecordFooterChild1Binding(this, r100, r101, r102, r103, r104, r105, r106);
        this.f214172b = new AtomicBoolean(false);
        return;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r112)));
    }

    @Override // gv4.b
    public final void iq(Object r100, t r101) {
        ItemViewRecordFooterData r102 = (ItemViewRecordFooterData) r100;
        if (r102 == null) goto L32;
        com.bytedance.ee.bear.bitable.itemview.util.l.a("ItemViewRecordFooterChild1.setData", null, null, null, 14);
        boolean r103 = true;
        if (r102.getShowAvatar() == false) goto L7;
        AccountService$Account r104 = ((h0) e0c.k.a(LarkContext.getApplication(), h0.class)).G2();
        Glide.with(getContext()).load(new BearGlideUrl(r104.avatarUrl)).diskCacheStrategy(DiskCacheStrategy.DATA).placeholder(R.drawable.facade_common_avatar_place_holder).into(this.f214171a.f210893h);
        this.f214171a.f210893h.setAvatarSize(com.bytedance.ee.util.ui.n.d(32));
        com.bytedance.ee.bear.bitable.m.z(this.f214171a.f210893h, true);
    L9:
        if (this.f214172b.compareAndSet(false, true) == false) goto L15;
        com.bytedance.ee.bear.bitable.itemview.b r105 = com.bytedance.ee.bear.bitable.itemview.util.i.c(this);
        if (r105 == null) goto L15;
        LiveData<Boolean> r106 = r105.getCommentAble();
        if (r106 == null) goto L15;
        r106.observe(r105.getFragment().getViewLifecycleOwner(), new b(this));
    L15:
        this.f214171a.f210888c.setOnClickListener(new c(r101));
        Drawable r107 = ResourcesCompat.getDrawable(getResources(), R.drawable.ud_icon_add_comment_outlined, getContext().getTheme());
        if (r107 == null) goto L18;
        r107.setBounds(0, 0, com.bytedance.ee.util.ui.n.d(20), com.bytedance.ee.util.ui.n.d(20));
        this.f214171a.f210887b.setCompoundDrawables(r107, null, null, null);
    L18:
        this.f214171a.f210887b.setText(String.valueOf(r102.getCommentCount()));
        this.f214171a.f210887b.setOnClickListener(new d(r102, r101));
        com.bytedance.ee.bear.bitable.m.z(this.f214171a.f210890e, r102.getShouldShowBottomSwitchView());
        if (r102.getShouldShowBottomSwitchView() == false) goto L30;
        this.f214171a.f210892g.setText(r102.getIndexText());
        TextView r108 = this.f214171a.f210892g;
        String r109 = r102.getIndexText();
        if (r109 != null) goto L23;
    L28:
        r103 = false;
    L29:
        com.bytedance.ee.bear.bitable.m.z(r108, r103);
        goto L30
    L23:
        if (r109.length() <= 0) goto L25;
        boolean r110 = true;
    L26:
        if (r110 != true) goto L28;
    L25:
        r110 = false;
    L30:
        this.f214171a.f210891f.setOnClickListener(new e(r101));
        this.f214171a.f210891f.setEnabled(r102.enableScrollLeft());
        this.f214171a.f210889d.setOnClickListener(new f(r101));
        this.f214171a.f210889d.setEnabled(r102.enableScrollRight());
        return;
    L7:
        com.bytedance.ee.bear.bitable.m.z(this.f214171a.f210893h, false);
        goto L9
    }
}
