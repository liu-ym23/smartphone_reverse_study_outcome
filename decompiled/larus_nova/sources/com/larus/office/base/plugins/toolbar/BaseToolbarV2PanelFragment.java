package com.larus.office.base.plugins.toolbar;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.docsdk.impl.utils.TintUtils;
import com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProvider;
import com.bytedance.ee.docsdk.impl.utils.keyboard.utils.HardKeyboardUtils;
import com.bytedance.ee.docsdk.impl.utils.keyboard.utils.KeyBoardUtils;
import com.bytedance.ee.docsdk.impl.utils.keyboard.utils.WindowModeUtils;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larus.nova.R;
import com.larus.office.base.plugins.toolbar.model.Item;
import com.larus.office.base.plugins.toolbar.model.ItemId;
import com.larus.office.base.plugins.toolbar.model.ToolbarPrimaryItemId;
import com.larus.office.base.plugins.toolbar.model.a;
import com.larus.office.base.plugins.toolbar.submenu.BaseSubToolbarV2Fragment;
import com.larus.office.base.plugins.toolbar.view.HorizontalOverScrollView;
import com.larus.office.base.plugins.toolbar.view.KeyboardPlaceholderView;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import dn9.b;
import dn9.c;
import dn9.d;
import dn9.e;
import dn9.f;
import dn9.k;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 s*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u0003:\u0001sB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0010\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007H$J&\u0010:\u001a\u0004\u0018\u00010\t2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u001c2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u001a\u0010>\u001a\u0002062\u0006\u0010?\u001a\u00020\t2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u0010@\u001a\u000206H\u0014J\u0010\u0010A\u001a\u0002062\u0006\u0010B\u001a\u00020.H\u0014J\u0012\u0010C\u001a\u0002062\b\u0010D\u001a\u0004\u0018\u00010EH\u0002J\u0010\u0010F\u001a\u0002062\u0006\u0010D\u001a\u00020EH\u0002J\u001c\u0010G\u001a\u0002062\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010J\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010K\u001a\u0002062\u0006\u0010D\u001a\u00020EH\u0002J\u001a\u0010L\u001a\u00020M2\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010J\u001a\u00020\u0003H\u0002J\u0012\u0010N\u001a\u00020M2\b\u0010J\u001a\u0004\u0018\u00010\u0003H$J\b\u0010O\u001a\u000206H\u0016J\b\u0010P\u001a\u000206H\u0002J\u0012\u0010Q\u001a\u0002062\b\u0010R\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010S\u001a\u000206H\u0002J\u0010\u0010T\u001a\u0002062\u0006\u0010R\u001a\u00020\u0002H\u0004J\b\u0010U\u001a\u000206H\u0002J\u0018\u0010V\u001a\u0002062\u0006\u0010W\u001a\u00020.2\u0006\u0010?\u001a\u00020\tH\u0002J\"\u0010X\u001a\u0002062\u0006\u0010Y\u001a\u00020E2\u0006\u0010Z\u001a\u00020\t2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0002J\u0012\u0010]\u001a\u00020.2\b\u0010^\u001a\u0004\u0018\u00010_H$J\u001c\u0010`\u001a\u0002062\b\u0010^\u001a\u0004\u0018\u00010_2\b\u0010a\u001a\u0004\u0018\u00010\\H\u0014J\u0012\u0010b\u001a\u0002062\b\u0010a\u001a\u0004\u0018\u00010\\H\u0002J\b\u0010c\u001a\u000206H\u0014J\u0012\u0010d\u001a\u0002062\b\u0010e\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010f\u001a\u0002062\u0006\u0010g\u001a\u00020EH\u0002J\u0010\u0010h\u001a\u0002062\u0006\u0010g\u001a\u00020EH\u0016J\"\u0010i\u001a\u0012\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010k\u0018\u00010j2\b\u0010^\u001a\u0004\u0018\u00010_H$J\u0010\u0010l\u001a\u0002062\u0006\u0010m\u001a\u00020MH\u0016J\u001c\u0010n\u001a\u0002062\b\u0010o\u001a\u0004\u0018\u00010p2\b\u0010J\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010q\u001a\u000206H\u0002J\u0010\u0010r\u001a\u0002062\u0006\u0010J\u001a\u00020\u0003H\u0002R\u001c\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u00078\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\rR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u001cX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u0010\u0010$\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u0004\u0018\u0001008\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006t"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/BaseToolbarV2PanelFragment;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/larus/office/base/plugins/toolbar/model/Toolbar;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "toolbarPanel", "Lcom/larus/office/base/plugins/toolbar/BaseToolbarV2PanelViewModel;", "keyboardSwitch", "Landroid/view/View;", "getKeyboardSwitch", "()Landroid/view/View;", "setKeyboardSwitch", "(Landroid/view/View;)V", "mMarkView", "keyboardSwitchIconParent", "getKeyboardSwitchIconParent", "setKeyboardSwitchIconParent", "keyboardSwitchIcon", "Landroid/widget/ImageView;", "getKeyboardSwitchIcon", "()Landroid/widget/ImageView;", "setKeyboardSwitchIcon", "(Landroid/widget/ImageView;)V", "toolbarLayout", "getToolbarLayout", "setToolbarLayout", "subToolbarContainer1", "Landroid/view/ViewGroup;", "getSubToolbarContainer1", "()Landroid/view/ViewGroup;", "setSubToolbarContainer1", "(Landroid/view/ViewGroup;)V", "subToolbarContainer2", "getSubToolbarContainer2", "setSubToolbarContainer2", "itemsContainer", "mKeyboardHeightProvider", "Lcom/bytedance/ee/docsdk/impl/utils/keyboard/provider/KeyboardHeightProvider;", "getMKeyboardHeightProvider", "()Lcom/bytedance/ee/docsdk/impl/utils/keyboard/provider/KeyboardHeightProvider;", "setMKeyboardHeightProvider", "(Lcom/bytedance/ee/docsdk/impl/utils/keyboard/provider/KeyboardHeightProvider;)V", "mScrollView", "Lcom/larus/office/base/plugins/toolbar/view/HorizontalOverScrollView;", "currentItemCount", "", "keyboardPlaceholder", "Lcom/larus/office/base/plugins/toolbar/view/KeyboardPlaceholderView;", "mOverScrolledListener", "Lcom/larus/office/base/plugins/toolbar/view/HorizontalOverScrollView$OnScrollChangedListener;", "toolbarItemContentDescriptionRegistry", "Lcom/larus/office/base/plugins/toolbar/ToolbarItemContentDescriptionRegistry;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "getToolbarViewModel", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "onViewCreated", "view", "onToolbarChanged", "onKeyboardChanged", "keyboardHeight", "updateSubToolbar", "expandedSubToolbar", "Lcom/larus/office/base/plugins/toolbar/model/Item;", "updateSubToolBarV2", "removeFragment", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", WidgetService.PARAM_FRAGMENT, "updateFunctionPanel", "isExpandedSubToolbar", "", "needHideFunctionPanelWhenUpdate", "onDestroyView", "updateToolbar", "onUpdateToolbar", NewBroadcastMonitor.STAGE.TOOLBAR, "updateKeyboardSwitchIcon", "updateToolbarItems", "setMarkVisible", "applyItemWidth", "width", "updateItemView", MapController.ITEM_LAYER_TAG, "itemView", "showingItemId", "", "getToolbarIcon", "id", "Lcom/larus/office/base/plugins/toolbar/model/ItemId;", "onToolbarItemClick", "value", "handleInsertImagePanelHeight", "onKeyboardToolbarItemClick", "removeFragmentIfNeeded", "viewGroup", "showSubToolbarV2", "itemV2", "showFunctionPanel", "getSubToolbarV2FragmentClass", "Ljava/lang/Class;", "Lcom/larus/office/base/plugins/toolbar/submenu/BaseSubToolbarV2Fragment;", "dismissAllFunctionPanel", MapMonitorConst.EVENT_DESTROY, "removeImageSelectFragment", "activity", "Landroidx/fragment/app/FragmentActivity;", "removeAllSubToolBarV2", "showDialog", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseToolbarV2PanelFragment<T extends com.larus.office.base.plugins.toolbar.model.a> extends Fragment {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f360790q = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BaseToolbarV2PanelViewModel<T> f360791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f360792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f360793f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f360794g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f360795h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f360796i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewGroup f360797j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ViewGroup f360798k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ViewGroup f360799l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public KeyboardHeightProvider f360800m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public HorizontalOverScrollView f360801n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public KeyboardPlaceholderView f360802o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final k f360803p;

    public static final class a {
    }

    public abstract Class<? extends BaseSubToolbarV2Fragment<?>> T90(ItemId r100);

    public abstract int U90(ItemId r100);

    public abstract BaseToolbarV2PanelViewModel<T> V90();

    public void W90(int r100) {
    }

    public void Y90() {
    }

    public void ba0(FragmentActivity r100, Fragment r101) {
    }

    static {
        c7.b(Float.valueOf(0.5f));
        c7.b(Float.valueOf(24.0f));
        c7.b(Float.valueOf(44.0f));
        c7.b(Float.valueOf(3.0f));
    }

    public void X90() {
        BaseToolbarV2PanelViewModel<T> r100 = this.f360791d;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == true) goto L18;
        FragmentActivity r102 = getActivity();
        if (r102 == null) goto L18;
        FragmentManager r103 = r102.getSupportFragmentManager();
        if (r103 == null) goto L18;
        List<Fragment> r104 = r103.getFragments();
        if (r104 == null) goto L18;
        Iterator<Fragment> r105 = r104.iterator();
    L16:
        if (r105.hasNext() == false) goto L18;
        Fragment r106 = r105.next();
        ba0(getActivity(), r106);
    L18:
        if (r101 == true) goto L20;
        KeyBoardUtils.hideKeyboard(getContext());
        return;
    L20:
        KeyBoardUtils.showKeyboard(getContext());
        return;
    L5:
        if (r100.clearSubToolbar() != true) goto L7;
        r101 = true;
        goto L7
    }

    public final void da0() {
        BaseToolbarV2PanelViewModel<T> r100 = this.f360791d;
        ItemId.DisplayMode r101 = null;
        if (r100 == null) goto L7;
        LiveData<T> r102 = r100.getToolbar();
        if (r102 == null) goto L7;
        T r103 = r102.getValue();
    L8:
        aa0(r103);
        BaseToolbarV2PanelViewModel<T> r104 = this.f360791d;
        if (r104 == null) goto L13;
        LiveData<Item> r105 = r104.getExpandedSubToolbar();
        if (r105 == null) goto L13;
        Item r106 = r105.getValue();
    L14:
        KeyboardHeightProvider r107 = this.f360800m;
        boolean r108 = true;
        if (r107 != null) goto L17;
    L19:
        boolean r109 = false;
    L21:
        if (HardKeyboardUtils.hasHardKeyboard(getActivity()) == false) goto L25;
        View r110 = this.f360794g;
        if (r110 == null) goto L38;
        r110.setSelected(false);
        return;
    L38:
        return;
    L25:
        View r111 = this.f360794g;
        if (r111 == null) goto L40;
        if (r109 == false) goto L36;
        if (r106 == null) goto L33;
        ItemId r112 = r106.id();
        if (r112 == null) goto L33;
        r101 = r112.displayMode();
    L33:
        if (r101 == ItemId.DisplayMode.FunctionPanel) goto L36;
        r108 = false;
    L36:
        r111.setSelected(r108);
        return;
    L40:
        return;
    L17:
        if (r107.isKeyboardShowing() != true) goto L19;
        r109 = true;
    L13:
        r106 = null;
    L7:
        r103 = null;
        goto L8
    }

    public BaseToolbarV2PanelFragment() {
        this.f360803p = new k();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        HorizontalOverScrollView r100 = this.f360801n;
        if (r100 == null) goto L5;
        TypeIntrinsics.asMutableCollection(r100.f360971a).remove(null);
    L5:
        S90(true);
    }

    public void S90(boolean r100) {
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L7;
        FragmentManager r102 = r101.getSupportFragmentManager();
        if (r102 == null) goto L7;
        List<Fragment> r103 = r102.getFragments();
    L8:
        if (r103 != null) goto L18;
        return;
    L18:
        Iterator<Fragment> r104 = r103.iterator();     // Catch: Exception -> L15
    L12:
        if (r104.hasNext() == false) goto L22;
        Fragment r105 = r104.next();     // Catch: Exception -> L15
        ba0(getActivity(), r105);     // Catch: Exception -> L15
        goto L12
    L22:
        return;
    L15:
        e = move-exception;
        FLogger.f375446a.e("ToolbarV2", "dismissAllFunctionPanel err: ", e);
        return;
    L7:
        r103 = null;
        goto L8
    }

    public void aa0(com.larus.office.base.plugins.toolbar.model.a r110) {
        if (r110 == null) goto L5;
        Item[] r100 = r110.a();
    L6:
        int r101 = 0;
        if (r100 != null) goto L9;
    L15:
        boolean r102 = true;
    L17:
        if (r102 == false) goto L23;
        View r103 = this.f360796i;
        if (r103 == null) goto L21;
        r103.setVisibility(8);
    L21:
        FLogger.f375446a.i("ToolbarV2", "hide toolbar items length = 0");
        return;
    L23:
        View r104 = this.f360796i;
        if (r104 == null) goto L26;
        r104.setVisibility(0);
    L26:
        Intrinsics.checkNotNullParameter(r110, NewBroadcastMonitor.STAGE.TOOLBAR);
        FLogger r105 = FLogger.f375446a;
        StringBuilder r106 = new StringBuilder("Update toolbar items, item count: ");
        Item[] r107 = r110.a();
        if (r107 == null) goto L29;
        Integer r108 = Integer.valueOf(r107.length);
    L30:
        r106.append(r108);
        r105.i("ToolbarV2", r106.toString());
        Item[] r109 = r110.a();
        if (r109 == null) goto L111;
        ViewGroup r111 = this.f360799l;
        if (r111 == null) goto L35;
        int r112 = r111.getChildCount();
    L37:
        if (r109.length <= r112) goto L42;
        LayoutInflater r113 = LayoutInflater.from(getContext());
        int r114 = r109.length - r112;
        int r115 = 0;
    L39:
        if (r115 >= r114) goto L49;
        r113.inflate(R.layout.larus_toolbar_v2_top_level_item, this.f360799l);
        r115 = r115 + 1;
    L49:
        ViewGroup r116 = this.f360799l;
        if (r116 == null) goto L108;
        int r117 = r109.length;
        int r118 = 0;
    L52:
        if (r118 >= r117) goto L108;
        Item r119 = r109[r118];
        View r120 = r116.getChildAt(r118);
        String r121 = r110.b();
        final AppCompatImageView r122 = (AppCompatImageView) r120.findViewById(R.id.toolbarItemImg);
        View r123 = r120.findViewById(R.id.separator);
        r120.setTag(r119.id().itemName());
        if (Intrinsics.areEqual("separator", r119.id().itemName()) == false) goto L59;
        r122.setVisibility(8);
        r123.setVisibility(r101);
        ItemId r124 = r119.id();
        if (r124 == r122.getTag()) goto L107;
        r122.setTag(r124);
    L107:
        r118 = r118 + 1;
        r101 = 0;
        goto L52
    L59:
        r122.setVisibility(r101);
        r123.setVisibility(8);
        ItemId r125 = r119.id();
        if (r125 == r122.getTag()) goto L63;
        r122.setTag(r125);
        r122.setImageResource(U90(r119.id()));
    L63:
        if (r119.isAdminLimit() == false) goto L65;
    L68:
        boolean r126 = true;
    L69:
        r122.setEnabled(r126);
        if (r119.isAdminLimit() == false) goto L72;
        float r127 = 0.5f;
    L73:
        r122.setAlpha(r127);
        r122.setSelected(r119.isSelected());
        if (ToolbarPrimaryItemId.inlineAI != r119.id()) goto L76;
        r122.setImageTintList(null);
    L77:
        r120.setTag(r125.itemName());
        if (r119.isAdminLimit() == false) goto L80;
    L83:
        boolean r128 = true;
    L84:
        r120.setEnabled(r128);
        if (r119.isAdminLimit() == false) goto L87;
        float r129 = 0.5f;
    L88:
        r120.setAlpha(r129);
        r120.setSelected(r119.isSelected());
        k r130 = this.f360803p;
        String r131 = r125.itemName();
        r130.getClass();
        if (TextUtils.isEmpty(r131) == false) goto L91;
        CharSequence r132 = null;
    L93:
        if (TextUtils.isEmpty(r132) == true) goto L95;
        r120.setContentDescription(r132);
    L95:
        BaseToolbarV2PanelViewModel<T> r133 = this.f360791d;
        if (r133 == null) goto L101;
        if (r133.isExpanded(r119) != true) goto L101;
        boolean r134 = true;
    L103:
        if (Intrinsics.areEqual(r119.id().itemName(), r121) == false) goto L105;
        r122.setBackgroundResource(R.drawable.larus_doc_toolbar_v2_subitem_all_pressed);
        r122.post(new e(this, r122));
    L106:
        r120.setOnClickListener(new f(r134, this, r125));
        goto L107
    L105:
        r122.setBackgroundResource(R.drawable.larus_doc_toolbar_v2_subitem_all_selector);
    L101:
        r134 = false;
        goto L103
    L91:
        Map<CharSequence, CharSequence> r135 = r130.f469387a;
        Intrinsics.checkNotNull(r131);
        r132 = (CharSequence) ((LinkedHashMap) r135).get(r131);
        goto L93
    L87:
        r129 = 1.0f;
        goto L88
    L80:
        if (r119.isEnable() == true) goto L83;
        r128 = false;
        goto L84
    L76:
        r122.setImageTintList(AppCompatResources.getColorStateList(requireContext(), R.color.larus_toolbar_item_tint));
        goto L77
    L72:
        r127 = 1.0f;
        goto L73
    L65:
        if (r119.isEnable() == true) goto L68;
        r126 = false;
    L108:
        int r136 = r109.length;
        int r137 = 0;
    L109:
        if (r137 >= r136) goto L120;
        Intrinsics.areEqual(r109[r137].id().itemName(), "separator");
        r137 = r137 + 1;
        goto L109
    L120:
        return;
    L42:
        if (r109.length >= r112) goto L49;
        int r138 = r112 - r109.length;
        int r139 = 0;
    L44:
        if (r139 >= r138) goto L49;
        ViewGroup r140 = this.f360799l;
        if (r140 == null) goto L48;
        r140.removeViewAt(r140.getChildCount() - 1);
    L48:
        r139 = r139 + 1;
        goto L44
    L35:
        r112 = 0;
        goto L37
    L111:
        return;
    L29:
        r108 = null;
        goto L30
    L9:
        if (r100.length != 0) goto L11;
        boolean r141 = true;
    L12:
        if (r141 == true) goto L15;
        r102 = false;
        goto L17
    L11:
        r141 = false;
        goto L12
    L5:
        r100 = null;
        goto L6
    }

    public void ca0(Item r100) {
        Intrinsics.checkNotNullParameter(r100, "itemV2");
        KeyboardPlaceholderView r101 = this.f360802o;
        if (r101 == null) goto L5;
        r101.a();
    L5:
        String r102 = r100.id().itemName();
        FragmentActivity r103 = getActivity();
        if (r103 == null) goto L29;
        FragmentManager r104 = r103.getSupportFragmentManager();
        if (r104 == null) goto L30;
        Fragment r105 = r104.findFragmentByTag(r102);
        if (r105 == null) goto L31;
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type androidx.fragment.app.DialogFragment");
        DialogFragment r106 = (DialogFragment) r105;
        Dialog r107 = r106.getDialog();
        if (r107 != null) goto L14;
    L16:
        boolean r108 = false;
    L17:
        if (r108 == false) goto L32;
        Dialog r109 = r106.getDialog();
        if (r109 != null) goto L21;
        return;
    L21:
        if (DialogLancet.shouldBlockDialogShow(r109) == false) goto L27;
        DialogLancet.handleBlockedDialogShow(r109);
        return;
    L27:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L26
    L24:
        DialogLancet.beforeDialogShow(r109);
        r109.show();
        DialogLancet.afterDialogShow(r109);
        return;
    L32:
        return;
    L14:
        if (r107.isShowing() == true) goto L16;
        r108 = true;
        goto L17
    L31:
        return;
    L30:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        FragmentActivity r101 = requireActivity();
        this.f360791d = V90();
        this.f360800m = KeyboardHeightProvider.Factory.get(r101);
    }

    public void Z90(ItemId r100, String r101) {
        if (r100 == ItemId.ConstId.keyboard) goto L5;
        int r102 = 0;
        if (r100 != ToolbarPrimaryItemId.insertImage) goto L29;
        if (getActivity() != null) goto L18;
    L35:
        if (r100 == null) goto L43;
        BaseToolbarV2PanelViewModel<T> r103 = this.f360791d;
        if (r103 == null) goto L44;
        r103.processToolbarItemClick(r100, r101);
        return;
    L44:
        return;
    L43:
        return;
    L18:
        if (HardKeyboardUtils.hasHardKeyboard(getActivity()) == false) goto L20;
    L21:
        int r104 = KeyboardHeightProvider.Factory.get(getActivity()).keyBoardRawHeight();
        if (Intrinsics.areEqual("true", r101) == false) goto L24;
        S90(true);
    L25:
        KeyboardPlaceholderView r105 = this.f360802o;
        if (r105 == null) goto L35;
        r105.b(r102);
        goto L35
    L24:
        r102 = r104;
        goto L25
    L20:
        if (WindowModeUtils.INSTANCE.isInFreeFromMode() == false) goto L35;
    L29:
        if (getActivity() == null) goto L35;
        if (HardKeyboardUtils.hasHardKeyboard(getActivity()) == false) goto L35;
        KeyboardPlaceholderView r106 = this.f360802o;
        if (r106 == null) goto L35;
        r106.b(0);
        goto L35
    L5:
        if (HardKeyboardUtils.hasHardKeyboard(getActivity()) == false) goto L9;
        KeyBoardUtils.hideKeyboard(getContext());
        BaseToolbarV2PanelViewModel<T> r107 = this.f360791d;
        if (r107 == null) goto L40;
        r107.hideToolbar();
        return;
    L40:
        return;
    L9:
        BaseToolbarV2PanelViewModel<T> r108 = this.f360791d;
        if (r108 == null) goto L12;
        r108.processToolbarItemClick(r100, r101);
    L12:
        X90();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f360801n = (HorizontalOverScrollView) r100.findViewById(R.id.scrollView);
        this.f360793f = r100.findViewById(R.id.mark);
        this.f360794g = r100.findViewById(R.id.keyboardSwitchIconParent);
        ImageView r102 = (ImageView) r100.findViewById(R.id.keyboardSwitchIcon);
        this.f360795h = r102;
        if (r102 == null) goto L5;
        r102.setContentDescription("keyboardSwitch");
    L5:
        TintUtils.updateImageTint(this.f360795h, R.color.icon_n1);
        this.f360792e = r100.findViewById(R.id.keyboardSwitch);
        ImageView r103 = this.f360795h;
        if (r103 == null) goto L8;
        r103.setOnClickListener(new dn9.a(this, r100));
    L8:
        this.f360802o = (KeyboardPlaceholderView) r100.findViewById(R.id.keyboardPlaceholder);
        this.f360796i = r100.findViewById(R.id.toolbarLayout);
        this.f360799l = (ViewGroup) r100.findViewById(R.id.topLevelItems);
        this.f360797j = (ViewGroup) r100.findViewById(R.id.container_1);
        this.f360798k = (ViewGroup) r100.findViewById(R.id.container_2);
        BaseToolbarV2PanelViewModel<T> r104 = this.f360791d;
        if (r104 == null) goto L13;
        LiveData<Integer> r105 = r104.keyboardHeightLiveData();
        if (r105 == null) goto L13;
        r105.observe(getViewLifecycleOwner(), new b(this));
    L13:
        BaseToolbarV2PanelViewModel<T> r106 = this.f360791d;
        if (r106 == null) goto L18;
        LiveData<T> r107 = r106.getToolbar();
        if (r107 == null) goto L18;
        r107.observe(getViewLifecycleOwner(), new c(this));
    L18:
        BaseToolbarV2PanelViewModel<T> r108 = this.f360791d;
        if (r108 == null) goto L23;
        LiveData<Item> r109 = r108.getExpandedSubToolbar();
        if (r109 == null) goto L23;
        r109.observe(getViewLifecycleOwner(), new d(this));
    L23:
        BaseToolbarV2PanelViewModel<T> r110 = this.f360791d;
        if (r110 == null) goto L27;
        r110.observeActivePanel(this, new AnonymousClass5());
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.larus_toolbar_v2_fragment, r101, false);
    }
}
