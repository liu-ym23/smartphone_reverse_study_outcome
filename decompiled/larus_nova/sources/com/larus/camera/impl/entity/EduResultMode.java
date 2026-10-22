package com.larus.camera.impl.entity;

import com.larus.bmhome.chat.bean.SuggestActionType;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import nx8.c;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0012"}, d2 = {"Lcom/larus/camera/impl/entity/EduResultMode;", "", "textResId", "", "clipViewMode", "Lcom/larus/camera/impl/edulibs/cameraapi/EduClipViewMode;", "<init>", "(Ljava/lang/String;IILcom/larus/camera/impl/edulibs/cameraapi/EduClipViewMode;)V", "getTextResId", "()I", "getClipViewMode", "()Lcom/larus/camera/impl/edulibs/cameraapi/EduClipViewMode;", "SINGLE_QUESTION", "MULTI_QUESTION", "HOMEWORK_CORRECTION", SuggestActionType.PHOTO, "toEduIntentMode", "Lcom/larus/camera/impl/entity/EduIntentMode;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EduResultMode extends Enum<EduResultMode> {
    public static final EduResultMode HOMEWORK_CORRECTION = null;
    public static final EduResultMode MULTI_QUESTION = null;
    public static final EduResultMode PHOTO = null;
    public static final EduResultMode SINGLE_QUESTION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EduResultMode[] f321705a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f321706b = null;
    private final c clipViewMode;
    private final int textResId;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f321707a = null;

        static {
            int[] r100 = new int[EduResultMode.values().length];
            r100[EduResultMode.SINGLE_QUESTION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[EduResultMode.MULTI_QUESTION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[EduResultMode.HOMEWORK_CORRECTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[EduResultMode.PHOTO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f321707a = r100;
        }
    }

    public static EnumEntries<EduResultMode> getEntries() {
        return f321706b;
    }

    static {
        EduResultMode r100 = new EduResultMode("SINGLE_QUESTION", 0, R.string.larus_camera_shoot_as_single_question_cn, c.C6990c.f521068a);
        SINGLE_QUESTION = r100;
        EduResultMode r101 = new EduResultMode("MULTI_QUESTION", 1, R.string.larus_camera_shoot_as_multi_question_cn, c.b.f521067a);
        MULTI_QUESTION = r101;
        c.a r102 = c.a.f521066a;
        EduResultMode r103 = new EduResultMode("HOMEWORK_CORRECTION", 2, R.string.larus_aiCamera_tab_check, r102);
        HOMEWORK_CORRECTION = r103;
        EduResultMode r104 = new EduResultMode(SuggestActionType.PHOTO, 3, R.string.larus_camera_shoot_as_photo_cn, r102);
        PHOTO = r104;
        EduResultMode[] r105 = {r100, r101, r103, r104};
        f321705a = r105;
        f321706b = EnumEntriesKt.enumEntries(r105);
    }

    public static EduResultMode[] values() {
        return (EduResultMode[]) f321705a.clone();
    }

    public final EduIntentMode toEduIntentMode() {
        int r100 = a.f321707a[ordinal()];
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L19;
        if (r100 == 3) goto L18;
        if (r100 != 4) goto L12;
        return EduIntentMode.COMMON;
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return EduIntentMode.HOMEWORK_CORRECTION;
    L19:
        return EduIntentMode.MULTI_QUESTION;
    L16:
        return EduIntentMode.SINGLE_QUESTION;
    }

    public final c getClipViewMode() {
        return this.clipViewMode;
    }

    public final int getTextResId() {
        return this.textResId;
    }

    public static EduResultMode valueOf(String r100) {
        return (EduResultMode) r27.a.a(EduResultMode.class, r100);
    }

    public EduResultMode(String r100, int r101, int r102, c r103) {
        super(r100, r101);
        this.textResId = r102;
        this.clipViewMode = r103;
    }
}
