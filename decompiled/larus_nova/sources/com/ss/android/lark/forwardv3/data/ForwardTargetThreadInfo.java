package com.ss.android.lark.forwardv3.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.chat.entity.Channel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 )2\u00020\u0001:\u0002()B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u0015J\u0018\u0010$\u001a\u00020%2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\bH\u0016J\b\u0010'\u001a\u00020\bH\u0016R$\u0010\u0007\u001a\u00020\b8\u0016@\u0016X\u0097\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R$\u0010\u001d\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001f\u0010\u000b\"\u0004\b \u0010\r¨\u0006*"}, d2 = {"Lcom/ss/android/lark/forwardv3/data/ForwardTargetThreadInfo;", "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "type", "", "getType$annotations", "getType", "()I", "setType", "(I)V", "channel", "Lcom/ss/android/lark/chat/entity/Channel;", "getChannel", "()Lcom/ss/android/lark/chat/entity/Channel;", "setChannel", "(Lcom/ss/android/lark/chat/entity/Channel;)V", "threadId", "", "getThreadId", "()Ljava/lang/String;", "setThreadId", "(Ljava/lang/String;)V", "p2pChatterId", "getP2pChatterId", "setP2pChatterId", "entityType", "getEntityType$annotations", "getEntityType", "setEntityType", "isReplyInThread", "", "getEntityId", "writeToParcel", "", "flags", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForwardTargetThreadInfo extends ForwardTargetBaseInfoNew {
    public static final b CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f425296f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Channel f425297g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f425298h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f425299i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f425300j;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Channel f425301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f425302b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f425303c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f425304d;

        public final ForwardTargetThreadInfo a() {
            ForwardTargetThreadInfo r100 = new ForwardTargetThreadInfo();
            Channel r101 = this.f425301a;
            Intrinsics.checkNotNullParameter(r101, "<set-?>");
            r100.f425297g = r101;
            String r102 = this.f425302b;
            Intrinsics.checkNotNullParameter(r102, "<set-?>");
            r100.f425298h = r102;
            r100.f425300j = this.f425304d;
            String r103 = this.f425303c;
            Intrinsics.checkNotNullParameter(r103, "<set-?>");
            r100.f425299i = r103;
            return r100;
        }

        public a() {
            this.f425301a = new Channel(Channel.Type.UNKNOWN, "");
            this.f425302b = "";
            this.f425303c = "";
            this.f425304d = -1;
        }
    }

    public static final class b implements Parcelable.Creator<ForwardTargetThreadInfo> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTargetThreadInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ForwardTargetThreadInfo r101 = new ForwardTargetThreadInfo();
            r101.a(r100);
            Serializable r102 = r100.readSerializable();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.Channel");
            r101.f425297g = (Channel) r102;
            String r103 = r100.readString();
            String r104 = "";
            if (r103 != null) goto L5;
            r103 = "";
        L5:
            r101.f425298h = r103;
            String r105 = r100.readString();
            if (r105 == null) goto L9;
            r104 = r105;
        L9:
            r101.f425299i = r104;
            r101.f425300j = r100.readInt();
            return r101;
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTargetThreadInfo[] newArray(int r100) {
            return new ForwardTargetThreadInfo[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ForwardTargetThreadInfo() {
        this.f425296f = 3;
        this.f425297g = new Channel(Channel.Type.UNKNOWN, "");
        this.f425298h = "";
        this.f425299i = "";
        this.f425300j = -1;
    }

    @Override // com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew
    public int getType() {
        return this.f425296f;
    }

    @Override // com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew
    public final void b(int r100) {
        this.f425296f = r100;
    }

    @Override // com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        super.writeToParcel(r100, r101);
        r100.writeSerializable(this.f425297g);
        r100.writeString(this.f425298h);
        r100.writeString(this.f425299i);
        r100.writeInt(this.f425300j);
    }
}
