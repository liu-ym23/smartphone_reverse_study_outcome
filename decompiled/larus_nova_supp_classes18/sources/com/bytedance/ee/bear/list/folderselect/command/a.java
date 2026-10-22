package com.bytedance.ee.bear.list.folderselect.command;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a<T extends Result> implements NetService.c {
    public static final a<T> a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final Result parse(String r5) {
        Intrinsics.checkNotNullParameter(r5, "json");
        boolean r0 = false;
        JSONObject r6 = new JSONObject(r5).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: JSONException -> L11
        if (r6 == null) goto L10;
        boolean r1 = r6.optBoolean("has_shortcut");     // Catch: JSONException -> L11
        r0 = r6.optBoolean("has_entity");     // Catch: JSONException -> L8
    L15:
        return new DuplicateContentChecker.CheckShortcutResult(r1, r0);
    L8:
        e = e;
    L13:
        tt5.a.e("DuplicateContentChecker", "checkDuplicateContent parse err.", e, false);
        goto L15
    L10:
        r1 = false;
    L11:
        e = e;
        r1 = false;
        goto L13
    }
}
