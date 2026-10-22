package com.bytedance.ee.bear.document.sharewords.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/document/sharewords/bean/SendImLoadStage;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "IMAGE_START", "IMAGE_URL_SUCCESS", "IMAGE_SUCCESS", "IMAGE_FAIL", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SendImLoadStage extends Enum<SendImLoadStage> {
    public static final SendImLoadStage IMAGE_FAIL = null;
    public static final SendImLoadStage IMAGE_START = null;
    public static final SendImLoadStage IMAGE_SUCCESS = null;
    public static final SendImLoadStage IMAGE_URL_SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SendImLoadStage[] f221785a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f221786b = null;

    public static EnumEntries<SendImLoadStage> getEntries() {
        return f221786b;
    }

    static {
        SendImLoadStage r100 = new SendImLoadStage("IMAGE_START", 0);
        IMAGE_START = r100;
        SendImLoadStage r101 = new SendImLoadStage("IMAGE_URL_SUCCESS", 1);
        IMAGE_URL_SUCCESS = r101;
        SendImLoadStage r102 = new SendImLoadStage("IMAGE_SUCCESS", 2);
        IMAGE_SUCCESS = r102;
        SendImLoadStage r103 = new SendImLoadStage("IMAGE_FAIL", 3);
        IMAGE_FAIL = r103;
        SendImLoadStage[] r104 = {r100, r101, r102, r103};
        f221785a = r104;
        f221786b = EnumEntriesKt.enumEntries(r104);
    }

    public static SendImLoadStage[] values() {
        return (SendImLoadStage[]) f221785a.clone();
    }

    public static SendImLoadStage valueOf(String r100) {
        return (SendImLoadStage) a.a(SendImLoadStage.class, r100);
    }

    public SendImLoadStage(String r100, int r101) {
        super(r100, r101);
    }
}
