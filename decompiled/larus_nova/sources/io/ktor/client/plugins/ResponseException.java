package io.ktor.client.plugins;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0017\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\rR\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lio/ktor/client/plugins/ResponseException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "Lio/ktor/client/statement/b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lio/ktor/client/statement/b;", "getResponse", "()Lio/ktor/client/statement/b;", "response", "", "cachedResponseText", "<init>", "(Lio/ktor/client/statement/b;Ljava/lang/String;)V", "(Lio/ktor/client/statement/b;)V", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public class ResponseException extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient io.ktor.client.statement.b f491664a;

    public final io.ktor.client.statement.b getResponse() {
        return this.f491664a;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Please, provide response text in constructor")
    public ResponseException(io.ktor.client.statement.b r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        this(r100, "<no response text provided>");
    }

    public ResponseException(io.ktor.client.statement.b r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "response");
        Intrinsics.checkNotNullParameter(r101, "cachedResponseText");
        super("Bad response: " + r100 + ". Text: \"" + r101 + Typography.quote);
        this.f491664a = r100;
    }
}
