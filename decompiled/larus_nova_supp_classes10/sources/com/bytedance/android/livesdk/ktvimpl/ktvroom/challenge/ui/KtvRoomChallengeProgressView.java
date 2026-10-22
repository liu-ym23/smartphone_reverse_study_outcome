package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.message.model.KtvChallengeType;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/challenge/ui/KtvRoomChallengeProgressView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "max", "", "setProgressBarRange", "challengeType", "setChallengeTypeText", "", "i", "Z", "isHideSongNameChallenging", "()Z", "setHideSongNameChallenging", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvRoomChallengeProgressView extends ConstraintLayout {
    public ProgressBar a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public View h;
    public boolean i;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ KtvRoomChallengeProgressView a;

        public b(KtvRoomChallengeProgressView r1) {
            this.a = r1;
        }

        public final void a() {
            TextView r0 = this.a.f;
            if (r0 == null) goto L5;
            r0.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        L5:
            TextView r1 = this.a.f;
            if (r1 == null) goto L8;
            r1.setSingleLine(true);
        L8:
            TextView r2 = this.a.f;
            if (r2 == null) goto L11;
            r2.setSelected(true);
        L11:
            TextView r3 = this.a.f;
            if (r3 == null) goto L14;
            r3.setEnabled(true);
        L14:
            TextView r4 = this.a.f;
            if (r4 == null) goto L17;
            r4.setFocusable(true);
        L17:
            TextView r5 = this.a.f;
            if (r5 == null) goto L21;
            r5.setFocusableInTouchMode(true);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public KtvRoomChallengeProgressView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvRoomChallengeProgressView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void R5(long r4) {
        if (r4 > 10) goto L5;
        String r0 = "#FF3372";
    L6:
        TextView r1 = this.e;
        if (r1 == null) goto L9;
        r1.setTextColor(ColorProtector.parseColor(r0));
    L9:
        TextView r2 = this.e;
        if (r2 == null) goto L13;
        r2.setText(KtvUtilsKt.e(r4));
        return;
    L13:
        return;
    L5:
        r0 = "#FFFFFF";
        goto L6
    }

    public final void S5(int r2) {
        ProgressBar r0 = this.a;
        if (r0 == null) goto L5;
        r0.setProgress(r2);
    L5:
        TextView r1 = this.c;
        if (r1 == null) goto L9;
        r1.setText(String.valueOf(r2));
        return;
    }

    public final void setChallengeTypeText(int r5) {
        if (r5 != KtvChallengeType.KTV_CHALLENGE_TYPE_GIFT.getValue()) goto L11;
        TextView r6 = this.d;
        if (r6 == null) goto L7;
        r6.setText("");
    L7:
        Drawable r7 = s1.m(2131252112);
        r7.setBounds(0, 0, UtilityKotlinExtentionsKt.i(15), UtilityKotlinExtentionsKt.i(15));
        TextView r0 = this.d;
        if (r0 == null) goto L27;
        r0.setCompoundDrawables(r7, null, null, null);
        return;
    L27:
        return;
    L11:
        if (r5 != KtvChallengeType.KTV_CHALLENGE_TYPE_MIDI.getValue()) goto L19;
        TextView r8 = this.d;
        if (r8 == null) goto L15;
        r8.setCompoundDrawables(null, null, null, null);
    L15:
        TextView r9 = this.d;
        if (r9 == null) goto L29;
        r9.setText(s1.B(2131918253));
        return;
    L29:
        return;
    L19:
        if (r5 != KtvChallengeType.KTV_CHALLENGE_TYPE_LIKE.getValue()) goto L31;
        TextView r10 = this.d;
        if (r10 == null) goto L23;
        r10.setCompoundDrawables(null, null, null, null);
    L23:
        TextView r11 = this.d;
        if (r11 == null) goto L32;
        r11.setText(s1.B(2131918252));
        return;
    L32:
        return;
    }

    public final void setHideSongNameChallenging(boolean r1) {
        this.i = r1;
    }

    public final void setProgressBarRange(int r4) {
        ProgressBar r0 = this.a;
        if (r0 == null) goto L5;
        r0.setProgress(0);
    L5:
        TextView r1 = this.c;
        if (r1 == null) goto L8;
        r1.setText(BDLocationException.ERROR_TIMEOUT);
    L8:
        ProgressBar r2 = this.a;
        if (r2 == null) goto L11;
        r2.setMax(r4);
    L11:
        TextView r3 = this.b;
        if (r3 == null) goto L15;
        r3.setText("/" + r4);
        return;
    }

    public final void T5(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "songName");
        TextView r0 = this.f;
        if (r0 != null) goto L5;
    L10:
        TextView r4 = this.f;
        if (r4 == null) goto L13;
        r4.setText(r2);
    L13:
        TextView r5 = this.f;
        if (r5 == null) goto L16;
        r5.setMaxEms(5);
    L16:
        i0.c().post(new b(this));
        return;
    L5:
        if (r0.getVisibility() != 0) goto L10;
        if (r3 == true) goto L10;
        TextView r6 = this.f;
        if (r6 == null) goto L10;
        r6.setVisibility(8);
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KtvRoomChallengeProgressView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131566526, this);
        this.a = (ProgressBar) findViewById(2131376878);
        this.b = (TextView) findViewById(2131376888);
        this.c = (TextView) findViewById(2131376874);
        this.d = (TextView) findViewById(2131376873);
        this.e = (TextView) findViewById(2131376870);
        this.f = (TextView) findViewById(2131376885);
        this.h = findViewById(2131376871);
        this.g = (TextView) findViewById(2131376880);
        TextView r5 = this.d;
        if (r5 == null) goto L6;
        r5.setOnClickListener(f.a);
        return;
    }

    public /* synthetic */ KtvRoomChallengeProgressView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
