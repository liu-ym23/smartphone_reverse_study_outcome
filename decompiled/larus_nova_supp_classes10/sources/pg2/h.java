package pg2;

import android.view.MotionEvent;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.adapter.LiveDetailPagerAdapter;
import com.bytedance.android.livesdk.landscapeslide.LiveLandSlideContext;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import com.bytedance.android.livesdk.widget.e0;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h implements e0 {
    public final /* synthetic */ i a;

    public h(i r1) {
        this.a = r1;
    }

    public final void a(MotionEvent r8) {
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.e() == true) goto L6;
        return;
    L6:
        if (LiveLandSlideContext.isSlideAble() == false) goto L8;
        return;
    L8:
        LiveVerticalViewPager r0 = this.a.a;
        if (r0 != null) goto L11;
        return;
    L11:
        int r1 = r0.getCurrentItem();
        boolean r2 = true;
        if (r8.getY() > this.a.a.getInitialMotionY()) goto L14;
        boolean r9 = true;
    L15:
        i r3 = this.a;
        int r4 = r1 + 1;
        r3.getClass();
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.e() == true) goto L19;
    L17:
        boolean r5 = false;
    L24:
        if (r5 == true) goto L41;
        i r6 = this.a;
        int r7 = r1 - 1;
        r6.getClass();
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.a.h() != 4) goto L29;
        boolean r10 = true;
    L30:
        if (r10 == true) goto L33;
    L31:
        boolean r11 = false;
    L38:
        if (r11 == true) goto L41;
        r2 = false;
        goto L41
    L33:
        if (i.f(r6.i, r6.h) == false) goto L31;
        if (r9 == true) goto L31;
        r11 = r6.c(r7, r1);
        goto L38
    L29:
        r10 = false;
    L41:
        if (r2 == false) goto L44;
        this.a.getClass();
        i.g("onInterceptTouchEvent is called. mIsBeingDragged is true");
        LiveVerticalViewPager r12 = this.a.a;
        r12.L2 = 0.99f;
        r12.o = false;
        return;
    L44:
        return;
    L19:
        if (i.f(r3.i, r3.h) == false) goto L17;
        if (r9 == false) goto L17;
        r5 = r3.c(r1, r4);
        goto L24
    L14:
        r9 = false;
        goto L15
    }

    public final void b(MotionEvent r13) {
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.b() == true) goto L6;
        return;
    L6:
        if (LiveLandSlideContext.isSlideAble() == false) goto L8;
        return;
    L8:
        i r0 = this.a;
        boolean r2 = false;
        if (r0.k > 0.0f) goto L11;
        r0.k = r0.a.getInitialMotionY();
        i r1 = this.a;
        r1.l = r1.a.getCurrentItem();
        this.a.m = false;
    L11:
        i r3 = this.a;
        r3.getClass();
        float r4 = Math.abs(r13.getY() - r3.k);
        if (r4 < 0.001d) goto L91;
        if ((r13.getY() - r3.k) >= 0.0f) goto L17;
        boolean r11 = true;
    L19:
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.e() == false) goto L91;
        r13.getY();
        r13.getAction();
        float r5 = r4 / s1.s(r3.d);
        int r6 = r3.a.getCurrentItem();
        int r7 = r6 + 1;
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.e() == true) goto L24;
    L22:
        boolean r8 = false;
    L29:
        if (r8 == true) goto L44;
        int r9 = r6 - 1;
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.a.h() != 4) goto L34;
        boolean r10 = true;
    L35:
        if (r10 == true) goto L38;
    L36:
        boolean r12 = false;
    L43:
        if (r12 == true) goto L44;
    L45:
        if (r2 == true) goto L47;
        r3.i(r13);
        goto L91
    L47:
        r3.n = true;
        float r14 = r13.getY() - r3.k;
        ILiveRoomPlayFragment r15 = r3.d();
        if (r15 != null) goto L50;
    L52:
        r3.h();
    L53:
        ILiveRoomPlayFragment r16 = null;
        if (r11 == false) goto L72;
        LiveDetailPagerAdapter r17 = r3.f;
        if (r17 != null) goto L58;
    L67:
        if (r16 != null) goto L69;
    L71:
        r3.h();
    L89:
        r3.i(r13);
        goto L91
    L69:
        if ((r16.getRealAction() instanceof b) == false) goto L71;
        r16.hashCode();
        b r18 = (b) r16.getRealAction();
        r3.g = r18;
        r3.j(r18, r5, true, false, r14);
        goto L89
    L58:
        if (r17.getCount() == 0) goto L67;
        LiveVerticalViewPager r19 = r3.a;
        if (r19 == null) goto L67;
        int r20 = r19.getCurrentItem() + 1;
        if (r20 < 0) goto L67;
        if (r20 >= r3.f.getCount()) goto L67;
        r16 = r3.f.i(r20);
        goto L67
    L72:
        LiveDetailPagerAdapter r21 = r3.f;
        if (r21 != null) goto L75;
    L84:
        if (r16 != null) goto L86;
    L88:
        r3.h();
        goto L89
    L86:
        if ((r16.getRealAction() instanceof b) == false) goto L88;
        r16.hashCode();
        b r22 = (b) r16.getRealAction();
        r3.g = r22;
        r3.j(r22, r5, false, false, r14);
        goto L89
    L75:
        if (r21.getCount() == 0) goto L84;
        LiveVerticalViewPager r23 = r3.a;
        if (r23 == null) goto L84;
        int r24 = r23.getCurrentItem() - 1;
        if (r24 < 0) goto L84;
        if (r24 >= r3.f.getCount()) goto L84;
        r16 = r3.f.i(r24);
        goto L84
    L50:
        if ((r15.getRealAction() instanceof b) == false) goto L52;
        r15.hashCode();
        r3.j((b) r15.getRealAction(), r5, r11, true, r14);
        goto L53
    L38:
        if (i.f(r3.i, r3.h) == false) goto L36;
        if (r11 == true) goto L36;
        r12 = r3.c(r9, r6);
        goto L43
    L34:
        r10 = false;
    L44:
        r2 = true;
        goto L45
    L24:
        if (i.f(r3.i, r3.h) == false) goto L22;
        if (r11 == false) goto L22;
        r8 = r3.c(r6, r7);
        goto L29
    L17:
        r11 = false;
    L91:
        if (1 != r13.getAction()) goto L94;
        this.a.k = 0.0f;
        return;
    }
}
