package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;
import javax.annotation.Nullable;
import zu7.a;

/* JADX INFO: loaded from: classes23.dex */
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f274587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f274588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f274589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f274590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f274591e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f274592f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f274593g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final List f274594h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f274595i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f274596j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f274597k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f274598l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f274599m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f274600n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f274601o;

    static {
        CREATOR = new a();
    }

    public WakeLockEvent(int r100, long r101, int r102, String r103, int r104, @Nullable List r110, String r111, long r112, int r113, String r114, String r115, float r116, long r117, String r210, boolean r211) {
        this.f274587a = r100;
        this.f274588b = r101;
        this.f274589c = r102;
        this.f274590d = r103;
        this.f274591e = r114;
        this.f274592f = r210;
        this.f274593g = r104;
        this.f274594h = r110;
        this.f274595i = r111;
        this.f274596j = r112;
        this.f274597k = r113;
        this.f274598l = r115;
        this.f274599m = r116;
        this.f274600n = r117;
        this.f274601o = r211;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int a() {
        return this.f274589c;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long b() {
        return this.f274588b;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String c() {
        List r100 = this.f274594h;
        String r101 = "";
        if (r100 != null) goto L5;
        String r102 = "";
    L6:
        int r103 = this.f274597k;
        String r104 = this.f274591e;
        String r105 = this.f274598l;
        float r106 = this.f274599m;
        String r107 = this.f274592f;
        int r108 = this.f274593g;
        String r109 = this.f274590d;
        boolean r110 = this.f274601o;
        StringBuilder r111 = new StringBuilder("\t");
        r111.append(r109);
        r111.append("\t");
        r111.append(r108);
        r111.append("\t");
        r111.append(r102);
        r111.append("\t");
        r111.append(r103);
        r111.append("\t");
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        r111.append(r104);
        r111.append("\t");
        if (r105 != null) goto L12;
        r105 = "";
    L12:
        r111.append(r105);
        r111.append("\t");
        r111.append(r106);
        r111.append("\t");
        if (r107 == null) goto L16;
        r101 = r107;
    L16:
        r111.append(r101);
        r111.append("\t");
        r111.append(r110);
        return r111.toString();
    L5:
        r102 = TextUtils.join(",", r100);
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        int r102 = SafeParcelWriter.beginObjectHeader(r100);
        SafeParcelWriter.writeInt(r100, 1, this.f274587a);
        SafeParcelWriter.writeLong(r100, 2, this.f274588b);
        SafeParcelWriter.writeString(r100, 4, this.f274590d, false);
        SafeParcelWriter.writeInt(r100, 5, this.f274593g);
        SafeParcelWriter.writeStringList(r100, 6, this.f274594h, false);
        SafeParcelWriter.writeLong(r100, 8, this.f274596j);
        SafeParcelWriter.writeString(r100, 10, this.f274591e, false);
        SafeParcelWriter.writeInt(r100, 11, this.f274589c);
        SafeParcelWriter.writeString(r100, 12, this.f274595i, false);
        SafeParcelWriter.writeString(r100, 13, this.f274598l, false);
        SafeParcelWriter.writeInt(r100, 14, this.f274597k);
        SafeParcelWriter.writeFloat(r100, 15, this.f274599m);
        SafeParcelWriter.writeLong(r100, 16, this.f274600n);
        SafeParcelWriter.writeString(r100, 17, this.f274592f, false);
        SafeParcelWriter.writeBoolean(r100, 18, this.f274601o);
        SafeParcelWriter.finishObjectHeader(r100, r102);
    }
}
