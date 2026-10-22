package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.ktvapi.util.KtvCommonSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0005B'\b\u0007\u0012\u0006\u0010X\u001a\u00020W\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010Y\u0012\b\b\u0002\u0010[\u001a\u00020\u0002¢\u0006\u0004\b\\\u0010]J\b\u0010\u0003\u001a\u00020\u0002H\u0002R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010 \u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010#\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u000e\u001a\u0004\b\"\u0010\u001aR\u001d\u0010&\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000e\u001a\u0004\b%\u0010\u001aR\u001d\u0010)\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u000e\u001a\u0004\b(\u0010\u001aR\u001d\u0010,\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u000e\u001a\u0004\b+\u0010\u001fR\u001d\u0010/\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u000e\u001a\u0004\b.\u0010\u001aR\u001d\u00102\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u000e\u001a\u0004\b1\u0010\u0015R\u001d\u00105\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u000e\u001a\u0004\b4\u0010\u0015R\u001d\u00108\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u000e\u001a\u0004\b7\u0010\u001aR\u001d\u0010;\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u000e\u001a\u0004\b:\u0010\u001aR\u001d\u0010>\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u000e\u001a\u0004\b=\u0010\u0015R\u001d\u0010A\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u000e\u001a\u0004\b@\u0010\u001fR\u001d\u0010E\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u000e\u001a\u0004\bC\u0010DR\u001d\u0010H\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010\u000e\u001a\u0004\bG\u0010\u001fR\u001d\u0010K\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\u000e\u001a\u0004\bJ\u0010\u001fR\u001d\u0010N\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010\u000e\u001a\u0004\bM\u0010\u001aR\u001d\u0010Q\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010\u000e\u001a\u0004\bP\u0010\u001fR\u001d\u0010V\u001a\u0004\u0018\u00010R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\u000e\u001a\u0004\bT\u0010U¨\u0006^"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/view/secondleveltab/FloatingBottomView;", "Landroid/widget/FrameLayout;", "", "getOnlineLinkMicCount", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/d;", "a", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/d;", "getBaseOrderSongViewModel", "()Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/d;", "setBaseOrderSongViewModel", "(Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/d;)V", "baseOrderSongViewModel", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "b", "Lkotlin/Lazy;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Landroid/view/View;", "c", "getBottomDiver", "()Landroid/view/View;", "bottomDiver", "Landroid/widget/TextView;", "d", "getSequenceNum", "()Landroid/widget/TextView;", "sequenceNum", "Lcom/bytedance/android/live/core/widget/HSImageView;", "e", "getMusicCover", "()Lcom/bytedance/android/live/core/widget/HSImageView;", "musicCover", "f", "getMusicDuration", "musicDuration", "g", "getMusicName", "musicName", "h", "getMusicAuthor", "musicAuthor", "i", "getUserAvatar", "userAvatar", "j", "getUserName", "userName", "k", "getUp", "up", "l", "getMvPreViewBtn", "mvPreViewBtn", "m", "getChangeRoomStartSong", "changeRoomStartSong", "n", "getLinkMic", "linkMic", "o", "getRemove", "remove", "q", "getRtChorusLiveIv", "rtChorusLiveIv", "r", "getRtChorusAvatarFl", "()Landroid/widget/FrameLayout;", "rtChorusAvatarFl", "s", "getRtChorusAvatar1Iv", "rtChorusAvatar1Iv", "t", "getRtChorusAvatar2Iv", "rtChorusAvatar2Iv", "u", "getRtChorusJoinTv", "rtChorusJoinTv", "v", "getRtChorusArrowIv", "rtChorusArrowIv", "Landroid/widget/LinearLayout;", "w", "getMusicInfoLl", "()Landroid/widget/LinearLayout;", "musicInfoLl", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class FloatingBottomView extends FrameLayout {
    public static final /* synthetic */ int y = 0;
    public com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final View p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public MusicPanel x;

    public static final class a {
        public static void a(View r1) {
            Intrinsics.checkNotNullParameter(r1, "$this$hideSelf");
            r1.setVisibility(8);
        }
    }

    static {
    }

    public FloatingBottomView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FloatingBottomView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final View getBottomDiver() {
        return (View) this.c.getValue();
    }

    private final TextView getChangeRoomStartSong() {
        return (TextView) this.m.getValue();
    }

    private final DataCenter getDataCenter() {
        return (DataCenter) this.b.getValue();
    }

    private final TextView getLinkMic() {
        return (TextView) this.n.getValue();
    }

    private final TextView getMusicAuthor() {
        return (TextView) this.h.getValue();
    }

    private final HSImageView getMusicCover() {
        return (HSImageView) this.e.getValue();
    }

    private final TextView getMusicDuration() {
        return (TextView) this.f.getValue();
    }

    private final LinearLayout getMusicInfoLl() {
        return (LinearLayout) this.w.getValue();
    }

    private final TextView getMusicName() {
        return (TextView) this.g.getValue();
    }

    private final View getMvPreViewBtn() {
        return (View) this.l.getValue();
    }

    private final View getRemove() {
        return (View) this.o.getValue();
    }

    private final HSImageView getRtChorusArrowIv() {
        return (HSImageView) this.v.getValue();
    }

    private final HSImageView getRtChorusAvatar1Iv() {
        return (HSImageView) this.s.getValue();
    }

    private final HSImageView getRtChorusAvatar2Iv() {
        return (HSImageView) this.t.getValue();
    }

    private final FrameLayout getRtChorusAvatarFl() {
        return (FrameLayout) this.r.getValue();
    }

    private final TextView getRtChorusJoinTv() {
        return (TextView) this.u.getValue();
    }

    private final HSImageView getRtChorusLiveIv() {
        return (HSImageView) this.q.getValue();
    }

    private final TextView getSequenceNum() {
        return (TextView) this.d.getValue();
    }

    private final View getUp() {
        return (View) this.k.getValue();
    }

    private final HSImageView getUserAvatar() {
        return (HSImageView) this.i.getValue();
    }

    private final TextView getUserName() {
        return (TextView) this.j.getValue();
    }

    public static boolean e() {
        Boolean r0 = o3.f().isAnchor();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    private final int getOnlineLinkMicCount() {
        DataCenter r0 = getDataCenter();
        if (r0 == null) goto L7;
        List r1 = (List) r0.get("data_online_changed_list", new ArrayList());
        if (r1 == null) goto L7;
        return r1.size();
    L7:
        return 0;
    }

    public final void c() {
        View r0 = getUp();
        if (r0 != null) goto L5;
    L6:
        View r1 = getRemove();
        if (r1 != null) goto L9;
    L16:
        View r2 = getUp();
        if (r2 != null) goto L19;
    L20:
        View r3 = getRemove();
        if (r3 != null) goto L23;
    L24:
        TextView r4 = getMusicName();
        if (r4 == null) goto L27;
        r4.setMaxWidth(s1.j(2131168836));
    L27:
        TextView r5 = getLinkMic();
        boolean r6 = false;
        if (r5 == null) goto L34;
        Intrinsics.checkNotNullParameter(r5, "$this$isVisible");
        if (r5.getVisibility() != 0) goto L32;
        boolean r7 = true;
    L33:
        if (r7 != true) goto L34;
    L40:
        TextView r8 = getMusicName();
        if (r8 == null) goto L46;
        r8.setMaxWidth(s1.j(2131168838));
        return;
    L46:
        return;
    L32:
        r7 = false;
    L34:
        TextView r9 = getChangeRoomStartSong();
        if (r9 == null) goto L44;
        Intrinsics.checkNotNullParameter(r9, "$this$isVisible");
        if (r9.getVisibility() != 0) goto L39;
        r6 = true;
    L39:
        if (r6 == true) goto L40;
        return;
    L44:
        return;
    L23:
        if (r3.getVisibility() == 0) goto L27;
    L19:
        if (r2.getVisibility() == 0) goto L27;
    L9:
        if (r1.getVisibility() != 0) goto L16;
        TextView r10 = getMusicName();
        if (r10 == null) goto L13;
        r10.setMaxWidth(s1.j(2131168839));
    L13:
        TextView r11 = getMusicAuthor();
        if (r11 == null) goto L16;
        r11.setMaxWidth(s1.j(2131168837));
        goto L16
    L5:
        if (r0.getVisibility() == 0) goto L16;
        goto L6
    }

    public final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d getBaseOrderSongViewModel() {
        return this.a;
    }

    public static final /* synthetic */ int a(FloatingBottomView r0) {
        return r0.getOnlineLinkMicCount();
    }

    public final void f(int r4) {
        boolean r1 = true;
        if (e() == false) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L10;
    L28:
        TextView r5 = getChangeRoomStartSong();
        if (r5 == null) goto L33;
        Intrinsics.checkNotNullParameter(r5, "$this$invisibleSelf");
        r5.setVisibility(4);
        return;
    L33:
        return;
    L10:
        if (r4 <= 3) goto L28;
        Integer r6 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r6 != null) goto L15;
    L17:
        r1 = false;
    L18:
        if (r1 == true) goto L28;
        if (vm2.d.e().a() == false) goto L28;
        TextView r7 = getChangeRoomStartSong();
        if (r7 == null) goto L24;
        Intrinsics.checkNotNullParameter(r7, "$this$showSelf");
        r7.setVisibility(0);
    L24:
        TextView r8 = getChangeRoomStartSong();
        if (r8 == null) goto L27;
        r8.setOnClickListener(com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.a.a);
    L27:
        jc1.k.n(IInteractService.class).getAudioTalkService().n();
        c();
        return;
    L15:
        if (r6.intValue() != 2) goto L17;
    L5:
        if (jc1.k.n(IMiddlewareUserService.class).user().isAdmin() == true) goto L7;
        r0 = true;
        goto L8
    }

    public final void setBaseOrderSongViewModel(com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r1) {
        this.a = r1;
    }

    public static final String b(FloatingBottomView r0, boolean r1) {
        r0.getClass();
        if (r1 == false) goto L6;
        return "anchor";
    L6:
        if (KtvUtilsKt.j() == false) goto L8;
        return "administrator";
    L8:
        Integer r2 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r2 != null) goto L12;
    L14:
        return "user";
    L12:
        if (r2.intValue() != 2) goto L14;
        return "guest";
    }

    public FloatingBottomView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = LazyKt.lazy(FloatingBottomView$dataCenter$2.INSTANCE);
        this.c = LazyKt.lazy(new FloatingBottomView$bottomDiver$2(this));
        this.d = LazyKt.lazy(new FloatingBottomView$sequenceNum$2(this));
        this.e = LazyKt.lazy(new FloatingBottomView$musicCover$2(this));
        this.f = LazyKt.lazy(new FloatingBottomView$musicDuration$2(this));
        this.g = LazyKt.lazy(new FloatingBottomView$musicName$2(this));
        this.h = LazyKt.lazy(new FloatingBottomView$musicAuthor$2(this));
        this.i = LazyKt.lazy(new FloatingBottomView$userAvatar$2(this));
        this.j = LazyKt.lazy(new FloatingBottomView$userName$2(this));
        this.k = LazyKt.lazy(new FloatingBottomView$up$2(this));
        this.l = LazyKt.lazy(new FloatingBottomView$mvPreViewBtn$2(this));
        this.m = LazyKt.lazy(new FloatingBottomView$changeRoomStartSong$2(this));
        this.n = LazyKt.lazy(new FloatingBottomView$linkMic$2(this));
        this.o = LazyKt.lazy(new FloatingBottomView$remove$2(this));
        View r5 = findViewById(2131384878);
        this.p = r5;
        this.q = LazyKt.lazy(new FloatingBottomView$rtChorusLiveIv$2(this));
        this.r = LazyKt.lazy(new FloatingBottomView$rtChorusAvatarFl$2(this));
        this.s = LazyKt.lazy(new FloatingBottomView$rtChorusAvatar1Iv$2(this));
        this.t = LazyKt.lazy(new FloatingBottomView$rtChorusAvatar2Iv$2(this));
        this.u = LazyKt.lazy(new FloatingBottomView$rtChorusJoinTv$2(this));
        this.v = LazyKt.lazy(new FloatingBottomView$rtChorusArrowIv$2(this));
        this.w = LazyKt.lazy(new FloatingBottomView$musicInfoLl$2(this));
        LayoutInflater.from(r2).inflate(2131566504, this, true);
        KtvOrderSongThemeManager.b(this, MonitorLevel.WARN);
        View r6 = getBottomDiver();
        if (r6 == null) goto L5;
        r6.setVisibility(0);
    L5:
        TextView r7 = getSequenceNum();
        if (r7 == null) goto L8;
        KtvOrderSongThemeManager.d(r7, KtvOrderSongThemeManager.a);
    L8:
        TextView r8 = getMusicName();
        if (r8 == null) goto L11;
        KtvOrderSongThemeManager.d(r8, 10);
    L11:
        TextView r9 = getUserName();
        if (r9 == null) goto L14;
        KtvOrderSongThemeManager.d(r9, KtvOrderSongThemeManager.a);
    L14:
        View r10 = getMvPreViewBtn();
        if (r10 == null) goto L17;
        r10.setOnClickListener(x0.a(new FloatingBottomView$addOnClickListener$1(this)));
    L17:
        View r11 = getRemove();
        if (r11 == null) goto L20;
        r11.setOnClickListener(x0.a(new FloatingBottomView$addOnClickListener$2(this)));
    L20:
        if (r5 == null) goto L23;
        r5.setOnClickListener(x0.a(FloatingBottomView$addOnClickListener$3.INSTANCE));
        return;
    }

    public final void d(MusicPanel r10, boolean r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "music");
        this.x = r10;
        ImageLoader.bindImage(getMusicCover(), r10.a.getCoverUrl());
        String r0 = r10.a.getMTitle();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        TextView r2 = getMusicName();
        if (r2 == null) goto L8;
        r2.setText(StringsKt.trimStart(r0).toString());
    L8:
        String r3 = r10.a.getMAuthor();
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        TextView r4 = getMusicAuthor();
        int r5 = 0;
        if (r4 == null) goto L14;
        r4.setText(s1.C(2131918539, new Object[]{StringsKt.trimStart(r3).toString()}));
    L14:
        HSImageView r6 = getUserAvatar();
        if (r6 == null) goto L23;
        OrderInfo r7 = r10.a.getOrderInfo();
        if (r7 == null) goto L21;
        InteractiveSongUserInfo r8 = r7.getTopUser();
        if (r8 == null) goto L21;
        py.k r9 = r8.getAvatarThumbFlex();
    L22:
        a1.x(r6, r9, r6.getWidth(), r6.getHeight(), 2131251677);
    L21:
        r9 = null;
    L23:
        TextView r13 = getUserName();
        if (r13 == null) goto L32;
        OrderInfo r14 = r10.a.getOrderInfo();
        if (r14 == null) goto L30;
        InteractiveSongUserInfo r15 = r14.getTopUser();
        if (r15 == null) goto L30;
        String r16 = r15.getNickNameFlex();
    L31:
        r13.setText(r16);
    L30:
        r16 = null;
    L32:
        boolean r17 = e();
        Integer r18 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r18 != null) goto L36;
    L38:
        boolean r19 = false;
    L40:
        if (r12 != (-1)) goto L42;
        String r110 = s1.B(2131918550);
    L43:
        com.bytedance.android.livesdk.ktvimpl.base.util.j.l.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.i() == false) goto L48;
        TextView r111 = getSequenceNum();
        if (r111 == null) goto L55;
        a.a(r111);
    L55:
        if (KtvUtilsKt.j() == true) goto L64;
        if (r17 == true) goto L64;
        View r112 = getUp();
        if (r112 == null) goto L61;
        a.a(r112);
    L61:
        TextView r113 = getLinkMic();
        if (r113 == null) goto L95;
        a.a(r113);
    L95:
        c();
        Lazy r114 = KtvCommonSettingHelper.a;
        if (KtvCommonSettingHelper.a(null) == false) goto L115;
        KtvContext.Companion.getClass();
        if (KtvContext.a.k() == false) goto L115;
        if (KtvContext.a.j() == true) goto L115;
        View r115 = getMvPreViewBtn();
        if (r115 == null) goto L115;
        KtvMusic r116 = r10.a;
        IMiddlewareUserService r117 = jc1.k.f(IMiddlewareUserService.class);
        if (r117 == null) goto L111;
        com.bytedance.android.livesdk.user.e r118 = r117.user();
        if (r118 == null) goto L111;
        String r119 = r118.n();
        if (r119 == null) goto L111;
        r1 = r119;
    L111:
        if (r116.isSinger(r1) == true) goto L114;
        r5 = 8;
    L114:
        r115.setVisibility(r5);
    L115:
        View r120 = this.p;
        if (r120 == null) goto L118;
        UtilityKotlinExtentionsKt.t(r120);
    L118:
        LinearLayout r121 = getMusicInfoLl();
        if (r121 == null) goto L121;
        r121.setDividerDrawable(s1.m(2131249595));
    L121:
        UIUtils.updateLayout(getMusicCover(), s1.f(52.0f), s1.f(52.0f));
        UIUtils.updateLayout(getMusicDuration(), s1.f(52.0f), -3);
        return;
    L64:
        if (r19 == true) goto L79;
        View r122 = getUp();
        if (r122 == null) goto L69;
        a.a(r122);
    L69:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.L0.getValue()).booleanValue() == false) goto L76;
        TextView r123 = getLinkMic();
        if (r123 == null) goto L73;
        Intrinsics.checkNotNullParameter(r123, "$this$showSelf");
        r123.setVisibility(0);
    L73:
        TextView r124 = getLinkMic();
        if (r124 == null) goto L95;
        r124.setOnClickListener(new c(this, r10));
        goto L95
    L76:
        TextView r125 = getLinkMic();
        if (r125 == null) goto L95;
        a.a(r125);
        goto L95
    L79:
        if (r11 == false) goto L89;
        TextView r126 = getLinkMic();
        if (r126 == null) goto L83;
        a.a(r126);
    L83:
        View r127 = getUp();
        if (r127 == null) goto L86;
        Intrinsics.checkNotNullParameter(r127, "$this$showSelf");
        r127.setVisibility(0);
    L86:
        View r128 = getUp();
        if (r128 == null) goto L95;
        r128.setOnClickListener(new b(this, r10, r17));
        goto L95
    L89:
        TextView r129 = getLinkMic();
        if (r129 == null) goto L92;
        a.a(r129);
    L92:
        View r130 = getUp();
        if (r130 == null) goto L95;
        a.a(r130);
        goto L95
    L48:
        TextView r20 = getSequenceNum();
        if (r20 == null) goto L51;
        r20.setText(r110);
    L51:
        TextView r131 = getSequenceNum();
        if (r131 == null) goto L55;
        Intrinsics.checkNotNullParameter(r131, "$this$showSelf");
        r131.setVisibility(0);
        goto L55
    L42:
        r110 = String.valueOf(r12 + 1);
        goto L43
    L36:
        if (r18.intValue() != 2) goto L38;
        r19 = true;
        goto L40
    }

    public /* synthetic */ FloatingBottomView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
