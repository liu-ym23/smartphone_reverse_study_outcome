package com.ss.android.lark.coremd.facade.bizext.image;

import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.coremd.base.parse.i;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.span.BorderProperty;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class BorderPropertyFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BorderPropertyFactory f419637a = null;

    static {
        f419637a = new BorderPropertyFactory();
    }

    public BorderPropertyFactory() {
    }

    public static BorderProperty a(final i r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (((Boolean) IMContextExtend.A.b(new BorderPropertyFactory$imageThread$isGroupAnnouncement$1(r100))).booleanValue() == false) goto L7;
        return new BorderProperty(0, 0, 0);
    L7:
        return new BorderProperty(UIUtils.getColor(r100.getContext(), R.color.line_border_component), UIHelper.dp2px(0.5f), UIHelper.dp2px(4.0f));
    }
}
