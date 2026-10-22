package com.bytedance.ee.bear.document.ai.docai;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/docai/CcmDocAIScene;", "", "<init>", "(Ljava/lang/String;I)V", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "SHEET", "SLIDES", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CcmDocAIScene extends Enum<CcmDocAIScene> {
    public static final CcmDocAIScene DOC = null;
    public static final CcmDocAIScene SHEET = null;
    public static final CcmDocAIScene SLIDES = null;
    public static final /* synthetic */ CcmDocAIScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CcmDocAIScene> getEntries() {
        return b;
    }

    static {
        CcmDocAIScene r0 = new CcmDocAIScene(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 0);
        DOC = r0;
        CcmDocAIScene r1 = new CcmDocAIScene("SHEET", 1);
        SHEET = r1;
        CcmDocAIScene r3 = new CcmDocAIScene("SLIDES", 2);
        SLIDES = r3;
        CcmDocAIScene[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static CcmDocAIScene[] values() {
        return (CcmDocAIScene[]) a.clone();
    }

    public static CcmDocAIScene valueOf(String r1) {
        return (CcmDocAIScene) a.a(CcmDocAIScene.class, r1);
    }

    public CcmDocAIScene(String r1, int r2) {
        super(r1, r2);
    }
}
