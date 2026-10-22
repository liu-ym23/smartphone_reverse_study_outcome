package com.ss.android.ugc.aweme.discover.commodity.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/utils/MapWriter;", "Lcom/ss/android/ugc/aweme/discover/commodity/utils/MapWriterInner;", "<init>", "()V", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
public final class MapWriter extends MapWriterInner {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Object> f450376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f450377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f450378d;

    @Override // com.google.gson.stream.JsonWriter, java.io.Flushable
    public final void flush() throws IOException {
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter nullValue() throws IOException {
        b(null);
        return this;
    }

    public final Object a() {
        List<Object> r100 = this.f450376b;
        return CollectionsKt.getOrNull(r100, ((ArrayList) r100).size() - 1);
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter beginArray() throws IOException {
        LinkedList r100 = new LinkedList();
        b(r100);
        ((ArrayList) this.f450376b).add(r100);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter beginObject() throws IOException {
        HashMap r100 = new HashMap();
        b(r100);
        ((ArrayList) this.f450376b).add(r100);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if ((!this.f450376b.isEmpty()) == true) goto L6;
        return;
    L6:
        throw new IOException("Incomplete document");
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter endArray() throws IOException {
        if (((ArrayList) this.f450376b).isEmpty() == true) goto L18;
        if (this.f450377c != null) goto L18;
        Object r100 = a();
        if (r100 != null) goto L9;
    L11:
        boolean r101 = false;
    L12:
        if (r101 == false) goto L16;
        List<Object> r102 = this.f450376b;
        ListProtector.remove(r102, ((ArrayList) r102).size() - 1);
        return this;
    L16:
        throw new IllegalStateException();
    L9:
        if ((r100 instanceof List) == false) goto L11;
        r101 = true;
    L18:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter endObject() throws IOException {
        if (((ArrayList) this.f450376b).isEmpty() == true) goto L18;
        if (this.f450377c != null) goto L18;
        Object r100 = a();
        if (r100 != null) goto L9;
    L11:
        boolean r101 = false;
    L12:
        if (r101 == false) goto L16;
        List<Object> r102 = this.f450376b;
        ListProtector.remove(r102, ((ArrayList) r102).size() - 1);
        return this;
    L16:
        throw new IllegalStateException();
    L9:
        if ((r100 instanceof Map) == false) goto L11;
        r101 = true;
    L18:
        throw new IllegalStateException();
    }

    public MapWriter() {
        this.f450376b = new ArrayList();
    }

    public final void b(Object r100) {
        if ((r100 instanceof Number) == false) goto L17;
        Number r101 = (Number) r100;
        String r102 = r101.toString();
        if (Intrinsics.areEqual(r102, String.valueOf(r101.intValue())) == false) goto L8;
        r100 = Integer.valueOf(r101.intValue());
        goto L17
    L8:
        if (Intrinsics.areEqual(r102, String.valueOf(r101.longValue())) == false) goto L11;
        r100 = Long.valueOf(r101.longValue());
        goto L17
    L11:
        if (Intrinsics.areEqual(r102, String.valueOf(r101.floatValue())) == false) goto L14;
        r100 = Float.valueOf(r101.floatValue());
        goto L17
    L14:
        if (Intrinsics.areEqual(r102, String.valueOf(r101.doubleValue())) == false) goto L16;
        r100 = Double.valueOf(r101.doubleValue());
        goto L17
    L16:
        r100 = null;
    L17:
        boolean r103 = true;
        if (this.f450377c == null) goto L34;
        if (r100 == null) goto L21;
    L22:
        Object r104 = a();
        if (r104 != null) goto L25;
    L27:
        r103 = false;
    L28:
        if (r103 == false) goto L32;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any?>");
        Map r105 = TypeIntrinsics.asMutableMap(r104);
        String r106 = this.f450377c;
        Intrinsics.checkNotNull(r106);
        r105.put(r106, r100);
    L30:
        this.f450377c = null;
        return;
    L32:
        throw new IllegalStateException();
    L25:
        if ((r104 instanceof Map) == false) goto L27;
    L21:
        if (getSerializeNulls() == false) goto L30;
    L34:
        if (((ArrayList) this.f450376b).isEmpty() == false) goto L36;
        this.f450378d = r100;
        return;
    L36:
        Object r107 = a();
        if (r107 != null) goto L39;
    L41:
        r103 = false;
    L42:
        if (r103 == false) goto L46;
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any?>");
        TypeIntrinsics.asMutableList(r107).add(r100);
        return;
    L46:
        throw new IllegalStateException();
    L39:
        if ((r107 instanceof List) == false) goto L41;
        goto L41
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter name(String r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (((ArrayList) this.f450376b).isEmpty() == true) goto L18;
        if (this.f450377c != null) goto L18;
        Object r101 = a();
        if (r101 != null) goto L9;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == false) goto L16;
        this.f450377c = r100;
        return this;
    L16:
        throw new IllegalStateException();
    L9:
        if ((r101 instanceof Map) == false) goto L11;
        r102 = true;
    L18:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter value(Number r100) throws IOException {
        if (r100 != null) goto L6;
        b(null);
        return this;
    L6:
        if (isLenient() == true) goto L14;
        double r101 = r100.doubleValue();
        if (Double.isNaN(r101) == true) goto L13;
        if (Double.isInfinite(r101) == false) goto L14;
    L13:
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + r100);
    L14:
        b(r100);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter value(double r100) throws IOException {
        if (isLenient() == false) goto L5;
    L11:
        b(Double.valueOf(r100));
        return this;
    L5:
        if (Double.isNaN(r100) == true) goto L10;
        if (Double.isInfinite(r100) == false) goto L11;
    L10:
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + r100);
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter value(String r100) throws IOException {
        if (r100 != null) goto L4;
        b(null);
    L5:
        return this;
    L4:
        b(r100);
        goto L5
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter value(long r100) throws IOException {
        b(Long.valueOf(r100));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter value(boolean r100) throws IOException {
        b(Boolean.valueOf(r100));
        return this;
    }
}
