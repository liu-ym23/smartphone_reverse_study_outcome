package com.bytedance.ee.bear.document.security;

import android.content.Context;
import com.bytedance.ee.bear.contract.z;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.larksuite.framework.utils.ApkUtil;
import com.larksuite.framework.utils.DevEnvUtil;
import eu5.c;
import hac.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@ClaymoreImpl(z.class)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/document/security/SecurityUtils;", "Lcom/bytedance/ee/bear/contract/ISecurityUtils;", "<init>", "()V", "isDebugEnabled", "", "context", "Landroid/content/Context;", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SecurityUtils implements z {
    public static final a Companion = null;
    private static final String TAG = null;

    public static final class a {
        public a() {
        }
    }

    public SecurityUtils() {
    }

    static {
        Companion = new a();
        TAG = "SecurityUtils";
    }

    @Override // com.bytedance.ee.bear.contract.z
    public boolean isDebugEnabled(Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        boolean r0 = c.b(r11);
        String r1 = ApkUtil.getAppVersionName(r11).toLowerCase();
        String r2 = AppInfoUtils.b(r11);
        boolean r3 = StringsKt.contains$default(r1, "alpha", false, 2, null);
        Intrinsics.checkNotNull(r2);
        if (StringsKt.contains$default(r2, "lark.debug", false, 2, null) == false) goto L5;
    L8:
        boolean r4 = true;
    L9:
        boolean r5 = DevEnvUtil.isDevelopPackage(r11);
        b.a.b(TAG, "isDebugEnabled: buildConfigIsDebug=" + r0 + ", versionNameIsAlpha=" + r3 + ", packageNameIsDebug=" + r4 + ", isPackageDevelop=" + r5);
        if (r0 == true) goto L16;
        if (r3 == true) goto L16;
        if (r4 == true) goto L16;
        if (DevEnvUtil.isDebugMode(r11) == true) goto L16;
        if (r5 == true) goto L16;
        return false;
    L16:
        return true;
    L5:
        if (StringsKt.contains$default(r2, "suite.debug", false, 2, null) == true) goto L8;
        r4 = false;
        goto L9
    }
}
