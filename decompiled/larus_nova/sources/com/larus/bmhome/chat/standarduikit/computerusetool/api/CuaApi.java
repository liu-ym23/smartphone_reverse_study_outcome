package com.larus.bmhome.chat.standarduikit.computerusetool.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/computerusetool/api/CuaApi;", "Lcom/larus/bmhome/chat/standarduikit/computerusetool/api/ICuaApi;", "<init>", "()V", "DEFAULT_PURE_TEXT_STRING", "", "pureTextString", "getPureTextString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CuaApi implements ICuaApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CuaApi f309034a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f309035b;

    static {
        f309034a = new CuaApi();
    }

    private CuaApi() {
    }

    @Override // com.larus.bmhome.chat.standarduikit.computerusetool.api.ICuaApi
    public final String a() {
        if (f309035b != null) goto L10;
        ICuaApi r100 = (ICuaApi) ServiceManager.get().getService(ICuaApi.class);
        if (r100 == null) goto L8;
        String r101 = r100.a();
        if (r101 == null) goto L8;
    L9:
        f309035b = r101;
    L8:
        r101 = "plaintext";
    L10:
        String r102 = f309035b;
        if (r102 != null) goto L14;
        return "plaintext";
    L14:
        return r102;
    }
}
