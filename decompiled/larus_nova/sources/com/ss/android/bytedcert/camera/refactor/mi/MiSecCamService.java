package com.ss.android.bytedcert.camera.refactor.mi;

import android.content.Context;
import android.content.ServiceConnection;
import com.byted.cast.common.bean.State;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.cert.manager.utils.CertLog;

/* JADX INFO: loaded from: classes34.dex */
public final class MiSecCamService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f407303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IMiSecCamService f407304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ServiceConnection f407305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Status f407306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f407307e;

    public static final enum Status extends Enum<Status> {
        public static final Status CONNECTED = null;
        public static final Status CONNECTING = null;
        public static final Status DISCONNECTED = null;
        public static final Status NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f407308a = null;

        static {
            Status r100 = new Status(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            Status r101 = new Status("CONNECTING", 1);
            CONNECTING = r101;
            Status r102 = new Status("CONNECTED", 2);
            CONNECTED = r102;
            Status r103 = new Status(State.DISCONNECTED, 3);
            DISCONNECTED = r103;
            f407308a = new Status[]{r100, r101, r102, r103};
        }

        public static Status[] values() {
            return (Status[]) f407308a.clone();
        }

        public static Status valueOf(String r100) {
            return (Status) r27.a.a(Status.class, r100);
        }

        public Status(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final MiSecCamService f407309a = null;

        static {
            f407309a = new MiSecCamService();
        }
    }

    public MiSecCamService() {
        this.f407304b = null;
        this.f407305c = null;
        this.f407306d = Status.NONE;
        this.f407307e = false;
    }

    public final void a(final c.a.C4709a r100) {
        int r101 = 0;
    L4:
        if (r101 >= 20) goto L11;
        if (this.f407306d != Status.CONNECTING) goto L9;
        Thread.sleep(50);     // Catch: InterruptedException -> L25
    L9:
        r101 = r101 + 1;
        goto L4
    L11:
        if (this.f407304b != null) goto L27;
        this.f407306d = Status.NONE;
        CertLog.w("MiSecCameraService", "openMiSecCam: service not connected");
        r100.a(false);
        return;
    L27:
        CertLog.i("MiSecCameraService", "try to openMiSecCam");     // Catch: Exception -> L22
        int r102 = this.f407304b.openMiSecCam(new AnonymousClass2(this, r100));     // Catch: Exception -> L22
        if (r102 != 0) goto L18;
        CertLog.i("MiSecCameraService", "openMiSecCam: connect timeout, reopen");     // Catch: Exception -> L22
        a(r100);     // Catch: Exception -> L22
    L26:
        return;
    L18:
        if (r102 != 34) goto L20;
        CertLog.i("MiSecCameraService", "openMiSecCam: manual close, ignore");     // Catch: Exception -> L22
        goto L26
    L20:
        this.f407306d = Status.NONE;     // Catch: Exception -> L22
        CertLog.w("MiSecCameraService", "openMiSecCam: open failed, result: " + r102);     // Catch: Exception -> L22
        r100.a(false);     // Catch: Exception -> L22
    L22:
        e = move-exception;
        this.f407306d = Status.NONE;
        CertLog.w("MiSecCameraService", "openMiSecCam", e);
        r100.a(false);
    }
}
