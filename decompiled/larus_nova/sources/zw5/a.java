package zw5;

import buc.e;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f573839d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f573840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f573841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e<String> f573842c;

    /* JADX INFO: renamed from: zw5.a$a, reason: collision with other inner class name */
    public static final class C8499a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f573840a, r101.f573840a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f573841b, r101.f573841b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f573840a.hashCode() * 31) + this.f573841b.hashCode();
    }

    public final String toString() {
        return "FlowAsrLogContext(taskId=" + this.f573840a + ", conversationId=" + this.f573841b + ')';
    }

    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        String r101 = this.f573842c.c();
        if (r101 == null) goto L5;
        String r102 = " asr_log_id=".concat(r101);
    L6:
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        return r100 + " taskId=" + this.f573840a + " conversationId=" + this.f573841b + r102;
    L5:
        r102 = null;
        goto L6
    }

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        this.f573840a = r100;
        this.f573841b = r101;
        this.f573842c = buc.b.d(null);
    }
}
