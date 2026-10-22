package com.huawei.hms.support.account.result;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes23.dex */
public class AssistTokenResult implements Parcelable {
    public static final Parcelable.Creator<AssistTokenResult> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f277700a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public AssistTokenResult() {
    }

    public String getAssistToken() {
        return this.f277700a;
    }

    private AssistTokenResult(Parcel r100) {
        this.f277700a = r100.readString();
    }

    public void setAssistToken(String r100) {
        this.f277700a = r100;
    }

    public /* synthetic */ AssistTokenResult(Parcel r100, AnonymousClass1 r101) {
        this(r100);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f277700a);
    }
}
