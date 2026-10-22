package com.ss.android.lark.forwardv3.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0002#$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\bH\u0016J\b\u0010\"\u001a\u00020\bH\u0016R$\u0010\u0007\u001a\u00020\b8\u0016@\u0016X\u0097\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006%"}, d2 = {"Lcom/ss/android/lark/forwardv3/data/ForwardTargetChatterInfo;", "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "type", "", "getType$annotations", "getType", "()I", "setType", "(I)V", "chatterId", "", "getChatterId", "()Ljava/lang/String;", "setChatterId", "(Ljava/lang/String;)V", "p2pChatId", "getP2pChatId", "setP2pChatId", "chatterType", "Lcom/ss/android/lark/chat/entity/chatter/Chatter$ChatterType;", "getChatterType", "()Lcom/ss/android/lark/chat/entity/chatter/Chatter$ChatterType;", "setChatterType", "(Lcom/ss/android/lark/chat/entity/chatter/Chatter$ChatterType;)V", "isBot", "", "writeToParcel", "", "flags", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForwardTargetChatterInfo extends ForwardTargetBaseInfoNew {
    public static final b CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f425273f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f425274g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f425275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Chatter.ChatterType f425276i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f425277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f425278b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Chatter.ChatterType f425279c;

        public a() {
            this.f425277a = "";
            this.f425278b = "";
            this.f425279c = Chatter.ChatterType.UNKNOWN;
        }
    }

    public static final class b implements Parcelable.Creator<ForwardTargetChatterInfo> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTargetChatterInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ForwardTargetChatterInfo r101 = new ForwardTargetChatterInfo();
            r101.a(r100);
            String r102 = r100.readString();
            String r103 = "";
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            r101.f425274g = r102;
            String r104 = r100.readString();
            if (r104 == null) goto L9;
            r103 = r104;
        L9:
            r101.f425275h = r103;
            r101.f425276i = Chatter.ChatterType.forNumber(r100.readInt());
            return r101;
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTargetChatterInfo[] newArray(int r100) {
            return new ForwardTargetChatterInfo[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ForwardTargetChatterInfo() {
        this.f425273f = 2;
        this.f425274g = "";
        this.f425275h = "";
        this.f425276i = Chatter.ChatterType.UNKNOWN;
    }

    @Override // com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew
    public int getType() {
        return this.f425273f;
    }

    @Override // com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew
    public final void b(int r100) {
        this.f425273f = r100;
    }

    @Override // com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        super.writeToParcel(r100, r101);
        r100.writeString(this.f425274g);
        r100.writeString(this.f425275h);
        r100.writeInt(this.f425276i.getNumber());
    }
}
