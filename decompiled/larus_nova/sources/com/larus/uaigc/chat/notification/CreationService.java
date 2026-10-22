package com.larus.uaigc.chat.notification;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0012\u0010\u0004\u001a\u00060\u0005R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/uaigc/chat/notification/CreationService;", "Landroid/app/Service;", "<init>", "()V", "binder", "Lcom/larus/uaigc/chat/notification/CreationService$CreationServiceBinder;", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "onBind", "Landroid/os/IBinder;", LiveCommonConstants.REASON_ON_DEDTROY, "", "CreationServiceBinder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f371325a;

    public final class a extends Binder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CreationService f371326a;

        public a(CreationService r100) {
            this.f371326a = r100;
        }
    }

    public CreationService() {
        this.f371325a = new a(this);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        stopForeground(true);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        return this.f371325a;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r100, int r101, int r102) {
        if (r100 == null) goto L5;
        String r103 = r100.getAction();
    L7:
        if (Intrinsics.areEqual(r103, "delete") == false) goto L20;
        CreationRefreshNotificationStrategy r104 = CreationRefreshNotificationStrategy.f371308a;
        Bundle r105 = r100.getExtras();
        if (r105 == null) goto L20;
        String r106 = r105.getString("task_id");
        if (r106 == null) goto L20;
        int r107 = r105.getInt("notify_id");
        CreationRefreshNotificationStrategy.f371312e.add(r106);
        if (r107 != 107) goto L20;
        CreationRefreshNotificationStrategy.f371313f = true;
        Iterator<Map.Entry<String, CreationRefreshNotificationStrategy.a>> r108 = CreationRefreshNotificationStrategy.f371310c.entrySet().iterator();
    L17:
        if (r108.hasNext() == false) goto L19;
        Job.DefaultImpls.cancel$default(r108.next().getValue().f371317b, null, 1, null);
        goto L17
    L19:
        CreationRefreshNotificationStrategy.f371310c.clear();
        f.d();
    L20:
        super.onStartCommand(r100, r101, r102);
        return 2;
    L5:
        r103 = null;
        goto L7
    }
}
