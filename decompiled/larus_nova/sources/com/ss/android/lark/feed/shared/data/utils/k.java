package com.ss.android.lark.feed.shared.data.utils;

import com.bytedance.lark.pb.feed.v1.Digest;

/* JADX INFO: loaded from: classes35.dex */
public final /* synthetic */ class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f421174a = null;

    static {
        int[] r100 = new int[Digest.Element.Tag.values().length];
        r100[Digest.Element.Tag.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r100[Digest.Element.Tag.EMOJI.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r100[Digest.Element.Tag.TEXT_WITH_EMOJIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        f421174a = r100;
    }
}
