package com.bytedance.ee.bear.middleground.comment.adapter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
public final class CardAdapterHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f230258a = 0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapterHelper$ItemType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "PLACEHOLDER", "QUOTE", "PART_CONTENT", "WHOLE_TEXT", "WHOLE_CONTENT", "WHOLE_INPUT", CardAdapter.REACTION, "REVISION_CONTENT", "ASIDE_NEW_INPUT", "UNKNOWN", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ItemType extends Enum<ItemType> {
        public static final ItemType ASIDE_NEW_INPUT = null;
        public static final ItemType PART_CONTENT = null;
        public static final ItemType PLACEHOLDER = null;
        public static final ItemType QUOTE = null;
        public static final ItemType REACTION = null;
        public static final ItemType REVISION_CONTENT = null;
        public static final ItemType UNKNOWN = null;
        public static final ItemType WHOLE_CONTENT = null;
        public static final ItemType WHOLE_INPUT = null;
        public static final ItemType WHOLE_TEXT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ItemType[] f230259a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f230260b = null;
        private final int type;

        public static EnumEntries<ItemType> getEntries() {
            return f230260b;
        }

        static {
            ItemType r100 = new ItemType("PLACEHOLDER", 0, 0);
            PLACEHOLDER = r100;
            ItemType r101 = new ItemType("QUOTE", 1, 1);
            QUOTE = r101;
            ItemType r102 = new ItemType("PART_CONTENT", 2, 2);
            PART_CONTENT = r102;
            ItemType r103 = new ItemType("WHOLE_TEXT", 3, 3);
            WHOLE_TEXT = r103;
            ItemType r104 = new ItemType("WHOLE_CONTENT", 4, 4);
            WHOLE_CONTENT = r104;
            ItemType r105 = new ItemType("WHOLE_INPUT", 5, 5);
            WHOLE_INPUT = r105;
            ItemType r110 = new ItemType(CardAdapter.REACTION, 6, 6);
            REACTION = r110;
            ItemType r111 = new ItemType("REVISION_CONTENT", 7, 7);
            REVISION_CONTENT = r111;
            ItemType r112 = new ItemType("ASIDE_NEW_INPUT", 8, 8);
            ASIDE_NEW_INPUT = r112;
            ItemType r113 = new ItemType("UNKNOWN", 9, 100);
            UNKNOWN = r113;
            ItemType[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
            f230259a = r114;
            f230260b = EnumEntriesKt.enumEntries(r114);
        }

        public static ItemType[] values() {
            return (ItemType[]) f230259a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public static ItemType valueOf(String r100) {
            return (ItemType) r27.a.a(ItemType.class, r100);
        }

        public ItemType(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    static {
    }
}
