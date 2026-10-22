package com.lightning.edu.ei.edgealgorithm;

/* JADX INFO: loaded from: classes32.dex */
public class Params {
    public int blur_status;
    public double blur_threshold;
    public String blur_url;
    public int dark_status;
    public String dark_url;
    public boolean debug;
    public boolean enable_blur;
    public boolean enable_dark;
    public boolean enable_orientation;
    public boolean enable_scene;
    public boolean only_enable_orientation;
    public int orientation_status;
    public String orientation_url;
    public int questions_status;
    public String questions_url;
    public int scene_status;
    public String scene_url;
    public boolean test;

    public Params() {
        this.blur_threshold = 3.2d;
        this.debug = false;
        this.enable_blur = true;
        this.enable_scene = true;
        this.enable_orientation = true;
        this.test = false;
        this.enable_dark = true;
        this.only_enable_orientation = false;
        this.blur_status = 1;
        this.blur_url = null;
        this.scene_status = 1;
        this.scene_url = null;
        this.dark_status = 1;
        this.dark_url = null;
        this.orientation_status = 1;
        this.orientation_url = null;
        this.questions_status = 1;
        this.questions_url = null;
    }
}
