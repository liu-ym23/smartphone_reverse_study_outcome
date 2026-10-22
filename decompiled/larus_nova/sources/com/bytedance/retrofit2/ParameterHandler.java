package com.bytedance.retrofit2;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.retrofit2.http.ext.QueryParamObject;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.RequestBody;
import okhttp3.k;

/* JADX INFO: loaded from: classes3.dex */
abstract class ParameterHandler<T> {

    public static final class AddCommonParam<T> extends ParameterHandler<T> {
        private final Converter<T, String> converter;

        public AddCommonParam(Converter<T, String> r100) {
            this.converter = (Converter) Utils.checkNotNull(r100, "converter == null");
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r100, T r101) throws IOException {
            if (r101 != null) goto L9;
            return;
        L9:
            r100.setAddCommonParam(Boolean.parseBoolean(this.converter.convert(r101)));     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r101 + " to AddCommonParam", e);
        }
    }

    public static final class Body<T> extends ParameterHandler<T> {
        private final Converter<T, TypedOutput> converter;
        private final boolean isCustomMethod;
        private final java.lang.reflect.Method method;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final int f267491p;

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r100, @Nullable T r101) {
            if (r101 == null) goto L5;
        L15:
            e = move-exception;
            throw Utils.parameterError(this.method, e, this.f267491p, "Unable to convert " + r101 + " to RequestBody", new Object[0]);
        L10:
            if (this.converter.needRequestBuilder() == false) goto L12;
            TypedOutput r102 = this.converter.convertWithRequestBuilder(r101, r100);     // Catch: IOException -> L15
        L13:
            r100.setBody(r102);
            return;
        L12:
            r102 = this.converter.convert(r101);     // Catch: IOException -> L15
            goto L13
        L5:
            if (this.isCustomMethod == false) goto L8;
            return;
        L8:
            throw Utils.parameterError(this.method, this.f267491p, "Body parameter value must not be null.", new Object[0]);
        }

        public Body(java.lang.reflect.Method r100, int r101, boolean r102, Converter<T, TypedOutput> r103) {
            this.method = r100;
            this.f267491p = r101;
            this.isCustomMethod = r102;
            this.converter = r103;
        }
    }

    public static final class ConverterBody extends ParameterHandler<RequestBody> {
        static final ConverterBody INSTANCE = null;

        static {
            INSTANCE = new ConverterBody();
        }

        public ConverterBody() {
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public void apply2(RequestBuilder r100, RequestBody r101) {
            if (r101 == null) goto L6;
            r100.setBody(r101);
            r100.useRequestBody();
            return;
        L6:
            throw new IllegalArgumentException("Body parameter value must not be null.");
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder r100, RequestBody r101) throws IOException {
            apply2(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class ConverterPart extends ParameterHandler<RequestBody> {
        private final Headers headers;

        public ConverterPart(Headers r100) {
            this.headers = r100;
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public void apply2(RequestBuilder r100, RequestBody r101) {
            if (r101 != null) goto L4;
            return;
        L4:
            r100.addPart(this.headers, r101);
            r100.useRequestBody();
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder r100, RequestBody r101) throws IOException {
            apply2(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class ConverterPartMap extends ParameterHandler<Map<String, RequestBody>> {
        private final String transferEncoding;

        public ConverterPartMap(String r100) {
            this.transferEncoding = r100;
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public void apply2(RequestBuilder r100, Map<String, RequestBody> r101) throws IOException {
            if (r101 == null) goto L18;
            Iterator<Map.Entry<String, RequestBody>> r102 = r101.entrySet().iterator();
        L5:
            if (r102.hasNext() == false) goto L15;
            Map.Entry<String, RequestBody> r103 = r102.next();
            String r104 = r103.getKey();
            if (r104 == null) goto L14;
            RequestBody r105 = r103.getValue();
            if (r105 == null) goto L12;
            r100.addPart(Headers.of(new String[]{"Content-Disposition", "form-data; name=\"" + r104 + "\"", "Content-Transfer-Encoding", this.transferEncoding}), r105);
            goto L5
        L12:
            throw new IllegalArgumentException("Part map contained null value for key '" + r104 + "'.");
        L14:
            throw new IllegalArgumentException("Part map contained null key.");
        L15:
            r100.useRequestBody();
            return;
        L18:
            throw new IllegalArgumentException("Part map was null.");
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder r100, Map<String, RequestBody> r101) throws IOException {
            apply2(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class ConverterRawPart extends ParameterHandler<k.b> {
        static final ConverterRawPart INSTANCE = null;

        static {
            INSTANCE = new ConverterRawPart();
        }

        public ConverterRawPart() {
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public void apply2(RequestBuilder r100, k.b r101) throws IOException {
            if (r101 == null) goto L4;
            r100.addPart(r101);
        L4:
            r100.useRequestBody();
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder r100, k.b r101) throws IOException {
            apply2(r100, r101);
        }
    }

    public static final class ExtraInfo<T> extends ParameterHandler<T> {
        private final Converter<T, Object> converter;

        public ExtraInfo(Converter<T, Object> r100) {
            this.converter = (Converter) Utils.checkNotNull(r100, "converter == null");
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r100, T r101) throws IOException {
            if (r101 != null) goto L9;
            return;
        L9:
            r100.setExtraInfo(this.converter.convert(r101));     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r101 + " to ExtraInfo", e);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class Field<T> extends ParameterHandler<T> {
        private final boolean encode;
        private final String name;
        private final Converter<T, String> valueConverter;

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r100, @Nullable T r101) throws IOException {
            if (r101 != null) goto L4;
            return;
        L4:
            String r102 = this.valueConverter.convert(r101);
            if (r102 != null) goto L7;
            return;
        L7:
            r100.addFormField(this.name, r102, this.encode);
        }

        public Field(String r100, Converter<T, String> r101, boolean r102) {
            this.name = (String) Utils.checkNotNull(r100, "name == null");
            this.valueConverter = r101;
            this.encode = r102;
        }
    }

    public static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encode;
        private final java.lang.reflect.Method method;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final int f267492p;
        private final Converter<T, String> valueConverter;

        public void apply(RequestBuilder r100, @Nullable Map<String, T> r101) throws IOException {
            if (r101 == null) goto L22;
            Iterator<Map.Entry<String, T>> r102 = r101.entrySet().iterator();
        L6:
            if (r102.hasNext() == false) goto L20;
            Map.Entry<String, T> r103 = r102.next();
            String r104 = r103.getKey();
            if (r104 == null) goto L19;
            T r105 = r103.getValue();
            if (r105 == null) goto L17;
            String r106 = this.valueConverter.convert(r105);
            if (r106 == null) goto L15;
            r100.addFormField(r104, r106, this.encode);
            goto L6
        L15:
            throw Utils.parameterError(this.method, this.f267492p, "Field map value '" + r105 + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + r104 + "'.", new Object[0]);
        L17:
            throw Utils.parameterError(this.method, this.f267492p, "Field map contained null value for key '" + r104 + "'.", new Object[0]);
        L19:
            throw Utils.parameterError(this.method, this.f267492p, "Field map contained null key.", new Object[0]);
        L20:
            return;
        L22:
            throw Utils.parameterError(this.method, this.f267492p, "Field map was null.", new Object[0]);
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder r100, @Nullable Object r101) throws IOException {
            apply(r100, (Map) r101);
        }

        public FieldMap(java.lang.reflect.Method r100, int r101, Converter<T, String> r102, boolean r103) {
            this.method = r100;
            this.f267492p = r101;
            this.valueConverter = r102;
            this.encode = r103;
        }
    }

    public static final class Header<T> extends ParameterHandler<T> {
        private final String name;
        private final Converter<T, String> valueConverter;

        public Header(String r100, Converter<T, String> r101) {
            this.name = (String) Utils.checkNotNull(r100, "name == null");
            this.valueConverter = r101;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r100, @Nullable T r101) throws IOException {
            if (r101 != null) goto L4;
            return;
        L4:
            String r102 = this.valueConverter.convert(r101);
            if (r102 != null) goto L7;
            return;
        L7:
            r100.addHeader(this.name, r102);
        }
    }

    public static final class HeaderList<T> extends ParameterHandler<List<T>> {
        private final Converter<T, com.bytedance.retrofit2.client.Header> valueConverter;

        public HeaderList(Converter<T, com.bytedance.retrofit2.client.Header> r100) {
            this.valueConverter = r100;
        }

        public void apply(RequestBuilder r100, List<T> r101) throws IOException {
            if (r101 != null) goto L4;
            return;
        L4:
            Iterator<T> r102 = r101.iterator();
        L6:
            if (r102.hasNext() == false) goto L8;
            T r103 = r102.next();
            com.bytedance.retrofit2.client.Header r104 = this.valueConverter.convert(r103);
            r100.addHeader(r104.getName(), r104.getValue());
            goto L6
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder r100, Object r101) throws IOException {
            apply(r100, (List) r101);
        }
    }

    public static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {
        private final java.lang.reflect.Method method;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final int f267493p;
        private final Converter<T, String> valueConverter;

        public void apply(RequestBuilder r100, @Nullable Map<String, T> r101) throws IOException {
            if (r101 == null) goto L18;
            Iterator<Map.Entry<String, T>> r102 = r101.entrySet().iterator();
        L6:
            if (r102.hasNext() == false) goto L16;
            Map.Entry<String, T> r103 = r102.next();
            String r104 = r103.getKey();
            if (r104 == null) goto L15;
            T r105 = r103.getValue();
            if (r105 == null) goto L13;
            r100.addHeader(r104, this.valueConverter.convert(r105));
            goto L6
        L13:
            throw Utils.parameterError(this.method, this.f267493p, "Header map contained null value for key '" + r104 + "'.", new Object[0]);
        L15:
            throw Utils.parameterError(this.method, this.f267493p, "Header map contained null key.", new Object[0]);
        L16:
            return;
        L18:
            throw Utils.parameterError(this.method, this.f267493p, "Header map was null.", new Object[0]);
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder r100, @Nullable Object r101) throws IOException {
            apply(r100, (Map) r101);
        }

        public HeaderMap(java.lang.reflect.Method r100, int r101, Converter<T, String> r102) {
            this.method = r100;
            this.f267493p = r101;
            this.valueConverter = r102;
        }
    }

    public static final class MaxLength<T> extends ParameterHandler<T> {
        private final Converter<T, String> converter;

        public MaxLength(Converter<T, String> r100) {
            this.converter = (Converter) Utils.checkNotNull(r100, "converter == null");
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r100, T r101) throws IOException {
            if (r101 != null) goto L9;
            return;
        L9:
            r100.setMaxLength(CastIntegerProtector.parseInt(this.converter.convert(r101)));     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r101 + " to MaxLength", e);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class Method<T> extends ParameterHandler<T> {
        private final String name;
        private final Converter<T, String> valueConverter;

        public Method(String r100, Converter<T, String> r101) {
            this.name = (String) Utils.checkNotNull(r100, "name == null");
            this.valueConverter = r101;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r100, T r101) throws IOException {
            if (r101 == null) goto L6;
            r100.setMethod(this.name, this.valueConverter.convert(r101));
            return;
        L6:
            throw new IllegalArgumentException("Method parameter \"" + this.name + "\" value must not be null.");
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class Part<T> extends ParameterHandler<T> {
        private final Converter<T, TypedOutput> converter;
        private final java.lang.reflect.Method method;
        private final String name;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final int f267494p;

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r100, T r101) {
            if (r101 != null) goto L10;
            return;
        L10:
            r100.addPart(this.name, this.converter.convert(r101));
            return;
        L7:
            e = move-exception;
            throw Utils.parameterError(this.method, this.f267494p, "Unable to convert " + r101 + " to RequestBody", new Object[]{e});
        }

        public Part(java.lang.reflect.Method r100, int r101, String r102, Converter<T, TypedOutput> r103) {
            this.method = r100;
            this.f267494p = r101;
            this.name = r102;
            this.converter = r103;
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class PartMap<T> extends ParameterHandler<Map<String, T>> {
        private final java.lang.reflect.Method method;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final int f267495p;
        private final String transferEncoding;
        private final Converter<T, TypedOutput> valueConverter;

        public void apply(RequestBuilder r100, @Nullable Map<String, T> r101) throws IOException {
            if (r101 == null) goto L18;
            Iterator<Map.Entry<String, T>> r102 = r101.entrySet().iterator();
        L6:
            if (r102.hasNext() == false) goto L16;
            Map.Entry<String, T> r103 = r102.next();
            String r104 = r103.getKey();
            if (r104 == null) goto L15;
            T r105 = r103.getValue();
            if (r105 == null) goto L13;
            r100.addPart(r104, this.transferEncoding, this.valueConverter.convert(r105));
            goto L6
        L13:
            throw Utils.parameterError(this.method, this.f267495p, "Part map contained null value for key '" + r104 + "'.", new Object[0]);
        L15:
            throw Utils.parameterError(this.method, this.f267495p, "Part map contained null key.", new Object[0]);
        L16:
            return;
        L18:
            throw Utils.parameterError(this.method, this.f267495p, "Part map was null.", new Object[0]);
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder r100, @Nullable Object r101) throws IOException {
            apply(r100, (Map) r101);
        }

        public PartMap(java.lang.reflect.Method r100, int r101, Converter<T, TypedOutput> r102, String r103) {
            this.method = r100;
            this.f267495p = r101;
            this.valueConverter = r102;
            this.transferEncoding = r103;
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class Path<T> extends ParameterHandler<T> {
        private final boolean encode;
        private final java.lang.reflect.Method method;
        private final String name;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final int f267496p;
        private final Converter<T, String> valueConverter;

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r100, @Nullable T r101) throws IOException {
            if (r101 == null) goto L6;
            r100.addPathParam(this.name, this.valueConverter.convert(r101), this.encode);
            return;
        L6:
            throw Utils.parameterError(this.method, this.f267496p, "Path parameter \"" + this.name + "\" value must not be null.", new Object[0]);
        }

        public Path(java.lang.reflect.Method r100, int r101, String r102, Converter<T, String> r103, boolean r104) {
            this.method = r100;
            this.f267496p = r101;
            this.name = (String) Utils.checkNotNull(r102, "name == null");
            this.valueConverter = r103;
            this.encode = r104;
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class Query<T> extends ParameterHandler<T> {
        private final boolean encode;
        private final String name;
        private final Converter<T, String> valueConverter;

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r100, T r101) throws IOException {
            if (r101 != null) goto L4;
            return;
        L4:
            String r102 = this.valueConverter.convert(r101);
            if (r102 != null) goto L7;
            return;
        L7:
            r100.addQueryParam(this.name, r102, this.encode);
        }

        public Query(String r100, Converter<T, String> r101, boolean r102) {
            this.name = (String) Utils.checkNotNull(r100, "name == null");
            this.valueConverter = r101;
            this.encode = r102;
        }
    }

    public static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encode;
        private final java.lang.reflect.Method method;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final int f267497p;
        private final Converter<T, String> valueConverter;

        public void apply(RequestBuilder r100, @Nullable Map<String, T> r101) throws IOException {
            if (r101 != null) goto L4;
            return;
        L4:
            Iterator<Map.Entry<String, T>> r102 = r101.entrySet().iterator();
        L6:
            if (r102.hasNext() == false) goto L19;
            Map.Entry<String, T> r103 = r102.next();
            String r104 = r103.getKey();
            if (r104 == null) goto L18;
            T r105 = r103.getValue();
            if (r105 == null) goto L6;
            String r106 = this.valueConverter.convert(r105);
            if (r106 == null) goto L16;
            r100.addQueryParam(r104, r106, this.encode);
            goto L6
        L16:
            throw Utils.parameterError(this.method, this.f267497p, "Query map value '" + r105 + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + r104 + "'.", new Object[0]);
        L18:
            throw Utils.parameterError(this.method, this.f267497p, "Query map contained null key.", new Object[0]);
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder r100, @Nullable Object r101) throws IOException {
            apply(r100, (Map) r101);
        }

        public QueryMap(java.lang.reflect.Method r100, int r101, Converter<T, String> r102, boolean r103) {
            this.method = r100;
            this.f267497p = r101;
            this.valueConverter = r102;
            this.encode = r103;
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class QueryName<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Converter<T, String> nameConverter;

        public QueryName(Converter<T, String> r100, boolean r101) {
            this.nameConverter = r100;
            this.encoded = r101;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r100, @Nullable T r101) throws IOException {
            if (r101 != null) goto L4;
            return;
        L4:
            r100.addQueryParam(this.nameConverter.convert(r101), null, this.encoded);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class QueryObject<T> extends ParameterHandler<T> {
        public QueryObject() {
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r100, T r101) throws IOException {
            if (r101 != null) goto L5;
            return;
        L5:
            if ((r101 instanceof QueryParamObject) == false) goto L9;
            r100.setQueryObjectParams(((QueryParamObject) r101).toQuery());
            return;
        L9:
            throw new RuntimeException("wrong type:" + r101.getClass() + ",not implement QueryParamObject");
        }
    }

    public static final class RelativeUrl extends ParameterHandler<Object> {
        private final java.lang.reflect.Method method;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final int f267498p;

        public RelativeUrl(java.lang.reflect.Method r100, int r101) {
            this.method = r100;
            this.f267498p = r101;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r100, @Nullable Object r101) {
            r100.setRelativeUrl(r101);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class Tag<T> extends ParameterHandler<T> {
        final Class<T> cls;

        public Tag(Class<T> r100) {
            this.cls = r100;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r100, @Nullable T r101) {
            r100.addTag(this.cls, r101);
        }
    }

    public ParameterHandler() {
    }

    public abstract void apply(RequestBuilder r100, @Nullable T r101) throws IOException;

    public final ParameterHandler<Object> array() {
        return new AnonymousClass2(this);
    }

    public final ParameterHandler<Iterable<T>> iterable() {
        return new AnonymousClass1(this);
    }
}
