package s35;

import com.bytedance.ee.bear.BlockSimpleInfo;
import com.bytedance.ee.bear.share.export.BitableShareRoleMember;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f540467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f540468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f540469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f540470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<Integer> f540471e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<Integer> f540472f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f540473g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList<BlockSimpleInfo> f540474h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList<BlockSimpleInfo> f540475i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f540476j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList<BitableShareRoleMember> f540477k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f540478l;

    public final String toString() {
        return "ShareItemModel{id='" + du5.b.g(null) + "', title='" + du5.b.g(this.f540467a) + "', url='" + du5.b.g(this.f540468b) + "', content='" + du5.b.g(this.f540469c) + "', topic='" + du5.b.g(this.f540470d) + "', disabledShareTypes=" + this.f540471e + ", badgeShareTypes=" + this.f540472f + ", menuCallback=" + this.f540478l + '}';
    }

    public b() {
        this.f540471e = new ArrayList();
        this.f540472f = new ArrayList();
        this.f540474h = new ArrayList();
        this.f540475i = new ArrayList();
    }
}
