package com.obric.assistant.voice;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.obric.eventkit.eventstaskmanager.AppEvent;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ContentScene f394369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f394370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f394371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ContentStatus f394372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AppEvent f394373e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OAutoEvent f394374f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ComplexEvent f394375g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f394369a == r101.f394369a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f394370b, r101.f394370b) == true) goto L15;
        return false;
    L15:
        if (this.f394371c == r101.f394371c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f394369a.hashCode() * 31) + this.f394370b.hashCode()) * 31;
        long r101 = this.f394371c;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String a() {
        JSONObject r100 = new JSONObject();
        r100.put("scene", this.f394369a.getStr());
        r100.put("content", this.f394370b);
        AppEvent r101 = this.f394373e;
        if (r101 == null) goto L5;
        r100.put("appEvent", GsonProtectorUtils.toJson(new Gson(), r101));
    L5:
        OAutoEvent r102 = this.f394374f;
        if (r102 == null) goto L8;
        r100.put("oautoEvent", GsonProtectorUtils.toJson(new Gson(), r102));
    L8:
        ComplexEvent r103 = this.f394375g;
        if (r103 == null) goto L12;
        r100.put("complexEvent", GsonProtectorUtils.toJson(new Gson(), r103));
    L12:
        return r100.toString();
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("scene ");
        r100.append(this.f394369a);
        r100.append(" content ");
        r100.append(this.f394370b.length());
        r100.append(" status ");
        r100.append(this.f394372d);
        r100.append(" payload is [ appEvent? ");
        boolean r101 = true;
        if (this.f394373e == null) goto L5;
        boolean r102 = true;
    L6:
        r100.append(r102);
        r100.append(" --  oautoEvent ");
        if (this.f394374f == null) goto L9;
        boolean r103 = true;
    L10:
        r100.append(r103);
        r100.append(" -- complexEvent ");
        if (this.f394375g != null) goto L14;
        r101 = false;
    L14:
        r100.append(r101);
        r100.append(" -- content = ");
        r100.append(this.f394370b);
        r100.append(" ]");
        return r100.toString();
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public a(ContentScene r100, String r101) {
        long r102 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "content");
        this.f394369a = r100;
        this.f394370b = r101;
        this.f394371c = r102;
        this.f394372d = ContentStatus.INIT;
    }
}
