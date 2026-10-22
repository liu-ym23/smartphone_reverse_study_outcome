package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import retrofit2.http.Url;

/* JADX INFO: loaded from: classes41.dex */
public abstract class t<T> {
    public t() {
    }

    public abstract T a(Object[] r100);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v15 */
    public static j b(Retrofit r210, Method r211) {
        s.a r100 = new s.a(r210, r211);
        Annotation[] r101 = r100.f537578c;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        p<?> r104 = null;
        boolean r105 = true;
        String r106 = "HEAD";
        if (r103 >= r102) goto L70;
        Annotation r110 = r101[r103];
        if ((r110 instanceof DELETE) == false) goto L9;
        r100.b("DELETE", ((DELETE) r110).value(), false);
    L68:
        r103 = r103 + 1;
        goto L3
    L9:
        if ((r110 instanceof GET) == false) goto L12;
        r100.b("GET", ((GET) r110).value(), false);
        goto L68
    L12:
        if ((r110 instanceof HEAD) == false) goto L15;
        r100.b("HEAD", ((HEAD) r110).value(), false);
        goto L68
    L15:
        if ((r110 instanceof PATCH) == false) goto L18;
        r100.b("PATCH", ((PATCH) r110).value(), true);
        goto L68
    L18:
        if ((r110 instanceof POST) == false) goto L21;
        r100.b("POST", ((POST) r110).value(), true);
        goto L68
    L21:
        if ((r110 instanceof PUT) == false) goto L24;
        r100.b("PUT", ((PUT) r110).value(), true);
        goto L68
    L24:
        if ((r110 instanceof OPTIONS) == false) goto L27;
        r100.b("OPTIONS", ((OPTIONS) r110).value(), false);
        goto L68
    L27:
        if ((r110 instanceof HTTP) == false) goto L30;
        HTTP r111 = (HTTP) r110;
        r100.b(r111.method(), r111.path(), r111.hasBody());
        goto L68
    L30:
        if ((r110 instanceof Headers) == false) goto L55;
        String[] r107 = ((Headers) r110).value();
        if (r107.length == 0) goto L53;
        okhttp3.Headers.Builder r112 = new okhttp3.Headers.Builder();
        int r113 = r107.length;
        int r114 = 0;
    L34:
        if (r114 >= r113) goto L51;
        String r115 = r107[r114];
        int r116 = r115.indexOf(58);
        if (r116 == (-1)) goto L50;
        if (r116 == 0) goto L50;
        if (r116 == (r115.length() - 1)) goto L50;
        String r117 = r115.substring(0, r116);
        String r118 = r115.substring(r116 + 1).trim();
        if ("Content-Type".equalsIgnoreCase(r117) == true) goto L451;
        r112.add(r117, r118);
    L48:
        r114 = r114 + 1;
        goto L34
    L451:
        r100.f537595t = MediaType.get(r118);     // Catch: IllegalArgumentException -> L44
    L44:
        e = move-exception;
        throw u.i(r100.f537577b, e, "Malformed content type: %s", new Object[]{r118});
    L50:
        throw u.i(r100.f537577b, null, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", new Object[]{r115});
    L51:
        r100.f537594s = r112.build();
        goto L68
    L53:
        throw u.i(r100.f537577b, null, "@Headers annotation is empty.", new Object[0]);
    L55:
        if ((r110 instanceof Multipart) == false) goto L62;
        if (r100.f537591p == true) goto L60;
        r100.f537592q = true;
        goto L68
    L60:
        throw u.i(r100.f537577b, null, "Only one encoding annotation is allowed.", new Object[0]);
    L62:
        if ((r110 instanceof FormUrlEncoded) == false) goto L68;
        if (r100.f537592q == true) goto L67;
        r100.f537591p = true;
        goto L68
    L67:
        throw u.i(r100.f537577b, null, "Only one encoding annotation is allowed.", new Object[0]);
    L70:
        if (r100.f537589n == null) goto L444;
        if (r100.f537590o == false) goto L74;
    L82:
        int r108 = r100.f537579d.length;
        r100.f537597v = new p[r108];
        int r109 = 0;
    L83:
        if (r109 >= r108) goto L379;
        p<?>[] r119 = r100.f537597v;
        Type r120 = r100.f537580e[r109];
        Annotation[] r121 = r100.f537579d[r109];
        if (r121 == null) goto L374;
        int r122 = r121.length;
        p<?> r123 = r104;
        int r124 = 0;
        int r125 = r105;
    L87:
        if (r124 >= r122) goto L373;
        Annotation r126 = r121[r124];
        if ((r126 instanceof Url) == false) goto L129;
        r100.c(r109, r120);
        if (r100.f537588m == true) goto L127;
        if (r100.f537584i == true) goto L125;
        if (r100.f537585j == true) goto L123;
        if (r100.f537586k == true) goto L121;
        if (r100.f537587l == true) goto L119;
        if (r100.f537593r != null) goto L116;
        r100.f537588m = r125;
        if (r120 != HttpUrl.class) goto L105;
    L115:
        p<?> r127 = new p.m();
    L145:
        int r128 = r108;
        int r129 = r122;
    L296:
        p<?> r130 = r127;
    L215:
        String r131 = r106;
    L366:
        if (r130 == null) goto L370;
        if (r123 != null) goto L372;
        r123 = r130;
        goto L370
    L372:
        throw u.j(r100.f537577b, r109, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
    L370:
        r124 = r124 + 1;
        r108 = r128;
        r122 = r129;
        r106 = r131;
        r125 = 1;
        goto L87
    L105:
        if (r120 == String.class) goto L115;
        if (r120 == URI.class) goto L115;
        if ((r120 instanceof Class) == false) goto L114;
        if ("android.net.Uri".equals(((Class) r120).getName()) == true) goto L115;
    L114:
        throw u.j(r100.f537577b, r109, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
    L116:
        Method r132 = r100.f537577b;
        Object[] r133 = new Object[r125];
        r133[0] = r100.f537589n;
        throw u.j(r132, r109, "@Url cannot be used with @%s URL", r133);
    L119:
        throw u.j(r100.f537577b, r109, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
    L121:
        throw u.j(r100.f537577b, r109, "A @Url parameter must not come after a @QueryName.", new Object[0]);
    L123:
        throw u.j(r100.f537577b, r109, "A @Url parameter must not come after a @Query.", new Object[0]);
    L125:
        throw u.j(r100.f537577b, r109, "@Path parameters may not be used with @Url.", new Object[0]);
    L127:
        throw u.j(r100.f537577b, r109, "Multiple @Url method annotations found.", new Object[0]);
    L129:
        if ((r126 instanceof Path) == false) goto L161;
        r100.c(r109, r120);
        if (r100.f537585j == true) goto L159;
        if (r100.f537586k == true) goto L157;
        if (r100.f537587l == true) goto L155;
        if (r100.f537588m == true) goto L153;
        if (r100.f537593r == null) goto L151;
        r100.f537584i = true;
        Path r134 = (Path) r126;
        String r135 = r134.value();
        if (s.a.f537575x.matcher(r135).matches() == false) goto L149;
        if (r100.f537596u.contains(r135) == false) goto L147;
        r127 = new p.h(r135, r100.f537576a.stringConverter(r120, r121), r134.encoded());
        goto L145
    L147:
        throw u.j(r100.f537577b, r109, "URL \"%s\" does not contain \"{%s}\".", new Object[]{r100.f537593r, r135});
    L149:
        throw u.j(r100.f537577b, r109, "@Path parameter name must match %s. Found: %s", new Object[]{s.a.f537574w.pattern(), r135});
    L151:
        throw u.j(r100.f537577b, r109, "@Path can only be used with relative url on @%s", new Object[]{r100.f537589n});
    L153:
        throw u.j(r100.f537577b, r109, "@Path parameters may not be used with @Url.", new Object[0]);
    L155:
        throw u.j(r100.f537577b, r109, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
    L157:
        throw u.j(r100.f537577b, r109, "A @Path parameter must not come after a @QueryName.", new Object[0]);
    L159:
        throw u.j(r100.f537577b, r109, "A @Path parameter must not come after a @Query.", new Object[0]);
    L161:
        if ((r126 instanceof Query) == false) goto L175;
        r100.c(r109, r120);
        Query r136 = (Query) r126;
        String r137 = r136.value();
        boolean r138 = r136.encoded();
        r128 = r108;
        Class<?> r139 = u.f(r120);
        r129 = r122;
        r100.f537585j = true;
        if (Iterable.class.isAssignableFrom(r139) == false) goto L170;
        if ((r120 instanceof ParameterizedType) == false) goto L168;
        p<?> r140 = new n(new p.i(r137, r100.f537576a.stringConverter(u.e(0, (ParameterizedType) r120), r121), r138));
    L172:
        r127 = r140;
        goto L296
    L168:
        throw u.j(r100.f537577b, r109, r139.getSimpleName() + " must include generic type (e.g., " + r139.getSimpleName() + "<String>)", new Object[0]);
    L170:
        if (r139.isArray() == false) goto L173;
        r140 = new o(new p.i(r137, r100.f537576a.stringConverter(s.a.a(r139.getComponentType()), r121), r138));
        goto L172
    L173:
        p<?> r141 = new p.i(r137, r100.f537576a.stringConverter(r120, r121), r138);
    L174:
        r127 = r141;
        goto L296
    L175:
        r128 = r108;
        r129 = r122;
        if ((r126 instanceof QueryName) == false) goto L189;
        r100.c(r109, r120);
        boolean r142 = ((QueryName) r126).encoded();
        Class<?> r143 = u.f(r120);
        r100.f537586k = true;
        if (Iterable.class.isAssignableFrom(r143) == false) goto L185;
        if ((r120 instanceof ParameterizedType) == false) goto L183;
        r130 = new n(new p.k(r100.f537576a.stringConverter(u.e(0, (ParameterizedType) r120), r121), r142));
        goto L215
    L183:
        throw u.j(r100.f537577b, r109, r143.getSimpleName() + " must include generic type (e.g., " + r143.getSimpleName() + "<String>)", new Object[0]);
    L185:
        if (r143.isArray() == false) goto L187;
        r130 = new o(new p.k(r100.f537576a.stringConverter(s.a.a(r143.getComponentType()), r121), r142));
        goto L215
    L187:
        r141 = new p.k(r100.f537576a.stringConverter(r120, r121), r142);
        goto L174
    L189:
        if ((r126 instanceof QueryMap) == false) goto L204;
        r100.c(r109, r120);
        Class<?> r144 = u.f(r120);
        r100.f537587l = true;
        if (Map.class.isAssignableFrom(r144) == false) goto L202;
        Type r145 = u.g(r120, r144, Map.class);
        if ((r145 instanceof ParameterizedType) == false) goto L200;
        ParameterizedType r146 = (ParameterizedType) r145;
        Type r147 = u.e(0, r146);
        if (String.class != r147) goto L198;
        r127 = new p.j(r100.f537576a.stringConverter(u.e(1, r146), r121), ((QueryMap) r126).encoded());
        goto L296
    L198:
        throw u.j(r100.f537577b, r109, "@QueryMap keys must be of type String: " + r147, new Object[0]);
    L200:
        throw u.j(r100.f537577b, r109, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
    L202:
        throw u.j(r100.f537577b, r109, "@QueryMap parameter type must be Map.", new Object[0]);
    L204:
        if ((r126 instanceof Header) == false) goto L218;
        r100.c(r109, r120);
        String r148 = ((Header) r126).value();
        Class<?> r149 = u.f(r120);
        if (Iterable.class.isAssignableFrom(r149) == false) goto L213;
        if ((r120 instanceof ParameterizedType) == false) goto L211;
        r130 = new n(new p.d(r148, r100.f537576a.stringConverter(u.e(0, (ParameterizedType) r120), r121)));
        goto L215
    L211:
        throw u.j(r100.f537577b, r109, r149.getSimpleName() + " must include generic type (e.g., " + r149.getSimpleName() + "<String>)", new Object[0]);
    L213:
        if (r149.isArray() == false) goto L216;
        r130 = new o(new p.d(r148, r100.f537576a.stringConverter(s.a.a(r149.getComponentType()), r121)));
        goto L215
    L216:
        r141 = new p.d(r148, r100.f537576a.stringConverter(r120, r121));
        goto L174
    L218:
        if ((r126 instanceof HeaderMap) == false) goto L233;
        r100.c(r109, r120);
        Class<?> r150 = u.f(r120);
        if (Map.class.isAssignableFrom(r150) == false) goto L231;
        Type r151 = u.g(r120, r150, Map.class);
        if ((r151 instanceof ParameterizedType) == false) goto L229;
        ParameterizedType r152 = (ParameterizedType) r151;
        Type r153 = u.e(0, r152);
        if (String.class != r153) goto L227;
        r127 = new p.e(r100.f537576a.stringConverter(u.e(1, r152), r121));
        goto L296
    L227:
        throw u.j(r100.f537577b, r109, "@HeaderMap keys must be of type String: " + r153, new Object[0]);
    L229:
        throw u.j(r100.f537577b, r109, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
    L231:
        throw u.j(r100.f537577b, r109, "@HeaderMap parameter type must be Map.", new Object[0]);
    L233:
        if ((r126 instanceof Field) == false) goto L250;
        r100.c(r109, r120);
        if (r100.f537591p == false) goto L248;
        Field r154 = (Field) r126;
        String r155 = r154.value();
        boolean r156 = r154.encoded();
        r100.f537581f = true;
        Class<?> r157 = u.f(r120);
        if (Iterable.class.isAssignableFrom(r157) == false) goto L244;
        if ((r120 instanceof ParameterizedType) == false) goto L242;
        r140 = new n(new p.b(r155, r100.f537576a.stringConverter(u.e(0, (ParameterizedType) r120), r121), r156));
        goto L172
    L242:
        throw u.j(r100.f537577b, r109, r157.getSimpleName() + " must include generic type (e.g., " + r157.getSimpleName() + "<String>)", new Object[0]);
    L244:
        if (r157.isArray() == false) goto L246;
        r140 = new o(new p.b(r155, r100.f537576a.stringConverter(s.a.a(r157.getComponentType()), r121), r156));
        goto L172
    L246:
        r127 = new p.b(r155, r100.f537576a.stringConverter(r120, r121), r156);
        goto L296
    L248:
        throw u.j(r100.f537577b, r109, "@Field parameters can only be used with form encoding.", new Object[0]);
    L250:
        if ((r126 instanceof FieldMap) == false) goto L269;
        r100.c(r109, r120);
        if (r100.f537591p == false) goto L267;
        Class<?> r158 = u.f(r120);
        if (Map.class.isAssignableFrom(r158) == false) goto L265;
        Type r159 = u.g(r120, r158, Map.class);
        if ((r159 instanceof ParameterizedType) == false) goto L263;
        ParameterizedType r160 = (ParameterizedType) r159;
        Type r161 = u.e(0, r160);
        if (String.class != r161) goto L261;
        g<T, String> r162 = r100.f537576a.stringConverter(u.e(1, r160), r121);
        r100.f537581f = true;
        r127 = new p.c(r162, ((FieldMap) r126).encoded());
        goto L296
    L261:
        throw u.j(r100.f537577b, r109, "@FieldMap keys must be of type String: " + r161, new Object[0]);
    L263:
        throw u.j(r100.f537577b, r109, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
    L265:
        throw u.j(r100.f537577b, r109, "@FieldMap parameter type must be Map.", new Object[0]);
    L267:
        throw u.j(r100.f537577b, r109, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
    L269:
        if ((r126 instanceof Part) == false) goto L325;
        r100.c(r109, r120);
        if (r100.f537592q == false) goto L324;
        Part r163 = (Part) r126;
        r100.f537582g = true;
        String r164 = r163.value();
        Class<?> r165 = u.f(r120);
        if (r164.isEmpty() == true) goto L275;
        r131 = r106;
        okhttp3.Headers r166 = okhttp3.Headers.of(new String[]{"Content-Disposition", "form-data; name=\"" + r164 + "\"", "Content-Transfer-Encoding", r163.encoding()});
        if (Iterable.class.isAssignableFrom(r165) == false) goto L311;
        if ((r120 instanceof ParameterizedType) == false) goto L309;
        Type r167 = u.e(0, (ParameterizedType) r120);
        if (okhttp3.k.b.class.isAssignableFrom(u.f(r167)) == true) goto L307;
        p<?> r168 = new n(new p.f(r166, r100.f537576a.requestBodyConverter(r167, r121, r100.f537578c)));
    L315:
        r130 = r168;
        goto L366
    L307:
        throw u.j(r100.f537577b, r109, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
    L309:
        throw u.j(r100.f537577b, r109, r165.getSimpleName() + " must include generic type (e.g., " + r165.getSimpleName() + "<String>)", new Object[0]);
    L311:
        if (r165.isArray() == false) goto L319;
        Class<?> r169 = s.a.a(r165.getComponentType());
        if (okhttp3.k.b.class.isAssignableFrom(r169) == true) goto L317;
        r168 = new o(new p.f(r166, r100.f537576a.requestBodyConverter(r169, r121, r100.f537578c)));
        goto L315
    L317:
        throw u.j(r100.f537577b, r109, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
    L319:
        if (okhttp3.k.b.class.isAssignableFrom(r165) == true) goto L322;
        r130 = new p.f(r166, r100.f537576a.requestBodyConverter(r120, r121, r100.f537578c));
        goto L366
    L322:
        throw u.j(r100.f537577b, r109, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
    L275:
        if (Iterable.class.isAssignableFrom(r165) == false) goto L286;
        if ((r120 instanceof ParameterizedType) == false) goto L284;
        if (okhttp3.k.b.class.isAssignableFrom(u.f(u.e(0, (ParameterizedType) r120))) == false) goto L282;
        r141 = new n(p.l.f537547a);
        goto L174
    L282:
        throw u.j(r100.f537577b, r109, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
    L284:
        throw u.j(r100.f537577b, r109, r165.getSimpleName() + " must include generic type (e.g., " + r165.getSimpleName() + "<String>)", new Object[0]);
    L286:
        if (r165.isArray() == false) goto L294;
        if (okhttp3.k.b.class.isAssignableFrom(r165.getComponentType()) == false) goto L292;
        r127 = new o(p.l.f537547a);
        goto L296
    L292:
        throw u.j(r100.f537577b, r109, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
    L294:
        if (okhttp3.k.b.class.isAssignableFrom(r165) == false) goto L298;
        r127 = p.l.f537547a;
        goto L296
    L298:
        throw u.j(r100.f537577b, r109, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
    L324:
        throw u.j(r100.f537577b, r109, "@Part parameters can only be used with multipart encoding.", new Object[0]);
    L325:
        r131 = r106;
        if ((r126 instanceof PartMap) == false) goto L349;
        r100.c(r109, r120);
        if (r100.f537592q == false) goto L347;
        r100.f537582g = true;
        Class<?> r170 = u.f(r120);
        if (Map.class.isAssignableFrom(r170) == false) goto L345;
        Type r171 = u.g(r120, r170, Map.class);
        if ((r171 instanceof ParameterizedType) == false) goto L343;
        ParameterizedType r172 = (ParameterizedType) r171;
        Type r173 = u.e(0, r172);
        if (String.class != r173) goto L341;
        Type r174 = u.e(1, r172);
        if (okhttp3.k.b.class.isAssignableFrom(u.f(r174)) == true) goto L339;
        r130 = new p.g(r100.f537576a.requestBodyConverter(r174, r121, r100.f537578c), ((PartMap) r126).encoding());
        goto L366
    L339:
        throw u.j(r100.f537577b, r109, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
    L341:
        throw u.j(r100.f537577b, r109, "@PartMap keys must be of type String: " + r173, new Object[0]);
    L343:
        throw u.j(r100.f537577b, r109, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
    L345:
        throw u.j(r100.f537577b, r109, "@PartMap parameter type must be Map.", new Object[0]);
    L347:
        throw u.j(r100.f537577b, r109, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
    L349:
        if ((r126 instanceof Body) == false) goto L365;
        r100.c(r109, r120);
        if (r100.f537591p == true) goto L364;
        if (r100.f537592q == true) goto L364;
        if (r100.f537583h == true) goto L362;
        g<T, RequestBody> r175 = r100.f537576a.requestBodyConverter(r120, r121, r100.f537578c);     // Catch: RuntimeException -> L358
        r100.f537583h = true;
        r130 = new p.a(r175);
    L358:
        e = move-exception;
        throw u.i(r100.f537577b, e, "Unable to create @Body converter for %s (parameter #" + (r109 + 1) + ")", new Object[]{r120});
    L362:
        throw u.j(r100.f537577b, r109, "Multiple @Body method annotations found.", new Object[0]);
    L364:
        throw u.j(r100.f537577b, r109, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
    L365:
        r130 = null;
        goto L366
    L373:
        int r176 = r108;
        String r177 = r106;
    L375:
        if (r123 == null) goto L378;
        r119[r109] = r123;
        r109 = r109 + 1;
        r108 = r176;
        r106 = r177;
        r104 = null;
        r105 = true;
        goto L83
    L378:
        throw u.j(r100.f537577b, r109, "No Retrofit annotation found.", new Object[0]);
    L374:
        r176 = r108;
        r177 = r106;
        r123 = null;
        goto L375
    L379:
        String r178 = r106;
        if (r100.f537593r == null) goto L382;
    L386:
        boolean r179 = r100.f537591p;
        if (r179 == false) goto L389;
    L397:
        if (r179 == false) goto L404;
        if (r100.f537581f == true) goto L404;
        throw u.i(r100.f537577b, null, "Form-encoded method must contain at least one @Field.", new Object[0]);
    L404:
        if (r100.f537592q == true) goto L406;
    L410:
        s r180 = new s(r100);
        Type r181 = r211.getGenericReturnType();
        if (u.h(r181) == true) goto L442;
        if (r181 == Void.TYPE) goto L440;
        Type r182 = r211.getGenericReturnType();
        CallAdapter<?, ?> r183 = r210.callAdapter(r182, r211.getAnnotations());     // Catch: RuntimeException -> L436
        Type r184 = r183.responseType();
        if (r184 == Response.class) goto L435;
        if (r184 == okhttp3.Response.class) goto L435;
        if (r180.f537566c.equals(r178) == false) goto L447;
        if (Void.class.equals(r184) == true) goto L447;
        throw u.i(r211, null, "HEAD method must use Void as response type.", new Object[0]);
    L447:
        return new j(r180, r210.callFactory, r183, r210.responseBodyConverter(r184, r211.getAnnotations()));
    L431:
        e = move-exception;
        throw u.i(r211, e, "Unable to create converter for %s", new Object[]{r184});
    L435:
        throw u.i(r211, null, "'" + u.f(r184).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
    L436:
        e = move-exception;
        throw u.i(r211, e, "Unable to create call adapter for %s", new Object[]{r182});
    L440:
        throw u.i(r211, null, "Service methods cannot return void.", new Object[0]);
    L442:
        throw u.i(r211, null, "Method return type must not include a type variable or wildcard: %s", new Object[]{r181});
    L406:
        if (r100.f537582g == true) goto L410;
        throw u.i(r100.f537577b, null, "Multipart method must contain at least one @Part.", new Object[0]);
    L389:
        if (r100.f537592q == true) goto L397;
        if (r100.f537590o == true) goto L397;
        if (r100.f537583h == false) goto L397;
        throw u.i(r100.f537577b, null, "Non-body HTTP method cannot contain @Body.", new Object[0]);
    L382:
        if (r100.f537588m == true) goto L386;
        throw u.i(r100.f537577b, null, "Missing either @%s URL or @Url parameter.", new Object[]{r100.f537589n});
    L74:
        if (r100.f537592q == true) goto L81;
        if (r100.f537591p == false) goto L82;
        throw u.i(r100.f537577b, null, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
    L81:
        throw u.i(r100.f537577b, null, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
    L444:
        throw u.i(r100.f537577b, null, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
    }
}
