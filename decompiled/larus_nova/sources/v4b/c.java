package v4b;

import com.ss.android.lark.chat.entity.message.MessageLink;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f553189k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f553190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f553191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f553192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<MessageType> f553193d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f553194e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f553195f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MessageLink.ChatInfo f553196g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f553197h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f553198i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f553199j;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f553200a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f553201b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<MessageType> f553202c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f553203d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f553204e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f553205f;

        public a() {
            this.f553200a = 32;
            this.f553201b = 12.0f;
            int r100 = c.f553189k;
            ArrayList r101 = new ArrayList();
            r101.add(MessageType.FILE);
            r101.add(MessageType.FOLDER);
            r101.add(MessageType.MERGE_FORWARD);
            this.f553202c = r101;
            this.f553203d = true;
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        new b();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f553190a, ((c) r100).f553190a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f553190a.hashCode();
    }

    public final String toString() {
        return "MessageBubbleConfig(build=" + this.f553190a + ')';
    }

    public c(a r100) {
        Intrinsics.checkNotNullParameter(r100, "build");
        this.f553190a = r100;
        this.f553191b = 16.0f;
        this.f553192c = 32;
        UIHelper.dp2px(150.0f);
        ArrayList r101 = new ArrayList();
        r101.add(MessageType.FILE);
        r101.add(MessageType.FOLDER);
        r101.add(MessageType.MERGE_FORWARD);
        this.f553193d = r101;
        this.f553194e = true;
        this.f553195f = true;
        this.f553196g = null;
        this.f553197h = r100.f553204e;
        this.f553198i = false;
        this.f553199j = r100.f553205f;
        this.f553192c = r100.f553200a;
        this.f553191b = r100.f553201b;
        this.f553193d = r100.f553202c;
        this.f553194e = r100.f553203d;
    }
}
