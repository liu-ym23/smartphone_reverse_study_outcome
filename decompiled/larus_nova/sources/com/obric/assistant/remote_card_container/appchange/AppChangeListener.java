package com.obric.assistant.remote_card_container.appchange;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.IRemoteCard;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/remote_card_container/appchange/AppChangeListener;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "onAppUpdated", "onAppUninstall", "onAppChanged", "markPackageEnabled", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppChangeListener extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f391229a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile AppChangeListener f391230b;

    public static final class a {
        public static IntentFilter a() {
            IntentFilter r100 = new IntentFilter();
            r100.addAction("android.intent.action.PACKAGE_ADDED");
            r100.addAction("android.intent.action.PACKAGE_REMOVED");
            r100.addAction("android.intent.action.PACKAGE_CHANGED");
            r100.addDataScheme("package");
            return r100;
        }

        public a() {
        }
    }

    static {
        f391229a = new a();
    }

    public AppChangeListener() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        String r102 = r101.getAction();
        Object r103 = null;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L11
        Uri r105 = r101.getData();     // Catch: Throwable -> L11
        if (r105 == null) goto L8;
        String r106 = r105.getSchemeSpecificPart();     // Catch: Throwable -> L11
    L9:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L11
    L13:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L17;
        FLogger.f375446a.w("AppChangeListener", "get schemeSpecificPart failed", r108);
    L17:
        if (Result.m9455isFailureimpl(r107) == true) goto L20;
        r103 = r107;
    L20:
        FLogger r109 = FLogger.f375446a;
        r109.i("AppChangeListener", "onReceive: action = " + r102 + ", schemeSpecificPart = " + ((String) r103));
        if (r102 == null) goto L57;
        int r110 = r102.hashCode();
        if (r110 == 172491798) goto L48;
        if (r110 == 525384130) goto L39;
        if (r110 == 1544582882) goto L30;
        return;
    L30:
        if (r102.equals("android.intent.action.PACKAGE_ADDED") == true) goto L33;
        return;
    L33:
        if (r101.getBooleanExtra("android.intent.extra.REPLACING", false) == false) goto L58;
        IRemoteCard r111 = (IRemoteCard) ServiceManager.get().getService(IRemoteCard.class);
        if (r111 == null) goto L37;
        r111.b(r101);
        return;
    L37:
        r109.w("AppChangeListener", "RemoteCard is null");
        return;
    L58:
        return;
    L39:
        if (r102.equals("android.intent.action.PACKAGE_REMOVED") == true) goto L42;
        return;
    L42:
        if (r101.getBooleanExtra("android.intent.extra.REPLACING", false) == true) goto L61;
        IRemoteCard r112 = (IRemoteCard) ServiceManager.get().getService(IRemoteCard.class);
        if (r112 == null) goto L46;
        r112.c(r101);
        return;
    L46:
        r109.w("AppChangeListener", "RemoteCard is null");
        return;
    L61:
        return;
    L48:
        if (r102.equals("android.intent.action.PACKAGE_CHANGED") == false) goto L68;
        IRemoteCard r113 = (IRemoteCard) ServiceManager.get().getService(IRemoteCard.class);
        if (r113 == null) goto L53;
        r113.a(r101);
        return;
    L53:
        r109.w("AppChangeListener", "RemoteCard is null");
        return;
    L68:
        return;
    L57:
        return;
    L8:
        r106 = null;
    L11:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }
}
