package com.ss.android.lark.keyboard.editor.input;

import android.content.Context;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.keyboard.edittext2.edittors.image.ImageEditor;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class l extends ImageEditor {
    public l() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.image.ImageEditor
    public final Object V(Context r100, hob.f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "insertImageInfo");
        if (com.ss.android.lark.keyboard.edittext2.utils.d.a("im.keyboard.editor_support_view") == false) goto L7;
        com.ss.android.lark.keyboard.edittext2.edittors.image.a r102 = new com.ss.android.lark.keyboard.edittext2.edittors.image.a(r101.f486327a);
        r102.f429064b = UIUtils.dp2px(context(), 2.0f);
        r102.f429065c = UIUtils.dp2px(context(), 1.0f);
        r102.f429066d = r101.f486331e;
        return r102;
    L7:
        return super.V(r100, r101);
    }
}
