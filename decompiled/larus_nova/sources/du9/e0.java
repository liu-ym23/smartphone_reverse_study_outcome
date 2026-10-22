package du9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/larus/settings/provider/chat/CreativeMsgModifyConfig;", "", "<init>", "()V", "canImageInstructionMsgModify", "", "getCanImageInstructionMsgModify", "()Z", "modifyToGenerateAgain", "getModifyToGenerateAgain", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e0 {

    @SerializedName("can_image_instruction_msg_modify")
    private final boolean canImageInstructionMsgModify;

    @SerializedName("modify_to_generate_again")
    private final boolean modifyToGenerateAgain;

    public e0() {
        this.canImageInstructionMsgModify = true;
    }

    public final boolean a() {
        return this.canImageInstructionMsgModify;
    }

    public final boolean b() {
        return this.modifyToGenerateAgain;
    }
}
