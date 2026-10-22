package ji3;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundLinearlayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes13.dex */
public final class m extends SlcRoundLinearlayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f499185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f499186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f499187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f499188d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f499189e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f499190f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f499191g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f499192h;

    public static final class a {
    }

    static {
    }

    public m(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 6, 0);
        LinearLayout.inflate(r100, R.layout.shopping_anchor_v4_activity_count_down, this);
        this.f499185a = (TextView) findViewById(R.id.prefix);
        this.f499186b = (TextView) findViewById(R.id.day);
        this.f499187c = (TextView) findViewById(R.id.day_tag);
        this.f499188d = (TextView) findViewById(R.id.hour);
        this.f499189e = (TextView) findViewById(R.id.minute);
        this.f499190f = (TextView) findViewById(R.id.second);
        this.f499191g = (TextView) findViewById(R.id.dot1);
        this.f499192h = (TextView) findViewById(R.id.dot2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchHoverEvent(MotionEvent r100) {
        return super.dispatchHoverEvent(r100);
    }

    public final void update(long r110) {
        if (r110 <= 0) goto L5;
        long r100 = r110 / 86400000;
        long r101 = (r110 % 86400000) / 3600000;
        long r102 = (r110 % 3600000) / 60000;
        long r111 = (r110 % 60000) / 1000;
    L6:
        TextView r103 = this.f499186b;
        StringCompanionObject r104 = StringCompanionObject.INSTANCE;
        r103.setText(String.format("%d", Arrays.copyOf(new Object[]{Long.valueOf(r100)}, 1)));
        if (r100 == 0) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == false) goto L12;
        int r106 = 0;
    L13:
        this.f499186b.setVisibility(r106);
        this.f499187c.setVisibility(r106);
        this.f499188d.setText(String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(r101)}, 1)));
        this.f499189e.setText(String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(r102)}, 1)));
        this.f499190f.setText(String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(r111)}, 1)));
        setContentDescription(r101 + " 小时 " + r102 + " 分钟 " + r111 + " 秒");
        return;
    L12:
        r106 = 8;
        goto L13
    L9:
        r105 = false;
        goto L10
    L5:
        r111 = 0;
        r101 = 0;
        r100 = 0;
        r102 = 0;
        goto L6
    }

    public final void b(String r100, float r101, float r102) {
        this.f499185a.setText(r100);
        this.f499185a.setTextSize(r101);
        this.f499186b.setTextSize(r102);
        this.f499187c.setTextSize(r101);
        this.f499188d.setTextSize(r102);
        this.f499189e.setTextSize(r102);
        this.f499190f.setTextSize(r102);
        this.f499191g.setTextSize(r102);
        this.f499192h.setTextSize(r102);
    }
}
