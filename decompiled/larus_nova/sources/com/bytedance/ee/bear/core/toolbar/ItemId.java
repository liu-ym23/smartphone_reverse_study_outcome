package com.bytedance.ee.bear.core.toolbar;

import com.obric.trace.ObricActionBarTrackType;

/* JADX INFO: loaded from: classes16.dex */
public interface ItemId {

    public static final enum BusinessId extends Enum<BusinessId> implements ItemId {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BusinessId[] f217213a = null;
        public static final BusinessId insertSeparator = null;
        public static final BusinessId mention = null;

        @Override // com.bytedance.ee.bear.core.toolbar.ItemId
        public ItemId[] children() {
            return null;
        }

        static {
            BusinessId r100 = new BusinessId("mention", 0);
            mention = r100;
            BusinessId r101 = new BusinessId("insertSeparator", 1);
            insertSeparator = r101;
            f217213a = new BusinessId[]{r100, r101};
        }

        public static BusinessId[] values() {
            return (BusinessId[]) f217213a.clone();
        }

        public static BusinessId valueOf(String r100) {
            return (BusinessId) r27.a.a(BusinessId.class, r100);
        }

        public BusinessId(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum ConstId extends Enum<ConstId> implements ItemId {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ConstId[] f217214a = null;
        public static final ConstId keyboard = null;
        public static final ConstId unknown = null;

        @Override // com.bytedance.ee.bear.core.toolbar.ItemId
        public ItemId[] children() {
            return null;
        }

        static {
            ConstId r100 = new ConstId("unknown", 0);
            unknown = r100;
            ConstId r101 = new ConstId(ObricActionBarTrackType.KEY_BOARD, 1);
            keyboard = r101;
            f217214a = new ConstId[]{r100, r101};
        }

        public static ConstId[] values() {
            return (ConstId[]) f217214a.clone();
        }

        public static ConstId valueOf(String r100) {
            return (ConstId) r27.a.a(ConstId.class, r100);
        }

        public ConstId(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a extends ItemId {
    }

    ItemId[] children();

    String name();
}
