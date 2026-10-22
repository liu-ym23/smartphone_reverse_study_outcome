package com.larus.dora.impl.resource;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/resource/DoraDrawableDensity;", "", "densityDpi", "", "<init>", "(Ljava/lang/String;ILjava/lang/Integer;)V", "getDensityDpi$impl_mainlandRelease", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", UserProfileEvent.POSITION_NONE, "MDPI", "XXHDPI", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraDrawableDensity extends Enum<DoraDrawableDensity> {
    public static final DoraDrawableDensity MDPI = null;
    public static final DoraDrawableDensity NONE = null;
    public static final DoraDrawableDensity XXHDPI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraDrawableDensity[] f337812a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f337813b = null;
    private final Integer densityDpi;

    public static EnumEntries<DoraDrawableDensity> getEntries() {
        return f337813b;
    }

    static {
        DoraDrawableDensity r100 = new DoraDrawableDensity(UserProfileEvent.POSITION_NONE, 0, null);
        NONE = r100;
        DoraDrawableDensity r101 = new DoraDrawableDensity("MDPI", 1, 160);
        MDPI = r101;
        DoraDrawableDensity r102 = new DoraDrawableDensity("XXHDPI", 2, 480);
        XXHDPI = r102;
        DoraDrawableDensity[] r103 = {r100, r101, r102};
        f337812a = r103;
        f337813b = EnumEntriesKt.enumEntries(r103);
    }

    public static DoraDrawableDensity[] values() {
        return (DoraDrawableDensity[]) f337812a.clone();
    }

    public final Integer getDensityDpi$impl_mainlandRelease() {
        return this.densityDpi;
    }

    public static DoraDrawableDensity valueOf(String r100) {
        return (DoraDrawableDensity) r27.a.a(DoraDrawableDensity.class, r100);
    }

    public DoraDrawableDensity(String r100, int r101, Integer r102) {
        super(r100, r101);
        this.densityDpi = r102;
    }
}
