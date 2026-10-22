package com.larus.platform.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/model/Level;", "", "<init>", "(Ljava/lang/String;I)V", "Normal", "HIGH", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Level extends Enum<Level> {
    public static final Level HIGH = null;
    public static final Level Normal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Level[] f365462a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365463b = null;

    public static EnumEntries<Level> getEntries() {
        return f365463b;
    }

    static {
        Level r100 = new Level("Normal", 0);
        Normal = r100;
        Level r101 = new Level("HIGH", 1);
        HIGH = r101;
        Level[] r102 = {r100, r101};
        f365462a = r102;
        f365463b = EnumEntriesKt.enumEntries(r102);
    }

    public static Level[] values() {
        return (Level[]) f365462a.clone();
    }

    public static Level valueOf(String r100) {
        return (Level) a.a(Level.class, r100);
    }

    public Level(String r100, int r101) {
        super(r100, r101);
    }
}
