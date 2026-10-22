package com.bytedance.ee.bear.share.externalshare;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/share/externalshare/ShareScene;", "", "<init>", "(Ljava/lang/String;I)V", "DOCUMENT", "EXPORT_IMAGE", "SHARE_TEXT", "features-share-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ShareScene extends Enum<ShareScene> {
    public static final ShareScene DOCUMENT = null;
    public static final ShareScene EXPORT_IMAGE = null;
    public static final ShareScene SHARE_TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShareScene[] f237022a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f237023b = null;

    public static EnumEntries<ShareScene> getEntries() {
        return f237023b;
    }

    static {
        ShareScene r100 = new ShareScene("DOCUMENT", 0);
        DOCUMENT = r100;
        ShareScene r101 = new ShareScene("EXPORT_IMAGE", 1);
        EXPORT_IMAGE = r101;
        ShareScene r102 = new ShareScene("SHARE_TEXT", 2);
        SHARE_TEXT = r102;
        ShareScene[] r103 = {r100, r101, r102};
        f237022a = r103;
        f237023b = EnumEntriesKt.enumEntries(r103);
    }

    public static ShareScene[] values() {
        return (ShareScene[]) f237022a.clone();
    }

    public static ShareScene valueOf(String r100) {
        return (ShareScene) a.a(ShareScene.class, r100);
    }

    public ShareScene(String r100, int r101) {
        super(r100, r101);
    }
}
