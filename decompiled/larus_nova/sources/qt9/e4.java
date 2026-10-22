package qt9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0016R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/larus/settings/provider/SocialFirstFlashOptSwitchProvider;", "Lcom/bytedance/news/common/settings/api/annotation/IDefaultValueProvider;", "<init>", "()V", "create", "optConversationListRender", "", "getOptConversationListRender", "()Z", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e4 {

    @SerializedName("opt_conv_list_render")
    private final boolean optConversationListRender;

    public e4() {
        this.optConversationListRender = true;
    }

    public final boolean a() {
        return this.optConversationListRender;
    }
}
