package com.bytedance.ee.util.info;

import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentServiceId;
import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum DocAppIdConst extends Enum<DocAppIdConst> {
    public static final DocAppIdConst Lark = null;
    public static final DocAppIdConst Mempope = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DocAppIdConst[] f243138a = null;
    public final String value;

    static {
        DocAppIdConst r100 = new DocAppIdConst("Mempope", 0, CommentServiceId.PRODUCT_COMMENT);
        Mempope = r100;
        DocAppIdConst r101 = new DocAppIdConst("Lark", 1, InitSDKRequest.DEFAULT_APP_ID);
        Lark = r101;
        f243138a = new DocAppIdConst[]{r100, r101};
    }

    public static DocAppIdConst[] values() {
        return (DocAppIdConst[]) f243138a.clone();
    }

    public String getValue() {
        return this.value;
    }

    public static DocAppIdConst valueOf(String r100) {
        return (DocAppIdConst) a.a(DocAppIdConst.class, r100);
    }

    public DocAppIdConst(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
