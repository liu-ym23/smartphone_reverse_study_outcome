package com.bytedance.ee.bear.bitable.itemview.record.list;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.bitable.itemview.record.ItemViewRecordEditorScrollManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e extends View implements gv4.b<PlaceHolderItemData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ItemViewRecordEditorScrollManager f214148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f214149b;

    public final void setIsBottom(boolean r100) {
        this.f214149b = r100;
    }

    public e(ItemViewRecordEditorScrollManager r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r101, null);
        this.f214148a = r100;
    }
}
