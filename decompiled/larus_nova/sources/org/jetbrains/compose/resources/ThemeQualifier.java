package org.jetbrains.compose.resources;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes42.dex */
@InternalResourceApi
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u0000 \u00072\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lorg/jetbrains/compose/resources/ThemeQualifier;", "Lorg/jetbrains/compose/resources/Qualifier;", "", "<init>", "(Ljava/lang/String;I)V", "LIGHT", "DARK", "Companion", "library_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ThemeQualifier extends Enum<ThemeQualifier> {
    public static final a Companion = null;
    public static final ThemeQualifier DARK = null;
    public static final ThemeQualifier LIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ThemeQualifier[] f525831a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f525832b = null;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ThemeQualifier> getEntries() {
        return f525832b;
    }

    static {
        ThemeQualifier r100 = new ThemeQualifier("LIGHT", 0);
        LIGHT = r100;
        ThemeQualifier r101 = new ThemeQualifier("DARK", 1);
        DARK = r101;
        ThemeQualifier[] r102 = {r100, r101};
        f525831a = r102;
        f525832b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static ThemeQualifier[] values() {
        return (ThemeQualifier[]) f525831a.clone();
    }

    public static ThemeQualifier valueOf(String r100) {
        return (ThemeQualifier) r27.a.a(ThemeQualifier.class, r100);
    }

    public ThemeQualifier(String r100, int r101) {
        super(r100, r101);
    }
}
