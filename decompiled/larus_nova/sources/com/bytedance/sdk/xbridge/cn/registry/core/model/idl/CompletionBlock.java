package com.bytedance.sdk.xbridge.cn.registry.core.model.idl;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00018\u0000H'¢\u0006\u0002\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00028\u00002\b\b\u0002\u0010\b\u001a\u00020\tH&¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", ExifInterface.LATITUDE_SOUTH, "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;", "", "onFailure", "", "code", "", "msg", "", "data", "(ILjava/lang/String;Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;)V", "onRawSuccess", "(Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;)V", "onSuccess", "result", "(Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface CompletionBlock<S extends XBaseResultModel> {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void onRawSuccess$default(CompletionBlock r100, XBaseResultModel r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = null;
        L6:
            r100.onRawSuccess(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onRawSuccess");
        }

        public static /* synthetic */ void onSuccess$default(CompletionBlock r100, XBaseResultModel r101, String r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = "";
        L6:
            r100.onSuccess(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSuccess");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void onFailure$default(CompletionBlock r100, int r101, String r102, XBaseResultModel r103, int r104, Object r105) {
            if (r105 != null) goto L12;
            if ((r104 & 2) == 0) goto L7;
            r102 = "";
        L7:
            if ((r104 & 4) == 0) goto L9;
            r103 = null;
        L9:
            r100.onFailure(r101, r102, r103);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFailure");
        }
    }

    void onFailure(int r100, String r101, S r102);

    @Deprecated(level = DeprecationLevel.WARNING, message = "just for compatibility with old bridge")
    void onRawSuccess(S r100);

    void onSuccess(S r100, String r101);
}
