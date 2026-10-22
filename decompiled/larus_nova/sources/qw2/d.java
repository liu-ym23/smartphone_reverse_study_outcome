package qw2;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.camera.core.processing.util.GLUtils;
import com.bytedance.android.live.broadcast.api.model.a2;
import com.bytedance.android.live.broadcast.api.model.r;
import com.bytedance.android.live.broadcast.api.model.z1;
import com.bytedance.android.livesdk.chatroom.broadcast.widget.LiveStartZoomWidget;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.larus.nova.R;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.text.DecimalFormat;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static float f534970j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f534971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f534972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DecimalFormat f534973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f534974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a2 f534975e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f534976f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f534977g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f534978h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final qw2.a f534979i;

    public static final class a {
    }

    static {
        f534970j = 1.0f;
    }

    public final void a(float r100) {
        HashMap r101 = new HashMap();
        r101.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, this.f534978h);
        r101.put("focal_length_before", String.valueOf(this.f534976f));
        r101.put("focal_length_after", String.valueOf(r100));
        u.l().sendLog("livesdk_focal_length_switch", r101, new Object[]{Room.class});
    }

    public d(ViewGroup r100, LiveStartZoomWidget.a r101) {
        Intrinsics.checkNotNullParameter(r100, "containerView");
        Intrinsics.checkNotNullParameter("live_take_detail", "eventPage");
        Intrinsics.checkNotNullParameter(r101, "onSelectRatioListener");
        this.f534977g = r100;
        this.f534978h = "live_take_detail";
        this.f534979i = r101;
        this.f534971a = new e(this);
        this.f534972b = true;
        this.f534973c = new DecimalFormat(GLUtils.VERSION_UNKNOWN);
        this.f534976f = 1.0f;
        r100.setVisibility(8);
        z1 r102 = r.f59035a;
        a2 r103 = r.b(com.bytedance.android.livesdk.sharedpref.b.f158117a.a().intValue());
        if (r103 == null) goto L11;
        this.f534975e = r103;
        TextView r104 = (TextView) r100.findViewById(R.id.zoom_tv_upper);
        if (r104 == null) goto L7;
        r104.setOnClickListener(new b(this));
    L7:
        TextView r105 = (TextView) r100.findViewById(R.id.zoom_tv2_lower);
        if (r105 == null) goto L12;
        r105.setOnClickListener(new c(this));
        return;
    L12:
        return;
    }
}
