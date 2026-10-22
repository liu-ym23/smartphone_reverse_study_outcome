package com.larus.suggest.impl.popup;

import kotlin.collections.SetsKt;
import kotlin.text.Regex;
import kotlin.text.RegexOption;

/* JADX INFO: loaded from: classes31.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f369906a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Regex f369907b = null;

    public w() {
    }

    static {
        f369906a = new w();
        f369907b = new Regex("(?<!!)\\[[^\\]\\r\\n]+]\\((https?://[^\\s)]+)\\)", SetsKt.setOf(RegexOption.IGNORE_CASE));
    }
}
