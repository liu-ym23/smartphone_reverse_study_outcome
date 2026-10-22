package com.bytedance.ee.bear.middleground.comment.export.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CommentArea {
    public boolean a;
    public boolean b;
    public Type c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentArea$Type;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "WHOLE_PAGE", "AREA", "CONTENT", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        public static final Type AREA = null;
        public static final Type CONTENT = null;
        public static final Type NONE = null;
        public static final Type WHOLE_PAGE = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("NONE", 0);
            NONE = r0;
            Type r1 = new Type("WHOLE_PAGE", 1);
            WHOLE_PAGE = r1;
            Type r3 = new Type("AREA", 2);
            AREA = r3;
            Type r5 = new Type("CONTENT", 3);
            CONTENT = r5;
            Type[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2) {
            super(r1, r2);
        }
    }

    public CommentArea() {
        this.c = Type.NONE;
    }

    public final Type getType() {
        return this.c;
    }
}
