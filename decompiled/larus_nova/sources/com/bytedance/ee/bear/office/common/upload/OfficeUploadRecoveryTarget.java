package com.bytedance.ee.bear.office.common.upload;

import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class OfficeUploadRecoveryTarget {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f235302c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f235303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f235304b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadRecoveryTarget$Type;", "", "<init>", "(Ljava/lang/String;I)V", "ROOT_MINE", "FOLDER", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        public static final Type FOLDER = null;
        public static final Type ROOT_MINE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f235305a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f235306b = null;

        public static EnumEntries<Type> getEntries() {
            return f235306b;
        }

        static {
            Type r100 = new Type("ROOT_MINE", 0);
            ROOT_MINE = r100;
            Type r101 = new Type("FOLDER", 1);
            FOLDER = r101;
            Type[] r102 = {r100, r101};
            f235305a = r102;
            f235306b = EnumEntriesKt.enumEntries(r102);
        }

        public static Type[] values() {
            return (Type[]) f235305a.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public static OfficeUploadRecoveryTarget b() {
            return new OfficeUploadRecoveryTarget(Type.ROOT_MINE, null);
        }

        public static OfficeUploadRecoveryTarget a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "folderToken");
            if ((!StringsKt.isBlank(r100)) == true) goto L6;
            r100 = null;
        L6:
            if (r100 != null) goto L8;
            return null;
        L8:
            return new OfficeUploadRecoveryTarget(Type.FOLDER, r100);
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f235307a = null;

        static {
            int[] r100 = new int[Type.values().length];
            r100[Type.ROOT_MINE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Type.FOLDER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f235307a = r100;
        }
    }

    static {
    }

    public final String a() {
        Type r100 = this.f235303a;
        int r101 = b.f235307a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return RootDescription.ROOT_ELEMENT;
    L5:
        if (r101 != 2) goto L11;
        StringBuilder r102 = new StringBuilder("folder:");
        String r103 = this.f235304b;
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        r102.append(r103.hashCode());
        return r102.toString();
    L11:
        throw new NoWhenBranchMatchedException();
    }

    public final g0 b() {
        Type r100 = this.f235303a;
        int r101 = b.f235307a[r100.ordinal()];
        if (r101 == 1) goto L13;
        if (r101 != 2) goto L11;
        String r102 = this.f235304b;
        if (r102 != null) goto L14;
        r102 = "";
    L14:
        return new g0.a(r102);
    L11:
        throw new NoWhenBranchMatchedException();
    L13:
        return g0.b.f235371a;
    }

    public OfficeUploadRecoveryTarget(Type r100, String r101) {
        this.f235303a = r100;
        this.f235304b = r101;
    }
}
