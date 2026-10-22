package com.bytedance.ee.bear.list.homepage.title;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/list/homepage/title/DocPageEnum;", "", ResourceData.KEY_ID, "", "textResId", "<init>", "(Ljava/lang/String;III)V", "getId", "()I", "getTextResId", "RECENT_VISIT", "SHARE_WITH_ME", "FAVORITE", "MY_FOLDER", "SHARE_FOLDER", "OFFLINE", "OWNED_BY_ME", "MY_INVOLVED", "AI_NOTE_SHARE_WITH_ME", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DocPageEnum extends Enum<DocPageEnum> {
    public static final DocPageEnum AI_NOTE_SHARE_WITH_ME = null;
    public static final DocPageEnum FAVORITE = null;
    public static final DocPageEnum MY_FOLDER = null;
    public static final DocPageEnum MY_INVOLVED = null;
    public static final DocPageEnum OFFLINE = null;
    public static final DocPageEnum OWNED_BY_ME = null;
    public static final DocPageEnum RECENT_VISIT = null;
    public static final DocPageEnum SHARE_FOLDER = null;
    public static final DocPageEnum SHARE_WITH_ME = null;
    public static final /* synthetic */ DocPageEnum[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int id;
    private final int textResId;

    public static EnumEntries<DocPageEnum> getEntries() {
        return b;
    }

    static {
        DocPageEnum r0 = new DocPageEnum("RECENT_VISIT", 0, 1, 2131889630);
        RECENT_VISIT = r0;
        DocPageEnum r1 = new DocPageEnum("SHARE_WITH_ME", 1, 2, 2131887980);
        SHARE_WITH_ME = r1;
        DocPageEnum r2 = new DocPageEnum("FAVORITE", 2, 3, 2131887927);
        FAVORITE = r2;
        DocPageEnum r5 = new DocPageEnum("MY_FOLDER", 3, 4, 2131889621);
        MY_FOLDER = r5;
        DocPageEnum r7 = new DocPageEnum("SHARE_FOLDER", 4, 5, 2131889636);
        SHARE_FOLDER = r7;
        DocPageEnum r9 = new DocPageEnum("OFFLINE", 5, 6, 2131887949);
        OFFLINE = r9;
        DocPageEnum r11 = new DocPageEnum("OWNED_BY_ME", 6, 7, 2131888707);
        OWNED_BY_ME = r11;
        DocPageEnum r13 = new DocPageEnum("MY_INVOLVED", 7, 8, 2131894005);
        MY_INVOLVED = r13;
        DocPageEnum r14 = new DocPageEnum("AI_NOTE_SHARE_WITH_ME", 8, 9, 2131887929);
        AI_NOTE_SHARE_WITH_ME = r14;
        DocPageEnum[] r8 = {r0, r1, r2, r5, r7, r9, r11, r13, r14};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static DocPageEnum[] values() {
        return (DocPageEnum[]) a.clone();
    }

    public final int getId() {
        return this.id;
    }

    public final int getTextResId() {
        return this.textResId;
    }

    public static DocPageEnum valueOf(String r1) {
        return (DocPageEnum) r27.a.a(DocPageEnum.class, r1);
    }

    public DocPageEnum(String r1, int r2, int r3, int r4) {
        super(r1, r2);
        this.id = r3;
        this.textResId = r4;
    }
}
