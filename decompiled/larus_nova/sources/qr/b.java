package qr;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lqr/b;", "", "", "uri", "Ljava/lang/String;", "getUri", "()Ljava/lang/String;", "", "urlList", "Ljava/util/List;", "getUrlList", "()Ljava/util/List;", "<init>", "()V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("uri")
    private final String uri;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    private final List<String> urlList;

    public b() {
    }
}
