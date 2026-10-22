package com.bytedance.ee.bear.content.creation;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.appsetting.c;

/* JADX INFO: loaded from: classes16.dex */
public class SelectCreationMenuConfig implements Parcelable {
    public static final Parcelable.Creator<SelectCreationMenuConfig> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f216805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f216806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f216807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f216808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f216809e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f216810f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f216811g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f216812h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f216813i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f216814j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f216815k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f216816l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f216817m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f216818n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f216819o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f216820p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f216821q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f216822r;

    public class a implements Parcelable.Creator<SelectCreationMenuConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SelectCreationMenuConfig createFromParcel(Parcel r100) {
            return new SelectCreationMenuConfig(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SelectCreationMenuConfig[] newArray(int r100) {
            return new SelectCreationMenuConfig[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public SelectCreationMenuConfig() {
        this.f216805a = true;
        this.f216806b = true;
        this.f216807c = true;
        this.f216808d = true;
        this.f216809e = true;
        this.f216810f = true;
        this.f216811g = true;
        this.f216812h = true;
        this.f216813i = true;
        this.f216814j = true;
        this.f216817m = c.a.f206237a.g("ccm.mobile.mindnote_offline_create_enable");
        this.f216822r = true;
    }

    public SelectCreationMenuConfig(Parcel r100) {
        boolean r101 = true;
        this.f216805a = true;
        this.f216806b = true;
        this.f216807c = true;
        this.f216808d = true;
        this.f216809e = true;
        this.f216810f = true;
        this.f216811g = true;
        this.f216812h = true;
        this.f216813i = true;
        this.f216814j = true;
        this.f216817m = c.a.f206237a.g("ccm.mobile.mindnote_offline_create_enable");
        this.f216822r = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.f216805a = r102;
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.f216806b = r103;
        if (r100.readByte() == 0) goto L13;
        boolean r104 = true;
    L14:
        this.f216808d = r104;
        if (r100.readByte() == 0) goto L17;
        boolean r105 = true;
    L18:
        this.f216809e = r105;
        if (r100.readByte() == 0) goto L21;
        boolean r106 = true;
    L22:
        this.f216810f = r106;
        if (r100.readByte() == 0) goto L25;
        boolean r107 = true;
    L26:
        this.f216811g = r107;
        if (r100.readByte() == 0) goto L29;
        boolean r108 = true;
    L30:
        this.f216812h = r108;
        if (r100.readByte() == 0) goto L33;
        boolean r109 = true;
    L34:
        this.f216813i = r109;
        if (r100.readByte() == 0) goto L37;
        boolean r110 = true;
    L38:
        this.f216814j = r110;
        if (r100.readByte() == 0) goto L41;
        boolean r111 = true;
    L42:
        this.f216815k = r111;
        if (r100.readByte() == 0) goto L45;
        boolean r112 = true;
    L46:
        this.f216816l = r112;
        if (r100.readByte() == 0) goto L49;
        boolean r113 = true;
    L50:
        this.f216818n = r113;
        if (r100.readByte() == 0) goto L53;
        boolean r114 = true;
    L54:
        this.f216819o = r114;
        if (r100.readByte() == 0) goto L57;
        boolean r115 = true;
    L58:
        this.f216820p = r115;
        if (r100.readByte() == 0) goto L61;
        boolean r116 = true;
    L62:
        this.f216821q = r116;
        if (r100.readByte() != 0) goto L66;
        r101 = false;
    L66:
        this.f216822r = r101;
        return;
    L61:
        r116 = false;
        goto L62
    L57:
        r115 = false;
        goto L58
    L53:
        r114 = false;
        goto L54
    L49:
        r113 = false;
        goto L50
    L45:
        r112 = false;
        goto L46
    L41:
        r111 = false;
        goto L42
    L37:
        r110 = false;
        goto L38
    L33:
        r109 = false;
        goto L34
    L29:
        r108 = false;
        goto L30
    L25:
        r107 = false;
        goto L26
    L21:
        r106 = false;
        goto L22
    L17:
        r105 = false;
        goto L18
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeByte(this.f216805a ? 1 : 0);
        r100.writeByte(this.f216806b ? 1 : 0);
        r100.writeByte(this.f216808d ? 1 : 0);
        r100.writeByte(this.f216809e ? 1 : 0);
        r100.writeByte(this.f216810f ? 1 : 0);
        r100.writeByte(this.f216811g ? 1 : 0);
        r100.writeByte(this.f216812h ? 1 : 0);
        r100.writeByte(this.f216813i ? 1 : 0);
        r100.writeByte(this.f216814j ? 1 : 0);
        r100.writeByte(this.f216815k ? 1 : 0);
        r100.writeByte(this.f216816l ? 1 : 0);
        r100.writeByte(this.f216818n ? 1 : 0);
        r100.writeByte(this.f216819o ? 1 : 0);
        r100.writeByte(this.f216820p ? 1 : 0);
        r100.writeByte(this.f216821q ? 1 : 0);
        r100.writeByte(this.f216822r ? 1 : 0);
    }
}
