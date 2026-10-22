package com.bytedance.awemeopen.bizmodels.feed;

import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/IntAsBooleanAdapter;", "Lcom/google/gson/TypeAdapter;", "", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class IntAsBooleanAdapter extends TypeAdapter<Boolean> {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f198173a = null;

        static {
            int[] r100 = new int[JsonToken.values().length];
            r100[JsonToken.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[JsonToken.NULL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[JsonToken.NUMBER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f198173a = r100;
        }
    }

    public IntAsBooleanAdapter() {
    }

    @Override // com.google.gson.TypeAdapter
    public final Boolean read(JsonReader r100) {
        Intrinsics.checkNotNullParameter(r100, "in");
        JsonToken r101 = r100.peek();
        if (r101 != null) goto L5;
        int r102 = -1;
    L6:
        boolean r103 = true;
        if (r102 == 1) goto L21;
        if (r102 != 2) goto L11;
        r100.nextNull();
        return null;
    L11:
        if (r102 != 3) goto L18;
        if (r100.nextInt() != 0) goto L22;
        r103 = false;
    L22:
        return Boolean.valueOf(r103);
    L18:
        throw new JsonParseException("Expected BOOLEAN or NUMBER but was " + r101);
    L21:
        return Boolean.valueOf(r100.nextBoolean());
    L5:
        r102 = a.f198173a[r101.ordinal()];
        goto L6
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, Boolean r101) {
        Boolean r102 = r101;
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        if (r102 != null) goto L5;
        r100.nullValue();
        return;
    L5:
        r100.value(r102.booleanValue());
    }
}
