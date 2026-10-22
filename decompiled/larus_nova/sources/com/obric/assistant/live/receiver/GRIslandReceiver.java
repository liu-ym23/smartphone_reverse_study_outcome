package com.obric.assistant.live.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.spi.keyguard.IKeyguardService;
import com.obric.assistant.spi.keyguard.KeyguardService;
import com.obric.assistant.t1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\f"}, d2 = {"Lcom/obric/assistant/live/receiver/GRIslandReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "sendForwardIntent", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GRIslandReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f390158a = 0;

    public static final class a {
    }

    public static final class b implements oga.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GRIslandReceiver f390159a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f390160b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Intent f390161c;

        @Override // oga.a
        public final void onDismissFailed() {
        }

        @Override // oga.a
        public final void onDismissSucceeded() {
            FLogger.f375446a.i("GRIslandReceiver", "onDismissSucceeded");
            GRIslandReceiver r100 = this.f390159a;
            Context r101 = this.f390160b;
            Intent r102 = this.f390161c;
            int r103 = GRIslandReceiver.f390158a;
            r100.getClass();
            GRIslandReceiver.a(r101, r102);
        }

        public b(GRIslandReceiver r100, Context r101, Intent r102) {
            this.f390159a = r100;
            this.f390160b = r101;
            this.f390161c = r102;
        }
    }

    static {
    }

    public GRIslandReceiver() {
    }

    public static void a(Context r100, Intent r101) {
        Intent r102 = new Intent(r100, ObricLiveReceiver.class);
        r102.setAction("com.obric.assistant.obric.live.pending.action");
        r102.setPackage(r100.getPackageName());
        Bundle r103 = r101.getExtras();
        if (r103 == null) goto L5;
        r102.putExtras(r103);
    L5:
        FLogger.f375446a.d("GRIslandReceiver", "onReceive() forwardIntent: " + r102);
        r100.sendBroadcast(r102);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r110, Intent r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "intent");
        FLogger r100 = FLogger.f375446a;
        r100.i("GRIslandReceiver", "onReceive() intent: " + r111);
        String r101 = r111.getAction();
        if (r101 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r101, "com.obric.assistant.obric.gr.island.pending.action") == true) goto L12;
        if (Intrinsics.areEqual(r101, "com.obric.assistant.obric.gr.island.pending.action2") == true) goto L12;
        r100.d("GRIslandReceiver", "onReceive() action: " + r101 + ", not GR_ACTION or GR_ACTION2, ignore");
        return;
    L12:
        if (r111.getIntExtra("live_state", -1) == (-101)) goto L14;
    L19:
        a(r110, r111);
        return;
    L14:
        if (t1.f393353a.i() == true) goto L19;
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L19;
        r100.i("GRIslandReceiver", "isKeyguardLocked and isLockedScreenUseEnabled false, requestDismissKeyguard");
        IKeyguardService.a.a(KeyguardService.f392886a, new b(this, r110, r111), false, false, false, false, null, 62);
    }
}
