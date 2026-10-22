package mg7;

import com.bytedance.sync.v2.protocal.Bucket;
import com.bytedance.sync.v2.protocal.TopicType;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f513757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f513758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f513759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TopicType f513760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bucket f513761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f513762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f513763g;

    public final String toString() {
        return "SyncCursor{did='" + this.f513758b + "', uid='" + this.f513759c + "', syncId='" + this.f513757a + "', topicType=" + this.f513760d + ", bucket=" + this.f513761e + ", receiveCursor=" + this.f513762f + ", reportCursor=" + this.f513763g + '}';
    }

    public c() {
    }

    public c(c r100) {
        this.f513758b = r100.f513758b;
        this.f513759c = r100.f513759c;
        this.f513757a = r100.f513757a;
        this.f513760d = r100.f513760d;
        this.f513761e = r100.f513761e;
        this.f513762f = r100.f513762f;
        this.f513763g = r100.f513763g;
    }
}
