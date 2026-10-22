package el2;

import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayUtils;

/* JADX INFO: loaded from: classes10.dex */
public final class f implements o {
    public f() {
    }

    @Override // el2.o
    public final String a() {
        return "2";
    }

    @Override // el2.o
    public final String getBioType() {
        return "1";
    }

    @Override // el2.o
    public final String getSdkVersion() {
        return TTCJPayUtils.Companion.getInstance().getSDKVersion();
    }
}
