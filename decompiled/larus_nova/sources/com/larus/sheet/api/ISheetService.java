package com.larus.sheet.api;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kw9.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&JO\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00030\u001bH¦@¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\fH&J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\"2\u0006\u0010\u0016\u001a\u00020\fH&J\b\u0010#\u001a\u00020\u0003H&J\b\u0010$\u001a\u00020%H&J\u0018\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H&J\u0018\u0010+\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H&J\u000f\u0010,\u001a\u0004\u0018\u00010-H&¢\u0006\u0002\u0010.J$\u0010/\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00100\u001a\u00020\f2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\fH&J\u0010\u00102\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\fH&¨\u00063"}, d2 = {"Lcom/larus/sheet/api/ISheetService;", "", "preloadWebViewIfNeeded", "", "initSdkIfNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openSheet", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "Landroid/os/Bundle;", "page", "", "tryPrefetchData", "", "openSheetAndChat", "switchConversationParams", "Lcom/larus/bmhome/chat/resp/SwitchConversationParams;", "triggerInnerNotification", "inAppBannerNotify", "Lcom/larus/im/bean/InAppBannerNotify;", "setSheetPermission", "slidesToken", "public", "onSuccess", "Lkotlin/Function0;", LynxVideoManagerLite.EVENT_ON_ERROR, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSheetPermission", "getSheetPermissionLiveData", "Landroidx/lifecycle/LiveData;", "clearReference", "getSheetTrackInfo", "Lorg/json/JSONObject;", "showSheetDownloadFragment", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "downloadParams", "Lcom/larus/share/bean/SheetDownloadParams;", "showSheetDownloadSimple", "getFloatChatShowPercent", "", "()Ljava/lang/Integer;", "doubaoSheetUrlJump", "url", "enterMethod", "isDoubaoSheetUrl", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ISheetService {
    Integer A();

    Object a(Continuation<? super Unit> r100);

    void b(Fragment r100, e r101);

    boolean c(Bundle r100);

    void clearReference();

    void d(Context r100, Bundle r101, String r102);

    Unit e(String r100, boolean r101, Function0 r102, Function1 r103);

    JSONObject f();

    MutableLiveData g(String r100);

    boolean h(String r100);
}
