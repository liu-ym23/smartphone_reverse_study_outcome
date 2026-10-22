package com.ss.android.lark.forwardv3.forward.mediaforward;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.configuration.IShareContent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0017H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lcom/ss/android/lark/forwardv3/forward/mediaforward/MediaForwardContent;", "Lcom/ss/android/lark/forwardv3/configuration/IShareContent;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "videoKey", "", "getVideoKey", "()Ljava/lang/String;", "setVideoKey", "(Ljava/lang/String;)V", "coverKey", "getCoverKey", "setCoverKey", "entityId", "getEntityId", "setEntityId", "messageId", "getMessageId", "setMessageId", "forwardScene", "", "getForwardScene", "()I", "setForwardScene", "(I)V", "describeContents", "writeToParcel", "", "dest", "flags", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaForwardContent implements IShareContent {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f425366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f425367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f425368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f425369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f425370e;

    public static final class a implements Parcelable.Creator<MediaForwardContent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MediaForwardContent createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new MediaForwardContent(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final MediaForwardContent[] newArray(int r100) {
            return new MediaForwardContent[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public MediaForwardContent() {
        this.f425366a = "";
        this.f425367b = "";
        this.f425368c = "";
        this.f425369d = "";
        this.f425370e = ForwardScene.UNKNOWN.getValue();
    }

    public MediaForwardContent(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        String r101 = r100.readString();
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this.f425366a = r101;
        String r103 = r100.readString();
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        this.f425367b = r103;
        String r104 = r100.readString();
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        this.f425368c = r104;
        String r105 = r100.readString();
        if (r105 == null) goto L15;
        r102 = r105;
    L15:
        this.f425369d = r102;
        this.f425370e = r100.readInt();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f425366a);
        r100.writeString(this.f425367b);
        r100.writeString(this.f425368c);
        r100.writeString(this.f425369d);
        r100.writeInt(this.f425370e);
    }
}
