package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.larksuite.framework.ui.StableLinearLayoutManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013*\u0001\u0014\u0018\u0000 ;2\u00020\u0001:\u00039:;B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0018\u00010\u0019R\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001f\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170 H\u0082\bJ\u000e\u0010!\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0007J\u0006\u0010\"\u001a\u00020\u0007J\u0010\u0010#\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010%\u001a\u00020\u0007J\u0016\u0010&\u001a\u00020\u00072\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0002J\b\u0010*\u001a\u00020\u0007H\u0002J\b\u0010+\u001a\u00020\tH\u0002J\u001e\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\f\u0010.\u001a\b\u0012\u0004\u0012\u00020)0(H\u0002J \u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007H\u0016J\u001a\u00103\u001a\u00020\u00172\u0006\u00100\u001a\u00020)2\b\u00104\u001a\u0004\u0018\u00010\u001bH\u0002J(\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00072\f\u0010\u0018\u001a\b\u0018\u00010\u0019R\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J,\u00107\u001a\u00020\u0017*\u00020\u00122\u0006\u00106\u001a\u00020\u00072\f\u0010\u0018\u001a\b\u0018\u00010\u0019R\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\f\u00108\u001a\u00020\u0017*\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006<"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/AnchorItemLayoutManager;", "Lcom/larksuite/framework/ui/StableLinearLayoutManager;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "orientation", "", "reverseLayout", "", "isChildRectangleOnScreen", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/content/Context;IZZ)V", "anchorPositionProvider", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/AnchorItemLayoutManager$IAnchorPositionProvider;", "anchorBlankSpace", "anchorOffset", "measureState", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/AnchorItemLayoutManager$MeasureStateOnScroll;", "offsetDecoration", "com/ss/android/lark/chat/chatwindow/chat/v2/component/message/AnchorItemLayoutManager$offsetDecoration$1", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/AnchorItemLayoutManager$offsetDecoration$1;", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "computeTimeCostAndLog", "tag", "", "action", "Lkotlin/Function0;", "setAnchorOffset", "getAnchorOffset", "setAnchorPositionProvider", ShortVideoSegments.KEY_PROP_PROVIDER, "getAnchorBlankSpace", "findAnchorViewPosition", "children", "", "Landroid/view/View;", "findLastViewPosition", "computeAnchorSpaceIfNeed", "binSearchViewInScreen", "targetPosition", "views", "measureChildWithMargins", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "widthUsed", "heightUsed", "forceUpdateItemDecoration", "rvState", "scrollVerticallyBy", "dy", "setScrollState", BasicTestActionHandler.TEST_ACTION_RESET, "MeasureStateOnScroll", "IAnchorPositionProvider", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnchorItemLayoutManager extends StableLinearLayoutManager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<Method> f413591d = null;

    public static final class a {
    }

    static {
        f413591d = LazyKt.lazy(AnchorItemLayoutManager$Companion$method$2.INSTANCE);
    }

    @Override // com.larksuite.framework.ui.StableLinearLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        long r102 = System.currentTimeMillis();
        super.onLayoutChildren(r100, r101);
        Log.d("AnchorItemLayoutManager", "first onLayoutChildren:, cost " + (System.currentTimeMillis() - r102) + " millis");
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, com.bytedance.android.ec.vlayout.b
    public final void measureChildWithMargins(View r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        super.measureChildWithMargins(r100, r101, r102);
        throw null;
    }

    @Override // com.larksuite.framework.ui.StableLinearLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        throw null;
    }
}
