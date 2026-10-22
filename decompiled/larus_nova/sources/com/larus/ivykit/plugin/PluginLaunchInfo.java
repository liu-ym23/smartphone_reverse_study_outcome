package com.larus.ivykit.plugin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/larus/ivykit/plugin/PluginLaunchInfo;", "Landroid/os/Parcelable;", "preLoadingGui", "Lcom/larus/ivykit/plugin/PreLoadingGui;", "<init>", "(Lcom/larus/ivykit/plugin/PreLoadingGui;)V", "getPreLoadingGui", "()Lcom/larus/ivykit/plugin/PreLoadingGui;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "ivykit_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PluginLaunchInfo implements Parcelable {
    public static final Parcelable.Creator<PluginLaunchInfo> CREATOR = null;

    @SerializedName("pre_loading_gui")
    private final PreLoadingGui preLoadingGui;

    public static final class a implements Parcelable.Creator<PluginLaunchInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PluginLaunchInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() != 0) goto L5;
            PreLoadingGui r101 = null;
        L7:
            return new PluginLaunchInfo(r101);
        L5:
            r101 = PreLoadingGui.CREATOR.createFromParcel(r100);
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final PluginLaunchInfo[] newArray(int r100) {
            return new PluginLaunchInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public PluginLaunchInfo() {
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
        if ((r100 instanceof PluginLaunchInfo) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.preLoadingGui, ((PluginLaunchInfo) r100).preLoadingGui) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        PreLoadingGui r100 = this.preLoadingGui;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "PluginLaunchInfo(preLoadingGui=" + this.preLoadingGui + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        PreLoadingGui r102 = this.preLoadingGui;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
    }

    public final PreLoadingGui a() {
        return this.preLoadingGui;
    }

    public PluginLaunchInfo(PreLoadingGui r100) {
        this.preLoadingGui = r100;
    }
}
