package com.larus.platform.model.music;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0081\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0015"}, d2 = {"Lcom/larus/platform/model/music/ThirdPartyMusicPlatform;", "Landroid/os/Parcelable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "QQMusicType", "LunaMusicType", "NetEaseMusicType", "Other", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ThirdPartyMusicPlatform extends Enum<ThirdPartyMusicPlatform> implements Parcelable {
    public static final Parcelable.Creator<ThirdPartyMusicPlatform> CREATOR = null;
    public static final a Companion = null;
    public static final ThirdPartyMusicPlatform LunaMusicType = null;
    public static final ThirdPartyMusicPlatform NetEaseMusicType = null;
    public static final ThirdPartyMusicPlatform Other = null;
    public static final ThirdPartyMusicPlatform QQMusicType = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ThirdPartyMusicPlatform[] f365639a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365640b = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ThirdPartyMusicPlatform> getEntries() {
        return f365640b;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(name());
    }

    static {
        ThirdPartyMusicPlatform r100 = new ThirdPartyMusicPlatform("QQMusicType", 0, "qqmusic");
        QQMusicType = r100;
        ThirdPartyMusicPlatform r101 = new ThirdPartyMusicPlatform("LunaMusicType", 1, "luna");
        LunaMusicType = r101;
        ThirdPartyMusicPlatform r102 = new ThirdPartyMusicPlatform("NetEaseMusicType", 2, "neteasemusic");
        NetEaseMusicType = r102;
        ThirdPartyMusicPlatform r103 = new ThirdPartyMusicPlatform("Other", 3, "other");
        Other = r103;
        ThirdPartyMusicPlatform[] r104 = {r100, r101, r102, r103};
        f365639a = r104;
        f365640b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
        CREATOR = new b();
    }

    public static ThirdPartyMusicPlatform[] values() {
        return (ThirdPartyMusicPlatform[]) f365639a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ThirdPartyMusicPlatform valueOf(String r100) {
        return (ThirdPartyMusicPlatform) r27.a.a(ThirdPartyMusicPlatform.class, r100);
    }

    public ThirdPartyMusicPlatform(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
