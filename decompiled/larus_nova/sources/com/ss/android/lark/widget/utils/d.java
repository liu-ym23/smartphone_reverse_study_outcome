package com.ss.android.lark.widget.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDListDialogController;
import com.larksuite.component.universe_design.dialog.actionpanel.UDActionPanelBuilder;
import com.larus.nova.R;
import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFiles;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f449079a = 0;

    static {
    }

    @JvmStatic
    public static final boolean b(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r101, MimeType.GIF) == false) goto L9;
        return true;
    L9:
        if (Intrinsics.areEqual(r101, MimeType.WEBP) == true) goto L11;
        return false;
    L11:
        if (ImageUtils.f444666d == false) goto L20;
        VFSFiles r102 = VFSFiles.f444819b;
        if (r100 != null) goto L16;
        r100 = "";
    L16:
        return ImageUtils.e(r102.i(r100));
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final UDDialog a(Context r100, List<? extends CharSequence> r101, UDListDialogController.OnItemClickListener r102, DialogInterface.OnClickListener r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "items");
        Intrinsics.checkNotNullParameter(r102, "clickListener");
        Intrinsics.checkNotNullParameter(r103, "onCancel");
        return ((UDActionPanelBuilder) ((UDActionPanelBuilder) new UDActionPanelBuilder(r100).items(r101).itemClickListener(r102).addActionButton(R.id.ud_dialog_btn_cancel, R.string.Lark_Legacy_Cancel, r103)).maxWidth(b.f449077b)).build();
    }
}
