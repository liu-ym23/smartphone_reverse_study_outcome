package com.bytedance.ee.bear.document.associated;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/document/associated/QuickLaunchBarItemType;", "", "<init>", "(Ljava/lang/String;I)V", "ADD_ASSOCIATION_DOC", "ASSOCIATED_DOC", "ASSOCIATED_DOC_WITH_COLLABORATOR", "docs-document-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum QuickLaunchBarItemType extends Enum<QuickLaunchBarItemType> {
    public static final QuickLaunchBarItemType ADD_ASSOCIATION_DOC = null;
    public static final QuickLaunchBarItemType ASSOCIATED_DOC = null;
    public static final QuickLaunchBarItemType ASSOCIATED_DOC_WITH_COLLABORATOR = null;
    public static final /* synthetic */ QuickLaunchBarItemType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<QuickLaunchBarItemType> getEntries() {
        return b;
    }

    static {
        QuickLaunchBarItemType r0 = new QuickLaunchBarItemType("ADD_ASSOCIATION_DOC", 0);
        ADD_ASSOCIATION_DOC = r0;
        QuickLaunchBarItemType r1 = new QuickLaunchBarItemType("ASSOCIATED_DOC", 1);
        ASSOCIATED_DOC = r1;
        QuickLaunchBarItemType r3 = new QuickLaunchBarItemType("ASSOCIATED_DOC_WITH_COLLABORATOR", 2);
        ASSOCIATED_DOC_WITH_COLLABORATOR = r3;
        QuickLaunchBarItemType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static QuickLaunchBarItemType[] values() {
        return (QuickLaunchBarItemType[]) a.clone();
    }

    public static QuickLaunchBarItemType valueOf(String r1) {
        return (QuickLaunchBarItemType) a.a(QuickLaunchBarItemType.class, r1);
    }

    public QuickLaunchBarItemType(String r1, int r2) {
        super(r1, r2);
    }
}
