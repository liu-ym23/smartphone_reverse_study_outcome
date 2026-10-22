package h6b;

import com.ss.android.lark.export.entity.preview.Type;

/* JADX INFO: loaded from: classes35.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f483953a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f483954a = null;

        static {
            int[] r100 = new int[Type.values().length];
            r100[Type.HEADER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Type.TEXT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f483954a = r100;
        }
    }

    static {
    }
}
