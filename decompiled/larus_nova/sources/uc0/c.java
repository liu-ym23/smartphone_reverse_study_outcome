package uc0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.emoji.api.IAwemeEmojiProxy;
import com.bytedance.android.live.livesdkapi.LiveSdkApiForSaaS;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.depend.PluginType;
import com.bytedance.android.livehostapi.foundation.depend.pluginstrategy.SaaSLiveResourceStrategy;
import com.bytedance.android.livesdk.chatroom.ui.AlwaysConsumeEventFrameLayout;
import com.bytedance.android.livesdk.commonpop.e;
import com.bytedance.android.livesdk.config.LiveInitSettingKeysForSaas;
import com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk.ILiveWrappedAudio;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdk.utils.h5;
import com.bytedance.android.livesdk.widget.h;
import com.bytedance.android.livesdk.widget.i;
import com.bytedance.android.livesdk.widget.j;
import com.bytedance.android.livesdk.widget.l;
import com.bytedance.android.livesdk.widget.m;
import com.bytedance.android.openlive.realtime.IUserRealtimeSignalFeature;
import com.bytedance.android.openlive.realtime.UserRealtimeSignalFeature;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.BuildConfig;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import v80.g;
import y00.d;

/* JADX INFO: loaded from: classes46.dex */
public class c extends LiveSdkApiForSaaS {
    @Override // il0.a
    public String getSecKey() {
        int r100 = bv1.a.f20777a;
        return "naZ=Q%#3xu2f5vs9";
    }

    @Override // il0.a
    public IUserRealtimeSignalFeature getUserRealtimeSignalFeature() {
        return new UserRealtimeSignalFeature();
    }

    @Override // il0.a
    public boolean initAudioSDKPluginLoader() {
        if (com.bytedance.android.live.broadcast.a.f58961a == true) goto L28;
        Context r100 = s1.getContext();
        if (r100 != null) goto L9;
    L16:
        return false;
    L9:
        if (h5.a() == false) goto L26;
        PluginType r101 = PluginType.SaaSLiveResource;
        if (r101.isInstalled() == true) goto L18;
        com.bytedance.android.live.broadcast.a r102 = com.bytedance.android.live.broadcast.a.f58964d;
        if (com.bytedance.android.live.broadcast.a.f58962b == true) goto L16;
        f2.b(R.string.ttlive_audio_comment_loading, 0);
        r101.checkInstall(r100, "", r102, false);
        goto L16
    L18:
        if (com.bytedance.android.live.broadcast.a.f58963c == true) goto L21;
        String[] r103 = {"c++_shared", "iesapplogger", "bytenn", "ttffmpeg", BuildConfig.LIBNAME};
        SaaSLiveResourceStrategy.loadHostLibraryByList(r100, com.bytedance.android.live.broadcast.a.class.getClassLoader(), r103);
        com.bytedance.android.live.broadcast.a.f58963c = true;
    L21:
        ILiveWrappedAudio.Companion.getClass();
        ILiveWrappedAudio r104 = ILiveWrappedAudio.a.a();
        if (r104 == null) goto L24;
        r104.getSpeechEngineLoader();
    L24:
        com.bytedance.android.live.broadcast.a.f58961a = true;
    L26:
        return com.bytedance.android.live.broadcast.a.f58961a;
    L28:
        return true;
    }

    @Override // il0.a
    public void preloadOnlineEmoji() {
        if (LiveInitSettingKeysForSaas.get_LIVE_ONLINE_EMOJI_ENABLE() == false) goto L8;
        IAwemeEmojiProxy r100 = (IAwemeEmojiProxy) k.f(IAwemeEmojiProxy.class);
        if (r100 == null) goto L9;
        r100.preloadOnlineEmoji();
        return;
    L9:
        return;
    }

    public c() {
    }

    @Override // il0.a
    public void openAgreeToStartLiveDialog(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "verifyParam");
        if ((r100 instanceof g) == true) goto L5;
        r100 = null;
    L5:
        g r101 = (g) r100;
        if (r101 != null) goto L8;
        return;
    L8:
        int r102 = d.f565563a;
        Intrinsics.checkNotNullParameter(r101, "verifyParam");
        Activity r103 = r101.getActivity();
        View r104 = LayoutInflater.from(r103).inflate(R.layout.live_dialog_vertify, null);
        r104.findViewById(R.id.live_verify_url).setOnClickListener(new y00.a(r103));
        m.a r105 = new m.a(r103);
        r105.f161818c = R.drawable.ttlive_dialog_verify_bg;
        r105.f161824i = r104;
        y00.b r106 = y00.b.f565561a;
        r105.f161817b = r103.getString(R.string.live_verify_text_cancel);
        r105.f161820e = r106;
        r105.f161826k = false;
        y00.c r107 = new y00.c(r101);
        r105.f161816a = r103.getString(R.string.live_verify_text_ok);
        r105.f161819d = r107;
        r105.f161825j = false;
        m r108 = new m(r105);
        r108.f161804n.setAlpha(0.0f);
        AlertDialog.Builder r109 = new AlertDialog.Builder(r108.f161791a);
        r109.setView(r108.f161798h);
        r108.f161792b.setText(null);
        r108.f161793c.setText(null);
        r108.f161793c.setGravity(17);
        r108.f161795e.setText(r108.f161806p);
        r108.f161795e.setTextColor(r108.f161809s);
        r108.f161802l.setBackgroundColor(0);
        if (TextUtils.isEmpty(r108.f161807q) == false) goto L11;
        r108.f161794d.setVisibility(8);
        r108.f161796f.setVisibility(8);
        r108.f161795e.setBackgroundResource(R.drawable.ttlive_uikit_bg_bottom_selector);
    L13:
        if (r108.f161799i == null) goto L16;
        r108.f161793c.setVisibility(8);
        r108.f161792b.setVisibility(8);
        ((ViewGroup.MarginLayoutParams) r108.f161800j.getLayoutParams()).topMargin = 0;
        r108.f161805o.removeAllViews();
        r108.f161805o.addView(r108.f161799i);
    L16:
        if (TextUtils.isEmpty(null) == false) goto L20;
        r108.f161792b.setVisibility(8);
        if (TextUtils.isEmpty(null) == false) goto L20;
        LinearLayout.LayoutParams r110 = (LinearLayout.LayoutParams) r108.f161793c.getLayoutParams();
        r110.topMargin = (int) UIUtils.dip2Px(r108.f161791a, 32.0f);
        r110.bottomMargin = (int) UIUtils.dip2Px(r108.f161791a, 8.0f);
        r108.f161793c.setLayoutParams(r110);
    L20:
        int r111 = r108.f161810t;
        if (r111 <= 0) goto L23;
        r108.f161797g.setImageResource(r111);
    L24:
        r109.setOnCancelListener(new h(r108));
        r108.f161815y = r109.create();
        r108.f161794d.setOnClickListener(new i(r108));
        r108.f161795e.setOnClickListener(new j(r108));
        r108.f161801k.setOnClickListener(new com.bytedance.android.livesdk.widget.k(r108));
        AlertDialog r112 = r108.f161815y;
        RelativeLayout r113 = r108.f161804n;     // Catch: Exception -> L46
        if (r113 == null) goto L30;
        r113.post(new l(r113, true));     // Catch: Exception -> L46
    L30:
        if (DialogLancet.shouldBlockDialogShow(r112) == false) goto L49;
        DialogLancet.handleBlockedDialogShow(r112);     // Catch: Exception -> L46
    L35:
        Window r114 = r112.getWindow();     // Catch: Exception -> L46
        if (r114 == null) goto L51;
        r114.setBackgroundDrawableResource(R.color.SDQuaternary);     // Catch: Exception -> L46
        WindowManager.LayoutParams r115 = r114.getAttributes();     // Catch: Exception -> L46
        r115.dimAmount = 0.5f;     // Catch: Exception -> L46
        r114.addFlags(2);     // Catch: Exception -> L46
        r115.gravity = 1;     // Catch: Exception -> L46
        r115.width = (int) UIUtils.dip2Px(r112.getContext(), 280.0f);     // Catch: Exception -> L46
        View r116 = r114.getDecorView();     // Catch: Exception -> L46
        if (com.larus.home.impl.utils.c.f346345e == false) goto L43;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Exception -> L46
        Thread r117 = ThreadMethodProxy.currentThread();     // Catch: Exception -> L46
        if (r117 == com.larus.home.impl.utils.c.f346341a) goto L43;
        com.larus.home.impl.utils.c.a(r117, "getDecorView");     // Catch: Exception -> L46
    L43:
        r116.setPadding(0, 0, 0, 0);     // Catch: Exception -> L46
        r114.setAttributes(r115);     // Catch: Exception -> L46
        return;
    L51:
        return;
    L49:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L45
    L34:
        DialogLancet.beforeDialogShow(r112);     // Catch: Exception -> L46
        r112.show();     // Catch: Exception -> L46
        DialogLancet.afterDialogShow(r112);     // Catch: Exception -> L46
    L52:
        return;
    L23:
        r108.f161802l.setVisibility(8);
        r108.f161803m.setBackgroundResource(R.drawable.ttlive_uikit_bg_dialog);
        goto L24
    L11:
        r108.f161794d.setText(r108.f161807q);
        r108.f161794d.setTextColor(r108.f161808r);
        goto L13
    }

    @Override // il0.a
    public void readLocationForSaas(Context r110, Function1<? super String, Unit> r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "runAfter");
        int r100 = z00.m.f569602a;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "runAfter");
        Object r101 = r110.getSystemService("location");
        if (r101 == null) goto L25;
        LocationManager r102 = (LocationManager) r101;
        List<String> r103 = r102.getProviders(true);
        String r104 = "network";
        if (r103.contains("network") == false) goto L7;
    L6:
        String r112 = r104;
        if (m60.c.d(r110, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}) == false) goto L26;
        f06.c r113 = new f06.c();
        Object[] r114 = {r112};
        f06.b r115 = new f06.b();
        f06.d r116 = r113.b(100000, "android/location/LocationManager", "getLastKnownLocation", r102, r114, "android.location.Location", r115);
        if (r116.f474982a == false) goto L15;
        r113.a(100000, "android/location/LocationManager", "getLastKnownLocation", r102, r114, null, r115, false);
        Location r105 = (Location) r116.f474983b;
    L16:
        if (r105 == null) goto L18;
        z00.m.b(r110, r105, r111);
        return;
    L18:
        z00.l r106 = new z00.l(r110, r111);
        if (fna.g.d() == true) goto L21;
        z00.m.a(r102, r112, r106);
        return;
    L21:
        z00.m.a(r102, r112, r106);
        nna.a.c(r106.hashCode());
        return;
    L15:
        Location r117 = r102.getLastKnownLocation(r112);
        r113.a(100000, "android/location/LocationManager", "getLastKnownLocation", r102, r114, r117, r115, true);
        r105 = r117;
        goto L16
    L26:
        return;
    L7:
        r104 = GeocodeSearch.GPS;
        if (r103.contains(GeocodeSearch.GPS) == true) goto L6;
        f2.b(R.string.ttlive_live_prompt_location_setting, 0);
        r110.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        r111.invoke("");
        return;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type android.location.LocationManager");
    }

    @Override // il0.a
    public void broadcastAuthUtilsCheckLogin(Context r100, boolean r101, Function1<? super IBaseUser, Unit> r102, Function1<? super Throwable, Unit> r103) {
        Intrinsics.checkNotNullParameter(r102, "onAuth");
        Intrinsics.checkNotNullParameter(r103, LynxVideoManagerLite.EVENT_ON_ERROR);
        int r104 = v00.c.f552297a;
        Intrinsics.checkNotNullParameter(r102, "onAuth");
        Intrinsics.checkNotNullParameter(r103, LynxVideoManagerLite.EVENT_ON_ERROR);
        IUserService r105 = (IUserService) k.f(IUserService.class);
        if (r105 == null) goto L7;
        f r106 = r105.user();
        if (r106 == null) goto L7;
        boolean r107 = r106.isLogin();
    L8:
        if (r107 == false) goto L18;
        if (r101 == true) goto L18;
        IUserService r108 = (IUserService) k.f(IUserService.class);
        if (r108 == null) goto L23;
        f r109 = r108.user();
        if (r109 == null) goto L24;
        IUser r110 = r109.b();
        if (r110 == null) goto L25;
        r102.invoke(r110);
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L18:
        if (r101 == false) goto L20;
        String r111 = "broadcast_force_login";
    L21:
        f2.b(R.string.ttlive_live_prompt_auth, 0);
        f r112 = ((IUserService) k.n(IUserService.class)).user();
        com.bytedance.android.livesdk.user.l.a r113 = new com.bytedance.android.livesdk.user.l.a();
        r113.f158688d = r111;
        r112.login(r100, new com.bytedance.android.livesdk.user.l(r113)).compose(RxUtil.rxSchedulerHelper()).subscribe(new v00.a(r102), new v00.b(r103));
        return;
    L20:
        r111 = "broadcast";
    L7:
        r107 = false;
        goto L8
    }

    @Override // il0.a
    public void commonPopupMessageWidgetOnInRoomPushEvent(Widget r100, WeakHandler r101, Object r102, int r103, Function0<Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        Intrinsics.checkNotNullParameter(r101, "handler");
        Intrinsics.checkNotNullParameter(r102, "event");
        Intrinsics.checkNotNullParameter(r110, "dismissBlock");
        int r104 = com.bytedance.android.livesdk.commonpop.g.f119732a;
        Intrinsics.checkNotNullParameter(r100, "widget");
        Intrinsics.checkNotNullParameter(r101, "handler");
        Intrinsics.checkNotNullParameter(r102, "event");
        Intrinsics.checkNotNullParameter(r110, "dismissBlock");
        if ((r102 instanceof com.bytedance.android.livesdk.commonpop.i) == true) goto L5;
        r102 = null;
    L5:
        com.bytedance.android.livesdk.commonpop.i r105 = (com.bytedance.android.livesdk.commonpop.i) r102;
        if (r105 == null) goto L32;
        View r106 = r100.contentView;
        if (r106 != null) goto L12;
        return;
    L12:
        if ((r106 instanceof ViewGroup) == true) goto L14;
        View r107 = null;
    L15:
        ViewGroup r108 = (ViewGroup) r107;
        if (r108 == null) goto L34;
        Context r109 = r100.context;
        if (r109 == null) goto L35;
        com.bytedance.android.live.base.model.push.b r111 = r105.f119735a;
        if (r111 == null) goto L36;
        r108.setVisibility(0);
        r108.removeAllViews();
        if ((r106 instanceof AlwaysConsumeEventFrameLayout) == true) goto L27;
        r106 = null;
    L27:
        AlwaysConsumeEventFrameLayout r112 = (AlwaysConsumeEventFrameLayout) r106;
        if (r112 == null) goto L30;
        r112.setAlwaysConsume(false);
    L30:
        View r113 = LayoutInflater.from(r109).inflate(R.layout.ttlive_common_inner_push_for_saas, r108, false);
        r108.addView(r113);
        ImageUtil.loadRoundImage((HSImageView) r113.findViewById(R.id.push_icon), r111.getIcon());
        ((TextView) r113.findViewById(R.id.tv_title)).setText(r111.getTitle());
        ((TextView) r113.findViewById(R.id.tv_content)).setText(r111.getContent());
        TextView r114 = (TextView) r113.findViewById(R.id.tv_action);
        r114.setText(r111.getButtonText());
        r114.setOnClickListener(new e(r111, r109));
        Ref.FloatRef r115 = new Ref.FloatRef();
        r115.element = 0.0f;
        r113.setOnTouchListener(new com.bytedance.android.livesdk.commonpop.f(r115, r110, r113));
        Message r116 = r101.obtainMessage(r103);
        r101.removeCallbacksAndMessages(null);
        r101.sendMessageDelayed(r116, r111.getDuration() * ((long) 1000));
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L14:
        r107 = r106;
        goto L15
    }
}
