package com.larus.office.base.host;

import com.larus.account.base.provider.IOfficeSDKLgwHeaderProvider;
import com.ss.android.lark.integrator.security.compliance.export.OfficeSDKLgwHeaderKey;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¨\u0006\b"}, d2 = {"Lcom/larus/office/base/host/OfficeSDKLgwHeaderProvider;", "Lcom/larus/account/base/provider/IOfficeSDKLgwHeaderProvider;", "<init>", "()V", "getCommonRequestParams", "", "", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSDKLgwHeaderProvider implements IOfficeSDKLgwHeaderProvider {

    public static final class a {
    }

    static {
    }

    public OfficeSDKLgwHeaderProvider() {
    }

    @Override // com.larus.account.base.provider.IOfficeSDKLgwHeaderProvider
    public final Map<String, String> a() {
        LinkedHashMap r100 = new LinkedHashMap();
        OfficeSDKLgwHeaderKey.Companion.getClass();
        Map r101 = OfficeSDKLgwHeaderKey.access$getAndroidFixedHeaders$cp();
        String r102 = (String) r101.get(OfficeSDKLgwHeaderKey.OS_TYPE);
        String r103 = null;
        if (r102 != null) goto L5;
    L10:
        String r104 = (String) r101.get(OfficeSDKLgwHeaderKey.TERMINAL_TYPE);
        if (r104 != null) goto L13;
    L17:
        return r100;
    L13:
        if ((!StringsKt.isBlank(r104)) == false) goto L15;
        r103 = r104;
    L15:
        if (r103 == null) goto L17;
        r100.put("terminal_type", r103);
        goto L17
    L5:
        if ((!StringsKt.isBlank(r102)) == true) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L10;
        String r105 = (String) r100.put("os_type", r102);
        goto L10
    }
}
