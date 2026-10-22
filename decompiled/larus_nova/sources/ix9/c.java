package ix9;

import com.larus.suggest.impl.wcb.model.WcbSurface;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f496434a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f496435a = null;

        static {
            int[] r100 = new int[WcbSurface.values().length];
            r100[WcbSurface.MAIN_CONVERSATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[WcbSurface.NEW_CONVERSATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[WcbSurface.NOT_SUPPORT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f496435a = r100;
        }
    }

    static {
    }
}
