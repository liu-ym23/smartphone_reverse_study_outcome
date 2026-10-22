package com.bytedance.android.livesdk.livecommerce.iron.listheader;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0004\u001bB'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/listheader/CustomEllipsisPositionTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "", "a", "Ljava/lang/String;", "getEllipsisText", "()Ljava/lang/String;", "setEllipsisText", "(Ljava/lang/String;)V", "ellipsisText", "", "f", "Z", "getNeedCompat", "()Z", "setNeedCompat", "(Z)V", "needCompat", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "EllipsisMode", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CustomEllipsisPositionTextView extends AppCompatTextView {
    public String a;
    public Integer b;
    public Integer c;
    public String d;
    public EllipsisMode e;
    public boolean f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/listheader/CustomEllipsisPositionTextView$EllipsisMode;", "", "NONE", "NORMAL", "FORWARD", "BACKWARD", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum EllipsisMode extends Enum<EllipsisMode> {
        public static final EllipsisMode BACKWARD = null;
        public static final EllipsisMode FORWARD = null;
        public static final EllipsisMode NONE = null;
        public static final EllipsisMode NORMAL = null;
        public static final /* synthetic */ EllipsisMode[] a = null;

        static {
            EllipsisMode r1 = new EllipsisMode("NONE", 0);
            NONE = r1;
            EllipsisMode r2 = new EllipsisMode("NORMAL", 1);
            NORMAL = r2;
            EllipsisMode r3 = new EllipsisMode("FORWARD", 2);
            FORWARD = r3;
            EllipsisMode r4 = new EllipsisMode("BACKWARD", 3);
            BACKWARD = r4;
            a = new EllipsisMode[]{r1, r2, r3, r4};
        }

        public static EllipsisMode valueOf(String r1) {
            return (EllipsisMode) r27.a.a(EllipsisMode.class, r1);
        }

        public static EllipsisMode[] values() {
            return (EllipsisMode[]) a.clone();
        }

        public EllipsisMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public CustomEllipsisPositionTextView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CustomEllipsisPositionTextView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public String getEllipsisText() {
        return this.a;
    }

    public final boolean getNeedCompat() {
        return this.f;
    }

    public void setEllipsisText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public final void setNeedCompat(boolean r1) {
        this.f = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z(String r4, int r5) {
        dm.a.a("CustomEllipsisTextView").a("measuredText=" + r4 + ", viewWidth=" + r5);
        setText(r4);
        ViewGroup.LayoutParams r6 = getLayoutParams();
        r6.width = r5;
        setLayoutParams(r6);
    }

    public CustomEllipsisPositionTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = "…";
        this.e = EllipsisMode.NONE;
    }

    public /* synthetic */ CustomEllipsisPositionTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r5, int r6, int r7, int r8) {
        int r0 = com.bytedance.android.livesdk.livecommerce.iron.listheader.a.a[this.e.ordinal()];
        if (r0 != 1) goto L5;
        String r9 = this.d;
        Integer r10 = this.b;
        Integer r11 = this.c;
        if (r9 == null) goto L52;
        if (r10 == null) goto L53;
        if (r11 == null) goto L54;
        r11.intValue();
        int r12 = r10.intValue();
        Intrinsics.checkNotNullParameter(r9, "text");
        this.b = Integer.valueOf(r12);
        this.d = r9;
        this.c = Integer.valueOf(r5);
        this.e = EllipsisMode.FORWARD;
        if (r5 > 0) goto L19;
        z(r9, 0);
    L19:
        float r13 = getPaint().measureText(r9);
        if (r12 >= 0) goto L26;
        if (this.f == false) goto L24;
        x(r9, false, r5, false);
        return;
    L24:
        setEllipsize(TextUtils.TruncateAt.START);
        z(r9, r5);
        return;
    L26:
        if (r12 >= r9.length()) goto L28;
        setEllipsize(null);
        float r1 = r5;
        if (r13 > r1) goto L34;
        z(r9, r5);
        return;
    L34:
        String r2 = r9.substring(0, r12);
        String r3 = r9;
    L36:
        if (r13 <= r1) goto L40;
        if (r12 >= r9.length()) goto L40;
        r12 = r12 + 1;
        r3 = r2 + getEllipsisText() + r9.substring(r12, r9.length());
        r13 = getPaint().measureText(r3);
    L40:
        if (r13 <= r1) goto L42;
        setEllipsize(TextUtils.TruncateAt.END);
    L43:
        z(r9, r5);
        return;
    L42:
        r9 = r3;
        goto L43
    L28:
        if (this.f == false) goto L30;
        x(r9, true, r5, false);
        return;
    L30:
        setEllipsize(TextUtils.TruncateAt.END);
        z(r9, r5);
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L5:
        if (r0 == 2) goto L7;
        super/*android.widget.TextView*/.onSizeChanged(r5, r6, r7, r8);
        return;
    L7:
        String r14 = this.d;
        Integer r15 = this.b;
        Integer r16 = this.c;
        if (r14 == null) goto L48;
        if (r15 == null) goto L49;
        if (r16 == null) goto L50;
        r16.intValue();
        y(r14, r15.intValue(), r5, false);
        return;
    L50:
        return;
    L49:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x(String r7, boolean r8, int r9, boolean r10) {
        setEllipsize(null);
        float r0 = getPaint().measureText(r7);
        float r1 = r9;
        if (r0 > r1) goto L8;
        if (r10 == false) goto L6;
        r9 = Math.min((int) r0, r9);
    L6:
        z(r7, r9);
        return;
    L8:
        boolean r2 = false;
        if (r7.length() <= 0) goto L11;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L23;
        if (getPaint().measureText(r7 + "…") <= r1) goto L23;
        if (r8 == true) goto L17;
        if (r7 == null) goto L21;
        r7 = r7.substring(1);
        goto L8
    L21:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L17:
        r7 = r7.substring(0, r7.length() - 1);
    L23:
        if (r7.length() <= 0) goto L25;
        r2 = true;
    L25:
        if (r2 == false) goto L27;
        String r11 = r7 + "…";
    L28:
        float r12 = getPaint().measureText(r11);
        if (r10 == false) goto L31;
        r9 = Math.min((int) r12, r9);
    L31:
        z(r11, r9);
        return;
    L27:
        r11 = "";
        goto L28
    L11:
        r3 = false;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y(String r7, int r8, int r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r7, "text");
        this.b = Integer.valueOf(r8);
        this.d = r7;
        this.c = Integer.valueOf(r9);
        this.e = EllipsisMode.BACKWARD;
        if (r9 > 0) goto L6;
        z(r7, 0);
        return;
    L6:
        float r1 = getPaint().measureText(r7);
        if (r8 >= 0) goto L18;
        if (this.f == false) goto L12;
        x(r7, false, r9, r10);
        return;
    L12:
        setEllipsize(TextUtils.TruncateAt.START);
        if (r10 == false) goto L15;
        r9 = Math.min((int) r1, r9);
    L15:
        z(r7, r9);
        return;
    L18:
        if (r8 > r7.length()) goto L20;
        setEllipsize(null);
        float r2 = r9;
        if (r1 > r2) goto L34;
        if (r10 == false) goto L32;
        r9 = -2;
    L32:
        z(r7, r9);
        return;
    L34:
        int r4 = (r7.length() - r8) - 1;
        String r11 = r7.substring(r7.length() - r8, r7.length());
        String r3 = r7;
    L36:
        if (r1 <= r2) goto L39;
        if (r4 < 0) goto L39;
        r3 = r7.substring(0, r4) + getEllipsisText() + r11;
        r1 = getPaint().measureText(r3);
        r4 = r4 - 1;
    L39:
        if (r1 <= r2) goto L41;
        setEllipsize(TextUtils.TruncateAt.START);
    L42:
        if (r10 == false) goto L44;
        r9 = Math.min((int) r1, r9);
    L44:
        z(r7, r9);
        return;
    L41:
        r7 = r3;
        goto L42
    L20:
        if (this.f == false) goto L23;
        x(r7, true, r9, r10);
        return;
    L23:
        setEllipsize(TextUtils.TruncateAt.END);
        if (r10 == false) goto L26;
        r9 = Math.min((int) r1, r9);
    L26:
        z(r7, r9);
    }
}
