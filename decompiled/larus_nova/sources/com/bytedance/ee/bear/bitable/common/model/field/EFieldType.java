package com.bytedance.ee.bear.bitable.common.model.field;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b!\b\u0086\u0081\u0002\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001#B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "NOT_SUPPORT", CardAdapter.TEXT, "NUMBER", "SINGLE_SELECT", "MULTI_SELECT", "DATE_TIME", "CHECKBOX", FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, "PHONE", "URL", "ATTACHMENT", "SINGLE_LINK", "LOOKUP", "FORMULA", "DUPLEX_LINK", HTTP.LOCATION, "GROUP", "STAGE", "CREATED_TIME", "MODIFIED_TIME", "CREATED_USER", "MODIFIED_USER", "AUTO_NUMBER", "VIRTUAL", "FORM_GRID", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EFieldType extends Enum<EFieldType> {
    public static final EFieldType ATTACHMENT = null;
    public static final EFieldType AUTO_NUMBER = null;
    public static final EFieldType CHECKBOX = null;
    public static final EFieldType CREATED_TIME = null;
    public static final EFieldType CREATED_USER = null;
    public static final a Companion = null;
    public static final EFieldType DATE_TIME = null;
    public static final EFieldType DUPLEX_LINK = null;
    public static final EFieldType FORMULA = null;
    public static final EFieldType FORM_GRID = null;
    public static final EFieldType GROUP = null;
    public static final EFieldType LOCATION = null;
    public static final EFieldType LOOKUP = null;
    public static final EFieldType MODIFIED_TIME = null;
    public static final EFieldType MODIFIED_USER = null;
    public static final EFieldType MULTI_SELECT = null;
    public static final EFieldType NOT_SUPPORT = null;
    public static final EFieldType NUMBER = null;
    public static final EFieldType PHONE = null;
    public static final EFieldType SINGLE_LINK = null;
    public static final EFieldType SINGLE_SELECT = null;
    public static final EFieldType STAGE = null;
    public static final EFieldType TEXT = null;
    public static final EFieldType URL = null;
    public static final EFieldType USER = null;
    public static final EFieldType VIRTUAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EFieldType[] f209854a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f209855b = null;
    private int value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static EFieldType a(Integer r100) {
            EFieldType[] r101 = EFieldType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L14;
            EFieldType r104 = r101[r103];
            int r105 = r104.getValue();
            if (r100 != null) goto L8;
        L10:
            boolean r106 = false;
        L11:
            if (r106 == true) goto L15;
            r103 = r103 + 1;
        L15:
            if (r104 == null) goto L17;
            return r104;
        L17:
            return EFieldType.NOT_SUPPORT;
        L8:
            if (r105 != r100.intValue()) goto L10;
            r106 = true;
            goto L11
        L14:
            r104 = null;
            goto L15
        }
    }

    public static EnumEntries<EFieldType> getEntries() {
        return f209855b;
    }

    @JvmStatic
    public static final EFieldType lookup(Integer r100) {
        Companion.getClass();
        return a.a(r100);
    }

    static {
        EFieldType r100 = new EFieldType("NOT_SUPPORT", 0, 0);
        NOT_SUPPORT = r100;
        EFieldType r101 = new EFieldType(CardAdapter.TEXT, 1, 1);
        TEXT = r101;
        EFieldType r102 = new EFieldType("NUMBER", 2, 2);
        NUMBER = r102;
        EFieldType r103 = new EFieldType("SINGLE_SELECT", 3, 3);
        SINGLE_SELECT = r103;
        EFieldType r104 = new EFieldType("MULTI_SELECT", 4, 4);
        MULTI_SELECT = r104;
        EFieldType r105 = new EFieldType("DATE_TIME", 5, 5);
        DATE_TIME = r105;
        EFieldType r110 = new EFieldType("CHECKBOX", 6, 7);
        CHECKBOX = r110;
        EFieldType r111 = new EFieldType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 7, 11);
        USER = r111;
        EFieldType r112 = new EFieldType("PHONE", 8, 13);
        PHONE = r112;
        EFieldType r113 = new EFieldType("URL", 9, 15);
        URL = r113;
        EFieldType r114 = new EFieldType("ATTACHMENT", 10, 17);
        ATTACHMENT = r114;
        EFieldType r106 = new EFieldType("SINGLE_LINK", 11, 18);
        SINGLE_LINK = r106;
        EFieldType r107 = new EFieldType("LOOKUP", 12, 19);
        LOOKUP = r107;
        EFieldType r108 = new EFieldType("FORMULA", 13, 20);
        FORMULA = r108;
        EFieldType r109 = new EFieldType("DUPLEX_LINK", 14, 21);
        DUPLEX_LINK = r109;
        EFieldType r115 = new EFieldType(HTTP.LOCATION, 15, 22);
        LOCATION = r115;
        EFieldType r116 = new EFieldType("GROUP", 16, 23);
        GROUP = r116;
        EFieldType r117 = new EFieldType("STAGE", 17, 24);
        STAGE = r117;
        EFieldType r118 = new EFieldType("CREATED_TIME", 18, 1001);
        CREATED_TIME = r118;
        EFieldType r119 = new EFieldType("MODIFIED_TIME", 19, 1002);
        MODIFIED_TIME = r119;
        EFieldType r120 = new EFieldType("CREATED_USER", 20, 1003);
        CREATED_USER = r120;
        EFieldType r121 = new EFieldType("MODIFIED_USER", 21, 1004);
        MODIFIED_USER = r121;
        EFieldType r122 = new EFieldType("AUTO_NUMBER", 22, 1005);
        AUTO_NUMBER = r122;
        EFieldType r123 = new EFieldType("VIRTUAL", 23, 3001);
        VIRTUAL = r123;
        EFieldType r124 = new EFieldType("FORM_GRID", 24, 4001);
        FORM_GRID = r124;
        EFieldType[] r125 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124};
        f209854a = r125;
        f209855b = EnumEntriesKt.enumEntries(r125);
        Companion = new a();
    }

    public static EFieldType[] values() {
        return (EFieldType[]) f209854a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static EFieldType valueOf(String r100) {
        return (EFieldType) r27.a.a(EFieldType.class, r100);
    }

    public final void setValue(int r100) {
        this.value = r100;
    }

    public EFieldType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
