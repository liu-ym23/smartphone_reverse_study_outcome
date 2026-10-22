package mg7;

import com.bytedance.sync.model.DataType;
import com.bytedance.sync.v2.protocal.Bucket;
import com.bytedance.sync.v2.protocal.ConsumeType;
import com.bytedance.sync.v2.protocal.PacketStatus;
import com.bytedance.sync.v2.protocal.TopicType;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f513764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f513765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f513766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f513767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f513768e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f513769f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f513770g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ConsumeType f513771h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DataType f513772i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f513773j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f513774k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Bucket f513775l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f513776m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TopicType f513777n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PacketStatus f513778o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Map<String, String> f513779p;

    public d() {
    }

    public final String toString() {
        return "SyncHistoryLog{syncId='" + this.f513764a + "', did='" + this.f513765b + "', uid='" + this.f513766c + "', syncCursor=" + this.f513767d + ", data=" + Arrays.toString(this.f513768e) + ", md5='" + this.f513769f + "', business=" + this.f513770g + ", consumeType=" + this.f513771h + ", dataType=" + this.f513772i + ", publishTs=" + this.f513773j + ", receiveTs=" + this.f513774k + ", bucket=" + this.f513775l + ", reqId='" + this.f513776m + "', topicType=" + this.f513777n + ", packetStatus=" + this.f513778o + ", extra=" + this.f513779p + '}';
    }
}
