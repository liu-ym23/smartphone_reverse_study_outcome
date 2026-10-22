package com.bytedance.byted_bach_sdk.buffer;

import com.bytedance.android.ec.core.event.a;
import com.ss.texturerender.TextureRenderKeys;
import java.util.HashMap;
import java.util.Vector;
import kotlin.UByte;

/* JADX INFO: loaded from: classes8.dex */
public class BachFaceAlgorithmOutput extends BachAlgorithmOutput {
    public Vector<SingleFaceResult> faceResults;

    public BachFaceAlgorithmOutput(HashMap<String, BachObject>[] r110) {
        this.faceResults = new Vector();
        int r100 = r110.length;
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L62;
        HashMap<String, BachObject> r102 = r110[r101];
        SingleFaceResult r103 = new SingleFaceResult();
        r103.m_width = (int) r102.get("m_width").valueResult.int64Val;
        r103.m_height = (int) r102.get("m_height").valueResult.int64Val;
        r103.bbox_x = (float) r102.get("bbox_x").valueResult.doubleVal;
        r103.bbox_y = (float) r102.get("bbox_y").valueResult.doubleVal;
        r103.bbox_width = (float) r102.get("bbox_width").valueResult.doubleVal;
        r103.bbox_height = (float) r102.get("bbox_height").valueResult.doubleVal;
        r103.score = (float) r102.get(a.KEY_SCORE).valueResult.doubleVal;
        r103.points_array = new Vector();
        BachObject[] r104 = r102.get("points_array").vectorResult;
        int r105 = r104.length;
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L8;
        BachObject r107 = r104[r106];
        Vector<Float> r111 = new Vector();
        r111.add(Float.valueOf((float) r107.valueResult.vecFVal[0]));
        r111.add(Float.valueOf((float) r107.valueResult.vecFVal[1]));
        r103.points_array.add(r111);
        r106 = r106 + 1;
        goto L6
    L8:
        Vector<Float> r108 = new Vector();
        double[] r109 = r102.get("visibility_array").valueResult.vecFVal;
        int r112 = r109.length;
        int r113 = 0;
    L9:
        if (r113 >= r112) goto L11;
        r108.add(Float.valueOf((float) r109[r113]));
        r113 = r113 + 1;
        goto L9
    L11:
        r103.visibility_array = r108;
        r103.roll = (float) r102.get("roll").valueResult.doubleVal;
        r103.yaw = (float) r102.get(TextureRenderKeys.KEY_IS_YAW).valueResult.doubleVal;
        r103.pitch = (float) r102.get(TextureRenderKeys.KEY_IS_PITCH).valueResult.doubleVal;
        r103.eye_dist = (float) r102.get("eye_dist").valueResult.doubleVal;
        r103.ID = (int) r102.get("ID").valueResult.int64Val;
        r103.action = r102.get("action").valueResult.int64Val;
        r103.tracking_cnt = r102.get("tracking_cnt").valueResult.int64Val;
        r103.occlusion_prob = (float) r102.get("occlusion_prob").valueResult.doubleVal;
        if (r102.containsKey("mouth_id") == false) goto L21;
        r103.mouth_id = (int) r102.get("mouth_id").valueResult.int64Val;
        r103.mouth_mask_size = (int) r102.get("mouth_mask_size").valueResult.int64Val;
        Vector<Short> r114 = new Vector();
        byte[] r115 = r102.get("mouth_mask").valueResult.byteArrayVal;
        int r116 = r115.length;
        int r117 = 0;
    L14:
        if (r117 >= r116) goto L16;
        r114.add(Short.valueOf((short) (r115[r117] & UByte.MAX_VALUE)));
        r117 = r117 + 1;
        goto L14
    L16:
        r103.mouth_mask = r114;
        Vector<Float> r118 = new Vector();
        double[] r119 = r102.get("mouth_warp_mat").valueResult.vecFVal;
        int r120 = r119.length;
        int r121 = 0;
    L17:
        if (r121 >= r120) goto L19;
        r118.add(Float.valueOf((float) r119[r121]));
        r121 = r121 + 1;
        goto L17
    L19:
        r103.mouth_warp_mat = r118;
    L21:
        if (r102.containsKey("teeth_id") == false) goto L30;
        r103.teeth_id = (int) r102.get("teeth_id").valueResult.int64Val;
        r103.teeth_mask_size = (int) r102.get("teeth_mask_size").valueResult.int64Val;
        Vector<Short> r122 = new Vector();
        byte[] r123 = r102.get("teeth_mask").valueResult.byteArrayVal;
        int r124 = r123.length;
        int r125 = 0;
    L23:
        if (r125 >= r124) goto L25;
        r122.add(Short.valueOf((short) (r123[r125] & UByte.MAX_VALUE)));
        r125 = r125 + 1;
        goto L23
    L25:
        r103.teeth_mask = r122;
        Vector<Float> r126 = new Vector();
        double[] r127 = r102.get("teeth_warp_mat").valueResult.vecFVal;
        int r128 = r127.length;
        int r129 = 0;
    L26:
        if (r129 >= r128) goto L28;
        r126.add(Float.valueOf((float) r127[r129]));
        r129 = r129 + 1;
        goto L26
    L28:
        r103.teeth_warp_mat = r126;
    L30:
        if (r102.containsKey("face_id") == false) goto L39;
        r103.face_id = (int) r102.get("face_id").valueResult.int64Val;
        r103.face_mask_size = (int) r102.get("face_mask_size").valueResult.int64Val;
        Vector<Short> r130 = new Vector();
        byte[] r131 = r102.get("face_mask").valueResult.byteArrayVal;
        int r132 = r131.length;
        int r133 = 0;
    L32:
        if (r133 >= r132) goto L34;
        r130.add(Short.valueOf((short) (r131[r133] & UByte.MAX_VALUE)));
        r133 = r133 + 1;
        goto L32
    L34:
        r103.face_mask = r130;
        Vector<Float> r134 = new Vector();
        double[] r135 = r102.get("face_warp_mat").valueResult.vecFVal;
        int r136 = r135.length;
        int r137 = 0;
    L35:
        if (r137 >= r136) goto L37;
        r134.add(Float.valueOf((float) r135[r137]));
        r137 = r137 + 1;
        goto L35
    L37:
        r103.face_warp_mat = r134;
    L39:
        if (r102.containsKey("eye_count") == false) goto L61;
        r103.eye_count = (int) r102.get("eye_count").valueResult.int64Val;
        r103.eyebrow_count = (int) r102.get("eyebrow_count").valueResult.int64Val;
        r103.lips_count = (int) r102.get("lips_count").valueResult.int64Val;
        r103.iris_count = (int) r102.get("iris_count").valueResult.int64Val;
        r103.eye_left = new Vector();
        BachObject[] r138 = r102.get("eye_left").vectorResult;
        int r139 = r138.length;
        int r140 = 0;
    L41:
        if (r140 >= r139) goto L43;
        BachObject r141 = r138[r140];
        Vector<Float> r142 = new Vector();
        r142.add(Float.valueOf((float) r141.valueResult.vecFVal[0]));
        r142.add(Float.valueOf((float) r141.valueResult.vecFVal[1]));
        r103.eye_left.add(r142);
        r140 = r140 + 1;
        goto L41
    L43:
        r103.eye_right = new Vector();
        BachObject[] r143 = r102.get("eye_right").vectorResult;
        int r144 = r143.length;
        int r145 = 0;
    L44:
        if (r145 >= r144) goto L46;
        BachObject r146 = r143[r145];
        Vector<Float> r147 = new Vector();
        r147.add(Float.valueOf((float) r146.valueResult.vecFVal[0]));
        r147.add(Float.valueOf((float) r146.valueResult.vecFVal[1]));
        r103.eye_right.add(r147);
        r145 = r145 + 1;
        goto L44
    L46:
        r103.eyebrow_left = new Vector();
        BachObject[] r148 = r102.get("eyebrow_left").vectorResult;
        int r149 = r148.length;
        int r150 = 0;
    L47:
        if (r150 >= r149) goto L49;
        BachObject r151 = r148[r150];
        Vector<Float> r152 = new Vector();
        r152.add(Float.valueOf((float) r151.valueResult.vecFVal[0]));
        r152.add(Float.valueOf((float) r151.valueResult.vecFVal[1]));
        r103.eyebrow_left.add(r152);
        r150 = r150 + 1;
        goto L47
    L49:
        r103.eyebrow_right = new Vector();
        BachObject[] r153 = r102.get("eyebrow_right").vectorResult;
        int r154 = r153.length;
        int r155 = 0;
    L50:
        if (r155 >= r154) goto L52;
        BachObject r156 = r153[r155];
        Vector<Float> r157 = new Vector();
        r157.add(Float.valueOf((float) r156.valueResult.vecFVal[0]));
        r157.add(Float.valueOf((float) r156.valueResult.vecFVal[1]));
        r103.eyebrow_right.add(r157);
        r155 = r155 + 1;
        goto L50
    L52:
        r103.lips = new Vector();
        BachObject[] r158 = r102.get("lips").vectorResult;
        int r159 = r158.length;
        int r160 = 0;
    L53:
        if (r160 >= r159) goto L55;
        BachObject r161 = r158[r160];
        Vector<Float> r162 = new Vector();
        r162.add(Float.valueOf((float) r161.valueResult.vecFVal[0]));
        r162.add(Float.valueOf((float) r161.valueResult.vecFVal[1]));
        r103.lips.add(r162);
        r160 = r160 + 1;
        goto L53
    L55:
        r103.left_iris = new Vector();
        BachObject[] r163 = r102.get("left_iris").vectorResult;
        int r164 = r163.length;
        int r165 = 0;
    L56:
        if (r165 >= r164) goto L58;
        BachObject r166 = r163[r165];
        Vector<Float> r167 = new Vector();
        r167.add(Float.valueOf((float) r166.valueResult.vecFVal[0]));
        r167.add(Float.valueOf((float) r166.valueResult.vecFVal[1]));
        r103.left_iris.add(r167);
        r165 = r165 + 1;
        goto L56
    L58:
        r103.right_iris = new Vector();
        BachObject[] r168 = r102.get("right_iris").vectorResult;
        int r169 = r168.length;
        int r170 = 0;
    L59:
        if (r170 >= r169) goto L61;
        BachObject r171 = r168[r170];
        Vector<Float> r172 = new Vector();
        r172.add(Float.valueOf((float) r171.valueResult.vecFVal[0]));
        r172.add(Float.valueOf((float) r171.valueResult.vecFVal[1]));
        r103.right_iris.add(r172);
        r170 = r170 + 1;
    L61:
        this.faceResults.add(r103);
        r101 = r101 + 1;
        goto L3
    }
}
