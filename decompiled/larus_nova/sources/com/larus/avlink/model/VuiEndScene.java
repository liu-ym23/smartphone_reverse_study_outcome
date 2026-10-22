package com.larus.avlink.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/avlink/model/VuiEndScene;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "MediaFocus", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VuiEndScene extends Enum<VuiEndScene> {
    public static final VuiEndScene DEFAULT = null;
    public static final VuiEndScene MediaFocus = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VuiEndScene[] f293419a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f293420b = null;

    public static EnumEntries<VuiEndScene> getEntries() {
        return f293420b;
    }

    static {
        VuiEndScene r100 = new VuiEndScene("DEFAULT", 0);
        DEFAULT = r100;
        VuiEndScene r101 = new VuiEndScene("MediaFocus", 1);
        MediaFocus = r101;
        VuiEndScene[] r102 = {r100, r101};
        f293419a = r102;
        f293420b = EnumEntriesKt.enumEntries(r102);
    }

    public static VuiEndScene[] values() {
        return (VuiEndScene[]) f293419a.clone();
    }

    public static VuiEndScene valueOf(String r100) {
        return (VuiEndScene) r27.a.a(VuiEndScene.class, r100);
    }

    public VuiEndScene(String r100, int r101) {
        super(r100, r101);
    }
}
