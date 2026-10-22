package l90;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR2\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Ll90/c;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "requirements", "Ljava/util/ArrayList;", "getRequirements", "()Ljava/util/ArrayList;", "setRequirements", "(Ljava/util/ArrayList;)V", "<init>", "()V", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("requirements")
    private ArrayList<String> requirements;

    public c() {
        this.requirements = CollectionsKt.arrayListOf(new String[]{"script", "mega", "nh_inference", "cine_move", "video_relit"});
    }
}
