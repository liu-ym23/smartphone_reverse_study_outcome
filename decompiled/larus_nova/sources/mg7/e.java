package mg7;

import com.bytedance.sync.model.DataType;
import com.bytedance.sync.v2.protocal.Bucket;
import com.bytedance.sync.v2.protocal.ConsumeType;
import com.bytedance.sync.v2.protocal.PacketStatus;
import com.bytedance.sync.v2.protocal.TopicType;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f513780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f513781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f513782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f513783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f513784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f513785f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f513786g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ConsumeType f513787h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DataType f513788i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f513789j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f513790k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Bucket f513791l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f513792m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TopicType f513793n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PacketStatus f513794o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Map<String, String> f513795p;

    public e() {
    }

    public final String toString() {
        return "SyncLog{syncId='" + this.f513780a + "', did='" + this.f513781b + "', uid='" + this.f513782c + "', syncCursor=" + this.f513783d + ", data=" + Arrays.toString(this.f513784e) + ", md5='" + this.f513785f + "', business=" + this.f513786g + ", consumeType=" + this.f513787h + ", dataType=" + this.f513788i + ", publishTs=" + this.f513789j + ", receiveTs=" + this.f513790k + ", bucket=" + this.f513791l + ", reqId='" + this.f513792m + "', topicType=" + this.f513793n + ", packetStatus=" + this.f513794o + ", extra=" + this.f513795p + '}';
    }
}
