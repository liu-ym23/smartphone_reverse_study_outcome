package com.bytedance.awemeopen.apps.framework.comment.write.refactor;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import com.bytedance.awemeopen.apps.framework.comment.api.statistics.CommentMobParameters;
import com.bytedance.awemeopen.apps.framework.comment.util.CommentKeyboardUtils;
import com.bytedance.awemeopen.apps.framework.comment.widget.view.CommentMentionEditText;
import com.bytedance.awemeopen.apps.framework.comment.write.arch.panel.BasePanel;
import com.bytedance.awemeopen.apps.framework.comment.write.utils.KeyBoardHeightSp;
import com.bytedance.awemeopen.apps.framework.comment.write.utils.KeyboardUtils;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class BaseInputPanel extends BasePanel implements com.bytedance.awemeopen.apps.framework.comment.write.c, k {
    public final Context d;
    public final com.bytedance.awemeopen.apps.framework.comment.write.d e;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b f;
    public View g;
    public final Lazy h;
    public View i;
    public View j;
    public g k;
    public final m l;
    public q m;
    public final i n;
    public final j o;
    public final h p;
    public com.bytedance.awemeopen.apps.framework.comment.write.g q;

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.c
    public abstract void e(CommentMobParameters r1);

    public final void B() {
        SharedPreferences r0 = com.bytedance.awemeopen.apps.framework.comment.write.utils.a.b;
        com.bytedance.awemeopen.apps.framework.comment.write.utils.a.c = System.currentTimeMillis();
        AppCompatEditText r1 = q();
        if (r1 == null) goto L13;
        g r2 = this.k;
        if (r2 == null) goto L11;
        fz3.a r3 = r2.i;
        if (r3 == null) goto L11;
        CharSequence r4 = r3.a;
        if (r4 == null) goto L11;
    L12:
        r1.setText(r4);
    L11:
        r4 = "";
    L13:
        g r5 = this.k;
        if (r5 != null) goto L16;
    L18:
        boolean r6 = false;
    L19:
        if (r6 == false) goto L21;
        ((s) this).D(false, false);
    L22:
        AoLogger.b("write_comment", new Object[]{"base updateView"});
        j r7 = this.o;
        r7.a.setValue(Boolean.TRUE);
        return;
    L21:
        d(true);
        goto L22
    L16:
        if (r5.h != true) goto L18;
        r6 = true;
        goto L19
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.c
    public final void j() {
        ez3.e.a r0 = ez3.e.Z1;
        g r1 = this.k;
        r0.getClass();
        ez3.e r2 = ez3.e.a.a(r1);
        if (r2 == null) goto L6;
        r2.v("outer_send");
        return;
    }

    public final CommentMentionEditText q() {
        return (CommentMentionEditText) this.h.getValue();
    }

    public final void r() {
        g r0 = this.k;
        if (r0 == null) goto L10;
        com.bytedance.awemeopen.apps.framework.comment.write.g r2 = this.q;
        if (r2 == null) goto L8;
        boolean r3 = r2.b;
    L9:
        r0.h = r3;
        goto L10
    L8:
        r3 = false;
    L10:
        AoLogger.b("write_comment", new Object[]{"base parseData"});
        i r1 = this.n;
        r1.a.setValue(this.q);
    }

    public final void t() {
        AppCompatEditText r0 = q();
        if (r0 == null) goto L6;
        r0.setFocusableInTouchMode(true);
    L6:
        AppCompatEditText r1 = q();
        if (r1 == null) goto L10;
        r1.setFocusable(true);
    L10:
        AppCompatEditText r2 = q();
        if (r2 == null) goto L13;
        Boolean r3 = Boolean.valueOf(r2.requestFocus());
    L15:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == true) goto L29;
        AppCompatEditText r4 = q();
        if (r4 == null) goto L19;
        r4.getVisibility();
    L19:
        AppCompatEditText r5 = q();
        if (r5 == null) goto L22;
        r5.isEnabled();
    L22:
        AppCompatEditText r6 = q();
        if (r6 == null) goto L25;
        r6.isFocusable();
    L25:
        AppCompatEditText r7 = q();
        if (r7 == null) goto L30;
        r7.isFocusableInTouchMode();
        return;
    L30:
        return;
    L29:
        return;
    L13:
        r3 = null;
        goto L15
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.refactor.k
    public final void d(final boolean r5) {
        AoLogger.b("write_comment", new Object[]{"openKeyboard, show=" + r5 + ", delay=0"});
        AppCompatEditText r0 = q();
        if (r0 == null) goto L6;
        r0.postDelayed(new e(r5, this), 0);
        return;
    }

    public final void z(fz3.a r2) {
        g r0 = this.k;
        if (r0 == null) goto L6;
        r0.i = r2;
    L6:
        this.l.c = r2;
    }

    public final void A(boolean r10, int r11) {
        AoLogger.b("write_comment", new Object[]{"updateSoftKeyboardState, keyBoardVisible=" + r10 + ", keyBoardHeight=" + r11});
        q r1 = this.m;
        Integer r4 = null;
        if (r1 == null) goto L5;
        r1.removeCallbacksAndMessages(null);
    L5:
        if (r10 == false) goto L43;
        List<KeyboardUtils.ClearCursorDecorator> r2 = KeyboardUtils.a;
        Lazy r3 = KeyBoardHeightSp.a;
        if (r11 <= 0) goto L10;
        ((SharedPreferences) KeyBoardHeightSp.a.getValue()).edit().putInt("height", r11).apply();
    L10:
        g r5 = this.k;
        if (r5 == null) goto L13;
        Context r6 = r5.getContext();
    L14:
        g r7 = this.k;
        if (r7 != null) goto L17;
    L19:
        boolean r8 = false;
    L20:
        boolean r9 = !r8;
        Object r12 = this.f.g.get("comment_bottom_margin");
        if ((r12 instanceof Integer) == false) goto L23;
        r4 = (Integer) r12;
    L23:
        if (r4 == null) goto L25;
        int r13 = r4.intValue();
    L27:
        if (r11 > 100) goto L29;
        Lazy r14 = CommentKeyboardUtils.a;
    L69:
        ((s) this).D(r10, false);
        return;
    L29:
        Lazy r15 = CommentKeyboardUtils.a;
        if (r9 == false) goto L42;
        if (r6 == null) goto L33;
        CommentKeyboardUtils.e = (int) (d0.c(r6) * 0.75f);
    L33:
        Resources r16 = Resources.getSystem();
        int r17 = r11 + MathKt.roundToInt(TypedValue.applyDimension(1, 40, WindowDisplayMetricsOverride.apply(r16, r16.getDisplayMetrics())));
        int r0 = CommentKeyboardUtils.e;
        if (r17 <= r0) goto L36;
        r17 = r0;
    L36:
        Lazy r18 = CommentKeyboardUtils.b;
        if (r17 >= ((Number) r18.getValue()).intValue()) goto L39;
        r17 = ((Number) r18.getValue()).intValue();
    L39:
        if (r13 <= 0) goto L41;
        r17 = r17 + r13;
    L41:
        ((SharedPreferences) CommentKeyboardUtils.c.getValue()).edit().putInt("keyboard_height_portrait", r17).apply();
        goto L69
    L42:
        ((SharedPreferences) CommentKeyboardUtils.c.getValue()).edit().putInt("keyboard_height_landscape", Math.max(r11, ((Number) CommentKeyboardUtils.a.getValue()).intValue())).apply();
        goto L69
    L25:
        r13 = 0;
        goto L27
    L17:
        if (r7.e != true) goto L19;
        r8 = true;
        goto L20
    L13:
        r6 = null;
        goto L14
    L43:
        g r19 = this.k;
        if (r19 != null) goto L46;
    L48:
        boolean r110 = false;
    L49:
        if (r110 == true) goto L69;
        SharedPreferences r111 = com.bytedance.awemeopen.apps.framework.comment.write.utils.a.b;
        if ((System.currentTimeMillis() - com.bytedance.awemeopen.apps.framework.comment.write.utils.a.c) >= 240) goto L54;
        com.bytedance.awemeopen.apps.framework.comment.write.utils.a.d++;
    L54:
        if (com.bytedance.awemeopen.apps.framework.comment.write.utils.a.d < 2) goto L56;
        SharedPreferences r112 = com.bytedance.awemeopen.apps.framework.comment.write.utils.a.b;
        r112.edit().putBoolean("keyboard_can_dismiss", false).apply();
        r112.edit().putLong("keyboard_can_dismiss_expire_time", System.currentTimeMillis() + com.bytedance.awemeopen.apps.framework.comment.write.utils.a.a).apply();
    L56:
        SharedPreferences r113 = com.bytedance.awemeopen.apps.framework.comment.write.utils.a.b;
        boolean r114 = r113.getBoolean("keyboard_can_dismiss", true);
        if (r113.getLong("keyboard_can_dismiss_expire_time", 0) >= System.currentTimeMillis()) goto L59;
        r113.edit().putBoolean("keyboard_can_dismiss", true).apply();
        r114 = true;
    L59:
        if (r114 == false) goto L71;
    L63:
        if (r114 == false) goto L73;
        q r115 = this.m;
        if (r115 == null) goto L67;
        AoLogger.b("write_comment", new Object[]{"sendDismissMessage"});
        r115.sendEmptyMessageDelayed(0, 50);
    L67:
        AoLogger.b("write_comment", new Object[]{"sendDismissMessage"});
        return;
    L73:
        return;
    L71:
        MapsKt.hashMapOf(new Pair[]{TuplesKt.to("wont_dismiss_type", "by_local")});     // Catch: Throwable -> L62
        goto L63
    L46:
        if (r19.h != true) goto L48;
        r110 = true;
        goto L49
    }

    public BaseInputPanel(Context r2, com.bytedance.awemeopen.apps.framework.comment.write.d r3, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r4) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "keyboardView");
        Intrinsics.checkNotNullParameter(r4, "pageOwner");
        super(r4.d);
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.h = LazyKt.lazy(new BaseInputPanel$mEditText$2(this));
        this.l = new m();
        i r5 = new i();
        int r6 = xy3.a.a;
        xy3.a.d(i.class, r5, r4.d);
        this.n = r5;
        j r7 = new j();
        xy3.a.d(j.class, r7, r4.d);
        this.o = r7;
        h r8 = new h();
        xy3.a.d(h.class, r8, r4.d);
        this.p = r8;
        xy3.a.c(k.class, this, r4.d);
        this.m = new q(this);
    }
}
