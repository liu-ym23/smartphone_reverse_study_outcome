package j68;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/audio/audiov3/task/sami/v2/data/SectionContextResults;", "", CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL, "Lcom/larus/audio/audiov3/task/tts/extra/TtsSentenceLang;", "<init>", "(Lcom/larus/audio/audiov3/task/tts/extra/TtsSentenceLang;)V", "getLang", "()Lcom/larus/audio/audiov3/task/tts/extra/TtsSentenceLang;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL)
    private final m68.a lang;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.lang, ((a) r100).lang) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        m68.a r100 = this.lang;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "SectionContextResults(lang=" + this.lang + ')';
    }

    public a() {
        this.lang = null;
    }

    public final m68.a a() {
        return this.lang;
    }
}
