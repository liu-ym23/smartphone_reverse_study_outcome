package com.ss.android.ugc.effectmanager.knadapt;

import android.accounts.NetworkErrorException;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.ss.android.ugc.effectmanager.common.EffectRequest;
import com.ss.android.ugc.effectmanager.common.ErrorConstants;
import com.ss.android.ugc.effectmanager.common.exception.StatusCodeException;
import com.ss.android.ugc.effectmanager.common.listener.IJsonConverter;
import com.ss.android.ugc.effectmanager.common.network.EffectNetWorkerWrapper;
import com.ss.android.ugc.effectmanager.common.utils.CloseUtil;
import com.ss.ugc.effectplatform.model.e;
import com.ss.ugc.effectplatform.util.l;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aM\u0010\u000b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u0000*\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\f\u001aC\u0010\r\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u0000*\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/ugc/effectplatform/model/e;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ss/android/ugc/effectmanager/common/network/EffectNetWorkerWrapper;", "Lcom/ss/android/ugc/effectmanager/common/EffectRequest;", "request", "Ljava/io/InputStream;", "inputStream", "Lcom/ss/android/ugc/effectmanager/common/listener/IJsonConverter;", "jsonConverter", "Ljava/lang/Class;", "cls", "parse", "(Lcom/ss/android/ugc/effectmanager/common/network/EffectNetWorkerWrapper;Lcom/ss/android/ugc/effectmanager/common/EffectRequest;Ljava/io/InputStream;Lcom/ss/android/ugc/effectmanager/common/listener/IJsonConverter;Ljava/lang/Class;)Lcom/ss/ugc/effectplatform/model/e;", "execute", "(Lcom/ss/android/ugc/effectmanager/common/network/EffectNetWorkerWrapper;Lcom/ss/android/ugc/effectmanager/common/EffectRequest;Lcom/ss/android/ugc/effectmanager/common/listener/IJsonConverter;Ljava/lang/Class;)Lcom/ss/ugc/effectplatform/model/e;", "effectmanager_release"}, k = 2, mv = {1, 4, 0})
public final class AdapterExtKt {
    public static final <T extends e<?>> T execute(EffectNetWorkerWrapper r100, EffectRequest r101, IJsonConverter r102, Class<T> r103) throws Exception {
        InputStream r104 = r100.getIEffectNetWorker().execute(r101);
        if (r104 == null) goto L13;
        T r105 = (T) r102.convertJsonToObj(r104, r103);
        CloseUtil.close(r104);
        if (r105 == null) goto L12;
        int r106 = r105.getStatusCode();
        if (r106 != 0) goto L10;
        return r105;
    L10:
        throw new StatusCodeException(r106, r105.getResponseMessage());
    L12:
        throw new JSONException(ErrorConstants.EXCEPTION_JSON_CONVERT);
    L13:
        int r107 = l.f458042a;
        if (l.a(r100.getContext()) == false) goto L29;
        String r108 = null;
        if (r101 == null) goto L18;
        String r109 = r101.getErrorMsg();
    L20:
        if (TextUtils.isEmpty(r109) == true) goto L27;
        if (r101 == null) goto L25;
        r108 = r101.getErrorMsg();
    L25:
        throw new NetworkErrorException(r108);
    L27:
        throw new NetworkErrorException(ErrorConstants.EXCEPTION_DOWNLOAD_ERROR);
    L18:
        r109 = null;
        goto L20
    L29:
        throw new Exception("network unavailable");
    }

    public static final <T extends e<?>> T parse(EffectNetWorkerWrapper r100, EffectRequest r101, InputStream r102, IJsonConverter r103, Class<T> r104) throws Exception {
        if (r102 != null) goto L4;
        Intrinsics.throwNpe();
    L4:
        T r105 = (T) r103.convertJsonToObj(r102, r104);
        if (r105 == null) goto L12;
        int r106 = r105.getStatusCode();
        if (r106 != 0) goto L10;
        return r105;
    L10:
        throw new StatusCodeException(r106, r105.getResponseMessage());
    L12:
        throw new JSONException(ErrorConstants.EXCEPTION_JSON_CONVERT);
    }
}
