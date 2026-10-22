package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.content.Context;
import com.larus.nova.R;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.sheet.v2.OSheetTitleBar;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class t2 {
    public static final q2 a(Context r100, String r101, final Function0<Unit> r102, final Function0<Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "onClose");
        Intrinsics.checkNotNullParameter(r110, "onConfirm");
        OSheetTitleBar r103 = new OSheetTitleBar(r100, null, 6, 0);
        r103.setShowLeftBack(false);
        r103.setTitleText(r101);
        r103.getMTitleView().setTextSize(16.0f);
        com.larus.utils.e1.d(r103.d(r100, r103.getMLeftContainer(), R.drawable.oui_ic_title_bar_close, r100.getColorStateList(R.color.oui_text_1), Integer.valueOf(R.string.oui_iv_close_desc)), new r2(r102));
        OIconButtonFloating r104 = r103.e(r100, r103.getMRightContainer(), R.drawable.oui_ic_title_bar_confirm, r100.getColorStateList(R.color.oui_on_accent_default), Integer.valueOf(R.string.oui_confirm));
        com.larus.utils.e1.d(r104, new s2(r110));
        return new q2(r103, r104);
    }
}
