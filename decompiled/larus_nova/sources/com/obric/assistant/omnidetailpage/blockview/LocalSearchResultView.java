package com.obric.assistant.omnidetailpage.blockview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.auth.DeepThinkingConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.layout.widget.MessageLoading;
import com.larus.bmhome.chat.layout.widget.ShimmerLinearLayout;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.common_ui.widget.roundlayout.RoundRelativeLayout;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.OSearchQueryResultBlock;
import com.larus.im.bean.message.block.OSearchReference;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.block.search.local.adapter.SearchLocalItemAdapter;
import com.obric.assistant.card.databinding.ObricOmniBlockLocalSearchBinding;
import com.obric.assistant.omnidetailpage.blockview.base.OmniDetailVerticalLineFrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ?2\u00020\u0001:\u0001?B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00180\u001cJ\u0006\u0010\u001e\u001a\u00020\u0018J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000bH\u0002J \u0010 \u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0016H\u0002J \u0010#\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0016H\u0002J \u0010'\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010(\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J \u0010)\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0016H\u0002J\u0010\u0010*\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001c\u0010+\u001a\u00020\u00182\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010,\u001a\u00020\u0016H\u0002J\u0010\u0010-\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010.\u001a\u00020\u0018H\u0002J\b\u0010/\u001a\u00020\u0018H\u0002J\u001a\u00100\u001a\u00020\u00182\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u00101\u001a\u00020\u0016H\u0002J\u001e\u00102\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000b2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001d04H\u0002J\u0010\u00105\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0016\u00106\u001a\b\u0012\u0004\u0012\u00020\u001d042\u0006\u0010$\u001a\u00020%H\u0002J\u0018\u00107\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u001dH\u0002J\u0012\u00109\u001a\u00020\u00182\b\b\u0001\u0010:\u001a\u00020\u0007H\u0002J,\u0010;\u001a\u00020\u00182\u0006\u0010<\u001a\u00020\u00162\u0006\u0010=\u001a\u00020>2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00180\u001cH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/obric/assistant/omnidetailpage/blockview/LocalSearchResultView;", "Lcom/obric/assistant/omnidetailpage/blockview/base/OmniDetailVerticalLineFrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/obric/assistant/card/databinding/ObricOmniBlockLocalSearchBinding;", "swipeTextViewList", "", "Lcom/larus/bmhome/chat/layout/widget/ShimmerTextView;", "switcherAdapter", "Lcom/obric/assistant/block/search/common/ObricSearchSwitcherAdapter;", "angleAnimator", "Landroid/animation/ValueAnimator;", "shineAnimator", "Landroid/animation/ObjectAnimator;", "isFold", "", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem$LocalResult;", "onItemClick", "Lkotlin/Function1;", "", "onRecycled", "initBlockView", "setDropdownExpandState", BitableAnalytic.LinkSceneClickType.EXPAND, "withArrowAnimation", "setDropdownData", "searchQueryResultBlock", "Lcom/larus/im/bean/message/block/OSearchQueryResultBlock;", "isSubBlock", "setArrow", "setArrowRotation", "refreshSearchViewSearchIng", "refreshSearchViewSearchEnd", "cancelSwipeLight", "hideSwitch", "cancelMessageLoading", "startSwipeLight", "stopSwipeLight", "updateSwitcherVisible", "visible", "tryInitSwitchAdapter", "switcherList", "", "setUpTextSwitcher", "getSwitcherList", "jumpToUrl", "url", "showToast", "toastTextResId", "setAskUserState", "show", "block", "Lcom/larus/im/bean/message/block/Block;", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalSearchResultView extends OmniDetailVerticalLineFrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f390558h = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ObricOmniBlockLocalSearchBinding f390559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<ShimmerTextView> f390560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public eca.c f390561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ValueAnimator f390562f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f390563g;

    public static final class a {
    }

    static {
    }

    public LocalSearchResultView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LocalSearchResultView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void f() {
        Iterator<T> r100 = this.f390560d.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ShimmerTextView) r100.next()).x();
        goto L4
    L6:
        ((ArrayList) this.f390560d).clear();
    }

    private final void setUpTextSwitcher(final Context r100) {
        f();
        ObricOmniBlockLocalSearchBinding r101 = this.f390559c;
        if (r101 == null) goto L7;
        TextSwitcher r102 = r101.f386264j;
        if (r102 == null) goto L7;
        r102.removeAllViews();
    L7:
        ObricOmniBlockLocalSearchBinding r103 = this.f390559c;
        if (r103 == null) goto L13;
        TextSwitcher r104 = r103.f386264j;
        if (r104 == null) goto L14;
        r104.setFactory(new m(r100, this));
        return;
    L14:
        return;
    }

    public static void c(ObricOmniBlockLocalSearchBinding r100, boolean r101) {
        View r102 = r100.f386256b;
        if (r101 == false) goto L5;
        float r103 = 0.0f;
    L6:
        r102.setRotation(r103);
        return;
    L5:
        r103 = 90.0f;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v18, types: [java.util.ArrayList] */
    public final void a(ifa.f.C6260f r210, final Function1<? super String, Unit> r310) {
        Intrinsics.checkNotNullParameter(r210, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r310, "onItemClick");
        FLogger r100 = FLogger.f375446a;
        r100.d("LocalResultView", "bind");
        final ObricOmniBlockLocalSearchBinding r101 = this.f390559c;
        if (r101 != null) goto L5;
        return;
    L5:
        BlockContent r102 = r210.f489685b.getContent();
        if (r102 == null) goto L8;
        OSearchQueryResultBlock r103 = r102.getOSearchQueryResultBlock();
    L9:
        if (r103 != null) goto L12;
        r100.w("LocalResultView", "searchQueryResultBlock == null");
        e1.o(r101.f386255a);
        return;
    L12:
        String r104 = r103.oShownState;
        boolean r105 = true;
        if (r104 != null) goto L15;
    L18:
        boolean r106 = true;
    L19:
        if (r106 == false) goto L22;
        r100.w("LocalResultView", "no oShownState, is invalid data");
        e1.o(r101.f386255a);
        return;
    L22:
        e1.x(r101.f386255a);
        setShowLine(r210.f489686c);
        boolean r107 = r210.f489685b.isFinish();
        Boolean r110 = r103.oIsSubBlock;
        if (r110 == null) goto L25;
        boolean r111 = r110.booleanValue();
    L26:
        String r112 = r103.iconUrl;
        boolean r113 = v19.h.f552477a;
        if (v19.h.a(null) == false) goto L39;
        String r114 = r103.iconUrlDark;
        if (r114 != null) goto L31;
    L34:
        boolean r115 = true;
    L35:
        if (r115 == true) goto L39;
        r112 = r103.iconUrlDark;
        if (r112 != null) goto L42;
    L40:
        r112 = "";
    L42:
        if (r112.length() != 0) goto L44;
        boolean r116 = true;
    L45:
        if (r116 == false) goto L47;
        r101.f386261g.setImageResource(R.drawable.obric_ic_search_grap_sug_bar);
    L49:
        if (r107 == false) goto L54;
        b(r101, true);
        MessageLoading r108 = r101.f386263i;
        r108.f304832e.cancel();
        r108.f304830c = false;
        e1.o(r101.f386263i);
        e1.x(r101.f386268n);
        TextView r109 = r101.f386268n;
        String r117 = r103.summary;
        if (r117 != null) goto L53;
        r117 = "";
    L53:
        r109.setText(r117);
        d(false, r210.f489685b, r310);
        String r118 = "";
    L140:
        if (Intrinsics.areEqual(r103.oShownState, "2") == false) goto L142;
        TextView r119 = r101.f386268n;
        r119.setMaxLines(1);
        r119.setEllipsize(TextUtils.TruncateAt.END);
    L143:
        List<OSearchReference> r120 = r103.results;
        if (r120 != null) goto L146;
    L149:
        boolean r121 = true;
    L150:
        if (r121 == false) goto L152;
    L163:
        boolean r122 = false;
    L164:
        FLogger r123 = FLogger.f375446a;
        StringBuilder r124 = new StringBuilder("item count = ");
        List<OSearchReference> r125 = r103.results;
        if (r125 == null) goto L167;
        int r126 = r125.size();
    L168:
        r124.append(r126);
        r124.append(", shownState = ");
        r124.append(r103.oShownState);
        r124.append(", isFinish = ");
        r124.append(r107);
        r124.append(", isSubBlock = ");
        r124.append(r111);
        r123.d("LocalResultView", r124.toString());
        if (r122 == false) goto L208;
        e1.x(r101.f386256b);
        e(r101, !this.f390563g, false);
        Context r127 = r101.f386255a.getContext();
        String r128 = r127.getString(R.string.obric_double_quotation_marks);
        String r211 = r127.getString(R.string.obric_enumeration_comma);
        List<String> r129 = r103.queries;
        if (r129 == null) goto L185;
        ArrayList r130 = new ArrayList();
        Iterator<T> r131 = r129.iterator();
    L174:
        if (r131.hasNext() == false) goto L181;
        String r132 = (String) r131.next();
        if (r132 == null) goto L178;
        StringCompanionObject r133 = StringCompanionObject.INSTANCE;
        String r134 = String.format(r128, Arrays.copyOf(new Object[]{r132}, 1));
    L179:
        if (r134 == null) goto L174;
        r130.add(r134);
        goto L174
    L178:
        r134 = null;
        goto L179
    L181:
        String r135 = CollectionsKt.joinToString$default(r130, r211, null, null, 0, null, null, 62, null);
        if (r135 == null) goto L185;
        String r136 = r135;
    L186:
        r101.f386267m.setText(r136);
        if (r136.length() == 0) goto L190;
        r105 = false;
    L190:
        if (r105 == false) goto L192;
        e1.o(r101.f386267m);
    L193:
        RecyclerView.Adapter r137 = r101.f386262h.getAdapter();
        if ((r137 instanceof SearchLocalItemAdapter) == false) goto L196;
        SearchLocalItemAdapter r138 = (SearchLocalItemAdapter) r137;
    L197:
        if (r138 == null) goto L203;
        List<OSearchReference> r139 = r103.results;
        if (r139 == null) goto L201;
        List<OSearchReference> r140 = CollectionsKt.filterNotNull(r139);
    L202:
        r138.y2(r140, r111);
        goto L203
    L201:
        r140 = null;
    L203:
        e1.d(r101.f386265k, new n(this, r101, r310));
        View r141 = r101.f386259e;
        if (r111 == false) goto L206;
        int r142 = 0;
    L207:
        r141.setVisibility(r142);
    L222:
        if (r111 == false) goto L228;
        e1.x(r101.f386261g);
        r101.f386258d.getDelegate().a(ContextCompat.getColor(r101.f386255a.getContext(), R.color.base_3_overlay));
        RelativeLayout r143 = r101.f386255a;
        ViewGroup.LayoutParams r144 = r143.getLayoutParams();
        if (r144 == null) goto L227;
        ViewGroup.MarginLayoutParams r145 = (ViewGroup.MarginLayoutParams) r144;
        r145.leftMargin = i5.q();
        r145.rightMargin = i5.q();
        r143.setLayoutParams(r145);
        LinearLayout r146 = r101.f386265k;
        r146.setPadding(0, r146.getPaddingTop(), i5.c(), r146.getPaddingBottom());
        we8.a.b(r101.f386268n, i5.m(), false, null, null, 12);
        TextView r147 = r101.f386267m;
        r147.setPadding(i5.h(), r147.getPaddingTop(), i5.h(), r147.getPaddingBottom());
        RelativeLayout r148 = r101.f386260f;
        r148.setPadding(r148.getPaddingLeft(), r148.getPaddingTop(), r148.getPaddingRight(), i5.v0());
    L231:
        we8.a.b(r101.f386267m, i5.o(), false, null, null, 12);
        return;
    L227:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L228:
        e1.o(r101.f386261g);
        r101.f386258d.getDelegate().a(0);
        RelativeLayout r149 = r101.f386255a;
        ViewGroup.LayoutParams r150 = r149.getLayoutParams();
        if (r150 == null) goto L234;
        ViewGroup.MarginLayoutParams r151 = (ViewGroup.MarginLayoutParams) r150;
        r151.leftMargin = 0;
        r151.rightMargin = 0;
        r151.topMargin = i5.r0();
        r151.bottomMargin = i5.r0();
        r149.setLayoutParams(r151);
        LinearLayout r152 = r101.f386265k;
        r152.setPadding(i5.q(), r152.getPaddingTop(), i5.q(), r152.getPaddingBottom());
        we8.a.b(r101.f386268n, i5.t(), false, null, null, 12);
        TextView r153 = r101.f386267m;
        r153.setPadding(i5.q(), r153.getPaddingTop(), i5.q(), r153.getPaddingBottom());
        RelativeLayout r154 = r101.f386260f;
        r154.setPadding(r154.getPaddingLeft(), r154.getPaddingTop(), r154.getPaddingRight(), 0);
        goto L231
    L234:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L206:
        r142 = 4;
        goto L207
    L196:
        r138 = null;
        goto L197
    L192:
        e1.x(r101.f386267m);
    L185:
        r136 = r118;
        goto L186
    L208:
        ValueAnimator r155 = this.f390562f;
        if (r155 == null) goto L211;
        r155.cancel();
    L211:
        this.f390562f = null;
        c(r101, true);
        e1.o(r101.f386256b);
        e1.o(r101.f386260f);
        r101.f386265k.setOnClickListener(null);
        String r156 = r103.oJumpUrl;
        if (r156 != null) goto L214;
        final String r157 = r118;
    L216:
        if (Intrinsics.areEqual(r103.oShownState, "1") == true) goto L218;
    L220:
        e1.o(r101.f386256b);
        r101.f386265k.setOnClickListener(null);
        goto L222
    L218:
        if (com.larus.utils.o0.d(r157) == false) goto L220;
        e1.x(r101.f386256b);
        e1.d(r101.f386265k, new o(r310, this, r101, r157));
        goto L222
    L214:
        r157 = r156;
        goto L216
    L167:
        r126 = 0;
        goto L168
    L152:
        if (Intrinsics.areEqual(r103.oShownState, "2") == true) goto L161;
        String r158 = r103.oShownState;
        if (r158 != null) goto L156;
    L159:
        boolean r159 = true;
    L160:
        if (r159 == false) goto L163;
    L156:
        if (r158.length() == 0) goto L159;
        r159 = false;
    L161:
        if (r107 == false) goto L163;
        r122 = true;
        goto L164
    L146:
        if (r120.isEmpty() == true) goto L149;
        r121 = false;
        goto L150
    L142:
        TextView r160 = r101.f386268n;
        r160.setMaxLines(2);
        r160.setEllipsize(TextUtils.TruncateAt.END);
        goto L143
    L54:
        Intrinsics.checkNotNullParameter(r103, "<this>");
        String r161 = r103.oClickAction;
        r118 = "";
        if (r161 != null) goto L57;
    L59:
        boolean r162 = false;
    L60:
        if (r162 == true) goto L62;
    L64:
        boolean r163 = false;
    L65:
        if (r163 == false) goto L67;
        b(r101, true);
        MessageLoading r164 = r101.f386263i;
        r164.f304832e.cancel();
        r164.f304830c = false;
        e1.o(r101.f386263i);
        e1.o(r101.f386268n);
        d(true, r210.f489685b, r310);
        goto L140
    L67:
        Boolean r165 = r103.oHasNotAnimation;
        if (r165 == null) goto L70;
        boolean r166 = r165.booleanValue();
    L71:
        if (r166 == false) goto L73;
    L135:
        r100.i("LocalResultView", "oHasNotAnimation = true");
        b(r101, true);
        MessageLoading r167 = r101.f386263i;
        r167.f304832e.cancel();
        r167.f304830c = false;
        e1.o(r101.f386263i);
        e1.x(r101.f386268n);
        TextView r168 = r101.f386268n;
        String r169 = r103.summary;
        if (r169 != null) goto L138;
        r169 = r118;
    L138:
        r168.setText(r169);
        d(false, r210.f489685b, r310);
        goto L140
    L73:
        if (r210.f489687d == false) goto L135;
        List<String> r170 = r103.queries;
        if (r170 == null) goto L88;
        List r171 = CollectionsKt.filterNotNull(r170);
        if (r171 == null) goto L88;
        List r172 = new ArrayList();
        Iterator r173 = r171.iterator();
    L81:
        if (r173.hasNext() == false) goto L89;
        String r212 = (String) r173.next();
        String r174 = r103.summary;
        if (r174 == null) goto L85;
        String r175 = StringsKt.replace$default(r174, "%s", r212, false, 4, null);
    L86:
        if (r175 == null) goto L81;
        r172.add(r175);
        goto L81
    L85:
        r175 = null;
    L89:
        if (r172 != 0) goto L91;
    L94:
        boolean r176 = true;
    L95:
        if (r176 == false) goto L103;
        String r177 = r103.summary;
        if (r177 == null) goto L99;
        String r178 = StringsKt.replace$default(r177, "\n", "", false, 4, null);
    L100:
        if (r178 != null) goto L102;
        r178 = r118;
    L102:
        r172 = CollectionsKt.listOf(r178);
        goto L103
    L99:
        r178 = null;
    L103:
        if (r111 == false) goto L130;
        MessageLoading r179 = r101.f386263i;
        r179.f304832e.cancel();
        r179.f304830c = false;
        e1.o(r101.f386263i);
        eca.c r180 = this.f390561e;
        if (r180 == null) goto L107;
        List<String> r181 = r180.f472160b;
    L108:
        if (r181 == null) goto L116;
        if (r180 == null) goto L111;
        List<String> r182 = r180.f472160b;
    L113:
        if (Intrinsics.areEqual(r172, r182) == true) goto L116;
        b(r101, false);
        FLogger.f375446a.i("LocalResultView", "is change to " + r172);
        goto L116
    L111:
        r182 = null;
    L116:
        if (this.f390561e != null) goto L121;
        setUpTextSwitcher(r101.f386255a.getContext());
        eca.c r183 = new eca.c(r101.f386264j, r172);
        this.f390561e = r183;
        r183.a(r101.f386255a.getContext());
        eca.c r184 = this.f390561e;
        if (r184 == null) goto L120;
        r184.c();
    L120:
        boolean r185 = true;
    L122:
        if (r185 == false) goto L127;
        Iterator r186 = ((ArrayList) this.f390560d).iterator();
    L125:
        if (r186.hasNext() == false) goto L127;
        ShimmerTextView r187 = (ShimmerTextView) r186.next();
        int r188 = ShimmerTextView.f304901h;
        r187.z(false);
    L127:
        TextSwitcher r189 = r101.f386264j;
        if (r189 == null) goto L131;
        r189.setVisibility(0);
    L131:
        e1.o(r101.f386268n);
        TextView r190 = r101.f386268n;
        String r191 = r103.summary;
        if (r191 != null) goto L134;
        r191 = r118;
    L134:
        r190.setText(r191);
        d(false, r210.f489685b, r310);
        goto L140
    L121:
        r185 = false;
        goto L122
    L107:
        r181 = null;
        goto L108
    L130:
        b(r101, true);
        e1.x(r101.f386263i);
        r101.f386263i.setLoadingText(CollectionsKt.joinToString$default(r172, String.valueOf(r101.f386255a.getContext().getString(R.string.obric_enumeration_comma)), null, null, 0, null, null, 62, null));
        r101.f386263i.c();
        goto L131
    L91:
        if (r172.isEmpty() == true) goto L94;
        r176 = false;
    L88:
        r172 = 0;
        goto L89
    L70:
        r166 = false;
        goto L71
    L62:
        if (Intrinsics.areEqual(r103.oShownState, "1") == false) goto L64;
        r163 = true;
        goto L65
    L57:
        if (StringsKt.contains$default(r161, "finish_current_page", false, 2, null) != true) goto L59;
        r162 = true;
        goto L60
    L47:
        com.obric.assistant.card.utils.h.a(r101.f386261g, r112, "obric_chat.cards");
        goto L49
    L44:
        r116 = false;
        goto L45
    L31:
        if (r114.length() == 0) goto L34;
        r115 = false;
    L39:
        if (r112 != null) goto L42;
    L25:
        r111 = false;
        goto L26
    L15:
        if (r104.length() == 0) goto L18;
        r106 = false;
        goto L19
    L8:
        r103 = null;
        goto L9
    }

    public final void b(ObricOmniBlockLocalSearchBinding r100, boolean r101) {
        eca.c r102 = this.f390561e;
        if (r102 == null) goto L5;
        r102.b();
    L5:
        this.f390561e = null;
        f();
        if (r101 == false) goto L12;
        if (r100 == null) goto L13;
        TextSwitcher r103 = r100.f386264j;
        if (r103 == null) goto L14;
        r103.setVisibility(8);
        return;
    L14:
        return;
    L13:
        return;
    }

    public LocalSearchResultView(Context r210, AttributeSet r211, int r212) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r210, r211, r212);
        ArrayList r100 = new ArrayList();
        this.f390560d = r100;
        com.larus.bmhome.chat.api.e0 r101 = AuthModelDelegate.f297134b.e().getValue();
        if (r101 == null) goto L9;
        LaunchInfo r102 = r101.f297186a;
        if (r102 == null) goto L9;
        DeepThinkingConfig r103 = r102.S();
        if (r103 == null) goto L9;
        boolean r104 = r103.b();
    L10:
        this.f390563g = r104;
        View r105 = LayoutInflater.from(r210).inflate(R.layout.obric_omni_block_local_search, this, false);
        addView(r105);
        int r106 = R.id.arrow;
        View r107 = ViewBindings.findChildViewById(r105, R.id.arrow);
        if (r107 == null) goto L41;
        r106 = R.id.askUserContainer;
        ShimmerLinearLayout r108 = (ShimmerLinearLayout) ViewBindings.findChildViewById(r105, R.id.askUserContainer);
        if (r108 == null) goto L41;
        r106 = R.id.container;
        RoundRelativeLayout r110 = (RoundRelativeLayout) ViewBindings.findChildViewById(r105, R.id.container);
        if (r110 == null) goto L41;
        r106 = R.id.divider;
        View r111 = ViewBindings.findChildViewById(r105, R.id.divider);
        if (r111 == null) goto L41;
        r106 = R.id.dropdown_layout;
        RelativeLayout r112 = (RelativeLayout) ViewBindings.findChildViewById(r105, R.id.dropdown_layout);
        if (r112 == null) goto L41;
        r106 = R.id.icon;
        SimpleDraweeView r113 = (SimpleDraweeView) ViewBindings.findChildViewById(r105, R.id.icon);
        if (r113 == null) goto L41;
        r106 = R.id.item_list;
        RecyclerView r114 = (RecyclerView) ViewBindings.findChildViewById(r105, R.id.item_list);
        if (r114 == null) goto L41;
        r106 = R.id.message_loading;
        MessageLoading r115 = (MessageLoading) ViewBindings.findChildViewById(r105, R.id.message_loading);
        if (r115 == null) goto L41;
        r106 = R.id.rightIcon;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r105, R.id.rightIcon)) == null) goto L41;
        r106 = R.id.search_reference_switcher;
        TextSwitcher r116 = (TextSwitcher) ViewBindings.findChildViewById(r105, R.id.search_reference_switcher);
        if (r116 == null) goto L41;
        r106 = R.id.title_layout;
        LinearLayout r117 = (LinearLayout) ViewBindings.findChildViewById(r105, R.id.title_layout);
        if (r117 == null) goto L41;
        r106 = R.id.tvAskUserText;
        TextView r118 = (TextView) ViewBindings.findChildViewById(r105, R.id.tvAskUserText);
        if (r118 == null) goto L41;
        r106 = R.id.tv_queries;
        TextView r213 = (TextView) ViewBindings.findChildViewById(r105, R.id.tv_queries);
        if (r213 == null) goto L41;
        r106 = R.id.tv_title;
        TextView r214 = (TextView) ViewBindings.findChildViewById(r105, R.id.tv_title);
        if (r214 == null) goto L41;
        RelativeLayout r109 = (RelativeLayout) r105;
        this.f390559c = new ObricOmniBlockLocalSearchBinding(r109, r107, r108, r110, r111, r112, r113, r114, r115, r116, r117, r118, r213, r214);
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        r114.setLayoutManager(new LinearLayoutManager(r109.getContext(), 1, false));
        r114.setAdapter(new SearchLocalItemAdapter());
        r100.clear();
        this.f390561e = null;
        int r119 = com.larus.utils.j0.f375426a;
        setPadding(com.larus.utils.j0.b(R.dimen.dp_32), 0, 0, com.larus.utils.j0.b(R.dimen.dp_8));
        return;
    L41:
        throw new NullPointerException("Missing required view with ID: ".concat(r105.getResources().getResourceName(r106)));
    L9:
        r104 = true;
        goto L10
    }

    public final void d(boolean r100, final Block r101, final Function1<? super String, Unit> r102) {
        if (r100 == false) goto L44;
        BlockContent r103 = r101.getContent();
        if (r103 == null) goto L6;
        final OSearchQueryResultBlock r104 = r103.getOSearchQueryResultBlock();
    L7:
        ObricOmniBlockLocalSearchBinding r105 = this.f390559c;
        if (r105 == null) goto L12;
        ShimmerLinearLayout r106 = r105.f386257c;
        if (r106 == null) goto L12;
        e1.x(r106);
    L12:
        ObricOmniBlockLocalSearchBinding r107 = this.f390559c;
        if (r107 == null) goto L22;
        TextView r108 = r107.f386266l;
        if (r108 == null) goto L22;
        if (r104 == null) goto L18;
        String r109 = r104.summary;
    L19:
        if (r109 != null) goto L21;
        r109 = "";
    L21:
        r108.setText(r109);
        goto L22
    L18:
        r109 = null;
    L22:
        ObricOmniBlockLocalSearchBinding r110 = this.f390559c;
        if (r110 == null) goto L27;
        ShimmerLinearLayout r111 = r110.f386257c;
        if (r111 == null) goto L27;
        e1.d(r111, new p(r102, this, r104, r101));
    L27:
        ObricOmniBlockLocalSearchBinding r112 = this.f390559c;
        if (r112 == null) goto L32;
        ShimmerLinearLayout r113 = r112.f386257c;
        if (r113 == null) goto L32;
        r113.b();
    L32:
        boolean r114 = v19.h.f552477a;
        if (v19.h.a(null) == false) goto L39;
        ObricOmniBlockLocalSearchBinding r115 = this.f390559c;
        if (r115 == null) goto L55;
        ShimmerLinearLayout r116 = r115.f386257c;
        if (r116 == null) goto L56;
        r116.setShimmerColor(ContextCompat.getColor(getContext(), R.color.base_3_overlay));
        return;
    L56:
        return;
    L55:
        return;
    L39:
        ObricOmniBlockLocalSearchBinding r117 = this.f390559c;
        if (r117 == null) goto L58;
        ShimmerLinearLayout r118 = r117.f386257c;
        if (r118 == null) goto L59;
        r118.setShimmerColor(ContextCompat.getColor(getContext(), R.color.base_2_overlay));
        return;
    L59:
        return;
    L58:
        return;
    L6:
        r104 = null;
        goto L7
    L44:
        ObricOmniBlockLocalSearchBinding r119 = this.f390559c;
        if (r119 == null) goto L49;
        ShimmerLinearLayout r120 = r119.f386257c;
        if (r120 == null) goto L49;
        r120.a();
    L49:
        ObricOmniBlockLocalSearchBinding r121 = this.f390559c;
        if (r121 == null) goto L61;
        ShimmerLinearLayout r122 = r121.f386257c;
        if (r122 == null) goto L62;
        e1.o(r122);
        return;
    L62:
        return;
    }

    public final void e(final ObricOmniBlockLocalSearchBinding r100, boolean r101, boolean r102) {
        FLogger.f375446a.d("LocalResultView", "setDropdownExpandState: expand = " + r101 + ", withArrowAnimation = " + r102);
        if (r101 == false) goto L5;
        e1.x(r100.f386260f);
    L6:
        boolean r103 = !r101;
        ValueAnimator r104 = this.f390562f;
        if (r104 == null) goto L9;
        r104.cancel();
        this.f390562f = null;
    L9:
        if (r102 == false) goto L15;
        float r105 = 90.0f;
        float r106 = 0.0f;
        if (r103 == true) goto L14;
        r105 = 0.0f;
        r106 = 90.0f;
    L14:
        ValueAnimator r107 = ValueAnimator.ofFloat(new float[]{r105, r106});
        this.f390562f = r107;
        r107.setDuration(150);
        r107.addUpdateListener(new q(r100));
        r107.addListener(new s(this, r100, r103));
        r107.start();
        return;
    L15:
        c(r100, r103);
        return;
    L5:
        e1.o(r100.f386260f);
        goto L6
    }

    public /* synthetic */ LocalSearchResultView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
