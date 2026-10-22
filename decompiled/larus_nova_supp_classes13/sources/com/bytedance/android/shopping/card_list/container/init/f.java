package com.bytedance.android.shopping.card_list.container.init;

import android.content.Context;
import android.view.View;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface f {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;
        public final Map<String, Integer> d;
        public final Map<String, Object> e;

        public b() {
            this(0);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L16;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r4.e) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            Map<String, Integer> r10 = this.d;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            Map<String, Object> r13 = this.e;
            if (r13 == null) goto L22;
            r1 = r13.hashCode();
        L22:
            return r12 + r1;
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "SDKParams(bizBtm=" + this.a + ", bizCode=" + this.b + ", sliceTemplateChannel=" + this.c + ", sliceTemplateList=" + this.d + ", abilityParams=" + this.e + ")";
        }

        public /* synthetic */ b(int r7) {
            this(null, "", "", null, MapsKt.emptyMap());
        }

        public b(String r2, String r3, String r4, Map<String, Integer> r5, Map<String, ? extends Object> r6) {
            Intrinsics.checkNotNullParameter(r3, "bizCode");
            Intrinsics.checkNotNullParameter(r4, "sliceTemplateChannel");
            Intrinsics.checkNotNullParameter(r6, "abilityParams");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    static {
        a = a.a;
    }

    void a(CardListObjectContainer r1, View r2);

    void b(CardPassThroughData r1, Function3<? super String, ? super String, ? super Map<String, String>, Unit> r2);

    void c(CardListObjectContainer r1, b r2, com.bytedance.kmp.ec.yata.view.render.delegate.v2.a r3, Function2<? super b, ? super com.bytedance.kmp.ec.yata.view.render.delegate.v2.a, Unit> r4);

    void d(Context r1);
}
