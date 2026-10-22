package com.ss.android.lark.chat.entity.preview;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import y28.a;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001*B;\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0000H\u0016J\u0013\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\b\u0010 \u001a\u00020!H\u0016J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JL\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001¢\u0006\u0002\u0010(J\t\u0010)\u001a\u00020\u0004HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006+"}, d2 = {"Lcom/ss/android/lark/chat/entity/preview/UrlPreViewEntries;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "sourceId", "", "sourceTextMD5", "sourceType", "Lcom/ss/android/lark/chat/entity/preview/UrlPreViewEntries$UrlPreViewSourceType;", "privateDescriptionId", "", "entryList", "", "Lcom/ss/android/lark/chat/entity/preview/UrlPreViewEntry;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chat/entity/preview/UrlPreViewEntries$UrlPreViewSourceType;Ljava/lang/Long;Ljava/util/List;)V", "getSourceId", "()Ljava/lang/String;", "getSourceTextMD5", "getSourceType", "()Lcom/ss/android/lark/chat/entity/preview/UrlPreViewEntries$UrlPreViewSourceType;", "getPrivateDescriptionId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEntryList", "()Ljava/util/List;", "isItemSame", "", "diffable", "isContentSame", "equals", "other", "", "hashCode", "", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chat/entity/preview/UrlPreViewEntries$UrlPreViewSourceType;Ljava/lang/Long;Ljava/util/List;)Lcom/ss/android/lark/chat/entity/preview/UrlPreViewEntries;", "toString", "UrlPreViewSourceType", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlPreViewEntries implements Serializable, b<UrlPreViewEntries> {
    private final List<UrlPreViewEntry> entryList;
    private final Long privateDescriptionId;
    private final String sourceId;
    private final String sourceTextMD5;
    private final UrlPreViewSourceType sourceType;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/entity/preview/UrlPreViewEntries$UrlPreViewSourceType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "CHAT_ANNOUNCEMENT", "PERSONAL_SIG", "PRIVATE_DESCRIPTION", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum UrlPreViewSourceType extends Enum<UrlPreViewSourceType> {
        public static final UrlPreViewSourceType CHAT_ANNOUNCEMENT = null;
        public static final a Companion = null;
        public static final UrlPreViewSourceType PERSONAL_SIG = null;
        public static final UrlPreViewSourceType PRIVATE_DESCRIPTION = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ UrlPreViewSourceType[] f415356a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f415357b = null;
        private int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<UrlPreViewSourceType> getEntries() {
            return f415357b;
        }

        static {
            UrlPreViewSourceType r100 = new UrlPreViewSourceType("CHAT_ANNOUNCEMENT", 0, 1);
            CHAT_ANNOUNCEMENT = r100;
            UrlPreViewSourceType r101 = new UrlPreViewSourceType("PERSONAL_SIG", 1, 10);
            PERSONAL_SIG = r101;
            UrlPreViewSourceType r102 = new UrlPreViewSourceType("PRIVATE_DESCRIPTION", 2, 11);
            PRIVATE_DESCRIPTION = r102;
            UrlPreViewSourceType[] r103 = {r100, r101, r102};
            f415356a = r103;
            f415357b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static UrlPreViewSourceType[] values() {
            return (UrlPreViewSourceType[]) f415356a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static UrlPreViewSourceType valueOf(String r100) {
            return (UrlPreViewSourceType) r27.a.a(UrlPreViewSourceType.class, r100);
        }

        public final void setValue(int r100) {
            this.value = r100;
        }

        public UrlPreViewSourceType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UrlPreViewEntries copy$default(UrlPreViewEntries r100, String r101, String r102, UrlPreViewSourceType r103, Long r104, List r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.sourceId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.sourceTextMD5;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.sourceType;
    L11:
        UrlPreViewSourceType r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.privateDescriptionId;
    L14:
        Long r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.entryList;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.sourceId;
    }

    public final String component2() {
        return this.sourceTextMD5;
    }

    public final UrlPreViewSourceType component3() {
        return this.sourceType;
    }

    public final Long component4() {
        return this.privateDescriptionId;
    }

    public final List<UrlPreViewEntry> component5() {
        return this.entryList;
    }

    public final UrlPreViewEntries copy(String r100, String r101, UrlPreViewSourceType r110, Long r111, List<UrlPreViewEntry> r112) {
        Intrinsics.checkNotNullParameter(r101, "sourceTextMD5");
        Intrinsics.checkNotNullParameter(r112, "entryList");
        return new UrlPreViewEntries(r100, r101, r110, r111, r112);
    }

    public String toString() {
        return "UrlPreViewEntries(sourceId=" + this.sourceId + ", sourceTextMD5=" + this.sourceTextMD5 + ", sourceType=" + this.sourceType + ", privateDescriptionId=" + this.privateDescriptionId + ", entryList=" + this.entryList + ')';
    }

    public int hashCode() {
        String r100 = this.sourceId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.sourceTextMD5.hashCode()) * 31;
        UrlPreViewSourceType r104 = this.sourceType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.privateDescriptionId;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return ((r106 + r101) * 31) + this.entryList.hashCode();
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final List<UrlPreViewEntry> getEntryList() {
        return this.entryList;
    }

    public final Long getPrivateDescriptionId() {
        return this.privateDescriptionId;
    }

    public final String getSourceId() {
        return this.sourceId;
    }

    public final String getSourceTextMD5() {
        return this.sourceTextMD5;
    }

    public final UrlPreViewSourceType getSourceType() {
        return this.sourceType;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UrlPreViewEntries) == true) goto L8;
        return false;
    L8:
        UrlPreViewEntries r101 = (UrlPreViewEntries) r100;
        if (Intrinsics.areEqual(this.sourceId, r101.sourceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sourceTextMD5, r101.sourceTextMD5) == true) goto L15;
        return false;
    L15:
        if (this.sourceType == r101.sourceType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.privateDescriptionId, r101.privateDescriptionId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.entryList, r101.entryList) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public boolean isContentSame(UrlPreViewEntries r100) {
        String r101 = this.sourceId;
        Long r102 = null;
        if (r100 == null) goto L5;
        String r103 = r100.sourceId;
    L7:
        if (Intrinsics.areEqual(r101, r103) == false) goto L34;
        String r104 = this.sourceTextMD5;
        if (r100 == null) goto L11;
        String r105 = r100.sourceTextMD5;
    L13:
        if (Intrinsics.areEqual(r104, r105) == false) goto L34;
        UrlPreViewSourceType r106 = this.sourceType;
        if (r106 == null) goto L22;
        if (r100 == null) goto L18;
        UrlPreViewSourceType r107 = r100.sourceType;
    L20:
        if (r106.equals(r107) == true) goto L22;
        boolean r108 = true;
    L23:
        if (r108 == true) goto L34;
        Long r109 = this.privateDescriptionId;
        if (r100 == null) goto L28;
        r102 = r100.privateDescriptionId;
    L28:
        if (Intrinsics.areEqual(r109, r102) == false) goto L34;
        if (a.b(this.entryList, r100.entryList) == true) goto L33;
        return false;
    L33:
        return true;
    L18:
        r107 = null;
    L22:
        r108 = false;
        goto L23
    L11:
        r105 = null;
    L34:
        return false;
    L5:
        r103 = null;
        goto L7
    }

    public boolean isItemSame(UrlPreViewEntries r100) {
        String r101 = this.sourceId;
        Long r102 = null;
        if (r100 == null) goto L5;
        String r103 = r100.sourceId;
    L7:
        if (Intrinsics.areEqual(r101, r103) == false) goto L27;
        String r104 = this.sourceTextMD5;
        if (r100 == null) goto L11;
        String r105 = r100.sourceTextMD5;
    L13:
        if (Intrinsics.areEqual(r104, r105) == false) goto L27;
        UrlPreViewSourceType r106 = this.sourceType;
        if (r106 != null) goto L17;
    L19:
        boolean r107 = false;
    L20:
        if (r107 == false) goto L27;
        Long r108 = this.privateDescriptionId;
        if (r100 == null) goto L25;
        r102 = r100.privateDescriptionId;
    L25:
        if (Intrinsics.areEqual(r108, r102) == false) goto L27;
        return true;
    L17:
        if (r106.equals(r100.sourceType) != true) goto L19;
        r107 = true;
        goto L20
    L11:
        r105 = null;
    L27:
        return false;
    L5:
        r103 = null;
        goto L7
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((UrlPreViewEntries) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((UrlPreViewEntries) r100);
    }

    public UrlPreViewEntries(String r100, String r101, UrlPreViewSourceType r102, Long r103, List<UrlPreViewEntry> r104) {
        Intrinsics.checkNotNullParameter(r101, "sourceTextMD5");
        Intrinsics.checkNotNullParameter(r104, "entryList");
        this.sourceId = r100;
        this.sourceTextMD5 = r101;
        this.sourceType = r102;
        this.privateDescriptionId = r103;
        this.entryList = r104;
    }
}
