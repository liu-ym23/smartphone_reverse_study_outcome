package com.larus.im.internal.jni.callback;

import androidx.exifinterface.media.ExifInterface;
import com.larus.im.internal.jni.bean.OmniIMError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/larus/im/internal/jni/callback/OmniIMCallback;", ExifInterface.GPS_DIRECTION_TRUE, "", "onSuccess", "", "result", "(Ljava/lang/Object;)V", "onFailure", "error", "Lcom/larus/im/internal/jni/bean/OmniIMError;", "onLocalFinish", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OmniIMCallback<T> {

    /* JADX INFO: loaded from: classes29.dex */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <T> void onFailure(OmniIMCallback<T> r100, OmniIMError r101) {
            Intrinsics.checkNotNullParameter(r101, "error");
        }

        public static <T> void onLocalFinish(OmniIMCallback<T> r100, T r101) {
        }

        public static <T> void onSuccess(OmniIMCallback<T> r100, T r101) {
        }
    }

    void onFailure(OmniIMError r100);

    void onLocalFinish(T r100);

    void onSuccess(T r100);
}
