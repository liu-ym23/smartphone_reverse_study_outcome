package pg2;

import am2.x;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.feed.FeedApi;
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
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ILiveRoomList;
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

/* JADX INFO: loaded from: classes10.dex */
public final class i implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LiveVerticalViewPager f529153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ILiveRoomListProvider f529154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Fragment f529155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FragmentActivity f529156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public kn2.b f529157e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f529158f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f529159g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f529160h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f529161i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c f529162j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f529163k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f529164l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f529165m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f529166n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final f f529167o;

    @Override // pg2.d
    public final String a() {
        f r100 = this.f529167o;
        r100.getClass();
        String r101 = f.c();
        return r100.d(r101) + "-" + r100.e(r101);
    }

    @Override // pg2.d
    public final boolean b() {
        f r100 = this.f529167o;
        r100.getClass();
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.b() == false) goto L45;
        Bundle r101 = r100.f529150g;
        if (r101 == null) goto L9;
        String r102 = r101.getString("pre_enter_from");
        if (r102 == null) goto L9;
    L10:
        String r103 = f.c();
        String r104 = r100.f529145b + '-' + r100.f529146c;
        com.bytedance.android.livesdk.chatroom.followrecommendguide.a.g("canLoadMoreWhenEmpty.enterSource = " + r103 + ", followEnterSource:" + r104);
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.c(r103) == false) goto L13;
    L42:
        return true;
    L13:
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.c(r104) == true) goto L42;
        Intrinsics.checkNotNullParameter(r102, "enterComponent");
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.b() == true) goto L18;
    L40:
        boolean r105 = false;
    L41:
        if (r105 == true) goto L42;
        return false;
    L18:
        if (du.f120064a.getValue().contains(r102) == false) goto L40;
        h31 r106 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.f106238a;
        if (r106 == null) goto L23;
        List<String> r107 = r106.a();
    L24:
        List<String> r108 = r107;
        if (r108 != null) goto L27;
    L30:
        boolean r109 = true;
    L31:
        if (r109 == true) goto L40;
        h31 r110 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.f106238a;
        if (r110 == null) goto L40;
        List<String> r111 = r110.a();
        if (r111 == null) goto L40;
        if (r111.contains(r102) != true) goto L40;
        r105 = true;
        goto L41
    L27:
        if (r108.isEmpty() == true) goto L30;
        r109 = false;
        goto L31
    L23:
        r107 = null;
    L9:
        r102 = "";
        goto L10
    L45:
        return false;
    }

    public final ILiveRoomPlayFragment d() {
        a r100 = this.f529158f;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (((LiveDetailPagerAdapter) r100).getCount() == 0) goto L13;
        LiveVerticalViewPager r101 = this.f529153a;
        if (r101 == null) goto L14;
        a r102 = this.f529158f;
        LiveDetailPagerAdapter r103 = (LiveDetailPagerAdapter) r102;
        return r103.i(r101.getCurrentItem());
    L14:
        return null;
    L13:
        return null;
    }

    public final String e() {
        f r100 = this.f529167o;
        r100.getClass();
        String r101 = f.c();
        String r102 = r100.d(r101) + "_" + r100.e(r101);
        int r103 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.f246865a;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r100.f529149f) == false) goto L13;
        Uri r104 = UriProtector.parse(r100.f529149f);
        l r105 = new l(FeedApi.DEFAULT_FEED_API);
        if (r104 == null) goto L12;
        Iterator r106 = ((ArrayList) UtilityKotlinExtentionsKt.l(r104)).iterator();
    L8:
        if (r106.hasNext() == false) goto L12;
        Pair r107 = (Pair) r106.next();
        if (r100.f529144a.contains(r107.getFirst()) == true) goto L8;
        r105.c((String) r107.getFirst(), (String) r107.getSecond());
    L12:
        r105.c(FeedApi.SOURCE_KEY, r102);
        r105.a(FeedApi.NEED_MAP_KEY, 1);
        r105.a("show_type", 2);
        return r105.d();
    L13:
        l r108 = new l(FeedApi.DEFAULT_FEED_API);
        r108.c(FeedApi.SOURCE_KEY, r102);
        r108.a(FeedApi.NEED_MAP_KEY, 1);
        r108.a("show_type", 2);
        return r108.d();
    }

    public i() {
        this.f529163k = 0.0f;
        this.f529165m = false;
        this.f529167o = new f();
    }

    public final void h() {
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.e() == false) goto L6;
        LiveVerticalViewPager r100 = this.f529153a;
        r100.L2 = 1.0f;
        r100.f161158o = true;
        return;
    }

    public static void g(String r100) {
        com.bytedance.android.livesdk.chatroom.followrecommendguide.a.g("LiveRoomFeedEmptyController," + r100);
    }

    public final void i(MotionEvent r100) {
        if (this.f529166n == true) goto L5;
        return;
    L5:
        ILiveRoomPlayFragment r101 = d();
        if (r101 != null) goto L8;
    L21:
        h();
        return;
    L8:
        if ((r101.getRealAction() instanceof b) == false) goto L21;
        b r102 = (b) r101.getRealAction();
        if (r100 != null) goto L12;
        b r103 = this.f529159g;
        if (r103 == null) goto L20;
        r103.b();
    L20:
        LiveVerticalViewPager r104 = this.f529153a;
        r104.L2 = 1.0f;
        r104.f161158o = true;
        r102.e();
        r102.b();
        this.f529166n = false;
        return;
    L12:
        if (r100.getAction() != 1) goto L23;
        b r105 = this.f529159g;
        if (r105 == null) goto L16;
        r105.b();
    L16:
        r102.f(Math.abs(r100.getY() - this.f529163k) / s1.s(this.f529156d));
        r102.e();
        this.f529166n = false;
        return;
    }

    public static boolean f(String r100, String r101) {
        h31 r102 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.f106238a;
        r4 r103 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.f106238a.c().get(r100 + "-" + r101);
        if (r103 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        Iterator<Map.Entry<String, r4>> r105 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.f106238a.c().entrySet().iterator();
    L9:
        boolean r106 = true;
    L11:
        if (r105.hasNext() == false) goto L20;
        Map.Entry<String, r4> r107 = r105.next();
        if (r107.getValue().f().equals(r100) == false) goto L11;
        if (r107.getValue().g().equals(r101) == false) goto L11;
        if (r107.getValue().d() == 0) goto L9;
        r106 = false;
        goto L11
    L20:
        if (r104 == true) goto L22;
        if (r106 == true) goto L22;
        return false;
    L22:
        return true;
    L5:
        if (r103.d() != 0) goto L7;
        r104 = true;
        goto L8
    }

    public final boolean c(int r110, int r111) {
        if (b() == true) goto L5;
        return false;
    L5:
        ILiveRoomListProvider r100 = this.f529154b;
        if (r100 != null) goto L8;
        return false;
    L8:
        if (r110 >= 0) goto L10;
        return false;
    L10:
        if (r110 >= r100.size()) goto L79;
        if (r111 >= 0) goto L14;
        return false;
    L14:
        if (r111 >= this.f529154b.size()) goto L80;
        FeedItem r101 = this.f529154b.getFeedItem(r110);
        FeedItem r102 = this.f529154b.getFeedItem(r111);
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.f106238a.d() == false) goto L37;
        if (r101 == null) goto L37;
        if (r102 == null) goto L37;
        FeedbackManager.Companion.getClass();
        if (FeedbackManager.b.b(r101) == false) goto L25;
    L36:
        boolean r103 = true;
    L38:
        if (r103 == false) goto L40;
        return false;
    L40:
        ILiveRoomListProvider r104 = this.f529154b;
        if (r104 == null) goto L43;
        Bundle r112 = r104.getRoomArgs(r110);
    L44:
        ILiveRoomListProvider r105 = this.f529154b;
        if (r105 == null) goto L47;
        Bundle r113 = r105.getRoomArgs(r111);
    L48:
        String r114 = r112.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_FOLLOW_RECOMMEND_UNREAD_EXTRA, "");
        String r115 = r113.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_FOLLOW_RECOMMEND_UNREAD_EXTRA, "");
        Intrinsics.checkNotNullParameter(r114, "unreadExtraF");
        Intrinsics.checkNotNullParameter(r115, "unreadExtraR");
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.j() == false) goto L63;
        Iterator<String> r106 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.f106241d.iterator();
        boolean r107 = false;
        boolean r108 = false;
    L52:
        if (r106.hasNext() == false) goto L59;
        String r109 = r106.next();
        if (StringsKt.contains$default(r114, r109, false, 2, null) == false) goto L57;
        r107 = true;
    L57:
        if (StringsKt.contains$default(r115, r109, false, 2, null) == false) goto L52;
        r108 = true;
        goto L52
    L59:
        if (r107 == true) goto L75;
        if (r108 == false) goto L76;
    L66:
        return true;
    L76:
        return false;
    L75:
        return false;
    L63:
        if (StringsKt.contains$default(r114, "follow_recommend_", false, 2, null) == false) goto L65;
        return false;
    L65:
        if (StringsKt.contains$default(r115, "follow_recommend_", false, 2, null) == true) goto L66;
        return false;
    L47:
        r113 = null;
        goto L48
    L43:
        r112 = null;
        goto L44
    L25:
        if (FeedbackManager.b.b(r102) == true) goto L36;
        LiveAntiAddictionManager.Companion.getClass();
        if (r101.type != 22) goto L29;
        boolean r116 = true;
    L30:
        if (r116 == true) goto L36;
        if (r102.type != 22) goto L34;
        boolean r117 = true;
    L35:
        if (r117 == false) goto L37;
    L34:
        r117 = false;
        goto L35
    L29:
        r116 = false;
    L37:
        r103 = false;
        goto L38
    L80:
        return false;
    L79:
        return false;
    }

    public final void k(Bundle r100, Bundle r101) {
        if (b() == true) goto L5;
        return;
    L5:
        if (r101 == null) goto L7;
        r101.putString("enter_from_merge", this.f529161i);
        r101.putString("enter_method", this.f529160h);
    L7:
        if (r100 == null) goto L11;
        r100.putString("enter_from_merge", this.f529161i);
        r100.putString("enter_method", this.f529160h);
        return;
    }

    public final void l(boolean r100, int r101) {
        h31 r102 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.f106238a;
        if (r100 == false) goto L10;
        f r103 = this.f529167o;
        String r104 = r103.f529148e;
        this.f529160h = r104;
        String r105 = r103.f529147d;
        this.f529161i = r105;
        c r106 = this.f529162j;
        if (r106 == null) goto L7;
        ls2.d r107 = ((wi1.h) r106).f559747a;
        r107.f510516e = r105;
        r107.f510517f = r104;
    L7:
        ILiveRoomList r108 = this.f529154b;
        if ((r108 instanceof e) == false) goto L16;
        ((e) r108).l(e());
    L16:
        a r109 = this.f529158f;
        if (r109 != null) goto L19;
        return;
    L19:
        if (r101 > ((LiveDetailPagerAdapter) r109).getCount()) goto L28;
        ILiveRoomListProvider r110 = this.f529154b;
        if (r110 == null) goto L24;
        Bundle r111 = r110.getRoomArgs(r101);
    L25:
        k(r111, m0.a(r111));
        return;
    L24:
        r111 = null;
        goto L25
    L28:
        return;
    L10:
        f r112 = this.f529167o;
        String r113 = r112.f529146c;
        this.f529160h = r113;
        String r114 = r112.f529145b;
        this.f529161i = r114;
        c r115 = this.f529162j;
        if (r115 == null) goto L13;
        ls2.d r116 = ((wi1.h) r115).f559747a;
        r116.f510516e = r114;
        r116.f510517f = r113;
    L13:
        ILiveRoomList r117 = this.f529154b;
        if ((r117 instanceof e) == false) goto L16;
        ((e) r117).l(r112.f529149f);
        goto L16
    }

    public final void j(b r110, float r111, boolean r112, boolean r113, float r114) {
        r110.d(r111, Math.max(0.9f, Math.abs((1.0f - r111) - 1.0E-4f)), r112, this.f529164l, r113, r114, this.f529153a, this.f529161i, this.f529160h);
        kn2.b r100 = this.f529157e;
        if (r100 == null) goto L6;
        k r101 = (k) r100;
        View r102 = r101.f504182z;
        UIUtils.setViewVisibility(r101.A, 8);
        UIUtils.setViewVisibility(r102, 8);
    L6:
        if (this.f529165m == true) goto L13;
        g("isReportRecommendData is called");
        com.bytedance.android.livesdk.log.g r103 = u.l();
        LinkedHashMap r104 = new LinkedHashMap();
        if (r112 == false) goto L10;
        String r105 = ILiveRoomPlayFragmentConstant.LOG_DIRECTION_DOWN;
    L11:
        r104.put("draw_action", r105);
        Unit r106 = Unit.INSTANCE;
        r103.sendLog("livesdk_end_to_recommend_draw_show", r104, new Object[]{new x(), Room.class});
        this.f529165m = true;
        return;
    L10:
        r105 = "up";
        goto L11
    }
}
