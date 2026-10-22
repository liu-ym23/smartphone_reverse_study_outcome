package sv2;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.moreliveentrance.LiveTabForceRefreshStyle;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.player.LivePlayerStreamTypeUtils;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.livesdkapi.resolution.IResolutionService;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ILivePlayerClient f543616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AbsLivePlayerView f543617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f543618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f543619d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RecyclerView f543620e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameLayout f543621f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FrameLayout f543622g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f543623h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f543624i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f543625j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f543626k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final sv2.c f543627l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Room f543628m;

    /* JADX INFO: renamed from: sv2.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC7660a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f543629a;

        public ViewOnClickListenerC7660a(a r100) {
            this.f543629a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a r101 = this.f543629a;
            r101.e("live_cell", r101.f543624i, r101.f543625j);
            a r102 = this.f543629a;
            r102.c(r102.getViewParams().f543643j);
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f543630a;

        public b(a r100) {
            this.f543630a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a r101 = this.f543630a;
            r101.e("enter_tablive", r101.f543624i, r101.f543625j);
            a r102 = this.f543630a;
            r102.c(r102.getViewParams().f543643j);
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f543631a;

        public c(a r100) {
            this.f543631a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a r101 = this.f543631a;
            r101.e(AppConstants.BUNDLE_DISLIKE, r101.f543624i, r101.f543625j);
            this.f543631a.b();
        }
    }

    public static final class d implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f543632a;

        public d(a r100) {
            this.f543632a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            this.f543632a.h();
            return false;
        }
    }

    public void b() {
    }

    public void g() {
    }

    public void h() {
    }

    public final Map<String, String> getCommonMobParams() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("enter_from_merge", this.f543627l.f543637d);
        r100.put("enter_method", this.f543627l.f543638e);
        r100.put("action_type", "draw");
        r100.put("request_id", this.f543627l.f543639f);
        String r101 = this.f543626k;
        String r102 = null;
        if (r101 != null) goto L5;
    L10:
        String r103 = getTabLiveGuideAnchorIds();
        if ((!StringsKt.isBlank(r103)) == false) goto L13;
        r102 = r103;
    L13:
        if (r102 == null) goto L15;
        r100.put("tablive_guide_anchor_id", r102);
    L15:
        return r100;
    L5:
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L10;
        String r104 = (String) r100.put("tablive_guide_id", r101);
        goto L10
    }

    public String getTabLiveGuideAnchorIds() {
        return this.f543627l.f543643j.getString("tablive_guide_anchor_id", "");
    }

    public final void i() {
        String r100 = this.f543628m.getCompoundStreamData();
        if (r100 != null) goto L5;
        return;
    L5:
        LiveRequest.Builder r101 = new LiveRequest.Builder().streamData(r100).streamType(LivePlayerStreamTypeUtils.INSTANCE.mapLiveModeToStreamType(this.f543628m.getStreamType()));
        IResolutionService r102 = (IResolutionService) k.f(IResolutionService.class);
        if (r102 == null) goto L11;
        PlayerResolution.PickResult r103 = r102.getPullStreamResolution(this.f543628m.getRoomId(), this.f543628m.getStreamUrl(), true);
        if (r103 == null) goto L11;
        String r104 = r103.getResultSdkKey();
        if (r104 == null) goto L11;
    L12:
        LiveRequest r105 = r101.resolution(r104).mute(this.f543627l.f543642i).build();
        ILivePlayerClient r106 = this.f543616a;
        if (r106 == null) goto L16;
        r106.stream(r105, null);
        return;
    L16:
        return;
    L11:
        r104 = PlayerResolution.SDKKEY.ORIGIN;
        goto L12
    }

    public final void d() {
        Context r100 = getContext();
        int r101 = sv2.d.f543644a;
        String r102 = this.f543627l.f543634a;
        Intrinsics.checkNotNullParameter(r102, "pageSoure");
        int r103 = r102.hashCode();
        if (r103 == 823094105) goto L11;
        if (r103 == 1725424499) goto L8;
    L13:
        int r104 = -1;
    L14:
        View r105 = FrameLayout.inflate(r100, r104, this);
        this.f543618c = r105;
        FrameLayout r106 = null;
        if (r105 == null) goto L17;
        ViewGroup r107 = (ViewGroup) r105.findViewById(R.id.player_container);
    L18:
        this.f543619d = r107;
        View r108 = this.f543618c;
        if (r108 == null) goto L21;
        RecyclerView r109 = (RecyclerView) r108.findViewById(R.id.often_skylight_recyclerview);
    L22:
        this.f543620e = r109;
        View r110 = this.f543618c;
        if (r110 == null) goto L25;
        FrameLayout r111 = (FrameLayout) r110.findViewById(R.id.goto_see_button);
    L26:
        this.f543621f = r111;
        View r112 = this.f543618c;
        if (r112 == null) goto L29;
        FrameLayout r113 = (FrameLayout) r112.findViewById(R.id.dislike_button);
    L30:
        this.f543622g = r113;
        View r114 = this.f543618c;
        if (r114 == null) goto L33;
        TextView r115 = (TextView) r114.findViewById(R.id.tablive_guide_title);
    L34:
        this.f543623h = r115;
        ViewGroup r116 = this.f543619d;
        if (r116 == null) goto L37;
        r116.setOnClickListener(new ViewOnClickListenerC7660a(this));
    L37:
        FrameLayout r117 = this.f543621f;
        if (r117 == null) goto L40;
        r117.setOnClickListener(new b(this));
    L40:
        FrameLayout r118 = this.f543622g;
        if (r118 == null) goto L43;
        r118.setOnClickListener(new c(this));
    L43:
        View r119 = this.f543618c;
        if (r119 == null) goto L46;
        r106 = (FrameLayout) r119.findViewById(R.id.gesture_layout);
    L46:
        if (r106 == null) goto L48;
        r106.setOnTouchListener(new d(this));
    L48:
        long r120 = this.f543628m.getRoomId();
        as0.a r121 = LivePlatformPlayerManager.c(r120, false);
        FrameLayout.LayoutParams r122 = new FrameLayout.LayoutParams(-1, -1);
        r122.gravity = 17;
        AbsLivePlayerView r123 = as0.a.C0216a.a(r121, getContext(), r120);
        r123.setClipToOutline(true);
        r123.setOutlineProvider(new sv2.b(this));
        r123.setLayoutParams(r122);
        r123.getRenderView().setLayoutParams(r122);
        r123.setScaleType(2);
        Unit r124 = Unit.INSTANCE;
        this.f543617b = r123;
        this.f543616a = r123.getClient();
        ViewGroup r125 = this.f543619d;
        if (r125 == null) goto L52;
        r125.addView(this.f543617b, 0);
        return;
    L52:
        return;
    L33:
        r115 = null;
        goto L34
    L29:
        r113 = null;
        goto L30
    L25:
        r111 = null;
        goto L26
    L21:
        r109 = null;
        goto L22
    L17:
        r107 = null;
        goto L18
    L8:
        if (r102.equals("end_page") == false) goto L13;
        r104 = R.layout.ttlive_end_page_tablive_guide_play;
        goto L14
    L11:
        if (r102.equals("inner_card") == false) goto L13;
        r104 = R.layout.ttlive_inner_card_tablive_guide_play;
        goto L14
    }

    public final void f() {
        j0 r100 = j0.l();
        Map<String, String> r101 = getCommonMobParams();
        r101.put("guide_scene", this.f543627l.f543636c);
        r101.put("guide_position", String.valueOf(this.f543627l.f543635b + 1));
        Unit r102 = Unit.INSTANCE;
        r100.sendLog("livesdk_leavescene_tablive_guide_show", r101, new Object[0]);
        g();
    }

    public final Room getFirstRoom() {
        return this.f543628m;
    }

    public final FrameLayout getGoToSeeButton() {
        return this.f543621f;
    }

    public final ILivePlayerClient getMPlayerClient() {
        return this.f543616a;
    }

    public final ViewGroup getPlayerViewContainer() {
        return this.f543619d;
    }

    public final RecyclerView getSkylightRecyclerView() {
        return this.f543620e;
    }

    public final sv2.c getViewParams() {
        return this.f543627l;
    }

    public final void c(Bundle r110) {
        Intrinsics.checkNotNullParameter(r110, "insertParams");
        IMiddlewareHostBusiness r100 = (IMiddlewareHostBusiness) k.f(IMiddlewareHostBusiness.class);
        if (r100 == null) goto L6;
        Context r101 = getContext();
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("enter_method", this.f543627l.f543640g);
        Unit r103 = Unit.INSTANCE;
        String r104 = this.f543627l.f543634a;
        Bundle r105 = new Bundle();
        r105.putString("guide_scene", this.f543627l.f543636c);
        r105.putAll(r110);
        r100.enterLiveChannel(r101, r102, r104, r105, true, true, LiveTabForceRefreshStyle.REFRESH_FULL);
        return;
    }

    public final void setGoToSeeButton(FrameLayout r100) {
        this.f543621f = r100;
    }

    public final void setMPlayerClient(ILivePlayerClient r100) {
        this.f543616a = r100;
    }

    public final void setPlayerViewContainer(ViewGroup r100) {
        this.f543619d = r100;
    }

    public final void setSkylightRecyclerView(RecyclerView r100) {
        this.f543620e = r100;
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, n.KEY_MAIN_TEXT);
        Intrinsics.checkNotNullParameter(r101, n.KEY_SUB_TEXT);
        boolean r102 = true;
        if (r100.length() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L11;
        TextView r104 = this.f543623h;
        if (r104 == null) goto L11;
        r104.setText(r100);
    L11:
        if (r101.length() > 0) goto L14;
        r102 = false;
    L14:
        if (r102 == false) goto L22;
        View r105 = this.f543618c;
        if (r105 == null) goto L18;
        TextView r106 = (TextView) r105.findViewById(R.id.often_living_sub_title);
    L19:
        if (r106 == null) goto L23;
        r106.setText(r101);
        return;
    L23:
        return;
    L18:
        r106 = null;
        goto L19
    L22:
        return;
    L5:
        r103 = false;
        goto L6
    }

    public a(Context r100, sv2.c r101, Room r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "viewParams");
        Intrinsics.checkNotNullParameter(r102, "firstRoom");
        super(r100);
        this.f543627l = r101;
        this.f543628m = r102;
        this.f543624i = String.valueOf(r102.getRoomId());
        this.f543625j = r102.getOwnerUserIdString();
        this.f543626k = r101.f543643j.getString("tablive_guide_id", "");
    }

    public final void e(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "clickArea");
        Intrinsics.checkNotNullParameter(r101, "roomId");
        Intrinsics.checkNotNullParameter(r102, "anchorId");
        j0 r103 = j0.l();
        Map<String, String> r104 = getCommonMobParams();
        r104.put("room_id", r101);
        r104.put("anchor_id", r102);
        r104.put(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, r100);
        r104.put("guide_scene", this.f543627l.f543636c);
        r104.put("guide_position", String.valueOf(this.f543627l.f543635b + 1));
        Unit r105 = Unit.INSTANCE;
        r103.sendLog("livesdk_tablive_guide_click", r104, new Object[0]);
    }
}
