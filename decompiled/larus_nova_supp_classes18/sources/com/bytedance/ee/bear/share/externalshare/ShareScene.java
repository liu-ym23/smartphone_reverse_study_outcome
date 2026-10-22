package com.bytedance.ee.bear.share.externalshare;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/share/externalshare/ShareScene;", "", "<init>", "(Ljava/lang/String;I)V", "DOCUMENT", "EXPORT_IMAGE", "SHARE_TEXT", "features-share-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ShareScene extends Enum<ShareScene> {
    public static final ShareScene DOCUMENT = null;
    public static final ShareScene EXPORT_IMAGE = null;
    public static final ShareScene SHARE_TEXT = null;
    public static final /* synthetic */ ShareScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ShareScene> getEntries() {
        return b;
    }

    static {
        ShareScene r0 = new ShareScene("DOCUMENT", 0);
        DOCUMENT = r0;
        ShareScene r1 = new ShareScene("EXPORT_IMAGE", 1);
        EXPORT_IMAGE = r1;
        ShareScene r3 = new ShareScene("SHARE_TEXT", 2);
        SHARE_TEXT = r3;
        ShareScene[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ShareScene[] values() {
        return (ShareScene[]) a.clone();
    }

    public static ShareScene valueOf(String r1) {
        return (ShareScene) a.a(ShareScene.class, r1);
    }

    public ShareScene(String r1, int r2) {
        super(r1, r2);
    }
}
