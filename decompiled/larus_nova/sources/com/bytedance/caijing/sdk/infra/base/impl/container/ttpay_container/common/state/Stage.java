package com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.state;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/impl/container/ttpay_container/common/state/Stage;", "", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "STAGE_INIT", "STAGE_CONTAINER_CREATE_START", "STAGE_CONTAINER_CREATE_END", "STAGE_CONTAINER_LOAD_START", "STAGE_CONTAINER_LOAD_TEMPLATE_START", "STAGE_CONTAINER_LOAD_END", "STAGE_CONTAINER_LOAD_FAILED", "cj-host-service-impl-container_release"}, k = 1, mv = {1, 6, 0})
public final enum Stage extends Enum<Stage> {
    public static final Stage STAGE_CONTAINER_CREATE_END = null;
    public static final Stage STAGE_CONTAINER_CREATE_START = null;
    public static final Stage STAGE_CONTAINER_LOAD_END = null;
    public static final Stage STAGE_CONTAINER_LOAD_FAILED = null;
    public static final Stage STAGE_CONTAINER_LOAD_START = null;
    public static final Stage STAGE_CONTAINER_LOAD_TEMPLATE_START = null;
    public static final Stage STAGE_INIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Stage[] f202528a = null;
    private final String desc;

    public static Stage valueOf(String r100) {
        return (Stage) a.a(Stage.class, r100);
    }

    public static Stage[] values() {
        return (Stage[]) f202528a.clone();
    }

    static {
        Stage r100 = new Stage("STAGE_INIT", 0, "stage_init");
        STAGE_INIT = r100;
        Stage r101 = new Stage("STAGE_CONTAINER_CREATE_START", 1, "stage_container_create_start");
        STAGE_CONTAINER_CREATE_START = r101;
        Stage r102 = new Stage("STAGE_CONTAINER_CREATE_END", 2, "stage_container_create_end");
        STAGE_CONTAINER_CREATE_END = r102;
        Stage r103 = new Stage("STAGE_CONTAINER_LOAD_START", 3, "stage_container_load_start");
        STAGE_CONTAINER_LOAD_START = r103;
        Stage r104 = new Stage("STAGE_CONTAINER_LOAD_TEMPLATE_START", 4, "stage_container_load_template_start");
        STAGE_CONTAINER_LOAD_TEMPLATE_START = r104;
        Stage r105 = new Stage("STAGE_CONTAINER_LOAD_END", 5, "stage_container_load_end");
        STAGE_CONTAINER_LOAD_END = r105;
        Stage r110 = new Stage("STAGE_CONTAINER_LOAD_FAILED", 6, "stage_container_load_failed");
        STAGE_CONTAINER_LOAD_FAILED = r110;
        f202528a = new Stage[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public final String getDesc() {
        return this.desc;
    }

    public Stage(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
