package com.ss.android.ugc.aweme.search.filter.view.good;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.discover.model.commodity.select.RenderItem;
import com.ss.android.ugc.aweme.search.common.utils.ViewExtKt;
import com.ss.android.ugc.aweme.search.filter.ECSearchBaseFilterViewHolder;
import com.ss.android.ugc.aweme.search.filter.ECSearchFilterViewModel;
import com.ss.android.ugc.aweme.search.utils.extensions.DimenExtensionsKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/good/GoodSelectSlideSlipView;", "Lcom/ss/android/ugc/aweme/search/filter/ECSearchBaseFilterViewHolder;", "Companion", "ItemCreator", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GoodSelectSlideSlipView extends ECSearchBaseFilterViewHolder {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Companion f453242m = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ItemCreator f453243k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f453244l;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/good/GoodSelectSlideSlipView$Companion;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/good/GoodSelectSlideSlipView$ItemCreator;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface ItemCreator {
        ECSearchBaseFilterViewHolder a(ViewGroup r100, String r101);
    }

    static {
        f453242m = new Companion(0);
    }

    public GoodSelectSlideSlipView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }

    @Override // com.ss.android.ugc.aweme.search.filter.ECSearchBaseFilterViewHolder
    public final void l(ECSearchFilterViewModel r110, RenderItem r111) {
        Intrinsics.checkNotNullParameter(r110, "viewModel");
        Intrinsics.checkNotNullParameter(r111, "renderItem");
        super.l(r110, r111);
        LinearLayout r100 = (LinearLayout) this.f452782j.findViewById(R.id.item_container);
        if (r100 != null) goto L5;
        return;
    L5:
        Integer r101 = r111.getUiMode();
        List<RenderItem> r102 = r111.getChildrenComponent();
        if (r102 == null) goto L42;
        Iterator<T> r103 = r102.iterator();
        int r104 = 0;
        int r105 = 0;
    L9:
        if (r103.hasNext() == false) goto L42;
        Object r106 = r103.next();
        int r107 = r104 + 1;
        if (r104 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        RenderItem r108 = (RenderItem) r106;
        String r109 = r108.getComponentId();
        if (r109 == null) goto L41;
        ItemCreator r112 = this.f453243k;
        if (r112 == null) goto L41;
        ECSearchBaseFilterViewHolder r113 = r112.a(r100, r109);
        if (r113 == null) goto L41;
        r113.f450507c = r105;
        View r114 = r113.f452782j;
        r100.addView(r114);
        r105 = r105 + 1;
        Float r115 = r108.getWidth();
        Float r116 = r108.getHeight();
        if (r114.getLayoutParams() == null) goto L33;
        ViewGroup.LayoutParams r117 = r114.getLayoutParams();
        if (r117 == null) goto L31;
        if (r115 == null) goto L28;
        r117.width = DimenExtensionsKt.b(r115);
    L28:
        if (r116 == null) goto L30;
        r117.height = DimenExtensionsKt.b(r116);
    L30:
        Unit r118 = Unit.INSTANCE;
    L32:
        r114.setLayoutParams(r117);
        goto L33
    L31:
        r117 = null;
    L33:
        if (r104 < 0) goto L40;
        List<RenderItem> r119 = r111.getChildrenComponent();
        if (r119 == null) goto L37;
        int r120 = r119.size();
    L38:
        if (r104 == r120) goto L40;
        ViewExtKt.n(r114, DimenExtensionsKt.b(Integer.valueOf(this.f453244l)));
        goto L40
    L37:
        r120 = -1;
    L40:
        r108.setUiMode(r101);
        r113.l(r110, r108);
    L41:
        r104 = r107;
    L42:
        this.f452782j.post(new GoodSelectSlideSlipView$bind$2(this));
    }
}
