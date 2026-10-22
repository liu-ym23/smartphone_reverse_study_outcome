package com.suite.lark.platform.component.cta.newstyle.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.platform.component.cta.databinding.ItemVersionInfoBinding;
import com.suite.lark.platform.component.cta.newstyle.f;
import goc.b;
import java.util.List;
import joc.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import loc.e;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002)*B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0003H\u0002J\u0018\u0010 \u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0003H\u0002J\u0018\u0010!\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0003H\u0002J \u0010\"\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010#\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0003H\u0002J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0014\u0010%\u001a\u00020\u001c2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00030\u00030\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/suite/lark/platform/component/cta/newstyle/adapter/VersionInfoAdapter;", "Lcom/ss/android/lark/base/adapter/LarkRecyclerViewBaseAdapter;", "Lcom/suite/lark/platform/component/cta/newstyle/adapter/VersionInfoAdapter$VersionViewHolder;", "Lcom/suite/lark/platform/component/cta/newstyle/entity/CardVO;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onVersionClickListener", "Lcom/suite/lark/platform/component/cta/newstyle/entity/OnVersionClickListener;", "<init>", "(Landroid/content/Context;Lcom/suite/lark/platform/component/cta/newstyle/entity/OnVersionClickListener;)V", "getContext", "()Landroid/content/Context;", "getOnVersionClickListener", "()Lcom/suite/lark/platform/component/cta/newstyle/entity/OnVersionClickListener;", "differ", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "getItems", "", "getItem", "position", "", "getItemCount", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "bindVersionInfoItem", MapController.ITEM_LAYER_TAG, "bindTitle", "bindPrice", "updateItemMargin", "bindListeners", "updateSelection", "submitList", "items", "", "Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Card;", "VersionViewHolder", "Companion", "cta_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VersionInfoAdapter extends LarkRecyclerViewBaseAdapter<VersionViewHolder, joc.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f460545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f460546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AsyncListDiffer<joc.a> f460547c;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0016\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u0018\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/suite/lark/platform/component/cta/newstyle/adapter/VersionInfoAdapter$VersionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/suite/lark/platform/component/cta/databinding/ItemVersionInfoBinding;", "<init>", "(Lcom/suite/lark/platform/component/cta/databinding/ItemVersionInfoBinding;)V", "versionCheckbox", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "getVersionCheckbox", "()Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "versionWrapper", "Landroid/widget/LinearLayout;", "getVersionWrapper", "()Landroid/widget/LinearLayout;", "versionText", "Landroid/widget/TextView;", "getVersionText", "()Landroid/widget/TextView;", "priceSymbol", "getPriceSymbol", "priceCount", "getPriceCount", "priceUnit", "getPriceUnit", RootDescription.ROOT_ELEMENT, "getRoot", "Companion", "cta_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class VersionViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final /* synthetic */ int f460548h = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UDCheckBox f460549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinearLayout f460550b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f460551c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f460552d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f460553e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f460554f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final LinearLayout f460555g;

        public static final class a {
        }

        static {
        }

        public VersionViewHolder(ItemVersionInfoBinding r100) {
            super(r100.f460502a);
            this.f460549a = r100.f460506e;
            this.f460550b = r100.f460508g;
            this.f460551c = r100.f460507f;
            this.f460552d = r100.f460504c;
            this.f460553e = r100.f460503b;
            this.f460554f = r100.f460505d;
            this.f460555g = r100.f460502a;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter
    public final List<joc.a> getItems() {
        return this.f460547c.getCurrentList();
    }

    @Override // com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return getItems().size();
    }

    public final Context getContext() {
        return this.f460545a;
    }

    @Override // com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter
    public final joc.a getItem(int r100) {
        return (joc.a) ListProtector.get(this.f460547c.getCurrentList(), r100);
    }

    public VersionInfoAdapter(Context r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "onVersionClickListener");
        this.f460545a = r100;
        this.f460546b = r101;
        this.f460547c = new AsyncListDiffer(this, new VersionInfoAdapter$differ$1());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        VersionViewHolder r102 = (VersionViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        joc.a r103 = (joc.a) ListProtector.get(this.f460547c.getCurrentList(), r101);
        r102.f460549a.setEnabled(r103.f499925a.f());
        r102.f460549a.setChecked(r103.f499926b);
        if (r103.f499925a.f() == true) goto L5;
    L13:
        TextView r104 = r102.f460551c;
        String r105 = r103.f499925a.h();
        String r106 = "";
        if (r105 != null) goto L16;
        r105 = "";
    L16:
        r104.setText(r105);
        String r107 = null;
        if (r103.f499925a.i() == false) goto L25;
        UDTagsDrawable.d.a r108 = new UDTagsDrawable.d.a(this.f460545a);
        String r109 = r103.f499925a.c();
        if (r109 == null) goto L22;
        r106 = r109;
    L22:
        r108.f285353c = r106;
        r108.f285354d = UIUtils.getColor(this.f460545a, R.color.udtoken_tag_neutral_text_normal);
        r108.a(UIUtils.getColor(this.f460545a, R.color.udtoken_tag_neutral_bg_normal));
        UDTagsDrawable.d r110 = r108.b();
        UDTagsDrawable.a r111 = new UDTagsDrawable.a(this.f460545a);
        r111.a(r110);
        UDTagsDrawable r112 = r111.b();
        if (r112 == null) goto L39;
        r112.c(r102.f460551c);
    L39:
        TextView r113 = r102.f460552d;
        b.k r114 = r103.f499925a.e();
        if (r114 == null) goto L42;
        String r115 = r114.b();
    L43:
        r113.setText(r115);
        TextView r116 = r102.f460553e;
        b.k r117 = r103.f499925a.e();
        if (r117 == null) goto L46;
        String r118 = r117.a();
    L47:
        r116.setText(r118);
        TextView r119 = r102.f460554f;
        b.k r120 = r103.f499925a.e();
        if (r120 == null) goto L50;
        r107 = r120.c();
    L50:
        r119.setText(r107);
        r102.f460553e.post(new com.suite.lark.platform.component.cta.newstyle.adapter.a(r102, this, r101));
        r102.f460555g.setOnClickListener(new ioc.a(r103, this, r102));
        return;
    L46:
        r118 = null;
        goto L47
    L42:
        r115 = null;
        goto L43
    L25:
        String r121 = r103.f499925a.b();
        if (r121 != null) goto L28;
    L31:
        boolean r122 = true;
    L32:
        if (r122 == true) goto L39;
        if (r102.f460550b.findViewWithTag("iconView") != null) goto L39;
        int r123 = UIUtils.dp2px(this.f460545a, 24.0f);
        ImageView r124 = new ImageView(this.f460545a);
        LinearLayout.LayoutParams r125 = new LinearLayout.LayoutParams(r123, r123);
        r125.setMarginStart(UIUtils.dp2px(r124.getContext(), 4.0f));
        r124.setLayoutParams(r125);
        r124.setTag("iconView");
        String r126 = r103.f499925a.b();
        if (r126 == null) goto L38;
        e.a(r124, this.f460545a, r126, null);
    L38:
        r102.f460550b.addView(r124);
        goto L39
    L28:
        if (r121.length() == 0) goto L31;
        r122 = false;
        goto L32
    L5:
        if (r103.f499926b == false) goto L7;
        int r127 = UIUtils.getColor(this.f460545a, R.color.primary_fill_default);
    L9:
        if (r103.f499926b == false) goto L11;
        int r128 = UIUtils.getColor(this.f460545a, R.color.primary_fill_default);
    L12:
        r102.f460551c.setTextColor(r127);
        r102.f460552d.setTextColor(r128);
        r102.f460553e.setTextColor(r128);
        goto L13
    L11:
        r128 = UIUtils.getColor(this.f460545a, R.color.text_caption);
        goto L12
    L7:
        r127 = UIUtils.getColor(this.f460545a, R.color.text_title);
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        int r100 = VersionViewHolder.f460548h;
        Intrinsics.checkNotNullParameter(r110, "parent");
        View r112 = LayoutInflater.from(r110.getContext()).inflate(R.layout.item_version_info, r110, false);
        int r113 = R.id.price_count;
        TextView r101 = (TextView) ViewBindings.findChildViewById(r112, R.id.price_count);
        if (r101 == null) goto L19;
        r113 = R.id.price_symbol;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r112, R.id.price_symbol);
        if (r102 == null) goto L19;
        r113 = R.id.price_unit;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r112, R.id.price_unit);
        if (r103 == null) goto L19;
        r113 = R.id.price_wrapper;
        if (((LinearLayout) ViewBindings.findChildViewById(r112, R.id.price_wrapper)) == null) goto L19;
        r113 = R.id.version_info_checkbox;
        UDCheckBox r104 = (UDCheckBox) ViewBindings.findChildViewById(r112, R.id.version_info_checkbox);
        if (r104 == null) goto L19;
        r113 = R.id.version_info_text;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r112, R.id.version_info_text);
        if (r105 == null) goto L19;
        r113 = R.id.version_info_wrapper;
        LinearLayout r106 = (LinearLayout) ViewBindings.findChildViewById(r112, R.id.version_info_wrapper);
        if (r106 == null) goto L19;
        return new VersionViewHolder(new ItemVersionInfoBinding((LinearLayout) r112, r101, r102, r103, r104, r105, r106));
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r112.getResources().getResourceName(r113)));
    }
}
