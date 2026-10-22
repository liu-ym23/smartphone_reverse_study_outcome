package com.larus.dora.impl.resource;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0011"}, d2 = {"Lcom/larus/dora/impl/resource/DoraResourceDeviceType;", "", "directoryName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDirectoryName", "()Ljava/lang/String;", "LITE", FaceService.neutralLabel, "G1", "G2", "G_SERIES", "lookupOrder", "", "getLookupOrder$impl_mainlandRelease", "()Ljava/util/List;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraResourceDeviceType extends Enum<DoraResourceDeviceType> {
    public static final DoraResourceDeviceType G1 = null;
    public static final DoraResourceDeviceType G2 = null;
    public static final DoraResourceDeviceType G_SERIES = null;
    public static final DoraResourceDeviceType H = null;
    public static final DoraResourceDeviceType LITE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraResourceDeviceType[] f337817a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f337818b = null;
    private final String directoryName;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f337819a = null;

        static {
            int[] r100 = new int[DoraResourceDeviceType.values().length];
            r100[DoraResourceDeviceType.G1.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[DoraResourceDeviceType.G2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f337819a = r100;
        }
    }

    public static EnumEntries<DoraResourceDeviceType> getEntries() {
        return f337818b;
    }

    static {
        DoraResourceDeviceType r100 = new DoraResourceDeviceType("LITE", 0, "lite");
        LITE = r100;
        DoraResourceDeviceType r101 = new DoraResourceDeviceType(FaceService.neutralLabel, 1, "h");
        H = r101;
        DoraResourceDeviceType r102 = new DoraResourceDeviceType("G1", 2, DoraObricDeviceHomeViewModel.PRODUCT_CODE_G1);
        G1 = r102;
        DoraResourceDeviceType r103 = new DoraResourceDeviceType("G2", 3, DoraObricDeviceHomeViewModel.PRODUCT_CODE_G2);
        G2 = r103;
        DoraResourceDeviceType r104 = new DoraResourceDeviceType("G_SERIES", 4, "shared/g");
        G_SERIES = r104;
        DoraResourceDeviceType[] r105 = {r100, r101, r102, r103, r104};
        f337817a = r105;
        f337818b = EnumEntriesKt.enumEntries(r105);
    }

    public static DoraResourceDeviceType[] values() {
        return (DoraResourceDeviceType[]) f337817a.clone();
    }

    public final List<DoraResourceDeviceType> getLookupOrder$impl_mainlandRelease() {
        int r100 = a.f337819a[ordinal()];
        if (r100 == 1) goto L8;
        if (r100 == 2) goto L10;
        return CollectionsKt.listOf(this);
    L10:
        return CollectionsKt.listOf(new DoraResourceDeviceType[]{G2, G_SERIES});
    L8:
        return CollectionsKt.listOf(new DoraResourceDeviceType[]{G1, G_SERIES});
    }

    public final String getDirectoryName() {
        return this.directoryName;
    }

    public static DoraResourceDeviceType valueOf(String r100) {
        return (DoraResourceDeviceType) r27.a.a(DoraResourceDeviceType.class, r100);
    }

    public DoraResourceDeviceType(String r100, int r101, String r102) {
        super(r100, r101);
        this.directoryName = r102;
    }
}
