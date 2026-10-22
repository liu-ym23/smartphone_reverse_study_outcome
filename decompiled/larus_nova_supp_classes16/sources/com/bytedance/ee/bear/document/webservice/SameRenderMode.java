package com.bytedance.ee.bear.document.webservice;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/document/webservice/SameRenderMode;", "", "<init>", "(Ljava/lang/String;I)V", "DISABLED", "EMBED", "SANDWICH", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SameRenderMode extends Enum<SameRenderMode> {
    public static final SameRenderMode DISABLED = null;
    public static final SameRenderMode EMBED = null;
    public static final SameRenderMode SANDWICH = null;
    public static final /* synthetic */ SameRenderMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SameRenderMode> getEntries() {
        return b;
    }

    static {
        SameRenderMode r0 = new SameRenderMode("DISABLED", 0);
        DISABLED = r0;
        SameRenderMode r1 = new SameRenderMode("EMBED", 1);
        EMBED = r1;
        SameRenderMode r3 = new SameRenderMode("SANDWICH", 2);
        SANDWICH = r3;
        SameRenderMode[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static SameRenderMode[] values() {
        return (SameRenderMode[]) a.clone();
    }

    public static SameRenderMode valueOf(String r1) {
        return (SameRenderMode) a.a(SameRenderMode.class, r1);
    }

    public SameRenderMode(String r1, int r2) {
        super(r1, r2);
    }
}
