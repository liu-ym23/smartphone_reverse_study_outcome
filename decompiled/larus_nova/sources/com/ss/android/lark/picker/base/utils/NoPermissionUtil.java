package com.ss.android.lark.picker.base.utils;

import android.content.Context;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/picker/base/utils/NoPermissionUtil;", "", "<init>", "()V", "showNoPermissionDialog", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "tipsRes", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoPermissionUtil {
    public static final NoPermissionUtil INSTANCE = null;

    static {
        INSTANCE = new NoPermissionUtil();
    }

    private NoPermissionUtil() {
    }

    @JvmStatic
    public static final void showNoPermissionDialog(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new UDDialogBuilder(r100).title(R.string.Lark_IM_UnableToPreview_PopUpTitle).message(r101).addActionButton(R.id.ud_dialog_btn_primary, R.string.Lark_IM_UnableToPreview_PopUpButton, null).show();
    }
}
