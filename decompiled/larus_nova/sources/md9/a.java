package md9;

import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.util.JsonFormat;
import com.larus.im.internal.delegate.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonFormat.Printer f513429a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JsonFormat.Parser f513430b = null;

    static {
        f513429a = JsonFormat.printer().omittingInsignificantWhitespace().preservingProtoFieldNames();
        f513430b = JsonFormat.parser();
    }

    public static final String b(MessageOrBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return f513429a.print(r100);
    L5:
        th = move-exception;
        if (c.f348197a.isDebug() == true) goto L10;
        com.larus.im.internal.delegate.a.f348188b.e("ProtocolBufferExt", th.getMessage(), th);
        return null;
    L10:
        throw th;
    }

    public static final void a(GeneratedMessageV3.Builder r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "json");
        f513430b.merge(r101, r100);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.larus.im.internal.delegate.a.f348188b.e("ProtocolBufferExt", th.getMessage(), th);
    }
}
