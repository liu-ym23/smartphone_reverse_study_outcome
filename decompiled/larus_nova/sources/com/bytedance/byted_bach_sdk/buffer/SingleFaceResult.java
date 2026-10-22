package com.bytedance.byted_bach_sdk.buffer;

import java.util.Vector;

/* JADX INFO: loaded from: classes8.dex */
public class SingleFaceResult {
    public int ID;
    public long action;
    public float bbox_height;
    public float bbox_width;
    public float bbox_x;
    public float bbox_y;
    public int eye_count;
    public float eye_dist;
    public Vector<Vector<Float>> eye_left;
    public Vector<Vector<Float>> eye_right;
    public int eyebrow_count;
    public Vector<Vector<Float>> eyebrow_left;
    public Vector<Vector<Float>> eyebrow_right;
    public int face_id;
    public Vector<Short> face_mask;
    public int face_mask_size;
    public Vector<Float> face_warp_mat;
    public int iris_count;
    public Vector<Vector<Float>> left_iris;
    public Vector<Vector<Float>> lips;
    public int lips_count;
    public int m_height;
    public int m_width;
    public int mouth_id;
    public Vector<Short> mouth_mask;
    public int mouth_mask_size;
    public Vector<Float> mouth_warp_mat;
    public float occlusion_prob;
    public float pitch;
    public Vector<Vector<Float>> points_array;
    public Vector<Vector<Float>> right_iris;
    public float roll;
    public float score;
    public int teeth_id;
    public Vector<Short> teeth_mask;
    public int teeth_mask_size;
    public Vector<Float> teeth_warp_mat;
    public long tracking_cnt;
    public Vector<Float> visibility_array;
    public float yaw;

    public SingleFaceResult() {
        this.ID = -1;
        this.action = 0;
        this.tracking_cnt = 0;
        this.mouth_id = -1;
        this.mouth_mask_size = -1;
        this.teeth_id = -1;
        this.teeth_mask_size = -1;
        this.face_id = -1;
        this.face_mask_size = -1;
        this.eye_count = -1;
        this.eyebrow_count = -1;
        this.lips_count = -1;
        this.iris_count = -1;
    }
}
