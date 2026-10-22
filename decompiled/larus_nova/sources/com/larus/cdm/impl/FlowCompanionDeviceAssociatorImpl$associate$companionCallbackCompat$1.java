package com.larus.cdm.impl;

import android.companion.AssociationInfo;
import android.content.IntentSender;
import androidx.activity.result.IntentSenderRequest;
import androidx.lifecycle.Lifecycle;
import com.larus.dora.impl.alive.DoraKeepAliveViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import oy8.c;
import py8.a;

/* JADX INFO: loaded from: classes26.dex */
public final class FlowCompanionDeviceAssociatorImpl$associate$companionCallbackCompat$1 implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowCompanionDeviceAssociatorImpl f323886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f323887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f323888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f323889d;

    @Override // py8.a
    public final void a(CharSequence r100) {
        FLogger.f375446a.i("flow_cdm", "[onFailure] " + r100);
        this.f323886a.f323884d = false;
        c r101 = this.f323887b;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // py8.a
    public final void b(IntentSender r100) {
        Intrinsics.checkNotNullParameter(r100, "intentSender");
        FLogger r101 = FLogger.f375446a;
        r101.d("flow_cdm", "[onAssociationPending] " + r100);
        final FlowCompanionDeviceAssociatorImpl r102 = this.f323886a;
        FlowCompanionDeviceAssociatorImpl$resultCallback$1 r103 = r102.f323885e;
        final c r104 = this.f323887b;
        final String r105 = this.f323888c;
        final String r106 = this.f323889d;
        r103.f323880a = new FlowCompanionDeviceAssociatorImpl$associate$companionCallbackCompat$1$onAssociationPending$1(r102, r104, r105, r106);
        if (r102.f323882b.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r101.w("flow_cdm", "[onAssociationPending] Context not valid to launch.");
        c r107 = this.f323887b;
        if (r107 == null) goto L17;
        r107.a("Lifecycle state is not valid.");
    L17:
        this.f323886a.f323884d = false;
        return;
    L19:
        c r108 = this.f323887b;     // Catch: Throwable -> L9
        if (r108 == null) goto L7;
        r108.b(r100);     // Catch: Throwable -> L9
    L7:
        this.f323886a.f323883c.launch(new IntentSenderRequest.Builder(r100).build());     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        FLogger.f375446a.e("flow_cdm", "[onAssociationPending] Launch failed", th);
        c r109 = this.f323887b;
        if (r109 == null) goto L13;
        r109.a("Launch failed: " + th.getMessage());
    L13:
        this.f323886a.f323884d = false;
    }

    @Override // py8.a
    public final void c(AssociationInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "associationInfo");
        FLogger.f375446a.i("flow_cdm", "[onAssociationCreated] " + r100);
        this.f323886a.f323884d = false;
        c r101 = this.f323887b;
        if (r101 == null) goto L6;
        r101.c(this.f323888c);
        return;
    }

    public FlowCompanionDeviceAssociatorImpl$associate$companionCallbackCompat$1(FlowCompanionDeviceAssociatorImpl r100, DoraKeepAliveViewModel.b r101, String r102, String r103) {
        this.f323886a = r100;
        this.f323887b = r101;
        this.f323888c = r102;
        this.f323889d = r103;
    }
}
