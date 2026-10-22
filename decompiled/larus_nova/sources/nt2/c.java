package nt2;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lnt2/c;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "messageList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c<T> {

    @SerializedName("message_list")
    private final List<T> messageList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.messageList, ((c) r100).messageList) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<T> r100 = this.messageList;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "MessageMockList(messageList=" + this.messageList + ")";
    }

    public final List<T> a() {
        return this.messageList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(List<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "messageList");
        this.messageList = r100;
    }
}
