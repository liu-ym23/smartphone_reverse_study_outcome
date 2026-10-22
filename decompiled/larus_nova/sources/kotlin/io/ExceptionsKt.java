package kotlin.io;

import java.io.File;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0002¨\u0006\u0006"}, d2 = {"constructMessage", "", "file", "Ljava/io/File;", "other", "reason", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ExceptionsKt {
    public static final /* synthetic */ String access$constructMessage(File r100, File r101, String r102) {
        return constructMessage(r100, r101, r102);
    }

    private static final String constructMessage(File r100, File r101, String r102) {
        StringBuilder r103 = new StringBuilder(r100.toString());
        if (r101 == null) goto L5;
        r103.append(" -> " + r101);
    L5:
        if (r102 == null) goto L8;
        r103.append(": ".concat(r102));
    L8:
        return r103.toString();
    }
}
