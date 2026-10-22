package com.ss.android.lark.chat.entity.theme;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public final class TitleTheme {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThemeType f415366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f415367b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chat/entity/theme/TitleTheme$ThemeType;", "", "<init>", "(Ljava/lang/String;I)V", "DARK", "LIGHT", "SECRET", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ThemeType extends Enum<ThemeType> {
        public static final ThemeType DARK = null;
        public static final ThemeType LIGHT = null;
        public static final ThemeType SECRET = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ThemeType[] f415368a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f415369b = null;

        public static EnumEntries<ThemeType> getEntries() {
            return f415369b;
        }

        static {
            ThemeType r100 = new ThemeType("DARK", 0);
            DARK = r100;
            ThemeType r101 = new ThemeType("LIGHT", 1);
            LIGHT = r101;
            ThemeType r102 = new ThemeType("SECRET", 2);
            SECRET = r102;
            ThemeType[] r103 = {r100, r101, r102};
            f415368a = r103;
            f415369b = EnumEntriesKt.enumEntries(r103);
        }

        public static ThemeType[] values() {
            return (ThemeType[]) f415368a.clone();
        }

        public static ThemeType valueOf(String r100) {
            return (ThemeType) a.a(ThemeType.class, r100);
        }

        public ThemeType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final String toString() {
        return "TitleTheme(type=" + this.f415366a + ", titleBgColor=" + this.f415367b + ')';
    }

    public final int hashCode() {
        int r100 = this.f415366a.hashCode() * 31;
        Integer r101 = this.f415367b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final ThemeType getType() {
        return this.f415366a;
    }

    public TitleTheme(ThemeType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f415366a = r100;
        this.f415367b = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(TitleTheme.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.theme.TitleTheme");
        TitleTheme r102 = (TitleTheme) r100;
        if (this.f415366a == r102.f415366a) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f415367b, r102.f415367b) == true) goto L18;
        return false;
    L18:
        return true;
    L8:
        r101 = null;
        goto L10
    }
}
