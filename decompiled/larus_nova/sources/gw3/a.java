package gw3;

import androidx.camera.video.AudioStats;
import com.bytedance.sdk.xbridge.cn.system.s;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocationResult;
import hq9.a3;
import kotlin.jvm.internal.Intrinsics;
import re7.e;
import re7.f;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements a3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f483027a;

    /* JADX INFO: renamed from: gw3.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C6075a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f483028a = null;

        static {
            int[] r100 = new int[LocationResult.values().length];
            r100[LocationResult.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f483028a = r100;
        }
    }

    public a(s.a r100) {
        this.f483027a = r100;
    }

    @Override // hq9.a3
    public final void a(LocationResult r100, Integer r101, GeoLocationInfo r102) {
        Intrinsics.checkNotNullParameter(r100, "code");
        if (C6075a.f483028a[r100.ordinal()] != 1) goto L11;
        e r103 = this.f483027a;
        double r104 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r102 == null) goto L7;
        double r105 = r102.getLatitude();
    L8:
        if (r102 == null) goto L10;
        r104 = r102.getLongitude();
    L10:
        r103.a(new f(r105, r104));
        return;
    L7:
        r105 = 0.0d;
        goto L8
    L11:
        this.f483027a.onFail(r100.getMessage());
    }
}
