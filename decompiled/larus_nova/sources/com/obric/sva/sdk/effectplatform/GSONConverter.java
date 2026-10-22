package com.obric.sva.sdk.effectplatform;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.obric.sva.sdk.network.InputStreamByteRead;
import com.ss.ugc.effectplatform.bridge.jsonconverter.IAndroidJsonConverter;
import com.ss.ugc.effectplatform.bridge.network.ByteReadStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u000bH\u0016¢\u0006\u0002\u0010\fJ)\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u000bH\u0016¢\u0006\u0002\u0010\u000fJ\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u000e\"\u0004\b\u0000\u0010\u00072\u0006\u0010\u0011\u001a\u0002H\u0007H\u0016¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/sva/sdk/effectplatform/GSONConverter;", "Lcom/ss/ugc/effectplatform/bridge/jsonconverter/IAndroidJsonConverter;", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "convertJsonToObj", ExifInterface.GPS_DIRECTION_TRUE, "stream", "Lcom/ss/ugc/effectplatform/bridge/network/ByteReadStream;", "cls", "Ljava/lang/Class;", "(Lcom/ss/ugc/effectplatform/bridge/network/ByteReadStream;Ljava/lang/Class;)Ljava/lang/Object;", "json", "", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "convertObjToJson", "any", "(Ljava/lang/Object;)Ljava/lang/String;", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class GSONConverter implements IAndroidJsonConverter {
    private final Gson gson;

    public GSONConverter() {
        this.gson = new Gson();
    }

    @Override // com.ss.ugc.effectplatform.bridge.jsonconverter.IAndroidJsonConverter
    public <T> String convertObjToJson(T r100) {
        return GsonProtectorUtils.toJson(this.gson, r100);
    }

    @Override // com.ss.ugc.effectplatform.bridge.jsonconverter.IAndroidJsonConverter
    public <T> T convertJsonToObj(ByteReadStream r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "stream");
        Intrinsics.checkNotNullParameter(r101, "cls");
        if ((r100 instanceof InputStreamByteRead) == false) goto L5;
        InputStreamReader r102 = new InputStreamReader(((InputStreamByteRead) r100).getInputStream(), StandardCharsets.UTF_8);
        GsonProtectorUtils.fromJson(this.gson, r102, r101);
    L7:
        return (T) GsonProtectorUtils.fromJson(this.gson, r102, r101);
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.ss.ugc.effectplatform.bridge.jsonconverter.IAndroidJsonConverter
    public <T> T convertJsonToObj(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "cls");
        return (T) GsonProtectorUtils.fromJson(this.gson, r100, r101);
    }
}
