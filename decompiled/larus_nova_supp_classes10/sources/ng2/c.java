package ng2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class c {

    @SerializedName("enable_multi_tab")
    private boolean enableMultiTab;

    @SerializedName("enable_replace_recommend")
    private boolean enableReplaceRecommend;

    @SerializedName("inner_url")
    private String innerUrl;

    @SerializedName("key")
    private String key;

    @SerializedName("req_from")
    private String reqFrom;

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String url;

    public c() {
    }

    public final String a() {
        return this.innerUrl;
    }

    public final String b() {
        return this.key;
    }

    public final String c() {
        return this.reqFrom;
    }

    public final String d() {
        return this.title;
    }

    public final String e() {
        return this.url;
    }

    public final boolean f() {
        return this.enableMultiTab;
    }

    public final boolean g() {
        return this.enableReplaceRecommend;
    }

    public final void h(Boolean r1) {
        this.enableReplaceRecommend = r1.booleanValue();
    }

    public final void i(String r1) {
        this.innerUrl = r1;
    }

    public final void j(String r1) {
        this.url = r1;
    }
}
