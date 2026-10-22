package com.ss.android.lark.movable.attatchment;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J(\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/movable/attatchment/ImageInfoDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/ss/android/lark/movable/attatchment/ImageInfo;", "<init>", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/google/gson/JsonDeserializationContext;", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageInfoDeserializer implements JsonDeserializer<k> {
    public ImageInfoDeserializer() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final k deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        if (r100 == null) goto L4;
        String r103 = r100.getAsString();
    L6:
        return (k) GsonProtectorUtils.fromJson(new Gson(), r103, k.class);
    L4:
        r103 = null;
        goto L6
    }
}
