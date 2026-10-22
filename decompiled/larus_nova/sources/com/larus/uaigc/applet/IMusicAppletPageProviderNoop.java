package com.larus.uaigc.applet;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000b"}, d2 = {"Lcom/larus/uaigc/applet/IMusicAppletPageProviderNoop;", "Lcom/larus/uaigc/applet/IMusicAppletPageProvider;", "<init>", "()V", "createDefaultTemplateArguments", "Landroid/os/Bundle;", "createPage", "Landroidx/fragment/app/Fragment;", "url", "", "launchArguments", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IMusicAppletPageProviderNoop implements IMusicAppletPageProvider {
    public IMusicAppletPageProviderNoop() {
    }

    @Override // com.larus.uaigc.applet.IMusicAppletPageProvider
    public final Bundle a() {
        return null;
    }

    @Override // com.larus.uaigc.applet.IMusicAppletPageProvider
    public final Fragment b(String r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return null;
    }
}
