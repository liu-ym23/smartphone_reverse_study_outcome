package com.ss.android.ugc.aweme.search.common.list.utils;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.common.result.WrapContentStaggeredGridLayoutManager;
import com.ss.android.ugc.aweme.search.common.saas.ECSearchSaaSDepsHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/list/utils/ItemShowReporter;", "", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ItemShowReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f451698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, List<PendingTask>> f451699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WrapContentStaggeredGridLayoutManager f451700c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/list/utils/ItemShowReporter$Companion;", "", "()V", "TAG", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    public final void b() {
        final RecyclerView r100 = this.f451698a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.post(new ItemShowReporter$onLayoutChildren$1(this, r100));
    }

    public ItemShowReporter(WrapContentStaggeredGridLayoutManager r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutManager");
        this.f451700c = r100;
        this.f451699b = new LinkedHashMap();
    }

    public final void a(RecyclerView r100, int r101, String r110) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r110, "source");
        if (this.f451699b.isEmpty() == false) goto L5;
        return;
    L5:
        int r102 = this.f451700c.getChildCount();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L39;
        View r104 = r100.getChildAt(r103);
        if (r104 == null) goto L36;
        int r105 = r104.getHeight();
        if (r105 <= 0) goto L18;
        Rect r106 = new Rect();
        boolean r107 = r104.getGlobalVisibleRect(r106);
        float r108 = RangesKt.coerceAtLeast(r106.height(), 0) / r105;
        if (r107 == false) goto L18;
        ECSearchSaaSDepsHelper.f451981a.getClass();
        if (r108 < 0.01f) goto L18;
        boolean r109 = true;
    L19:
        if (r109 == false) goto L36;
    L22:
        if (r104.getParent() == null) goto L30;
        if ((r104.getParent() instanceof RecyclerView) == true) goto L30;
        Object r111 = r104.getParent();
        if (r111 == null) goto L29;
        r104 = (View) r111;
        goto L22
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L30:
        String r112 = String.valueOf(r104.hashCode());
        List r113 = (List) ((LinkedHashMap) this.f451699b).get(r112);
        if (r113 == null) goto L36;
        ArrayList r114 = new ArrayList(r113);
        r113.clear();
        Iterator r115 = r114.iterator();
        if (r115.hasNext() == true) goto L37;
        this.f451699b.remove(r112);
        goto L36
    L37:
        ((PendingTask) r115.next()).getClass();
        throw null;
    L18:
        r109 = false;
    L36:
        r103 = r103 + 1;
        goto L6
    L39:
        Logger.a("ItemShowReporter", "handleItemEffectiveExpose: " + r110 + ", dy: " + r101);
    }
}
