package px8;

import com.larus.camera.impl.entity.EduResultMode;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f530956a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f530957a = null;

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
            f530957a = r100;
        }
    }

    static {
    }
}
