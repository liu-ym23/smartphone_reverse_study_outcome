package com.ss.android.lark.forwardv2.dto.template;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes36.dex */
public class ForwardViewDependency implements Parcelable {
    public static final Parcelable.Creator<ForwardViewDependency> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f424862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f424863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f424864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f424865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BasicDialogContent f424866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ForwardEnhancedView f424867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f424868g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f424869h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f424870i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f424871j;

    public class a implements Parcelable.Creator<ForwardViewDependency> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardViewDependency createFromParcel(Parcel r100) {
            return new ForwardViewDependency(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardViewDependency[] newArray(int r100) {
            return new ForwardViewDependency[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ForwardViewDependency() {
        this.f424870i = true;
        this.f424871j = true;
    }

    public ForwardViewDependency(Parcel r100) {
        boolean r101 = true;
        this.f424870i = true;
        this.f424871j = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.f424870i = r102;
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.f424862a = r103;
        this.f424863b = r100.readString();
        this.f424864c = r100.readString();
        this.f424865d = r100.readString();
        this.f424868g = r100.readString();
        this.f424869h = r100.readString();
        this.f424866e = (BasicDialogContent) r100.readParcelable(BasicDialogContent.class.getClassLoader());
        this.f424867f = (ForwardEnhancedView) r100.readParcelable(BasicDialogContent.class.getClassLoader());
        if (r100.readByte() != 0) goto L14;
        r101 = false;
    L14:
        this.f424871j = r101;
        return;
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeByte(this.f424870i ? 1 : 0);
        r100.writeByte(this.f424862a ? 1 : 0);
        r100.writeString(this.f424863b);
        r100.writeString(this.f424864c);
        r100.writeString(this.f424865d);
        r100.writeString(this.f424868g);
        r100.writeString(this.f424869h);
        r100.writeParcelable(this.f424866e, r101);
        r100.writeParcelable(this.f424867f, r101);
        r100.writeByte(this.f424871j ? 1 : 0);
    }
}
