package ji3;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundLinearlayout;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m extends SlcRoundLinearlayout {
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
        LinearLayout.inflate(r4, 2131564597, this);
        this.a = (TextView) findViewById(2131382869);
        this.b = (TextView) findViewById(2131368556);
        this.c = (TextView) findViewById(2131368562);
        this.d = (TextView) findViewById(2131374562);
        this.e = (TextView) findViewById(2131380162);
        this.f = (TextView) findViewById(2131385664);
        this.g = (TextView) findViewById(2131370083);
        this.h = (TextView) findViewById(2131370084);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchHoverEvent(MotionEvent r1) {
        return super/*android.widget.LinearLayout*/.dispatchHoverEvent(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void update(long r14) {
        if (r14 <= 0) goto L5;
        long r4 = r14 / 86400000;
        long r2 = (r14 % 86400000) / 3600000;
        long r6 = (r14 % 3600000) / 60000;
        long r15 = (r14 % 60000) / 1000;
    L6:
        TextView r8 = this.b;
        StringCompanionObject r9 = StringCompanionObject.INSTANCE;
        r8.setText(String.format("%d", Arrays.copyOf(new Object[]{Long.valueOf(r4)}, 1)));
        if (r4 == 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L12;
        int r1 = 0;
    L13:
        this.b.setVisibility(r1);
        this.c.setVisibility(r1);
        this.d.setText(String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(r2)}, 1)));
        this.e.setText(String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(r6)}, 1)));
        this.f.setText(String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(r15)}, 1)));
        setContentDescription(r2 + " 小时 " + r6 + " 分钟 " + r15 + " 秒");
        return;
    L12:
        r1 = 8;
        goto L13
    L9:
        r0 = false;
        goto L10
    L5:
        r15 = 0;
        r2 = 0;
        r4 = 0;
        r6 = 0;
        goto L6
    }

    public final void b(String r2, float r3, float r4) {
        this.a.setText(r2);
        this.a.setTextSize(r3);
        this.b.setTextSize(r4);
        this.c.setTextSize(r3);
        this.d.setTextSize(r4);
        this.e.setTextSize(r4);
        this.f.setTextSize(r4);
        this.g.setTextSize(r4);
        this.h.setTextSize(r4);
    }
}
