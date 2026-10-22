package com.ss.android.lark.forwardv3.configuration;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.configuration.dto.StickImage;
import com.ss.android.lark.image.entity.Image;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 ;2\u00020\u0001:\u0002:;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u00106\u001a\u0002072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u0017H\u0016J\b\u00109\u001a\u00020\u0017H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00100\"\u0004\b5\u00102¨\u0006<"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/BasicDialogContentConfig;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "label", "", "getLabel", "()Ljava/lang/String;", "setLabel", "(Ljava/lang/String;)V", "title", "getTitle", com.alipay.sdk.m.x.d.f25925o, "content", "getContent", "setContent", "description", "getDescription", "setDescription", "subscriptRes", "", "getSubscriptRes", "()I", "setSubscriptRes", "(I)V", "thumbnailRes", "getThumbnailRes", "setThumbnailRes", "encryptThumbnailImage", "Lcom/ss/android/lark/image/entity/Image;", "getEncryptThumbnailImage", "()Lcom/ss/android/lark/image/entity/Image;", "setEncryptThumbnailImage", "(Lcom/ss/android/lark/image/entity/Image;)V", "avatarThumbnailImage", "getAvatarThumbnailImage", "setAvatarThumbnailImage", "thumbnailStick", "Lcom/ss/android/lark/forwardv3/configuration/dto/StickImage;", "getThumbnailStick", "()Lcom/ss/android/lark/forwardv3/configuration/dto/StickImage;", "setThumbnailStick", "(Lcom/ss/android/lark/forwardv3/configuration/dto/StickImage;)V", "isVideoType", "", "()Z", "setVideoType", "(Z)V", "clickable", "getClickable", "setClickable", "writeToParcel", "", "flags", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BasicDialogContentConfig implements Parcelable {
    public static final b CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f425128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f425129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f425130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f425131d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f425132e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f425133f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Image f425134g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Image f425135h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public StickImage f425136i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f425137j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f425138k;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f425139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f425140b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f425141c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f425142d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f425143e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f425144f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Image f425145g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Image f425146h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public StickImage f425147i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f425148j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f425149k;

        public final BasicDialogContentConfig a() {
            BasicDialogContentConfig r100 = new BasicDialogContentConfig();
            String r101 = this.f425139a;
            Intrinsics.checkNotNullParameter(r101, "<set-?>");
            r100.f425128a = r101;
            String r102 = this.f425140b;
            Intrinsics.checkNotNullParameter(r102, "<set-?>");
            r100.f425129b = r102;
            String r103 = this.f425141c;
            Intrinsics.checkNotNullParameter(r103, "<set-?>");
            r100.f425130c = r103;
            String r104 = this.f425142d;
            Intrinsics.checkNotNullParameter(r104, "<set-?>");
            r100.f425131d = r104;
            r100.f425132e = this.f425143e;
            r100.f425133f = this.f425144f;
            r100.f425134g = this.f425145g;
            r100.f425135h = this.f425146h;
            r100.f425136i = this.f425147i;
            r100.f425137j = this.f425148j;
            r100.f425138k = this.f425149k;
            return r100;
        }

        public a() {
            this.f425139a = "";
            this.f425140b = "";
            this.f425141c = "";
            this.f425142d = "";
        }
    }

    public static final class b implements Parcelable.Creator<BasicDialogContentConfig> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final BasicDialogContentConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            BasicDialogContentConfig r101 = new BasicDialogContentConfig();
            String r102 = r100.readString();
            String r103 = "";
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            r101.f425128a = r102;
            String r104 = r100.readString();
            if (r104 != null) goto L8;
            r104 = "";
        L8:
            r101.f425129b = r104;
            String r105 = r100.readString();
            if (r105 != null) goto L11;
            r105 = "";
        L11:
            r101.f425130c = r105;
            String r106 = r100.readString();
            if (r106 == null) goto L15;
            r103 = r106;
        L15:
            r101.f425131d = r103;
            r101.f425132e = r100.readInt();
            r101.f425133f = r100.readInt();
            r101.f425134g = (Image) r100.readSerializable();
            r101.f425135h = (Image) r100.readSerializable();
            r101.f425136i = (StickImage) r100.readParcelable(BasicDialogContentConfig.class.getClassLoader());
            boolean r107 = true;
            if (r100.readByte() == 0) goto L18;
            boolean r108 = true;
        L19:
            r101.f425137j = r108;
            if (r100.readByte() != 0) goto L23;
            r107 = false;
        L23:
            r101.f425138k = r107;
            return r101;
        L18:
            r108 = false;
            goto L19
        }

        @Override // android.os.Parcelable.Creator
        public final BasicDialogContentConfig[] newArray(int r100) {
            return new BasicDialogContentConfig[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public BasicDialogContentConfig() {
        this.f425128a = "";
        this.f425129b = "";
        this.f425130c = "";
        this.f425131d = "";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f425128a);
        r100.writeString(this.f425129b);
        r100.writeString(this.f425130c);
        r100.writeString(this.f425131d);
        r100.writeInt(this.f425132e);
        r100.writeInt(this.f425133f);
        r100.writeSerializable(this.f425134g);
        r100.writeSerializable(this.f425135h);
        r100.writeParcelable(this.f425136i, r101);
        r100.writeByte(this.f425137j ? 1 : 0);
        r100.writeByte(this.f425138k ? 1 : 0);
    }
}
