package com.ss.android.lark.forwardv3.messageforward;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 02\u00020\u0001:\u0002/0B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010+\u001a\u00020,2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\bH\u0016J\b\u0010.\u001a\u00020\bH\u0016R$\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0015j\b\u0012\u0004\u0012\u00020\u000f`\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001a\u0010&\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010 \"\u0004\b'\u0010\"R\u001a\u0010(\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0011\"\u0004\b*\u0010\u0013¨\u00061"}, d2 = {"Lcom/ss/android/lark/forwardv3/messageforward/MergeMessageForwardContent;", "Lcom/ss/android/lark/forwardv3/configuration/IForwardContent;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "mergeSource", "", "getMergeSource$annotations", "getMergeSource", "()I", "setMergeSource", "(I)V", "originMergeForwardId", "", "getOriginMergeForwardId", "()Ljava/lang/String;", "setOriginMergeForwardId", "(Ljava/lang/String;)V", "messageIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMessageIds", "()Ljava/util/ArrayList;", "setMessageIds", "(Ljava/util/ArrayList;)V", "quasiTitle", "getQuasiTitle", "setQuasiTitle", "isThread", "", "()Z", "setThread", "(Z)V", "threadId", "getThreadId", "setThreadId", "isLimit", "setLimit", "chatId", "getChatId", "setChatId", "writeToParcel", "", "flags", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MergeMessageForwardContent implements IForwardContent {
    public static final b CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f425396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f425397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<String> f425398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f425399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f425400e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f425401f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f425402g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f425403h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f425404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f425405b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList<String> f425406c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f425407d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f425408e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f425409f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f425410g;

        public final MergeMessageForwardContent a() {
            MergeMessageForwardContent r100 = new MergeMessageForwardContent();
            r100.f425396a = this.f425404a;
            String r101 = this.f425405b;
            Intrinsics.checkNotNullParameter(r101, "<set-?>");
            r100.f425397b = r101;
            ArrayList<String> r102 = this.f425406c;
            Intrinsics.checkNotNullParameter(r102, "<set-?>");
            r100.f425398c = r102;
            String r103 = this.f425407d;
            Intrinsics.checkNotNullParameter(r103, "<set-?>");
            r100.f425399d = r103;
            r100.f425400e = this.f425408e;
            String r104 = this.f425409f;
            Intrinsics.checkNotNullParameter(r104, "<set-?>");
            r100.f425401f = r104;
            r100.f425402g = false;
            String r105 = this.f425410g;
            Intrinsics.checkNotNullParameter(r105, "<set-?>");
            r100.f425403h = r105;
            return r100;
        }

        public a() {
            this.f425405b = "";
            this.f425406c = new ArrayList();
            this.f425407d = "";
            this.f425409f = "";
            this.f425410g = "";
        }
    }

    public static final class b implements Parcelable.Creator<MergeMessageForwardContent> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final MergeMessageForwardContent createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            MergeMessageForwardContent r101 = new MergeMessageForwardContent();
            r101.f425396a = r100.readInt();
            String r102 = r100.readString();
            String r103 = "";
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            r101.f425397b = r102;
            ArrayList<String> r104 = r100.readArrayList(String.class.getClassLoader());
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
            r101.f425398c = r104;
            String r105 = r100.readString();
            if (r105 != null) goto L8;
            r105 = "";
        L8:
            r101.f425399d = r105;
            boolean r106 = true;
            if (r100.readByte() == 0) goto L11;
            boolean r107 = true;
        L12:
            r101.f425400e = r107;
            String r108 = r100.readString();
            if (r108 != null) goto L15;
            r108 = "";
        L15:
            r101.f425401f = r108;
            if (r100.readByte() != 0) goto L19;
            r106 = false;
        L19:
            r101.f425402g = r106;
            String r109 = r100.readString();
            if (r109 == null) goto L23;
            r103 = r109;
        L23:
            r101.f425403h = r103;
            return r101;
        L11:
            r107 = false;
            goto L12
        }

        @Override // android.os.Parcelable.Creator
        public final MergeMessageForwardContent[] newArray(int r100) {
            return new MergeMessageForwardContent[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public MergeMessageForwardContent() {
        this.f425397b = "";
        this.f425398c = new ArrayList();
        this.f425399d = "";
        this.f425401f = "";
        this.f425403h = "";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.f425396a);
        r100.writeString(this.f425397b);
        r100.writeList(this.f425398c);
        r100.writeString(this.f425399d);
        r100.writeByte(this.f425400e ? 1 : 0);
        r100.writeString(this.f425401f);
        r100.writeByte(this.f425402g ? 1 : 0);
        r100.writeString(this.f425403h);
    }
}
