package com.bytedance.ee.bear.bitable.itemview.cell.cellview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.ee.bear.bitable.card.view.cell.progress.ProgressItemsAdapter;
import com.bytedance.ee.bear.bitable.common.widgets.flex.InnerRecyclerView;
import com.bytedance.ee.bear.bitable.itemview.record.list.ContainerDirection;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u0001\u001aB\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ$\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u001e\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/ProgressCell;", "Lcom/bytedance/ee/bear/bitable/common/widgets/flex/InnerRecyclerView;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKitEx2;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/ProgressCellValue;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/CellContextData;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "adapter", "Lcom/bytedance/ee/bear/bitable/card/view/cell/progress/ProgressItemsAdapter;", "setData", "", "data", "extra", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "updateLayout", "", "needFullWidth", "", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/cellvalue/NumberModel;", "remainWidth", "", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProgressCell extends InnerRecyclerView {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ProgressItemsAdapter f213833i;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f213834a = null;

        static {
            int[] r100 = new int[ContainerDirection.values().length];
            r100[ContainerDirection.HORIZONTAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ContainerDirection.VERTICAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f213834a = r100;
        }
    }

    static {
    }

    public ProgressCell(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public ProgressCell(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 4, 0);
        ProgressItemsAdapter r102 = new ProgressItemsAdapter(r100, true, true);
        this.f213833i = r102;
        setLayoutManager(new LinearLayoutManager(r100));
        setAdapter(r102);
        t(160.0f);
    }
}
