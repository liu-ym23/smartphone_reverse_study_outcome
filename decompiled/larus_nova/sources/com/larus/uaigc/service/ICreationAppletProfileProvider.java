package com.larus.uaigc.service;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/larus/uaigc/service/ICreationAppletProfileProvider;", "", "createOtherProfileFragment", "Landroidx/fragment/app/Fragment;", "bundle", "Landroid/os/Bundle;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICreationAppletProfileProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f373901a = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¨\u0006\b"}, d2 = {"Lcom/larus/uaigc/service/ICreationAppletProfileProvider$Companion;", "Lcom/larus/uaigc/service/ICreationAppletProfileProvider;", "<init>", "()V", "createOtherProfileFragment", "Landroidx/fragment/app/Fragment;", "bundle", "Landroid/os/Bundle;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements ICreationAppletProfileProvider {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f373902c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ICreationAppletProfileProvider f373903b;

        static {
            f373902c = new Companion();
        }

        @Override // com.larus.uaigc.service.ICreationAppletProfileProvider
        public final Fragment a(Bundle r100) {
            Intrinsics.checkNotNullParameter(r100, "bundle");
            return this.f373903b.a(r100);
        }

        private Companion() {
            ICreationAppletProfileProvider r100 = (ICreationAppletProfileProvider) ServiceManager.get().getService(ICreationAppletProfileProvider.class);
            if (r100 != null) goto L5;
            r100 = new ICreationAppletProfileProviderNoop();
        L5:
            this.f373903b = r100;
        }
    }

    static {
        f373901a = Companion.f373902c;
    }

    Fragment a(Bundle r100);
}
