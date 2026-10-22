package f68;

import android.app.Application;
import com.larus.audio.settings.audio.data.AudioRetransmitStrategy;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.mammon.audiosdk.BuildConfig;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmEndWindowAvatar;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import m58.b;
import m58.h;
import m58.w;
import m58.y;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f475715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f475716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f475717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f475718d;

    /* JADX INFO: renamed from: f68.a$a, reason: collision with other inner class name */
    public static final class C5861a {
    }

    static {
    }

    public final Map<String, Object> a() {
        Pair[] r100 = new Pair[11];
        boolean r101 = false;
        r100[0] = TuplesKt.to("bot_id", this.f475718d);
        r100[1] = TuplesKt.to(DBDefinition.TASK_ID, this.f475715a);
        r100[2] = TuplesKt.to(MmEndWindowAvatar.TYPE_SPEAKER, this.f475716b);
        r100[3] = TuplesKt.to(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, this.f475717c);
        r100[4] = TuplesKt.to("new_arch", "arch-v3");
        x58.a r102 = h.f512130a;
        x58.a r103 = h.f512130a;
        Application r104 = null;
        if (r103 == null) goto L9;
        AudioRetransmitStrategy r105 = r103.f562538l;
        if (r105 == null) goto L9;
        t78.a r106 = r105.getData();
        if (r106 == null) goto L9;
        Boolean r107 = Boolean.valueOf(r106.a());
    L10:
        r100[5] = TuplesKt.to("enable_retransmit", String.valueOf(r107));
        r100[6] = TuplesKt.to("sami_sdk_version", BuildConfig.VERSION);
        y r108 = y.f512149a;
        b r109 = h.f512140k;
        if (r109 == null) goto L13;
        Application r110 = r109.getApplication();
    L14:
        r100[7] = TuplesKt.to("phone_volume", String.valueOf(r108.b(r110)));
        b r111 = h.f512140k;
        if (r111 == null) goto L17;
        r104 = r111.getApplication();
    L17:
        r100[8] = TuplesKt.to("phone_is_muted", String.valueOf(r108.f(r104)));
        w r112 = h.f512135f;
        if (r112 == null) goto L21;
        String r113 = r112.getCurrentNetworkStatus();
        if (r113 == null) goto L21;
    L22:
        r100[9] = TuplesKt.to("network_status", r113);
        b r114 = h.f512140k;
        if (r114 != null) goto L25;
    L27:
        if (r101 == false) goto L29;
        String r115 = "background";
    L30:
        r100[10] = TuplesKt.to("app_status", r115);
        return MapsKt.mapOf(r100);
    L29:
        r115 = "foreground";
        goto L30
    L25:
        if (r114.isAppBackground() != true) goto L27;
        r101 = true;
    L21:
        r113 = "";
        goto L22
    L13:
        r110 = null;
    L9:
        r107 = null;
        goto L10
    }

    public a(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "mTaskId");
        Intrinsics.checkNotNullParameter(r101, "mSpeaker");
        Intrinsics.checkNotNullParameter(r102, "mModelName");
        Intrinsics.checkNotNullParameter(r103, "botId");
        this.f475715a = r100;
        this.f475716b = r101;
        this.f475717c = r102;
        this.f475718d = r103;
    }
}
