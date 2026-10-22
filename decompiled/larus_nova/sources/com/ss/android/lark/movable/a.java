package com.ss.android.lark.movable;

import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public class a implements b {
    public a() {
    }

    @Override // com.ss.android.lark.movable.b
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "imageKey");
    }

    @Override // com.ss.android.lark.movable.b
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "captionUri");
    }

    public static String e(String r100, String r101, String r102) {
        return new JSONObject(r100).optString(r101);
    L4:
        e = move-exception;
        Log.e("MovableUtils", r102 + " payload parse failed, e: " + e.getMessage());
        return null;
    }

    @Override // com.ss.android.lark.movable.b
    public boolean c(View r100, String r101, com.ss.android.lark.movable.attatchment.b r102) {
        Intrinsics.checkNotNullParameter(r100, "anchorView");
        Intrinsics.checkNotNullParameter(r101, "imageKey");
        Intrinsics.checkNotNullParameter(r102, "attachmentInfo");
        return false;
    }

    @Override // com.ss.android.lark.movable.b
    public final void d(Context r100, int r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "schema");
        Intrinsics.checkNotNullParameter(r112, WsConstants.KEY_PAYLOAD);
        boolean r101 = true;
        boolean r102 = false;
        switch(r111.hashCode()) {
            case -1961610058: goto L107;
            case -506252289: goto L72;
            case -504883868: goto L37;
            case 937803688: goto L22;
            case 1938746582: goto L6;
            default: goto L133;
        };
    L133:
        Log.d("MovableUtils", "eventClick: unknow schema");
        return;
    L6:
        if (r111.equals("movableOpenTable") == false) goto L133;
        if (com.ss.android.lark.movable.preview.a.a(r100) == true) goto L157;
        String r113 = e(r112, "text", "handleOpenTablePreview");
        if (r113 != null) goto L15;
        return;
    L15:
        if (r113.length() == 0) goto L18;
        r101 = false;
    L18:
        if (r101 == true) goto L159;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r113, "markdown");
        com.ss.android.lark.movable.preview.a.b(r100, 0, r113, r110);
        return;
    L159:
        return;
    L157:
        return;
    L22:
        if (r111.equals("movableOpenCodeBlock") == false) goto L133;
        if (com.ss.android.lark.movable.preview.a.a(r100) == true) goto L160;
        String r114 = e(r112, "text", "handleOpenCodeBlockPreview");
        if (r114 != null) goto L31;
        return;
    L31:
        if (r114.length() != 0) goto L33;
        r102 = true;
    L33:
        if (r102 == true) goto L162;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r114, "markdown");
        com.ss.android.lark.movable.preview.a.b(r100, 1, r114, r110);
        return;
    L162:
        return;
    L160:
        return;
    L37:
        if (r111.equals("openLink") == false) goto L133;
        String r115 = e(r112, "url", "openLink");
        if (r115 != null) goto L43;
        return;
    L43:
        if (r115.length() == 0) goto L46;
        r101 = false;
    L46:
        if (r101 == true) goto L164;
        lsb.a r116 = (lsb.a) ClaymoreServiceLoader.loadFirstOrNull(lsb.a.class);
        if (r116 == null) goto L137;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L52
        Object r118 = Result.m9449constructorimpl(Boolean.valueOf(r116.a()));     // Catch: Throwable -> L52
    L54:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r118);
        if (r119 == null) goto L57;
        Log.e("MovableUtils", "openLink by ILinkOpener failed, url=" + r115 + ", e: " + r119.getMessage());
    L57:
        Boolean r120 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r118) == false) goto L61;
        r118 = r120;
    L61:
        if (((Boolean) r118).booleanValue() == true) goto L165;
        Log.i("MovableUtils", "openLink: ILinkOpener not handled, fallback to ACTION_VIEW, url=".concat(r115));
        goto L137
    L165:
        return;
    L52:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L137:
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L66
        Intent r123 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r115));     // Catch: Throwable -> L66
        r123.addFlags(268435456);     // Catch: Throwable -> L66
        r100.startActivity(r123);     // Catch: Throwable -> L66
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L66
    L68:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L147;
        Log.e("MovableUtils", "openLink failed, url=" + r115 + ", e: " + r104.getMessage());
        return;
    L147:
        return;
    L66:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L68
    L164:
        return;
    L72:
        if (r111.equals("openProfile") == false) goto L133;
        String r105 = e(r112, "user_id", "openProfile");
        if (r105 != null) goto L78;
        return;
    L78:
        if (r105.length() != 0) goto L80;
        boolean r125 = true;
    L81:
        if (r125 == true) goto L149;
        int r126 = 0;
    L84:
        if (r126 >= r105.length()) goto L94;
        char r127 = r105.charAt(r126);
        if ('0' <= r127) goto L88;
    L90:
        boolean r128 = false;
    L91:
        if (r128 == false) goto L92;
        r126 = r126 + 1;
        goto L84
    L92:
        r101 = false;
        goto L94
    L88:
        if (r127 >= ':') goto L90;
        r128 = true;
    L94:
        if (r101 == false) goto L167;
        lsb.c r129 = (lsb.c) ClaymoreServiceLoader.loadFirstOrNull(lsb.c.class);
        if (r129 != null) goto L139;
        Log.i("MovableUtils", "openProfile: no IProfileOpener impl found, userId=".concat(r105));
        return;
    L139:
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L101
        r129.b();     // Catch: Throwable -> L101
        Object r131 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L101
    L103:
        Throwable r132 = Result.m9452exceptionOrNullimpl(r131);
        if (r132 == null) goto L151;
        Log.e("MovableUtils", "openProfile failed, userId=" + r105 + ", e: " + r132.getMessage());
        return;
    L151:
        return;
    L101:
        th = move-exception;
        Result.Companion r133 = Result.Companion;
        r131 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L103
    L167:
        return;
    L149:
        return;
    L80:
        r125 = false;
        goto L81
    L107:
        if (r111.equals("clipboardWriteText") == false) goto L133;
        String r106 = e(r112, "text", "clipboardWriteText");
        if (r106 != null) goto L113;
        return;
    L113:
        if (r106.length() == 0) goto L116;
        r101 = false;
    L116:
        if (r101 == true) goto L169;
        Application r134 = com.larksuite.framework.utils.b.f285948a;
        if (r134 != null) goto L121;
        Log.w("MovableUtils", "clipboardWriteText: app context is null");
        return;
    L121:
        Object r135 = r134.getSystemService(DataType.CLIPBOARD);
        if ((r135 instanceof ClipboardManager) == false) goto L124;
        ClipboardManager r136 = (ClipboardManager) r135;
    L125:
        if (r136 != null) goto L141;
        Log.w("MovableUtils", "clipboardWriteText: ClipboardManager is null");
        return;
    L141:
        qf7.a.f532746a.a(r136, ClipData.newPlainText("", r106), new Token("LARK-PSDA-movable-default-clipboard-write"));     // Catch: Exception -> L129 SensitiveAPIException -> L131
        UDToast.show(r134, R.string.Lark_Legacy_CopyReady);     // Catch: Exception -> L129 SensitiveAPIException -> L131
    L170:
        return;
    L131:
        e = move-exception;
        Log.e("MovableUtils", "clipboardWriteText forbidden by sensitive policy: " + e.getMessage());
        UDToast.show(r134, R.string.Lark_IM_CopyContent_CopyingIsForbidden_Toast);
        return;
    L129:
        e = move-exception;
        Log.e("MovableUtils", "clipboardWriteText failed, e: " + e.getMessage());
        return;
    L124:
        r136 = null;
        goto L125
    }
}
