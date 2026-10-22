package p00;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class a {

    @SerializedName("enable_live_audio")
    public boolean enableLiveAudio;

    @SerializedName("enable_live_screenshot")
    public boolean enableLiveScreenshot;

    @SerializedName("enable_live_third_party")
    public boolean enableLiveThirdParty;

    @SerializedName("toast")
    public C7135a mToast;

    /* JADX INFO: renamed from: p00.a$a, reason: collision with other inner class name */
    public static class C7135a {

        @SerializedName("new_anchor")
        public boolean mNewAnchor;

        public C7135a() {
        }
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public a() {
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (this.enableLiveAudio == r101.enableLiveAudio) goto L7;
        return false;
    L7:
        if (this.enableLiveThirdParty == r101.enableLiveThirdParty) goto L9;
        return false;
    L9:
        if (this.enableLiveScreenshot != r101.enableLiveScreenshot) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }
}
