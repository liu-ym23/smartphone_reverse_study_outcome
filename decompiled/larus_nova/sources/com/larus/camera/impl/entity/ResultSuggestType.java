package com.larus.camera.impl.entity;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.larus.bmhome.chat.bean.SuggestActionType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/camera/impl/entity/ResultSuggestType;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, SuggestActionType.PHOTO, "HOMEWORK_CORRECTION", "EDU_SINGLE_QUESTION", "EDU_MULTI_QUESTION", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResultSuggestType extends Enum<ResultSuggestType> {
    public static final ResultSuggestType EDU_MULTI_QUESTION = null;
    public static final ResultSuggestType EDU_SINGLE_QUESTION = null;
    public static final ResultSuggestType HOMEWORK_CORRECTION = null;
    public static final ResultSuggestType NONE = null;
    public static final ResultSuggestType PHOTO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResultSuggestType[] f321710a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f321711b = null;

    public static EnumEntries<ResultSuggestType> getEntries() {
        return f321711b;
    }

    static {
        ResultSuggestType r100 = new ResultSuggestType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        ResultSuggestType r101 = new ResultSuggestType(SuggestActionType.PHOTO, 1);
        PHOTO = r101;
        ResultSuggestType r102 = new ResultSuggestType("HOMEWORK_CORRECTION", 2);
        HOMEWORK_CORRECTION = r102;
        ResultSuggestType r103 = new ResultSuggestType("EDU_SINGLE_QUESTION", 3);
        EDU_SINGLE_QUESTION = r103;
        ResultSuggestType r104 = new ResultSuggestType("EDU_MULTI_QUESTION", 4);
        EDU_MULTI_QUESTION = r104;
        ResultSuggestType[] r105 = {r100, r101, r102, r103, r104};
        f321710a = r105;
        f321711b = EnumEntriesKt.enumEntries(r105);
    }

    public static ResultSuggestType[] values() {
        return (ResultSuggestType[]) f321710a.clone();
    }

    public static ResultSuggestType valueOf(String r100) {
        return (ResultSuggestType) a.a(ResultSuggestType.class, r100);
    }

    public ResultSuggestType(String r100, int r101) {
        super(r100, r101);
    }
}
