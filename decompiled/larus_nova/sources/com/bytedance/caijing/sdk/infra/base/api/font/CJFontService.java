package com.bytedance.caijing.sdk.infra.base.api.font;

import android.content.Context;
import android.graphics.Typeface;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import ud4.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&¨\u0006\f"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/font/CJFontService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "fontName", "Landroid/graphics/Typeface;", "getDouyinTextFont", "Lud4/a;", "callback", "", "setDouyinTextFont", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface CJFontService extends ICJService {
    Typeface getDouyinTextFont(Context r100, String r101);

    void setDouyinTextFont(Context r100, String r101, a r102);
}
