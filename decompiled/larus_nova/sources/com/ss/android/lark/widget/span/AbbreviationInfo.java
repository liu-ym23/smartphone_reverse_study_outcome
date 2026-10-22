package com.ss.android.lark.widget.span;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public class AbbreviationInfo extends TextStyleInfo {
    public AbbreviationType bizType;
    public String chatId;
    public String desc;
    public Serializable extra;
    public String fullName;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public String f448571id;
    public int intervalOff;
    public int intervalOn;
    public String messageId;
    public String name;

    public static final enum AbbreviationType extends Enum<AbbreviationType> {
        public static final AbbreviationType BAIKE = null;
        public static final AbbreviationType CALENDAR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AbbreviationType[] f448572a = null;

        static {
            AbbreviationType r100 = new AbbreviationType("BAIKE", 0);
            BAIKE = r100;
            AbbreviationType r101 = new AbbreviationType("CALENDAR", 1);
            CALENDAR = r101;
            f448572a = new AbbreviationType[]{r100, r101};
        }

        public static AbbreviationType[] values() {
            return (AbbreviationType[]) f448572a.clone();
        }

        public static AbbreviationType valueOf(String r100) {
            return (AbbreviationType) r27.a.a(AbbreviationType.class, r100);
        }

        public AbbreviationType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // com.ss.android.lark.widget.span.TextStyleInfo, com.ss.android.lark.widget.span.SpanInfo
    public int hashCode() {
        return Objects.hash(new Object[]{this.f448571id, this.name, this.desc, this.fullName, this.chatId, this.messageId, Integer.valueOf(this.intervalOn), Integer.valueOf(this.intervalOff), this.bizType});
    }

    public AbbreviationInfo() {
        this.bizType = AbbreviationType.BAIKE;
        this.intervalOn = -1;
        this.intervalOff = -1;
    }

    @Override // com.ss.android.lark.widget.span.TextStyleInfo, com.ss.android.lark.widget.span.SpanInfo
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AbbreviationInfo) == true) goto L8;
        return false;
    L8:
        AbbreviationInfo r101 = (AbbreviationInfo) r100;
        if (Objects.equals(this.f448571id, r101.f448571id) == true) goto L11;
    L27:
        return false;
    L11:
        if (Objects.equals(this.name, r101.name) == false) goto L27;
        if (Objects.equals(this.desc, r101.desc) == false) goto L27;
        if (Objects.equals(this.fullName, r101.fullName) == false) goto L27;
        if (Objects.equals(this.chatId, r101.chatId) == false) goto L27;
        if (Objects.equals(this.messageId, r101.messageId) == false) goto L27;
        if (Objects.equals(Integer.valueOf(this.intervalOn), Integer.valueOf(r101.intervalOn)) == false) goto L27;
        if (Objects.equals(Integer.valueOf(this.intervalOff), Integer.valueOf(r101.intervalOff)) == false) goto L27;
        if (Objects.equals(this.bizType, r101.bizType) == false) goto L27;
        return true;
    }
}
