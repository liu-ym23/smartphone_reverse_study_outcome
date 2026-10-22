package com.larus.sheet.sdk.api;

import com.larus.office.base.service.b;
import com.larus.sheet.impl.SheetFragment$initTitleBarService$1;
import com.larus.sheet.impl.n;
import com.larus.sheet.impl.o;
import com.larus.sheet.impl.p;
import kotlin.Metadata;
import pw9.a;
import vm9.c;
import vm9.d;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0014H&J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0014H&J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH&J\b\u0010\u001f\u001a\u00020\u0003H&J\b\u0010 \u001a\u00020\u0003H&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H&J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u001eH&¨\u0006&"}, d2 = {"Lcom/larus/sheet/sdk/api/ISheetSdkProxyService;", "", "addChatService", "", "chatService", "Lcom/larus/sheet/sdk/api/IChatService;", "removeChatService", "addTitleBarService", "titleBarService", "Lcom/larus/office/base/service/ITitleBarService;", "removeTitleBarService", "addSelectionChangeService", "selectionChangeService", "Lcom/larus/sheet/sdk/api/ISelectionChangeService;", "removeSelectionChangeService", "addLoadingService", "service", "Lcom/larus/office/base/page/ILoadingService;", "removeLoadingService", "addPermissionChangeService", "Lcom/larus/sheet/sdk/api/ISheetPermissionChangeService;", "removePermissionChangeService", "getMoreMenuItemClickListener", "Lcom/larus/sheet/sdk/api/IMoreMenuClickListener;", "getTitleStageChangeListener", "Lcom/larus/office/base/service/ITitleStateChangeListener;", "getNavigationListener", "Lcom/larus/office/base/page/INavigationListener;", "notifyClearToast", "isV2", "", "clearReference", "notifyCloseActionMode", "notifyBottomPanelHeightChanged", "height", "", "notifyAIChatListFoldStatusChanged", "isFold", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ISheetSdkProxyService {
    void a();

    void addLoadingService(c r100);

    void addTitleBarService(b r100);

    com.larus.office.base.service.c b();

    d c();

    void clearReference();

    void d(boolean r100);

    void e(n r100);

    void f(a r100);

    void g(p r100);

    void h(o r100);

    void i(int r100);

    void j(SheetFragment$initTitleBarService$1 r100);

    void k();

    void l(pw9.d r100);
}
