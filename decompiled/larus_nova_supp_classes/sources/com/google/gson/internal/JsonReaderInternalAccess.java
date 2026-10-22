package com.google.gson.internal;

import com.google.gson.stream.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class JsonReaderInternalAccess {
    public static JsonReaderInternalAccess INSTANCE;

    public JsonReaderInternalAccess() {
    }

    public abstract void promoteNameToValue(JsonReader r1) throws IOException;
}
