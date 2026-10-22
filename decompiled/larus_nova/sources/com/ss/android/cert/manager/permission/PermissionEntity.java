package com.ss.android.cert.manager.permission;

import android.content.Context;
import java.io.Serializable;

/* JADX INFO: loaded from: classes34.dex */
public class PermissionEntity implements Serializable {
    private static final long serialVersionUID = -4489576172138345207L;
    public final String description;
    public final String group;
    public final boolean necessary;
    public final String permission;
    public final String usage;

    public interface Group {
        public static final String PERMISSION_GROUP_CAMERA = "android.permission-group.CAMERA";
        public static final String PERMISSION_GROUP_MICROPHONE = "android.permission-group.MICROPHONE";
        public static final String PERMISSION_GROUP_STORAGE = "android.permission-group.STORAGE";
    }

    public static PermissionEntity getCameraEntity(Context r100, String r101) {
        return new PermissionEntity("android.permission.CAMERA", Group.PERMISSION_GROUP_CAMERA, r101, null, true);
    }

    public static PermissionEntity getRecordAudioEntity(Context r100, String r101) {
        return new PermissionEntity("android.permission.RECORD_AUDIO", Group.PERMISSION_GROUP_MICROPHONE, r101, null, true);
    }

    public PermissionEntity(String r100, String r101, String r102, String r103, boolean r104) {
        this.group = r101;
        this.permission = r100;
        this.description = r102;
        this.usage = r103;
        this.necessary = r104;
    }
}
