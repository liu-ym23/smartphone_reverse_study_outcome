package com.larus.dora.impl.assistant;

import com.larus.utils.logger.FLogger;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\f\u0010\u000f\u001a\u00020\u0005*\u00020\u0010H\u0002J\f\u0010\u0011\u001a\u00020\n*\u00020\u0012H\u0002¨\u0006\u0013"}, d2 = {"Lcom/larus/dora/impl/assistant/ObricAssistantWifiServiceImpl;", "Lcom/larus/dora/impl/assistant/AssistantWifiService;", "<init>", "()V", "requestWifi", "Lcom/larus/dora/impl/assistant/AssistantWifiOperationResult;", "owner", "", "releaseWifi", "queryWifiState", "Lcom/larus/dora/impl/assistant/AssistantWifiStateResult;", "setWifiEnabledForDebug", "enabled", "", "queryWifiStateForDebug", "toAssistantWifiOperationResult", "Lcom/larus/dora/impl/assistant/DoraWifiIntentResult;", "toAssistantWifiStateResult", "Lcom/larus/dora/impl/assistant/DoraWifiStateResult;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAssistantWifiServiceImpl implements AssistantWifiService {
    public ObricAssistantWifiServiceImpl() {
    }

    @Override // com.larus.dora.impl.assistant.AssistantWifiService
    public final c b() {
        DoraWifiIntentClientImpl.f332025a.getClass();
        a.f332035a.getClass();
        f r100 = a.a();
        return new c(r100.f332047a, r100.f332048b, r100.f332049c, r100.f332050d);
    }

    @Override // com.larus.dora.impl.assistant.AssistantWifiService
    public final b a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "owner");
        DoraWifiIntentClientImpl.f332025a.getClass();
        Intrinsics.checkNotNullParameter(r110, "owner");
        Object r100 = DoraWifiIntentClientImpl.f332026b;
        monitor-enter(r100);
        String r111 = StringsKt.trim(r110).toString();     // Catch: Throwable -> L27
        if (r111.length() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        int r112 = e.f332043d;     // Catch: Throwable -> L27
        e r113 = e.a.a("invalid_owner", "owner is empty");     // Catch: Throwable -> L27
    L24:
        monitor-exit(r100);
        return new b(r113.f332044a, r113.f332045b, r113.f332046c);
    L10:
        Set<String> r102 = DoraWifiIntentClientImpl.f332027c;     // Catch: Throwable -> L27
        r102.add(r111);     // Catch: Throwable -> L27
        a.f332035a.getClass();     // Catch: Throwable -> L27
        f r103 = a.a();     // Catch: Throwable -> L27
        if (r103.f332047a == true) goto L17;
        r102.remove(r111);     // Catch: Throwable -> L27
        int r114 = e.f332043d;     // Catch: Throwable -> L27
        String r115 = r103.f332049c;     // Catch: Throwable -> L27
        if (r115 != null) goto L15;
        r115 = "query_wifi_state_failed";
    L15:
        r113 = e.a.a(r115, r103.f332050d);     // Catch: Throwable -> L27
        goto L24
    L17:
        if (r103.f332048b == false) goto L19;
        FLogger.f375446a.i("DoraWifiIntentClient", "requestWifi success, already enabled, ownerCount=" + r102.size());     // Catch: Throwable -> L27
        r113 = new e(true, null, null);     // Catch: Throwable -> L27
        goto L24
    L19:
        DoraWifiIntentClientImpl.a r104 = DoraWifiIntentClientImpl.d(true);     // Catch: Throwable -> L27
        e r116 = r104.f332029a;     // Catch: Throwable -> L27
        DoraWifiIntentClientImpl.c(StringsKt.substringAfterLast(r111, ":", r111), r116, r104.f332030b, r104.f332031c);     // Catch: Throwable -> L27
        if (r116.f332044a == false) goto L22;
        DoraWifiIntentClientImpl.f332028d = true;     // Catch: Throwable -> L27
        FLogger.f375446a.i("DoraWifiIntentClient", "requestWifi success, opened by client, ownerCount=" + r102.size());     // Catch: Throwable -> L27
    L23:
        r113 = r116;
        goto L24
    L22:
        r102.remove(r111);     // Catch: Throwable -> L27
        FLogger.f375446a.w("DoraWifiIntentClient", "requestWifi failed, errorCode=" + r116.f332045b + ", ownerCount=" + r102.size());     // Catch: Throwable -> L27
        goto L23
    L7:
        r101 = false;
    L27:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.dora.impl.assistant.AssistantWifiService
    public final b c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        DoraWifiIntentClientImpl.f332025a.getClass();
        Intrinsics.checkNotNullParameter(r100, "owner");
        Object r101 = DoraWifiIntentClientImpl.f332026b;
        monitor-enter(r101);
        String r102 = StringsKt.trim(r100).toString();     // Catch: Throwable -> L16
        if (r102.length() != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L10;
        FLogger.f375446a.w("DoraWifiIntentClient", "releaseWifi ignored, owner is empty");     // Catch: Throwable -> L16
        int r104 = e.f332043d;     // Catch: Throwable -> L16
        e r105 = e.a.a("invalid_owner", "owner is empty");     // Catch: Throwable -> L16
    L11:
        monitor-exit(r101);
        if (r105 != null) goto L20;
        return null;
    L20:
        return new b(r105.f332044a, r105.f332045b, r105.f332046c);
    L10:
        DoraWifiIntentClientImpl.f332027c.remove(r102);     // Catch: Throwable -> L16
        r105 = DoraWifiIntentClientImpl.b();     // Catch: Throwable -> L16
        goto L11
    L7:
        r103 = false;
    L16:
        th = move-exception;
        throw th;
    }
}
