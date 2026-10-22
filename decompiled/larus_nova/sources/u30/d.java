package u30;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lu30/d;", "", "", "showConfirm", "Z", "getShowConfirm", "()Z", "setShowConfirm", "(Z)V", "", "", "whiteList", "Ljava/util/List;", "getWhiteList", "()Ljava/util/List;", "setWhiteList", "(Ljava/util/List;)V", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("show_confirm")
    private boolean showConfirm;

    @SerializedName("white_list")
    private List<String> whiteList;

    public d() {
        this.showConfirm = true;
    }

    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (this.showConfirm == true) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r100) == false) goto L9;
        return true;
    L9:
        Uri r101 = UriProtector.parse(r100);
        List<String> r102 = this.whiteList;
        if (r102 == null) goto L15;
        Iterator<T> r103 = r102.iterator();
    L13:
        if (r103.hasNext() == false) goto L15;
        String r104 = (String) r103.next();
        x30.a.a(r101.getHost(), r104);
    L15:
        return true;
    }
}
