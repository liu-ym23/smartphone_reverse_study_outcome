package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.animator.LiveAnimator;
import com.bytedance.android.livesdkapi.depend.message.BackgroundMaterial;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinMaterial;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\rB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RTChorusMusicInfoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lpy/k;", "getMusicInfoBgModel", "", "getCurShowMode", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RTChorusMusicInfoView extends ConstraintLayout {
    public MidiSkinDressInfo a;
    public HSImageView b;
    public ConstraintLayout c;
    public TextView d;
    public TextView e;
    public ConstraintLayout f;
    public TextView g;
    public TextView h;
    public ConstraintLayout i;
    public TextView j;
    public long k;
    public int l;
    public Disposable m;
    public final CompositeDisposable n;
    public com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c o;
    public final NextLiveData<Pair<Boolean, com.bytedance.android.live.ktv.common.model.bean.a>> p;

    public static final class a {
    }

    public static final class b implements fd0.b {
        public final /* synthetic */ ConstraintLayout a;
        public final /* synthetic */ RTChorusMusicInfoView b;

        public b(ConstraintLayout r1, RTChorusMusicInfoView r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onStop() {
            UtilityKotlinExtentionsKt.w(this.a);
            ConstraintLayout r0 = this.b;
            if (r0.getVisibility() == 0) goto L6;
            UtilityKotlinExtentionsKt.w(r0);
            return;
        }
    }

    public static final class c implements fd0.b {
        public final /* synthetic */ ConstraintLayout a;
        public final /* synthetic */ RTChorusMusicInfoView b;

        public c(ConstraintLayout r1, RTChorusMusicInfoView r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onStop() {
            UtilityKotlinExtentionsKt.w(this.a);
            ConstraintLayout r0 = this.b;
            if (r0.getVisibility() == 0) goto L6;
            UtilityKotlinExtentionsKt.w(r0);
            return;
        }
    }

    public static final class d implements fd0.b {
        public final /* synthetic */ ConstraintLayout a;
        public final /* synthetic */ RTChorusMusicInfoView b;

        public d(ConstraintLayout r1, RTChorusMusicInfoView r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onStop() {
            UtilityKotlinExtentionsKt.w(this.a);
            ConstraintLayout r0 = this.b;
            if (r0.getVisibility() == 0) goto L6;
            UtilityKotlinExtentionsKt.w(r0);
            return;
        }
    }

    public static final class e implements fd0.a {
        public final /* synthetic */ ConstraintLayout a;

        public e(ConstraintLayout r1) {
            this.a = r1;
        }

        public final void onStart() {
            UtilityKotlinExtentionsKt.w(this.a);
            this.a.setAlpha(0.0f);
        }
    }

    public static final class f implements fd0.b {
        public final /* synthetic */ ConstraintLayout a;
        public final /* synthetic */ ConstraintLayout b;

        public f(ConstraintLayout r1, ConstraintLayout r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onStop() {
            UtilityKotlinExtentionsKt.t(this.a);
            UtilityKotlinExtentionsKt.t(this.b);
        }
    }

    public static final class g implements fd0.a {
        public final /* synthetic */ ConstraintLayout a;

        public g(ConstraintLayout r1) {
            this.a = r1;
        }

        public final void onStart() {
            UtilityKotlinExtentionsKt.w(this.a);
            this.a.setAlpha(0.0f);
        }
    }

    public static final class h implements fd0.b {
        public final /* synthetic */ ConstraintLayout a;
        public final /* synthetic */ ConstraintLayout b;

        public h(ConstraintLayout r1, ConstraintLayout r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onStop() {
            UtilityKotlinExtentionsKt.t(this.a);
            UtilityKotlinExtentionsKt.t(this.b);
        }
    }

    public static final class i implements fd0.a {
        public final /* synthetic */ ConstraintLayout a;

        public i(ConstraintLayout r1) {
            this.a = r1;
        }

        public final void onStart() {
            UtilityKotlinExtentionsKt.w(this.a);
            this.a.setAlpha(0.0f);
        }
    }

    public static final class j implements fd0.b {
        public final /* synthetic */ ConstraintLayout a;
        public final /* synthetic */ ConstraintLayout b;

        public j(ConstraintLayout r1, ConstraintLayout r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onStop() {
            UtilityKotlinExtentionsKt.t(this.a);
            UtilityKotlinExtentionsKt.t(this.b);
        }
    }

    static {
    }

    public RTChorusMusicInfoView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RTChorusMusicInfoView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final py.k getMusicInfoBgModel() {
        MidiSkinDressInfo r0 = this.a;
        if (r0 == null) goto L5;
        String r1 = r0.getDressId();
    L7:
        if (TextUtils.isEmpty(r1) == true) goto L15;
        MidiSkinDressInfo r2 = this.a;
        if (r2 == null) goto L11;
        String r3 = r2.getDressId();
    L12:
        boolean r4 = true;
        if ((!Intrinsics.areEqual(r3, BDLocationException.ERROR_TIMEOUT)) == false) goto L15;
    L16:
        if (r4 == false) goto L24;
        MidiSkinDressInfo r5 = this.a;
        if (r5 == null) goto L26;
        MidiSkinMaterial r6 = r5.getMaterial();
        if (r6 == null) goto L27;
        BackgroundMaterial r7 = r6.getBg();
        if (r7 != null) goto L29;
        return null;
    L29:
        return r7.getSongTitleBgImage();
    L27:
        return null;
    L26:
        return null;
    L24:
        int r8 = qy.a.a;
        return qy.a.a(com.bytedance.android.live.ktv.common.midi.j.d);
    L11:
        r3 = null;
    L15:
        r4 = false;
        goto L16
    L5:
        r1 = null;
        goto L7
    }

    public final void R5() {
        Disposable r0 = this.m;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        r0.dispose();
        return;
    }

    public final int getCurShowMode() {
        return this.l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(int r11) {
        if (this.l != r11) goto L5;
        return;
    L5:
        ALogger.i("RTChorusMusicInfoView", "switchMode " + r11);
        this.l = r11;
        if (r11 == 0) goto L31;
        if (r11 == 1) goto L25;
        if (r11 != 2) goto L10;
        View r12 = this.i;
        View r5 = this.c;
        View r6 = this.f;
        if (r12 == null) goto L38;
        if (r5 == null) goto L39;
        if (r6 == null) goto L40;
        fd0.f r7 = LiveAnimator.a(new View[]{r5});
        r7.a();
        LiveAnimator r8 = r7.a;
        r8.b = 200;
        r8.h = new i(r5);
        r8.i = new d(r5, this);
        r7.e();
        fd0.f r0 = LiveAnimator.a(new View[]{r12, r6});
        r0.b();
        LiveAnimator r3 = r0.a;
        r3.b = 200;
        r3.i = new j(r12, r6);
        r0.e();
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L10:
        if (r11 != 3) goto L46;
        ConstraintLayout r13 = this.i;
        ConstraintLayout r1 = this.c;
        ConstraintLayout r2 = this.f;
        if (r13 == null) goto L19;
        if (r1 == null) goto L19;
        if (r2 == null) goto L19;
        r13.clearAnimation();
        r1.clearAnimation();
        r2.clearAnimation();
        if (getVisibility() == 4) goto L19;
        UtilityKotlinExtentionsKt.u(this);
    L19:
        R5();
        return;
    L46:
        return;
    L25:
        View r14 = this.i;
        View r9 = this.c;
        View r10 = this.f;
        if (r14 == null) goto L30;
        if (r9 == null) goto L30;
        if (r10 == null) goto L30;
        fd0.f r15 = LiveAnimator.a(new View[]{r10});
        r15.a();
        LiveAnimator r16 = r15.a;
        r16.b = 200;
        r16.h = new g(r10);
        r16.i = new c(r10, this);
        r15.e();
        fd0.f r4 = LiveAnimator.a(new View[]{r14, r9});
        r4.b();
        LiveAnimator r17 = r4.a;
        r17.b = 200;
        r17.i = new h(r14, r9);
        r4.e();
    L30:
        R5();
        return;
    L31:
        View r18 = this.i;
        View r19 = this.c;
        View r20 = this.f;
        if (r18 == null) goto L43;
        if (r19 == null) goto L44;
        if (r20 == null) goto L45;
        fd0.f r21 = LiveAnimator.a(new View[]{r18});
        r21.a();
        LiveAnimator r22 = r21.a;
        r22.b = 200;
        r22.h = new e(r18);
        r22.i = new b(r18, this);
        r21.e();
        fd0.f r110 = LiveAnimator.a(new View[]{r19, r20});
        r110.b();
        LiveAnimator r23 = r110.a;
        r23.b = 200;
        r23.i = new f(r19, r20);
        r110.e();
        return;
    L45:
        return;
    L44:
        return;
    }

    public final void T5(String r2) {
        Intrinsics.checkNotNullParameter(r2, "musicTitle");
        TextView r0 = this.g;
        if (r0 == null) goto L5;
        r0.setText(r2);
    L5:
        TextView r1 = this.d;
        if (r1 == null) goto L9;
        r1.setText(r2);
        return;
    }

    public final void U5(long r8) {
        if (r8 < 1000) goto L17;
        long r0 = 999;
        long r2 = -999;
        long r4 = this.k - r8;
        if (r2 <= r4) goto L8;
    L10:
        this.k = r8;
        String r9 = new SimpleDateFormat("mm:ss", Locale.US).format(Long.valueOf(r8));
        TextView r10 = this.e;
        if (r10 == null) goto L13;
        r10.setText(r9);
    L13:
        TextView r11 = this.h;
        if (r11 == null) goto L18;
        r11.setText(r9);
        return;
    L18:
        return;
    L8:
        if (r0 < r4) goto L10;
        return;
    }

    public final void y(MidiSkinDressInfo r3) {
        this.a = r3;
        com.bytedance.android.livesdk.chatroom.utils.a1.o(this.b, getMusicInfoBgModel(), ImageView.ScaleType.FIT_XY);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RTChorusMusicInfoView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.k = Long.MAX_VALUE;
        this.l = -1;
        this.n = new CompositeDisposable();
        this.p = new NextLiveData();
        LayoutInflater.from(r2).inflate(2131567402, this);
        this.c = findViewById(2131374069);
        HSImageView r5 = findViewById(2131380494);
        this.b = r5;
        com.bytedance.android.livesdk.chatroom.utils.a1.o(r5, getMusicInfoBgModel(), ImageView.ScaleType.FIT_XY);
        ImageView r6 = (ImageView) findViewById(2131374082);
        this.d = (TextView) findViewById(2131374070);
        this.e = (TextView) findViewById(2131374071);
        this.f = findViewById(2131363370);
        ImageView r7 = (ImageView) findViewById(2131363378);
        TextView r8 = (TextView) findViewById(2131363371);
        this.g = r8;
        if (r8 == null) goto L5;
        r8.setMaxWidth(s1.t() - s1.f(170.0f));
    L5:
        this.h = (TextView) findViewById(2131363372);
        this.i = findViewById(2131380969);
        this.j = (TextView) findViewById(2131380972);
        S5(0);
    }

    public /* synthetic */ RTChorusMusicInfoView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
