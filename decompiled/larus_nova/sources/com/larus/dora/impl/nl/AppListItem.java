package com.larus.dora.impl.nl;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class AppListItem {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/impl/nl/AppListItem$BackgroundType;", "", "<init>", "(Ljava/lang/String;I)V", "FIRST", "MIDDLE", "LAST", "DEFAULT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BackgroundType extends Enum<BackgroundType> {
        public static final BackgroundType DEFAULT = null;
        public static final BackgroundType FIRST = null;
        public static final BackgroundType LAST = null;
        public static final BackgroundType MIDDLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BackgroundType[] f336173a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f336174b = null;

        public static EnumEntries<BackgroundType> getEntries() {
            return f336174b;
        }

        static {
            BackgroundType r100 = new BackgroundType("FIRST", 0);
            FIRST = r100;
            BackgroundType r101 = new BackgroundType("MIDDLE", 1);
            MIDDLE = r101;
            BackgroundType r102 = new BackgroundType("LAST", 2);
            LAST = r102;
            BackgroundType r103 = new BackgroundType("DEFAULT", 3);
            DEFAULT = r103;
            BackgroundType[] r104 = {r100, r101, r102, r103};
            f336173a = r104;
            f336174b = EnumEntriesKt.enumEntries(r104);
        }

        public static BackgroundType[] values() {
            return (BackgroundType[]) f336173a.clone();
        }

        public static BackgroundType valueOf(String r100) {
            return (BackgroundType) r27.a.a(BackgroundType.class, r100);
        }

        public BackgroundType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a extends AppListItem {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f336175a = null;

        static {
            f336175a = new a();
        }

        public a() {
        }
    }

    public static final class b extends AppListItem {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f336176a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f336176a, ((b) r100).f336176a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f336176a.hashCode();
        }

        public final String toString() {
            return "Header(title=" + this.f336176a + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "title");
            this.f336176a = r100;
        }
    }

    public static final class c extends AppListItem {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f336177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BackgroundType f336178b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.larus.dora.impl.network.s f336179c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f336177a == r101.f336177a) goto L12;
            return false;
        L12:
            if (this.f336178b == r101.f336178b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f336179c, r101.f336179c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.f336177a == false) goto L5;
            int r100 = 1231;
        L7:
            return (((r100 * 31) + this.f336178b.hashCode()) * 31) + this.f336179c.hashCode();
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "Item(isEnabled=" + this.f336177a + ", bgType=" + this.f336178b + ", data=" + this.f336179c + ')';
        }

        public final void a(BackgroundType r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.f336178b = r100;
        }

        public c(boolean r100, BackgroundType r101, com.larus.dora.impl.network.s r102) {
            Intrinsics.checkNotNullParameter(r101, "bgType");
            Intrinsics.checkNotNullParameter(r102, "data");
            this.f336177a = r100;
            this.f336178b = r101;
            this.f336179c = r102;
        }
    }

    public AppListItem() {
    }
}
