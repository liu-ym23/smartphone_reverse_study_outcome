package com.ss.android.lark.flow.chat.message.image;

import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/flow/chat/message/image/FlowYunPanCoverType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "Thumbnail", "Middle", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowYunPanCoverType extends Enum<FlowYunPanCoverType> {
    public static final FlowYunPanCoverType Middle = null;
    public static final FlowYunPanCoverType Thumbnail = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowYunPanCoverType[] f422566a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f422567b = null;
    private final String type;

    public static EnumEntries<FlowYunPanCoverType> getEntries() {
        return f422567b;
    }

    static {
        FlowYunPanCoverType r100 = new FlowYunPanCoverType("Thumbnail", 0, DocCallbackImpl.KEY_THUMBNAIL);
        Thumbnail = r100;
        FlowYunPanCoverType r101 = new FlowYunPanCoverType("Middle", 1, "middle");
        Middle = r101;
        FlowYunPanCoverType[] r102 = {r100, r101};
        f422566a = r102;
        f422567b = EnumEntriesKt.enumEntries(r102);
    }

    public static FlowYunPanCoverType[] values() {
        return (FlowYunPanCoverType[]) f422566a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static FlowYunPanCoverType valueOf(String r100) {
        return (FlowYunPanCoverType) r27.a.a(FlowYunPanCoverType.class, r100);
    }

    public FlowYunPanCoverType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
