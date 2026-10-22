package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;

    public static final class Adapter<E> extends TypeAdapter<Collection<E>> {
        private final ObjectConstructor<? extends Collection<E>> constructor;
        private final TypeAdapter<E> elementTypeAdapter;

        @Override // com.google.gson.TypeAdapter
        public Collection<E> read(JsonReader r100) throws IOException {
            if (r100.peek() != JsonToken.NULL) goto L6;
            r100.nextNull();
            return null;
        L6:
            Collection<E> r101 = this.constructor.construct();
            r100.beginArray();
        L8:
            if (r100.hasNext() == false) goto L10;
            r101.add(this.elementTypeAdapter.read(r100));
            goto L8
        L10:
            r100.endArray();
            return r101;
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ Object read(JsonReader r100) throws IOException {
            return read(r100);
        }

        public void write(JsonWriter r100, Collection<E> r101) throws IOException {
            if (r101 != null) goto L5;
            r100.nullValue();
            return;
        L5:
            r100.beginArray();
            Iterator<E> r102 = r101.iterator();
        L7:
            if (r102.hasNext() == false) goto L9;
            E r103 = r102.next();
            this.elementTypeAdapter.write(r100, r103);
            goto L7
        L9:
            r100.endArray();
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ void write(JsonWriter r100, Object r101) throws IOException {
            write(r100, (Collection) r101);
        }

        public Adapter(Gson r100, Type r101, TypeAdapter<E> r102, ObjectConstructor<? extends Collection<E>> r103) {
            this.elementTypeAdapter = new TypeAdapterRuntimeTypeWrapper(r100, r102, r101);
            this.constructor = r103;
        }
    }

    public CollectionTypeAdapterFactory(ConstructorConstructor r100) {
        this.constructorConstructor = r100;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r100, TypeToken<T> r101) {
        Type r102 = r101.getType();
        Class<? super T> r103 = r101.getRawType();
        if (Collection.class.isAssignableFrom(r103) == true) goto L6;
        return null;
    L6:
        Type r104 = C$Gson$Types.getCollectionElementType(r102, r103);
        return new Adapter(r100, r104, r100.getAdapter(TypeToken.get(r104)), this.constructorConstructor.get(r101));
    }
}
