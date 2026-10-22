package td1;

import com.bytedance.android.live.base.model.Extra;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Ltd1/g;", "Lcom/bytedance/android/live/base/model/Extra;", "", "duration", "I", "getDuration", "()I", "textLimit", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g extends Extra {

    @SerializedName("duration")
    private final int duration;

    @SerializedName("text_limit")
    private final int textLimit;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L10;
        g r101 = (g) r100;
        if (this.duration == r101.duration) goto L8;
        return false;
    L8:
        if (this.textLimit == r101.textLimit) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.duration * 31) + this.textLimit;
    }

    public final String toString() {
        return "PromptsListExtra(duration=" + this.duration + ", textLimit=" + this.textLimit + ")";
    }

    public final int a() {
        return this.textLimit;
    }

    public final int getDuration() {
        return this.duration;
    }
}
