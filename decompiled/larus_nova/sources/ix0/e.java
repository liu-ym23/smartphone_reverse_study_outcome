package ix0;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\r\u0010\u000eRB\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lix0/e;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lix0/d;", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "objToken", "Ljava/util/Map;", "getObjToken", "()Ljava/util/Map;", "P6", "(Ljava/util/Map;)V", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class e<T> implements d<T> {

    @SerializedName("_obj_token")
    private Map<String, String> objToken;

    public e() {
    }

    public final String toString() {
        return Reflection.getOrCreateKotlinClass(e.class).getSimpleName() + " { objToken = " + this.objToken + " }";
    }

    @Override // ix0.d
    public final Map<String, String> getObjToken() {
        return this.objToken;
    }

    @Override // ix0.d
    public final void P6(Map<String, String> r100) {
        this.objToken = r100;
    }
}
