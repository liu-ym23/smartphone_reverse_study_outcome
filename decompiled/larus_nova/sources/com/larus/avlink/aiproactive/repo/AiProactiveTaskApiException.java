package com.larus.avlink.aiproactive.repo;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/larus/avlink/aiproactive/repo/AiProactiveTaskApiException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "code", "", "message", "", "<init>", "(Ljava/lang/Long;Ljava/lang/String;)V", "getCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiProactiveTaskApiException extends RuntimeException {
    public static final int $stable = 8;
    private final Long code;

    public final Long getCode() {
        return this.code;
    }

    public AiProactiveTaskApiException(Long r100, String r101) {
        super(r101);
        this.code = r100;
    }
}
