package com.obric.memorydata.sdk.screencapture;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.memorydata.sdk.screencapture.rule.ScreenEventRule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J'\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010 \u001a\u00020\u0017J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\u0015¨\u0006'"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/ScreenEventReaction;", "Landroid/os/Parcelable;", "id", "", com.heytap.mcssdk.constant.b.f276366p, "Lcom/obric/memorydata/sdk/screencapture/rule/ScreenEventRule;", "taskOptions", "Lcom/obric/memorydata/sdk/screencapture/TaskOptions;", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/sdk/screencapture/rule/ScreenEventRule;Lcom/obric/memorydata/sdk/screencapture/TaskOptions;)V", "getId", "()Ljava/lang/String;", "getRule", "()Lcom/obric/memorydata/sdk/screencapture/rule/ScreenEventRule;", "getTaskOptions", "()Lcom/obric/memorydata/sdk/screencapture/TaskOptions;", "sourcePackage", "getSourcePackage$annotations", "()V", "getSourcePackage", "setSourcePackage", "(Ljava/lang/String;)V", "hashCode", "", "equals", "", "other", "", "component1", "component2", "component3", "copy", "describeContents", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenEventReaction implements Parcelable {
    public static final Parcelable.Creator<ScreenEventReaction> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f397207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScreenEventRule f397208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TaskOptions f397209c;

    public static final class a implements Parcelable.Creator<ScreenEventReaction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ScreenEventReaction createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new ScreenEventReaction(r100.readString(), (ScreenEventRule) r100.readParcelable(ScreenEventReaction.class.getClassLoader()), TaskOptions.CREATOR.createFromParcel(r100));
        }

        @Override // android.os.Parcelable.Creator
        public final ScreenEventReaction[] newArray(int r100) {
            return new ScreenEventReaction[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "ScreenEventReaction(id=" + this.f397207a + ", rule=" + this.f397208b + ", taskOptions=" + this.f397209c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f397207a);
        r100.writeParcelable(this.f397208b, r101);
        this.f397209c.writeToParcel(r100, r101);
    }

    public final int hashCode() {
        return this.f397207a.hashCode();
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof ScreenEventReaction) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(this.f397207a, ((ScreenEventReaction) r100).f397207a);
    }

    public ScreenEventReaction(String r100, ScreenEventRule r101, TaskOptions r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, com.heytap.mcssdk.constant.b.f276366p);
        Intrinsics.checkNotNullParameter(r102, "taskOptions");
        this.f397207a = r100;
        this.f397208b = r101;
        this.f397209c = r102;
    }
}
