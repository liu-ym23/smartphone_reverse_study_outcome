package com.bytedance.ee.bear.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Map;
import sbb.e;

/* JADX INFO: loaded from: classes16.dex */
public class BearUrl implements Parcelable {
    public static final Parcelable.Creator<BearUrl> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f222560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f222561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f222562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, String> f222563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f222564e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f222565f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f222566g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f222567h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f222568i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f222569j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f222570k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f222571l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f222572m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f222573n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f222574o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f222575p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f222576q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f222577r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f222578s;

    public class a implements Parcelable.Creator<BearUrl> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BearUrl createFromParcel(Parcel r100) {
            return new BearUrl(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final BearUrl[] newArray(int r100) {
            return new BearUrl[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final int a() {
        return e.g(this.f222560a);
    }

    public final boolean b() {
        if (TextUtils.isEmpty(this.f222564e) == false) goto L7;
        return false;
    L7:
        return "appeal".equals(UriProtector.parse(this.f222564e).getFragment());
    }

    public String getType() {
        return this.f222560a;
    }

    public BearUrl(Parcel r100) {
        this.f222563d = new HashMap();
        String r101 = r100.readString();
        if (TextUtils.isEmpty(r101) == false) goto L5;
        tt5.a.d("BearUrl", "the document type is empty");
        r101 = e.f541294e.getType();
    L5:
        this.f222560a = r101;
        this.f222561b = r100.readString();
        this.f222562c = r100.readString();
        this.f222564e = r100.readString();
        this.f222565f = r100.readString();
        this.f222567h = r100.readString();
        this.f222568i = r100.readString();
        this.f222569j = r100.readString();
        this.f222566g = r100.readString();
        this.f222570k = r100.readString();
        this.f222571l = r100.readString();
        this.f222572m = r100.readString();
        this.f222573n = r100.readString();
        this.f222574o = r100.readString();
        this.f222576q = r100.readString();
        this.f222577r = r100.readString();
        this.f222563d = r100.readHashMap(getClass().getClassLoader());
        this.f222578s = r100.readString();
    }

    public BearUrl(String r100) {
        this.f222563d = new HashMap();
        this.f222564e = r100;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f222560a);
        r100.writeString(this.f222561b);
        r100.writeString(this.f222562c);
        r100.writeString(this.f222564e);
        r100.writeString(this.f222565f);
        r100.writeString(this.f222567h);
        r100.writeString(this.f222568i);
        r100.writeString(this.f222569j);
        r100.writeString(this.f222566g);
        r100.writeString(this.f222570k);
        r100.writeString(this.f222571l);
        r100.writeString(this.f222572m);
        r100.writeString(this.f222573n);
        r100.writeString(this.f222574o);
        r100.writeString(this.f222576q);
        r100.writeString(this.f222577r);
        Map<String, String> r102 = this.f222563d;
        if (r102 == null) goto L5;
        r100.writeMap(r102);
    L5:
        r100.writeString(this.f222578s);
    }
}
