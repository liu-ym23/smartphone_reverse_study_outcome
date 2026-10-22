package dx6;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Ldx6/n;", "Ldx6/c;", "", "title", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "content", "d", "", "needDot", "Ljava/lang/Boolean;", "e", "()Ljava/lang/Boolean;", "<init>", "()V", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class n extends c {

    @SerializedName("content")
    private final String content;

    @SerializedName("needDot")
    private final Boolean needDot;

    @SerializedName("title")
    private final String title;

    public n() {
        this.needDot = Boolean.FALSE;
    }

    public final String d() {
        return this.content;
    }

    public final Boolean e() {
        return this.needDot;
    }

    public final String f() {
        return this.title;
    }
}
