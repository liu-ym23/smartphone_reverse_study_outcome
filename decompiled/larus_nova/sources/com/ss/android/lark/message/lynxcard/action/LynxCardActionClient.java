package com.ss.android.lark.message.lynxcard.action;

import com.larksuite.component.card.protocol.CardActionDataSource;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes36.dex */
public final class LynxCardActionClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<LynxCardActionClient> f432118a = null;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f432119a = null;

        static {
            int[] r100 = new int[CardActionDataSource.values().length];
            r100[CardActionDataSource.IM_CONTENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[CardActionDataSource.CARD_ENTITY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[CardActionDataSource.STREAMING_CARD_ENTITY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f432119a = r100;
        }
    }

    public LynxCardActionClient() {
    }

    static {
        f432118a = LazyKt.lazy(LazyThreadSafetyMode.NONE, LynxCardActionClient$Companion$instance$2.INSTANCE);
    }
}
