package com.ss.android.lark.forwardv2.dto.template;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv2.dto.StickImage;
import com.ss.android.lark.image.entity.Image;

/* JADX INFO: loaded from: classes36.dex */
public class BasicDialogContent implements Parcelable {
    public static final Parcelable.Creator<BasicDialogContent> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f424807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f424808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f424809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f424810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f424811e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Image f424812f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Image f424813g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public StickImage f424814h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f424815i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f424816j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f424817k;

    public class a implements Parcelable.Creator<BasicDialogContent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BasicDialogContent createFromParcel(Parcel r100) {
            return new BasicDialogContent(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final BasicDialogContent[] newArray(int r100) {
            return new BasicDialogContent[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public BasicDialogContent() {
    }

    public BasicDialogContent(Parcel r100) {
        this.f424807a = r100.readString();
        this.f424808b = r100.readString();
        this.f424809c = r100.readString();
        this.f424810d = r100.readString();
        this.f424811e = r100.readInt();
        this.f424813g = (Image) r100.readSerializable();
        this.f424812f = (Image) r100.readSerializable();
        this.f424814h = (StickImage) r100.readSerializable();
        this.f424815i = r100.readInt();
        boolean r101 = false;
        if (r100.readInt() != 1) goto L5;
        boolean r102 = true;
    L6:
        this.f424816j = r102;
        if (r100.readInt() != 1) goto L9;
        r101 = true;
    L9:
        this.f424817k = r101;
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f424807a);
        r100.writeString(this.f424808b);
        r100.writeString(this.f424809c);
        r100.writeString(this.f424810d);
        r100.writeInt(this.f424811e);
        r100.writeSerializable(this.f424813g);
        r100.writeSerializable(this.f424812f);
        r100.writeSerializable(this.f424814h);
        r100.writeInt(this.f424815i);
        r100.writeInt(this.f424816j ? 1 : 0);
        r100.writeInt(this.f424817k ? 1 : 0);
    }
}
