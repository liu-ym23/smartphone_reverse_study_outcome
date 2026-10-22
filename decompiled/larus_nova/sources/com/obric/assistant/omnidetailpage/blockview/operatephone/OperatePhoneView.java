package com.obric.assistant.omnidetailpage.blockview.operatephone;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.larus.bmhome.chat.layout.widget.ShimmerLinearLayout;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.OOmniDetailGUIProcessBlock;
import com.larus.nova.R;
import com.obric.assistant.card.databinding.ObricOmniBlockTaskOperatePhoneBinding;
import com.obric.assistant.omnidetailpage.blockview.base.OmniDetailVerticalLineFrameLayout;
import com.obric.assistant.omnidetailpage.util.OmniPageUtil;
import com.ss.android.lark.utils.statistics.PerfLog;
import hfa.c;
import hfa.d;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.h;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0019\u001a\u00020\u0015H\u0002JN\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00112\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00180\u001f2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00150\u00142\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00150\u0014J\b\u0010 \u001a\u00020\u0011H\u0002J\b\u0010!\u001a\u00020\u0015H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/assistant/omnidetailpage/blockview/operatephone/OperatePhoneView;", "Lcom/obric/assistant/omnidetailpage/blockview/base/OmniDetailVerticalLineFrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/obric/assistant/card/databinding/ObricOmniBlockTaskOperatePhoneBinding;", "adapter", "Lcom/obric/assistant/omnidetailpage/blockview/operatephone/OperatePhoneInnerAdapter;", "block", "Lcom/larus/im/bean/message/block/Block;", "isExpanded", "", "forceExpand", "onExpandChange", "Lkotlin/Function1;", "", "shouldShowAnim", "onItemClick", "", "updateExpandState", "bind", MapController.ITEM_LAYER_TAG, "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem$OperatePhone;", "expanded", "instructionTypeProvider", "Lkotlin/Function0;", "shouldShowProgress", "setProgressShimmerAnimStatus", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OperatePhoneView extends OmniDetailVerticalLineFrameLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f390687k = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ObricOmniBlockTaskOperatePhoneBinding f390688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OperatePhoneInnerAdapter f390689d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Block f390690e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f390691f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f390692g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f390693h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f390694i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function1<? super String, Unit> f390695j;

    public static final class a {
    }

    static {
    }

    public OperatePhoneView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OperatePhoneView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        ObricOmniBlockTaskOperatePhoneBinding r100 = this.f390688c;
        if (r100 == null) goto L13;
        boolean r101 = h.f552477a;
        if (h.a(null) == false) goto L7;
        r100.f386298h.setShimmerColor(ContextCompat.getColor(getContext(), R.color.base_3_overlay));
    L9:
        if (this.f390694i == false) goto L11;
        r100.f386298h.b();
        return;
    L11:
        r100.f386298h.a();
        return;
    L7:
        r100.f386298h.setShimmerColor(ContextCompat.getColor(getContext(), R.color.base_2_overlay));
        goto L9
    }

    public final void b() {
        ObricOmniBlockTaskOperatePhoneBinding r100 = this.f390688c;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f390691f == false) goto L7;
    L10:
        r100.f386295e.setRotation(90.0f);
        r100.f386294d.setVisibility(0);
    L11:
        ImageView r101 = r100.f386295e;
        boolean r102 = true;
        if ((!this.f390692g) == false) goto L14;
        int r103 = 0;
    L15:
        r101.setVisibility(r103);
        ConcurrentHashMap<String, Pair<Drawable, String>> r104 = OmniPageUtil.f390862a;
        Block r105 = this.f390690e;
        if (r105 == null) goto L22;
        BlockContent r106 = r105.getContent();
        if (r106 == null) goto L22;
        OOmniDetailGUIProcessBlock r107 = r106.getOOmniDetailGUIBlock();
        if (r107 == null) goto L22;
        String r108 = r107.getNowPackageName();
    L23:
        if (r108 != null) goto L26;
        r108 = "";
    L26:
        if (OmniPageUtil.b(r108, getContext().getPackageManager(), getContext(), false).getFirst() != null) goto L44;
        Block r109 = this.f390690e;
        if (r109 == null) goto L41;
        BlockContent r110 = r109.getContent();
        if (r110 == null) goto L41;
        OOmniDetailGUIProcessBlock r111 = r110.getOOmniDetailGUIBlock();
        if (r111 == null) goto L41;
        String r112 = r111.getNowProcessContent();
        if (r112 == null) goto L41;
        if (r112.length() <= 0) goto L38;
        boolean r113 = true;
    L39:
        if (r113 != true) goto L41;
        boolean r114 = true;
    L42:
        if (r114 == true) goto L44;
    L46:
        boolean r115 = false;
    L47:
        if (r115 == false) goto L49;
        r100.f386298h.setVisibility(0);
        a();
    L50:
        Block r116 = this.f390690e;
        if (r116 == null) goto L64;
        BlockContent r117 = r116.getContent();
        if (r117 == null) goto L64;
        OOmniDetailGUIProcessBlock r118 = r117.getOOmniDetailGUIBlock();
        if (r118 == null) goto L64;
        String r119 = r118.getNowPackageName();
        if (r119 == null) goto L64;
        if (r119.length() <= 0) goto L61;
        boolean r120 = true;
    L62:
        if (r120 != true) goto L64;
        boolean r121 = true;
    L65:
        if (r121 == true) goto L86;
        Block r122 = this.f390690e;
        if (r122 == null) goto L80;
        BlockContent r123 = r122.getContent();
        if (r123 == null) goto L80;
        OOmniDetailGUIProcessBlock r124 = r123.getOOmniDetailGUIBlock();
        if (r124 == null) goto L80;
        String r125 = r124.getNowProcessContent();
        if (r125 == null) goto L80;
        if (r125.length() <= 0) goto L77;
        boolean r126 = true;
    L78:
        if (r126 != true) goto L80;
    L81:
        if (r102 == true) goto L86;
        if (this.f390691f == true) goto L86;
        LinearLayout r127 = r100.f386292b;
        ViewGroup.LayoutParams r128 = r127.getLayoutParams();
        r128.width = -2;
        r127.setLayoutParams(r128);
        r100.f386293c.setVisibility(8);
        return;
    L77:
        r126 = false;
    L80:
        r102 = false;
    L86:
        LinearLayout r129 = r100.f386292b;
        ViewGroup.LayoutParams r130 = r129.getLayoutParams();
        r130.width = -1;
        r129.setLayoutParams(r130);
        r100.f386293c.setVisibility(0);
        return;
    L61:
        r120 = false;
    L64:
        r121 = false;
        goto L65
    L49:
        r100.f386298h.setVisibility(8);
        r100.f386298h.a();
        goto L50
    L38:
        r113 = false;
    L41:
        r114 = false;
    L44:
        if (this.f390691f == true) goto L46;
        r115 = true;
    L22:
        r108 = null;
        goto L23
    L14:
        r103 = 8;
        goto L15
    L7:
        if (this.f390692g == true) goto L10;
        r100.f386295e.setRotation(0.0f);
        r100.f386294d.setVisibility(8);
        goto L11
    }

    /* JADX WARN: Type inference failed for: r5v10, types: [hfa.c] */
    public OperatePhoneView(Context r110, AttributeSet r111, int r210) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r210);
        View r100 = LayoutInflater.from(r110).inflate(R.layout.obric_omni_block_task_operate_phone, this, false);
        addView(r100);
        int r101 = R.id.bodyContainer;
        if (((LinearLayout) ViewBindings.findChildViewById(r100, R.id.bodyContainer)) == null) goto L27;
        r101 = R.id.cardContainer;
        LinearLayout r102 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.cardContainer);
        if (r102 == null) goto L27;
        r101 = R.id.divider;
        View r103 = ViewBindings.findChildViewById(r100, R.id.divider);
        if (r103 == null) goto L27;
        r101 = R.id.innerRecyclerView;
        RecyclerView r104 = (RecyclerView) ViewBindings.findChildViewById(r100, R.id.innerRecyclerView);
        if (r104 == null) goto L27;
        r101 = R.id.ivArrow;
        ImageView r112 = (ImageView) ViewBindings.findChildViewById(r100, R.id.ivArrow);
        if (r112 == null) goto L27;
        r101 = R.id.layoutCompletedHeader;
        LinearLayout r113 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.layoutCompletedHeader);
        if (r113 == null) goto L27;
        r101 = R.id.leftIcon;
        AppCompatImageView r114 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.leftIcon);
        if (r114 == null) goto L27;
        r101 = R.id.progressContainer;
        ShimmerLinearLayout r115 = (ShimmerLinearLayout) ViewBindings.findChildViewById(r100, R.id.progressContainer);
        if (r115 == null) goto L27;
        r101 = R.id.rightIcon;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.rightIcon)) == null) goto L27;
        r101 = R.id.tvProcessContent;
        CustomMarkdownTextView r116 = (CustomMarkdownTextView) ViewBindings.findChildViewById(r100, R.id.tvProcessContent);
        if (r116 == null) goto L27;
        r101 = R.id.tvTitle;
        TextView r117 = (TextView) ViewBindings.findChildViewById(r100, R.id.tvTitle);
        if (r117 == null) goto L27;
        this.f390688c = new ObricOmniBlockTaskOperatePhoneBinding((LinearLayout) r100, r102, r103, r104, r112, r113, r114, r115, r116, r117);
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        OperatePhoneInnerAdapter r105 = new OperatePhoneInnerAdapter(new c(this), 5);
        this.f390689d = r105;
        r104.setLayoutManager(new LinearLayoutManager(r110));
        r104.setAdapter(r105);
        b();
        r113.setOnClickListener(new d(this));
        return;
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public /* synthetic */ OperatePhoneView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
