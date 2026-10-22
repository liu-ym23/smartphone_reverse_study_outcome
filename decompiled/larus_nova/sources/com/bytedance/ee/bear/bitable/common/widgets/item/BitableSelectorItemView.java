package com.bytedance.ee.bear.bitable.common.widgets.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.bitable.common.widgets.SyncIconImageView;
import com.bytedance.ee.bear.widgets.t;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001QB)\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ!\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:2\n\b\u0003\u0010;\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010<J+\u0010=\u001a\u0002082\b\b\u0001\u0010>\u001a\u00020\u00072\n\b\u0003\u0010;\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010?\u001a\u00020&¢\u0006\u0002\u0010@J!\u0010A\u001a\u0002082\b\b\u0001\u0010>\u001a\u00020\u00072\n\b\u0003\u0010;\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010BJ!\u0010C\u001a\u0002082\b\u0010D\u001a\u0004\u0018\u00010:2\n\b\u0003\u0010;\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010<J\u000e\u0010E\u001a\u0002082\u0006\u0010F\u001a\u00020&J\u000e\u0010G\u001a\u0002082\u0006\u0010F\u001a\u00020&J\u000e\u0010H\u001a\u0002082\u0006\u0010F\u001a\u00020&J\u0010\u0010I\u001a\u0002082\u0006\u0010J\u001a\u00020&H\u0016J\u0018\u0010K\u001a\u0002082\u0006\u0010L\u001a\u00020M2\u0006\u0010J\u001a\u00020&H\u0002J\u000e\u0010N\u001a\u0002082\u0006\u0010O\u001a\u00020,J\b\u0010P\u001a\u000208H\u0016R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001e\u0010\u001f\u001a\u0004\u0018\u00010 8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006R"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/widgets/item/BitableSelectorItemView;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "titleTVFromXml", "Landroid/widget/TextView;", "getTitleTVFromXml", "()Landroid/widget/TextView;", "setTitleTVFromXml", "(Landroid/widget/TextView;)V", "leftIconIVFromXml", "Lcom/bytedance/ee/bear/bitable/common/widgets/SyncIconImageView;", "getLeftIconIVFromXml", "()Lcom/bytedance/ee/bear/bitable/common/widgets/SyncIconImageView;", "setLeftIconIVFromXml", "(Lcom/bytedance/ee/bear/bitable/common/widgets/SyncIconImageView;)V", "rightIconIvFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getRightIconIvFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setRightIconIvFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "rightDescTVFromXml", "getRightDescTVFromXml", "setRightDescTVFromXml", "guideBadgeFromXml", "Lcom/larksuite/component/universe_design/badge/UDBadgeView;", "getGuideBadgeFromXml", "()Lcom/larksuite/component/universe_design/badge/UDBadgeView;", "setGuideBadgeFromXml", "(Lcom/larksuite/component/universe_design/badge/UDBadgeView;)V", "mEnabled", "", "getMEnabled", "()Z", "setMEnabled", "(Z)V", "mItemClickListener", "Lcom/bytedance/ee/bear/bitable/common/widgets/item/BitableSelectorItemView$OnItemClickListener;", "getMItemClickListener", "()Lcom/bytedance/ee/bear/bitable/common/widgets/item/BitableSelectorItemView$OnItemClickListener;", "setMItemClickListener", "(Lcom/bytedance/ee/bear/bitable/common/widgets/item/BitableSelectorItemView$OnItemClickListener;)V", "itemTitle", "", "getItemTitle", "()Ljava/lang/String;", "setItemTitle", "(Ljava/lang/String;)V", com.alipay.sdk.m.x.d.f25925o, "", "title", "", "tintColorRes", "(Ljava/lang/CharSequence;Ljava/lang/Integer;)V", "setLeftIcon", "iconRes", "isSync", "(ILjava/lang/Integer;Z)V", "setRightIcon", "(ILjava/lang/Integer;)V", "setRightText", "text", "setLeftIconVisible", "visible", "setRightIconVisible", "setGuideBadgeVisible", "setEnabled", "enabled", "setChildViewEnabled", "viewGroup", "Landroid/view/ViewGroup;", "setOnItemClickListener", "listener", "onItemClicked", "OnItemClickListener", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BitableSelectorItemView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f209981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SyncIconImageView f209982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AppCompatImageView f209983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f209984d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public UDBadgeView f209985e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f209986f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f209987g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f209988h;

    public static final class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BitableSelectorItemView f209989c;

        public a(BitableSelectorItemView r100) {
            this.f209989c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            this.f209989c.a();
        }
    }

    public interface b {
        void a(BitableSelectorItemView r100);

        boolean b(BitableSelectorItemView r100);
    }

    public BitableSelectorItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BitableSelectorItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public void a() {
        if (this.f209986f == false) goto L7;
        b r100 = this.f209987g;
        if (r100 == null) goto L11;
        r100.b(this);
        return;
    L11:
        return;
    L7:
        b r101 = this.f209987g;
        if (r101 == null) goto L13;
        r101.a(this);
        return;
    }

    public final UDBadgeView getGuideBadgeFromXml() {
        KeyEvent.Callback r100 = this.f209985e;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.guideBadge);
        this.f209985e = (UDBadgeView) r100;
    L6:
        return (UDBadgeView) r100;
    }

    public final SyncIconImageView getLeftIconIVFromXml() {
        KeyEvent.Callback r100 = this.f209982b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.leftIconIV);
        this.f209982b = (SyncIconImageView) r100;
    L6:
        return (SyncIconImageView) r100;
    }

    public final TextView getRightDescTVFromXml() {
        KeyEvent.Callback r100 = this.f209984d;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.rightDescTV);
        this.f209984d = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final AppCompatImageView getRightIconIvFromXml() {
        KeyEvent.Callback r100 = this.f209983c;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.rightIconIv);
        this.f209983c = (AppCompatImageView) r100;
    L6:
        return (AppCompatImageView) r100;
    }

    public final TextView getTitleTVFromXml() {
        KeyEvent.Callback r100 = this.f209981a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.titleTV);
        this.f209981a = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final String getItemTitle() {
        return this.f209988h;
    }

    public final boolean getMEnabled() {
        return this.f209986f;
    }

    public final b getMItemClickListener() {
        return this.f209987g;
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        this.f209986f = r100;
        b(this, r100);
        Context r101 = getContext();
        if (r100 == false) goto L5;
        int r102 = R.color.bitable_selector_item_bg_color;
    L6:
        setBackgroundTintList(UDColorUtils.getColorStateList(r101, r102));
        return;
    L5:
        r102 = R.color.bg_float;
        goto L6
    }

    public final void setGuideBadgeFromXml(UDBadgeView r100) {
        this.f209985e = r100;
    }

    public final void setGuideBadgeVisible(boolean r100) {
        UDBadgeView r101 = getGuideBadgeFromXml();
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setItemTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f209988h = r100;
    }

    public final void setLeftIconIVFromXml(SyncIconImageView r100) {
        this.f209982b = r100;
    }

    public final void setLeftIconVisible(boolean r100) {
        SyncIconImageView r101 = getLeftIconIVFromXml();
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setMEnabled(boolean r100) {
        this.f209986f = r100;
    }

    public final void setMItemClickListener(b r100) {
        this.f209987g = r100;
    }

    public final void setOnItemClickListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f209987g = r100;
    }

    public final void setRightDescTVFromXml(TextView r100) {
        this.f209984d = r100;
    }

    public final void setRightIconIvFromXml(AppCompatImageView r100) {
        this.f209983c = r100;
    }

    public final void setRightIconVisible(boolean r100) {
        AppCompatImageView r101 = getRightIconIvFromXml();
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setTitleTVFromXml(TextView r100) {
        this.f209981a = r100;
    }

    public static void b(ViewGroup r100, boolean r101) {
        int r102 = r100.getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        View r104 = r100.getChildAt(r103);
        r104.setEnabled(r101);
        if ((r104 instanceof ViewGroup) == false) goto L7;
        b((ViewGroup) r104, r101);
    L7:
        r103 = r103 + 1;
        goto L3
    }

    public static void e(com.bytedance.ee.bear.bitable.fieldedit.view.selection.m r100, CharSequence r101) {
        r100.getRightDescTVFromXml().setVisibility(0);
        r100.getRightDescTVFromXml().setText(r101);
    }

    public static void f(BitableSelectorItemView r100, CharSequence r101) {
        r100.getTitleTVFromXml().setText(r101);
        r100.f209988h = String.valueOf(r101);
    }

    public final void d(int r100, Integer r101) {
        getRightIconIvFromXml().setVisibility(0);
        getRightIconIvFromXml().setImageResource(r100);
        if (r101 == null) goto L6;
        int r102 = r101.intValue();
        getRightIconIvFromXml().setImageTintList(UDColorUtils.getColorStateList(getContext(), r102));
        return;
    }

    public BitableSelectorItemView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f209986f = true;
        this.f209988h = "";
        LayoutInflater.from(r100).inflate(R.layout.bitable_selector_list_item, this);
        setBackgroundColor(getResources().getColor(R.color.bg_float));
        setPadding(getResources().getDimensionPixelSize(R.dimen.space_kit_len_16), 0, 0, 0);
        setEnabled(this.f209986f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.space_kit_len_48)));
        setOnClickListener(new a(this));
    }

    public /* synthetic */ BitableSelectorItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static void c(BitableSelectorItemView r100, int r101, boolean r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        r102 = false;
    L5:
        r100.getLeftIconIVFromXml().setVisibility(0);
        r100.getLeftIconIVFromXml().setImageResource(r101);
        r100.getLeftIconIVFromXml().setSyncIconVisible(r102);
    }
}
