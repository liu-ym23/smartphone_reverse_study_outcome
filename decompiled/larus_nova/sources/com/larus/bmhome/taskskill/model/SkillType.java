package com.larus.bmhome.taskskill.model;

import com.larus.media.MediaScene;
import com.obric.miniapp.alarm.AccountType;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/taskskill/model/SkillType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, MediaScene.SYSTEM, "ENTERPRISE", AccountType.LOCAL, "STORE", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SkillType extends Enum<SkillType> {
    public static final a Companion = null;
    public static final SkillType ENTERPRISE = null;
    public static final SkillType LOCAL = null;
    public static final SkillType STORE = null;
    public static final SkillType SYSTEM = null;
    public static final SkillType USER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SkillType[] f314346a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f314347b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static SkillType a(int r100) {
            SkillType[] r101 = SkillType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L11;
            SkillType r104 = r101[r103];
            if (r104.getValue() != r100) goto L7;
            boolean r105 = true;
        L8:
            if (r105 == true) goto L12;
            r103 = r103 + 1;
        L12:
            if (r104 == null) goto L14;
            return r104;
        L14:
            return SkillType.SYSTEM;
        L7:
            r105 = false;
            goto L8
        L11:
            r104 = null;
            goto L12
        }
    }

    public static EnumEntries<SkillType> getEntries() {
        return f314347b;
    }

    static {
        SkillType r100 = new SkillType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 0, 1);
        USER = r100;
        SkillType r101 = new SkillType(MediaScene.SYSTEM, 1, 2);
        SYSTEM = r101;
        SkillType r102 = new SkillType("ENTERPRISE", 2, 3);
        ENTERPRISE = r102;
        SkillType r103 = new SkillType(AccountType.LOCAL, 3, 4);
        LOCAL = r103;
        SkillType r104 = new SkillType("STORE", 4, 5);
        STORE = r104;
        SkillType[] r110 = {r100, r101, r102, r103, r104};
        f314346a = r110;
        f314347b = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
    }

    public static SkillType[] values() {
        return (SkillType[]) f314346a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SkillType valueOf(String r100) {
        return (SkillType) r27.a.a(SkillType.class, r100);
    }

    public SkillType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
