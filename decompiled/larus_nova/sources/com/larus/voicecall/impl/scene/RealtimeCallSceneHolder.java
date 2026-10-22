package com.larus.voicecall.impl.scene;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.av_call.constant.ThemeType;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \f*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \f*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \f*\u0004\u0018\u00010\u00150\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/voicecall/impl/scene/RealtimeCallSceneHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "themeType", "Lcom/larus/av_call/constant/ThemeType;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/av_call/constant/ThemeType;Landroid/view/View;)V", "getThemeType", "()Lcom/larus/av_call/constant/ThemeType;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "kotlin.jvm.PlatformType", "sceneTitle", "Landroid/widget/TextView;", "sceneDesc", "sceneIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "sceneLoading", "Landroid/widget/ProgressBar;", "sceneIconArea", "Landroid/widget/FrameLayout;", "colorAnimator", "Landroid/animation/ObjectAnimator;", "bindData", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/voicecall/impl/scene/SceneDisplayItem;", "closeClick", "Lkotlin/Function0;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallSceneHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f378701h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThemeType f378702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f378703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f378704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f378705d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SimpleDraweeView f378706e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ProgressBar f378707f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FrameLayout f378708g;

    public RealtimeCallSceneHolder(ThemeType r100, ConstraintLayout r101) {
        Intrinsics.checkNotNullParameter(r100, "themeType");
        Intrinsics.checkNotNullParameter(r101, "itemView");
        super(r101);
        this.f378702a = r100;
        this.f378703b = r101.getContext();
        this.f378704c = (TextView) r101.findViewById(R.id.scene_title);
        this.f378705d = (TextView) r101.findViewById(R.id.scene_desc);
        this.f378706e = (SimpleDraweeView) r101.findViewById(R.id.scene_icon);
        this.f378707f = (ProgressBar) r101.findViewById(R.id.scene_loading);
        this.f378708g = (FrameLayout) r101.findViewById(R.id.scene_icon_area);
    }
}
