package com.larus.platform.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u000b"}, d2 = {"Lcom/larus/platform/model/LarkSocialFeedPresentationMode;", "", "<init>", "(Ljava/lang/String;I)V", "NATIVE", "MIXED_PENDING", "MIXED_ACTIVE", "usesMixedProductShape", "", "getUsesMixedProductShape", "()Z", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LarkSocialFeedPresentationMode extends Enum<LarkSocialFeedPresentationMode> {
    public static final LarkSocialFeedPresentationMode MIXED_ACTIVE = null;
    public static final LarkSocialFeedPresentationMode MIXED_PENDING = null;
    public static final LarkSocialFeedPresentationMode NATIVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LarkSocialFeedPresentationMode[] f365456a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365457b = null;

    public static EnumEntries<LarkSocialFeedPresentationMode> getEntries() {
        return f365457b;
    }

    static {
        LarkSocialFeedPresentationMode r100 = new LarkSocialFeedPresentationMode("NATIVE", 0);
        NATIVE = r100;
        LarkSocialFeedPresentationMode r101 = new LarkSocialFeedPresentationMode("MIXED_PENDING", 1);
        MIXED_PENDING = r101;
        LarkSocialFeedPresentationMode r102 = new LarkSocialFeedPresentationMode("MIXED_ACTIVE", 2);
        MIXED_ACTIVE = r102;
        LarkSocialFeedPresentationMode[] r103 = {r100, r101, r102};
        f365456a = r103;
        f365457b = EnumEntriesKt.enumEntries(r103);
    }

    public static LarkSocialFeedPresentationMode[] values() {
        return (LarkSocialFeedPresentationMode[]) f365456a.clone();
    }

    public final boolean getUsesMixedProductShape() {
        if (this == NATIVE) goto L5;
        return true;
    L5:
        return false;
    }

    public static LarkSocialFeedPresentationMode valueOf(String r100) {
        return (LarkSocialFeedPresentationMode) a.a(LarkSocialFeedPresentationMode.class, r100);
    }

    public LarkSocialFeedPresentationMode(String r100, int r101) {
        super(r100, r101);
    }
}
