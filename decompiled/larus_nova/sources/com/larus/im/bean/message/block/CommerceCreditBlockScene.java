package com.larus.im.bean.message.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/im/bean/message/block/CommerceCreditBlockScene;", "", "scene", "", "<init>", "(Ljava/lang/String;II)V", "getScene", "()I", "CREDIT_BLOCK_SCENE_NONE", "CREDIT_BLOCK_SCENE_INSUFFICIENT_BALANCE", "CREDIT_BLOCK_SCENE_USAGE_DETAIL", "CREDIT_BLOCK_SCENE_CREDIT_REFUND", "CREDIT_BLOCK_SCENE_CREDIT_ESTIMATION", "CREDIT_BLOCK_SCENE_USAGE_DETAIL_ASYNC", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CommerceCreditBlockScene extends Enum<CommerceCreditBlockScene> {
    public static final CommerceCreditBlockScene CREDIT_BLOCK_SCENE_CREDIT_ESTIMATION = null;
    public static final CommerceCreditBlockScene CREDIT_BLOCK_SCENE_CREDIT_REFUND = null;
    public static final CommerceCreditBlockScene CREDIT_BLOCK_SCENE_INSUFFICIENT_BALANCE = null;
    public static final CommerceCreditBlockScene CREDIT_BLOCK_SCENE_NONE = null;
    public static final CommerceCreditBlockScene CREDIT_BLOCK_SCENE_USAGE_DETAIL = null;
    public static final CommerceCreditBlockScene CREDIT_BLOCK_SCENE_USAGE_DETAIL_ASYNC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommerceCreditBlockScene[] f346831a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346832b = null;
    private final int scene;

    public static EnumEntries<CommerceCreditBlockScene> getEntries() {
        return f346832b;
    }

    static {
        CommerceCreditBlockScene r100 = new CommerceCreditBlockScene("CREDIT_BLOCK_SCENE_NONE", 0, 0);
        CREDIT_BLOCK_SCENE_NONE = r100;
        CommerceCreditBlockScene r101 = new CommerceCreditBlockScene("CREDIT_BLOCK_SCENE_INSUFFICIENT_BALANCE", 1, 1);
        CREDIT_BLOCK_SCENE_INSUFFICIENT_BALANCE = r101;
        CommerceCreditBlockScene r102 = new CommerceCreditBlockScene("CREDIT_BLOCK_SCENE_USAGE_DETAIL", 2, 2);
        CREDIT_BLOCK_SCENE_USAGE_DETAIL = r102;
        CommerceCreditBlockScene r103 = new CommerceCreditBlockScene("CREDIT_BLOCK_SCENE_CREDIT_REFUND", 3, 3);
        CREDIT_BLOCK_SCENE_CREDIT_REFUND = r103;
        CommerceCreditBlockScene r104 = new CommerceCreditBlockScene("CREDIT_BLOCK_SCENE_CREDIT_ESTIMATION", 4, 4);
        CREDIT_BLOCK_SCENE_CREDIT_ESTIMATION = r104;
        CommerceCreditBlockScene r105 = new CommerceCreditBlockScene("CREDIT_BLOCK_SCENE_USAGE_DETAIL_ASYNC", 5, 5);
        CREDIT_BLOCK_SCENE_USAGE_DETAIL_ASYNC = r105;
        CommerceCreditBlockScene[] r110 = {r100, r101, r102, r103, r104, r105};
        f346831a = r110;
        f346832b = EnumEntriesKt.enumEntries(r110);
    }

    public static CommerceCreditBlockScene[] values() {
        return (CommerceCreditBlockScene[]) f346831a.clone();
    }

    public final int getScene() {
        return this.scene;
    }

    public static CommerceCreditBlockScene valueOf(String r100) {
        return (CommerceCreditBlockScene) a.a(CommerceCreditBlockScene.class, r100);
    }

    public CommerceCreditBlockScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.scene = r102;
    }
}
