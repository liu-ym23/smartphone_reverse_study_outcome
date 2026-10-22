package v4b;

import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageLink;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f553206k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f553207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f553208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f553209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f553210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<? extends MessageType> f553211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MessageInfo f553212f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MessageLink.ChatInfo f553213g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f553214h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f553215i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f553216j;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f553217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f553218b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<? extends MessageType> f553219c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f553220d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f553221e;

        public a() {
            this.f553217a = true;
            this.f553218b = -1;
            int r100 = d.f553206k;
            this.f553219c = b.a();
            this.f553220d = true;
        }
    }

    public static final class b {
        public static List a() {
            ArrayList r100 = new ArrayList();
            r100.add(MessageType.CARD);
            r100.add(MessageType.EMAIL);
            r100.add(MessageType.CALENDAR);
            r100.add(MessageType.GENERAL_CALENDAR);
            r100.add(MessageType.SHARE_CALENDAR_EVENT);
            r100.add(MessageType.TODO);
            r100.add(MessageType.SHARE_GROUP_CHAT);
            r100.add(MessageType.PROFILE);
            r100.add(MessageType.RED_PACKET);
            r100.add(MessageType.VIDEO_CHAT);
            r100.add(MessageType.VOTE);
            r100.add(MessageType.LOCATION);
            return r100;
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f553207a, ((d) r100).f553207a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f553207a.hashCode();
    }

    public final String toString() {
        return "MessageCellConfig(build=" + this.f553207a + ')';
    }

    public d(a r100) {
        Intrinsics.checkNotNullParameter(r100, "build");
        this.f553207a = r100;
        this.f553208b = true;
        this.f553209c = true;
        this.f553210d = -1;
        this.f553211e = b.a();
        this.f553213g = null;
        this.f553215i = false;
        this.f553216j = r100.f553221e;
        this.f553209c = r100.f553217a;
        this.f553211e = r100.f553219c;
        this.f553210d = r100.f553218b;
        this.f553208b = r100.f553220d;
        this.f553212f = null;
        this.f553214h = false;
    }
}
