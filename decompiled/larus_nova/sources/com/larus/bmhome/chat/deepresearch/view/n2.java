package com.larus.bmhome.chat.deepresearch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.larus.im.bean.message.block.Block;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class n2 extends AbsFoldableHeaderBlockView {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public j2 f302500n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f302501o;

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsFoldableHeaderBlockView
    public final boolean d() {
        return this.f302501o;
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsFoldableHeaderBlockView
    public View getContentBlockView() {
        return this.f302500n;
    }

    public n2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f302501o = true;
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsFoldableHeaderBlockView, com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void a(final Block r100, Map<String, Object> r101) {
        List r102 = AbsBlockView.a.c(r100);
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        boolean r104 = !r103;
        this.f302501o = r104;
        if (r104 == true) goto L20;
        Map r105 = null;
        if (r101 == null) goto L14;
        Object r106 = r101.get("block_view_extra_fold_states");
    L16:
        if (TypeIntrinsics.isMutableMap(r106) == false) goto L18;
        r105 = (Map) r106;
    L18:
        if (r105 == null) goto L20;
        Boolean r107 = (Boolean) r105.put(e(r100), Boolean.TRUE);
        goto L20
    L14:
        r106 = null;
    L20:
        j2 r108 = this.f302500n;
        if (r108 == null) goto L23;
        r108.a(r100, r101);
    L23:
        super.a(r100, r101);
        ExposureTrackerExtKt.a(this, new k2(this, r100));
        return;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsFoldableHeaderBlockView, com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void b(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.b(r100, r101);
        j2 r102 = new j2(r100);
        this.f302500n = r102;
        addView(r102, new LinearLayout.LayoutParams(-1, -2));
    }
}
