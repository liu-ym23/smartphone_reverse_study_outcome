package com.bytedance.awemeopen.apps.framework.comment.api.constants;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/awemeopen/apps/framework/comment/api/constants/CommentConstants$PermissionChangeScene", "", "Lcom/bytedance/awemeopen/apps/framework/comment/api/constants/CommentConstants$PermissionChangeScene;", "VIDEO", "PUBLISH", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final enum CommentConstants$PermissionChangeScene extends Enum<CommentConstants$PermissionChangeScene> {
    public static final CommentConstants$PermissionChangeScene PUBLISH = null;
    public static final CommentConstants$PermissionChangeScene VIDEO = null;
    public static final /* synthetic */ CommentConstants$PermissionChangeScene[] a = null;

    public static CommentConstants$PermissionChangeScene valueOf(String r1) {
        return (CommentConstants$PermissionChangeScene) a.a(CommentConstants$PermissionChangeScene.class, r1);
    }

    public static CommentConstants$PermissionChangeScene[] values() {
        return (CommentConstants$PermissionChangeScene[]) a.clone();
    }

    static {
        CommentConstants$PermissionChangeScene r0 = new CommentConstants$PermissionChangeScene("VIDEO", 0);
        VIDEO = r0;
        CommentConstants$PermissionChangeScene r1 = new CommentConstants$PermissionChangeScene("PUBLISH", 1);
        PUBLISH = r1;
        a = new CommentConstants$PermissionChangeScene[]{r0, r1};
    }

    public CommentConstants$PermissionChangeScene(String r1, int r2) {
        super(r1, r2);
    }
}
