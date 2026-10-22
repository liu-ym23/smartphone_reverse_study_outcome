package com.larus.avatar.impl.scan.view;

import com.huawei.hms.support.feature.result.CommonConstant;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import p88.h;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0010"}, d2 = {"Lcom/larus/avatar/impl/scan/view/ScanCameraBeautyLevel;", "", "categoryKey", "", CommonConstant.KEY_DISPLAY_NAME, "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getCategoryKey", "()Ljava/lang/String;", "getDisplayName", "NATURAL", "ENHANCED", "OFF", "getMobLevelInt", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ScanCameraBeautyLevel extends Enum<ScanCameraBeautyLevel> {
    public static final String CATEGORY_KEY_BASIC = "basic";
    public static final a Companion = null;
    public static final ScanCameraBeautyLevel ENHANCED = null;
    public static final ScanCameraBeautyLevel NATURAL = null;
    public static final ScanCameraBeautyLevel OFF = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScanCameraBeautyLevel[] f291187a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291188b = null;
    private final String categoryKey;
    private final String displayName;

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f291189a = null;

        static {
            int[] r100 = new int[ScanCameraBeautyLevel.values().length];
            r100[ScanCameraBeautyLevel.NATURAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ScanCameraBeautyLevel.ENHANCED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f291189a = r100;
        }
    }

    public static EnumEntries<ScanCameraBeautyLevel> getEntries() {
        return f291188b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.avatar.impl.scan.view.ScanCameraBeautyLevel$a] */
    static {
        ScanCameraBeautyLevel r100 = new ScanCameraBeautyLevel("NATURAL", 0, "naturally", h.a(R.string.larus_simplifyReplicaGen_pillEnhance_natural));
        NATURAL = r100;
        ScanCameraBeautyLevel r101 = new ScanCameraBeautyLevel("ENHANCED", 1, "enhanced", h.a(R.string.larus_simplifyReplicaGen_pillEnhance_strong));
        ENHANCED = r101;
        ScanCameraBeautyLevel r102 = new ScanCameraBeautyLevel("OFF", 2, "off", h.a(R.string.larus_simplifyReplicaGen_pillEnhance_off));
        OFF = r102;
        ScanCameraBeautyLevel[] r103 = {r100, r101, r102};
        f291187a = r103;
        f291188b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static ScanCameraBeautyLevel[] values() {
        return (ScanCameraBeautyLevel[]) f291187a.clone();
    }

    public final int getMobLevelInt() {
        int r100 = b.f291189a[ordinal()];
        if (r100 != 1) goto L5;
        return 1;
    L5:
        if (r100 == 2) goto L9;
        return 0;
    L9:
        return 2;
    }

    public final String getCategoryKey() {
        return this.categoryKey;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public static ScanCameraBeautyLevel valueOf(String r100) {
        return (ScanCameraBeautyLevel) r27.a.a(ScanCameraBeautyLevel.class, r100);
    }

    public ScanCameraBeautyLevel(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.categoryKey = r102;
        this.displayName = r103;
    }
}
