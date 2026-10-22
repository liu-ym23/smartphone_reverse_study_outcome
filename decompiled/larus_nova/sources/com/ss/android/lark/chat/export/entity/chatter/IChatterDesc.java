package com.ss.android.lark.chat.export.entity.chatter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public interface IChatterDesc {
    public static final a F1 = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/export/entity/chatter/IChatterDesc$Type;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "DEFAULT", "BUSINESS", "LEAVE", "MEETING", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        public static final Type BUSINESS = null;
        public static final a Companion = null;
        public static final Type DEFAULT = null;
        public static final Type LEAVE = null;
        public static final Type MEETING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f415384a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f415385b = null;
        private final int number;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<Type> getEntries() {
            return f415385b;
        }

        static {
            Type r100 = new Type("DEFAULT", 0, 0);
            DEFAULT = r100;
            Type r101 = new Type("BUSINESS", 1, 1);
            BUSINESS = r101;
            Type r102 = new Type("LEAVE", 2, 2);
            LEAVE = r102;
            Type r103 = new Type("MEETING", 3, 3);
            MEETING = r103;
            Type[] r104 = {r100, r101, r102, r103};
            f415384a = r104;
            f415385b = EnumEntriesKt.enumEntries(r104);
            Companion = new a();
        }

        public static Type[] values() {
            return (Type[]) f415384a.clone();
        }

        public final int getNumber() {
            return this.number;
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.number = r102;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f415386a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final com.ss.android.lark.chat.export.entity.chatter.a f415387b = null;

        public a() {
        }

        static {
            f415386a = new a();
            Type r100 = Type.DEFAULT;
            Intrinsics.checkNotNullParameter(r100, "type");
            f415387b = new com.ss.android.lark.chat.export.entity.chatter.a(r100);
        }
    }

    static {
        F1 = a.f415386a;
    }

    String getContent();

    Type getType();
}
