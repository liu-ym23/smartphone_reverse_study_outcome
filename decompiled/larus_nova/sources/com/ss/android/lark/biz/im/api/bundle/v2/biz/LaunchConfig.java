package com.ss.android.lark.biz.im.api.bundle.v2.biz;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.biz.im.api.bundle.SourceType;
import com.ss.android.lark.biz.im.api.bundle.v2.annotation.BundleKey;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@BundleKey("data_launch_config_key")
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001,B=\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J?\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0006\u0010!\u001a\u00020\u0004J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0004HÖ\u0001J\t\u0010'\u001a\u00020\tHÖ\u0001J\u0016\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006-"}, d2 = {"Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/LaunchConfig;", "Landroid/os/Parcelable;", "Lcom/ss/android/lark/biz/im/api/bundle/v2/base/IBundle;", "startFlag", "", "transition", "launchStyle", "Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/LaunchConfig$LaunchStyle;", "fromTag", "", "sourceType", "Lcom/ss/android/lark/biz/im/api/bundle/SourceType;", "<init>", "(IILcom/ss/android/lark/biz/im/api/bundle/v2/biz/LaunchConfig$LaunchStyle;Ljava/lang/String;Lcom/ss/android/lark/biz/im/api/bundle/SourceType;)V", "getStartFlag", "()I", "getTransition", "getLaunchStyle", "()Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/LaunchConfig$LaunchStyle;", "getFromTag", "()Ljava/lang/String;", "getSourceType", "()Lcom/ss/android/lark/biz/im/api/bundle/SourceType;", "putInBundle", "", "bundle", "Landroid/os/Bundle;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "LaunchStyle", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LaunchConfig implements Parcelable {
    public static final Parcelable.Creator<LaunchConfig> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f410017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f410018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LaunchStyle f410019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f410020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SourceType f410021e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/LaunchConfig$LaunchStyle;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", EffectConstants.NORMAL, "BOTTOM_SHEET", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LaunchStyle extends Enum<LaunchStyle> {
        public static final LaunchStyle BOTTOM_SHEET = null;
        public static final LaunchStyle NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LaunchStyle[] f410022a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f410023b = null;
        private final int value;

        public static EnumEntries<LaunchStyle> getEntries() {
            return f410023b;
        }

        static {
            LaunchStyle r100 = new LaunchStyle(EffectConstants.NORMAL, 0, 0);
            NORMAL = r100;
            LaunchStyle r101 = new LaunchStyle("BOTTOM_SHEET", 1, 1);
            BOTTOM_SHEET = r101;
            LaunchStyle[] r102 = {r100, r101};
            f410022a = r102;
            f410023b = EnumEntriesKt.enumEntries(r102);
        }

        public static LaunchStyle[] values() {
            return (LaunchStyle[]) f410022a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static LaunchStyle valueOf(String r100) {
            return (LaunchStyle) r27.a.a(LaunchStyle.class, r100);
        }

        public LaunchStyle(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a implements Parcelable.Creator<LaunchConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LaunchConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            int r101 = r100.readInt();
            int r102 = r100.readInt();
            LaunchStyle r103 = LaunchStyle.valueOf(r100.readString());
            String r104 = r100.readString();
            if (r100.readInt() != 0) goto L5;
            SourceType r105 = null;
        L7:
            return new LaunchConfig(r101, r102, r103, r104, r105);
        L5:
            r105 = SourceType.valueOf(r100.readString());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final LaunchConfig[] newArray(int r100) {
            return new LaunchConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public LaunchConfig() {
        this(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LaunchConfig) == true) goto L8;
        return false;
    L8:
        LaunchConfig r101 = (LaunchConfig) r100;
        if (this.f410017a == r101.f410017a) goto L12;
        return false;
    L12:
        if (this.f410018b == r101.f410018b) goto L15;
        return false;
    L15:
        if (this.f410019c == r101.f410019c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f410020d, r101.f410020d) == true) goto L21;
        return false;
    L21:
        if (this.f410021e == r101.f410021e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f410017a * 31) + this.f410018b) * 31) + this.f410019c.hashCode()) * 31;
        String r101 = this.f410020d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        SourceType r105 = this.f410021e;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "LaunchConfig(startFlag=" + this.f410017a + ", transition=" + this.f410018b + ", launchStyle=" + this.f410019c + ", fromTag=" + this.f410020d + ", sourceType=" + this.f410021e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.f410017a);
        r100.writeInt(this.f410018b);
        r100.writeString(this.f410019c.name());
        r100.writeString(this.f410020d);
        SourceType r102 = this.f410021e;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r100.writeString(r102.name());
    }

    public /* synthetic */ LaunchConfig(int r100) {
        this(-1, 0, LaunchStyle.NORMAL, null, null);
    }

    public LaunchConfig(int r100, int r101, LaunchStyle r102, String r103, SourceType r104) {
        Intrinsics.checkNotNullParameter(r102, "launchStyle");
        this.f410017a = r100;
        this.f410018b = r101;
        this.f410019c = r102;
        this.f410020d = r103;
        this.f410021e = r104;
    }
}
