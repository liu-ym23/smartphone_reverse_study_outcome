package com.ss.android.lark.picker.doubao;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.i18n.claymore.PluginServiceLoader;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.nova.R;
import com.ss.android.lark.picker.Picker;
import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.picker.base.view.binder.ICustomBinder;
import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.picker.base.widget.CustomSearchResultItem;
import com.ss.android.lark.picker.base.widget.SearchResultAdapter;
import com.ss.android.lark.picker.config.AddressBookConfig;
import com.ss.android.lark.picker.config.DoubaoConfig;
import com.ss.android.lark.picker.config.NavPickerConfig;
import com.ss.android.lark.picker.config.NavigationConfig;
import com.ss.android.lark.picker.config.PickerConfig;
import com.ss.android.lark.picker.doubao.api.DoubaoLocalChatterProvider;
import com.ss.android.lark.picker.doubao.organization.DoubaoOrganizationItemState;
import com.ss.android.lark.picker.doubao.organization.DoubaoOrganizationPickerView;
import com.ss.android.lark.picker.doubao.view.pickercommon.DoubaoChatterTagEnricher;
import com.ss.android.lark.picker.doubao.view.pickercommon.DoubaoPickerCommonItemViewBridgeFactory;
import com.ss.android.lark.search.baseview.SearchInputView;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import ktb.b;
import ktb.c;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u0000 z2\u00020\u0001:\u0001zB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u00104\u001a\u00020/2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208J\u000e\u00109\u001a\u00020/2\u0006\u0010:\u001a\u00020;J\u000e\u0010<\u001a\u00020/2\u0006\u0010=\u001a\u00020>J\u0010\u0010?\u001a\u00020/2\b\u0010@\u001a\u0004\u0018\u00010AJ\u0006\u0010B\u001a\u00020/J\u000e\u0010C\u001a\u00020/2\u0006\u0010D\u001a\u00020EJ\u000e\u0010F\u001a\u00020/2\u0006\u0010G\u001a\u00020\u0011J#\u0010H\u001a\u00020/2\n\b\u0003\u0010I\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010K¢\u0006\u0002\u0010LJ\u000e\u0010M\u001a\u00020/2\u0006\u0010N\u001a\u00020\u0011J\u0016\u0010O\u001a\u00020/2\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010QJ\u000e\u0010R\u001a\u00020/2\u0006\u0010S\u001a\u00020\u0011J\u0018\u0010T\u001a\u00020/2\u0006\u0010U\u001a\u00020\u00112\b\b\u0002\u0010V\u001a\u00020\u0011J\u0006\u0010W\u001a\u00020/J\u0006\u0010X\u001a\u00020\u0011J\u0006\u0010Y\u001a\u00020/J\u0018\u0010Z\u001a\u00020/2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0002J\b\u0010[\u001a\u00020/H\u0002J\u0010\u0010\\\u001a\u00020/2\u0006\u0010]\u001a\u00020'H\u0002J\u0018\u0010^\u001a\u00020/2\u0006\u0010_\u001a\u00020\u00112\u0006\u0010`\u001a\u00020\"H\u0002J\b\u0010a\u001a\u00020/H\u0002J\b\u0010b\u001a\u00020/H\u0002J\u0010\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020.H\u0002J\b\u0010f\u001a\u00020/H\u0002J\u0018\u0010g\u001a\u00020/2\u0006\u0010e\u001a\u00020.2\u0006\u0010h\u001a\u00020\u0011H\u0002J\b\u0010i\u001a\u00020/H\u0002J\u0018\u0010j\u001a\u00020/2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010k\u001a\u00020%H\u0002J\u0010\u0010l\u001a\u00020/2\u0006\u0010m\u001a\u00020nH\u0002J\u0010\u0010o\u001a\u00020/2\u0006\u0010p\u001a\u00020.H\u0002J\u0018\u0010q\u001a\u00020\"2\u0006\u0010r\u001a\u00020\"2\u0006\u0010k\u001a\u00020%H\u0002J\b\u0010s\u001a\u00020/H\u0002J\b\u0010t\u001a\u00020/H\u0002J\u0012\u0010u\u001a\u00020/2\b\b\u0001\u0010v\u001a\u00020%H\u0002J\u0010\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020xH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010#\u001a\u0014\u0012\u0004\u0012\u00020%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010,\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006{"}, d2 = {"Lcom/ss/android/lark/picker/doubao/LarkPicker;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "picker", "Lcom/ss/android/lark/picker/Picker;", "contentContainer", "titleBar", "Lcom/ss/android/lark/ui/CommonTitleBar;", "bottomBarContainer", "imePlaceholder", "Landroid/view/View;", "hasSelected", "", "selectedText", "Landroid/widget/TextView;", "bottomBarActionButton", "selectedAvatarList", "Landroidx/recyclerview/widget/RecyclerView;", "selectedAvatarAdapter", "Lcom/ss/android/lark/picker/doubao/LarkPickerSelectedAvatarAdapter;", "organizationPickerView", "Lcom/ss/android/lark/picker/doubao/organization/DoubaoOrganizationPickerView;", "organizationEntryView", "organizationSearchWatcher", "Landroid/text/TextWatcher;", "doubaoConfig", "Lcom/ss/android/lark/picker/config/DoubaoConfig;", "configuredRequiredIds", "", "", "selectedItemIdsByType", "", "", "configuredNavigation", "Lcom/ss/android/lark/picker/config/NavigationConfig;", "isDepartmentSelectable", "isOrganizationEnabled", "chatterTagEnricher", "Lcom/ss/android/lark/picker/doubao/view/pickercommon/DoubaoChatterTagEnricher;", "onItemClickListener", "Lkotlin/Function1;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "init", "activity", "Landroidx/fragment/app/FragmentActivity;", "pickerConfig", "Lcom/ss/android/lark/picker/config/PickerConfig;", "setCustomBinder", "binder", "Lcom/ss/android/lark/picker/base/view/binder/ICustomBinder;", "attachCustomSearchResultItem", "customItem", "Lcom/ss/android/lark/picker/base/widget/CustomSearchResultItem;", "attachSearchResultAdapter", "adapter", "Lcom/ss/android/lark/picker/base/widget/SearchResultAdapter;", "clearCustomSearchResultItems", "setPickModeChangeListener", "listener", "Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnPickModeChangeListener;", "setConsumeResultLayoutClickWhenEmpty", "consume", "attachRecommendEmptyViewConfig", "emptyIconResId", "emptyHintText", "", "(Ljava/lang/Integer;Ljava/lang/CharSequence;)V", "resetFocus", "needResetKeyboardNavigation", "resetSelectedData", "selected", "", "defaultMode", "withAnimation", "switchMultipleStatus", BdpAppEventConstant.MULTIPLE, "isForce", "clearInputViewFocus", "onBackPressed", MapMonitorConst.EVENT_DESTROY, "injectInternalBinderAndResolver", "applyConfiguredTitleBar", "configureTitleBar", NotificationCompat.CATEGORY_NAVIGATION, "updateOrganizationTitle", "showing", "organizationTitle", "attachOrganizationEntry", "dismissSearchKeyboard", "resolveOrganizationItemState", "Lcom/ss/android/lark/picker/doubao/organization/DoubaoOrganizationItemState;", "info", "refreshOrganizationSelection", "handleOrganizationItemClick", "shouldSelect", "attachConfiguredBottomBar", "updateBottomBar", "selectedCount", "updateSelectedAvatarList", "config", "Lcom/ss/android/lark/picker/config/DoubaoConfig$BottomBarConfig;", "onSelectedAvatarClick", MapController.ITEM_LAYER_TAG, "formatSelectedCountHintTemplate", ThumbGlideUrl.SOURCE_TEMPLATE, "setupWindowInsetsListener", "requestApplyInsetsWhenAttached", "applyTitleBarLeftIcon", "iconRes", "dp2px", "", "dp", "Companion", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkPicker extends FrameLayout {
    public static final Companion Companion = null;
    private static final float SEARCH_BAR_TEXT_SIZE_SP = 17.0f;
    private static final float SEARCH_ICON_SIZE_DP = 20.0f;
    public static final String TAG = "DoubaoPicker";
    private static final float TOP_CORNER_RADIUS_DP = 24.0f;
    private TextView bottomBarActionButton;
    private final FrameLayout bottomBarContainer;
    private DoubaoChatterTagEnricher chatterTagEnricher;
    private NavigationConfig configuredNavigation;
    private Set<String> configuredRequiredIds;
    private final FrameLayout contentContainer;
    private DoubaoConfig doubaoConfig;
    private boolean hasSelected;
    private final View imePlaceholder;
    private boolean isDepartmentSelectable;
    private boolean isOrganizationEnabled;
    private Function1<? super SearchBaseInfo, Unit> onItemClickListener;
    private View organizationEntryView;
    private DoubaoOrganizationPickerView organizationPickerView;
    private TextWatcher organizationSearchWatcher;
    private final Picker picker;
    private LarkPickerSelectedAvatarAdapter selectedAvatarAdapter;
    private RecyclerView selectedAvatarList;
    private Map<Integer, ? extends Set<String>> selectedItemIdsByType;
    private TextView selectedText;
    private final CommonTitleBar titleBar;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/picker/doubao/LarkPicker$Companion;", "", "<init>", "()V", "TAG", "", "TOP_CORNER_RADIUS_DP", "", "SEARCH_BAR_TEXT_SIZE_SP", "SEARCH_ICON_SIZE_DP", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final void applyConfiguredTitleBar() {
        NavigationConfig r100 = this.configuredNavigation;
        if (r100 != null) goto L6;
        this.titleBar.setVisibility(8);
        return;
    L6:
        configureTitleBar(r100);
        boolean r101 = false;
        this.titleBar.setVisibility(0);
        CommonTitleBar r102 = this.titleBar;
        String r103 = r100.getTitle();
        if (r103 != null) goto L9;
    L10:
        r101 = true;
    L11:
        if (r101 == false) goto L14;
        r103 = null;
    L14:
        if (r103 != null) goto L16;
        r103 = UIHelper.getString(R.string.Lark_Legacy_SelectTip);
    L16:
        r102.setTitle(r103);
        return;
    L9:
        if (r103.length() != 0) goto L11;
        goto L10
    }

    private final void attachConfiguredBottomBar() {
        DoubaoConfig.BottomBarConfig r100 = this.doubaoConfig.getBottomBarConfig();
        if (r100 != null) goto L5;
        return;
    L5:
        boolean r101 = false;
        View r102 = LayoutInflater.from(getContext()).inflate(R.layout.layout_lark_picker_bottom_bar, this.bottomBarContainer, false);
        this.bottomBarContainer.removeAllViews();
        this.bottomBarContainer.addView(r102);
        RecyclerView r103 = (RecyclerView) r102.findViewById(R.id.ai_bottom_bar_selected_avatar_list);
        if (r100.getShowSelectedAvatarList() == false) goto L8;
        r103.setLayoutManager(new LinearLayoutManager(r103.getContext(), 0, false));
        r103.setItemAnimator(null);
        LarkPickerSelectedAvatarAdapter r104 = new LarkPickerSelectedAvatarAdapter(new LarkPicker$attachConfiguredBottomBar$1$1(this));
        r103.setAdapter(r104);
        this.selectedAvatarAdapter = r104;
    L9:
        this.selectedAvatarList = r103;
        TextView r105 = (TextView) r102.findViewById(R.id.ai_bottom_bar_selection_text);
        this.selectedText = r105;
        if (r105 == null) goto L12;
        r105.setClickable(false);
    L12:
        TextView r106 = this.selectedText;
        if (r106 == null) goto L15;
        r106.setFocusable(false);
    L15:
        TextView r107 = (TextView) r102.findViewById(R.id.ai_bottom_bar_confirm_button);
        this.bottomBarActionButton = r107;
        if (r107 == null) goto L18;
        r107.setOnClickListener(new AnonymousClass2(this));
    L18:
        setupWindowInsetsListener();
        requestApplyInsetsWhenAttached();
        int r108 = this.picker.getSelectedList().size();
        if (r108 <= 0) goto L21;
        r101 = true;
    L21:
        this.hasSelected = r101;
        updateBottomBar(r101, r108);
        return;
    L8:
        r103.setVisibility(8);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void attachOrganizationEntry() {
        if (this.organizationEntryView == null) goto L5;
        return;
    L5:
        c r100 = (c) PluginServiceLoader.loadFirstOrNull(c.class);
        if (r100 != null) goto L8;
        return;
    L8:
        final String r101 = UIHelper.getString(R.string.Lark_Legacy_TitleDepartmentStructure);
        View r102 = LayoutInflater.from(getContext()).inflate(R.layout.view_doubao_organization_entry, this.picker, false);
        ((TextView) r102.findViewById(R.id.organization_title)).setText(r101);
        AttributeSet r103 = null;
        final DoubaoOrganizationPickerView r110 = new DoubaoOrganizationPickerView(getContext(), r103, 2, 0 == true ? 1 : 0);
        b r104 = r100.getContactOpenRepository();
        Intrinsics.checkNotNull(r101);
        r110.bind(r104, r101, UIHelper.getString(R.string.Lark_Legacy_Contact), UIHelper.getString(R.string.LarkIM_Contacts_OrgStructure_ViewReports_Button), this.isDepartmentSelectable, this.picker.isMultipleSelect(), new LarkPicker$attachOrganizationEntry$organizationView$1$1(this), new LarkPicker$attachOrganizationEntry$organizationView$1$2(this), new LarkPicker$attachOrganizationEntry$organizationView$1$3(this, r101), new LarkPicker$attachOrganizationEntry$organizationView$1$4(this));
        this.contentContainer.addView(r110, new FrameLayout.LayoutParams(-1, -1));
        TextWatcher r105 = new LarkPicker$attachOrganizationEntry$watcher$1(r110);
        this.picker.getSearchInputView().getInputEditText().addTextChangedListener(r105);
        this.organizationSearchWatcher = r105;
        r102.setOnClickListener(new AnonymousClass1(this, r110));
        Picker r106 = this.picker;
        Intrinsics.checkNotNull(r102);
        r106.attachTopCustomView(r102, false);
        this.organizationEntryView = r102;
        this.organizationPickerView = r110;
    }

    private final void dismissSearchKeyboard() {
        SearchInputView r100 = this.picker.getSearchInputView();
        EditText r101 = r100.getInputEditText();
        KeyboardUtils.hideKeyboard(getContext(), r101);
        r101.clearFocus();
        r100.clearFocus();
    }

    private final void refreshOrganizationSelection() {
        LinkedHashMap r100 = new LinkedHashMap();
        Iterator<T> r101 = this.picker.getSelectedList().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        SearchBaseInfo r102 = (SearchBaseInfo) r101.next();
        Integer r103 = Integer.valueOf(r102.getType());
        Object r104 = r100.get(r103);
        if (r104 != null) goto L8;
        r104 = new LinkedHashSet();
        r100.put(r103, r104);
    L8:
        ((Set) r104).add(r102.getId());
        goto L4
    L9:
        this.selectedItemIdsByType = r100;
        DoubaoOrganizationPickerView r105 = this.organizationPickerView;
        if (r105 == null) goto L16;
        r105.refreshSelection();
        return;
    }

    private final void setupWindowInsetsListener() {
        ViewCompat.setOnApplyWindowInsetsListener(this, new C120861(this));
    }

    public final void clearCustomSearchResultItems() {
        this.picker.clearCustomSearchResultItems();
    }

    public final void clearInputViewFocus() {
        this.picker.getSearchInputView().clearFocus();
    }

    public final void destroy() {
        TextWatcher r100 = this.organizationSearchWatcher;
        if (r100 == null) goto L5;
        this.picker.getSearchInputView().getInputEditText().removeTextChangedListener(r100);
    L5:
        this.organizationSearchWatcher = null;
        DoubaoOrganizationPickerView r101 = this.organizationPickerView;
        if (r101 == null) goto L8;
        r101.destroy();
    L8:
        this.organizationPickerView = null;
        this.organizationEntryView = null;
        DoubaoChatterTagEnricher r102 = this.chatterTagEnricher;
        if (r102 == null) goto L11;
        r102.destroy();
    L11:
        this.chatterTagEnricher = null;
        this.selectedAvatarAdapter = null;
        this.selectedAvatarList = null;
        ViewCompat.setOnApplyWindowInsetsListener(this, null);
        this.picker.destroy();
    }

    public final boolean onBackPressed() {
        DoubaoOrganizationPickerView r100 = this.organizationPickerView;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.onBackPressed() != true) goto L9;
        return true;
    L9:
        return false;
    }

    private final void requestApplyInsetsWhenAttached() {
        if (ViewCompat.isAttachedToWindow(this) == false) goto L6;
        ViewCompat.requestApplyInsets(this);
        return;
    L6:
        addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC120851(this));
    }

    public final Function1<SearchBaseInfo, Unit> getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public static final /* synthetic */ void access$dismissSearchKeyboard(LarkPicker r100) {
        r100.dismissSearchKeyboard();
    }

    public static final /* synthetic */ FrameLayout access$getBottomBarContainer$p(LarkPicker r100) {
        return r100.bottomBarContainer;
    }

    public static final /* synthetic */ DoubaoConfig access$getDoubaoConfig$p(LarkPicker r100) {
        return r100.doubaoConfig;
    }

    public static final /* synthetic */ View access$getImePlaceholder$p(LarkPicker r100) {
        return r100.imePlaceholder;
    }

    public static final /* synthetic */ DoubaoOrganizationPickerView access$getOrganizationPickerView$p(LarkPicker r100) {
        return r100.organizationPickerView;
    }

    public static final /* synthetic */ Picker access$getPicker$p(LarkPicker r100) {
        return r100.picker;
    }

    public static final /* synthetic */ void access$refreshOrganizationSelection(LarkPicker r100) {
        r100.refreshOrganizationSelection();
    }

    private final void applyTitleBarLeftIcon(int r100) {
        Drawable r101 = AppCompatResources.getDrawable(getContext(), R.drawable.bg_doubao_picker_title_icon);
        if (r101 != null) goto L5;
        return;
    L5:
        Drawable r102 = AppCompatResources.getDrawable(getContext(), r100);
        if (r102 == null) goto L12;
        Drawable r103 = DrawableCompat.wrap(r102).mutate();
        DrawableCompat.setTint(r103, ContextCompat.getColor(getContext(), R.color.larus_neutral_100));
        if (r103 == null) goto L13;
        LayerDrawable r104 = new LayerDrawable(new Drawable[]{r101, new InsetDrawable(r103, (int) dp2px(8.0f))});
        int r105 = (int) dp2px(36.0f);
        r104.setBounds(0, 0, r105, r105);
        this.titleBar.setLeftText("");
        this.titleBar.getLeftText().setCompoundDrawables(r104, null, null, null);
        this.titleBar.setLeftTextPadding(18, 0, 0, 0);
        return;
    L13:
        return;
    }

    private final void configureTitleBar(final NavigationConfig r100) {
        this.titleBar.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.flow_ud_bg_base_3));
        TextView r101 = this.titleBar.getCenterText();
        r101.setTextSize(2, 17.0f);
        r101.setTextColor(ContextCompat.getColor(r101.getContext(), R.color.flow_ud_neutral_100));
        Integer r102 = r100.getCancelIcon();
        if (r102 == null) goto L5;
        int r103 = r102.intValue();
    L6:
        applyTitleBarLeftIcon(r103);
        this.titleBar.setLeftClickListener(new ViewOnClickListenerC120832(r100));
        return;
    L5:
        r103 = R.drawable.ic_doubao_picker_close;
        goto L6
    }

    private final float dp2px(float r100) {
        return UIHelper.dp2px(r100);
    }

    private final void onSelectedAvatarClick(SearchBaseInfo r100) {
        if (resolveOrganizationItemState(r100).isEnabled() == true) goto L6;
        return;
    L6:
        if (this.picker.getBusinessConsumeDelegate().onBusinessConsumeItemClick(r100) == true) goto L8;
        this.picker.doItemClick(r100, false, 0);
        this.picker.refreshResult();
        this.picker.refreshDefault();
    L8:
        refreshOrganizationSelection();
    }

    private final DoubaoOrganizationItemState resolveOrganizationItemState(SearchBaseInfo r100) {
        boolean r101 = false;
        if (this.configuredRequiredIds.contains(r100.getId()) == true) goto L5;
        SearchResultView.CheckBoxBindStatus r102 = this.picker.getBusinessConsumeDelegate().onBusinessBindItemCheckBox(r100);
        if (r102.isConsume() == true) goto L9;
        Set<String> r103 = this.selectedItemIdsByType.get(Integer.valueOf(r100.getType()));
        if (r103 == null) goto L16;
        if (r103.contains(r100.getId()) != true) goto L16;
        r101 = true;
    L16:
        return new DoubaoOrganizationItemState(r101, true);
    L9:
        return new DoubaoOrganizationItemState(r102.isChecked(), r102.isEnabled());
    L5:
        return new DoubaoOrganizationItemState(true, false);
    }

    private final void updateSelectedAvatarList(DoubaoConfig.BottomBarConfig r100) {
        RecyclerView r101 = this.selectedAvatarList;
        if (r101 != null) goto L5;
        return;
    L5:
        int r102 = 8;
        if (r100.getShowSelectedAvatarList() == true) goto L9;
        r101.setVisibility(8);
        return;
    L9:
        List<SearchBaseInfo> r103 = this.picker.getSelectedList();
        LarkPickerSelectedAvatarAdapter r104 = this.selectedAvatarAdapter;
        if (r104 == null) goto L13;
        r104.submitList(r103);
    L13:
        if (r103.isEmpty() == true) goto L16;
        r102 = 0;
    L16:
        r101.setVisibility(r102);
    }

    public final void attachCustomSearchResultItem(CustomSearchResultItem r100) {
        Intrinsics.checkNotNullParameter(r100, "customItem");
        this.picker.attachCustomSearchResultItem(r100);
    }

    public final void attachSearchResultAdapter(SearchResultAdapter r100) {
        this.picker.attachSearchResultAdapter(r100);
    }

    public final void defaultMode(boolean r100) {
        this.picker.defaultMode(r100);
    }

    public final void resetFocus(boolean r100) {
        this.picker.resetFocus(r100);
    }

    public final void resetSelectedData(List<? extends SearchBaseInfo> r100) {
        Picker r101 = this.picker;
        if (r100 == null) goto L5;
        List<? extends SearchBaseInfo> r102 = CollectionsKt.toMutableList(r100);
    L6:
        r101.resetSelectedData(r102);
        int r103 = this.picker.getSelectedList().size();
        if (r103 <= 0) goto L9;
        boolean r104 = true;
    L10:
        this.hasSelected = r104;
        updateBottomBar(r104, r103);
        refreshOrganizationSelection();
        return;
    L9:
        r104 = false;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final void setConsumeResultLayoutClickWhenEmpty(boolean r100) {
        this.picker.attachConsumeResultLayoutClickWhenEmpty(r100);
    }

    public final void setCustomBinder(ICustomBinder r100) {
        Intrinsics.checkNotNullParameter(r100, "binder");
        this.picker.setCustomBinder(r100);
    }

    public final void setOnItemClickListener(Function1<? super SearchBaseInfo, Unit> r100) {
        this.onItemClickListener = r100;
    }

    public final void setPickModeChangeListener(BasePicker.IOnPickModeChangeListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.picker.setPickModeChangeListener(r100);
    }

    public LarkPicker(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.doubaoConfig = new DoubaoConfig();
        this.configuredRequiredIds = SetsKt.emptySet();
        this.selectedItemIdsByType = MapsKt.emptyMap();
        LayoutInflater.from(r100).inflate(R.layout.view_lark_picker, this);
        this.picker = (Picker) findViewById(R.id.picker);
        this.contentContainer = (FrameLayout) findViewById(R.id.lark_picker_content_container);
        this.titleBar = (CommonTitleBar) findViewById(R.id.lark_picker_title_bar);
        this.bottomBarContainer = (FrameLayout) findViewById(R.id.lark_picker_bottom_bar_container);
        this.imePlaceholder = findViewById(R.id.lark_picker_ime_placeholder);
    }

    public static final /* synthetic */ void access$onSelectedAvatarClick(LarkPicker r100, SearchBaseInfo r101) {
        r100.onSelectedAvatarClick(r101);
    }

    public static final /* synthetic */ DoubaoOrganizationItemState access$resolveOrganizationItemState(LarkPicker r100, SearchBaseInfo r101) {
        return r100.resolveOrganizationItemState(r101);
    }

    public static final /* synthetic */ void access$setConfiguredRequiredIds$p(LarkPicker r100, Set r101) {
        r100.configuredRequiredIds = r101;
    }

    public static final /* synthetic */ void access$setHasSelected$p(LarkPicker r100, boolean r101) {
        r100.hasSelected = r101;
    }

    private final String formatSelectedCountHintTemplate(String r100, int r101) {
        String r102 = String.valueOf(r101);
        MatchResult r103 = Regex.find$default(new Regex("\\{\\{\\s*num\\s*\\}\\}"), r100, 0, 2, null);
        Regex r104 = new Regex("%(\\d+\\$)?s");
        MatchResult r105 = Regex.find$default(r104, r100, 0, 2, null);
        if (r103 == null) goto L8;
        if (r105 != null) goto L6;
    L7:
        String r106 = UIHelper.mustacheFormat(r100, "num", r102);
        Intrinsics.checkNotNull(r106);
        return r106;
    L6:
        if (r103.getRange().getFirst() <= r105.getRange().getFirst()) goto L7;
    L8:
        if (r105 != null) goto L10;
        return r100;
    L10:
        return r104.replaceFirst(r100, r102);
    }

    private final void handleOrganizationItemClick(SearchBaseInfo r100, boolean r101) {
        if (r100.getType() != 17) goto L8;
        if (this.isDepartmentSelectable == true) goto L8;
        return;
    L8:
        if (resolveOrganizationItemState(r100).isEnabled() == true) goto L11;
        return;
    L11:
        if (this.picker.getBusinessConsumeDelegate().onBusinessConsumeItemClick(r100) == true) goto L15;
        this.picker.doItemClick(r100, r101, 0);
        Function1<? super SearchBaseInfo, Unit> r102 = this.onItemClickListener;
        if (r102 == null) goto L15;
        r102.invoke(r100);
    L15:
        refreshOrganizationSelection();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.ss.android.lark.picker.doubao.LarkPicker$injectInternalBinderAndResolver$onItemClickHandler$1] */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.ss.android.lark.picker.doubao.LarkPicker$injectInternalBinderAndResolver$doubaoBinder$1] */
    private final void injectInternalBinderAndResolver(final FragmentActivity r100, PickerConfig r101) {
        final ?? r102 = new LarkPicker$injectInternalBinderAndResolver$onItemClickHandler$1(this);
        final DoubaoPickerCommonItemViewBridgeFactory r103 = new DoubaoPickerCommonItemViewBridgeFactory(this.chatterTagEnricher);
        final ?? r104 = new LarkPicker$injectInternalBinderAndResolver$doubaoBinder$1(r100, r102, r103);
        final LarkPicker$injectInternalBinderAndResolver$doubaoResolver$1 r105 = LarkPicker$injectInternalBinderAndResolver$doubaoResolver$1.INSTANCE;
        r101.extra(new C120841(this, r104, r105));
    }

    private final void updateBottomBar(boolean r100, int r101) {
        DoubaoConfig.BottomBarConfig r102 = this.doubaoConfig.getBottomBarConfig();
        if (r102 != null) goto L5;
        return;
    L5:
        updateSelectedAvatarList(r102);
        if (r100 == false) goto L8;
    L11:
        this.bottomBarContainer.setVisibility(0);
        TextView r103 = this.selectedText;
        if (r103 == null) goto L20;
        String r104 = r102.getSelectedTextTemplate();
        if (r104 == null) goto L18;
        String r105 = formatSelectedCountHintTemplate(r104, r101);
        if (r105 == null) goto L18;
    L19:
        r103.setText(r105);
    L18:
        r105 = String.valueOf(r101);
    L20:
        TextView r106 = this.bottomBarActionButton;
        if (r106 == null) goto L32;
        String r107 = r102.getActionText();
        if (r107 != null) goto L26;
        r107 = UIHelper.mustacheFormat(R.string.Lark_Legacy_PickerConfirmWithCount, "count", String.valueOf(r101));
    L26:
        r106.setText(r107);
        r106.setEnabled(r100);
        if (r100 == false) goto L29;
        float r108 = 1.0f;
    L30:
        r106.setAlpha(r108);
        return;
    L29:
        r108 = 0.4f;
        goto L30
    L32:
        return;
    L8:
        if (r102.getShowWhenEmpty() == true) goto L11;
        this.bottomBarContainer.setVisibility(8);
    }

    private final void updateOrganizationTitle(boolean r100, String r101) {
        if (r100 == false) goto L5;
        this.titleBar.setVisibility(0);
        this.titleBar.setTitle(r101);
        applyTitleBarLeftIcon(R.drawable.ic_doubao_picker_back);
        this.titleBar.setLeftClickListener(new ViewOnClickListenerC120871(this));
        return;
    L5:
        applyConfiguredTitleBar();
    }

    public final void attachRecommendEmptyViewConfig(Integer r100, CharSequence r101) {
        this.picker.attachRecommendEmptyViewConfig(r100, r101);
    }

    public final void init(FragmentActivity r110, PickerConfig r111) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "pickerConfig");
        DoubaoChatterTagEnricher r100 = this.chatterTagEnricher;
        if (r100 == null) goto L5;
        r100.destroy();
    L5:
        DoubaoLocalChatterProvider r101 = (DoubaoLocalChatterProvider) PluginServiceLoader.loadFirstOrNull(DoubaoLocalChatterProvider.class);
        NavigationConfig r102 = null;
        if (r101 == null) goto L8;
        DoubaoChatterTagEnricher r103 = new DoubaoChatterTagEnricher(r101, null, null, 0, 14, null);
    L9:
        this.chatterTagEnricher = r103;
        DoubaoConfig r104 = r111.getDoubaoConfig();
        if (r104 != null) goto L12;
        r104 = new DoubaoConfig();
    L12:
        this.doubaoConfig = r104;
        if ((r111 instanceof NavPickerConfig) == false) goto L17;
        r102 = ((NavPickerConfig) r111).getNavigationConfig();
        if (r102 != null) goto L17;
        r102 = new NavigationConfig();
    L17:
        this.configuredNavigation = r102;
        this.isOrganizationEnabled = false;
        this.isDepartmentSelectable = false;
        AddressBookConfig r105 = r111.consumeAddressBookConfig();
        if (r105 == null) goto L20;
        this.isOrganizationEnabled = true;
        this.isDepartmentSelectable = r105.isDepartmentSelectable();
    L20:
        injectInternalBinderAndResolver(r110, r111);
        r111.searcherExtra(AnonymousClass4.INSTANCE);
        this.picker.init2(r111);
        refreshOrganizationSelection();
        this.picker.setDefaultContainerHideKeyboardOnTouch(false);
        SearchInputView r112 = this.picker.getSearchInputView();
        r112.setSearchEditTextCornerRadius(dp2px(16.0f));
        r112.setSearchEditTextTextSizeSp(17.0f);
        r112.setSearchIconRes(R.drawable.doubao_picker_search);
        r112.setSearchIconSize(UIHelper.dp2px(20.0f));
        r112.setSearchEditTextBackgroundColor(ContextCompat.getColor(r110, R.color.flow_ud_bg_base_2_overlay));
        r112.setSearchInputContainerBackgroundColor(ContextCompat.getColor(r110, R.color.flow_ud_bg_base_3));
        this.picker.attachSearchEmptyViewConfig(0, UIHelper.getString(R.string.Lark_Mention_NoResultsFound_Mobile));
        this.picker.setOnSelectedStatusChangeListener(new AnonymousClass6(this));
        this.picker.selectedRvBg2Doubao();
        applyConfiguredTitleBar();
        attachConfiguredBottomBar();
        if (this.isOrganizationEnabled == false) goto L24;
        attachOrganizationEntry();
        return;
    L24:
        return;
    L8:
        r103 = null;
        goto L9
    }

    public final void switchMultipleStatus(boolean r100, boolean r101) {
        this.picker.switchMultipleStatus(r100, r101);
        DoubaoOrganizationPickerView r102 = this.organizationPickerView;
        if (r102 == null) goto L6;
        r102.updateMultipleSelect(this.picker.isMultipleSelect());
        return;
    }

    public static final /* synthetic */ void access$handleOrganizationItemClick(LarkPicker r100, SearchBaseInfo r101, boolean r102) {
        r100.handleOrganizationItemClick(r101, r102);
    }

    public static final /* synthetic */ void access$updateBottomBar(LarkPicker r100, boolean r101, int r102) {
        r100.updateBottomBar(r101, r102);
    }

    public static final /* synthetic */ void access$updateOrganizationTitle(LarkPicker r100, boolean r101, String r102) {
        r100.updateOrganizationTitle(r101, r102);
    }

    public /* synthetic */ LarkPicker(Context r100, AttributeSet r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }

    public static /* synthetic */ void attachRecommendEmptyViewConfig$default(LarkPicker r100, Integer r101, CharSequence r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = null;
    L8:
        r100.attachRecommendEmptyViewConfig(r101, r102);
    }

    public static /* synthetic */ void switchMultipleStatus$default(LarkPicker r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = false;
    L5:
        r100.switchMultipleStatus(r101, r102);
    }
}
