package com.ss.android.lark.biz.im.api.param;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final class Params {

    public static final enum ReferType extends Enum<ReferType> {
        public static final ReferType Docs = null;
        public static final ReferType LarkMine = null;
        public static final ReferType VideoChat = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ReferType[] f410436a = null;
        private String name;

        static {
            ReferType r100 = new ReferType("LarkMine", 0, "suite");
            LarkMine = r100;
            ReferType r101 = new ReferType("Docs", 1, "doc");
            Docs = r101;
            ReferType r102 = new ReferType("VideoChat", 2, ThumbGlideUrl.SOURCE_VC);
            VideoChat = r102;
            f410436a = new ReferType[]{r100, r101, r102};
        }

        public static ReferType[] values() {
            return (ReferType[]) f410436a.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }

        public static ReferType valueOf(String r100) {
            return (ReferType) a.a(ReferType.class, r100);
        }

        public ReferType(String r100, int r101, String r102) {
            super(r100, r101);
            this.name = r102;
        }
    }

    public Params() {
    }
}
