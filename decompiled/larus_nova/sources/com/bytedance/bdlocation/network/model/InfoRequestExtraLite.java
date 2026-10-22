package com.bytedance.bdlocation.network.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class InfoRequestExtraLite {

    @SerializedName("scene_permission_enable")
    public final boolean scenePermissionEnable;

    @SerializedName(InvRouter.SCENES)
    public final Map<String, Boolean> scenes;

    public String toString() {
        return "scenePermissionEnable: " + this.scenePermissionEnable + ", scenes: " + this.scenes;
    }

    public InfoRequestExtraLite(boolean r100, Map<String, Boolean> r101) {
        this.scenePermissionEnable = r100;
        this.scenes = r101;
    }
}
