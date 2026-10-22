package in2;

import am2.n;
import am2.q;
import am2.x;
import am2.y;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.core.setting.CoreSettingUtil;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.config.n61;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.model.FollowLog;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.service.f;
import com.bytedance.android.livesdk.user.d;
import com.bytedance.android.livesdk.user.f0;
import com.bytedance.android.livesdk.user.h;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.ss.android.downloadlib.constants.EventConstants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.HashMap;
import jc1.k;

/* JADX INFO: loaded from: classes11.dex */
public final class b extends com.bytedance.android.livesdk.common.b implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f490577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Room f490578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final User f490579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f490580e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f490581f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f490582g;

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f490581f = false;
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f490581f = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        if (r110.getId() == R.id.follow) goto L5;
        return;
    L5:
        if (((f) TTLiveSDKContext.getHostService()).h().isLogin() == true) goto L8;
        Bundle r111 = new Bundle();
        r111.putString("enter_from", "live_detail");
        r111.putString("action_type", "follow");
        r111.putString("source", "live");
        r111.putString(VSConstants.KEY_V1_SOURCE, "follow");
        com.bytedance.android.livesdk.user.f r112 = ((f) TTLiveSDKContext.getHostService()).h();
        Context r100 = getContext();
        l.a r101 = new l.a();
        r101.f158685a = CoreSettingUtil.getLoginPromptForFollow();
        r101.f158686b = CoreSettingUtil.getLoginImageForFollow();
        r101.f158689e = "live_detail";
        r101.f158691g = "follow";
        r101.f158688d = "live";
        r101.f158687c = -1;
        ((f0) r112).login(r100, new l(r101)).subscribe(new h());
        return;
    L8:
        if (this.f490580e == true) goto L35;
        com.bytedance.android.livesdk.user.f r113 = ((f) TTLiveSDKContext.getHostService()).h();
        com.bytedance.android.livesdk.user.b.a r102 = new d.b().c(this.f490579d.getIdStr());
        this.f490578c.getRequestId();
        d.b r103 = (d.b) r102.e();
        r103.getClass();
        d.b r104 = (d.b) ((d.b) r103.g("live_follow_popup")).h(this.f490578c.getId());
        this.f490578c.getLabels();
        r104.getClass();
        String r105 = r104.f158637a;
        String r106 = r104.f158638b;
        long r107 = r104.f158645e;
        HashMap<String, String> r114 = r104.f158646f;
        boolean r115 = r104.f158647g;
        f0 r108 = (f0) r113;
        r108.getClass();
        r108.Q(1, r105, r107, r106, r114, r115).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        this.f490580e = true;
        long r109 = n61.f120810b.getValue().intValue();
        HashMap r116 = new HashMap();
        r116.put("follow_notice_duration", String.valueOf(r109));
        r116.put("growth_deepevent", String.valueOf(1));
        int r117 = h1.f66189a;
        r116.put("live_type", i1.a(this.f490578c.getStreamType()));
        r116.putAll(h1.a(this.f490578c));
        String r118 = "1";
        if (((IBroadcastService) k.f(IBroadcastService.class)).isPlayingGame() == false) goto L13;
        Object r119 = "1";
    L14:
        r116.put("is_gaming", r119);
        if (com.bytedance.android.livesdk.sharedpref.b.V.getValue().booleanValue() == false) goto L17;
        Object r120 = "1";
    L18:
        r116.put("is_screen_clear", r120);
        AudienceGameContext r121 = AudienceGameContext.getGameContext();
        if (r121 != null) goto L21;
    L23:
        r116.put("connection_type", ((IInteractService) k.f(IInteractService.class)).getLinkConnectionType());
        r116.put("anchor_cnt", ((ILinkServiceExternal) k.f(ILinkServiceExternal.class)).getLinkAnchorCount());
        if (RoomContext.getShared() != null) goto L27;
        r116.put("if_clear_mode", "0");
    L31:
        g r122 = u.l();
        x r123 = new x();
        r123.f4349a = "live_interact";
        r123.f4350b = "live_detail";
        r122.sendLog("livesdk_follow", r116, new Object[]{new FollowLog("live_follow_popup", this.f490579d.getIdString()), r123, Room.class, y.class, n.f(), q.class});
        return;
    L27:
        if (RoomContext.getShared().isCleanMode().getValue().booleanValue() == true) goto L30;
        r118 = "0";
    L30:
        r116.put("if_clear_mode", r118);
        goto L31
    L21:
        if (r121.getCurrentGame().getValue() == null) goto L23;
        r116.put("game_id", String.valueOf(r121.getCurrentGame().getValue().p()));
        r116.put(EventConstants.ExtraJson.GAME_NAME, String.valueOf(r121.getCurrentGame().getValue().q()));
        goto L23
    L17:
        r120 = "0";
        goto L18
    L13:
        r119 = "0";
        goto L14
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(R.layout.ttlive_dialog_pick_follow);
        ImageView r101 = (ImageView) findViewById(R.id.avatar);
        TextView r102 = (TextView) findViewById(R.id.name);
        TextView r103 = (TextView) findViewById(R.id.follow);
        this.f490577b = r103;
        r103.setOnClickListener(this);
        a1.v(r101, this.f490579d.getAvatarThumb(), R.drawable.ttlive_img_avatar_empty);
        r102.setText(this.f490579d.getNickName());
        View r104 = findViewById(R.id.douyin_official_pick_top);
        if (this.f490582g == false) goto L5;
        int r105 = 0;
    L6:
        UIUtils.setViewVisibility(r104, r105);
        return;
    L5:
        r105 = 8;
        goto L6
    }

    public b(Activity r100, Room r101, boolean r102) {
        super(r100, true);
        this.f490580e = false;
        this.f490581f = false;
        this.f490582g = false;
        this.f490578c = r101;
        this.f490579d = (User) r101.getBaseOwner();
        this.f490582g = r102;
    }
}
