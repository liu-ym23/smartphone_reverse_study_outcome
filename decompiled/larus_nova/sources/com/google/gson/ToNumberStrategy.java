package com.google.gson;

import com.google.gson.stream.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface ToNumberStrategy {
    Number readNumber(JsonReader r100) throws IOException;
}
