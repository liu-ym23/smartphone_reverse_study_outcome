package com.ss.android.lark.inline.ai.api.knowledgeai;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/knowledgeai/CreateScene;", "", "<init>", "(Ljava/lang/String;I)V", "CREATE_KEYBOARD_FROM_QUOTE", "CLICK_ENTRY", "EXPLAIN_QUERY", "KEYBOARD_SEND", "KEYBOARD_RECOMMEND_QUESTION", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreateScene extends Enum<CreateScene> {
    public static final CreateScene CLICK_ENTRY = null;
    public static final CreateScene CREATE_KEYBOARD_FROM_QUOTE = null;
    public static final CreateScene EXPLAIN_QUERY = null;
    public static final CreateScene KEYBOARD_RECOMMEND_QUESTION = null;
    public static final CreateScene KEYBOARD_SEND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreateScene[] f426822a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f426823b = null;

    public static EnumEntries<CreateScene> getEntries() {
        return f426823b;
    }

    static {
        CreateScene r100 = new CreateScene("CREATE_KEYBOARD_FROM_QUOTE", 0);
        CREATE_KEYBOARD_FROM_QUOTE = r100;
        CreateScene r101 = new CreateScene("CLICK_ENTRY", 1);
        CLICK_ENTRY = r101;
        CreateScene r102 = new CreateScene("EXPLAIN_QUERY", 2);
        EXPLAIN_QUERY = r102;
        CreateScene r103 = new CreateScene("KEYBOARD_SEND", 3);
        KEYBOARD_SEND = r103;
        CreateScene r104 = new CreateScene("KEYBOARD_RECOMMEND_QUESTION", 4);
        KEYBOARD_RECOMMEND_QUESTION = r104;
        CreateScene[] r105 = {r100, r101, r102, r103, r104};
        f426822a = r105;
        f426823b = EnumEntriesKt.enumEntries(r105);
    }

    public static CreateScene[] values() {
        return (CreateScene[]) f426822a.clone();
    }

    public static CreateScene valueOf(String r100) {
        return (CreateScene) r27.a.a(CreateScene.class, r100);
    }

    public CreateScene(String r100, int r101) {
        super(r100, r101);
    }
}
