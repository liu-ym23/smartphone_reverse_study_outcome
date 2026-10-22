package com.ss.android.lark.search.dto;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/search/dto/DataSource;", "Ljava/io/Serializable;", "<init>", "()V", "Type", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DataSource implements Serializable {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/search/dto/DataSource$Type;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNKNOWN", "RECOMMEND", "SEARCH", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> implements Serializable {
        public static final Type RECOMMEND = null;
        public static final Type SEARCH = null;
        public static final Type UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f440119a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f440120b = null;
        private final String value;

        public static EnumEntries<Type> getEntries() {
            return f440120b;
        }

        static {
            Type r100 = new Type("UNKNOWN", 0, "unknown");
            UNKNOWN = r100;
            Type r101 = new Type("RECOMMEND", 1, "recommend");
            RECOMMEND = r101;
            Type r102 = new Type("SEARCH", 2, "search");
            SEARCH = r102;
            Type[] r103 = {r100, r101, r102};
            f440119a = r103;
            f440120b = EnumEntriesKt.enumEntries(r103);
        }

        public static Type[] values() {
            return (Type[]) f440119a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        public Type(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public DataSource() {
    }
}
