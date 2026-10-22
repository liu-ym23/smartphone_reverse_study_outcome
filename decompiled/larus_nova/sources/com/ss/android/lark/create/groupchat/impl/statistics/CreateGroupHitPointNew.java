package com.ss.android.lark.create.groupchat.impl.statistics;

import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;
import s5c.d;

/* JADX INFO: loaded from: classes35.dex */
public final class CreateGroupHitPointNew {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f420247a = 0;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/create/groupchat/impl/statistics/CreateGroupHitPointNew$TextType;", "Lcom/ss/android/lark/statistics/extensions/IParam;", "", "value", "", "key", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "getKey", "INPLUS", "ADD_MEMBER", "create-group-chat-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TextType extends Enum<TextType> implements d {
        public static final TextType ADD_MEMBER = null;
        public static final TextType INPLUS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TextType[] f420248a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f420249b = null;
        private final String key;
        private final String value;

        public TextType() {
            throw null;
        }

        public static EnumEntries<TextType> getEntries() {
            return f420249b;
        }

        static {
            TextType r100 = new TextType("INPLUS", 0, "inplus", null, 2, null);
            INPLUS = r100;
            TextType r101 = new TextType("ADD_MEMBER", 1, "add_member", null, 2, null);
            ADD_MEMBER = r101;
            TextType[] r102 = {r100, r101};
            f420248a = r102;
            f420249b = EnumEntriesKt.enumEntries(r102);
        }

        public static TextType[] values() {
            return (TextType[]) f420248a.clone();
        }

        @Override // s5c.d
        public JSONObject toJson() {
            return d.b.c(this);
        }

        @Override // s5c.d
        public String getKey() {
            return this.key;
        }

        @Override // s5c.d
        public String getValue() {
            return this.value;
        }

        public static TextType valueOf(String r100) {
            return (TextType) r27.a.a(TextType.class, r100);
        }

        @Override // s5c.d
        public d plus(Map<String, ? extends Object> r100) {
            return d.b.a(this, r100);
        }

        @Override // s5c.d
        public d plus(d r100) {
            return d.b.b(this, r100);
        }

        public TextType(String r100, int r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 2) == 0) goto L5;
            r103 = com.bytedance.android.ec.core.event.a.KEY_TEXT_TYPE;
        L5:
            super(r100, r101);
            this.value = r102;
            this.key = r103;
        }
    }

    public static final class a {
    }

    static {
    }
}
