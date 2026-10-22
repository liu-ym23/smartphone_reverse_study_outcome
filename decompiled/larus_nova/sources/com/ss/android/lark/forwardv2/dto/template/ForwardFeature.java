package com.ss.android.lark.forwardv2.dto.template;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv2.dto.template.choosechat.PreSelectedPair;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes36.dex */
public class ForwardFeature implements Parcelable {
    public static final Parcelable.Creator<ForwardFeature> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<PreSelectedPair> f424825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f424826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f424827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f424828d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f424829e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f424830f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f424831g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f424832h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f424833i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f424834j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f424835k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f424836l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public IForwardCancelListener f424837m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public IForwardSelectListener f424838n;

    public class a implements Parcelable.Creator<ForwardFeature> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardFeature createFromParcel(Parcel r100) {
            return new ForwardFeature(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardFeature[] newArray(int r100) {
            return new ForwardFeature[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final void a() {
        if (this.f424826b == false) goto L6;
        com.ss.android.lark.forwardv3.utils.b.d();
        return;
    }

    public ForwardFeature() {
        this.f424825a = new ArrayList();
        this.f424826b = true;
        this.f424831g = true;
        this.f424832h = true;
        this.f424833i = false;
        this.f424834j = true;
        this.f424835k = false;
        this.f424836l = false;
    }

    public ForwardFeature(Parcel r100) {
        ArrayList<PreSelectedPair> r101 = new ArrayList();
        this.f424825a = r101;
        boolean r102 = true;
        this.f424826b = true;
        this.f424831g = true;
        this.f424832h = true;
        this.f424833i = false;
        this.f424834j = true;
        this.f424835k = false;
        this.f424836l = false;
        r100.readTypedList(r101, PreSelectedPair.CREATOR);
        if (r100.readByte() == 0) goto L5;
        boolean r103 = true;
    L6:
        this.f424826b = r103;
        if (r100.readByte() == 0) goto L9;
        boolean r104 = true;
    L10:
        this.f424827c = r104;
        if (r100.readByte() == 0) goto L13;
        boolean r105 = true;
    L14:
        this.f424828d = r105;
        this.f424829e = r100.readInt();
        if (r100.readByte() == 0) goto L17;
        boolean r106 = true;
    L18:
        this.f424831g = r106;
        if (r100.readByte() == 0) goto L21;
        boolean r107 = true;
    L22:
        this.f424832h = r107;
        if (r100.readByte() == 0) goto L25;
        boolean r108 = true;
    L26:
        this.f424830f = r108;
        if (r100.readByte() == 0) goto L29;
        boolean r109 = true;
    L30:
        this.f424833i = r109;
        if (r100.readByte() == 0) goto L33;
        boolean r110 = true;
    L34:
        this.f424834j = r110;
        if (r100.readByte() == 0) goto L37;
        boolean r111 = true;
    L38:
        this.f424835k = r111;
        if (r100.readByte() != 0) goto L42;
        r102 = false;
    L42:
        this.f424836l = r102;
        this.f424837m = (IForwardCancelListener) r100.readParcelable(ForwardFeature.class.getClassLoader());
        this.f424838n = (IForwardSelectListener) r100.readParcelable(ForwardFeature.class.getClassLoader());
        return;
    L37:
        r111 = false;
        goto L38
    L33:
        r110 = false;
        goto L34
    L29:
        r109 = false;
        goto L30
    L25:
        r108 = false;
        goto L26
    L21:
        r107 = false;
        goto L22
    L17:
        r106 = false;
        goto L18
    L13:
        r105 = false;
        goto L14
    L9:
        r104 = false;
        goto L10
    L5:
        r103 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeTypedList(this.f424825a);
        r100.writeByte(this.f424826b ? 1 : 0);
        r100.writeByte(this.f424827c ? 1 : 0);
        r100.writeByte(this.f424828d ? 1 : 0);
        r100.writeInt(this.f424829e);
        r100.writeByte(this.f424831g ? 1 : 0);
        r100.writeByte(this.f424832h ? 1 : 0);
        r100.writeByte(this.f424830f ? 1 : 0);
        r100.writeByte(this.f424833i ? 1 : 0);
        r100.writeByte(this.f424834j ? 1 : 0);
        r100.writeByte(this.f424835k ? 1 : 0);
        r100.writeByte(this.f424836l ? 1 : 0);
        r100.writeParcelable(this.f424837m, r101);
        r100.writeParcelable(this.f424838n, r101);
    }
}
