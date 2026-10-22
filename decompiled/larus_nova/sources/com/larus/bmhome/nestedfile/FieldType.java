package com.larus.bmhome.nestedfile;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/nestedfile/FieldType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "STATE_UNKNOWN", "REVIEW_STATE", "PARSE_STATE", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FieldType extends Enum<FieldType> {
    public static final a Companion = null;
    public static final FieldType PARSE_STATE = null;
    public static final FieldType REVIEW_STATE = null;
    public static final FieldType STATE_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FieldType[] f313403a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f313404b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static FieldType a(Integer r100) {
            FieldType[] r101 = FieldType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L14;
            FieldType r104 = r101[r103];
            int r105 = r104.getValue();
            if (r100 != null) goto L8;
        L10:
            boolean r106 = false;
        L11:
            if (r106 == true) goto L15;
            r103 = r103 + 1;
        L15:
            if (r104 == null) goto L17;
            return r104;
        L17:
            return FieldType.STATE_UNKNOWN;
        L8:
            if (r105 != r100.intValue()) goto L10;
            r106 = true;
            goto L11
        L14:
            r104 = null;
            goto L15
        }
    }

    public static EnumEntries<FieldType> getEntries() {
        return f313404b;
    }

    static {
        FieldType r100 = new FieldType("STATE_UNKNOWN", 0, 0);
        STATE_UNKNOWN = r100;
        FieldType r101 = new FieldType("REVIEW_STATE", 1, 1);
        REVIEW_STATE = r101;
        FieldType r102 = new FieldType("PARSE_STATE", 2, 2);
        PARSE_STATE = r102;
        FieldType[] r103 = {r100, r101, r102};
        f313403a = r103;
        f313404b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static FieldType[] values() {
        return (FieldType[]) f313403a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FieldType valueOf(String r100) {
        return (FieldType) r27.a.a(FieldType.class, r100);
    }

    public FieldType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
