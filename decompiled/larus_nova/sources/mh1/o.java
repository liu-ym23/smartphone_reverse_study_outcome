package mh1;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.livesdk.chatroom.miniapp.LiveStreamEndReceiver;
import com.bytedance.android.livesdk.chatroom.miniapp.views.LiveMiniAppRoundedImageView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.android.livesdkapi.view.ILiveWindow;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.nova.R;
import java.util.ArrayList;
import zg1.h1;

/* JADX INFO: loaded from: classes7.dex */
public final class o implements ILiveWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f513883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f513884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f513885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f513886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f513887e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f513888f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f513889g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f513890h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f513891i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ILivePlayerClient f513892j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LivePlayerView f513893k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LiveRequest f513894l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f513895m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f513896n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public AudioManager f513897o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public f f513898p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final LiveStreamEndReceiver f513899q;

    @Override // com.bytedance.android.livesdkapi.view.ILiveWindow
    public final boolean isShowing() {
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.view.ILiveWindow
    public final void dismissLiveWindow() {
        if (this.f513892j != null) goto L5;
        return;
    L5:
        if (this.f513891i == null) goto L25;
        xs2.b.a().post(new h1(48));
        this.f513892j.stopAndRelease(this.f513883a);
        this.f513892j = null;
        this.f513891i.setVisibility(8);
        this.f513893k.setVisibility(8);
        LiveStreamEndReceiver r100 = this.f513899q;
        if (r100 == null) goto L26;
        Activity r101 = this.f513883a;
        ReceiverRegisterLancet.loge(r100, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L20;
        r101.unregisterReceiver(r100);
        return;
    L20:
    L16:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r100.toString());
        e.printStackTrace();
        return;
    L13:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r100, r101) == false) goto L23;
        r101.unregisterReceiver(r100);     // Catch: Exception -> L16
        return;
    L23:
        return;
    L26:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.view.ILiveWindow
    public final void play() {
        ILivePlayerClient r100 = this.f513892j;
        if (r100 == null) goto L6;
        r100.stream(this.f513894l, null);
        xs2.b.a().post(new h1(47));
        this.f513892j.unmute();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.view.ILiveWindow
    public final void showEndView() {
        this.f513883a.runOnUiThread(new i(this));
    }

    @Override // com.bytedance.android.livesdkapi.view.ILiveWindow
    public final void showLiveWindow() {
        if (this.f513891i != null) goto L13;
        this.f513891i = ((LayoutInflater) this.f513883a.getSystemService("layout_inflater")).inflate(R.layout.ttlive_microapp_view_live_window, null);
        ((ViewGroup) this.f513883a.findViewById(android.R.id.content)).addView(this.f513891i);
        View r100 = this.f513891i.findViewById(R.id.microapp_m_float_video_close);
        this.f513888f = this.f513891i.findViewById(R.id.microapp_m_live_window_mask);
        this.f513889g = this.f513891i.findViewById(R.id.microapp_m_live_window_new_user);
        this.f513890h = this.f513891i.findViewById(R.id.microapp_m_live_window_end);
        this.f513887e = this.f513891i.findViewById(R.id.microapp_m_out_box);
        this.f513893k = (LivePlayerView) this.f513891i.findViewById(R.id.live_window_player_view);
        LiveMiniAppRoundedImageView r101 = (LiveMiniAppRoundedImageView) this.f513891i.findViewById(R.id.microapp_m_live_avatar);
        if (this.f513886d == false) goto L7;
        b(this.f513887e, LiveResUtil.dp2Px(160.0f), LiveResUtil.dp2Px(90.0f));
    L7:
        r101.setIsOval(true);
        ArrayList r102 = new ArrayList();
        r102.add(this.f513885c);
        ImageUtil.loadImage(r101, new ImageModel(null, r102), 0);
        r100.setOnClickListener(new b(this));
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r103 = com.bytedance.android.livesdk.sharedpref.b.f158194p1;
        if (r103.getValue().booleanValue() == true) goto L10;
        this.f513883a.runOnUiThread(new l(this));
        com.bytedance.android.livesdk.sharedpref.f.d(r103, Boolean.TRUE);
    L11:
        ((TextView) this.f513891i.findViewById(R.id.microapp_m_live_name)).setText(this.f513884b);
        this.f513893k.setOnClickListener(new g(this));
        this.f513889g.setOnClickListener(new h(this));
        goto L13
    L10:
        this.f513883a.runOnUiThread(new j(this));
    L13:
        if (this.f513894l == null) goto L31;
        if (this.f513892j != null) goto L31;
        this.f513891i.setVisibility(4);
        this.f513893k.setVisibility(4);
        ILivePlayerClient r104 = this.f513893k.getClient();
        this.f513892j = r104;
        r104.getEventHub().getPlayPrepared().observe(this.f513892j.getLifecycleOwner(), new a(this));
        this.f513892j.getEventHub().getVideoSizeChanged().observe(this.f513892j.getLifecycleOwner(), new e(this));
        String[] r105 = {"android.permission.MODIFY_AUDIO_SETTINGS", "android.permission.ACCESS_NETWORK_STATE"};
        ArrayList r106 = new ArrayList();
        int r107 = 0;
    L17:
        if (r107 >= 2) goto L27;
        String r108 = r105[r107];
        if (ContextCompat.checkSelfPermission(this.f513883a, r108) != 0) goto L21;
        boolean r109 = true;
    L22:
        if (r109 == true) goto L25;
        r106.add(r108);
    L25:
        r107 = r107 + 1;
        goto L17
    L21:
        r109 = false;
        goto L22
    L27:
        if (r106.isEmpty() == true) goto L31;
        String[] r110 = new String[r106.size()];
        r106.toArray(r110);
        ActivityCompat.requestPermissions(this.f513883a, r110, 123);
    L31:
        if (this.f513899q == null) goto L71;
        IntentFilter r111 = new IntentFilter();
        r111.addAction("com.bytedance.android.livesdk.chatroom.miniapp.LiveStreamEndReceiver");
        Activity r112 = this.f513883a;
        LiveStreamEndReceiver r113 = this.f513899q;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L65;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L65:
    L58:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L63;
        ReceiverRegisterCrashOptimizer.registerReceiver(r113, r111);
        return;
    L63:
        throw e;
    L37:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L49;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r111) == false) goto L49;
        int r114 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r113, r111, 0, null, null, 2, r112).result;     // Catch: Exception -> L58
        if (r114 == 1) goto L47;
        if (r114 != 2) goto L44;
        new Intent();     // Catch: Exception -> L58
    L64:
        return;
    L44:
        if (r114 == 3) goto L64;
        r112.registerReceiver(r113, r111);     // Catch: Exception -> L58
        goto L64
    L47:
        r112.registerReceiver(r113, r111);     // Catch: Exception -> L58
    L49:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L52;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L58
        r112.registerReceiver(r113, r111, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L58
        goto L64
    L52:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L54;
    L56:
        r112.registerReceiver(r113, r111);     // Catch: Exception -> L58
        goto L64
    L54:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r111) == false) goto L56;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L58
        ContextCompat.registerReceiver(r112, r113, r111, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L58
        goto L64
    }

    @Override // com.bytedance.android.livesdkapi.view.ILiveWindow
    public final boolean isCloseLiveWindowByUserClick() {
        return this.f513895m;
    }

    public final void a(boolean r100) {
        dismissLiveWindow();
        if (r100 == false) goto L9;
        int r101 = nh1.a.f519159a;
        Activity r102 = this.f513883a;
        if (r102 == null) goto L10;
        r102.finish();
        ALogger.d("ActivityExitHelper", "Activity finish activity:" + r102);
        return;
    L10:
        return;
    }

    public static void b(View r100, int r101, int r102) {
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if (r103.height == r102) goto L5;
    L6:
        r103.width = r101;
        r103.height = r102;
        r100.setLayoutParams(r103);
        return;
    L5:
        if (r103.width != r101) goto L6;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [mh1.f] */
    public o(Activity r100, String r101, String r102, String r103) {
        this.f513886d = false;
        this.f513895m = false;
        this.f513896n = false;
        this.f513883a = r100;
        this.f513894l = new LiveRequest.Builder().streamData(r101).preview(true).inBackground(true).build();
        this.f513884b = r102;
        this.f513885c = r103;
        this.f513886d = false;
        this.f513897o = (AudioManager) r100.getSystemService("audio");
        this.f513898p = new f();
        this.f513899q = new LiveStreamEndReceiver(this);
    }
}
