package dx6;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Ldx6/m;", "Ldx6/c;", "", "title", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "", "Ldx6/k;", "steps", "Ljava/util/List;", "e", "()Ljava/util/List;", "", "needIcon", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", "<init>", "()V", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class m extends c {

    @SerializedName("needIcon")
    private final Boolean needIcon;

    @SerializedName("steps")
    private final List<k> steps;

    @SerializedName("title")
    private final String title;

    public m() {
        this.needIcon = Boolean.FALSE;
    }

    public final Boolean d() {
        return this.needIcon;
    }

    public final List<k> e() {
        return this.steps;
    }

    public final String f() {
        return this.title;
    }
}
