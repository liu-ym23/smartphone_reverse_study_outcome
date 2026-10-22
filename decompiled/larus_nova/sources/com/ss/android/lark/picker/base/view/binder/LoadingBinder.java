package com.ss.android.lark.picker.base.view.binder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.view.SpotlightLoadingViewHolder;
import com.ss.android.lark.search.dto.info.SearchLoadingFooterInfo;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import y9c.d;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/LoadingBinder;", "Lcom/ss/android/lark/picker/base/view/binder/IViewBinder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "loadingDrawable", "Lcom/larksuite/component/universe_design/loading/UDLoadingDrawable;", "getLoadingDrawable", "()Lcom/larksuite/component/universe_design/loading/UDLoadingDrawable;", "icon", "Landroid/graphics/drawable/Drawable;", "getIcon", "()Landroid/graphics/drawable/Drawable;", "bind", "", "position", "", "data", "Lcom/ss/android/lark/search/dto/info/SearchLoadingFooterInfo;", "holder", "Lcom/ss/android/lark/picker/base/view/SpotlightLoadingViewHolder;", "Companion", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoadingBinder implements IViewBinder {
    public static final Companion Companion = null;
    private static final String TAG = "LarkSearch.Common.LoadingBinder";
    private final Context context;
    private final Drawable icon;
    private final UDLoadingDrawable loadingDrawable;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/LoadingBinder$Companion;", "", "<init>", "()V", "TAG", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public final Context getContext() {
        return this.context;
    }

    public final Drawable getIcon() {
        return this.icon;
    }

    public final UDLoadingDrawable getLoadingDrawable() {
        return this.loadingDrawable;
    }

    public LoadingBinder(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
        UDLoadingDrawable r101 = new UDLoadingDrawable(r100);
        r101.setColorSchemeColors(new int[]{d.c(r100, R.color.primary_fill_default)});
        this.loadingDrawable = r101;
        Drawable r102 = UIHelper.getDrawable(R.drawable.ud_icon_cloud_failed_outlined);
        r102.setTint(UIHelper.getColor(R.color.icon_n3));
        this.icon = r102;
    }

    public final void bind(int r100, SearchLoadingFooterInfo r101, SpotlightLoadingViewHolder r102) {
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "holder");
        LinearLayout r103 = r102.getBinding().pickerSpotlightLoading;
        LinearLayout r104 = r102.getBinding().pickerNetLoadingFail;
        r102.getBinding().pickerNetLoadingFailIcon.setImageDrawable(this.icon);
        if (r101.isLoading() == false) goto L5;
        r103.setVisibility(0);
        r104.setVisibility(8);
        r102.getBinding().searchNetLoadingIv.setImageDrawable(this.loadingDrawable);
        this.loadingDrawable.stop();
        this.loadingDrawable.start();
        return;
    L5:
        r103.setVisibility(8);
        r104.setVisibility(0);
        this.loadingDrawable.stop();
    }
}
