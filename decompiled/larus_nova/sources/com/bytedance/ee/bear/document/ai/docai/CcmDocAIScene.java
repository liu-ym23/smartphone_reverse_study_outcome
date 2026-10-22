package com.bytedance.ee.bear.document.ai.docai;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/docai/CcmDocAIScene;", "", "<init>", "(Ljava/lang/String;I)V", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "SHEET", "SLIDES", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CcmDocAIScene extends Enum<CcmDocAIScene> {
    public static final CcmDocAIScene DOC = null;
    public static final CcmDocAIScene SHEET = null;
    public static final CcmDocAIScene SLIDES = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CcmDocAIScene[] f218799a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f218800b = null;

    public static EnumEntries<CcmDocAIScene> getEntries() {
        return f218800b;
    }

    static {
        CcmDocAIScene r100 = new CcmDocAIScene(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 0);
        DOC = r100;
        CcmDocAIScene r101 = new CcmDocAIScene("SHEET", 1);
        SHEET = r101;
        CcmDocAIScene r102 = new CcmDocAIScene("SLIDES", 2);
        SLIDES = r102;
        CcmDocAIScene[] r103 = {r100, r101, r102};
        f218799a = r103;
        f218800b = EnumEntriesKt.enumEntries(r103);
    }

    public static CcmDocAIScene[] values() {
        return (CcmDocAIScene[]) f218799a.clone();
    }

    public static CcmDocAIScene valueOf(String r100) {
        return (CcmDocAIScene) a.a(CcmDocAIScene.class, r100);
    }

    public CcmDocAIScene(String r100, int r101) {
        super(r100, r101);
    }
}
