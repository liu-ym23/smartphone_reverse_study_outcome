package com.ss.android.lark.passport.flow.mfa;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.sdk.account.platform.api.ITiktokService;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f437908a = null;

    static {
        f437908a = CollectionsKt.listOf(new String[]{"uri", "auth_url", "url", "web_url", ITiktokService.ResponseConstants.REDIRECT_URL});
    }

    public static final String a(JSONObject r100) {
        Iterator<T> r101 = f437908a.iterator();
    L3:
        String r102 = null;
        if (r101.hasNext() == false) goto L11;
        String r103 = r100.getString((String) r101.next());
        if (r103 == null) goto L10;
        if ((!StringsKt.isBlank(r103)) == false) goto L10;
        r102 = r103;
    L10:
        if (r102 == null) goto L3;
    L11:
        return r102;
    }
}
