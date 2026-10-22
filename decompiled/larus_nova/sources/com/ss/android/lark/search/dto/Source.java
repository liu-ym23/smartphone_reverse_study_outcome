package com.ss.android.lark.search.dto;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/search/dto/Source;", "Ljava/io/Serializable;", "<init>", "()V", "Type", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Source implements Serializable {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/search/dto/Source$Type;", "Ljava/io/Serializable;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "UNKNOWN", "RECOMMEND", "SEARCH", "FORWARD", "Companion", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> implements Serializable {
        public static final a Companion = null;
        public static final Type FORWARD = null;
        public static final Type RECOMMEND = null;
        public static final Type SEARCH = null;
        public static final Type UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f440126a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f440127b = null;
        private final int number;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<Type> getEntries() {
            return f440127b;
        }

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("RECOMMEND", 1, 1);
            RECOMMEND = r101;
            Type r102 = new Type("SEARCH", 2, 2);
            SEARCH = r102;
            Type r103 = new Type("FORWARD", 3, 3);
            FORWARD = r103;
            Type[] r104 = {r100, r101, r102, r103};
            f440126a = r104;
            f440127b = EnumEntriesKt.enumEntries(r104);
            Companion = new a();
        }

        public static Type[] values() {
            return (Type[]) f440126a.clone();
        }

        public final int getNumber() {
            return this.number;
        }

        @JvmStatic
        public static final Type valueOf(int r100) {
            Companion.getClass();
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L15;
            if (r100 == 3) goto L14;
            return UNKNOWN;
        L14:
            return FORWARD;
        L15:
            return SEARCH;
        L12:
            return RECOMMEND;
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.number = r102;
        }
    }

    public Source() {
    }
}
