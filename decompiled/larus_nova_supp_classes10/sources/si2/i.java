package si2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lsi2/i;", "", "", "titleMinLength", "I", "b", "()I", "setTitleMinLength", "(I)V", "titleMaxLength", "a", "setTitleMaxLength", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("title_length_max")
    private int titleMaxLength;

    @SerializedName("title_length_min")
    private int titleMinLength;

    public i() {
        this.titleMinLength = 8;
        this.titleMaxLength = 30;
    }

    public final int a() {
        return this.titleMaxLength;
    }

    public final int b() {
        return this.titleMinLength;
    }
}
