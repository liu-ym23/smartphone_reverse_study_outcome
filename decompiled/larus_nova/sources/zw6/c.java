package zw6;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lzw6/c;", "Ldx6/c;", "", "title", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "", "needAnim", "Z", "d", "()Z", "<init>", "()V", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class c extends dx6.c {

    @SerializedName("needAnim")
    private final boolean needAnim;

    @SerializedName("title")
    private final String title;

    public c() {
    }

    public final boolean d() {
        return this.needAnim;
    }

    public final String e() {
        return this.title;
    }
}
