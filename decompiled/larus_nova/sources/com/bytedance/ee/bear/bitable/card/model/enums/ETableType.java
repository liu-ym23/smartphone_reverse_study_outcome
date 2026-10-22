package com.bytedance.ee.bear.bitable.card.model.enums;

import com.bytedance.ee.bear.bitable.plugin.more.BitableTitleMorePlugin;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/enums/ETableType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "LINK", "LINK_TABLE", "LINK_CREATE", "CARD", "FORM", "STAGE", BitableTitleMorePlugin.MENU_ID_BASE_MORE_PRO, "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ETableType extends Enum<ETableType> {
    public static final ETableType CARD = null;
    public static final a Companion = null;
    public static final ETableType FORM = null;
    public static final ETableType LINK = null;
    public static final ETableType LINK_CREATE = null;
    public static final ETableType LINK_TABLE = null;
    public static final ETableType PRO = null;
    public static final ETableType STAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ETableType[] f207093a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f207094b = null;
    private final String value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static boolean a(ETableType r100) {
            if (r100 != ETableType.LINK) goto L5;
        L10:
            return true;
        L5:
            if (r100 == ETableType.LINK_TABLE) goto L10;
            if (r100 == ETableType.LINK_CREATE) goto L10;
            return false;
        }

        @JvmStatic
        public static boolean b(ETableType r100) {
            if (r100 != ETableType.CARD) goto L5;
        L10:
            return true;
        L5:
            if (r100 == ETableType.FORM) goto L10;
            if (r100 == ETableType.PRO) goto L10;
            return false;
        }
    }

    public static EnumEntries<ETableType> getEntries() {
        return f207094b;
    }

    @JvmStatic
    public static final boolean isLinkTable(ETableType r100) {
        Companion.getClass();
        return a.a(r100);
    }

    @JvmStatic
    public static final boolean isNormal(ETableType r100) {
        Companion.getClass();
        return a.b(r100);
    }

    static {
        ETableType r100 = new ETableType("LINK", 0, "link");
        LINK = r100;
        ETableType r101 = new ETableType("LINK_TABLE", 1, "link_table");
        LINK_TABLE = r101;
        ETableType r102 = new ETableType("LINK_CREATE", 2, "link_create");
        LINK_CREATE = r102;
        ETableType r103 = new ETableType("CARD", 3, BrowserDependency.UrlClickType.CARD);
        CARD = r103;
        ETableType r104 = new ETableType("FORM", 4, "form");
        FORM = r104;
        ETableType r105 = new ETableType("STAGE", 5, "stage");
        STAGE = r105;
        ETableType r110 = new ETableType(BitableTitleMorePlugin.MENU_ID_BASE_MORE_PRO, 6, "pro");
        PRO = r110;
        ETableType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f207093a = r111;
        f207094b = EnumEntriesKt.enumEntries(r111);
        Companion = new a();
    }

    public static ETableType[] values() {
        return (ETableType[]) f207093a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @JvmStatic
    public static final ETableType from(String r100) {
        Companion.getClass();
        if (r100 == null) goto L14;
        ETableType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L15;
        ETableType r104 = r101[r103];
        if (Intrinsics.areEqual(r104.getValue(), r100) == true) goto L11;
        r103 = r103 + 1;
        goto L6
    L11:
        return r104;
    L15:
        return null;
    L14:
        return null;
    }

    @JvmStatic
    public static final boolean isStackMainLimitCount(ETableType r100) {
        Companion.getClass();
        if (r100 != null) goto L5;
    L16:
        return true;
    L5:
        if (r100 == CARD) goto L16;
        if (r100 == FORM) goto L16;
        if (r100 == PRO) goto L16;
        if (r100 == LINK) goto L16;
        if (r100 == LINK_CREATE) goto L16;
        return false;
    }

    public static ETableType valueOf(String r100) {
        return (ETableType) r27.a.a(ETableType.class, r100);
    }

    public ETableType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
