package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import bb0.b;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.message.model.WantListenInfo;
import com.bytedance.android.livesdk.utils.d5;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0010R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u000bR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0010¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/singer/KtvComponentEmptyView;", "Landroid/widget/FrameLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "a", "Lkotlin/Lazy;", "getKtvComponentInfoContainer", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "ktvComponentInfoContainer", "Landroid/widget/LinearLayout;", "b", "getKtvComponentSingInfoHintContainer", "()Landroid/widget/LinearLayout;", "ktvComponentSingInfoHintContainer", "Landroid/widget/TextView;", "c", "getKtvComponentSingInfoHintName", "()Landroid/widget/TextView;", "ktvComponentSingInfoHintName", "d", "getKtvComponentSingInfoHintSinger", "ktvComponentSingInfoHintSinger", "e", "getKtvComponentSingInfoContainer", "ktvComponentSingInfoContainer", "Lcom/bytedance/android/live/core/widget/HSImageView;", "f", "getKtvComponentSingerAvatar", "()Lcom/bytedance/android/live/core/widget/HSImageView;", "ktvComponentSingerAvatar", "g", "getKtvComponentSingerInfoHint", "ktvComponentSingerInfoHint", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvComponentEmptyView extends FrameLayout {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;

    public static final class a {
    }

    static {
    }

    public KtvComponentEmptyView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvComponentEmptyView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final ConstraintLayout getKtvComponentInfoContainer() {
        return (ConstraintLayout) this.a.getValue();
    }

    private final LinearLayout getKtvComponentSingInfoContainer() {
        return (LinearLayout) this.e.getValue();
    }

    private final LinearLayout getKtvComponentSingInfoHintContainer() {
        return (LinearLayout) this.b.getValue();
    }

    private final TextView getKtvComponentSingInfoHintName() {
        return (TextView) this.c.getValue();
    }

    private final TextView getKtvComponentSingInfoHintSinger() {
        return (TextView) this.d.getValue();
    }

    private final HSImageView getKtvComponentSingerAvatar() {
        return (HSImageView) this.f.getValue();
    }

    private final TextView getKtvComponentSingerInfoHint() {
        return (TextView) this.g.getValue();
    }

    public final void b(KtvMusic r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        LinearLayout r0 = getKtvComponentSingInfoContainer();
        if (r0 == null) goto L7;
        UtilityKotlinExtentionsKt.t(r0);
    L7:
        LinearLayout r1 = getKtvComponentSingInfoHintContainer();
        if (r1 == null) goto L10;
        UtilityKotlinExtentionsKt.w(r1);
    L10:
        String r2 = r5.getMTitle();
        String r3 = "";
        if (r2 != null) goto L13;
        r2 = "";
    L13:
        String r6 = r5.getMAuthor();
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        ConstraintLayout r4 = getKtvComponentInfoContainer();
        if (r4 == null) goto L19;
        UtilityKotlinExtentionsKt.w(r4);
        r4.setBackground(null);
    L19:
        TextView r7 = getKtvComponentSingInfoHintName();
        if (r7 == null) goto L22;
        UtilityKotlinExtentionsKt.w(r7);
        r7.setText(r2);
    L22:
        TextView r8 = getKtvComponentSingInfoHintSinger();
        if (r8 == null) goto L33;
        UtilityKotlinExtentionsKt.w(r8);
        if (r6.length() != 0) goto L27;
        boolean r9 = true;
    L28:
        if (r9 == true) goto L31;
        r3 = " -" + a(r6, 10);
    L31:
        r8.setText(r3);
        return;
    L27:
        r9 = false;
        goto L28
    }

    public final void d(KtvMusic r17) {
        if (r17 != null) goto L4;
        return;
    L4:
        LinearLayout r0 = getKtvComponentSingInfoContainer();
        if (r0 == null) goto L7;
        UtilityKotlinExtentionsKt.w(r0);
    L7:
        LinearLayout r1 = getKtvComponentSingInfoHintContainer();
        if (r1 == null) goto L10;
        UtilityKotlinExtentionsKt.t(r1);
    L10:
        OrderInfo r2 = r17.getOrderInfo();
        if (r2 == null) goto L13;
        InteractiveSongUserInfo r3 = r2.getTopUser();
    L14:
        if (r3 == null) goto L16;
        String r4 = r3.getHighScoreSongCountFlex();
    L17:
        int r5 = d5.b(r4);
        if (r5 <= 0) goto L20;
        boolean r6 = true;
    L21:
        WantListenInfo r7 = r17.getWantListenInfo();
        long r8 = 0;
        if (r7 == null) goto L24;
        long r9 = r7.getWantListenCount().longValue();
    L26:
        if (r9 <= 0) goto L28;
        boolean r10 = true;
    L29:
        StringBuilder r11 = new StringBuilder("showSecondInfo ;; isWantListenSong == ");
        r11.append(r10);
        r11.append(" ;; isHighScoreSong == ");
        r11.append(r6);
        r11.append(" ;; topUser?.avatarThumb == ");
        if (r3 == null) goto L32;
        k r12 = r3.getAvatarThumbFlex();
    L33:
        r11.append(r12);
        r11.append(" ;; topUser?.nickName == ");
        if (r3 == null) goto L36;
        String r13 = r3.getNickNameFlex();
    L37:
        r11.append(r13);
        ALogger.i("KtvComponentEmptyView", r11.toString());
        String r14 = "";
        if (r10 == false) goto L56;
        WantListenInfo r15 = r17.getWantListenInfo();
        if (r15 == null) goto L42;
        r8 = r15.getWantListenCount().longValue();
    L42:
        bb0.a r16 = b.a;
        long r18 = r17.getMId();
        bb0.a r19 = b.a;
        if (r19 == null) goto L45;
        boolean r20 = r19.i(r18);
    L46:
        if (r20 == true) goto L48;
        String r21 = s1.C(2131918465, new Object[]{Long.valueOf(r8)});
    L53:
        r14 = r21;
    L54:
        c(0, null, 2131252177, 14.0f, r14);
        return;
    L48:
        if (r8 <= 1) goto L50;
        r21 = s1.C(2131918582, new Object[]{Long.valueOf(r8 - 1)});
        goto L53
    L50:
        if (r8 != 1) goto L54;
        r21 = s1.B(2131918466);
        goto L53
    L45:
        r20 = false;
        goto L46
    L56:
        if (r6 == false) goto L77;
        if (r3 == null) goto L60;
        k r22 = r3.getAvatarThumbFlex();
    L62:
        if ((r22 instanceof k) == true) goto L64;
        k r110 = null;
    L65:
        StringBuilder r23 = new StringBuilder();
        if (r3 == null) goto L71;
        String r24 = r3.getNickNameFlex();
        if (r24 == null) goto L71;
        r14 = r24;
    L71:
        r23.append(a(r14, 16));
        r23.append("唱过");
        if (r5 <= 999) goto L74;
        String r25 = "999+";
    L75:
        r23.append(r25);
        r23.append("首高分歌");
        c(2131249306, r110, 0, 10.0f, r23.toString());
        return;
    L74:
        r25 = String.valueOf(r5);
        goto L75
    L64:
        r110 = r22;
        goto L65
    L60:
        r22 = null;
        goto L62
    L77:
        if (r3 == null) goto L79;
        k r26 = r3.getAvatarThumbFlex();
    L81:
        if ((r26 instanceof k) == true) goto L84;
        r26 = null;
    L84:
        if (r3 == null) goto L89;
        String r27 = r3.getNickNameFlex();
        if (r27 == null) goto L89;
        r14 = r27;
    L89:
        c(0, r26, 0, 14.0f, a(r14, 16));
        return;
    L79:
        r26 = null;
        goto L81
    L36:
        r13 = null;
        goto L37
    L32:
        r12 = null;
        goto L33
    L28:
        r10 = false;
        goto L29
    L24:
        r9 = 0;
        goto L26
    L20:
        r6 = false;
        goto L21
    L16:
        r4 = null;
        goto L17
    L13:
        r3 = null;
        goto L14
    }

    public static String a(String r2, int r3) {
        if (r2.length() > r3) goto L6;
        return r2;
    L6:
        return r2.substring(0, r3) + "...";
    }

    public KtvComponentEmptyView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View.inflate(r2, 2131566444, this);
        this.a = LazyKt.lazy(new KtvComponentEmptyView$ktvComponentInfoContainer$2(this));
        this.b = LazyKt.lazy(new KtvComponentEmptyView$ktvComponentSingInfoHintContainer$2(this));
        this.c = LazyKt.lazy(new KtvComponentEmptyView$ktvComponentSingInfoHintName$2(this));
        this.d = LazyKt.lazy(new KtvComponentEmptyView$ktvComponentSingInfoHintSinger$2(this));
        this.e = LazyKt.lazy(new KtvComponentEmptyView$ktvComponentSingInfoContainer$2(this));
        this.f = LazyKt.lazy(new KtvComponentEmptyView$ktvComponentSingerAvatar$2(this));
        this.g = LazyKt.lazy(new KtvComponentEmptyView$ktvComponentSingerInfoHint$2(this));
    }

    public /* synthetic */ KtvComponentEmptyView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void c(int r3, k r4, int r5, float r6, String r7) {
        LinearLayout r0 = getKtvComponentSingInfoContainer();
        if (r0 == null) goto L14;
        r0.setBackground(null);
        r0.setBackgroundResource(r3);
        HSImageView r8 = getKtvComponentSingerAvatar();
        if (r8 == null) goto L10;
        UtilityKotlinExtentionsKt.w(r8);
        if (r4 == null) goto L9;
        ImageLoader.bindImage(r8, r4);
        goto L10
    L9:
        a1.m(r8, r5);
    L10:
        TextView r9 = getKtvComponentSingerInfoHint();
        if (r9 == null) goto L15;
        UtilityKotlinExtentionsKt.w(r9);
        r9.setTextSize(r6);
        r9.setText(r7);
        return;
    L15:
        return;
    }
}
