package com.larus.receive.api;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096\u0001J\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rH\u0096\u0001¨\u0006\u0011"}, d2 = {"Lcom/larus/receive/api/ReceiveIntentServiceDelegate;", "Lcom/larus/receive/api/IReceiveIntentService;", "<init>", "()V", "handle", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "currentPage", "", "isReceive", "", "intent", "Landroid/content/Intent;", "parseUris", "", "Landroid/net/Uri;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReceiveIntentServiceDelegate implements IReceiveIntentService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReceiveIntentServiceDelegate f367362b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IReceiveIntentService f367363a;

    static {
        f367362b = new ReceiveIntentServiceDelegate();
    }

    @Override // com.larus.receive.api.IReceiveIntentService
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("landing", "currentPage");
        this.f367363a.a(r100);
    }

    @Override // com.larus.receive.api.IReceiveIntentService
    public final boolean b(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        return this.f367363a.b(r100);
    }

    @Override // com.larus.receive.api.IReceiveIntentService
    public final List<Uri> c(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        return this.f367363a.c(r100);
    }

    private ReceiveIntentServiceDelegate() {
        Object r100 = ServiceManager.get().getService(IReceiveIntentService.class);
        Intrinsics.checkNotNull(r100);
        this.f367363a = (IReceiveIntentService) r100;
    }
}
