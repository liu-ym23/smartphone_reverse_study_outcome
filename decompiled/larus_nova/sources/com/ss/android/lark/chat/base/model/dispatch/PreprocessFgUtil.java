package com.ss.android.lark.chat.base.model.dispatch;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes35.dex */
public final class PreprocessFgUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f411717a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f411718a = null;

        static {
            int[] r100 = new int[ResourceType.values().length];
            r100[ResourceType.FILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ResourceType.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ResourceType.MEDIA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f411718a = r100;
        }
    }

    static {
        f411717a = LazyKt.lazy(PreprocessFgUtil$enableConvertToWebp$2.INSTANCE);
    }
}
