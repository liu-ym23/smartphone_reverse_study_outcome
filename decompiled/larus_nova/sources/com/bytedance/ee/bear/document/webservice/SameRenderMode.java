package com.bytedance.ee.bear.document.webservice;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/document/webservice/SameRenderMode;", "", "<init>", "(Ljava/lang/String;I)V", "DISABLED", "EMBED", "SANDWICH", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SameRenderMode extends Enum<SameRenderMode> {
    public static final SameRenderMode DISABLED = null;
    public static final SameRenderMode EMBED = null;
    public static final SameRenderMode SANDWICH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SameRenderMode[] f222482a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f222483b = null;

    public static EnumEntries<SameRenderMode> getEntries() {
        return f222483b;
    }

    static {
        SameRenderMode r100 = new SameRenderMode("DISABLED", 0);
        DISABLED = r100;
        SameRenderMode r101 = new SameRenderMode("EMBED", 1);
        EMBED = r101;
        SameRenderMode r102 = new SameRenderMode("SANDWICH", 2);
        SANDWICH = r102;
        SameRenderMode[] r103 = {r100, r101, r102};
        f222482a = r103;
        f222483b = EnumEntriesKt.enumEntries(r103);
    }

    public static SameRenderMode[] values() {
        return (SameRenderMode[]) f222482a.clone();
    }

    public static SameRenderMode valueOf(String r100) {
        return (SameRenderMode) a.a(SameRenderMode.class, r100);
    }

    public SameRenderMode(String r100, int r101) {
        super(r100, r101);
    }
}
