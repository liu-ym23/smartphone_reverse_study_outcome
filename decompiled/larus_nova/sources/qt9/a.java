package qt9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/larus/settings/provider/AIBeautifyConfig;", "", "<init>", "()V", "defaultKeyboardInvoke", "", "Ljava/lang/Boolean;", "instructionOnImage", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("default_keyboard_invoke")
    public final Boolean defaultKeyboardInvoke;

    @SerializedName("instruction_on_image")
    public final Boolean instructionOnImage;

    public a() {
        Boolean r100 = Boolean.TRUE;
        this.defaultKeyboardInvoke = r100;
        this.instructionOnImage = r100;
    }
}
