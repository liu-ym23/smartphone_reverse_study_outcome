package com.larus.bot.impl.common.propertyconfig;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bot/impl/common/propertyconfig/Visibility;", "", "<init>", "(Ljava/lang/String;I)V", "VISIBLE", "DISABLE", "HIDDEN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Visibility extends Enum<Visibility> {
    public static final Visibility DISABLE = null;
    public static final Visibility HIDDEN = null;
    public static final Visibility VISIBLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Visibility[] f317665a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f317666b = null;

    public static EnumEntries<Visibility> getEntries() {
        return f317666b;
    }

    static {
        Visibility r100 = new Visibility("VISIBLE", 0);
        VISIBLE = r100;
        Visibility r101 = new Visibility("DISABLE", 1);
        DISABLE = r101;
        Visibility r102 = new Visibility("HIDDEN", 2);
        HIDDEN = r102;
        Visibility[] r103 = {r100, r101, r102};
        f317665a = r103;
        f317666b = EnumEntriesKt.enumEntries(r103);
    }

    public static Visibility[] values() {
        return (Visibility[]) f317665a.clone();
    }

    public static Visibility valueOf(String r100) {
        return (Visibility) a.a(Visibility.class, r100);
    }

    public Visibility(String r100, int r101) {
        super(r100, r101);
    }
}
