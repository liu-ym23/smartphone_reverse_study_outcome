package el2;

import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayUtils;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements o {
    public d() {
    }

    @Override // el2.o
    public final String a() {
        return TTCJPayUtils.Companion.getInstance().getJailBreak();
    }

    @Override // el2.o
    public final String getBioType() {
        return TTCJPayUtils.Companion.getInstance().getBioType();
    }

    @Override // el2.o
    public final String getSdkVersion() {
        return TTCJPayUtils.Companion.getInstance().getSDKVersion();
    }
}
