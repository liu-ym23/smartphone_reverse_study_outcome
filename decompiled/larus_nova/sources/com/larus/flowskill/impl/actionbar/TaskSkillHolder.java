package com.larus.flowskill.impl.actionbar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hihonor.honorid.core.data.UserInfo;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.view.actionbar.BaseActionBarHolder;
import com.larus.bmhome.view.actionbar.custom.t1;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u0000 @2\u00020\u0001:\u0001@B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\b\u0010\u001f\u001a\u00020\u001cH\u0016J\u0012\u0010 \u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0016\u0010#\u001a\u00020\u001c2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u000fH\u0002J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001aH\u0002J\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u000bH\u0002J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020\"H\u0002J\u0010\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u00020'H\u0002J\u001a\u00102\u001a\u00020'2\u0006\u0010+\u001a\u00020\u000b2\b\u00103\u001a\u0004\u0018\u00010\"H\u0002J\u0018\u00104\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00105\u001a\u00020'H\u0002J\u001a\u00106\u001a\u00020\u001a2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u00105\u001a\u00020'H\u0002J\u0018\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020<H\u0002J\u0013\u0010=\u001a\u0004\u0018\u00010\u001a*\u00020\"H\u0002¢\u0006\u0002\u0010>J\u0013\u0010?\u001a\u0004\u0018\u00010\u001a*\u00020\"H\u0002¢\u0006\u0002\u0010>R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/larus/flowskill/impl/actionbar/TaskSkillHolder;", "Lcom/larus/bmhome/view/actionbar/BaseActionBarHolder;", "itemView", "Landroid/view/View;", "callback", "Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "<init>", "(Landroid/view/View;Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;Lcom/larus/ui/arch/context/external/VContext;)V", "icon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "connectorIconGroup", "Landroid/widget/FrameLayout;", "connectorIcons", "", "connectorIconContainers", "connectorIconBorders", "name", "Landroid/widget/TextView;", "dot", "arrow", "Landroid/widget/ImageView;", "roundViewDelegate", "Lcom/larus/common_ui/widget/roundlayout/RoundViewDelegate;", "iconBindGeneration", "", "bindData", "", "data", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "onViewRecycle", "bindSingleIcon", "iconUrl", "", "bindConnectorIcons", "iconUrls", "setConnectorIconsVisible", "visible", "", "setAllConnectorIconBordersVisibility", RemoteMessageConst.Notification.VISIBILITY, "clearIcon", "imageView", "buildMergedNameWithDot", "", UserInfo.FIRSTNAME, "secondName", "applyMaskStyle", "isMergedEntry", "setLocalResourceIcon", "url", "resolveArrowTintColor", "isDarkMode", "applyDisplayExtra", "extra", "Lcom/larus/bmhome/actionbar/model/ActionBarUIDisplayExtra;", "applyAlpha", "color", "alpha", "", "toColorIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "toLocalResIdOrNull", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskSkillHolder extends BaseActionBarHolder {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f343475m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t1 f343476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t1a.b f343477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f343478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f343479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<SimpleDraweeView> f343480e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<FrameLayout> f343481f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<List<View>> f343482g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f343483h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f343484i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ImageView f343485j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c29.a f343486k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f343487l;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.view.actionbar.BaseActionBarHolder
    public final void T3() {
        this.f343487l++;
        ImageLoaderKt.d(this.f343478c);
        Iterator<T> r100 = this.f343480e.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ImageLoaderKt.d((SimpleDraweeView) r100.next());
        goto L4
    L6:
        ExposeXTrackerExtKt.e(this.itemView);
    }

    public final void U3(int r100) {
        Iterator r101 = CollectionsKt.flatten(this.f343482g).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((View) r101.next()).setVisibility(r100);
        goto L4
    }

    public final void V3(boolean r100) {
        SimpleDraweeView r101 = this.f343478c;
        int r102 = 8;
        if (r100 == false) goto L5;
        int r103 = 8;
    L6:
        r101.setVisibility(r103);
        FrameLayout r104 = this.f343479d;
        if (r100 == false) goto L9;
        float r105 = 1.0f;
    L10:
        r104.setAlpha(r105);
        if (r100 == false) goto L13;
        int r106 = -2;
    L15:
        if (this.f343479d.getLayoutParams().width == r106) goto L17;
        FrameLayout r107 = this.f343479d;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        r108.width = r106;
        r107.setLayoutParams(r108);
    L17:
        if (r100 == false) goto L19;
        r102 = 0;
    L19:
        U3(r102);
        return;
    L13:
        r106 = 0;
        goto L15
    L9:
        r105 = 0.0f;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TaskSkillHolder(View r100, t1 r101, t1a.b r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "vContext");
        super(r100);
        this.f343476a = r101;
        this.f343477b = r102;
        this.f343478c = (SimpleDraweeView) r100.findViewById(R.id.ic_item_img);
        this.f343479d = (FrameLayout) r100.findViewById(R.id.fl_connector_icons);
        this.f343480e = CollectionsKt.listOf(new SimpleDraweeView[]{r100.findViewById(R.id.ic_connector_img_first), r100.findViewById(R.id.ic_item_img_second), r100.findViewById(R.id.ic_item_img_third)});
        this.f343481f = CollectionsKt.listOf(new FrameLayout[]{r100.findViewById(R.id.fl_item_icon_first), r100.findViewById(R.id.fl_item_icon_second), r100.findViewById(R.id.fl_item_icon_third)});
        this.f343482g = CollectionsKt.listOf(new List[]{CollectionsKt.listOf(new View[]{r100.findViewById(R.id.v_item_icon_outer_border_first), r100.findViewById(R.id.v_item_icon_border_first)}), CollectionsKt.listOf(new View[]{r100.findViewById(R.id.v_item_icon_outer_border_second), r100.findViewById(R.id.v_item_icon_border_second)}), CollectionsKt.listOf(new View[]{r100.findViewById(R.id.v_item_icon_outer_border_third), r100.findViewById(R.id.v_item_icon_border_third)})});
        this.f343483h = (TextView) r100.findViewById(R.id.tv_item_name);
        this.f343484i = r100.findViewById(R.id.v_item_dot);
        this.f343485j = (ImageView) r100.findViewById(R.id.iv_item_arrow);
        c29.a r103 = null;
        if ((r100 instanceof RoundConstraintLayout) == false) goto L5;
        RoundConstraintLayout r104 = (RoundConstraintLayout) r100;
    L6:
        if (r104 == null) goto L8;
        r103 = r104.getDelegate();
    L8:
        this.f343486k = r103;
        return;
    L5:
        r104 = null;
        goto L6
    }
}
