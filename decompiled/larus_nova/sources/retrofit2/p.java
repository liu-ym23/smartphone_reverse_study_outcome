package retrofit2;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import kotlin.UByte;
import okhttp3.Headers;
import okhttp3.RequestBody;
import okio.Buffer;

/* JADX INFO: loaded from: classes41.dex */
public abstract class p<T> {

    public static final class a<T> extends p<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final retrofit2.g<T, RequestBody> f537524a;

        public a(retrofit2.g<T, RequestBody> r100) {
            this.f537524a = r100;
        }

        @Override // retrofit2.p
        public final void a(r r100, @Nullable T r101) {
            if (r101 == null) goto L10;
            r100.f537561j = this.f537524a.convert(r101);
            return;
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r101 + " to RequestBody", e);
        L10:
            throw new IllegalArgumentException("Body parameter value must not be null.");
        }
    }

    public static final class b<T> extends p<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f537525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final retrofit2.g<T, String> f537526b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f537527c;

        @Override // retrofit2.p
        public final void a(r r100, @Nullable T r101) throws IOException {
            if (r101 != null) goto L4;
            return;
        L4:
            String r102 = this.f537526b.convert(r101);
            if (r102 != null) goto L7;
            return;
        L7:
            String r103 = this.f537525a;
            if (this.f537527c == false) goto L10;
            r100.f537560i.addEncoded(r103, r102);
            return;
        L10:
            r100.f537560i.add(r103, r102);
        }

        public b(String r100, retrofit2.g<T, String> r101, boolean r102) {
            u.a(r100, "name == null");
            this.f537525a = r100;
            this.f537526b = r101;
            this.f537527c = r102;
        }
    }

    public static final class c<T> extends p<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final retrofit2.g<T, String> f537528a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f537529b;

        public c(retrofit2.g<T, String> r100, boolean r101) {
            this.f537528a = r100;
            this.f537529b = r101;
        }

        @Override // retrofit2.p
        public final void a(r r100, @Nullable Object r101) throws IOException {
            Map r102 = (Map) r101;
            if (r102 == null) goto L25;
            Iterator r103 = r102.entrySet().iterator();
        L6:
            if (r103.hasNext() == false) goto L23;
            Map.Entry r104 = (Map.Entry) r103.next();
            String r105 = (String) r104.getKey();
            if (r105 == null) goto L22;
            Object r106 = r104.getValue();
            if (r106 == null) goto L20;
            String r107 = this.f537528a.convert((T) r106);
            if (r107 == null) goto L18;
            if (this.f537529b == true) goto L15;
            r100.f537560i.add(r105, r107);
            goto L6
        L15:
            r100.f537560i.addEncoded(r105, r107);
            goto L6
        L18:
            throw new IllegalArgumentException("Field map value '" + r106 + "' converted to null by " + this.f537528a.getClass().getName() + " for key '" + r105 + "'.");
        L20:
            throw new IllegalArgumentException("Field map contained null value for key '" + r105 + "'.");
        L22:
            throw new IllegalArgumentException("Field map contained null key.");
        L23:
            return;
        L25:
            throw new IllegalArgumentException("Field map was null.");
        }
    }

    public static final class d<T> extends p<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f537530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final retrofit2.g<T, String> f537531b;

        public d(String r100, retrofit2.g<T, String> r101) {
            u.a(r100, "name == null");
            this.f537530a = r100;
            this.f537531b = r101;
        }

        @Override // retrofit2.p
        public final void a(r r100, @Nullable T r101) throws IOException {
            if (r101 != null) goto L4;
            return;
        L4:
            String r102 = this.f537531b.convert(r101);
            if (r102 != null) goto L7;
            return;
        L7:
            r100.a(this.f537530a, r102);
        }
    }

    public static final class e<T> extends p<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final retrofit2.g<T, String> f537532a;

        public e(retrofit2.g<T, String> r100) {
            this.f537532a = r100;
        }

        @Override // retrofit2.p
        public final void a(r r100, @Nullable Object r101) throws IOException {
            Map r102 = (Map) r101;
            if (r102 == null) goto L18;
            Iterator r103 = r102.entrySet().iterator();
        L6:
            if (r103.hasNext() == false) goto L16;
            Map.Entry r104 = (Map.Entry) r103.next();
            String r105 = (String) r104.getKey();
            if (r105 == null) goto L15;
            Object r106 = r104.getValue();
            if (r106 == null) goto L13;
            r100.a(r105, this.f537532a.convert((T) r106));
            goto L6
        L13:
            throw new IllegalArgumentException("Header map contained null value for key '" + r105 + "'.");
        L15:
            throw new IllegalArgumentException("Header map contained null key.");
        L16:
            return;
        L18:
            throw new IllegalArgumentException("Header map was null.");
        }
    }

    public static final class f<T> extends p<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Headers f537533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final retrofit2.g<T, RequestBody> f537534b;

        public f(Headers r100, retrofit2.g<T, RequestBody> r101) {
            this.f537533a = r100;
            this.f537534b = r101;
        }

        @Override // retrofit2.p
        public final void a(r r100, @Nullable T r101) {
            if (r101 != null) goto L10;
            return;
        L10:
            RequestBody r102 = this.f537534b.convert(r101);     // Catch: IOException -> L7
            Headers r103 = this.f537533a;
            okhttp3.k.a r104 = r100.f537559h;
            r104.getClass();
            r104.c(okhttp3.k.b.a(r103, r102));
            return;
        L7:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r101 + " to RequestBody", e);
        }
    }

    public static final class g<T> extends p<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final retrofit2.g<T, RequestBody> f537535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f537536b;

        public g(retrofit2.g<T, RequestBody> r100, String r101) {
            this.f537535a = r100;
            this.f537536b = r101;
        }

        @Override // retrofit2.p
        public final void a(r r100, @Nullable Object r101) throws IOException {
            Map r102 = (Map) r101;
            if (r102 == null) goto L18;
            Iterator r103 = r102.entrySet().iterator();
        L6:
            if (r103.hasNext() == false) goto L16;
            Map.Entry r104 = (Map.Entry) r103.next();
            String r105 = (String) r104.getKey();
            if (r105 == null) goto L15;
            Object r106 = r104.getValue();
            if (r106 == null) goto L13;
            Headers r107 = Headers.of(new String[]{"Content-Disposition", "form-data; name=\"" + r105 + "\"", "Content-Transfer-Encoding", this.f537536b});
            RequestBody r108 = this.f537535a.convert((T) r106);
            okhttp3.k.a r109 = r100.f537559h;
            r109.getClass();
            r109.c(okhttp3.k.b.a(r107, r108));
            goto L6
        L13:
            throw new IllegalArgumentException("Part map contained null value for key '" + r105 + "'.");
        L15:
            throw new IllegalArgumentException("Part map contained null key.");
        L16:
            return;
        L18:
            throw new IllegalArgumentException("Part map was null.");
        }
    }

    public static final class h<T> extends p<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f537537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final retrofit2.g<T, String> f537538b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f537539c;

        @Override // retrofit2.p
        public final void a(r r110, @Nullable T r210) throws IOException {
            if (r210 == null) goto L59;
            String r100 = this.f537537a;
            String r101 = this.f537538b.convert(r210);
            boolean r102 = this.f537539c;
            if (r110.f537554c == null) goto L57;
            int r103 = r101.length();
            int r104 = 0;
        L7:
            if (r104 >= r103) goto L49;
            int r105 = r101.codePointAt(r104);
            int r106 = 47;
            if (r105 < 32) goto L18;
            if (r105 >= 127) goto L18;
            if (" \"<>^`{}|\\?#".indexOf(r105) != (-1)) goto L18;
            if (r102 == true) goto L17;
            if (r105 == 47) goto L18;
            if (r105 == 37) goto L18;
        L17:
            r104 = r104 + Character.charCount(r105);
        L18:
            Buffer r107 = new Buffer();
            r107.writeUtf8(r101, 0, r104);
            Buffer r108 = null;
        L19:
            if (r104 >= r103) goto L48;
            int r111 = r101.codePointAt(r104);
            if (r102 == true) goto L23;
        L31:
            if (r111 < 32) goto L41;
            if (r111 >= 127) goto L41;
            if (" \"<>^`{}|\\?#".indexOf(r111) != (-1)) goto L41;
            if (r102 == true) goto L40;
            if (r111 == r106) goto L41;
            if (r111 == 37) goto L41;
        L40:
            r107.writeUtf8CodePoint(r111);
        L47:
            r104 = r104 + Character.charCount(r111);
            r106 = 47;
        L41:
            if (r108 != null) goto L43;
            r108 = new Buffer();
        L43:
            r108.writeUtf8CodePoint(r111);
        L45:
            if (r108.exhausted() == true) goto L47;
            int r112 = r108.readByte() & UByte.MAX_VALUE;
            r107.writeByte(37);
            char[] r113 = r.f537550k;
            r107.writeByte(r113[(r112 >> 4) & 15]);
            r107.writeByte(r113[r112 & 15]);
            goto L45
        L23:
            if (r111 == 9) goto L47;
            if (r111 == 10) goto L47;
            if (r111 == 12) goto L47;
            if (r111 != 13) goto L31;
        L48:
            String r109 = r107.readUtf8();
        L50:
            String r114 = r110.f537554c.replace("{" + r100 + com.alipay.sdk.m.u.i.f25855d, r109);
            if (r.f537551l.matcher(r114).matches() == true) goto L55;
            r110.f537554c = r114;
            return;
        L55:
            throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): ".concat(r101));
        L49:
            r109 = r101;
            goto L50
        L57:
            throw new AssertionError();
        L59:
            throw new IllegalArgumentException("Path parameter \"" + this.f537537a + "\" value must not be null.");
        }

        public h(String r100, retrofit2.g<T, String> r101, boolean r102) {
            u.a(r100, "name == null");
            this.f537537a = r100;
            this.f537538b = r101;
            this.f537539c = r102;
        }
    }

    public static final class i<T> extends p<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f537540a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final retrofit2.g<T, String> f537541b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f537542c;

        @Override // retrofit2.p
        public final void a(r r100, @Nullable T r101) throws IOException {
            if (r101 != null) goto L4;
            return;
        L4:
            String r102 = this.f537541b.convert(r101);
            if (r102 != null) goto L7;
            return;
        L7:
            r100.b(this.f537540a, r102, this.f537542c);
        }

        public i(String r100, retrofit2.g<T, String> r101, boolean r102) {
            u.a(r100, "name == null");
            this.f537540a = r100;
            this.f537541b = r101;
            this.f537542c = r102;
        }
    }

    public static final class j<T> extends p<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final retrofit2.g<T, String> f537543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f537544b;

        public j(retrofit2.g<T, String> r100, boolean r101) {
            this.f537543a = r100;
            this.f537544b = r101;
        }

        @Override // retrofit2.p
        public final void a(r r100, @Nullable Object r101) throws IOException {
            Map r102 = (Map) r101;
            if (r102 == null) goto L22;
            Iterator r103 = r102.entrySet().iterator();
        L6:
            if (r103.hasNext() == false) goto L20;
            Map.Entry r104 = (Map.Entry) r103.next();
            String r105 = (String) r104.getKey();
            if (r105 == null) goto L19;
            Object r106 = r104.getValue();
            if (r106 == null) goto L17;
            String r107 = this.f537543a.convert((T) r106);
            if (r107 == null) goto L15;
            r100.b(r105, r107, this.f537544b);
            goto L6
        L15:
            throw new IllegalArgumentException("Query map value '" + r106 + "' converted to null by " + this.f537543a.getClass().getName() + " for key '" + r105 + "'.");
        L17:
            throw new IllegalArgumentException("Query map contained null value for key '" + r105 + "'.");
        L19:
            throw new IllegalArgumentException("Query map contained null key.");
        L20:
            return;
        L22:
            throw new IllegalArgumentException("Query map was null.");
        }
    }

    public static final class k<T> extends p<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final retrofit2.g<T, String> f537545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f537546b;

        public k(retrofit2.g<T, String> r100, boolean r101) {
            this.f537545a = r100;
            this.f537546b = r101;
        }

        @Override // retrofit2.p
        public final void a(r r100, @Nullable T r101) throws IOException {
            if (r101 != null) goto L4;
            return;
        L4:
            r100.b(this.f537545a.convert(r101), null, this.f537546b);
        }
    }

    public static final class l extends p<okhttp3.k.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f537547a = null;

        static {
            f537547a = new l();
        }

        public l() {
        }

        @Override // retrofit2.p
        public final void a(r r100, @Nullable okhttp3.k.b r101) throws IOException {
            okhttp3.k.b r102 = r101;
            if (r102 == null) goto L6;
            r100.f537559h.c(r102);
            return;
        }
    }

    public static final class m extends p<Object> {
        public m() {
        }

        @Override // retrofit2.p
        public final void a(r r100, @Nullable Object r101) {
            u.a(r101, "@Url parameter is null.");
            r100.f537554c = r101.toString();
        }
    }

    public p() {
    }

    public abstract void a(r r100, @Nullable T r101) throws IOException;
}
