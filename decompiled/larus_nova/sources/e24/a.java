package e24;

import android.text.TextUtils;
import com.alipay.sdk.m.x.d;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Le24/a;", "", "", "id", "J", "getId", "()J", "setId", "(J)V", "", "author", "Ljava/lang/String;", "getAuthor", "()Ljava/lang/String;", "setAuthor", "(Ljava/lang/String;)V", "title", "getTitle", d.f25925o, "mixedTitle", "getMixedTitle", "setMixedTitle", "mixedAuthor", "getMixedAuthor", "setMixedAuthor", "Lt14/a;", "coverMedium", "Lt14/a;", "getCoverMedium", "()Lt14/a;", "setCoverMedium", "(Lt14/a;)V", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class a {

    @SerializedName("author")
    private String author;

    @SerializedName("cover_medium")
    private t14.a coverMedium;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private long f470816id;

    @SerializedName("mixed_author")
    private String mixedAuthor;

    @SerializedName("mixed_title")
    private String mixedTitle;

    @SerializedName("title")
    private String title;

    public a() {
    }

    public final String a() {
        if (TextUtils.isEmpty(this.title) == false) goto L8;
        if (TextUtils.isEmpty(this.author) == false) goto L8;
        return "";
    L8:
        if (TextUtils.isEmpty(this.title) == false) goto L11;
        return this.author;
    L11:
        if (TextUtils.isEmpty(this.author) == false) goto L14;
        return this.title;
    L14:
        return this.title + " - " + this.author;
    }
}
