package com.lynx.clay.plugin.mouse;

import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larus.avatar.impl.scan.view.ScanCameraBeautyLevel;
import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
class MouseCursorPlugin$1 extends HashMap<String, Integer> {
    private static final long serialVersionUID = 1;
    final /* synthetic */ a this$0;

    public MouseCursorPlugin$1(a r100) {
        put("alias", 1010);
        put("allScroll", 1013);
        put(ScanCameraBeautyLevel.CATEGORY_KEY_BASIC, 1000);
        put(LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL, 1006);
        put("click", 1002);
        put("contextMenu", 1001);
        put("copy", 1011);
        put("forbidden", 1012);
        put("grab", 1020);
        put("grabbing", 1021);
        put("help", 1003);
        put("move", 1013);
        put("none", 0);
        put("noDrop", 1012);
        put("precise", 1007);
        put("text", 1008);
        put("resizeColumn", 1014);
        put("resizeDown", 1015);
        put("resizeUpLeft", 1016);
        put("resizeDownRight", 1017);
        put("resizeLeft", 1014);
        put("resizeLeftRight", 1014);
        put("resizeRight", 1014);
        put("resizeRow", 1015);
        put("resizeUp", 1015);
        put("resizeUpDown", 1015);
        put("resizeUpLeft", 1017);
        put("resizeUpRight", 1016);
        put("resizeUpLeftDownRight", 1017);
        put("resizeUpRightDownLeft", 1016);
        put("verticalText", 1009);
        put("wait", 1004);
        put("zoomIn", 1018);
        put("zoomOut", 1019);
    }
}
