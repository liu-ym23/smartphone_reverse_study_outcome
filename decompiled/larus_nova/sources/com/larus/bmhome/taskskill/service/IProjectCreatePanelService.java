package com.larus.bmhome.taskskill.service;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\u0011\u0012J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J4\u0010\u0002\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J4\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/taskskill/service/IProjectCreatePanelService;", "", "showPanel", "", "hostFragment", "Landroidx/fragment/app/Fragment;", "enterMethod", "", "callback", "Lcom/larus/bmhome/taskskill/service/IProjectCreatePanelService$Callback;", "", "config", "Lcom/larus/bmhome/taskskill/service/IProjectCreatePanelService$PanelConfig;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "observePanelResult", "resultKey", "PanelConfig", "Callback", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IProjectCreatePanelService {

    public interface a {
        void a(boolean r100);

        void b(com.larus.bmhome.taskskill.service.a r100);

        void c();

        void d(boolean r100);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f314411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f314412b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f314411a, r101.f314411a) == true) goto L12;
            return false;
        L12:
            if (this.f314412b == r101.f314412b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f314411a.hashCode() * 31;
            if (this.f314412b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "PanelConfig(resultKey=" + this.f314411a + ", autoLaunchDevicePicker=" + this.f314412b + ')';
        }

        public b(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "resultKey");
            this.f314411a = r100;
            this.f314412b = r101;
        }
    }

    boolean a(Fragment r100, b r101, LifecycleOwner r102, String r103, a r104);

    void b(Fragment r100, LifecycleOwner r101, String r102, String r103, a r104);

    void c(Fragment r100, String r101, a r102);
}
