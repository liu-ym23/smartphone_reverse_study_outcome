package defpackage;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"LGetDownloadGiftAssetsResultModel_GetDownloadGiftAssetsDataSerializableObjectImpl;", "LGetDownloadGiftAssetsResultModel$b;", "", "code", "Ljava/lang/Integer;", "getCode", "()Ljava/lang/Integer;", "setCode", "(Ljava/lang/Integer;)V", "", "path", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GetDownloadGiftAssetsResultModel_GetDownloadGiftAssetsDataSerializableObjectImpl implements GetDownloadGiftAssetsResultModel.b {

    @SerializedName("code")
    private Integer code;

    @SerializedName("path")
    private String path;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"LGetDownloadGiftAssetsResultModel_GetDownloadGiftAssetsDataSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(GetDownloadGiftAssetsResultModel_GetDownloadGiftAssetsDataSerializableObjectImpl.class);
        }
    }

    public GetDownloadGiftAssetsResultModel_GetDownloadGiftAssetsDataSerializableObjectImpl() {
    }
}
