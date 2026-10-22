package com.ss.android.lark.chat.entity.chat;

import java.io.Serializable;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001:\u0001%B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003JK\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatRefDynamicRule;", "Ljava/io/Serializable;", "id", "", "ruleType", "Lcom/ss/android/lark/chat/entity/chat/ChatRefDynamicRule$RuleType;", "refId", "refName", "employeeTypes", "Ljava/util/LinkedList;", "allowAllEmployeeType", "", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chat/entity/chat/ChatRefDynamicRule$RuleType;Ljava/lang/String;Ljava/lang/String;Ljava/util/LinkedList;Z)V", "getId", "()Ljava/lang/String;", "getRuleType", "()Lcom/ss/android/lark/chat/entity/chat/ChatRefDynamicRule$RuleType;", "getRefId", "getRefName", "getEmployeeTypes", "()Ljava/util/LinkedList;", "getAllowAllEmployeeType", "()Z", "equals", "other", "", "hashCode", "", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "RuleType", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatRefDynamicRule implements Serializable {
    private final boolean allowAllEmployeeType;
    private final LinkedList<String> employeeTypes;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f415147id;
    private final String refId;
    private final String refName;
    private final RuleType ruleType;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatRefDynamicRule$RuleType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "DEPARTMENT", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RuleType extends Enum<RuleType> {
        public static final a Companion = null;
        public static final RuleType DEPARTMENT = null;
        public static final RuleType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RuleType[] f415148a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f415149b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<RuleType> getEntries() {
            return f415149b;
        }

        static {
            RuleType r100 = new RuleType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            RuleType r101 = new RuleType("DEPARTMENT", 1, 1);
            DEPARTMENT = r101;
            RuleType[] r102 = {r100, r101};
            f415148a = r102;
            f415149b = EnumEntriesKt.enumEntries(r102);
            Companion = new a();
        }

        public static RuleType[] values() {
            return (RuleType[]) f415148a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static RuleType valueOf(String r100) {
            return (RuleType) r27.a.a(RuleType.class, r100);
        }

        public RuleType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatRefDynamicRule copy$default(ChatRefDynamicRule r100, String r101, RuleType r102, String r103, String r104, LinkedList r105, boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.f415147id;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.ruleType;
    L8:
        RuleType r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.refId;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.refName;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.employeeTypes;
    L17:
        LinkedList r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.allowAllEmployeeType;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.f415147id;
    }

    public final RuleType component2() {
        return this.ruleType;
    }

    public final String component3() {
        return this.refId;
    }

    public final String component4() {
        return this.refName;
    }

    public final LinkedList<String> component5() {
        return this.employeeTypes;
    }

    public final boolean component6() {
        return this.allowAllEmployeeType;
    }

    public final ChatRefDynamicRule copy(String r100, RuleType r110, String r111, String r112, LinkedList<String> r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r110, "ruleType");
        Intrinsics.checkNotNullParameter(r111, "refId");
        Intrinsics.checkNotNullParameter(r112, "refName");
        Intrinsics.checkNotNullParameter(r113, "employeeTypes");
        return new ChatRefDynamicRule(r100, r110, r111, r112, r113, r114);
    }

    public int hashCode() {
        int r100 = ((((((((this.f415147id.hashCode() * 31) + this.ruleType.hashCode()) * 31) + this.refId.hashCode()) * 31) + this.refName.hashCode()) * 31) + this.employeeTypes.hashCode()) * 31;
        if (this.allowAllEmployeeType == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "ChatRefDynamicRule(id='" + this.f415147id + "', ruleType=" + this.ruleType + ", refId='" + this.refId + "', refName='" + this.refName + "', employeeTypes=" + this.employeeTypes + ", allowAllEmployeeType=" + this.allowAllEmployeeType + ')';
    }

    public final boolean getAllowAllEmployeeType() {
        return this.allowAllEmployeeType;
    }

    public final LinkedList<String> getEmployeeTypes() {
        return this.employeeTypes;
    }

    public final String getId() {
        return this.f415147id;
    }

    public final String getRefId() {
        return this.refId;
    }

    public final String getRefName() {
        return this.refName;
    }

    public final RuleType getRuleType() {
        return this.ruleType;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(ChatRefDynamicRule.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.chat.ChatRefDynamicRule");
        ChatRefDynamicRule r102 = (ChatRefDynamicRule) r100;
        if (Intrinsics.areEqual(this.f415147id, r102.f415147id) == true) goto L16;
        return false;
    L16:
        if (this.ruleType == r102.ruleType) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.refId, r102.refId) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.refName, r102.refName) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.employeeTypes, r102.employeeTypes) == true) goto L28;
        return false;
    L28:
        if (this.allowAllEmployeeType == r102.allowAllEmployeeType) goto L30;
        return false;
    L30:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public ChatRefDynamicRule(String r100, RuleType r101, String r102, String r103, LinkedList<String> r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "ruleType");
        Intrinsics.checkNotNullParameter(r102, "refId");
        Intrinsics.checkNotNullParameter(r103, "refName");
        Intrinsics.checkNotNullParameter(r104, "employeeTypes");
        this.f415147id = r100;
        this.ruleType = r101;
        this.refId = r102;
        this.refName = r103;
        this.employeeTypes = r104;
        this.allowAllEmployeeType = r105;
    }
}
