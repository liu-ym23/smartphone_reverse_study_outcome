package com.obric.assistant.spi.keyguard;

import android.content.ComponentName;
import android.os.Bundle;
import kotlin.Metadata;
import kotlinx.coroutines.flow.i1;
import oga.b;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&JD\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\fH&J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0018H&J\b\u0010\u0019\u001a\u00020\fH&¨\u0006\u001a"}, d2 = {"Lcom/obric/assistant/spi/keyguard/IKeyguardService;", "", "registerDismissKeyguardChangedListener", "", "listener", "Lcom/obric/assistant/spi/keyguard/IDismissKeyguardStatusListener;", "unregisterDismissKeyguardChangedListener", "cancelDismissKeyguard", "requestDismissKeyguard", "callback", "Lcom/obric/assistant/spi/keyguard/DismissKeyguardCallback;", "fastFailWhenAppBackground", "", "playTts", "allowBiometricUnlock", "autoPopupWindow", "reportParams", "Landroid/os/Bundle;", "getHelperActivityName", "", "getHelperActivityComponentName", "Landroid/content/ComponentName;", "isKeyguardLocked", "isDismissingKeyguard", "Lkotlinx/coroutines/flow/StateFlow;", "isRequestingDismissKeyguard", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKeyguardService {

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a {
        public static /* synthetic */ void a(KeyguardService r100, oga.a r110, boolean r111, boolean r112, boolean r113, boolean r114, Bundle r115, int r116) {
            if ((r116 & 2) == 0) goto L5;
            boolean r101 = false;
        L7:
            if ((r116 & 4) == 0) goto L9;
            boolean r102 = false;
        L11:
            if ((r116 & 8) == 0) goto L13;
            boolean r103 = true;
        L15:
            if ((r116 & 16) == 0) goto L17;
            boolean r104 = false;
        L19:
            if ((r116 & 32) == 0) goto L21;
            Bundle r105 = null;
        L22:
            r100.requestDismissKeyguard(r110, r101, r102, r103, r104, r105);
            return;
        L21:
            r105 = r115;
            goto L22
        L17:
            r104 = r114;
            goto L19
        L13:
            r103 = r113;
            goto L15
        L9:
            r102 = r112;
            goto L11
        L5:
            r101 = r111;
            goto L7
        }
    }

    void cancelDismissKeyguard();

    ComponentName getHelperActivityComponentName();

    String getHelperActivityName();

    i1<Boolean> isDismissingKeyguard();

    boolean isKeyguardLocked();

    boolean isRequestingDismissKeyguard();

    void registerDismissKeyguardChangedListener(b r100);

    void requestDismissKeyguard(oga.a r100, boolean r101, boolean r102, boolean r103, boolean r104, Bundle r105);

    void unregisterDismissKeyguardChangedListener(b r100);
}
