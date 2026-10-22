package com.facebook.keyframes.deserializers;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public abstract class AbstractListDeserializer<T> {
    public AbstractListDeserializer() {
    }

    public abstract T readObjectImpl(JsonReader r100) throws IOException;

    public final List<T> readList(JsonReader r100) throws IOException {
        ArrayList r101 = new ArrayList();
        r100.beginArray();
    L4:
        if (r100.hasNext() == false) goto L6;
        r101.add(readObjectImpl(r100));
        goto L4
    L6:
        r100.endArray();
        return r101;
    }
}
