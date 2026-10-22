package com.google.gson;

import com.google.gson.stream.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface ToNumberStrategy {
    Number readNumber(JsonReader r1) throws IOException;
}
