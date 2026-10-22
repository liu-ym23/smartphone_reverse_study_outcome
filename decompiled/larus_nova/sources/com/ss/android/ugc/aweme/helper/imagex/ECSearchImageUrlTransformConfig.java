package com.ss.android.ugc.aweme.helper.imagex;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/ss/android/ugc/aweme/helper/imagex/ECSearchImageUrlTransformConfig;", "Ljava/io/Serializable;", "()V", "rules", "", "Lcom/ss/android/ugc/aweme/helper/imagex/ECSearchImageUrlTransformRule;", "getRules", "()Ljava/util/List;", "setRules", "(Ljava/util/List;)V", "rulesVersion", "", "getRulesVersion", "()Ljava/lang/String;", "setRulesVersion", "(Ljava/lang/String;)V", "Companion", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchImageUrlTransformConfig implements Serializable {
    public static final Companion Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("rules")
    private List<ECSearchImageUrlTransformRule> rules;

    @SerializedName("rules_version")
    private String rulesVersion;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/helper/imagex/ECSearchImageUrlTransformConfig$Companion;", "", "()V", "serialVersionUID", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public ECSearchImageUrlTransformConfig() {
    }

    public final List<ECSearchImageUrlTransformRule> getRules() {
        return this.rules;
    }

    public final String getRulesVersion() {
        return this.rulesVersion;
    }

    public final void setRules(List<ECSearchImageUrlTransformRule> r100) {
        this.rules = r100;
    }

    public final void setRulesVersion(String r100) {
        this.rulesVersion = r100;
    }
}
