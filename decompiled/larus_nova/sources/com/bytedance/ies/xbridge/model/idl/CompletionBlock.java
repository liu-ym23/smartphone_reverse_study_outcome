package com.bytedance.ies.xbridge.model.idl;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00018\u0000H'¢\u0006\u0002\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00028\u00002\b\b\u0002\u0010\b\u001a\u00020\tH&¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/xbridge/model/idl/CompletionBlock;", ExifInterface.LATITUDE_SOUTH, "Lcom/bytedance/ies/xbridge/model/idl/XBaseResultModel;", "", "onFailure", "", "code", "", "msg", "", "data", "(ILjava/lang/String;Lcom/bytedance/ies/xbridge/model/idl/XBaseResultModel;)V", "onRawSuccess", "(Lcom/bytedance/ies/xbridge/model/idl/XBaseResultModel;)V", "onSuccess", "result", "(Lcom/bytedance/ies/xbridge/model/idl/XBaseResultModel;Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface CompletionBlock<S extends XBaseResultModel> {

    public static final class a {
        public static /* synthetic */ void b(CompletionBlock r100, XBaseResultModel r101) {
            r100.onSuccess(r101, "");
        }

        public static /* synthetic */ void a(CompletionBlock r100, int r101, String r102, com.bytedance.locallife.bridge.common.method.a r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r102 = "";
        L6:
            if ((r104 & 4) == 0) goto L8;
            r103 = null;
        L8:
            r100.onFailure(r101, r102, r103);
        }
    }

    void onFailure(int r100, String r101, S r102);

    @Deprecated(level = DeprecationLevel.WARNING, message = "just for compatibility with old bridge")
    void onRawSuccess(S r100);

    void onSuccess(S r100, String r101);
}
