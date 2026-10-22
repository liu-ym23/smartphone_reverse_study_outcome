package o47;

import com.amap.api.col.s.ce;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
public interface a {

    /* JADX INFO: renamed from: o47.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lo47/a$a;", "", "", "maxAge", "Ljava/lang/Number;", "c", "()Ljava/lang/Number;", "", "version", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "Lcom/google/gson/JsonObject;", "meta", "Lcom/google/gson/JsonObject;", "d", "()Lcom/google/gson/JsonObject;", "expire", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "f", "(Ljava/lang/Number;)V", "", "marked", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", ce.f26391f, "(Ljava/lang/Boolean;)V", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final class C7013a {

        @SerializedName("expire")
        private Number expire;

        @SerializedName("marked")
        private Boolean marked;

        @SerializedName("maxAge")
        private final Number maxAge;

        @SerializedName("meta")
        private final JsonObject meta;

        @SerializedName("version")
        private final String version;

        /* JADX INFO: renamed from: o47.a$a$a, reason: collision with other inner class name */
        public static final class C7014a {
        }

        static {
        }

        public final JsonObject h() {
            JsonObject r100 = new JsonObject();
            Number r101 = this.maxAge;
            if (r101 == null) goto L5;
            r100.addProperty("maxAge", r101);
        L5:
            String r102 = this.version;
            if (r102 == null) goto L8;
            r100.addProperty("version", r102);
        L8:
            Number r103 = this.expire;
            if (r103 == null) goto L11;
            r100.addProperty("expire", r103);
        L11:
            JsonObject r104 = this.meta;
            if (r104 == null) goto L14;
            r100.add("meta", r104);
        L14:
            Boolean r105 = this.marked;
            if (r105 == null) goto L17;
            r105.booleanValue();
            r100.addProperty("marked", this.marked);
        L17:
            return r100;
        }

        public C7013a() {
            this.maxAge = null;
            this.version = null;
            this.meta = null;
            this.expire = null;
            this.marked = null;
        }

        public final String toString() {
            return h().toString();
        }

        public final Number a() {
            return this.expire;
        }

        public final Boolean b() {
            return this.marked;
        }

        public final Number c() {
            return this.maxAge;
        }

        public final JsonObject d() {
            return this.meta;
        }

        public final String e() {
            return this.version;
        }

        public final void f(Number r100) {
            this.expire = r100;
        }

        public final void g(Boolean r100) {
            this.marked = r100;
        }
    }

    C7013a a();

    String b();

    String c();
}
