package com.ss.android.ugc.effectmanager.knadapt;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.ugc.effectmanager.common.listener.IJsonConverter;
import com.ss.ugc.effectplatform.bridge.jsonconverter.IAndroidJsonConverter;
import com.ss.ugc.effectplatform.bridge.network.ByteReadStream;
import com.ss.ugc.effectplatform.bridge.network.c;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH\u0016¢\u0006\u0002\u0010\u000bJ)\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\u0006\u0010\f\u001a\u00020\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH\u0016¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u000f\u001a\u0004\u0018\u00010\r\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0010\u001a\u0002H\u0006H\u0016¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/ugc/effectmanager/knadapt/KNJsonConverter;", "Lcom/ss/ugc/effectplatform/bridge/jsonconverter/IAndroidJsonConverter;", "jsonConverter", "Lcom/ss/android/ugc/effectmanager/common/listener/IJsonConverter;", "(Lcom/ss/android/ugc/effectmanager/common/listener/IJsonConverter;)V", "convertJsonToObj", ExifInterface.GPS_DIRECTION_TRUE, "stream", "Lcom/ss/ugc/effectplatform/bridge/network/ByteReadStream;", "cls", "Ljava/lang/Class;", "(Lcom/ss/ugc/effectplatform/bridge/network/ByteReadStream;Ljava/lang/Class;)Ljava/lang/Object;", "json", "", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "convertObjToJson", "object", "(Ljava/lang/Object;)Ljava/lang/String;", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class KNJsonConverter implements IAndroidJsonConverter {
    private final IJsonConverter jsonConverter;

    public KNJsonConverter(IJsonConverter r100) {
        this.jsonConverter = r100;
    }

    @Override // com.ss.ugc.effectplatform.bridge.jsonconverter.IAndroidJsonConverter
    public <T> String convertObjToJson(T r100) {
        return this.jsonConverter.convertObjToJson(r100);
    }

    @Override // com.ss.ugc.effectplatform.bridge.jsonconverter.IAndroidJsonConverter
    public <T> T convertJsonToObj(String r100, Class<T> r101) {
        Charset r102 = Charsets.UTF_8;
        ByteArrayInputStream r103 = new ByteArrayInputStream(r100.getBytes(r102));
        T r104 = (T) this.jsonConverter.convertJsonToObj(new ByteArrayInputStream(r100.getBytes(r102)), r101);
        CloseableKt.closeFinally(r103, null);
        return r104;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);
        throw th;
    }

    @Override // com.ss.ugc.effectplatform.bridge.jsonconverter.IAndroidJsonConverter
    public <T> T convertJsonToObj(ByteReadStream r100, Class<T> r101) {
        return (T) this.jsonConverter.convertJsonToObj(new c(r100), r101);
    }
}
