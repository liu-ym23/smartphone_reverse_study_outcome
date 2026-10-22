package com.bytedance.ee.bear.bitable.itemview.record.list;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.ee.bear.bitable.itemview.record.ItemViewRecordEditorScrollManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends FrameLayout implements gv4.b<HorizontalContainer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f214131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HorizontalRecyclerView f214132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ItemViewRenderItemAdapter f214133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f214134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f214135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f214136f;

    public static final class a {
    }

    static {
    }

    public b(ItemViewRecordEditorScrollManager r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r101, null);
        this.f214135e = -1;
        HorizontalRecyclerView r102 = new HorizontalRecyclerView(r101, null, 6, 0);
        this.f214132b = r102;
        ItemViewRenderItemAdapter r103 = new ItemViewRenderItemAdapter(r100, ContainerDirection.HORIZONTAL);
        this.f214133c = r103;
        r102.setLayoutManager(new LinearLayoutManager(r101, 0, false));
        r102.setAdapter(r103);
        addView(r102, new FrameLayout.LayoutParams(-1, -2));
    }
}
