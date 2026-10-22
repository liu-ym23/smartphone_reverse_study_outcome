package com.ss.android.lark.forwardv2.dto.template;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import com.ss.android.lark.forwardv2.impl.IRemoteForwardTargetFilter;

/* JADX INFO: loaded from: classes36.dex */
public class ForwardTargetFilter implements Parcelable {
    public static final Parcelable.Creator<ForwardTargetFilter> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f424851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f424852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f424853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f424854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f424855e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f424856f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f424857g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f424858h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f424859i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f424860j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public IRemoteForwardTargetFilter f424861k;

    /* JADX INFO: renamed from: com.ss.android.lark.forwardv2.dto.template.ForwardTargetFilter$2, reason: invalid class name */
    class AnonymousClass2 extends IRemoteForwardTargetFilter.Stub {
        final /* synthetic */ ForwardTargetFilter this$0;
        final /* synthetic */ c val$customFilter;

        @Override // com.ss.android.lark.forwardv2.impl.IRemoteForwardTargetFilter
        public boolean filter(ForwardTarget r100) throws RemoteException {
            throw null;
        }

        public AnonymousClass2(ForwardTargetFilter r100, c r101) {
            this.this$0 = r100;
        }
    }

    public class a implements Parcelable.Creator<ForwardTargetFilter> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTargetFilter createFromParcel(Parcel r100) {
            return new ForwardTargetFilter(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTargetFilter[] newArray(int r100) {
            return new ForwardTargetFilter[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ForwardTargetFilter() {
        this.f424851a = false;
        this.f424852b = false;
        this.f424853c = false;
        this.f424854d = false;
        this.f424855e = false;
        this.f424856f = false;
        this.f424857g = true;
        this.f424858h = true;
        this.f424859i = false;
        this.f424860j = false;
    }

    public ForwardTargetFilter(Parcel r100) {
        boolean r101 = false;
        this.f424851a = false;
        this.f424852b = false;
        this.f424853c = false;
        this.f424854d = false;
        this.f424855e = false;
        this.f424856f = false;
        this.f424857g = true;
        this.f424858h = true;
        this.f424859i = false;
        this.f424860j = false;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.f424851a = r102;
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.f424852b = r103;
        if (r100.readByte() == 0) goto L13;
        boolean r104 = true;
    L14:
        this.f424853c = r104;
        if (r100.readByte() == 0) goto L17;
        boolean r105 = true;
    L18:
        this.f424854d = r105;
        if (r100.readByte() == 0) goto L21;
        boolean r106 = true;
    L22:
        this.f424855e = r106;
        if (r100.readByte() == 0) goto L25;
        boolean r107 = true;
    L26:
        this.f424856f = r107;
        if (r100.readByte() == 0) goto L29;
        boolean r108 = true;
    L30:
        this.f424857g = r108;
        if (r100.readByte() == 0) goto L33;
        boolean r109 = true;
    L34:
        this.f424859i = r109;
        if (r100.readByte() == 0) goto L37;
        boolean r110 = true;
    L38:
        this.f424858h = r110;
        if (r100.readByte() == 0) goto L41;
        r101 = true;
    L41:
        this.f424860j = r101;
        if (r100.readInt() <= 0) goto L45;
        this.f424861k = IRemoteForwardTargetFilter.Stub.asInterface(r100.readStrongBinder());
        return;
    L45:
        return;
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
        r100.writeByte(this.f424851a ? 1 : 0);
        r100.writeByte(this.f424852b ? 1 : 0);
        r100.writeByte(this.f424853c ? 1 : 0);
        r100.writeByte(this.f424854d ? 1 : 0);
        r100.writeByte(this.f424855e ? 1 : 0);
        r100.writeByte(this.f424856f ? 1 : 0);
        r100.writeByte(this.f424857g ? 1 : 0);
        r100.writeByte(this.f424859i ? 1 : 0);
        r100.writeByte(this.f424858h ? 1 : 0);
        r100.writeByte(this.f424860j ? 1 : 0);
        if (this.f424861k == null) goto L5;
        r100.writeInt(1);
        r100.writeStrongBinder(this.f424861k.asBinder());
        return;
    L5:
        r100.writeInt(0);
    }
}
