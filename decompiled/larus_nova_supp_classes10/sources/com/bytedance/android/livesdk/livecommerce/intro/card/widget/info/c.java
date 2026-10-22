package com.bytedance.android.livesdk.livecommerce.intro.card.widget.info;

import android.content.Context;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ec.model.response.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c extends AppCompatTextView implements q83.a {
    public k a;
    public StringBuilder b;
    public Function0<Unit> c;
    public final long d;

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTick(long r13) {
        k r0 = this.a;
        if (r0 == null) goto L25;
        long r2 = this.d;
        if (r13 >= r2) goto L22;
        long r3 = r2 - r13;
        String r14 = r0.b();
        String r15 = "";
        if (r14 != null) goto L9;
        r14 = "";
    L9:
        String r1 = r0.d();
        if (r1 == null) goto L13;
        r15 = r1;
    L13:
        StringBuilder r4 = this.b;
        Intrinsics.checkNotNullParameter(r14, "prefix");
        Intrinsics.checkNotNullParameter(r15, "suffix");
        double r5 = r3;
        if (r5 <= 0) goto L16;
        int r6 = (int) (r5 / ((double) 3600000));
        double r7 = r5 - ((double) (3600000 * r6));
        int r8 = (int) (r7 / ((double) 60000));
        int r9 = (int) ((r7 - ((double) (60000 * r8))) / ((double) 1000));
    L17:
        String r10 = getContext().getString(2131896692, new Object[]{Integer.valueOf(r6)});
        String r11 = getContext().getString(2131896692, new Object[]{Integer.valueOf(r8)});
        String r12 = getContext().getString(2131896692, new Object[]{Integer.valueOf(r9)});
        if (r4 == null) goto L20;
        r4.append(r6 + " 小时，" + r8 + " 分钟，" + r9 + " 秒");
    L20:
        setText(r14 + r10 + ':' + r11 + ':' + r12 + r15);
        return true;
    L16:
        r9 = 0;
        r6 = 0;
        r8 = 0;
        goto L17
    L22:
        Function0<Unit> r16 = this.c;
        if (r16 == null) goto L25;
        Unit r17 = (Unit) r16.invoke();
    L25:
        return false;
    }

    public c(Context r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, null, 0);
        this.d = r4;
    }
}
