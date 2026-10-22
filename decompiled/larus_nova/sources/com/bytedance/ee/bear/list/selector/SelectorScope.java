package com.bytedance.ee.bear.list.selector;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00112\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0006\u0010\u000f\u001a\u00020\u0010j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/list/selector/SelectorScope;", "Landroid/os/Parcelable;", "", "<init>", "(Ljava/lang/String;I)V", AccountType.ALL, "SPACE_ONLY", "WIKI_ONLY", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "describeContents", "getFilter", "", "CREATOR", "contentmanager-list-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SelectorScope extends Enum<SelectorScope> implements Parcelable {
    public static final SelectorScope ALL = null;
    public static final a CREATOR = null;
    public static final SelectorScope SPACE_ONLY = null;
    public static final SelectorScope WIKI_ONLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SelectorScope[] f229379a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f229380b = null;

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f229381a = null;

        static {
            int[] r100 = new int[SelectorScope.values().length];
            r100[SelectorScope.SPACE_ONLY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[SelectorScope.WIKI_ONLY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f229381a = r100;
        }
    }

    public static EnumEntries<SelectorScope> getEntries() {
        return f229380b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.list.selector.SelectorScope$a] */
    static {
        SelectorScope r100 = new SelectorScope(AccountType.ALL, 0);
        ALL = r100;
        SelectorScope r101 = new SelectorScope("SPACE_ONLY", 1);
        SPACE_ONLY = r101;
        SelectorScope r102 = new SelectorScope("WIKI_ONLY", 2);
        WIKI_ONLY = r102;
        SelectorScope[] r103 = {r100, r101, r102};
        f229379a = r103;
        f229380b = EnumEntriesKt.enumEntries(r103);
        CREATOR = new a();
    }

    public static SelectorScope[] values() {
        return (SelectorScope[]) f229379a.clone();
    }

    public final String getFilter() {
        int r100 = b.f229381a[ordinal()];
        if (r100 != 1) goto L5;
        return "space";
    L5:
        if (r100 == 2) goto L7;
        return "";
    L7:
        return "wiki";
    }

    public static SelectorScope valueOf(String r100) {
        return (SelectorScope) r27.a.a(SelectorScope.class, r100);
    }

    public SelectorScope(String r100, int r101) {
        super(r100, r101);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(ordinal());
    }
}
