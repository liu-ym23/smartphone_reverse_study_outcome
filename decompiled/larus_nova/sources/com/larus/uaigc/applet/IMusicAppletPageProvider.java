package com.larus.uaigc.applet;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0003H&¨\u0006\n"}, d2 = {"Lcom/larus/uaigc/applet/IMusicAppletPageProvider;", "", "createDefaultTemplateArguments", "Landroid/os/Bundle;", "createPage", "Landroidx/fragment/app/Fragment;", "url", "", "launchArguments", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IMusicAppletPageProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f370282a = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0096\u0001¨\u0006\u000b"}, d2 = {"Lcom/larus/uaigc/applet/IMusicAppletPageProvider$Companion;", "Lcom/larus/uaigc/applet/IMusicAppletPageProvider;", "<init>", "()V", "createDefaultTemplateArguments", "Landroid/os/Bundle;", "createPage", "Landroidx/fragment/app/Fragment;", "url", "", "launchArguments", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IMusicAppletPageProvider {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f370283c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IMusicAppletPageProvider f370284b;

        static {
            f370283c = new Companion();
        }

        @Override // com.larus.uaigc.applet.IMusicAppletPageProvider
        public final Bundle a() {
            return this.f370284b.a();
        }

        @Override // com.larus.uaigc.applet.IMusicAppletPageProvider
        public final Fragment b(String r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "url");
            return this.f370284b.b(r100, r101);
        }

        private Companion() {
            this.f370284b = (IMusicAppletPageProvider) ServiceManager.get().getService(IMusicAppletPageProvider.class);
        }
    }

    static {
        f370282a = Companion.f370283c;
    }

    Bundle a();

    Fragment b(String r100, Bundle r101);
}
