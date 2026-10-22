package com.larus.audio.ainotes.notification;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0012\u0010\u0004\u001a\u00060\u0005R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/audio/ainotes/notification/AiNoteService;", "Landroid/app/Service;", "<init>", "()V", "binder", "Lcom/larus/audio/ainotes/notification/AiNoteService$AiNoteServiceBinder;", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "onBind", "Landroid/os/IBinder;", LiveCommonConstants.REASON_ON_DEDTROY, "", "AiNoteServiceBinder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiNoteService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f288336a;

    public final class a extends Binder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AiNoteService f288337a;

        public a(AiNoteService r100) {
            this.f288337a = r100;
        }
    }

    public AiNoteService() {
        this.f288336a = new a(this);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        stopForeground(true);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        return this.f288336a;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r100, int r101, int r102) {
        return super.onStartCommand(r100, r101, r102);
    }
}
