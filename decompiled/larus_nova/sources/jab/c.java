package jab;

import com.bytedance.lark.pb.im.v1.CreateChatRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f497973a;

    public static final class a {
    }

    static {
    }

    public c(CreateChatRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        this.f497973a = r100.is_crypto;
    }
}
