package com.bytedance.map.api.utils;

import android.graphics.Point;
import android.text.TextUtils;
import com.bytedance.map.api.animation.AnimationStyle;
import com.bytedance.map.api.animation.EaseCubicInterpolator;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.BDMarkerOptions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public class OptionsMapParser {
    public OptionsMapParser() {
    }

    private static AnimationStyle createAlphaAnimation(Map<?, ?> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        AnimationStyle r101 = new AnimationStyle();
        r101.setType(1);
        setupAnimationCommonParams(r101, r100);
        return r101;
    }

    private static AnimationStyle createScaleAnimation(Map<?, ?> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        AnimationStyle r101 = new AnimationStyle();
        r101.setType(0);
        setupAnimationCommonParams(r101, r100);
        return r101;
    }

    public static List<AnimationStyle> parseAnimations(Map<String, Object> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ArrayList r101 = new ArrayList();
        Object r102 = r100.get("animate");
        if ((r102 instanceof Map) == false) goto L17;
        Map r103 = (Map) r102;
        Object r104 = r103.get("scale");
        if ((r104 instanceof Map) == false) goto L12;
        AnimationStyle r105 = createScaleAnimation((Map) r104);
        if (r105 == null) goto L12;
        r101.add(r105);
    L12:
        Object r106 = r103.get("alpha");
        if ((r106 instanceof Map) == false) goto L17;
        AnimationStyle r107 = createAlphaAnimation((Map) r106);
        if (r107 == null) goto L17;
        r101.add(r107);
    L17:
        return r101;
    }

    public static BDMarkerOptions parseMarkerOptions(Map<String, Object> r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        Object r100 = r110.get("id");
        if ((r100 instanceof String) == false) goto L8;
        String r101 = (String) r100;
    L10:
        if (TextUtils.isEmpty(r101) == false) goto L12;
        return null;
    L12:
        BDMarkerOptions r102 = new BDMarkerOptions();
        r102.setId(r101);
        Object r103 = r110.get("rotateAngle");
        if ((r103 instanceof Number) == false) goto L15;
        r102.setRotateAngle(((Number) r103).floatValue());
    L15:
        Object r104 = r110.get("alpha");
        if ((r104 instanceof Number) == false) goto L18;
        r102.setAlpha(((Number) r104).floatValue());
    L18:
        Object r105 = r110.get("zIndex");
        if ((r105 instanceof Number) == false) goto L21;
        r102.setZIndex(((Number) r105).floatValue());
    L21:
        Object r106 = r110.get("position");
        if ((r106 instanceof List) == false) goto L30;
        List r107 = (List) r106;
        if (r107.size() != 2) goto L30;
        Object r108 = ListProtector.get(r107, 0);
        Object r109 = ListProtector.get(r107, 1);
        if ((r108 instanceof Number) == false) goto L30;
        if ((r109 instanceof Number) == false) goto L30;
        double r111 = ((Number) r108).doubleValue();
        r102.setLatLng(new BDLatLng(((Number) r109).doubleValue(), r111));
    L30:
        Object r112 = r110.get("containerPosition");
        if ((r112 instanceof List) == false) goto L42;
        List r113 = (List) r112;
        if (r113.size() != 2) goto L42;
        Object r114 = ListProtector.get(r113, 0);
        Object r115 = ListProtector.get(r113, 1);
        if ((r114 instanceof Number) == false) goto L42;
        if ((r115 instanceof Number) == false) goto L42;
        int r116 = ((Number) r114).intValue();
        int r117 = ((Number) r115).intValue();
        if (r116 == (-1)) goto L42;
        if (r117 == (-1)) goto L42;
        r102.setScreenPoint(new Point(r116, r117));
    L42:
        Object r118 = r110.get("anchor");
        if ((r118 instanceof List) == false) goto L51;
        List r119 = (List) r118;
        if (r119.size() != 2) goto L51;
        Object r120 = ListProtector.get(r119, 0);
        Object r121 = ListProtector.get(r119, 1);
        if ((r120 instanceof Number) == false) goto L51;
        if ((r121 instanceof Number) == false) goto L51;
        r102.setAnchorX(((Number) r120).floatValue());
        r102.setAnchorY(((Number) r121).floatValue());
    L51:
        Object r122 = r110.get("draggable");
        if ((r122 instanceof Boolean) == false) goto L54;
        r102.setDraggable(((Boolean) r122).booleanValue());
    L54:
        Object r123 = r110.get("clickable");
        if ((r123 instanceof Boolean) == false) goto L57;
        r102.setClickable(((Boolean) r123).booleanValue());
    L57:
        Object r124 = r110.get("isCollideWithPoi");
        if ((r124 instanceof Boolean) == false) goto L61;
        r102.setCollideWithPoi(((Boolean) r124).booleanValue());
    L61:
        if (r102.getLatLng() == null) goto L63;
    L65:
        return r102;
    L63:
        if (r102.getScreenPoint() != null) goto L65;
        return null;
    L8:
        r101 = "";
        goto L10
    }

    public static void setupAnimationCommonParams(AnimationStyle r100, Map<?, ?> r101) {
        Object r102 = r101.get("from");
        if ((r102 instanceof Number) == false) goto L5;
        r100.setFrom(((Number) r102).floatValue());
    L5:
        Object r103 = r101.get(RemoteMessageConst.TO);
        if ((r103 instanceof Number) == false) goto L8;
        r100.setTo(((Number) r103).floatValue());
    L8:
        Object r104 = r101.get("duration");
        if ((r104 instanceof Number) == false) goto L11;
        r100.setDuration(((Number) r104).longValue());
    L11:
        Object r105 = r101.get("fillMode");
        if ((r105 instanceof Number) == false) goto L14;
        r100.setFillMode(((Number) r105).intValue());
    L14:
        Object r106 = r101.get("repeatCount");
        if ((r106 instanceof Number) == false) goto L17;
        r100.setRepeatCount(((Number) r106).intValue());
    L17:
        Object r107 = r101.get("interpolator");
        if ((r107 instanceof Number) == true) goto L20;
        return;
    L20:
        if (((Number) r107).intValue() != 1) goto L40;
        Object r108 = r101.get("bezierParams");
        if ((r108 instanceof Map) == false) goto L41;
        Map r109 = (Map) r108;
        Object r110 = r109.get("x1");
        float r111 = 0.0f;
        if ((r110 instanceof Number) == false) goto L26;
        float r112 = ((Number) r110).floatValue();
    L27:
        Object r113 = r109.get("y1");
        if ((r113 instanceof Number) == false) goto L30;
        r111 = ((Number) r113).floatValue();
    L30:
        Object r114 = r109.get("x2");
        float r115 = 1.0f;
        if ((r114 instanceof Number) == false) goto L33;
        float r116 = ((Number) r114).floatValue();
    L34:
        Object r117 = r109.get("y2");
        if ((r117 instanceof Number) == false) goto L37;
        r115 = ((Number) r117).floatValue();
    L37:
        r100.setInterpolator(new EaseCubicInterpolator(r112, r111, r116, r115));
        return;
    L33:
        r116 = 1.0f;
        goto L34
    L26:
        r112 = 0.0f;
        goto L27
    L41:
        return;
    }
}
