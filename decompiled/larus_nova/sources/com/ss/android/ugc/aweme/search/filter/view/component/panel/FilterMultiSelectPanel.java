package com.ss.android.ugc.aweme.search.filter.view.component.panel;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.lighten.loader.SmartImageView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.discover.model.commodity.select.BaseSelectItemView;
import com.ss.android.ugc.aweme.discover.model.commodity.select.ItemSelectStatusChangeObserver;
import com.ss.android.ugc.aweme.discover.model.commodity.select.RenderItem;
import com.ss.android.ugc.aweme.search.filter.ECSearchAbsSelectViewHolder;
import com.ss.android.ugc.aweme.search.filter.ECSearchBaseFilterViewHolder;
import com.ss.android.ugc.aweme.search.filter.view.component.ECSearchSimpleAdapter;
import com.ss.android.ugc.aweme.search.filter.view.component.FilterMultiTextView;
import com.ss.android.ugc.aweme.search.filter.view.component.FilterMultiTextWithSubTitleView;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0007\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/component/panel/FilterMultiSelectPanel;", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/ItemSelectStatusChangeObserver;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Companion", "FilterMultiSelectAdapter", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class FilterMultiSelectPanel implements ItemSelectStatusChangeObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Float> f453163a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Float> f453164b = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/component/panel/FilterMultiSelectPanel$Companion;", "", "", "DEFAULT_RATIO", FaceService.girlLabel, "", "ITEM_HEIGHT", "I", "", "MAX_DISPLAY_ITEM", "D", "SUM_WIDTH_RATIO", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/component/panel/FilterMultiSelectPanel$FilterMultiSelectAdapter;", "Lcom/ss/android/ugc/aweme/search/filter/view/component/ECSearchSimpleAdapter;", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FilterMultiSelectAdapter extends ECSearchSimpleAdapter<RenderItem> {
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onViewRecycled(RecyclerView.ViewHolder r100) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            super.onViewRecycled(r100);
            if ((r100 instanceof ECSearchAbsSelectViewHolder) == false) goto L6;
            ECSearchBaseFilterViewHolder r101 = ((ECSearchAbsSelectViewHolder) r100).f452776a;
            r101.getClass();
            Intrinsics.checkNotNullParameter(null, "observer");
            ((ArrayList) r101.f450508d).remove(null);
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r110, int r111) {
            Intrinsics.checkNotNullParameter(r110, "parent");
            FilterMultiTextWithSubTitleView.D.getClass();
            Intrinsics.checkNotNullParameter(r110, "parent");
            Intrinsics.checkNotNullParameter(null, "panel");
            View r112 = LayoutInflater.from(r110.getContext()).inflate(R.layout.ec_search_filter_with_sub_title, r110, false);
            LinearLayout r100 = (LinearLayout) r112.findViewById(R.id.filter_common_root);
            LinearLayout r101 = (LinearLayout) r112.findViewById(R.id.filter_common_content_root);
            TextView r102 = (TextView) r112.findViewById(R.id.filter_common_text);
            SmartImageView r103 = (SmartImageView) r112.findViewById(R.id.filter_common_icon_right);
            TextView r104 = (TextView) r112.findViewById(R.id.filter_sub_title_text);
            View r113 = r112.findViewById(R.id.filter_common_bg);
            if (r113 == null) goto L5;
            r113.setVisibility(8);
        L5:
            final FilterMultiTextWithSubTitleView r114 = new FilterMultiTextWithSubTitleView(null, r100, r101, r103, r102, r104);
            r114.A = 0.0f;
            View r115 = r114.f452782j;
            float r105 = 14;
            Resources r106 = Resources.getSystem();
            int r107 = MathKt.roundToInt(TypedValue.applyDimension(1, r105, WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics())));
            Resources r108 = Resources.getSystem();
            r115.setPadding(0, r107, 0, MathKt.roundToInt(TypedValue.applyDimension(1, r105, WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics()))));
            View r116 = r114.f452782j;
            ViewGroup.LayoutParams r109 = r116.getLayoutParams();
            r109.width = -1;
            r109.height = -2;
            Unit r117 = Unit.INSTANCE;
            r116.setLayoutParams(r109);
            LinearLayout r118 = r114.f453048t;
            if (r118 == null) goto L8;
            r118.setGravity(19);
        L8:
            LinearLayout r119 = r114.f453048t;
            if (r119 == null) goto L17;
            ViewGroup.LayoutParams r120 = r119.getLayoutParams();
            FrameLayout.LayoutParams r121 = null;
            if ((r120 instanceof FrameLayout.LayoutParams) == true) goto L13;
            r120 = null;
        L13:
            FrameLayout.LayoutParams r122 = (FrameLayout.LayoutParams) r120;
            if (r122 == null) goto L16;
            r122.gravity = 19;
            r121 = r122;
        L16:
            r119.setLayoutParams(r121);
        L17:
            r114.f452778f = true;
            r114.f453044p = FilterMultiSelectPanel$FilterMultiSelectAdapter$onCreateViewHolder$filterTextView$1$3.INSTANCE;
            return new FilterMultiSelectPanel$FilterMultiSelectAdapter$onCreateViewHolder$1(r114);
        }

        @Override // com.ss.android.ugc.aweme.search.filter.view.component.ECSearchSimpleAdapter
        public final void y2(RecyclerView.ViewHolder r100, int r101, RenderItem r102) {
            RenderItem r103 = r102;
            Intrinsics.checkNotNullParameter(r100, "holder");
            if (r103 == null) goto L23;
            ECSearchBaseFilterViewHolder r104 = null;
            if ((r100 instanceof ECSearchAbsSelectViewHolder) == true) goto L8;
            r100 = null;
        L8:
            ECSearchAbsSelectViewHolder r105 = (ECSearchAbsSelectViewHolder) r100;
            if (r105 == null) goto L24;
            ECSearchBaseFilterViewHolder r106 = r105.f452776a;
            r106.a(MiPushClient.COMMAND_UNREGISTER);
            RenderItem r107 = r106.f450505a;
            if (r107 == null) goto L14;
            r107.setRenderView(null);
        L14:
            r105.f452776a.l(null, r103);
            ECSearchBaseFilterViewHolder r108 = r105.f452776a;
            if ((r108 instanceof FilterMultiTextView) == false) goto L18;
            r104 = r108;
        L18:
            FilterMultiTextView r109 = (FilterMultiTextView) r104;
            if (r109 == null) goto L21;
            r109.getClass();
        L21:
            r108.getClass();
            Intrinsics.checkNotNullParameter(null, "observer");
            ((ArrayList) r108.f450508d).remove(null);
            ECSearchBaseFilterViewHolder r110 = r105.f452776a;
            r110.getClass();
            Intrinsics.checkNotNullParameter(null, "observer");
            ((ArrayList) r110.f450508d).add(null);
            return;
        L24:
            return;
        }
    }

    public final Context getContext() {
        return null;
    }

    static {
        new Companion(0);
        f453163a = CollectionsKt.listOf(new Float[]{Float.valueOf(100.0f), Float.valueOf(70.0f), Float.valueOf(40.0f)});
        Float r100 = Float.valueOf(30.0f);
        f453164b = CollectionsKt.listOf(new Float[]{r100, r100, r100});
    }

    @Override // com.ss.android.ugc.aweme.discover.model.commodity.select.ItemSelectStatusChangeObserver
    public final void a(BaseSelectItemView r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        RenderItem r101 = r100.f450505a;
        if (r101 == null) goto L5;
        List<RenderItem> r102 = r101.getChildrenComponent();
    L6:
        List<RenderItem> r103 = r102;
        if (r103 == null) goto L10;
        r103.isEmpty();
        return;
    L10:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
