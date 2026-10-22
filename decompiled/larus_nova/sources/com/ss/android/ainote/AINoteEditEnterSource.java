package com.ss.android.ainote;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007j\u0002\b\u0004j\u0002\b\u0005¨\u0006\b"}, d2 = {"Lcom/ss/android/ainote/AINoteEditEnterSource;", "", "<init>", "(Ljava/lang/String;I)V", FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, "OPENING_PLACEHOLDER", "shouldDelayShowKeyboard", "", "ai-note_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AINoteEditEnterSource extends Enum<AINoteEditEnterSource> {
    public static final AINoteEditEnterSource OPENING_PLACEHOLDER = null;
    public static final AINoteEditEnterSource USER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AINoteEditEnterSource[] f406507a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f406508b = null;

    public static EnumEntries<AINoteEditEnterSource> getEntries() {
        return f406508b;
    }

    static {
        AINoteEditEnterSource r100 = new AINoteEditEnterSource(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 0);
        USER = r100;
        AINoteEditEnterSource r101 = new AINoteEditEnterSource("OPENING_PLACEHOLDER", 1);
        OPENING_PLACEHOLDER = r101;
        AINoteEditEnterSource[] r102 = {r100, r101};
        f406507a = r102;
        f406508b = EnumEntriesKt.enumEntries(r102);
    }

    public static AINoteEditEnterSource[] values() {
        return (AINoteEditEnterSource[]) f406507a.clone();
    }

    public final boolean shouldDelayShowKeyboard() {
        if (this != OPENING_PLACEHOLDER) goto L5;
        return true;
    L5:
        return false;
    }

    public static AINoteEditEnterSource valueOf(String r100) {
        return (AINoteEditEnterSource) r27.a.a(AINoteEditEnterSource.class, r100);
    }

    public AINoteEditEnterSource(String r100, int r101) {
        super(r100, r101);
    }
}
