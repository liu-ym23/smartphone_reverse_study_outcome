package pg2;

import am2.x;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.antiaddiction.LiveAntiAddictionManager;
import com.bytedance.android.livesdk.chatroom.adapter.LiveDetailPagerAdapter;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdk.config.du;
import com.bytedance.android.livesdk.config.h31;
import com.bytedance.android.livesdk.config.r4;
import com.bytedance.android.livesdk.feedback.FeedbackManager;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import ita.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kn2.k;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i implements d {
    public LiveVerticalViewPager a;
    public ILiveRoomListProvider b;
    public Fragment c;
    public FragmentActivity d;
    public kn2.b e;
    public a f;
    public b g;
    public String h;
    public String i;
    public c j;
    public float k;
    public int l;
    public boolean m;
    public boolean n;
    public final f o;

    @Override // pg2.d
    public final String a() {
        f r0 = this.o;
        r0.getClass();
        String r1 = f.c();
        return r0.d(r1) + "-" + r0.e(r1);
    }

    @Override // pg2.d
    public final boolean b() {
        f r0 = this.o;
        r0.getClass();
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.b() == false) goto L45;
        Bundle r1 = r0.g;
        if (r1 == null) goto L9;
        String r2 = r1.getString("pre_enter_from");
        if (r2 == null) goto L9;
    L10:
        String r3 = f.c();
        String r4 = r0.b + '-' + r0.c;
        com.bytedance.android.livesdk.chatroom.followrecommendguide.a.g("canLoadMoreWhenEmpty.enterSource = " + r3 + ", followEnterSource:" + r4);
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.c(r3) == false) goto L13;
    L42:
        return true;
    L13:
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.c(r4) == true) goto L42;
        Intrinsics.checkNotNullParameter(r2, "enterComponent");
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.b() == true) goto L18;
    L40:
        boolean r5 = false;
    L41:
        if (r5 == true) goto L42;
        return false;
    L18:
        if (((List) du.a.getValue()).contains(r2) == false) goto L40;
        h31 r6 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.a;
        if (r6 == null) goto L23;
        List r7 = r6.a();
    L24:
        List r8 = r7;
        if (r8 != null) goto L27;
    L30:
        boolean r9 = true;
    L31:
        if (r9 == true) goto L40;
        h31 r10 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.a;
        if (r10 == null) goto L40;
        List r11 = r10.a();
        if (r11 == null) goto L40;
        if (r11.contains(r2) != true) goto L40;
        r5 = true;
        goto L41
    L27:
        if (r8.isEmpty() == true) goto L30;
        r9 = false;
        goto L31
    L23:
        r7 = null;
    L9:
        r2 = "";
        goto L10
    L45:
        return false;
    }

    public final ILiveRoomPlayFragment d() {
        LiveDetailPagerAdapter r0 = this.f;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.getCount() == 0) goto L13;
        LiveVerticalViewPager r1 = this.a;
        if (r1 == null) goto L14;
        LiveDetailPagerAdapter r2 = this.f;
        LiveDetailPagerAdapter r3 = r2;
        return r3.i(r1.getCurrentItem());
    L14:
        return null;
    L13:
        return null;
    }

    public final String e() {
        f r0 = this.o;
        r0.getClass();
        String r1 = f.c();
        String r2 = r0.d(r1) + "_" + r0.e(r1);
        int r3 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.a;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r0.f) == false) goto L13;
        Uri r4 = UriProtector.parse(r0.f);
        l r9 = new l("/webcast/feed/");
        if (r4 == null) goto L12;
        Iterator r5 = ((ArrayList) UtilityKotlinExtentionsKt.l(r4)).iterator();
    L8:
        if (r5.hasNext() == false) goto L12;
        Pair r6 = (Pair) r5.next();
        if (r0.a.contains(r6.getFirst()) == true) goto L8;
        r9.c((String) r6.getFirst(), (String) r6.getSecond());
    L12:
        r9.c("source_key", r2);
        r9.a("need_map", 1);
        r9.a("show_type", 2);
        return r9.d();
    L13:
        l r7 = new l("/webcast/feed/");
        r7.c("source_key", r2);
        r7.a("need_map", 1);
        r7.a("show_type", 2);
        return r7.d();
    }

    public i() {
        this.k = 0.0f;
        this.m = false;
        this.o = new f();
    }

    public final void h() {
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.e() == false) goto L6;
        LiveVerticalViewPager r0 = this.a;
        r0.L2 = 1.0f;
        r0.o = true;
        return;
    }

    public static void g(String r2) {
        com.bytedance.android.livesdk.chatroom.followrecommendguide.a.g("LiveRoomFeedEmptyController," + r2);
    }

    public final void i(MotionEvent r5) {
        if (this.n == true) goto L5;
        return;
    L5:
        ILiveRoomPlayFragment r0 = d();
        if (r0 != null) goto L8;
    L21:
        h();
        return;
    L8:
        if ((r0.getRealAction() instanceof b) == false) goto L21;
        b r1 = r0.getRealAction();
        if (r5 != null) goto L12;
        b r6 = this.g;
        if (r6 == null) goto L20;
        r6.b();
    L20:
        LiveVerticalViewPager r7 = this.a;
        r7.L2 = 1.0f;
        r7.o = true;
        r1.e();
        r1.b();
        this.n = false;
        return;
    L12:
        if (r5.getAction() != 1) goto L23;
        b r2 = this.g;
        if (r2 == null) goto L16;
        r2.b();
    L16:
        r1.f(Math.abs(r5.getY() - this.k) / s1.s(this.d));
        r1.e();
        this.n = false;
        return;
    }

    public static boolean f(String r7, String r8) {
        h31 r0 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.a;
        r4 r1 = (r4) com.bytedance.android.livesdk.chatroom.followrecommendguide.a.a.c().get(r7 + "-" + r8);
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        Iterator r3 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.a.c().entrySet().iterator();
    L9:
        boolean r4 = true;
    L11:
        if (r3.hasNext() == false) goto L20;
        Map.Entry r5 = (Map.Entry) r3.next();
        if (((r4) r5.getValue()).f().equals(r7) == false) goto L11;
        if (((r4) r5.getValue()).g().equals(r8) == false) goto L11;
        if (((r4) r5.getValue()).d() == 0) goto L9;
        r4 = false;
        goto L11
    L20:
        if (r2 == true) goto L22;
        if (r4 == true) goto L22;
        return false;
    L22:
        return true;
    L5:
        if (r1.d() != 0) goto L7;
        r2 = true;
        goto L8
    }

    public final boolean c(int r10, int r11) {
        if (b() == true) goto L5;
        return false;
    L5:
        ILiveRoomListProvider r0 = this.b;
        if (r0 != null) goto L8;
        return false;
    L8:
        if (r10 >= 0) goto L10;
        return false;
    L10:
        if (r10 >= r0.size()) goto L79;
        if (r11 >= 0) goto L14;
        return false;
    L14:
        if (r11 >= this.b.size()) goto L80;
        FeedItem r1 = this.b.getFeedItem(r10);
        FeedItem r2 = this.b.getFeedItem(r11);
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.a.d() == false) goto L37;
        if (r1 == null) goto L37;
        if (r2 == null) goto L37;
        FeedbackManager.Companion.getClass();
        if (FeedbackManager.b.b(r1) == false) goto L25;
    L36:
        boolean r3 = true;
    L38:
        if (r3 == false) goto L40;
        return false;
    L40:
        ILiveRoomListProvider r4 = this.b;
        if (r4 == null) goto L43;
        Bundle r12 = r4.getRoomArgs(r10);
    L44:
        ILiveRoomListProvider r5 = this.b;
        if (r5 == null) goto L47;
        Bundle r13 = r5.getRoomArgs(r11);
    L48:
        String r14 = r12.getString("live.intent.extra.LIVE_FOLLOW_RECOMMEND_UNREAD_EXTRA", "");
        String r15 = r13.getString("live.intent.extra.LIVE_FOLLOW_RECOMMEND_UNREAD_EXTRA", "");
        Intrinsics.checkNotNullParameter(r14, "unreadExtraF");
        Intrinsics.checkNotNullParameter(r15, "unreadExtraR");
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.j() == false) goto L63;
        Iterator r6 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.d.iterator();
        boolean r7 = false;
        boolean r8 = false;
    L52:
        if (r6.hasNext() == false) goto L59;
        String r9 = (String) r6.next();
        if (StringsKt.contains$default(r14, r9, false, 2, null) == false) goto L57;
        r7 = true;
    L57:
        if (StringsKt.contains$default(r15, r9, false, 2, null) == false) goto L52;
        r8 = true;
        goto L52
    L59:
        if (r7 == true) goto L75;
        if (r8 == false) goto L76;
    L66:
        return true;
    L76:
        return false;
    L75:
        return false;
    L63:
        if (StringsKt.contains$default(r14, "follow_recommend_", false, 2, null) == false) goto L65;
        return false;
    L65:
        if (StringsKt.contains$default(r15, "follow_recommend_", false, 2, null) == true) goto L66;
        return false;
    L47:
        r13 = null;
        goto L48
    L43:
        r12 = null;
        goto L44
    L25:
        if (FeedbackManager.b.b(r2) == true) goto L36;
        LiveAntiAddictionManager.Companion.getClass();
        if (r1.type != 22) goto L29;
        boolean r16 = true;
    L30:
        if (r16 == true) goto L36;
        if (r2.type != 22) goto L34;
        boolean r17 = true;
    L35:
        if (r17 == false) goto L37;
    L34:
        r17 = false;
        goto L35
    L29:
        r16 = false;
    L37:
        r3 = false;
        goto L38
    L80:
        return false;
    L79:
        return false;
    }

    public final void k(Bundle r4, Bundle r5) {
        if (b() == true) goto L5;
        return;
    L5:
        if (r5 == null) goto L7;
        r5.putString("enter_from_merge", this.i);
        r5.putString("enter_method", this.h);
    L7:
        if (r4 == null) goto L11;
        r4.putString("enter_from_merge", this.i);
        r4.putString("enter_method", this.h);
        return;
    }

    public final void l(boolean r4, int r5) {
        h31 r0 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.a;
        if (r4 == false) goto L10;
        f r6 = this.o;
        String r1 = r6.e;
        this.h = r1;
        String r7 = r6.d;
        this.i = r7;
        wi1.h r2 = this.j;
        if (r2 == null) goto L7;
        ls2.d r3 = r2.a;
        r3.e = r7;
        r3.f = r1;
    L7:
        e r8 = this.b;
        if ((r8 instanceof e) == false) goto L16;
        r8.l(e());
    L16:
        LiveDetailPagerAdapter r9 = this.f;
        if (r9 != null) goto L19;
        return;
    L19:
        if (r5 > r9.getCount()) goto L28;
        ILiveRoomListProvider r10 = this.b;
        if (r10 == null) goto L24;
        Bundle r11 = r10.getRoomArgs(r5);
    L25:
        k(r11, m0.a(r11));
        return;
    L24:
        r11 = null;
        goto L25
    L28:
        return;
    L10:
        f r12 = this.o;
        String r13 = r12.c;
        this.h = r13;
        String r14 = r12.b;
        this.i = r14;
        wi1.h r15 = this.j;
        if (r15 == null) goto L13;
        ls2.d r16 = r15.a;
        r16.e = r14;
        r16.f = r13;
    L13:
        e r17 = this.b;
        if ((r17 instanceof e) == false) goto L16;
        r17.l(r12.f);
        goto L16
    }

    public final void j(b r13, float r14, boolean r15, boolean r16, float r17) {
        r13.d(r14, Math.max(0.9f, Math.abs((1.0f - r14) - 1.0E-4f)), r15, this.l, r16, r17, this.a, this.i, this.h);
        k r1 = this.e;
        if (r1 == null) goto L6;
        k r2 = r1;
        View r3 = r2.z;
        UIUtils.setViewVisibility(r2.A, 8);
        UIUtils.setViewVisibility(r3, 8);
    L6:
        if (this.m == true) goto L13;
        g("isReportRecommendData is called");
        com.bytedance.android.livesdk.log.g r4 = u.l();
        LinkedHashMap r5 = new LinkedHashMap();
        if (r15 == false) goto L10;
        String r6 = "down";
    L11:
        r5.put("draw_action", r6);
        Unit r7 = Unit.INSTANCE;
        r4.sendLog("livesdk_end_to_recommend_draw_show", r5, new Object[]{new x(), Room.class});
        this.m = true;
        return;
    L10:
        r6 = "up";
        goto L11
    }
}
