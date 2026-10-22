package com.larus.profile.impl.creation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.activity.result.ActivityResultCaller;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import com.larus.bmhome.bigimg.widget.LeftCreationEditView;
import com.larus.bmhome.bigimg.widget.NumericIndicator;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.common_res.common_ui.databinding.LarusFragmentCommonSlideBinding;
import com.larus.common_ui.fragment.CommonSlideDialogFragment;
import com.larus.common_ui.fragment.CommonSlideFragment;
import com.larus.common_ui.fragment.helper.EditPanelType;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.nova.R;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.ModifiedUserCreationMusic;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationMusic;
import com.larus.profile.impl.databinding.LarusCreationPagerLayoutBinding;
import com.larus.profile.impl.viewmodel.CreationPagerViewModel;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002\u0083\u0001\u0018\u0000 \u008a\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0002\u008a\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010D\u001a\u00020\fH\u0016J\u0010\u0010E\u001a\u00020*2\u0006\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u000206H\u0016J\u0018\u0010I\u001a\u00020*2\u0006\u0010J\u001a\u00020\f2\u0006\u0010K\u001a\u00020\u0013H\u0002J\u001a\u0010L\u001a\u00020*2\u0006\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\u000e\u0010Q\u001a\u00020*2\u0006\u0010R\u001a\u000206J\n\u0010S\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010T\u001a\u0004\u0018\u00010\u00162\u0006\u0010U\u001a\u00020\fH\u0002J\b\u0010V\u001a\u00020\u0013H\u0002J\u001a\u0010W\u001a\u00020*2\u0006\u0010X\u001a\u00020\u00132\b\b\u0002\u0010Y\u001a\u00020\fH\u0002J+\u0010Z\u001a\u00020*2\u0006\u0010X\u001a\u00020\u00132\n\b\u0001\u0010[\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010Y\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\\J\u0012\u0010]\u001a\u00020*2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J&\u0010^\u001a\u0004\u0018\u00010N2\u0006\u0010_\u001a\u00020`2\b\u0010a\u001a\u0004\u0018\u00010b2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\u0012\u0010c\u001a\u00020*2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J\b\u0010f\u001a\u00020*H\u0016J\b\u0010g\u001a\u00020*H\u0016J\n\u0010h\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010i\u001a\u0004\u0018\u00010jH\u0016J\b\u0010k\u001a\u000206H\u0016J\n\u0010l\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010m\u001a\u00020\fH\u0016J\u0010\u0010n\u001a\u00020*2\u0006\u0010o\u001a\u000206H\u0016J\u001a\u0010p\u001a\u00020*2\u0006\u0010q\u001a\u00020\f2\b\b\u0002\u0010r\u001a\u000206H\u0002J\b\u0010s\u001a\u00020*H\u0016J\b\u0010t\u001a\u0004\u0018\u00010uJ\u0006\u0010v\u001a\u00020*J\u0006\u0010w\u001a\u00020*J\u0006\u0010x\u001a\u00020*J\b\u0010y\u001a\u00020*H\u0002J\b\u0010z\u001a\u00020*H\u0002J\b\u0010{\u001a\u00020*H\u0002J\b\u0010|\u001a\u00020*H\u0016J\b\u0010}\u001a\u00020*H\u0016J\b\u0010~\u001a\u00020*H\u0016J\u0011\u0010\u007f\u001a\u00020*2\u0007\u0010\u0080\u0001\u001a\u00020\fH\u0016J \u0010\u0087\u0001\u001a\u00020*2\t\b\u0002\u0010\u0088\u0001\u001a\u00020\f2\n\b\u0002\u0010\u0089\u0001\u001a\u00030\u0086\u0001H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR\"\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00107\"\u0004\b8\u00109R\u001b\u0010:\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b;\u00107R\u001b\u0010>\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010=\u001a\u0004\b?\u00107R\u001b\u0010A\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010=\u001a\u0004\bB\u00107R\u000f\u0010\u0081\u0001\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0082\u0001\u001a\u00030\u0083\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0084\u0001R\u0010\u0010\u0085\u0001\u001a\u00030\u0086\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u008b\u0001"}, d2 = {"Lcom/larus/profile/impl/creation/CreationGroupFragment;", "Lcom/larus/common_ui/fragment/CommonSlideFragment;", "Lcom/larus/profile/impl/databinding/LarusCreationPagerLayoutBinding;", "Lcom/larus/profile/impl/creation/ICreationDelegateInterface;", "Lcom/larus/common_ui/fragment/helper/IContainerFunctionInterface;", "<init>", "()V", "binding", "pagerAdapter", "Lcom/larus/profile/impl/creation/CreationInnerPagerAdapter;", "fragmentMap", "", "", "Landroidx/fragment/app/Fragment;", "getFragmentMap", "()Ljava/util/Map;", "setFragmentMap", "(Ljava/util/Map;)V", "preReportVid", "", "initList", "", "Lcom/larus/platform/api/creation/UserCreation;", "getInitList", "()Ljava/util/List;", "setInitList", "(Ljava/util/List;)V", "initPosition", "getInitPosition", "()I", "setInitPosition", "(I)V", "visitId", "getVisitId", "()Ljava/lang/String;", "setVisitId", "(Ljava/lang/String;)V", "creationStyle", "getCreationStyle", "setCreationStyle", "selfDismissed", "Lkotlin/Function0;", "", "getSelfDismissed", "()Lkotlin/jvm/functions/Function0;", "setSelfDismissed", "(Lkotlin/jvm/functions/Function0;)V", "creationPagerInitParams", "Lcom/larus/profile/api/model/CreationPagerInitParams;", "getCreationPagerInitParams", "()Lcom/larus/profile/api/model/CreationPagerInitParams;", "setCreationPagerInitParams", "(Lcom/larus/profile/api/model/CreationPagerInitParams;)V", "isShowLeftCreationView", "", "()Z", "setShowLeftCreationView", "(Z)V", "hasCreateImageAbility", "getHasCreateImageAbility", "hasCreateImageAbility$delegate", "Lkotlin/Lazy;", "hasDetailImageEditAbility", "getHasDetailImageEditAbility", "hasDetailImageEditAbility$delegate", "hasCreateVideoAbility", "getHasCreateVideoAbility", "hasCreateVideoAbility$delegate", "getDirection", "dispatchContainerEvent", "event", "Lcom/larus/common_ui/fragment/CommonSlideFragment$ContainerEvent;", "showEditPanel", "sendMobCreationSlide", "previous", "status", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "enableShareAction", "enable", "getCurrentCreation", "getCreationByIndex", "index", "getCurrentCreationId", "traceEnterMusicDetail", "slideStatus", "prePos", "traceEnterPictureDetail", "creationType", "(Ljava/lang/String;Ljava/lang/Integer;I)V", "initView", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "updateCreationContent", "content", "Lcom/larus/platform/api/ModifiedUserCreationMusic;", "onDetach", "onDestroyView", "initViewBinding", "getPagerAdapter", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "needCommonSlide", "getCurrentFragment", "getInitItemPosition", "setCreationPrivacy", BridgePrivilege.PRIVATE, "updateCreationModelPrivacy", "privacy", "splitMode", "deleteCreation", "getShareContainer", "Landroid/widget/FrameLayout;", "dismissScreenView", "showScreenView", "showOrDismissExtraView", "showOrDismissLeftEditView", "showLeftEditViewWithPinch", "dismissLeftEditViewWithPinch", "onMoreClick", "onShareClick", "onScroll", "onDoCreationAction", "action", "isFirstOnPageChangeCalled", "onPageChangeCallback", "com/larus/profile/impl/creation/CreationGroupFragment$onPageChangeCallback$1", "Lcom/larus/profile/impl/creation/CreationGroupFragment$onPageChangeCallback$1;", "currentEditPanelType", "Lcom/larus/common_ui/fragment/helper/EditPanelType;", "bindEditPanel", "position", "defaultType", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationGroupFragment extends CommonSlideFragment<LarusCreationPagerLayoutBinding> implements j2, g19.a {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f366112y = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LarusCreationPagerLayoutBinding f366113i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CreationInnerPagerAdapter f366114j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<Integer, Fragment> f366115k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f366116l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<UserCreation> f366117m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f366118n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f366119o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final t f366120p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public gs9.d f366121q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f366122r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f366123s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f366124t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f366125u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f366126v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final CreationGroupFragment$onPageChangeCallback$1 f366127w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public EditPanelType f366128x;

    public static final class a {
    }

    static {
    }

    @Override // g19.a
    public final void Oh() {
    }

    @Override // com.larus.common_ui.fragment.CommonSlideFragment
    public final int U90() {
        return 0;
    }

    @Override // com.larus.common_ui.fragment.CommonSlideFragment
    public final int V90() {
        return 0;
    }

    @Override // g19.a
    public final void u() {
    }

    @Override // com.larus.common_ui.fragment.CommonSlideFragment
    public final FragmentStateAdapter W90() {
        if (this.f366114j != null) goto L6;
        this.f366114j = new CreationInnerPagerAdapter(this);
    L6:
        return this.f366114j;
    }

    public final UserCreation aa0() {
        int r100 = this.f327586e;
        if (r100 < 0) goto L13;
        List<UserCreation> r101 = this.f366117m;
        if (r101 == null) goto L7;
        int r102 = r101.size();
    L8:
        if (r100 >= r102) goto L13;
        List<UserCreation> r103 = this.f366117m;
        if (r103 == null) goto L13;
        return (UserCreation) ListProtector.get(r103, r100);
    L7:
        r102 = 0;
    L13:
        return null;
    }

    public final g19.a ba0() {
        LarusFragmentCommonSlideBinding r100 = this.f327585d;     // Catch: Exception -> L20
        if (r100 == null) goto L6;
        ViewPager2 r101 = r100.f326711c;     // Catch: Exception -> L20
    L7:
        if (r101 == null) goto L22;
        int r102 = r101.getCurrentItem();     // Catch: Exception -> L20
        FragmentManager r103 = getChildFragmentManager();     // Catch: Exception -> L20
        if (r103 == null) goto L15;
        StringBuilder r104 = new StringBuilder("f");     // Catch: Exception -> L20
        CreationInnerPagerAdapter r105 = this.f366114j;     // Catch: Exception -> L20
        if (r105 == null) goto L13;
        Long r106 = Long.valueOf(r105.getItemId(r102));     // Catch: Exception -> L20
    L14:
        r104.append(r106);     // Catch: Exception -> L20
        ActivityResultCaller r107 = r103.findFragmentByTag(r104.toString());     // Catch: Exception -> L20
    L17:
        if ((r107 instanceof g19.a) == false) goto L27;
        return (g19.a) r107;
    L27:
        return null;
    L13:
        r106 = null;
        goto L14
    L15:
        r107 = null;
        goto L17
    L22:
        return null;
    L6:
        r101 = null;
    L20:
        e = move-exception;
        FLogger.f375446a.e("CreationGroupFragment", "getCurrentFragment error e=" + e.getMessage());
        return null;
    }

    public final void ca0() {
        LarusCreationPagerLayoutBinding r100 = this.f366113i;
        boolean r101 = false;
        if (r100 == null) goto L9;
        NumericIndicator r102 = r100.f366435c;
        if (r102 == null) goto L9;
        if (r102.getVisibility() != 4) goto L9;
        r101 = true;
    L9:
        if (r101 == false) goto L15;
        LarusCreationPagerLayoutBinding r103 = this.f366113i;
        if (r103 == null) goto L15;
        NumericIndicator r104 = r103.f366435c;
        if (r104 == null) goto L15;
        ViewExtKt.d(r104);
    L15:
        Fragment r105 = getParentFragment();
        CreationPagerFragment r106 = null;
        if ((r105 instanceof CreationPagerFragment) == false) goto L18;
        CreationPagerFragment r107 = (CreationPagerFragment) r105;
    L19:
        if (r107 == null) goto L22;
        r107.ha0();
    L22:
        if (this.f366122r == false) goto L28;
        LarusCreationPagerLayoutBinding r108 = this.f366113i;
        if (r108 == null) goto L40;
        LeftCreationEditView r109 = r108.f366434b;
        if (r109 == null) goto L41;
        ViewExtKt.d(r109);
        return;
    L41:
        return;
    L40:
        return;
    L28:
        Fragment r110 = getParentFragment();
        if ((r110 instanceof CreationPagerFragment) == false) goto L31;
        CreationPagerFragment r111 = (CreationPagerFragment) r110;
    L32:
        if (r111 == null) goto L34;
        r111.la0();
    L34:
        Fragment r112 = getParentFragment();
        if ((r112 instanceof CreationPagerFragment) == false) goto L37;
        r106 = (CreationPagerFragment) r112;
    L37:
        if (r106 == null) goto L43;
        r106.ia0();
        return;
    L43:
        return;
    L31:
        r111 = null;
        goto L32
    L18:
        r107 = null;
        goto L19
    }

    @Override // com.larus.common_ui.fragment.CommonSlideFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        ((LinkedHashMap) this.f366115k).clear();
        this.f366114j = null;
        this.f366113i = null;
        super.onDestroyView();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.profile.impl.creation.t] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.larus.profile.impl.creation.CreationGroupFragment$onPageChangeCallback$1] */
    public CreationGroupFragment() {
        this.f366115k = new LinkedHashMap();
        this.f366116l = "";
        this.f366118n = "";
        this.f366120p = new t();
        this.f366123s = LazyKt.lazy(new u());
        this.f366124t = LazyKt.lazy(new v());
        this.f366125u = LazyKt.lazy(new w());
        this.f366127w = new CreationGroupFragment$onPageChangeCallback$1(this);
        this.f366128x = EditPanelType.NONE;
    }

    @Override // g19.a
    public final void VT() {
        g19.a r100 = ba0();
        if (r100 == null) goto L6;
        r100.VT();
        return;
    }

    @Override // com.larus.common_ui.fragment.CommonSlideFragment
    public final ViewBinding Y90() {
        View r100 = getLayoutInflater().inflate(R.layout.larus_creation_pager_layout, null, false);
        int r101 = R.id.creation_left_edit_view;
        LeftCreationEditView r102 = (LeftCreationEditView) ViewBindings.findChildViewById(r100, R.id.creation_left_edit_view);
        if (r102 == null) goto L11;
        r101 = R.id.num_indicator;
        NumericIndicator r103 = (NumericIndicator) ViewBindings.findChildViewById(r100, R.id.num_indicator);
        if (r103 == null) goto L11;
        r101 = R.id.share_product_container;
        FrameLayout r104 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.share_product_container);
        if (r104 == null) goto L11;
        LarusCreationPagerLayoutBinding r105 = new LarusCreationPagerLayoutBinding((ConstraintLayout) r100, r102, r103, r104);
        this.f366113i = r105;
        return r105;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    @Override // g19.a
    public final void d70() {
        g19.a r100 = ba0();
        if (r100 == null) goto L6;
        r100.d70();
        return;
    }

    @Override // com.larus.profile.impl.creation.j2
    public final void fB() {
        UserCreation r100 = aa0();
        List<UserCreation> r101 = this.f366117m;
        if (r101 == null) goto L5;
        TypeIntrinsics.asMutableCollection(r101).remove(r100);
    L5:
        CreationInnerPagerAdapter r102 = this.f366114j;
        if (r102 == null) goto L11;
        List<UserCreation> r103 = this.f366117m;
        if (r103 != null) goto L10;
        r103 = new ArrayList();
    L10:
        r102.y2(r103);
    L11:
        LarusCreationPagerLayoutBinding r104 = this.f366113i;
        if (r104 == null) goto L20;
        NumericIndicator r105 = r104.f366435c;
        if (r105 == null) goto L20;
        List<UserCreation> r106 = this.f366117m;
        if (r106 == null) goto L18;
        int r107 = r106.size();
    L19:
        r105.setTotalCount(r107);
        r105.x(this.f327586e + 1);
        goto L20
    L18:
        r107 = 1;
    L20:
        Fragment r108 = getParentFragment();
        if ((r108 instanceof CreationPagerFragment) == false) goto L23;
        CreationPagerFragment r109 = (CreationPagerFragment) r108;
    L24:
        if (r109 == null) goto L29;
        int r110 = this.f327586e;
        CreationPagerViewModel r111 = r109.oa0();
        if (r111 == null) goto L30;
        r111.deleteCreation(r110);
        return;
    L30:
        return;
    L29:
        return;
    L23:
        r109 = null;
        goto L24
    }

    @Override // g19.a
    public final void o1() {
        g19.a r100 = ba0();
        if (r100 == null) goto L6;
        r100.o1();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDetach() {
        super.onDetach();
        if (this.f366120p == null) goto L6;
        Unit r100 = Unit.INSTANCE;
        return;
    }

    @Override // g19.a
    public final EditPanelType SQ() {
        return EditPanelType.NONE;
    }

    @Override // g19.a
    public final boolean dc() {
        return this.f366122r;
    }

    @Override // g19.a
    public final void FU(int r100) {
        g19.a r101 = ba0();
        if (r101 == null) goto L6;
        r101.FU(r100);
        return;
    }

    @Override // com.larus.profile.impl.creation.j2
    public final void J50(ModifiedUserCreationMusic r110) {
        FLogger.f375446a.i("CreationGroupFragment", "updateCreationContent content is " + r110);
        CreationPagerFragment r100 = null;
        if (r110 == null) goto L5;
        String r101 = r110.f364817a;
    L6:
        if (r110 == null) goto L8;
        ImageInfo r102 = r110.f364818b;
    L9:
        if (r110 == null) goto L11;
        String r103 = r110.f364819c;
    L72:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L19
        List<UserCreation> r105 = this.f366117m;     // Catch: Throwable -> L19
        if (r105 == null) goto L16;
        UserCreation r106 = (UserCreation) ListProtector.get(r105, this.f327586e);     // Catch: Throwable -> L19
        if (r106 == null) goto L16;
    L17:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L19
    L22:
        if (Result.m9452exceptionOrNullimpl(r107) == null) goto L25;
        r107 = null;
    L25:
        UserCreation r108 = (UserCreation) r107;
        if (r108 != null) goto L28;
        return;
    L28:
        UserCreationContent r109 = r108.f364991e;
        if (r109 == null) goto L31;
        UserCreationContent r111 = UserCreationContent.a(r109, null, null, null, null, 63);
    L32:
        UserCreation r112 = UserCreation.c(r108, null, r111, null, null, null, null, 131055);
        UserCreationContent r113 = r112.f364991e;
        if (r113 == null) goto L41;
        UserCreationContent r114 = r108.f364991e;
        if (r114 == null) goto L39;
        UserCreationMusic r115 = r114.f365007b;
        if (r115 == null) goto L39;
        UserCreationMusic r116 = UserCreationMusic.a(r115);
    L40:
        r113.f365007b = r116;
    L39:
        r116 = null;
    L41:
        if (r102 == null) goto L48;
        UserCreationContent r117 = r112.f364991e;
        if (r117 == null) goto L48;
        UserCreationMusic r118 = r117.f365007b;
        if (r118 == null) goto L48;
        r118.f365025d = r102;
    L48:
        if (com.larus.utils.o0.d(r101) == false) goto L55;
        UserCreationContent r119 = r112.f364991e;
        if (r119 == null) goto L55;
        UserCreationMusic r120 = r119.f365007b;
        if (r120 == null) goto L55;
        r120.f365023b = r101;
    L55:
        if (com.larus.utils.o0.d(r103) == false) goto L61;
        UserCreationContent r121 = r112.f364991e;
        if (r121 == null) goto L61;
        UserCreationMusic r122 = r121.f365007b;
        if (r122 == null) goto L61;
        r122.f365027f = r103;
    L61:
        List<UserCreation> r123 = this.f366117m;
        if (r123 == null) goto L64;
        UserCreation r124 = (UserCreation) ListProtector.set(r123, this.f327586e, r112);
    L64:
        Fragment r125 = getParentFragment();
        if ((r125 instanceof CreationPagerFragment) == false) goto L67;
        r100 = (CreationPagerFragment) r125;
    L67:
        if (r100 == null) goto L74;
        int r126 = this.f327586e;
        CreationPagerViewModel r127 = r100.oa0();
        if (r127 == null) goto L75;
        r127.updateCreationContent(r110, r126);
        return;
    L75:
        return;
    L74:
        return;
    L31:
        r111 = null;
    L16:
        r106 = null;
    L19:
        th = move-exception;
        Result.Companion r128 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    L11:
        r103 = null;
        goto L72
    L8:
        r102 = null;
        goto L9
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.common_ui.fragment.CommonSlideFragment
    public final void T90(CommonSlideFragment.b r210) {
        Intrinsics.checkNotNullParameter(r210, "event");
        g19.a r100 = null;
        String r101 = null;
        r101 = null;
        String r102 = null;
        r102 = null;
        g19.a r103 = null;
        if ((r210 instanceof CommonSlideFragment.b.c) == false) goto L276;
        CommonSlideFragment.b.c r104 = (CommonSlideFragment.b.c) r210;
        int r105 = r104.f327590a;
        int r106 = r104.f327591b;
        if (r105 < 0) goto L11;
        if (r106 < 0) goto L11;
        if (r105 == r106) goto L11;
        g19.a r107 = ba0();
        if (r107 == null) goto L11;
        r107.u();
    L11:
        boolean r110 = false;
        if (r105 != 0) goto L14;
        r105 = 0;
    L14:
        Fragment r108 = getParentFragment();
        if ((r108 instanceof CreationPagerFragment) == false) goto L17;
        CreationPagerFragment r109 = (CreationPagerFragment) r108;
    L18:
        if (r109 == null) goto L20;
        CreationGroupFragment r111 = r109.ma0();
    L22:
        if (Intrinsics.areEqual(r111, this) == true) goto L24;
        return;
    L24:
        LarusCreationPagerLayoutBinding r112 = this.f366113i;
        if (r112 == null) goto L30;
        NumericIndicator r113 = r112.f366435c;
        if (r113 == null) goto L30;
        r113.x(r105 + 1);
    L30:
        if (r106 == (-1)) goto L274;
        if (r105 == r106) goto L292;
        if (r105 <= r106) goto L35;
        String r114 = "left";
    L36:
        String r115 = r114;
        if (r106 < 0) goto L47;
        List<UserCreation> r116 = this.f366117m;
        if (r116 == null) goto L41;
        int r117 = r116.size();
    L42:
        if (r106 >= r117) goto L47;
        List<UserCreation> r118 = this.f366117m;
        if (r118 == null) goto L47;
        UserCreation r119 = (UserCreation) ListProtector.get(r118, r106);
    L48:
        boolean r120 = true;
        if (r119 == null) goto L56;
        Integer r121 = r119.f364990d;
        if (r121 == null) goto L56;
        if (r121.intValue() != 2) goto L56;
        boolean r122 = true;
    L57:
        String r123 = "0";
        if (r122 == false) goto L60;
        String r124 = "0";
    L61:
        Fragment r125 = getParentFragment();
        if ((r125 instanceof CommonSlideDialogFragment) == false) goto L64;
        CommonSlideDialogFragment r126 = (CommonSlideDialogFragment) r125;
    L65:
        if (r126 == null) goto L67;
        int r127 = r126.f327574e;
    L68:
        if (r119 != null) goto L70;
    L72:
        boolean r128 = false;
    L73:
        if (r128 == false) goto L75;
        String r129 = "music";
    L76:
        String r130 = r129;
        if (r119 == null) goto L79;
        String r131 = r119.f364987a;
    L80:
        String r132 = this.f366118n;
        if (r132 != null) goto L83;
    L86:
        boolean r133 = true;
    L87:
        String r134 = "creation_private";
        if (r133 == true) goto L90;
        String r135 = "creation_others";
    L94:
        tx9.x2.b(r135, r115, r124, r127, r106, r130, r131);
        UserCreation r136 = aa0();
        if (r136 != null) goto L97;
    L99:
        boolean r137 = false;
    L101:
        if (r137 == false) goto L186;
        UserCreation r138 = aa0();
        if (r138 == null) goto L109;
        UserCreationContent r139 = r138.f364991e;
        if (r139 == null) goto L109;
        UserCreationMusic r140 = r139.f365007b;
        if (r140 == null) goto L109;
        String r141 = r140.f365029h;
    L111:
        if (Intrinsics.areEqual(r141, this.f366116l) == true) goto L293;
        String r142 = this.f366118n;
        if (r142 != null) goto L115;
    L118:
        boolean r143 = true;
    L119:
        if (r143 == true) goto L121;
        String r144 = "creation_others";
    L125:
        UserCreation r145 = aa0();
        if (r145 == null) goto L132;
        UserCreationContent r146 = r145.f364991e;
        if (r146 == null) goto L132;
        UserCreationMusic r147 = r146.f365007b;
        if (r147 == null) goto L132;
        String r148 = r147.f365029h;
    L133:
        UserCreation r149 = aa0();
        if (r149 == null) goto L139;
        String r150 = r149.f364987a;
        if (r150 == null) goto L139;
        String r151 = r150;
    L140:
        Fragment r152 = getParentFragment();
        if ((r152 instanceof CommonSlideDialogFragment) == false) goto L143;
        CommonSlideDialogFragment r153 = (CommonSlideDialogFragment) r152;
    L144:
        if (r153 == null) goto L146;
        int r154 = r153.f327574e;
    L147:
        int r155 = this.f327586e;
        String r156 = this.f366118n;
        if (r156 != null) goto L150;
    L153:
        boolean r157 = true;
    L154:
        if (r157 == true) goto L156;
        r134 = "creation_others";
    L160:
        UserCreation r158 = aa0();
        if (r158 == null) goto L168;
        Integer r159 = r158.f364990d;
        if (r159 == null) goto L168;
        if (r159.intValue() != 2) goto L168;
        r110 = true;
    L168:
        if (r110 == false) goto L170;
        String r160 = "0";
    L171:
        gs9.d r161 = this.f366121q;
        if (r161 == null) goto L176;
        gs9.b r162 = r161.f482474f;
        if (r162 == null) goto L176;
        r101 = r162.f482457d;
    L176:
        tx9.x2.c(r115, r106, r144, r148, r151, r154, r155, r160, r134, r101);
        UserCreation r163 = aa0();
        if (r163 == null) goto L184;
        UserCreationContent r164 = r163.f364991e;
        if (r164 == null) goto L184;
        UserCreationMusic r165 = r164.f365007b;
        if (r165 == null) goto L184;
        String r166 = r165.f365029h;
        if (r166 == null) goto L184;
    L185:
        this.f366116l = r166;
        return;
    L184:
        r166 = "";
        goto L185
    L170:
        r160 = "1";
        goto L171
    L156:
        if (this.f366119o == 2) goto L160;
        r134 = "creation_list";
        goto L160
    L150:
        if (r156.length() == 0) goto L153;
        r157 = false;
        goto L154
    L146:
        r154 = 0;
        goto L147
    L143:
        r153 = null;
    L139:
        r151 = "";
    L132:
        r148 = null;
        goto L133
    L121:
        if (this.f366119o != 2) goto L123;
        r144 = "creation_private";
        goto L125
    L123:
        r144 = "creation_list";
        goto L125
    L115:
        if (r142.length() == 0) goto L118;
        r143 = false;
        goto L119
    L293:
        return;
    L109:
        r141 = null;
        goto L111
    L186:
        if (r106 == r105) goto L295;
        UserCreation r167 = aa0();
        if (r167 == null) goto L190;
        Integer r168 = Integer.valueOf(r167.f364988b);
    L191:
        gs9.d r169 = this.f366121q;
        if (r169 == null) goto L199;
        gs9.b r170 = r169.f482474f;
        if (r170 == null) goto L199;
        String r171 = r170.f482458e;
        if (r171 == null) goto L199;
        String r172 = r171;
    L212:
        UserCreation r173 = aa0();
        if (r173 == null) goto L218;
        String r174 = r173.f364987a;
        if (r174 == null) goto L218;
        String r175 = r174;
    L219:
        Fragment r176 = getParentFragment();
        if ((r176 instanceof CommonSlideDialogFragment) == false) goto L222;
        CommonSlideDialogFragment r177 = (CommonSlideDialogFragment) r176;
    L223:
        if (r177 == null) goto L225;
        int r178 = r177.f327574e;
    L226:
        int r179 = this.f327586e;
        String r180 = this.f366118n;
        if (r180 != null) goto L229;
    L232:
        boolean r181 = true;
    L233:
        if (r181 == true) goto L235;
        String r182 = "creation_others";
    L239:
        if (r168 != null) goto L242;
    L244:
        boolean r183 = false;
    L245:
        UserCreation r184 = aa0();
        if (r184 == null) goto L253;
        Integer r185 = r184.f364990d;
        if (r185 == null) goto L253;
        if (r185.intValue() != 2) goto L253;
        boolean r186 = true;
    L254:
        if (r186 == true) goto L257;
        r123 = "1";
    L257:
        if (r168 != null) goto L260;
    L262:
        r120 = false;
    L263:
        gs9.d r187 = this.f366121q;
        if (r187 == null) goto L268;
        gs9.b r188 = r187.f482474f;
        if (r188 == null) goto L268;
        String r189 = r188.f482457d;
    L269:
        if (r187 == null) goto L273;
        gs9.b r190 = r187.f482474f;
        if (r190 == null) goto L273;
        r102 = r190.f482459f;
    L273:
        tx9.x2.d(r115, r106, r172, r175, r178, r179, r182, r123, r183, r120, r189, r102);
        return;
    L268:
        r189 = null;
        goto L269
    L260:
        if (r168.intValue() != 4) goto L262;
    L253:
        r186 = false;
        goto L254
    L242:
        if (r168.intValue() != 3) goto L244;
        r183 = true;
        goto L245
    L235:
        if (this.f366119o != 2) goto L237;
        r182 = "creation_private";
        goto L239
    L237:
        r182 = "creation_list";
        goto L239
    L229:
        if (r180.length() == 0) goto L232;
        r181 = false;
        goto L233
    L225:
        r178 = 0;
        goto L226
    L222:
        r177 = null;
    L218:
        r175 = "";
    L199:
        String r191 = this.f366118n;
        if (r191 != null) goto L202;
    L205:
        boolean r192 = true;
    L206:
        if (r192 == true) goto L208;
        r172 = "creation_others";
        goto L212
    L208:
        if (this.f366119o != 2) goto L210;
        r172 = "creation_private";
        goto L212
    L210:
        r172 = "creation_list";
        goto L212
    L202:
        if (r191.length() == 0) goto L205;
        r192 = false;
        goto L206
    L190:
        r168 = null;
        goto L191
    L295:
        return;
    L97:
        if (r136.f364988b != 1) goto L99;
        r137 = true;
        goto L101
    L90:
        if (this.f366119o != 2) goto L92;
        r135 = "creation_private";
        goto L94
    L92:
        r135 = "creation_list";
        goto L94
    L83:
        if (r132.length() == 0) goto L86;
        r133 = false;
        goto L87
    L79:
        r131 = null;
        goto L80
    L75:
        r129 = "pic";
        goto L76
    L70:
        if (r119.f364988b != 1) goto L72;
        r128 = true;
        goto L73
    L67:
        r127 = 0;
        goto L68
    L64:
        r126 = null;
        goto L65
    L60:
        r124 = "1";
    L56:
        r122 = false;
        goto L57
    L41:
        r117 = 0;
    L47:
        r119 = null;
        goto L48
    L35:
        r114 = "right";
        goto L36
    L292:
        return;
    L274:
        return;
    L20:
        r111 = null;
        goto L22
    L17:
        r109 = null;
        goto L18
    L276:
        if ((r210 instanceof CommonSlideFragment.b.a) == false) goto L283;
        g19.a r193 = ba0();
        if ((r193 instanceof g19.a) == false) goto L280;
        r103 = r193;
    L280:
        if (r103 == null) goto L297;
        r103.o1();
        return;
    L297:
        return;
    L283:
        if ((r210 instanceof CommonSlideFragment.b.C4187b) == false) goto L291;
        g19.a r194 = ba0();
        if ((r194 instanceof g19.a) == false) goto L287;
        r100 = r194;
    L287:
        if (r100 == null) goto L299;
        r100.VT();
        return;
    L299:
        return;
    L291:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.common_ui.fragment.CommonSlideFragment
    public final void X90(Bundle r100) {
        super.X90(r100);
        CreationInnerPagerAdapter r101 = this.f366114j;
        if (r101 == null) goto L8;
        List<UserCreation> r102 = this.f366117m;
        if (r102 != null) goto L7;
        r102 = new ArrayList();
    L7:
        r101.y2(r102);
    L8:
        LarusCreationPagerLayoutBinding r103 = this.f366113i;
        if (r103 == null) goto L17;
        NumericIndicator r104 = r103.f366435c;
        if (r104 == null) goto L17;
        List<UserCreation> r105 = this.f366117m;
        if (r105 == null) goto L15;
        int r106 = r105.size();
    L16:
        r104.setTotalCount(r106);
        goto L17
    L15:
        r106 = 1;
    L17:
        LarusCreationPagerLayoutBinding r107 = this.f366113i;
        if (r107 == null) goto L23;
        NumericIndicator r108 = r107.f366435c;
        if (r108 == null) goto L23;
        r108.x(1);
    L23:
        if (this.f366122r == false) goto L49;
        LarusCreationPagerLayoutBinding r109 = this.f366113i;
        if (r109 == null) goto L29;
        LeftCreationEditView r110 = r109.f366434b;
        if (r110 == null) goto L29;
        com.larus.utils.e1.x(r110);
    L29:
        LarusCreationPagerLayoutBinding r111 = this.f366113i;
        if (r111 == null) goto L38;
        LeftCreationEditView r112 = r111.f366434b;
        if (r112 == null) goto L38;
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
        if (r113 == null) goto L37;
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r113;
        com.larus.utils.i0.f375410a.getClass();
        r114.topMargin = com.larus.utils.i0.g();
        r112.setLayoutParams(r114);
        goto L38
    L37:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L38:
        List r115 = CollectionsKt.listOf(new Integer[]{6, 7, 9, 8, 10, 11, 12});
        List<UserCreation> r116 = this.f366117m;
        if (r116 == null) goto L43;
        UserCreation r117 = (UserCreation) CollectionsKt.getOrNull(r116, 0);
        if (r117 == null) goto L43;
        Integer r118 = Integer.valueOf(r117.f364988b);
    L45:
        if (CollectionsKt.contains(r115, r118) == false) goto L47;
        EditPanelType r119 = EditPanelType.VIDEO;
    L48:
        Z90(this, 0, r119, 1);
        return;
    L47:
        r119 = EditPanelType.IMAGE;
    L43:
        r118 = null;
        goto L45
    L49:
        LarusCreationPagerLayoutBinding r120 = this.f366113i;
        if (r120 == null) goto L56;
        LeftCreationEditView r121 = r120.f366434b;
        if (r121 == null) goto L57;
        com.larus.utils.e1.o(r121);
        return;
    L57:
        return;
    }

    @Override // com.larus.profile.impl.creation.j2
    public final void fy(boolean r110) {
        boolean r100 = true;
        if (r110 == false) goto L5;
        int r101 = 2;
    L7:
        if (this.f366119o == 0) goto L9;
        boolean r102 = true;
    L10:
        Integer r103 = null;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L18
        List<UserCreation> r105 = this.f366117m;     // Catch: Throwable -> L18
        if (r105 == null) goto L15;
        UserCreation r106 = (UserCreation) ListProtector.get(r105, this.f327586e);     // Catch: Throwable -> L18
        if (r106 == null) goto L15;
    L16:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L18
    L21:
        if (Result.m9452exceptionOrNullimpl(r107) == null) goto L24;
        r107 = null;
    L24:
        UserCreation r108 = (UserCreation) r107;
        if (r108 == null) goto L53;
        if (r102 == false) goto L44;
        List<UserCreation> r109 = this.f366117m;
        if (r109 == null) goto L31;
        r109.remove(r108);
    L31:
        LarusCreationPagerLayoutBinding r111 = this.f366113i;
        if (r111 == null) goto L47;
        NumericIndicator r112 = r111.f366435c;
        if (r112 == null) goto L47;
        List<UserCreation> r113 = this.f366117m;
        if (r113 == null) goto L38;
        int r114 = r113.size();
    L39:
        r112.setTotalCount(r114);
        LarusCreationPagerLayoutBinding r115 = this.f366113i;
        if (r115 == null) goto L47;
        NumericIndicator r116 = r115.f366435c;
        if (r116 == null) goto L47;
        r116.x(this.f327586e + 1);
        goto L47
    L38:
        r114 = 1;
    L47:
        CreationInnerPagerAdapter r117 = this.f366114j;
        if (r117 == null) goto L53;
        List<UserCreation> r118 = this.f366117m;
        if (r118 != null) goto L52;
        r118 = new ArrayList();
    L52:
        r117.y2(r118);
        goto L53
    L44:
        UserCreation r119 = UserCreation.c(r108, Integer.valueOf(r101), null, null, null, null, null, 131063);
        List<UserCreation> r120 = this.f366117m;
        if (r120 == null) goto L47;
        UserCreation r121 = (UserCreation) ListProtector.set(r120, this.f327586e, r119);
    L53:
        Fragment r122 = getParentFragment();
        if ((r122 instanceof CreationPagerFragment) == false) goto L56;
        CreationPagerFragment r123 = (CreationPagerFragment) r122;
    L57:
        if (r123 == null) goto L73;
        int r124 = this.f327586e;
        CreationPagerViewModel r125 = r123.oa0();
        if (r125 == null) goto L74;
        int r126 = r123.f366186r;
        if (r126 == 1) goto L65;
        if (r126 != 2) goto L66;
        r103 = 2;
    L66:
        if (r103 != null) goto L69;
        r100 = false;
    L69:
        r125.setCreationPrivacy(r110, r100, r124);
        return;
    L65:
        r103 = 1;
        goto L66
    L74:
        return;
    L73:
        return;
    L56:
        r123 = null;
    L15:
        r106 = null;
    L18:
        th = move-exception;
        Result.Companion r127 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    L9:
        r102 = false;
        goto L10
    L5:
        r101 = 1;
        goto L7
    }

    @Override // com.larus.common_ui.fragment.CommonSlideFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LarusCreationPagerLayoutBinding r102 = this.f366113i;
        if (r102 == null) goto L11;
        NumericIndicator r103 = r102.f366435c;
        if (r103 == null) goto L11;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L10;
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        com.larus.utils.i0.f375410a.getClass();
        r105.topMargin = com.larus.utils.i0.g();
        r103.setLayoutParams(r105);
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L11:
        LarusFragmentCommonSlideBinding r106 = this.f327585d;
        if (r106 == null) goto L14;
        ViewPager2 r107 = r106.f326711c;
    L15:
        if (r107 == null) goto L18;
        r107.post(new x(this));
        return;
    L18:
        return;
    L14:
        r107 = null;
        goto L15
    }

    @Override // com.larus.common_ui.fragment.CommonSlideFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = super.onCreateView(r100, r101, r102);
        LarusFragmentCommonSlideBinding r104 = this.f327585d;
        if (r104 == null) goto L7;
        ImageView r105 = r104.f326714f;
        if (r105 == null) goto L7;
        r105.setVisibility(8);
    L7:
        LarusFragmentCommonSlideBinding r106 = this.f327585d;
        if (r106 == null) goto L12;
        ImageView r107 = r106.f326710b;
        if (r107 == null) goto L12;
        r107.setVisibility(8);
    L12:
        LarusFragmentCommonSlideBinding r108 = this.f327585d;
        if (r108 == null) goto L17;
        ImageView r109 = r108.f326715g;
        if (r109 == null) goto L17;
        r109.setVisibility(8);
    L17:
        return r103;
    }

    public static void Z90(CreationGroupFragment r110, int r111, EditPanelType r112, int r113) {
        if ((r113 & 1) == 0) goto L6;
        r111 = 0;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r112 = EditPanelType.NONE;
    L8:
        Map<Integer, Fragment> r114 = r110.f366115k;
        LinkedHashMap r115 = (LinkedHashMap) r114;
        Object r116 = r115.get(Integer.valueOf(r111));
        if ((r116 instanceof g19.a) == false) goto L11;
        g19.a r117 = (g19.a) r116;
    L12:
        if (r117 == null) goto L17;
        EditPanelType r118 = r117.SQ();
        if (r118 == null) goto L17;
        r112 = r118;
    L17:
        boolean r119 = Intrinsics.areEqual(PollingConfigService.f326423a.f("cre_pic_sc_dg"), "1");
        if (r110.f366128x == r112) goto L49;
        r110.f366128x = r112;
        LarusCreationPagerLayoutBinding r120 = r110.f366113i;
        if (r120 == null) goto L47;
        LeftCreationEditView r100 = r120.f366434b;
        if (r100 == null) goto L48;
        y r101 = new y(r110);
        if (((Boolean) r110.f366123s.getValue()).booleanValue() == false) goto L28;
        if (r119 == true) goto L28;
        boolean r102 = true;
    L30:
        if (((Boolean) r110.f366124t.getValue()).booleanValue() == false) goto L33;
        if (r119 == true) goto L33;
        boolean r103 = true;
    L35:
        if (((Boolean) r110.f366125u.getValue()).booleanValue() == false) goto L38;
        if (r119 == true) goto L38;
        boolean r104 = true;
    L40:
        if (r112 == EditPanelType.VIDEO) goto L42;
    L44:
        boolean r105 = false;
    L45:
        com.larus.platform.service.z2.f365865a.w3();
        LeftCreationEditView.d(r100, r101, Boolean.TRUE, r102, r103, r104, r105, true, null, 128);
        return;
    L42:
        if (com.larus.platform.service.z2.f365865a.getCreationExtendVideoConfig().b() == false) goto L44;
        r105 = true;
    L38:
        r104 = false;
    L33:
        r103 = false;
    L28:
        r102 = false;
        goto L30
    L48:
        return;
    L47:
        return;
    L49:
        return;
    L11:
        r117 = null;
        goto L12
    }
}
