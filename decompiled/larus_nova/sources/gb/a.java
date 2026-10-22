package gb;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f480642a = 0;

    /* JADX INFO: renamed from: gb.a$a, reason: collision with other inner class name */
    public static final class C6000a {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lgb/a$b;", "", "", "Lgb/b;", "block", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("expression")
        private final List<gb.b> block;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.block, ((b) r100).block) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            List<gb.b> r100 = this.block;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "ConditionBlock(block=" + this.block + ')';
        }

        public b() {
            this.block = null;
        }

        public final List<gb.b> a() {
            return this.block;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f¨\u0006\u0011"}, d2 = {"Lgb/a$c;", "", "", "Lgb/b;", "expression", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lgb/a$b;", "ifBlock", "Lgb/a$b;", "c", "()Lgb/a$b;", "elseBlock", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "thenBlock", "d", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("else")
        private final b elseBlock;

        @SerializedName("expression")
        private final List<gb.b> expression;

        @SerializedName("if")
        private final b ifBlock;

        @SerializedName("then")
        private final b thenBlock;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.expression, r101.expression) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.ifBlock, r101.ifBlock) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.elseBlock, r101.elseBlock) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.thenBlock, r101.thenBlock) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            List<gb.b> r100 = this.expression;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            b r104 = this.ifBlock;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            b r107 = this.elseBlock;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            b r110 = this.thenBlock;
            if (r110 == null) goto L19;
            r101 = r110.hashCode();
        L19:
            return r109 + r101;
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "HighExec(expression=" + this.expression + ", ifBlock=" + this.ifBlock + ", elseBlock=" + this.elseBlock + ", thenBlock=" + this.thenBlock + ')';
        }

        public c() {
            this.expression = null;
            this.ifBlock = null;
            this.elseBlock = null;
            this.thenBlock = null;
        }

        public final b a() {
            return this.elseBlock;
        }

        public final List<gb.b> b() {
            return this.expression;
        }

        public final b c() {
            return this.ifBlock;
        }

        public final b d() {
            return this.thenBlock;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lgb/a$d;", "", "", com.alipay.sdk.m.p.e.f25671s, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "params", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "Lgb/a$c;", "highExec", "Lgb/a$c;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lgb/a$c;", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        @SerializedName("callback")
        private final c highExec;

        @SerializedName(com.alipay.sdk.m.p.e.f25671s)
        private final String method;

        @SerializedName("params")
        private final Map<String, Object> params;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.method, r101.method) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.params, r101.params) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.highExec, r101.highExec) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r100 = this.method;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Map<String, Object> r104 = this.params;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            c r107 = this.highExec;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "JSBAction(method=" + this.method + ", params=" + this.params + ", highExec=" + this.highExec + ')';
        }

        public d() {
            this.method = null;
            this.params = null;
            this.highExec = null;
        }

        public final c a() {
            return this.highExec;
        }

        public final String b() {
            return this.method;
        }

        public final Map<String, Object> c() {
            return this.params;
        }
    }

    static {
    }
}
