package pv1;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.feed.l;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.w0;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f530788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f530789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f530790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f530791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.live.base.model.banner.a f530792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f530793f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l f530794g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f530795h;

    public b(View r100, Context r101, String r102, l r103) {
        HSImageView r104 = (HSImageView) r100.findViewById(R.id.image);
        this.f530788a = r104;
        this.f530789b = (TextView) r100.findViewById(R.id.text);
        this.f530790c = (TextView) r100.findViewById(R.id.ttlive_label);
        r104.setOnClickListener(new w0(new a(this), 500));
        r3.a(r104, s1.B(R.string.ttlive_feed_banner_desc));
        this.f530791d = r101;
        this.f530793f = r102;
        this.f530794g = r103;
    }
}
