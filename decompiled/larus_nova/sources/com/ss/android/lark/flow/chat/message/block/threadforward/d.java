package com.ss.android.lark.flow.chat.message.block.threadforward;

import android.view.View;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.chat.base.view.vo.message.ThreadForwardContentVOV2;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m<y6b.a<ThreadForwardContentVOV2>> f422512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlowThreadForwardHeaderBlock f422513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ y6b.a<ThreadForwardContentVOV2> f422514c;

    public d(m<y6b.a<ThreadForwardContentVOV2>> r100, FlowThreadForwardHeaderBlock r101, y6b.a<ThreadForwardContentVOV2> r102) {
        this.f422512a = r100;
        this.f422513b = r101;
        this.f422514c = r102;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        m<y6b.a<ThreadForwardContentVOV2>> r101 = this.f422512a;
        if ((r101 instanceof e6b.b) == false) goto L5;
        e6b.b r102 = (e6b.b) r101;
    L6:
        if (r102 != null) goto L10;
        return false;
    L10:
        return r102.e(this.f422513b, this.f422514c);
    L5:
        r102 = null;
        goto L6
    }
}
