package com.ss.android.lark.monitor.perf;

import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.MonitorModule;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0011\u001a\u00020\u000bH$R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/monitor/perf/ResourcePerfMonitor;", "", "<init>", "(Ljava/lang/String;I)V", "VIDEO_SEND", "IMAGE_SEND", "VIDEO_PLAY", "IMAGE_PREVIEW", "ALBUM_OPEN", "IMAGE_EDITOR", "TAG", "", "hasStarted", "Ljava/util/concurrent/atomic/AtomicBoolean;", WidgetCostModule.TYPE_ON_START, "", "onEnd", "getSceneName", "monitor_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract enum ResourcePerfMonitor extends Enum<ResourcePerfMonitor> {
    public static final ResourcePerfMonitor ALBUM_OPEN = null;
    public static final ResourcePerfMonitor IMAGE_EDITOR = null;
    public static final ResourcePerfMonitor IMAGE_PREVIEW = null;
    public static final ResourcePerfMonitor IMAGE_SEND = null;
    public static final ResourcePerfMonitor VIDEO_PLAY = null;
    public static final ResourcePerfMonitor VIDEO_SEND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourcePerfMonitor[] f432429a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f432430b = null;
    private final String TAG;
    private AtomicBoolean hasStarted;

    public ResourcePerfMonitor() {
        throw null;
    }

    public static EnumEntries<ResourcePerfMonitor> getEntries() {
        return f432430b;
    }

    public abstract String getSceneName();

    static {
        final String r100 = "VIDEO_SEND";
        final int r101 = 0;
        ResourcePerfMonitor r102 = new VIDEO_SEND(r100, r101);
        VIDEO_SEND = r102;
        final String r103 = "IMAGE_SEND";
        final int r104 = 1;
        ResourcePerfMonitor r105 = new IMAGE_SEND(r103, r104);
        IMAGE_SEND = r105;
        final String r106 = "VIDEO_PLAY";
        final int r107 = 2;
        ResourcePerfMonitor r108 = new VIDEO_PLAY(r106, r107);
        VIDEO_PLAY = r108;
        final String r109 = "IMAGE_PREVIEW";
        final int r110 = 3;
        ResourcePerfMonitor r111 = new IMAGE_PREVIEW(r109, r110);
        IMAGE_PREVIEW = r111;
        final String r112 = "ALBUM_OPEN";
        final int r113 = 4;
        ResourcePerfMonitor r114 = new ALBUM_OPEN(r112, r113);
        ALBUM_OPEN = r114;
        final String r115 = "IMAGE_EDITOR";
        final int r116 = 5;
        ResourcePerfMonitor r117 = new IMAGE_EDITOR(r115, r116);
        IMAGE_EDITOR = r117;
        ResourcePerfMonitor[] r118 = {r102, r105, r108, r111, r114, r117};
        f432429a = r118;
        f432430b = EnumEntriesKt.enumEntries(r118);
    }

    public static ResourcePerfMonitor[] values() {
        return (ResourcePerfMonitor[]) f432429a.clone();
    }

    public final void onEnd() {
        String r100 = getSceneName();
        if (this.hasStarted.get() == false) goto L5;
        this.hasStarted.set(false);
        Log.i(this.TAG, "onEnd success, scene:" + r100);
        MonitorModule.e().h(MonitorModule.Business.messenger, r100);
        return;
    L5:
        Log.i(this.TAG, "onEnd, no has started, scene:" + r100);
    }

    public final void onStart() {
        String r100 = getSceneName();
        if (this.hasStarted.get() == false) goto L5;
        Log.i(this.TAG, "onStart, has started, scene:" + r100);
        return;
    L5:
        this.hasStarted.set(true);
        Log.i(this.TAG, "onStart success, scene:" + r100);
        MonitorModule.e().f(MonitorModule.Business.messenger, r100);
    }

    public static ResourcePerfMonitor valueOf(String r100) {
        return (ResourcePerfMonitor) r27.a.a(ResourcePerfMonitor.class, r100);
    }

    public ResourcePerfMonitor(String r100, int r101, DefaultConstructorMarker r102) {
        super(r100, r101);
        this.TAG = "ResourcePerfMonitor";
        this.hasStarted = new AtomicBoolean(false);
    }
}
