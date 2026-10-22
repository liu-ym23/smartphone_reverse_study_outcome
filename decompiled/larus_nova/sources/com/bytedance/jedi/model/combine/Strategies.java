package com.bytedance.jedi.model.combine;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/jedi/model/combine/Strategies;", "", "<init>", "()V", "model_release"}, k = 1, mv = {1, 7, 1})
public final class Strategies {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Strategies f251059a = null;

    static {
        f251059a = new Strategies();
    }

    private Strategies() {
    }

    public static Function2 a() {
        return Strategies$fetcherOnly$1.INSTANCE;
    }
}
