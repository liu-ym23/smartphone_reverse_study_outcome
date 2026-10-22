package com.ss.android.lark.desktopmode.base;

import android.content.Intent;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes35.dex */
public class StandAloneParam implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient Intent f420392a;
    private final boolean clipChildren;
    private final int launchMode;
    private final int requestCode;
    private final int[] targetCoordination;
    private final int targetWindowHeight;
    private final int targetWindowWidth;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LaunchMode {
        public static final int BOUNDARY_ADAPT = 2;
        public static final int PARENT_CENTER = 0;
        public static final int TARGET_COORDINATE = 1;
    }

    public Intent getIntent() {
        return this.f420392a;
    }

    public int getLaunchMode() {
        return this.launchMode;
    }

    public int getRequestCode() {
        return this.requestCode;
    }

    public int[] getTargetCoordination() {
        return this.targetCoordination;
    }

    public int getTargetWindowHeight() {
        return this.targetWindowHeight;
    }

    public int getTargetWindowWidth() {
        return this.targetWindowWidth;
    }

    public boolean isClipChildren() {
        return this.clipChildren;
    }

    public StandAloneParam(Intent r100, int r101, int[] r102, int r103, int r104, int r105, boolean r106) {
        this.f420392a = r100;
        this.launchMode = r101;
        this.targetCoordination = r102;
        this.targetWindowWidth = r103;
        this.targetWindowHeight = r104;
        this.requestCode = r105;
        this.clipChildren = r106;
    }
}
