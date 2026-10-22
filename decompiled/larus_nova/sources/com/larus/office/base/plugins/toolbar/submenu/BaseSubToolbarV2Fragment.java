package com.larus.office.base.plugins.toolbar.submenu;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ee.docsdk.impl.utils.keyboard.KeyboardHeightObserver;
import com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProvider;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.office.base.plugins.toolbar.BaseToolbarV2PanelViewModel;
import com.larus.office.base.plugins.toolbar.model.Item;
import com.larus.office.base.plugins.toolbar.model.ItemId;
import com.larus.office.base.plugins.toolbar.model.a;
import com.larus.office.base.plugins.toolbar.view.RecyclerViewScrollBottomListener;
import com.larus.utils.logger.FLogger;
import com.lynx.serval.svg.SVGRenderEngine;
import java.io.Serializable;
import kn9.h;
import kn9.i;
import kn9.j;
import kn9.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 Z*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u00032\u00020\u0004:\u0001ZB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020&H\u0016J&\u0010*\u001a\u0004\u0018\u00010\b2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u00101\u001a\u00020&H\u0004J\n\u00102\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u00103\u001a\u0004\u0018\u00010\u0010H\u0004J\u0010\u00104\u001a\u00020&2\u0006\u00105\u001a\u00020!H\u0004J\n\u00106\u001a\u0004\u0018\u00010\u0010H$J\u0010\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u000008H$J\b\u00109\u001a\u00020\u0018H\u0004J'\u0010:\u001a\u00020&\"\u0004\b\u0001\u0010;2\b\u00105\u001a\u0004\u0018\u00010!2\b\u0010<\u001a\u0004\u0018\u0001H;H\u0014¢\u0006\u0002\u0010=J$\u0010:\u001a\u00020&2\b\u0010>\u001a\u0004\u0018\u00010?2\b\u0010<\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020\u0018H\u0014J\b\u0010A\u001a\u00020&H\u0002J\b\u0010B\u001a\u00020\u001bH\u0002J\u0010\u0010C\u001a\u00020\u00182\u0006\u0010D\u001a\u00020\u0018H\u0004J\u0012\u0010E\u001a\u00020&2\b\u0010F\u001a\u0004\u0018\u00010GH\u0002J\u001f\u0010H\u001a\u00020&2\u0010\u0010I\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010JH\u0004¢\u0006\u0002\u0010KJ!\u0010L\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010J2\b\u0010M\u001a\u0004\u0018\u00010\u0002H\u0004¢\u0006\u0002\u0010NJ\u0014\u0010O\u001a\u0004\u0018\u00010P2\b\u0010M\u001a\u0004\u0018\u00010\u0002H\u0004J\b\u0010Q\u001a\u00020&H\u0002J\b\u0010R\u001a\u00020&H\u0002J\b\u0010S\u001a\u00020\u0018H\u0002J \u0010T\u001a\u00020&2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u00182\u0006\u0010X\u001a\u00020\u0018H\u0016J\b\u0010Y\u001a\u00020&H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lcom/larus/office/base/plugins/toolbar/submenu/BaseSubToolbarV2Fragment;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/larus/office/base/plugins/toolbar/model/Toolbar;", "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/ee/docsdk/impl/utils/keyboard/KeyboardHeightObserver;", "<init>", "()V", "viewParent", "Landroid/view/View;", "itemRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "getItemRecycler", "()Landroidx/recyclerview/widget/RecyclerView;", "setItemRecycler", "(Landroidx/recyclerview/widget/RecyclerView;)V", "subToolbarAdapter", "Lcom/larus/office/base/plugins/toolbar/submenu/BaseSubToolbarAdapter;", "getSubToolbarAdapter", "()Lcom/larus/office/base/plugins/toolbar/submenu/BaseSubToolbarAdapter;", "setSubToolbarAdapter", "(Lcom/larus/office/base/plugins/toolbar/submenu/BaseSubToolbarAdapter;)V", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "currOffsetX", "", "width", "posChange", "", "getPosChange", "()Z", "setPosChange", "(Z)V", "parentItemV2", "Lcom/larus/office/base/plugins/toolbar/model/Item;", "lastChildrenCount", "childrenCountChange", "isOverScreenWidth", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "initItemRecycler", "getLayoutManager", "getAdapter", "onItemClick", "itemV2", "instantiateAdapter", "getToolbarV2PanelViewModel", "Lcom/larus/office/base/plugins/toolbar/BaseToolbarV2PanelViewModel;", "getRecyclerOrientation", "processOnItemClick", "V", "value", "(Lcom/larus/office/base/plugins/toolbar/model/Item;Ljava/lang/Object;)V", "id", "", "level", "observerRect", "isCurrentSubToolbar", "suggestionWidth", "screenWidth", "adjustPosition", SVGRenderEngine.RECT, "Landroid/graphics/Rect;", "onToolbarUpdate", "items", "", "([Lcom/larus/office/base/plugins/toolbar/model/Item;)V", "findChildrenItemsById", "toolbarV2", "(Lcom/larus/office/base/plugins/toolbar/model/Toolbar;)[Lcom/larus/office/base/plugins/toolbar/model/Item;", "findChildrenById", "Lcom/larus/office/base/plugins/toolbar/model/Item$Children;", "scrollToPosition", "initPos", "findLastSelectedPos", "onKeyboardHeightChanged", "khp", "Lcom/bytedance/ee/docsdk/impl/utils/keyboard/provider/KeyboardHeightProvider;", "keyboardHeight", "orientation", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseSubToolbarV2Fragment<T extends com.larus.office.base.plugins.toolbar.model.a> extends Fragment implements KeyboardHeightObserver {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f360942n = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f360943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RecyclerView f360944e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BaseSubToolbarAdapter f360945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayoutManager f360946g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f360947h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f360948i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f360949j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Item f360950k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f360951l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f360952m;

    public static final class a {
    }

    public abstract BaseToolbarV2PanelViewModel<T> V90();

    public abstract DocSubToolbarAdapter W90();

    @Override // com.bytedance.ee.docsdk.impl.utils.keyboard.KeyboardHeightObserver
    public final void onKeyboardHeightChanged(KeyboardHeightProvider r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "khp");
    }

    static {
        f360942n = c7.b(9);
    }

    public BaseSubToolbarV2Fragment() {
        this.f360947h = f360942n;
        this.f360951l = -1;
    }

    public final boolean X90() {
        Item r100 = V90().getExpandedSubToolbar().getValue();
        if (this.f360950k == null) goto L11;
        if (r100 == null) goto L11;
        ItemId r101 = r100.id();
        Item r102 = this.f360950k;
        if (r102 == null) goto L8;
        ItemId r103 = r102.id();
    L9:
        if (r101 != r103) goto L11;
        return true;
    L8:
        r103 = null;
    L11:
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        KeyboardHeightProvider.Factory.get(getActivity()).removeKeyboardHeightObserver(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        RecyclerView r100 = this.f360944e;
        if (r100 == null) goto L6;
        r100.postDelayed(new h(this), 300);
        return;
    }

    public final void S90(Rect r110) {
        if (X90() == true) goto L5;
        return;
    L5:
        RecyclerView r100 = this.f360944e;
        int r101 = 0;
        if (r100 == null) goto L9;
        r100.measure(0, 0);
    L9:
        if (r110 != null) goto L11;
    L13:
        boolean r102 = false;
    L14:
        if (r102 == false) goto L79;
        RecyclerView r103 = this.f360944e;
        if (r103 != null) goto L18;
    L20:
        boolean r104 = false;
    L21:
        if (r104 == true) goto L25;
        RecyclerView r105 = this.f360944e;
        if (r105 == null) goto L25;
        r105.setVisibility(0);
    L25:
        if (r110 == null) goto L27;
        int r111 = r110.centerX();
    L28:
        FLogger r106 = FLogger.f375446a;
        r106.i("BaseSubToolbarV2Fragment", "new x: " + r111 + ", old x:" + this.f360947h);
        if (r111 == this.f360947h) goto L31;
    L32:
        this.f360952m = false;
        this.f360947h = r111;
        this.f360949j = true;
        if (getView() == null) goto L85;
        RecyclerView r112 = this.f360944e;
        if (r112 == null) goto L38;
        int r113 = r112.getMeasuredWidth();
    L39:
        r106.i("BaseSubToolbarV2Fragment", "width=> currentWidth");
        if (r113 != 0) goto L42;
        return;
    L42:
        if (this.f360948i == r113) goto L44;
    L46:
        RecyclerView r107 = this.f360944e;
        if (r107 == null) goto L49;
        r107.post(new k(this));
    L49:
        this.f360949j = false;
        this.f360948i = r113;
        int r114 = UIUtils.getScreenWidth(AppHost.f326268a.getApplication());
        int r108 = this.f360948i;
        int r109 = f360942n;
        int r115 = r114 - (r109 * 2);
        if (r108 < r115) goto L65;
        r106.d("BaseSubToolbarV2Fragment", "suggestionWidth suggestionWidth");
        if (r115 > 0) goto L54;
        return;
    L54:
        if (r115 >= this.f360948i) goto L83;
        RecyclerView r116 = this.f360944e;
        if (r116 == null) goto L58;
        ViewGroup.LayoutParams r117 = r116.getLayoutParams();
    L59:
        if (r117 == null) goto L64;
        r117.width = r115;
        RecyclerView r118 = this.f360944e;
        if (r118 == null) goto L63;
        r118.requestLayout();
    L63:
        this.f360948i = r117.width;
    L64:
        r106.i("BaseSubToolbarV2Fragment", "width:" + this.f360948i + ", set suggestionWidth: " + r115);
        goto L65
    L58:
        r117 = null;
        goto L59
    L83:
        return;
    L65:
        int r119 = this.f360947h;
        int r120 = this.f360948i;
        int r121 = r120 / 2;
        int r122 = r119 - r121;
        int r123 = r121 + r119;
        if (r122 >= r109) goto L68;
    L70:
        if (r122 >= r109) goto L73;
    L75:
        r106.i("BaseSubToolbarV2Fragment", "width:" + this.f360948i + ", posX:" + this.f360947h + ", paddingStart:" + r101);
        View r124 = this.f360943d;
        if (r124 == null) goto L84;
        r124.setPadding(r101, r124.getPaddingTop(), r124.getPaddingRight(), r124.getPaddingBottom());
        return;
    L84:
        return;
    L73:
        if (r123 <= (r114 - r109)) goto L75;
        r101 = r114 - r120;
        goto L75
    L68:
        if (r123 > (r114 - r109)) goto L70;
        r101 = r122 - r109;
        goto L75
    L44:
        if (this.f360949j == true) goto L46;
        return;
    L38:
        r113 = 0;
        goto L39
    L85:
        return;
    L31:
        if (this.f360952m == true) goto L32;
        return;
    L27:
        r111 = 0;
        goto L28
    L18:
        if (r103.getVisibility() != 0) goto L20;
        r104 = true;
        goto L21
    L79:
        return;
    L11:
        if (r110.isEmpty() == true) goto L13;
        r102 = true;
        goto L14
    }

    public final Item.a T90(com.larus.office.base.plugins.toolbar.model.a r100) {
        if (r100 == null) goto L27;
        Item[] r101 = r100.a();
        if (r101 == null) goto L27;
        int r102 = 0;
        if (r101.length != 0) goto L9;
        boolean r103 = true;
    L11:
        if ((!r103) == false) goto L26;
        int r104 = r101.length;
    L13:
        if (r102 >= r104) goto L27;
        Item r105 = r101[r102];
        Item r106 = this.f360950k;
        if (r106 == null) goto L25;
        if (r106 == null) goto L18;
        String r107 = r106.getId();
    L20:
        if (Intrinsics.areEqual(r107, r105.getId()) == false) goto L25;
        if (r105.getChildren() == null) goto L25;
        return r105.getChildren();
    L18:
        r107 = null;
    L25:
        r102 = r102 + 1;
        goto L13
    L26:
        FLogger.f375446a.w("BaseSubToolbarV2Fragment", "toolbar data is null!");
        goto L27
    L9:
        r103 = false;
    L27:
        return null;
    }

    public final Item[] U90(com.larus.office.base.plugins.toolbar.model.a r100) {
        Item.a r101 = T90(r100);
        if (r101 == null) goto L7;
        Item[] r102 = r101.a();
        if (r102 == null) goto L7;
        int r103 = r102.length;
    L9:
        if (r103 <= 0) goto L13;
        if (r101 != null) goto L12;
        return null;
    L12:
        return r101.a();
    L13:
        FLogger.f375446a.w("BaseSubToolbarV2Fragment", "children is null");
        return null;
    L7:
        r103 = 0;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        Item r102 = null;
        if (r101 == null) goto L5;
        Serializable r103 = r101.getSerializable(Item.class.getName());
    L7:
        if ((r103 instanceof Item) == false) goto L9;
        r102 = (Item) r103;
    L9:
        this.f360950k = r102;
        KeyboardHeightProvider.Factory.get(getActivity()).addKeyboardHeightObserver(this);
        return;
    L5:
        r103 = null;
        goto L7
    }

    public <V> void Y90(Item r100, V r101) {
        FLogger.f375446a.i("BaseSubToolbarV2Fragment", "processOnItemClick " + r100);     // Catch: Exception -> L9
        BaseToolbarV2PanelViewModel<T> r102 = V90();     // Catch: Exception -> L9
        if (r100 == null) goto L6;
        ItemId r103 = r100.id();     // Catch: Exception -> L9
    L7:
        r102.processSubToolbarItemClick(r103, r101);     // Catch: Exception -> L9
        return;
    L6:
        r103 = null;
    L9:
        e = move-exception;
        FLogger.f375446a.e("BaseSubToolbarV2Fragment", e.getMessage());
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        BaseSubToolbarAdapter r102 = this.f360945f;
        if (r102 != null) goto L5;
        r102 = W90();
    L5:
        this.f360945f = r102;
        RecyclerView r103 = this.f360944e;
        if (r103 == null) goto L8;
        r103.setAdapter(r102);
    L8:
        Context r104 = getContext();
        T r105 = V90().getToolbar().getValue();
        Item.a r106 = T90(r105);
        if (r105 == null) goto L12;
        if (r106 == null) goto L12;
        int r107 = !r106.b() ? 1 : 0;
    L13:
        LinearLayoutManager r108 = new LinearLayoutManager(r104, r107, false);
        this.f360946g = r108;
        RecyclerView r109 = this.f360944e;
        if (r109 == null) goto L16;
        r109.setLayoutManager(r108);
    L16:
        RecyclerView r110 = this.f360944e;
        if (r110 == null) goto L19;
        r110.addItemDecoration(new HorizontalMarginItemDecoration(c7.b(6)));
    L19:
        BaseSubToolbarAdapter r111 = this.f360945f;
        if (r111 == null) goto L22;
        r111.f360939b = new c(this);
    L22:
        RecyclerViewScrollBottomListener r112 = new RecyclerViewScrollBottomListener();
        RecyclerView r113 = this.f360944e;
        if (r113 == null) goto L25;
        r113.addOnScrollListener(r112);
    L25:
        final BaseToolbarV2PanelViewModel<T> r114 = V90();
        LiveData<Rect> r115 = r114.getSubToolbarV2Rect();
        if (r115 == null) goto L28;
        r115.observe(getViewLifecycleOwner(), new i(this));
    L28:
        r114.getToolbar().observe(getViewLifecycleOwner(), new j(this, r114));
        LiveData<Rect> r116 = r114.getSubToolbarV2Rect();
        Intrinsics.checkNotNull(r116);
        S90(r116.getValue());
        return;
    L12:
        r107 = 0;
        goto L13
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.larus_doc_sub_toolbar_layout, r101, false);
        this.f360944e = (RecyclerView) r103.findViewById(R.id.sub_toolbar_menu_list);
        this.f360943d = r103.findViewById(R.id.menu_parent);
        return r103;
    }
}
