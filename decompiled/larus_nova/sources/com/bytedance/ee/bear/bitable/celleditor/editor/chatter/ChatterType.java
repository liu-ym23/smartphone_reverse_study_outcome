package com.bytedance.ee.bear.bitable.celleditor.editor.chatter;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/editor/chatter/ChatterType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "GROUP", FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatterType extends Enum<ChatterType> {
    public static final ChatterType GROUP = null;
    public static final ChatterType USER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatterType[] f209383a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f209384b = null;
    private final int value;

    public static EnumEntries<ChatterType> getEntries() {
        return f209384b;
    }

    static {
        ChatterType r100 = new ChatterType("GROUP", 0, 0);
        GROUP = r100;
        ChatterType r101 = new ChatterType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 1);
        USER = r101;
        ChatterType[] r102 = {r100, r101};
        f209383a = r102;
        f209384b = EnumEntriesKt.enumEntries(r102);
    }

    public static ChatterType[] values() {
        return (ChatterType[]) f209383a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ChatterType valueOf(String r100) {
        return (ChatterType) a.a(ChatterType.class, r100);
    }

    public ChatterType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
