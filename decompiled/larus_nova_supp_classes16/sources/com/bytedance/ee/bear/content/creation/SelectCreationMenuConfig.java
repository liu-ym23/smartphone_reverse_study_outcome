package com.bytedance.ee.bear.content.creation;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.appsetting.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SelectCreationMenuConfig implements Parcelable {
    public static final Parcelable.Creator<SelectCreationMenuConfig> CREATOR = null;
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public final boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public final boolean r;

    public class a implements Parcelable.Creator<SelectCreationMenuConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SelectCreationMenuConfig createFromParcel(Parcel r2) {
            return new SelectCreationMenuConfig(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final SelectCreationMenuConfig[] newArray(int r1) {
            return new SelectCreationMenuConfig[r1];
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
        this.a = true;
        this.b = true;
        this.c = true;
        this.d = true;
        this.e = true;
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = true;
        this.m = c.a.a.g("ccm.mobile.mindnote_offline_create_enable");
        this.r = true;
    }

    public SelectCreationMenuConfig(Parcel r4) {
        boolean r0 = true;
        this.a = true;
        this.b = true;
        this.c = true;
        this.d = true;
        this.e = true;
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = true;
        this.m = c.a.a.g("ccm.mobile.mindnote_offline_create_enable");
        this.r = true;
        if (r4.readByte() == 0) goto L5;
        boolean r1 = true;
    L6:
        this.a = r1;
        if (r4.readByte() == 0) goto L9;
        boolean r2 = true;
    L10:
        this.b = r2;
        if (r4.readByte() == 0) goto L13;
        boolean r3 = true;
    L14:
        this.d = r3;
        if (r4.readByte() == 0) goto L17;
        boolean r5 = true;
    L18:
        this.e = r5;
        if (r4.readByte() == 0) goto L21;
        boolean r6 = true;
    L22:
        this.f = r6;
        if (r4.readByte() == 0) goto L25;
        boolean r7 = true;
    L26:
        this.g = r7;
        if (r4.readByte() == 0) goto L29;
        boolean r8 = true;
    L30:
        this.h = r8;
        if (r4.readByte() == 0) goto L33;
        boolean r9 = true;
    L34:
        this.i = r9;
        if (r4.readByte() == 0) goto L37;
        boolean r10 = true;
    L38:
        this.j = r10;
        if (r4.readByte() == 0) goto L41;
        boolean r11 = true;
    L42:
        this.k = r11;
        if (r4.readByte() == 0) goto L45;
        boolean r12 = true;
    L46:
        this.l = r12;
        if (r4.readByte() == 0) goto L49;
        boolean r13 = true;
    L50:
        this.n = r13;
        if (r4.readByte() == 0) goto L53;
        boolean r14 = true;
    L54:
        this.o = r14;
        if (r4.readByte() == 0) goto L57;
        boolean r16 = true;
    L58:
        this.p = r16;
        if (r4.readByte() == 0) goto L61;
        boolean r17 = true;
    L62:
        this.q = r17;
        if (r4.readByte() != 0) goto L66;
        r0 = false;
    L66:
        this.r = r0;
        return;
    L61:
        r17 = false;
        goto L62
    L57:
        r16 = false;
        goto L58
    L53:
        r14 = false;
        goto L54
    L49:
        r13 = false;
        goto L50
    L45:
        r12 = false;
        goto L46
    L41:
        r11 = false;
        goto L42
    L37:
        r10 = false;
        goto L38
    L33:
        r9 = false;
        goto L34
    L29:
        r8 = false;
        goto L30
    L25:
        r7 = false;
        goto L26
    L21:
        r6 = false;
        goto L22
    L17:
        r5 = false;
        goto L18
    L13:
        r3 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeByte(this.a ? 1 : 0);
        r1.writeByte(this.b ? 1 : 0);
        r1.writeByte(this.d ? 1 : 0);
        r1.writeByte(this.e ? 1 : 0);
        r1.writeByte(this.f ? 1 : 0);
        r1.writeByte(this.g ? 1 : 0);
        r1.writeByte(this.h ? 1 : 0);
        r1.writeByte(this.i ? 1 : 0);
        r1.writeByte(this.j ? 1 : 0);
        r1.writeByte(this.k ? 1 : 0);
        r1.writeByte(this.l ? 1 : 0);
        r1.writeByte(this.n ? 1 : 0);
        r1.writeByte(this.o ? 1 : 0);
        r1.writeByte(this.p ? 1 : 0);
        r1.writeByte(this.q ? 1 : 0);
        r1.writeByte(this.r ? 1 : 0);
    }
}
