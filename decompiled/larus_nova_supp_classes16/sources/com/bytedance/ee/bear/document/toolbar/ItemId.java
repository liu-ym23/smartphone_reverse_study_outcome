package com.bytedance.ee.bear.document.toolbar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface ItemId {

    public static final enum BusinessId extends Enum<BusinessId> implements ItemId {
        public static final /* synthetic */ BusinessId[] a = null;
        public static final BusinessId insertSeparator = null;
        public static final BusinessId mention = null;

        @Override // com.bytedance.ee.bear.document.toolbar.ItemId
        public ItemId[] children() {
            return null;
        }

        static {
            BusinessId r0 = new BusinessId("mention", 0);
            mention = r0;
            BusinessId r1 = new BusinessId("insertSeparator", 1);
            insertSeparator = r1;
            a = new BusinessId[]{r0, r1};
        }

        public static BusinessId[] values() {
            return (BusinessId[]) a.clone();
        }

        public static BusinessId valueOf(String r1) {
            return (BusinessId) r27.a.a(BusinessId.class, r1);
        }

        public BusinessId(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum ConstId extends Enum<ConstId> implements ItemId {
        public static final /* synthetic */ ConstId[] a = null;
        public static final ConstId keyboard = null;
        public static final ConstId unknown = null;

        @Override // com.bytedance.ee.bear.document.toolbar.ItemId
        public ItemId[] children() {
            return null;
        }

        static {
            ConstId r0 = new ConstId("unknown", 0);
            unknown = r0;
            ConstId r1 = new ConstId("keyboard", 1);
            keyboard = r1;
            a = new ConstId[]{r0, r1};
        }

        public static ConstId[] values() {
            return (ConstId[]) a.clone();
        }

        public static ConstId valueOf(String r1) {
            return (ConstId) r27.a.a(ConstId.class, r1);
        }

        public ConstId(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a extends ItemId {
    }

    ItemId[] children();

    String name();
}
