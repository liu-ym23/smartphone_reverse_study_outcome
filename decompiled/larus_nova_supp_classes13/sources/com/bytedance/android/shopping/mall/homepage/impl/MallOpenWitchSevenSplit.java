package com.bytedance.android.shopping.mall.homepage.impl;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class MallOpenWitchSevenSplit implements cf3.a {
    public final Lazy a;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.impl.MallOpenWitchSevenSplit$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000eR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/impl/MallOpenWitchSevenSplit$a$a;", "", "", "", "schemaRelaxCondition", "Ljava/util/List;", "b", "()Ljava/util/List;", "setSchemaRelaxCondition", "(Ljava/util/List;)V", "schemaStrictCondition", "c", "setSchemaStrictCondition", "schemaInnerCondition", "a", "setSchemaInnerCondition", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class C0101a {

            @SerializedName("schema_inner_condition")
            private List<String> schemaInnerCondition;

            @SerializedName("schema_relax_condition")
            private List<String> schemaRelaxCondition;

            @SerializedName("schema_strict_condition")
            private List<String> schemaStrictCondition;

            /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.impl.MallOpenWitchSevenSplit$a$a$a, reason: collision with other inner class name */
            public static final class C0102a {
            }

            static {
            }

            public C0101a() {
                this(null);
            }

            public final boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof C0101a) == false) goto L12;
                C0101a r4 = (C0101a) r3;
                if (Intrinsics.areEqual(this.schemaRelaxCondition, r4.schemaRelaxCondition) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.schemaStrictCondition, r4.schemaStrictCondition) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.schemaInnerCondition, r4.schemaInnerCondition) == true) goto L19;
                return false;
            L19:
                return true;
            L12:
                return false;
            }

            public final int hashCode() {
                List<String> r0 = this.schemaRelaxCondition;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                List<String> r4 = this.schemaStrictCondition;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                List<String> r7 = this.schemaInnerCondition;
                if (r7 == null) goto L14;
                r1 = r7.hashCode();
            L14:
                return r6 + r1;
            L9:
                r5 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            public final String toString() {
                return "MallSevenSplitOpenCondition(schemaRelaxCondition=" + this.schemaRelaxCondition + ", schemaStrictCondition=" + this.schemaStrictCondition + ", schemaInnerCondition=" + this.schemaInnerCondition + ")";
            }

            public final List<String> a() {
                return this.schemaInnerCondition;
            }

            public final List<String> b() {
                return this.schemaRelaxCondition;
            }

            public final List<String> c() {
                return this.schemaStrictCondition;
            }

            public C0101a(Object r1) {
                this.schemaRelaxCondition = null;
                this.schemaStrictCondition = null;
                this.schemaInnerCondition = null;
            }
        }
    }

    static {
    }

    public MallOpenWitchSevenSplit() {
        this.a = LazyKt.lazy(MallOpenWitchSevenSplit$settingConfig$2.INSTANCE);
    }

    @Override // cf3.a
    public final boolean a(String r7) {
        Intrinsics.checkNotNullParameter(r7, "schema");
        List<String> r0 = ((a.C0101a) this.a.getValue()).b();
        String r1 = null;
        if (r0 == null) goto L10;
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        if (StringsKt.contains$default(r7, (String) r2.next(), false, 2, null) == false) goto L6;
        return true;
    L10:
        List<String> r3 = ((a.C0101a) this.a.getValue()).c();
        if (r3 != null) goto L13;
    L15:
        List<String> r4 = ((a.C0101a) this.a.getValue()).a();
        if (r4 != null) goto L35;
    L34:
        return false;
    L35:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L28
        Uri r8 = UriProtector.parse(r7);     // Catch: Throwable -> L28
        if (r8 == null) goto L25;
        String r6 = UriProtector.getQueryParameter(r8, "url");     // Catch: Throwable -> L28
        if (r6 == null) goto L22;
    L21:
        r1 = r6;
    L30:
        if (r1 == null) goto L34;
        if (b(r1, r4) == false) goto L34;
        return true;
    L22:
        r6 = UriProtector.getQueryParameter(r8, "surl");     // Catch: Throwable -> L28
        if (r6 != null) goto L21;
    L26:
        Result.constructor-impl(r8);     // Catch: Throwable -> L28
        goto L30
    L25:
        r8 = null;
    L28:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    L13:
        if (b(r7, r3) == false) goto L15;
        return true;
    }

    public static boolean b(String r3, List r4) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L20
        Uri r5 = UriProtector.parse(r3);     // Catch: Throwable -> L20
        if (r5 == null) goto L17;
        Iterator r6 = r4.iterator();     // Catch: Throwable -> L20
    L7:
        if (r6.hasNext() == false) goto L18;
        String r2 = UriProtector.getQueryParameter(r5, (String) r6.next());     // Catch: Throwable -> L20
        if (r2 != null) goto L11;
    L14:
        boolean r7 = true;
    L15:
        if (r7 == true) goto L7;
        return true;
    L11:
        if (r2.length() == 0) goto L14;
        r7 = false;
    L18:
        Result.constructor-impl(r5);     // Catch: Throwable -> L20
    L22:
        return false;
    L17:
        r5 = null;
    L20:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }
}
