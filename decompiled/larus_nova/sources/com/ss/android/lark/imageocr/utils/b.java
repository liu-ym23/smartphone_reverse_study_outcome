package com.ss.android.lark.imageocr.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f426574a = 0;

    static {
    }

    @JvmStatic
    public static final boolean b(Context r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L17;
        Object r103 = r100.getSystemService(DataType.CLIPBOARD);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardManager r104 = (ClipboardManager) r103;
        qf7.a.f532746a.a(r104, ClipData.newPlainText("ocr_result", r101), new Token("LARK-PSDA-ocr_copy_to_clip_board"));     // Catch: Exception -> L13 SensitiveAPIException -> L15
        return true;
    L15:
        e = move-exception;
        UDToast.show(LarkContext.getApplication(), R.string.Lark_IM_CopyContent_CopyingIsForbidden_Toast);
        Log.e("ImageOCRUtils", "Copy failed:" + e);
    L13:
        e = move-exception;
        Log.e("ImageOCRUtils", "Copy failed:" + e);
    L17:
        return false;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static List c(CharSequence r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        ArrayList r102 = new ArrayList();
        int r103 = 0;
    L4:
        if (StringsKt.indexOf$default(r100, r101, r103, false, 4, null) == (-1)) goto L6;
        int r104 = StringsKt.indexOf$default(r100, r101, r103, false, 4, null);
        r102.add(Integer.valueOf(r104));
        r103 = r104 + r101.length();
        goto L4
    L6:
        return r102;
    }

    public static float a(float r100, float r101, float r102, float r103) {
        return (float) Math.sqrt(Math.pow(Math.abs(r100 - r102), 2.0d) + Math.pow(Math.abs(r101 - r103), 2.0d));
    }
}
