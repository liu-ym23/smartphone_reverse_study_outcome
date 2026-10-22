package rn9;

import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.ArtifactStatus;

/* JADX INFO: loaded from: classes29.dex */
public final class l {
    public static final String a(ArtifactBlock r100) {
        Integer r101 = r100.getStatus();
        int r102 = ArtifactStatus.GENERATING.getValue();
        if (r101 != null) goto L6;
    L8:
        int r103 = ArtifactStatus.GENERATED.getValue();
        if (r101 != null) goto L12;
    L13:
        int r104 = ArtifactStatus.OUTDATED.getValue();
        if (r101 != null) goto L17;
    L18:
        int r105 = ArtifactStatus.DELETED.getValue();
        if (r101 != null) goto L22;
    L24:
        return "";
    L22:
        if (r101.intValue() != r105) goto L24;
    L25:
        return "bitable_artifact_result_card_click";
    L17:
        if (r101.intValue() == r104) goto L25;
    L12:
        if (r101.intValue() == r103) goto L25;
    L6:
        if (r101.intValue() != r102) goto L8;
        return "bitable_artifact_progress_card_click";
    }
}
