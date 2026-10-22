package com.bytedance.retrofit2;

import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.mime.MimeUtil;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
final class BuiltInConverters extends Converter.Factory {
    private boolean checkForKotlinUnit;

    public static final class BufferingResponseBodyConverter implements Converter<TypedInput, TypedInput> {
        static final BufferingResponseBodyConverter INSTANCE = null;

        public BufferingResponseBodyConverter() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.retrofit2.mime.TypedInput, java.lang.Object] */
        @Override // com.bytedance.retrofit2.Converter
        public final /* synthetic */ TypedInput convertWithRequestBuilder(TypedInput r100, RequestBuilder r101) {
            return Converter.CC.$default$convertWithRequestBuilder(this, r100, r101);
        }

        @Override // com.bytedance.retrofit2.Converter
        public final /* synthetic */ boolean needRequestBuilder() {
            return Converter.CC.$default$needRequestBuilder(this);
        }

        static {
            INSTANCE = new BufferingResponseBodyConverter();
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public TypedInput convert2(@Nullable TypedInput r100) throws IOException {
            if (r100 != null) goto L4;
        L15:
            return r100;
        L4:
            if ((r100 instanceof TypedByteArray) == true) goto L15;
            String r101 = r100.mimeType();
            InputStream r102 = r100.in();
            TypedByteArray r103 = new TypedByteArray(r101, Utils.streamToBytes(r102), new String[0]);     // Catch: Throwable -> L11
            if (r102 != null) goto L22;
        L10:
            return r103;
        L22:
            r102.close();     // Catch: IOException -> L16
        L11:
            th = move-exception;
            if (r102 != null) goto L20;
        L14:
            throw th;
        L20:
            r102.close();     // Catch: IOException -> L17
            goto L14
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ TypedInput convert(@Nullable TypedInput r100) throws IOException {
            return convert2(r100);
        }
    }

    public static final class HeaderConverter implements Converter<Header, Header> {
        static final HeaderConverter INSTANCE = null;

        public HeaderConverter() {
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public Header convert2(Header r100) throws IOException {
            return r100;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.retrofit2.client.Header, java.lang.Object] */
        @Override // com.bytedance.retrofit2.Converter
        public final /* synthetic */ Header convertWithRequestBuilder(Header r100, RequestBuilder r101) {
            return Converter.CC.$default$convertWithRequestBuilder(this, r100, r101);
        }

        @Override // com.bytedance.retrofit2.Converter
        public final /* synthetic */ boolean needRequestBuilder() {
            return Converter.CC.$default$needRequestBuilder(this);
        }

        static {
            INSTANCE = new HeaderConverter();
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ Header convert(Header r100) throws IOException {
            return convert2(r100);
        }
    }

    public static final class ObjectConverter implements Converter<Object, Object> {
        static final ObjectConverter INSTANCE = null;

        public ObjectConverter() {
        }

        @Override // com.bytedance.retrofit2.Converter
        public Object convert(Object r100) throws IOException {
            return r100;
        }

        @Override // com.bytedance.retrofit2.Converter
        public final /* synthetic */ Object convertWithRequestBuilder(Object r100, RequestBuilder r101) {
            return Converter.CC.$default$convertWithRequestBuilder(this, r100, r101);
        }

        @Override // com.bytedance.retrofit2.Converter
        public final /* synthetic */ boolean needRequestBuilder() {
            return Converter.CC.$default$needRequestBuilder(this);
        }

        static {
            INSTANCE = new ObjectConverter();
        }
    }

    public static final class RequestBodyConverter implements Converter<TypedOutput, TypedOutput> {
        static final RequestBodyConverter INSTANCE = null;

        public RequestBodyConverter() {
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public TypedOutput convert2(TypedOutput r100) {
            return r100;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.retrofit2.mime.TypedOutput, java.lang.Object] */
        @Override // com.bytedance.retrofit2.Converter
        public final /* synthetic */ TypedOutput convertWithRequestBuilder(TypedOutput r100, RequestBuilder r101) {
            return Converter.CC.$default$convertWithRequestBuilder(this, r100, r101);
        }

        @Override // com.bytedance.retrofit2.Converter
        public final /* synthetic */ boolean needRequestBuilder() {
            return Converter.CC.$default$needRequestBuilder(this);
        }

        static {
            INSTANCE = new RequestBodyConverter();
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ TypedOutput convert(TypedOutput r100) throws IOException {
            return convert2(r100);
        }
    }

    public static final class StreamingResponseBodyConverter implements Converter<TypedInput, TypedInput> {
        static final StreamingResponseBodyConverter INSTANCE = null;

        public StreamingResponseBodyConverter() {
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public TypedInput convert2(TypedInput r100) {
            return r100;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.retrofit2.mime.TypedInput, java.lang.Object] */
        @Override // com.bytedance.retrofit2.Converter
        public final /* synthetic */ TypedInput convertWithRequestBuilder(TypedInput r100, RequestBuilder r101) {
            return Converter.CC.$default$convertWithRequestBuilder(this, r100, r101);
        }

        @Override // com.bytedance.retrofit2.Converter
        public final /* synthetic */ boolean needRequestBuilder() {
            return Converter.CC.$default$needRequestBuilder(this);
        }

        static {
            INSTANCE = new StreamingResponseBodyConverter();
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ TypedInput convert(TypedInput r100) throws IOException {
            return convert2(r100);
        }
    }

    public static final class StringConverter implements Converter<String, String> {
        static final StringConverter INSTANCE = null;

        public StringConverter() {
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public String convert2(String r100) throws IOException {
            return r100;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.String] */
        @Override // com.bytedance.retrofit2.Converter
        public final /* synthetic */ String convertWithRequestBuilder(String r100, RequestBuilder r101) {
            return Converter.CC.$default$convertWithRequestBuilder(this, r100, r101);
        }

        @Override // com.bytedance.retrofit2.Converter
        public final /* synthetic */ boolean needRequestBuilder() {
            return Converter.CC.$default$needRequestBuilder(this);
        }

        static {
            INSTANCE = new StringConverter();
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ String convert(String r100) throws IOException {
            return convert2(r100);
        }
    }

    public static final class StringResponseBodyConverter implements Converter<TypedInput, String> {
        static final StringResponseBodyConverter INSTANCE = null;

        public StringResponseBodyConverter() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.String] */
        @Override // com.bytedance.retrofit2.Converter
        public final /* synthetic */ String convertWithRequestBuilder(TypedInput r100, RequestBuilder r101) {
            return Converter.CC.$default$convertWithRequestBuilder(this, r100, r101);
        }

        @Override // com.bytedance.retrofit2.Converter
        public final /* synthetic */ boolean needRequestBuilder() {
            return Converter.CC.$default$needRequestBuilder(this);
        }

        static {
            INSTANCE = new StringResponseBodyConverter();
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public String convert2(TypedInput r100) throws IOException {
            if ((r100 instanceof TypedByteArray) == false) goto L9;
            String r101 = "UTF-8";
            if (r100.mimeType() == null) goto L8;
            r101 = MimeUtil.parseCharset(r100.mimeType(), "UTF-8");
        L8:
            return new String(((TypedByteArray) r100).getBytes(), r101);
        L9:
            return null;
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ String convert(TypedInput r100) throws IOException {
            return convert2(r100);
        }
    }

    public static final class ToStringConverter implements Converter<Object, String> {
        static final ToStringConverter INSTANCE = null;

        public ToStringConverter() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.String] */
        @Override // com.bytedance.retrofit2.Converter
        public final /* synthetic */ String convertWithRequestBuilder(Object r100, RequestBuilder r101) {
            return Converter.CC.$default$convertWithRequestBuilder(this, r100, r101);
        }

        @Override // com.bytedance.retrofit2.Converter
        public final /* synthetic */ boolean needRequestBuilder() {
            return Converter.CC.$default$needRequestBuilder(this);
        }

        static {
            INSTANCE = new ToStringConverter();
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ String convert(Object r100) throws IOException {
            return convert2(r100);
        }

        @Override // com.bytedance.retrofit2.Converter
        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public String convert2(Object r100) {
            return r100.toString();
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class UnitResponseBodyConverter implements Converter<TypedInput, Unit> {
        static final UnitResponseBodyConverter INSTANCE = null;

        public UnitResponseBodyConverter() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, kotlin.Unit] */
        @Override // com.bytedance.retrofit2.Converter
        public final /* synthetic */ Unit convertWithRequestBuilder(TypedInput r100, RequestBuilder r101) {
            return Converter.CC.$default$convertWithRequestBuilder(this, r100, r101);
        }

        @Override // com.bytedance.retrofit2.Converter
        public final /* synthetic */ boolean needRequestBuilder() {
            return Converter.CC.$default$needRequestBuilder(this);
        }

        static {
            INSTANCE = new UnitResponseBodyConverter();
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public Unit convert2(TypedInput r100) {
            r100.in().close();     // Catch: IOException -> L4
        L7:
            return Unit.INSTANCE;
        L4:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ Unit convert(TypedInput r100) throws IOException {
            return convert2(r100);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class VoidResponseBodyConverter implements Converter<TypedInput, Void> {
        static final VoidResponseBodyConverter INSTANCE = null;

        public VoidResponseBodyConverter() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Void] */
        @Override // com.bytedance.retrofit2.Converter
        public final /* synthetic */ Void convertWithRequestBuilder(TypedInput r100, RequestBuilder r101) {
            return Converter.CC.$default$convertWithRequestBuilder(this, r100, r101);
        }

        @Override // com.bytedance.retrofit2.Converter
        public final /* synthetic */ boolean needRequestBuilder() {
            return Converter.CC.$default$needRequestBuilder(this);
        }

        static {
            INSTANCE = new VoidResponseBodyConverter();
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public Void convert2(TypedInput r100) throws IOException {
            InputStream r101 = r100.in();
            if (r101 == null) goto L7;
            r101.close();
            return null;
        L7:
            return null;
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ Void convert(TypedInput r100) throws IOException {
            return convert2(r100);
        }
    }

    public BuiltInConverters() {
        this.checkForKotlinUnit = true;
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public Converter<?, Header> headerConverter(Type r100, Annotation[] r101, Retrofit r102) {
        if (r100 == Header.class) goto L5;
        return null;
    L5:
        return HeaderConverter.INSTANCE;
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public Converter<?, Object> objectConverter(Type r100, Annotation[] r101, Retrofit r102) {
        if (r100 == Object.class) goto L5;
        return null;
    L5:
        return ObjectConverter.INSTANCE;
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    @Nullable
    public Converter<TypedInput, ?> responseBodyConverter(Type r100, Annotation[] r101, Retrofit r102) {
        if (r100 != TypedInput.class) goto L11;
        if (Utils.isAnnotationPresent(r101, Streaming.class) == false) goto L9;
        return StreamingResponseBodyConverter.INSTANCE;
    L9:
        return BufferingResponseBodyConverter.INSTANCE;
    L11:
        if (r100 != String.class) goto L15;
        return StringResponseBodyConverter.INSTANCE;
    L15:
        if (r100 != Void.class) goto L19;
        return VoidResponseBodyConverter.INSTANCE;
    L19:
        if (this.checkForKotlinUnit == true) goto L21;
        return null;
    L21:
        if (r100 != Unit.class) goto L30;
        return UnitResponseBodyConverter.INSTANCE;
    L24:
        this.checkForKotlinUnit = false;
        return null;
    L30:
        return null;
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public Converter<?, String> stringConverter(Type r100, Annotation[] r101, Retrofit r102) {
        if (r100 == String.class) goto L5;
        return null;
    L5:
        return StringConverter.INSTANCE;
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    @Nullable
    public Converter<?, TypedOutput> requestBodyConverter(Type r100, Annotation[] r101, Annotation[] r102, Retrofit r103) {
        if (TypedOutput.class.isAssignableFrom(Utils.getRawType(r100)) == true) goto L5;
        return null;
    L5:
        return RequestBodyConverter.INSTANCE;
    }
}
