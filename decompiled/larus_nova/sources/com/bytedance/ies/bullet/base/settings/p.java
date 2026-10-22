package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/p;", "", "", "", "whiteList", "[Ljava/lang/String;", "b", "()[Ljava/lang/String;", "setWhiteList", "([Ljava/lang/String;)V", "", "", "forceDegradeCodeList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setForceDegradeCodeList", "(Ljava/util/List;)V", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class p {

    @SerializedName("degrade_verify_code_list")
    private List<Integer> forceDegradeCodeList;

    @SerializedName("white_list")
    private String[] whiteList;

    public p() {
        this.forceDegradeCodeList = CollectionsKt.emptyList();
    }

    public final List<Integer> a() {
        return this.forceDegradeCodeList;
    }

    public final String[] b() {
        return this.whiteList;
    }
}
