package com.larus.home.impl.main.side_bar.view.adapter;

import android.view.View;
import android.widget.CheckBox;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 ,2\u00020\u0001:\u0001,Bt\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012Q\u0010\b\u001aM\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\t¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010*\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\nJ\u001a\u0010+\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\nH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000RY\u0010\b\u001aM\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R#\u0010\u001c\u001a\n \u0017*\u0004\u0018\u00010\u001d0\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b\u001e\u0010\u001fR#\u0010!\u001a\n \u0017*\u0004\u0018\u00010\"0\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b#\u0010$R\u0010\u0010&\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/adapter/SideBarCaseHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "contentBridge", "Lcom/larus/home/impl/main/side_bar/view/ISideBarContentBridge;", "conversationBridge", "Lcom/larus/home/impl/main/side_bar/view/ISideBarCaseBridge;", "onItemClicked", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/larus/home/impl/main/side_bar/data/SideBarItemConfig;", "config", "", "clickType", "", "<init>", "(Landroid/view/View;Lcom/larus/home/impl/main/side_bar/view/ISideBarContentBridge;Lcom/larus/home/impl/main/side_bar/view/ISideBarCaseBridge;Lkotlin/jvm/functions/Function3;)V", "caseTitle", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getCaseTitle", "()Landroid/widget/TextView;", "caseTitle$delegate", "Lkotlin/Lazy;", "caseCheckbox", "Landroid/widget/CheckBox;", "getCaseCheckbox", "()Landroid/widget/CheckBox;", "caseCheckbox$delegate", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "getContainer", "()Landroid/view/ViewGroup;", "container$delegate", "itemConfig", "itemPosition", "isCodeOperator", "", "bind", "initEvents", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SideBarCaseHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f344883g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.home.impl.main.side_bar.view.b f344884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function3<Integer, com.larus.home.impl.main.side_bar.data.j0, String, Unit> f344885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f344886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f344887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f344888e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f344889f;

    public static final class a {
    }

    static {
    }

    public final CheckBox T3() {
        return (CheckBox) this.f344887d.getValue();
    }

    public SideBarCaseHolder(final View r100, com.larus.home.impl.main.side_bar.view.b r101, com.larus.home.impl.main.side_bar.view.a r102, j r103) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r102, "conversationBridge");
        super(r100);
        this.f344884a = r101;
        this.f344885b = r103;
        this.f344886c = LazyKt.lazy(new l(r100));
        this.f344887d = LazyKt.lazy(new m(r100));
        this.f344888e = LazyKt.lazy(new n(r100));
        x0.c(r100, false);
    }
}
