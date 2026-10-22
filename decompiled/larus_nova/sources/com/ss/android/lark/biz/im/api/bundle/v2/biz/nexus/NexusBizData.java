package com.ss.android.lark.biz.im.api.bundle.v2.biz.nexus;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.biz.im.api.bundle.v2.annotation.BundleKey;
import com.ss.android.lark.chat.entity.message.LarkAgentContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@BundleKey("data_nexus_key")
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0015\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0016\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/nexus/NexusBizData;", "Landroid/os/Parcelable;", "Lcom/ss/android/lark/biz/im/api/bundle/v2/base/IBundle;", "agentContext", "Lcom/ss/android/lark/chat/entity/message/LarkAgentContext;", "<init>", "(Lcom/ss/android/lark/chat/entity/message/LarkAgentContext;)V", "getAgentContext", "()Lcom/ss/android/lark/chat/entity/message/LarkAgentContext;", "putInBundle", "", "bundle", "Landroid/os/Bundle;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NexusBizData implements Parcelable {
    public static final Parcelable.Creator<NexusBizData> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarkAgentContext f410051a;

    public static final class a implements Parcelable.Creator<NexusBizData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final NexusBizData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new NexusBizData((LarkAgentContext) r100.readParcelable(NexusBizData.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final NexusBizData[] newArray(int r100) {
            return new NexusBizData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public NexusBizData() {
        this(null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NexusBizData) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f410051a, ((NexusBizData) r100).f410051a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        LarkAgentContext r100 = this.f410051a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "NexusBizData(agentContext=" + this.f410051a + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeParcelable(this.f410051a, r101);
    }

    public NexusBizData(LarkAgentContext r100) {
        this.f410051a = r100;
    }
}
