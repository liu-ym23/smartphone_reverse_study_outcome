package com.bytedance.android.window.shop.repository.tab.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowProductCategoryVODeprecated extends f {
    public static final /* synthetic */ int k = 0;
    public final List<a> j;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/WindowProductCategoryVODeprecated$CategoryType;", "", "", "typeInt", "I", "getTypeInt", "()I", "TEXT", "IMAGE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum CategoryType extends Enum<CategoryType> {
        public static final CategoryType IMAGE = null;
        public static final CategoryType TEXT = null;
        public static final /* synthetic */ CategoryType[] a = null;
        private final int typeInt;

        static {
            CategoryType r2 = new CategoryType("TEXT", 0, 1);
            TEXT = r2;
            CategoryType r3 = new CategoryType("IMAGE", 1, 2);
            IMAGE = r3;
            a = new CategoryType[]{r2, r3};
        }

        public static CategoryType valueOf(String r1) {
            return (CategoryType) r27.a.a(CategoryType.class, r1);
        }

        public static CategoryType[] values() {
            return (CategoryType[]) a.clone();
        }

        public final int getTypeInt() {
            return this.typeInt;
        }

        public CategoryType(String r1, int r2, int r3) {
            super(r1, r2);
            this.typeInt = r3;
        }
    }

    public static class a {
        public static final CategoryType[] c = null;
        public static final C0041a d = null;
        public final String a;
        public final String b;

        /* JADX INFO: renamed from: com.bytedance.android.window.shop.repository.tab.entity.WindowProductCategoryVODeprecated$a$a, reason: collision with other inner class name */
        public static final class C0041a {
            public C0041a() {
            }
        }

        static {
            d = new C0041a();
            c = CategoryType.values();
        }

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "id");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
        public static WindowProductCategoryVODeprecated a(List r14) {
            Intrinsics.checkNotNullParameter(r14, "categoryDtoList");
            ArrayList r0 = new ArrayList();
            Iterator r15 = r14.iterator();
        L3:
            a r2 = null;
            if (r15.hasNext() == false) goto L64;
            com.bytedance.android.window.shop.repository.dto.p r1 = (com.bytedance.android.window.shop.repository.dto.p) r15.next();
            a.d.getClass();
            Intrinsics.checkNotNullParameter(r1, "dto");
            Integer r3 = r1.getType();
            boolean r4 = false;
            if (r3 != null) goto L8;
            CategoryType r5 = CategoryType.TEXT;
        L18:
            if (r5 == null) goto L61;
            int r6 = y.a[r5.ordinal()];
            if (r6 != 1) goto L23;
            int r7 = d.j;
            String r8 = r1.b();
            String r9 = r1.c();
            String r10 = r1.e();
            String r11 = r1.i();
            ECUrlModel r12 = r1.f();
            ECUrlModel r13 = r1.j();
            String r16 = r1.d();
            if (r8 != null) goto L55;
        L56:
            r4 = true;
        L57:
            if (r4 == true) goto L61;
            if (r9 == null) goto L61;
            r2 = new d(r8, r9, com.bytedance.android.ec.core.utils.s.b(r10), com.bytedance.android.ec.core.utils.s.b(r11), r12, r13, com.bytedance.android.ec.core.utils.s.b(r16));
            goto L61
        L55:
            if (StringsKt.isBlank(r8) == false) goto L57;
        L23:
            if (r6 != 2) goto L51;
            int r17 = c.g;
            String r18 = r1.b();
            String r19 = r1.c();
            ECUrlModel r20 = r1.f();
            ECUrlModel r21 = r1.j();
            if (r18 != null) goto L27;
        L30:
            boolean r22 = true;
        L31:
            if (r22 == true) goto L61;
            if (r20 == null) goto L61;
            List r23 = r20.getUrlList();
            if (r23 != null) goto L36;
        L39:
            boolean r24 = true;
        L40:
            if (r24 == true) goto L61;
            if (r21 == null) goto L61;
            List r25 = r21.getUrlList();
            if (r25 != null) goto L45;
        L46:
            r4 = true;
        L47:
            if (r4 == true) goto L61;
            r2 = new c(r18, r19, r20, r21);
            goto L61
        L45:
            if (r25.isEmpty() == false) goto L47;
        L36:
            if (r23.isEmpty() == true) goto L39;
            r24 = false;
            goto L40
        L27:
            if (StringsKt.isBlank(r18) == true) goto L30;
            r22 = false;
            goto L31
        L51:
            throw new NoWhenBranchMatchedException();
        L61:
            if (r2 == null) goto L3;
            r0.add(r2);
            goto L3
        L8:
            CategoryType[] r26 = a.c;
            int r27 = r26.length;
            int r28 = 0;
        L9:
            if (r28 >= r27) goto L17;
            CategoryType r29 = r26[r28];
            if (r29.getTypeInt() != r3.intValue()) goto L13;
            boolean r110 = true;
        L14:
            if (r110 == true) goto L15;
            r28 = r28 + 1;
            goto L9
        L15:
            r5 = r29;
            goto L18
        L13:
            r110 = false;
            goto L14
        L17:
            r5 = null;
            goto L18
        L64:
            if (r0.isEmpty() == false) goto L67;
            return null;
        L67:
            return new WindowProductCategoryVODeprecated(r0);
        }
    }

    public static final class c extends a {
        public static final /* synthetic */ int g = 0;
        public final ECUrlModel e;
        public final ECUrlModel f;

        public static final class a {
        }

        static {
        }

        public c(String r2, String r3, ECUrlModel r4, ECUrlModel r5) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r4, "selectedIconUrl");
            Intrinsics.checkNotNullParameter(r5, "unSelectedIconUrl");
            super(r2, r3);
            this.e = r4;
            this.f = r5;
        }
    }

    public static final class d extends a {
        public static final /* synthetic */ int j = 0;
        public final Integer e;
        public final Integer f;
        public final ECUrlModel g;
        public final ECUrlModel h;
        public final Integer i;

        public static final class a {
        }

        static {
        }

        public d(String r2, String r3, Integer r4, Integer r5, ECUrlModel r6, ECUrlModel r7, Integer r8) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, "name");
            super(r2, r3);
            this.e = r4;
            this.f = r5;
            this.g = r6;
            this.h = r7;
            this.i = r8;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WindowProductCategoryVODeprecated(List<? extends a> r2) {
        Intrinsics.checkNotNullParameter(r2, "categoryTypes");
        super(2511);
        this.j = r2;
    }
}
