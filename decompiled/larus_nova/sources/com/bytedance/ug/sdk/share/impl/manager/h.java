package com.bytedance.ug.sdk.share.impl.manager;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.ug.sdk.share.api.panel.IPanelItem;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.model.ShareChannelItem;
import com.bytedance.ug.sdk.share.impl.network.model.PanelInfo;
import com.bytedance.ug.sdk.share.impl.network.model.TokenRefluxInfo;
import com.bytedance.ug.sdk.share.impl.network.model.ZlinkInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f272326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, Runnable> f272327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f272328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f272329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<ln7.a, IPanelItem> f272330e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f272331f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public co7.c f272332g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f272333h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f272334i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<TokenRefluxInfo> f272335j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<TokenRefluxInfo> f272336k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<TokenRefluxInfo> f272337l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<Integer> f272338m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<PanelInfo> f272339n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<ZlinkInfo> f272340o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List<String> f272341p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public List<List<String>> f272342q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f272343r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ShareChannelType f272344s;

    /* JADX INFO: loaded from: classes22.dex */
    public class a extends TypeToken<ArrayList<TokenRefluxInfo>> {
        public a() {
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class b extends TypeToken<ArrayList<TokenRefluxInfo>> {
        public b() {
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class c extends TypeToken<ArrayList<TokenRefluxInfo>> {
        public c() {
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class d extends TypeToken<ArrayList<ZlinkInfo>> {
        public d() {
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class e extends TypeToken<ArrayList<String>> {
        public e() {
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class f extends TypeToken<ArrayList<String>> {
        public f() {
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f272345a = null;

        static {
            f272345a = new h();
        }
    }

    public final List<List<String>> b() {
        if (this.f272342q != null) goto L10;
        if (this.f272331f == true) goto L10;
        String r100 = bo7.a.C0322a.f19870a.f19869a.b("android12_token_detect_strategy", "");
        if (TextUtils.isEmpty(r100) == true) goto L10;
        this.f272342q = (List) GsonProtectorUtils.fromJson(new Gson(), r100, new e().getType());
    L10:
        return this.f272342q;
    }

    public final List<TokenRefluxInfo> d() {
        if (this.f272335j != null) goto L10;
        if (this.f272331f == true) goto L10;
        String r100 = bo7.a.C0322a.f19870a.f19869a.b("token_activity_regex", (String) eo7.a.b.f473353a.c("default_token_act_reg", ""));
        if (TextUtils.isEmpty(r100) == true) goto L10;
        this.f272335j = (List) GsonProtectorUtils.fromJson(new Gson(), r100, new a().getType());
    L10:
        return this.f272335j;
    }

    public final List<TokenRefluxInfo> e() {
        if (this.f272336k != null) goto L10;
        if (this.f272331f == true) goto L10;
        String r100 = bo7.a.C0322a.f19870a.f19869a.b("token_pic_regex", (String) eo7.a.b.f473353a.c("default_token_pic_reg", ""));
        if (TextUtils.isEmpty(r100) == true) goto L10;
        this.f272336k = (List) GsonProtectorUtils.fromJson(new Gson(), r100, new b().getType());
    L10:
        return this.f272336k;
    }

    public final List<TokenRefluxInfo> f() {
        if (this.f272337l != null) goto L10;
        if (this.f272331f == true) goto L10;
        String r100 = bo7.a.C0322a.f19870a.f19869a.b("token_video_regex", (String) eo7.a.b.f473353a.c("default_token_video_reg", ""));
        if (TextUtils.isEmpty(r100) == true) goto L10;
        this.f272337l = (List) GsonProtectorUtils.fromJson(new Gson(), r100, new c().getType());
    L10:
        return this.f272337l;
    }

    public final void g() {
        this.f272330e = new HashMap();
        ShareChannelType[] r100 = ShareChannelType.values();
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        ShareChannelType r103 = r100[r102];
        Map<ln7.a, IPanelItem> r104 = this.f272330e;
        HashMap r105 = (HashMap) r104;
        r105.put(r103, new ShareChannelItem(r103));
        r102 = r102 + 1;
        goto L3
    }

    public h() {
        this.f272328c = 0;
        this.f272329d = false;
        this.f272331f = false;
        this.f272333h = false;
        this.f272343r = -1;
        this.f272344s = null;
        this.f272339n = new ArrayList();
        this.f272327b = new ConcurrentHashMap();
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public final String c(ShareChannelType r100) {
        if (this.f272340o == null) goto L5;
    L9:
        String r101 = ShareChannelType.getShareItemTypeName(r100);
        List<ZlinkInfo> r102 = this.f272340o;
        if (r102 == null) goto L19;
        Iterator<ZlinkInfo> r103 = r102.iterator();
    L13:
        if (r103.hasNext() == false) goto L19;
        ZlinkInfo r104 = r103.next();
        if (TextUtils.isEmpty(r101) == true) goto L13;
        if (TextUtils.equals(r101, r104.getChannel()) == false) goto L13;
        String r105 = r104.getZlink();
    L20:
        if (r105 != null) goto L23;
        return "";
    L23:
        return r105;
    L19:
        r105 = "";
        goto L20
    L5:
        if (this.f272331f == true) goto L9;
        String r106 = bo7.a.C0322a.f19870a.f19869a.b("zlink_info_list", "");
        if (TextUtils.isEmpty(r106) == true) goto L9;
        this.f272340o = (List) GsonProtectorUtils.fromJson(new Gson(), r106, new d().getType());
        goto L9
    }

    public final boolean h(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (this.f272341p == null) goto L8;
    L12:
        List<String> r101 = this.f272341p;
        if (r101 != null) goto L15;
        return false;
    L15:
        return r101.contains(r100);
    L8:
        if (this.f272331f == true) goto L12;
        String r102 = bo7.a.C0322a.f19870a.f19869a.b("check_and_sign_channel_list", "");
        if (TextUtils.isEmpty(r102) == true) goto L12;
        this.f272341p = (List) GsonProtectorUtils.fromJson(new Gson(), r102, new f().getType());
        goto L12
    }
}
