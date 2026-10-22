package com.ss.android.lark.inline.ai.api;

import com.obric.miniapp.alarm.AccountType;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/MentionType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, "DOCUMENT", AccountType.ALL, "DEFAULT", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MentionType extends Enum<MentionType> {
    public static final MentionType ALL = null;
    public static final MentionType DEFAULT = null;
    public static final MentionType DOCUMENT = null;
    public static final MentionType USER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MentionType[] f426807a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f426808b = null;
    private final String value;

    public static EnumEntries<MentionType> getEntries() {
        return f426808b;
    }

    static {
        MentionType r100 = new MentionType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 0, "user");
        USER = r100;
        MentionType r101 = new MentionType("DOCUMENT", 1, "document");
        DOCUMENT = r101;
        MentionType r102 = new MentionType(AccountType.ALL, 2, "all");
        ALL = r102;
        MentionType r103 = new MentionType("DEFAULT", 3, "default");
        DEFAULT = r103;
        MentionType[] r104 = {r100, r101, r102, r103};
        f426807a = r104;
        f426808b = EnumEntriesKt.enumEntries(r104);
    }

    public static MentionType[] values() {
        return (MentionType[]) f426807a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static MentionType valueOf(String r100) {
        return (MentionType) a.a(MentionType.class, r100);
    }

    public MentionType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
