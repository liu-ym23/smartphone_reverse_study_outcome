package com.ss.android.lark.biz.im.api.bundle.v2.base.input;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\u0013\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0017\u001a\u00020\u000eHÖ\u0001J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/biz/im/api/bundle/v2/base/input/ChatLaunchParamData;", "Landroid/os/Parcelable;", "Lcom/ss/android/lark/biz/im/api/bundle/v2/base/input/ILaunchDataInput;", "launchInputParam", "Lcom/ss/android/lark/biz/im/api/bundle/v2/base/input/LaunchInputParam;", "<init>", "(Lcom/ss/android/lark/biz/im/api/bundle/v2/base/input/LaunchInputParam;)V", "getLaunchInputParam", "()Lcom/ss/android/lark/biz/im/api/bundle/v2/base/input/LaunchInputParam;", "type", "Lcom/ss/android/lark/biz/im/api/bundle/v2/base/input/ILaunchDataInput$LaunchDataType;", "isValid", "", "toDesc", "", "component1", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatLaunchParamData implements Parcelable, ILaunchDataInput {
    public static final Parcelable.Creator<ChatLaunchParamData> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LaunchInputParam f409978a;

    public static final class a implements Parcelable.Creator<ChatLaunchParamData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ChatLaunchParamData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new ChatLaunchParamData(LaunchInputParam.CREATOR.createFromParcel(r100));
        }

        @Override // android.os.Parcelable.Creator
        public final ChatLaunchParamData[] newArray(int r100) {
            return new ChatLaunchParamData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatLaunchParamData) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f409978a, ((ChatLaunchParamData) r100).f409978a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f409978a.hashCode();
    }

    public final String toString() {
        return "ChatLaunchParamData(launchInputParam=" + this.f409978a + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        this.f409978a.writeToParcel(r100, r101);
    }

    @Override // com.ss.android.lark.biz.im.api.bundle.v2.base.input.ILaunchDataInput
    public final boolean isValid() {
        LaunchInputParam r100 = this.f409978a;
        if (TextUtils.isEmpty(r100.f409982a) == true) goto L5;
    L8:
        return true;
    L5:
        if (TextUtils.isEmpty(r100.f409983b) == false) goto L8;
        return false;
    }

    @Override // com.ss.android.lark.biz.im.api.bundle.v2.base.input.ILaunchDataInput
    public final String x0() {
        String r100 = this.f409978a.f409982a;
        if (r100 != null) goto L6;
        r100 = "nil";
    L6:
        return "launchInputParam: ".concat(r100);
    }

    @Override // com.ss.android.lark.biz.im.api.bundle.v2.base.input.ILaunchDataInput
    public final ILaunchDataInput.LaunchDataType type() {
        return ILaunchDataInput.LaunchDataType.CHAT_EQUAL_DATA;
    }

    public ChatLaunchParamData(LaunchInputParam r100) {
        Intrinsics.checkNotNullParameter(r100, "launchInputParam");
        this.f409978a = r100;
    }
}
