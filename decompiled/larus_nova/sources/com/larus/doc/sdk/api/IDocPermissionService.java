package com.larus.doc.sdk.api;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.permission.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import n39.i;
import n39.q;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u000eH&J4\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\u0013H&¨\u0006\u0014"}, d2 = {"Lcom/larus/doc/sdk/api/IDocPermissionService;", "", "initPermissionSdk", "", "sdk", "Lcom/bytedance/ee/permission/IPermissionSdk;", "updatePermission", "token", "", "isPublic", "", "callback", "Lcom/larus/doc/sdk/api/IUpdateDocPermissionCallback;", "getPermission", "Lcom/larus/doc/sdk/api/IGetDocPermissionCallback;", "validatePermission", "type", "", WikiFolderPushPlugin.OPT, "Lkotlin/Function1;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDocPermissionService {
    void getPermission(String r100, i r101);

    void initPermissionSdk(a r100);

    void updatePermission(String r100, boolean r101, q r102);

    void validatePermission(String r100, int r101, String r102, Function1<? super Boolean, Unit> r103);
}
