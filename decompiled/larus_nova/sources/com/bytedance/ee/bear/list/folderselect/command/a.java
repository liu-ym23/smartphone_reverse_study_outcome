package com.bytedance.ee.bear.list.folderselect.command;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class a<T extends Result> implements NetService.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T> f228125a = null;

    static {
        f228125a = new a();
    }

    public a() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        boolean r101 = false;
        JSONObject r102 = new JSONObject(r100).optJSONObject("data");     // Catch: JSONException -> L11
        if (r102 == null) goto L10;
        boolean r103 = r102.optBoolean("has_shortcut");     // Catch: JSONException -> L11
        r101 = r102.optBoolean("has_entity");     // Catch: JSONException -> L8
    L15:
        return new DuplicateContentChecker.CheckShortcutResult(r103, r101);
    L8:
        e = e;
    L13:
        tt5.a.e("DuplicateContentChecker", "checkDuplicateContent parse err.", e, false);
        goto L15
    L10:
        r103 = false;
    L11:
        e = e;
        r103 = false;
        goto L13
    }
}
