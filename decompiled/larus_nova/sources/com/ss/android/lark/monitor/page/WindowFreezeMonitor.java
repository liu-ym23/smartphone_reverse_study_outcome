package com.ss.android.lark.monitor.page;

import android.os.SystemClock;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.banner.export.entity.BannerBizName;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.setting.WindowFreezeMonitorConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
public final class WindowFreezeMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f432426a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/monitor/page/WindowFreezeMonitor$TouchSource;", "", "<init>", "(Ljava/lang/String;I)V", BannerBizName.ACTIVITY, "POPUP_WINDOW", "DIALOG", "monitor_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TouchSource extends Enum<TouchSource> {
        public static final TouchSource ACTIVITY = null;
        public static final TouchSource DIALOG = null;
        public static final TouchSource POPUP_WINDOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TouchSource[] f432427a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f432428b = null;

        public static EnumEntries<TouchSource> getEntries() {
            return f432428b;
        }

        static {
            TouchSource r100 = new TouchSource(BannerBizName.ACTIVITY, 0);
            ACTIVITY = r100;
            TouchSource r101 = new TouchSource("POPUP_WINDOW", 1);
            POPUP_WINDOW = r101;
            TouchSource r102 = new TouchSource("DIALOG", 2);
            DIALOG = r102;
            TouchSource[] r103 = {r100, r101, r102};
            f432427a = r103;
            f432428b = EnumEntriesKt.enumEntries(r103);
        }

        public static TouchSource[] values() {
            return (TouchSource[]) f432427a.clone();
        }

        public static TouchSource valueOf(String r100) {
            return (TouchSource) a.a(TouchSource.class, r100);
        }

        public TouchSource(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        if (gsb.a.f482482a != null) goto L6;
        long r100 = SystemClock.elapsedRealtime();
        gsb.a.f482482a = (WindowFreezeMonitorConfig) SettingManager.getInstance().get(WindowFreezeMonitorConfig.class);
        Log.i("MonitorConfig", "getWindowFreezeMonitorConfig = " + gsb.a.f482482a + ", cost = " + (SystemClock.elapsedRealtime() - r100));
    L6:
        if (gsb.a.f482482a != null) goto L9;
        new WindowFreezeMonitorConfig(false, 0, 0, 0, false, false, false, false, false, false, 1023, null);
        return;
    }

    public static boolean a(LKUIRoundLinearLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.isAttachedToWindow() == true) goto L5;
    L10:
        return false;
    L5:
        if (r100.getWindowVisibility() == 0) goto L8;
        return true;
    L8:
        if (r100.getChildCount() != 0) goto L10;
        return true;
    }
}
