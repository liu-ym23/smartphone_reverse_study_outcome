package e40;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.cloudgrouplive.core.CloudGroupLiveManager;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f470957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f470958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f470959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f470960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CloudGroupLiveManager f470961e;

    /* JADX INFO: renamed from: e40.a$a, reason: collision with other inner class name */
    public static final class C5738a {
    }

    static {
    }

    public a(Context r100, CloudGroupLiveManager r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "cloudGroupLiveService");
        super(r100);
        this.f470961e = r101;
        View r102 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_view_cloud_group_preview_view, this);
        this.f470957a = (ViewGroup) r102.findViewById(R.id.preview_container);
        this.f470958b = (ImageView) r102.findViewById(R.id.status_icon);
        this.f470959c = (TextView) r102.findViewById(R.id.status_text);
        ViewGroup r103 = (ViewGroup) r102.findViewById(R.id.back_btn_container);
        this.f470960d = r103;
        if (r103 == null) goto L6;
        r103.setOnClickListener(new c(this));
        return;
    }
}
