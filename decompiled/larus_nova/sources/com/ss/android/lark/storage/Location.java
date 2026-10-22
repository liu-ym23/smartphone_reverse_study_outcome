package com.ss.android.lark.storage;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/storage/Location;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "INTERNAL", "EXTERNAL", "PUBLIC", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Location extends Enum<Location> {
    public static final Location EXTERNAL = null;
    public static final Location INTERNAL = null;
    public static final Location PUBLIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Location[] f440937a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440938b = null;
    private final String value;

    public static EnumEntries<Location> getEntries() {
        return f440938b;
    }

    static {
        Location r100 = new Location("INTERNAL", 0, "internal");
        INTERNAL = r100;
        Location r101 = new Location("EXTERNAL", 1, "external");
        EXTERNAL = r101;
        Location r102 = new Location("PUBLIC", 2, "public");
        PUBLIC = r102;
        Location[] r103 = {r100, r101, r102};
        f440937a = r103;
        f440938b = EnumEntriesKt.enumEntries(r103);
    }

    public static Location[] values() {
        return (Location[]) f440937a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static Location valueOf(String r100) {
        return (Location) r27.a.a(Location.class, r100);
    }

    public Location(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
