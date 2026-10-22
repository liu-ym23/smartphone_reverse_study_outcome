package dv9;

import android.util.EventsUtils;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/larus/settings/provider/maintab/MainTabProvider;", "Lcom/bytedance/news/common/settings/api/annotation/IDefaultValueProvider;", "<init>", "()V", "create", "style", XmlPullParser.NO_NAMESPACE, "getStyle", "()I", "setStyle", "(I)V", "Companion", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class c {

    @SerializedName("style")
    private int style;

    static {
    }

    public c() {
        this.style = 1;
    }

    public final int a() {
        return this.style;
    }
}
