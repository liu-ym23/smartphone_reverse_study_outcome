package com.larksuite.component.ui.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.larksuite.component.universe_design.dialog.UDListDialogController;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public class g extends UDListDialogController {
    @Override // com.larksuite.component.universe_design.dialog.UDListDialogController, com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateContent() {
        if (getMContentLayoutRes() == 0) goto L5;
        View r100 = LayoutInflater.from(getContext()).inflate(getMContentLayoutRes(), null);
        setMContentLayoutRes(0);
    L6:
        setMContentLayout(r100);
        View r101 = getMContentLayout();
        if (r101 == null) goto L10;
        TraverseLayoutChildIdUtilsKt.a(r101);
    L10:
        return super.onCreateContent();
    L5:
        r100 = getMContentLayout();
        goto L6
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateFooter() {
        if (getMFooterLayoutRes() == 0) goto L5;
        View r100 = LayoutInflater.from(getContext()).inflate(getMFooterLayoutRes(), null);
        setMFooterLayoutRes(0);
    L6:
        setMFooterLayout(r100);
        View r101 = getMFooterLayout();
        if (r101 == null) goto L10;
        TraverseLayoutChildIdUtilsKt.a(r101);
    L10:
        return super.onCreateFooter();
    L5:
        r100 = getMFooterLayout();
        goto L6
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateHeader() {
        if (getMHeaderLayoutRes() == 0) goto L5;
        View r100 = LayoutInflater.from(getContext()).inflate(getMHeaderLayoutRes(), null);
        setMHeaderLayoutRes(0);
    L6:
        setMHeaderLayout(r100);
        View r101 = getMHeaderLayout();
        if (r101 == null) goto L10;
        TraverseLayoutChildIdUtilsKt.a(r101);
    L10:
        return super.onCreateHeader();
    L5:
        r100 = getMHeaderLayout();
        goto L6
    }

    public g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}
