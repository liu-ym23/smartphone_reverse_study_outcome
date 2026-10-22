package com.ss.ugc.effectplatform.listener;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ec.core.event.a;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/ugc/effectplatform/listener/IEffectPlatformBaseListener;", ExifInterface.GPS_DIRECTION_TRUE, "", "onFail", "", "failedResult", a.KEY_EXCEPTION, "Lcom/ss/ugc/effectplatform/model/ExceptionResult;", "(Ljava/lang/Object;Lcom/ss/ugc/effectplatform/model/ExceptionResult;)V", "onSuccess", "response", "(Ljava/lang/Object;)V", "effect_base_release"}, k = 1, mv = {1, 1, 16})
public interface IEffectPlatformBaseListener<T> {
    void onFail(T r100, ExceptionResult r101);

    void onSuccess(T r100);
}
