package io7;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.impl.manager.h;
import com.bytedance.ug.sdk.share.impl.manager.j;
import com.bytedance.ug.sdk.share.impl.network.model.InitShareResponse;
import com.bytedance.ug.sdk.share.impl.network.model.InitShareSettings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import jn7.i;
import oo7.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC6341d f495231a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InitShareResponse f495232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f495233b;

        public final void a() {
            InterfaceC6341d r100 = this.f495233b.f495231a;
            if (r100 == null) goto L40;
            InitShareResponse r101 = this.f495232a;
            com.bytedance.ug.sdk.share.impl.manager.c r102 = (com.bytedance.ug.sdk.share.impl.manager.c) r100;
            r102.getClass();
            k.e("ShareSdkManager", "share init interface success");
            if (r101 == null) goto L36;
            h r103 = r102.f272325c;
            r103.getClass();
            r103.f272339n = r101.getPanelList();
            r103.f272334i = r101.getTokenRegex();
            r103.f272335j = r101.getTokenActivityRegex();
            r103.f272336k = r101.getTokenPicRegex();
            r103.f272337l = r101.getTokenVideoRegex();
            r103.f272338m = r101.getTokenStrategy();
            r103.f272340o = r101.getZlinkInfoList();
            if (r101.getInitSettings() == null) goto L36;
            InitShareSettings r104 = r101.getInitSettings();
            if (r104 == null) goto L36;
            eo7.a r105 = eo7.a.b.f473353a;
            if (r104.getAlbumParseSwitch() == 0) goto L14;
            boolean r106 = true;
        L15:
            r105.f473342p = r106;
            if (r104.getHiddenMarkParseSwitch() == 0) goto L18;
            boolean r107 = true;
        L19:
            r105.f473344r = r107;
            if (r104.getQrcodeParseSwitch() == 0) goto L22;
            boolean r108 = true;
        L23:
            r105.f473343q = r108;
            if (r104.getTextTokenParseSwitch() == 0) goto L26;
            boolean r109 = true;
        L27:
            r105.f473345s = r109;
            if (r104.getVideoHiddenMarkSwitch() == 0) goto L30;
            boolean r110 = true;
        L31:
            r105.f473346t = r110;
            if (r104.getVideoQrcodeSwitch() == 0) goto L34;
            boolean r111 = true;
        L35:
            r105.f473347u = r111;
            r103.f272341p = r104.getCheckAndSignChannelList();
            r103.f272342q = r104.getAndroid12TokenDetectStrategy();
            r103.f272343r = r104.getUseTimon();
            goto L36
        L34:
            r111 = false;
            goto L35
        L30:
            r110 = false;
            goto L31
        L26:
            r109 = false;
            goto L27
        L22:
            r108 = false;
            goto L23
        L18:
            r107 = false;
            goto L19
        L14:
            r106 = false;
        L36:
            go7.b.g(true, "success", System.currentTimeMillis() - r102.f272323a);
            go7.a.f(0, System.currentTimeMillis() - r102.f272324b);
            h r112 = r102.f272325c;
            r112.f272331f = true;
            r112.getClass();
            co7.c r113 = r112.f272332g;
            if (r113 == null) goto L41;
            ((j.a) r113).f272348a.b();
            r102.f272325c.f272332g = null;
            return;
        L41:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(d r100, InitShareResponse r101) {
            this.f495233b = r100;
            this.f495232a = r101;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f495234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f495235b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f495236c;

        @Override // java.lang.Runnable
        public final void run() {
            InterfaceC6341d r100 = this.f495236c.f495231a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            com.bytedance.ug.sdk.share.impl.manager.c r101 = (com.bytedance.ug.sdk.share.impl.manager.c) r100;     // Catch: Throwable -> L6
            r101.a(this.f495234a, this.f495235b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public b(d r100, int r101, String r102) {
            this.f495236c = r100;
            this.f495234a = r101;
            this.f495235b = r102;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Exception f495237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f495238b;

        @Override // java.lang.Runnable
        public final void run() {
            InterfaceC6341d r100 = this.f495238b.f495231a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            com.bytedance.ug.sdk.share.impl.manager.c r101 = (com.bytedance.ug.sdk.share.impl.manager.c) r100;     // Catch: Throwable -> L6
            r101.a(-1, this.f495237a.toString());     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public c(d r100, Exception r101) {
            this.f495238b = r100;
            this.f495237a = r101;
        }
    }

    /* JADX INFO: renamed from: io7.d$d, reason: collision with other inner class name */
    public interface InterfaceC6341d {
    }

    public final void a() {
        Handler r100 = new Handler(Looper.getMainLooper());
        String r101 = ko7.a.a(ko7.a.b("/share_strategy/v2/init/"));     // Catch: Exception -> L42
        i r102 = eo7.a.b.f473353a.f473330d;     // Catch: Exception -> L42
        if (r102 == null) goto L6;
        String r103 = r102.executeGet(r101);     // Catch: Exception -> L42
    L7:
        k.e("InitShareSdkThread", "share init response is " + r103);     // Catch: Exception -> L42
        JSONObject r104 = new JSONObject(r103);     // Catch: Exception -> L42
        String r105 = r104.optString("data");     // Catch: Exception -> L42
        InitShareResponse r106 = (InitShareResponse) new GsonBuilder().create().fromJson(r105, InitShareResponse.class);     // Catch: Exception -> L42
        int r107 = r104.optInt("err_no", -1);     // Catch: Exception -> L42
        String r108 = r104.optString("err_tips", "unknown");     // Catch: Exception -> L42
        k.e("InitShareSdkThread", "share init data parse success");     // Catch: Exception -> L42
        if (TextUtils.isEmpty(r105) == true) goto L40;
        if (r107 != 0) goto L40;
        r100.post(new a(this, r106));     // Catch: Exception -> L42
        if (r106 != null) goto L13;
        return;
    L13:
        if (r106.getTokenRegex() == null) goto L16;
        bo7.a r109 = bo7.a.C0322a.f19870a;     // Catch: Exception -> L42
        r109.f19869a.c("token_regex", r106.getTokenRegex());     // Catch: Exception -> L42
    L16:
        if (r106.getTokenStrategy() == null) goto L19;
        bo7.a r110 = bo7.a.C0322a.f19870a;     // Catch: Exception -> L42
        r110.f19869a.c("token_strategy", new Gson().toJson(r106.getTokenStrategy()));     // Catch: Exception -> L42
    L19:
        if (r106.getTokenActivityRegex() == null) goto L22;
        bo7.a r111 = bo7.a.C0322a.f19870a;     // Catch: Exception -> L42
        r111.f19869a.c("token_activity_regex", new Gson().toJson(r106.getTokenActivityRegex()));     // Catch: Exception -> L42
    L22:
        if (r106.getTokenPicRegex() == null) goto L25;
        bo7.a r112 = bo7.a.C0322a.f19870a;     // Catch: Exception -> L42
        r112.f19869a.c("token_pic_regex", new Gson().toJson(r106.getTokenPicRegex()));     // Catch: Exception -> L42
    L25:
        if (r106.getTokenVideoRegex() == null) goto L28;
        bo7.a r113 = bo7.a.C0322a.f19870a;     // Catch: Exception -> L42
        r113.f19869a.c("token_video_regex", new Gson().toJson(r106.getTokenVideoRegex()));     // Catch: Exception -> L42
    L28:
        if (r106.getPanelList() == null) goto L31;
        bo7.a.C0322a.f19870a.f19869a.c("panel_list", new Gson().toJson(r106.getPanelList()));     // Catch: Exception -> L42
    L31:
        if (r106.getZlinkInfoList() == null) goto L36;
        if (r106.getZlinkInfoList().size() <= 0) goto L36;
        bo7.a r114 = bo7.a.C0322a.f19870a;     // Catch: Exception -> L42
        r114.f19869a.c("zlink_info_list", new Gson().toJson(r106.getZlinkInfoList()));     // Catch: Exception -> L42
    L36:
        if (r106.getInitSettings() == null) goto L49;
        String r115 = new Gson().toJson(r106.getInitSettings().getCheckAndSignChannelList());     // Catch: Exception -> L42
        String r116 = new Gson().toJson(r106.getInitSettings().getAndroid12TokenDetectStrategy());     // Catch: Exception -> L42
        bo7.a r117 = bo7.a.C0322a.f19870a;     // Catch: Exception -> L42
        r117.f19869a.c("android12_token_detect_strategy", r116);     // Catch: Exception -> L42
        r117.f19869a.c("check_and_sign_channel_list", r115);     // Catch: Exception -> L42
        int r118 = r106.getInitSettings().getUseTimon();     // Catch: Exception -> L42
        SharedPreferences r119 = r117.f19869a.f524630a;     // Catch: Exception -> L42
        if (r119 == null) goto L50;
        SharedPreferences.Editor r120 = r119.edit();     // Catch: Exception -> L42
        r120.putInt("use_timon", r118);     // Catch: Exception -> L42
        r120.apply();     // Catch: Exception -> L42
        return;
    L50:
        return;
    L49:
        return;
    L40:
        r100.post(new b(this, r107, r108));     // Catch: Exception -> L42
        return;
    L6:
        r103 = null;
    L42:
        e = move-exception;
        r100.post(new c(this, e));
        i r121 = eo7.a.b.f473353a.f473330d;
        if (r121 == null) goto L52;
        r121.checkResponseException(e);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(com.bytedance.ug.sdk.share.impl.manager.c r100) {
        this.f495231a = r100;
    }
}
