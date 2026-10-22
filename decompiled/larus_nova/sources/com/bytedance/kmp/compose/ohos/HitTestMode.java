package com.bytedance.kmp.compose.ohos;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/kmp/compose/ohos/HitTestMode;", "", "(Ljava/lang/String;I)V", "ARKUI_HIT_TEST_MODE_DEFAULT", "ARKUI_HIT_TEST_MODE_BLOCK", "ARKUI_HIT_TEST_MODE_TRANSPARENT", "ARKUI_HIT_TEST_MODE_NONE", "annotation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum HitTestMode extends Enum<HitTestMode> {
    public static final HitTestMode ARKUI_HIT_TEST_MODE_BLOCK = null;
    public static final HitTestMode ARKUI_HIT_TEST_MODE_DEFAULT = null;
    public static final HitTestMode ARKUI_HIT_TEST_MODE_NONE = null;
    public static final HitTestMode ARKUI_HIT_TEST_MODE_TRANSPARENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HitTestMode[] f251228a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f251229b = null;

    public static EnumEntries<HitTestMode> getEntries() {
        return f251229b;
    }

    public static HitTestMode valueOf(String r100) {
        return (HitTestMode) a.a(HitTestMode.class, r100);
    }

    public static HitTestMode[] values() {
        return (HitTestMode[]) f251228a.clone();
    }

    static {
        HitTestMode r100 = new HitTestMode("ARKUI_HIT_TEST_MODE_DEFAULT", 0);
        ARKUI_HIT_TEST_MODE_DEFAULT = r100;
        HitTestMode r101 = new HitTestMode("ARKUI_HIT_TEST_MODE_BLOCK", 1);
        ARKUI_HIT_TEST_MODE_BLOCK = r101;
        HitTestMode r102 = new HitTestMode("ARKUI_HIT_TEST_MODE_TRANSPARENT", 2);
        ARKUI_HIT_TEST_MODE_TRANSPARENT = r102;
        HitTestMode r103 = new HitTestMode("ARKUI_HIT_TEST_MODE_NONE", 3);
        ARKUI_HIT_TEST_MODE_NONE = r103;
        HitTestMode[] r104 = {r100, r101, r102, r103};
        f251228a = r104;
        f251229b = EnumEntriesKt.enumEntries(r104);
    }

    public HitTestMode(String r100, int r101) {
        super(r100, r101);
    }
}
