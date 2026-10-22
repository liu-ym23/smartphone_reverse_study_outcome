package com.bytedance.ee.bear.wikiv2.selector;

import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/selector/FolderSource;", "", "source", "", "<init>", "(Ljava/lang/String;II)V", "getSource", "()I", "SEARCH", "MY_SPACE", "SHARED_SPACE", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FolderSource extends Enum<FolderSource> {
    public static final a Companion = null;
    public static final FolderSource MY_SPACE = null;
    public static final FolderSource SEARCH = null;
    public static final FolderSource SHARED_SPACE = null;
    public static final /* synthetic */ FolderSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int source;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<FolderSource> getEntries() {
        return b;
    }

    static {
        FolderSource r0 = new FolderSource("SEARCH", 0, 0);
        SEARCH = r0;
        FolderSource r1 = new FolderSource("MY_SPACE", 1, 1);
        MY_SPACE = r1;
        FolderSource r3 = new FolderSource("SHARED_SPACE", 2, 2);
        SHARED_SPACE = r3;
        FolderSource[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static FolderSource[] values() {
        return (FolderSource[]) a.clone();
    }

    public final int getSource() {
        return this.source;
    }

    @JvmStatic
    public static final String getTargetLocation(int r1) {
        Companion.getClass();
        if (r1 != MY_SPACE.getSource()) goto L6;
        return WikiSpaceType.PERSONAL;
    L6:
        if (r1 != SHARED_SPACE.getSource()) goto L8;
        return "shared";
    L8:
        return "space";
    }

    public static FolderSource valueOf(String r1) {
        return (FolderSource) r27.a.a(FolderSource.class, r1);
    }

    public FolderSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.source = r3;
    }
}
