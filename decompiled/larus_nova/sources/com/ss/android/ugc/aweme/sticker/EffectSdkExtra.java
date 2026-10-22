package com.ss.android.ugc.aweme.sticker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0014\u0012\r\b\u0002\u0010\u0003\u001a\u00070\u0004¢\u0006\u0002\b\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bHÖ\u0001R#\u0010\u0003\u001a\u00070\u0004¢\u0006\u0002\b\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/ss/android/ugc/aweme/sticker/EffectSdkExtra;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "pl", "Lcom/ss/android/ugc/aweme/sticker/PlDataBean;", "Lkotlinx/android/parcel/RawValue;", "(Lcom/ss/android/ugc/aweme/sticker/PlDataBean;)V", "getPl", "()Lcom/ss/android/ugc/aweme/sticker/PlDataBean;", "setPl", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class EffectSdkExtra implements Parcelable, Serializable {
    public static final Parcelable.Creator<EffectSdkExtra> CREATOR = null;

    /* JADX INFO: renamed from: pl, reason: collision with root package name */
    @SerializedName("pl")
    private PlDataBean f454276pl;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public static class Creator implements Parcelable.Creator<EffectSdkExtra> {
        public Creator() {
        }

        @Override // android.os.Parcelable.Creator
        public final EffectSdkExtra createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            return new EffectSdkExtra(PlDataBean.CREATOR.createFromParcel(r100));
        }

        @Override // android.os.Parcelable.Creator
        public final EffectSdkExtra[] newArray(int r100) {
            return new EffectSdkExtra[r100];
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EffectSdkExtra() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this.f454276pl.writeToParcel(r100, 0);
    }

    public final PlDataBean getPl() {
        return this.f454276pl;
    }

    public EffectSdkExtra(PlDataBean r100) {
        Intrinsics.checkNotNullParameter(r100, "pl");
        this.f454276pl = r100;
    }

    public final void setPl(PlDataBean r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f454276pl = r100;
    }

    public /* synthetic */ EffectSdkExtra(PlDataBean r110, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 1) == 0) goto L5;
        PlDataBean r100 = new PlDataBean(null, null, null, false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16383, null);
    L6:
        this(r100);
        return;
    L5:
        r100 = r110;
        goto L6
    }
}
