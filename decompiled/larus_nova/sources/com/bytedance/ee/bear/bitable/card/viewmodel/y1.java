package com.bytedance.ee.bear.bitable.card.viewmodel;

import android.content.Context;
import android.text.TextPaint;
import com.bytedance.ee.bear.bitable.card.view.membrane.AsyncPrefetchAndRecyclePool;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldType;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AsyncPrefetchAndRecyclePool f209194a;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f209195a = null;

        static {
            int[] r100 = new int[EFieldType.values().length];
            r100[EFieldType.ATTACHMENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[EFieldType.DUPLEX_LINK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[EFieldType.SINGLE_LINK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[EFieldType.CREATED_USER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[EFieldType.MODIFIED_USER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[EFieldType.USER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[EFieldType.GROUP.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f209195a = r100;
        }
    }

    static {
    }

    public y1(Context r100, TextPaint r101, iq4.b r102, AsyncPrefetchAndRecyclePool r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "titlePaint");
        Intrinsics.checkNotNullParameter(r102, "spanGenerator");
        Intrinsics.checkNotNullParameter(r103, "prefetchAndRecycleViewPool");
        this.f209194a = r103;
        com.bytedance.ee.util.ui.n.m(r100, R.drawable.facade_common_avatar_place_holder);
        if (((com.bytedance.ee.bear.contract.i0) org.koin.java.a.c(com.bytedance.ee.bear.contract.i0.class, null, null, 6)).a() != null) goto L6;
        Locale.getDefault().getLanguage();
        return;
    }
}
