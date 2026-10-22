package com.bytedance.ee.bear.document.sharewords.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/document/sharewords/bean/SendImLoadStage;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "IMAGE_START", "IMAGE_URL_SUCCESS", "IMAGE_SUCCESS", "IMAGE_FAIL", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SendImLoadStage extends Enum<SendImLoadStage> {
    public static final SendImLoadStage IMAGE_FAIL = null;
    public static final SendImLoadStage IMAGE_START = null;
    public static final SendImLoadStage IMAGE_SUCCESS = null;
    public static final SendImLoadStage IMAGE_URL_SUCCESS = null;
    public static final /* synthetic */ SendImLoadStage[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SendImLoadStage> getEntries() {
        return b;
    }

    static {
        SendImLoadStage r0 = new SendImLoadStage("IMAGE_START", 0);
        IMAGE_START = r0;
        SendImLoadStage r1 = new SendImLoadStage("IMAGE_URL_SUCCESS", 1);
        IMAGE_URL_SUCCESS = r1;
        SendImLoadStage r3 = new SendImLoadStage("IMAGE_SUCCESS", 2);
        IMAGE_SUCCESS = r3;
        SendImLoadStage r5 = new SendImLoadStage("IMAGE_FAIL", 3);
        IMAGE_FAIL = r5;
        SendImLoadStage[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static SendImLoadStage[] values() {
        return (SendImLoadStage[]) a.clone();
    }

    public static SendImLoadStage valueOf(String r1) {
        return (SendImLoadStage) a.a(SendImLoadStage.class, r1);
    }

    public SendImLoadStage(String r1, int r2) {
        super(r1, r2);
    }
}
