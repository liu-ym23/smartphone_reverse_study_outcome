package com.bytedance.ee.bear.middleground.comment.adapter;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CardAdapterHelper {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapterHelper$ItemType;", "", ResourceData.KEY_TYPE, "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "PLACEHOLDER", "QUOTE", "PART_CONTENT", "WHOLE_TEXT", "WHOLE_CONTENT", "WHOLE_INPUT", CardAdapter.REACTION, "REVISION_CONTENT", "ASIDE_NEW_INPUT", "UNKNOWN", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        public static final /* synthetic */ ItemType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int type;

        public static EnumEntries<ItemType> getEntries() {
            return b;
        }

        static {
            ItemType r0 = new ItemType("PLACEHOLDER", 0, 0);
            PLACEHOLDER = r0;
            ItemType r1 = new ItemType("QUOTE", 1, 1);
            QUOTE = r1;
            ItemType r3 = new ItemType("PART_CONTENT", 2, 2);
            PART_CONTENT = r3;
            ItemType r5 = new ItemType("WHOLE_TEXT", 3, 3);
            WHOLE_TEXT = r5;
            ItemType r7 = new ItemType("WHOLE_CONTENT", 4, 4);
            WHOLE_CONTENT = r7;
            ItemType r9 = new ItemType("WHOLE_INPUT", 5, 5);
            WHOLE_INPUT = r9;
            ItemType r11 = new ItemType(CardAdapter.REACTION, 6, 6);
            REACTION = r11;
            ItemType r13 = new ItemType("REVISION_CONTENT", 7, 7);
            REVISION_CONTENT = r13;
            ItemType r15 = new ItemType("ASIDE_NEW_INPUT", 8, 8);
            ASIDE_NEW_INPUT = r15;
            ItemType r14 = new ItemType("UNKNOWN", 9, 100);
            UNKNOWN = r14;
            ItemType[] r10 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
            a = r10;
            b = EnumEntriesKt.enumEntries(r10);
        }

        public static ItemType[] values() {
            return (ItemType[]) a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public static ItemType valueOf(String r1) {
            return (ItemType) r27.a.a(ItemType.class, r1);
        }

        public ItemType(String r1, int r2, int r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    static {
    }
}
