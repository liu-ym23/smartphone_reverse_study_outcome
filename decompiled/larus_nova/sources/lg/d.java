package lg;

import com.bytedance.android.ec.core.apt.ActionType;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Llg/d;", "Llg/a;", "Lcom/bytedance/android/ec/core/apt/ActionType;", "type", "Lcom/bytedance/android/ec/core/apt/ActionType;", "getType", "()Lcom/bytedance/android/ec/core/apt/ActionType;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class d extends a {

    @SerializedName("type")
    private final ActionType type;

    public abstract String a();

    public abstract String b();

    public d() {
        this(ActionType.Empty);
    }

    public final ActionType getType() {
        return this.type;
    }

    public d(ActionType r100) {
        this.type = r100;
    }
}
