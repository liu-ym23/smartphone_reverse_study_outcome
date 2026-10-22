package com.bytedance.android.window.shop.repository.tab.entity;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowChildCategoryVO {
    public static final /* synthetic */ int b = 0;
    public final List<ChildCategoryVO> a;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B+\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryItemVO;", "Ljava/io/Serializable;", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryTextVO;", "prefix", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryTextVO;", "getPrefix", "()Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryTextVO;", "title", "getTitle", "suffix", "getSuffix", "", "bgColor", "I", "getBgColor", "()I", "<init>", "(Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryTextVO;Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryTextVO;Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryTextVO;I)V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ChildCategoryItemVO implements Serializable {
        public static final a Companion = null;
        private final int bgColor;
        private final ChildCategoryTextVO prefix;
        private final ChildCategoryTextVO suffix;
        private final ChildCategoryTextVO title;

        public static final class a {
            public a() {
            }

            public static ChildCategoryItemVO a(b r4) {
                if (r4 != null) goto L5;
                return null;
            L5:
                ChildCategoryTextVO.a r1 = ChildCategoryTextVO.Companion;
                c r2 = r4.d();
                r1.getClass();
                ChildCategoryTextVO r3 = ChildCategoryTextVO.a.a(r2);
                if (r3 != null) goto L8;
                return null;
            L8:
                int r5 = com.bytedance.android.ec.core.utils.s.a;
                Integer r6 = com.bytedance.android.ec.core.utils.s.b(r4.a());
                if (r6 == null) goto L12;
                int r0 = r6.intValue();
                return new ChildCategoryItemVO(ChildCategoryTextVO.a.a(r4.b()), r3, ChildCategoryTextVO.a.a(r4.c()), r0);
            L12:
                return null;
            }
        }

        static {
            Companion = new a();
        }

        public final int getBgColor() {
            return this.bgColor;
        }

        public final ChildCategoryTextVO getPrefix() {
            return this.prefix;
        }

        public final ChildCategoryTextVO getSuffix() {
            return this.suffix;
        }

        public final ChildCategoryTextVO getTitle() {
            return this.title;
        }

        public ChildCategoryItemVO(ChildCategoryTextVO r2, ChildCategoryTextVO r3, ChildCategoryTextVO r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "title");
            this.prefix = r2;
            this.title = r3;
            this.suffix = r4;
            this.bgColor = r5;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryTextVO;", "Ljava/io/Serializable;", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "", "textColor", "I", "getTextColor", "()I", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ChildCategoryTextVO implements Serializable {
        public static final a Companion = null;
        private final String text;
        private final int textColor;

        public static final class a {
            public a() {
            }

            public static ChildCategoryTextVO a(c r3) {
                if (r3 != null) goto L5;
                return null;
            L5:
                String r1 = r3.b();
                if (r1 != null) goto L8;
                return null;
            L8:
                int r2 = com.bytedance.android.ec.core.utils.s.a;
                Integer r4 = com.bytedance.android.ec.core.utils.s.b(r3.a());
                if (r4 != null) goto L11;
                return null;
            L11:
                return new ChildCategoryTextVO(r1, r4.intValue());
            }
        }

        static {
            Companion = new a();
        }

        public final String getText() {
            return this.text;
        }

        public final int getTextColor() {
            return this.textColor;
        }

        public ChildCategoryTextVO(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "text");
            this.text = r2;
            this.textColor = r3;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryVO;", "Ljava/io/Serializable;", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryItemVO;", "selectedItem", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryItemVO;", "getSelectedItem", "()Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryItemVO;", "unselectedItem", "getUnselectedItem", "", "selected", "Z", "getSelected", "()Z", "setSelected", "(Z)V", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "<init>", "(Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryItemVO;Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryItemVO;ZLjava/lang/String;)V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ChildCategoryVO implements Serializable {
        public static final a Companion = null;
        private final String id;
        private boolean selected;
        private final ChildCategoryItemVO selectedItem;
        private final ChildCategoryItemVO unselectedItem;

        public static final class a {
            public a() {
            }
        }

        static {
            Companion = new a();
        }

        public final String getId() {
            return this.id;
        }

        public final boolean getSelected() {
            return this.selected;
        }

        public final ChildCategoryItemVO getSelectedItem() {
            return this.selectedItem;
        }

        public final ChildCategoryItemVO getUnselectedItem() {
            return this.unselectedItem;
        }

        public final void setSelected(boolean r1) {
            this.selected = r1;
        }

        public ChildCategoryVO(ChildCategoryItemVO r2, ChildCategoryItemVO r3, boolean r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "selectedItem");
            Intrinsics.checkNotNullParameter(r3, "unselectedItem");
            Intrinsics.checkNotNullParameter(r5, "id");
            this.selectedItem = r2;
            this.unselectedItem = r3;
            this.selected = r4;
            this.id = r5;
        }
    }

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof WindowChildCategoryVO) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((WindowChildCategoryVO) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<ChildCategoryVO> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "WindowChildCategoryVO(subCategoryVO=" + this.a + ")";
    }

    public WindowChildCategoryVO(List<ChildCategoryVO> r2) {
        Intrinsics.checkNotNullParameter(r2, "subCategoryVO");
        this.a = r2;
    }
}
