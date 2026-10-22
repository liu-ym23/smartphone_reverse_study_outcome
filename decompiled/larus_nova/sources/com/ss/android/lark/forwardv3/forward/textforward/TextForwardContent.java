package com.ss.android.lark.forwardv3.forward.textforward;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0002 !B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016R$\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013¨\u0006\""}, d2 = {"Lcom/ss/android/lark/forwardv3/forward/textforward/TextForwardContent;", "Lcom/ss/android/lark/forwardv3/configuration/IForwardContent;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "textSource", "", "getTextSource$annotations", "getTextSource", "()I", "setTextSource", "(I)V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "isLocalShare", "", "()Z", "setLocalShare", "(Z)V", "sourceName", "getSourceName", "setSourceName", "writeToParcel", "", "flags", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextForwardContent implements IForwardContent {
    public static final b CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f425376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f425377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f425378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f425379d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f425380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f425381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f425382c;

        public final TextForwardContent a() {
            TextForwardContent r100 = new TextForwardContent();
            r100.f425376a = 0;
            String r101 = this.f425380a;
            Intrinsics.checkNotNullParameter(r101, "<set-?>");
            r100.f425377b = r101;
            r100.f425378c = this.f425381b;
            String r102 = this.f425382c;
            Intrinsics.checkNotNullParameter(r102, "<set-?>");
            r100.f425379d = r102;
            return r100;
        }

        public a() {
            this.f425380a = "";
            this.f425381b = true;
            this.f425382c = "";
        }
    }

    public static final class b implements Parcelable.Creator<TextForwardContent> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final TextForwardContent createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            TextForwardContent r101 = new TextForwardContent();
            r101.f425376a = r100.readInt();
            String r102 = r100.readString();
            String r103 = "";
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            r101.f425377b = r102;
            if (r100.readByte() == 0) goto L8;
            boolean r104 = true;
        L9:
            r101.f425378c = r104;
            String r105 = r100.readString();
            if (r105 == null) goto L13;
            r103 = r105;
        L13:
            r101.f425379d = r103;
            return r101;
        L8:
            r104 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final TextForwardContent[] newArray(int r100) {
            return new TextForwardContent[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public TextForwardContent() {
        this.f425377b = "";
        this.f425378c = true;
        this.f425379d = "";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.f425376a);
        r100.writeString(this.f425377b);
        r100.writeByte(this.f425378c ? 1 : 0);
        r100.writeString(this.f425379d);
    }
}
