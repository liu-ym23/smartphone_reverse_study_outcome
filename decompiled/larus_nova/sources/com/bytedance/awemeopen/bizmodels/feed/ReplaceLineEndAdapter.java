package com.bytedance.awemeopen.bizmodels.feed;

import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/ReplaceLineEndAdapter;", "Lcom/google/gson/TypeAdapter;", "", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class ReplaceLineEndAdapter extends TypeAdapter<String> {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f198174a = null;

        static {
            int[] r100 = new int[JsonToken.values().length];
            r100[JsonToken.NULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[JsonToken.STRING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f198174a = r100;
        }
    }

    public ReplaceLineEndAdapter() {
    }

    @Override // com.google.gson.TypeAdapter
    public final String read(JsonReader r100) {
        Intrinsics.checkNotNullParameter(r100, "in");
        JsonToken r101 = r100.peek();
        if (r101 != null) goto L5;
        int r102 = -1;
    L7:
        if (r102 != 1) goto L9;
        r100.nextNull();
        return null;
    L9:
        if (r102 != 2) goto L15;
        String r103 = r100.nextString();
        if (StringsKt.contains$default(r103, "\r\n", false, 2, null) == false) goto L18;
        r103 = new Regex("\r\n").replace(r103, "\n");
    L18:
        return r103;
    L15:
        throw new JsonSyntaxException("expect STRING, but got " + r101.name() + " at " + r100.getPath());
    L5:
        r102 = a.f198174a[r101.ordinal()];
        goto L7
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.value(r101);
    }
}
