package com.larus.camera.impl.entity;

import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import nx8.c;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/larus/camera/impl/entity/EduIntentMode;", "", "id", "", "textResId", "clipViewMode", "Lcom/larus/camera/impl/edulibs/cameraapi/EduClipViewMode;", "<init>", "(Ljava/lang/String;IIILcom/larus/camera/impl/edulibs/cameraapi/EduClipViewMode;)V", "getId", "()I", "getTextResId", "getClipViewMode", "()Lcom/larus/camera/impl/edulibs/cameraapi/EduClipViewMode;", "UNDETECTED", "COMMON", "SINGLE_QUESTION", "MULTI_QUESTION", "HOMEWORK_CORRECTION", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EduIntentMode extends Enum<EduIntentMode> {
    public static final EduIntentMode COMMON = null;
    public static final a Companion = null;
    public static final EduIntentMode HOMEWORK_CORRECTION = null;
    public static final EduIntentMode MULTI_QUESTION = null;
    public static final EduIntentMode SINGLE_QUESTION = null;
    public static final EduIntentMode UNDETECTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EduIntentMode[] f321701a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f321702b = null;
    private final c clipViewMode;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f321703id;
    private final int textResId;

    public static final class a {

        /* JADX INFO: renamed from: com.larus.camera.impl.entity.EduIntentMode$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C4148a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f321704a = null;

            static {
                int[] r100 = new int[EduIntentMode.values().length];
                r100[EduIntentMode.UNDETECTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r100[EduIntentMode.COMMON.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r100[EduIntentMode.SINGLE_QUESTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r100[EduIntentMode.MULTI_QUESTION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r100[EduIntentMode.HOMEWORK_CORRECTION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                f321704a = r100;
            }
        }

        public a() {
        }

        public static EduIntentMode a(int r100) {
            EduIntentMode r101 = EduIntentMode.SINGLE_QUESTION;
            if (r100 == r101.getId()) goto L16;
            EduIntentMode r102 = EduIntentMode.MULTI_QUESTION;
            if (r100 == r102.getId()) goto L17;
            EduIntentMode r103 = EduIntentMode.COMMON;
            if (r100 == r103.getId()) goto L18;
            EduIntentMode r104 = EduIntentMode.HOMEWORK_CORRECTION;
            if (r100 != r104.getId()) goto L15;
            return r104;
        L15:
            return EduIntentMode.UNDETECTED;
        L18:
            return r103;
        L17:
            return r102;
        L16:
            return r101;
        }

        public static int b(EduIntentMode r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            int r101 = C4148a.f321704a[r100.ordinal()];
            if (r101 != 1) goto L5;
            return 0;
        L5:
            if (r101 != 2) goto L7;
            return 1;
        L7:
            if (r101 != 3) goto L9;
        L15:
            return 2;
        L9:
            if (r101 == 4) goto L15;
            if (r101 == 5) goto L15;
            throw new NoWhenBranchMatchedException();
        }
    }

    public static EnumEntries<EduIntentMode> getEntries() {
        return f321702b;
    }

    static {
        c.a r110 = c.a.f521066a;
        EduIntentMode r100 = new EduIntentMode("UNDETECTED", 0, 0, 0, r110);
        UNDETECTED = r100;
        EduIntentMode r101 = new EduIntentMode("COMMON", 1, 1, R.string.larus_camera_shoot_as_photo_cn, r110);
        COMMON = r101;
        EduIntentMode r102 = new EduIntentMode("SINGLE_QUESTION", 2, 2, R.string.larus_camera_shoot_as_single_question_cn, c.C6990c.f521068a);
        SINGLE_QUESTION = r102;
        EduIntentMode r103 = new EduIntentMode("MULTI_QUESTION", 3, 3, R.string.larus_camera_shoot_as_multi_question_cn, c.b.f521067a);
        MULTI_QUESTION = r103;
        EduIntentMode r104 = new EduIntentMode("HOMEWORK_CORRECTION", 4, 4, R.string.larus_aiCamera_tab_check, r110);
        HOMEWORK_CORRECTION = r104;
        EduIntentMode[] r105 = {r100, r101, r102, r103, r104};
        f321701a = r105;
        f321702b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static EduIntentMode[] values() {
        return (EduIntentMode[]) f321701a.clone();
    }

    public final c getClipViewMode() {
        return this.clipViewMode;
    }

    public final int getId() {
        return this.f321703id;
    }

    public final int getTextResId() {
        return this.textResId;
    }

    public static EduIntentMode valueOf(String r100) {
        return (EduIntentMode) r27.a.a(EduIntentMode.class, r100);
    }

    public EduIntentMode(String r100, int r101, int r102, int r103, c r104) {
        super(r100, r101);
        this.f321703id = r102;
        this.textResId = r103;
        this.clipViewMode = r104;
    }
}
