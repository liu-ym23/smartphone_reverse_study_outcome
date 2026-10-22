package com.ss.android.lark.vote;

import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Singleton
public final class VoteModule {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<VoteModule> f445146b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Inject
    public pbc.a f445147a;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/vote/VoteModule$VoteModuleEntryPoint;", "", "getVoteModule", "Lcom/ss/android/lark/vote/VoteModule;", "vote_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface b {
        VoteModule h();
    }

    @Inject
    public VoteModule() {
    }

    static {
        f445146b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, VoteModule$Companion$instance$2.INSTANCE);
    }
}
