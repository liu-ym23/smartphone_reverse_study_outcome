package com.bytedance.ee.bear.document.associated;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/document/associated/QuickLaunchBarItemType;", "", "<init>", "(Ljava/lang/String;I)V", "ADD_ASSOCIATION_DOC", "ASSOCIATED_DOC", "ASSOCIATED_DOC_WITH_COLLABORATOR", "docs-document-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum QuickLaunchBarItemType extends Enum<QuickLaunchBarItemType> {
    public static final QuickLaunchBarItemType ADD_ASSOCIATION_DOC = null;
    public static final QuickLaunchBarItemType ASSOCIATED_DOC = null;
    public static final QuickLaunchBarItemType ASSOCIATED_DOC_WITH_COLLABORATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ QuickLaunchBarItemType[] f218977a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f218978b = null;

    public static EnumEntries<QuickLaunchBarItemType> getEntries() {
        return f218978b;
    }

    static {
        QuickLaunchBarItemType r100 = new QuickLaunchBarItemType("ADD_ASSOCIATION_DOC", 0);
        ADD_ASSOCIATION_DOC = r100;
        QuickLaunchBarItemType r101 = new QuickLaunchBarItemType("ASSOCIATED_DOC", 1);
        ASSOCIATED_DOC = r101;
        QuickLaunchBarItemType r102 = new QuickLaunchBarItemType("ASSOCIATED_DOC_WITH_COLLABORATOR", 2);
        ASSOCIATED_DOC_WITH_COLLABORATOR = r102;
        QuickLaunchBarItemType[] r103 = {r100, r101, r102};
        f218977a = r103;
        f218978b = EnumEntriesKt.enumEntries(r103);
    }

    public static QuickLaunchBarItemType[] values() {
        return (QuickLaunchBarItemType[]) f218977a.clone();
    }

    public static QuickLaunchBarItemType valueOf(String r100) {
        return (QuickLaunchBarItemType) a.a(QuickLaunchBarItemType.class, r100);
    }

    public QuickLaunchBarItemType(String r100, int r101) {
        super(r100, r101);
    }
}
