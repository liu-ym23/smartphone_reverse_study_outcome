package com.ss.android.lark.mention.base.impl.atselector.bean;

import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import com.ss.android.lark.chat.entity.chatter.ChatterSensitiveInfo;
import com.ss.android.lark.chat.entity.chatter.TagInfo;
import com.ss.android.lark.chat.entity.chatter.WorkStatus;
import com.ss.android.lark.chat.entity.tag.TagData;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements Comparable<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f431695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f431696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f431697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f431698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f431699e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f431700f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Chatter.ChatterType f431701g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ChatterDescription f431702h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f431703i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f431704j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f431705k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f431706l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final WorkStatus f431707m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f431708n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f431709o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<TagInfo> f431710p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ChatterSensitiveInfo f431711q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List<com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus> f431712r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TagData f431713s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f431714t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f431715u;

    public final boolean b() {
        return "mention_ai_knowledge".equals(this.f431695a);
    }

    public a() {
        this.f431711q = null;
    }

    public final int a(a r100) {
        String r101 = this.f431697c;
        if (TextUtils.isEmpty(this.f431706l) == false) goto L5;
    L7:
        String r102 = r100.f431706l;
        if (TextUtils.isEmpty(r102) == false) goto L10;
    L11:
        r102 = r100.f431697c;
    L13:
        if (TextUtils.isEmpty(r101) == false) goto L15;
        return 0;
    L15:
        if (TextUtils.isEmpty(r101) == false) goto L17;
        return 0;
    L17:
        if (r101.compareToIgnoreCase(r102) != 0) goto L21;
        return this.f431695a.compareTo(r100.f431695a);
    L21:
        return r101.compareToIgnoreCase(r102);
    L10:
        if (r102.equals("#") == false) goto L13;
    L5:
        if (this.f431706l.equals("#") == true) goto L7;
        r101 = this.f431706l;
        goto L7
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(a r100) {
        return a(r100);
    }

    public a(String r100, String r101, Chatter.ChatterType r102) {
        this.f431711q = null;
        this.f431695a = "mention_ai_knowledge";
        this.f431697c = r100;
        this.f431702h = new ChatterDescription(r101, ChatterDescription.Type.DEFAULT);
        this.f431701g = r102;
        this.f431706l = MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z;
        this.f431699e = new ArrayList();
        new ArrayList();
        this.f431698d = "";
        this.f431708n = 0;
        this.f431710p = new ArrayList();
        this.f431712r = new ArrayList();
    }

    public a(String r210, String r211, String r212, String r213, List r214, List r215, Chatter.ChatterType r216, ChatterDescription r217, boolean r310, String r311, WorkStatus r312, long r313, boolean r314, List r315, List r316, TagData r317, boolean r318, boolean r410) {
        this(r210, r211, r212, r213, r214, r215, r216, r217, r310, false, r311, r312, r313, r314, r315, r316, r317, r318, r410);
    }

    public a(String r100, String r101, String r102, String r103, List r104, List r105, Chatter.ChatterType r110, ChatterDescription r111, boolean r112, boolean r113, String r114, WorkStatus r115, long r116, boolean r117, List r118, List r210, TagData r211, boolean r212, boolean r213) {
        this.f431711q = null;
        this.f431695a = r100;
        this.f431696b = r101;
        this.f431697c = r102;
        this.f431698d = r103;
        this.f431699e = r104;
        this.f431700f = r105;
        this.f431701g = r110;
        this.f431702h = r111;
        this.f431703i = r112;
        this.f431704j = r113;
        this.f431706l = r114;
        this.f431707m = r115;
        this.f431708n = r116;
        this.f431709o = r117;
        this.f431710p = r118;
        this.f431712r = r210;
        this.f431713s = r211;
        this.f431715u = r213;
        this.f431714t = r212;
    }
}
