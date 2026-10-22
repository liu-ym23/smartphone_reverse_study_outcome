package com.suite.lark.platform.feature.forward.doubao.file;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0002\u0010\tJ\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0014H\u0016J\b\u0010%\u001a\u00020\u0014H\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000f¨\u0006'"}, d2 = {"Lcom/suite/lark/platform/feature/forward/doubao/file/DoubaoFileForwardContent;", "Lcom/ss/android/lark/forwardv3/configuration/IForwardContent;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "request", "Lcom/suite/lark/platform/feature/forward/doubao/api/entity/DoubaoFileForwardRequest;", "(Lcom/suite/lark/platform/feature/forward/doubao/api/entity/DoubaoFileForwardRequest;)V", "resourceUri", "", "getResourceUri", "()Ljava/lang/String;", "setResourceUri", "(Ljava/lang/String;)V", "fileName", "getFileName", "setFileName", "storageType", "", "getStorageType", "()I", "setStorageType", "(I)V", "fileSize", "", "getFileSize", "()J", "setFileSize", "(J)V", DBDefinition.MIME_TYPE, "getMimeType", "setMimeType", "writeToParcel", "", "flags", "describeContents", "CREATOR", "forward-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoFileForwardContent implements IForwardContent {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f461342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f461343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f461344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f461345d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f461346e;

    public static final class a implements Parcelable.Creator<DoubaoFileForwardContent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DoubaoFileForwardContent createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new DoubaoFileForwardContent(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final DoubaoFileForwardContent[] newArray(int r100) {
            return new DoubaoFileForwardContent[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public DoubaoFileForwardContent() {
        this.f461342a = "";
        this.f461343b = "";
        this.f461346e = "";
    }

    public DoubaoFileForwardContent(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        String r101 = r100.readString();
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this.f461342a = r101;
        String r103 = r100.readString();
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        this.f461343b = r103;
        this.f461344c = r100.readInt();
        this.f461345d = r100.readLong();
        String r104 = r100.readString();
        if (r104 == null) goto L12;
        r102 = r104;
    L12:
        this.f461346e = r102;
    }

    public DoubaoFileForwardContent(npc.a r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        this();
        this.f461342a = r100.f520068a;
        this.f461343b = r100.f520069b;
        this.f461344c = r100.f520070c;
        this.f461345d = r100.f520071d;
        this.f461346e = r100.f520072e;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f461342a);
        r100.writeString(this.f461343b);
        r100.writeInt(this.f461344c);
        r100.writeLong(this.f461345d);
        r100.writeString(this.f461346e);
    }
}
