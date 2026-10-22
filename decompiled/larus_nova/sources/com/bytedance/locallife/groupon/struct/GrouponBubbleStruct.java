package com.bytedance.locallife.groupon.struct;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes21.dex */
public final class GrouponBubbleStruct implements Serializable {

    @SerializedName("bubble_attribute")
    public int bubbleAttribute;
    public GrouponTabDotInfo nearbyDotInfo;
    public GrouponGeneralBubbleStruct nearbyGeneralBubbleStruct;

    @SerializedName("nearby_tab_bubble_mob_extra")
    public String nearbyTabBubbleMobExtra;
    public HashMap<String, String> nearbyTabBubbleMobExtraMap;

    @SerializedName("nearby_tab_bubble_text")
    public String nearbyTabBubbleText;

    @SerializedName("nearby_tab_bubble_type")
    public Integer nearbyTabBubbleType;

    public int getAttributeSafety() {
        GrouponGeneralBubbleStruct r100 = this.nearbyGeneralBubbleStruct;
        if (r100 == null) goto L9;
        if (r100.getAttribute() == 0) goto L9;
        return this.nearbyGeneralBubbleStruct.getAttribute();
    L9:
        return this.bubbleAttribute;
    }

    public int getTypeSafety() {
        if (this.nearbyTabBubbleType != null) goto L6;
        return 0;
    L6:
        GrouponGeneralBubbleStruct r100 = this.nearbyGeneralBubbleStruct;
        if (r100 == null) goto L15;
        if (r100.getType() == null) goto L15;
        if (this.nearbyGeneralBubbleStruct.getType().intValue() <= 0) goto L15;
        return this.nearbyGeneralBubbleStruct.getType().intValue();
    L15:
        return this.nearbyTabBubbleType.intValue();
    }

    public GrouponBubbleStruct() {
    }
}
