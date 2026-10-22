package v37;

import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.common.push.BaseJson;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.notification.supporter.impl.NotificationReminderServiceImpl;
import com.bytedance.notification.supporter.impl.d;
import com.bytedance.notification.supporter.impl.e;
import com.bytedance.notification.supporter.impl.f;
import com.bytedance.notification.supporter.impl.g;
import com.ss.android.message.util.ToolUtils;
import org.json.JSONObject;
import t37.b;
import w37.c;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends BaseJson implements b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile a f552940h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile com.bytedance.notification.supporter.impl.a f552941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile f f552942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile g f552943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile d f552944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile NotificationReminderServiceImpl f552945e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile e f552946f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile com.bytedance.notification.supporter.impl.b f552947g;

    public static b b() {
        if (f552940h != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f552940h != null) goto L9;
        f552940h = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f552940h;
    }

    public final w37.a c() {
        if (this.f552941a != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f552941a != null) goto L8;
        this.f552941a = new com.bytedance.notification.supporter.impl.a();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f552941a;
    }

    public final w37.b d() {
        if (this.f552942b != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f552942b != null) goto L8;
        this.f552942b = new f();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f552942b;
    }

    public final c e() {
        if (this.f552943c != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f552943c != null) goto L8;
        this.f552943c = new g(PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f552943c;
    }

    public a() {
    }

    public final void f(long r100, boolean r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();
        add(r104, "id", r100);
        add(r104, "result", r101);
        add(r104, "reason", r102);
        add(r104, "type", r103);
        add(r104, "process", ToolUtils.getCurProcessNameSuffix(PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication));
        PushServiceManager.get().getPushExternalService().getMultiProcessEventSenderService().onEventV3("bdpush_banner_show", r104);
    }
}
