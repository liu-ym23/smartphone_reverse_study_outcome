package com.ss.android.lark.message.card.parser;

import com.bytedance.lark.pb.basic.v1.UniversalCardEntity;

/* JADX INFO: loaded from: classes36.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f431907a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f431908a = null;

        static {
            int[] r100 = new int[UniversalCardEntity.DataSource.values().length];
            r100[UniversalCardEntity.DataSource.IM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[UniversalCardEntity.DataSource.CARD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[UniversalCardEntity.DataSource.STREAMING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f431908a = r100;
        }
    }

    static {
    }
}
