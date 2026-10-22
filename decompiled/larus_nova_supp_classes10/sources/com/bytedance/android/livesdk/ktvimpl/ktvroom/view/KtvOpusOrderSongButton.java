package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.KtvModeOrderSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomInteractViewModel;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.bdlocation.exception.BDLocationException;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\t\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/KtvOpusOrderSongButton;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lio/reactivex/disposables/CompositeDisposable;", "e", "Lio/reactivex/disposables/CompositeDisposable;", "getMCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "setMCompositeDisposable", "(Lio/reactivex/disposables/CompositeDisposable;)V", "mCompositeDisposable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvOpusOrderSongButton extends ConstraintLayout {
    public static final /* synthetic */ int f = 0;
    public final TextView a;
    public final TextView b;
    public final View c;
    public KtvContext d;
    public CompositeDisposable e;

    public static final class a {
    }

    static {
    }

    public final boolean S5() {
        KtvModeOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r0 = KtvModeOrderSongDataContext.Companion.e();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.hasNewKtvDress() != true) goto L7;
        return true;
    }

    public final void R5() {
        int r1 = 0;
        if (S5() == false) goto L8;
        View r0 = this.c;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mKtvDressYellowDot");
    L7:
        r0.setVisibility(0);
    L12:
        KtvContext r2 = this.d;
        if (r2 == null) goto L15;
        r1 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.e(r2);
    L15:
        U5(r1);
        com.bytedance.android.livesdk.ktvimpl.base.util.j r3 = com.bytedance.android.livesdk.ktvimpl.base.util.j.l;
        View r4 = this.c;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mKtvDressYellowDot");
    L18:
        r3.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.util.j.h(r4);
        return;
    L8:
        View r5 = this.c;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mKtvDressYellowDot");
    L11:
        r5.setVisibility(8);
        goto L12
    }

    public final CompositeDisposable getMCompositeDisposable() {
        return this.e;
    }

    public final void U5(int r6) {
        if (S5() == false) goto L10;
        TextView r7 = this.b;
        if (r7 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L7:
        r7.setVisibility(8);
        return;
    L10:
        if (r6 <= 0) goto L21;
        String r1 = String.valueOf(r6);
        if (r6 <= 99) goto L14;
        r1 = "99+";
    L14:
        TextView r3 = this.b;
        if (r3 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L17:
        r3.setVisibility(0);
        TextView r4 = this.b;
        if (r4 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L20:
        r4.setText(r1);
    L28:
        TextView r2 = this.b;
        if (r2 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L31:
        if (r2 == null) goto L33;
        r2.setClickable(false);
    L33:
        TextView r0 = this.a;
        if (r0 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mOrderSongBtn");
    L36:
        r3.a(r0, "点歌" + r6 + 39318);
        TextView r5 = this.b;
        if (r5 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L39:
        r3.a(r5, "点歌" + r6 + 39318);
        com.bytedance.android.livesdk.ktvimpl.base.util.j r8 = com.bytedance.android.livesdk.ktvimpl.base.util.j.l;
        TextView r9 = this.b;
        if (r9 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L42:
        r8.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.util.j.h(r9);
        return;
    L21:
        TextView r10 = this.b;
        if (r10 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L24:
        r10.setText(BDLocationException.ERROR_TIMEOUT);
        TextView r11 = this.b;
        if (r11 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L27:
        r11.setVisibility(8);
        goto L28
    }

    public final void setMCompositeDisposable(CompositeDisposable r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KtvOpusOrderSongButton(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
        this.e = new CompositeDisposable();
        LayoutInflater.from(r2).inflate(2131566520, this);
        this.a = (TextView) findViewById(2131376998);
        this.b = (TextView) findViewById(2131377011);
        this.c = findViewById(2131376929);
    }

    public final void T5(final KtvContext r2, KtvRoomInteractViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "ktvContext");
        Intrinsics.checkNotNullParameter(r3, "vm");
        if (this.e.isDisposed() == false) goto L5;
        this.e = new CompositeDisposable();
    L5:
        this.d = r2;
        TextView r4 = this.a;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mOrderSongBtn");
    L8:
        r4.setOnClickListener(x0.a(new KtvOpusOrderSongButton$initFunction$1(this, r2)));
        R5();
    }
}
