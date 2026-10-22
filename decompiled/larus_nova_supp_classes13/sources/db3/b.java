package db3;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR8\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Ldb3/b;", "", "", "", "popupCodes", "Ljava/util/List;", "c", "()Ljava/util/List;", "setPopupCodes", "(Ljava/util/List;)V", "disableAutoHideKeyboardList", "a", "setDisableAutoHideKeyboardList", "", "lifecycles", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "setLifecycles", "(Ljava/util/Map;)V", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("disable_auto_hide_keyboard")
    private List<String> disableAutoHideKeyboardList;

    @SerializedName("lifecycle_whitelist")
    private Map<String, ? extends List<String>> lifecycles;

    @SerializedName("bottom_offset_whitelist")
    private List<String> popupCodes;

    public b() {
    }

    public final List<String> a() {
        return this.disableAutoHideKeyboardList;
    }

    public final Map<String, List<String>> b() {
        return this.lifecycles;
    }

    public final List<String> c() {
        return this.popupCodes;
    }
}
