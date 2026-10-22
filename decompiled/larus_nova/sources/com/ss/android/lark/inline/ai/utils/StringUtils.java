package com.ss.android.lark.inline.ai.utils;

import androidx.core.content.ContextCompat;
import com.larksuite.framework.utils.l0;
import com.larus.nova.R;
import com.ss.android.lark.inline.ai.api.InlineAIErrorCode;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes36.dex */
public final class StringUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StringUtils f427693a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f427694b = null;

    public StringUtils() {
    }

    static {
        f427693a = new StringUtils();
        f427694b = "<span style='color: #" + Integer.toHexString(ContextCompat.getColor(LarkContext.getApplication(), R.color.function_info_content_default)).substring(2).toUpperCase(Locale.ROOT) + "'>";
    }

    public static String a() {
        return ((xzb.a) ApiUtils.getApi(xzb.a.class)).getUserId() + "-" + l0.a().toString();
    }

    public static String b(int r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl((nsb.b) LarkContext.spiByDwarf(nsb.b.class));     // Catch: Throwable -> L4
    L6:
        String r103 = null;
        if (Result.m9455isFailureimpl(r102) == false) goto L9;
        r102 = null;
    L9:
        nsb.b r104 = (nsb.b) r102;
        if (r104 == null) goto L14;
        i1<String> r105 = r104.a();
        if (r105 == null) goto L14;
        r103 = r105.getValue();
    L14:
        if (r104 == null) goto L19;
        i1<com.ss.android.lark.myai.export.c> r106 = r104.W();
        if (r106 == null) goto L19;
        com.ss.android.lark.myai.export.c r107 = r106.getValue();
    L19:
        if (r103 != null) goto L22;
        r103 = "AiNickname";
    L22:
        if (r100 != InlineAIErrorCode.INLINEAI_ADMINDEACTIVATED_CODE.getValue()) goto L25;
        String r108 = UIHelper.mustacheFormat(UIHelper.getString(R.string.LarkCCM_Docs_MyAi_AdminDeactivated_aiName_Toast), "aiName", r103);
        Intrinsics.checkNotNull(r108);
        return r108;
    L25:
        if (r100 != InlineAIErrorCode.InlineAI_CROSS_REGION_ERROR.getValue()) goto L28;
        String r109 = UIHelper.mustacheFormat(UIHelper.getString(R.string.LarkCCM_Docs_MyAI_UnavailRegion_aiName_Text), "aiName", r103);
        Intrinsics.checkNotNull(r109);
        return r109;
    L28:
        if (r100 != InlineAIErrorCode.InlineAI_CROSS_BRAND_ERROR.getValue()) goto L30;
        String r110 = UIHelper.mustacheFormat(UIHelper.getString(R.string.LarkCCM_Docs_MyAI_LogInToUse_aiName_Text), "aiName", r103);
        Intrinsics.checkNotNull(r110);
        return r110;
    L30:
        String r111 = UIHelper.mustacheFormat(R.string.LarkCCM_Docs_MyAi_Custom_NotAvail_Toast, "AiNickname", r103);
        Intrinsics.checkNotNull(r111);
        return r111;
    L4:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public static String d(int r100) {
        return LarkContext.getApplication().getString(r100);
    }

    public static String c(String r100, String r101) {
        if (r100 == null) goto L30;
        if (r101 == null) goto L30;
        Regex r102 = new Regex(r101);
        int r103 = 0;
        List r104 = SequencesKt.toList(SequencesKt.map(Regex.findAll$default(r102, r100, 0, 2, null), StringUtils$highlightAsHtml$indexes$1.INSTANCE));
        ArrayList r105 = new ArrayList();
        IntRange r106 = IntRange.Companion.getEMPTY();
        Iterator r107 = r104.iterator();
    L7:
        if (r107.hasNext() == false) goto L16;
        IntRange r108 = (IntRange) r107.next();
        IntRange.Companion r109 = IntRange.Companion;
        if (Intrinsics.areEqual(r106, r109.getEMPTY()) == true) goto L10;
        if (r108.getFirst() <= r106.getLast()) goto L13;
        r105.add(r106);
        r106 = r109.getEMPTY();
        goto L7
    L13:
        r106 = new IntRange(r106.getFirst(), r108.getLast());
        goto L7
    L10:
        r106 = r108;
        goto L7
    L16:
        if (Intrinsics.areEqual(r106, IntRange.Companion.getEMPTY()) == true) goto L18;
        r105.add(r106);
    L18:
        StringBuilder r110 = new StringBuilder();
        Iterator r111 = r105.iterator();
    L20:
        if (r111.hasNext() == false) goto L26;
        IntRange r112 = (IntRange) r111.next();
        if (r103 >= r112.getFirst()) goto L24;
        r110.append(r100.substring(r103, r112.getFirst()));
    L24:
        r110.append(f427694b);
        r110.append(StringsKt.substring(r100, r112));
        r110.append("</span>");
        r103 = r112.getLast() + 1;
        goto L20
    L26:
        if (r103 >= r100.length()) goto L29;
        r110.append(r100.substring(r103, r100.length()));
    L29:
        return r110.toString();
    L30:
        if (r100 != null) goto L45;
        return "";
    L45:
        return r100;
    }
}
