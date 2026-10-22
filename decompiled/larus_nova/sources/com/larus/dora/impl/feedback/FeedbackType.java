package com.larus.dora.impl.feedback;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/larus/dora/impl/feedback/FeedbackType;", "", "serverType", "", "str", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getServerType", "()I", "getStr", "()Ljava/lang/String;", UserProfileEvent.POSITION_NONE, "GLASSES_APP_FAULT", "DOUBAO_CONVERSATION_PROBLEM", "PRODUCT_SUGGESTION", "QUICK_FEEDBACK", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeedbackType extends Enum<FeedbackType> {
    public static final a Companion = null;
    public static final FeedbackType DOUBAO_CONVERSATION_PROBLEM = null;
    public static final FeedbackType GLASSES_APP_FAULT = null;
    public static final FeedbackType NONE = null;
    public static final FeedbackType PRODUCT_SUGGESTION = null;
    public static final FeedbackType QUICK_FEEDBACK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeedbackType[] f335595a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f335596b = null;
    private final int serverType;
    private final String str;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<FeedbackType> getEntries() {
        return f335596b;
    }

    static {
        int r100 = com.larus.utils.j0.f375426a;
        FeedbackType r101 = new FeedbackType(UserProfileEvent.POSITION_NONE, 0, 0, com.larus.utils.j0.d(R.string.larus_dora_g_feedback_type_please_choose_cn));
        NONE = r101;
        FeedbackType r102 = new FeedbackType("GLASSES_APP_FAULT", 1, 1, com.larus.utils.j0.d(R.string.larus_dora_g_feedback_type_choose_glassess_cn));
        GLASSES_APP_FAULT = r102;
        FeedbackType r103 = new FeedbackType("DOUBAO_CONVERSATION_PROBLEM", 2, 2, com.larus.utils.j0.d(R.string.larus_dora_g_feedback_type_choose_doubao_cn));
        DOUBAO_CONVERSATION_PROBLEM = r103;
        FeedbackType r104 = new FeedbackType("PRODUCT_SUGGESTION", 3, 3, com.larus.utils.j0.d(R.string.larus_dora_g_feedback_type_choose_product_cn));
        PRODUCT_SUGGESTION = r104;
        FeedbackType r105 = new FeedbackType("QUICK_FEEDBACK", 4, 4, com.larus.utils.j0.d(R.string.larus_dora_g_quick_feedback_cn));
        QUICK_FEEDBACK = r105;
        FeedbackType[] r106 = {r101, r102, r103, r104, r105};
        f335595a = r106;
        f335596b = EnumEntriesKt.enumEntries(r106);
        Companion = new a();
    }

    public static FeedbackType[] values() {
        return (FeedbackType[]) f335595a.clone();
    }

    public final int getServerType() {
        return this.serverType;
    }

    public final String getStr() {
        return this.str;
    }

    public static FeedbackType valueOf(String r100) {
        return (FeedbackType) r27.a.a(FeedbackType.class, r100);
    }

    public FeedbackType(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.serverType = r102;
        this.str = r103;
    }
}
