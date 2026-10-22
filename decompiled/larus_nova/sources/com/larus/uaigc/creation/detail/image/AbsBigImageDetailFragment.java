package com.larus.uaigc.creation.detail.image;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.common_ui.image.ImageAdapter;
import com.larus.bmhome.common_ui.image.NonScrollableLinearLayoutManager;
import com.larus.image.databinding.LarusImageDetailLayoutBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0001TB\u0007¢\u0006\u0004\b\u0003\u0010\u0004JJ\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011H\u0016J\b\u0010=\u001a\u00020\u0013H\u0002J\b\u0010>\u001a\u00020\u0013H\u0016J\b\u0010?\u001a\u00020\u0013H\u0002J\b\u0010@\u001a\u00020\u0013H\u0002J\u0010\u0010A\u001a\u00020\u00132\u0006\u0010B\u001a\u00020\u0012H\u0002J\u0018\u0010C\u001a\u00020\u00132\u0006\u0010B\u001a\u00020\u00122\u0006\u0010D\u001a\u000204H\u0002J\u0012\u0010E\u001a\u00020\u00132\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J&\u0010H\u001a\u0004\u0018\u00010'2\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u000f\u0010M\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010NJ\b\u0010O\u001a\u00020\u0013H\u0016J\u000e\u0010P\u001a\u00020\u00132\u0006\u0010Q\u001a\u00020\u0012J\u0018\u0010R\u001a\u00020\u00132\u0006\u0010B\u001a\u00020\u00122\u0006\u0010D\u001a\u000204H\u0002J\b\u0010S\u001a\u00020\u0013H\u0016R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010.\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b/\u00100R\u000e\u00101\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R$\u00109\u001a\u0002042\u0006\u0010\u0005\u001a\u000204@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006U"}, d2 = {"Lcom/larus/uaigc/creation/detail/image/AbsBigImageDetailFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/common_ui/photoviewer/OnPageSelectedListener;", "<init>", "()V", "value", "Lcom/larus/bmhome/common_ui/image/ImageAdapter;", "adapter", "getAdapter", "()Lcom/larus/bmhome/common_ui/image/ImageAdapter;", "initUrls", "", "Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;", "thumbUrls", "", "", "selectCallback", "Lkotlin/Function1;", "", "", "initialize", "pager", "Landroidx/recyclerview/widget/RecyclerView;", "getPager", "()Landroidx/recyclerview/widget/RecyclerView;", "setPager", "(Landroidx/recyclerview/widget/RecyclerView;)V", "rootContainer", "Landroid/widget/FrameLayout;", "getRootContainer", "()Landroid/widget/FrameLayout;", "setRootContainer", "(Landroid/widget/FrameLayout;)V", "onPageSelectedListener", "getOnPageSelectedListener", "()Lcom/larus/common_ui/photoviewer/OnPageSelectedListener;", "setOnPageSelectedListener", "(Lcom/larus/common_ui/photoviewer/OnPageSelectedListener;)V", "extraView", "Landroid/view/View;", "getExtraView", "()Landroid/view/View;", "setExtraView", "(Landroid/view/View;)V", "binding", "Lcom/larus/image/databinding/LarusImageDetailLayoutBinding;", "currentPos", "getCurrentPos", "()I", "_currentPos", "depInitPos", "isAnimatedShow", "", "backgroundAlphaFactor", "", "orientationHelper", "Landroidx/recyclerview/widget/OrientationHelper;", "isInfinityLoop", "()Z", "setInfinityLoop", "(Z)V", "initRecyclerView", "onResume", "updateLayoutManager", "initAdapter", "dispatchOnPageUnSelected", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "dispatchOnPageSelected", "byScroll", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "getExtraViewLayout", "()Ljava/lang/Integer;", "dismissFragment", "show", "position", "setCurrentPos", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class AbsBigImageDetailFragment extends Fragment implements j19.g {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f372793n = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageAdapter f372794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<n1> f372795e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<String> f372796f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super Integer, Unit> f372797g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RecyclerView f372798h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f372799i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f372800j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LarusImageDetailLayoutBinding f372801k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f372802l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public OrientationHelper f372803m;

    public static final class a {
    }

    static {
    }

    @Override // j19.g
    public final void S80(int r100) {
    }

    public Integer T90() {
        return null;
    }

    @Override // j19.g
    public final void onPageSelected(int r100) {
    }

    @Override // j19.g
    public final void onPageSelected(int r100, boolean r101) {
    }

    public AbsBigImageDetailFragment() {
        this.f372802l = -1;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
    }

    public static final void S90(AbsBigImageDetailFragment r100, int r101) {
        if (r100.f372802l == r101) goto L8;
        r100.f372802l = r101;
        Function1<? super Integer, Unit> r102 = r100.f372797g;
        if (r102 == null) goto L9;
        r102.invoke(Integer.valueOf(r101));
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        LarusImageDetailLayoutBinding r103 = LarusImageDetailLayoutBinding.a(r100, r101);
        this.f372801k = r103;
        this.f372799i = r103.f350915c;
        this.f372798h = r103.f350914b;
        new PagerSnapHelper().attachToRecyclerView(this.f372798h);
        RecyclerView r104 = this.f372798h;
        if (r104 == null) goto L5;
        r104.addOnScrollListener(new AbsBigImageDetailFragment$initRecyclerView$1(this));
    L5:
        ImageAdapter r105 = this.f372794d;
        if (r105 == null) goto L8;
        r105.f310680b = this.f372795e;
    L8:
        if (r105 == null) goto L10;
        r105.f310681c = this.f372796f;
    L10:
        RecyclerView r106 = this.f372798h;
        if (r106 == null) goto L13;
        r106.setAdapter(r105);
    L13:
        ImageAdapter r107 = this.f372794d;
        if (r107 == null) goto L16;
        r107.registerAdapterDataObserver(new AbsBigImageDetailFragment$initAdapter$1());
    L16:
        ImageAdapter r108 = this.f372794d;
        if (r108 == null) goto L19;
        r108.f310685g = new b(this);
    L19:
        RecyclerView r109 = this.f372798h;
        if (r109 == null) goto L22;
        NonScrollableLinearLayoutManager r110 = new NonScrollableLinearLayoutManager(getContext());
        r110.setOrientation(0);
        r109.setLayoutManager(r110);
    L22:
        RecyclerView r111 = this.f372798h;
        if (r111 == null) goto L25;
        RecyclerView.LayoutManager r112 = r111.getLayoutManager();
    L26:
        this.f372803m = OrientationHelper.createVerticalHelper(r112);
        RecyclerView r113 = this.f372798h;
        if (r113 == null) goto L30;
        r113.scrollToPosition(0);
    L30:
        if (this.f372802l == 0) goto L34;
        this.f372802l = 0;
        Function1<? super Integer, Unit> r114 = this.f372797g;
        if (r114 == null) goto L34;
        r114.invoke(0);
    L34:
        FrameLayout r115 = this.f372799i;
        if (r115 == null) goto L39;
        Drawable r116 = r115.getBackground();
        if (r116 == null) goto L39;
        r116.setAlpha(255);
    L39:
        Integer r117 = T90();
        if (r117 == null) goto L44;
        View r118 = getLayoutInflater().inflate(r117.intValue(), this.f372799i, false);
        this.f372800j = r118;
        FrameLayout r119 = this.f372799i;
        if (r119 == null) goto L44;
        r119.addView(r118, new FrameLayout.LayoutParams(-1, -1));
    L44:
        LarusImageDetailLayoutBinding r120 = this.f372801k;
        if (r120 != null) goto L47;
        return null;
    L47:
        return r120.f350913a;
    L25:
        r112 = null;
        goto L26
    }
}
