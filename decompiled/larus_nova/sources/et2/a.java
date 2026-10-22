package et2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Let2/a;", "", "", "templateCacheMode", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setTemplateCacheMode", "(I)V", "<init>", "()V", "dslservice-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("use_template_cache")
    private int templateCacheMode;

    public a() {
        this.templateCacheMode = 1;
    }

    public final int a() {
        return this.templateCacheMode;
    }
}
