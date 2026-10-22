package com.larus.bmhome.taskskill.service;

import androidx.fragment.app.Fragment;
import com.larus.project.create.CreateProjectPanelFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0004\u0012\u0013\u0014\u0015J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J4\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0011H&¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/taskskill/service/IPcDevicePanelService;", "", "showPanel", "", "hostFragment", "Landroidx/fragment/app/Fragment;", "selectedPcDeviceId", "", "config", "Lcom/larus/bmhome/taskskill/service/IPcDevicePanelService$PanelConfig;", "callback", "Lcom/larus/bmhome/taskskill/service/IPcDevicePanelService$Callback;", "showAddComputerGuide", "showFolderPanel", "pcDeviceId", "currentPage", "Lcom/larus/bmhome/taskskill/service/IPcDevicePanelService$FolderPanelConfig;", "Lcom/larus/bmhome/taskskill/service/IPcDevicePanelService$FolderCallback;", "PanelConfig", "FolderPanelConfig", "Callback", "FolderCallback", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IPcDevicePanelService {

    public interface a {
        void a();

        void b(be8.d r100);

        void c();
    }

    public interface b {
        void a();

        void b();

        void c(String r100, String r101);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f314406a;

        public c() {
            this(true);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f314406a == ((c) r100).f314406a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f314406a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "FolderPanelConfig(showDoNotUseFolder=" + this.f314406a + ')';
        }

        public c(boolean r100) {
            this.f314406a = r100;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Integer f314407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f314408b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f314409c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f314410d;

        public d() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f314407a, r101.f314407a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f314408b, r101.f314408b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f314409c, r101.f314409c) == true) goto L18;
            return false;
        L18:
            if (this.f314410d == r101.f314410d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            Integer r100 = this.f314407a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.f314408b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Integer r107 = this.f314409c;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            int r108 = (r106 + r101) * 31;
            if (this.f314410d == false) goto L17;
            int r109 = 1231;
        L19:
            return r108 + r109;
        L17:
            r109 = 1237;
            goto L19
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "PanelConfig(titleResId=" + this.f314407a + ", navigationIconResId=" + this.f314408b + ", bottomSheetCloseSizeDp=" + this.f314409c + ", showCloudComputer=" + this.f314410d + ')';
        }

        public /* synthetic */ d(int r100) {
            this(null, null, null, true);
        }

        public d(Integer r100, Integer r101, Integer r102, boolean r103) {
            this.f314407a = r100;
            this.f314408b = r101;
            this.f314409c = r102;
            this.f314410d = r103;
        }
    }

    void a(Fragment r100, String r101, d r102, a r103);

    void b(CreateProjectPanelFragment r100, String r101, c r102, ls9.i r103);

    void c(Fragment r100);
}
