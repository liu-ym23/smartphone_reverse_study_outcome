package py8;

import android.companion.AssociationInfo;
import android.companion.CompanionDeviceManager;
import android.content.IntentSender;
import com.larus.cdm.impl.FlowCompanionDeviceAssociatorImpl$associate$companionCallbackCompat$1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c extends CompanionDeviceManager.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f531042a;

    public c(FlowCompanionDeviceAssociatorImpl$associate$companionCallbackCompat$1 r100) {
        this.f531042a = r100;
    }

    @Override // android.companion.CompanionDeviceManager.Callback
    public final void onAssociationCreated(AssociationInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "associationInfo");
        this.f531042a.c(r100);
    }

    @Override // android.companion.CompanionDeviceManager.Callback
    public final void onAssociationPending(IntentSender r100) {
        Intrinsics.checkNotNullParameter(r100, "intentSender");
        this.f531042a.b(r100);
    }

    @Override // android.companion.CompanionDeviceManager.Callback
    public final void onDeviceFound(IntentSender r100) {
        Intrinsics.checkNotNullParameter(r100, "intentSender");
        this.f531042a.b(r100);
    }

    @Override // android.companion.CompanionDeviceManager.Callback
    public final void onFailure(CharSequence r100) {
        this.f531042a.a(r100);
    }
}
