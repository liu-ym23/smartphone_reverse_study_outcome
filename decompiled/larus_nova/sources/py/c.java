package py;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\r\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R$\u0010\u0014\u001a\u0004\u0018\u00010\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R:\u0010\u001d\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u0015j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u0001`\u00178&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\b\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\b\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lpy/c;", "Lvh7/c;", "", "getCustomVerify", "()Ljava/lang/String;", "setCustomVerify", "(Ljava/lang/String;)V", "getCustomVerify$annotations", "()V", "customVerify", "getEnterpriseVerifyReason", "setEnterpriseVerifyReason", "getEnterpriseVerifyReason$annotations", "enterpriseVerifyReason", "Lpy/k;", "getAuthenticationBadge", "()Lpy/k;", "setAuthenticationBadge", "(Lpy/k;)V", "getAuthenticationBadge$annotations", "authenticationBadge", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getLevelList", "()Ljava/util/List;", "setLevelList", "(Ljava/util/List;)V", "getLevelList$annotations", "levelList", "Lpy/a;", "getAccountTypeInfo", "()Lpy/a;", "setAccountTypeInfo", "(Lpy/a;)V", "getAccountTypeInfo$annotations", "accountTypeInfo", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface c extends vh7.c<c> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "account_type_info")
    py.a getAccountTypeInfo();

    @FieldName(name = "authentication_badge")
    k getAuthenticationBadge();

    @FieldName(name = "custom_verify")
    String getCustomVerify();

    @FieldName(name = "enterprise_verify_reason")
    String getEnterpriseVerifyReason();

    @FieldName(name = "level_list")
    List<Integer> getLevelList();

    @FieldName(name = "account_type_info#setter")
    void setAccountTypeInfo(py.a r100);

    @FieldName(name = "authentication_badge#setter")
    void setAuthenticationBadge(k r100);

    @FieldName(name = "custom_verify#setter")
    void setCustomVerify(String r100);

    @FieldName(name = "enterprise_verify_reason#setter")
    void setEnterpriseVerifyReason(String r100);

    @FieldName(name = "level_list#setter")
    void setLevelList(List<Integer> r100);
}
