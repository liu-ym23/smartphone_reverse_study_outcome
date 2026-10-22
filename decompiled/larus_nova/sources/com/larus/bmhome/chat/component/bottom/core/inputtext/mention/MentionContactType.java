package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionContactType;", "", "protocolValue", "", "<init>", "(Ljava/lang/String;II)V", "getProtocolValue", "()I", FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum MentionContactType extends Enum<MentionContactType> {
    public static final MentionContactType USER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MentionContactType[] f298774a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f298775b = null;
    private final int protocolValue;

    public static EnumEntries<MentionContactType> getEntries() {
        return f298775b;
    }

    static {
        MentionContactType r100 = new MentionContactType();
        USER = r100;
        MentionContactType[] r101 = {r100};
        f298774a = r101;
        f298775b = EnumEntriesKt.enumEntries(r101);
    }

    public MentionContactType() {
        super(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 0);
        this.protocolValue = 1;
    }

    public static MentionContactType[] values() {
        return (MentionContactType[]) f298774a.clone();
    }

    public final int getProtocolValue() {
        return this.protocolValue;
    }

    public static MentionContactType valueOf(String r100) {
        return (MentionContactType) r27.a.a(MentionContactType.class, r100);
    }
}
