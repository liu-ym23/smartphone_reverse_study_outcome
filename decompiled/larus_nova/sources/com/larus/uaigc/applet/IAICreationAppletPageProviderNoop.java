package com.larus.uaigc.applet;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ny9.b;
import ny9.c;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\fH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0016¨\u0006\u0014"}, d2 = {"Lcom/larus/uaigc/applet/IAICreationAppletPageProviderNoop;", "Lcom/larus/uaigc/applet/IAICreationAppletPageProvider;", "<init>", "()V", "startCreatePagePerf", "", "config", "Lcom/larus/uaigc/bean/createpage/ICreatePageConfig;", "buildChooseTemplateBundle", "Landroid/os/Bundle;", "Lcom/larus/uaigc/bean/createpage/CreatePageChooseTemplateConfig;", "buildCreatePageBundle", "Lcom/larus/uaigc/bean/createpage/CreatePageConfig;", "openNativeCreatePage", "getNativeCreationIntent", "Landroid/content/Intent;", "createCreationFragment", "Landroidx/fragment/app/Fragment;", "args", "createImageRemoveFragment", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IAICreationAppletPageProviderNoop implements IAICreationAppletPageProvider {
    public IAICreationAppletPageProviderNoop() {
    }

    @Override // com.larus.uaigc.applet.IAICreationAppletPageProvider
    public final Fragment a(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "args");
        return null;
    }

    @Override // com.larus.uaigc.applet.IAICreationAppletPageProvider
    public final void b(c r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
    }

    @Override // com.larus.uaigc.applet.IAICreationAppletPageProvider
    public final void d(c r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
    }

    @Override // com.larus.uaigc.applet.IAICreationAppletPageProvider
    public final Fragment e(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "args");
        return null;
    }

    @Override // com.larus.uaigc.applet.IAICreationAppletPageProvider
    public final Bundle c(b r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return new Bundle();
    }

    @Override // com.larus.uaigc.applet.IAICreationAppletPageProvider
    public final Bundle f(ny9.a r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return new Bundle();
    }
}
