package com.larus.platform.model.action;

import com.larus.chat.gallery.api.bean.GalleryChatType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/larus/platform/model/action/SuggestedActionKey;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "AIBeautify", "InvokeCamera", "InvokeAlbum", "InvokeDirectory", "InvokeCall", "AIVideoGenerate", "HomeworkCorrection", "EduSolveQuestionSingle", "EduSolveQuestionMulti", "EduSolveQuestionAlbum", "EduCorrectionAlbum", "Loading", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SuggestedActionKey extends Enum<SuggestedActionKey> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SuggestedActionKey[] $VALUES = null;
    public static final SuggestedActionKey AIBeautify = null;
    public static final SuggestedActionKey AIVideoGenerate = null;
    public static final SuggestedActionKey EduCorrectionAlbum = null;
    public static final SuggestedActionKey EduSolveQuestionAlbum = null;
    public static final SuggestedActionKey EduSolveQuestionMulti = null;
    public static final SuggestedActionKey EduSolveQuestionSingle = null;
    public static final SuggestedActionKey HomeworkCorrection = null;
    public static final SuggestedActionKey InvokeAlbum = null;
    public static final SuggestedActionKey InvokeCall = null;
    public static final SuggestedActionKey InvokeCamera = null;
    public static final SuggestedActionKey InvokeDirectory = null;
    public static final SuggestedActionKey Loading = null;
    private final String value;

    private static final /* synthetic */ SuggestedActionKey[] $values() {
        return new SuggestedActionKey[]{AIBeautify, InvokeCamera, InvokeAlbum, InvokeDirectory, InvokeCall, AIVideoGenerate, HomeworkCorrection, EduSolveQuestionSingle, EduSolveQuestionMulti, EduSolveQuestionAlbum, EduCorrectionAlbum, Loading};
    }

    public static EnumEntries<SuggestedActionKey> getEntries() {
        return $ENTRIES;
    }

    static {
        AIBeautify = new SuggestedActionKey("AIBeautify", 0, "ai_beautify");
        InvokeCamera = new SuggestedActionKey("InvokeCamera", 1, "invoke_camera");
        InvokeAlbum = new SuggestedActionKey("InvokeAlbum", 2, "invoke_album");
        InvokeDirectory = new SuggestedActionKey("InvokeDirectory", 3, "invoke_directory");
        InvokeCall = new SuggestedActionKey("InvokeCall", 4, "invoke_call");
        AIVideoGenerate = new SuggestedActionKey("AIVideoGenerate", 5, "camera_video_gen");
        HomeworkCorrection = new SuggestedActionKey("HomeworkCorrection", 6, GalleryChatType.HOMEWORK_CORRECTION);
        EduSolveQuestionSingle = new SuggestedActionKey("EduSolveQuestionSingle", 7, "edu_solve_question_single");
        EduSolveQuestionMulti = new SuggestedActionKey("EduSolveQuestionMulti", 8, "edu_solve_question_multi");
        EduSolveQuestionAlbum = new SuggestedActionKey("EduSolveQuestionAlbum", 9, "edu_solve_question_album");
        EduCorrectionAlbum = new SuggestedActionKey("EduCorrectionAlbum", 10, "edu_correction_album");
        Loading = new SuggestedActionKey("Loading", 11, "loading");
        SuggestedActionKey[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static SuggestedActionKey[] values() {
        return (SuggestedActionKey[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static SuggestedActionKey valueOf(String r100) {
        return (SuggestedActionKey) r27.a.a(SuggestedActionKey.class, r100);
    }

    private SuggestedActionKey(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
